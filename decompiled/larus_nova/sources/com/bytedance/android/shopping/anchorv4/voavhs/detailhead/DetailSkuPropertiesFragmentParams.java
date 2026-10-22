package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/DetailSkuPropertiesFragmentParams;", "Ljava/io/Serializable;", "", "component1", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "component2", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "component3", "tabPosition", "vo", "viewModel", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getTabPosition", "()I", "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", "getVo", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "getViewModel", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;", "<init>", "(ILcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/AnchorV4DetailSkuVO;Lcom/bytedance/android/shopping/anchorv4/voavhs/detailhead/t;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailSkuPropertiesFragmentParams implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient t f168200a;
    private final int tabPosition;

    /* JADX INFO: renamed from: vo, reason: collision with root package name */
    private final AnchorV4DetailSkuVO f168201vo;

    public DetailSkuPropertiesFragmentParams() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ DetailSkuPropertiesFragmentParams copy$default(DetailSkuPropertiesFragmentParams r100, int r101, AnchorV4DetailSkuVO r102, t r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tabPosition;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f168201vo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.f168200a;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.tabPosition;
    }

    public final AnchorV4DetailSkuVO component2() {
        return this.f168201vo;
    }

    public final t component3() {
        return this.f168200a;
    }

    public final DetailSkuPropertiesFragmentParams copy(int r100, AnchorV4DetailSkuVO r101, t r102) {
        return new DetailSkuPropertiesFragmentParams(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DetailSkuPropertiesFragmentParams) == false) goto L12;
        DetailSkuPropertiesFragmentParams r101 = (DetailSkuPropertiesFragmentParams) r100;
        if (this.tabPosition == r101.tabPosition) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168201vo, r101.f168201vo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168200a, r101.f168200a) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.tabPosition * 31;
        AnchorV4DetailSkuVO r101 = this.f168201vo;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        t r105 = this.f168200a;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "DetailSkuPropertiesFragmentParams(tabPosition=" + this.tabPosition + ", vo=" + this.f168201vo + ", viewModel=" + this.f168200a + ")";
    }

    public final int getTabPosition() {
        return this.tabPosition;
    }

    public final t getViewModel() {
        return this.f168200a;
    }

    public final AnchorV4DetailSkuVO getVo() {
        return this.f168201vo;
    }

    public DetailSkuPropertiesFragmentParams(int r100, AnchorV4DetailSkuVO r101, t r102) {
        this.tabPosition = r100;
        this.f168201vo = r101;
        this.f168200a = r102;
    }

    public /* synthetic */ DetailSkuPropertiesFragmentParams(int r100, AnchorV4DetailSkuVO r101, t r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
