package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.Comparable;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes4.dex */
class g<T extends Comparable<? super T>> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f38531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f38532b;

    public g(T r3, T r4) {
        T r5 = (T) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r4, Comparable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "start");
        d.h.b.o.e(r6, "endInclusive");
        this.f38531a = r5;
        this.f38532b = r6;
    }

    @Override // d.l.f
    public boolean a(T r3) {
        return f.a.a(this, (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.l.f
    public boolean d() {
        return f.a.a(this);
    }

    @Override // d.l.f
    public T g() {
        return this.f38531a;
    }

    @Override // d.l.f
    public T h() {
        return this.f38532b;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L12:
        return true;
    L9:
        if (d.h.b.o.a(g(), ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).g()) == false) goto L13;
        if (d.h.b.o.a(h(), ((g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin")).h()) == false) goto L13;
        goto L12
    }

    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = g().hashCode() * 31;
        return h().hashCode() + r0;
    }

    public String toString() {
        return g() + DownloadConstants.VULNERABILITY_PATH + h();
    }
}
