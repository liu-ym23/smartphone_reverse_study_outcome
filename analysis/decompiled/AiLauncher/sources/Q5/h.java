package Q5;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.R$drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"LQ5/h;", "", "<init>", "()V", "", "weatherText", "", "night", "", "c", "(Ljava/lang/String;Z)I", Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "(Z)I", "DEFAULT_BACKGROUND", "I", "DAILY_BACKGROUND", Const.INTENT_KEY_PKGNAME, "()I", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h {
    public static final h INSTANCE = new h();
    private static final int DEFAULT_BACKGROUND = R$drawable.bg_card_weather_cloudy;
    private static final int DAILY_BACKGROUND = R$drawable.bg_card_weather_daily;

    public final int a(boolean night) {
        return night ? R$drawable.ic_weather_partly_cloudy_night : R$drawable.ic_weather_partly_cloudy_day;
    }

    public final int b() {
        return DAILY_BACKGROUND;
    }

    public final int c(String weatherText, boolean night) {
        String strH = l.INSTANCE.h(weatherText);
        return strH == null ? a(night) : H.g0(strH, "雷", false, 2, null) ? R$drawable.ic_weather_thunder : H.g0(strH, "暴雪", false, 2, null) ? R$drawable.ic_weather_snow_storm : H.g0(strH, "雪", false, 2, null) ? R$drawable.ic_weather_snow : H.g0(strH, "暴雨", false, 2, null) ? R$drawable.ic_weather_rain_storm : H.g0(strH, "大雨", false, 2, null) ? R$drawable.ic_weather_rain_heavy : H.g0(strH, "中雨", false, 2, null) ? R$drawable.ic_weather_rain_moderate : H.g0(strH, "雨", false, 2, null) ? R$drawable.ic_weather_rain_light : H.g0(strH, "霾", false, 2, null) ? R$drawable.ic_weather_haze : H.g0(strH, "雾", false, 2, null) ? R$drawable.ic_weather_fog : H.g0(strH, "沙", false, 2, null) ? R$drawable.ic_weather_sand : H.g0(strH, "尘", false, 2, null) ? R$drawable.ic_weather_dust : H.g0(strH, "风", false, 2, null) ? R$drawable.ic_weather_wind : H.g0(strH, "阴", false, 2, null) ? R$drawable.ic_weather_overcast : H.g0(strH, "云", false, 2, null) ? night ? R$drawable.ic_weather_partly_cloudy_night : R$drawable.ic_weather_partly_cloudy_day : H.g0(strH, "晴", false, 2, null) ? night ? R$drawable.ic_weather_clear_night : R$drawable.ic_weather_clear_day : a(night);
    }

    public final int d(String weatherText, boolean night) {
        String strH = l.INSTANCE.h(weatherText);
        return strH == null ? DEFAULT_BACKGROUND : H.g0(strH, "雪", false, 2, null) ? R$drawable.bg_card_weather_snow : (H.g0(strH, "霾", false, 2, null) || H.g0(strH, "雾", false, 2, null) || H.g0(strH, "沙", false, 2, null) || H.g0(strH, "尘", false, 2, null) || H.g0(strH, "风", false, 2, null)) ? R$drawable.bg_card_weather_dust : (H.g0(strH, "雷", false, 2, null) || H.g0(strH, "雨", false, 2, null) || H.g0(strH, "阴", false, 2, null) || H.g0(strH, "云", false, 2, null)) ? R$drawable.bg_card_weather_cloudy : H.g0(strH, "晴", false, 2, null) ? night ? R$drawable.bg_card_weather_clear_night : R$drawable.bg_card_weather_clear_day : DEFAULT_BACKGROUND;
    }
}
