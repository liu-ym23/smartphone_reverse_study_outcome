package t3;

import f4.c2;
import f4.k1;
import f4.q1;
import f4.r1;
import f4.s1;
import f4.t1;
import f4.u1;
import f4.v1;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f9730a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static v1 a(r1 r1Var) {
        s1 s1VarY = v1.y();
        int iA = r1Var.A();
        s1VarY.d();
        v1.v((v1) s1VarY.f2287g, iA);
        for (q1 q1Var : r1Var.z()) {
            t1 t1VarA = u1.A();
            String strA = q1Var.z().A();
            t1VarA.d();
            u1.v((u1) t1VarA.f2287g, strA);
            k1 k1VarC = q1Var.C();
            t1VarA.d();
            u1.x((u1) t1VarA.f2287g, k1VarC);
            c2 c2VarB = q1Var.B();
            t1VarA.d();
            u1.w((u1) t1VarA.f2287g, c2VarB);
            int iA2 = q1Var.A();
            t1VarA.d();
            u1.y((u1) t1VarA.f2287g, iA2);
            u1 u1Var = (u1) t1VarA.a();
            s1VarY.d();
            v1.w((v1) s1VarY.f2287g, u1Var);
        }
        return (v1) s1VarY.a();
    }
}
