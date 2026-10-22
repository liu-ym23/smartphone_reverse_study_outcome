package l0;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import q0.C0946I;
import q0.InterfaceC0944G;
import q0.e0;
import q0.f0;

/* loaded from: classes.dex */
public class f implements InterfaceC0944G {

    /* renamed from: c, reason: collision with root package name */
    public static String f18030c = "/**/";

    /* renamed from: a, reason: collision with root package name */
    private String f18031a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Object> f18032b = new ArrayList();

    public f() {
    }

    @Override // q0.InterfaceC0944G
    public void a(C0946I c0946i, Object obj, Type type, int i5) {
        e0 e0Var = c0946i.f19676k;
        int i6 = f0.BrowserSecure.f19849a;
        if ((i5 & i6) != 0 || e0Var.u(i6)) {
            e0Var.write(f18030c);
        }
        e0Var.write(this.f18031a);
        e0Var.write(40);
        for (int i7 = 0; i7 < this.f18032b.size(); i7++) {
            if (i7 != 0) {
                e0Var.write(44);
            }
            c0946i.G(this.f18032b.get(i7));
        }
        e0Var.write(41);
    }

    public void b(Object obj) {
        this.f18032b.add(obj);
    }

    public String toString() {
        return AbstractC0822a.F(this);
    }

    public f(String str) {
        this.f18031a = str;
    }
}
