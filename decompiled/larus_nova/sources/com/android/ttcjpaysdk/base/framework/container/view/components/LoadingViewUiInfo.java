package com.android.ttcjpaysdk.base.framework.container.view.components;

import com.android.ttcjpaysdk.base.framework.container.view.base.abs.BaseViewUiInfo;
import com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo;", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/IViewUiInfo;", "baseViewUiInfo", "Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "timeout", "", "showLoadingTextAndBg", "", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;JZ)V", "getBaseViewUiInfo", "()Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;", "setBaseViewUiInfo", "(Lcom/android/ttcjpaysdk/base/framework/container/view/base/abs/BaseViewUiInfo;)V", "getShowLoadingTextAndBg", "()Z", "setShowLoadingTextAndBg", "(Z)V", "getTimeout", "()J", "setTimeout", "(J)V", "component1", "component2", "component3", "copy", "equals", "other", "", "getBaseUiInfo", "hashCode", "", "toString", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoadingViewUiInfo implements IViewUiInfo {
    public static final Companion Companion = null;
    public static final long DEFAULT_TIMEOUT = -1;
    private BaseViewUiInfo baseViewUiInfo;
    private boolean showLoadingTextAndBg;
    private long timeout;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/framework/container/view/components/LoadingViewUiInfo$Companion;", "", "()V", "DEFAULT_TIMEOUT", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LoadingViewUiInfo() {
        this(null, 0, false, 7, null);
    }

    public static /* synthetic */ LoadingViewUiInfo copy$default(LoadingViewUiInfo r100, BaseViewUiInfo r101, long r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.baseViewUiInfo;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.timeout;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.showLoadingTextAndBg;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final BaseViewUiInfo component1() {
        return this.baseViewUiInfo;
    }

    public final long component2() {
        return this.timeout;
    }

    public final boolean component3() {
        return this.showLoadingTextAndBg;
    }

    public final LoadingViewUiInfo copy(BaseViewUiInfo r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        return new LoadingViewUiInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LoadingViewUiInfo) == true) goto L8;
        return false;
    L8:
        LoadingViewUiInfo r101 = (LoadingViewUiInfo) r100;
        if (Intrinsics.areEqual(this.baseViewUiInfo, r101.baseViewUiInfo) == true) goto L12;
        return false;
    L12:
        if (this.timeout == r101.timeout) goto L15;
        return false;
    L15:
        if (this.showLoadingTextAndBg == r101.showLoadingTextAndBg) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = this.baseViewUiInfo.hashCode() * 31;
        long r101 = this.timeout;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        if (this.showLoadingTextAndBg == false) goto L5;
        int r103 = 1231;
    L7:
        return r102 + r103;
    L5:
        r103 = 1237;
        goto L7
    }

    public String toString() {
        return "LoadingViewUiInfo(baseViewUiInfo=" + this.baseViewUiInfo + ", timeout=" + this.timeout + ", showLoadingTextAndBg=" + this.showLoadingTextAndBg + ')';
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public BaseViewUiInfo getBaseUiInfo() {
        return this.baseViewUiInfo;
    }

    public final BaseViewUiInfo getBaseViewUiInfo() {
        return this.baseViewUiInfo;
    }

    public final boolean getShowLoadingTextAndBg() {
        return this.showLoadingTextAndBg;
    }

    public final long getTimeout() {
        return this.timeout;
    }

    @Override // com.android.ttcjpaysdk.base.framework.container.view.base.abs.IViewUiInfo
    public int parseColor(String r100) {
        return IViewUiInfo.DefaultImpls.parseColor(this, r100);
    }

    public final void setBaseViewUiInfo(BaseViewUiInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseViewUiInfo = r100;
    }

    public final void setShowLoadingTextAndBg(boolean r100) {
        this.showLoadingTextAndBg = r100;
    }

    public final void setTimeout(long r100) {
        this.timeout = r100;
    }

    public LoadingViewUiInfo(BaseViewUiInfo r100, long r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "baseViewUiInfo");
        this.baseViewUiInfo = r100;
        this.timeout = r101;
        this.showLoadingTextAndBg = r102;
    }

    public /* synthetic */ LoadingViewUiInfo(BaseViewUiInfo r100, long r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = new BaseViewUiInfo(null, -1, -1, 0, null, 25, null);
    L6:
        if ((r112 & 2) == 0) goto L9;
        r110 = -1;
    L9:
        if ((r112 & 4) == 0) goto L11;
        r111 = true;
    L11:
        this(r100, r110, r111);
    }
}
