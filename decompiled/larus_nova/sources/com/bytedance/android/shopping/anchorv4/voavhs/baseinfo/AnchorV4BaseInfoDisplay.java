package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/AnchorV4BaseInfoDisplay;", "Ljava/io/Serializable;", "baseInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "activityInfo", "Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;)V", "getActivityInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/ActivityVO;", "getBaseInfo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/baseinfo/BaseInfoVO;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4BaseInfoDisplay implements Serializable {

    @SerializedName("activity_info")
    private final ActivityVO activityInfo;

    @SerializedName("base_info")
    private final BaseInfoVO baseInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4BaseInfoDisplay() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4BaseInfoDisplay copy$default(AnchorV4BaseInfoDisplay r100, BaseInfoVO r101, ActivityVO r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.baseInfo;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.activityInfo;
    L9:
        return r100.copy(r101, r102);
    }

    public final BaseInfoVO component1() {
        return this.baseInfo;
    }

    public final ActivityVO component2() {
        return this.activityInfo;
    }

    public final AnchorV4BaseInfoDisplay copy(BaseInfoVO r100, ActivityVO r101) {
        return new AnchorV4BaseInfoDisplay(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4BaseInfoDisplay) == false) goto L10;
        AnchorV4BaseInfoDisplay r101 = (AnchorV4BaseInfoDisplay) r100;
        if (Intrinsics.areEqual(this.baseInfo, r101.baseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.activityInfo, r101.activityInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        BaseInfoVO r100 = this.baseInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ActivityVO r104 = this.activityInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4BaseInfoDisplay(baseInfo=" + this.baseInfo + ", activityInfo=" + this.activityInfo + ")";
    }

    public final ActivityVO getActivityInfo() {
        return this.activityInfo;
    }

    public final BaseInfoVO getBaseInfo() {
        return this.baseInfo;
    }

    public AnchorV4BaseInfoDisplay(BaseInfoVO r100, ActivityVO r101) {
        this.baseInfo = r100;
        this.activityInfo = r101;
    }

    public /* synthetic */ AnchorV4BaseInfoDisplay(BaseInfoVO r100, ActivityVO r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
