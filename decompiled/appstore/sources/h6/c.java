package h6;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f20350a;

    public c() {
        this.f20350a = new ByteArrayOutputStream();
    }

    @Override // h6.a
    public boolean a() {
        byte[] r10 = this.f20350a.toByteArray();
        if (r10 != null) goto L5;
    L12:
        return false;
    L5:
        if (r10.length > 102400) goto L12;
        byte[] r11 = EncryptorUtil.a(r10, r10.length);
        if (r11 != null) goto L10;
        return false;
    L10:
        ByteArrayOutputStream r12 = new ByteArrayOutputStream(r11.length);
        this.f20350a = r12;
        r12.write(r11, 0, r11.length);
        return true;
    }

    public void b(String r10, String r11) {
        c(r10, true, r11, true);
    }

    public void c(String r10, boolean r11, String r12, boolean r13) {
        if (r10 == null) goto L21;
        if (r12 == null) goto L19;
        if (this.f20350a.size() <= 0) goto L8;
        this.f20350a.write(38);
    L8:
        if (r11 == true) goto L22;
    L12:
        if (r13 == false) goto L14;
        r12 = URLEncoder.encode(r12, "UTF-8");     // Catch: IOException -> L10
    L14:
        this.f20350a.write(r10.getBytes("UTF-8"));     // Catch: IOException -> L10
        this.f20350a.write(61);     // Catch: IOException -> L10
        this.f20350a.write(r12.getBytes("UTF-8"));     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        throw new RuntimeException(e);
    L22:
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: IOException -> L10
        goto L12
    L19:
        throw new NullPointerException(CommonKey.KEY_VALUE);
    L21:
        throw new NullPointerException("name");
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f20350a.size();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return b.c(this.f20350a.toByteArray());
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        r10.write(this.f20350a.toByteArray());
    }
}
