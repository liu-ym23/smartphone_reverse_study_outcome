package androidx.window.layout;

import android.app.Activity;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0016\u0010\u0018\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\f0\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend;", "Landroidx/window/layout/WindowBackend;", "component", "Landroidx/window/extensions/layout/WindowLayoutComponent;", "consumerAdapter", "Landroidx/window/core/ConsumerAdapter;", "(Landroidx/window/extensions/layout/WindowLayoutComponent;Landroidx/window/core/ConsumerAdapter;)V", "activityToListeners", "", "Landroid/app/Activity;", "Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "consumerToToken", "Landroidx/window/core/ConsumerAdapter$Subscription;", "extensionWindowBackendLock", "Ljava/util/concurrent/locks/ReentrantLock;", "listenerToActivity", "Landroidx/core/util/Consumer;", "Landroidx/window/layout/WindowLayoutInfo;", "registerLayoutChangeCallback", "", "activity", "executor", "Ljava/util/concurrent/Executor;", "callback", "unregisterLayoutChangeCallback", "MulticastConsumer", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionWindowLayoutInfoBackend implements WindowBackend {
    private final Map<Activity, MulticastConsumer> activityToListeners;

    /* JADX INFO: renamed from: component, reason: collision with root package name */
    private final WindowLayoutComponent f15680component;
    private final ConsumerAdapter consumerAdapter;
    private final Map<MulticastConsumer, ConsumerAdapter.Subscription> consumerToToken;
    private final ReentrantLock extensionWindowBackendLock;
    private final Map<Consumer<WindowLayoutInfo>, Activity> listenerToActivity;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0014\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0014\u0010\u0013\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00010\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/window/layout/ExtensionWindowLayoutInfoBackend$MulticastConsumer;", "Landroidx/core/util/Consumer;", "Landroidx/window/extensions/layout/WindowLayoutInfo;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "lastKnownValue", "Landroidx/window/layout/WindowLayoutInfo;", "multicastConsumerLock", "Ljava/util/concurrent/locks/ReentrantLock;", "registeredListeners", "", "accept", "", "value", "addListener", "listener", "isEmpty", "", "removeListener", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class MulticastConsumer implements Consumer<androidx.window.extensions.layout.WindowLayoutInfo> {
        private final Activity activity;
        private WindowLayoutInfo lastKnownValue;
        private final ReentrantLock multicastConsumerLock;
        private final Set<Consumer<WindowLayoutInfo>> registeredListeners;

        public final boolean isEmpty() {
            return this.registeredListeners.isEmpty();
        }

        public MulticastConsumer(Activity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.activity = r100;
            this.multicastConsumerLock = new ReentrantLock();
            this.registeredListeners = new LinkedHashSet();
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(androidx.window.extensions.layout.WindowLayoutInfo r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            ReentrantLock r101 = this.multicastConsumerLock;
            r101.lock();
            this.lastKnownValue = ExtensionsWindowLayoutInfoAdapter.INSTANCE.translate$window_release(this.activity, r100);     // Catch: Throwable -> L10
            Iterator<T> r102 = this.registeredListeners.iterator();     // Catch: Throwable -> L10
        L5:
            if (r102.hasNext() == false) goto L7;
            ((Consumer) r102.next()).accept(this.lastKnownValue);     // Catch: Throwable -> L10
            goto L5
        L7:
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L10
            r101.unlock();
            return;
        L10:
            th = move-exception;
            r101.unlock();
            throw th;
        }

        public final void addListener(Consumer<WindowLayoutInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ReentrantLock r101 = this.multicastConsumerLock;
            r101.lock();
            WindowLayoutInfo r102 = this.lastKnownValue;     // Catch: Throwable -> L9
            if (r102 == null) goto L6;
            r100.accept(r102);     // Catch: Throwable -> L9
        L6:
            this.registeredListeners.add(r100);     // Catch: Throwable -> L9
            r101.unlock();
            return;
        L9:
            th = move-exception;
            r101.unlock();
            throw th;
        }

        public final void removeListener(Consumer<WindowLayoutInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            ReentrantLock r101 = this.multicastConsumerLock;
            r101.lock();
            this.registeredListeners.remove(r100);     // Catch: Throwable -> L6
            r101.unlock();
            return;
        L6:
            th = move-exception;
            r101.unlock();
            throw th;
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(androidx.window.extensions.layout.WindowLayoutInfo r100) {
            accept2(r100);
        }
    }

    @Override // androidx.window.layout.WindowBackend
    public void unregisterLayoutChangeCallback(Consumer<WindowLayoutInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        ReentrantLock r101 = this.extensionWindowBackendLock;
        r101.lock();
        Activity r102 = this.listenerToActivity.get(r100);     // Catch: Throwable -> L20
        if (r102 != null) goto L7;
        r101.unlock();
        return;
    L7:
        MulticastConsumer r103 = this.activityToListeners.get(r102);     // Catch: Throwable -> L20
        if (r103 != null) goto L11;
        r101.unlock();
        return;
    L11:
        r103.removeListener(r100);     // Catch: Throwable -> L20
        if (r103.isEmpty() == false) goto L17;
        ConsumerAdapter.Subscription r104 = this.consumerToToken.remove(r103);     // Catch: Throwable -> L20
        if (r104 == null) goto L16;
        r104.dispose();     // Catch: Throwable -> L20
    L16:
        this.listenerToActivity.remove(r100);     // Catch: Throwable -> L20
        this.activityToListeners.remove(r102);     // Catch: Throwable -> L20
    L17:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L20
        r101.unlock();
        return;
    L20:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public ExtensionWindowLayoutInfoBackend(WindowLayoutComponent r100, ConsumerAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, "component");
        Intrinsics.checkNotNullParameter(r101, "consumerAdapter");
        this.f15680component = r100;
        this.consumerAdapter = r101;
        this.extensionWindowBackendLock = new ReentrantLock();
        this.activityToListeners = new LinkedHashMap();
        this.listenerToActivity = new LinkedHashMap();
        this.consumerToToken = new LinkedHashMap();
    }

    @Override // androidx.window.layout.WindowBackend
    public void registerLayoutChangeCallback(Activity r110, Executor r111, Consumer<WindowLayoutInfo> r112) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "executor");
        Intrinsics.checkNotNullParameter(r112, "callback");
        ReentrantLock r113 = this.extensionWindowBackendLock;
        r113.lock();
        MulticastConsumer r100 = this.activityToListeners.get(r110);     // Catch: Throwable -> L12
        if (r100 == null) goto L6;
        r100.addListener(r112);     // Catch: Throwable -> L12
        this.listenerToActivity.put(r112, r110);     // Catch: Throwable -> L12
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L7:
        if (r101 != null) goto L9;
        final MulticastConsumer r102 = new MulticastConsumer(r110);     // Catch: Throwable -> L12
        this.activityToListeners.put(r110, r102);     // Catch: Throwable -> L12
        this.listenerToActivity.put(r112, r110);     // Catch: Throwable -> L12
        r102.addListener(r112);     // Catch: Throwable -> L12
        ConsumerAdapter.Subscription r114 = this.consumerAdapter.createSubscription(this.f15680component, Reflection.getOrCreateKotlinClass(androidx.window.extensions.layout.WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", r110, new ExtensionWindowLayoutInfoBackend$registerLayoutChangeCallback$1$2$disposableToken$1(r102));     // Catch: Throwable -> L12
        this.consumerToToken.put(r102, r114);     // Catch: Throwable -> L12
    L9:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r113.unlock();
        return;
    L6:
        r101 = null;
    L12:
        th = move-exception;
        r113.unlock();
        throw th;
    }
}
