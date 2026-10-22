package O8;

import O8.h;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements h.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f5264a;

    /* renamed from: b, reason: collision with root package name */
    public final List<h.f> f5265b;

    public d(String str, List<h.f> list) {
        this.f5264a = str;
        this.f5265b = list;
    }

    @Override // O8.h.a
    public List<h.f> a() {
        return this.f5265b;
    }

    @Override // O8.h.a
    public String name() {
        return this.f5264a;
    }

    public String toString() {
        return k.a(this);
    }
}
