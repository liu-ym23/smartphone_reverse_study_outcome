package Z2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: Z2.l0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0137l0 extends s0 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2228e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f2229f;

    public C0137l0(int i4, Object obj) {
        this.f2228e = i4;
        this.f2229f = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        switch (this.f2228e) {
            case 0:
                j((Throwable) obj);
                break;
            default:
                j((Throwable) obj);
                break;
        }
        return Unit.INSTANCE;
    }

    @Override // Z2.s0
    public final void j(Throwable th) {
        int i4 = this.f2228e;
        Object obj = this.f2229f;
        switch (i4) {
            case 0:
                ((Function1) obj).invoke(th);
                break;
            default:
                Object objG = i().G();
                if (!(objG instanceof r)) {
                    Result.Companion companion = Result.INSTANCE;
                    ((C0128h) obj).resumeWith(Result.m22constructorimpl(I.G(objG)));
                    break;
                } else {
                    Result.Companion companion2 = Result.INSTANCE;
                    ((C0128h) obj).resumeWith(Result.m22constructorimpl(ResultKt.createFailure(((r) objG).f2238a)));
                    break;
                }
        }
    }
}
