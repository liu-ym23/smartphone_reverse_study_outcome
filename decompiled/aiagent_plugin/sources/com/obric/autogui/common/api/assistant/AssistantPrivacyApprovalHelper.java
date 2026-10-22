package com.obric.autogui.common.api.assistant;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.OperationCanceledException;
import com.obric.aiagent.privacy.IPrivacyService;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;

/* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AssistantPrivacyApprovalHelper {
    private static final String AUTHORITY = "com.larus.nova.privacy.provider";
    private static final long CACHE_DURATION_MS = 5000;
    private static final Uri CONTENT_URI = null;
    public static final Companion Companion = null;
    private static final long QUERY_TIMEOUT_MS = 2000;
    private static final String TAG = "Assist/PrivApproval";
    private volatile CachedStatus mCachedStatus;
    private boolean mInitialised;
    private final Observer mObserver;
    private final am mScope;

    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    private static final class CachedStatus {
        private final AssistantPrivacyApprovalStatus status;
        private final long timestamp;

        public static /* synthetic */ CachedStatus copy$default(CachedStatus r0, AssistantPrivacyApprovalStatus r1, long r2, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.status;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.timestamp;
        L9:
            return r0.copy(r1, r2);
        }

        public final AssistantPrivacyApprovalStatus component1() {
            return this.status;
        }

        public final long component2() {
            return this.timestamp;
        }

        public final CachedStatus copy(AssistantPrivacyApprovalStatus r1, long r2) {
            o.e(r1, "status");
            return new CachedStatus(r1, r2);
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, CachedStatus.class) == true) goto L8;
            return false;
        L8:
            CachedStatus r8 = (CachedStatus) ZeusTransformUtils.preCheckCast(r7, CachedStatus.class, "com.obric.aiagent.plugin");
            if (this.status == r8.status) goto L12;
            return false;
        L12:
            if (this.timestamp == r8.timestamp) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.status.hashCode() * 31) + Long.hashCode(this.timestamp);
        }

        public String toString() {
            return "CachedStatus(status=" + this.status + ", timestamp=" + this.timestamp + ')';
        }

        public CachedStatus(AssistantPrivacyApprovalStatus r2, long r3) {
            o.e(r2, "status");
            this.status = r2;
            this.timestamp = r3;
        }

        public /* synthetic */ CachedStatus(AssistantPrivacyApprovalStatus r1, long r2, int r4, h r5) {
            if ((r4 & 2) == 0) goto L5;
            r2 = -1;
        L5:
            this(r1, r2);
        }

        public final AssistantPrivacyApprovalStatus getStatus() {
            return this.status;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(h r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    private final class Observer extends ContentObserver {
        final /* synthetic */ AssistantPrivacyApprovalHelper this$0;

        public Observer(AssistantPrivacyApprovalHelper r2) {
            this.this$0 = r2;
            super(new Handler(Looper.getMainLooper()));
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            AssistantPrivacyApprovalHelper.access$onObservedChange(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApproval$2, reason: invalid class name */
    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    @f(b = "AssistantPrivacyApprovalHelper.kt", c = {121}, d = "invokeSuspend", e = "com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApproval$2")
    static final class AnonymousClass2 extends l implements m<am, d<? super x>, Object> {
        final /* synthetic */ w<AssistantPrivacyApprovalStatus> $approvedStatus;
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ AssistantPrivacyApprovalHelper this$0;

        AnonymousClass2(AssistantPrivacyApprovalHelper r3, Context r4, w<AssistantPrivacyApprovalStatus> r5, d<? super AnonymousClass2> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            w<AssistantPrivacyApprovalStatus> r8 = (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            this.$context = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.$approvedStatus = r8;
            super(2, r9);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.this$0, this.$context, this.$approvedStatus, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super x> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            AssistantPrivacyApprovalStatus r7 = (AssistantPrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(r6, AssistantPrivacyApprovalStatus.class, "com.obric.aiagent.plugin");
            this.$approvedStatus.a(r7);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            Loog.INSTANCE.d(AssistantPrivacyApprovalHelper.TAG, "[Assist-PrivApproval] querying the Assistant about approval status.");
            AssistantPrivacyApprovalHelper r8 = this.this$0;
            Context r2 = this.$context;
            d<? super AssistantPrivacyApprovalStatus> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r6 = r8.checkApprovalAsync(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApproval$3, reason: invalid class name */
    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    @f(b = "AssistantPrivacyApprovalHelper.kt", c = {127}, d = "invokeSuspend", e = "com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApproval$3")
    static final class AnonymousClass3 extends l implements m<am, d<? super AssistantPrivacyApprovalStatus>, Object> {
        final /* synthetic */ w<AssistantPrivacyApprovalStatus> $approvedStatus;
        int label;

        AnonymousClass3(w<AssistantPrivacyApprovalStatus> r3, d<? super AnonymousClass3> r4) {
            w<AssistantPrivacyApprovalStatus> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.$approvedStatus = r5;
            super(2, r6);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.$approvedStatus, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super AssistantPrivacyApprovalStatus> r4) {
            return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(am r3, d<? super AssistantPrivacyApprovalStatus> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AnonymousClass3.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = b.a();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<AssistantPrivacyApprovalStatus> r6 = this.$approvedStatus;
            d<? super AssistantPrivacyApprovalStatus> r2 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.label = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper$checkApprovalAsync$1, reason: invalid class name */
    /* JADX INFO: compiled from: AssistantPrivacyApprovalHelper.kt */
    @f(b = "AssistantPrivacyApprovalHelper.kt", c = {139}, d = "checkApprovalAsync", e = "com.obric.autogui.common.api.assistant.AssistantPrivacyApprovalHelper")
    static final class AnonymousClass1 extends d.c.b.a.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AssistantPrivacyApprovalHelper this$0;

        AnonymousClass1(AssistantPrivacyApprovalHelper r3, d<? super AnonymousClass1> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.checkApprovalAsync(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    public AssistantPrivacyApprovalHelper() {
        this.mCachedStatus = new CachedStatus(AssistantPrivacyApprovalStatus.CannotObtain, 0, 2, null);
        this.mScope = an.a((g) ZeusTransformUtils.preCheckCast(bd.c(), g.class, "com.obric.aiagent.plugin"));
        this.mObserver = new Observer(this);
    }

    public static final /* synthetic */ AssistantPrivacyApprovalStatus access$checkApprovalSync(AssistantPrivacyApprovalHelper r2, Context r3, CancellationSignal r4) {
        return r2.checkApprovalSync((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ am access$getMScope$p(AssistantPrivacyApprovalHelper r0) {
        return r0.mScope;
    }

    public static final /* synthetic */ void access$onObservedChange(AssistantPrivacyApprovalHelper r0) {
        r0.onObservedChange();
    }

    static {
        Companion = new Companion(null);
        Uri r0 = Uri.parse("content://com.larus.nova.privacy.provider/status");
        o.c(r0, "parse(...)");
        CONTENT_URI = r0;
    }

    private final CachedStatus fetchUnexpiredCachedStatus() {
        long r0 = System.currentTimeMillis();
        CachedStatus r4 = this.mCachedStatus;
        if ((r0 - r4.getTimestamp()) < 5000) goto L5;
        return null;
    L5:
        if (r4.getTimestamp() == (-1)) goto L9;
        return r4;
    L9:
        return null;
    }

    private final void onObservedChange() {
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] content provider changed.");
        if (AutoActionFoundation.INSTANCE.getStatus() == FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.w(TAG, "[Assist-PrivApproval] onObservedChange() and the App is in an initialised state.");
        return;
    L6:
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] onObservedChange() and the App is not initialised. Exiting.");
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public final void init(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        if (this.mInitialised == false) goto L5;
        return;
    L5:
        this.mInitialised = true;
        ZeusProviderTransform.registerContentObserver(r8.getContentResolver(), CONTENT_URI, true, (ContentObserver) ZeusTransformUtils.preCheckCast(this.mObserver, ContentObserver.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "[Assist-PrivApproval] initialised and registered ContentObserver.");
        checkApproval(r8);
    }

    public final AssistantPrivacyApprovalStatus checkApproval(Context r2) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), "context");
        IPrivacyService r1 = (IPrivacyService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPrivacyService.class), IPrivacyService.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (r1 != null) goto L5;
    L7:
        r3 = false;
    L8:
        if (r3 == false) goto L11;
        return AssistantPrivacyApprovalStatus.Approved;
    L11:
        return AssistantPrivacyApprovalStatus.NotApproved;
    L5:
        if (r1.isAgreed() != true) goto L7;
        goto L7
    }

    public final Object checkApprovalAsync(Context r10, d<? super AssistantPrivacyApprovalStatus> r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d r13 = (d) ZeusTransformUtils.wrapperContextForParams(r11, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, AnonymousClass1.class) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) ZeusTransformUtils.preCheckCast(r13, AnonymousClass1.class, "com.obric.aiagent.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.result;
        Object r2 = b.a();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        CancellationSignal r9 = (CancellationSignal) ZeusTransformUtils.preCheckCast(r0.L$0, CancellationSignal.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L22:
        AssistantPrivacyApprovalStatus r15 = (AssistantPrivacyApprovalStatus) ZeusTransformUtils.preCheckCast(r14, AssistantPrivacyApprovalStatus.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L26;
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] query timeout");
        r9.cancel();
        return AssistantPrivacyApprovalStatus.Timeout;
    L26:
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        CachedStatus r16 = fetchUnexpiredCachedStatus();
        if (r16 != null) goto L17;
        CancellationSignal r17 = new CancellationSignal();
        m r18 = (m) ZeusTransformUtils.preCheckCast(new AssistantPrivacyApprovalHelper$checkApprovalAsync$result$1(this, r12, r17, null), m.class, "com.obric.aiagent.plugin");
        r0.L$0 = r17;
        r0.label = 1;
        Object r19 = dg.b(QUERY_TIMEOUT_MS, r18, r0);
        if (r19 != r2) goto L21;
        return r2;
    L21:
        r14 = r19;
        r9 = r17;
        goto L22
    L17:
        return r16.getStatus();
    L7:
        r0 = new AnonymousClass1(this, r13);
        goto L8
    }

    private final AssistantPrivacyApprovalStatus checkApprovalSync(Context r13, CancellationSignal r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        CachedStatus r1 = fetchUnexpiredCachedStatus();
        if (r1 != null) goto L5;
        Cursor r2 = null;
        r2 = ZeusProviderTransform.query(r15.getContentResolver(), CONTENT_URI, new String[]{"value"}, null, null, null, r14, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r2 != null) goto L10;
    L15:
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] query failed: cursor is null");     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        AssistantPrivacyApprovalStatus r16 = AssistantPrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L16:
        Loog.INSTANCE.d(TAG, "[Assist-PrivApproval] query result: " + r16);     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        if (r2 == null) goto L29;
    L18:
        r2.close();
    L29:
        CachedStatus r17 = new CachedStatus(r16, System.currentTimeMillis());
        this.mCachedStatus = r17;
        return r17.getStatus();
    L10:
        if (r2.moveToFirst() == false) goto L15;
        if (r2.getInt(0) != 1) goto L14;
        r16 = AssistantPrivacyApprovalStatus.Approved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
        goto L16
    L14:
        r16 = AssistantPrivacyApprovalStatus.NotApproved;     // Catch: Throwable -> L19 Exception -> L21 OperationCanceledException -> L25
    L19:
        th = move-exception;
        if (r2 == null) goto L33;
        r2.close();
    L33:
        throw th;
    L25:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] query timeout (" + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r16 = AssistantPrivacyApprovalStatus.Timeout;     // Catch: Throwable -> L19
        if (r2 == null) goto L29;
    L21:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "[Assist-PrivApproval] query failed (exception, " + e + ')', (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        r16 = AssistantPrivacyApprovalStatus.CannotObtain;     // Catch: Throwable -> L19
        if (r2 == null) goto L29;
    L5:
        return r1.getStatus();
    }
}
