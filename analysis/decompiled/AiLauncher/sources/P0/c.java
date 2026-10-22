package P0;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f5356a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f5357b;

    /* renamed from: c, reason: collision with root package name */
    public int f5358c;

    /* renamed from: d, reason: collision with root package name */
    public int f5359d;

    /* renamed from: e, reason: collision with root package name */
    public d f5360e = d.a();

    public int a(int i10) {
        return i10 + this.f5357b.getInt(i10);
    }

    public int b(int i10) {
        if (i10 < this.f5359d) {
            return this.f5357b.getShort(this.f5358c + i10);
        }
        return 0;
    }

    public void c(int i10, ByteBuffer byteBuffer) {
        this.f5357b = byteBuffer;
        if (byteBuffer == null) {
            this.f5356a = 0;
            this.f5358c = 0;
            this.f5359d = 0;
        } else {
            this.f5356a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f5358c = i11;
            this.f5359d = this.f5357b.getShort(i11);
        }
    }

    public int d(int i10) {
        int i11 = i10 + this.f5356a;
        return i11 + this.f5357b.getInt(i11) + 4;
    }

    public int e(int i10) {
        int i11 = i10 + this.f5356a;
        return this.f5357b.getInt(i11 + this.f5357b.getInt(i11));
    }
}
