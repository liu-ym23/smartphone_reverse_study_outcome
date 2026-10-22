package w2;

import d7.n;
import java.util.Map;
import m.x;
import p7.k;
import q7.m;

/* loaded from: classes.dex */
public final class a extends m implements k {

    /* renamed from: g, reason: collision with root package name */
    public static final a f10648g = new a(1);

    @Override // p7.k
    public final Object invoke(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        q7.k.e(entry, "entry");
        Object value = entry.getValue();
        return x.n(new StringBuilder("  "), ((d) entry.getKey()).f10655a, " = ", value instanceof byte[] ? n.n0((byte[]) value, ", ", null, 56) : String.valueOf(entry.getValue()));
    }
}
