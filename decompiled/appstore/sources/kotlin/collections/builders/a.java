package kotlin.collections.builders;

import java.util.Map;
import kotlin.collections.g;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends g {
    public a() {
    }

    public final boolean a(Map.Entry r10) {
        q.g(r10, "element");
        return b(r10);
    }

    public abstract boolean b(Map.Entry r10);

    public abstract /* bridge */ boolean c(Map.Entry r10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return a((Map.Entry) r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ boolean remove(Object r10) {
        if ((r10 instanceof Map.Entry) == true) goto L7;
        return false;
    L7:
        return c((Map.Entry) r10);
    }
}
