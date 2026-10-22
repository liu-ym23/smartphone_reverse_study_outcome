package com.stepos.alphame.location;

import B0.g;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.awareness.LongTermEvent;
import com.stepos.alphame.persona.PersonaDataItem;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class FrequentLocationManager {
    public static final float AVAILABLE_MIN_ACC = 100.0f;
    private static final long COMPANY_STAY_MIN_DURATION = 14400000;
    private static final long DAY = 86400000;
    private static final double EARTH_RADIUS = 6378137.0d;
    private static final long FIRST_DAY_STAY_MIN_DURATION = 600000;
    public static final float FREQUENCY_HOME_DEFAULT = 7.0f;
    private static final int FREQUENT_LOCATION_LIMIT = 20;
    private static final long HOUR = 3600000;
    private static final int LOCATION_ACCURACY = 100;
    public static final int LOC_TYPE_COMPANY = 1;
    public static final int LOC_TYPE_FREQUENT = 2;
    public static final int LOC_TYPE_HOME = 0;
    public static final int LOC_TYPE_UNKNOWN = -1;
    private static final long MINUTE = 60000;
    private static final long SECEND = 1000;
    private static final String TAG = "FrequentLocation";

    @SuppressLint({"StaticFieldLeak"})
    private static FrequentLocationManager sInstance;
    private Context mContext;
    private FrequentLocation mCurrentLocation;
    private FrequentLocation mFavoriteCompany;
    private FrequentLocation mLastArriveLocation;

    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, FrequentLocation> mFrequentLocations = new HashMap<>();
    private List<Integer> mArrivedIDs = new ArrayList();
    private List<TimePoint> mRoute = new ArrayList();
    private int mLocationID = 0;
    private List<FrequentLocation> mHomeLocations = new ArrayList();
    private FrequentLocation mFavoriteHome = null;

    public class LocationCircle {
        private static final long MIN_STAY_DURATION = 1800000;
        private static final int NEARBY_ACCURACY = 500;
        FrequentLocation midPoint;
        ArrayList<FrequentLocation> nearbyLocations = new ArrayList<>();

        public LocationCircle(FrequentLocation frequentLocation) {
            this.midPoint = frequentLocation;
        }

        public void addIfNeayby(FrequentLocation frequentLocation) {
            if (frequentLocation.getStayDuration() <= 1800000 || FrequentLocationManager.distanceOfTwoPoints(frequentLocation, this.midPoint) >= 500.0d) {
                return;
            }
            this.nearbyLocations.add(frequentLocation);
        }

        public long getTodayDayTimeTotalDuration() {
            long dayTimeStayDuration = this.midPoint.getDayTimeStayDuration();
            Iterator<FrequentLocation> it = this.nearbyLocations.iterator();
            while (it.hasNext()) {
                dayTimeStayDuration += it.next().getDayTimeStayDuration();
            }
            return dayTimeStayDuration;
        }

        public long getTodayTotalDuration() {
            long stayDuration = this.midPoint.getStayDuration();
            Iterator<FrequentLocation> it = this.nearbyLocations.iterator();
            while (it.hasNext()) {
                stayDuration += it.next().getStayDuration();
            }
            return stayDuration;
        }

        public void matchCompany() {
            this.midPoint.matchCompany();
            Iterator<FrequentLocation> it = this.nearbyLocations.iterator();
            while (it.hasNext()) {
                it.next().matchCompany();
            }
        }

        public void matchHome() {
            this.midPoint.matchHome();
            Iterator<FrequentLocation> it = this.nearbyLocations.iterator();
            while (it.hasNext()) {
                it.next().matchHomeNearBy();
            }
        }

        public String toString() {
            String string = "midPoint : " + this.midPoint.getAddress();
            Iterator<FrequentLocation> it = this.nearbyLocations.iterator();
            while (it.hasNext()) {
                FrequentLocation next = it.next();
                StringBuilder sbV = g.v(string, "\nnearby ");
                sbV.append(next.getAddress());
                string = sbV.toString();
            }
            StringBuilder sbV2 = g.v(string, "\n");
            sbV2.append(StringUtil.formatTimeMill(getTodayTotalDuration()));
            sbV2.append(", ");
            sbV2.append(StringUtil.formatDateFull(this.midPoint.getLastArrivalTime()));
            return sbV2.toString();
        }
    }

    public class TimePoint {
        long end;
        FrequentLocation location;
        long start;

        public TimePoint(FrequentLocation frequentLocation) {
            this.location = frequentLocation;
        }

        public String toString() {
            return "start at " + StringUtil.formatDateFull(this.start) + ", end at " + StringUtil.formatDateFull(this.end) + ", location = " + this.location;
        }
    }

    public FrequentLocationManager(Context context) {
        this.mContext = context;
    }

    private int checkLocType(String str, int i4) {
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (!StringUtil.hasSplitter(str)) {
            return i4;
        }
        String[] strArrSplit = str.split(",");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        FrequentLocationManager frequentLocationManager = getInstance(this.mContext);
        FrequentLocation home = frequentLocationManager.getHome();
        if (home != null && distanceOfTwoPoints(str2, str3, home.getLongitude(), home.getLatitude()) < UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME) {
            i4 = 0;
        }
        FrequentLocation company = frequentLocationManager.getCompany();
        if (company != null) {
            if (distanceOfTwoPoints(str2, str3, company.getLongitude(), company.getLatitude()) < UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME) {
                return 1;
            }
        }
        return i4;
    }

    public static double distanceOfTwoPoints(String str, String str2, String str3, String str4) {
        return distanceOfTwoPoints(Double.valueOf(str2).doubleValue(), Double.valueOf(str).doubleValue(), Double.valueOf(str4).doubleValue(), Double.valueOf(str3).doubleValue());
    }

    public static FrequentLocationManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new FrequentLocationManager(context);
        }
        return sInstance;
    }

    private Location getLocationByCoord(String str, String str2) {
        Location location = new Location("");
        location.setLongitude(Double.valueOf(str).doubleValue());
        location.setLatitude(Double.valueOf(str2).doubleValue());
        return location;
    }

    private boolean isSameLocation(String str, String str2, String str3, String str4) {
        return distanceOfTwoPoints(str, str2, str3, str4) < 100.0d;
    }

    private boolean isWifiConnected(@NonNull List<LongTermEvent> list) {
        return !list.isEmpty() && ((LongTermEvent) g.h(list, 1)).end == 0;
    }

    private static double rad(double d4) {
        return (d4 * 3.141592653589793d) / 180.0d;
    }

    private void removeExpiredFl() {
        ArrayList arrayList = new ArrayList();
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if ((frequentLocation.getFrequency() == Property.DEFAULT_FLOAT_VALUE && frequentLocation.getStayDuration() < 600000) || (frequentLocation.getFrequency() > Property.DEFAULT_FLOAT_VALUE && frequentLocation.getFrequency() < 0.2d)) {
                arrayList.add(frequentLocation);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mFrequentLocations.remove(Integer.valueOf(((FrequentLocation) it.next()).getId()));
        }
    }

    private void setAddress(FrequentLocation frequentLocation, String str) {
        if (StringUtil.hasSplitter(str)) {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length >= 2) {
                frequentLocation.setAddress(strArrSplit[1]);
                if (strArrSplit.length == 5) {
                    frequentLocation.setCountry(strArrSplit[2]);
                    frequentLocation.setProvince(strArrSplit[3]);
                    frequentLocation.setCity(strArrSplit[4]);
                } else if (strArrSplit.length > 5) {
                    frequentLocation.setCountry(strArrSplit[2]);
                    frequentLocation.setProvince(strArrSplit[3]);
                    frequentLocation.setCity(strArrSplit[4]);
                    frequentLocation.setDistrict(strArrSplit[5]);
                }
            }
        }
    }

    private void updateCompany(boolean z4, long j4) {
        if (!z4) {
            LocationCircle locationCircle = null;
            long j5 = 0;
            for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
                if (!frequentLocation.isHome() && frequentLocation.getDayTimeStayDuration() != 0) {
                    LocationCircle locationCircle2 = new LocationCircle(frequentLocation);
                    for (FrequentLocation frequentLocation2 : this.mFrequentLocations.values()) {
                        if (!frequentLocation2.isHome() && frequentLocation2 != frequentLocation) {
                            locationCircle2.addIfNeayby(frequentLocation2);
                        }
                    }
                    long todayDayTimeTotalDuration = locationCircle2.getTodayDayTimeTotalDuration();
                    if (j5 == 0 || todayDayTimeTotalDuration > j5) {
                        locationCircle = locationCircle2;
                        j5 = todayDayTimeTotalDuration;
                    }
                }
            }
            if (locationCircle != null && locationCircle.getTodayDayTimeTotalDuration() > COMPANY_STAY_MIN_DURATION) {
                locationCircle.matchCompany();
            }
            for (FrequentLocation frequentLocation3 : this.mFrequentLocations.values()) {
                if (frequentLocation3.isCompany()) {
                    if (this.mFavoriteCompany == null) {
                        this.mFavoriteCompany = frequentLocation3;
                    } else if (frequentLocation3.getCompany() > this.mFavoriteCompany.getCompany()) {
                        this.mFavoriteCompany = frequentLocation3;
                    } else if (frequentLocation3.getCompany() == this.mFavoriteCompany.getCompany() && frequentLocation3.getLastArrivalTime() > this.mFavoriteCompany.getLastArrivalTime()) {
                        this.mFavoriteCompany = frequentLocation3;
                    }
                }
            }
        }
        for (FrequentLocation frequentLocation4 : this.mFrequentLocations.values()) {
            frequentLocation4.update(this.mArrivedIDs.contains(Integer.valueOf(frequentLocation4.getId())), z4);
        }
    }

    private void updateHome(FrequentLocation frequentLocation) {
        if (frequentLocation == null) {
            return;
        }
        if (!this.mHomeLocations.contains(frequentLocation)) {
            this.mHomeLocations.add(frequentLocation);
        }
        LocationCircle locationCircle = new LocationCircle(frequentLocation);
        for (FrequentLocation frequentLocation2 : this.mFrequentLocations.values()) {
            if (frequentLocation2.isHome() && frequentLocation2 != frequentLocation) {
                locationCircle.addIfNeayby(frequentLocation2);
            }
        }
        locationCircle.matchHome();
        AlphaMeLogger.debugLog("updateHome " + locationCircle);
        for (FrequentLocation frequentLocation3 : this.mHomeLocations) {
            if (frequentLocation3.isHome()) {
                if (this.mFavoriteHome == null) {
                    this.mFavoriteHome = frequentLocation3;
                } else if (frequentLocation3.getHome() > this.mFavoriteHome.getHome()) {
                    this.mFavoriteHome = frequentLocation3;
                } else if (frequentLocation3.getHome() == this.mFavoriteHome.getHome() && frequentLocation3.getLastArrivalTime() > this.mFavoriteHome.getLastArrivalTime()) {
                    this.mFavoriteHome = frequentLocation3;
                }
            }
        }
        this.mHomeLocations.add(frequentLocation);
    }

    public void add(FrequentLocation frequentLocation) {
        this.mFrequentLocations.put(Integer.valueOf(frequentLocation.getId()), frequentLocation);
    }

    public void arrive(FrequentLocation frequentLocation, long j4) {
        if (frequentLocation == null || isSameLocation(this.mCurrentLocation, frequentLocation)) {
            return;
        }
        frequentLocation.setTotal(frequentLocation.getTotal() + 1);
        frequentLocation.arrive(j4);
        this.mCurrentLocation = frequentLocation;
        this.mLastArriveLocation = frequentLocation;
        if (!this.mArrivedIDs.contains(Integer.valueOf(frequentLocation.getId()))) {
            this.mArrivedIDs.add(Integer.valueOf(frequentLocation.getId()));
        }
        TimePoint timePoint = new TimePoint(this.mCurrentLocation);
        timePoint.start = j4;
        this.mRoute.add(timePoint);
    }

    public void clear() {
        this.mFrequentLocations.clear();
        this.mHomeLocations.clear();
        this.mRoute.clear();
        this.mLastArriveLocation = null;
    }

    public void fillPersona(PersonaDataItem personaDataItem, ArrayList<LongTermEvent> arrayList, long j4) {
        TimePoint timePoint = null;
        TimePoint timePoint2 = null;
        TimePoint timePoint3 = null;
        TimePoint timePoint4 = null;
        TimePoint timePoint5 = null;
        TimePoint timePoint6 = null;
        for (TimePoint timePoint7 : this.mRoute) {
            FrequentLocation frequentLocation = timePoint7.location;
            if (frequentLocation != null) {
                if (frequentLocation.isHome()) {
                    if (timePoint == null) {
                        timePoint = timePoint7;
                    }
                    if (timePoint3 != null && !timePoint3.location.isHome()) {
                        timePoint4 = timePoint7;
                    }
                } else {
                    if (timePoint3 != null && timePoint3.location.isHome() && timePoint2 == null) {
                        timePoint2 = timePoint7;
                    }
                    if (timePoint7.location.isCompany()) {
                        if (timePoint5 == null) {
                            timePoint5 = timePoint7;
                            timePoint6 = timePoint5;
                        } else {
                            timePoint6 = timePoint7;
                        }
                    }
                }
                timePoint3 = timePoint7;
            }
        }
        if (timePoint != null) {
            personaDataItem.home = timePoint.location.getAddress();
        }
        if (timePoint2 != null) {
            Iterator<LongTermEvent> it = arrayList.iterator();
            while (it.hasNext()) {
                LongTermEvent next = it.next();
                long j5 = timePoint2.start;
                long j6 = next.end;
                if (j5 - j6 <= 0) {
                    break;
                } else if (j5 - j6 < 3600000) {
                    personaDataItem.leave_home_time = j6;
                }
            }
            if (personaDataItem.leave_home_time == 0) {
                personaDataItem.leave_home_time = timePoint2.start;
            }
        }
        if (timePoint5 != null) {
            personaDataItem.on_duty_time = timePoint5.start;
            personaDataItem.company = timePoint5.location.getAddress();
            long j7 = personaDataItem.on_duty_time;
            if (j7 > 0) {
                long j8 = personaDataItem.leave_home_time;
                if (j8 > 0) {
                    personaDataItem.on_duty_cost = j7 - j8;
                }
            }
        }
        if (timePoint6 != null) {
            long j9 = timePoint6.end;
            if (j9 > 0) {
                personaDataItem.off_duty_time = j9;
                if (timePoint4 != null) {
                    long j10 = timePoint4.start;
                    if (j10 > j9) {
                        personaDataItem.arrive_home_time = j10;
                        if (j10 <= 0 || j9 <= 0) {
                            return;
                        }
                        personaDataItem.off_duty_cost = j10 - j9;
                    }
                }
            }
        }
    }

    public FrequentLocation get(String str, String str2) {
        FrequentLocation frequentLocation = null;
        if (!StringUtil.hasSplitter(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        double d4 = 0.0d;
        for (FrequentLocation frequentLocation2 : this.mFrequentLocations.values()) {
            double dDistanceOfTwoPoints = distanceOfTwoPoints(str3, str4, frequentLocation2.getLongitude(), frequentLocation2.getLatitude());
            if (dDistanceOfTwoPoints < 100.0d && (d4 == 0.0d || dDistanceOfTwoPoints < d4)) {
                frequentLocation = frequentLocation2;
                d4 = dDistanceOfTwoPoints;
            }
        }
        if (frequentLocation != null && !TextUtils.isEmpty(str2)) {
            setAddress(frequentLocation, str2);
        }
        return frequentLocation;
    }

    public List<String> getAll(float f4) {
        ArrayList arrayList = new ArrayList();
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if (frequentLocation.getFrequency() > f4) {
                arrayList.add(frequentLocation.toString());
            }
        }
        return arrayList;
    }

    public List<String> getAllFrequent(float f4) {
        FrequentLocation company;
        FrequentLocation home;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if (frequentLocation.getFrequency() > f4) {
                arrayList.add(frequentLocation);
            }
        }
        if (this.mFavoriteHome == null && (home = getHome()) != null) {
            arrayList.add(home);
        }
        if (this.mFavoriteCompany == null && (company = getCompany()) != null) {
            arrayList.add(company);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            FrequentLocation frequentLocation2 = (FrequentLocation) it.next();
            arrayList2.add(frequentLocation2.getLongitude() + "," + frequentLocation2.getLatitude() + "," + getLocationType(frequentLocation2));
        }
        return arrayList2;
    }

    public FrequentLocation getCompany() {
        return this.mFavoriteCompany;
    }

    public FrequentLocation getCurrentLocation() {
        return this.mCurrentLocation;
    }

    public FrequentLocation getHome() {
        return this.mFavoriteHome;
    }

    public List<String> getHomeAndCompany(float f4) {
        ArrayList arrayList = new ArrayList();
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if (frequentLocation.getHome() > f4) {
                arrayList.add("0," + frequentLocation.getAddress() + "," + frequentLocation.getLongitude() + "," + frequentLocation.getLatitude());
            }
            if (frequentLocation.getCompany() > f4) {
                arrayList.add("1," + frequentLocation.getAddress() + "," + frequentLocation.getLongitude() + "," + frequentLocation.getLatitude());
            }
        }
        return arrayList;
    }

    public FrequentLocation getHomeOrCompany(String str) {
        if (!StringUtil.hasSplitter(str)) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        String str2 = strArrSplit[0];
        String str3 = strArrSplit[1];
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if (distanceOfTwoPoints(str2, str3, frequentLocation.getLongitude(), frequentLocation.getLatitude()) < 100.0d && (frequentLocation.isHome() || frequentLocation.isCompany())) {
                return frequentLocation;
            }
        }
        return null;
    }

    public FrequentLocation getLastAvailableLocation() {
        List<TimePoint> list = this.mRoute;
        if (list == null || list.size() == 0) {
            return null;
        }
        return ((TimePoint) g.h(this.mRoute, 1)).location;
    }

    public int getLocType(String str) {
        int locationType = getLocationType(getHomeOrCompany(str));
        return (locationType == -1 || locationType == 2) ? checkLocType(str, locationType) : locationType;
    }

    public int getLocationType(String str) {
        return getLocationType(get(str, null));
    }

    public List<String> gethomeOrCompany() {
        ArrayList arrayList = new ArrayList();
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            if (frequentLocation.getCompany() > Property.DEFAULT_FLOAT_VALUE || frequentLocation.getHome() > Property.DEFAULT_FLOAT_VALUE) {
                arrayList.add(frequentLocation.toString());
            }
        }
        return arrayList;
    }

    public boolean isAvailableLocation(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (StringUtil.hasSplitter(str2)) {
            try {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit != null && strArrSplit.length > 2 && Float.valueOf(strArrSplit[0]).floatValue() <= 100.0f) {
                    if (TextUtils.isEmpty(strArrSplit[1])) {
                    }
                }
                return false;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public boolean isCompany(String str) {
        return isCompany(get(str, null));
    }

    public boolean isHome(String str) {
        return isHome(get(str, null));
    }

    public void leave(long j4) {
        FrequentLocation frequentLocation = this.mCurrentLocation;
        if (frequentLocation != null) {
            frequentLocation.leave(j4);
            this.mCurrentLocation = null;
            if (this.mRoute.size() > 0) {
                ((TimePoint) g.h(this.mRoute, 1)).end = j4;
            }
        }
    }

    public FrequentLocation newLocation(String str, String str2, long j4) {
        AlphaMeLogger.debugLog(TAG, "newLocation: " + str2);
        String[] strArrSplit = str.split(",");
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        FrequentLocation frequentLocation = new FrequentLocation();
        frequentLocation.setLongitude(str3);
        frequentLocation.setLatitude(str4);
        frequentLocation.arrive(j4);
        frequentLocation.setTotal(1);
        int i4 = this.mLocationID;
        this.mLocationID = i4 + 1;
        frequentLocation.setId(i4);
        setAddress(frequentLocation, str2);
        this.mFrequentLocations.put(Integer.valueOf(frequentLocation.getId()), frequentLocation);
        return frequentLocation;
    }

    public void reset() {
        for (FrequentLocation frequentLocation : this.mFrequentLocations.values()) {
            frequentLocation.setStayDuration(0L);
            frequentLocation.setReset(true);
        }
        TimePoint timePoint = this.mRoute.size() > 0 ? (TimePoint) g.h(this.mRoute, 1) : null;
        this.mRoute.clear();
        if (timePoint != null) {
            this.mRoute.add(timePoint);
        }
        this.mArrivedIDs.clear();
        this.mLastArriveLocation = null;
    }

    public void setFrequentWifi(FrequentLocation frequentLocation, @NonNull List<LongTermEvent> list) {
        FrequentWifi next;
        if (isWifiConnected(list)) {
            LongTermEvent longTermEvent = (LongTermEvent) g.h(list, 1);
            String str = longTermEvent.info1;
            String str2 = longTermEvent.info2;
            if (str == null || str2 == null) {
                return;
            }
            List<FrequentWifi> frequentWifiList = frequentLocation.getFrequentWifiList();
            Iterator<FrequentWifi> it = frequentWifiList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (str2.equals(next.getBssid())) {
                    next.setTotalConnectedCount(next.getTotalConnectedCount() + 1);
                    break;
                }
            }
            if (next == null) {
                frequentWifiList.add(new FrequentWifi(str, str2, 1));
            }
        }
    }

    public void update(boolean z4, long j4) {
        AlphaMeLogger.debugLog(TAG, "update ");
        if (this.mFrequentLocations.size() == 0) {
            return;
        }
        updateHome(this.mLastArriveLocation);
        removeExpiredFl();
        updateCompany(z4, j4);
        if (this.mFavoriteHome == this.mFavoriteCompany) {
            this.mFavoriteCompany = null;
        }
    }

    public static double distanceOfTwoPoints(String str, String str2) {
        String[] strArrSplit = str.split(",");
        String[] strArrSplit2 = str2.split(",");
        return distanceOfTwoPoints(strArrSplit[0], strArrSplit[1], strArrSplit2[0], strArrSplit2[1]);
    }

    public static boolean isCompany(FrequentLocation frequentLocation) {
        if (frequentLocation != null) {
            return frequentLocation.isCompany();
        }
        return false;
    }

    private boolean isSameLocation(FrequentLocation frequentLocation, FrequentLocation frequentLocation2) {
        if (frequentLocation == null || frequentLocation2 == null) {
            return false;
        }
        return isSameLocation(frequentLocation.getLongitude(), frequentLocation.getLatitude(), frequentLocation2.getLongitude(), frequentLocation2.getLatitude());
    }

    public boolean isHome(FrequentLocation frequentLocation) {
        if (frequentLocation != null) {
            return frequentLocation.isHome();
        }
        return false;
    }

    public int getLocationType(FrequentLocation frequentLocation) {
        if (frequentLocation == null) {
            return -1;
        }
        if (frequentLocation.isHome()) {
            return 0;
        }
        if (frequentLocation.isCompany()) {
            return 1;
        }
        return frequentLocation.getFrequency() > 0.5f ? 2 : -1;
    }

    public static double distanceOfTwoPoints(double d4, double d5, double d6, double d7) {
        double dRad = rad(d4);
        double dRad2 = rad(d6);
        double dRad3 = rad(d5) - rad(d7);
        return Math.round(((Math.asin(Math.sqrt((Math.pow(Math.sin(dRad3 / 2.0d), 2.0d) * (Math.cos(dRad2) * Math.cos(dRad))) + Math.pow(Math.sin((dRad - dRad2) / 2.0d), 2.0d))) * 2.0d) * EARTH_RADIUS) * 10000.0d) / 10000.0d;
    }

    public FrequentLocation get(long j4) {
        return this.mFrequentLocations.get(Long.valueOf(j4));
    }

    public static double distanceOfTwoPoints(FrequentLocation frequentLocation, FrequentLocation frequentLocation2) {
        return distanceOfTwoPoints(frequentLocation.getLongitude(), frequentLocation.getLatitude(), frequentLocation2.getLongitude(), frequentLocation2.getLatitude());
    }
}
