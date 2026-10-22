package androidx.compose.runtime.snapshots;

import S7.k;
import S7.n;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserver;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements ObserverHandle {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1810a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1810a = i;
        this.b = obj;
    }

    @Override // androidx.compose.runtime.snapshots.ObserverHandle
    public final void dispose() {
        int i = this.f1810a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Snapshot.Companion.registerApplyObserver$lambda$3((n) obj);
                break;
            case 1:
                Snapshot.Companion.registerGlobalWriteObserver$lambda$6((k) obj);
                break;
            default:
                SnapshotObserverKt.observeSnapshots$lambda$3((SnapshotObserver) obj);
                break;
        }
    }
}
