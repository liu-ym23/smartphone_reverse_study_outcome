package com.bytedance.android.live.revlink.impl.control.dialog;

import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: classes47.dex */
public abstract class g<V extends RevInteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f92391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V f92392c;

    public final <R> AutoDisposeConverter<R> c() {
        return this.f92392c.T90();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(V r100) {
        this.f92391b = getClass().getSimpleName();
        this.f92392c = r100;
        this.f119692a = r100;
    }

    public final void d(Throwable r100) {
        jy0.d.a(6, this.f92391b, r100.getStackTrace());
    }
}
