package com.obric.autoaction.foundation;

import android.content.Context;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.privacy.IPrivacyService;
import com.obric.autogui.common.api.AOAgentRobotsTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.foundation.IAutoActionFoundationReadyTask;
import com.obric.autogui.common.api.logging.IAutoActionLoggingApi;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AutoActionFoundation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoActionFoundation {
    public static final AutoActionFoundation INSTANCE = null;
    private static final String TAG = "AutoActionApp";
    private static Context mContext;
    private static boolean mCreateRequested;
    private static Context mCreateRequestedContext;
    private static FoundationStatus mStatus;
    private static final AtomicBoolean sCreateOnce = null;
    private static final Object sCreateRequestLock = null;
    private static final w<x> sCreatedDeferred = null;
    private static final am sInitScope = null;
    private static final w<x> sReadyDeferred = null;

    /* JADX INFO: renamed from: com.obric.autoaction.foundation.AutoActionFoundation$createInternalOnce$1, reason: invalid class name */
    /* JADX INFO: compiled from: AutoActionFoundation.kt */
    @f(b = "AutoActionFoundation.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.foundation.AutoActionFoundation$createInternalOnce$1")
    static final class AnonymousClass1 extends l implements m<am, d<? super x>, Object> {
        int label;

        AnonymousClass1(d<? super AnonymousClass1> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass1((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
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
        public final Object invokeSuspend(Object r1) {
            b.a();
            if (this.label != 0) goto L7;
            o.a(r1);
            AOPlatform.INSTANCE.init();
            AutoActionFoundation.access$setStatus(AutoActionFoundation.INSTANCE, FoundationStatus.Ready);
            AutoActionFoundation.access$getSReadyDeferred$p().a(x.f38692a);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ x lambda$WW4itM8_ThzvJR41xOEy7WC5hU8() {
        return create$lambda$1();
    }

    private AutoActionFoundation() {
    }

    public static final /* synthetic */ w access$getSReadyDeferred$p() {
        return sReadyDeferred;
    }

    public static final /* synthetic */ void access$setStatus(AutoActionFoundation r0, FoundationStatus r1) {
        r0.setStatus(r1);
    }

    static {
        INSTANCE = new AutoActionFoundation();
        mStatus = FoundationStatus.NotInitialised;
        sInitScope = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
        sCreateOnce = new AtomicBoolean(false);
        sCreateRequestLock = new Object();
        sCreatedDeferred = y.a(null, 1, null);
        sReadyDeferred = y.a(null, 1, null);
    }

    public final w<x> getCreatedDeferred() {
        return sCreatedDeferred;
    }

    public final w<x> getReadyDeferred() {
        return sReadyDeferred;
    }

    public final Context getBaseContext() {
        return mContext;
    }

    public static final void create(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        Object r0 = sCreateRequestLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (mCreateRequested == false) goto L9;
        ILogDepend.Companion.d(TAG, "[Create] Skip: create already requested.");     // Catch: Throwable -> L19
        monitor-exit(r0);
        return;
    L9:
        AutoActionFoundation r1 = INSTANCE;     // Catch: Throwable -> L19
        boolean r2 = true;
        mCreateRequested = true;     // Catch: Throwable -> L19
        mCreateRequestedContext = r4;     // Catch: Throwable -> L19
        if (r1.isPrivacyStatementAgreed() == false) goto L13;
        r2 = false;
    L13:
        x r5 = x.f38692a;     // Catch: Throwable -> L19
        monitor-exit(r0);
        if (r2 == false) goto L17;
        ILogDepend.Companion.i(TAG, "[Create] Deferred until privacy statement agreed.");
        r1.runAfterPrivacyStatementAgreed($$Lambda$AutoActionFoundation$WW4itM8_ThzvJR41xOEy7WC5hU8.INSTANCE);
        return;
    L17:
        ILogDepend.Companion.i(TAG, "[Create] Privacy statement already agreed.");
        r1.createInternalOnce();
    }

    private static final x create$lambda$1() {
        INSTANCE.createInternalOnce();
        return x.f38692a;
    }

    private final void createInternalOnce() {
        if (sCreateOnce.compareAndSet(false, true) == true) goto L6;
        ILogDepend.Companion.d(TAG, "[Create] Skip: create already executed.");
        return;
    L6:
        Object r0 = sCreateRequestLock;
        monitor-enter(r0);
        Context r1 = mCreateRequestedContext;     // Catch: Throwable -> L17
        monitor-exit(r0);
        if (r1 != null) goto L12;
        return;
    L12:
        IAutoActionLoggingApi r2 = (IAutoActionLoggingApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionLoggingApi.class), IAutoActionLoggingApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L15;
        r2.initLoggingModule(r1);
    L15:
        Loog.INSTANCE.i(TAG, "[Create] O-Auto App (vc: " + IAppContext.Companion.getVersionCode() + ", buildTime: " + AOHostAppTools.INSTANCE.getBuildTime() + ", vd: " + AOHostAppTools.INSTANCE.getAppVersionCode() + ", vn: " + IAppContext.Companion.getVersionName() + ')');
        AOAgentRobotsTools.INSTANCE.registerAgentAsync(r1, "obric_oauto", AOAgentRobotsTools.AgentType.AUTONOMOUS);
        mContext = r1;
        setStatus(FoundationStatus.Created);
        sCreatedDeferred.a(x.f38692a);
        i.a(sInitScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private final void setStatus(FoundationStatus r8) {
        FoundationStatus r7 = mStatus;
        mStatus = r8;
        Loog.INSTANCE.i(TAG, "[SetStatus] O-Auto App Status: " + r7 + " -> " + r8);
        if (r7 == FoundationStatus.Created) goto L5;
        return;
    L5:
        if (r8 != FoundationStatus.Ready) goto L12;
        Set r9 = ServiceManager.get().getServices(IAutoActionFoundationReadyTask.class);
        d.h.b.o.b(r9, "ServiceManager.get().getServices(T::class.java)");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r10.hasNext() == false) goto L13;
        i.a(sInitScope, null, null, (m) ZeusTransformUtils.preCheckCast(new AutoActionFoundation$setStatus$1$1((IAutoActionFoundationReadyTask) ZeusTransformUtils.preCheckCast(r10.next(), IAutoActionFoundationReadyTask.class, "com.obric.aiagent.plugin"), null), m.class, "com.obric.aiagent.plugin"), 3, null);
        goto L8
    L13:
        return;
    }

    public final FoundationStatus getStatus() {
        return mStatus;
    }

    private final boolean isPrivacyStatementAgreed() {
        IPrivacyService r2 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r2.isAgreed() != true) goto L8;
        return true;
    L8:
        return false;
    }

    private final void runAfterPrivacyStatementAgreed(a<x> r3) {
        a<x> r2 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        IPrivacyService r4 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        r4.registerAgreeListener(r2);
        return;
    }
}
