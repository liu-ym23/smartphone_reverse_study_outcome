package w2;

import com.bytedance.applog.encryptor.EncryptorUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.HTTP;
import s2.C1912a;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f6831a = "AAA" + System.currentTimeMillis() + "AAA";
    public final boolean b;
    public j c;
    public p d;

    public b(boolean z10) {
        this.b = z10;
    }

    public String a() throws IOException {
        byte[] bytes = ("\r\n--" + this.f6831a + "--\r\n").getBytes();
        if (this.b) {
            this.d.write(bytes);
            this.d.c();
            this.d.b();
            return "";
        }
        this.c.write(bytes);
        this.c.flush();
        this.c.b();
        return "";
    }

    public final void b(String str, File file, HashMap map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6831a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        for (Map.Entry entry : map.entrySet()) {
            sb.append("; ");
            sb.append((String) entry.getKey());
            sb.append("=\"");
            sb.append((String) entry.getValue());
            sb.append("\"");
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        boolean z10 = this.b;
        if (z10) {
            this.d.write(sb.toString().getBytes());
        } else {
            this.c.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            } else {
                (z10 ? this.d : this.c).write(bArr, 0, i);
            }
        }
        fileInputStream.close();
        if (z10) {
            this.d.write(HTTP.CRLF.getBytes());
        } else {
            this.c.write(HTTP.CRLF.getBytes());
            this.c.flush();
        }
    }

    public final void c(String str, String str2, boolean z10) throws IOException {
        StringBuilder sb = new StringBuilder("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6831a, "\r\nContent-Disposition: form-data; name=\"", str, "\"\r\nContent-Type: text/plain; charset=UTF-8\r\n\r\n");
        boolean z11 = this.b;
        try {
            if (z11) {
                this.d.write(sb.toString().getBytes());
            } else {
                this.c.write(sb.toString().getBytes());
            }
        } catch (IOException unused) {
        }
        byte[] bytes = str2.getBytes();
        if (z10) {
            ((C1912a) com.apm.insight.g.g.getEncryptImpl()).getClass();
            bytes = EncryptorUtil.a(bytes.length, bytes);
        }
        try {
            if (z11) {
                this.d.write(bytes);
                this.d.write(HTTP.CRLF.getBytes());
            } else {
                this.c.write(bytes);
                this.c.write(HTTP.CRLF.getBytes());
            }
        } catch (IOException unused2) {
        }
    }

    public final void d(String str, HashMap map, File... fileArr) throws Throwable {
        StringBuilder sb = new StringBuilder("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6831a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(str);
        sb.append("\"");
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                sb.append("; ");
                sb.append((String) entry.getKey());
                sb.append("=\"");
                sb.append((String) entry.getValue());
                sb.append("\"");
            }
        }
        sb.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        boolean z10 = this.b;
        if (z10) {
            this.d.write(sb.toString().getBytes());
        } else {
            this.c.write(sb.toString().getBytes());
        }
        M.a.r(z10 ? this.d : this.c, fileArr);
        if (z10) {
            this.d.write(HTTP.CRLF.getBytes());
        } else {
            this.c.write(HTTP.CRLF.getBytes());
            this.c.flush();
        }
    }

    public final void e(F.g... gVarArr) throws Throwable {
        StringBuilder sb = new StringBuilder("--");
        androidx.compose.foundation.b.C(sb, this.f6831a, "\r\nContent-Disposition: form-data; name=\"file\"; filename=\"file\"", "\r\nContent-Transfer-Encoding: binary\r\n\r\n");
        boolean z10 = this.b;
        if (z10) {
            this.d.write(sb.toString().getBytes());
        } else {
            this.c.write(sb.toString().getBytes());
        }
        M.a.q(z10 ? this.d : this.c, gVarArr);
        if (z10) {
            this.d.write(HTTP.CRLF.getBytes());
        } else {
            this.c.write(HTTP.CRLF.getBytes());
            this.c.flush();
        }
    }
}
