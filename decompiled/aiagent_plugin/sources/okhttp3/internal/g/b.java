package okhttp3.internal.g;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ErrorCode.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f39964b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f39965c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f39966d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f39967e = null;
    public static final b f = null;
    public static final b g = null;
    public static final b h = null;
    public static final b i = null;
    public static final b j = null;
    public static final b k = null;
    public static final b l = null;
    public static final b m = null;
    public static final b n = null;
    public static final b o = null;
    private static final /* synthetic */ b[] q = null;
    private final int p;

    /* JADX INFO: compiled from: ErrorCode.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final b a(int r6) {
            b[] r5 = b.values();
            int r0 = r5.length;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            b r3 = r5[r2];
            if (r3.a() != r6) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L15;
            r2 = r2 + 1;
            goto L3
        L15:
            return r3;
        L7:
            r4 = false;
            goto L8
        L11:
            return null;
        }
    }

    private static final /* synthetic */ b[] b() {
        return new b[]{f39964b, f39965c, f39966d, f39967e, f, g, h, i, j, k, l, m, n, o};
    }

    public static b valueOf(String r2) {
        return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
    }

    public static b[] values() {
        return (b[]) ZeusTransformUtils.preCheckCast(q.clone(), b[].class, "com.obric.aiagent.plugin");
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
        this.p = r3;
    }

    public final int a() {
        return this.p;
    }

    static {
        f39964b = new b("NO_ERROR", 0, 0);
        f39965c = new b("PROTOCOL_ERROR", 1, 1);
        f39966d = new b("INTERNAL_ERROR", 2, 2);
        f39967e = new b("FLOW_CONTROL_ERROR", 3, 3);
        f = new b("SETTINGS_TIMEOUT", 4, 4);
        g = new b("STREAM_CLOSED", 5, 5);
        h = new b("FRAME_SIZE_ERROR", 6, 6);
        i = new b("REFUSED_STREAM", 7, 7);
        j = new b("CANCEL", 8, 8);
        k = new b("COMPRESSION_ERROR", 9, 9);
        l = new b("CONNECT_ERROR", 10, 10);
        m = new b("ENHANCE_YOUR_CALM", 11, 11);
        n = new b("INADEQUATE_SECURITY", 12, 12);
        o = new b("HTTP_1_1_REQUIRED", 13, 13);
        q = b();
        f39963a = new a(null);
    }
}
