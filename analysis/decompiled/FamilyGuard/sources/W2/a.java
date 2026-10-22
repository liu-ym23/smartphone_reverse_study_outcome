package W2;

import androidx.recyclerview.widget.RecyclerView;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: q, reason: collision with root package name */
    private static final byte[] f5727q = b.a("; filename=");

    /* renamed from: o, reason: collision with root package name */
    private byte[] f5728o;

    /* renamed from: p, reason: collision with root package name */
    private String f5729p;

    public a(String str, String str2, byte[] bArr, String str3, String str4) {
        super(str, str3 == null ? "application/octet-stream" : str3, str4 == null ? "ISO-8859-1" : str4, "binary");
        if (bArr == null) {
            throw new IllegalArgumentException("Source may not be null");
        }
        this.f5729p = str2;
        this.f5728o = bArr;
    }

    @Override // W2.c
    protected void g(OutputStream outputStream) throws IOException {
        if (p() == 0) {
            return;
        }
        byte[] bArr = new byte[RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.f5728o);
        while (true) {
            try {
                int i5 = byteArrayInputStream.read(bArr);
                if (i5 < 0) {
                    return;
                } else {
                    outputStream.write(bArr, 0, i5);
                }
            } finally {
                byteArrayInputStream.close();
            }
        }
    }

    @Override // W2.c
    protected void i(OutputStream outputStream) throws IOException {
        super.i(outputStream);
        if (this.f5729p != null) {
            outputStream.write(f5727q);
            byte[] bArr = c.f5733e;
            outputStream.write(bArr);
            outputStream.write(b.a(this.f5729p));
            outputStream.write(bArr);
        }
    }

    protected long p() {
        return this.f5728o.length;
    }

    public a(String str, String str2, byte[] bArr) {
        this(str, str2, bArr, null, null);
    }
}
