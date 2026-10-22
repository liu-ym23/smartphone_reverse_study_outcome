package q0;

import java.lang.reflect.Type;
import o0.C0888a;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class r implements U, p0.t {

    /* renamed from: a, reason: collision with root package name */
    public static final r f19873a = new r();

    @Override // q0.U
    public void b(C0946I c0946i, Object obj, Object obj2, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        Character ch = (Character) obj;
        if (ch == null) {
            e0Var.h0(BuildConfig.FLAVOR);
        } else if (ch.charValue() == 0) {
            e0Var.h0("\u0000");
        } else {
            e0Var.h0(ch.toString());
        }
    }

    @Override // p0.t
    public int d() {
        return 4;
    }

    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        Object objS = c0888a.S();
        if (objS == null) {
            return null;
        }
        return (T) u0.o.n(objS);
    }
}
