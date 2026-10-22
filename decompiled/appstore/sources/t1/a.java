package t1;

import android.text.TextUtils;
import com.bytedance.apm.util.k;
import com.bytedance.services.apm.api.IMultipartUploader;
import i6.c;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a implements IMultipartUploader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HttpURLConnection f24702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f24704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map f24705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DataOutputStream f24706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GZIPOutputStream f24707g;

    public a(String r10, String r11, boolean r12, Map r13) {
        this.f24703c = r11;
        this.f24704d = r12;
        this.f24705e = r13;
        String r14 = "AAA" + System.currentTimeMillis() + "AAA";
        this.f24701a = r14;
        HttpURLConnection r15 = k.a(r10);
        this.f24702b = r15;
        r15.setUseCaches(false);
        this.f24702b.setDoOutput(true);
        this.f24702b.setDoInput(true);
        this.f24702b.setRequestMethod("POST");
        this.f24702b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + r14);
        if (r13 == null) goto L8;
        Iterator r16 = r13.entrySet().iterator();
    L6:
        if (r16.hasNext() == false) goto L8;
        Map.Entry r17 = (Map.Entry) r16.next();
        this.f24702b.setRequestProperty((String) r17.getKey(), (String) r17.getValue());
    L8:
        this.f24702b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f24701a);
        if (r12 == false) goto L11;
        this.f24702b.setRequestProperty("Content-Encoding", "gzip");
        this.f24707g = new GZIPOutputStream(this.f24702b.getOutputStream());
        return;
    L11:
        this.f24706f = new DataOutputStream(this.f24702b.getOutputStream());
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r10, File r11, String r12, Map r13) {
        String r14 = r11.getName();
        StringBuilder r15 = new StringBuilder(100);
        r15.append("--");
        r15.append(this.f24701a);
        r15.append("\r\n");
        r15.append("Content-Disposition: form-data; name=\"");
        r15.append(r10);
        r15.append("\"; filename=\"");
        r15.append(r14);
        r15.append("\"");
        Iterator r16 = r13.entrySet().iterator();
    L4:
        if (r16.hasNext() == false) goto L7;
        Map.Entry r17 = (Map.Entry) r16.next();
        r15.append("; ");
        r15.append((String) r17.getKey());
        r15.append("=\"");
        r15.append((String) r17.getValue());
        r15.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r15.append("\r\n");
        r15.append("Content-Type: ");
        r15.append(r12);
        r15.append("\r\n");
    L9:
        r15.append("\r\n");
        r15.append("Content-Transfer-Encoding: binary");
        r15.append("\r\n");
        r15.append("\r\n");
        if (this.f24704d == false) goto L12;
        this.f24707g.write(r15.toString().getBytes());
    L13:
        FileInputStream r18 = new FileInputStream(r11);
        byte[] r19 = new byte[8192];
    L14:
        int r20 = r18.read(r19);
        if (r20 == (-1)) goto L20;
        if (this.f24704d == true) goto L18;
        this.f24706f.write(r19, 0, r20);
        goto L14
    L18:
        this.f24707g.write(r19, 0, r20);
        goto L14
    L20:
        r18.close();
        if (this.f24704d == false) goto L23;
        this.f24707g.write("\r\n".getBytes());
        return;
    L23:
        this.f24706f.write("\r\n".getBytes());
        this.f24706f.flush();
        return;
    L12:
        this.f24706f.write(r15.toString().getBytes());
        goto L13
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFormField(String r10, String r11) {
        StringBuilder r12 = new StringBuilder(100);
        r12.append("--");
        r12.append(this.f24701a);
        r12.append("\r\n");
        r12.append("Content-Disposition: form-data; name=\"");
        r12.append(r10);
        r12.append("\"");
        r12.append("\r\n");
        r12.append("Content-Type: text/plain; charset=");
        r12.append(this.f24703c);
        r12.append("\r\n");
        r12.append("\r\n");
        r12.append(r11);
        r12.append("\r\n");
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f24704d == false) goto L8;
        this.f24707g.write(r12.toString().getBytes());     // Catch: IOException -> L6
    L12:
        return;
    L8:
        this.f24706f.write(r12.toString().getBytes());     // Catch: IOException -> L6
        goto L12
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public c finish() {
        ArrayList r10 = new ArrayList();
        byte[] r11 = ("\r\n--" + this.f24701a + "--\r\n").getBytes();
        if (this.f24704d == false) goto L5;
        this.f24707g.write(r11);
        this.f24707g.finish();
        this.f24707g.close();
    L6:
        int r12 = this.f24702b.getResponseCode();
        if (r12 != 200) goto L19;
        BufferedReader r13 = new BufferedReader(new InputStreamReader(this.f24702b.getInputStream()));
    L9:
        String r14 = r13.readLine();
        if (r14 == null) goto L12;
        r10.add(r14);
        goto L9
    L12:
        r13.close();
        this.f24702b.disconnect();
        StringBuilder r15 = new StringBuilder();
        Iterator r16 = r10.iterator();
    L14:
        if (r16.hasNext() == false) goto L17;
        r15.append((String) r16.next());
        goto L14
    L17:
        return new c(r12, r15.toString().getBytes());
    L19:
        throw new IOException("Server returned non-OK status: " + r12);
    L5:
        this.f24706f.write(r11);
        this.f24706f.flush();
        this.f24706f.close();
        goto L6
    }

    @Override // com.bytedance.services.apm.api.IMultipartUploader
    public void addFilePart(String r10, String r11, String r12, Map r13) {
        StringBuilder r14 = new StringBuilder(100);
        r14.append("--");
        r14.append(this.f24701a);
        r14.append("\r\n");
        r14.append("Content-Disposition: form-data; name=\"");
        r14.append(r10);
        r14.append("\"; filename=\"");
        r14.append(r10);
        r14.append("\"");
        Iterator r15 = r13.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L7;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.append("; ");
        r14.append((String) r16.getKey());
        r14.append("=\"");
        r14.append((String) r16.getValue());
        r14.append("\"");
        goto L4
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        r14.append("\r\n");
        r14.append("Content-Type: ");
        r14.append(r12);
        r14.append("\r\n");
    L9:
        r14.append("\r\n");
        if (this.f24704d == false) goto L12;
        this.f24707g.write(r14.toString().getBytes());
    L13:
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        if (this.f24704d == false) goto L18;
        this.f24707g.write(r11.getBytes());
    L20:
        if (this.f24704d == false) goto L22;
        this.f24707g.write("\r\n".getBytes());
        return;
    L22:
        this.f24706f.write("\r\n".getBytes());
        this.f24706f.flush();
        return;
    L18:
        this.f24706f.write(r11.getBytes());
        goto L20
    L12:
        this.f24706f.write(r14.toString().getBytes());
        goto L13
    }
}
