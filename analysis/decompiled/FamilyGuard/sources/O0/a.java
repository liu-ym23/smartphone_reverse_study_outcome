package O0;

import X0.k;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import x0.C1279c;
import x0.C1280d;
import x0.C1281e;
import x0.InterfaceC1277a;
import z0.C1342h;
import z0.EnumC1336b;

/* loaded from: classes.dex */
public class a implements z0.i<ByteBuffer, c> {

    /* renamed from: f, reason: collision with root package name */
    private static final C0068a f4294f = new C0068a();

    /* renamed from: g, reason: collision with root package name */
    private static final b f4295g = new b();

    /* renamed from: a, reason: collision with root package name */
    private final Context f4296a;

    /* renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f4297b;

    /* renamed from: c, reason: collision with root package name */
    private final b f4298c;

    /* renamed from: d, reason: collision with root package name */
    private final C0068a f4299d;

    /* renamed from: e, reason: collision with root package name */
    private final O0.b f4300e;

    /* renamed from: O0.a$a, reason: collision with other inner class name */
    static class C0068a {
        C0068a() {
        }

        InterfaceC1277a a(InterfaceC1277a.InterfaceC0257a interfaceC0257a, C1279c c1279c, ByteBuffer byteBuffer, int i5) {
            return new C1281e(interfaceC0257a, c1279c, byteBuffer, i5);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Queue<C1280d> f4301a = k.f(0);

        b() {
        }

        synchronized C1280d a(ByteBuffer byteBuffer) {
            C1280d c1280dPoll;
            try {
                c1280dPoll = this.f4301a.poll();
                if (c1280dPoll == null) {
                    c1280dPoll = new C1280d();
                }
            } catch (Throwable th) {
                throw th;
            }
            return c1280dPoll.p(byteBuffer);
        }

        synchronized void b(C1280d c1280d) {
            c1280d.a();
            this.f4301a.offer(c1280d);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, D0.d dVar, D0.b bVar) {
        this(context, list, dVar, bVar, f4295g, f4294f);
    }

    private e c(ByteBuffer byteBuffer, int i5, int i6, C1280d c1280d, C1342h c1342h) {
        StringBuilder sb;
        long jB = X0.f.b();
        try {
            C1279c c1279cC = c1280d.c();
            if (c1279cC.b() > 0 && c1279cC.c() == 0) {
                Bitmap.Config config = c1342h.c(i.f4338a) == EnumC1336b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                InterfaceC1277a interfaceC1277aA = this.f4299d.a(this.f4300e, c1279cC, byteBuffer, e(c1279cC, i5, i6));
                interfaceC1277aA.f(config);
                interfaceC1277aA.c();
                Bitmap bitmapB = interfaceC1277aA.b();
                if (bitmapB == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder();
                    }
                    return null;
                }
                e eVar = new e(new c(this.f4296a, interfaceC1277aA, J0.b.c(), i5, i6, bitmapB));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + X0.f.a(jB));
                }
                return eVar;
            }
            if (!Log.isLoggable("BufferGifDecoder", 2)) {
                return null;
            }
            sb = new StringBuilder();
            sb.append("Decoded GIF from stream in ");
            sb.append(X0.f.a(jB));
            Log.v("BufferGifDecoder", sb.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + X0.f.a(jB));
            }
            throw th;
        }
    }

    private static int e(C1279c c1279c, int i5, int i6) {
        int iMin = Math.min(c1279c.a() / i6, c1279c.d() / i5);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i5 + "x" + i6 + "], actual dimens: [" + c1279c.d() + "x" + c1279c.a() + "]");
        }
        return iMax;
    }

    @Override // z0.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e a(ByteBuffer byteBuffer, int i5, int i6, C1342h c1342h) {
        C1280d c1280dA = this.f4298c.a(byteBuffer);
        try {
            return c(byteBuffer, i5, i6, c1280dA, c1342h);
        } finally {
            this.f4298c.b(c1280dA);
        }
    }

    @Override // z0.i
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean b(ByteBuffer byteBuffer, C1342h c1342h) {
        return !((Boolean) c1342h.c(i.f4339b)).booleanValue() && com.bumptech.glide.load.a.c(this.f4297b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    a(Context context, List<ImageHeaderParser> list, D0.d dVar, D0.b bVar, b bVar2, C0068a c0068a) {
        this.f4296a = context.getApplicationContext();
        this.f4297b = list;
        this.f4299d = c0068a;
        this.f4300e = new O0.b(dVar, bVar);
        this.f4298c = bVar2;
    }
}
