package android.view.compose;

import S7.a;
import S7.k;
import androidx.compose.runtime.CompositionLocalAccessorScope;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1662a;

    public /* synthetic */ f(int i) {
        this.f1662a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1662a) {
            case 0:
                return ReportDrawnComposition.snapshotStateObserver$lambda$0((a) obj);
            default:
                return LocalActivityKt.LocalActivity$lambda$0((CompositionLocalAccessorScope) obj);
        }
    }
}
