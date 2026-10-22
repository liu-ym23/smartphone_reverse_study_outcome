package com.stepos.agentframework.display;

import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003/01B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0010\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u0019J%\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ#\u0010\u001f\u001a\u00020\u000e2\u0012\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00062"}, d2 = {"Lcom/stepos/agentframework/display/j;", "", "<init>", "()V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/View;)Ljava/lang/AutoCloseable;", "", "p", "(Landroid/view/View;)Z", "Lkotlin/Function0;", "LY8/t;", "listener", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/View;Lp9/a;)Ljava/lang/AutoCloseable;", Parameters.ROOT, "r", "(Landroid/view/View;)V", "o", "Lcom/stepos/agentframework/display/j$c;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/view/View;Lcom/stepos/agentframework/display/j$c;)V", "m", "t", "(Landroid/view/View;Lp9/a;)V", "", "listeners", "q", "(Ljava/util/List;)V", "", "TAG", "Ljava/lang/String;", "", "IDLE_GRACE_MS", "J", "lock", "Ljava/lang/Object;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Ljava/util/WeakHashMap;", "windows", "Ljava/util/WeakHashMap;", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class j {
    private static final long IDLE_GRACE_MS = 500;
    private static final String TAG = "OverlayWaitPowerMode";
    public static final j INSTANCE = new j();
    private static final Object lock = new Object();
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final WeakHashMap<View, c> windows = new WeakHashMap<>();

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\"\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00030\u00030\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/display/j$a;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroid/view/View;", Parameters.ROOT, "Lkotlin/Function0;", "LY8/t;", "listener", "<init>", "(Landroid/view/View;Lp9/a;)V", "close", "()V", "Lp9/a;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "rootRef", "Ljava/lang/ref/WeakReference;", "", AlipayXuiIsland.REASON_CLOSED, "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements AutoCloseable {
        private volatile boolean closed;
        private final InterfaceC5063a<t> listener;
        private final WeakReference<View> rootRef;

        public a(View root, InterfaceC5063a<t> listener) {
            p.i(root, "root");
            p.i(listener, "listener");
            this.listener = listener;
            this.rootRef = new WeakReference<>(root);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            View view = this.rootRef.get();
            if (view == null) {
                return;
            }
            j.INSTANCE.t(view, this.listener);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00030\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/display/j$b;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Landroid/view/View;", Parameters.ROOT, "<init>", "(Landroid/view/View;)V", "LY8/t;", "close", "()V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "rootRef", "Ljava/lang/ref/WeakReference;", "", AlipayXuiIsland.REASON_CLOSED, "Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements AutoCloseable {
        private volatile boolean closed;
        private final WeakReference<View> rootRef;

        public b(View root) {
            p.i(root, "root");
            this.rootRef = new WeakReference<>(root);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            View view = this.rootRef.get();
            if (view == null) {
                return;
            }
            j.INSTANCE.r(view);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/display/j$c;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "count", "I", Const.INTENT_KEY_PKGNAME, "()I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)V", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "drawListener", "Landroid/view/ViewTreeObserver$OnDrawListener;", "c", "()Landroid/view/ViewTreeObserver$OnDrawListener;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/view/ViewTreeObserver$OnDrawListener;)V", "Ljava/lang/Runnable;", "idlePending", "Ljava/lang/Runnable;", Const.INTENT_KEY_UMID, "()Ljava/lang/Runnable;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/Runnable;)V", "", "f", "()Z", "isActive", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c {
        private int count;
        private ViewTreeObserver.OnDrawListener drawListener;
        private Runnable idlePending;
        private final CopyOnWriteArrayList<InterfaceC5063a<t>> listeners = new CopyOnWriteArrayList<>();

        public final void a() {
            Runnable runnable = this.idlePending;
            if (runnable == null) {
                return;
            }
            this.idlePending = null;
            j.handler.removeCallbacks(runnable);
        }

        /* renamed from: b, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: c, reason: from getter */
        public final ViewTreeObserver.OnDrawListener getDrawListener() {
            return this.drawListener;
        }

        /* renamed from: d, reason: from getter */
        public final Runnable getIdlePending() {
            return this.idlePending;
        }

        public final CopyOnWriteArrayList<InterfaceC5063a<t>> e() {
            return this.listeners;
        }

        public final boolean f() {
            return this.count > 0 || this.idlePending != null;
        }

        public final void g(int i10) {
            this.count = i10;
        }

        public final void h(ViewTreeObserver.OnDrawListener onDrawListener) {
            this.drawListener = onDrawListener;
        }

        public final void i(Runnable runnable) {
            this.idlePending = runnable;
        }
    }

    public static final void k() {
        M6.c.INSTANCE.C();
    }

    public static final void l(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            view.getViewTreeObserver().addOnDrawListener(onDrawListener);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "addOnDrawListener failed", thE, false, 8, null);
        }
    }

    public static final void n(View view, ViewTreeObserver.OnDrawListener onDrawListener) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            view.getViewTreeObserver().removeOnDrawListener(onDrawListener);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "removeOnDrawListener failed", thE, false, 8, null);
        }
    }

    public static final void s(View view) {
        INSTANCE.o(view);
    }

    public final AutoCloseable h(View anchor) {
        List<? extends InterfaceC5063a<t>> listM1;
        p.i(anchor, "anchor");
        View rootView = anchor.getRootView();
        synchronized (lock) {
            try {
                WeakHashMap<View, c> weakHashMap = windows;
                c cVar = weakHashMap.get(rootView);
                if (cVar == null) {
                    cVar = new c();
                    weakHashMap.put(rootView, cVar);
                }
                c cVar2 = cVar;
                boolean zF = cVar2.f();
                boolean z10 = cVar2.getIdlePending() != null;
                cVar2.g(cVar2.getCount() + 1);
                cVar2.a();
                if (zF) {
                    if (z10) {
                        M6.c.INSTANCE.y();
                    }
                    M6.c.INSTANCE.w(cVar2.getCount());
                    listM1 = C1173v.m();
                } else {
                    M6.c cVar3 = M6.c.INSTANCE;
                    M6.c.B(cVar3, null, 1, null);
                    p.f(rootView);
                    Triple<DisplayWindowHost, Activity, Integer> tripleB = com.stepos.agentframework.display.a.b(rootView, anchor);
                    DisplayWindowHost displayWindowHostA = tripleB.a();
                    int iIntValue = tripleB.c().intValue();
                    String lowerCase = displayWindowHostA.name().toLowerCase(Locale.ROOT);
                    p.h(lowerCase, "toLowerCase(...)");
                    cVar3.D(lowerCase, iIntValue);
                    cVar3.E(rootView);
                    INSTANCE.j(rootView, cVar2);
                    listM1 = F.m1(cVar2.e());
                }
                C4148a.k(TAG, "acquire count=" + cVar2.getCount(), false, 4, null);
            } catch (Throwable th) {
                throw th;
            }
        }
        q(listM1);
        p.f(rootView);
        return new b(rootView);
    }

    public final AutoCloseable i(View anchor, InterfaceC5063a<t> listener) {
        p.i(anchor, "anchor");
        p.i(listener, "listener");
        View rootView = anchor.getRootView();
        synchronized (lock) {
            try {
                WeakHashMap<View, c> weakHashMap = windows;
                c cVar = weakHashMap.get(rootView);
                if (cVar == null) {
                    cVar = new c();
                    weakHashMap.put(rootView, cVar);
                }
                cVar.e().add(listener);
            } catch (Throwable th) {
                throw th;
            }
        }
        p.f(rootView);
        return new a(rootView, listener);
    }

    public final void j(final View root, c state) {
        if (state.getDrawListener() != null) {
            return;
        }
        final ViewTreeObserver.OnDrawListener onDrawListener = new ViewTreeObserver.OnDrawListener() { // from class: com.stepos.agentframework.display.f
            @Override // android.view.ViewTreeObserver.OnDrawListener
            public final void onDraw() {
                j.k();
            }
        };
        state.h(onDrawListener);
        handler.post(new Runnable() { // from class: com.stepos.agentframework.display.g
            @Override // java.lang.Runnable
            public final void run() {
                j.l(root, onDrawListener);
            }
        });
    }

    public final void m(final View root, c state) {
        final ViewTreeObserver.OnDrawListener drawListener = state.getDrawListener();
        if (drawListener == null) {
            return;
        }
        state.h(null);
        handler.post(new Runnable() { // from class: com.stepos.agentframework.display.i
            @Override // java.lang.Runnable
            public final void run() {
                j.n(root, drawListener);
            }
        });
    }

    public final void o(View root) {
        synchronized (lock) {
            try {
                WeakHashMap<View, c> weakHashMap = windows;
                c cVar = weakHashMap.get(root);
                if (cVar == null) {
                    return;
                }
                cVar.i(null);
                if (cVar.getCount() > 0) {
                    return;
                }
                M6.c.INSTANCE.x();
                INSTANCE.m(root, cVar);
                List<? extends InterfaceC5063a<t>> listM1 = F.m1(cVar.e());
                if (cVar.e().isEmpty()) {
                    weakHashMap.remove(root);
                }
                t tVar = t.f7040a;
                q(listM1);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean p(View anchor) {
        p.i(anchor, "anchor");
        boolean z10 = false;
        if (!anchor.isAttachedToWindow()) {
            return false;
        }
        View rootView = anchor.getRootView();
        synchronized (lock) {
            c cVar = windows.get(rootView);
            if (cVar != null) {
                if (cVar.f()) {
                    z10 = true;
                }
            }
        }
        return z10;
    }

    public final void q(List<? extends InterfaceC5063a<t>> listeners) {
        Object objB;
        for (InterfaceC5063a<t> interfaceC5063a : listeners) {
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.t(TAG, "wait-mode listener failed", thE, false, 8, null);
            }
        }
    }

    public final void r(final View root) {
        synchronized (lock) {
            c cVar = windows.get(root);
            if (cVar == null) {
                return;
            }
            if (cVar.getCount() <= 0) {
                return;
            }
            cVar.g(cVar.getCount() - 1);
            C4148a.k(TAG, "release count=" + cVar.getCount(), false, 4, null);
            if (cVar.getCount() > 0) {
                M6.c.INSTANCE.w(cVar.getCount());
                return;
            }
            M6.c.INSTANCE.z();
            Runnable runnable = new Runnable() { // from class: com.stepos.agentframework.display.h
                @Override // java.lang.Runnable
                public final void run() {
                    j.s(root);
                }
            };
            cVar.i(runnable);
            handler.postDelayed(runnable, 500L);
        }
    }

    public final void t(View root, InterfaceC5063a<t> listener) {
        synchronized (lock) {
            try {
                WeakHashMap<View, c> weakHashMap = windows;
                c cVar = weakHashMap.get(root);
                if (cVar == null) {
                    return;
                }
                cVar.e().remove(listener);
                if (!cVar.f() && cVar.e().isEmpty()) {
                    weakHashMap.remove(root);
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
