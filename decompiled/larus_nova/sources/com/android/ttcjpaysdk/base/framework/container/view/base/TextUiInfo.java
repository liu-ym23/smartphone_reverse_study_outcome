package com.android.ttcjpaysdk.base.framework.container.view.base;

import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/TextUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "text", "", "textColor", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "getTextColor", "setTextColor", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextUiInfo implements IViewUiInfo {
    private BaseViewUiInfo baseViewUiInfo;
    private String text;
    private String textColor;

    public TextUiInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ TextUiInfo copy$default(TextUiInfo r100, BaseViewUiInfo r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.baseViewUiInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.text;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.textColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.textColor;
    }

    public final TextUiInfo copy(BaseViewUiInfo r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "textColor");
        return new TextUiInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TextUiInfo) == true) goto L8;
        return false;
    L8:
        TextUiInfo r101 = (TextUiInfo) r100;
        if (Intrinsics.areEqual(this.baseViewUiInfo, r101.baseViewUiInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.baseViewUiInfo.hashCode() * 31) + this.text.hashCode()) * 31) + this.textColor.hashCode();
    }

    public String toString() {
        return "TextUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ", text=" + this.text + ", textColor=" + this.textColor + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setTextColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.textColor = r100;
    }

    public TextUiInfo(BaseViewUiInfo r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "textColor");
        this.baseViewUiInfo = r100;
        this.text = r101;
        this.textColor = r102;
    }

    public /* synthetic */ TextUiInfo(BaseViewUiInfo r100, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = new BaseViewUiInfo(null, -2, -2, 0, null, 25, null);
    L6:
        if ((r112 & 2) == 0) goto L9;
        r110 = "";
    L9:
        if ((r112 & 4) == 0) goto L11;
        r111 = "#161823";
    L11:
        this(r100, r110, r111);
    }
}
