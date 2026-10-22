package com.stepos.ailauncher.task.weather;

import O5.c;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/task/weather/WeatherRepository$Realtime", "", "<init>", "()V", "", "temp", "Ljava/lang/String;", "getTemp", "()Ljava/lang/String;", "setTemp", "(Ljava/lang/String;)V", c.WEATHER, "getWeather", "setWeather", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class WeatherRepository$Realtime {

    @SerializedName("temp")
    private String temp;

    @SerializedName(c.WEATHER)
    private String weather;

    public final String getTemp() {
        return this.temp;
    }

    public final String getWeather() {
        return this.weather;
    }

    public final void setTemp(String str) {
        this.temp = str;
    }

    public final void setWeather(String str) {
        this.weather = str;
    }
}
