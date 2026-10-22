package androidx.compose.runtime;

import S7.n;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Set;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1798a;
    public final /* synthetic */ Object b;

    public /* synthetic */ j(Object obj, int i) {
        this.f1798a = i;
        this.b = obj;
    }

    @Override // S7.n
    public final Object invoke(Object obj, Object obj2) {
        int i = this.f1798a;
        Object obj3 = this.b;
        switch (i) {
            case 0:
                return Recomposer.C06902.invokeSuspend$lambda$2((Recomposer) obj3, (Set) obj, (Snapshot) obj2);
            case 1:
                return SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$2((kotlinx.coroutines.channels.a) obj3, (Set) obj, (Snapshot) obj2);
            default:
                return ComposerKt.removeCurrentGroup$lambda$2((RememberManager) obj3, ((Integer) obj).intValue(), obj2);
        }
    }
}
