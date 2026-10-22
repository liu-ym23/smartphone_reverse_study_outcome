package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.xiaomi.mipush.sdk.MiPushClient;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 !2\u00020\u0001:\u0005!\"#$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0007\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0016J\u0016\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020 H\u0017R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/window/layout/SidecarCompat;", "Landroidx/window/layout/ExtensionInterfaceCompat;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "sidecar", "Landroidx/window/sidecar/SidecarInterface;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "(Landroidx/window/sidecar/SidecarInterface;Landroidx/window/layout/SidecarAdapter;)V", "componentCallbackMap", "", "Landroid/app/Activity;", "Landroid/content/ComponentCallbacks;", "extensionCallback", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "getSidecar", "()Landroidx/window/sidecar/SidecarInterface;", "windowListenerRegisteredContexts", "Landroid/os/IBinder;", "getWindowLayoutInfo", "Landroidx/window/layout/WindowLayoutInfo;", "activity", "onWindowLayoutChangeListenerAdded", "", "onWindowLayoutChangeListenerRemoved", MiPushClient.COMMAND_REGISTER, "windowToken", "registerConfigurationChangeListener", "setExtensionCallback", "unregisterComponentCallback", "validateExtensionInterface", "", "Companion", "DistinctElementCallback", "DistinctSidecarElementCallback", "FirstAttachAdapter", "TranslatingCallback", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = null;
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/window/layout/SidecarCompat$Companion;", "", "()V", "TAG", "", "sidecarVersion", "Landroidx/window/core/Version;", "getSidecarVersion", "()Landroidx/window/core/Version;", "getActivityWindowToken", "Landroid/os/IBinder;", "activity", "Landroid/app/Activity;", "getActivityWindowToken$window_release", "getSidecarCompat", "Landroidx/window/sidecar/SidecarInterface;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getSidecarCompat$window_release", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Version getSidecarVersion() {
            String r100 = SidecarProvider.getApiVersion();     // Catch: Throwable -> L7
            if (TextUtils.isEmpty(r100) == true) goto L10;
            return Version.Companion.parse(r100);
        L10:
            return null;
        L11:
            return null;
        }

        public final IBinder getActivityWindowToken$window_release(Activity r100) {
            if (r100 == null) goto L8;
            Window r101 = r100.getWindow();
            if (r101 == null) goto L8;
            WindowManager.LayoutParams r102 = r101.getAttributes();
            if (r102 == null) goto L8;
            return r102.token;
        L8:
            return null;
        }

        public final SidecarInterface getSidecarCompat$window_release(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return SidecarProvider.getSidecarImpl(r100.getApplicationContext());
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctElementCallback;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "callbackInterface", "(Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;)V", "activityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "Landroidx/window/layout/WindowLayoutInfo;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "onWindowLayoutChanged", "", "activity", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface r100) {
            Intrinsics.checkNotNullParameter(r100, "callbackInterface");
            this.callbackInterface = r100;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity r100, WindowLayoutInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "newLayout");
            ReentrantLock r102 = this.lock;
            r102.lock();
        L10:
            th = move-exception;
            r102.unlock();
            throw th;
        L4:
            if (Intrinsics.areEqual(r101, this.activityWindowLayoutInfo.get(r100)) == false) goto L7;
            r102.unlock();
            return;
        L7:
            WindowLayoutInfo r103 = this.activityWindowLayoutInfo.put(r100, r101);     // Catch: Throwable -> L10
            r102.unlock();
            this.callbackInterface.onWindowLayoutChanged(r100, r101);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "sidecarAdapter", "Landroidx/window/layout/SidecarAdapter;", "callbackInterface", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "lastDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "mActivityWindowLayoutInfo", "Ljava/util/WeakHashMap;", "Landroid/os/IBinder;", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "onDeviceStateChanged", "", "newDeviceState", "onWindowLayoutChanged", "token", "newLayout", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public void onDeviceStateChanged(SidecarDeviceState r100) {
            Intrinsics.checkNotNullParameter(r100, "newDeviceState");
            ReentrantLock r101 = this.lock;
            r101.lock();
        L10:
            th = move-exception;
            r101.unlock();
            throw th;
        L4:
            if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, r100) == false) goto L7;
            r101.unlock();
            return;
        L7:
            this.lastDeviceState = r100;     // Catch: Throwable -> L10
            this.callbackInterface.onDeviceStateChanged(r100);     // Catch: Throwable -> L10
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
            r101.unlock();
        }

        public DistinctSidecarElementCallback(SidecarAdapter r100, SidecarInterface.SidecarCallback r101) {
            Intrinsics.checkNotNullParameter(r100, "sidecarAdapter");
            Intrinsics.checkNotNullParameter(r101, "callbackInterface");
            this.sidecarAdapter = r100;
            this.callbackInterface = r101;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap();
        }

        public void onWindowLayoutChanged(IBinder r100, SidecarWindowLayoutInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "token");
            Intrinsics.checkNotNullParameter(r101, "newLayout");
            ReentrantLock r102 = this.lock;
            monitor-enter(r102);
            SidecarWindowLayoutInfo r103 = this.mActivityWindowLayoutInfo.get(r100);     // Catch: Throwable -> L12
            if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(r103, r101) == false) goto L8;
            monitor-exit(r102);
            return;
        L8:
            SidecarWindowLayoutInfo r104 = this.mActivityWindowLayoutInfo.put(r100, r101);     // Catch: Throwable -> L12
            monitor-exit(r102);
            this.callbackInterface.onWindowLayoutChanged(r100, r101);
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u00050\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/window/layout/SidecarCompat$FirstAttachAdapter;", "Landroid/view/View$OnAttachStateChangeListener;", "sidecarCompat", "Landroidx/window/layout/SidecarCompat;", "activity", "Landroid/app/Activity;", "(Landroidx/window/layout/SidecarCompat;Landroid/app/Activity;)V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "onViewAttachedToWindow", "", "view", "Landroid/view/View;", "onViewDetachedFromWindow", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            r100.removeOnAttachStateChangeListener(this);
            Activity r101 = this.activityWeakReference.get();
            IBinder r102 = SidecarCompat.Companion.getActivityWindowToken$window_release(r101);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r102 != null) goto L7;
            return;
        L7:
            this.sidecarCompat.register(r102, r101);
        }

        public FirstAttachAdapter(SidecarCompat r100, Activity r101) {
            Intrinsics.checkNotNullParameter(r100, "sidecarCompat");
            Intrinsics.checkNotNullParameter(r101, "activity");
            this.sidecarCompat = r100;
            this.activityWeakReference = new WeakReference(r101);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat r100) {
            this.this$0 = r100;
        }

        public void onDeviceStateChanged(SidecarDeviceState r100) {
            Intrinsics.checkNotNullParameter(r100, "newDeviceState");
            Collection r101 = SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).values();
            SidecarCompat r102 = this.this$0;
            Iterator r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L13;
            Activity r104 = (Activity) r103.next();
            IBinder r105 = SidecarCompat.Companion.getActivityWindowToken$window_release(r104);
            SidecarWindowLayoutInfo r106 = null;
            if (r105 == null) goto L10;
            SidecarInterface r107 = r102.getSidecar();
            if (r107 == null) goto L10;
            r106 = r107.getWindowLayoutInfo(r105);
        L10:
            ExtensionInterfaceCompat.ExtensionCallbackInterface r108 = SidecarCompat.access$getExtensionCallback$p(r102);
            if (r108 == null) goto L4;
            r108.onWindowLayoutChanged(r104, SidecarCompat.access$getSidecarAdapter$p(r102).translate(r106, r100));
            goto L4
        }

        public void onWindowLayoutChanged(IBinder r100, SidecarWindowLayoutInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "windowToken");
            Intrinsics.checkNotNullParameter(r101, "newLayout");
            Activity r102 = (Activity) SidecarCompat.access$getWindowListenerRegisteredContexts$p(this.this$0).get(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            SidecarAdapter r103 = SidecarCompat.access$getSidecarAdapter$p(this.this$0);
            SidecarInterface r104 = this.this$0.getSidecar();
            if (r104 == null) goto L9;
            SidecarDeviceState r105 = r104.getDeviceState();
            if (r105 == null) goto L9;
        L10:
            WindowLayoutInfo r106 = r103.translate(r101, r105);
            ExtensionInterfaceCompat.ExtensionCallbackInterface r107 = SidecarCompat.access$getExtensionCallback$p(this.this$0);
            if (r107 == null) goto L14;
            r107.onWindowLayoutChanged(r102, r106);
            return;
        L14:
            return;
        L9:
            r105 = new SidecarDeviceState();
            goto L10
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public boolean validateExtensionInterface() {
        SidecarInterface r100 = this.sidecar;     // Catch: Throwable -> L85
        Class<?> r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();     // Catch: Throwable -> L85
        if (r102 == null) goto L8;
        Method r103 = r102.getMethod("setSidecarCallback", new Class[]{SidecarInterface.SidecarCallback.class});     // Catch: Throwable -> L85
    L9:
        if (r103 == null) goto L11;
        Class<?> r104 = r103.getReturnType();     // Catch: Throwable -> L85
    L13:
        if (Intrinsics.areEqual(r104, Void.TYPE) == false) goto L83;
        SidecarInterface r105 = this.sidecar;     // Catch: Throwable -> L85
        if (r105 == null) goto L17;
        r105.getDeviceState();     // Catch: Throwable -> L85
    L17:
        SidecarInterface r106 = this.sidecar;     // Catch: Throwable -> L85
        if (r106 == null) goto L20;
        r106.onDeviceStateListenersChanged(true);     // Catch: Throwable -> L85
    L20:
        SidecarInterface r107 = this.sidecar;     // Catch: Throwable -> L85
        if (r107 == null) goto L25;
        Class<?> r108 = r107.getClass();     // Catch: Throwable -> L85
        if (r108 == null) goto L25;
        Method r109 = r108.getMethod("getWindowLayoutInfo", new Class[]{IBinder.class});     // Catch: Throwable -> L85
    L26:
        if (r109 == null) goto L28;
        Class<?> r110 = r109.getReturnType();     // Catch: Throwable -> L85
    L30:
        if (Intrinsics.areEqual(r110, SidecarWindowLayoutInfo.class) == false) goto L81;
        SidecarInterface r111 = this.sidecar;     // Catch: Throwable -> L85
        if (r111 == null) goto L36;
        Class<?> r112 = r111.getClass();     // Catch: Throwable -> L85
        if (r112 == null) goto L36;
        Method r113 = r112.getMethod("onWindowLayoutChangeListenerAdded", new Class[]{IBinder.class});     // Catch: Throwable -> L85
    L37:
        if (r113 == null) goto L39;
        Class<?> r114 = r113.getReturnType();     // Catch: Throwable -> L85
    L41:
        if (Intrinsics.areEqual(r114, Void.TYPE) == false) goto L79;
        SidecarInterface r115 = this.sidecar;     // Catch: Throwable -> L85
        if (r115 == null) goto L47;
        Class<?> r116 = r115.getClass();     // Catch: Throwable -> L85
        if (r116 == null) goto L47;
        Method r117 = r116.getMethod("onWindowLayoutChangeListenerRemoved", new Class[]{IBinder.class});     // Catch: Throwable -> L85
    L48:
        if (r117 == null) goto L51;
        r101 = r117.getReturnType();     // Catch: Throwable -> L85
    L51:
        if (Intrinsics.areEqual(r101, Void.TYPE) == false) goto L77;
        SidecarDeviceState r118 = new SidecarDeviceState();     // Catch: Throwable -> L85
        r118.posture = 3;     // Catch: NoSuchFieldError -> L56 Throwable -> L85
    L60:
        SidecarDisplayFeature r119 = new SidecarDisplayFeature();     // Catch: Throwable -> L85
        r119.setRect(r119.getRect());     // Catch: Throwable -> L85
        r119.getType();     // Catch: Throwable -> L85
        r119.setType(1);     // Catch: Throwable -> L85
        SidecarWindowLayoutInfo r120 = new SidecarWindowLayoutInfo();     // Catch: Throwable -> L85
        List r121 = r120.displayFeatures;     // Catch: NoSuchFieldError -> L63 Throwable -> L85
    L84:
        return true;
    L63:
        ArrayList r122 = new ArrayList();     // Catch: Throwable -> L85
        r122.add(r119);     // Catch: Throwable -> L85
        SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", new Class[]{List.class}).invoke(r120, new Object[]{r122});     // Catch: Throwable -> L85
        Object r123 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(r120, new Object[0]);     // Catch: Throwable -> L85
        if (r123 == null) goto L71;
        if (Intrinsics.areEqual(r122, (List) r123) == true) goto L84;
        throw new Exception("Invalid display feature getter/setter");     // Catch: Throwable -> L85
    L71:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");     // Catch: Throwable -> L85
    L56:
        SidecarDeviceState.class.getMethod("setPosture", new Class[]{Integer.TYPE}).invoke(r118, new Object[]{3});     // Catch: Throwable -> L85
        Object r124 = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(r118, new Object[0]);     // Catch: Throwable -> L85
        if (r124 == null) goto L75;
        if (((Integer) r124).intValue() == 3) goto L60;
        throw new Exception("Invalid device posture getter/setter");     // Catch: Throwable -> L85
    L75:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L85
    L77:
        throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + r101);     // Catch: Throwable -> L85
    L47:
        r117 = null;
        goto L48
    L79:
        throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + r114);     // Catch: Throwable -> L85
    L39:
        r114 = null;
    L36:
        r113 = null;
        goto L37
    L81:
        throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + r110);     // Catch: Throwable -> L85
    L28:
        r110 = null;
    L25:
        r109 = null;
        goto L26
    L83:
        throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + r104);     // Catch: Throwable -> L85
    L11:
        r104 = null;
    L8:
        r103 = null;
    L91:
        return false;
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public SidecarCompat(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(Companion.getSidecarCompat$window_release(r100), new SidecarAdapter(null, 1, null));
    }

    public static View INVOKEVIRTUAL_androidx_window_layout_SidecarCompat_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static final /* synthetic */ ExtensionInterfaceCompat.ExtensionCallbackInterface access$getExtensionCallback$p(SidecarCompat r100) {
        return r100.extensionCallback;
    }

    public static final /* synthetic */ SidecarAdapter access$getSidecarAdapter$p(SidecarCompat r100) {
        return r100.sidecarAdapter;
    }

    public static final /* synthetic */ Map access$getWindowListenerRegisteredContexts$p(SidecarCompat r100) {
        return r100.windowListenerRegisteredContexts;
    }

    private final void registerConfigurationChangeListener(final Activity r100) {
        if (this.componentCallbackMap.get(r100) != null) goto L6;
        ComponentCallbacks r101 = new SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1(this, r100);
        this.componentCallbackMap.put(r100, r101);
        r100.registerComponentCallbacks(r101);
        return;
    }

    private final void unregisterComponentCallback(Activity r100) {
        r100.unregisterComponentCallbacks(this.componentCallbackMap.get(r100));
        this.componentCallbackMap.remove(r100);
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IBinder r101 = Companion.getActivityWindowToken$window_release(r100);
        if (r101 == null) goto L5;
        SidecarInterface r102 = this.sidecar;
        if (r102 == null) goto L9;
        SidecarWindowLayoutInfo r103 = r102.getWindowLayoutInfo(r101);
    L10:
        SidecarAdapter r104 = this.sidecarAdapter;
        SidecarInterface r105 = this.sidecar;
        if (r105 == null) goto L14;
        SidecarDeviceState r106 = r105.getDeviceState();
        if (r106 == null) goto L14;
    L16:
        return r104.translate(r103, r106);
    L14:
        r106 = new SidecarDeviceState();
        goto L16
    L9:
        r103 = null;
        goto L10
    L5:
        return new WindowLayoutInfo(CollectionsKt.emptyList());
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IBinder r101 = Companion.getActivityWindowToken$window_release(r100);
        if (r101 == null) goto L5;
        register(r101, r100);
        return;
    L5:
        FirstAttachAdapter r102 = new FirstAttachAdapter(this, r100);
        INVOKEVIRTUAL_androidx_window_layout_SidecarCompat_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).addOnAttachStateChangeListener(r102);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        IBinder r101 = Companion.getActivityWindowToken$window_release(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        SidecarInterface r102 = this.sidecar;
        if (r102 == null) goto L8;
        r102.onWindowLayoutChangeListenerRemoved(r101);
    L8:
        unregisterComponentCallback(r100);
        if (this.windowListenerRegisteredContexts.size() != 1) goto L11;
        boolean r103 = true;
    L12:
        this.windowListenerRegisteredContexts.remove(r101);
        if (r103 == false) goto L18;
        SidecarInterface r104 = this.sidecar;
        if (r104 == null) goto L19;
        r104.onDeviceStateListenersChanged(true);
        return;
    L19:
        return;
    L18:
        return;
    L11:
        r103 = false;
        goto L12
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(r100);
        SidecarInterface r101 = this.sidecar;
        if (r101 == null) goto L6;
        r101.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
        return;
    }

    public SidecarCompat(SidecarInterface r100, SidecarAdapter r101) {
        Intrinsics.checkNotNullParameter(r101, "sidecarAdapter");
        this.sidecar = r100;
        this.sidecarAdapter = r101;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    public final void register(IBinder r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "windowToken");
        Intrinsics.checkNotNullParameter(r101, "activity");
        this.windowListenerRegisteredContexts.put(r100, r101);
        SidecarInterface r102 = this.sidecar;
        if (r102 == null) goto L6;
        r102.onWindowLayoutChangeListenerAdded(r100);
    L6:
        if (this.windowListenerRegisteredContexts.size() != 1) goto L10;
        SidecarInterface r103 = this.sidecar;
        if (r103 == null) goto L10;
        r103.onDeviceStateListenersChanged(false);
    L10:
        ExtensionInterfaceCompat.ExtensionCallbackInterface r104 = this.extensionCallback;
        if (r104 == null) goto L13;
        r104.onWindowLayoutChanged(r101, getWindowLayoutInfo(r101));
    L13:
        registerConfigurationChangeListener(r101);
    }
}
