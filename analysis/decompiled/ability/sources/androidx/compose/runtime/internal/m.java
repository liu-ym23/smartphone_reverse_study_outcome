package androidx.compose.runtime.internal;

import android.view.LifecycleOwner;
import android.view.compose.LifecycleEffectKt;
import android.view.compose.LifecycleResumePauseEffectScope;
import android.view.compose.LifecycleStartStopEffectScope;
import androidx.compose.runtime.Composer;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements S7.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1787a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i, int i6) {
        this.f1787a = i6;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
        this.b = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1787a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return ComposableLambdaImpl.invoke$lambda$1((ComposableLambdaImpl) this.c, this.d, this.e, this.b, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffectImpl$lambda$20((LifecycleOwner) this.c, (LifecycleStartStopEffectScope) this.d, (S7.k) this.e, this.b, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffectImpl$lambda$35((LifecycleOwner) this.c, (LifecycleResumePauseEffectScope) this.d, (S7.k) this.e, this.b, (Composer) obj, iIntValue3);
        }
    }
}
