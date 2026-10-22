package Q5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0019R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b#\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010 \u001a\u0004\b$\u0010\u0019R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b%\u0010\u0019R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b&\u0010\u0019R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b'\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b(\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b)\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b-\u0010\u0019R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b.\u0010\u0019R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b/\u0010\u0019R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b0\u0010\u0019R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010*\u001a\u0004\b1\u0010,R\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"LQ5/e;", "", "", "date", "fullDate", "week", "tempHigh", "tempLow", "weatherDay", "weatherNight", "aqi", "quality", "", "humidity", "windDirectionDay", "windDirectionNight", "windScaleDay", "windScaleNight", "pop", "", "LQ5/i;", "lifeIndexes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "getWeatherNight", "getAqi", "f", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "getWindDirectionDay", "getWindDirectionNight", "getWindScaleDay", "getWindScaleNight", "e", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Q5.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WeatherDaily {

    @SerializedName("aqi")
    private final String aqi;

    @SerializedName("date")
    private final String date;

    @SerializedName("fullDate")
    private final String fullDate;

    @SerializedName("humidity")
    private final Integer humidity;

    @SerializedName("lifeIndexes")
    private final List<WeatherLifeIndex> lifeIndexes;

    @SerializedName("pop")
    private final Integer pop;

    @SerializedName("quality")
    private final String quality;

    @SerializedName("tempHigh")
    private final String tempHigh;

    @SerializedName("tempLow")
    private final String tempLow;

    @SerializedName("weatherDay")
    private final String weatherDay;

    @SerializedName("weatherNight")
    private final String weatherNight;

    @SerializedName("week")
    private final String week;

    @SerializedName("windDirectionDay")
    private final String windDirectionDay;

    @SerializedName("windDirectionNight")
    private final String windDirectionNight;

    @SerializedName("windScaleDay")
    private final String windScaleDay;

    @SerializedName("windScaleNight")
    private final String windScaleNight;

    public WeatherDaily() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: b, reason: from getter */
    public final String getFullDate() {
        return this.fullDate;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getHumidity() {
        return this.humidity;
    }

    public final List<WeatherLifeIndex> d() {
        return this.lifeIndexes;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getPop() {
        return this.pop;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherDaily)) {
            return false;
        }
        WeatherDaily weatherDaily = (WeatherDaily) other;
        return p.d(this.date, weatherDaily.date) && p.d(this.fullDate, weatherDaily.fullDate) && p.d(this.week, weatherDaily.week) && p.d(this.tempHigh, weatherDaily.tempHigh) && p.d(this.tempLow, weatherDaily.tempLow) && p.d(this.weatherDay, weatherDaily.weatherDay) && p.d(this.weatherNight, weatherDaily.weatherNight) && p.d(this.aqi, weatherDaily.aqi) && p.d(this.quality, weatherDaily.quality) && p.d(this.humidity, weatherDaily.humidity) && p.d(this.windDirectionDay, weatherDaily.windDirectionDay) && p.d(this.windDirectionNight, weatherDaily.windDirectionNight) && p.d(this.windScaleDay, weatherDaily.windScaleDay) && p.d(this.windScaleNight, weatherDaily.windScaleNight) && p.d(this.pop, weatherDaily.pop) && p.d(this.lifeIndexes, weatherDaily.lifeIndexes);
    }

    /* renamed from: f, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    /* renamed from: g, reason: from getter */
    public final String getTempHigh() {
        return this.tempHigh;
    }

    /* renamed from: h, reason: from getter */
    public final String getTempLow() {
        return this.tempLow;
    }

    public int hashCode() {
        String str = this.date;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.fullDate;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.week;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tempHigh;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tempLow;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.weatherDay;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.weatherNight;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.aqi;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.quality;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.humidity;
        int iHashCode10 = (iHashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.windDirectionDay;
        int iHashCode11 = (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.windDirectionNight;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.windScaleDay;
        int iHashCode13 = (iHashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.windScaleNight;
        int iHashCode14 = (iHashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num2 = this.pop;
        int iHashCode15 = (iHashCode14 + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<WeatherLifeIndex> list = this.lifeIndexes;
        return iHashCode15 + (list != null ? list.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getWeatherDay() {
        return this.weatherDay;
    }

    /* renamed from: j, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    public String toString() {
        return "WeatherDaily(date=" + this.date + ", fullDate=" + this.fullDate + ", week=" + this.week + ", tempHigh=" + this.tempHigh + ", tempLow=" + this.tempLow + ", weatherDay=" + this.weatherDay + ", weatherNight=" + this.weatherNight + ", aqi=" + this.aqi + ", quality=" + this.quality + ", humidity=" + this.humidity + ", windDirectionDay=" + this.windDirectionDay + ", windDirectionNight=" + this.windDirectionNight + ", windScaleDay=" + this.windScaleDay + ", windScaleNight=" + this.windScaleNight + ", pop=" + this.pop + ", lifeIndexes=" + this.lifeIndexes + ")";
    }

    public WeatherDaily(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, String str11, String str12, String str13, Integer num2, List<WeatherLifeIndex> list) {
        this.date = str;
        this.fullDate = str2;
        this.week = str3;
        this.tempHigh = str4;
        this.tempLow = str5;
        this.weatherDay = str6;
        this.weatherNight = str7;
        this.aqi = str8;
        this.quality = str9;
        this.humidity = num;
        this.windDirectionDay = str10;
        this.windDirectionNight = str11;
        this.windScaleDay = str12;
        this.windScaleNight = str13;
        this.pop = num2;
        this.lifeIndexes = list;
    }

    public /* synthetic */ WeatherDaily(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, String str11, String str12, String str13, Integer num2, List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? null : str6, (i10 & 64) != 0 ? null : str7, (i10 & 128) != 0 ? null : str8, (i10 & 256) != 0 ? null : str9, (i10 & 512) != 0 ? null : num, (i10 & 1024) != 0 ? null : str10, (i10 & 2048) != 0 ? null : str11, (i10 & 4096) != 0 ? null : str12, (i10 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str13, (i10 & 16384) != 0 ? null : num2, (i10 & 32768) != 0 ? null : list);
    }
}
