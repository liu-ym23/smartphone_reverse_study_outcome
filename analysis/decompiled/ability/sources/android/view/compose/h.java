package android.view.compose;

import C7.d;
import S7.a;
import S7.n;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1664a;
    public final /* synthetic */ d b;
    public final /* synthetic */ int c;

    public /* synthetic */ h(d dVar, int i, int i6) {
        this.f1664a = i6;
        this.b = dVar;
        this.c = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1664a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ReportDrawnKt.ReportDrawnWhen$lambda$0((a) this.b, this.c, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return ReportDrawnKt.ReportDrawnWhen$lambda$5((a) this.b, this.c, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return EffectsKt.LaunchedEffect$lambda$4((n) this.b, this.c, (Composer) obj, iIntValue3);
        }
    }
}
