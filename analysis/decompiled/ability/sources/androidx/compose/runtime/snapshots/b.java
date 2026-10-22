package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1811a;
    public final /* synthetic */ k b;
    public final /* synthetic */ k c;

    public /* synthetic */ b(int i, k kVar, k kVar2) {
        this.f1811a = i;
        this.b = kVar;
        this.c = kVar2;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1811a) {
            case 0:
                return SnapshotKt.mergedReadObserver$lambda$2(this.b, this.c, obj);
            case 1:
                return SnapshotKt.mergedWriteObserver$lambda$3(this.b, this.c, obj);
            default:
                return SnapshotObserverKt.mergeObservers$lambda$6(this.b, this.c, obj);
        }
    }
}
