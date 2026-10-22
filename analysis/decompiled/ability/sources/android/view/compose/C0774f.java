package android.view.compose;

import S7.k;
import S7.n;
import android.view.LifecycleOwner;
import androidx.compose.runtime.Composer;

/* renamed from: androidx.lifecycle.compose.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0774f implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1980a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ LifecycleOwner e;
    public final /* synthetic */ k f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;

    public /* synthetic */ C0774f(Object obj, Object obj2, Object obj3, LifecycleOwner lifecycleOwner, k kVar, int i, int i6, int i10) {
        this.f1980a = i10;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = lifecycleOwner;
        this.f = kVar;
        this.g = i;
        this.h = i6;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1980a) {
            case 0:
                int iIntValue = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleResumeEffect$lambda$26(this.b, this.c, this.d, this.e, this.f, this.g, this.h, (Composer) obj, iIntValue);
            default:
                int iIntValue2 = ((Integer) obj2).intValue();
                return LifecycleEffectKt.LifecycleStartEffect$lambda$11(this.b, this.c, this.d, this.e, this.f, this.g, this.h, (Composer) obj, iIntValue2);
        }
    }
}
