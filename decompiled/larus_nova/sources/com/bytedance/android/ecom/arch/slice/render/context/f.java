package com.bytedance.android.ecom.arch.slice.render.context;

import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f50248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f50249b;

    public f(String r100, Function0 r101) {
        this.f50248a = r100;
        this.f50249b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SliceRender.f50121o.getClass();     // Catch: Throwable -> L6
        pq.a r100 = SliceRender.f50108b;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.i(this.f50248a, (Map) this.f50249b.invoke());     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
