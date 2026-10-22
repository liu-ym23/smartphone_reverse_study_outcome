package com.obric.autogui.common.api.agent.blacklist;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.h.b.h;
import d.o;
import d.x;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.f.a;
import kotlinx.coroutines.f.c;

/* JADX INFO: compiled from: AppBlackListEventHolderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppBlackListEventHolderImpl implements IAppBlackListEventHolder {
    public static final Companion Companion = null;
    private static final String TAG = "AppBL-Holder/Impl";
    private final a mMutex;
    private AtomicReference<AppBlackListEvent> mOngoingBlackListEvent;

    /* JADX INFO: compiled from: AppBlackListEventHolderImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolderImpl$lock$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppBlackListEventHolderImpl.kt */
    @f(b = "AppBlackListEventHolderImpl.kt", c = {35}, d = "lock", e = "com.obric.autogui.common.api.agent.blacklist.AppBlackListEventHolderImpl")
    static final class AnonymousClass1 extends d {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AppBlackListEventHolderImpl this$0;

        AnonymousClass1(AppBlackListEventHolderImpl r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.lock((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AppBlackListEventHolderImpl() {
        this.mOngoingBlackListEvent = new AtomicReference(null);
        this.mMutex = c.a(false, 1, null);
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public Object lock(d.c.d<? super x> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r6, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r1 = b.a();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        o.a(r7);
    L17:
        Loog.INSTANCE.d(TAG, "[BL] the EventHolder locked.");
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r7);
        a r4 = this.mMutex;
        r0.label = 1;
        if (a.C1058a.a(r4, null, r0, 1, null) != r1) goto L17;
        return r1;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void unlock() {
        a.C1058a.b(this.mMutex, null, 1, null);     // Catch: IllegalStateException -> L5
        Loog.INSTANCE.d(TAG, "[BL] the EventHolder unlocked.");     // Catch: IllegalStateException -> L5
        return;
    L5:
        Loog.INSTANCE.d(TAG, "[BL] the EventHolder wasn't locked.");
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void setBlackListEvent(AppBlackListEvent r2) {
        d.h.b.o.e(r2, "event");
        this.mOngoingBlackListEvent.set(r2);
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public AppBlackListEvent getBlackListEvent() {
        return (AppBlackListEvent) ZeusTransformUtils.preCheckCast(this.mOngoingBlackListEvent.get(), AppBlackListEvent.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.agent.blacklist.IAppBlackListEventHolder
    public void clearBlackListEvent() {
        this.mOngoingBlackListEvent.set(null);
    }
}
