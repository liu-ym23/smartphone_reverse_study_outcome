package com.android.ttcjpaysdk.base.framework.container.view.components;

import com.android.ttcjpaysdk.base.framework.container.view.base.abs.AbsBaseViewController;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IApiView;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012&\b\u0002\u0010\u0006\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t\u0012&\b\u0002\u0010\n\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t\u0012&\b\u0002\u0010\u000b\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t\u0012&\b\u0002\u0010\f\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J'\u0010%\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tHÆ\u0003J'\u0010&\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tHÆ\u0003J'\u0010'\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tHÆ\u0003J'\u0010(\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003JÇ\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052&\b\u0002\u0010\u0006\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t2&\b\u0002\u0010\n\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t2&\b\u0002\u0010\u000b\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t2&\b\u0002\u0010\f\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\t2\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\b\u0010.\u001a\u00020\u0003H\u0016J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u000202HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R8\u0010\f\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R8\u0010\u0006\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R8\u0010\n\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR8\u0010\u000b\u001a \u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0018\u00010\u0007j\u0002`\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001e¨\u00063"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/TitleBarUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "needMarginStatusBar", "", "leftViewController", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IApiView;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/ViewController;", "middleViewController", "rightViewController", "bgViewController", "showTitleBarLine", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;ZLcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;Z)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getBgViewController", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;", "setBgViewController", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/AbsBaseViewController;)V", "getLeftViewController", "setLeftViewController", "getMiddleViewController", "setMiddleViewController", "getNeedMarginStatusBar", "()Z", "setNeedMarginStatusBar", "(Z)V", "getRightViewController", "setRightViewController", "getShowTitleBarLine", "setShowTitleBarLine", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TitleBarUiInfo implements IViewUiInfo {
    private BaseViewUiInfo baseViewUiInfo;
    private AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> bgViewController;
    private AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> leftViewController;
    private AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> middleViewController;
    private boolean needMarginStatusBar;
    private AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> rightViewController;
    private boolean showTitleBarLine;

    public TitleBarUiInfo() {
        this(null, false, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TitleBarUiInfo copy$default(TitleBarUiInfo r100, BaseViewUiInfo r101, boolean r102, AbsBaseViewController r103, AbsBaseViewController r104, AbsBaseViewController r110, AbsBaseViewController r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.baseViewUiInfo;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.needMarginStatusBar;
    L8:
        boolean r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.leftViewController;
    L11:
        AbsBaseViewController r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.middleViewController;
    L14:
        AbsBaseViewController r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.rightViewController;
    L17:
        AbsBaseViewController r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.bgViewController;
    L20:
        AbsBaseViewController r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.showTitleBarLine;
    L23:
        BaseViewUiInfo r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final boolean component2() {
        return this.needMarginStatusBar;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> component3() {
        return this.leftViewController;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> component4() {
        return this.middleViewController;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> component5() {
        return this.rightViewController;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> component6() {
        return this.bgViewController;
    }

    public final boolean component7() {
        return this.showTitleBarLine;
    }

    public final TitleBarUiInfo copy(BaseViewUiInfo r110, boolean r111, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r112, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r113, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r114, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r115, boolean r116) {
        Intrinsics.checkNotNullParameter(r110, "baseViewUiInfo");
        return new TitleBarUiInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TitleBarUiInfo) == true) goto L8;
        return false;
    L8:
        TitleBarUiInfo r101 = (TitleBarUiInfo) r100;
        if (Intrinsics.areEqual(this.baseViewUiInfo, r101.baseViewUiInfo) == true) goto L12;
        return false;
    L12:
        if (this.needMarginStatusBar == r101.needMarginStatusBar) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.leftViewController, r101.leftViewController) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.middleViewController, r101.middleViewController) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.rightViewController, r101.rightViewController) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bgViewController, r101.bgViewController) == true) goto L27;
        return false;
    L27:
        if (this.showTitleBarLine == r101.showTitleBarLine) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = this.baseViewUiInfo.hashCode() * 31;
        int r101 = 1231;
        if (this.needMarginStatusBar == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r104 = this.leftViewController;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r108 = this.middleViewController;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r111 = this.rightViewController;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r114 = this.bgViewController;
        if (r114 == null) goto L22;
        r105 = r114.hashCode();
    L22:
        int r115 = (r113 + r105) * 31;
        if (this.showTitleBarLine == true) goto L27;
        r101 = 1237;
    L27:
        return r115 + r101;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "TitleBarUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ", needMarginStatusBar=" + this.needMarginStatusBar + ", leftViewController=" + this.leftViewController + ", middleViewController=" + this.middleViewController + ", rightViewController=" + this.rightViewController + ", bgViewController=" + this.bgViewController + ", showTitleBarLine=" + this.showTitleBarLine + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> getBgViewController() {
        return this.bgViewController;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> getLeftViewController() {
        return this.leftViewController;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> getMiddleViewController() {
        return this.middleViewController;
    }

    public final boolean getNeedMarginStatusBar() {
        return this.needMarginStatusBar;
    }

    public final AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> getRightViewController() {
        return this.rightViewController;
    }

    public final boolean getShowTitleBarLine() {
        return this.showTitleBarLine;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public final void setBgViewController(AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        this.bgViewController = r100;
    }

    public final void setLeftViewController(AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        this.leftViewController = r100;
    }

    public final void setMiddleViewController(AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        this.middleViewController = r100;
    }

    public final void setNeedMarginStatusBar(boolean r100) {
        this.needMarginStatusBar = r100;
    }

    public final void setRightViewController(AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r100) {
        this.rightViewController = r100;
    }

    public final void setShowTitleBarLine(boolean r100) {
        this.showTitleBarLine = r100;
    }

    public TitleBarUiInfo(BaseViewUiInfo r100, boolean r101, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r102, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r103, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r104, AbsBaseViewController<? extends IViewUiInfo, ? extends IApiView<? extends IViewUiInfo>> r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        this.baseViewUiInfo = r100;
        this.needMarginStatusBar = r101;
        this.leftViewController = r102;
        this.middleViewController = r103;
        this.rightViewController = r104;
        this.bgViewController = r105;
        this.showTitleBarLine = r106;
    }

    public /* synthetic */ TitleBarUiInfo(BaseViewUiInfo r110, boolean r111, AbsBaseViewController r112, AbsBaseViewController r113, AbsBaseViewController r114, AbsBaseViewController r115, boolean r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 1) == 0) goto L5;
        BaseViewUiInfo r100 = new BaseViewUiInfo(null, -1, -2, 0, null, 25, null);
    L7:
        if ((r117 & 2) == 0) goto L9;
        boolean r101 = true;
    L10:
        AbsBaseViewController r102 = null;
        if ((r117 & 4) == 0) goto L13;
        AbsBaseViewController r103 = null;
    L15:
        if ((r117 & 8) == 0) goto L17;
        AbsBaseViewController r104 = null;
    L19:
        if ((r117 & 16) == 0) goto L21;
        AbsBaseViewController r105 = null;
    L23:
        if ((r117 & 32) != 0) goto L27;
        r102 = r115;
    L27:
        if ((r117 & 64) == 0) goto L29;
        boolean r106 = false;
    L30:
        this(r100, r101, r103, r104, r105, r102, r106);
        return;
    L29:
        r106 = r116;
        goto L30
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L10
    L5:
        r100 = r110;
        goto L7
    }
}
