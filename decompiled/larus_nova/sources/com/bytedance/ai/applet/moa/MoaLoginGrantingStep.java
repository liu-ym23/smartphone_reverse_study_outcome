package com.bytedance.ai.applet.moa;

import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationRouter;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.CheckType;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes43.dex */
public final class MoaLoginGrantingStep implements n, q {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f34797m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u2.f f34798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u2.j f34799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f34800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f34801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MoaLoginPanelPresenter f34802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public State f34803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public o f34804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public kotlinx.coroutines.i<? super MoaStepResult> f34805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f34806i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public OnlineAppletApplication f34807j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f34808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MoaLoginGrantingStep$loginAppLifecycleObserver$1 f34809l;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaLoginGrantingStep$State;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "CHECKING_PRIVACY", "WAITING_PRIVACY", "ACCEPTING_PRIVACY", "WAITING_LOGIN", "FETCHING_LOGIN_CODE", "OPENING_LOGIN_PAGE", "WAITING_LOGIN_RESULT", "EXCHANGING_CODE", "DISMISSING", "DONE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State ACCEPTING_PRIVACY = null;
        public static final State CHECKING_PRIVACY = null;
        public static final State DISMISSING = null;
        public static final State DONE = null;
        public static final State EXCHANGING_CODE = null;
        public static final State FETCHING_LOGIN_CODE = null;
        public static final State IDLE = null;
        public static final State OPENING_LOGIN_PAGE = null;
        public static final State WAITING_LOGIN = null;
        public static final State WAITING_LOGIN_RESULT = null;
        public static final State WAITING_PRIVACY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f34810a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34811b = null;

        public static EnumEntries<State> getEntries() {
            return f34811b;
        }

        static {
            State r100 = new State("IDLE", 0);
            IDLE = r100;
            State r101 = new State("CHECKING_PRIVACY", 1);
            CHECKING_PRIVACY = r101;
            State r102 = new State("WAITING_PRIVACY", 2);
            WAITING_PRIVACY = r102;
            State r103 = new State("ACCEPTING_PRIVACY", 3);
            ACCEPTING_PRIVACY = r103;
            State r104 = new State("WAITING_LOGIN", 4);
            WAITING_LOGIN = r104;
            State r105 = new State("FETCHING_LOGIN_CODE", 5);
            FETCHING_LOGIN_CODE = r105;
            State r110 = new State("OPENING_LOGIN_PAGE", 6);
            OPENING_LOGIN_PAGE = r110;
            State r111 = new State("WAITING_LOGIN_RESULT", 7);
            WAITING_LOGIN_RESULT = r111;
            State r112 = new State("EXCHANGING_CODE", 8);
            EXCHANGING_CODE = r112;
            State r113 = new State("DISMISSING", 9);
            DISMISSING = r113;
            State r114 = new State("DONE", 10);
            DONE = r114;
            State[] r115 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
            f34810a = r115;
            f34811b = EnumEntriesKt.enumEntries(r115);
        }

        public static State[] values() {
            return (State[]) f34810a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ai/applet/moa/MoaLoginGrantingStep$Type;", "", "<init>", "(Ljava/lang/String;I)V", "PRIVACY", "LOGIN", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        public static final Type LOGIN = null;
        public static final Type PRIVACY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f34812a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f34813b = null;

        public static EnumEntries<Type> getEntries() {
            return f34813b;
        }

        static {
            Type r100 = new Type("PRIVACY", 0);
            PRIVACY = r100;
            Type r101 = new Type("LOGIN", 1);
            LOGIN = r101;
            Type[] r102 = {r100, r101};
            f34812a = r102;
            f34813b = EnumEntriesKt.enumEntries(r102);
        }

        public static Type[] values() {
            return (Type[]) f34812a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34814a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f34815b = null;

        static {
            int[] r100 = new int[Type.values().length];
            r100[Type.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[Type.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f34814a = r100;
            int[] r101 = new int[MoaLoginPanelType.values().length];
            r101[MoaLoginPanelType.PRIVACY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[MoaLoginPanelType.LOGIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f34815b = r101;
        }
    }

    public static final class c implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MoaLoginGrantingStep f34816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<MoaStepResult> f34817b;

        public c(MoaLoginGrantingStep r100, kotlinx.coroutines.j r101) {
            this.f34816a = r100;
            this.f34817b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            MoaLoginGrantingStep r101 = this.f34816a;
            BuildersKt.launch$default(r101.f34801d, null, null, new MoaLoginGrantingStep$requestConfirmation$2$1$1(r101, this.f34817b, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public static IllegalStateException l() {
        return new IllegalStateException("MOA login flow is no longer waiting for this callback");
    }

    public final void q() {
        OnlineAppletApplication r100 = this.f34807j;
        if (r100 == null) goto L7;
        LifecycleRegistry r101 = r100.f34082a;
        if (r101 == null) goto L7;
        r101.removeObserver(this.f34809l);
    L7:
        this.f34807j = null;
        this.f34808k = false;
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final void a(o r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f34803f = State.DONE;
        this.f34805h = null;
        this.f34802e.b();
        q();
        CoroutineScopeKt.cancel$default(this.f34801d, null, 1, null);
        this.f34804g = null;
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void b(com.bytedance.ai.bridge.method.login.c r100) {
        Intrinsics.checkNotNullParameter(r100, "completion");
        if (this.f34803f == State.WAITING_PRIVACY) goto L5;
    L9:
        Result.Companion r101 = Result.Companion;
        r100.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.f34805h == null) goto L9;
        this.f34803f = State.ACCEPTING_PRIVACY;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handlePrivacyAgreement$1(this, r100, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void h(com.bytedance.ai.bridge.method.phoneNum.c r100) {
        Intrinsics.checkNotNullParameter(r100, "completion");
        if (this.f34803f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r101 = Result.Companion;
        r100.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.f34805h == null) goto L9;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handleGetPhoneNumber$1(this, r100, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final boolean i(MoaLoginPanelType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = b.f34815b[r100.ordinal()];
        if (r101 == 1) goto L14;
        if (r101 != 2) goto L12;
        State r102 = this.f34803f;
        if (r102 != State.WAITING_LOGIN) goto L9;
    L15:
        boolean r103 = true;
    L17:
        if (r103 == true) goto L19;
    L23:
        return false;
    L19:
        if (this.f34805h == null) goto L23;
        this.f34803f = State.DISMISSING;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handleClosePanel$1(this, null), 3, null);
        return true;
    L9:
        if (r102 == State.WAITING_LOGIN_RESULT) goto L15;
    L16:
        r103 = false;
        goto L17
    L12:
        throw new NoWhenBranchMatchedException();
    L14:
        if (this.f34803f != State.WAITING_PRIVACY) goto L16;
        goto L15
    }

    public final void k(MoaStepResult r100) {
        kotlinx.coroutines.i<? super MoaStepResult> r101 = this.f34805h;
        if (r101 != null) goto L5;
        return;
    L5:
        this.f34805h = null;
        this.f34803f = State.IDLE;
        this.f34806i = false;
        this.f34802e.b();
        q();
        if (r101.isActive() == false) goto L9;
        r101.resumeWith(Result.m9449constructorimpl(r100));
        return;
    }

    public final Object n(Continuation<? super Unit> r100) {
        if ((r100 instanceof MoaLoginGrantingStep$routeToLogin$1) == false) goto L7;
        MoaLoginGrantingStep$routeToLogin$1 r101 = (MoaLoginGrantingStep$routeToLogin$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L38:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        Object r106 = ((Result) r103).m9458unboximpl();
    L28:
        if (Result.m9455isFailureimpl(r106) == false) goto L33;
        if (this.f34805h == null) goto L33;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "Failed to open default MOA login page", Result.m9452exceptionOrNullimpl(r106));
        k(MoaStepResult.FAILED);
    L33:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r103);
        String r107 = this.f34799b.c();
        if (r107 != null) goto L19;
    L22:
        boolean r108 = true;
    L23:
        if (r108 == false) goto L34;
        r101.label = 1;
        r106 = m("mcp-login-page", r101);
        if (r106 != r104) goto L28;
        return r104;
    L34:
        r101.label = 2;
        if (o(r101) != r104) goto L38;
        return r104;
    L19:
        if (StringsKt.isBlank(r107) == true) goto L22;
        r108 = false;
    L7:
        r101 = new MoaLoginGrantingStep$routeToLogin$1(this, r100);
        goto L8
    }

    public final Object o(Continuation<? super Unit> r100) {
        if ((r100 instanceof MoaLoginGrantingStep$showLoginPanel$1) == false) goto L7;
        MoaLoginGrantingStep$showLoginPanel$1 r101 = (MoaLoginGrantingStep$showLoginPanel$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MoaLoginGrantingStep$showLoginPanel$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L22:
        if (Result.m9455isFailureimpl(r107) == false) goto L29;
        if (this.f34803f != State.WAITING_LOGIN) goto L29;
        if (this.f34805h == null) goto L29;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "Failed to show MOA login panel", Result.m9452exceptionOrNullimpl(r107));
        k(MoaStepResult.FAILED);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        o r108 = this.f34804g;
        if (r108 != null) goto L18;
        k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L18:
        this.f34803f = State.WAITING_LOGIN;
        MoaLoginPanelPresenter r109 = this.f34802e;
        u2.j r110 = this.f34799b;
        MoaLoginPanelType r111 = MoaLoginPanelType.LOGIN;
        Function0<Unit> r112 = new r(this);
        r103.label = 1;
        r107 = r109.c(r108, r110, r111, r112, r103);
        if (r107 != r105) goto L22;
        return r105;
    L7:
        r101 = new MoaLoginGrantingStep$showLoginPanel$1(this, r100);
        goto L8
    }

    public final Object p(Continuation<? super Unit> r100) {
        if ((r100 instanceof MoaLoginGrantingStep$showPrivacyPanel$1) == false) goto L7;
        MoaLoginGrantingStep$showPrivacyPanel$1 r101 = (MoaLoginGrantingStep$showPrivacyPanel$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MoaLoginGrantingStep$showPrivacyPanel$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L22:
        if (Result.m9455isFailureimpl(r107) == false) goto L29;
        if (this.f34803f != State.WAITING_PRIVACY) goto L29;
        if (this.f34805h == null) goto L29;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "Failed to show MOA privacy panel", Result.m9452exceptionOrNullimpl(r107));
        k(MoaStepResult.FAILED);
    L29:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        o r108 = this.f34804g;
        if (r108 != null) goto L18;
        k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L18:
        this.f34803f = State.WAITING_PRIVACY;
        MoaLoginPanelPresenter r109 = this.f34802e;
        u2.j r110 = this.f34799b;
        MoaLoginPanelType r111 = MoaLoginPanelType.PRIVACY;
        Function0<Unit> r112 = new s(this);
        r103.label = 1;
        r107 = r109.c(r108, r110, r111, r112, r103);
        if (r107 != r105) goto L22;
        return r105;
    L7:
        r101 = new MoaLoginGrantingStep$showPrivacyPanel$1(this, r100);
        goto L8
    }

    public static final Object j(MoaLoginGrantingStep r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof MoaLoginGrantingStep$prepareLogin$1) == false) goto L7;
        MoaLoginGrantingStep$prepareLogin$1 r102 = (MoaLoginGrantingStep$prepareLogin$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L18;
        if (r106 == 1) goto L17;
        if (r106 == 2) goto L16;
        if (r106 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
    L51:
        return Unit.INSTANCE;
    L17:
        ResultKt.throwOnFailure(r104);
        Object r107 = ((Result) r104).m9458unboximpl();
    L32:
        if (r100.f34803f != State.CHECKING_PRIVACY) goto L49;
        if (r100.f34805h == null) goto L49;
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L39;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "Failed to query privacy before MOA login", r108);
        r100.k(MoaStepResult.FAILED);
        goto L51
    L39:
        if (((Boolean) r107).booleanValue() == false) goto L43;
        r102.label = 2;
        if (r100.n(r102) != r105) goto L51;
        return r105;
    L43:
        r102.label = 3;
        if (r100.p(r102) != r105) goto L51;
        return r105;
    L49:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r104);
        o r109 = r100.f34804g;
        if (r109 != null) goto L21;
        r100.k(MoaStepResult.FAILED);
        return Unit.INSTANCE;
    L21:
        r100.f34803f = State.CHECKING_PRIVACY;
        String r110 = r109.f34866a.d();
        String r111 = "";
        if (r110 != null) goto L24;
        r110 = "";
    L24:
        String r112 = r109.f34866a.g();
        if (r112 == null) goto L28;
        r111 = r112;
    L28:
        UserAuthService r113 = UserAuthService.f36075a;
        r102.label = 1;
        r107 = r113.d(r110, r111, r102);
        if (r107 != r105) goto L32;
        return r105;
    L7:
        r102 = new MoaLoginGrantingStep$prepareLogin$1(r100, r101);
        goto L8
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object c(o r100, Continuation<? super MoaStepResult> r101) {
        if (this.f34805h == null) goto L6;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "A MOA login confirmation is already active");
        return MoaStepResult.FAILED;
    L6:
        this.f34804g = r100;
        this.f34803f = State.IDLE;
        kotlinx.coroutines.j r102 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        this.f34805h = r102;
        r102.i(new c(this, r102));
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$requestConfirmation$2$2(this, null), 3, null);
        Object r103 = r102.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L9:
        return r103;
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void e(Long r100, com.bytedance.ai.bridge.method.login.i r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        if (this.f34803f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r102 = Result.Companion;
        r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.f34805h == null) goto L9;
        this.f34803f = State.FETCHING_LOGIN_CODE;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handleLogin$1(this, r101, r100, null), 3, null);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void f(String r100, com.bytedance.ai.bridge.method.login.l r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "completion");
        if (this.f34803f == State.WAITING_LOGIN) goto L5;
    L9:
        Result.Companion r102 = Result.Companion;
        r101.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(l()))));
        return;
    L5:
        if (this.f34805h == null) goto L9;
        this.f34803f = State.OPENING_LOGIN_PAGE;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handleOpenLoginPage$1(this, r100, r101, null), 3, null);
    }

    public final Object m(String r110, Continuation<? super Result<Unit>> r111) {
        if ((r111 instanceof MoaLoginGrantingStep$openLoginPage$1) == false) goto L7;
        MoaLoginGrantingStep$openLoginPage$1 r100 = (MoaLoginGrantingStep$openLoginPage$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        OnlineAppletApplication r113 = (OnlineAppletApplication) r100.L$0;
        ResultKt.throwOnFailure(r112);
        Object r114 = ((Result) r112).m9458unboximpl();
    L47:
        if (Result.m9456isSuccessimpl(r114) == true) goto L49;
    L55:
        return r114;
    L49:
        if (this.f34803f != State.OPENING_LOGIN_PAGE) goto L55;
        if (this.f34805h == null) goto L55;
        this.f34806i = true;
        this.f34803f = State.WAITING_LOGIN_RESULT;
        if (this.f34807j == r113) goto L55;
        q();
        this.f34807j = r113;
        this.f34808k = r113.m();
        r113.f34082a.addObserver(this.f34809l);
        goto L55
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r115 = (String) r100.L$2;
        o r104 = (o) r100.L$1;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
        String r106 = r105;
    L28:
        if ((r112 instanceof OnlineAppletApplication) == false) goto L30;
        OnlineAppletApplication r116 = (OnlineAppletApplication) r112;
    L31:
        if (r116 != null) goto L56;
        Result.Companion r117 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(new IllegalStateException("Online app " + r115 + " is unavailable")));
    L56:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L36
        Object r119 = Result.m9449constructorimpl(UriProtector.parse(r106).buildUpon().appendQueryParameter("__moa_attempt_id", r104.f34868c).build().toString());     // Catch: Throwable -> L36
    L38:
        Object r107 = r106;
        if (Result.m9455isFailureimpl(r119) == true) goto L42;
        r107 = r119;
    L42:
        ApplicationRouter r120 = r116.h().d();
        r100.L$0 = r116;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        Object r121 = r120.i((String) r107, null, r100);
        if (r121 != r102) goto L45;
        return r102;
    L45:
        OnlineAppletApplication r108 = r116;
        r114 = r121;
        r113 = r108;
    L36:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r119 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
    L30:
        r116 = null;
        goto L31
    L16:
        ResultKt.throwOnFailure(r112);
        r104 = this.f34804g;
        if (r104 != null) goto L20;
        Result.Companion r122 = Result.Companion;
        return Result.m9449constructorimpl(ResultKt.createFailure(l()));
    L20:
        String r123 = r104.f34866a.d();
        if (r123 != null) goto L23;
        r123 = "";
    L23:
        this.f34803f = State.OPENING_LOGIN_PAGE;
        this.f34802e.b();
        AppletAppManagerService r124 = AppletAppManagerService.INSTANCE;
        r100.L$0 = r110;
        r100.L$1 = r104;
        r100.L$2 = r123;
        r100.label = 1;
        Object r125 = r124.d(r123, r100);
        if (r125 != r102) goto L26;
        return r102;
    L26:
        r106 = r110;
        r115 = r123;
        r112 = r125;
    L7:
        r100 = new MoaLoginGrantingStep$openLoginPage$1(this, r111);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.bytedance.ai.applet.moa.MoaLoginGrantingStep$loginAppLifecycleObserver$1] */
    public MoaLoginGrantingStep(u2.f r100, u2.j r101, Type r102) {
        this.f34798a = r100;
        this.f34799b = r101;
        this.f34800c = r102;
        this.f34801d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f34802e = new MoaLoginPanelPresenter();
        this.f34803f = State.IDLE;
        this.f34809l = new MoaLoginGrantingStep$loginAppLifecycleObserver$1(this);
    }

    @Override // com.bytedance.ai.applet.moa.q
    public final void d(boolean r100, String r101, com.bytedance.ai.bridge.method.login.o r102) {
        Intrinsics.checkNotNullParameter(r102, "completion");
        State r103 = this.f34803f;
        if (r103 != State.WAITING_PRIVACY) goto L12;
        if (this.f34805h == null) goto L12;
        if (r100 == false) goto L9;
        Result.Companion r104 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(new IllegalArgumentException("Unexpected successful privacy callback")))));
        return;
    L9:
        Result.Companion r105 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)));
        k(MoaStepResult.REFUSED);
        return;
    L12:
        if (r103 == State.WAITING_LOGIN) goto L16;
        if (r103 == State.WAITING_LOGIN_RESULT) goto L16;
    L17:
        Result.Companion r106 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(l()))));
        return;
    L16:
        if (this.f34805h == null) goto L17;
        if (r100 == true) goto L22;
        Result.Companion r107 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(Unit.INSTANCE)));
        k(MoaStepResult.FAILED);
        return;
    L22:
        if (r101 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == false) goto L31;
        IllegalArgumentException r109 = new IllegalArgumentException("Login code is missing");
        Result.Companion r110 = Result.Companion;
        r102.invoke(Result.m9448boximpl(Result.m9449constructorimpl(ResultKt.createFailure(r109))));
        k(MoaStepResult.FAILED);
        return;
    L31:
        this.f34803f = State.EXCHANGING_CODE;
        BuildersKt.launch$default(this.f34801d, null, null, new MoaLoginGrantingStep$handlePostLoginResult$1(this, r101, r102, null), 3, null);
        return;
    L24:
        if (StringsKt.isBlank(r101) == true) goto L27;
        r108 = false;
        goto L28
    }

    @Override // com.bytedance.ai.applet.moa.n
    public final Object g(o r100, boolean r101, Continuation<? super MoaStepResult> r102) {
        if ((r102 instanceof MoaLoginGrantingStep$handleAction$1) == false) goto L7;
        MoaLoginGrantingStep$handleAction$1 r103 = (MoaLoginGrantingStep$handleAction$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
        Object r108 = ((Result) r105).m9458unboximpl();
    L30:
        if (Result.m9456isSuccessimpl(r108) == false) goto L32;
        r108 = Boxing.boxBoolean(((p4.i) r108).f527621c);
    L32:
        Object r109 = Result.m9449constructorimpl(r108);
    L38:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L41;
        com.bytedance.ai.utils.g.f37637a.e("MoaLoginGrantingStep", "Failed to query " + this.f34800c.name().toLowerCase(Locale.ROOT) + " status", r110);
        return MoaStepResult.FAILED;
    L41:
        if (((Boolean) r109).booleanValue() == true) goto L52;
        if (r101 == false) goto L45;
    L47:
        if (r101 == true) goto L55;
        return MoaStepResult.CONTINUE;
    L55:
        return MoaStepResult.REQUIRES_CONFIRMATION;
    L45:
        if (this.f34798a.f() == false) goto L47;
        return MoaStepResult.REFUSED;
    L52:
        return MoaStepResult.CONTINUE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = r103.Z$0;
        ResultKt.throwOnFailure(r105);
        r109 = ((Result) r105).m9458unboximpl();
        goto L38
    L16:
        ResultKt.throwOnFailure(r105);
        String r111 = r100.f34866a.d();
        String r112 = "";
        if (r111 != null) goto L19;
        r111 = "";
    L19:
        String r113 = r100.f34866a.g();
        if (r113 == null) goto L23;
        r112 = r113;
    L23:
        int r114 = b.f34814a[this.f34800c.ordinal()];
        if (r114 == 1) goto L35;
        if (r114 != 2) goto L34;
        UserAuthService r115 = UserAuthService.f36075a;
        CheckType r116 = CheckType.CHECK_TYPE_LOGIN_STATUS;
        r103.Z$0 = r101;
        r103.label = 2;
        r108 = r115.e(r111, r112, r116, r103);
        if (r108 != r106) goto L30;
        return r106;
    L34:
        throw new NoWhenBranchMatchedException();
    L35:
        UserAuthService r117 = UserAuthService.f36075a;
        r103.Z$0 = r101;
        r103.label = 1;
        r109 = r117.d(r111, r112, r103);
        if (r109 != r106) goto L38;
        return r106;
    L7:
        r103 = new MoaLoginGrantingStep$handleAction$1(this, r102);
        goto L8
    }
}
