package y5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import d5.p;
import java.lang.invoke.VarHandle;
import java.nio.ByteBuffer;
import v5.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15902a;

    /* renamed from: b, reason: collision with root package name */
    public e6.m f15903b;

    /* renamed from: c, reason: collision with root package name */
    public Object f15904c;

    @Override // y5.g
    public final Object a(nb.c cVar) {
        switch (this.f15902a) {
            case 0:
                return new d(new BitmapDrawable(this.f15903b.f3573a.getResources(), (Bitmap) this.f15904c), false, v5.f.f14785f);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) this.f15904c;
                try {
                    od.i iVar = new od.i();
                    iVar.write(byteBuffer);
                    byteBuffer.position(0);
                    Context context = this.f15903b.f3573a;
                    g9.k kVar = new g9.k(2);
                    kVar.f4509f = context;
                    VarHandle.storeStoreFence();
                    return new m(new r(iVar, kVar, null), null, v5.f.f14785f);
                } catch (Throwable th) {
                    byteBuffer.position(0);
                    throw th;
                }
            default:
                e6.m mVar = this.f15903b;
                Drawable bitmapDrawable = (Drawable) this.f15904c;
                Bitmap.Config config = i6.d.f5804a;
                boolean z10 = (bitmapDrawable instanceof VectorDrawable) || (bitmapDrawable instanceof p);
                if (z10) {
                    bitmapDrawable = new BitmapDrawable(mVar.f3573a.getResources(), id.k.k(bitmapDrawable, mVar.f3574b, mVar.f3576d, mVar.f3577e, mVar.f3578f));
                }
                return new d(bitmapDrawable, z10, v5.f.f14785f);
        }
    }
}
