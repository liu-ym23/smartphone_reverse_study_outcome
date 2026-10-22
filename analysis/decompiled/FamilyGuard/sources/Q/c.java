package Q;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected int f4861a;

    /* renamed from: b, reason: collision with root package name */
    protected ByteBuffer f4862b;

    /* renamed from: c, reason: collision with root package name */
    private int f4863c;

    /* renamed from: d, reason: collision with root package name */
    private int f4864d;

    /* renamed from: e, reason: collision with root package name */
    d f4865e = d.a();

    protected int a(int i5) {
        return i5 + this.f4862b.getInt(i5);
    }

    protected int b(int i5) {
        if (i5 < this.f4864d) {
            return this.f4862b.getShort(this.f4863c + i5);
        }
        return 0;
    }

    protected void c(int i5, ByteBuffer byteBuffer) {
        this.f4862b = byteBuffer;
        if (byteBuffer == null) {
            this.f4861a = 0;
            this.f4863c = 0;
            this.f4864d = 0;
        } else {
            this.f4861a = i5;
            int i6 = i5 - byteBuffer.getInt(i5);
            this.f4863c = i6;
            this.f4864d = this.f4862b.getShort(i6);
        }
    }

    protected int d(int i5) {
        int i6 = i5 + this.f4861a;
        return i6 + this.f4862b.getInt(i6) + 4;
    }

    protected int e(int i5) {
        int i6 = i5 + this.f4861a;
        return this.f4862b.getInt(i6 + this.f4862b.getInt(i6));
    }
}
