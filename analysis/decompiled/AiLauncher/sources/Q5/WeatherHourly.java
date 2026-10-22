package Q5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b!\u0010\u001eR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"LQ5/g;", "", "", "date", "hour", "temp", O5.c.WEATHER, "", "pop", "humidity", "windDirection", "windScale", "", "isStart", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "e", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "getHumidity", "getWindDirection", "getWindScale", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Q5.g, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WeatherHourly {

    @SerializedName("date")
    private final String date;

    @SerializedName("hour")
    private final String hour;

    @SerializedName("humidity")
    private final Integer humidity;

    @SerializedName("isStart")
    private final Boolean isStart;

    @SerializedName("pop")
    private final Integer pop;

    @SerializedName("temp")
    private final String temp;

    @SerializedName(O5.c.WEATHER)
    private final String weather;

    @SerializedName("windDirection")
    private final String windDirection;

    @SerializedName("windScale")
    private final Integer windScale;

    public WeatherHourly() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* renamed from: b, reason: from getter */
    public final String getHour() {
        return this.hour;
    }

    /* renamed from: c, reason: from getter */
    public final Integer getPop() {
        return this.pop;
    }

    /* renamed from: d, reason: from getter */
    public final String getTemp() {
        return this.temp;
    }

    /* renamed from: e, reason: from getter */
    public final String getWeather() {
        return this.weather;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherHourly)) {
            return false;
        }
        WeatherHourly weatherHourly = (WeatherHourly) other;
        return p.d(this.date, weatherHourly.date) && p.d(this.hour, weatherHourly.hour) && p.d(this.temp, weatherHourly.temp) && p.d(this.weather, weatherHourly.weather) && p.d(this.pop, weatherHourly.pop) && p.d(this.humidity, weatherHourly.humidity) && p.d(this.windDirection, weatherHourly.windDirection) && p.d(this.windScale, weatherHourly.windScale) && p.d(this.isStart, weatherHourly.isStart);
    }

    /* renamed from: f, reason: from getter */
    public final Boolean getIsStart() {
        return this.isStart;
    }

    public int hashCode() {
        String str = this.date;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.hour;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.temp;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.weather;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.pop;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.humidity;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.windDirection;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num3 = this.windScale;
        int iHashCode8 = (iHashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Boolean bool = this.isStart;
        return iHashCode8 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "WeatherHourly(date=" + this.date + ", hour=" + this.hour + ", temp=" + this.temp + ", weather=" + this.weather + ", pop=" + this.pop + ", humidity=" + this.humidity + ", windDirection=" + this.windDirection + ", windScale=" + this.windScale + ", isStart=" + this.isStart + ")";
    }

    public WeatherHourly(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, Integer num3, Boolean bool) {
        this.date = str;
        this.hour = str2;
        this.temp = str3;
        this.weather = str4;
        this.pop = num;
        this.humidity = num2;
        this.windDirection = str5;
        this.windScale = num3;
        this.isStart = bool;
    }

    public /* synthetic */ WeatherHourly(String str, String str2, String str3, String str4, Integer num, Integer num2, String str5, Integer num3, Boolean bool, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : num2, (i10 & 64) != 0 ? null : str5, (i10 & 128) != 0 ? null : num3, (i10 & 256) != 0 ? null : bool);
    }
}
