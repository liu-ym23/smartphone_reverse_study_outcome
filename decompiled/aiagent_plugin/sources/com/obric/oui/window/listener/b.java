package com.obric.oui.window.listener;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aj;
import androidx.lifecycle.ap;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.lifecycle.w;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.oui.window.a.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.b.h;
import d.m;
import d.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: WindowConfigChangeListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends aj {
    private static final String TAG = "Window";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36901a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, m<Configuration, Integer>> f36902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, ConcurrentLinkedQueue<WeakReference<Fragment>>> f36903d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.oui.window.listener.a<g> f36904b;

    /* JADX INFO: compiled from: WindowConfigChangeListener.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.listener.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WindowConfigChangeListener.kt */
        @f(b = "WindowConfigChangeListener.kt", c = {}, d = "invokeSuspend", e = "com.obric.oui.window.listener.WindowConfigChangeListener$Companion$removeObserverOnMainThread$1")
        static final class C1006a extends l implements d.h.a.m<am, d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f36905a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ p f36906b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ w<g> f36907c;

            C1006a(p r3, w<g> r4, d<? super C1006a> r5) {
                p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
                w<g> r7 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
                d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
                this.f36906b = r6;
                this.f36907c = r7;
                super(2, r8);
            }

            public final Object a(am r3, d<? super x> r4) {
                return ((C1006a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C1006a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d<x> create(Object r3, d<?> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                return (d) ZeusTransformUtils.preCheckCast(new C1006a(this.f36906b, this.f36907c, r5), d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f36905a != 0) goto L11;
                o.a(r2);
                com.obric.oui.window.listener.a<g> r3 = b.f36901a.a(this.f36906b);
                if (r3 == null) goto L9;
                r3.b(this.f36907c);
            L9:
                return x.f38692a;
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        private final boolean a() {
            return d.h.b.o.a(Looper.getMainLooper(), Looper.myLooper());
        }

        private final void b(w<g> r9, p r10) {
            w<? super g> r11 = (w) ZeusTransformUtils.wrapperContextForParams(r9, w.class, "com.obric.aiagent.plugin");
            p r12 = (p) ZeusTransformUtils.wrapperContextForParams(r10, p.class, "com.obric.aiagent.plugin");
            if (a() == false) goto L8;
            com.obric.oui.window.listener.a<g> r8 = a(r12);
            if (r8 == null) goto L11;
            r8.b(r11);
            return;
        L11:
            return;
        L8:
            i r13 = r12.getLifecycle();
            d.h.b.o.c(r13, "owner.lifecycle");
            kotlinx.coroutines.i.a((am) ZeusTransformUtils.preCheckCast(n.a(r13), am.class, "com.obric.aiagent.plugin"), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C1006a(r12, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        }

        public final com.obric.oui.window.listener.a<g> a(p r5) {
            p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r5, p.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "lifecycleOwner");
            if (ZeusTransformUtils.instanceOf(r4, Fragment.class) == false) goto L12;
            FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Fragment) ZeusTransformUtils.preCheckCast(r4, Fragment.class, "com.obric.aiagent.plugin")).getActivity(), "com.obric.aiagent.plugin"), FragmentActivity.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L20;
            Application r7 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L21;
            aj r8 = new androidx.lifecycle.am((ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin"), (androidx.lifecycle.am.b) ZeusTransformUtils.preCheckCast(androidx.lifecycle.am.a.a(r7), androidx.lifecycle.am.b.class, "com.obric.aiagent.plugin")).a(b.class);
            d.h.b.o.c(r8, "ViewModelProvider(\n     …angeListener::class.java]");
            return b.a((b) ZeusTransformUtils.preCheckCast(r8, b.class, "com.obric.aiagent.plugin"));
        L21:
            return null;
        L20:
            return null;
        L12:
            if (ZeusTransformUtils.instanceOf(r4, FragmentActivity.class) == false) goto L19;
            Application r9 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.aiagent.plugin")).getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");
            if (r9 == null) goto L22;
            aj r10 = new androidx.lifecycle.am((ap) ZeusTransformUtils.preCheckCast(r4, ap.class, "com.obric.aiagent.plugin"), (androidx.lifecycle.am.b) ZeusTransformUtils.preCheckCast(androidx.lifecycle.am.a.a(r9), androidx.lifecycle.am.b.class, "com.obric.aiagent.plugin")).a(b.class);
            d.h.b.o.c(r10, "ViewModelProvider(\n     …angeListener::class.java]");
            return b.a((b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin"));
        L22:
            return null;
        L19:
            return null;
        }

        public final void a(w<g> r3, p r4) {
            w<g> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            p r6 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L8;
            if (r5 == null) goto L8;
            b(r5, r6);
            return;
        L8:
            a(b.TAG, "cannot remove WindowConfigChangeListener:context or observer = nul");
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }
    }

    public b() {
        this.f36904b = new com.obric.oui.window.listener.a();
    }

    public static final /* synthetic */ com.obric.oui.window.listener.a a(b r0) {
        return r0.f36904b;
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return f36902c;
    }

    public static final /* synthetic */ ConcurrentHashMap c() {
        return f36903d;
    }

    static {
        f36901a = new a(null);
        f36902c = new ConcurrentHashMap();
        f36903d = new ConcurrentHashMap();
    }
}
