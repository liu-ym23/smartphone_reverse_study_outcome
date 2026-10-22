package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.BottomPinInfo")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/BottomPinInfo;", "", "()V", "duration", "", "getDuration", "()J", "exitStrategy", "getExitStrategy", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BottomPinInfo implements h {

    @SerializedName("stay_duration")
    protected long duration;

    @SerializedName("exit_strategy")
    protected long exitStrategy;

    public BottomPinInfo() {
    }

    public final long getDuration() {
        return this.duration;
    }

    public final long getExitStrategy() {
        return this.exitStrategy;
    }

    public BottomPinInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.duration = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.exitStrategy = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
