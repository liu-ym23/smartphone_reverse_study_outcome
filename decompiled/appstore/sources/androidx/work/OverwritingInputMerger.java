package androidx.work;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class OverwritingInputMerger extends e {
    public OverwritingInputMerger() {
    }

    @Override // androidx.work.e
    public c b(List r10) {
        c.a r11 = new c.a();
        HashMap r12 = new HashMap();
        Iterator r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12.putAll(((c) r13.next()).h());
        goto L4
    L6:
        r11.c(r12);
        return r11.a();
    }
}
