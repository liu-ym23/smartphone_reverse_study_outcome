package te;

import java.util.ArrayList;
import k0.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13336a;

    public f(Object obj) {
        if (obj != null) {
            this.f13336a = obj;
        } else {
            g5.f.s("Wrapped Object can not be null.");
            throw null;
        }
    }

    public boolean c(q0 q0Var, Object obj) {
        ArrayList arrayList = q0Var.f7024a;
        if (arrayList == null) {
            return true;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = arrayList.get(i);
            if (obj2 instanceof k0.b) {
                if (obj2.equals(obj)) {
                    return true;
                }
            } else {
                if (!(obj2 instanceof q0)) {
                    g5.f.n(obj2, "Unexpected child source info ");
                    return false;
                }
                if (c((q0) obj2, obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public f() {
        this.f13336a = new ArrayList();
    }

    public void d(q0 q0Var, Object obj) {
    }
}
