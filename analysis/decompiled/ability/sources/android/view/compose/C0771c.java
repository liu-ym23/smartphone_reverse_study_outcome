package android.view.compose;

import S7.k;
import S7.n;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composer;

/* renamed from: androidx.lifecycle.compose.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0771c implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1977a;
    public final /* synthetic */ Object[] b;
    public final /* synthetic */ LifecycleOwner c;
    public final /* synthetic */ k d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    public /* synthetic */ C0771c(Object[] objArr, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, int i10) {
        this.f1977a = i10;
        this.b = objArr;
        this.c = lifecycleOwner;
        this.d = kVar;
        this.e = i;
        this.f = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1977a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffect$lambda$28(this.b, this.c, this.d, this.e, this.f, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffect$lambda$13(this.b, this.c, this.d, this.e, this.f, (Composer) obj, iIntValue2);
        }
    }
}
