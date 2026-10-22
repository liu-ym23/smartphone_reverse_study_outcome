package y1;

import java.nio.charset.Charset;
import k2.e1;
import k2.f1;
import k2.g1;
import k2.h1;
import k2.i1;
import k2.j1;
import k2.q1;
import k2.y0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6333a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static j1 a(f1 f1Var) {
        g1 g1VarZ = j1.z();
        int iB = f1Var.B();
        g1VarZ.e();
        j1.w((j1) g1VarZ.f1537b, iB);
        for (e1 e1Var : f1Var.A()) {
            h1 h1VarB = i1.B();
            String strB = e1Var.A().B();
            h1VarB.e();
            i1.w((i1) h1VarB.f1537b, strB);
            y0 y0VarD = e1Var.D();
            h1VarB.e();
            i1.y((i1) h1VarB.f1537b, y0VarD);
            q1 q1VarC = e1Var.C();
            h1VarB.e();
            i1.x((i1) h1VarB.f1537b, q1VarC);
            int iB2 = e1Var.B();
            h1VarB.e();
            i1.z((i1) h1VarB.f1537b, iB2);
            i1 i1Var = (i1) h1VarB.b();
            g1VarZ.e();
            j1.x((j1) g1VarZ.f1537b, i1Var);
        }
        return (j1) g1VarZ.b();
    }
}
