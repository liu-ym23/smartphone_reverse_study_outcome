package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.gift.model.k0;
import com.bytedance.android.livesdk.gift.model.q3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/CustomData;", "", "Lcom/bytedance/android/livesdk/gift/model/q3;", "component1", "", "component2", "subscribeGiftPackInfo", "lockStatus", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/livesdk/gift/model/q3;", "getSubscribeGiftPackInfo", "()Lcom/bytedance/android/livesdk/gift/model/q3;", "J", "getLockStatus", "()J", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/q3;J)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomData {
    private final long lockStatus;
    private final q3 subscribeGiftPackInfo;

    public CustomData() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ CustomData copy$default(CustomData r100, q3 r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.subscribeGiftPackInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.lockStatus;
    L9:
        return r100.copy(r101, r102);
    }

    public final q3 component1() {
        return this.subscribeGiftPackInfo;
    }

    public final long component2() {
        return this.lockStatus;
    }

    public final CustomData copy(q3 r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "subscribeGiftPackInfo");
        return new CustomData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CustomData) == false) goto L10;
        CustomData r101 = (CustomData) r100;
        if (Intrinsics.areEqual(this.subscribeGiftPackInfo, r101.subscribeGiftPackInfo) == true) goto L8;
        return false;
    L8:
        if (this.lockStatus == r101.lockStatus) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        q3 r100 = this.subscribeGiftPackInfo;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.lockStatus;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "CustomData(subscribeGiftPackInfo=" + this.subscribeGiftPackInfo + ", lockStatus=" + this.lockStatus + ")";
    }

    public final long getLockStatus() {
        return this.lockStatus;
    }

    public final q3 getSubscribeGiftPackInfo() {
        return this.subscribeGiftPackInfo;
    }

    public CustomData(q3 r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "subscribeGiftPackInfo");
        this.subscribeGiftPackInfo = r100;
        this.lockStatus = r101;
    }

    public /* synthetic */ CustomData(q3 r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = (q3) f.c(q3.class);
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = k0.UNLOCKED;
    L8:
        this(r100, r101);
    }
}
