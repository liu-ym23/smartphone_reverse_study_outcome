package d.n;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c<T, K> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j<T> f38567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<T, K> f38568b;

    public c(j<? extends T> r3, d.h.a.b<? super T, ? extends K> r4) {
        j<T> r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.a.b<T, K> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r6, "keySelector");
        this.f38567a = r5;
        this.f38568b = r6;
    }

    @Override // d.n.j
    public Iterator<T> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new b(this.f38567a.a(), this.f38568b), Iterator.class, "com.obric.aiagent.plugin");
    }
}
