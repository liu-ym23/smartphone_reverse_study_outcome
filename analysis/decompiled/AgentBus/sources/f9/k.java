package f9;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class k extends j implements v {

    /* renamed from: g, reason: collision with root package name */
    public i f3566g = i.f3562c;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3567h;

    public final void d(l lVar) {
        a0 a0Var;
        if (!this.f3567h) {
            this.f3566g = this.f3566g.clone();
            this.f3567h = true;
        }
        i iVar = this.f3566g;
        i iVar2 = lVar.f3568f;
        iVar.getClass();
        int i2 = 0;
        while (true) {
            a0Var = iVar2.f3563a;
            if (i2 >= a0Var.f3526g.size()) {
                break;
            }
            iVar.g((Map.Entry) a0Var.f3526g.get(i2));
            i2++;
        }
        Iterator it = a0Var.c().iterator();
        while (it.hasNext()) {
            iVar.g((Map.Entry) it.next());
        }
    }
}
