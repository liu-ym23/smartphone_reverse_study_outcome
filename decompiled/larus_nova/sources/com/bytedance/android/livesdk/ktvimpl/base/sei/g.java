package com.bytedance.android.livesdk.ktvimpl.base.sei;

import android.text.TextUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0015R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/g;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "anchorId", "J", "getAnchorId", "()J", "getAnchorId$annotations", "()V", "", "cmd", "I", "c", "()I", SlcFlexDirection.FLEX_ROW, "getRow", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, FaceService.girlLabel, "d", "()F", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class g extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f143308a;

    @SerializedName("anchor_id")
    private final long anchorId;

    @SerializedName("cmd")
    private final int cmd;

    @SerializedName(SlcFlexDirection.FLEX_ROW)
    private final int row;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private final float score;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L14;
        g r101 = (g) r100;
        if (this.anchorId == r101.anchorId) goto L8;
        return false;
    L8:
        if (this.cmd == r101.cmd) goto L10;
        return false;
    L10:
        if (this.row == r101.row) goto L12;
        return false;
    L12:
        if (Float.compare(this.score, r101.score) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.anchorId;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.cmd) * 31) + this.row) * 31) + Float.floatToIntBits(this.score);
    }

    public final String toString() {
        return "KtvMidiSeiModel(anchorId=" + this.anchorId + ", cmd=" + this.cmd + ", row=" + this.row + ", score=" + this.score + ")";
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f143308a) == false) goto L6;
        this.f143308a = t.k(this.anchorId);
    L6:
        return this.f143308a;
    }

    public g() {
        this.anchorId = 0;
        this.cmd = 0;
        this.row = 0;
        this.score = 0.0f;
        this.f143308a = "";
    }

    public final int c() {
        return this.cmd;
    }

    public final float d() {
        return this.score;
    }
}
