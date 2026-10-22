package android.view.compose;

import S7.k;
import S7.n;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composer;

/* renamed from: androidx.lifecycle.compose.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0770b implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1976a;
    public final /* synthetic */ LifecycleOwner b;
    public final /* synthetic */ k c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ C0770b(LifecycleOwner lifecycleOwner, k kVar, int i, int i6, int i10) {
        this.f1976a = i10;
        this.b = lifecycleOwner;
        this.c = kVar;
        this.d = i;
        this.e = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1976a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffect$lambda$14(this.b, this.c, this.d, this.e, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffect$lambda$29(this.b, this.c, this.d, this.e, (Composer) obj, iIntValue2);
        }
    }
}
