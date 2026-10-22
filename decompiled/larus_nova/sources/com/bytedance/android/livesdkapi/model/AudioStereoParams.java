package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioStereoParams;", "", "enable", "", "position", "", "params", "", "(ZILjava/lang/String;)V", "getEnable", "()Z", "getParams", "()Ljava/lang/String;", "getPosition", "()I", "toString", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioStereoParams {
    private final boolean enable;
    private final String params;
    private final int position;

    public String toString() {
        return "AudioStereoParams(enable=" + this.enable + ", position=" + this.position + ", params='" + this.params + "')";
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getParams() {
        return this.params;
    }

    public final int getPosition() {
        return this.position;
    }

    public AudioStereoParams(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "params");
        this.enable = r100;
        this.position = r101;
        this.params = r102;
    }
}
