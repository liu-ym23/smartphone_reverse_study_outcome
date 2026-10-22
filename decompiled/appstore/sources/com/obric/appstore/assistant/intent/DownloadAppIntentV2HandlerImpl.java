package com.obric.appstore.assistant.intent;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.text.format.Formatter;
import com.bytedanceos.common.download.d;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.AppInfoKtxKt;
import com.bytedanceos.common.privacy.PrivacyUtils;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.ui.JumpActivity;
import com.obric.appstore.buss.repo.StoreRepo;
import com.obric.appstore.network.entity.CommonAppEntity;
import com.obric.appstore.network.entity.PageResp;
import com.obric.appstore.network.entity.UpdateAppInfoReq;
import com.obric.appstore.network.entity.UpdateAppInfoResp;
import com.obric.appstore.network.entity.UpdateAppListResp;
import com.obric.appstore.network.g;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.SystemDownloadAppParams;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.smt.obric.appstore.assistant.intent.DownloadAppIntentV2Handler;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.EnqueueAppInstallTaskUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.GetAppStatusUseCase;
import com.smt.obric.appstore.domain.usecase.app.install.ResumeAppDownloadUseCase;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.b;
import kotlin.c;
import kotlin.collections.b0;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.y;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadAppIntentV2HandlerImpl implements DownloadAppIntentV2Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadAppIntentV2HandlerImpl f10526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineExceptionHandler f10527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f10528c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f10529d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f10530e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f10531f = null;

    public static final class a extends kotlin.coroutines.a implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.a r10) {
            super(r10);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r10, Throwable r11) {
            j.q("[AI_Intent] [DownloadApp][V2] coroutine failed", r11);
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl$handle$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.appstore.assistant.intent.DownloadAppIntentV2HandlerImpl", f = "DownloadAppIntentV2HandlerImpl.kt", i = {0, 0, 1, 1}, l = {86, 87}, m = "handle", n = {"this", "params", "this", "params"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ DownloadAppIntentV2HandlerImpl this$0;

        public AnonymousClass1(DownloadAppIntentV2HandlerImpl r10, Continuation<? super AnonymousClass1> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.result = r10;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handle(null, null, this);
        }
    }

    static {
        f10526a = new DownloadAppIntentV2HandlerImpl();
        a r10 = new a(CoroutineExceptionHandler.Key);
        f10527b = r10;
        f10528c = d0.a(x1.b(null, 1, null).plus(l0.c().e()).plus(r10));
        f10529d = b.b(DownloadAppIntentV2HandlerImpl$getAppStatusUseCase$2.INSTANCE);
        f10530e = b.b(DownloadAppIntentV2HandlerImpl$enqueueAppInstallTaskUseCase$2.INSTANCE);
        f10531f = b.b(DownloadAppIntentV2HandlerImpl$resumeAppDownloadUseCase$2.INSTANCE);
    }

    public DownloadAppIntentV2HandlerImpl() {
    }

    public static /* synthetic */ AppInfoEntity C(DownloadAppIntentV2HandlerImpl r10, he.a r11, Context r12, boolean r13, int r14, boolean r15, int r16, Object r17) {
        if ((r16 & 4) == 0) goto L5;
        int r18 = 0;
    L7:
        if ((r16 & 8) == 0) goto L9;
        boolean r19 = false;
    L11:
        return r10.B(r11, r12, r13, r18, r19);
    L9:
        r19 = r15;
        goto L11
    L5:
        r18 = r14;
        goto L7
    }

    public static final /* synthetic */ Object a(DownloadAppIntentV2HandlerImpl r10, SystemDownloadAppParams r11, Context r12, Continuation r13) {
        return r10.k(r11, r12, r13);
    }

    public static final /* synthetic */ Object b(DownloadAppIntentV2HandlerImpl r10, SystemDownloadAppParams r11, Context r12, Continuation r13) {
        return r10.m(r11, r12, r13);
    }

    public static final /* synthetic */ Object c(DownloadAppIntentV2HandlerImpl r10, SystemDownloadAppParams r11, Context r12, Continuation r13) {
        return r10.n(r11, r12, r13);
    }

    public static final /* synthetic */ Object d(DownloadAppIntentV2HandlerImpl r10, String r11, boolean r12, Context r13, Continuation r14) {
        return r10.v(r11, r12, r13, r14);
    }

    public static final /* synthetic */ Object e(DownloadAppIntentV2HandlerImpl r10, String r11, Context r12, Continuation r13) {
        return r10.x(r11, r12, r13);
    }

    public static final /* synthetic */ Object f(DownloadAppIntentV2HandlerImpl r10, he.a r11, he.b r12, Context r13, Continuation r14) {
        return r10.z(r11, r12, r13, r14);
    }

    public static /* synthetic */ Object w(DownloadAppIntentV2HandlerImpl r10, String r11, boolean r12, Context r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = null;
    L9:
        return r10.v(r11, r12, r13, r14);
    }

    public final IntentResult A(List r14) {
        AppInfoEntity[] r13 = (AppInfoEntity[]) r14.toArray(new AppInfoEntity[0]);
        IntentResult r15 = new IntentResult(0, r13, null, null, false, false, 0, null, null, null, 1020, null);
        r15.putEntityFallback(r13, AppInfoEntity.class.getName(), Boolean.TRUE);
        return r15;
    }

    public final AppInfoEntity B(he.a r15, Context r16, boolean r17, int r18, boolean r19) {
        long r10 = System.currentTimeMillis();
        String r11 = r15.j();
        String r12 = r15.i();
        String r13 = r15.j();
        if (r19 == false) goto L6;
        String r14 = "";
    L5:
        String r110 = r14;
        String r111 = "market://details?id=" + r15.j();
        Long r20 = r15.c();
        if (r20 == null) goto L14;
        long r21 = r20.longValue();
    L16:
        return new AppInfoEntity(r11, r10, r10, r12, r13, r18, r17, r110, r111, Formatter.formatFileSize(r16, r21));
    L14:
        r21 = 0;
        goto L16
    L6:
        r14 = r15.h();
        if (o.r(r14) == false) goto L5;
        r14 = null;
        goto L5
    }

    public final int D(AppStatus r10, String r11) {
        if (q.b(r10, AppStatus.k.f17988a) == false) goto L6;
        return 0;
    L6:
        if (q.b(r10, AppStatus.i.f17984a) == false) goto L9;
        return 2;
    L9:
        if (q.b(r10, AppStatus.m.f17992a) == false) goto L12;
        return 4;
    L12:
        if (((Map) le.a.f21945a.b().getValue()).get(r11) != null) goto L14;
        return 1;
    L14:
        return 3;
    }

    public final int E(he.b r10) {
        if (((Map) le.a.f21945a.b().getValue()).get(r10.b()) != null) goto L5;
        return 1;
    L5:
        return 3;
    }

    public final void F(DispatchContext r10) {
        Long r11 = r10.getQuestionId();
        Map<String, String> r12 = r10.getExt();
        if (r11 != null) goto L6;
        j.n("[AI_Intent] [DownloadApp][V2] skip update result after privacy agreed, questionId is null");
        return;
    L6:
        h.d(f10528c, null, CoroutineStart.UNDISPATCHED, new DownloadAppIntentV2HandlerImpl$updateResultAfterPrivacyAgreed$1(r11, r12, null), 1, null);
    }

    public final he.a G(he.a r39, Context r40) {
        Long r10 = r39.c();
        if (r10 == null) goto L5;
        long r11 = r10.longValue();
    L7:
        if (r11 <= 0) goto L9;
        return r39;
    L9:
        Long r12 = t(r39);
        if (r12 == null) goto L12;
        long r13 = r12.longValue();
    L14:
        if (r13 <= 0) goto L17;
        return he.a.b(r39, 0, null, null, null, null, 0, null, null, Long.valueOf(r13), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741567, null);
    L17:
        return r39;
    L12:
        r13 = o(r39, r40);
        goto L14
    L5:
        r11 = 0;
        goto L7
    }

    public final IntentResult g(SystemDownloadAppParams r30) {
        int r10 = e.A();
        if (r10 == 0) goto L14;
        if (r10 == 1) goto L8;
        return null;
    L8:
        if (q.b(r30.getProceed(), Boolean.TRUE) == false) goto L10;
        return null;
    L10:
        if (r() == false) goto L16;
        return null;
    L16:
        return new IntentResult(ErrorCode.System.DOUBLE_CONFIRMATION_BEFORE_DOWNLOADING_ERROR, null, null, null, false, false, 0, null, null, null, 1022, null);
    L14:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    }

    public final EnqueueAppInstallTaskUseCase h() {
        return (EnqueueAppInstallTaskUseCase) f10530e.getValue();
    }

    @Override // com.smt.obric.appstore.assistant.intent.DownloadAppIntentV2Handler
    public Object handle(SystemDownloadAppParams r18, DispatchContext r19, Continuation r20) {
        DownloadAppIntentV2HandlerImpl r10 = this;
        SystemDownloadAppParams r11 = r18;
        if ((r20 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r12 = (AnonymousClass1) r20;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 == 1) goto L15;
        if (r16 != 2) goto L14;
        SystemDownloadAppParams r17 = (SystemDownloadAppParams) r12.L$1;
        DownloadAppIntentV2HandlerImpl r21 = (DownloadAppIntentV2HandlerImpl) r12.L$0;
        c.b(r14);
        r11 = r17;
        r10 = r21;
    L35:
        IntentResult r22 = (IntentResult) r14;
    L37:
        r10.u(r11, r22);
        return r22;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        SystemDownloadAppParams r23 = (SystemDownloadAppParams) r12.L$1;
        DownloadAppIntentV2HandlerImpl r24 = (DownloadAppIntentV2HandlerImpl) r12.L$0;
        c.b(r14);
        r11 = r23;
        r10 = r24;
    L27:
        r22 = (IntentResult) r14;
        goto L37
    L16:
        c.b(r14);
        j.n("[AI_Intent] [DownloadApp][V2] doAction, appName=" + r18.getAppName() + ", operateType=" + r18.getOperateType() + ", updateRange=" + r18.getUpdateRange() + ", proceed=" + r18.getProceed() + ", isSystemApp=" + r18.isSystemApp());
        if (((Boolean) PrivacyUtils.f9901a.j().getValue()).booleanValue() == true) goto L19;
        r10.F(r19);
        r10.y(r19.getContext());
        r22 = new IntentResult(201, null, null, null, false, false, 0, null, null, null, 1022, null);
        goto L37
    L19:
        Integer r25 = r18.getOperateType();
        if (r25 != null) goto L23;
    L28:
        if (r25 != null) goto L31;
    L36:
        r22 = new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
        goto L37
    L31:
        if (r25.intValue() != 1) goto L36;
        Context r26 = r19.getContext();
        r12.L$0 = r10;
        r12.L$1 = r11;
        r12.label = 2;
        r14 = r10.l(r11, r26, r12);
        if (r14 != r15) goto L35;
        return r15;
    L23:
        if (r25.intValue() != 0) goto L28;
        Context r27 = r19.getContext();
        r12.L$0 = r10;
        r12.L$1 = r11;
        r12.label = 1;
        r14 = r10.k(r11, r27, r12);
        if (r14 != r15) goto L27;
        return r15;
    L7:
        r12 = new AnonymousClass1(r10, r20);
        goto L8
    }

    public final GetAppStatusUseCase i() {
        return (GetAppStatusUseCase) f10529d.getValue();
    }

    public final ResumeAppDownloadUseCase j() {
        return (ResumeAppDownloadUseCase) f10531f.getValue();
    }

    public final Object k(SystemDownloadAppParams r29, Context r30, Continuation r31) {
        Context r10 = r30;
        int r11 = 0;
        int r12 = 4;
        if ((r31 instanceof DownloadAppIntentV2HandlerImpl$handleDownload$1) == false) goto L7;
        DownloadAppIntentV2HandlerImpl$handleDownload$1 r13 = (DownloadAppIntentV2HandlerImpl$handleDownload$1) r31;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L20;
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L16;
        if (r17 != 3) goto L15;
        int r18 = r13.I$0;
        boolean r19 = r13.Z$0;
        le.c r20 = (le.c) r13.L$4;
        he.b r21 = (he.b) r13.L$3;
        he.a r22 = (he.a) r13.L$2;
        Context r23 = (Context) r13.L$1;
        DownloadAppIntentV2HandlerImpl r24 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r15);
    L70:
        if (((Boolean) r15).booleanValue() == false) goto L72;
        boolean r110 = r19;
        le.c r25 = r20;
        DownloadAppIntentV2HandlerImpl r26 = r24;
        r11 = r18;
        he.b r27 = r21;
        he.a r28 = r22;
    L75:
        if (r11 == 0) goto L78;
        r12 = r26.E(r27);
    L77:
        int r111 = r12;
    L86:
        return r26.A(s.e(r26.B(r28, r23, true, r111, r110)));
    L78:
        if (r25 != null) goto L80;
    L82:
        if (r25 == null) goto L84;
        r111 = 2;
        goto L86
    L84:
        r12 = r26.D(r27.c(), r28.j());
        goto L77
    L80:
        if (r28.o() <= r25.b()) goto L82;
    L72:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        boolean r32 = r13.Z$0;
        he.a r33 = (he.a) r13.L$3;
        Context r112 = (Context) r13.L$2;
        SystemDownloadAppParams r113 = (SystemDownloadAppParams) r13.L$1;
        DownloadAppIntentV2HandlerImpl r114 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r15);
        r22 = r33;
    L17:
        r19 = r32;
        r27 = (he.b) r15;
        r25 = (le.c) ((Map) le.a.f21945a.b().getValue()).get(r22.j());
        if (r25 == null) goto L59;
    L61:
        if (r11 == 0) goto L74;
        IntentResult r34 = r114.g(r113);
        if (r34 == null) goto L65;
        return r34;
    L65:
        r13.L$0 = r114;
        r13.L$1 = r112;
        r13.L$2 = r22;
        r13.L$3 = r27;
        r13.L$4 = r25;
        r13.Z$0 = r19;
        r13.I$0 = r11;
        r13.label = 3;
        Object r35 = r114.z(r22, r27, r112, r13);
        if (r35 != r16) goto L68;
        return r16;
    L68:
        r23 = r112;
        r24 = r114;
        r21 = r27;
        r18 = r11;
        r20 = r25;
        r15 = r35;
        goto L70
    L74:
        r28 = r22;
        r23 = r112;
        DownloadAppIntentV2HandlerImpl r210 = r114;
        r110 = r19;
        r26 = r210;
        goto L75
    L59:
        if (t.l(new AppStatus[]{AppStatus.k.f17988a, AppStatus.b.f17970a, AppStatus.f.f17978a, AppStatus.a.f17968a}).contains(r27.c()) == false) goto L61;
        r11 = 1;
        goto L61
    L18:
        r32 = r13.Z$0;
        String r36 = (String) r13.L$3;
        Context r115 = (Context) r13.L$2;
        SystemDownloadAppParams r116 = (SystemDownloadAppParams) r13.L$1;
        DownloadAppIntentV2HandlerImpl r117 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r15);
        Object r211 = r15;
        String r37 = r36;
        r10 = r115;
    L32:
        List r118 = (List) r211;
        if (r118 == null) goto L35;
        Iterator r119 = r118.iterator();
    L38:
        if (r119.hasNext() == false) goto L43;
        Object r120 = r119.next();
        if (f10526a.q(((he.a) r120).i(), r37) == false) goto L38;
        Object r121 = r120;
    L44:
        he.a r122 = (he.a) r121;
        if (r122 != null) goto L52;
        List r38 = b0.u0(r118, 5);
        ArrayList r39 = new ArrayList(u.r(r38, 10));
        Iterator r40 = r38.iterator();
    L48:
        if (r40.hasNext() == false) goto L51;
        r39.add(C(f10526a, (he.a) r40.next(), r10, false, 0, r32, 4, null));
        goto L48
    L51:
        return r117.A(r39);
    L52:
        r13.L$0 = r117;
        r13.L$1 = r116;
        r13.L$2 = r10;
        r13.L$3 = r122;
        r13.Z$0 = r32;
        r13.label = 2;
        r15 = r117.s(r122, r13);
        if (r15 != r16) goto L55;
        return r16;
    L55:
        r112 = r10;
        r22 = r122;
        r113 = r116;
        r114 = r117;
        goto L17
    L43:
        r121 = null;
        goto L44
    L35:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L20:
        c.b(r15);
        r37 = r29.getAppName();
        if (r37 == null) goto L88;
        if (o.r(r37) == false) goto L26;
        r37 = null;
    L26:
        if (r37 == null) goto L88;
        boolean r123 = q.b(r29.isSystemApp(), tf.a.a(true));
        r13.L$0 = this;
        r116 = r29;
        r13.L$1 = r116;
        r13.L$2 = r10;
        r13.L$3 = r37;
        r13.Z$0 = r123;
        r13.label = 1;
        Object r124 = v(r37, r123, r10, r13);
        if (r124 != r16) goto L31;
        return r16;
    L31:
        r211 = r124;
        r117 = this;
        r32 = r123;
    L88:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L7:
        r13 = new DownloadAppIntentV2HandlerImpl$handleDownload$1(this, r31);
        goto L8
    }

    public final Object l(SystemDownloadAppParams r10, Context r11, Continuation r12) {
        Integer r13 = r10.getUpdateRange();
        if (r13 == null) goto L10;
        if (r13.intValue() != 1) goto L10;
        return m(r10, r11, r12);
    L10:
        return n(r10, r11, r12);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01db -> B:71:0x01de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x025e -> B:92:0x0261). Please report as a decompilation issue!!! */
    public final Object m(SystemDownloadAppParams r28, Context r29, Continuation r30) {
        DownloadAppIntentV2HandlerImpl r10 = this;
        if ((r30 instanceof DownloadAppIntentV2HandlerImpl$handleUpdateAll$1) == false) goto L7;
        DownloadAppIntentV2HandlerImpl$handleUpdateAll$1 r11 = (DownloadAppIntentV2HandlerImpl$handleUpdateAll$1) r30;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L22;
        if (r15 == 1) goto L21;
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L19;
        if (r15 == 4) goto L18;
        if (r15 != 5) goto L17;
        Object r16 = r11.L$4;
        Iterator r17 = (Iterator) r11.L$3;
        Collection r18 = (Collection) r11.L$2;
        Context r19 = (Context) r11.L$1;
        DownloadAppIntentV2HandlerImpl r20 = (DownloadAppIntentV2HandlerImpl) r11.L$0;
        c.b(r13);
        DownloadAppIntentV2HandlerImpl r110 = r20;
        Context r21 = r19;
        Object r22 = r16;
        Collection r23 = r18;
    L93:
        if (((Boolean) r13).booleanValue() == false) goto L95;
        r23.add(r22);
    L95:
        Iterator r24 = r17;
    L82:
        DownloadAppIntentV2HandlerImpl r25 = r110;
        if (r24.hasNext() == false) goto L96;
        r22 = r24.next();
        he.a r26 = (he.a) r22;
        DownloadAppIntentV2HandlerImpl r111 = f10526a;
        r11.L$0 = r25;
        r11.L$1 = r21;
        r11.L$2 = r23;
        r11.L$3 = r24;
        r11.L$4 = r22;
        r11.L$5 = r26;
        r11.L$6 = r111;
        r11.label = 4;
        Object r112 = r111.s(r26, r11);
        if (r112 != r14) goto L87;
        return r14;
    L87:
        Context r27 = r21;
        Collection r31 = r23;
        DownloadAppIntentV2HandlerImpl r32 = r111;
        Context r113 = r27;
        Iterator r33 = r24;
        r13 = r112;
        r110 = r25;
        he.a r34 = r26;
    L88:
        r11.L$0 = r110;
        r11.L$1 = r113;
        r11.L$2 = r31;
        r11.L$3 = r33;
        r11.L$4 = r22;
        r11.L$5 = null;
        r11.L$6 = null;
        r11.label = 5;
        r13 = r32.z(r34, (he.b) r13, r113, r11);
        if (r13 != r14) goto L91;
        return r14;
    L91:
        r17 = r33;
        r23 = r31;
        r21 = r113;
        goto L93
    L96:
        List r35 = (List) r23;
        if (r35.isEmpty() == true) goto L99;
        ArrayList r36 = new ArrayList(u.r(r35, 10));
        Iterator r37 = r35.iterator();
    L102:
        if (r37.hasNext() == false) goto L105;
        r36.add(C(f10526a, (he.a) r37.next(), r21, true, 3, false, 8, null));
        goto L102
    L105:
        return r25.A(r36);
    L99:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r32 = (DownloadAppIntentV2HandlerImpl) r11.L$6;
        r34 = (he.a) r11.L$5;
        r22 = r11.L$4;
        r33 = (Iterator) r11.L$3;
        r31 = (Collection) r11.L$2;
        r113 = (Context) r11.L$1;
        r110 = (DownloadAppIntentV2HandlerImpl) r11.L$0;
        c.b(r13);
        goto L88
    L19:
        Object r38 = r11.L$5;
        Iterator r39 = (Iterator) r11.L$4;
        Collection r40 = (Collection) r11.L$3;
        r21 = (Context) r11.L$2;
        SystemDownloadAppParams r114 = (SystemDownloadAppParams) r11.L$1;
        r110 = (DownloadAppIntentV2HandlerImpl) r11.L$0;
        c.b(r13);
    L72:
        if (q.b(((he.b) r13).c(), AppStatus.m.f17992a) == false) goto L67;
        r40.add(r38);
    L67:
        if (r39.hasNext() == false) goto L74;
        r38 = r39.next();
        DownloadAppIntentV2HandlerImpl r115 = f10526a;
        r11.L$0 = r110;
        r11.L$1 = r114;
        r11.L$2 = r21;
        r11.L$3 = r40;
        r11.L$4 = r39;
        r11.L$5 = r38;
        r11.label = 3;
        r13 = r115.s((he.a) r38, r11);
        if (r13 != r14) goto L72;
        return r14;
    L74:
        List r41 = (List) r40;
        if (r41.isEmpty() == true) goto L77;
        IntentResult r42 = r110.g(r114);
        if (r42 == null) goto L81;
        return r42;
    L81:
        r23 = new ArrayList();
        r24 = r41.iterator();
        goto L82
    L77:
        return r110.A(t.i());
    L20:
        Context r43 = (Context) r11.L$2;
        SystemDownloadAppParams r44 = (SystemDownloadAppParams) r11.L$1;
        DownloadAppIntentV2HandlerImpl r45 = (DownloadAppIntentV2HandlerImpl) r11.L$0;
        c.b(r13);
    L44:
        g r46 = (g) r13;
        if ((r46 instanceof g.d) == false) goto L47;
        UpdateAppListResp r47 = (UpdateAppListResp) ((g.d) r46).a();
        if (r47 == null) goto L51;
        List<UpdateAppInfoResp> r48 = r47.getApps();
    L52:
        if (r48 != null) goto L54;
        r48 = t.i();
    L54:
        ArrayList r116 = new ArrayList();
        Iterator<T> r49 = r48.iterator();
    L56:
        if (r49.hasNext() == false) goto L65;
        CommonAppEntity r117 = ((UpdateAppInfoResp) r49.next()).getAppInfo();
        if (r117 == null) goto L62;
        AppInfo r118 = r117.convertAppInfo();
        if (r118 == null) goto L62;
        he.a r119 = AppInfoKtxKt.newDomainEntity$default(r118, null, 1, null);
    L63:
        if (r119 == null) goto L56;
        r116.add(r119);
    L62:
        r119 = null;
        goto L63
    L65:
        ArrayList r50 = new ArrayList();
        Iterator r51 = r116.iterator();
        r114 = r44;
        r110 = r45;
        r39 = r51;
        r21 = r43;
        r40 = r50;
        goto L67
    L51:
        r48 = null;
        goto L52
    L47:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L21:
        Context r52 = (Context) r11.L$2;
        r44 = (SystemDownloadAppParams) r11.L$1;
        DownloadAppIntentV2HandlerImpl r120 = (DownloadAppIntentV2HandlerImpl) r11.L$0;
        c.b(r13);
        Context r121 = r52;
        r10 = r120;
    L25:
        Collection r53 = ((Map) le.a.f21945a.b().getValue()).values();
        ArrayList r122 = new ArrayList();
        Iterator r54 = r53.iterator();
    L27:
        if (r54.hasNext() == false) goto L40;
        le.c r123 = (le.c) r54.next();
        Long r124 = tf.a.d(r123.b());
        if (r124.longValue() <= 2147483647L) goto L32;
        r124 = null;
    L32:
        if (r124 == null) goto L34;
        Integer r125 = tf.a.c((int) r124.longValue());
    L35:
        if (r125 == null) goto L37;
        UpdateAppInfoReq r126 = new UpdateAppInfoReq(r123.a(), r125.intValue());
    L38:
        if (r126 == null) goto L27;
        r122.add(r126);
        goto L27
    L37:
        r126 = null;
        goto L38
    L34:
        r125 = null;
        goto L35
    L40:
        StoreRepo r55 = StoreRepo.f10831a;
        r11.L$0 = r10;
        r11.L$1 = r44;
        r11.L$2 = r121;
        r11.label = 2;
        r13 = r55.p(r122, r11);
        if (r13 != r14) goto L43;
        return r14;
    L43:
        r45 = r10;
        r43 = r121;
        goto L44
    L22:
        c.b(r13);
        le.a r56 = le.a.f21945a;
        r11.L$0 = r10;
        r44 = r28;
        r11.L$1 = r44;
        r121 = r29;
        r11.L$2 = r121;
        r11.label = 1;
        if (r56.a(r11) != r14) goto L25;
        return r14;
    L7:
        r11 = new DownloadAppIntentV2HandlerImpl$handleUpdateAll$1(r10, r30);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0183 -> B:53:0x018d). Please report as a decompilation issue!!! */
    public final Object n(SystemDownloadAppParams r31, Context r32, Continuation r33) {
        int r10 = 3;
        if ((r33 instanceof DownloadAppIntentV2HandlerImpl$handleUpdateSingle$1) == false) goto L8;
        DownloadAppIntentV2HandlerImpl$handleUpdateSingle$1 r11 = (DownloadAppIntentV2HandlerImpl$handleUpdateSingle$1) r33;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L8;
        r11.label = r12 - Integer.MIN_VALUE;
    L7:
        DownloadAppIntentV2HandlerImpl$handleUpdateSingle$1 r13 = r11;
        Object r14 = r13.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r13.label;
        Object r17 = null;
        if (r16 == 0) goto L22;
        if (r16 == 1) goto L21;
        if (r16 == 2) goto L20;
        if (r16 == 3) goto L18;
        if (r16 != 4) goto L17;
        boolean r18 = r13.Z$0;
        he.b r19 = (he.b) r13.L$3;
        he.a r20 = (he.a) r13.L$2;
        Context r21 = (Context) r13.L$1;
        DownloadAppIntentV2HandlerImpl r22 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r14);
    L72:
        if (((Boolean) r14).booleanValue() == false) goto L74;
        he.a r110 = r20;
        Context r111 = r21;
    L77:
        if (r18 == true) goto L81;
        r10 = r22.D(r19.c(), r110.j());
    L81:
        return r22.A(s.e(C(r22, r110, r111, true, r10, false, 8, null)));
    L74:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        he.a r23 = (he.a) r13.L$3;
        Context r24 = (Context) r13.L$2;
        SystemDownloadAppParams r25 = (SystemDownloadAppParams) r13.L$1;
        DownloadAppIntentV2HandlerImpl r26 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r14);
        he.a r112 = r23;
    L19:
        r22 = r26;
        r21 = r24;
        r19 = (he.b) r14;
        r18 = t.l(new AppStatus[]{AppStatus.m.f17992a, AppStatus.b.f17970a, AppStatus.f.f17978a, AppStatus.a.f17968a}).contains(r19.c());
        if (r18 == false) goto L76;
        IntentResult r27 = r22.g(r25);
        if (r27 == null) goto L67;
        return r27;
    L67:
        r13.L$0 = r22;
        r13.L$1 = r21;
        r13.L$2 = r112;
        r13.L$3 = r19;
        r13.Z$0 = r18;
        r13.label = 4;
        r14 = r22.z(r112, r19, r21, r13);
        if (r14 != r15) goto L70;
        return r15;
    L70:
        r20 = r112;
        goto L72
    L76:
        r111 = r21;
        r110 = r112;
        goto L77
    L20:
        int r28 = r13.I$0;
        Collection r29 = (Collection) r13.L$9;
        DownloadAppIntentV2HandlerImpl r30 = (DownloadAppIntentV2HandlerImpl) r13.L$8;
        DownloadAppIntentV2HandlerImpl r34 = (DownloadAppIntentV2HandlerImpl) r13.L$7;
        he.a r35 = (he.a) r13.L$6;
        Context r36 = (Context) r13.L$5;
        DownloadAppIntentV2HandlerImpl r37 = (DownloadAppIntentV2HandlerImpl) r13.L$4;
        he.a r38 = (he.a) r13.L$3;
        Iterator r113 = (Iterator) r13.L$2;
        Collection r114 = (Collection) r13.L$1;
        Context r115 = (Context) r13.L$0;
        c.b(r14);
        DownloadAppIntentV2HandlerImpl r116 = r34;
        he.a r117 = r35;
        Context r118 = r36;
        Context r39 = r115;
    L53:
        if (r28 == 0) goto L55;
        boolean r210 = true;
    L56:
        r29.add(C(r116, r117, r118, r210, r37.D(((he.b) r14).c(), r38.j()), false, 8, null));
        r29 = r114;
    L48:
        if (r113.hasNext() == false) goto L58;
        he.a r40 = (he.a) r113.next();
        DownloadAppIntentV2HandlerImpl r41 = f10526a;
        r13.L$0 = r39;
        r13.L$1 = r29;
        r13.L$2 = r113;
        r13.L$3 = r40;
        r13.L$4 = r41;
        r13.L$5 = r39;
        r13.L$6 = r40;
        r13.L$7 = r41;
        r13.L$8 = r30;
        r13.L$9 = r29;
        r13.I$0 = 0;
        r13.label = 2;
        r14 = r41.s(r40, r13);
        if (r14 != r15) goto L52;
        return r15;
    L52:
        r114 = r29;
        r37 = r41;
        r116 = r37;
        r38 = r40;
        r117 = r38;
        r118 = r39;
        r28 = 0;
        goto L53
    L58:
        return r30.A((List) r29);
    L55:
        r210 = false;
        goto L56
    L21:
        String r42 = (String) r13.L$3;
        r24 = (Context) r13.L$2;
        r25 = (SystemDownloadAppParams) r13.L$1;
        r26 = (DownloadAppIntentV2HandlerImpl) r13.L$0;
        c.b(r14);
    L34:
        List r43 = (List) r14;
        if (r43 == null) goto L37;
        Iterator r44 = r43.iterator();
    L40:
        if (r44.hasNext() == false) goto L44;
        Object r45 = r44.next();
        if (f10526a.q(((he.a) r45).i(), r42) == false) goto L40;
        r17 = r45;
    L44:
        r112 = (he.a) r17;
        if (r112 != null) goto L59;
        List r46 = b0.u0(r43, 5);
        ArrayList r47 = new ArrayList(u.r(r46, 10));
        r113 = r46.iterator();
        r39 = r24;
        r30 = r26;
        r29 = r47;
        goto L48
    L59:
        r13.L$0 = r26;
        r13.L$1 = r25;
        r13.L$2 = r24;
        r13.L$3 = r112;
        r13.label = 3;
        r14 = r26.s(r112, r13);
        if (r14 != r15) goto L19;
        return r15;
    L37:
        return new IntentResult(1, null, null, null, false, false, 0, null, null, null, 1022, null);
    L22:
        c.b(r14);
        String r48 = r31.getAppName();
        if (r48 == null) goto L83;
        if (o.r(r48) == true) goto L27;
        String r119 = r48;
    L28:
        if (r119 == null) goto L83;
        r13.L$0 = this;
        r13.L$1 = r31;
        r13.L$2 = r32;
        r13.L$3 = r119;
        r13.label = 1;
        r14 = w(this, r119, false, null, r13, 6, null);
        if (r14 != r15) goto L33;
        return r15;
    L33:
        r25 = r31;
        r24 = r32;
        r26 = this;
        r42 = r119;
        goto L34
    L27:
        r119 = null;
    L83:
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L8:
        r11 = new DownloadAppIntentV2HandlerImpl$handleUpdateSingle$1(this, r33);
        goto L7
    }

    public final long o(he.a r10, Context r11) {
        Result.a r12 = Result.Companion;     // Catch: Throwable -> L6
        ApplicationInfo r13 = r11.getPackageManager().getApplicationInfo(r10.j(), 0);     // Catch: Throwable -> L6
        q.f(r13, "getApplicationInfo(...)");     // Catch: Throwable -> L6
        List r14 = s.c();     // Catch: Throwable -> L6
        r14.add(r13.sourceDir);     // Catch: Throwable -> L6
        String[] r15 = r13.splitSourceDirs;     // Catch: Throwable -> L6
        if (r15 == null) goto L8;
        q.d(r15);     // Catch: Throwable -> L6
        y.w(r14, r15);     // Catch: Throwable -> L6
    L8:
        Iterator r16 = s.a(r14).iterator();     // Catch: Throwable -> L6
        long r17 = 0;
    L10:
        if (r16.hasNext() == false) goto L19;
        File r18 = new File((String) r16.next());     // Catch: Throwable -> L6
        if (r18.isFile() == true) goto L15;
        r18 = null;
    L15:
        if (r18 == null) goto L17;
        long r19 = r18.length();     // Catch: Throwable -> L6
    L18:
        r17 = r17 + r19;     // Catch: Throwable -> L6
        goto L10
    L17:
        r19 = 0;
        goto L18
    L19:
        Object r20 = Result.m35constructorimpl(Long.valueOf(r17));     // Catch: Throwable -> L6
    L23:
        if (Result.m41isFailureimpl(r20) == false) goto L26;
        r20 = 0L;
    L26:
        return ((Number) r20).longValue();
    L6:
        th = move-exception;
        Result.a r21 = Result.Companion;
        r20 = Result.m35constructorimpl(c.a(th));
        goto L23
    }

    public final boolean p(he.a r10) {
        return q.b(r10.m(), "ad");
    }

    public final boolean q(String r10, String r11) {
        return q.b(com.smt.obric.appstore.assistant.intent.a.a(r10), com.smt.obric.appstore.assistant.intent.a.a(r11));
    }

    public final boolean r() {
        if (e.G(0) == true) goto L5;
        return false;
    L5:
        if (e.G(1) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public final Object s(he.a r10, Continuation r11) {
        return kotlinx.coroutines.flow.c.u(i().b(r10.j(), tf.a.d(r10.o())), r11);
    }

    public final Long t(he.a r10) {
        String r11 = r10.k();
        if (r11 == null) goto L13;
        File r12 = new File(r11);
        if (r12.isFile() == true) goto L8;
        r12 = null;
    L8:
        if (r12 == null) goto L14;
        Long r13 = Long.valueOf(r12.length());
        if (r13.longValue() > 0) goto L12;
        return null;
    L12:
        return r13;
    L14:
        return null;
    L13:
        return null;
    }

    public final void u(SystemDownloadAppParams r10, IntentResult r11) {
        AppInfoEntity[] r12 = (AppInfoEntity[]) r11.getEntity();
        if (r12 == null) goto L5;
        String r13 = n.C(r12, null, "[", "]", 10, null, DownloadAppIntentV2HandlerImpl$logResult$entities$1.INSTANCE, 17, null);
    L6:
        j.n("[AI_Intent] [DownloadApp][V2] result, appName=" + r10.getAppName() + ", operateType=" + r10.getOperateType() + ", updateRange=" + r10.getUpdateRange() + ", isSystemApp=" + r10.isSystemApp() + ", ret=" + r11.getRet() + ", details=" + r11.getDetails() + ", entities=" + r13);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public final Object v(String r10, boolean r11, Context r12, Continuation r13) {
        if ((r13 instanceof DownloadAppIntentV2HandlerImpl$searchApps$1) == false) goto L7;
        DownloadAppIntentV2HandlerImpl$searchApps$1 r14 = (DownloadAppIntentV2HandlerImpl$searchApps$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        ArrayList r19 = null;
        if (r18 == 0) goto L16;
        if (r18 == 1) goto L15;
        if (r18 != 2) goto L14;
        c.b(r16);
    L27:
        g r20 = (g) r16;
        if ((r20 instanceof g.d) == false) goto L45;
        PageResp r21 = (PageResp) ((g.d) r20).a();
        if (r21 == null) goto L32;
        List r22 = r21.getData();
    L33:
        if (r22 != null) goto L35;
        r22 = t.i();
    L35:
        ArrayList r23 = new ArrayList(u.r(r22, 10));
        Iterator r24 = r22.iterator();
    L37:
        if (r24.hasNext() == false) goto L39;
        r23.add(AppInfoKtxKt.newDomainEntity$default((AppInfo) r24.next(), null, 1, null));
        goto L37
    L39:
        r19 = new ArrayList();
        Iterator r25 = r23.iterator();
    L41:
        if (r25.hasNext() == false) goto L45;
        Object r26 = r25.next();
        if (f10526a.p((he.a) r26) == true) goto L41;
        r19.add(r26);
        goto L41
    L32:
        r22 = null;
    L45:
        return r19;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        c.b(r16);
    L23:
        return (List) r16;
    L16:
        c.b(r16);
        if (r11 == false) goto L24;
        if (r12 == null) goto L52;
        DownloadAppIntentV2HandlerImpl r27 = f10526a;
        r14.label = 1;
        r16 = r27.x(r10, r12, r14);
        if (r16 != r17) goto L23;
        return r17;
    L52:
        return null;
    L24:
        StoreRepo r28 = StoreRepo.f10831a;
        r14.label = 2;
        r16 = r28.m(r10, 1, r14);
        if (r16 != r17) goto L27;
        return r17;
    L7:
        r14 = new DownloadAppIntentV2HandlerImpl$searchApps$1(this, r13);
        goto L8
    }

    public final Object x(String r10, Context r11, Continuation r12) {
        if ((r12 instanceof DownloadAppIntentV2HandlerImpl$searchSystemApps$1) == false) goto L7;
        DownloadAppIntentV2HandlerImpl$searchSystemApps$1 r13 = (DownloadAppIntentV2HandlerImpl$searchSystemApps$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r11 = (Context) r13.L$1;
        r10 = (String) r13.L$0;
        c.b(r15);
    L17:
        Object r18 = ((Result) r15).m44unboximpl();
        Throwable r19 = Result.m38exceptionOrNullimpl(r18);
        if (r19 != null) goto L44;
        List r20 = (List) r18;
        String r110 = com.smt.obric.appstore.assistant.intent.a.a(r10);
        if (o.r(r110) == false) goto L23;
        List r21 = t.i();
    L54:
        return r21;
    L23:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r20.iterator();
    L25:
        if (r23.hasNext() == false) goto L40;
        Object r24 = r23.next();
        AppInfo r25 = (AppInfo) r24;
        String r26 = r25.appName;
        String r27 = "";
        if (r26 != null) goto L29;
        r26 = "";
    L29:
        String r28 = com.smt.obric.appstore.assistant.intent.a.a(r26);
        String r29 = r25.appName;
        if (r29 == null) goto L34;
        r27 = r29;
    L34:
        if (StringsKt__StringsKt.D(r27, r10, true) == true) goto L39;
        if (StringsKt__StringsKt.E(r28, r110, false, 2, null) == true) goto L39;
        if (StringsKt__StringsKt.E(r110, r28, false, 2, null) == false) goto L25;
    L39:
        r22.add(r24);
        goto L25
    L40:
        r21 = new ArrayList(u.r(r22, 10));
        Iterator r30 = r22.iterator();
    L42:
        if (r30.hasNext() == false) goto L54;
        AppInfo r111 = (AppInfo) r30.next();
        r21.add(f10526a.G(AppInfoKtxKt.newDomainEntity$default(r111, null, 1, null), r11));
        goto L42
    L44:
        j.q("[AI_Intent] [DownloadApp][V2] search system apps failed", r19);
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r15);
        Flow r31 = new LoadSysAppUseCase(r11, null, 2, null).l();
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        r15 = kotlinx.coroutines.flow.c.u(r31, r13);
        if (r15 != r16) goto L17;
        return r16;
    L7:
        r13 = new DownloadAppIntentV2HandlerImpl$searchSystemApps$1(this, r12);
        goto L8
    }

    public final void y(Context r10) {
        Result.a r11 = Result.Companion;     // Catch: Throwable -> L4
        Intent r12 = new Intent(r10, JumpActivity.class);     // Catch: Throwable -> L4
        r12.putExtra(JumpActivity.ARG_USER_AGREEMENT_ONLY, true);     // Catch: Throwable -> L4
        r12.putExtra(JumpActivity.ARG_OVERRIDE_ENTER_ANIM, true);     // Catch: Throwable -> L4
        r12.putExtra(JumpActivity.ARG_KEEP_FULLSCREEN_FOR_PRIVACY, true);     // Catch: Throwable -> L4
        r12.setFlags(268468224);     // Catch: Throwable -> L4
        r10.startActivity(r12);     // Catch: Throwable -> L4
        Object r13 = Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L4
    L6:
        Throwable r14 = Result.m38exceptionOrNullimpl(r13);
        if (r14 == null) goto L12;
        j.q("[AI_Intent] [DownloadApp][V2] show privacy agreement failed", r14);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.a r15 = Result.Companion;
        r13 = Result.m35constructorimpl(c.a(th));
        goto L6
    }

    public final Object z(he.a r10, he.b r11, Context r12, Continuation r13) {
        if ((r13 instanceof DownloadAppIntentV2HandlerImpl$startDownloadOrResume$1) == false) goto L7;
        DownloadAppIntentV2HandlerImpl$startDownloadOrResume$1 r14 = (DownloadAppIntentV2HandlerImpl$startDownloadOrResume$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L22;
        if (r18 == 1) goto L19;
        if (r18 != 2) goto L18;
        r10 = (he.a) r14.L$0;
        c.b(r16);     // Catch: Throwable -> L15
    L58:
        boolean r19 = ((Boolean) r16).booleanValue();     // Catch: Throwable -> L15
    L59:
        Object r20 = Result.m35constructorimpl(tf.a.a(r19));     // Catch: Throwable -> L15
    L62:
        Throwable r21 = Result.m38exceptionOrNullimpl(r20);
        if (r21 == null) goto L69;
        j.p("[AI_Intent] [DownloadApp][V2] start download failed, app=" + r10.q() + ", err=" + r21.getMessage());
        return tf.a.a(false);
    L69:
        return r20;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r10 = (he.a) r14.L$0;
        c.b(r16);     // Catch: Throwable -> L15
    L54:
        r19 = ((Boolean) r16).booleanValue();     // Catch: Throwable -> L15
        goto L59
    L22:
        c.b(r16);
        Long r110 = r10.c();
        if (r110 == null) goto L25;
        long r22 = r110.longValue();
    L27:
        if (d.c(r22) == true) goto L30;
        j.p("[AI_Intent] [DownloadApp][V2] insufficient space, app=" + r10.q());
        return tf.a.a(false);
    L30:
        AppStatus.b r111 = AppStatus.b.f17970a;
        AppStatus.f r23 = AppStatus.f.f17978a;
        if (b0.S(t.l(new AppStatus.DownloadStatus[]{r111, r23, AppStatus.a.f17968a}), r11.c()) == true) goto L43;
        String r24 = r10.d();
        if (r24 != null) goto L35;
    L36:
        String r25 = r10.k();
        if (r25 != null) goto L39;
    L40:
        j.p("[AI_Intent] [DownloadApp][V2] invalid download source, app=" + r10.q());
        return tf.a.a(false);
    L39:
        if (o.r(r25) == false) goto L43;
    L35:
        if (o.r(r24) == true) goto L36;
    L43:
        if (e.A() == 1) goto L45;
        boolean r26 = true;
    L46:
        Result.a r27 = Result.Companion;     // Catch: Throwable -> L15
        AppStatus r28 = r11.c();     // Catch: Throwable -> L15
        if (q.b(r28, r111) == false) goto L49;
        boolean r29 = true;
    L50:
        if (r29 == false) goto L55;
        ResumeAppDownloadUseCase r30 = j();     // Catch: Throwable -> L15
        String r31 = r10.j();     // Catch: Throwable -> L15
        r14.L$0 = r10;     // Catch: Throwable -> L15
        r14.label = 1;     // Catch: Throwable -> L15
        r16 = r30.a(r31, r26, r14);     // Catch: Throwable -> L15
        if (r16 != r17) goto L54;
        return r17;
    L55:
        EnqueueAppInstallTaskUseCase r32 = h();     // Catch: Throwable -> L15
        com.smt.obric.appstore.domain.app.entity.a r33 = com.smt.obric.appstore.domain.app.n.b(r10, r26, false);     // Catch: Throwable -> L15
        r14.L$0 = r10;     // Catch: Throwable -> L15
        r14.label = 2;     // Catch: Throwable -> L15
        r16 = r32.a(r33, r14);     // Catch: Throwable -> L15
        if (r16 != r17) goto L58;
        return r17;
    L49:
        r29 = q.b(r28, r23);     // Catch: Throwable -> L15
        goto L50
    L45:
        r26 = false;
        goto L46
    L25:
        r22 = 0;
    L15:
        th = move-exception;
        Result.a r34 = Result.Companion;
        r20 = Result.m35constructorimpl(c.a(th));
    L7:
        r14 = new DownloadAppIntentV2HandlerImpl$startDownloadOrResume$1(this, r13);
        goto L8
    }
}
