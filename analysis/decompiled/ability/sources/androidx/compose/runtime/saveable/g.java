package androidx.compose.runtime.saveable;

import S7.n;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1807a;

    public /* synthetic */ g(int i) {
        this.f1807a = i;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        SaverScope saverScope = (SaverScope) obj;
        switch (this.f1807a) {
            case 0:
                return SaveableStateHolderImpl.Saver$lambda$11(saverScope, (SaveableStateHolderImpl) obj2);
            default:
                return SaverKt.AutoSaver$lambda$0(saverScope, obj2);
        }
    }
}
