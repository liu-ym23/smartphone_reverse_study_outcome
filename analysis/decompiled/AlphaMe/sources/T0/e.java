package T0;

import Z2.F;
import g3.C0580d;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
public final class e extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public C0580d f1808a;

    /* renamed from: b, reason: collision with root package name */
    public i f1809b;

    /* renamed from: c, reason: collision with root package name */
    public h f1810c;

    /* renamed from: d, reason: collision with root package name */
    public int f1811d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f1812e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ i f1813f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(h hVar, i iVar, Continuation continuation) {
        super(2, continuation);
        this.f1812e = hVar;
        this.f1813f = iVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new e(this.f1812e, this.f1813f, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        h hVar;
        C0580d c0580d;
        i iVar;
        Object objM22constructorimpl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1811d;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            h hVar2 = this.f1812e;
            C0580d c0580d2 = hVar2.f1827b;
            this.f1808a = c0580d2;
            i iVar2 = this.f1813f;
            this.f1809b = iVar2;
            this.f1810c = hVar2;
            this.f1811d = 1;
            if (c0580d2.d(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            hVar = hVar2;
            c0580d = c0580d2;
            iVar = iVar2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            hVar = this.f1810c;
            iVar = this.f1809b;
            c0580d = this.f1808a;
            ResultKt.throwOnFailure(obj);
        }
        if (iVar != null) {
            try {
                h.a(hVar, iVar);
            } finally {
                c0580d.e(null);
            }
        }
        try {
            hVar.f1828c.a(hVar.f1826a, hVar.f1829d, hVar.f1830e, hVar.f1837l, hVar.f1831f, hVar.f1832g, hVar.f1838m, hVar.f1833h, Boxing.boxBoolean(hVar.f1839n));
            hVar.f1828c.g();
            Result.Companion companion = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(Boxing.boxBoolean(true));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m21boximpl(objM22constructorimpl);
    }
}
