package com.android.ttcjpaysdk.base.framework.container.view.base;

import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/base/WebUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "component1", "copy", "equals", "", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebUiInfo implements IViewUiInfo {
    private BaseViewUiInfo baseViewUiInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public WebUiInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ WebUiInfo copy$default(WebUiInfo r100, BaseViewUiInfo r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.baseViewUiInfo;
    L6:
        return r100.copy(r101);
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final WebUiInfo copy(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        return new WebUiInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WebUiInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.baseViewUiInfo, ((WebUiInfo) r100).baseViewUiInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.baseViewUiInfo.hashCode();
    }

    public String toString() {
        return "WebUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public WebUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        this.baseViewUiInfo = r100;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public /* synthetic */ WebUiInfo(BaseViewUiInfo r100, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        r100 = new BaseViewUiInfo(null, -1, -1, 0, null, 25, null);
    L5:
        this(r100);
    }
}
