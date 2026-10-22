package D0;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class j implements d {

    /* renamed from: k, reason: collision with root package name */
    private static final Bitmap.Config f1020k = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private final k f1021a;

    /* renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f1022b;

    /* renamed from: c, reason: collision with root package name */
    private final long f1023c;

    /* renamed from: d, reason: collision with root package name */
    private final a f1024d;

    /* renamed from: e, reason: collision with root package name */
    private long f1025e;

    /* renamed from: f, reason: collision with root package name */
    private long f1026f;

    /* renamed from: g, reason: collision with root package name */
    private int f1027g;

    /* renamed from: h, reason: collision with root package name */
    private int f1028h;

    /* renamed from: i, reason: collision with root package name */
    private int f1029i;

    /* renamed from: j, reason: collision with root package name */
    private int f1030j;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements a {
        b() {
        }

        @Override // D0.j.a
        public void a(Bitmap bitmap) {
        }

        @Override // D0.j.a
        public void b(Bitmap bitmap) {
        }
    }

    j(long j5, k kVar, Set<Bitmap.Config> set) {
        this.f1023c = j5;
        this.f1025e = j5;
        this.f1021a = kVar;
        this.f1022b = set;
        this.f1024d = new b();
    }

    private static void f(Bitmap.Config config) {
        if (config != Bitmap.Config.HARDWARE) {
            return;
        }
        throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
    }

    private static Bitmap g(int i5, int i6, Bitmap.Config config) {
        if (config == null) {
            config = f1020k;
        }
        return Bitmap.createBitmap(i5, i6, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f1027g + ", misses=" + this.f1028h + ", puts=" + this.f1029i + ", evictions=" + this.f1030j + ", currentSize=" + this.f1026f + ", maxSize=" + this.f1025e + "\nStrategy=" + this.f1021a);
    }

    private void j() {
        q(this.f1025e);
    }

    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        hashSet.remove(Bitmap.Config.HARDWARE);
        return Collections.unmodifiableSet(hashSet);
    }

    private static k l() {
        return new m();
    }

    private synchronized Bitmap m(int i5, int i6, Bitmap.Config config) {
        Bitmap bitmapD;
        try {
            f(config);
            bitmapD = this.f1021a.d(i5, i6, config != null ? config : f1020k);
            if (bitmapD == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.f1021a.a(i5, i6, config));
                }
                this.f1028h++;
            } else {
                this.f1027g++;
                this.f1026f -= this.f1021a.b(bitmapD);
                this.f1024d.a(bitmapD);
                p(bitmapD);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.f1021a.a(i5, i6, config));
            }
            h();
        } catch (Throwable th) {
            throw th;
        }
        return bitmapD;
    }

    private static void o(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j5) {
        while (this.f1026f > j5) {
            try {
                Bitmap bitmapRemoveLast = this.f1021a.removeLast();
                if (bitmapRemoveLast == null) {
                    if (Log.isLoggable("LruBitmapPool", 5)) {
                        Log.w("LruBitmapPool", "Size mismatch, resetting");
                        i();
                    }
                    this.f1026f = 0L;
                    return;
                }
                this.f1024d.a(bitmapRemoveLast);
                this.f1026f -= this.f1021a.b(bitmapRemoveLast);
                this.f1030j++;
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Evicting bitmap=" + this.f1021a.e(bitmapRemoveLast));
                }
                h();
                bitmapRemoveLast.recycle();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // D0.d
    public void a(int i5) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i5);
        }
        if (i5 >= 40) {
            b();
        } else if (i5 >= 20 || i5 == 15) {
            q(n() / 2);
        }
    }

    @Override // D0.d
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // D0.d
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f1021a.b(bitmap) <= this.f1025e && this.f1022b.contains(bitmap.getConfig())) {
                int iB = this.f1021a.b(bitmap);
                this.f1021a.c(bitmap);
                this.f1024d.b(bitmap);
                this.f1029i++;
                this.f1026f += iB;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f1021a.e(bitmap));
                }
                h();
                j();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f1021a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f1022b.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // D0.d
    public Bitmap d(int i5, int i6, Bitmap.Config config) {
        Bitmap bitmapM = m(i5, i6, config);
        if (bitmapM == null) {
            return g(i5, i6, config);
        }
        bitmapM.eraseColor(0);
        return bitmapM;
    }

    @Override // D0.d
    public Bitmap e(int i5, int i6, Bitmap.Config config) {
        Bitmap bitmapM = m(i5, i6, config);
        return bitmapM == null ? g(i5, i6, config) : bitmapM;
    }

    public long n() {
        return this.f1025e;
    }

    public j(long j5) {
        this(j5, l(), k());
    }
}
