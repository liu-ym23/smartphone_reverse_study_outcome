package S;

import Z2.InterfaceC0126g;
import android.content.Context;
import com.stepos.policy.sdk.PolicyManager;
import java.util.concurrent.CancellationException;
import k0.InterfaceC0674b;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class s extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1770a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1771b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(int i4, Object obj) {
        super(1);
        this.f1770a = i4;
        this.f1771b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object objM22constructorimpl;
        int i4 = this.f1770a;
        Object obj2 = this.f1771b;
        switch (i4) {
            case 0:
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 1:
                InterfaceC0674b db = (InterfaceC0674b) obj;
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL((String) obj2);
                return null;
            case 2:
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 3:
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 4:
                String deleteInfoListJson = (String) obj;
                Intrinsics.checkNotNullParameter(deleteInfoListJson, "deleteInfoListJson");
                PolicyManager policyManager = PolicyManager.INSTANCE;
                t0.J.y(policyManager.getLifecycleScope(), policyManager.getExceptionHandler(), new com.stepos.policy.sdk.N((Context) obj2, deleteInfoListJson, null), 2);
                return Unit.INSTANCE;
            case 5:
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 6:
                Throwable th = (Throwable) obj;
                Function1 function1 = (Function1) obj2;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Throwable th2 = (Throwable) function1.invoke(th);
                    if (!Intrinsics.areEqual(th.getMessage(), th2.getMessage()) && !Intrinsics.areEqual(th2.getMessage(), th.toString())) {
                        th2 = null;
                    }
                    objM22constructorimpl = Result.m22constructorimpl(th2);
                } catch (Throwable th3) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th3));
                }
                return (Throwable) (Result.m28isFailureimpl(objM22constructorimpl) ? null : objM22constructorimpl);
            default:
                invoke((Throwable) obj);
                return Unit.INSTANCE;
        }
    }

    public final void invoke(Throwable th) {
        switch (this.f1770a) {
            case 0:
                if (th != null) {
                    ((M) this.f1771b).f1732g.b(new C0104j(th));
                }
                Object obj = M.f1725k;
                M m4 = (M) this.f1771b;
                synchronized (obj) {
                    M.f1724j.remove(m4.d().getAbsolutePath());
                    Unit unit = Unit.INSTANCE;
                }
                return;
            case 1:
            case 4:
            default:
                ((g3.h) this.f1771b).b();
                return;
            case 2:
                Object obj2 = this.f1771b;
                if (th == null) {
                    if (!((s0.n) obj2).f14208a.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    return;
                } else {
                    if (th instanceof CancellationException) {
                        ((s0.n) obj2).f14208a.cancel(true);
                        return;
                    }
                    D0.j jVar = ((s0.n) obj2).f14208a;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    jVar.k(th);
                    return;
                }
            case 3:
                ((D1.a) this.f1771b).cancel(false);
                return;
            case 5:
                InterfaceC0126g interfaceC0126g = (InterfaceC0126g) this.f1771b;
                Result.Companion companion = Result.INSTANCE;
                interfaceC0126g.resumeWith(Result.m22constructorimpl(Unit.INSTANCE));
                return;
        }
    }
}
