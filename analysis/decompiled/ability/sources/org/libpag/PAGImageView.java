package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;
import org.libpag.c;
import z2.l;

/* loaded from: classes4.dex */
public class PAGImageView extends View implements PAGAnimator.Listener {

    /* renamed from: A, reason: collision with root package name */
    private volatile int f5487A;

    /* renamed from: B, reason: collision with root package name */
    private volatile int f5488B;

    /* renamed from: C, reason: collision with root package name */
    Paint f5489C;

    /* renamed from: D, reason: collision with root package name */
    private volatile boolean f5490D;
    private volatile boolean E;

    /* renamed from: F, reason: collision with root package name */
    private AtomicBoolean f5491F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f5492G;

    /* renamed from: a, reason: collision with root package name */
    private PAGAnimator f5493a;
    private float b;
    private final AtomicBoolean c;
    protected volatile c.a d;
    private final Object e;
    private volatile Bitmap f;
    private volatile Bitmap g;
    private volatile HardwareBuffer h;
    private volatile Bitmap i;

    /* renamed from: j, reason: collision with root package name */
    private volatile HardwareBuffer f5494j;
    private Matrix k;
    private final ConcurrentHashMap l;
    private String m;
    private volatile PAGComposition n;
    private int o;
    private volatile Matrix p;

    /* renamed from: q, reason: collision with root package name */
    private float f5495q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5496r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f5497s;

    /* renamed from: t, reason: collision with root package name */
    private int f5498t;
    private int u;

    /* renamed from: v, reason: collision with root package name */
    int f5499v;

    /* renamed from: w, reason: collision with root package name */
    long f5500w;

    /* renamed from: x, reason: collision with root package name */
    private final ArrayList f5501x;
    private volatile int y;

    /* renamed from: z, reason: collision with root package name */
    private volatile int f5502z;

    public interface PAGImageViewListener {
        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    static {
        l.j("pag");
    }

    public PAGImageView(Context context) {
        super(context);
        this.b = 30.0f;
        this.c = new AtomicBoolean(false);
        this.d = new c.a();
        this.e = new Object();
        this.l = new ConcurrentHashMap();
        this.o = 2;
        this.f5495q = 1.0f;
        this.f5496r = false;
        this.f5497s = false;
        this.u = 0;
        this.f5499v = -1;
        this.f5500w = 0L;
        this.f5501x = new ArrayList();
        this.f5489C = null;
        this.f5490D = false;
        this.E = false;
        this.f5491F = new AtomicBoolean(true);
        this.f5492G = false;
        e();
    }

    private static native int ContentVersion(PAGComposition pAGComposition);

    @Deprecated
    public static long MaxDiskCache() {
        return PAGDiskCache.MaxDiskSize();
    }

    @Deprecated
    public static void SetMaxDiskCache(long j5) {
        PAGDiskCache.SetMaxDiskSize(j5);
    }

    private void b() {
        boolean z10 = false;
        if (this.f5497s) {
            this.f5497s = false;
            z10 = true;
        }
        PAGComposition pAGComposition = this.n;
        if (pAGComposition != null) {
            int iContentVersion = ContentVersion(pAGComposition);
            int i = this.f5499v;
            boolean z11 = (i < 0 || i == iContentVersion) ? z10 : true;
            this.f5499v = iContentVersion;
            z10 = z11;
        }
        if (z10) {
            this.l.clear();
            if (this.d.a() || this.d.a(pAGComposition, this.y, this.f5502z, this.b)) {
                return;
            }
            Log.w("PAGImageView", "initDecoder failed in checkStatusChange, composition=" + pAGComposition);
        }
    }

    private void c() {
        boolean z10 = this.f5490D && isShown() && d();
        if (this.f5492G == z10) {
            return;
        }
        this.f5492G = z10;
        if (!z10) {
            this.f5493a.setDuration(0L);
            return;
        }
        PAGComposition pAGComposition = this.n;
        this.f5493a.setDuration(pAGComposition != null ? pAGComposition.duration() : this.f5500w);
        this.f5493a.update();
    }

    private boolean d() {
        return this.y > 0 && this.f5502z > 0;
    }

    private void e() {
        this.f5489C = new Paint(6);
        this.f5493a = PAGAnimator.a(getContext(), this);
    }

    private void g() {
        int i = this.o;
        if (i == 0) {
            return;
        }
        this.p = c.a(i, this.d.f5510a, this.d.b, this.y, this.f5502z);
    }

    private void h() {
        if (!this.d.b() && this.u == 0 && this.y > 0) {
            f();
        }
        if (this.d.b() && this.d.a()) {
            this.u = this.d.d();
        }
    }

    private void i() {
        synchronized (this.e) {
            try {
                this.f = null;
                this.g = null;
                this.i = null;
                if (this.h != null) {
                    this.h.close();
                    this.h = null;
                }
                if (this.f5494j != null) {
                    this.f5494j.close();
                    this.f5494j = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j() {
        if (a()) {
            this.d.e();
        }
    }

    public void addListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f5501x.add(pAGImageViewListener);
        }
    }

    public boolean cacheAllFramesInMemory() {
        return this.f5496r;
    }

    public int currentFrame() {
        return this.f5498t;
    }

    public Bitmap currentImage() {
        return this.f;
    }

    public void f() {
        this.d.c();
        try {
            if (!this.d.b()) {
                if (!this.d.a(this.n, this.y, this.f5502z, this.b)) {
                    Log.w("PAGImageView", "initDecoder failed in initDecoderInfo, composition=" + this.n);
                }
                if (!this.d.b()) {
                    this.d.g();
                    return;
                }
            }
            g();
            this.c.set(false);
            this.d.g();
        } catch (Throwable th) {
            this.d.g();
            throw th;
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public boolean flush() {
        if (!this.d.b()) {
            f();
            if (!this.d.b()) {
                postInvalidate();
                return false;
            }
        }
        if (this.d.a()) {
            this.u = this.d.d();
        }
        int iA = c.a(this.f5493a.progress(), this.u);
        this.f5498t = iA;
        if (!a(iA)) {
            this.E = false;
            return false;
        }
        this.E = false;
        postInvalidate();
        return true;
    }

    public PAGComposition getComposition() {
        if (this.m != null) {
            return null;
        }
        return this.n;
    }

    public String getPath() {
        return this.m;
    }

    public boolean isPlaying() {
        return this.f5493a.isRunning();
    }

    public Matrix matrix() {
        return this.p;
    }

    public int numFrames() {
        h();
        return this.u;
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f5501x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationCancel(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f5501x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationEnd(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f5501x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationRepeat(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f5501x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        if (this.f5490D) {
            PAGComposition pAGComposition = this.n;
            if (this.f5492G && pAGComposition != null) {
                pAGAnimator.setDuration(pAGComposition.duration());
            }
            flush();
            synchronized (this) {
                arrayList = new ArrayList(this.f5501x);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGImageViewListener) it.next()).onAnimationUpdate(this);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        this.f5490D = true;
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f5490D = false;
        super.onDetachedFromWindow();
        c();
        this.d.f();
        if (this.f5493a.isRunning()) {
            i();
        }
        this.l.clear();
        this.f5499v = -1;
        this.f5497s = false;
        this.c.set(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.c.get() || this.f == null || this.f.isRecycled()) {
            return;
        }
        super.onDraw(canvas);
        int saveCount = canvas.getSaveCount();
        canvas.save();
        Matrix matrix = this.k;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (this.p != null) {
            canvas.concat(this.p);
        }
        try {
            canvas.drawBitmap(this.f, 0.0f, 0.0f, this.f5489C);
        } catch (Exception e) {
            e.printStackTrace();
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.c.set(true);
        this.d.f();
        this.f5487A = i;
        this.f5488B = i6;
        this.y = (int) (this.f5495q * i);
        this.f5502z = (int) (this.f5495q * i6);
        i();
        this.E = true;
        c();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        c();
    }

    public void pause() {
        this.f5493a.cancel();
    }

    public void play() {
        this.f5493a.a();
    }

    public void removeListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f5501x.remove(pAGImageViewListener);
        }
    }

    public float renderScale() {
        return this.f5495q;
    }

    public int repeatCount() {
        return this.f5493a.repeatCount();
    }

    public int scaleMode() {
        return this.o;
    }

    public void setCacheAllFramesInMemory(boolean z10) {
        this.f5497s = z10 != this.f5496r;
        this.f5496r = z10;
    }

    public void setComposition(PAGComposition pAGComposition) {
        setComposition(pAGComposition, 30.0f);
    }

    public void setCurrentFrame(int i) {
        int i6;
        h();
        if (this.u == 0 || !this.d.b() || i < 0 || i >= (i6 = this.u)) {
            return;
        }
        this.f5498t = i;
        this.f5493a.setProgress(c.a(i, i6));
        this.f5493a.update();
    }

    public void setMatrix(Matrix matrix) {
        this.p = matrix;
        this.o = 0;
        if (d()) {
            postInvalidate();
        }
    }

    public boolean setPath(String str) {
        return setPath(str, 30.0f);
    }

    public void setPathAsync(String str, PAGFile.LoadListener loadListener) {
        setPathAsync(str, 30.0f, loadListener);
    }

    public void setRenderScale(float f) {
        if (this.f5495q == f) {
            return;
        }
        if (f < 0.0f || f > 1.0f) {
            f = 1.0f;
        }
        this.f5495q = f;
        this.y = (int) (this.f5487A * f);
        this.f5502z = (int) (this.f5488B * f);
        g();
        if (f < 1.0f) {
            Matrix matrix = new Matrix();
            this.k = matrix;
            float f7 = 1.0f / f;
            matrix.setScale(f7, f7);
        }
    }

    public void setRepeatCount(int i) {
        this.f5493a.setRepeatCount(i);
    }

    public void setScaleMode(int i) {
        if (i == this.o) {
            return;
        }
        this.o = i;
        if (!d()) {
            this.p = null;
        } else {
            g();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, float f, PAGFile.LoadListener loadListener) {
        PAGComposition pAGCompositionA = a(str);
        a(str, pAGCompositionA, f);
        if (loadListener != null) {
            loadListener.onLoad(pAGCompositionA instanceof PAGFile ? (PAGFile) pAGCompositionA : null);
        }
    }

    public void setComposition(PAGComposition pAGComposition, float f) {
        a((String) null, pAGComposition, f);
    }

    public boolean setPath(String str, float f) {
        PAGComposition pAGCompositionA = a(str);
        a(str, pAGCompositionA, f);
        return pAGCompositionA != null;
    }

    public void setPathAsync(final String str, final float f, final PAGFile.LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f5511a.a(str, f, loadListener);
            }
        });
    }

    private PAGComposition a(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("assets://")) {
            return PAGFile.Load(getContext().getAssets(), str.substring(9));
        }
        return PAGFile.Load(str);
    }

    private void a(String str, PAGComposition pAGComposition, float f) {
        this.c.set(true);
        this.d.f();
        this.b = f;
        this.p = null;
        i();
        this.m = str;
        this.n = pAGComposition;
        this.f5498t = 0;
        this.f5493a.setProgress(pAGComposition == null ? 0.0d : pAGComposition.getProgress());
        long jDuration = pAGComposition == null ? 0L : pAGComposition.duration();
        this.f5500w = jDuration;
        if (this.f5492G) {
            this.f5493a.setDuration(jDuration);
        }
        this.f5493a.update();
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 30.0f;
        this.c = new AtomicBoolean(false);
        this.d = new c.a();
        this.e = new Object();
        this.l = new ConcurrentHashMap();
        this.o = 2;
        this.f5495q = 1.0f;
        this.f5496r = false;
        this.f5497s = false;
        this.u = 0;
        this.f5499v = -1;
        this.f5500w = 0L;
        this.f5501x = new ArrayList();
        this.f5489C = null;
        this.f5490D = false;
        this.E = false;
        this.f5491F = new AtomicBoolean(true);
        this.f5492G = false;
        e();
    }

    private boolean a() {
        if (this.d.b() && this.d.a()) {
            this.u = this.d.d();
        }
        return this.l.size() == this.u;
    }

    private boolean a(int i) {
        HardwareBuffer hardwareBuffer;
        Bitmap bitmap;
        if (!this.d.b() || this.c.get()) {
            return false;
        }
        b();
        j();
        Bitmap bitmap2 = (Bitmap) this.l.get(Integer.valueOf(i));
        if (bitmap2 != null) {
            this.f = bitmap2;
            return true;
        }
        if (this.c.get() || !this.d.a()) {
            return false;
        }
        if (!this.E && !this.d.a(i)) {
            return true;
        }
        synchronized (this.e) {
            try {
                if (this.g == null || this.f5496r) {
                    Pair pairA = a.a(this.d.f5510a, this.d.b, false);
                    Object obj = pairA.first;
                    if (obj == null) {
                        return false;
                    }
                    this.g = (Bitmap) obj;
                    this.h = (HardwareBuffer) pairA.second;
                }
                if (this.g == null) {
                    return false;
                }
                if (!this.f5496r) {
                    if (this.i == null) {
                        Pair pairA2 = a.a(this.d.f5510a, this.d.b, false);
                        if (pairA2.first == null) {
                            return false;
                        }
                        this.f5494j = (HardwareBuffer) pairA2.second;
                        this.i = (Bitmap) pairA2.first;
                    }
                    if (this.f5491F.get()) {
                        bitmap = this.g;
                        hardwareBuffer = this.h;
                    } else {
                        bitmap = this.i;
                        hardwareBuffer = this.f5494j;
                    }
                    this.f5491F.set(!r5.get());
                } else {
                    hardwareBuffer = this.h;
                    bitmap = this.g;
                }
                if (hardwareBuffer != null) {
                    if (!this.d.a(i, hardwareBuffer)) {
                        return false;
                    }
                } else {
                    if (!this.d.a(bitmap, i)) {
                        return false;
                    }
                    bitmap.prepareToDraw();
                }
                this.f = bitmap;
                if (this.f5496r && bitmap != null) {
                    this.l.put(Integer.valueOf(i), bitmap);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 30.0f;
        this.c = new AtomicBoolean(false);
        this.d = new c.a();
        this.e = new Object();
        this.l = new ConcurrentHashMap();
        this.o = 2;
        this.f5495q = 1.0f;
        this.f5496r = false;
        this.f5497s = false;
        this.u = 0;
        this.f5499v = -1;
        this.f5500w = 0L;
        this.f5501x = new ArrayList();
        this.f5489C = null;
        this.f5490D = false;
        this.E = false;
        this.f5491F = new AtomicBoolean(true);
        this.f5492G = false;
        e();
    }
}
