package android.view.compose;

import S7.a;
import S7.n;
import androidx.compose.runtime.Composer;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1660a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ C7.d e;

    public /* synthetic */ d(boolean z10, C7.d dVar, int i, int i6, int i10) {
        this.f1660a = i10;
        this.b = z10;
        this.e = dVar;
        this.c = i;
        this.d = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1660a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return BackHandlerKt.BackHandler$lambda$8(this.b, (a) this.e, this.c, this.d, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return PredictiveBackHandlerKt.PredictiveBackHandler$lambda$8(this.b, (n) this.e, this.c, this.d, (Composer) obj, iIntValue2);
        }
    }
}
