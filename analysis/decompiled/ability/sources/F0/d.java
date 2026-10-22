package F0;

import H.h;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.encryptor.EncryptorUtil;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import z2.l;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public String f532a;
    public HashMap b;
    public byte[] c;

    public d(String str, HashMap map, byte[] bArr) {
        this.f532a = str;
        this.b = map;
        this.c = bArr;
    }

    public d a(boolean z10) throws IOException {
        Map map;
        Object obj;
        HashMap map2 = this.b;
        this.f532a = S0.b.p(this.f532a, h.e());
        if (this.c.length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    gZIPOutputStream.write(this.c);
                    gZIPOutputStream.close();
                    this.c = byteArrayOutputStream.toByteArray();
                    map2.put("Content-Encoding", "gzip");
                } catch (IOException e) {
                    throw e;
                }
            } catch (Throwable th) {
                gZIPOutputStream.close();
                throw th;
            }
        }
        String str = "application/json; charset=utf-8";
        if (z10) {
            i0.b bVar = J2.c.f865a.c;
            byte[] bArr = this.c;
            bVar.getClass();
            byte[] bArrA = EncryptorUtil.a(bArr.length, bArr);
            this.c = bArrA;
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(this.f532a).getQuery())) {
                    if (!this.f532a.endsWith("?")) {
                        this.f532a = B7.a.q(new StringBuilder(), this.f532a, "?");
                    }
                } else if (!this.f532a.endsWith("&")) {
                    this.f532a = B7.a.q(new StringBuilder(), this.f532a, "&");
                }
                this.f532a = B7.a.q(new StringBuilder(), this.f532a, "tt_data=a");
                str = "application/octet-stream;tt-data=a";
            }
            LinkedList<Pair> linkedList = new LinkedList();
            if (S0.b.a0(linkedList)) {
                map = Collections.EMPTY_MAP;
            } else {
                HashMap map3 = new HashMap();
                for (Pair pair : linkedList) {
                    if (pair != null && (obj = pair.first) != null) {
                        map3.put((String) obj, (String) pair.second);
                    }
                }
                map = map3;
            }
            map2.putAll(map);
        }
        map2.put("Version-Code", "1");
        map2.put(HttpHeaders.CONTENT_TYPE, str);
        map2.put("Accept-Encoding", "gzip");
        try {
            map2.put("identifier", l.d(h.f711a));
        } catch (Exception unused) {
        }
        String str2 = this.f532a;
        byte[] bArr2 = this.c;
        d dVar = new d();
        dVar.f532a = str2;
        dVar.b = map2;
        dVar.c = bArr2;
        return dVar;
    }

    public d(String str, byte[] bArr) {
        this.f532a = str;
        this.c = bArr;
        this.b = new HashMap();
    }
}
