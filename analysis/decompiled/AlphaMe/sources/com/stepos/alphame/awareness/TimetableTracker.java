package com.stepos.alphame.awareness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.RuleUpdater;
import com.stepos.alphame.Tags;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.data.DataSourceManager;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.database.EngineRoomDatabase;
import com.stepos.alphame.location.FrequentLocation;
import com.stepos.alphame.location.FrequentLocationManager;
import com.stepos.alphame.location.LocationEngine;
import com.stepos.alphame.persona.PersonaDataItem;
import com.stepos.alphame.persona.PersonaDataSource;
import com.stepos.alphame.persona.PersonaStorable;
import com.stepos.alphame.power.PowerEngine;
import com.stepos.alphame.predict.PredictManager;
import com.stepos.alphame.request.RequestManager;
import com.stepos.alphame.scene.QuickAppHelper;
import com.stepos.alphame.scene.SceneDetectorEngine;
import com.stepos.alphame.userbehavior.UserBehaviorDataSource;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.StringUtil;
import com.stepos.alphame.wifi.WifiEngine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class TimetableTracker {
    public static final long DAY = 86400000;
    private static final boolean DEBUG = false;
    private static final long HOUR = 3600000;
    private static final long MINUTE = 60000;
    public static final String PREF_NAME = "timetable";
    private static final long SECEND = 1000;
    private static final long SHORTEST_ON_DUTY_DURATION = 14400000;
    private static final long SHORTEST_SLEEP_DURATION = 14400000;
    private static final int SLEEP_END_DEFAULT = 4;
    private static final int SLEEP_START_DEFAULT = 19;
    private static final String TAG = "TimetableTracker";
    private static final int WAKE_UP_MAX = 15;
    private static final int WAKE_UP_MIN = 3;
    private AwarenessStorable mAwarenessStorable;
    private int mBlueConnected;
    private final Context mContext;
    private int mCurrMovingState;
    private int mHeadSetPlugedIn;
    private boolean mLoading;
    private final FrequentLocationManager mLocationManager;
    private ArrayList<LongTermEvent> mLongTermWifis;
    private PersonaDataItem mPersonaItem;
    private PersonaDataSource mPersonaSource;
    private final PersonaStorable mPersonaStorable;
    private int mPower;
    PowerEngine.PowerChangerListener mPowerListener;
    private boolean mScreenJustUnlocked;
    private boolean mScreenLocked;
    private long mScreenOffTime;
    private long mSleepTime;

    public static final class InstanceHolder {
        private static final TimetableTracker INSTANCE = new TimetableTracker(0);

        private InstanceHolder() {
        }
    }

    public /* synthetic */ TimetableTracker(int i4) {
        this();
    }

    private static void addDateInfo(PersonaDataItem personaDataItem, long j4, boolean z4) throws JSONException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.SIMPLIFIED_CHINESE);
        Date date = new Date(j4);
        personaDataItem.ymd = simpleDateFormat.format(date);
        personaDataItem.date = j4;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i4 = calendar.get(7);
        int i5 = i4 == 1 ? 7 : i4 - 1;
        personaDataItem.weekday = String.valueOf(i5);
        personaDataItem.day_off = (i5 == 6 || i5 == 7) ? 1 : 0;
        String[] dateInfo = RuleUpdater.getInstance().getDateInfo(personaDataItem.ymd);
        if (dateInfo != null) {
            personaDataItem.day_off = Integer.parseInt(dateInfo[0]);
            personaDataItem.holiday = dateInfo[1];
            if (z4) {
                AwarenessDataSource.getInstance().newDailyRecord(personaDataItem.day_off, "0", personaDataItem.holiday);
            }
        }
    }

    private void checkWakeup(long j4, boolean z4) throws JSONException {
        AlphaMeLogger.debugLog(TAG, "Checking Wakeup ");
        if (!isPossibleWakeupTime(j4)) {
            if (this.mSleepTime > 0) {
                this.mSleepTime = j4;
                return;
            }
            return;
        }
        AlphaMeLogger.dLog("checkWakeup " + format(j4));
        FrequentLocationManager frequentLocationManager = FrequentLocationManager.getInstance(this.mContext);
        FrequentLocation home = frequentLocationManager.getHome();
        FrequentLocation company = frequentLocationManager.getCompany();
        boolean z5 = home == null || !home.isValid();
        AlphaMeLogger.dLog("wakeup home location " + home + " company location " + company + "new update " + z5);
        if (z5) {
            AlphaMeLogger.dLog("start location when wake up");
            LocationEngine.getInstance(this.mContext).startLocation(6);
        }
        this.mPersonaItem.sleep_time = this.mSleepTime;
        updateHomeAndCompanyWifi();
        updateHomeAndCompanyLocation(this.mPersonaItem.day_off != 0, j4);
        this.mPersonaItem.home = this.mLocationManager.getHome() == null ? null : this.mLocationManager.getHome().getAddress();
        this.mPersonaItem.company = this.mLocationManager.getCompany() == null ? null : this.mLocationManager.getCompany().getAddress();
        update(j4, z4);
        RequestManager.getInstance(this.mContext).clearRetry();
        long j5 = j4 - this.mSleepTime;
        PersonaDataItem personaDataItem = new PersonaDataItem();
        this.mPersonaItem = personaDataItem;
        personaDataItem.rise_time = j4;
        personaDataItem.leave_home_time = j4;
        personaDataItem.sleep_cost = j5;
        personaDataItem.home = this.mLocationManager.getHome() == null ? null : this.mLocationManager.getHome().getAddress();
        this.mPersonaItem.company = this.mLocationManager.getCompany() != null ? this.mLocationManager.getCompany().getAddress() : null;
        addDateInfo(this.mPersonaItem, j4, z4);
        if (this.mPersonaSource == null) {
            this.mPersonaSource = (PersonaDataSource) DataSourceManager.getInstance().getDataSource(Tags.PERSONA);
        }
        this.mPersonaSource.process(this.mPersonaItem);
        this.mPersonaSource.store(!z4);
        this.mSleepTime = 0L;
    }

    private String format(long j4) {
        return StringUtil.formatDateFull(j4);
    }

    public static TimetableTracker getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private void handleScreenOff(long j4, boolean z4) {
        if (z4) {
            RuleUpdater.getInstance().tryUpdate(j4);
            RuleUpdater.getInstance().tryUpdateEx(j4);
        }
        if (this.mPersonaItem == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        int i4 = calendar.get(11);
        if (i4 > 19 || i4 < 4) {
            this.mSleepTime = j4;
        }
    }

    private void handleUserActive(long j4, boolean z4) throws JSONException {
        if (this.mLoading && z4) {
            return;
        }
        checkWakeup(j4, z4);
    }

    private boolean isPossibleWakeupTime(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j4));
        int i4 = calendar.get(11);
        long j5 = this.mSleepTime;
        long j6 = j4 - j5;
        return j5 > 0 && j6 > 14400000 && j6 < 86400000 && i4 > 3 && i4 < 15;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void loadLastPersona() throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.String r0 = "loadLastPersona begin"
            com.stepos.alphame.utils.AlphaMeLogger.dLog(r0)
            com.stepos.alphame.persona.PersonaStorable r0 = r8.mPersonaStorable
            com.stepos.alphame.persona.PersonaDataItem r0 = r0.getLastPersona()
            r8.mPersonaItem = r0
            if (r0 == 0) goto L12
            long r0 = r0.rise_time
            goto L1b
        L12:
            com.stepos.alphame.persona.PersonaDataItem r0 = new com.stepos.alphame.persona.PersonaDataItem
            r0.<init>()
            r8.mPersonaItem = r0
            r0 = 0
        L1b:
            com.stepos.alphame.awareness.AwarenessStorable r2 = r8.mAwarenessStorable
            if (r2 != 0) goto L2b
            com.stepos.alphame.awareness.AwarenessDataSource r2 = com.stepos.alphame.awareness.AwarenessDataSource.getInstance()
            com.stepos.alphame.data.Storable r2 = r2.getStorable()
            com.stepos.alphame.awareness.AwarenessStorable r2 = (com.stepos.alphame.awareness.AwarenessStorable) r2
            r8.mAwarenessStorable = r2
        L2b:
            r2 = 0
            r3 = 0
            java.lang.String r4 = "date > ?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Exception -> L8d
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Exception -> L8d
            r5[r3] = r0     // Catch: java.lang.Exception -> L8d
            android.database.Cursor r0 = com.stepos.alphame.awareness.AwarenessStorable.getCursor(r4, r5, r2, r2)     // Catch: java.lang.Exception -> L8d
            if (r0 == 0) goto L86
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L79
            if (r1 <= 0) goto L86
            int r1 = r0.getCount()     // Catch: java.lang.Throwable -> L79
            r0.moveToFirst()     // Catch: java.lang.Throwable -> L77
        L4b:
            com.stepos.alphame.awareness.AwarenessDataItem r4 = new com.stepos.alphame.awareness.AwarenessDataItem     // Catch: java.lang.Throwable -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L77
            com.stepos.alphame.awareness.AwarenessStorable.fillItemByCursor(r0, r4)     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = "TimetableTracker"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L77
            r6.<init>()     // Catch: java.lang.Throwable -> L77
            java.lang.String r7 = "Item: "
            r6.append(r7)     // Catch: java.lang.Throwable -> L77
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L77
            r6.append(r7)     // Catch: java.lang.Throwable -> L77
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L77
            com.stepos.alphame.utils.AlphaMeLogger.debugLog(r5, r6)     // Catch: java.lang.Throwable -> L77
            r8.track(r4, r3)     // Catch: java.lang.Throwable -> L77
            boolean r4 = r0.moveToNext()     // Catch: java.lang.Throwable -> L77
            if (r4 != 0) goto L4b
            goto L87
        L77:
            r4 = move-exception
            goto L7b
        L79:
            r4 = move-exception
            r1 = r3
        L7b:
            r0.close()     // Catch: java.lang.Throwable -> L7f
            goto L83
        L7f:
            r0 = move-exception
            r4.addSuppressed(r0)     // Catch: java.lang.Exception -> L84
        L83:
            throw r4     // Catch: java.lang.Exception -> L84
        L84:
            r0 = move-exception
            goto L8f
        L86:
            r1 = r3
        L87:
            if (r0 == 0) goto L94
            r0.close()     // Catch: java.lang.Exception -> L84
            goto L94
        L8d:
            r0 = move-exception
            r1 = r3
        L8f:
            java.lang.String r4 = "Persona"
            android.util.Log.e(r4, r2, r0)
        L94:
            r8.mLoading = r3
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "loadLastPersona end. count="
            r8.<init>(r0)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.stepos.alphame.utils.AlphaMeLogger.dLog(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.awareness.TimetableTracker.loadLastPersona():void");
    }

    private void trackAppEvent(String str, long j4, boolean z4) throws JSONException {
        String str2;
        if (TextUtils.isEmpty(str) || QuickAppHelper.isQuickApp(str)) {
            return;
        }
        if (this.mLoading && z4) {
            return;
        }
        if (SceneDetectorEngine.isScreenOff(str)) {
            handleScreenOff(j4, z4);
            this.mScreenOffTime = j4;
        } else if (SceneDetectorEngine.isScreenLocked(str)) {
            this.mScreenLocked = true;
            this.mScreenOffTime = 0L;
        } else {
            if (this.mScreenLocked) {
                this.mScreenLocked = false;
                this.mScreenJustUnlocked = true;
            } else if (this.mScreenJustUnlocked) {
                this.mScreenJustUnlocked = false;
                handleUserActive(j4, z4);
            }
            this.mScreenOffTime = 0L;
        }
        if (z4) {
            FrequentLocation currentLocation = FrequentLocationManager.getInstance(this.mContext).getCurrentLocation();
            if (currentLocation != null) {
                str2 = currentLocation.getLongitude() + "_" + currentLocation.getLatitude();
            } else {
                str2 = "";
            }
            String str3 = str2;
            PredictManager.getInstance(this.mContext).newRecordAndTest(8, WifiEngine.getInstance(this.mContext).isWifiOn() ? 1 : 0, str3, this.mCurrMovingState, str, j4);
        }
    }

    private void trackBluetoothEvent(int i4, String str, String str2, long j4, boolean z4) {
        this.mBlueConnected = i4;
        if (this.mPersonaItem == null) {
            return;
        }
        VehicleBluetoothManager.getInstance(this.mContext).trackBluetoothEvent(i4, str, str2, j4, z4);
    }

    private void trackChargingEvent(int i4, String str, String str2, long j4, boolean z4) {
        this.mPower = Integer.valueOf(str).intValue();
    }

    private void trackDailyEvent(int i4, String str, String str2, long j4, boolean z4) {
        this.mPersonaItem.weather = str;
        if (str2 == null || !str2.contains(",")) {
            return;
        }
        String[] strArrSplit = str2.split(",");
        this.mPersonaItem.day_off = Integer.valueOf(strArrSplit[0]).intValue();
        this.mPersonaItem.holiday = strArrSplit[1];
    }

    private void trackHeadsetEvent(int i4, String str, String str2, long j4, boolean z4) {
        this.mHeadSetPlugedIn = i4;
    }

    private void trackLocationUpdateEvent(int i4, String str, String str2, long j4, boolean z4) {
        FrequentLocation frequentLocationNewLocation;
        if (this.mLoading && z4) {
            return;
        }
        if (!FrequentLocationManager.getInstance(this.mContext).isAvailableLocation(str, str2)) {
            VehicleBluetoothManager.getInstance(this.mContext).locationFailed(z4, j4);
            return;
        }
        try {
            VehicleBluetoothManager.getInstance(this.mContext).onLocationChanged(i4, str, str2, j4, z4);
            if (StringUtil.hasSplitter(str)) {
                frequentLocationNewLocation = this.mLocationManager.get(str, str2);
                if (frequentLocationNewLocation == null) {
                    frequentLocationNewLocation = this.mLocationManager.newLocation(str, str2, j4);
                    EngineRoomDatabase.INSTANCE.getDatabase(this.mContext).getFrequentLocationDao().insertFrequentLocation(frequentLocationNewLocation);
                }
            } else {
                frequentLocationNewLocation = null;
            }
            this.mLocationManager.setFrequentWifi(frequentLocationNewLocation, this.mLongTermWifis);
            EngineRoomDatabase.INSTANCE.getDatabase(this.mContext).getFrequentLocationDao().updateFrequentLocation(frequentLocationNewLocation);
            if (frequentLocationNewLocation == this.mLocationManager.getCurrentLocation()) {
                return;
            }
            this.mLocationManager.leave(j4);
            this.mLocationManager.arrive(frequentLocationNewLocation, j4);
            this.mLocationManager.fillPersona(this.mPersonaItem, this.mLongTermWifis, j4);
            update(j4, z4);
        } catch (Exception unused) {
        }
    }

    private void trackMovingEvent(int i4, long j4, boolean z4) throws JSONException {
        if (this.mPersonaItem == null) {
            return;
        }
        this.mCurrMovingState = i4;
        if (z4) {
            LocationEngine.getInstance(this.mContext).startLocation(7);
        }
        if (i4 == 4 || i4 == 2 || i4 == 3) {
            checkWakeup(j4, z4);
        }
    }

    private void trackSystemEvent(int i4, String str, String str2, long j4, boolean z4) {
        if (i4 == 3) {
            VehicleBluetoothManager.getInstance(this.mContext).onStepCountChange(Integer.parseInt(str));
        } else if (i4 == 2) {
            trackDailyEvent(i4, str, str2, j4, z4);
        }
    }

    private void trackWifiEvent(Integer num, String str, String str2, long j4, boolean z4) {
        AlphaMeLogger.debugLog(TAG, "trackWifiEvent state = " + num + ", ssid = " + str + ", bssid = " + str2 + AwarenessDataItem.PERMISSION_SPLITTER + format(j4));
        if (this.mPersonaItem == null) {
            return;
        }
        if (z4) {
            if (num.intValue() == 2) {
                LocationEngine.getInstance(this.mContext).startLocation(3);
                return;
            } else if (num.intValue() == 1) {
                LocationEngine.getInstance(this.mContext).startLocation(4);
            }
        }
        if (num.intValue() == 2) {
            return;
        }
        if (this.mLongTermWifis.size() > 0) {
            ArrayList<LongTermEvent> arrayList = this.mLongTermWifis;
            if (arrayList.get(arrayList.size() - 1).end == 0) {
                ArrayList<LongTermEvent> arrayList2 = this.mLongTermWifis;
                LongTermEvent longTermEvent = arrayList2.get(arrayList2.size() - 1);
                longTermEvent.end = j4;
                longTermEvent.term = j4 - longTermEvent.start;
            }
        }
        if (num.intValue() == 1) {
            LongTermEvent longTermEvent2 = new LongTermEvent(1, j4, 0L, str, str2);
            AlphaMeLogger.debugLog(TAG, " add new wifi " + longTermEvent2.toString());
            this.mLongTermWifis.add(longTermEvent2);
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    private void update(long j4, boolean z4) {
        PersonaDataItem personaDataItem = this.mPersonaItem;
        if (personaDataItem != null) {
            if (!z4) {
                this.mPersonaStorable.updateItem(personaDataItem);
                return;
            }
            PersonaDataItem personaDataItem2 = new PersonaDataItem();
            personaDataItem2.fill(this.mPersonaItem);
            new AsyncTask<PersonaDataItem, Void, Void>() { // from class: com.stepos.alphame.awareness.TimetableTracker.1
                @Override // android.os.AsyncTask
                public Void doInBackground(PersonaDataItem... personaDataItemArr) {
                    TimetableTracker.this.mPersonaStorable.updateItem(personaDataItemArr[0]);
                    return null;
                }
            }.execute(personaDataItem2);
        }
    }

    private void updateHomeAndCompanyLocation(boolean z4, long j4) {
        AlphaMeLogger.debugLog(TAG, "updateHomeAndCompanyLocation ");
        this.mLocationManager.update(z4, j4);
        this.mLocationManager.reset();
    }

    private void updateHomeAndCompanyWifi() {
        LongTermEvent longTermEvent;
        AlphaMeLogger.debugLog(TAG, "updateHomeAndCompanyWifi ");
        if (this.mLongTermWifis.size() > 0) {
            longTermEvent = this.mLongTermWifis.get(r0.size() - 1);
        } else {
            longTermEvent = null;
        }
        this.mLongTermWifis.clear();
        if (longTermEvent != null) {
            this.mLongTermWifis.add(longTermEvent);
        }
    }

    public void forceTrain() {
        PredictManager.getInstance(this.mContext).trainAll(true);
    }

    public int getBlueConnected() {
        return this.mBlueConnected;
    }

    public int getDayOff() {
        PersonaDataItem personaDataItem = this.mPersonaItem;
        if (personaDataItem != null) {
            return personaDataItem.day_off;
        }
        return -1;
    }

    public int getHeadSetPlugedIn() {
        return this.mHeadSetPlugedIn;
    }

    public int getPowerState() {
        return this.mPower;
    }

    public long getScreenOffTime() {
        return this.mScreenOffTime;
    }

    public List<LongTermEvent> getWifiEvents() {
        return this.mLongTermWifis;
    }

    public synchronized void init() {
        this.mPersonaStorable.deleteAll();
        this.mPersonaItem = null;
        FrequentLocationManager.getInstance(this.mContext).clear();
        VehicleBluetoothManager.getInstance(this.mContext).clear();
        PredictManager.getInstance(this.mContext).initRecentPredict();
        loadLastPersona();
        long jCurrentTimeMillis = System.currentTimeMillis();
        UserBehaviorDataSource.getInstance().init(jCurrentTimeMillis);
        DailyUsageMessageHelperKt.sendDailyUsageInitMessage(jCurrentTimeMillis);
        AwarenessDataSource.getInstance().newBootRecord();
    }

    public void track(AwarenessDataItem awarenessDataItem, boolean z4) {
        switch (awarenessDataItem.getScene()) {
            case 0:
                trackMovingEvent(awarenessDataItem.getState(), awarenessDataItem.getDate(), z4);
                break;
            case 1:
                trackWifiEvent(Integer.valueOf(awarenessDataItem.getState()), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
            case 2:
                trackLocationUpdateEvent(awarenessDataItem.getState(), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
            case 3:
                trackAppEvent(awarenessDataItem.getPkgNameWithUserId(), awarenessDataItem.getDate(), z4);
                if (z4) {
                    UserBehaviorDataSource.getInstance().onAppResumeEvent(awarenessDataItem.getData1(), awarenessDataItem.getDate(), true, true, false);
                }
                VehicleBluetoothManager.getInstance(this.mContext).trackAppEvent(awarenessDataItem.getData1(), awarenessDataItem.getDate());
                break;
            case 4:
                trackBluetoothEvent(awarenessDataItem.getState(), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
            case 5:
                trackSystemEvent(awarenessDataItem.getState(), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
            case 6:
                trackChargingEvent(awarenessDataItem.getState(), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
            case 7:
                trackHeadsetEvent(awarenessDataItem.getState(), awarenessDataItem.getData1(), awarenessDataItem.getData2(), awarenessDataItem.getDate(), z4);
                break;
        }
    }

    private TimetableTracker() {
        this.mPersonaItem = null;
        this.mSleepTime = -1L;
        this.mLongTermWifis = new ArrayList<>();
        this.mScreenLocked = false;
        this.mScreenJustUnlocked = false;
        this.mScreenOffTime = 0L;
        this.mPower = 0;
        this.mBlueConnected = 0;
        this.mHeadSetPlugedIn = 0;
        this.mCurrMovingState = 0;
        this.mLoading = false;
        this.mPowerListener = new PowerEngine.PowerChangerListener() { // from class: com.stepos.alphame.awareness.TimetableTracker.2
            @Override // com.stepos.alphame.power.PowerEngine.PowerChangerListener
            public void onChanged(int i4, int i5) {
                PredictManager.getInstance(TimetableTracker.this.mContext).trainIfNeed(TimetableTracker.this.mPersonaItem, TimetableTracker.this.mScreenOffTime, System.currentTimeMillis());
            }
        };
        this.mPersonaStorable = new PersonaStorable();
        ApplicationImpl application = ApplicationImpl.getApplication();
        this.mContext = application;
        this.mLoading = true;
        this.mLocationManager = FrequentLocationManager.getInstance(application);
        PowerEngine.getInstance(application).registerPowerChangeListener(this.mPowerListener);
    }
}
