package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/p;", "", "", "userId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "", KtvSubElement.MIDI, FaceService.girlLabel, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()F", "c", "(F)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p {

    @SerializedName(KtvSubElement.MIDI)
    private float midi;

    @SerializedName("userId")
    private String userId;

    public p() {
        this(null, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.midi, r101.midi) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.userId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.midi);
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "MidiScoreData(userId=" + this.userId + ", midi=" + this.midi + ")";
    }

    public final float a() {
        return this.midi;
    }

    public final String b() {
        return this.userId;
    }

    public final void c(float r100) {
        this.midi = r100;
    }

    public p(String r100, float r101) {
        this.userId = r100;
        this.midi = r101;
    }
}
