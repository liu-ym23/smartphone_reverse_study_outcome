package com.obric.autogui.common.api.space;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.computercontrol.CCLifecycleListener;
import com.obric.autogui.common.api.space.DisplayOperatingSpace;
import com.obric.autogui.common.api.space.handusing.HandUsingConfigResult;
import com.obric.autogui.common.api.space.handusing.HandUsingEventsCallback;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.obric.autogui.common.api.space.monitor.OperatingSpaceMonitor;
import com.obric.autogui.common.api.space.status.SpaceStatusCallback;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseDisplaySpaceManager<S extends DisplayOperatingSpace> implements IOperatingSpaceManager {
    private volatile S activeSpace;
    private final AtomicReference<WeakReference<SurfaceHolder>> mCurrentSurfaceHolder;
    private Collection<String> mGlobalDisabledApps;
    private final a sLock;
    private final BaseDisplaySpaceManager<S>.SurfaceHolderMonitorCallback surfaceHolderMonitorCallback;

    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    private final class SurfaceHolderMonitorCallback implements SurfaceHolder.Callback {
        private final am sMainScope;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        public SurfaceHolderMonitorCallback(BaseDisplaySpaceManager r3) {
            this.this$0 = r3;
            this.sMainScope = an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin"));
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder r9) {
            SurfaceHolder r10 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r9, SurfaceHolder.class, "com.obric.aiagent.plugin");
            o.e(r10, "holder");
            i.a(this.sMainScope, null, null, (m) ZeusTransformUtils.preCheckCast(new BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceCreated$1(r10, this.this$0, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder r3, int r4, int r5, int r6) {
            o.e((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin"), "holder");
            Loog.INSTANCE.w(this.this$0.getLogTag(), "surfaceChanged: format=" + r4 + ", width=" + r5 + ", height=" + r6);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder r9) {
            SurfaceHolder r10 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r9, SurfaceHolder.class, "com.obric.aiagent.plugin");
            o.e(r10, "holder");
            i.a(this.sMainScope, null, null, (m) ZeusTransformUtils.preCheckCast(new BaseDisplaySpaceManager$SurfaceHolderMonitorCallback$surfaceDestroyed$1(this.this$0, r10, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplaySpaceManager$attachSurfaceHost$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    @f(b = "BaseDisplaySpaceManager.kt", c = {232}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager$attachSurfaceHost$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ SurfaceHolder $holder;
        final /* synthetic */ Surface $surface;
        int label;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        AnonymousClass1(BaseDisplaySpaceManager<S> r3, SurfaceHolder r4, Surface r5, d<? super AnonymousClass1> r6) {
            SurfaceHolder r7 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceHolder.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$holder = r7;
            this.$surface = r5;
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, this.$holder, this.$surface, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L16:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] --> Bind existing Surface holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, this.$surface) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", activeSpace=" + this.this$0.getActiveSpace());
            DisplayOperatingSpace r8 = this.this$0.getActiveSpace();
            if (r8 == null) goto L14;
            Surface r2 = this.$surface;
            d<? super x> r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r8.configureSurface(r2, r3) != r0) goto L16;
            return r0;
        L14:
            return null;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplaySpaceManager$createSpace$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    @f(b = "BaseDisplaySpaceManager.kt", c = {BDAbstractUpload.KeyIsRetryStatesOption, 68, 94, 98}, d = "createSpace$suspendImpl", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager")
    static final class C11411<S extends DisplayOperatingSpace> extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        C11411(BaseDisplaySpaceManager<S> r3, d<? super C11411> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BaseDisplaySpaceManager.createSpace$suspendImpl(this.this$0, null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplaySpaceManager$destroySpace$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    @f(b = "BaseDisplaySpaceManager.kt", c = {BDAbstractUpload.KeyIsRetryStatesOption, 139}, d = "destroySpace$suspendImpl", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager")
    static final class C11421<S extends DisplayOperatingSpace> extends d.c.b.a.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        C11421(BaseDisplaySpaceManager<S> r3, d<? super C11421> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return BaseDisplaySpaceManager.destroySpace$suspendImpl(this.this$0, null, null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplaySpaceManager$detachSurfaceHost$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    @f(b = "BaseDisplaySpaceManager.kt", c = {270}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager$detachSurfaceHost$1")
    static final class C11431 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ SurfaceHolder $holder;
        final /* synthetic */ Surface $surface;
        int label;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        C11431(BaseDisplaySpaceManager<S> r3, SurfaceHolder r4, Surface r5, d<? super C11431> r6) {
            SurfaceHolder r7 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r4, SurfaceHolder.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$holder = r7;
            this.$surface = r5;
            super(2, r8);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11431(this.this$0, this.$holder, this.$surface, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11431) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11431.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r11);
        L27:
            WeakReference r12 = (WeakReference) ZeusTransformUtils.preCheckCast(BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).get(), WeakReference.class, "com.obric.aiagent.plugin");
            if (r12 == null) goto L30;
            SurfaceHolder r13 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r12.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
        L32:
            if (r13 != this.$holder) goto L34;
            BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).set(null);
        L34:
            Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] detachMonitor: finished holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0));
            return x.f38692a;
        L30:
            r13 = null;
            goto L32
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r11);
            WeakReference r14 = (WeakReference) ZeusTransformUtils.preCheckCast(BaseDisplaySpaceManager.access$getMCurrentSurfaceHolder$p(this.this$0).get(), WeakReference.class, "com.obric.aiagent.plugin");
            if (r14 == null) goto L11;
            SurfaceHolder r15 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r14.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
        L13:
            if (r15 != this.$holder) goto L15;
            boolean r16 = true;
        L16:
            if (r16 == true) goto L19;
            Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] detachMonitor: skipped configureSurface(null) because holder is not current, holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0));
            return x.f38692a;
        L19:
            Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] detachMonitor: configureHandUsing(false) holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder));
            DisplayOperatingSpace r17 = this.this$0.getActiveSpace();
            if (r17 == null) goto L22;
            ((AOOperatingSpace) ZeusTransformUtils.preCheckCast(r17, AOOperatingSpace.class, "com.obric.aiagent.plugin")).configureHandUsing(false, null, null);
        L22:
            Loog.INSTANCE.i(this.this$0.getLogTag(), "[SurfaceHolder] detachMonitor: configureSurface(null) holder=" + BaseDisplaySpaceManager.access$describeHolder(this.this$0, this.$holder) + ", currentHolder=" + BaseDisplaySpaceManager.access$describeCurrentHolder(this.this$0) + ", surface=" + BaseDisplaySpaceManager.access$describeSurface(this.this$0, this.$surface));
            DisplayOperatingSpace r18 = this.this$0.getActiveSpace();
            if (r18 == null) goto L27;
            d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r18.configureSurface(null, r2) != r0) goto L27;
            return r0;
        L15:
            r16 = false;
            goto L16
        L11:
            r15 = null;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.space.BaseDisplaySpaceManager$postDestroyAllSpaces$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseDisplaySpaceManager.kt */
    @f(b = "BaseDisplaySpaceManager.kt", c = {150}, d = "invokeSuspend", e = "com.obric.autogui.common.api.space.BaseDisplaySpaceManager$postDestroyAllSpaces$1")
    static final class C11441 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ S $current;
        int label;
        final /* synthetic */ BaseDisplaySpaceManager<S> this$0;

        C11441(BaseDisplaySpaceManager<S> r3, Context r4, S r5, d<? super C11441> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            S r8 = (S) ZeusTransformUtils.wrapperContextForParams(r5, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.$current = r8;
            super(2, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C11441(this.this$0, this.$context, this.$current, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((C11441) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C11441.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            BaseDisplaySpaceManager<S> r8 = this.this$0;
            Context r2 = this.$context;
            AOOperatingSpace r3 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(this.$current, AOOperatingSpace.class, "com.obric.aiagent.plugin");
            d<? super x> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r8.destroySpace(r2, r3, r4) != r0) goto L12;
            return r0;
        }
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public Object createSpace(Context r3, CCLifecycleListener r4, d<? super IOperatingSpaceManager.OpSpaceCreationResult> r5) {
        return createSpace$suspendImpl(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r4, CCLifecycleListener.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object destroyDisplaySpace(Context r1, S r2, d<? super x> r3);

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public Object destroySpace(Context r3, AOOperatingSpace r4, d<? super x> r5) {
        return destroySpace$suspendImpl(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, AOOperatingSpace.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public abstract String getLogTag();

    public void logCreateSpaceSuccess(S r2) {
        o.e((DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r2, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"), "space");
    }

    public Object onSpaceCreated(Context r3, S r4, d<? super x> r5) {
        return onSpaceCreated$suspendImpl(this, (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r4, DisplayOperatingSpace.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin"));
    }

    public abstract Object spawnSpace(Context r1, CCLifecycleListener r2, d<? super S> r3);

    public BaseDisplaySpaceManager() {
        this.sLock = c.a(false, 1, null);
        this.mCurrentSurfaceHolder = new AtomicReference();
        this.surfaceHolderMonitorCallback = new SurfaceHolderMonitorCallback(this);
    }

    public static final /* synthetic */ String access$describeCurrentHolder(BaseDisplaySpaceManager r0) {
        return r0.describeCurrentHolder();
    }

    public static final /* synthetic */ String access$describeHolder(BaseDisplaySpaceManager r2, SurfaceHolder r3) {
        return r2.describeHolder((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String access$describeSurface(BaseDisplaySpaceManager r0, Surface r1) {
        return r0.describeSurface(r1);
    }

    public static final /* synthetic */ AtomicReference access$getMCurrentSurfaceHolder$p(BaseDisplaySpaceManager r0) {
        return r0.mCurrentSurfaceHolder;
    }

    public final a getManagerLock() {
        return this.sLock;
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public final S getActiveSpace() {
        return this.activeSpace;
    }

    public final void setActiveSpace(S r3) {
        this.activeSpace = (S) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public AOOperatingSpace getActiveSpace() {
        return (AOOperatingSpace) ZeusTransformUtils.preCheckCast(this.activeSpace, AOOperatingSpace.class, "com.obric.aiagent.plugin");
    }

    static /* synthetic */ <S extends DisplayOperatingSpace> Object createSpace$suspendImpl(BaseDisplaySpaceManager<S> r11, Context r12, CCLifecycleListener r13, d<? super IOperatingSpaceManager.OpSpaceCreationResult> r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r16 = (CCLifecycleListener) ZeusTransformUtils.wrapperContextForParams(r13, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        d r17 = (d) ZeusTransformUtils.wrapperContextForParams(r14, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r17, C11411.class) == false) goto L7;
        C11411 r1 = (C11411) ZeusTransformUtils.preCheckCast(r17, C11411.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r18 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        boolean r8 = true;
        if (r4 == 0) goto L24;
        if (r4 == 1) goto L23;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L16;
        S r19 = (S) ZeusTransformUtils.preCheckCast(r1.L$1, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r110 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
    L74:
        r110.logCreateSpaceSuccess(r19);
        return new IOperatingSpaceManager.OpSpaceCreationResult(IOperatingSpaceManager.OpSpaceCreationResult.Status.Success, (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r19, AOOperatingSpace.class, "com.obric.aiagent.plugin"));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r19 = (S) ZeusTransformUtils.preCheckCast(r1.L$2, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        Context r111 = (Context) ZeusTransformUtils.preCheckCast(r1.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r112 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
    L71:
        BaseDisplaySpaceManager<S> r10 = r112;
        Context r113 = r111;
        r110 = r10;
        r1.L$0 = r110;
        r1.L$1 = r19;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.label = 4;
        if (r110.onSpaceCreated(r113, r19, r1) != r3) goto L74;
        return r3;
    L18:
        r11 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$4, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r114 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$3, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        a r115 = (a) ZeusTransformUtils.preCheckCast(r1.L$2, a.class, "com.obric.aiagent.plugin");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(r1.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r0 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r18);     // Catch: Throwable -> L21
    L49:
        DisplayOperatingSpace r116 = (DisplayOperatingSpace) ZeusTransformUtils.preCheckCast(r18, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        r111 = r5;
        a r117 = r115;
        r112 = r0;
        S r2 = (S) r116;
    L85:
        ((BaseDisplaySpaceManager) r11).activeSpace = r2;     // Catch: Throwable -> L76
        r19 = ((BaseDisplaySpaceManager) r112).activeSpace;     // Catch: Throwable -> L76
        r117.b(null);
        if (r19 != null) goto L60;
        r112.clearDisabledPackages(r111);
        return new IOperatingSpaceManager.OpSpaceCreationResult(IOperatingSpaceManager.OpSpaceCreationResult.Status.FailedToCreate, null);
    L60:
        WeakReference r118 = (WeakReference) ZeusTransformUtils.preCheckCast(((BaseDisplaySpaceManager) r112).mCurrentSurfaceHolder.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r118 == null) goto L71;
        SurfaceHolder r119 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r118.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
        if (r119 == null) goto L71;
        Surface r120 = r119.getSurface();
        if (r120 == null) goto L71;
        if (r120.isValid() == false) goto L71;
        Loog.INSTANCE.i(r112.getLogTag(), "createSpace: restoring existing Surface to the new display space.");
        r1.L$0 = r112;
        r1.L$1 = r111;
        r1.L$2 = r19;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.label = 3;
        if (r19.configureSurface(r120, r1) != r3) goto L71;
        return r3;
    L76:
        th = th;
        r115 = r117;
    L79:
        r115.b(null);
        throw th;
    L21:
        Throwable th = th;
    L53:
        Loog.INSTANCE.e(r0.getLogTag(), "createSpace: failed to create display space", th);     // Catch: Throwable -> L78
        r11 = r114;
        r117 = r115;
        r112 = r0;
        r111 = r5;
        r2 = null;
        goto L85
    L23:
        a r121 = (a) ZeusTransformUtils.preCheckCast(r1.L$3, a.class, "com.obric.aiagent.plugin");
        CCLifecycleListener r122 = (CCLifecycleListener) ZeusTransformUtils.preCheckCast(r1.L$2, CCLifecycleListener.class, "com.obric.aiagent.plugin");
        r15 = (Context) ZeusTransformUtils.preCheckCast(r1.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r6 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r18);
        CCLifecycleListener r123 = r122;
        r115 = r121;
        r11 = r6;
    L87:
    L78:
        th = th;
        goto L79
    L33:
        if (((BaseDisplaySpaceManager) r11).activeSpace == null) goto L37;
        IOperatingSpaceManager.OpSpaceCreationResult r124 = new IOperatingSpaceManager.OpSpaceCreationResult(IOperatingSpaceManager.OpSpaceCreationResult.Status.AlreadyExist, null);     // Catch: Throwable -> L78
        r115.b(null);
        return r124;
    L37:
        Collection<String> r7 = ((BaseDisplaySpaceManager) r11).mGlobalDisabledApps;     // Catch: Throwable -> L78
        if (r7 != null) goto L40;
    L43:
        if (r8 == true) goto L81;
        r11.addDisabledPackages(r15, r7);     // Catch: Throwable -> L78
    L81:
        r1.L$0 = r11;     // Catch: Throwable -> L51
        r1.L$1 = r15;     // Catch: Throwable -> L51
        r1.L$2 = r115;     // Catch: Throwable -> L51
        r1.L$3 = r11;     // Catch: Throwable -> L51
        r1.L$4 = r11;     // Catch: Throwable -> L51
        r1.label = 2;     // Catch: Throwable -> L51
        r18 = r11.spawnSpace(r15, r123, r1);     // Catch: Throwable -> L51
        if (r18 != r3) goto L48;
        return r3;
    L48:
        r0 = r11;
        r5 = r15;
        r114 = r0;
    L51:
        th = move-exception;
        r0 = r11;
        r5 = r15;
        r114 = r0;
        th = th;
        goto L53
    L40:
        if (r7.isEmpty() == true) goto L43;
        r8 = false;
        goto L43
    L24:
        d.o.a(r18);
        if (((BaseDisplaySpaceManager) r11).activeSpace != null) goto L27;
        a r125 = ((BaseDisplaySpaceManager) r11).sLock;
        r1.L$0 = r11;
        r1.L$1 = r15;
        r1.L$2 = r16;
        r1.L$3 = r125;
        r1.label = 1;
        if (r125.a(null, r1) != r3) goto L31;
        return r3;
    L31:
        r123 = r16;
        r115 = r125;
        goto L87
    L27:
        return new IOperatingSpaceManager.OpSpaceCreationResult(IOperatingSpaceManager.OpSpaceCreationResult.Status.AlreadyExist, null);
    L7:
        r1 = new C11411(r11, r17);
        goto L8
    }

    static /* synthetic */ <S extends DisplayOperatingSpace> Object onSpaceCreated$suspendImpl(BaseDisplaySpaceManager<S> r1, Context r2, S r3, d<? super x> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        DisplayOperatingSpace r6 = (DisplayOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r3, DisplayOperatingSpace.class, "com.obric.aiagent.plugin");
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return x.f38692a;
    }

    public void addDisabledPackages(Context r2, Collection<String> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        Collection<String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r4, "disabledApps");
        AOPlatformTools.INSTANCE.display().setGloballyDisabledPackages(r1, r4);
    }

    public void clearDisabledPackages(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        AOPlatformTools.INSTANCE.display().clearGloballyDisabledPackages(r1);
    }

    static /* synthetic */ <S extends DisplayOperatingSpace> Object destroySpace$suspendImpl(BaseDisplaySpaceManager<S> r8, Context r9, AOOperatingSpace r10, d<? super x> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AOOperatingSpace r13 = (AOOperatingSpace) ZeusTransformUtils.wrapperContextForParams(r10, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, C11421.class) == false) goto L7;
        C11421 r1 = (C11421) ZeusTransformUtils.preCheckCast(r14, C11421.class, "com.obric.aiagent.plugin");
        if ((r1.label & Integer.MIN_VALUE) == 0) goto L7;
        r1.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r1.result;
        Object r3 = b.a();
        int r4 = r1.label;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L18;
        a r16 = (a) ZeusTransformUtils.preCheckCast(r1.L$2, a.class, "com.obric.aiagent.plugin");
        r12 = (Context) ZeusTransformUtils.preCheckCast(r1.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r17 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L15
    L32:
        ((BaseDisplaySpaceManager) r17).activeSpace = null;     // Catch: Throwable -> L15
        r17.clearDisabledPackages(r12);     // Catch: Throwable -> L15
        x r18 = x.f38692a;     // Catch: Throwable -> L15
        r16.b(null);
        return x.f38692a;
    L15:
        th = th;
    L37:
        r16.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        a r19 = (a) ZeusTransformUtils.preCheckCast(r1.L$3, a.class, "com.obric.aiagent.plugin");
        r13 = (AOOperatingSpace) ZeusTransformUtils.preCheckCast(r1.L$2, AOOperatingSpace.class, "com.obric.aiagent.plugin");
        r12 = (Context) ZeusTransformUtils.preCheckCast(r1.L$1, Context.class, "com.obric.aiagent.plugin");
        BaseDisplaySpaceManager<S> r0 = (BaseDisplaySpaceManager) ZeusTransformUtils.preCheckCast(r1.L$0, BaseDisplaySpaceManager.class, "com.obric.aiagent.plugin");
        d.o.a(r15);
        a r110 = r19;
        r8 = r0;
    L41:
        S r2 = ((BaseDisplaySpaceManager) r8).activeSpace;     // Catch: Throwable -> L35
        if (o.a(r2, r13) == true) goto L28;
        Loog.INSTANCE.w(r8.getLogTag(), "destroySpace: space " + r13 + " is not the active space " + r2);     // Catch: Throwable -> L35
        x r20 = x.f38692a;     // Catch: Throwable -> L35
        r110.b(null);
        return r20;
    L28:
        r1.L$0 = r8;     // Catch: Throwable -> L35
        r1.L$1 = r12;     // Catch: Throwable -> L35
        r1.L$2 = r110;     // Catch: Throwable -> L35
        r1.L$3 = null;     // Catch: Throwable -> L35
        r1.label = 2;     // Catch: Throwable -> L35
        if (r8.destroyDisplaySpace(r12, r2, r1) != r3) goto L31;
        return r3;
    L31:
        r17 = r8;
        r16 = r110;
    L35:
        th = th;
        r16 = r110;
        goto L37
    L20:
        d.o.a(r15);
        r110 = ((BaseDisplaySpaceManager) r8).sLock;
        r1.L$0 = r8;
        r1.L$1 = r12;
        r1.L$2 = r13;
        r1.L$3 = r110;
        r1.label = 1;
        if (r110.a(null, r1) != r3) goto L41;
        return r3;
    L7:
        r1 = new C11421(r8, r14);
        goto L8
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void postDestroyAllSpaces(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        S r0 = this.activeSpace;
        if (r0 != null) goto L5;
        return;
    L5:
        AOThreadingTools.INSTANCE.launchIO((m) ZeusTransformUtils.preCheckCast(new C11441(this, r7, r0, null), m.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public HandUsingConfigResult configureHandUsing(Context r3, boolean r4, DisplayHost r5, HandUsingEventsCallback r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        HandUsingEventsCallback r8 = (HandUsingEventsCallback) ZeusTransformUtils.wrapperContextForParams(r6, HandUsingEventsCallback.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        S r2 = this.activeSpace;
        if (r2 != null) goto L7;
        return new HandUsingConfigResult(HandUsingConfigResult.Status.NoActiveSpace);
    L7:
        return ((AOOperatingSpace) ZeusTransformUtils.preCheckCast(r2, AOOperatingSpace.class, "com.obric.aiagent.plugin")).configureHandUsing(r4, r5, r8);
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void configureStatusListening(Context r3, SpaceStatusCallback r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        SpaceStatusCallback r6 = (SpaceStatusCallback) ZeusTransformUtils.wrapperContextForParams(r4, SpaceStatusCallback.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        S r2 = this.activeSpace;
        if (r2 == null) goto L6;
        ((AOOperatingSpace) ZeusTransformUtils.preCheckCast(r2, AOOperatingSpace.class, "com.obric.aiagent.plugin")).setStatusCallback(r6);
        return;
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void attachMonitor(OperatingSpaceMonitor r4) {
        OperatingSpaceMonitor r5 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r4, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r5, "monitor");
        DisplayHost r6 = r5.getHost();
        if (ZeusTransformUtils.instanceOf(r6, DisplayHost.Surface.class) == true) goto L6;
        Loog.INSTANCE.w(getLogTag(), "[SurfaceHolder] attachMonitor: unsupported host=" + r6);
        return;
    L6:
        attachSurfaceHost((DisplayHost.Surface) ZeusTransformUtils.preCheckCast(r6, DisplayHost.Surface.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void detachMonitor(OperatingSpaceMonitor r4) {
        OperatingSpaceMonitor r5 = (OperatingSpaceMonitor) ZeusTransformUtils.wrapperContextForParams(r4, OperatingSpaceMonitor.class, "com.obric.aiagent.plugin");
        o.e(r5, "monitor");
        DisplayHost r6 = r5.getHost();
        if (ZeusTransformUtils.instanceOf(r6, DisplayHost.Surface.class) == true) goto L6;
        Loog.INSTANCE.w(getLogTag(), "[SurfaceHolder] detachMonitor: unsupported host=" + r6);
        return;
    L6:
        detachSurfaceHost((DisplayHost.Surface) ZeusTransformUtils.preCheckCast(r6, DisplayHost.Surface.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void setMuted(boolean r3) {
        S r2 = this.activeSpace;
        if (r2 == null) goto L6;
        ((AOOperatingSpace) ZeusTransformUtils.preCheckCast(r2, AOOperatingSpace.class, "com.obric.aiagent.plugin")).setMuted(r3);
        return;
    }

    @Override // com.obric.autogui.common.api.space.IOperatingSpaceManager
    public void setGlobalDisabledApps(Collection<String> r3) {
        Collection<String> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin");
        o.e(r4, "packages");
        this.mGlobalDisabledApps = r4;
    }

    private final void attachSurfaceHost(DisplayHost.Surface r10) {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mCurrentSurfaceHolder.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        SurfaceHolder r1 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r0.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
    L6:
        SurfaceHolder r11 = r10.getSurfaceView().getHolder();
        if (r1 == null) goto L9;
        Surface r3 = r1.getSurface();
    L10:
        Loog.INSTANCE.i(getLogTag(), "[SurfaceHolder] attachMonitor: oldHolder=" + describeHolder(r1) + ", oldSurface=" + describeSurface(r3) + ", newHolder=" + describeHolder(r11) + ", newSurface=" + describeSurface(r11.getSurface()) + ", activeSpace=" + this.activeSpace);
        if (r1 == null) goto L13;
        Loog.INSTANCE.i(getLogTag(), "[SurfaceHolder] attachMonitor: removeCallback holder=" + describeHolder(r1));
    L13:
        if (r1 == null) goto L15;
        r1.removeCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(this.surfaceHolderMonitorCallback, SurfaceHolder.Callback.class, "com.obric.aiagent.plugin"));
    L15:
        this.mCurrentSurfaceHolder.set(new WeakReference(r11));
        Loog.INSTANCE.i(getLogTag(), "[SurfaceHolder] attachMonitor: addCallback holder=" + describeHolder(r11) + ", currentHolder=" + describeCurrentHolder());
        r11.addCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(this.surfaceHolderMonitorCallback, SurfaceHolder.Callback.class, "com.obric.aiagent.plugin"));
        Surface r2 = r11.getSurface();
        if (r2 != null) goto L18;
        return;
    L18:
        if (r2.isValid() == false) goto L22;
        AOThreadingTools.INSTANCE.launchUI((m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, r11, r2, null), m.class, "com.obric.aiagent.plugin"));
        return;
    L22:
        return;
    L9:
        r3 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    private final void detachSurfaceHost(DisplayHost.Surface r11) {
        SurfaceHolder r12 = r11.getSurfaceView().getHolder();
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mCurrentSurfaceHolder.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        SurfaceHolder r1 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r0.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
    L6:
        Surface r3 = r12.getSurface();
        Loog.INSTANCE.i(getLogTag(), "[SurfaceHolder] detachMonitor: holder=" + describeHolder(r12) + ", currentHolder=" + describeHolder(r1) + ", surface=" + describeSurface(r3) + ", activeSpace=" + this.activeSpace);
        r12.removeCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(this.surfaceHolderMonitorCallback, SurfaceHolder.Callback.class, "com.obric.aiagent.plugin"));
        i.a(an.a((g) ZeusTransformUtils.preCheckCast(bd.b(), g.class, "com.obric.aiagent.plugin")), null, ao.f38854d, (m) ZeusTransformUtils.preCheckCast(new C11431(this, r12, r3, null), m.class, "com.obric.aiagent.plugin"), 1, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final String describeHolder(SurfaceHolder r3) {
        SurfaceHolder r2 = (SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L6;
        return "null";
    L6:
        int r4 = System.identityHashCode(r2);
        StringBuilder r5 = new StringBuilder().append("SurfaceHolder@");
        String r0 = Integer.toString(r4, d.o.a.a(16));
        o.c(r0, "toString(...)");
        return r5.append(r0).append('(').append(r4).append(')').toString();
    }

    private final String describeSurface(Surface r4) {
        if (r4 != null) goto L5;
        return "null";
    L5:
        int r3 = System.identityHashCode(r4);
        StringBuilder r0 = new StringBuilder().append("Surface@");
        String r1 = Integer.toString(r3, d.o.a.a(16));
        o.c(r1, "toString(...)");
        return r0.append(r1).append('(').append(r3).append(", valid=").append(r4.isValid()).append(')').toString();
    }

    private final String describeCurrentHolder() {
        WeakReference r0 = (WeakReference) ZeusTransformUtils.preCheckCast(this.mCurrentSurfaceHolder.get(), WeakReference.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        SurfaceHolder r1 = (SurfaceHolder) ZeusTransformUtils.preCheckCast(r0.get(), SurfaceHolder.class, "com.obric.aiagent.plugin");
    L7:
        return describeHolder(r1);
    L5:
        r1 = null;
        goto L7
    }
}
