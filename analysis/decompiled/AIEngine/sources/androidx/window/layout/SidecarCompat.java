package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.h;
import androidx.window.layout.j;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SidecarCompat implements androidx.window.layout.c {

    /* renamed from: a, reason: collision with root package name */
    public final SidecarInterface f2699a;

    /* renamed from: b, reason: collision with root package name */
    public final h f2700b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f2701c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f2702d;

    /* renamed from: e, reason: collision with root package name */
    public b f2703e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a, reason: collision with root package name */
        public final h f2704a;

        /* renamed from: b, reason: collision with root package name */
        public final SidecarInterface.SidecarCallback f2705b;

        /* renamed from: c, reason: collision with root package name */
        public final ReentrantLock f2706c;

        /* renamed from: d, reason: collision with root package name */
        public SidecarDeviceState f2707d;

        /* renamed from: e, reason: collision with root package name */
        public final WeakHashMap<IBinder, SidecarWindowLayoutInfo> f2708e;

        public DistinctSidecarElementCallback(h sidecarAdapter, SidecarInterface.SidecarCallback sidecarCallback) {
            kotlin.jvm.internal.g.f(sidecarAdapter, "sidecarAdapter");
            this.f2704a = sidecarAdapter;
            this.f2705b = sidecarCallback;
            this.f2706c = new ReentrantLock();
            this.f2708e = new WeakHashMap<>();
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
        
            if (androidx.window.layout.h.a.b(r2) == androidx.window.layout.h.a.b(r4)) goto L10;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState r4) {
            /*
                r3 = this;
                java.lang.String r0 = "newDeviceState"
                kotlin.jvm.internal.g.f(r4, r0)
                java.util.concurrent.locks.ReentrantLock r0 = r3.f2706c
                r0.lock()
                androidx.window.layout.h r1 = r3.f2704a     // Catch: java.lang.Throwable -> L36
                androidx.window.sidecar.SidecarDeviceState r2 = r3.f2707d     // Catch: java.lang.Throwable -> L36
                r1.getClass()     // Catch: java.lang.Throwable -> L36
                boolean r1 = kotlin.jvm.internal.g.b(r2, r4)     // Catch: java.lang.Throwable -> L36
                if (r1 == 0) goto L18
                goto L25
            L18:
                if (r2 != 0) goto L1b
                goto L29
            L1b:
                int r1 = androidx.window.layout.h.a.b(r2)     // Catch: java.lang.Throwable -> L36
                int r2 = androidx.window.layout.h.a.b(r4)     // Catch: java.lang.Throwable -> L36
                if (r1 != r2) goto L29
            L25:
                r0.unlock()
                return
            L29:
                r3.f2707d = r4     // Catch: java.lang.Throwable -> L36
                androidx.window.sidecar.SidecarInterface$SidecarCallback r3 = r3.f2705b     // Catch: java.lang.Throwable -> L36
                r3.onDeviceStateChanged(r4)     // Catch: java.lang.Throwable -> L36
                lb.n r3 = lb.n.f10413a     // Catch: java.lang.Throwable -> L36
                r0.unlock()
                return
            L36:
                r3 = move-exception
                r0.unlock()
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.DistinctSidecarElementCallback.onDeviceStateChanged(androidx.window.sidecar.SidecarDeviceState):void");
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            kotlin.jvm.internal.g.f(token, "token");
            kotlin.jvm.internal.g.f(newLayout, "newLayout");
            synchronized (this.f2706c) {
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = this.f2708e.get(token);
                this.f2704a.getClass();
                if (kotlin.jvm.internal.g.b(sidecarWindowLayoutInfo, newLayout) ? true : sidecarWindowLayoutInfo == null ? false : h.b(h.a.c(sidecarWindowLayoutInfo), h.a.c(newLayout))) {
                    return;
                }
                this.f2708e.put(token, newLayout);
                this.f2705b.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            Window window;
            WindowManager.LayoutParams attributes;
            SidecarInterface sidecarInterface;
            kotlin.jvm.internal.g.f(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = SidecarCompat.this.f2701c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : collectionValues) {
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
                if (iBinder != null && (sidecarInterface = sidecarCompat.f2699a) != null) {
                    windowLayoutInfo = sidecarInterface.getWindowLayoutInfo(iBinder);
                }
                b bVar = sidecarCompat.f2703e;
                if (bVar != null) {
                    bVar.a(activity, sidecarCompat.f2700b.c(windowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            kotlin.jvm.internal.g.f(windowToken, "windowToken");
            kotlin.jvm.internal.g.f(newLayout, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f2701c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarCompat sidecarCompat = SidecarCompat.this;
            h hVar = sidecarCompat.f2700b;
            SidecarInterface sidecarInterface = sidecarCompat.f2699a;
            SidecarDeviceState deviceState = sidecarInterface == null ? null : sidecarInterface.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            m mVarC = hVar.c(newLayout, deviceState);
            b bVar = SidecarCompat.this.f2703e;
            if (bVar == null) {
                return;
            }
            bVar.a(activity, mVarC);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static SidecarInterface a(Context context) {
            kotlin.jvm.internal.g.f(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public static Version b() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                Version version = Version.h;
                return Version.a.a(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final j.a f2710a;

        /* renamed from: b, reason: collision with root package name */
        public final ReentrantLock f2711b = new ReentrantLock();

        /* renamed from: c, reason: collision with root package name */
        public final WeakHashMap<Activity, m> f2712c = new WeakHashMap<>();

        public b(j.a aVar) {
            this.f2710a = aVar;
        }

        public final void a(Activity activity, m mVar) {
            WeakHashMap<Activity, m> weakHashMap = this.f2712c;
            kotlin.jvm.internal.g.f(activity, "activity");
            ReentrantLock reentrantLock = this.f2711b;
            reentrantLock.lock();
            try {
                if (mVar.equals(weakHashMap.get(activity))) {
                    return;
                }
                weakHashMap.put(activity, mVar);
                reentrantLock.unlock();
                Iterator<j.b> it = j.this.f2749b.iterator();
                while (it.hasNext()) {
                    j.b next = it.next();
                    if (next.f2751a.equals(activity)) {
                        next.f2753c = mVar;
                        next.f2752b.accept(mVar);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final SidecarCompat f2713a;

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<Activity> f2714b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            this.f2713a = sidecarCompat;
            this.f2714b = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            Window window;
            WindowManager.LayoutParams attributes;
            kotlin.jvm.internal.g.f(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.f2714b.get();
            IBinder iBinder = null;
            if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
                iBinder = attributes.token;
            }
            if (activity == null || iBinder == null) {
                return;
            }
            this.f2713a.d(iBinder, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            kotlin.jvm.internal.g.f(view, "view");
        }
    }

    public SidecarCompat(Context context) {
        kotlin.jvm.internal.g.f(context, "context");
        SidecarInterface sidecarInterfaceA = a.a(context);
        h hVar = new h(0);
        this.f2699a = sidecarInterfaceA;
        this.f2700b = hVar;
        this.f2701c = new LinkedHashMap();
        this.f2702d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.c
    public final void a(Activity activity) {
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        IBinder iBinder = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (iBinder != null) {
            d(iBinder, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // androidx.window.layout.c
    public final void b(Activity activity) {
        SidecarInterface sidecarInterface;
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        IBinder iBinder = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (iBinder == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f2699a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinder);
        }
        LinkedHashMap linkedHashMap = this.f2702d;
        activity.unregisterComponentCallbacks((ComponentCallbacks) linkedHashMap.get(activity));
        linkedHashMap.remove(activity);
        LinkedHashMap linkedHashMap2 = this.f2701c;
        boolean z = linkedHashMap2.size() == 1;
        linkedHashMap2.remove(iBinder);
        if (!z || (sidecarInterface = this.f2699a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final m c(Activity activity) {
        WindowManager.LayoutParams attributes;
        Window window = activity.getWindow();
        IBinder iBinder = (window == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (iBinder == null) {
            return new m(EmptyList.f10001a);
        }
        SidecarInterface sidecarInterface = this.f2699a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(iBinder);
        SidecarInterface sidecarInterface2 = this.f2699a;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return this.f2700b.c(windowLayoutInfo, deviceState);
    }

    public final void d(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        LinkedHashMap linkedHashMap = this.f2701c;
        linkedHashMap.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f2699a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (linkedHashMap.size() == 1 && (sidecarInterface = this.f2699a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b bVar = this.f2703e;
        if (bVar != null) {
            bVar.a(activity, c(activity));
        }
        LinkedHashMap linkedHashMap2 = this.f2702d;
        if (linkedHashMap2.get(activity) == null) {
            i iVar = new i(this, activity);
            linkedHashMap2.put(activity, iVar);
            activity.registerComponentCallbacks(iVar);
        }
    }

    public final void e(j.a aVar) {
        this.f2703e = new b(aVar);
        SidecarInterface sidecarInterface = this.f2699a;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.f2700b, new TranslatingCallback()));
    }

    @SuppressLint({"BanUncheckedReflection"})
    public final boolean f() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f2699a;
            Method method = (sidecarInterface == null || (cls = sidecarInterface.getClass()) == null) ? null : cls.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method == null ? null : method.getReturnType();
            Class cls5 = Void.TYPE;
            if (!kotlin.jvm.internal.g.b(returnType, cls5)) {
                throw new NoSuchMethodException(kotlin.jvm.internal.g.k(returnType, "Illegal return type for 'setSidecarCallback': "));
            }
            SidecarInterface sidecarInterface2 = this.f2699a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f2699a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f2699a;
            Method method2 = (sidecarInterface4 == null || (cls2 = sidecarInterface4.getClass()) == null) ? null : cls2.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 == null ? null : method2.getReturnType();
            if (!kotlin.jvm.internal.g.b(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException(kotlin.jvm.internal.g.k(returnType2, "Illegal return type for 'getWindowLayoutInfo': "));
            }
            SidecarInterface sidecarInterface5 = this.f2699a;
            Method method3 = (sidecarInterface5 == null || (cls3 = sidecarInterface5.getClass()) == null) ? null : cls3.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 == null ? null : method3.getReturnType();
            if (!kotlin.jvm.internal.g.b(returnType3, cls5)) {
                throw new NoSuchMethodException(kotlin.jvm.internal.g.k(returnType3, "Illegal return type for 'onWindowLayoutChangeListenerAdded': "));
            }
            SidecarInterface sidecarInterface6 = this.f2699a;
            Method method4 = (sidecarInterface6 == null || (cls4 = sidecarInterface6.getClass()) == null) ? null : cls4.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 == null ? null : method4.getReturnType();
            if (!kotlin.jvm.internal.g.b(returnType4, cls5)) {
                throw new NoSuchMethodException(kotlin.jvm.internal.g.k(returnType4, "Illegal return type for 'onWindowLayoutChangeListenerRemoved': "));
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", null).invoke(sidecarDeviceState, null);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            kotlin.jvm.internal.g.e(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", null).invoke(sidecarWindowLayoutInfo, null);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
                if (arrayList.equals((List) objInvoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }
}
