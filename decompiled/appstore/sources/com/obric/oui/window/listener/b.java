package com.obric.oui.window.listener;

import android.app.Application;
import android.content.res.Configuration;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.k0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import xd.f;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends k0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17655e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ConcurrentHashMap f17656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap f17657g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.obric.oui.window.listener.a f17658d;

    public static final class a {

        /* JADX INFO: renamed from: com.obric.oui.window.listener.b$a$a, reason: collision with other inner class name */
        public static final class C0211a implements LifecycleObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FragmentActivity f17659a;

            public C0211a(FragmentActivity r10) {
                this.f17659a = r10;
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            public final void onDestroy() {
                int r10 = this.f17659a.hashCode();
                if (b.f().containsKey(Integer.valueOf(r10)) == false) goto L6;
                b.f().remove(Integer.valueOf(r10));
                return;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ void a(a r10, FragmentActivity r11, Configuration r12, int r13, int r14, boolean r15) {
            r10.c(r11, r12, r13, r14, r15);
        }

        public static /* synthetic */ void d(a r10, FragmentActivity r11, Configuration r12, int r13, int r14, boolean r15, int r16, Object r17) {
            if ((r16 & 16) == 0) goto L5;
            r15 = false;
        L5:
            r10.c(r11, r12, r13, r14, r15);
        }

        public final com.obric.oui.window.listener.a b(LifecycleOwner r10) {
            q.g(r10, "lifecycleOwner");
            if ((r10 instanceof Fragment) == false) goto L12;
            FragmentActivity r11 = ((Fragment) r10).getActivity();
            if (r11 == null) goto L20;
            Application r12 = r11.getApplication();
            if (r12 == null) goto L21;
            k0 r13 = new ViewModelProvider((ViewModelStoreOwner) r10, ViewModelProvider.a.f(r12)).a(b.class);
            q.f(r13, "ViewModelProvider(\n     …angeListener::class.java]");
            return b.g((b) r13);
        L21:
            return null;
        L20:
            return null;
        L12:
            if ((r10 instanceof FragmentActivity) == false) goto L19;
            Application r14 = ((FragmentActivity) r10).getApplication();
            if (r14 == null) goto L22;
            k0 r15 = new ViewModelProvider((ViewModelStoreOwner) r10, ViewModelProvider.a.f(r14)).a(b.class);
            q.f(r15, "ViewModelProvider(\n     …angeListener::class.java]");
            return b.g((b) r15);
        L22:
            return null;
        L19:
            return null;
        }

        public final void c(FragmentActivity r10, Configuration r11, int r12, int r13, boolean r14) {
            int r15 = r10.hashCode();     // Catch: Exception -> L5
            if (b.f().containsKey(Integer.valueOf(r15)) == true) goto L7;
            r10.getLifecycle().a(new C0211a(r10));     // Catch: Exception -> L5
        L7:
            b.f().put(Integer.valueOf(r15), new Pair(r11, Integer.valueOf(r12)));     // Catch: Exception -> L5
        L10:
            ae.a r16 = ae.a.f85a;
            r16.h(r10, r12, r13, r14);
            if (r10 == null) goto L13;
            FragmentActivity r17 = r10;
        L14:
            if (r17 == null) goto L17;
            r16.a(r17, r12, r13);
        L17:
            r16.g();
            com.obric.oui.window.listener.a r18 = b.f17655e.b(r10);
            if (r18 == null) goto L21;
            r18.m(new f(r16.d(), r16.c()));
        L21:
            ConcurrentLinkedQueue r19 = (ConcurrentLinkedQueue) b.h().get(Integer.valueOf(r10.hashCode()));
            if (r19 == null) goto L34;
            Iterator r20 = r19.iterator();
        L26:
            if (r20.hasNext() == false) goto L34;
            Fragment r21 = (Fragment) ((WeakReference) r20.next()).get();
            if (r21 == null) goto L26;
            com.obric.oui.window.listener.a r22 = b.f17655e.b(r21);
            if (r22 == null) goto L26;
            r22.m(new f(r16.d(), r16.c()));
        L34:
            wd.a.f25402a.o(true);
            return;
        L13:
            r17 = null;
        L5:
            e = move-exception;
            Log.e("Window", q.p("setToConfig error:", e.getMessage()));
            goto L10
        }

        public a() {
        }
    }

    static {
        f17655e = new a(null);
        f17656f = new ConcurrentHashMap();
        f17657g = new ConcurrentHashMap();
    }

    public b() {
        this.f17658d = new com.obric.oui.window.listener.a();
    }

    public static final /* synthetic */ ConcurrentHashMap f() {
        return f17656f;
    }

    public static final /* synthetic */ com.obric.oui.window.listener.a g(b r10) {
        return r10.f17658d;
    }

    public static final /* synthetic */ ConcurrentHashMap h() {
        return f17657g;
    }
}
