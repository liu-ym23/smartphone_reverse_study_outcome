package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: FontRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<List<byte[]>> f1302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f1303e;
    private final String f;

    public c(String r4, String r5, String r6, List<List<byte[]>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        this.f1299a = (String) ZeusTransformUtils.preCheckCast(g.a(r4), String.class, "com.obric.aiagent.plugin");
        this.f1300b = (String) ZeusTransformUtils.preCheckCast(g.a(r5), String.class, "com.obric.aiagent.plugin");
        this.f1301c = (String) ZeusTransformUtils.preCheckCast(g.a(r6), String.class, "com.obric.aiagent.plugin");
        this.f1302d = (List) ZeusTransformUtils.preCheckCast(g.a(r8), List.class, "com.obric.aiagent.plugin");
        this.f1303e = 0;
        this.f = a(r4, r5, r6);
    }

    private String a(String r1, String r2, String r3) {
        return r1 + "-" + r2 + "-" + r3;
    }

    public String a() {
        return this.f1299a;
    }

    public String b() {
        return this.f1300b;
    }

    public String c() {
        return this.f1301c;
    }

    public List<List<byte[]>> d() {
        return this.f1302d;
    }

    public int e() {
        return this.f1303e;
    }

    @Deprecated
    public String getIdentifier() {
        return this.f;
    }

    String f() {
        return this.f;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FontRequest {mProviderAuthority: " + this.f1299a + ", mProviderPackage: " + this.f1300b + ", mQuery: " + this.f1301c + ", mCertificates:");
        int r2 = 0;
    L4:
        if (r2 >= this.f1302d.size()) goto L10;
        r0.append(" [");
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.f1302d.get(r2), List.class, "com.obric.aiagent.plugin");
        int r4 = 0;
    L7:
        if (r4 >= r3.size()) goto L9;
        r0.append(" \"");
        r0.append(Base64.encodeToString((byte[]) ZeusTransformUtils.preCheckCast(r3.get(r4), byte[].class, "com.obric.aiagent.plugin"), 0));
        r0.append("\"");
        r4 = r4 + 1;
        goto L7
    L9:
        r0.append(" ]");
        r2 = r2 + 1;
        goto L4
    L10:
        r0.append("}");
        r0.append("mCertificatesArray: " + this.f1303e);
        return r0.toString();
    }
}
