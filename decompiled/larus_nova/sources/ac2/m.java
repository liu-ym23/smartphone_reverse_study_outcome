package ac2;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes9.dex */
public final class m extends p<Iterable<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2587a;

    public m(p r100) {
        this.f2587a = r100;
    }

    @Override // ac2.p
    public final void a(w r100, Iterable<Object> r101) throws IOException {
        Iterable<Object> r102 = r101;
        if (r102 == null) goto L9;
        Iterator<Object> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        this.f2587a.a(r100, r104);
        goto L7
    L11:
        return;
    }
}
