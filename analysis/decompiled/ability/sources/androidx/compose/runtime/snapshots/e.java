package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.room.AmbiguousColumnResolver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1814a = 0;
    public final /* synthetic */ int b;
    public final /* synthetic */ Collection c;

    public /* synthetic */ e(int i, Collection collection) {
        this.b = i;
        this.c = collection;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        switch (this.f1814a) {
            case 0:
                return Boolean.valueOf(SnapshotStateList.addAll$lambda$4(this.b, this.c, (List) obj));
            default:
                return AmbiguousColumnResolver.resolve$lambda$16$lambda$15((ArrayList) this.c, this.b, (List) obj);
        }
    }

    public /* synthetic */ e(ArrayList arrayList, int i) {
        this.c = arrayList;
        this.b = i;
    }
}
