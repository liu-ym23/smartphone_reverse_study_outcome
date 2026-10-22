package com.obric.autogui.common.api.agent.blacklist;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AppBlackListEventHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppBlackListEventHolder implements IAppBlackListEventHolder {
    public static final AppBlackListEventHolder INSTANCE = null;
    private static final String TAG = "AppBL-Holder";
    private static final AtomicReference<IAppBlackListEventHolder> mCurrentHolder = null;

    /* JADX INFO: renamed from: com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder$lock$2, reason: invalid class name */
    /* JADX INFO: compiled from: AppBlackListEventHolder.kt */
    @f(b = "AppBlackListEventHolder.kt", c = {57}, d = "invokeSuspend", e = "com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolder$lock$2")
    static final class AnonymousClass2 extends l implements m<IAppBlackListEventHolder, d<? super x>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(d<? super AnonymousClass2> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            AnonymousClass2 r4 = new AnonymousClass2((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
            r4.L$0 = r2;
            return (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(IAppBlackListEventHolder r3, d<? super x> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((IAppBlackListEventHolder) ZeusTransformUtils.wrapperContextForParams(r3, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(IAppBlackListEventHolder r3, d<? super x> r4) {
            return invoke2((IAppBlackListEventHolder) ZeusTransformUtils.preCheckCast(r3, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            IAppBlackListEventHolder r6 = (IAppBlackListEventHolder) ZeusTransformUtils.preCheckCast(this.L$0, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
            d<? super x> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            if (r6.lock(r2) != r0) goto L12;
            return r0;
        }
    }

    public static /* synthetic */ x lambda$MDFpxlHd8UlUodO24pW_BqJNEfY(AppBlackListEvent r0, IAppBlackListEventHolder r1) {
        return setBlackListEvent$lambda$1(r0, r1);
    }

    public static /* synthetic */ x lambda$P52uVElP0DM3D0X2MFG2QG7iZBY(IAppBlackListEventHolder r0) {
        return unlock$lambda$0(r0);
    }

    public static /* synthetic */ x lambda$gqf2jmTcat0EyIuAjIP4H1JZS90(IAppBlackListEventHolder r0) {
        return clearBlackListEvent$lambda$3(r0);
    }

    public static /* synthetic */ AppBlackListEvent lambda$x8_JlDuEMaktGMTWQzakip51r2I(IAppBlackListEventHolder r0) {
        return getBlackListEvent$lambda$2(r0);
    }

    private AppBlackListEventHolder() {
    }

    public static final /* synthetic */ Object access$withCurrentHolderSuspend(AppBlackListEventHolder r2, m r3, d r4) {
        return r2.withCurrentHolderSuspend((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    static {
        INSTANCE = new AppBlackListEventHolder();
        mCurrentHolder = new AtomicReference(null);
    }

    private final <T> T withCurrentHolder(d.h.a.b<? super IAppBlackListEventHolder, ? extends T> r3) {
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        IAppBlackListEventHolder r4 = (IAppBlackListEventHolder) ZeusTransformUtils.preCheckCast(mCurrentHolder.get(), IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        Loog.INSTANCE.w(TAG, "the current holder is null.");
        return null;
    L7:
        return (T) r2.invoke(r4);
    }

    private final <T> Object withCurrentHolderSuspend(m<? super IAppBlackListEventHolder, ? super d<? super T>, ? extends Object> r3, d<? super T> r4) {
        m r2 = (m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin");
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        IAppBlackListEventHolder r6 = (IAppBlackListEventHolder) ZeusTransformUtils.preCheckCast(mCurrentHolder.get(), IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        Loog.INSTANCE.w(TAG, "the current holder is null.");
        return null;
    L7:
        return r2.invoke(r6, r5);
    }

    public final void clearHolder() {
        Loog r3 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("clearHolder(), currentHolder=");
        AtomicReference<IAppBlackListEventHolder> r1 = mCurrentHolder;
        r3.i(TAG, r0.append(r1.get()).toString());
        r1.set(null);
    }

    public final void acquireNewHolder() {
        Loog r3 = Loog.INSTANCE;
        StringBuilder r0 = new StringBuilder().append("acquireNewHolder(), currentHolder=");
        AtomicReference<IAppBlackListEventHolder> r1 = mCurrentHolder;
        r3.i(TAG, r0.append(r1.get()).toString());
        r1.set(new AppBlackListEventHolderImpl());
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public Object lock(d<? super x> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return withCurrentHolderSuspend((m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), m.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void unlock() {
        withCurrentHolder($$Lambda$AppBlackListEventHolder$P52uVElP0DM3D0X2MFG2QG7iZBY.INSTANCE);
    }

    private static final x unlock$lambda$0(IAppBlackListEventHolder r2) {
        IAppBlackListEventHolder r3 = (IAppBlackListEventHolder) ZeusTransformUtils.wrapperContextForParams(r2, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$this$withCurrentHolder");
        r3.unlock();
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void setBlackListEvent(final AppBlackListEvent r2) {
        d.h.b.o.e(r2, "event");
        withCurrentHolder(new $$Lambda$AppBlackListEventHolder$MDFpxlHd8UlUodO24pW_BqJNEfY(r2));
    }

    private static final x setBlackListEvent$lambda$1(AppBlackListEvent r2, IAppBlackListEventHolder r3) {
        IAppBlackListEventHolder r4 = (IAppBlackListEventHolder) ZeusTransformUtils.wrapperContextForParams(r3, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "$this$withCurrentHolder");
        r4.setBlackListEvent(r2);
        return x.f38692a;
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public AppBlackListEvent getBlackListEvent() {
        return (AppBlackListEvent) ZeusTransformUtils.preCheckCast(withCurrentHolder($$Lambda$AppBlackListEventHolder$x8_JlDuEMaktGMTWQzakip51r2I.INSTANCE), AppBlackListEvent.class, "com.obric.aiagent.plugin");
    }

    private static final AppBlackListEvent getBlackListEvent$lambda$2(IAppBlackListEventHolder r2) {
        IAppBlackListEventHolder r3 = (IAppBlackListEventHolder) ZeusTransformUtils.wrapperContextForParams(r2, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$this$withCurrentHolder");
        return r3.getBlackListEvent();
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void clearBlackListEvent() {
        withCurrentHolder($$Lambda$AppBlackListEventHolder$gqf2jmTcat0EyIuAjIP4H1JZS90.INSTANCE);
    }

    private static final x clearBlackListEvent$lambda$3(IAppBlackListEventHolder r2) {
        IAppBlackListEventHolder r3 = (IAppBlackListEventHolder) ZeusTransformUtils.wrapperContextForParams(r2, IAppBlackListEventHolder.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$this$withCurrentHolder");
        r3.clearBlackListEvent();
        return x.f38692a;
    }
}
