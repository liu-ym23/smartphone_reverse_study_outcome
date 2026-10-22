package T6;

import com.volcengine.tos.TosClientException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public final class a {
    public static a b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap f1210a;

    public static synchronized a a() {
        try {
            a aVar = b;
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            aVar2.f1210a = new HashMap();
            b = aVar2;
            try {
                InputStream resourceAsStream = a.class.getResourceAsStream("/tos.mime.types");
                if (resourceAsStream != null) {
                    try {
                        b.d(resourceAsStream);
                    } finally {
                    }
                }
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return b;
            } catch (IOException e) {
                throw new TosClientException("tos: failed to load mime types from file", e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String b(java.lang.String r3) {
        /*
            r2 = this;
            java.util.HashMap r2 = r2.f1210a
            java.lang.String r0 = "."
            int r0 = r3.lastIndexOf(r0)
            if (r0 <= 0) goto L27
            int r0 = r0 + 1
            int r1 = r3.length()
            if (r0 >= r1) goto L27
            java.lang.String r3 = r3.substring(r0)
            java.lang.String r3 = r3.toLowerCase()
            boolean r0 = r2.containsKey(r3)
            if (r0 == 0) goto L27
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            goto L28
        L27:
            r2 = 0
        L28:
            if (r2 == 0) goto L2b
            return r2
        L2b:
            java.lang.String r2 = "binary/octet-stream"
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: T6.a.b(java.lang.String):java.lang.String");
    }

    public boolean c(String str, Boolean bool) {
        HashMap map = this.f1210a;
        Objects.requireNonNull(str, "keyword cannot be null");
        return ((Boolean) map.getOrDefault(str, bool)).booleanValue();
    }

    public void d(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return;
            }
            String strTrim = line.trim();
            if (strTrim.length() != 0 && !strTrim.startsWith("#")) {
                StringTokenizer stringTokenizer = new StringTokenizer(strTrim, " \t");
                if (stringTokenizer.countTokens() > 1) {
                    this.f1210a.put(stringTokenizer.nextToken(), stringTokenizer.nextToken());
                }
            }
        }
    }
}
