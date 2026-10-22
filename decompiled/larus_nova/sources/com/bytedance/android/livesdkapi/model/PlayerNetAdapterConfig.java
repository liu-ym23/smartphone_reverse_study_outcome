package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerNetAdapterConfig;", "", "enable", "", "hurrySpeed", "", "hurryTime", "", "slowSpeed", "slowTime", "(ZFIFI)V", "getEnable", "()Z", "getHurrySpeed", "()F", "getHurryTime", "()I", "getSlowSpeed", "getSlowTime", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerNetAdapterConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("hurry_speed")
    private final float hurrySpeed;

    @SerializedName("hurry_time")
    private final int hurryTime;

    @SerializedName("slow_speed")
    private final float slowSpeed;

    @SerializedName("slow_time")
    private final int slowTime;

    public PlayerNetAdapterConfig() {
        this(false, 0.0f, 0, 0.0f, 0, 31, null);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getHurrySpeed() {
        return this.hurrySpeed;
    }

    public final int getHurryTime() {
        return this.hurryTime;
    }

    public final float getSlowSpeed() {
        return this.slowSpeed;
    }

    public final int getSlowTime() {
        return this.slowTime;
    }

    public PlayerNetAdapterConfig(boolean r100, float r101, int r102, float r103, int r104) {
        this.enable = r100;
        this.hurrySpeed = r101;
        this.hurryTime = r102;
        this.slowSpeed = r103;
        this.slowTime = r104;
    }

    public /* synthetic */ PlayerNetAdapterConfig(boolean r100, float r101, int r102, float r103, int r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r105 & 2) == 0) goto L8;
        float r111 = 1.1f;
    L10:
        if ((r105 & 4) == 0) goto L12;
        int r106 = 7;
    L14:
        if ((r105 & 8) == 0) goto L16;
        float r107 = 0.9f;
    L18:
        if ((r105 & 16) == 0) goto L20;
        int r108 = 3;
    L21:
        this(r100, r111, r106, r107, r108);
        return;
    L20:
        r108 = r104;
        goto L21
    L16:
        r107 = r103;
        goto L18
    L12:
        r106 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L10
    }
}
