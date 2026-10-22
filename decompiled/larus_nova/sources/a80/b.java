package a80;

import h70.b;
import j70.e;
import j70.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class b<T extends h70.b> extends a<T> implements k {
    @Override // j70.k
    public /* synthetic */ boolean k() {
        return false;
    }

    @Override // a80.a
    public final e p() {
        return this;
    }

    @Override // j70.k
    public final /* synthetic */ boolean v() {
        return false;
    }

    public b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "layerContext");
        super(r100);
    }
}
