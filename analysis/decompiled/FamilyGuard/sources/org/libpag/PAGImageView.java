package org.libpag;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.libpag.CacheManager;
import org.libpag.k;

/* loaded from: classes.dex */
public class PAGImageView extends View {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f19144a = new Object();

    /* renamed from: b, reason: collision with root package name */
    protected static long f19145b = 1073741824;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f19146c;

    /* renamed from: A, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f19147A;

    /* renamed from: B, reason: collision with root package name */
    private ArrayList<PAGImageViewListener> f19148B;

    /* renamed from: C, reason: collision with root package name */
    private final AnimatorListenerAdapter f19149C;

    /* renamed from: D, reason: collision with root package name */
    private volatile int f19150D;

    /* renamed from: E, reason: collision with root package name */
    private volatile int f19151E;

    /* renamed from: F, reason: collision with root package name */
    private volatile int f19152F;

    /* renamed from: G, reason: collision with root package name */
    private volatile int f19153G;

    /* renamed from: H, reason: collision with root package name */
    private float f19154H;

    /* renamed from: I, reason: collision with root package name */
    private boolean f19155I;

    /* renamed from: J, reason: collision with root package name */
    private volatile boolean f19156J;

    /* renamed from: K, reason: collision with root package name */
    private Runnable f19157K;

    /* renamed from: L, reason: collision with root package name */
    private Runnable f19158L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f19159M;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f19160d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f19161e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f19162f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Boolean f19163g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f19164h;

    /* renamed from: i, reason: collision with root package name */
    private final Object f19165i;

    /* renamed from: j, reason: collision with root package name */
    private int f19166j;

    /* renamed from: k, reason: collision with root package name */
    private float f19167k;

    /* renamed from: l, reason: collision with root package name */
    private PAGComposition f19168l;

    /* renamed from: m, reason: collision with root package name */
    private String f19169m;

    /* renamed from: n, reason: collision with root package name */
    private int f19170n;

    /* renamed from: o, reason: collision with root package name */
    private volatile Matrix f19171o;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<WeakReference<Future>> f19172p;

    /* renamed from: q, reason: collision with root package name */
    private float f19173q;

    /* renamed from: r, reason: collision with root package name */
    private AtomicBoolean f19174r;

    /* renamed from: s, reason: collision with root package name */
    protected volatile CacheManager.a f19175s;

    /* renamed from: t, reason: collision with root package name */
    protected volatile a f19176t;

    /* renamed from: u, reason: collision with root package name */
    protected volatile k.b f19177u;

    /* renamed from: v, reason: collision with root package name */
    protected volatile CacheManager f19178v;

    /* renamed from: w, reason: collision with root package name */
    private volatile Bitmap f19179w;

    /* renamed from: x, reason: collision with root package name */
    private ConcurrentHashMap<Integer, Bitmap> f19180x;

    /* renamed from: y, reason: collision with root package name */
    private Matrix f19181y;

    /* renamed from: z, reason: collision with root package name */
    private volatile long f19182z;

    public interface PAGImageViewListener {
        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    protected static class a {

        /* renamed from: a, reason: collision with root package name */
        String f19183a;

        /* renamed from: b, reason: collision with root package name */
        String f19184b;

        /* renamed from: c, reason: collision with root package name */
        boolean f19185c = false;

        protected a() {
        }
    }

    public PAGImageView(Context context) {
        super(context);
        this.f19161e = false;
        this.f19162f = false;
        this.f19163g = null;
        this.f19164h = true;
        this.f19165i = new Object();
        this.f19167k = 30.0f;
        this.f19170n = 2;
        this.f19172p = new ArrayList<>();
        this.f19173q = 1.0f;
        this.f19174r = new AtomicBoolean(false);
        this.f19177u = new k.b();
        this.f19180x = new ConcurrentHashMap<>();
        this.f19147A = new f(this);
        this.f19148B = new ArrayList<>();
        this.f19149C = new g(this);
        this.f19154H = 1.0f;
        this.f19155I = false;
        this.f19156J = false;
        this.f19157K = new h(this);
        this.f19158L = new i(this);
        this.f19159M = true;
        k();
    }

    public static long MaxDiskCache() {
        return f19145b;
    }

    public static void SetMaxDiskCache(long j5) {
        f19145b = j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.f19180x.size() == this.f19177u.f19245d;
    }

    private void h() {
        if (l()) {
            this.f19182z = this.f19160d.getCurrentPlayTime();
            this.f19160d.cancel();
        } else {
            removeCallbacks(this.f19157K);
            post(this.f19158L);
        }
    }

    private void i() {
        if (!this.f19155I) {
            Log.e("PAGImageView", "doPlay: View is not attached to window");
            return;
        }
        if (this.f19154H == 0.0f) {
            n();
            Log.e("PAGImageView", "doPlay: The scale of animator duration is turned off");
        } else {
            k.b(3, this);
            Log.i("PAGImageView", "doPlay");
            this.f19160d.setCurrentPlayTime(this.f19182z);
            t();
        }
    }

    private boolean j() {
        return this.f19150D > 0 && this.f19151E > 0;
    }

    private void k() {
        f();
        this.f19178v = CacheManager.a(getContext());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f19160d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(0);
        this.f19160d.setInterpolator(new LinearInterpolator());
        this.f19160d.addUpdateListener(this.f19147A);
        this.f19154H = a(getContext());
    }

    private boolean l() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    private void m() {
        ArrayList arrayList;
        if (this.f19148B.isEmpty() || !this.f19160d.isRunning()) {
            return;
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f19148B);
        }
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGImageViewListener) obj).onAnimationUpdate(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        ArrayList arrayList;
        int i5 = 0;
        this.f19162f = false;
        synchronized (this) {
            arrayList = new ArrayList(this.f19148B);
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGImageViewListener) obj).onAnimationEnd(this);
        }
    }

    private void o() {
        if (this.f19163g == null) {
            this.f19163g = Boolean.valueOf(this.f19160d.isRunning());
        }
        if (this.f19160d.isRunning()) {
            h();
        }
    }

    private void p() {
        int i5 = this.f19170n;
        if (i5 == 0) {
            return;
        }
        this.f19171o = k.a(i5, this.f19177u.f19242a, this.f19177u.f19243b, this.f19150D, this.f19151E);
    }

    private void q() {
        try {
            Iterator<WeakReference<Future>> it = this.f19172p.iterator();
            while (it.hasNext()) {
                WeakReference<Future> next = it.next();
                if (next.get() != null) {
                    next.get().cancel(false);
                }
                it.remove();
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    private void r() {
        if (this.f19175s == null || this.f19176t == null || TextUtils.isEmpty(this.f19176t.f19183a)) {
            return;
        }
        if (g()) {
            this.f19175s.g();
            if (this.f19177u.f19247f != null) {
                this.f19177u.b();
            }
            this.f19178v.b(this.f19176t.f19184b);
            this.f19175s.h();
            this.f19175s = null;
            return;
        }
        if (this.f19177u.f19247f == null || !this.f19175s.b()) {
            return;
        }
        this.f19175s.g();
        this.f19177u.b();
        this.f19175s.f();
        this.f19175s.h();
    }

    private void s() {
        if (this.f19150D == 0 || this.f19151E == 0 || !this.f19162f || this.f19160d.isRunning() || !(this.f19163g == null || this.f19163g.booleanValue())) {
            this.f19163g = null;
        } else {
            this.f19163g = null;
            i();
        }
    }

    private void t() {
        if (this.f19160d.getDuration() <= 0) {
            return;
        }
        if (l()) {
            this.f19160d.start();
        } else {
            removeCallbacks(this.f19158L);
            post(this.f19157K);
        }
    }

    public void addListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f19148B.add(pAGImageViewListener);
        }
    }

    public boolean cacheAllFramesInMemory() {
        return this.f19161e;
    }

    public int currentFrame() {
        return this.f19166j;
    }

    public Bitmap currentImage() {
        return this.f19179w;
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public boolean flush() {
        if (!this.f19177u.a()) {
            return false;
        }
        synchronized (this.f19165i) {
            try {
                if (this.f19164h) {
                    this.f19164h = false;
                    this.f19160d.setCurrentPlayTime((long) (this.f19177u.f19246e * 0.001f * k.b(this.f19166j, this.f19177u.f19245d)));
                }
                int iA = k.a(this.f19160d.getAnimatedFraction(), this.f19177u.f19245d);
                if (iA == this.f19166j && !this.f19156J) {
                    return false;
                }
                this.f19156J = false;
                this.f19166j = iA;
                if (!a(iA)) {
                    return false;
                }
                postInvalidate();
                m();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PAGComposition getComposition() {
        return this.f19168l;
    }

    public String getPath() {
        return this.f19169m;
    }

    public boolean isPlaying() {
        ValueAnimator valueAnimator = this.f19160d;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public Matrix matrix() {
        return this.f19171o;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        this.f19155I = true;
        super.onAttachedToWindow();
        this.f19156J = true;
        this.f19160d.addUpdateListener(this.f19147A);
        this.f19160d.addListener(this.f19149C);
        synchronized (f19144a) {
            k.b();
        }
        s();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f19155I = false;
        super.onDetachedFromWindow();
        k.a(1, this);
        o();
        this.f19160d.removeUpdateListener(this.f19147A);
        this.f19160d.removeListener(this.f19149C);
        q();
        k.b(2, this);
        synchronized (f19144a) {
            k.a();
        }
        this.f19179w = null;
        this.f19180x.clear();
        this.f19174r.set(false);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f19174r.get() || this.f19179w == null || this.f19179w.isRecycled()) {
            return;
        }
        super.onDraw(canvas);
        canvas.save();
        Matrix matrix = this.f19181y;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (this.f19171o != null) {
            canvas.concat(this.f19171o);
        }
        try {
            canvas.drawBitmap(this.f19179w, 0.0f, 0.0f, (Paint) null);
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f19152F = i5;
        this.f19153G = i6;
        float f5 = this.f19173q;
        this.f19150D = (int) (i5 * f5);
        this.f19151E = (int) (f5 * i6);
        k.b(3, this);
        s();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z5) {
        super.onVisibilityAggregated(z5);
        if (this.f19159M == z5) {
            return;
        }
        this.f19159M = z5;
        Log.i("PAGImageView", "onVisibilityAggregated isVisible=" + z5);
        if (z5) {
            s();
        } else {
            o();
        }
    }

    public void pause() {
        this.f19162f = false;
        this.f19163g = null;
        h();
    }

    public void play() {
        this.f19162f = true;
        this.f19163g = null;
        if (this.f19160d.getAnimatedFraction() == 1.0d) {
            setCurrentFrame(0);
        }
        i();
    }

    public void removeListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f19148B.remove(pAGImageViewListener);
        }
    }

    public float renderScale() {
        return this.f19173q;
    }

    public int scaleMode() {
        return this.f19170n;
    }

    public void setCacheAllFramesInMemory(boolean z5) {
        this.f19161e = z5;
    }

    public void setComposition(PAGComposition pAGComposition) {
        setComposition(pAGComposition, 30.0f);
    }

    public void setCurrentFrame(int i5) {
        if (!this.f19177u.a() || i5 < 0 || i5 >= this.f19177u.f19245d) {
            return;
        }
        if (this.f19175s != null || g()) {
            this.f19166j = i5;
            this.f19182z = (long) (Math.max(0.0f, Math.min((float) (this.f19177u.f19246e * 0.001f * k.b(this.f19166j, this.f19177u.f19245d)), 1.0f)) * this.f19160d.getDuration());
            synchronized (this.f19165i) {
                this.f19160d.setCurrentPlayTime(this.f19182z);
                this.f19164h = true;
            }
            k.a(this);
        }
    }

    public void setMatrix(Matrix matrix) {
        this.f19171o = matrix;
        this.f19170n = 0;
        if (j()) {
            postInvalidate();
        }
    }

    public boolean setPath(String str, float f5) {
        if (str == null) {
            return false;
        }
        if (str.equals(this.f19169m) && this.f19167k == f5 && this.f19177u.a()) {
            return true;
        }
        this.f19174r.set(true);
        this.f19169m = str;
        this.f19167k = f5;
        this.f19164h = true;
        this.f19160d.setCurrentPlayTime(0L);
        q();
        this.f19171o = null;
        this.f19179w = null;
        k.b(4, this);
        return true;
    }

    public void setRenderScale(float f5) {
        if (this.f19173q == f5) {
            return;
        }
        if (f5 < 0.0f || f5 > 1.0f) {
            f5 = 1.0f;
        }
        this.f19173q = f5;
        this.f19150D = (int) (this.f19152F * f5);
        this.f19151E = (int) (this.f19153G * f5);
        p();
        if (f5 < 1.0f) {
            Matrix matrix = new Matrix();
            this.f19181y = matrix;
            float f6 = 1.0f / f5;
            matrix.setScale(f6, f6);
        }
    }

    public void setRepeatCount(int i5) {
        if (i5 < 0) {
            i5 = 0;
        }
        this.f19160d.setRepeatCount(i5 - 1);
    }

    public void setScaleMode(int i5) {
        if (i5 == this.f19170n) {
            return;
        }
        this.f19170n = i5;
        if (!j()) {
            this.f19171o = null;
        } else {
            p();
            postInvalidate();
        }
    }

    private static void f() {
        if (f19146c == null) {
            synchronized (PAGImageView.class) {
                try {
                    if (f19146c == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 2L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        f19146c = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    protected void b() {
        if (!this.f19177u.a() && this.f19177u.a(getContext(), this.f19168l, this.f19169m, this.f19150D, this.f19151E, this.f19167k)) {
            this.f19160d.setDuration(this.f19177u.f19246e / 1000);
            if (!this.f19177u.a()) {
                return;
            }
            this.f19176t = a();
            if (this.f19175s != null || this.f19176t == null) {
                return;
            } else {
                this.f19175s = this.f19178v.a(this.f19176t.f19184b, this.f19177u.f19242a, this.f19177u.f19243b, this.f19177u.f19245d);
            }
        }
        p();
        this.f19174r.set(false);
    }

    protected void c() {
        if (this.f19177u != null) {
            this.f19177u.c();
        }
        d();
        this.f19176t = null;
        b();
    }

    protected void d() {
        if (this.f19175s != null) {
            this.f19175s.g();
            if (this.f19176t.f19185c) {
                try {
                    new File(this.f19178v.a(this.f19176t.f19184b)).delete();
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
            this.f19175s.h();
            this.f19178v.b(this.f19176t.f19184b);
            this.f19175s = null;
        }
    }

    protected boolean e() {
        if (this.f19155I) {
            return flush();
        }
        return true;
    }

    public void setComposition(PAGComposition pAGComposition, float f5) {
        if (pAGComposition == this.f19168l && this.f19167k == f5 && this.f19177u.a()) {
            return;
        }
        this.f19174r.set(true);
        this.f19168l = pAGComposition;
        this.f19167k = f5;
        this.f19164h = true;
        this.f19160d.setCurrentPlayTime(0L);
        q();
        this.f19171o = null;
        this.f19179w = null;
        k.b(4, this);
    }

    private float a(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    protected a a() {
        String str;
        if (!this.f19177u.a()) {
            return null;
        }
        if (this.f19168l == null && this.f19169m == null) {
            return null;
        }
        if (this.f19169m != null && this.f19176t != null) {
            return this.f19176t;
        }
        String str2 = "_" + ((this.f19177u.f19242a << 16) | this.f19177u.f19243b) + "_" + this.f19177u.f19244c;
        boolean z5 = false;
        if (this.f19169m != null) {
            str = this.f19169m + str2;
        } else {
            PAGComposition pAGComposition = this.f19168l;
            if ((pAGComposition instanceof PAGFile) && CacheManager.ContentVersion(pAGComposition) == 0) {
                str = ((PAGFile) this.f19168l).path() + str2;
            } else {
                str = this.f19168l.toString() + "_" + CacheManager.ContentVersion(this.f19168l) + str2;
                z5 = true;
            }
        }
        if (this.f19176t != null && str.equals(this.f19176t.f19183a)) {
            return this.f19176t;
        }
        a aVar = new a();
        aVar.f19183a = str;
        aVar.f19184b = k.a(str);
        aVar.f19185c = z5;
        return aVar;
    }

    protected boolean b(k.a aVar) {
        if (aVar != null) {
            try {
                if (this.f19175s != null) {
                    return this.f19175s.a(aVar.f19240c, aVar.f19241d);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return false;
    }

    public boolean setPath(String str) {
        return setPath(str, 30.0f);
    }

    private boolean a(int i5) {
        if (this.f19177u.a() && !this.f19174r.get()) {
            a aVarA = a();
            if (this.f19176t != null && this.f19176t.f19183a != null && !this.f19176t.f19183a.equals(aVarA.f19183a)) {
                d();
                this.f19175s = this.f19178v.a(aVarA.f19184b, this.f19177u.f19242a, this.f19177u.f19243b, this.f19177u.f19245d);
                this.f19180x.clear();
            }
            this.f19176t = aVarA;
            if (this.f19174r.get()) {
                return false;
            }
            r();
            if (this.f19176t != null && this.f19176t.f19184b != null) {
                Bitmap bitmap = this.f19180x.get(Integer.valueOf(i5));
                if (bitmap != null) {
                    this.f19179w = bitmap;
                    return true;
                }
                if (this.f19175s != null) {
                    try {
                        if (this.f19175s.a(i5)) {
                            if (this.f19179w == null || this.f19161e) {
                                this.f19179w = k.a(this.f19177u.f19242a, this.f19177u.f19243b);
                            }
                            a(k.a.a(this, this.f19176t.f19184b, i5, this.f19179w));
                            return true;
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            if (this.f19174r.get()) {
                return false;
            }
            if (this.f19179w == null || this.f19161e) {
                this.f19179w = k.a(this.f19177u.f19242a, this.f19177u.f19243b);
            }
            if (this.f19177u.f19247f != null && this.f19177u.f19247f.copyFrameTo(this.f19179w, i5)) {
                if (this.f19161e) {
                    this.f19180x.put(Integer.valueOf(i5), this.f19179w);
                }
                if (this.f19175s != null && this.f19175s.b(i5, this.f19179w)) {
                    this.f19172p.add(new WeakReference<>(f19146c.submit(new j(this))));
                }
                return true;
            }
        }
        return false;
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19161e = false;
        this.f19162f = false;
        this.f19163g = null;
        this.f19164h = true;
        this.f19165i = new Object();
        this.f19167k = 30.0f;
        this.f19170n = 2;
        this.f19172p = new ArrayList<>();
        this.f19173q = 1.0f;
        this.f19174r = new AtomicBoolean(false);
        this.f19177u = new k.b();
        this.f19180x = new ConcurrentHashMap<>();
        this.f19147A = new f(this);
        this.f19148B = new ArrayList<>();
        this.f19149C = new g(this);
        this.f19154H = 1.0f;
        this.f19155I = false;
        this.f19156J = false;
        this.f19157K = new h(this);
        this.f19158L = new i(this);
        this.f19159M = true;
        k();
    }

    protected static boolean a(k.a aVar) {
        if (aVar.f19238a == null || TextUtils.isEmpty(aVar.f19239b)) {
            return false;
        }
        if (!aVar.f19238a.b(aVar)) {
            Log.e("PAGImageView", "inflateBitmapFromDiskCache failed:" + aVar.f19238a.f19169m);
            return false;
        }
        PAGImageView pAGImageView = aVar.f19238a;
        if (!pAGImageView.f19161e) {
            return true;
        }
        pAGImageView.f19180x.put(Integer.valueOf(aVar.f19240c), aVar.f19241d);
        return true;
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f19161e = false;
        this.f19162f = false;
        this.f19163g = null;
        this.f19164h = true;
        this.f19165i = new Object();
        this.f19167k = 30.0f;
        this.f19170n = 2;
        this.f19172p = new ArrayList<>();
        this.f19173q = 1.0f;
        this.f19174r = new AtomicBoolean(false);
        this.f19177u = new k.b();
        this.f19180x = new ConcurrentHashMap<>();
        this.f19147A = new f(this);
        this.f19148B = new ArrayList<>();
        this.f19149C = new g(this);
        this.f19154H = 1.0f;
        this.f19155I = false;
        this.f19156J = false;
        this.f19157K = new h(this);
        this.f19158L = new i(this);
        this.f19159M = true;
        k();
    }
}
