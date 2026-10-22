package androidx.compose.foundation.text.selection;

import S7.n;
import androidx.compose.ui.semantics.SemanticsSortKt;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1742a;
    public final /* synthetic */ n b;

    public /* synthetic */ b(n nVar, int i) {
        this.f1742a = i;
        this.b = nVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.f1742a;
        n nVar = this.b;
        switch (i) {
            case 0:
                return SelectionRegistrarImpl.sort$lambda$2(nVar, obj, obj2);
            default:
                return SemanticsSortKt.sortByGeometryGroupings$lambda$3(nVar, obj, obj2);
        }
    }
}
