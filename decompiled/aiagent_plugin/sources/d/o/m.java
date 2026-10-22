package d.o;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f38652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f38653b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f38654c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f38655d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f38656e = null;
    public static final m f = null;
    public static final m g = null;
    private static final /* synthetic */ m[] j = null;
    private static final /* synthetic */ d.d.a k = null;
    private final int h;
    private final int i;

    private static final /* synthetic */ m[] b() {
        return new m[]{f38652a, f38653b, f38654c, f38655d, f38656e, f, g};
    }

    public static m valueOf(String r2) {
        return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.aiagent.plugin");
    }

    public static m[] values() {
        return (m[]) ZeusTransformUtils.preCheckCast(j.clone(), m[].class, "com.obric.aiagent.plugin");
    }

    private m(String r1, int r2, int r3, int r4) {
        super(r1, r2);
        this.h = r3;
        this.i = r4;
    }

    /* synthetic */ m(String r1, int r2, int r3, int r4, int r5, d.h.b.h r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = r3;
    L5:
        this(r1, r2, r3, r4);
    }

    public int a() {
        return this.h;
    }

    static {
        int r3 = 2;
        f38652a = new m("IGNORE_CASE", 0, r3, 0, 2, null);
        int r12 = 0;
        int r13 = 2;
        d.h.b.h r14 = null;
        f38653b = new m("MULTILINE", 1, 8, r12, r13, r14);
        int r5 = 0;
        int r6 = 2;
        d.h.b.h r7 = null;
        f38654c = new m("LITERAL", r3, 16, r5, r6, r7);
        f38655d = new m("UNIX_LINES", 3, 1, r12, r13, r14);
        f38656e = new m("COMMENTS", 4, 4, r5, r6, r7);
        f = new m("DOT_MATCHES_ALL", 5, 32, r12, r13, r14);
        g = new m("CANON_EQ", 6, 128, r5, r6, r7);
        m[] r0 = b();
        j = r0;
        k = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }
}
