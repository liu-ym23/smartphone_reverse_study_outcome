package com.android.ttcjpaysdk.base.framework.container.view.base;

import android.graphics.Bitmap;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.stdresource.CJPayStdIcon;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/ImgUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "iconType", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;", "customIcon", "Landroid/graphics/Bitmap;", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;Landroid/graphics/Bitmap;)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getCustomIcon", "()Landroid/graphics/Bitmap;", "setCustomIcon", "(Landroid/graphics/Bitmap;)V", "getIconType", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;", "setIconType", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImgUiInfo implements IViewUiInfo {
    private BaseViewUiInfo baseViewUiInfo;
    private Bitmap customIcon;
    private CJPayStdIcon iconType;

    public ImgUiInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ImgUiInfo copy$default(ImgUiInfo r100, BaseViewUiInfo r101, CJPayStdIcon r102, Bitmap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.baseViewUiInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.iconType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.customIcon;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final CJPayStdIcon component2() {
        return this.iconType;
    }

    public final Bitmap component3() {
        return this.customIcon;
    }

    public final ImgUiInfo copy(BaseViewUiInfo r100, CJPayStdIcon r101, Bitmap r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        return new ImgUiInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImgUiInfo) == true) goto L8;
        return false;
    L8:
        ImgUiInfo r101 = (ImgUiInfo) r100;
        if (Intrinsics.areEqual(this.baseViewUiInfo, r101.baseViewUiInfo) == true) goto L12;
        return false;
    L12:
        if (this.iconType == r101.iconType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.customIcon, r101.customIcon) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.baseViewUiInfo.hashCode() * 31;
        CJPayStdIcon r101 = this.iconType;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Bitmap r105 = this.customIcon;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ImgUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ", iconType=" + this.iconType + ", customIcon=" + this.customIcon + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public final Bitmap getCustomIcon() {
        return this.customIcon;
    }

    public final CJPayStdIcon getIconType() {
        return this.iconType;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public final void setCustomIcon(Bitmap r100) {
        this.customIcon = r100;
    }

    public final void setIconType(CJPayStdIcon r100) {
        this.iconType = r100;
    }

    public ImgUiInfo(BaseViewUiInfo r100, CJPayStdIcon r101, Bitmap r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        this.baseViewUiInfo = r100;
        this.iconType = r101;
        this.customIcon = r102;
    }

    public /* synthetic */ ImgUiInfo(BaseViewUiInfo r100, CJPayStdIcon r110, Bitmap r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = new BaseViewUiInfo(null, -2, -2, 0, null, 25, null);
    L6:
        if ((r112 & 2) == 0) goto L9;
        r110 = null;
    L9:
        if ((r112 & 4) == 0) goto L11;
        r111 = null;
    L11:
        this(r100, r110, r111);
    }
}
