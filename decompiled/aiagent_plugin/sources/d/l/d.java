package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes4.dex */
final class d implements e<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double f38529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f38530b;

    public boolean a(double r1, double r3) {
        if (r1 > r3) goto L5;
        return true;
    L5:
        return false;
    }

    public d(double r1, double r3) {
        this.f38529a = r1;
        this.f38530b = r3;
    }

    @Override // d.l.e, d.l.f
    public /* synthetic */ boolean a(Comparable r3) {
        return a(((Number) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin"), Number.class, "com.obric.aiagent.plugin")).doubleValue());
    }

    @Override // d.l.e
    public /* synthetic */ boolean a(Comparable r5, Comparable r6) {
        Comparable r7 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r5, Comparable.class, "com.obric.aiagent.plugin");
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r6, Comparable.class, "com.obric.aiagent.plugin");
        return a(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.aiagent.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).doubleValue());
    }

    @Override // d.l.f
    public /* synthetic */ Comparable g() {
        return (Comparable) ZeusTransformUtils.preCheckCast(a(), Comparable.class, "com.obric.aiagent.plugin");
    }

    @Override // d.l.f
    public /* synthetic */ Comparable h() {
        return (Comparable) ZeusTransformUtils.preCheckCast(b(), Comparable.class, "com.obric.aiagent.plugin");
    }

    public Double a() {
        return Double.valueOf(this.f38529a);
    }

    public Double b() {
        return Double.valueOf(this.f38530b);
    }

    public boolean a(double r3) {
        if (r3 >= this.f38529a) goto L5;
    L7:
        return false;
    L5:
        if (r3 > this.f38530b) goto L7;
        return true;
    }

    @Override // d.l.e, d.l.f
    public boolean d() {
        if (this.f38529a <= this.f38530b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, d.class) == false) goto L20;
        if (d() == false) goto L9;
        if (((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
        return true;
    L9:
        if (this.f38529a != ((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin")).f38529a) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L20;
        if (this.f38530b != ((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.aiagent.plugin")).f38530b) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L20;
        return true;
    L16:
        r9 = false;
        goto L17
    L11:
        r1 = false;
    L20:
        return false;
    }

    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = Double.hashCode(this.f38529a) * 31;
        return Double.hashCode(this.f38530b) + r0;
    }

    public String toString() {
        return this.f38529a + DownloadConstants.VULNERABILITY_PATH + this.f38530b;
    }
}
