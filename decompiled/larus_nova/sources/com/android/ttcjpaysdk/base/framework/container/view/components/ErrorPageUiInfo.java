package com.android.ttcjpaysdk.base.framework.container.view.components;

import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.stdresource.CJPayStdIcon;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Ji\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\b\u00105\u001a\u00020\u0003H\u0016J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017¨\u00069"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/ErrorPageUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "errorIconRes", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;", "mainErrorText", "", "subErrorText", "errorButtonText", "errorSolveLinkText", "onErrorButtonClick", "Lkotlin/Function0;", "", "onSolveLinkTextClick", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getErrorButtonText", "()Ljava/lang/String;", "setErrorButtonText", "(Ljava/lang/String;)V", "getErrorIconRes", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;", "setErrorIconRes", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/stdresource/CJPayStdIcon;)V", "getErrorSolveLinkText", "setErrorSolveLinkText", "getMainErrorText", "setMainErrorText", "getOnErrorButtonClick", "()Lkotlin/jvm/functions/Function0;", "setOnErrorButtonClick", "(Lkotlin/jvm/functions/Function0;)V", "getOnSolveLinkTextClick", "setOnSolveLinkTextClick", "getSubErrorText", "setSubErrorText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ErrorPageUiInfo implements IViewUiInfo {
    private BaseViewUiInfo baseViewUiInfo;
    private String errorButtonText;
    private CJPayStdIcon errorIconRes;
    private String errorSolveLinkText;
    private String mainErrorText;
    private Function0<Unit> onErrorButtonClick;
    private Function0<Unit> onSolveLinkTextClick;
    private String subErrorText;

    public ErrorPageUiInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ErrorPageUiInfo copy$default(ErrorPageUiInfo r100, BaseViewUiInfo r110, CJPayStdIcon r111, String r112, String r113, String r114, String r115, Function0 r116, Function0 r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        BaseViewUiInfo r101 = r100.baseViewUiInfo;
    L7:
        if ((r118 & 2) == 0) goto L9;
        CJPayStdIcon r102 = r100.errorIconRes;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.mainErrorText;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.subErrorText;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.errorButtonText;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.errorSolveLinkText;
    L27:
        if ((r118 & 64) == 0) goto L29;
        Function0 r107 = r100.onErrorButtonClick;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Function0 r108 = r100.onSolveLinkTextClick;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
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
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final CJPayStdIcon component2() {
        return this.errorIconRes;
    }

    public final String component3() {
        return this.mainErrorText;
    }

    public final String component4() {
        return this.subErrorText;
    }

    public final String component5() {
        return this.errorButtonText;
    }

    public final String component6() {
        return this.errorSolveLinkText;
    }

    public final Function0<Unit> component7() {
        return this.onErrorButtonClick;
    }

    public final Function0<Unit> component8() {
        return this.onSolveLinkTextClick;
    }

    public final ErrorPageUiInfo copy(BaseViewUiInfo r110, CJPayStdIcon r111, String r112, String r113, String r114, String r115, Function0<Unit> r116, Function0<Unit> r117) {
        Intrinsics.checkNotNullParameter(r110, "baseViewUiInfo");
        Intrinsics.checkNotNullParameter(r111, "errorIconRes");
        Intrinsics.checkNotNullParameter(r112, "mainErrorText");
        Intrinsics.checkNotNullParameter(r113, "subErrorText");
        Intrinsics.checkNotNullParameter(r114, "errorButtonText");
        Intrinsics.checkNotNullParameter(r115, "errorSolveLinkText");
        return new ErrorPageUiInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ErrorPageUiInfo) == true) goto L8;
        return false;
    L8:
        ErrorPageUiInfo r101 = (ErrorPageUiInfo) r100;
        if (Intrinsics.areEqual(this.baseViewUiInfo, r101.baseViewUiInfo) == true) goto L12;
        return false;
    L12:
        if (this.errorIconRes == r101.errorIconRes) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.mainErrorText, r101.mainErrorText) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.subErrorText, r101.subErrorText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.errorButtonText, r101.errorButtonText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.errorSolveLinkText, r101.errorSolveLinkText) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.onErrorButtonClick, r101.onErrorButtonClick) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.onSolveLinkTextClick, r101.onSolveLinkTextClick) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((this.baseViewUiInfo.hashCode() * 31) + this.errorIconRes.hashCode()) * 31) + this.mainErrorText.hashCode()) * 31) + this.subErrorText.hashCode()) * 31) + this.errorButtonText.hashCode()) * 31) + this.errorSolveLinkText.hashCode()) * 31;
        Function0<Unit> r101 = this.onErrorButtonClick;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Function0<Unit> r105 = this.onSolveLinkTextClick;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ErrorPageUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ", errorIconRes=" + this.errorIconRes + ", mainErrorText=" + this.mainErrorText + ", subErrorText=" + this.subErrorText + ", errorButtonText=" + this.errorButtonText + ", errorSolveLinkText=" + this.errorSolveLinkText + ", onErrorButtonClick=" + this.onErrorButtonClick + ", onSolveLinkTextClick=" + this.onSolveLinkTextClick + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public final String getErrorButtonText() {
        return this.errorButtonText;
    }

    public final CJPayStdIcon getErrorIconRes() {
        return this.errorIconRes;
    }

    public final String getErrorSolveLinkText() {
        return this.errorSolveLinkText;
    }

    public final String getMainErrorText() {
        return this.mainErrorText;
    }

    public final Function0<Unit> getOnErrorButtonClick() {
        return this.onErrorButtonClick;
    }

    public final Function0<Unit> getOnSolveLinkTextClick() {
        return this.onSolveLinkTextClick;
    }

    public final String getSubErrorText() {
        return this.subErrorText;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public final void setErrorButtonText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorButtonText = r100;
    }

    public final void setErrorIconRes(CJPayStdIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorIconRes = r100;
    }

    public final void setErrorSolveLinkText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorSolveLinkText = r100;
    }

    public final void setMainErrorText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mainErrorText = r100;
    }

    public final void setOnErrorButtonClick(Function0<Unit> r100) {
        this.onErrorButtonClick = r100;
    }

    public final void setOnSolveLinkTextClick(Function0<Unit> r100) {
        this.onSolveLinkTextClick = r100;
    }

    public final void setSubErrorText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subErrorText = r100;
    }

    public ErrorPageUiInfo(BaseViewUiInfo r100, CJPayStdIcon r101, String r102, String r103, String r104, String r105, Function0<Unit> r106, Function0<Unit> r107) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        Intrinsics.checkNotNullParameter(r101, "errorIconRes");
        Intrinsics.checkNotNullParameter(r102, "mainErrorText");
        Intrinsics.checkNotNullParameter(r103, "subErrorText");
        Intrinsics.checkNotNullParameter(r104, "errorButtonText");
        Intrinsics.checkNotNullParameter(r105, "errorSolveLinkText");
        this.baseViewUiInfo = r100;
        this.errorIconRes = r101;
        this.mainErrorText = r102;
        this.subErrorText = r103;
        this.errorButtonText = r104;
        this.errorSolveLinkText = r105;
        this.onErrorButtonClick = r106;
        this.onSolveLinkTextClick = r107;
    }

    public /* synthetic */ ErrorPageUiInfo(BaseViewUiInfo r110, CJPayStdIcon r111, String r112, String r113, String r114, String r115, Function0 r116, Function0 r117, int r118, DefaultConstructorMarker r210) {
        if ((r118 & 1) == 0) goto L5;
        BaseViewUiInfo r100 = new BaseViewUiInfo(null, -1, -1, 0, null, 25, null);
    L7:
        if ((r118 & 2) == 0) goto L9;
        CJPayStdIcon r101 = CJPayStdIcon.NET_ERROR;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r102 = "网络异常";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r103 = "请刷新页面";
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r104 = "刷新";
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r105 = "";
    L26:
        Function0 r106 = null;
        if ((r118 & 64) == 0) goto L29;
        Function0 r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r106 = r117;
    L34:
        this(r100, r101, r102, r103, r104, r105, r107, r106);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
