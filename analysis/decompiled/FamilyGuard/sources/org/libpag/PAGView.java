package org.libpag;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.TextureView;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, P4.d {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f19190a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static a f19191b;

    /* renamed from: c, reason: collision with root package name */
    private static HandlerThread f19192c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f19193d;

    /* renamed from: A, reason: collision with root package name */
    private Runnable f19194A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f19195B;

    /* renamed from: e, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f19196e;

    /* renamed from: f, reason: collision with root package name */
    private PAGPlayer f19197f;

    /* renamed from: g, reason: collision with root package name */
    private PAGSurface f19198g;

    /* renamed from: h, reason: collision with root package name */
    private PAGFile f19199h;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f19200i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f19201j;

    /* renamed from: k, reason: collision with root package name */
    private volatile Boolean f19202k;

    /* renamed from: l, reason: collision with root package name */
    private String f19203l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f19204m;

    /* renamed from: n, reason: collision with root package name */
    private EGLContext f19205n;

    /* renamed from: o, reason: collision with root package name */
    private SparseArray<PAGText> f19206o;

    /* renamed from: p, reason: collision with root package name */
    private SparseArray<PAGImage> f19207p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f19208q;

    /* renamed from: r, reason: collision with root package name */
    private volatile boolean f19209r;

    /* renamed from: s, reason: collision with root package name */
    private final Object f19210s;

    /* renamed from: t, reason: collision with root package name */
    private float f19211t;

    /* renamed from: u, reason: collision with root package name */
    private ArrayList<PAGViewListener> f19212u;

    /* renamed from: v, reason: collision with root package name */
    private ArrayList<PAGFlushListener> f19213v;

    /* renamed from: w, reason: collision with root package name */
    private volatile long f19214w;

    /* renamed from: x, reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f19215x;

    /* renamed from: y, reason: collision with root package name */
    private final AnimatorListenerAdapter f19216y;

    /* renamed from: z, reason: collision with root package name */
    private Runnable f19217z;

    public interface PAGFlushListener {
        void onFlush();
    }

    public interface PAGViewListener {
        void onAnimationCancel(PAGView pAGView);

        void onAnimationEnd(PAGView pAGView);

        void onAnimationRepeat(PAGView pAGView);

        void onAnimationStart(PAGView pAGView);

        void onAnimationUpdate(PAGView pAGView);
    }

    static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final Object f19218a;

        /* renamed from: b, reason: collision with root package name */
        private List<PAGView> f19219b;

        a(Looper looper) {
            super(looper);
            this.f19218a = new Object();
            this.f19219b = new ArrayList();
        }

        void a(PAGView pAGView) {
            synchronized (this.f19218a) {
                try {
                    if (this.f19219b.isEmpty()) {
                        Message messageObtainMessage = obtainMessage();
                        messageObtainMessage.arg1 = 0;
                        sendMessage(messageObtainMessage);
                    }
                    this.f19219b.add(pAGView);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ArrayList arrayList;
            super.handleMessage(message);
            int i5 = message.arg1;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        return;
                    }
                    new Handler(Looper.getMainLooper()).post(new s(this));
                    return;
                } else {
                    Object obj = message.obj;
                    if (obj instanceof SurfaceTexture) {
                        ((SurfaceTexture) obj).release();
                        return;
                    }
                    return;
                }
            }
            synchronized (this.f19218a) {
                arrayList = new ArrayList(this.f19219b);
                this.f19219b.clear();
            }
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj2 = arrayList.get(i6);
                i6++;
                if (obj2 instanceof PAGView) {
                    PAGView pAGView = (PAGView) obj2;
                    if (!arrayList2.contains(pAGView)) {
                        pAGView.n();
                        arrayList2.add(pAGView);
                    }
                }
            }
        }
    }

    public PAGView(Context context) {
        super(context);
        this.f19201j = false;
        this.f19202k = null;
        this.f19203l = BuildConfig.FLAVOR;
        this.f19204m = false;
        this.f19205n = null;
        this.f19206o = new SparseArray<>();
        this.f19207p = new SparseArray<>();
        this.f19208q = false;
        this.f19209r = true;
        this.f19210s = new Object();
        this.f19211t = 1.0f;
        this.f19212u = new ArrayList<>();
        this.f19213v = new ArrayList<>();
        this.f19215x = new m(this);
        this.f19216y = new n(this);
        this.f19217z = new q(this);
        this.f19194A = new RunnableC0904r(this);
        this.f19195B = true;
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(PAGView pAGView) {
        if (pAGView.f19208q) {
            pAGView.n();
            return;
        }
        a aVar = f19191b;
        if (aVar == null) {
            return;
        }
        aVar.a(pAGView);
    }

    private void j() {
        if (this.f19201j && !this.f19200i.isRunning() && (this.f19202k == null || this.f19202k.booleanValue())) {
            this.f19202k = null;
            f();
        } else {
            this.f19202k = null;
            m();
        }
    }

    private void k() {
        P4.b.a().b(this);
        setOpaque(false);
        this.f19197f = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.f19211t = getAnimationScale(getContext());
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f19200i = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setRepeatCount(0);
        this.f19200i.setInterpolator(new LinearInterpolator());
    }

    private void l() {
        if (this.f19200i.getDuration() <= 0) {
            return;
        }
        if (g()) {
            this.f19200i.start();
        } else {
            removeCallbacks(this.f19194A);
            post(this.f19217z);
        }
    }

    private void m() {
        post(new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f19204m) {
            flush();
            m();
            if (this.f19213v.isEmpty()) {
                return;
            }
            post(new p(this));
        }
    }

    public void addListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f19212u.add(pAGViewListener);
        }
    }

    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f19213v.add(pAGFlushListener);
        }
    }

    public boolean cacheEnabled() {
        return this.f19197f.cacheEnabled();
    }

    public float cacheScale() {
        return this.f19197f.cacheScale();
    }

    public long currentFrame() {
        return this.f19197f.currentFrame();
    }

    public long duration() {
        return this.f19197f.duration();
    }

    public boolean flush() {
        int i5;
        boolean zFlush;
        ArrayList arrayList;
        if (this.f19198g == null) {
            return this.f19197f.flush();
        }
        synchronized (this.f19210s) {
            try {
                i5 = 0;
                if (this.f19209r) {
                    zFlush = this.f19197f.flush();
                    long progress = (long) ((this.f19197f.getProgress() * this.f19197f.duration()) / 1000.0d);
                    this.f19209r = false;
                    this.f19200i.setCurrentPlayTime(progress);
                } else {
                    this.f19197f.setProgress(this.f19200i.getAnimatedFraction());
                    zFlush = this.f19197f.flush();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f19212u);
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGViewListener) obj).onAnimationUpdate(this);
        }
        return zFlush;
    }

    public void freeCache() {
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
    }

    public float getAnimationScale(Context context) {
        return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
    }

    public PAGComposition getComposition() {
        return this.f19197f.getComposition();
    }

    public PAGLayer[] getLayersUnderPoint(float f5, float f6) {
        return this.f19197f.getLayersUnderPoint(f5, f6);
    }

    public String getPath() {
        return this.f19203l;
    }

    public double getProgress() {
        return this.f19197f.getProgress();
    }

    public boolean isPlaying() {
        ValueAnimator valueAnimator = this.f19200i;
        if (valueAnimator != null) {
            return valueAnimator.isRunning();
        }
        return false;
    }

    public boolean isSync() {
        return this.f19208q;
    }

    public Bitmap makeSnapshot() {
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            return pAGSurface.makeSnapshot();
        }
        return null;
    }

    public Matrix matrix() {
        return this.f19197f.matrix();
    }

    public float maxFrameRate() {
        return this.f19197f.maxFrameRate();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        this.f19204m = true;
        super.onAttachedToWindow();
        this.f19200i.addUpdateListener(this.f19215x);
        this.f19200i.addListener(this.f19216y);
        synchronized (f19190a) {
            d();
        }
        j();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f19204m = false;
        super.onDetachedFromWindow();
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f19198g = null;
        }
        i();
        this.f19200i.removeUpdateListener(this.f19215x);
        this.f19200i.removeListener(this.f19216y);
    }

    @Override // P4.d
    public void onResume() {
        if (this.f19204m && getVisibility() == 0) {
            setVisibility(4);
            setVisibility(0);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i5, int i6) {
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f19198g = null;
        }
        PAGSurface pAGSurfaceFromSurfaceTexture = PAGSurface.FromSurfaceTexture(surfaceTexture, this.f19205n);
        this.f19198g = pAGSurfaceFromSurfaceTexture;
        this.f19197f.setSurface(pAGSurfaceFromSurfaceTexture);
        PAGSurface pAGSurface2 = this.f19198g;
        if (pAGSurface2 == null) {
            return;
        }
        pAGSurface2.clearAll();
        i(this);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f19196e;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i5, i6);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f19197f.setSurface(null);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f19196e;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        boolean z5 = true;
        if (f19191b != null && surfaceTexture != null) {
            a(1, surfaceTexture);
            z5 = false;
        }
        synchronized (f19190a) {
            b();
        }
        return z5;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i5, int i6) {
        PAGSurface pAGSurface = this.f19198g;
        if (pAGSurface != null) {
            pAGSurface.updateSize();
            this.f19198g.clearAll();
            i(this);
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f19196e;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i5, i6);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f19196e;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z5) {
        super.onVisibilityAggregated(z5);
        if (this.f19195B == z5) {
            return;
        }
        this.f19195B = z5;
        Log.i("PAGView", "onVisibilityAggregated isVisible=" + z5);
        if (z5) {
            j();
        } else {
            i();
        }
    }

    public void play() {
        this.f19201j = true;
        this.f19202k = null;
        if (this.f19200i.getAnimatedFraction() == 1.0d) {
            setProgress(0.0d);
        }
        f();
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f19212u.remove(pAGViewListener);
        }
    }

    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f19213v.remove(pAGFlushListener);
        }
    }

    public int scaleMode() {
        return this.f19197f.scaleMode();
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setCacheEnabled(boolean z5) {
        this.f19197f.setCacheEnabled(z5);
    }

    public void setCacheScale(float f5) {
        this.f19197f.setCacheScale(f5);
    }

    public void setComposition(PAGComposition pAGComposition) {
        this.f19203l = null;
        this.f19199h = null;
        this.f19197f.setComposition(pAGComposition);
        this.f19209r = true;
        this.f19200i.setDuration(this.f19197f.duration() / 1000);
        this.f19200i.setCurrentPlayTime(0L);
    }

    public void setMatrix(Matrix matrix) {
        this.f19197f.setMatrix(matrix);
    }

    public void setMaxFrameRate(float f5) {
        this.f19197f.setMaxFrameRate(f5);
    }

    public boolean setPath(String str) {
        PAGFile pAGFileLoad = (str == null || !str.startsWith("assets://")) ? PAGFile.Load(str) : PAGFile.Load(getContext().getAssets(), str.substring(9));
        setComposition(pAGFileLoad);
        this.f19203l = str;
        return pAGFileLoad != null;
    }

    public void setProgress(double d6) {
        synchronized (this.f19210s) {
            this.f19197f.setProgress(d6);
            this.f19209r = true;
        }
        i(this);
    }

    public void setRepeatCount(int i5) {
        if (i5 < 0) {
            i5 = 0;
        }
        this.f19200i.setRepeatCount(i5 - 1);
    }

    public void setScaleMode(int i5) {
        this.f19197f.setScaleMode(i5);
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
        } else {
            this.f19196e = surfaceTextureListener;
        }
    }

    public void setSync(boolean z5) {
        this.f19208q = z5;
    }

    public void setVideoEnabled(boolean z5) {
        this.f19197f.setVideoEnabled(z5);
    }

    public void stop() {
        Log.i("PAGView", "stop");
        this.f19201j = false;
        this.f19202k = null;
        e();
    }

    public boolean videoEnabled() {
        return this.f19197f.videoEnabled();
    }

    private static synchronized void b() {
        HandlerThread handlerThread;
        f19193d--;
        if (f19193d != 0) {
            return;
        }
        if (f19191b != null && (handlerThread = f19192c) != null) {
            if (handlerThread.isAlive()) {
                a(2, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        HandlerThread handlerThread;
        if (f19193d == 0 && f19191b != null && (handlerThread = f19192c) != null && handlerThread.isAlive()) {
            f19191b.removeCallbacksAndMessages(null);
            f19192c.quitSafely();
            f19192c = null;
            f19191b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: all -> 0x001a, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000d, B:7:0x0016, B:12:0x001d, B:13:0x0023, B:15:0x0027), top: B:20:0x0003, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static synchronized void d() {
        /*
            java.lang.Class<org.libpag.PAGView> r0 = org.libpag.PAGView.class
            monitor-enter(r0)
            int r1 = org.libpag.PAGView.f19193d     // Catch: java.lang.Throwable -> L1a
            int r1 = r1 + 1
            org.libpag.PAGView.f19193d = r1     // Catch: java.lang.Throwable -> L1a
            android.os.HandlerThread r1 = org.libpag.PAGView.f19192c     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L23
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L1a
            java.lang.String r2 = "pag-renderer"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            org.libpag.PAGView.f19192c = r1     // Catch: java.lang.Throwable -> L1a
            r1.start()     // Catch: java.lang.Throwable -> L1a java.lang.Throwable -> L1c
            goto L23
        L1a:
            r1 = move-exception
            goto L36
        L1c:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L1a
            r1 = 0
            org.libpag.PAGView.f19192c = r1     // Catch: java.lang.Throwable -> L1a
        L23:
            org.libpag.PAGView$a r1 = org.libpag.PAGView.f19191b     // Catch: java.lang.Throwable -> L1a
            if (r1 != 0) goto L34
            org.libpag.PAGView$a r1 = new org.libpag.PAGView$a     // Catch: java.lang.Throwable -> L1a
            android.os.HandlerThread r2 = org.libpag.PAGView.f19192c     // Catch: java.lang.Throwable -> L1a
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L1a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1a
            org.libpag.PAGView.f19191b = r1     // Catch: java.lang.Throwable -> L1a
        L34:
            monitor-exit(r0)
            return
        L36:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1a
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.libpag.PAGView.d():void");
    }

    private void e() {
        if (g()) {
            this.f19214w = this.f19200i.getCurrentPlayTime();
            this.f19200i.cancel();
        } else {
            removeCallbacks(this.f19217z);
            post(this.f19194A);
        }
    }

    private void f() {
        this.f19197f.prepare();
        if (!this.f19204m) {
            Log.w("PAGView", "doPlay: PAGView is not attached to window");
            return;
        }
        Log.i("PAGView", "doPlay");
        if (this.f19211t == 0.0f) {
            h();
            Log.e("PAGView", "doPlay: The scale of animator duration is turned off");
        } else {
            this.f19200i.setCurrentPlayTime(this.f19214w);
            l();
        }
    }

    private boolean g() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ArrayList arrayList;
        int i5 = 0;
        this.f19201j = false;
        synchronized (this) {
            arrayList = new ArrayList(this.f19212u);
        }
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((PAGViewListener) obj).onAnimationEnd(this);
        }
    }

    private static void a(int i5, Object obj) {
        a aVar = f19191b;
        if (aVar == null) {
            return;
        }
        Message messageObtainMessage = aVar.obtainMessage();
        messageObtainMessage.arg1 = i5;
        if (obj != null) {
            messageObtainMessage.obj = obj;
        }
        f19191b.sendMessage(messageObtainMessage);
    }

    private void i() {
        if (this.f19202k == null) {
            this.f19202k = Boolean.valueOf(this.f19200i.isRunning());
        }
        if (this.f19200i.isRunning()) {
            e();
        }
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        this.f19201j = false;
        this.f19202k = null;
        this.f19203l = BuildConfig.FLAVOR;
        this.f19204m = false;
        this.f19205n = null;
        this.f19206o = new SparseArray<>();
        this.f19207p = new SparseArray<>();
        this.f19208q = false;
        this.f19209r = true;
        this.f19210s = new Object();
        this.f19211t = 1.0f;
        this.f19212u = new ArrayList<>();
        this.f19213v = new ArrayList<>();
        this.f19215x = new m(this);
        this.f19216y = new n(this);
        this.f19217z = new q(this);
        this.f19194A = new RunnableC0904r(this);
        this.f19195B = true;
        this.f19205n = eGLContext;
        k();
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19201j = false;
        this.f19202k = null;
        this.f19203l = BuildConfig.FLAVOR;
        this.f19204m = false;
        this.f19205n = null;
        this.f19206o = new SparseArray<>();
        this.f19207p = new SparseArray<>();
        this.f19208q = false;
        this.f19209r = true;
        this.f19210s = new Object();
        this.f19211t = 1.0f;
        this.f19212u = new ArrayList<>();
        this.f19213v = new ArrayList<>();
        this.f19215x = new m(this);
        this.f19216y = new n(this);
        this.f19217z = new q(this);
        this.f19194A = new RunnableC0904r(this);
        this.f19195B = true;
        k();
    }

    public PAGView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f19201j = false;
        this.f19202k = null;
        this.f19203l = BuildConfig.FLAVOR;
        this.f19204m = false;
        this.f19205n = null;
        this.f19206o = new SparseArray<>();
        this.f19207p = new SparseArray<>();
        this.f19208q = false;
        this.f19209r = true;
        this.f19210s = new Object();
        this.f19211t = 1.0f;
        this.f19212u = new ArrayList<>();
        this.f19213v = new ArrayList<>();
        this.f19215x = new m(this);
        this.f19216y = new n(this);
        this.f19217z = new q(this);
        this.f19194A = new RunnableC0904r(this);
        this.f19195B = true;
        k();
    }
}
