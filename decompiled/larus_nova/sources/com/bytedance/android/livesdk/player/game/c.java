package com.bytedance.android.livesdk.player.game;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/player/game/c;", "", "", "displayStrategy", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "setDisplayStrategy", "(I)V", "streamOrientation", "c", "setStreamOrientation", "Lcom/bytedance/android/livesdk/player/game/e;", "specifyRatioConditions", "Lcom/bytedance/android/livesdk/player/game/e;", "b", "()Lcom/bytedance/android/livesdk/player/game/e;", "setSpecifyRatioConditions", "(Lcom/bytedance/android/livesdk/player/game/e;)V", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("display_strategy")
    private int displayStrategy;

    @SerializedName("specify_ratio_conditions")
    private e specifyRatioConditions;

    @SerializedName("stream_orientation")
    private int streamOrientation;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.displayStrategy == r101.displayStrategy) goto L8;
        return false;
    L8:
        if (this.streamOrientation == r101.streamOrientation) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.specifyRatioConditions, r101.specifyRatioConditions) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.displayStrategy * 31) + this.streamOrientation) * 31;
        e r101 = this.specifyRatioConditions;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "GameSpecialLayoutConditions(displayStrategy=" + this.displayStrategy + ", streamOrientation=" + this.streamOrientation + ", specifyRatioConditions=" + this.specifyRatioConditions + ")";
    }

    public c() {
        this.displayStrategy = 0;
        this.streamOrientation = 0;
        this.specifyRatioConditions = null;
    }

    public final int a() {
        return this.displayStrategy;
    }

    public final e b() {
        return this.specifyRatioConditions;
    }

    public final int c() {
        return this.streamOrientation;
    }
}
