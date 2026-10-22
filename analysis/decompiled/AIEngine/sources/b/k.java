package b;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Trace;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.z0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e0;
import androidx.lifecycle.i0;
import androidx.lifecycle.m0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import com.stepos.aiengine.R;
import e.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import mb.y;
import v0.k;
import w1.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class k extends androidx.core.app.c implements t0, androidx.lifecycle.i, w1.d, s, d.g, androidx.core.content.c, androidx.core.content.d, androidx.core.app.j, androidx.core.app.k, v0.h {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final b Companion = new b();
    private s0 _viewModelStore;
    private final d.d activityResultRegistry;
    private int contentLayoutId;
    private final c.a contextAwareHelper;
    private final lb.d defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final lb.d fullyDrawnReporter$delegate;
    private final v0.k menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final lb.d onBackPressedDispatcher$delegate;
    private final CopyOnWriteArrayList<u0.a<Configuration>> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<u0.a<androidx.core.app.d>> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<u0.a<Intent>> onNewIntentListeners;
    private final CopyOnWriteArrayList<u0.a<androidx.core.app.m>> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<u0.a<Integer>> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final d reportFullyDrawnExecutor;
    private final w1.c savedStateRegistryController;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements androidx.lifecycle.o {
        public a() {
        }

        @Override // androidx.lifecycle.o
        public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
            k kVar = k.this;
            kVar.ensureViewModelStore();
            kVar.getLifecycle().c(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f3005a;

        /* renamed from: b, reason: collision with root package name */
        public s0 f3006b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d extends Executor {
        void a();

        void w(View view);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class e implements d, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final long f3007a = SystemClock.uptimeMillis() + 10000;

        /* renamed from: b, reason: collision with root package name */
        public Runnable f3008b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3009c;

        public e() {
        }

        @Override // b.k.d
        public final void a() {
            k kVar = k.this;
            kVar.getWindow().getDecorView().removeCallbacks(this);
            kVar.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            kotlin.jvm.internal.g.f(runnable, "runnable");
            this.f3008b = runnable;
            View decorView = k.this.getWindow().getDecorView();
            kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
            if (!this.f3009c) {
                decorView.postOnAnimation(new z0(this, 3));
            } else if (kotlin.jvm.internal.g.b(Looper.myLooper(), Looper.getMainLooper())) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.f3008b;
            if (runnable == null) {
                if (SystemClock.uptimeMillis() > this.f3007a) {
                    this.f3009c = false;
                    k.this.getWindow().getDecorView().post(this);
                    return;
                }
                return;
            }
            runnable.run();
            this.f3008b = null;
            o fullyDrawnReporter = k.this.getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3023b) {
                z = fullyDrawnReporter.f3024c;
            }
            if (z) {
                this.f3009c = false;
                k.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // b.k.d
        public final void w(View view) {
            if (this.f3009c) {
                return;
            }
            this.f3009c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class f extends d.d {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.d
        public final void b(int i10, e.a contract, Object obj) {
            Bundle bundleExtra;
            int i11;
            kotlin.jvm.internal.g.f(contract, "contract");
            k kVar = k.this;
            a.C0074a c0074aB = contract.b(kVar, obj);
            int i12 = 0;
            if (c0074aB != null) {
                new Handler(Looper.getMainLooper()).post(new l(i10, i12, this, c0074aB));
                return;
            }
            Intent intentA = contract.a(kVar, obj);
            if (intentA.getExtras() != null) {
                Bundle extras = intentA.getExtras();
                kotlin.jvm.internal.g.c(extras);
                if (extras.getClassLoader() == null) {
                    intentA.setExtrasClassLoader(kVar.getClassLoader());
                }
            }
            if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundleExtra = null;
            }
            Bundle bundle = bundleExtra;
            if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
                if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
                    kVar.startActivityForResult(intentA, i10, bundle);
                    return;
                }
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    kotlin.jvm.internal.g.c(intentSenderRequest);
                    i11 = i10;
                } catch (IntentSender.SendIntentException e10) {
                    e = e10;
                    i11 = i10;
                }
                try {
                    kVar.startIntentSenderForResult(intentSenderRequest.getIntentSender(), i11, intentSenderRequest.getFillInIntent(), intentSenderRequest.getFlagsMask(), intentSenderRequest.getFlagsValues(), 0, bundle);
                    lb.n nVar = lb.n.f10413a;
                    return;
                } catch (IntentSender.SendIntentException e11) {
                    e = e11;
                    new Handler(Looper.getMainLooper()).post(new m(this, i11, e));
                    return;
                }
            }
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i13 = 0; i13 < stringArrayExtra.length; i13++) {
                if (TextUtils.isEmpty(stringArrayExtra[i13])) {
                    throw new IllegalArgumentException(ai.onnxruntime.a.o(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i13], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i13));
                }
            }
            int size = hashSet.size();
            String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i14 = 0;
                while (i12 < stringArrayExtra.length) {
                    if (!hashSet.contains(Integer.valueOf(i12))) {
                        strArr[i14] = stringArrayExtra[i12];
                        i14++;
                    }
                    i12++;
                }
            }
            if (kVar instanceof androidx.core.app.a) {
                ((androidx.core.app.a) kVar).validateRequestPermissionsRequestCode(i10);
            }
            kVar.requestPermissions(stringArrayExtra, i10);
        }
    }

    public k() {
        this.contextAwareHelper = new c.a();
        this.menuHostHelper = new v0.k(new b.c(this, 0));
        x1.a aVar = new x1.a(this, new b6.g(this, 19));
        this.savedStateRegistryController = new w1.c(aVar);
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        final int i10 = 0;
        this.fullyDrawnReporter$delegate = kotlin.b.b(new zb.a(this) { // from class: b.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f2998b;

            {
                this.f2998b = this;
            }

            @Override // zb.a
            public final Object invoke() {
                int i11 = i10;
                k kVar = this.f2998b;
                switch (i11) {
                    case 0:
                        return k.fullyDrawnReporter_delegate$lambda$2(kVar);
                    default:
                        return k.onBackPressedDispatcher_delegate$lambda$13(kVar);
                }
            }
        });
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new f();
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new g(this, 0));
        getLifecycle().a(new androidx.lifecycle.o() { // from class: b.h
            @Override // androidx.lifecycle.o
            public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
                k._init_$lambda$5(this.f3001a, qVar, event);
            }
        });
        getLifecycle().a(new a());
        aVar.a();
        i0.b(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new b.InterfaceC0161b() { // from class: b.i
            @Override // w1.b.InterfaceC0161b
            public final Bundle a() {
                return k._init_$lambda$6(this.f3002a);
            }
        });
        addOnContextAvailableListener(new c.b() { // from class: b.j
            @Override // c.b
            public final void a(k kVar) {
                k._init_$lambda$7(this.f3003a, kVar);
            }
        });
        final int i11 = 1;
        this.defaultViewModelProviderFactory$delegate = kotlin.b.b(new b.e(this, i11));
        this.onBackPressedDispatcher$delegate = kotlin.b.b(new zb.a(this) { // from class: b.f

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f2998b;

            {
                this.f2998b = this;
            }

            @Override // zb.a
            public final Object invoke() {
                int i112 = i11;
                k kVar = this.f2998b;
                switch (i112) {
                    case 0:
                        return k.fullyDrawnReporter_delegate$lambda$2(kVar);
                    default:
                        return k.onBackPressedDispatcher_delegate$lambda$13(kVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(k kVar, androidx.lifecycle.q qVar, Lifecycle.Event event) {
        Window window;
        View viewPeekDecorView;
        kotlin.jvm.internal.g.f(qVar, "<unused var>");
        kotlin.jvm.internal.g.f(event, "event");
        if (event != Lifecycle.Event.ON_STOP || (window = kVar.getWindow()) == null || (viewPeekDecorView = window.peekDecorView()) == null) {
            return;
        }
        viewPeekDecorView.cancelPendingInputEvents();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(k kVar, androidx.lifecycle.q qVar, Lifecycle.Event event) {
        kotlin.jvm.internal.g.f(qVar, "<unused var>");
        kotlin.jvm.internal.g.f(event, "event");
        if (event == Lifecycle.Event.ON_DESTROY) {
            kVar.contextAwareHelper.f3242b = null;
            if (!kVar.isChangingConfigurations()) {
                kVar.getViewModelStore().a();
            }
            kVar.reportFullyDrawnExecutor.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle _init_$lambda$6(k kVar) {
        Bundle bundle = new Bundle();
        d.d dVar = kVar.activityResultRegistry;
        dVar.getClass();
        LinkedHashMap linkedHashMap = dVar.f8239b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(dVar.f8241d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(dVar.f8244g));
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$7(k kVar, Context it) {
        kotlin.jvm.internal.g.f(it, "it");
        Bundle bundleA = kVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            d.d dVar = kVar.activityResultRegistry;
            LinkedHashMap linkedHashMap = dVar.f8239b;
            LinkedHashMap linkedHashMap2 = dVar.f8238a;
            Bundle bundle = dVar.f8244g;
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList<String> stringArrayList2 = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                dVar.f8241d.addAll(stringArrayList2);
            }
            Bundle bundle2 = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            int size = stringArrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str = stringArrayList.get(i10);
                if (linkedHashMap.containsKey(str)) {
                    Integer num = (Integer) linkedHashMap.remove(str);
                    if (!bundle.containsKey(str)) {
                        kotlin.jvm.internal.k.b(linkedHashMap2).remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i10);
                kotlin.jvm.internal.g.e(num2, "get(...)");
                int iIntValue = num2.intValue();
                String str2 = stringArrayList.get(i10);
                kotlin.jvm.internal.g.e(str2, "get(...)");
                String str3 = str2;
                linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                dVar.f8239b.put(str3, Integer.valueOf(iIntValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addObserverForBackInvoker(final OnBackPressedDispatcher onBackPressedDispatcher) {
        getLifecycle().a(new androidx.lifecycle.o(this) { // from class: b.d

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ k f2994b;

            {
                this.f2994b = this;
            }

            @Override // androidx.lifecycle.o
            public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
                k.addObserverForBackInvoker$lambda$14(onBackPressedDispatcher, this.f2994b, qVar, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addObserverForBackInvoker$lambda$14(OnBackPressedDispatcher onBackPressedDispatcher, k activity, androidx.lifecycle.q qVar, Lifecycle.Event event) {
        kotlin.jvm.internal.g.f(qVar, "<unused var>");
        kotlin.jvm.internal.g.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            kotlin.jvm.internal.g.f(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            kotlin.jvm.internal.g.e(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackPressedDispatcher.f204e = onBackInvokedDispatcher;
            onBackPressedDispatcher.d(onBackPressedDispatcher.f206g);
        }
    }

    private final d createFullyDrawnExecutor() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m0 defaultViewModelProviderFactory_delegate$lambda$9(k kVar) {
        return new m0(kVar.getApplication(), kVar, kVar.getIntent() != null ? kVar.getIntent().getExtras() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureViewModelStore() {
        if (this._viewModelStore == null) {
            c cVar = (c) getLastNonConfigurationInstance();
            if (cVar != null) {
                this._viewModelStore = cVar.f3006b;
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new s0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o fullyDrawnReporter_delegate$lambda$2(k kVar) {
        return new o(kVar.reportFullyDrawnExecutor, new b.e(kVar, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final lb.n fullyDrawnReporter_delegate$lambda$2$lambda$1(k kVar) {
        kVar.reportFullyDrawn();
        return lb.n.f10413a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBackPressedDispatcher onBackPressedDispatcher_delegate$lambda$13(k kVar) {
        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new b.c(kVar, 1));
        if (Build.VERSION.SDK_INT >= 33) {
            if (!kotlin.jvm.internal.g.b(Looper.myLooper(), Looper.getMainLooper())) {
                new Handler(Looper.getMainLooper()).post(new androidx.room.o(1, kVar, onBackPressedDispatcher));
                return onBackPressedDispatcher;
            }
            kVar.addObserverForBackInvoker(onBackPressedDispatcher);
        }
        return onBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBackPressedDispatcher_delegate$lambda$13$lambda$10(k kVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e10) {
            if (!kotlin.jvm.internal.g.b(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e10;
            }
        } catch (NullPointerException e11) {
            if (!kotlin.jvm.internal.g.b(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e11;
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        d dVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        dVar.w(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // v0.h
    public void addMenuProvider(v0.l provider) {
        kotlin.jvm.internal.g.f(provider, "provider");
        v0.k kVar = this.menuHostHelper;
        kVar.f13295b.add(provider);
        kVar.f13294a.run();
    }

    @Override // androidx.core.content.c
    public final void addOnConfigurationChangedListener(u0.a<Configuration> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    public final void addOnContextAvailableListener(c.b listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        c.a aVar = this.contextAwareHelper;
        aVar.getClass();
        k kVar = aVar.f3242b;
        if (kVar != null) {
            listener.a(kVar);
        }
        aVar.f3241a.add(listener);
    }

    @Override // androidx.core.app.j
    public final void addOnMultiWindowModeChangedListener(u0.a<androidx.core.app.d> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    public final void addOnNewIntentListener(u0.a<Intent> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    @Override // androidx.core.app.k
    public final void addOnPictureInPictureModeChangedListener(u0.a<androidx.core.app.m> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    @Override // androidx.core.content.d
    public final void addOnTrimMemoryListener(u0.a<Integer> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    public final void addOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // d.g
    public final d.d getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.lifecycle.i
    public q1.a getDefaultViewModelCreationExtras() {
        q1.b bVar = new q1.b((Object) null);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = bVar.f11486a;
        if (application != null) {
            linkedHashMap.put(r0.a.f2305d, getApplication());
        }
        linkedHashMap.put(i0.f2273a, this);
        linkedHashMap.put(i0.f2274b, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(i0.f2275c, extras);
        }
        return bVar;
    }

    public r0.b getDefaultViewModelProviderFactory() {
        return (r0.b) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public o getFullyDrawnReporter() {
        return (o) this.fullyDrawnReporter$delegate.getValue();
    }

    public Object getLastCustomNonConfigurationInstance() {
        c cVar = (c) getLastNonConfigurationInstance();
        if (cVar != null) {
            return cVar.f3005a;
        }
        return null;
    }

    @Override // androidx.core.app.c, androidx.lifecycle.q
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // b.s
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // w1.d
    public final w1.b getSavedStateRegistry() {
        return this.savedStateRegistryController.f13554b;
    }

    @Override // androidx.lifecycle.t0
    public s0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        s0 s0Var = this._viewModelStore;
        kotlin.jvm.internal.g.c(s0Var);
        return s0Var;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        a4.a.u(decorView, this);
        View decorView2 = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView3, "getDecorView(...)");
        y.L(decorView3, this);
        View decorView4 = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (this.activityResultRegistry.a(i10, i11, intent)) {
            return;
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        getOnBackPressedDispatcher().c();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator<u0.a<Configuration>> it = this.onConfigurationChangedListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(newConfig);
        }
    }

    @Override // androidx.core.app.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.a(bundle);
        c.a aVar = this.contextAwareHelper;
        aVar.getClass();
        aVar.f3242b = this;
        Iterator it = aVar.f3241a.iterator();
        while (it.hasNext()) {
            ((c.b) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i10 = e0.f2264a;
        e0.a.b(this);
        int i11 = this.contentLayoutId;
        if (i11 != 0) {
            setContentView(i11);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i10, Menu menu) {
        kotlin.jvm.internal.g.f(menu, "menu");
        if (i10 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i10, menu);
        v0.k kVar = this.menuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator<v0.l> it = kVar.f13295b.iterator();
        while (it.hasNext()) {
            it.next().d(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i10, MenuItem item) {
        kotlin.jvm.internal.g.f(item, "item");
        if (super.onMenuItemSelected(i10, item)) {
            return true;
        }
        if (i10 == 0) {
            Iterator<v0.l> it = this.menuHostHelper.f13295b.iterator();
            while (it.hasNext()) {
                if (it.next().c(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<u0.a<androidx.core.app.d>> it = this.onMultiWindowModeChangedListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.d(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.g.f(intent, "intent");
        super.onNewIntent(intent);
        Iterator<u0.a<Intent>> it = this.onNewIntentListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        kotlin.jvm.internal.g.f(menu, "menu");
        Iterator<v0.l> it = this.menuHostHelper.f13295b.iterator();
        while (it.hasNext()) {
            it.next().a(menu);
        }
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<u0.a<androidx.core.app.m>> it = this.onPictureInPictureModeChangedListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.m(z));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i10, View view, Menu menu) {
        kotlin.jvm.internal.g.f(menu, "menu");
        if (i10 != 0) {
            return true;
        }
        super.onPreparePanel(i10, view, menu);
        Iterator<v0.l> it = this.menuHostHelper.f13295b.iterator();
        while (it.hasNext()) {
            it.next().b(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        kotlin.jvm.internal.g.f(permissions, "permissions");
        kotlin.jvm.internal.g.f(grantResults, "grantResults");
        if (this.activityResultRegistry.a(i10, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            return;
        }
        super.onRequestPermissionsResult(i10, permissions, grantResults);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        c cVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        s0 s0Var = this._viewModelStore;
        if (s0Var == null && (cVar = (c) getLastNonConfigurationInstance()) != null) {
            s0Var = cVar.f3006b;
        }
        if (s0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        c cVar2 = new c();
        cVar2.f3005a = objOnRetainCustomNonConfigurationInstance;
        cVar2.f3006b = s0Var;
        return cVar2;
    }

    @Override // androidx.core.app.c, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.g.f(outState, "outState");
        if (getLifecycle() instanceof androidx.lifecycle.s) {
            Lifecycle lifecycle = getLifecycle();
            kotlin.jvm.internal.g.d(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            ((androidx.lifecycle.s) lifecycle).h(Lifecycle.State.f2216c);
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.b(outState);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        Iterator<u0.a<Integer>> it = this.onTrimMemoryListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i10));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        kotlin.jvm.internal.g.e(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.f3242b;
    }

    public final <I, O> d.b<I> registerForActivityResult(e.a<I, O> contract, d.d registry, d.a<O> callback) {
        kotlin.jvm.internal.g.f(contract, "contract");
        kotlin.jvm.internal.g.f(registry, "registry");
        kotlin.jvm.internal.g.f(callback, "callback");
        return registry.c("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, contract, callback);
    }

    @Override // v0.h
    public void removeMenuProvider(v0.l provider) {
        kotlin.jvm.internal.g.f(provider, "provider");
        this.menuHostHelper.a(provider);
    }

    @Override // androidx.core.content.c
    public final void removeOnConfigurationChangedListener(u0.a<Configuration> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    public final void removeOnContextAvailableListener(c.b listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        c.a aVar = this.contextAwareHelper;
        aVar.getClass();
        aVar.f3241a.remove(listener);
    }

    @Override // androidx.core.app.j
    public final void removeOnMultiWindowModeChangedListener(u0.a<androidx.core.app.d> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    public final void removeOnNewIntentListener(u0.a<Intent> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    @Override // androidx.core.app.k
    public final void removeOnPictureInPictureModeChangedListener(u0.a<androidx.core.app.m> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    @Override // androidx.core.content.d
    public final void removeOnTrimMemoryListener(u0.a<Integer> listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    public final void removeOnUserLeaveHintListener(Runnable listener) {
        kotlin.jvm.internal.g.f(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (c2.b.a()) {
                Trace.beginSection(c2.a.a("reportFullyDrawn() for ComponentActivity"));
            }
            super.reportFullyDrawn();
            o fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.f3023b) {
                try {
                    fullyDrawnReporter.f3024c = true;
                    ArrayList arrayList = fullyDrawnReporter.f3025d;
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj = arrayList.get(i10);
                        i10++;
                        ((zb.a) obj).invoke();
                    }
                    fullyDrawnReporter.f3025d.clear();
                    lb.n nVar = lb.n.f10413a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i10) {
        initializeViewTreeOwners();
        d dVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        dVar.w(decorView);
        super.setContentView(i10);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10) {
        kotlin.jvm.internal.g.f(intent, "intent");
        super.startActivityForResult(intent, i10);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i10, Intent intent2, int i11, int i12, int i13) throws IntentSender.SendIntentException {
        kotlin.jvm.internal.g.f(intent, "intent");
        super.startIntentSenderForResult(intent, i10, intent2, i11, i12, i13);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i10, Bundle bundle) {
        kotlin.jvm.internal.g.f(intent, "intent");
        super.startActivityForResult(intent, i10, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intent, int i10, Intent intent2, int i11, int i12, int i13, Bundle bundle) throws IntentSender.SendIntentException {
        kotlin.jvm.internal.g.f(intent, "intent");
        super.startIntentSenderForResult(intent, i10, intent2, i11, i12, i13, bundle);
    }

    public final <I, O> d.b<I> registerForActivityResult(e.a<I, O> contract, d.a<O> callback) {
        kotlin.jvm.internal.g.f(contract, "contract");
        kotlin.jvm.internal.g.f(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, newConfig);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<u0.a<androidx.core.app.d>> it = this.onMultiWindowModeChangedListeners.iterator();
            kotlin.jvm.internal.g.e(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.d(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration newConfig) {
        kotlin.jvm.internal.g.f(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, newConfig);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<u0.a<androidx.core.app.m>> it = this.onPictureInPictureModeChangedListeners.iterator();
            kotlin.jvm.internal.g.e(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.m(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        d dVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        dVar.w(decorView);
        super.setContentView(view);
    }

    public void addMenuProvider(final v0.l provider, androidx.lifecycle.q owner) {
        kotlin.jvm.internal.g.f(provider, "provider");
        kotlin.jvm.internal.g.f(owner, "owner");
        final v0.k kVar = this.menuHostHelper;
        kVar.f13295b.add(provider);
        kVar.f13294a.run();
        Lifecycle lifecycle = owner.getLifecycle();
        HashMap map = kVar.f13296c;
        k.a aVar = (k.a) map.remove(provider);
        if (aVar != null) {
            aVar.f13297a.c(aVar.f13298b);
            aVar.f13298b = null;
        }
        map.put(provider, new k.a(lifecycle, new androidx.lifecycle.o() { // from class: v0.j
            @Override // androidx.lifecycle.o
            public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
                k kVar2 = kVar;
                kVar2.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    kVar2.a(provider);
                }
            }
        }));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        d dVar = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        dVar.w(decorView);
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final v0.l provider, androidx.lifecycle.q owner, final Lifecycle.State state) {
        kotlin.jvm.internal.g.f(provider, "provider");
        kotlin.jvm.internal.g.f(owner, "owner");
        kotlin.jvm.internal.g.f(state, "state");
        final v0.k kVar = this.menuHostHelper;
        kVar.getClass();
        Lifecycle lifecycle = owner.getLifecycle();
        HashMap map = kVar.f13296c;
        k.a aVar = (k.a) map.remove(provider);
        if (aVar != null) {
            aVar.f13297a.c(aVar.f13298b);
            aVar.f13298b = null;
        }
        map.put(provider, new k.a(lifecycle, new androidx.lifecycle.o() { // from class: v0.i
            @Override // androidx.lifecycle.o
            public final void a(androidx.lifecycle.q qVar, Lifecycle.Event event) {
                k kVar2 = kVar;
                kVar2.getClass();
                Runnable runnable = kVar2.f13294a;
                CopyOnWriteArrayList<l> copyOnWriteArrayList = kVar2.f13295b;
                Lifecycle.Event.Companion.getClass();
                Lifecycle.State state2 = state;
                int iOrdinal = state2.ordinal();
                Lifecycle.Event event2 = iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? null : Lifecycle.Event.ON_RESUME : Lifecycle.Event.ON_START : Lifecycle.Event.ON_CREATE;
                l lVar = provider;
                if (event == event2) {
                    copyOnWriteArrayList.add(lVar);
                    runnable.run();
                } else if (event == Lifecycle.Event.ON_DESTROY) {
                    kVar2.a(lVar);
                } else if (event == Lifecycle.Event.a.a(state2)) {
                    copyOnWriteArrayList.remove(lVar);
                    runnable.run();
                }
            }
        }));
    }

    public static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private static /* synthetic */ void getSavedStateRegistryController$annotations() {
    }

    public k(int i10) {
        this();
        this.contentLayoutId = i10;
    }
}
