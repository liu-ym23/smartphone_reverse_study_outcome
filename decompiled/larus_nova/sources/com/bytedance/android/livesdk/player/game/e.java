package com.bytedance.android.livesdk.player.game;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/player/game/e;", "", "", "applyDowngrade", FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "setApplyDowngrade", "(F)V", "platform-player-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("apply_downgrade")
    private float applyDowngrade;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Float.compare(this.applyDowngrade, ((e) r100).applyDowngrade) == 0) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.applyDowngrade);
    }

    public final String toString() {
        return "GameSpecifyRatioCondition(applyDowngrade=" + this.applyDowngrade + ")";
    }

    public e() {
        this.applyDowngrade = 0.0f;
    }

    public final float a() {
        return this.applyDowngrade;
    }
}
