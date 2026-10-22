package Y;

import java.nio.ByteBuffer;
import y1.f;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public int f2111a;

    /* renamed from: b, reason: collision with root package name */
    public int f2112b;

    /* renamed from: c, reason: collision with root package name */
    public int f2113c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2114d;

    public c() {
        if (f.f16200a == null) {
            f.f16200a = new f();
        }
    }

    public final int a(int i4) {
        if (i4 < this.f2113c) {
            return ((ByteBuffer) this.f2114d).getShort(this.f2112b + i4);
        }
        return 0;
    }

    public final void b(ByteBuffer byteBuffer, int i4) {
        this.f2114d = byteBuffer;
        if (byteBuffer == null) {
            this.f2111a = 0;
            this.f2112b = 0;
            this.f2113c = 0;
        } else {
            this.f2111a = i4;
            int i5 = i4 - byteBuffer.getInt(i4);
            this.f2112b = i5;
            this.f2113c = ((ByteBuffer) this.f2114d).getShort(i5);
        }
    }
}
