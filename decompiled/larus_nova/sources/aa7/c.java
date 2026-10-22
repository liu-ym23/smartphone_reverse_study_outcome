package aa7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public final class c extends a {
    static {
    }

    public c() {
    }

    @Override // aa7.a
    public final List<ca7.c> a(ba7.a r100, ea7.b r101, int r102) {
        ArrayList r103 = new ArrayList();
        ArrayList<ea7.b> r104 = r101.f471627b;
        if (r104 == null) goto L8;
        Iterator<ea7.b> r105 = r104.iterator();
    L6:
        if (r105.hasNext() == false) goto L8;
        r103.add(((com.bytedance.express.command.f) r105.next().f471626a).f243204a);
    L8:
        ArrayList r106 = new ArrayList();
        r106.add(new ca7.d(r103));
        return r106;
    }
}
