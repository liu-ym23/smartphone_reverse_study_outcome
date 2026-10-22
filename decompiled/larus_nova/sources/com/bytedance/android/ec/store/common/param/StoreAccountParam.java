package com.bytedance.android.ec.store.common.param;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/store/common/param/StoreAccountParam;", "Ljava/io/Serializable;", "()V", "secUserId", "", "getSecUserId", "()Ljava/lang/String;", "setSecUserId", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "copyFrom", "", "from", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StoreAccountParam implements Serializable {
    private String secUserId;
    private String userId;

    public StoreAccountParam() {
    }

    public final String getSecUserId() {
        return this.secUserId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void copyFrom(StoreAccountParam r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        this.userId = r100.userId;
        this.secUserId = r100.secUserId;
    }

    public final void setSecUserId(String r100) {
        this.secUserId = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
