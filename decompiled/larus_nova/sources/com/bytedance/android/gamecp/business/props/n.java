package com.bytedance.android.gamecp.business.props;

import com.bytedance.android.gamecp.common.network.api.exceptions.local.ApiLocalException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes44.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f56385a = null;

    static {
        f56385a = new n();
    }

    public n() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
        yr.c.e("queryOrderState", "code: " + ((wt.j) r101.data).status);
        if (((wt.j) r101.data).status == 2) goto L6;
        return;
    L6:
        throw new ApiLocalException(((wt.j) r101.data).status, new RuntimeException("query pay status, current: paying"));
    }
}
