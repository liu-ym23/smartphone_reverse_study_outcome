package K0;

import C0.v;
import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import z0.C1342h;

/* loaded from: classes.dex */
public class e implements z0.i<ByteBuffer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final h f3515a;

    public e(h hVar) {
        this.f3515a = hVar;
    }

    @Override // z0.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<Bitmap> a(ByteBuffer byteBuffer, int i5, int i6, C1342h c1342h) {
        return this.f3515a.d(X0.a.e(byteBuffer), i5, i6, c1342h);
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, C1342h c1342h) {
        return this.f3515a.n(byteBuffer);
    }
}
