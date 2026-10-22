package d.l;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PrimitiveRanges.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends d.l.a implements f<Character> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f38528c = null;

    /* JADX INFO: compiled from: PrimitiveRanges.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    public c(char r2, char r3) {
        super(r2, r3, 1);
    }

    @Override // d.l.f
    public /* synthetic */ boolean a(Comparable r3) {
        return a(((Character) ZeusTransformUtils.preCheckCast((Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin"), Character.class, "com.obric.aiagent.plugin")).charValue());
    }

    @Override // d.l.f
    public /* synthetic */ Comparable g() {
        return (Comparable) ZeusTransformUtils.preCheckCast(e(), Comparable.class, "com.obric.aiagent.plugin");
    }

    @Override // d.l.f
    public /* synthetic */ Comparable h() {
        return (Comparable) ZeusTransformUtils.preCheckCast(f(), Comparable.class, "com.obric.aiagent.plugin");
    }

    public Character e() {
        return Character.valueOf(a());
    }

    public Character f() {
        return Character.valueOf(b());
    }

    public boolean a(char r2) {
        if (d.h.b.o.a(a(), r2) <= 0) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(r2, b()) > 0) goto L7;
        return true;
    }

    @Override // d.l.a, d.l.f
    public boolean d() {
        if (d.h.b.o.a(a(), b()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // d.l.a
    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L5;
    L13:
        return false;
    L5:
        if (d() == false) goto L9;
        if (((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).d() == false) goto L9;
    L12:
        return true;
    L9:
        if (a() != ((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).a()) goto L13;
        if (b() != ((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).b()) goto L13;
        goto L12
    }

    @Override // d.l.a
    public int hashCode() {
        if (d() == false) goto L5;
        return -1;
    L5:
        int r0 = a() * 31;
        return b() + r0;
    }

    @Override // d.l.a
    public String toString() {
        return a() + DownloadConstants.VULNERABILITY_PATH + b();
    }

    static {
        f38527b = new a(null);
        f38528c = new c(1, 0);
    }
}
