package h6;

import android.text.TextUtils;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class f extends a implements TypedInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f20365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20366c;

    public f(String r10, byte[] r11, String... r12) {
        if (r12 != null) goto L5;
    L7:
        String r13 = null;
    L8:
        if (r10 == null) goto L10;
    L13:
        if (r11 == null) goto L17;
        this.f20364a = r10;
        this.f20365b = r11;
        this.f20366c = r13;
        return;
    L17:
        throw new NullPointerException(DownloadInfoColumns.COLUMN_BYTES);
    L10:
        if (TextUtils.isEmpty(r13) == false) goto L12;
        r10 = "application/unknown";
        goto L13
    L12:
        r10 = "application/octet-stream";
        goto L13
    L5:
        if (r12.length <= 0) goto L7;
        r13 = r12[0];
        goto L8
    }

    @Override // h6.a
    public boolean a() {
        byte[] r10 = this.f20365b;
        if (r10 != null) goto L5;
    L12:
        return false;
    L5:
        if (r10.length > 102400) goto L12;
        byte[] r11 = EncryptorUtil.a(r10, r10.length);
        if (r11 != null) goto L10;
        return false;
    L10:
        this.f20365b = r11;
        return true;
    }

    public byte[] b() {
        return this.f20365b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L17;
        f r11 = (f) r10;
        if (Arrays.equals(this.f20365b, r11.f20365b) == true) goto L14;
        return false;
    L14:
        if (this.f20364a.equals(r11.f20364a) == true) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        if (TextUtils.isEmpty(this.f20366c) == false) goto L7;
        return null;
    L7:
        return this.f20366c;
    }

    public int hashCode() {
        return (this.f20364a.hashCode() * 31) + Arrays.hashCode(this.f20365b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() {
        return new ByteArrayInputStream(this.f20365b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public long length() {
        return this.f20365b.length;
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        byte[] r10 = this.f20365b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return b.c(r10);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String mimeType() {
        return this.f20364a;
    }

    public String toString() {
        return "TypedByteArray[length=" + length() + "]";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        r10.write(this.f20365b);
    }
}
