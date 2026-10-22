package okhttp3;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes4.dex */
public final enum aa extends Enum<aa> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39693a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final aa f39694b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final aa f39695c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aa f39696d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final aa f39697e = null;
    public static final aa f = null;
    public static final aa g = null;
    private static final /* synthetic */ aa[] i = null;
    private final String h;

    /* JADX INFO: compiled from: Protocol.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final aa a(String r3) {
            d.h.b.o.e(r3, MonitorConstants.PROTOCOL);
            if (d.h.b.o.a(r3, aa.a(aa.f39694b)) == false) goto L6;
            return aa.f39694b;
        L6:
            if (d.h.b.o.a(r3, aa.a(aa.f39695c)) == false) goto L9;
            return aa.f39695c;
        L9:
            if (d.h.b.o.a(r3, aa.a(aa.f)) == false) goto L12;
            return aa.f;
        L12:
            if (d.h.b.o.a(r3, aa.a(aa.f39697e)) == false) goto L15;
            return aa.f39697e;
        L15:
            if (d.h.b.o.a(r3, aa.a(aa.f39696d)) == false) goto L18;
            return aa.f39696d;
        L18:
            if (d.h.b.o.a(r3, aa.a(aa.g)) == false) goto L22;
            return aa.g;
        L22:
            throw new IOException("Unexpected protocol: " + r3);
        }
    }

    private static final /* synthetic */ aa[] a() {
        return new aa[]{f39694b, f39695c, f39696d, f39697e, f, g};
    }

    public static aa valueOf(String r2) {
        return (aa) ZeusTransformUtils.preCheckCast(Enum.valueOf(aa.class, r2), aa.class, "com.obric.aiagent.plugin");
    }

    public static aa[] values() {
        return (aa[]) ZeusTransformUtils.preCheckCast(i.clone(), aa[].class, "com.obric.aiagent.plugin");
    }

    private aa(String r1, int r2, String r3) {
        super(r1, r2);
        this.h = r3;
    }

    public static final /* synthetic */ String a(aa r0) {
        return r0.h;
    }

    static {
        f39694b = new aa("HTTP_1_0", 0, "http/1.0");
        f39695c = new aa("HTTP_1_1", 1, "http/1.1");
        f39696d = new aa("SPDY_3", 2, "spdy/3.1");
        f39697e = new aa("HTTP_2", 3, "h2");
        f = new aa("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        g = new aa("QUIC", 5, "quic");
        i = a();
        f39693a = new a(null);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.h;
    }
}
