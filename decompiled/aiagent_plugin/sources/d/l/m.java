package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class m extends k implements f<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38551b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final m f38552c = null;

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public m(long r8, long r10) {
        super(r8, r10, 1);
    }

    @Override // d.l.f
    public /* synthetic */ boolean a(Comparable r3) {
        return a(((Number) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin"), Number.class, "com.obric.aiagent.plugin")).longValue());
    }

    @Override // d.l.f
    public /* synthetic */ Comparable g() {
        return (Comparable) ZeusTransformUtils.preCheckCast(e(), Comparable.class, "com.obric.aiagent.plugin");
    }

    @Override // d.l.f
    public /* synthetic */ Comparable h() {
        return (Comparable) ZeusTransformUtils.preCheckCast(f(), Comparable.class, "com.obric.aiagent.plugin");
    }

    public Long e() {
        return Long.valueOf(a());
    }

    public Long f() {
        return Long.valueOf(b());
    }

    public boolean a(long r3) {
        if (a() <= r3) goto L5;
    L7:
        return false;
    L5:
        if (r3 > b()) goto L7;
        return true;
    }

    @Override // d.l.k, d.l.f
    public boolean d() {
        if (a() <= b()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.l.k
    public boolean equals(Object r8) {
        if (ZeusTransformUtils.instanceOf(r8, m.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L12:
        return true;
    L9:
        if (a() != ((m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin")).a()) goto L13;
        if (b() != ((m) ZeusTransformUtils.preCheckCast(r8, m.class, "com.obric.aiagent.plugin")).b()) goto L13;
        goto L12
    }

    @Override // d.l.k
    public int hashCode() {
        if (d() == false) goto L6;
        return -1;
    L6:
        return (int) ((((long) 31) * (a() ^ (a() >>> 32))) + (b() ^ (b() >>> 32)));
    }

    @Override // d.l.k
    public String toString() {
        return a() + DownloadConstants.VULNERABILITY_PATH + b();
    }

    static {
        f38551b = new a(null);
        f38552c = new m(1, 0);
    }
}
