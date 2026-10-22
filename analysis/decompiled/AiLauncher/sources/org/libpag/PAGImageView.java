package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import gc.AbstractC4115a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;
import org.libpag.c;

/* loaded from: classes5.dex */
public class PAGImageView extends View implements PAGAnimator.Listener {

    /* renamed from: A, reason: collision with root package name */
    private volatile int f37860A;

    /* renamed from: B, reason: collision with root package name */
    private volatile int f37861B;

    /* renamed from: C, reason: collision with root package name */
    Paint f37862C;

    /* renamed from: D, reason: collision with root package name */
    private volatile boolean f37863D;

    /* renamed from: E, reason: collision with root package name */
    private volatile boolean f37864E;

    /* renamed from: F, reason: collision with root package name */
    private AtomicBoolean f37865F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f37866G;

    /* renamed from: a, reason: collision with root package name */
    private PAGAnimator f37867a;

    /* renamed from: b, reason: collision with root package name */
    private float f37868b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f37869c;

    /* renamed from: d, reason: collision with root package name */
    protected volatile c.a f37870d;

    /* renamed from: e, reason: collision with root package name */
    private final Object f37871e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Bitmap f37872f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Bitmap f37873g;

    /* renamed from: h, reason: collision with root package name */
    private volatile HardwareBuffer f37874h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Bitmap f37875i;

    /* renamed from: j, reason: collision with root package name */
    private volatile HardwareBuffer f37876j;

    /* renamed from: k, reason: collision with root package name */
    private Matrix f37877k;

    /* renamed from: l, reason: collision with root package name */
    private final ConcurrentHashMap f37878l;

    /* renamed from: m, reason: collision with root package name */
    private String f37879m;

    /* renamed from: n, reason: collision with root package name */
    private PAGComposition f37880n;

    /* renamed from: o, reason: collision with root package name */
    private int f37881o;

    /* renamed from: p, reason: collision with root package name */
    private volatile Matrix f37882p;

    /* renamed from: q, reason: collision with root package name */
    private float f37883q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37884r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f37885s;

    /* renamed from: t, reason: collision with root package name */
    private int f37886t;

    /* renamed from: u, reason: collision with root package name */
    private int f37887u;

    /* renamed from: v, reason: collision with root package name */
    int f37888v;

    /* renamed from: w, reason: collision with root package name */
    long f37889w;

    /* renamed from: x, reason: collision with root package name */
    private final ArrayList f37890x;

    /* renamed from: y, reason: collision with root package name */
    private volatile int f37891y;

    /* renamed from: z, reason: collision with root package name */
    private volatile int f37892z;

    public interface PAGImageViewListener {
        void onAnimationCancel(PAGImageView pAGImageView);

        void onAnimationEnd(PAGImageView pAGImageView);

        void onAnimationRepeat(PAGImageView pAGImageView);

        void onAnimationStart(PAGImageView pAGImageView);

        void onAnimationUpdate(PAGImageView pAGImageView);
    }

    static {
        AbstractC4115a.e("pag");
    }

    public PAGImageView(Context context) {
        super(context);
        this.f37868b = 30.0f;
        this.f37869c = new AtomicBoolean(false);
        this.f37870d = new c.a();
        this.f37871e = new Object();
        this.f37878l = new ConcurrentHashMap();
        this.f37881o = 2;
        this.f37883q = 1.0f;
        this.f37884r = false;
        this.f37885s = false;
        this.f37887u = 0;
        this.f37888v = -1;
        this.f37889w = 0L;
        this.f37890x = new ArrayList();
        this.f37862C = null;
        this.f37863D = false;
        this.f37864E = false;
        this.f37865F = new AtomicBoolean(true);
        this.f37866G = false;
        e();
    }

    private static native int ContentVersion(PAGComposition pAGComposition);

    @Deprecated
    public static long MaxDiskCache() {
        return PAGDiskCache.MaxDiskSize();
    }

    @Deprecated
    public static void SetMaxDiskCache(long j10) {
        PAGDiskCache.SetMaxDiskSize(j10);
    }

    private void b() {
        PAGComposition pAGComposition;
        boolean z10 = false;
        if (this.f37885s) {
            this.f37885s = false;
            z10 = true;
        }
        if (this.f37879m == null && (pAGComposition = this.f37880n) != null) {
            int iContentVersion = ContentVersion(pAGComposition);
            int i10 = this.f37888v;
            boolean z11 = (i10 < 0 || i10 == iContentVersion) ? z10 : true;
            this.f37888v = iContentVersion;
            z10 = z11;
        }
        if (z10) {
            this.f37878l.clear();
            if (this.f37870d.a()) {
                return;
            }
            PAGComposition pAGCompositionA = this.f37880n;
            if (pAGCompositionA == null) {
                pAGCompositionA = a(this.f37879m);
            }
            this.f37870d.a(pAGCompositionA, this.f37891y, this.f37892z, this.f37868b);
        }
    }

    private void c() {
        boolean z10 = this.f37863D && isShown() && d();
        if (this.f37866G == z10) {
            return;
        }
        this.f37866G = z10;
        if (!z10) {
            this.f37867a.setDuration(0L);
            return;
        }
        PAGComposition pAGComposition = this.f37880n;
        this.f37867a.setDuration(pAGComposition != null ? pAGComposition.duration() : this.f37889w);
        this.f37867a.update();
    }

    private boolean d() {
        return this.f37891y > 0 && this.f37892z > 0;
    }

    private void e() {
        this.f37862C = new Paint(6);
        this.f37867a = PAGAnimator.a(getContext(), this);
    }

    private void g() {
        int i10 = this.f37881o;
        if (i10 == 0) {
            return;
        }
        this.f37882p = c.a(i10, this.f37870d.f37911a, this.f37870d.f37912b, this.f37891y, this.f37892z);
    }

    private void h() {
        if (!this.f37870d.b() && this.f37887u == 0 && this.f37891y > 0) {
            f();
        }
        if (this.f37870d.b() && this.f37870d.a()) {
            this.f37887u = this.f37870d.c();
        }
    }

    private void i() {
        synchronized (this.f37871e) {
            try {
                this.f37872f = null;
                this.f37873g = null;
                this.f37875i = null;
                if (this.f37874h != null) {
                    this.f37874h.close();
                    this.f37874h = null;
                }
                if (this.f37876j != null) {
                    this.f37876j.close();
                    this.f37876j = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void j() {
        if (a()) {
            this.f37870d.d();
        }
    }

    public void addListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f37890x.add(pAGImageViewListener);
        }
    }

    public boolean cacheAllFramesInMemory() {
        return this.f37884r;
    }

    public int currentFrame() {
        return this.f37886t;
    }

    public Bitmap currentImage() {
        return this.f37872f;
    }

    public void f() {
        synchronized (this.f37870d) {
            try {
                if (!this.f37870d.b()) {
                    if (this.f37880n == null) {
                        this.f37880n = a(this.f37879m);
                    }
                    if (this.f37870d.a(this.f37880n, this.f37891y, this.f37892z, this.f37868b) && this.f37879m != null) {
                        this.f37880n = null;
                    }
                    if (!this.f37870d.b()) {
                        return;
                    }
                }
                g();
                this.f37869c.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    public boolean flush() {
        if (!this.f37870d.b()) {
            f();
            if (!this.f37870d.b()) {
                postInvalidate();
                return false;
            }
        }
        if (this.f37870d.a()) {
            this.f37887u = this.f37870d.c();
        }
        int iA = c.a(this.f37867a.progress(), this.f37887u);
        this.f37886t = iA;
        if (!a(iA)) {
            this.f37864E = false;
            return false;
        }
        this.f37864E = false;
        postInvalidate();
        return true;
    }

    public PAGComposition getComposition() {
        if (this.f37879m != null) {
            return null;
        }
        return this.f37880n;
    }

    public String getPath() {
        return this.f37879m;
    }

    public boolean isPlaying() {
        return this.f37867a.isRunning();
    }

    public Matrix matrix() {
        return this.f37882p;
    }

    public int numFrames() {
        h();
        return this.f37887u;
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f37890x);
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
            arrayList = new ArrayList(this.f37890x);
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
            arrayList = new ArrayList(this.f37890x);
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
            arrayList = new ArrayList(this.f37890x);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGImageViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        PAGComposition pAGComposition;
        if (this.f37863D) {
            if (this.f37866G && (pAGComposition = this.f37880n) != null) {
                pAGAnimator.setDuration(pAGComposition.duration());
            }
            flush();
            synchronized (this) {
                arrayList = new ArrayList(this.f37890x);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGImageViewListener) it.next()).onAnimationUpdate(this);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        this.f37863D = true;
        super.onAttachedToWindow();
        c();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f37863D = false;
        super.onDetachedFromWindow();
        c();
        this.f37870d.e();
        if (this.f37867a.isRunning()) {
            i();
        }
        this.f37878l.clear();
        this.f37888v = -1;
        this.f37885s = false;
        this.f37869c.set(false);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f37869c.get() || this.f37872f == null || this.f37872f.isRecycled()) {
            return;
        }
        super.onDraw(canvas);
        int saveCount = canvas.getSaveCount();
        canvas.save();
        Matrix matrix = this.f37877k;
        if (matrix != null) {
            canvas.concat(matrix);
        }
        if (this.f37882p != null) {
            canvas.concat(this.f37882p);
        }
        try {
            canvas.drawBitmap(this.f37872f, 0.0f, 0.0f, this.f37862C);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        canvas.restoreToCount(saveCount);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f37869c.set(true);
        this.f37870d.e();
        this.f37860A = i10;
        this.f37861B = i11;
        this.f37891y = (int) (this.f37883q * i10);
        this.f37892z = (int) (this.f37883q * i11);
        i();
        this.f37864E = true;
        c();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        c();
    }

    public void pause() {
        this.f37867a.cancel();
    }

    public void play() {
        this.f37867a.a();
    }

    public void removeListener(PAGImageViewListener pAGImageViewListener) {
        synchronized (this) {
            this.f37890x.remove(pAGImageViewListener);
        }
    }

    public float renderScale() {
        return this.f37883q;
    }

    public int repeatCount() {
        return this.f37867a.repeatCount();
    }

    public int scaleMode() {
        return this.f37881o;
    }

    public void setCacheAllFramesInMemory(boolean z10) {
        this.f37885s = z10 != this.f37884r;
        this.f37884r = z10;
    }

    public void setComposition(PAGComposition pAGComposition) {
        setComposition(pAGComposition, 30.0f);
    }

    public void setCurrentFrame(int i10) {
        int i11;
        h();
        if (this.f37887u == 0 || !this.f37870d.b() || i10 < 0 || i10 >= (i11 = this.f37887u)) {
            return;
        }
        this.f37886t = i10;
        this.f37867a.setProgress(c.a(i10, i11));
        this.f37867a.update();
    }

    public void setMatrix(Matrix matrix) {
        this.f37882p = matrix;
        this.f37881o = 0;
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

    public void setRenderScale(float f10) {
        if (this.f37883q == f10) {
            return;
        }
        if (f10 < 0.0f || f10 > 1.0f) {
            f10 = 1.0f;
        }
        this.f37883q = f10;
        this.f37891y = (int) (this.f37860A * f10);
        this.f37892z = (int) (this.f37861B * f10);
        g();
        if (f10 < 1.0f) {
            Matrix matrix = new Matrix();
            this.f37877k = matrix;
            float f11 = 1.0f / f10;
            matrix.setScale(f11, f11);
        }
    }

    public void setRepeatCount(int i10) {
        this.f37867a.setRepeatCount(i10);
    }

    public void setScaleMode(int i10) {
        if (i10 == this.f37881o) {
            return;
        }
        this.f37881o = i10;
        if (!d()) {
            this.f37882p = null;
        } else {
            g();
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, float f10, PAGFile.LoadListener loadListener) {
        setPath(str, f10);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.f37880n);
        }
    }

    public void setComposition(PAGComposition pAGComposition, float f10) {
        a((String) null, pAGComposition, f10);
    }

    public boolean setPath(String str, float f10) {
        PAGComposition pAGCompositionA = a(str);
        a(str, pAGCompositionA, f10);
        return pAGCompositionA != null;
    }

    public void setPathAsync(final String str, final float f10, final PAGFile.LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f37920a.a(str, f10, loadListener);
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

    private void a(String str, PAGComposition pAGComposition, float f10) {
        this.f37869c.set(true);
        this.f37870d.e();
        this.f37868b = f10;
        this.f37882p = null;
        i();
        this.f37879m = str;
        this.f37880n = pAGComposition;
        this.f37886t = 0;
        this.f37867a.setProgress(pAGComposition == null ? 0.0d : pAGComposition.getProgress());
        PAGComposition pAGComposition2 = this.f37880n;
        long jDuration = pAGComposition2 == null ? 0L : pAGComposition2.duration();
        this.f37889w = jDuration;
        if (this.f37866G) {
            this.f37867a.setDuration(jDuration);
        }
        this.f37867a.update();
    }

    private boolean a() {
        if (this.f37870d.b() && this.f37870d.a()) {
            this.f37887u = this.f37870d.c();
        }
        return this.f37878l.size() == this.f37887u;
    }

    public PAGImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37868b = 30.0f;
        this.f37869c = new AtomicBoolean(false);
        this.f37870d = new c.a();
        this.f37871e = new Object();
        this.f37878l = new ConcurrentHashMap();
        this.f37881o = 2;
        this.f37883q = 1.0f;
        this.f37884r = false;
        this.f37885s = false;
        this.f37887u = 0;
        this.f37888v = -1;
        this.f37889w = 0L;
        this.f37890x = new ArrayList();
        this.f37862C = null;
        this.f37863D = false;
        this.f37864E = false;
        this.f37865F = new AtomicBoolean(true);
        this.f37866G = false;
        e();
    }

    private boolean a(int i10) {
        HardwareBuffer hardwareBuffer;
        Bitmap bitmap;
        if (!this.f37870d.b() || this.f37869c.get()) {
            return false;
        }
        b();
        j();
        Bitmap bitmap2 = (Bitmap) this.f37878l.get(Integer.valueOf(i10));
        if (bitmap2 != null) {
            this.f37872f = bitmap2;
            return true;
        }
        if (this.f37869c.get() || !this.f37870d.a()) {
            return false;
        }
        if (!this.f37864E && !this.f37870d.a(i10)) {
            return true;
        }
        synchronized (this.f37871e) {
            try {
                if (this.f37873g == null || this.f37884r) {
                    Pair pairA = a.a(this.f37870d.f37911a, this.f37870d.f37912b, false);
                    Object obj = pairA.first;
                    if (obj == null) {
                        return false;
                    }
                    this.f37873g = (Bitmap) obj;
                    this.f37874h = (HardwareBuffer) pairA.second;
                }
                if (this.f37873g == null) {
                    return false;
                }
                if (!this.f37884r) {
                    if (this.f37875i == null) {
                        Pair pairA2 = a.a(this.f37870d.f37911a, this.f37870d.f37912b, false);
                        if (pairA2.first == null) {
                            return false;
                        }
                        this.f37876j = (HardwareBuffer) pairA2.second;
                        this.f37875i = (Bitmap) pairA2.first;
                    }
                    if (this.f37865F.get()) {
                        bitmap = this.f37873g;
                        hardwareBuffer = this.f37874h;
                    } else {
                        bitmap = this.f37875i;
                        hardwareBuffer = this.f37876j;
                    }
                    this.f37865F.set(!r5.get());
                } else {
                    hardwareBuffer = this.f37874h;
                    bitmap = this.f37873g;
                }
                if (hardwareBuffer != null) {
                    if (!this.f37870d.a(i10, hardwareBuffer)) {
                        return false;
                    }
                } else {
                    if (!this.f37870d.a(bitmap, i10)) {
                        return false;
                    }
                    bitmap.prepareToDraw();
                }
                this.f37872f = bitmap;
                if (this.f37884r && this.f37872f != null) {
                    this.f37878l.put(Integer.valueOf(i10), this.f37872f);
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PAGImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37868b = 30.0f;
        this.f37869c = new AtomicBoolean(false);
        this.f37870d = new c.a();
        this.f37871e = new Object();
        this.f37878l = new ConcurrentHashMap();
        this.f37881o = 2;
        this.f37883q = 1.0f;
        this.f37884r = false;
        this.f37885s = false;
        this.f37887u = 0;
        this.f37888v = -1;
        this.f37889w = 0L;
        this.f37890x = new ArrayList();
        this.f37862C = null;
        this.f37863D = false;
        this.f37864E = false;
        this.f37865F = new AtomicBoolean(true);
        this.f37866G = false;
        e();
    }
}
