package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1813a;
    public final /* synthetic */ Collection b;

    public /* synthetic */ d(Collection collection, int i) {
        this.f1813a = i;
        this.b = collection;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        boolean zRetainAll$lambda$10;
        int i = this.f1813a;
        Collection collection = this.b;
        switch (i) {
            case 0:
                zRetainAll$lambda$10 = SnapshotStateList.retainAll$lambda$10(collection, (List) obj);
                break;
            case 1:
                zRetainAll$lambda$10 = SnapshotStateSet.retainAll$lambda$5(collection, (Set) obj);
                break;
            case 2:
                zRetainAll$lambda$10 = AbstractPersistentList.retainAll$lambda$3(collection, obj);
                break;
            case 3:
                zRetainAll$lambda$10 = collection.contains(obj);
                break;
            default:
                zRetainAll$lambda$10 = collection.contains(obj);
                break;
        }
        return Boolean.valueOf(zRetainAll$lambda$10);
    }
}
