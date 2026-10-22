package m0;

import b0.q0;
import java.util.ArrayList;
import x8.k;
import x8.l;

/* loaded from: classes.dex */
public abstract class a implements l {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f6121f;

    public a(int i2) {
        switch (i2) {
            case 1:
                this.f6121f = new ArrayList();
                break;
            default:
                this.f6121f = new ArrayList();
                break;
        }
    }

    public boolean a(q0 q0Var, Object obj) {
        ArrayList arrayList = q0Var.f1318a;
        if (arrayList == null) {
            return true;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj2 = arrayList.get(i2);
            if (obj2 instanceof b0.a) {
                if (obj2.equals(obj)) {
                    return true;
                }
            } else {
                if (!(obj2 instanceof q0)) {
                    throw new IllegalStateException(("Unexpected child source info " + obj2).toString());
                }
                if (a((q0) obj2, obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // x8.l
    public void b() {
        e((String[]) this.f6121f.toArray(new String[0]));
    }

    public void c(q0 q0Var, Object obj) {
    }

    @Override // x8.l
    public k d(e9.b bVar) {
        return null;
    }

    public abstract void e(String[] strArr);

    @Override // x8.l
    public void h(e9.b bVar, e9.f fVar) {
    }

    @Override // x8.l
    public void j(j9.f fVar) {
    }

    @Override // x8.l
    public void t(Object obj) {
        if (obj instanceof String) {
            this.f6121f.add((String) obj);
        }
    }
}
