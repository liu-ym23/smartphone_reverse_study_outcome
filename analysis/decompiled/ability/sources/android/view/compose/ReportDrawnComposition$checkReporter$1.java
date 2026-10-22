package android.view.compose;

import C7.r;
import S7.a;
import S7.k;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public /* synthetic */ class ReportDrawnComposition$checkReporter$1 extends FunctionReferenceImpl implements k {
    public ReportDrawnComposition$checkReporter$1(Object obj) {
        super(1, obj, ReportDrawnComposition.class, "observeReporter", "observeReporter(Lkotlin/jvm/functions/Function0;)V", 0);
    }

    @Override // S7.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return r.f317a;
    }

    public final void invoke(a aVar) {
        ((ReportDrawnComposition) this.receiver).observeReporter(aVar);
    }
}
