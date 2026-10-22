package com.stepos.launcher.assistant.slidepanel;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewRootImpl;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.function.Consumer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B#\b\u0007\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\fJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\fR\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010(R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00105\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b4\u00102R\u0011\u00106\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/launcher/assistant/slidepanel/RootSurfaceTracker;", "Landroid/view/ViewRootImpl$SurfaceChangedCallback;", "Landroid/view/View$OnAttachStateChangeListener;", "Ljava/util/function/Consumer;", "Landroid/view/SurfaceControl;", "listener", "Landroid/os/Handler;", "handler", "<init>", "(Ljava/util/function/Consumer;Landroid/os/Handler;)V", "LY8/t;", "scheduleDebouncedNull", "()V", "cancelPendingNull", UxipConstants.f30680s, "setSurfaceImmediate", "(Landroid/view/SurfaceControl;)V", "dispatchSurfaceChanged", "Landroid/view/ViewRootImpl;", "viewRootImpl", "addSurfaceCallback", "(Landroid/view/ViewRootImpl;)V", "removeSurfaceCallback", "Landroid/view/View;", "v", "reset", "(Landroid/view/View;)V", "clear", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/view/SurfaceControl$Transaction;", "t", "surfaceCreated", "(Landroid/view/SurfaceControl$Transaction;)V", "surfaceReplaced", "surfaceDestroyed", "Ljava/util/function/Consumer;", "Landroid/os/Handler;", "", "surfaceCallbackAdded", "Z", "mView", "Landroid/view/View;", "validSurface", "Landroid/view/SurfaceControl;", "nullPending", "Ljava/lang/Runnable;", "pendingNullRunnable", "Ljava/lang/Runnable;", "getRootSurface", "()Landroid/view/SurfaceControl;", "rootSurface", "getSurface", "surface", "isNullNotificationPending", "()Z", "Companion", "launcherClient_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootSurfaceTracker implements ViewRootImpl.SurfaceChangedCallback, View.OnAttachStateChangeListener {
    public static final long SURFACE_DESTROY_DEBOUNCE_MS = 1200;
    private static final String TAG = "RootSurfaceTracker";
    private final Handler handler;
    private final Consumer<SurfaceControl> listener;
    private View mView;
    private boolean nullPending;
    private final Runnable pendingNullRunnable;
    private boolean surfaceCallbackAdded;
    private SurfaceControl validSurface;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RootSurfaceTracker(Consumer<SurfaceControl> listener) {
        this(listener, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.p.i(listener, "listener");
    }

    private final void addSurfaceCallback(ViewRootImpl viewRootImpl) {
        if (this.surfaceCallbackAdded) {
            return;
        }
        viewRootImpl.addSurfaceChangedCallback(this);
        this.surfaceCallbackAdded = true;
    }

    private final void cancelPendingNull() {
        if (this.nullPending) {
            Log.i(TAG, "pending surface null cancelled (flash reconnect)");
        }
        this.handler.removeCallbacks(this.pendingNullRunnable);
        this.nullPending = false;
    }

    private final void dispatchSurfaceChanged(SurfaceControl value) {
        this.listener.accept(value);
    }

    private final SurfaceControl getRootSurface() {
        ViewRootImpl viewRootImpl;
        View view = this.mView;
        if (view == null || (viewRootImpl = view.getViewRootImpl()) == null) {
            return null;
        }
        return viewRootImpl.getSurfaceControl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pendingNullRunnable$lambda$0(RootSurfaceTracker rootSurfaceTracker) {
        rootSurfaceTracker.nullPending = false;
        Log.i(TAG, "surface null confirmed after debounce");
        rootSurfaceTracker.dispatchSurfaceChanged(null);
    }

    private final void removeSurfaceCallback(ViewRootImpl viewRootImpl) {
        if (this.surfaceCallbackAdded) {
            viewRootImpl.removeSurfaceChangedCallback(this);
            this.surfaceCallbackAdded = false;
        }
    }

    private final void scheduleDebouncedNull() {
        if (this.nullPending) {
            return;
        }
        this.nullPending = true;
        this.handler.removeCallbacks(this.pendingNullRunnable);
        this.handler.postDelayed(this.pendingNullRunnable, 1200L);
    }

    private final void setSurfaceImmediate(SurfaceControl value) {
        if (kotlin.jvm.internal.p.d(this.validSurface, value)) {
            return;
        }
        this.validSurface = value;
        dispatchSurfaceChanged(value);
    }

    public final void clear() {
        View view = this.mView;
        if (view != null) {
            this.handler.removeCallbacks(this.pendingNullRunnable);
            this.nullPending = false;
            view.removeOnAttachStateChangeListener(this);
            ViewRootImpl viewRootImpl = view.getViewRootImpl();
            if (viewRootImpl != null) {
                viewRootImpl.removeSurfaceChangedCallback(this);
            }
            this.surfaceCallbackAdded = false;
            this.mView = null;
            this.validSurface = null;
            dispatchSurfaceChanged(null);
        }
    }

    /* renamed from: getSurface, reason: from getter */
    public final SurfaceControl getValidSurface() {
        return this.validSurface;
    }

    /* renamed from: isNullNotificationPending, reason: from getter */
    public final boolean getNullPending() {
        return this.nullPending;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        ViewRootImpl viewRootImpl = v10.getViewRootImpl();
        kotlin.jvm.internal.p.h(viewRootImpl, "getViewRootImpl(...)");
        addSurfaceCallback(viewRootImpl);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v10) {
        kotlin.jvm.internal.p.i(v10, "v");
        ViewRootImpl viewRootImpl = v10.getViewRootImpl();
        if (viewRootImpl != null) {
            removeSurfaceCallback(viewRootImpl);
        }
    }

    public final void reset(View v10) {
        if (kotlin.jvm.internal.p.d(this.mView, v10)) {
            return;
        }
        if (this.mView != null) {
            clear();
        }
        this.mView = v10;
        if (v10 != null) {
            v10.addOnAttachStateChangeListener(this);
            if (v10.isAttachedToWindow()) {
                ViewRootImpl viewRootImpl = v10.getViewRootImpl();
                kotlin.jvm.internal.p.h(viewRootImpl, "getViewRootImpl(...)");
                addSurfaceCallback(viewRootImpl);
            }
        }
    }

    public void surfaceCreated(SurfaceControl.Transaction t10) {
        kotlin.jvm.internal.p.i(t10, "t");
        cancelPendingNull();
        setSurfaceImmediate(getRootSurface());
    }

    public void surfaceDestroyed() {
        if (this.validSurface == null) {
            return;
        }
        this.validSurface = null;
        scheduleDebouncedNull();
    }

    public void surfaceReplaced(SurfaceControl.Transaction t10) {
        kotlin.jvm.internal.p.i(t10, "t");
        cancelPendingNull();
        setSurfaceImmediate(getRootSurface());
    }

    public RootSurfaceTracker(Consumer<SurfaceControl> listener, Handler handler) {
        kotlin.jvm.internal.p.i(listener, "listener");
        kotlin.jvm.internal.p.i(handler, "handler");
        this.listener = listener;
        this.handler = handler;
        this.pendingNullRunnable = new Runnable() { // from class: com.stepos.launcher.assistant.slidepanel.p
            @Override // java.lang.Runnable
            public final void run() {
                RootSurfaceTracker.pendingNullRunnable$lambda$0(this.f30154a);
            }
        };
    }

    public /* synthetic */ RootSurfaceTracker(Consumer consumer, Handler handler, int i10, kotlin.jvm.internal.i iVar) {
        this(consumer, (i10 & 2) != 0 ? new Handler(Looper.getMainLooper()) : handler);
    }
}
