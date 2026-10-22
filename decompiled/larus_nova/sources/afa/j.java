package afa;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.n4;
import com.obric.assistant.obric_action.handler.auth.result.AuthenticationActionStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    public static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f3235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3236b;

        public a(AtomicBoolean r100, String r101) {
            this.f3235a = r100;
            this.f3236b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f3235a.set(true);
            FLogger.f375446a.i(this.f3236b, "authentication continuation cancelled");
            return Unit.INSTANCE;
        }
    }

    public static final class b implements n4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f3237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<com.obric.assistant.obric_action.h<bfa.b>> f3239c;

        @Override // com.obric.assistant.n4
        public final void onAuthenticationCancelled() {
            j.b(this.f3237a, this.f3238b, this.f3239c, j.a(false, AuthenticationActionStatus.CANCELLED), "onAuthenticationCancelled");
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationFailed() {
            j.b(this.f3237a, this.f3238b, this.f3239c, j.a(false, AuthenticationActionStatus.FAILED), "onAuthenticationFailed");
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationNotAvailable() {
            j.b(this.f3237a, this.f3238b, this.f3239c, j.a(false, AuthenticationActionStatus.NOT_AVAILABLE), "onAuthenticationNotAvailable");
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationPass() {
            j.b(this.f3237a, this.f3238b, this.f3239c, j.a(true, AuthenticationActionStatus.PASS), "onAuthenticationPass");
        }

        @Override // com.obric.assistant.n4
        public final void onAuthenticationTimeout() {
            j.b(this.f3237a, this.f3238b, this.f3239c, j.a(false, AuthenticationActionStatus.TIMEOUT), "onAuthenticationTimeout");
        }

        public b(AtomicBoolean r100, String r101, kotlinx.coroutines.j r102) {
            this.f3237a = r100;
            this.f3238b = r101;
            this.f3239c = r102;
        }
    }

    public static final ISessionAuthenticationService d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        ISessionAuthenticationService r101 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r101 != null) goto L5;
        FLogger.f375446a.w(r100, "ISessionAuthenticationService is null");
    L5:
        return r101;
    }

    public static final com.obric.assistant.obric_action.h a(boolean r100, AuthenticationActionStatus r101) {
        bfa.b r102 = new bfa.b(r101);
        if (r100 == false) goto L5;
        com.obric.assistant.obric_action.h.f390443d.getClass();
        return new com.obric.assistant.obric_action.h(true, "authentication pass", r102);
    L5:
        com.obric.assistant.obric_action.h.a r103 = com.obric.assistant.obric_action.h.f390443d;
        String r104 = "authentication " + r101.getValue();
        r103.getClass();
        return new com.obric.assistant.obric_action.h(false, r104, r102);
    }

    public static final Object c(String r100, Function1<? super n4, Unit> r101, Continuation<? super com.obric.assistant.obric_action.h<bfa.b>> r102) {
        boolean r103 = true;
        kotlinx.coroutines.j r104 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
        r104.C();
        AtomicBoolean r105 = new AtomicBoolean(false);
        r104.i(new a(r105, r100));
        b r106 = new b(r105, r100, r104);
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L5
        r101.invoke(r106);     // Catch: Throwable -> L5
        Object r108 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L19;
        FLogger.f375446a.w(r100, "request authentication failed. " + r109.getMessage(), r109);
        com.obric.assistant.obric_action.h.a r110 = com.obric.assistant.obric_action.h.f390443d;
        String r111 = r109.getMessage();
        if (r111 != null) goto L13;
        r111 = "";
    L13:
        if (r111.length() == 0) goto L16;
        r103 = false;
    L16:
        if (r103 == false) goto L18;
        r111 = "request authentication failed";
    L18:
        b(r105, r100, r104, com.obric.assistant.obric_action.h.a.a(r110, r111, 2), "requestAuthenticationException");
    L19:
        Object r112 = r104.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended(r102);
    L22:
        return r112;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void b(AtomicBoolean r100, String r101, kotlinx.coroutines.i r102, com.obric.assistant.obric_action.h r103, String r104) {
        if (r100.compareAndSet(false, true) == true) goto L6;
        FLogger.f375446a.w(r101, r104.concat(" ignored because authentication result already completed"));
        return;
    L6:
        if (r102.isActive() == true) goto L8;
        FLogger.f375446a.w(r101, r104.concat(" ignored because authentication continuation is inactive"));
        return;
    L8:
        r102.resumeWith(Result.m9449constructorimpl(r103));
    }
}
