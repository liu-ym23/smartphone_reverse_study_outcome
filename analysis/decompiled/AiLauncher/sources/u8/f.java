package u8;

import Zb.d;
import android.content.Context;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import u8.e;
import u8.g;
import u8.l;
import u8.o;
import v8.C5671a;

/* loaded from: classes4.dex */
public class f implements e.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f42466a;

    /* renamed from: b, reason: collision with root package name */
    public final List<i> f42467b = new ArrayList(3);

    /* renamed from: c, reason: collision with root package name */
    public TextView.BufferType f42468c = TextView.BufferType.SPANNABLE;

    /* renamed from: d, reason: collision with root package name */
    public boolean f42469d = true;

    public f(Context context) {
        this.f42466a = context;
    }

    public static List<i> b(List<i> list) {
        return new q(list).f();
    }

    @Override // u8.e.a
    public e.a a(i iVar) {
        this.f42467b.add(iVar);
        return this;
    }

    @Override // u8.e.a
    public e build() {
        if (this.f42467b.isEmpty()) {
            throw new IllegalStateException("No plugins were added to this builder. Use #usePlugin method to add them");
        }
        List<i> listB = b(this.f42467b);
        d.b bVar = new d.b();
        C5671a.C0540a c0540aJ = C5671a.j(this.f42466a);
        g.b bVar2 = new g.b();
        o.a aVar = new o.a();
        l.a aVar2 = new l.a();
        for (i iVar : listB) {
            iVar.h(bVar);
            iVar.k(c0540aJ);
            iVar.f(bVar2);
            iVar.c(aVar);
            iVar.a(aVar2);
        }
        g gVarI = bVar2.i(c0540aJ.A(), aVar2.build());
        return new h(this.f42468c, null, bVar.f(), n.b(aVar, gVarI), gVarI, Collections.unmodifiableList(listB), this.f42469d);
    }
}
