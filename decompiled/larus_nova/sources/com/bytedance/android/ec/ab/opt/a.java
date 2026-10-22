package com.bytedance.android.ec.ab.opt;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public abstract class a<Config> implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f42665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Config f42666b;

    public abstract Config b();

    public a() {
        this.f42665a = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.ec.ab.opt.b
    public final Object a(ContinuationImpl r100) {
        boolean r101 = false;
        if (this.f42665a.compareAndSet(false, true) == false) goto L13;
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L7;
        r101 = true;
    L7:
        if (r101 == false) goto L11;
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new IDefaultLocalConfig$initConfig$2(this, null), r100);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r102;
    L11:
        this.f42666b = b();
    L13:
        return Unit.INSTANCE;
    }
}
