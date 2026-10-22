package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1812a;
    public final /* synthetic */ k b;

    public /* synthetic */ c(k kVar, int i) {
        this.f1812a = i;
        this.b = kVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1812a;
        k kVar = this.b;
        switch (i) {
            case 0:
                return SnapshotKt.takeNewSnapshot$lambda$12(kVar, (SnapshotIdSet) obj);
            default:
                return RoomRawQuery.bindingFunction$lambda$1(kVar, (SQLiteStatement) obj);
        }
    }
}
