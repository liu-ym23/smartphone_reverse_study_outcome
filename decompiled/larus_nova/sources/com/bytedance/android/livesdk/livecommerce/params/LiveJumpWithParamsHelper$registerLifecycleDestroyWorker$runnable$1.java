package com.bytedance.android.livesdk.livecommerce.params;

import android.content.ComponentCallbacks2;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.plugin.e;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.WeakHashMap;
import kotlin.Unit;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f149781a;

    public LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1(Context r100) {
        this.f149781a = r100;
    }

    public final void a() {
        WeakHashMap<Context, Unit> r100 = a.f149784a;
        if (r100.containsKey(this.f149781a) == false) goto L5;
        return;
    L5:
        ComponentCallbacks2 r101 = e.getActivity(this.f149781a);
        if ((r101 instanceof LifecycleOwner) == true) goto L8;
        r101 = null;
    L8:
        LifecycleOwner r102 = (LifecycleOwner) r101;
        if (r102 != null) goto L11;
        r102 = ECQuickUtilKt.f45526b;
    L11:
        final Lifecycle r103 = r102.getLifecycle();
        r103.addObserver(new LiveJumpWithParamsHelper$registerLifecycleDestroyWorker$runnable$1$$special$$inlined$apply$lambda$1(r103, this));
        r100.put(this.f149781a, Unit.INSTANCE);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
