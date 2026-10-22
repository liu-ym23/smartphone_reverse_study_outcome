package h6;

import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class g implements TypedInput, TypedOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f20368b;

    public g(String r10, File r11) {
        if (r10 != null) goto L5;
        r10 = "application/octet-stream";
    L5:
        if (r11 == null) goto L9;
        this.f20367a = r10;
        this.f20368b = r11;
        return;
    L9:
        throw new NullPointerException("file");
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g) == true) goto L8;
        return false;
    L8:
        return this.f20368b.equals(((g) r10).f20368b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String fileName() {
        return this.f20368b.getName();
    }

    public int hashCode() {
        return this.f20368b.hashCode();
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public InputStream in() {
        return new FileInputStream(this.f20368b);
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public long length() {
        return this.f20368b.length();
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public String md5Stub() {
        return null;
    }

    @Override // com.bytedance.retrofit2.mime.TypedInput
    public String mimeType() {
        return this.f20367a;
    }

    public String toString() {
        return this.f20368b.getAbsolutePath() + " (" + mimeType() + ")";
    }

    @Override // com.bytedance.retrofit2.mime.TypedOutput
    public void writeTo(OutputStream r10) {
        byte[] r11 = new byte[4096];
        FileInputStream r12 = new FileInputStream(this.f20368b);
    L13:
        int r13 = r12.read(r11);     // Catch: Throwable -> L7
        if (r13 == (-1)) goto L9;
        r10.write(r11, 0, r13);     // Catch: Throwable -> L7
        goto L13
    L9:
        r12.close();
        return;
    L7:
        th = move-exception;
        r12.close();
        throw th;
    }
}
