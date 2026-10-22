package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"com/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc", "", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "component1", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "component2", "layoutStyle", "textStyle", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$ModuleDesc;", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "getLayoutStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;", "Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "getTextStyle", "()Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;", "<init>", "(Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$LayoutStyle;Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/CommonModel$CusTextStyle;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonModel$ModuleDesc {
    private final CommonModel$LayoutStyle layoutStyle;
    private final CommonModel$CusTextStyle textStyle;

    public static /* synthetic */ CommonModel$ModuleDesc copy$default(CommonModel$ModuleDesc r100, CommonModel$LayoutStyle r101, CommonModel$CusTextStyle r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.layoutStyle;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.textStyle;
    L9:
        return r100.copy(r101, r102);
    }

    public final CommonModel$LayoutStyle component1() {
        return this.layoutStyle;
    }

    public final CommonModel$CusTextStyle component2() {
        return this.textStyle;
    }

    public final CommonModel$ModuleDesc copy(CommonModel$LayoutStyle r100, CommonModel$CusTextStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutStyle");
        Intrinsics.checkNotNullParameter(r101, "textStyle");
        return new CommonModel$ModuleDesc(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CommonModel$ModuleDesc) == false) goto L10;
        CommonModel$ModuleDesc r101 = (CommonModel$ModuleDesc) r100;
        if (Intrinsics.areEqual(this.layoutStyle, r101.layoutStyle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textStyle, r101.textStyle) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        CommonModel$LayoutStyle r100 = this.layoutStyle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CommonModel$CusTextStyle r104 = this.textStyle;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ModuleDesc(layoutStyle=" + this.layoutStyle + ", textStyle=" + this.textStyle + ")";
    }

    public final CommonModel$LayoutStyle getLayoutStyle() {
        return this.layoutStyle;
    }

    public final CommonModel$CusTextStyle getTextStyle() {
        return this.textStyle;
    }

    public CommonModel$ModuleDesc(CommonModel$LayoutStyle r100, CommonModel$CusTextStyle r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutStyle");
        Intrinsics.checkNotNullParameter(r101, "textStyle");
        this.layoutStyle = r100;
        this.textStyle = r101;
    }
}
