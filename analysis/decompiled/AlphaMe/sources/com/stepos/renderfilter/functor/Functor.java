package com.stepos.renderfilter.functor;

import C2.a;
import K.C0073e;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.f;
import androidx.fragment.app.A;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.api.internal.p;
import com.stepos.renderfilter.RenderFilter;
import com.stepos.renderfilter.annotation.Keep;
import com.stepos.renderfilter.annotation.RenderThread;
import com.stepos.renderfilter.functor.Functor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import t2.C0933b;

/* loaded from: classes.dex */
public abstract class Functor {

    /* renamed from: c, reason: collision with root package name */
    public static final HashMap f12302c;

    /* renamed from: d, reason: collision with root package name */
    public static final Handler f12303d;

    /* renamed from: e, reason: collision with root package name */
    public static Method f12304e;

    /* renamed from: a, reason: collision with root package name */
    public Long f12305a;

    /* renamed from: b, reason: collision with root package name */
    public final C0933b f12306b;

    static {
        System.loadLibrary("renderfilter");
        f12302c = new HashMap();
        f12303d = new Handler(Looper.getMainLooper());
        native_init();
    }

    public Functor(p pVar) {
        RenderFilter.b().a();
        Long lA = a();
        this.f12305a = lA;
        this.f12306b = new C0933b(lA.longValue(), pVar);
        if (d()) {
            return;
        }
        throw new A("createFunctor failed, mNativePtr=" + this.f12305a, 6);
    }

    public static void c(WeakReference weakReference, long j4, a aVar) {
        Functor functor = weakReference == null ? null : (Functor) weakReference.get();
        if (functor == null) {
            synchronized (Functor.class) {
                functor = (Functor) f12302c.get(Long.valueOf(j4));
            }
            if (functor == null) {
                Log.e("RenderFilter", AbstractC0351g.n("functor recycled, skip, functor=", j4), new Exception());
                return;
            }
        }
        aVar.a(functor);
    }

    @Keep
    private static native void native_init();

    @RenderThread
    @Keep
    private static void onContextDestroyed(WeakReference<Functor> weakReference, long j4) {
        c(weakReference, j4, new C0073e(12));
    }

    @RenderThread
    @Keep
    private static void onDraw(WeakReference<Functor> weakReference, DrawGlInfo drawGlInfo, long j4) {
        c(weakReference, j4, new f(drawGlInfo));
    }

    @RenderThread
    @Keep
    public static void onInvoke(WeakReference<Functor> weakReference, final boolean z4, long j4) {
        c(weakReference, j4, new a() { // from class: t2.a
            @Override // C2.a
            public final void a(Functor functor) {
                functor.f12306b.j(z4);
            }
        });
    }

    @RenderThread
    @Keep
    private static void onSync(WeakReference<Functor> weakReference, long j4) {
        c(weakReference, j4, new C0073e(13));
    }

    public abstract Long a();

    public abstract void b();

    public final boolean d() {
        Long l4 = this.f12305a;
        return (l4 == null || l4.longValue() == 0) ? false : true;
    }
}
