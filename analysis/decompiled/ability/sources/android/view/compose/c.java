package android.view.compose;

import S7.a;
import androidx.room.coroutines.ConnectionPoolImpl;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1659a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ c(Object obj, boolean z10, int i) {
        this.f1659a = i;
        this.c = obj;
        this.b = z10;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f1659a) {
            case 0:
                return BackHandlerKt.BackHandler$lambda$3$lambda$2((BackHandlerKt$BackHandler$backCallback$1$1) this.c, this.b);
            default:
                return ConnectionPoolImpl.useConnection$lambda$6((ConnectionPoolImpl) this.c, this.b);
        }
    }
}
