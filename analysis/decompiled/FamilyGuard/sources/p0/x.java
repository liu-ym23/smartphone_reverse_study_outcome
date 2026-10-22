package p0;

import java.lang.reflect.Type;
import o0.C0888a;

/* loaded from: classes.dex */
public class x implements t {

    /* renamed from: a, reason: collision with root package name */
    public final Class<w> f19341a;

    public x(Class<w> cls) {
        this.f19341a = cls;
    }

    @Override // p0.t
    public int d() {
        return 12;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        try {
            return (T) c0888a.U(this.f19341a.newInstance(), obj);
        } catch (Exception unused) {
            throw new l0.d("craete instance error");
        }
    }
}
