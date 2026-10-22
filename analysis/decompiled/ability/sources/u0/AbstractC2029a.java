package u0;

import B.e;
import android.text.TextUtils;
import com.stepos.agentframework.adapter.bff.BffConstant;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.HTTP;

/* renamed from: u0.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2029a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final String f6685a = "AAA" + System.currentTimeMillis() + "AAA";
    public final String b;
    public final boolean c;
    public DataOutputStream d;
    public GZIPOutputStream e;

    public AbstractC2029a(String str, boolean z10) {
        this.b = str;
        this.c = z10;
    }

    @Override // B.e
    public final void a(String str, String str2) throws IOException {
        StringBuilder sb = new StringBuilder(100);
        sb.append("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6685a, "\r\nContent-Disposition: form-data; name=\"", str, "\"\r\nContent-Type: text/plain; charset=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.b, "\r\n\r\n", str2, HTTP.CRLF);
        try {
            if (this.c) {
                this.e.write(sb.toString().getBytes());
            } else {
                this.d.write(sb.toString().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // B.e
    public final void b(String str, File file, String str2, String str3, HashMap map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder(100);
        sb.append("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6685a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(name);
        sb.append("\"");
        for (Map.Entry entry : map.entrySet()) {
            sb.append("; ");
            sb.append((String) entry.getKey());
            sb.append("=\"");
            sb.append((String) entry.getValue());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(str2)) {
            androidx.compose.foundation.b.C(sb, "\r\nContent-Type: ", str2, HTTP.CRLF);
        }
        if (!TextUtils.isEmpty(str3)) {
            androidx.compose.foundation.b.C(sb, "\r\nContent-Transfer-Encoding: ", str3, HTTP.CRLF);
        }
        sb.append(HTTP.CRLF);
        boolean z10 = this.c;
        if (z10) {
            this.e.write(sb.toString().getBytes());
        } else {
            this.d.write(sb.toString().getBytes());
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                break;
            } else if (z10) {
                this.e.write(bArr, 0, i);
            } else {
                this.d.write(bArr, 0, i);
            }
        }
        fileInputStream.close();
        if (z10) {
            this.e.write(HTTP.CRLF.getBytes());
        } else {
            this.d.write(HTTP.CRLF.getBytes());
            this.d.flush();
        }
    }

    @Override // B.e
    public final void c(String str, HashMap map, String str2, String str3) throws IOException {
        StringBuilder sb = new StringBuilder(100);
        sb.append("--");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f6685a, "\r\nContent-Disposition: form-data; name=\"", str, "\"; filename=\"");
        sb.append(str2);
        sb.append("\"");
        for (Map.Entry entry : map.entrySet()) {
            sb.append("; ");
            sb.append((String) entry.getKey());
            sb.append("=\"");
            sb.append((String) entry.getValue());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty("text/plain")) {
            sb.append("\r\nContent-Type: text/plain\r\n");
        }
        sb.append(HTTP.CRLF);
        boolean z10 = this.c;
        if (z10) {
            this.e.write(sb.toString().getBytes());
        } else {
            this.d.write(sb.toString().getBytes());
        }
        if (str3 == null) {
            str3 = "";
        }
        if (z10) {
            this.e.write(str3.getBytes());
        } else {
            this.d.write(str3.getBytes());
        }
        if (z10) {
            this.e.write(HTTP.CRLF.getBytes());
        } else {
            this.d.write(HTTP.CRLF.getBytes());
            this.d.flush();
        }
    }

    @Override // B.e
    public final void d(HashMap map, File file) throws IOException {
        b(BffConstant.Type.File, file, "text/plain", null, map);
    }

    @Override // B.e
    public B.b a() throws IOException {
        byte[] bytes = ("\r\n--" + this.f6685a + "--\r\n").getBytes();
        if (this.c) {
            this.e.write(bytes);
            this.e.finish();
            this.e.close();
            return null;
        }
        this.d.write(bytes);
        this.d.flush();
        this.d.close();
        return null;
    }
}
