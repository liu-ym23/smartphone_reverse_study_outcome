package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j extends h implements f<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38541b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final j f38542c = null;

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final j a() {
            return j.j();
        }
    }

    public j(int r2, int r3) {
        super(r2, r3, 1);
    }

    public static final /* synthetic */ j j() {
        return f38542c;
    }

    @Override // d.l.f
    public /* synthetic */ boolean a(Comparable r3) {
        return a(((Number) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin"), Number.class, "com.obric.aiagent.plugin")).intValue());
    }

    @Override // d.l.f
    public /* synthetic */ Comparable g() {
        return (Comparable) ZeusTransformUtils.preCheckCast(f(), Comparable.class, "com.obric.aiagent.plugin");
    }

    @Override // d.l.f
    public /* synthetic */ Comparable h() {
        return (Comparable) ZeusTransformUtils.preCheckCast(i(), Comparable.class, "com.obric.aiagent.plugin");
    }

    public Integer f() {
        return Integer.valueOf(a());
    }

    public Integer i() {
        return Integer.valueOf(b());
    }

    public boolean a(int r2) {
        if (a() <= r2) goto L5;
    L7:
        return false;
    L5:
        if (r2 > b()) goto L7;
        return true;
    }

    @Override // d.l.h, d.l.f
    public boolean d() {
        if (a() <= b()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.l.h
    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L12:
        return true;
    L9:
        if (a() != ((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin")).a()) goto L13;
        if (b() != ((j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin")).b()) goto L13;
        goto L12
    }

    @Override // d.l.h
    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = a() * 31;
        return b() + r0;
    }

    @Override // d.l.h
    public String toString() {
        return a() + DownloadConstants.VULNERABILITY_PATH + b();
    }

    static {
        f38541b = new a(null);
        f38542c = new j(1, 0);
    }
}
