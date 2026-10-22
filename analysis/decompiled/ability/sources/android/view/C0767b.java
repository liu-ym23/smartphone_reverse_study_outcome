package android.view;

import S7.a;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0767b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1973a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C0767b(Object obj, int i) {
        this.f1973a = i;
        this.b = obj;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f1973a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return CoroutineLiveData._init_$lambda$0((CoroutineLiveData) obj);
            default:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) obj);
        }
    }
}
