package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f21191a;

    public w(int r10) {
        this.f21191a = new ArrayList(r10);
    }

    public void a(Object r10) {
        this.f21191a.add(r10);
    }

    public void b(Object r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof Object[]) == false) goto L10;
        Object[] r11 = (Object[]) r10;
        if (r11.length <= 0) goto L24;
        ArrayList r12 = this.f21191a;
        r12.ensureCapacity(r12.size() + r11.length);
        Collections.addAll(this.f21191a, r11);
        return;
    L24:
        return;
    L10:
        if ((r10 instanceof Collection) == false) goto L13;
        this.f21191a.addAll((Collection) r10);
        return;
    L13:
        if ((r10 instanceof Iterable) == false) goto L19;
        Iterator r13 = ((Iterable) r10).iterator();
    L16:
        if (r13.hasNext() == false) goto L31;
        this.f21191a.add(r13.next());
        goto L16
    L31:
        return;
    L19:
        if ((r10 instanceof Iterator) == false) goto L26;
        Iterator r14 = (Iterator) r10;
    L22:
        if (r14.hasNext() == false) goto L32;
        this.f21191a.add(r14.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r10.getClass());
    }

    public int c() {
        return this.f21191a.size();
    }

    public Object[] d(Object[] r10) {
        return this.f21191a.toArray(r10);
    }
}
