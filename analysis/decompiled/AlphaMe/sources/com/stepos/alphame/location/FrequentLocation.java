package com.stepos.alphame.location;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.alibaba.fastjson.JSON;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.location.repo.LocationConverters;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@TypeConverters({LocationConverters.class})
@Keep
@NotProguard
@Entity(tableName = "frequent_location")
/* loaded from: classes.dex */
public class FrequentLocation {
    private static final float ACCURACY = 100.0f;
    public static final float COMPANY_DEFAULT_FREQUENCY = 0.4f;
    public static final float COMPANY_MIN_FREQUENCY = 0.6f;
    public static final long DAY = 86400000;
    public static final int DAY_TIME_BEGIN = 8;
    public static final int DAY_TIME_END = 18;
    public static final float FREQUENCY_INC = 0.1f;
    public static final float HOME_DEFAULT_FREQUENCY = 0.5f;
    public static final float HOME_MIN_FREQUENCY = 0.6f;
    public static final long HOUR = 3600000;
    public static final float MAX_FREQUENCY = 0.8f;
    public static final long MINUTE = 60000;
    private static final float REDUCE_RATE = 0.95f;
    public static final long SECOND = 1000;
    private static final String SEPERATOR = ",";

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "city")
    private String city;

    @ColumnInfo(name = "company")
    public float company;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "day_time_stay_duration")
    private long dayTimeStayDuration;

    @ColumnInfo(name = "district")
    private String district;

    @ColumnInfo(name = AppEventDataItem.APP_HOME)
    public float home;

    @PrimaryKey
    private int id;

    @ColumnInfo(name = "last_arrival_time")
    private long lastArrivalTime;

    @ColumnInfo(name = AppSuggestStorable.COLUMN_LATITUDE)
    private String latitude;

    @ColumnInfo(name = AppSuggestStorable.COLUMN_LONGITUDE)
    private String longitude;

    @ColumnInfo(name = "province")
    private String province;

    @ColumnInfo(name = "stay_duration")
    private long stayDuration;

    @ColumnInfo(name = "total")
    private int total;

    @ColumnInfo(name = "frequency")
    private float frequency = 0.5f;

    @Ignore
    private boolean reset = false;

    @ColumnInfo(name = "frequent_wifi_list")
    private List<FrequentWifi> frequentWifiList = new ArrayList();

    public static FrequentLocation fromJsonString(String str) {
        return (FrequentLocation) JSON.parseObject(str).toJavaObject(FrequentLocation.class);
    }

    private long getDayTimeDuration(long j4, long j5) {
        long j6;
        long hourBase = getHourBase(j4, 0);
        long hourBase2 = getHourBase(j5, 0);
        if (hourBase == hourBase2) {
            long j7 = 28800000 + hourBase;
            long j8 = hourBase + 64800000;
            if ((j4 >= j7 || j5 >= j7) && (j4 <= j8 || j5 <= j8)) {
                return Math.min(j8, j5) - Math.max(j4, j7);
            }
            return 0L;
        }
        long j9 = (j5 - j4) / 86400000;
        long j10 = 36000000 * j9;
        long j11 = (j9 * 86400000) + j4;
        long hourBase3 = getHourBase(j11, 0);
        long j12 = hourBase3 + 28800000;
        long j13 = hourBase3 + 64800000;
        if (j11 <= j13) {
            j6 = (j11 < j12 ? j13 - j12 : j13 - j11) + j10;
        } else {
            j6 = j10;
        }
        long j14 = 28800000 + hourBase2;
        long j15 = hourBase2 + 64800000;
        return j5 >= j14 ? j5 > j15 ? j6 + (j15 - j14) : j6 + (j5 - j14) : j6;
    }

    private long getHourBase(long j4, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        calendar.set(11, i4);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void arrive(long j4) {
        this.lastArrivalTime = j4;
        this.reset = false;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public float getCompany() {
        return this.company;
    }

    public String getCountry() {
        return this.country;
    }

    public long getDayTimeStayDuration() {
        return this.dayTimeStayDuration;
    }

    public String getDistrict() {
        return this.district;
    }

    public float getFrequency() {
        return this.frequency;
    }

    public List<FrequentWifi> getFrequentWifiList() {
        return this.frequentWifiList;
    }

    public float getHome() {
        return this.home;
    }

    public int getId() {
        return this.id;
    }

    public long getLastArrivalTime() {
        return this.lastArrivalTime;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public GeoPoint getLocation() {
        return new GeoPoint(Double.valueOf(this.longitude).doubleValue(), Double.valueOf(this.latitude).doubleValue());
    }

    public String getLongitude() {
        return this.longitude;
    }

    public FrequentWifi getMostFrequentWifi() {
        int totalConnectedCount = 0;
        FrequentWifi frequentWifi = null;
        for (FrequentWifi frequentWifi2 : this.frequentWifiList) {
            if (totalConnectedCount < frequentWifi2.getTotalConnectedCount()) {
                totalConnectedCount = frequentWifi2.getTotalConnectedCount();
                frequentWifi = frequentWifi2;
            }
        }
        return frequentWifi;
    }

    public String getProvince() {
        return this.province;
    }

    public long getStayDuration() {
        return this.stayDuration;
    }

    public int getTotal() {
        return this.total;
    }

    public boolean hasLocation() {
        return (TextUtils.isEmpty(this.longitude) || TextUtils.isEmpty(this.latitude)) ? false : true;
    }

    public boolean isCompany() {
        return !isHome() && this.company > 0.6f;
    }

    public boolean isHome() {
        return this.home >= 0.6f;
    }

    public boolean isReset() {
        return this.reset;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.longitude) || TextUtils.isEmpty(this.latitude) || TextUtils.isEmpty(this.address)) ? false : true;
    }

    public void leave(long j4) {
        boolean z4 = this.reset;
        if (!z4) {
            long j5 = this.lastArrivalTime;
            if (j5 != 0) {
                this.stayDuration = (j4 - j5) + this.stayDuration;
                this.dayTimeStayDuration += getDayTimeDuration(j5, j4);
                return;
            }
        }
        if (z4) {
            this.reset = false;
        }
    }

    public void matchCompany() {
        this.company = Math.min(0.8f, Math.max(0.4f, this.company + 0.1f));
    }

    public void matchHome() {
        this.home = Math.min(0.8f, Math.max(0.5f, this.home + 0.1f));
        this.company = (float) (this.company * 0.5d);
    }

    public void matchHomeNearBy() {
        this.home = Math.min(0.8f, Math.max(0.5f, this.home + 0.05f));
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCompany(float f4) {
        this.company = f4;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDayTimeStayDuration(long j4) {
        this.dayTimeStayDuration = j4;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setFrequency(float f4) {
        this.frequency = f4;
    }

    public void setFrequentWifiList(List<FrequentWifi> list) {
        this.frequentWifiList = list;
    }

    public void setHome(float f4) {
        this.home = f4;
    }

    public void setId(int i4) {
        this.id = i4;
    }

    public void setLastArrivalTime(long j4) {
        this.lastArrivalTime = j4;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setReset(boolean z4) {
        this.reset = z4;
    }

    public void setStayDuration(long j4) {
        this.stayDuration = j4;
    }

    public void setTotal(int i4) {
        this.total = i4;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public String toString() {
        return "address = " + this.address + "\ncoord = " + this.longitude + "," + this.latitude + "\nfrequency = " + this.frequency + "\nhome = " + this.home + "\ncompany = " + this.company + "\nlastArrivalTime = " + StringUtil.formatDateFull(this.lastArrivalTime) + "\n";
    }

    public void update(boolean z4, boolean z5) {
        this.frequency = Math.min(0.8f, (this.frequency * REDUCE_RATE) + (z4 ? 0.1f : Property.DEFAULT_FLOAT_VALUE));
        if (Math.abs(this.home - 0.8f) > 1.0E-6f) {
            this.home *= REDUCE_RATE;
        }
        if (Math.abs(this.company - 0.8f) <= 1.0E-6f || z5) {
            return;
        }
        this.company *= REDUCE_RATE;
    }
}
