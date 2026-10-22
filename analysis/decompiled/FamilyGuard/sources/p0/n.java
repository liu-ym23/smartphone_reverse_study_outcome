package p0;

import java.lang.reflect.Type;
import o0.AbstractC0891d;
import o0.C0888a;

/* loaded from: classes.dex */
public class n implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final n f19305a = new n();

    @Override // p0.t
    public int d() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, l0.f] */
    @Override // p0.t
    public <T> T e(C0888a c0888a, Type type, Object obj) {
        int iU;
        AbstractC0891d abstractC0891d = (AbstractC0891d) c0888a.G();
        String strX = abstractC0891d.x(c0888a.L());
        abstractC0891d.nextToken();
        int iU2 = abstractC0891d.U();
        if (iU2 == 25) {
            String str = strX + ".";
            strX = str + abstractC0891d.x(c0888a.L());
            abstractC0891d.nextToken();
            iU2 = abstractC0891d.U();
        }
        ?? r02 = (T) new l0.f(strX);
        if (iU2 != 10) {
            throw new l0.d("illegal jsonp : " + abstractC0891d.c());
        }
        abstractC0891d.nextToken();
        while (true) {
            r02.b(c0888a.S());
            iU = abstractC0891d.U();
            if (iU != 16) {
                break;
            }
            abstractC0891d.nextToken();
        }
        if (iU == 11) {
            abstractC0891d.nextToken();
            if (abstractC0891d.U() == 24) {
                abstractC0891d.nextToken();
            }
            return r02;
        }
        throw new l0.d("illegal jsonp : " + abstractC0891d.c());
    }
}
