package android.view;

import S7.k;
import android.view.CoroutineLiveDataKt;
import android.view.Transformations;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0768c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1974a;
    public final /* synthetic */ MediatorLiveData b;

    public /* synthetic */ C0768c(MediatorLiveData mediatorLiveData, int i) {
        this.f1974a = i;
        this.b = mediatorLiveData;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1974a;
        MediatorLiveData mediatorLiveData = this.b;
        switch (i) {
            case 0:
                return CoroutineLiveDataKt.AnonymousClass2.invokeSuspend$lambda$0(mediatorLiveData, obj);
            case 1:
                return Transformations.switchMap$lambda$3$lambda$2(mediatorLiveData, obj);
            default:
                return Transformations.AnonymousClass2.onChanged$lambda$0(mediatorLiveData, obj);
        }
    }
}
