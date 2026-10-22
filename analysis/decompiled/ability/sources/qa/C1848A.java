package qa;

import java.lang.reflect.Method;

/* renamed from: qa.A, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1848A extends U {
    public final /* synthetic */ int d;
    public final Method e;
    public final int f;

    public /* synthetic */ C1848A(Method method, int i, int i6) {
        this.d = i6;
        this.e = method;
        this.f = i;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        switch (this.d) {
            case 0:
                F9.w wVar = (F9.w) obj;
                if (wVar == null) {
                    throw U.l(this.e, this.f, "Headers parameter must not be null.", new Object[0]);
                }
                F9.v vVar = i.f;
                vVar.getClass();
                int size = wVar.size();
                for (int i6 = 0; i6 < size; i6++) {
                    vVar.d(wVar.e(i6), wVar.h(i6));
                }
                return;
            default:
                if (obj == null) {
                    throw U.l(this.e, this.f, "@Url parameter is null.", new Object[0]);
                }
                i.c = obj.toString();
                return;
        }
    }
}
