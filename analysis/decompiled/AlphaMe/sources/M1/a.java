package M1;

import N1.b;
import androidx.core.app.f;
import java.util.LinkedList;

/* loaded from: classes.dex */
public final class a extends LinkedList {

    /* renamed from: a, reason: collision with root package name */
    public int f1434a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1435b;

    /* renamed from: c, reason: collision with root package name */
    public f f1436c;

    @Override // java.util.LinkedList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List, java.util.Deque, java.util.Queue
    public final boolean add(Object obj) {
        if (size() + 1 > this.f1434a) {
            Object objRemoveFirst = removeFirst();
            f fVar = this.f1436c;
            if (fVar != null) {
                com.stepos.architecture.domain.dispatch.a.c((com.stepos.architecture.domain.dispatch.a) fVar.f3281a, (b) objRemoveFirst);
            }
        }
        return super.add(obj);
    }
}
