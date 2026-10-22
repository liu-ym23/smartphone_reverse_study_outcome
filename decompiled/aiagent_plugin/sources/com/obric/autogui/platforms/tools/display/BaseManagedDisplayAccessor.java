package com.obric.autogui.platforms.tools.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.Surface;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.DisplayStatusListener;
import com.obric.autogui.common.api.platform.display.SurfaceChangeable;
import com.obric.autogui.common.api.space.errtrack.AppErrorTracker;
import com.obric.autogui.platforms.tools.display.vd.VDTaskStackObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.h.b.o;
import d.m;
import d.x;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BaseManagedDisplayAccessor.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseManagedDisplayAccessor extends com.obric.autogui.platforms.tools.display.a implements SurfaceChangeable {
    private final m<Integer, Integer> initialMetrics;
    private final String logTag;
    private DisplayStatusListener mExternalListener;
    private final InternalDisplayListener mInternalListener;
    private boolean mIsDestroyed;
    private final AtomicInteger mRotation;
    private final DisplayManager sDisplayManager;

    /* JADX INFO: compiled from: BaseManagedDisplayAccessor.kt */
    private final class InternalDisplayListener implements DisplayManager.DisplayListener {
        final /* synthetic */ BaseManagedDisplayAccessor this$0;

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int r1) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int r1) {
        }

        public InternalDisplayListener(BaseManagedDisplayAccessor r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int r6) {
            if (this.this$0.shouldHandleDisplayChanged(r6) == true) goto L5;
            return;
        L5:
            int r0 = this.this$0.getD().getRotation();
            Loog.INSTANCE.d(BaseManagedDisplayAccessor.access$getLogTag$p(this.this$0), "onDisplayChanged: " + r6 + ", rot->" + r0);
            BaseManagedDisplayAccessor.access$getMRotation$p(this.this$0).set(r0);
        }
    }

    /* JADX INFO: compiled from: BaseManagedDisplayAccessor.kt */
    @f(b = "BaseManagedDisplayAccessor.kt", c = {85}, d = "destroy$suspendImpl", e = "com.obric.autogui.platforms.tools.display.BaseManagedDisplayAccessor")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f30144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseManagedDisplayAccessor f30145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f30146d;

        a(BaseManagedDisplayAccessor r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30145c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30144b = r3;
            this.f30146d |= Integer.MIN_VALUE;
            return BaseManagedDisplayAccessor.destroy$suspendImpl(this.f30145c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public Object destroy(d.c.d<? super x> r3) {
        return destroy$suspendImpl(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object destroyDisplayResource(d.c.d<? super x> r1);

    public abstract String managedDisplayLogName();

    public boolean shouldHandleDisplayChanged(int r1) {
        return true;
    }

    public static final /* synthetic */ String access$getLogTag$p(BaseManagedDisplayAccessor r0) {
        return r0.logTag;
    }

    public static final /* synthetic */ AtomicInteger access$getMRotation$p(BaseManagedDisplayAccessor r0) {
        return r0.mRotation;
    }

    public BaseManagedDisplayAccessor(Context r4, Display r5, m<Integer, Integer> r6, int r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        o.e(r5, "display");
        o.e(r6, "initialMetrics");
        o.e(r8, "logTag");
        super(r5);
        this.initialMetrics = r6;
        this.logTag = r8;
        this.mRotation = new AtomicInteger(r7);
        Object r10 = r9.getSystemService("display");
        o.a(r10, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        DisplayManager r11 = (DisplayManager) ZeusTransformUtils.preCheckCast(r10, DisplayManager.class, "com.obric.aiagent.plugin");
        this.sDisplayManager = r11;
        InternalDisplayListener r12 = new InternalDisplayListener(this);
        this.mInternalListener = r12;
        r11.registerDisplayListener((DisplayManager.DisplayListener) ZeusTransformUtils.preCheckCast(r12, DisplayManager.DisplayListener.class, "com.obric.aiagent.plugin"), null);
        AppErrorTracker.INSTANCE.init();
        if (Build.VERSION.SDK_INT < 32) goto L6;
        VDTaskStackObserver.f30162a.b();
        return;
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public int getDisplayId() {
        return getD().getDisplayId();
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public DisplayAccessor.Rotation getRotation() {
        return mapDisplayRotation(this.mRotation.get());
    }

    public final boolean getMIsDestroyed() {
        return this.mIsDestroyed;
    }

    public final void setMIsDestroyed(boolean r1) {
        this.mIsDestroyed = r1;
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public m<Integer, Integer> getSpawnedDimensions() {
        return this.initialMetrics;
    }

    @Override // com.obric.autogui.platforms.tools.display.a, com.obric.autogui.common.api.platform.display.DisplayAccessor
    public boolean isDestroyed() {
        return this.mIsDestroyed;
    }

    static /* synthetic */ Object destroy$suspendImpl(BaseManagedDisplayAccessor r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f30146d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30146d -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f30144b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f30146d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (BaseManagedDisplayAccessor) ZeusTransformUtils.preCheckCast(r0.f30143a, BaseManagedDisplayAccessor.class, "com.obric.aiagent.plugin");
        d.o.a(r9);
    L20:
        Loog.INSTANCE.d(r6.logTag, '[' + r6.managedDisplayLogName() + '/' + r6.getDisplayId() + "] -> Destroyed.");
        r6.mIsDestroyed = true;
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r6.sDisplayManager.unregisterDisplayListener((DisplayManager.DisplayListener) ZeusTransformUtils.preCheckCast(r6.mInternalListener, DisplayManager.DisplayListener.class, "com.obric.aiagent.plugin"));
        AppErrorTracker.INSTANCE.release();
        if (Build.VERSION.SDK_INT < 32) goto L17;
        VDTaskStackObserver.f30162a.c();
    L17:
        r0.f30143a = r6;
        r0.f30146d = 1;
        if (r6.destroyDisplayResource(r0) != r2) goto L20;
        return r2;
    L7:
        r0 = new a(r6, r8);
        goto L8
    }

    @Override // com.obric.autogui.common.api.platform.display.DisplayAccessor
    public void registerStatusListener(DisplayStatusListener r3) {
        this.mExternalListener = (DisplayStatusListener) ZeusTransformUtils.wrapperContextForParams(r3, DisplayStatusListener.class, "com.obric.aiagent.plugin");
    }

    public final DisplayStatusListener getDisplayStatusListener() {
        return this.mExternalListener;
    }

    public final String describeSurface(Surface r4) {
        if (r4 != null) goto L5;
        return "null";
    L5:
        int r3 = System.identityHashCode(r4);
        StringBuilder r0 = new StringBuilder().append("Surface@");
        String r1 = Integer.toString(r3, d.o.a.a(16));
        o.c(r1, "toString(...)");
        return r0.append(r1).append('(').append(r3).append(", valid=").append(r4.isValid()).append(')').toString();
    }
}
