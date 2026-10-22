package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RechargeIconParams;", "", "Lpy/k;", "component1", "", "component2", "component3", "imageModel", "iconRes", RemoteMessageConst.Notification.VISIBILITY, "copy", "", "toString", "hashCode", "other", "", "equals", "Lpy/k;", "getImageModel", "()Lpy/k;", "I", "getIconRes", "()I", "getVisibility", "<init>", "(Lpy/k;II)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RechargeIconParams {
    private final int iconRes;
    private final k imageModel;
    private final int visibility;

    public RechargeIconParams() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ RechargeIconParams copy$default(RechargeIconParams r100, k r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.imageModel;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.iconRes;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.visibility;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final k component1() {
        return this.imageModel;
    }

    public final int component2() {
        return this.iconRes;
    }

    public final int component3() {
        return this.visibility;
    }

    public final RechargeIconParams copy(k r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "imageModel");
        return new RechargeIconParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RechargeIconParams) == false) goto L12;
        RechargeIconParams r101 = (RechargeIconParams) r100;
        if (Intrinsics.areEqual(this.imageModel, r101.imageModel) == true) goto L8;
        return false;
    L8:
        if (this.iconRes == r101.iconRes) goto L10;
        return false;
    L10:
        if (this.visibility == r101.visibility) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        k r100 = this.imageModel;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (((r101 * 31) + this.iconRes) * 31) + this.visibility;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "RechargeIconParams(imageModel=" + this.imageModel + ", iconRes=" + this.iconRes + ", visibility=" + this.visibility + ")";
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final k getImageModel() {
        return this.imageModel;
    }

    public final int getVisibility() {
        return this.visibility;
    }

    public RechargeIconParams(k r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "imageModel");
        this.imageModel = r100;
        this.iconRes = r101;
        this.visibility = r102;
    }

    public /* synthetic */ RechargeIconParams(k r100, int r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = (k) f.c(k.class);
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 8;
    L11:
        this(r100, r101, r102);
    }
}
