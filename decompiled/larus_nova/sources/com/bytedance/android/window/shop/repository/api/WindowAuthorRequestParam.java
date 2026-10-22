package com.bytedance.android.window.shop.repository.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/api/WindowAuthorRequestParam;", "Ljava/io/Serializable;", "()V", "passThroughApi", "", "getPassThroughApi", "()Ljava/lang/String;", "setPassThroughApi", "(Ljava/lang/String;)V", "secAuthorId", "getSecAuthorId", "setSecAuthorId", "tabType", "", "getTabType", "()I", "setTabType", "(I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAuthorRequestParam implements Serializable {
    private String passThroughApi;
    private String secAuthorId;
    private int tabType;

    public WindowAuthorRequestParam() {
        this.secAuthorId = "";
    }

    public final String getPassThroughApi() {
        return this.passThroughApi;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final int getTabType() {
        return this.tabType;
    }

    public final void setPassThroughApi(String r100) {
        this.passThroughApi = r100;
    }

    public final void setSecAuthorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.secAuthorId = r100;
    }

    public final void setTabType(int r100) {
        this.tabType = r100;
    }
}
