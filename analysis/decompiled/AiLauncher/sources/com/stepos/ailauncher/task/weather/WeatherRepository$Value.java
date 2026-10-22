package com.stepos.ailauncher.task.weather;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Keep
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/stepos/ailauncher/task/weather/WeatherRepository$Value", "", "<init>", "()V", "Lcom/stepos/ailauncher/task/weather/WeatherRepository$Realtime;", "realtime", "Lcom/stepos/ailauncher/task/weather/WeatherRepository$Realtime;", "getRealtime", "()Lcom/stepos/ailauncher/task/weather/WeatherRepository$Realtime;", "setRealtime", "(Lcom/stepos/ailauncher/task/weather/WeatherRepository$Realtime;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class WeatherRepository$Value {

    @SerializedName("realtime")
    private WeatherRepository$Realtime realtime;

    public final WeatherRepository$Realtime getRealtime() {
        return this.realtime;
    }

    public final void setRealtime(WeatherRepository$Realtime weatherRepository$Realtime) {
        this.realtime = weatherRepository$Realtime;
    }
}
