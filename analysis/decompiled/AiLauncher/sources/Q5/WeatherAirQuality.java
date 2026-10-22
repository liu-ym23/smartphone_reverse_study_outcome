package Q5;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u000b¨\u0006\u0019"}, d2 = {"LQ5/a;", "", "", "aqi", "pm25", "pm10", "", "quality", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getAqi", "()Ljava/lang/Integer;", "getPm25", "getPm10", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Q5.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class WeatherAirQuality {

    @SerializedName("aqi")
    private final Integer aqi;

    @SerializedName("pm10")
    private final Integer pm10;

    @SerializedName("pm25")
    private final Integer pm25;

    @SerializedName("quality")
    private final String quality;

    public WeatherAirQuality() {
        this(null, null, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getQuality() {
        return this.quality;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeatherAirQuality)) {
            return false;
        }
        WeatherAirQuality weatherAirQuality = (WeatherAirQuality) other;
        return p.d(this.aqi, weatherAirQuality.aqi) && p.d(this.pm25, weatherAirQuality.pm25) && p.d(this.pm10, weatherAirQuality.pm10) && p.d(this.quality, weatherAirQuality.quality);
    }

    public int hashCode() {
        Integer num = this.aqi;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.pm25;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.pm10;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.quality;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "WeatherAirQuality(aqi=" + this.aqi + ", pm25=" + this.pm25 + ", pm10=" + this.pm10 + ", quality=" + this.quality + ")";
    }

    public WeatherAirQuality(Integer num, Integer num2, Integer num3, String str) {
        this.aqi = num;
        this.pm25 = num2;
        this.pm10 = num3;
        this.quality = str;
    }

    public /* synthetic */ WeatherAirQuality(Integer num, Integer num2, Integer num3, String str, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : num3, (i10 & 8) != 0 ? null : str);
    }
}
