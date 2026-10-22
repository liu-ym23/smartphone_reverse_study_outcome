package com.stepos.alphame.suggest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.location.FrequentLocationManager;
import com.stepos.alphame.location.LocationEngine;
import com.stepos.alphame.power.PowerEngine;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.NetworkHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AppSuggestReport {
    private static final String AUTHORITY = "com.stepos.alphame.suggest.provider";
    private static final String COLUMN_APP_INSTALLED_LIST = "app_installed_list";
    private static final String COLUMN_CLS_NAME = "cls_name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_DRIVING = "driving";
    private static final String COLUMN_EARPHONE = "earphone";
    private static final String COLUMN_ENERGY = "energy";
    private static final String COLUMN_EXTEND_1 = "extend_1";
    private static final String COLUMN_EXTEND_2 = "extend_2";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_PKG_NAME = "pkg_name";
    private static final String COLUMN_POSITION = "position";
    private static final String COLUMN_POSITION_TYPE = "position_type";
    private static final String COLUMN_REPORTED = "reported";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_TIMESTAMP = "timestamp";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_WIFI = "wifi";
    private static final String TABLE_NAME = "app_suggest_event";
    public static final String TAG = "AppSuggestReport";
    private static final Uri URI_APP_SUGGEST_EVENT;
    public static ArrayList mShortFunList;

    public static class SingletonManager {
        private static final AppSuggestReport instance = new AppSuggestReport(0);
    }

    static {
        ArrayList arrayList = new ArrayList();
        mShortFunList = arrayList;
        arrayList.add("com.tencent.mm.plugin.scanner.ui.BaseScanUI");
        mShortFunList.add("com.tencent.mm.framework.app.UIPageFragmentActivity");
        mShortFunList.add("com.alipay.mobile.scan.as.main.MainCaptureActivity");
        mShortFunList.add("com.alipay.mobile.onsitepay9.payer.OspTabHostActivity");
        mShortFunList.add("com.alipay.mobile.onsitepay.merge.OnsitepayActivity");
        mShortFunList.add("com.eg.android.AlipayGphone.AlipayLogin");
        mShortFunList.add("com.alipay.mobile.nebulax.integration.mpaas.activity.NebulaActivity$Main");
        URI_APP_SUGGEST_EVENT = Uri.parse("content://com.stepos.alphame.suggest.provider/app_suggest_event");
    }

    private AppSuggestReport() {
    }

    public /* synthetic */ AppSuggestReport(int i4) {
        this();
    }

    private boolean checkIsWired(Context context) {
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) context.getSystemService("audio")).getDevices(2)) {
            int type = audioDeviceInfo.getType();
            if (type == 3 || type == 4 || type == 8 || type == 7) {
                return true;
            }
        }
        return false;
    }

    public static AppSuggestReport getInstance() {
        return SingletonManager.instance;
    }

    private String getLastLocation(Context context) {
        String str;
        String[] lastLocation = LocationEngine.getInstance(context).getLastLocation();
        String strReplace = (lastLocation == null || lastLocation.length < 5 || (str = lastLocation[4]) == null || !str.contains(",")) ? "" : str.replace(",", "_");
        if (System.currentTimeMillis() - Property.getLong(Property.KEY_LAST_START_LOCATION_TIME, 0L) > VehicleBluetoothManager.FAIL_START_TIMEOUT || getInstance().testMode()) {
            AlphaMeLogger.iLog("AppSuggestReport exceed 30 min, startLocation");
            LocationEngine.getInstance(context).startLocation(12);
            Property.setLong(Property.KEY_LAST_START_LOCATION_TIME, System.currentTimeMillis());
        }
        return strReplace;
    }

    private String getLastLocationLatitude(String str) {
        return (str == null || !str.contains("_")) ? "" : str.split("_")[1];
    }

    private String getLastLocationLongitude(String str) {
        return (str == null || !str.contains("_")) ? "" : str.split("_")[0];
    }

    private int getLastLocationType(Context context) {
        String[] lastLocation = LocationEngine.getInstance(context).getLastLocation();
        if (lastLocation == null || lastLocation.length < 5) {
            return -1;
        }
        return FrequentLocationManager.getInstance(context).getLocType(lastLocation[4]);
    }

    private String getLauncherApps(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (listQueryIntentActivities != null && listQueryIntentActivities.size() > 0) {
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null) {
                        sb.append(activityInfo.packageName);
                        sb.append(",");
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return sb.toString();
    }

    public static void testCursor() {
        Cursor cursorQuery = null;
        try {
            try {
                ArrayList arrayList = new ArrayList();
                ContentResolver contentResolver = ApplicationImpl.getApplication().getContentResolver();
                cursorQuery = contentResolver.query(URI_APP_SUGGEST_EVENT, null, "reported=0", null, null);
                if (cursorQuery != null && cursorQuery.getCount() > 0) {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("id");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("pkg_name");
                    int columnIndexOrThrow3 = cursorQuery.getColumnIndexOrThrow("cls_name");
                    cursorQuery.moveToFirst();
                    do {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        String string2 = cursorQuery.getString(columnIndexOrThrow2);
                        String string3 = cursorQuery.getString(columnIndexOrThrow3);
                        arrayList.add(Integer.valueOf(string));
                        Log.w(TAG, "item " + string + ", " + string2 + "/" + string3);
                    } while (cursorQuery.moveToNext());
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("reported", (Integer) 1);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Log.w(TAG, "item " + num + ", updated: " + contentResolver.update(URI_APP_SUGGEST_EVENT, contentValues, "id=?", new String[]{num.toString()}));
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                if (0 == 0) {
                    return;
                }
            }
            cursorQuery.close();
        } catch (Throwable th) {
            if (0 != 0) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public void pickItem(AppSuggestDataItem appSuggestDataItem, String str, String str2) {
        ApplicationImpl application = ApplicationImpl.getApplication();
        boolean zContains = mShortFunList.contains(str2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String dateYMD = StringUtil.formatDateYMD(jCurrentTimeMillis);
        String dateHMS = StringUtil.formatDateHMS(jCurrentTimeMillis);
        String launcherApps = getLauncherApps(application);
        int i4 = Settings.Secure.getInt(application.getContentResolver(), "stepos_drive_mode", 0);
        int lastLocationType = getLastLocationType(application);
        String lastLocation = getLastLocation(application);
        String lastLocationLatitude = getLastLocationLatitude(lastLocation);
        String lastLocationLongitude = getLastLocationLongitude(lastLocation);
        boolean zIsWifiNetwork = NetworkHelper.isWifiNetwork(application);
        int realtimePowerLevel = PowerEngine.getInstance(application).getRealtimePowerLevel();
        PowerEngine.getInstance(application).isCharging();
        appSuggestDataItem.create(str, str2, zContains ? 1 : 0, dateYMD, dateHMS, jCurrentTimeMillis, launcherApps, i4, lastLocationType, lastLocation, lastLocationLatitude, lastLocationLongitude, zIsWifiNetwork ? 1 : 0, realtimePowerLevel, checkIsWired(application) ? 1 : 0, 0, "", "");
    }

    public boolean testMode() {
        try {
            return Settings.System.getInt(ApplicationImpl.getApplication().getContentResolver(), "app_suggest_data_debug", 0) == 1;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
