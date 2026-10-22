package android.view;

import S7.k;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.Ref$BooleanRef;

/* renamed from: androidx.lifecycle.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0780i implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1986a;
    public final /* synthetic */ MediatorLiveData b;
    public final /* synthetic */ Object c;

    public /* synthetic */ C0780i(MediatorLiveData mediatorLiveData, Object obj, int i) {
        this.f1986a = i;
        this.b = mediatorLiveData;
        this.c = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1986a) {
            case 0:
                return Transformations.map$lambda$0(this.b, (k) this.c, obj);
            case 1:
                return Transformations.distinctUntilChanged$lambda$4(this.b, (Ref$BooleanRef) this.c, obj);
            default:
                return Transformations.map$lambda$1(this.b, (Function) this.c, obj);
        }
    }
}
