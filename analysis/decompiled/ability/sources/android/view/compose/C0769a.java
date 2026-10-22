package android.view.compose;

import C7.d;
import S7.a;
import S7.k;
import S7.n;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composer;

/* renamed from: androidx.lifecycle.compose.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0769a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1975a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ LifecycleOwner c;
    public final /* synthetic */ d d;
    public final /* synthetic */ int e;
    public final /* synthetic */ int f;

    public /* synthetic */ C0769a(Object obj, LifecycleOwner lifecycleOwner, d dVar, int i, int i6, int i10) {
        this.f1975a = i10;
        this.b = obj;
        this.c = lifecycleOwner;
        this.d = dVar;
        this.e = i;
        this.f = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1975a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffect$lambda$7(this.b, this.c, (k) this.d, this.e, this.f, (Composer) obj, iIntValue);
            case 1:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffect$lambda$22(this.b, this.c, (k) this.d, this.e, this.f, (Composer) obj, iIntValue2);
            default:
                int iIntValue3 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleEventEffect$lambda$5((Lifecycle.Event) this.b, this.c, (a) this.d, this.e, this.f, (Composer) obj, iIntValue3);
        }
    }
}
