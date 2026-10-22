package z2;

import android.content.Context;
import com.apm.insight.entity.Header;

/* loaded from: classes2.dex */
public final class e extends f {
    public Header c;

    @Override // z2.f
    public final Object b(String str) {
        if (this.c == null) {
            Context context = com.apm.insight.g.f2160a;
            Header headerA = Header.a();
            Header.addRuntimeHeader(headerA.f2158a);
            Header.f(headerA);
            headerA.h();
            headerA.j();
            headerA.k();
            this.c = headerA;
        }
        return this.c.f2158a.opt(str);
    }
}
