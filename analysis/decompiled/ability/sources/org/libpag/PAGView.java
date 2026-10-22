package org.libpag;

import A4.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.TextureView;
import java.util.ArrayList;
import java.util.Iterator;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;

/* loaded from: classes4.dex */
public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, PAGAnimator.Listener {

    /* renamed from: a, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f5505a;
    private PAGPlayer b;
    private PAGSurface c;
    private PAGAnimator d;
    private String e;
    private boolean f;
    private EGLContext g;
    private final Object h;
    private ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList f5506j;
    private boolean k;

    @Deprecated
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

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zIsOpaque = PAGView.this.isOpaque();
            PAGView.this.setOpaque(!zIsOpaque);
            PAGView.this.setOpaque(zIsOpaque);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SurfaceTexture f5508a;

        public b(SurfaceTexture surfaceTexture) {
            this.f5508a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5508a.release();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (PAGView.this) {
                arrayList = new ArrayList(PAGView.this.f5506j);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGFlushListener) it.next()).onFlush();
            }
        }
    }

    public PAGView(Context context) {
        super(context);
        this.e = "";
        this.f = false;
        this.g = null;
        this.h = new Object();
        this.i = new ArrayList();
        this.f5506j = new ArrayList();
        this.k = false;
        b();
    }

    private void b() {
        setOpaque(false);
        this.b = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.d = PAGAnimator.a(getContext(), this);
    }

    private void c() {
        post(new a());
    }

    public void addListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.i.add(pAGViewListener);
        }
    }

    @Deprecated
    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f5506j.add(pAGFlushListener);
        }
    }

    public boolean cacheEnabled() {
        return this.b.cacheEnabled();
    }

    public float cacheScale() {
        return this.b.cacheScale();
    }

    public long currentFrame() {
        return this.b.currentFrame();
    }

    public long duration() {
        return this.b.duration();
    }

    public boolean flush() {
        return this.b.flush();
    }

    public void freeCache() {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
    }

    public RectF getBounds(PAGLayer pAGLayer) {
        return pAGLayer != null ? this.b.getBounds(pAGLayer) : new RectF();
    }

    public PAGComposition getComposition() {
        return this.b.getComposition();
    }

    public PAGLayer[] getLayersUnderPoint(float f, float f7) {
        return this.b.getLayersUnderPoint(f, f7);
    }

    public String getPath() {
        return this.e;
    }

    public double getProgress() {
        return this.b.getProgress();
    }

    public boolean isPlaying() {
        return this.d.isRunning();
    }

    public boolean isSync() {
        return this.d.isSync();
    }

    public Bitmap makeSnapshot() {
        PAGSurface pAGSurface = this.c;
        if (pAGSurface != null) {
            return pAGSurface.makeSnapshot();
        }
        return null;
    }

    public Matrix matrix() {
        return this.b.matrix();
    }

    public float maxFrameRate() {
        return this.b.maxFrameRate();
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.i);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationCancel(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationEnd(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.i);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationEnd(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationRepeat(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.i);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationRepeat(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationStart(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.i);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this.h) {
            try {
                if (this.f) {
                    this.b.setProgress(pAGAnimator.progress());
                    if (this.k) {
                        pAGAnimator.setDuration(this.b.duration());
                    }
                    boolean zFlush = flush();
                    if (zFlush) {
                        c();
                    }
                    synchronized (this) {
                        arrayList = new ArrayList(this.i);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationUpdate(this);
                    }
                    if (this.f5506j.isEmpty()) {
                        return;
                    }
                    post(new c());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void onAttachedToWindow() {
        synchronized (this.h) {
            this.f = true;
        }
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        synchronized (this.h) {
            this.f = false;
        }
        a();
        super.onDetachedFromWindow();
        synchronized (this.h) {
            try {
                this.b.setSurface(null);
                PAGSurface pAGSurface = this.c;
                if (pAGSurface != null) {
                    pAGSurface.release();
                    this.c = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i6) {
        synchronized (this.h) {
            try {
                PAGSurface pAGSurface = this.c;
                if (pAGSurface != null) {
                    pAGSurface.release();
                    this.c = null;
                }
                PAGSurface pAGSurfaceFromSurfaceTexture = PAGSurface.FromSurfaceTexture(surfaceTexture, this.g);
                this.c = pAGSurfaceFromSurfaceTexture;
                this.b.setSurface(pAGSurfaceFromSurfaceTexture);
                PAGSurface pAGSurface2 = this.c;
                if (pAGSurface2 != null) {
                    pAGSurface2.clearAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.c == null) {
            return;
        }
        this.d.update();
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f5505a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i6);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        synchronized (this.h) {
            try {
                this.b.setSurface(null);
                PAGSurface pAGSurface = this.c;
                if (pAGSurface != null) {
                    pAGSurface.freeCache();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f5505a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        post(new b(surfaceTexture));
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i6) {
        synchronized (this.h) {
            try {
                PAGSurface pAGSurface = this.c;
                if (pAGSurface != null) {
                    pAGSurface.updateSize();
                    this.c.clearAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.c != null) {
            this.d.update();
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f5505a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i6);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f5505a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        a();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0 && this.k) {
            setVisibility(4);
            setVisibility(0);
        }
    }

    public void pause() {
        this.d.cancel();
    }

    public void play() {
        this.b.prepare();
        this.d.a();
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.i.remove(pAGViewListener);
        }
    }

    @Deprecated
    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f5506j.remove(pAGFlushListener);
        }
    }

    public int repeatCount() {
        return this.d.repeatCount();
    }

    public int scaleMode() {
        return this.b.scaleMode();
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setCacheEnabled(boolean z10) {
        this.b.setCacheEnabled(z10);
    }

    public void setCacheScale(float f) {
        this.b.setCacheScale(f);
    }

    public void setComposition(PAGComposition pAGComposition) {
        this.e = null;
        this.b.setComposition(pAGComposition);
        this.d.setProgress(this.b.getProgress());
        if (this.k) {
            this.d.setDuration(this.b.duration());
        }
    }

    public void setMatrix(Matrix matrix) {
        this.b.setMatrix(matrix);
    }

    public void setMaxFrameRate(float f) {
        this.b.setMaxFrameRate(f);
    }

    public boolean setPath(String str) {
        PAGFile pAGFileLoad = (str == null || !str.startsWith("assets://")) ? PAGFile.Load(str) : PAGFile.Load(getContext().getAssets(), str.substring(9));
        setComposition(pAGFileLoad);
        this.e = str;
        return pAGFileLoad != null;
    }

    public void setPathAsync(String str, PAGFile.LoadListener loadListener) {
        NativeTask.Run(new e(11, str, this, loadListener));
    }

    public void setProgress(double d) {
        this.b.setProgress(d);
        this.d.setProgress(this.b.getProgress());
        this.d.update();
    }

    public void setRepeatCount(int i) {
        this.d.setRepeatCount(i);
    }

    public void setScaleMode(int i) {
        this.b.setScaleMode(i);
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
        } else {
            this.f5505a = surfaceTextureListener;
        }
    }

    public void setSync(boolean z10) {
        this.d.setSync(z10);
    }

    public void setUseDiskCache(boolean z10) {
        this.b.setUseDiskCache(z10);
    }

    public void setVideoEnabled(boolean z10) {
        this.b.setVideoEnabled(z10);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a();
    }

    public void stop() {
        this.d.cancel();
    }

    public boolean useDiskCache() {
        return this.b.useDiskCache();
    }

    public boolean videoEnabled() {
        return this.b.videoEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, PAGFile.LoadListener loadListener) {
        setPath(str);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.b.getComposition());
        }
    }

    private void a() {
        boolean z10;
        synchronized (this.h) {
            z10 = this.f;
        }
        boolean z11 = z10 && isShown();
        synchronized (this.h) {
            try {
                if (this.k == z11) {
                    return;
                }
                this.k = z11;
                if (z11) {
                    this.d.setDuration(this.b.duration());
                    this.d.update();
                } else {
                    this.d.setDuration(0L);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        this.e = "";
        this.f = false;
        this.g = null;
        this.h = new Object();
        this.i = new ArrayList();
        this.f5506j = new ArrayList();
        this.k = false;
        this.g = eGLContext;
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = "";
        this.f = false;
        this.g = null;
        this.h = new Object();
        this.i = new ArrayList();
        this.f5506j = new ArrayList();
        this.k = false;
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = "";
        this.f = false;
        this.g = null;
        this.h = new Object();
        this.i = new ArrayList();
        this.f5506j = new ArrayList();
        this.k = false;
        b();
    }
}
