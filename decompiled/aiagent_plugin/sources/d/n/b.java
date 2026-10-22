package d.n;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
final class b<T, K> extends d.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator<T> f38564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<T, K> f38565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet<K> f38566c;

    public b(Iterator<? extends T> r3, d.h.a.b<? super T, ? extends K> r4) {
        Iterator<T> r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, K> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r6, "keySelector");
        this.f38564a = r5;
        this.f38565b = r6;
        this.f38566c = new HashSet();
    }

    @Override // d.a.b
    public void a() {
    L3:
        if (this.f38564a.hasNext() == false) goto L8;
        T r0 = this.f38564a.next();
        K r1 = this.f38565b.invoke(r0);
        if (this.f38566c.add(r1) == false) goto L3;
        a(r0);
        return;
    L8:
        b();
    }
}
