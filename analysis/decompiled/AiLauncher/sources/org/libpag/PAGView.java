package org.libpag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.opengl.EGLContext;
import android.util.AttributeSet;
import android.view.TextureView;
import gc.C4116b;
import java.util.ArrayList;
import java.util.Iterator;
import org.libpag.PAGAnimator;
import org.libpag.PAGFile;

/* loaded from: classes5.dex */
public class PAGView extends TextureView implements TextureView.SurfaceTextureListener, gc.d, PAGAnimator.Listener {

    /* renamed from: a, reason: collision with root package name */
    private TextureView.SurfaceTextureListener f37897a;

    /* renamed from: b, reason: collision with root package name */
    private PAGPlayer f37898b;

    /* renamed from: c, reason: collision with root package name */
    private PAGSurface f37899c;

    /* renamed from: d, reason: collision with root package name */
    private PAGAnimator f37900d;

    /* renamed from: e, reason: collision with root package name */
    private String f37901e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f37902f;

    /* renamed from: g, reason: collision with root package name */
    private EGLContext f37903g;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList f37904h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f37905i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f37906j;

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
        final /* synthetic */ SurfaceTexture f37908a;

        public b(SurfaceTexture surfaceTexture) {
            this.f37908a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f37908a.release();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList;
            synchronized (PAGView.this) {
                arrayList = new ArrayList(PAGView.this.f37905i);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((PAGFlushListener) it.next()).onFlush();
            }
        }
    }

    public PAGView(Context context) {
        super(context);
        this.f37901e = "";
        this.f37902f = false;
        this.f37903g = null;
        this.f37904h = new ArrayList();
        this.f37905i = new ArrayList();
        this.f37906j = false;
        b();
    }

    private void b() {
        C4116b.a().b(this);
        setOpaque(false);
        this.f37898b = new PAGPlayer();
        setSurfaceTextureListener(this);
        this.f37900d = PAGAnimator.a(getContext(), this);
    }

    private void c() {
        post(new a());
    }

    public void addListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f37904h.add(pAGViewListener);
        }
    }

    @Deprecated
    public void addPAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f37905i.add(pAGFlushListener);
        }
    }

    public boolean cacheEnabled() {
        return this.f37898b.cacheEnabled();
    }

    public float cacheScale() {
        return this.f37898b.cacheScale();
    }

    public long currentFrame() {
        return this.f37898b.currentFrame();
    }

    public long duration() {
        return this.f37898b.duration();
    }

    public boolean flush() {
        return this.f37898b.flush();
    }

    public void freeCache() {
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
    }

    public RectF getBounds(PAGLayer pAGLayer) {
        return pAGLayer != null ? this.f37898b.getBounds(pAGLayer) : new RectF();
    }

    public PAGComposition getComposition() {
        return this.f37898b.getComposition();
    }

    public PAGLayer[] getLayersUnderPoint(float f10, float f11) {
        return this.f37898b.getLayersUnderPoint(f10, f11);
    }

    public String getPath() {
        return this.f37901e;
    }

    public double getProgress() {
        return this.f37898b.getProgress();
    }

    public boolean isPlaying() {
        return this.f37900d.isRunning();
    }

    public boolean isSync() {
        return this.f37900d.isSync();
    }

    public Bitmap makeSnapshot() {
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            return pAGSurface.makeSnapshot();
        }
        return null;
    }

    public Matrix matrix() {
        return this.f37898b.matrix();
    }

    public float maxFrameRate() {
        return this.f37898b.maxFrameRate();
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationCancel(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.f37904h);
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
            arrayList = new ArrayList(this.f37904h);
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
            arrayList = new ArrayList(this.f37904h);
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
            arrayList = new ArrayList(this.f37904h);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((PAGViewListener) it.next()).onAnimationStart(this);
        }
    }

    @Override // org.libpag.PAGAnimator.Listener
    public void onAnimationUpdate(PAGAnimator pAGAnimator) {
        ArrayList arrayList;
        this.f37898b.setProgress(pAGAnimator.progress());
        synchronized (this) {
            try {
                if (this.f37902f) {
                    if (this.f37906j) {
                        pAGAnimator.setDuration(this.f37898b.duration());
                    }
                    if (flush()) {
                        c();
                    }
                    synchronized (this) {
                        arrayList = new ArrayList(this.f37904h);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((PAGViewListener) it.next()).onAnimationUpdate(this);
                    }
                    if (this.f37905i.isEmpty()) {
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
        this.f37902f = true;
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.f37902f = false;
        super.onDetachedFromWindow();
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f37899c = null;
        }
        a();
    }

    @Override // gc.d
    public void onResume() {
        if (this.f37906j) {
            setVisibility(4);
            setVisibility(0);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            pAGSurface.release();
            this.f37899c = null;
        }
        PAGSurface pAGSurfaceFromSurfaceTexture = PAGSurface.FromSurfaceTexture(surfaceTexture, this.f37903g);
        this.f37899c = pAGSurfaceFromSurfaceTexture;
        this.f37898b.setSurface(pAGSurfaceFromSurfaceTexture);
        PAGSurface pAGSurface2 = this.f37899c;
        if (pAGSurface2 == null) {
            return;
        }
        pAGSurface2.clearAll();
        this.f37900d.update();
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f37897a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i10, i11);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f37898b.setSurface(null);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f37897a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            pAGSurface.freeCache();
        }
        post(new b(surfaceTexture));
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
        PAGSurface pAGSurface = this.f37899c;
        if (pAGSurface != null) {
            pAGSurface.updateSize();
            this.f37899c.clearAll();
            this.f37900d.update();
        }
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f37897a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i10, i11);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.f37897a;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        a();
    }

    public void pause() {
        this.f37900d.cancel();
    }

    public void play() {
        this.f37898b.prepare();
        this.f37900d.a();
    }

    public void removeListener(PAGViewListener pAGViewListener) {
        synchronized (this) {
            this.f37904h.remove(pAGViewListener);
        }
    }

    @Deprecated
    public void removePAGFlushListener(PAGFlushListener pAGFlushListener) {
        synchronized (this) {
            this.f37905i.remove(pAGFlushListener);
        }
    }

    public int repeatCount() {
        return this.f37900d.repeatCount();
    }

    public int scaleMode() {
        return this.f37898b.scaleMode();
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setCacheEnabled(boolean z10) {
        this.f37898b.setCacheEnabled(z10);
    }

    public void setCacheScale(float f10) {
        this.f37898b.setCacheScale(f10);
    }

    public void setComposition(PAGComposition pAGComposition) {
        this.f37901e = null;
        this.f37898b.setComposition(pAGComposition);
        this.f37900d.setProgress(this.f37898b.getProgress());
        if (this.f37906j) {
            this.f37900d.setDuration(this.f37898b.duration());
        }
    }

    public void setMatrix(Matrix matrix) {
        this.f37898b.setMatrix(matrix);
    }

    public void setMaxFrameRate(float f10) {
        this.f37898b.setMaxFrameRate(f10);
    }

    public boolean setPath(String str) {
        PAGFile pAGFileLoad = (str == null || !str.startsWith("assets://")) ? PAGFile.Load(str) : PAGFile.Load(getContext().getAssets(), str.substring(9));
        setComposition(pAGFileLoad);
        this.f37901e = str;
        return pAGFileLoad != null;
    }

    public void setPathAsync(final String str, final PAGFile.LoadListener loadListener) {
        NativeTask.Run(new Runnable() { // from class: org.libpag.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f37924a.a(str, loadListener);
            }
        });
    }

    public void setProgress(double d10) {
        this.f37898b.setProgress(d10);
        this.f37900d.setProgress(this.f37898b.getProgress());
        this.f37900d.update();
    }

    public void setRepeatCount(int i10) {
        this.f37900d.setRepeatCount(i10);
    }

    public void setScaleMode(int i10) {
        this.f37898b.setScaleMode(i10);
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        if (surfaceTextureListener == this) {
            super.setSurfaceTextureListener(surfaceTextureListener);
        } else {
            this.f37897a = surfaceTextureListener;
        }
    }

    public void setSync(boolean z10) {
        this.f37900d.setSync(z10);
    }

    public void setUseDiskCache(boolean z10) {
        this.f37898b.setUseDiskCache(z10);
    }

    public void setVideoEnabled(boolean z10) {
        this.f37898b.setVideoEnabled(z10);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        a();
    }

    public void stop() {
        this.f37900d.cancel();
    }

    public boolean useDiskCache() {
        return this.f37898b.useDiskCache();
    }

    public boolean videoEnabled() {
        return this.f37898b.videoEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, PAGFile.LoadListener loadListener) {
        setPath(str);
        if (loadListener != null) {
            loadListener.onLoad((PAGFile) this.f37898b.getComposition());
        }
    }

    private void a() {
        boolean z10 = this.f37902f && isShown();
        if (this.f37906j == z10) {
            return;
        }
        this.f37906j = z10;
        if (z10) {
            this.f37900d.setDuration(this.f37898b.duration());
            this.f37900d.update();
        } else {
            this.f37900d.setDuration(0L);
        }
    }

    public PAGView(Context context, EGLContext eGLContext) {
        super(context);
        this.f37901e = "";
        this.f37902f = false;
        this.f37903g = null;
        this.f37904h = new ArrayList();
        this.f37905i = new ArrayList();
        this.f37906j = false;
        this.f37903g = eGLContext;
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37901e = "";
        this.f37902f = false;
        this.f37903g = null;
        this.f37904h = new ArrayList();
        this.f37905i = new ArrayList();
        this.f37906j = false;
        b();
    }

    public PAGView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f37901e = "";
        this.f37902f = false;
        this.f37903g = null;
        this.f37904h = new ArrayList();
        this.f37905i = new ArrayList();
        this.f37906j = false;
        b();
    }
}
