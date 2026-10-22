package E9;

import Ca.h;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public abstract class g0<Type extends Ca.h> {
    public /* synthetic */ g0(kotlin.jvm.internal.i iVar) {
        this();
    }

    public abstract boolean a(ga.e eVar);

    public final <Other extends Ca.i> g0<Other> b(InterfaceC5074l<? super Type, ? extends Other> transform) {
        kotlin.jvm.internal.p.i(transform, "transform");
        if (this instanceof C0813s) {
            C0813s c0813s = (C0813s) this;
            return new C0813s(c0813s.c(), transform.invoke(c0813s.d()));
        }
        if (!(this instanceof C0820z)) {
            throw new NoWhenBranchMatchedException();
        }
        List<Pair<ga.e, Type>> listC = ((C0820z) this).c();
        ArrayList arrayList = new ArrayList(C1174w.x(listC, 10));
        Iterator<T> it = listC.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(Y8.j.a((ga.e) pair.a(), transform.invoke((Ca.h) pair.b())));
        }
        return new C0820z(arrayList);
    }

    public g0() {
    }
}
