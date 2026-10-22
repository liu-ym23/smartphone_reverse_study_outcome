package android.view.compose;

import S7.k;
import S7.n;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composer;

/* renamed from: androidx.lifecycle.compose.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0773e implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1979a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ LifecycleOwner d;
    public final /* synthetic */ k e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;

    public /* synthetic */ C0773e(Object obj, Object obj2, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, int i10) {
        this.f1979a = i10;
        this.b = obj;
        this.c = obj2;
        this.d = lifecycleOwner;
        this.e = kVar;
        this.f = i;
        this.g = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1979a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffect$lambda$9(this.b, this.c, this.d, this.e, this.f, this.g, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffect$lambda$24(this.b, this.c, this.d, this.e, this.f, this.g, (Composer) obj, iIntValue2);
        }
    }
}
