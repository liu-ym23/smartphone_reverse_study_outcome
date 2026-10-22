package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/scope/service/p3;", "", "", "userId", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "lastTimestamp", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "c", "(J)V", "", "type", "I", "getType", "()I", "d", "(I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p3 {

    @SerializedName("last_timestamp")
    private long lastTimestamp;

    @SerializedName("type")
    private int type;

    @SerializedName("user_id")
    private final String userId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p3) == false) goto L12;
        p3 r101 = (p3) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L8;
        return false;
    L8:
        if (this.lastTimestamp == r101.lastTimestamp) goto L10;
        return false;
    L10:
        if (this.type == r101.type) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.userId;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.lastTimestamp;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.type;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "SendGiftRelation(userId=" + this.userId + ", lastTimestamp=" + this.lastTimestamp + ", type=" + this.type + ")";
    }

    public final long a() {
        return this.lastTimestamp;
    }

    public final String b() {
        return this.userId;
    }

    public final int getType() {
        return this.type;
    }

    public final void c(long r100) {
        this.lastTimestamp = r100;
    }

    public final void d(int r100) {
        this.type = r100;
    }

    public p3(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.userId = r100;
        this.lastTimestamp = r101;
        this.type = r102;
    }
}
