package Tb;

import bc.InterfaceC1477a;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class m implements Zb.b {

    /* renamed from: a, reason: collision with root package name */
    public final List<InterfaceC1477a> f5977a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, Yb.r> f5978b;

    public m(List<InterfaceC1477a> list, Map<String, Yb.r> map) {
        this.f5977a = list;
        this.f5978b = map;
    }

    @Override // Zb.b
    public Yb.r a(String str) {
        return this.f5978b.get(str);
    }

    @Override // Zb.b
    public List<InterfaceC1477a> b() {
        return this.f5977a;
    }
}
