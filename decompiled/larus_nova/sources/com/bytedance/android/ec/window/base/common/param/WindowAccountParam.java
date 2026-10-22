package com.bytedance.android.ec.window.base.common.param;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/param/WindowAccountParam;", "Ljava/io/Serializable;", "()V", "secUserId", "", "getSecUserId", "()Ljava/lang/String;", "setSecUserId", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAccountParam implements Serializable {
    private String secUserId;
    private String userId;

    public WindowAccountParam() {
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setSecUserId(String r100) {
        this.secUserId = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
