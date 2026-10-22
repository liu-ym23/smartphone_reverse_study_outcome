package A2;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class o5 implements l5 {

    /* renamed from: a, reason: collision with root package name */
    public final List f833a;

    public o5(Context context, n5 n5Var) {
        ArrayList arrayList = new ArrayList();
        this.f833a = arrayList;
        if (n5Var.c()) {
            arrayList.add(new y5(context, n5Var));
        }
    }

    @Override // A2.l5
    public final void a(k5 k5Var) {
        Iterator it = this.f833a.iterator();
        while (it.hasNext()) {
            ((l5) it.next()).a(k5Var);
        }
    }
}
