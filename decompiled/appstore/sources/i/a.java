package i;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap f20470e;

    public a() {
        this.f20470e = new HashMap();
    }

    @Override // i.b
    public b.c b(Object r10) {
        return (b.c) this.f20470e.get(r10);
    }

    public boolean contains(Object r10) {
        return this.f20470e.containsKey(r10);
    }

    @Override // i.b
    public Object f(Object r10, Object r11) {
        b.c r12 = b(r10);
        if (r12 != null) goto L5;
        this.f20470e.put(r10, e(r10, r11));
        return null;
    L5:
        return r12.f20476b;
    }

    @Override // i.b
    public Object g(Object r10) {
        Object r11 = super.g(r10);
        this.f20470e.remove(r10);
        return r11;
    }

    public Map.Entry h(Object r10) {
        if (contains(r10) == true) goto L5;
        return null;
    L5:
        return ((b.c) this.f20470e.get(r10)).f20478d;
    }
}
