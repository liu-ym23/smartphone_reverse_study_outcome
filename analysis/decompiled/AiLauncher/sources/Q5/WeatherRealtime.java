package Q5;

import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001b\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001c\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001d\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b!\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\"\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b$\u0010\u0012R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"LQ5/j;", "", "", "temp", "sendibleTemp", O5.c.WEATHER, "humidity", "", "uvi", Const.JSON_KEY_GPSPRESSURE, "sunrise", "sunset", "updateTime", "LQ5/a;", "airQuality", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LQ5/a;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "getSendibleTemp", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "Ljava/lang/Integer;", "getUvi", "()Ljava/lang/Integer;", "getPressure", "c", Const.INTENT_KEY_UMID, "f", "LQ5/a;", Const.INTENT_KEY_APIKEY, "()LQ5/a;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Q5.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WeatherRealtime {

    @SerializedName("airQuality")
    private final WeatherAirQuality airQuality;

    @SerializedName("humidity")
    private final String humidity;

    @SerializedName(Const.JSON_KEY_GPSPRESSURE)
    private final String pressure;

    @SerializedName("sendibleTemp")
    private final String sendibleTemp;

    @SerializedName("sunrise")
    private final String sunrise;

    @SerializedName("sunset")
    private final String sunset;

    @SerializedName("temp")
    private final String temp;

    @SerializedName("updateTime")
    private final String updateTime;

    @SerializedName("uvi")
    private final Integer uvi;

    @SerializedName(O5.c.WEATHER)
    private final String weather;

    public WeatherRealtime() {
        this(null, null, null, null, null, null, null, null, null, null, FastDoubleMath.DOUBLE_EXPONENT_BIAS, null);
    }

    /* renamed from: a, reason: from getter */
    public final WeatherAirQuality getAirQuality() {
        return this.airQuality;
    }

    /* renamed from: b, reason: from getter */
    public final String getHumidity() {
        return this.humidity;
    }

    /* renamed from: c, reason: from getter */
    public final String getSunrise() {
        return this.sunrise;
    }

    /* renamed from: d, reason: from getter */
    public final String getSunset() {
        return this.sunset;
    }

    /* renamed from: e, reason: from getter */
    public final String getTemp() {
        return this.temp;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherRealtime)) {
            return false;
        }
        WeatherRealtime weatherRealtime = (WeatherRealtime) other;
        return p.d(this.temp, weatherRealtime.temp) && p.d(this.sendibleTemp, weatherRealtime.sendibleTemp) && p.d(this.weather, weatherRealtime.weather) && p.d(this.humidity, weatherRealtime.humidity) && p.d(this.uvi, weatherRealtime.uvi) && p.d(this.pressure, weatherRealtime.pressure) && p.d(this.sunrise, weatherRealtime.sunrise) && p.d(this.sunset, weatherRealtime.sunset) && p.d(this.updateTime, weatherRealtime.updateTime) && p.d(this.airQuality, weatherRealtime.airQuality);
    }

    /* renamed from: f, reason: from getter */
    public final String getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: g, reason: from getter */
    public final String getWeather() {
        return this.weather;
    }

    public int hashCode() {
        String str = this.temp;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.sendibleTemp;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.weather;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.humidity;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.uvi;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.pressure;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sunrise;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sunset;
        int iHashCode8 = (iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.updateTime;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        WeatherAirQuality weatherAirQuality = this.airQuality;
        return iHashCode9 + (weatherAirQuality != null ? weatherAirQuality.hashCode() : 0);
    }

    public String toString() {
        return "WeatherRealtime(temp=" + this.temp + ", sendibleTemp=" + this.sendibleTemp + ", weather=" + this.weather + ", humidity=" + this.humidity + ", uvi=" + this.uvi + ", pressure=" + this.pressure + ", sunrise=" + this.sunrise + ", sunset=" + this.sunset + ", updateTime=" + this.updateTime + ", airQuality=" + this.airQuality + ")";
    }

    public WeatherRealtime(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, WeatherAirQuality weatherAirQuality) {
        this.temp = str;
        this.sendibleTemp = str2;
        this.weather = str3;
        this.humidity = str4;
        this.uvi = num;
        this.pressure = str5;
        this.sunrise = str6;
        this.sunset = str7;
        this.updateTime = str8;
        this.airQuality = weatherAirQuality;
    }

    public /* synthetic */ WeatherRealtime(String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, WeatherAirQuality weatherAirQuality, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7, (i10 & 256) != 0 ? null : str8, (i10 & 512) != 0 ? null : weatherAirQuality);
    }
}
