package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.Version;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\u0016\u0010\u001b\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend;", "Landroidx/window/layout/WindowBackend;", "windowExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "(Landroidx/window/layout/ExtensionInterfaceCompat;)V", "getWindowExtension", "()Landroidx/window/layout/ExtensionInterfaceCompat;", "setWindowExtension", "windowLayoutChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "getWindowLayoutChangeCallbacks$annotations", "()V", "getWindowLayoutChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "callbackRemovedForActivity", "", "activity", "Landroid/app/Activity;", "isActivityRegistered", "", "registerLayoutChangeCallback", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "unregisterLayoutChangeCallback", "Companion", "ExtensionListenerImpl", "WindowLayoutChangeCallbackWrapper", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SidecarWindowBackend implements WindowBackend {
    public static final Companion Companion = null;
    public static final boolean DEBUG = false;
    private static final String TAG = "WindowServer";
    private static volatile SidecarWindowBackend globalInstance;
    private static final ReentrantLock globalLock = null;
    private ExtensionInterfaceCompat windowExtension;
    private final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> windowLayoutChangeCallbacks;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$Companion;", "", "()V", "DEBUG", "", "TAG", "", "globalInstance", "Landroidx/window/layout/SidecarWindowBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initAndVerifyExtension", "Landroidx/window/layout/ExtensionInterfaceCompat;", "isSidecarVersionSupported", "sidecarVersion", "Landroidx/window/core/Version;", "resetInstance", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void resetInstance() {
            SidecarWindowBackend.access$setGlobalInstance$cp(null);
        }

        public final SidecarWindowBackend getInstance(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (SidecarWindowBackend.access$getGlobalInstance$cp() != null) goto L13;
            ReentrantLock r101 = SidecarWindowBackend.access$getGlobalLock$cp();
            r101.lock();
        L10:
            th = move-exception;
            r101.unlock();
            throw th;
        L6:
            if (SidecarWindowBackend.access$getGlobalInstance$cp() != null) goto L8;
            SidecarWindowBackend.access$setGlobalInstance$cp(new SidecarWindowBackend(SidecarWindowBackend.Companion.initAndVerifyExtension(r100)));     // Catch: Throwable -> L10
        L8:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
            r101.unlock();
        L13:
            SidecarWindowBackend r103 = SidecarWindowBackend.access$getGlobalInstance$cp();
            Intrinsics.checkNotNull(r103);
            return r103;
        }

        public final ExtensionInterfaceCompat initAndVerifyExtension(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (isSidecarVersionSupported(SidecarCompat.Companion.getSidecarVersion()) == false) goto L13;
            SidecarCompat r101 = new SidecarCompat(r100);     // Catch: Throwable -> L10
            if (r101.validateExtensionInterface() == true) goto L9;
            return null;
        L9:
            return r101;
        L13:
            return null;
        L15:
            return null;
        }

        public final boolean isSidecarVersionSupported(Version r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            if (r100.compareTo2(Version.Companion.getVERSION_0_1()) < 0) goto L9;
            return true;
        L9:
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0017¨\u0006\t"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$ExtensionListenerImpl;", "Landroidx/window/layout/ExtensionInterfaceCompat$ExtensionCallbackInterface;", "(Landroidx/window/layout/SidecarWindowBackend;)V", "onWindowLayoutChanged", "", "activity", "Landroid/app/Activity;", "newLayout", "Landroidx/window/layout/WindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ExtensionListenerImpl implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        final /* synthetic */ SidecarWindowBackend this$0;

        public ExtensionListenerImpl(SidecarWindowBackend r100) {
            this.this$0 = r100;
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity r100, WindowLayoutInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "newLayout");
            Iterator<WindowLayoutChangeCallbackWrapper> r102 = this.this$0.getWindowLayoutChangeCallbacks().iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            WindowLayoutChangeCallbackWrapper r103 = r102.next();
            if (Intrinsics.areEqual(r103.getActivity(), r100) == false) goto L4;
            r103.accept(r101);
            goto L4
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Landroidx/window/layout/SidecarWindowBackend$WindowLayoutChangeCallbackWrapper;", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Landroidx/core/util/Consumer;", "lastInfo", "getLastInfo", "()Landroidx/window/layout/WindowLayoutInfo;", "setLastInfo", "(Landroidx/window/layout/WindowLayoutInfo;)V", "accept", "", "newLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class WindowLayoutChangeCallbackWrapper {
        private final Activity activity;
        private final Consumer<WindowLayoutInfo> callback;
        private final Executor executor;
        private WindowLayoutInfo lastInfo;

        public static /* synthetic */ void a(WindowLayoutChangeCallbackWrapper r100, WindowLayoutInfo r101) {
            m7962accept$lambda0(r100, r101);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Consumer<WindowLayoutInfo> getCallback() {
            return this.callback;
        }

        public final WindowLayoutInfo getLastInfo() {
            return this.lastInfo;
        }

        public final void accept(final WindowLayoutInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "newLayoutInfo");
            this.lastInfo = r100;
            this.executor.execute(new a(this, r100));
        }

        public final void setLastInfo(WindowLayoutInfo r100) {
            this.lastInfo = r100;
        }

        /* JADX INFO: renamed from: accept$lambda-0, reason: not valid java name */
        private static final void m7962accept$lambda0(WindowLayoutChangeCallbackWrapper r100, WindowLayoutInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            Intrinsics.checkNotNullParameter(r101, "$newLayoutInfo");
            r100.callback.accept(r101);
        }

        public WindowLayoutChangeCallbackWrapper(Activity r100, Executor r101, Consumer<WindowLayoutInfo> r102) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            Intrinsics.checkNotNullParameter(r101, "executor");
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.activity = r100;
            this.executor = r101;
            this.callback = r102;
        }
    }

    public static /* synthetic */ void getWindowLayoutChangeCallbacks$annotations() {
    }

    static {
        Companion = new Companion(null);
        globalLock = new ReentrantLock();
    }

    public static final /* synthetic */ SidecarWindowBackend access$getGlobalInstance$cp() {
        return globalInstance;
    }

    public static final /* synthetic */ ReentrantLock access$getGlobalLock$cp() {
        return globalLock;
    }

    public final ExtensionInterfaceCompat getWindowExtension() {
        return this.windowExtension;
    }

    public final CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> getWindowLayoutChangeCallbacks() {
        return this.windowLayoutChangeCallbacks;
    }

    public SidecarWindowBackend(ExtensionInterfaceCompat r100) {
        this.windowExtension = r100;
        this.windowLayoutChangeCallbacks = new CopyOnWriteArrayList();
        ExtensionInterfaceCompat r101 = this.windowExtension;
        if (r101 == null) goto L6;
        r101.setExtensionCallback(new ExtensionListenerImpl(this));
        return;
    }

    public static final /* synthetic */ void access$setGlobalInstance$cp(SidecarWindowBackend r100) {
        globalInstance = r100;
    }

    private final void callbackRemovedForActivity(Activity r100) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> r101 = this.windowLayoutChangeCallbacks;
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) r103.next()).getActivity(), r100) == false) goto L9;
        r102 = true;
    L13:
        if (r102 == false) goto L15;
        return;
    L15:
        ExtensionInterfaceCompat r104 = this.windowExtension;
        if (r104 == null) goto L22;
        r104.onWindowLayoutChangeListenerRemoved(r100);
        return;
    L22:
        return;
    L5:
        if (r101.isEmpty() == false) goto L7;
        goto L7
    }

    private final boolean isActivityRegistered(Activity r100) {
        CopyOnWriteArrayList<WindowLayoutChangeCallbackWrapper> r101 = this.windowLayoutChangeCallbacks;
        if ((r101 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((WindowLayoutChangeCallbackWrapper) r102.next()).getActivity(), r100) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return false;
    }

    public final void setWindowExtension(ExtensionInterfaceCompat r100) {
        this.windowExtension = r100;
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ReentrantLock r101 = globalLock;
        monitor-enter(r101);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.windowExtension != null) goto L8;
        monitor-exit(r101);
        return;
    L8:
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<WindowLayoutChangeCallbackWrapper> r103 = this.windowLayoutChangeCallbacks.iterator();     // Catch: Throwable -> L21
    L10:
        if (r103.hasNext() == false) goto L14;
        WindowLayoutChangeCallbackWrapper r104 = r103.next();     // Catch: Throwable -> L21
        if (r104.getCallback() != r100) goto L10;
        r102.add(r104);     // Catch: Throwable -> L21
        goto L10
    L14:
        this.windowLayoutChangeCallbacks.removeAll(r102);     // Catch: Throwable -> L21
        Iterator r105 = r102.iterator();     // Catch: Throwable -> L21
    L16:
        if (r105.hasNext() == false) goto L18;
        callbackRemovedForActivity(((WindowLayoutChangeCallbackWrapper) r105.next()).getActivity());     // Catch: Throwable -> L21
        goto L16
    L18:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r101);
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r100, Executor r101, Consumer<WindowLayoutInfo> r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "executor");
        Intrinsics.checkNotNullParameter(r102, "callback");
        ReentrantLock r103 = globalLock;
        r103.lock();
        ExtensionInterfaceCompat r104 = this.windowExtension;     // Catch: Throwable -> L26
        if (r104 != null) goto L8;
        r102.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));     // Catch: Throwable -> L26
        r103.unlock();
        return;
    L8:
        boolean r105 = isActivityRegistered(r100);     // Catch: Throwable -> L26
        WindowLayoutChangeCallbackWrapper r106 = new WindowLayoutChangeCallbackWrapper(r100, r101, r102);     // Catch: Throwable -> L26
        this.windowLayoutChangeCallbacks.add(r106);     // Catch: Throwable -> L26
        if (r105 == true) goto L11;
        r104.onWindowLayoutChangeListenerAdded(r100);     // Catch: Throwable -> L26
    L23:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L26
        r103.unlock();
        return;
    L11:
        Iterator<T> r108 = this.windowLayoutChangeCallbacks.iterator();     // Catch: Throwable -> L26
    L12:
        WindowLayoutInfo r109 = null;
        if (r108.hasNext() == false) goto L17;
        Object r110 = r108.next();     // Catch: Throwable -> L26
        if (Intrinsics.areEqual(r100, ((WindowLayoutChangeCallbackWrapper) r110).getActivity()) == false) goto L12;
    L18:
        WindowLayoutChangeCallbackWrapper r111 = (WindowLayoutChangeCallbackWrapper) r110;     // Catch: Throwable -> L26
        if (r111 == null) goto L21;
        r109 = r111.getLastInfo();     // Catch: Throwable -> L26
    L21:
        if (r109 == null) goto L23;
        r106.accept(r109);     // Catch: Throwable -> L26
        goto L23
    L17:
        r110 = null;
    L26:
        th = move-exception;
        r103.unlock();
        throw th;
    }
}
