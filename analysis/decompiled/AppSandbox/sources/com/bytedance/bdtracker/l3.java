package com.bytedance.bdtracker;

import com.bytedance.applog.oneid.IDBindCallback;
import com.bytedance.applog.oneid.IDBindResult;

/* loaded from: classes.dex */
public final class l3 implements Runnable {
    public final /* synthetic */ IDBindCallback a;
    public final /* synthetic */ IDBindResult b;

    public l3(IDBindCallback iDBindCallback, IDBindResult iDBindResult) {
        this.a = iDBindCallback;
        this.b = iDBindResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onSuccess(this.b);
    }
}
