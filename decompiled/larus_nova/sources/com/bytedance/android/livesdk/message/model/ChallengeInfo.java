package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\t\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ChallengeInfo;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/r6;", "", "other", "", "equals", "", "hashCode", "ktvChallengeType", "I", "getKtvChallengeType", "()I", "setKtvChallengeType", "(I)V", "isSuccess", "Z", "()Z", "setSuccess", "(Z)V", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "D", "getScore", "()D", "setScore", "(D)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChallengeInfo extends FlexModelBase<r6> implements r6, vh7.h {

    @SerializedName("is_success")
    protected boolean isSuccess;

    @SerializedName("ktv_challenge_type")
    protected int ktvChallengeType;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    protected double score;

    public ChallengeInfo() {
        super(r6.class);
    }

    public int hashCode() {
        int r100 = getKtvChallengeType() * 31;
        if (isSuccess() == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = Double.doubleToLongBits(getScore());
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.message.model.r6
    public int getKtvChallengeType() {
        return this.ktvChallengeType;
    }

    @Override // com.bytedance.android.livesdk.message.model.r6
    public double getScore() {
        return this.score;
    }

    @Override // com.bytedance.android.livesdk.message.model.r6
    public boolean isSuccess() {
        return this.isSuccess;
    }

    public ChallengeInfo(am3.g r100) {
        super(r6.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.ktvChallengeType = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.isSuccess = am3.h.a(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.score = Double.longBitsToDouble(r100.h());
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this != r100) goto L9;
        return true;
    L9:
        if ((!Intrinsics.areEqual(ChallengeInfo.class, r100.getClass())) == false) goto L11;
        return false;
    L11:
        ChallengeInfo r101 = (ChallengeInfo) r100;
        if (getKtvChallengeType() == r101.getKtvChallengeType()) goto L15;
        return false;
    L15:
        if (isSuccess() == r101.isSuccess()) goto L18;
        return false;
    L18:
        if (getScore() == r101.getScore()) goto L20;
        return false;
    L20:
        return true;
    }

    public void setKtvChallengeType(int r100) {
        this.ktvChallengeType = r100;
    }

    public void setScore(double r100) {
        this.score = r100;
    }

    public void setSuccess(boolean r100) {
        this.isSuccess = r100;
    }
}
