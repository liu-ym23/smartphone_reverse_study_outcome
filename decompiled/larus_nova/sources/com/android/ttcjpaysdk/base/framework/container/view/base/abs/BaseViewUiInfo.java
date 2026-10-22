package com.android.ttcjpaysdk.base.framework.container.view.base.abs;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.framework.container.abs.Theme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003JB\u0010 \u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\b\u0010&\u001a\u00020\u0000H\u0016J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006*"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "bgColor", "", "width", "height", GXTemplateKey.GAIAX_LAYER_GRAVITY, "theme", "Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "(Ljava/lang/Integer;IIILcom/android/ttcjpaysdk/base/framework/container/abs/Theme;)V", "getBgColor", "()Ljava/lang/Integer;", "setBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGravity", "()I", "setGravity", "(I)V", "getHeight", "setHeight", "getTheme", "()Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;", "setTheme", "(Lcom/android/ttcjpaysdk/base/framework/container/abs/Theme;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;IIILcom/android/ttcjpaysdk/base/framework/container/abs/Theme;)Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "equals", "", "other", "", "getBaseUiInfo", "hashCode", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BaseViewUiInfo implements IViewUiInfo {
    private Integer bgColor;
    private int gravity;
    private int height;
    private Theme theme;
    private int width;

    public BaseViewUiInfo() {
        this(null, 0, 0, 0, null, 31, null);
    }

    public static /* synthetic */ BaseViewUiInfo copy$default(BaseViewUiInfo r100, Integer r101, int r102, int r103, int r104, Theme r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bgColor;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.width;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.height;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.gravity;
    L14:
        int r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.theme;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.bgColor;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.gravity;
    }

    public final Theme component5() {
        return this.theme;
    }

    public final BaseViewUiInfo copy(Integer r100, int r101, int r110, int r111, Theme r112) {
        Intrinsics.checkNotNullParameter(r112, "theme");
        return new BaseViewUiInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BaseViewUiInfo) == true) goto L8;
        return false;
    L8:
        BaseViewUiInfo r101 = (BaseViewUiInfo) r100;
        if (Intrinsics.areEqual(this.bgColor, r101.bgColor) == true) goto L12;
        return false;
    L12:
        if (this.width == r101.width) goto L15;
        return false;
    L15:
        if (this.height == r101.height) goto L18;
        return false;
    L18:
        if (this.gravity == r101.gravity) goto L21;
        return false;
    L21:
        if (this.theme == r101.theme) goto L23;
        return false;
    L23:
        return true;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this;
    }

    public int hashCode() {
        Integer r100 = this.bgColor;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((r101 * 31) + this.width) * 31) + this.height) * 31) + this.gravity) * 31) + this.theme.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "BaseViewUiInfo(bgColor=" + this.bgColor + ", width=" + this.width + ", height=" + this.height + ", gravity=" + this.gravity + ", theme=" + this.theme + ')';
    }

    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getHeight() {
        return this.height;
    }

    public final Theme getTheme() {
        return this.theme;
    }

    public final int getWidth() {
        return this.width;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBgColor(Integer r100) {
        this.bgColor = r100;
    }

    public final void setGravity(int r100) {
        this.gravity = r100;
    }

    public final void setHeight(int r100) {
        this.height = r100;
    }

    public final void setTheme(Theme r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.theme = r100;
    }

    public final void setWidth(int r100) {
        this.width = r100;
    }

    public BaseViewUiInfo(Integer r100, int r101, int r102, int r103, Theme r104) {
        Intrinsics.checkNotNullParameter(r104, "theme");
        this.bgColor = r100;
        this.width = r101;
        this.height = r102;
        this.gravity = r103;
        this.theme = r104;
    }

    public /* synthetic */ BaseViewUiInfo(Integer r100, int r101, int r102, int r103, Theme r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L5;
        r100 = null;
    L5:
        int r106 = -2;
        if ((r105 & 2) == 0) goto L8;
        int r111 = -2;
    L10:
        if ((r105 & 4) != 0) goto L14;
        r106 = r102;
    L14:
        if ((r105 & 8) == 0) goto L16;
        int r107 = 17;
    L18:
        if ((r105 & 16) == 0) goto L20;
        r104 = Theme.SYSTEM;
    L20:
        Theme r108 = r104;
        this(r100, r111, r106, r107, r108);
        return;
    L16:
        r107 = r103;
        goto L18
    L8:
        r111 = r101;
        goto L10
    }
}
