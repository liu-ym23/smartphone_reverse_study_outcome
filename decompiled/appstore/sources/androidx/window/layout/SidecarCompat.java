package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f5268f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarInterface f5269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SidecarAdapter f5270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f5271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f5272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ExtensionInterfaceCompat.ExtensionCallbackInterface f5273e;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "callbackInterface", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "a", "Landroidx/window/layout/SidecarAdapter;", "b", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "d", "Landroidx/window/sidecar/SidecarDeviceState;", "lastDeviceState", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarAdapter f5274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SidecarInterface.SidecarCallback f5275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ReentrantLock f5276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SidecarDeviceState f5277d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WeakHashMap f5278e;

        public DistinctSidecarElementCallback(SidecarAdapter r10, SidecarInterface.SidecarCallback r11) {
            q.g(r10, "sidecarAdapter");
            q.g(r11, "callbackInterface");
            this.f5274a = r10;
            this.f5275b = r11;
            this.f5276c = new ReentrantLock();
            this.f5278e = new WeakHashMap();
        }

        public void onDeviceStateChanged(@NotNull SidecarDeviceState r10) {
            q.g(r10, "newDeviceState");
            ReentrantLock r11 = this.f5276c;
            r11.lock();
        L10:
            th = move-exception;
            r11.unlock();
            throw th;
        L4:
            if (this.f5274a.a(this.f5277d, r10) == false) goto L7;
            r11.unlock();
            return;
        L7:
            this.f5277d = r10;     // Catch: Throwable -> L10
            this.f5275b.onDeviceStateChanged(r10);     // Catch: Throwable -> L10
            Unit r12 = Unit.f21064a;     // Catch: Throwable -> L10
            r11.unlock();
        }

        public void onWindowLayoutChanged(@NotNull IBinder r10, @NotNull SidecarWindowLayoutInfo r11) {
            q.g(r10, "token");
            q.g(r11, "newLayout");
            ReentrantLock r12 = this.f5276c;
            monitor-enter(r12);
            SidecarWindowLayoutInfo r13 = (SidecarWindowLayoutInfo) this.f5278e.get(r10);     // Catch: Throwable -> L12
            if (this.f5274a.d(r13, r11) == false) goto L8;
            monitor-exit(r12);
            return;
        L8:
            SidecarWindowLayoutInfo r14 = (SidecarWindowLayoutInfo) this.f5278e.put(r10, r11);     // Catch: Throwable -> L12
            monitor-exit(r12);
            this.f5275b.onWindowLayoutChanged(r10, r11);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidecarCompat f5279a;

        public TranslatingCallback(SidecarCompat r10) {
            q.g(r10, "this$0");
            this.f5279a = r10;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(@NotNull SidecarDeviceState r10) {
            q.g(r10, "newDeviceState");
            Collection r11 = SidecarCompat.c(this.f5279a).values();
            SidecarCompat r12 = this.f5279a;
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L16;
            Activity r14 = (Activity) r13.next();
            IBinder r15 = SidecarCompat.f5268f.a(r14);
            SidecarWindowLayoutInfo r16 = null;
            if (r15 == null) goto L12;
            SidecarInterface r17 = r12.d();
            if (r17 == null) goto L12;
            r16 = r17.getWindowLayoutInfo(r15);
        L12:
            ExtensionInterfaceCompat.ExtensionCallbackInterface r18 = SidecarCompat.a(r12);
            if (r18 == null) goto L4;
            r18.onWindowLayoutChanged(r14, SidecarCompat.b(r12).e(r16, r10));
            goto L4
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(@NotNull IBinder r10, @NotNull SidecarWindowLayoutInfo r11) {
            q.g(r10, "windowToken");
            q.g(r11, "newLayout");
            Activity r12 = (Activity) SidecarCompat.c(this.f5279a).get(r10);
            if (r12 != null) goto L6;
            Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
            return;
        L6:
            SidecarAdapter r13 = SidecarCompat.b(this.f5279a);
            SidecarInterface r14 = this.f5279a.d();
            if (r14 != null) goto L9;
            SidecarDeviceState r15 = null;
        L10:
            if (r15 != null) goto L12;
            r15 = new SidecarDeviceState();
        L12:
            i r16 = r13.e(r11, r15);
            ExtensionInterfaceCompat.ExtensionCallbackInterface r17 = SidecarCompat.a(this.f5279a);
            if (r17 == null) goto L17;
            r17.onWindowLayoutChanged(r12, r16);
            return;
        L17:
            return;
        L9:
            r15 = r14.getDeviceState();
            goto L10
        }
    }

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final IBinder a(Activity r10) {
            if (r10 == null) goto L13;
            Window r11 = r10.getWindow();
            if (r11 == null) goto L14;
            WindowManager.LayoutParams r12 = r11.getAttributes();
            if (r12 != null) goto L12;
            return null;
        L12:
            return r12.token;
        L14:
            return null;
        L13:
            return null;
        }

        public final SidecarInterface b(Context r10) {
            q.g(r10, "context");
            return SidecarProvider.getSidecarImpl(r10.getApplicationContext());
        }

        public final Version c() {
            String r10 = SidecarProvider.getApiVersion();     // Catch: Throwable -> L7
            if (TextUtils.isEmpty(r10) == true) goto L10;
            return Version.f5223f.b(r10);
        L10:
            return null;
        L11:
            return null;
        }

        public a() {
        }
    }

    public static final class b implements ExtensionInterfaceCompat.ExtensionCallbackInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExtensionInterfaceCompat.ExtensionCallbackInterface f5280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f5281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakHashMap f5282c;

        public b(ExtensionInterfaceCompat.ExtensionCallbackInterface r10) {
            q.g(r10, "callbackInterface");
            this.f5280a = r10;
            this.f5281b = new ReentrantLock();
            this.f5282c = new WeakHashMap();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity r10, i r11) {
            q.g(r10, "activity");
            q.g(r11, "newLayout");
            ReentrantLock r12 = this.f5281b;
            r12.lock();
        L10:
            th = move-exception;
            r12.unlock();
            throw th;
        L4:
            if (q.b(r11, (i) this.f5282c.get(r10)) == false) goto L7;
            r12.unlock();
            return;
        L7:
            i r13 = (i) this.f5282c.put(r10, r11);     // Catch: Throwable -> L10
            r12.unlock();
            this.f5280a.onWindowLayoutChanged(r10, r11);
        }
    }

    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarCompat f5283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference f5284b;

        public c(SidecarCompat r10, Activity r11) {
            q.g(r10, "sidecarCompat");
            q.g(r11, "activity");
            this.f5283a = r10;
            this.f5284b = new WeakReference(r11);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
            q.g(r10, "view");
            r10.removeOnAttachStateChangeListener(this);
            Activity r11 = (Activity) this.f5284b.get();
            IBinder r12 = SidecarCompat.f5268f.a(r11);
            if (r11 != null) goto L5;
            return;
        L5:
            if (r12 != null) goto L7;
            return;
        L7:
            this.f5283a.f(r12, r11);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            q.g(r10, "view");
        }
    }

    public static final class d implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidecarCompat f5285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5286b;

        public d(SidecarCompat r10, Activity r11) {
            this.f5285a = r10;
            this.f5286b = r11;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r10) {
            q.g(r10, "newConfig");
            ExtensionInterfaceCompat.ExtensionCallbackInterface r11 = SidecarCompat.a(this.f5285a);
            if (r11 == null) goto L7;
            Activity r12 = this.f5286b;
            r11.onWindowLayoutChanged(r12, this.f5285a.e(r12));
            return;
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    static {
        f5268f = new a(null);
    }

    public SidecarCompat(SidecarInterface r10, SidecarAdapter r11) {
        q.g(r11, "sidecarAdapter");
        this.f5269a = r10;
        this.f5270b = r11;
        this.f5271c = new LinkedHashMap();
        this.f5272d = new LinkedHashMap();
    }

    public static final /* synthetic */ ExtensionInterfaceCompat.ExtensionCallbackInterface a(SidecarCompat r10) {
        return r10.f5273e;
    }

    public static final /* synthetic */ SidecarAdapter b(SidecarCompat r10) {
        return r10.f5270b;
    }

    public static final /* synthetic */ Map c(SidecarCompat r10) {
        return r10.f5271c;
    }

    public final SidecarInterface d() {
        return this.f5269a;
    }

    public final i e(Activity r10) {
        q.g(r10, "activity");
        IBinder r11 = f5268f.a(r10);
        if (r11 == null) goto L5;
        SidecarInterface r12 = this.f5269a;
        SidecarDeviceState r13 = null;
        if (r12 != null) goto L9;
        SidecarWindowLayoutInfo r14 = null;
    L10:
        SidecarAdapter r15 = this.f5270b;
        SidecarInterface r16 = this.f5269a;
        if (r16 == null) goto L14;
        r13 = r16.getDeviceState();
    L14:
        if (r13 != null) goto L17;
        r13 = new SidecarDeviceState();
    L17:
        return r15.e(r14, r13);
    L9:
        r14 = r12.getWindowLayoutInfo(r11);
        goto L10
    L5:
        return new i(t.i());
    }

    public final void f(IBinder r10, Activity r11) {
        q.g(r10, "windowToken");
        q.g(r11, "activity");
        this.f5271c.put(r10, r11);
        SidecarInterface r12 = this.f5269a;
        if (r12 == null) goto L7;
        r12.onWindowLayoutChangeListenerAdded(r10);
    L7:
        if (this.f5271c.size() != 1) goto L12;
        SidecarInterface r13 = this.f5269a;
        if (r13 == null) goto L12;
        r13.onDeviceStateListenersChanged(false);
    L12:
        ExtensionInterfaceCompat.ExtensionCallbackInterface r14 = this.f5273e;
        if (r14 == null) goto L16;
        r14.onWindowLayoutChanged(r11, e(r11));
    L16:
        g(r11);
    }

    public final void g(Activity r10) {
        if (this.f5272d.get(r10) != null) goto L6;
        d r11 = new d(this, r10);
        this.f5272d.put(r10, r11);
        r10.registerComponentCallbacks(r11);
        return;
    }

    public final void h(Activity r10) {
        r10.unregisterComponentCallbacks((ComponentCallbacks) this.f5272d.get(r10));
        this.f5272d.remove(r10);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity r10) {
        q.g(r10, "activity");
        IBinder r11 = f5268f.a(r10);
        if (r11 == null) goto L5;
        f(r11, r10);
        return;
    L5:
        c r12 = new c(this, r10);
        r10.getWindow().getDecorView().addOnAttachStateChangeListener(r12);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity r10) {
        q.g(r10, "activity");
        IBinder r11 = f5268f.a(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        SidecarInterface r12 = this.f5269a;
        if (r12 == null) goto L9;
        r12.onWindowLayoutChangeListenerRemoved(r11);
    L9:
        h(r10);
        if (this.f5271c.size() != 1) goto L12;
        boolean r13 = true;
    L13:
        this.f5271c.remove(r11);
        if (r13 == false) goto L20;
        SidecarInterface r14 = this.f5269a;
        if (r14 == null) goto L21;
        r14.onDeviceStateListenersChanged(true);
        return;
    L21:
        return;
    L20:
        return;
    L12:
        r13 = false;
        goto L13
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface r10) {
        q.g(r10, "extensionCallback");
        this.f5273e = new b(r10);
        SidecarInterface r11 = this.f5269a;
        if (r11 == null) goto L7;
        r11.setSidecarCallback(new DistinctSidecarElementCallback(this.f5270b, new TranslatingCallback(this)));
        return;
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public boolean validateExtensionInterface() {
        SidecarInterface r10 = this.f5269a;     // Catch: Throwable -> L91
        if (r10 != null) goto L5;
    L4:
        Method r11 = null;
    L9:
        if (r11 != null) goto L11;
        Class<?> r12 = null;
    L12:
        Class r13 = Void.TYPE;     // Catch: Throwable -> L91
        if (q.b(r12, r13) == false) goto L90;
        SidecarInterface r14 = this.f5269a;     // Catch: Throwable -> L91
        if (r14 == null) goto L18;
        r14.getDeviceState();     // Catch: Throwable -> L91
    L18:
        SidecarInterface r15 = this.f5269a;     // Catch: Throwable -> L91
        if (r15 == null) goto L22;
        r15.onDeviceStateListenersChanged(true);     // Catch: Throwable -> L91
    L22:
        SidecarInterface r16 = this.f5269a;     // Catch: Throwable -> L91
        if (r16 != null) goto L26;
    L25:
        Method r17 = null;
    L30:
        if (r17 != null) goto L32;
        Class<?> r18 = null;
    L34:
        if (q.b(r18, SidecarWindowLayoutInfo.class) == false) goto L88;
        SidecarInterface r19 = this.f5269a;     // Catch: Throwable -> L91
        if (r19 != null) goto L38;
    L37:
        Method r20 = null;
    L42:
        if (r20 != null) goto L44;
        Class<?> r21 = null;
    L46:
        if (q.b(r21, r13) == false) goto L86;
        SidecarInterface r22 = this.f5269a;     // Catch: Throwable -> L91
        if (r22 != null) goto L50;
    L49:
        Method r23 = null;
    L54:
        if (r23 != null) goto L56;
        Class<?> r24 = null;
    L58:
        if (q.b(r24, r13) == false) goto L84;
        SidecarDeviceState r25 = new SidecarDeviceState();     // Catch: Throwable -> L91
        r25.posture = 3;     // Catch: NoSuchFieldError -> L63 Throwable -> L91
    L67:
        SidecarDisplayFeature r26 = new SidecarDisplayFeature();     // Catch: Throwable -> L91
        Rect r27 = r26.getRect();     // Catch: Throwable -> L91
        q.f(r27, "displayFeature.rect");     // Catch: Throwable -> L91
        r26.setRect(r27);     // Catch: Throwable -> L91
        r26.getType();     // Catch: Throwable -> L91
        r26.setType(1);     // Catch: Throwable -> L91
        SidecarWindowLayoutInfo r28 = new SidecarWindowLayoutInfo();     // Catch: Throwable -> L91
        List r29 = r28.displayFeatures;     // Catch: NoSuchFieldError -> L70 Throwable -> L91
    L99:
        return true;
    L70:
        ArrayList r30 = new ArrayList();     // Catch: Throwable -> L91
        r30.add(r26);     // Catch: Throwable -> L91
        SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(r28, new Object[]{r30});     // Catch: Throwable -> L91
        Object r31 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(r28, null);     // Catch: Throwable -> L91
        if (r31 == null) goto L78;
        if (q.b(r30, (List) r31) == false) goto L76;
        return true;
    L76:
        throw new Exception("Invalid display feature getter/setter");     // Catch: Throwable -> L91
    L78:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L91
    L63:
        SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r25, new Object[]{3});     // Catch: Throwable -> L91
        Object r32 = SidecarDeviceState.class.getMethod("getPosture", null).invoke(r25, null);     // Catch: Throwable -> L91
        if (r32 == null) goto L82;
        if (((Integer) r32).intValue() == 3) goto L67;
        throw new Exception("Invalid device posture getter/setter");     // Catch: Throwable -> L91
    L82:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L91
    L84:
        throw new NoSuchMethodException(q.p("Illegal return type for 'onWindowLayoutChangeListenerRemoved': ", r24));     // Catch: Throwable -> L91
    L56:
        r24 = r23.getReturnType();     // Catch: Throwable -> L91
        goto L58
    L50:
        Class<?> r33 = r22.getClass();     // Catch: Throwable -> L91
        if (r33 == null) goto L49;
        r23 = r33.getMethod("onWindowLayoutChangeListenerRemoved", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L54
    L86:
        throw new NoSuchMethodException(q.p("Illegal return type for 'onWindowLayoutChangeListenerAdded': ", r21));     // Catch: Throwable -> L91
    L44:
        r21 = r20.getReturnType();     // Catch: Throwable -> L91
        goto L46
    L38:
        Class<?> r34 = r19.getClass();     // Catch: Throwable -> L91
        if (r34 == null) goto L37;
        r20 = r34.getMethod("onWindowLayoutChangeListenerAdded", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L42
    L88:
        throw new NoSuchMethodException(q.p("Illegal return type for 'getWindowLayoutInfo': ", r18));     // Catch: Throwable -> L91
    L32:
        r18 = r17.getReturnType();     // Catch: Throwable -> L91
        goto L34
    L26:
        Class<?> r35 = r16.getClass();     // Catch: Throwable -> L91
        if (r35 == null) goto L25;
        r17 = r35.getMethod("getWindowLayoutInfo", new Class[]{IBinder.class});     // Catch: Throwable -> L91
        goto L30
    L90:
        throw new NoSuchMethodException(q.p("Illegal return type for 'setSidecarCallback': ", r12));     // Catch: Throwable -> L91
    L11:
        r12 = r11.getReturnType();     // Catch: Throwable -> L91
        goto L12
    L5:
        Class<?> r36 = r10.getClass();     // Catch: Throwable -> L91
        if (r36 == null) goto L4;
        r11 = r36.getMethod("setSidecarCallback", new Class[]{SidecarInterface.SidecarCallback.class});     // Catch: Throwable -> L91
    L91:
        return false;
    }

    public SidecarCompat(Context r10) {
        q.g(r10, "context");
        this(f5268f.b(r10), new SidecarAdapter(null, 1, null));
    }
}
