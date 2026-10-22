package w2;

import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o extends b {
    public final ByteArrayOutputStream e;
    public final String f;
    public final HashMap g;

    public o(Map map, String str, boolean z10) {
        super(z10);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        this.e = byteArrayOutputStream;
        HashMap map2 = new HashMap();
        this.g = map2;
        this.f = str;
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        map2.put(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f6831a);
        if (!z10) {
            this.c = new j(byteArrayOutputStream);
        } else {
            this.d = new p(byteArrayOutputStream);
            map2.put("Content-Encoding", "gzip");
        }
    }

    @Override // w2.b
    public final String a() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.e;
        super.a();
        try {
            if (com.apm.insight.g.p == null) {
                com.apm.insight.g.p = new k();
            }
            String str = new String(com.apm.insight.g.p.c(this.f, byteArrayOutputStream.toByteArray(), this.g).b);
            M0.i.i(byteArrayOutputStream);
            return str;
        } catch (Throwable unused) {
            M0.i.i(byteArrayOutputStream);
            return "error";
        }
    }
}
