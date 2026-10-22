package O8;

import O8.h;
import java.util.List;

/* loaded from: classes4.dex */
public class l implements h.f {

    /* renamed from: a, reason: collision with root package name */
    public final String f5281a;

    /* renamed from: b, reason: collision with root package name */
    public final List<h.c> f5282b;

    public l(String str, List<h.c> list) {
        this.f5281a = str;
        this.f5282b = list;
    }

    @Override // O8.h.f
    public List<h.c> a() {
        return this.f5282b;
    }

    @Override // O8.h.f
    public String name() {
        return this.f5281a;
    }

    public String toString() {
        return k.c(this);
    }
}
