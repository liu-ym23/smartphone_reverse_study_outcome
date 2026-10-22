package u0;

import H.h;
import android.text.TextUtils;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public final class c extends AbstractC2029a {
    public final ByteArrayOutputStream f;
    public final String g;
    public final HashMap h;

    public c(String str, String str2, Map map, boolean z10) {
        super(str2, z10);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        this.f = byteArrayOutputStream;
        HashMap map2 = new HashMap();
        this.h = map2;
        this.g = str;
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        map2.put(HttpHeaders.CONTENT_TYPE, "multipart/form-data; boundary=" + this.f6685a);
        if (!TextUtils.isEmpty(h.f718w)) {
            map2.put("aid", h.a());
            map2.put("x-auth-token", h.f718w);
        }
        if (!z10) {
            this.d = new DataOutputStream(byteArrayOutputStream);
        } else {
            this.e = new GZIPOutputStream(byteArrayOutputStream);
            map2.put("Content-Encoding", "gzip");
        }
    }

    @Override // u0.AbstractC2029a, B.e
    public final B.b a() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = this.f;
        super.a();
        try {
            B.b bVarDoPost = h.g.doPost(this.g, byteArrayOutputStream.toByteArray(), this.h);
            try {
                byteArrayOutputStream.close();
            } catch (Throwable unused) {
            }
            return bVarDoPost;
        } catch (Exception unused2) {
            if (byteArrayOutputStream == null) {
                return null;
            }
            try {
                byteArrayOutputStream.close();
                return null;
            } catch (Throwable unused3) {
                return null;
            }
        } catch (Throwable th) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }
}
