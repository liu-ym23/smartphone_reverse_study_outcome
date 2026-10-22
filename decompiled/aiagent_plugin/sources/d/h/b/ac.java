package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: SpreadBuilder.java */
/* JADX INFO: loaded from: classes4.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f38484a;

    public ac(int r2) {
        this.f38484a = new ArrayList(r2);
    }

    public void a(Object r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof Object[]) == false) goto L10;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast((Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.aiagent.plugin"), Object[].class, "com.obric.aiagent.plugin");
        if (r5.length <= 0) goto L24;
        ArrayList<Object> r0 = this.f38484a;
        r0.ensureCapacity(r0.size() + r5.length);
        Collections.addAll(this.f38484a, r5);
        return;
    L24:
        return;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L13;
        this.f38484a.addAll((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        if (ZeusTransformUtils.instanceOf(r4, Iterable.class) == false) goto L19;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L16:
        if (r6.hasNext() == false) goto L31;
        this.f38484a.add(r6.next());
        goto L16
    L31:
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r4, Iterator.class) == false) goto L26;
        Iterator r7 = (Iterator) ZeusTransformUtils.preCheckCast(r4, Iterator.class, "com.obric.aiagent.plugin");
    L22:
        if (r7.hasNext() == false) goto L32;
        this.f38484a.add(r7.next());
        goto L22
    L32:
        return;
    L26:
        throw new UnsupportedOperationException("Don't know how to spread " + r4.getClass());
    }

    public int a() {
        return this.f38484a.size();
    }

    public void b(Object r1) {
        this.f38484a.add(r1);
    }

    public Object[] a(Object[] r1) {
        return this.f38484a.toArray(r1);
    }
}
