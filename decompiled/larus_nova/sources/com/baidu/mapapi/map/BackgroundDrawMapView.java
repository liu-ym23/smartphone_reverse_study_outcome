package com.baidu.mapapi.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class BackgroundDrawMapView extends TextureView implements TextureView.SurfaceTextureListener {
    private static final int DEFAULT_FPS = 30;
    private static final int MAX_FPS = 60;
    private static final int MIN_FPS = 10;
    private MapController mController;
    private c mDrawThread;
    private final Object mDrawThreadLock;
    private volatile int mFps;
    private final AtomicBoolean mIsReady;
    private final List<IBackgroundDrawLayer> mLayers;
    private MapSurfaceView mMapSurfaceView;
    private MapTextureView mMapTextureView;

    public static class CanvasProxy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextureView f30662a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Canvas f30663b;

        public Canvas lockCanvas() {
            TextureView r100 = this.f30662a;
            if (r100 != null) goto L6;
            return null;
        L6:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L8;
            return null;
        L8:
            Canvas r101 = r100.lockCanvas();
            this.f30663b = r101;
            return r101;
        }

        public void restore() {
            TextureView r100 = this.f30662a;
            if (r100 != null) goto L5;
            return;
        L5:
            Canvas r101 = this.f30663b;
            if (r101 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r100.isAvailable() == false) goto L15;
            r101.restore();
            return;
        }

        public int save() {
            TextureView r100 = this.f30662a;
            if (r100 != null) goto L5;
            return -1;
        L5:
            Canvas r101 = this.f30663b;
            if (r101 != null) goto L9;
            return -1;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return -1;
        L12:
            if (r100.isAvailable() == true) goto L14;
            return -1;
        L14:
            return r101.save();
        }

        public CanvasProxy(TextureView r100) {
            this.f30662a = r100;
        }

        public void drawColor(int r100) {
            TextureView r101 = this.f30662a;
            if (r101 != null) goto L5;
            return;
        L5:
            Canvas r102 = this.f30663b;
            if (r102 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r101.isAvailable() == false) goto L15;
            r102.drawColor(r100);
            return;
        }

        public void rotate(float r100) {
            TextureView r101 = this.f30662a;
            if (r101 != null) goto L5;
            return;
        L5:
            Canvas r102 = this.f30663b;
            if (r102 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r101.isAvailable() == false) goto L15;
            r102.rotate(r100);
            return;
        }

        public void unlockCanvasAndPost(Canvas r100) {
            TextureView r101 = this.f30662a;
            if (r101 != null) goto L5;
            return;
        L5:
            if (r100 != null) goto L7;
            r100 = this.f30663b;
        L7:
            if (r100 != null) goto L10;
            return;
        L10:
            if (r100 == this.f30663b) goto L13;
            return;
        L13:
            if (r101.isAvailable() == false) goto L16;
            r101.unlockCanvasAndPost(r100);
            this.f30663b = null;
            return;
        }

        public void drawPath(Path r100, Paint r101) {
            TextureView r102 = this.f30662a;
            if (r102 != null) goto L5;
            return;
        L5:
            Canvas r103 = this.f30663b;
            if (r103 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r102.isAvailable() == false) goto L15;
            r103.drawPath(r100, r101);
            return;
        }

        public void scale(float r100, float r101) {
            TextureView r102 = this.f30662a;
            if (r102 != null) goto L5;
            return;
        L5:
            Canvas r103 = this.f30663b;
            if (r103 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r102.isAvailable() == false) goto L15;
            r103.scale(r100, r101);
            return;
        }

        public void translate(float r100, float r101) {
            TextureView r102 = this.f30662a;
            if (r102 != null) goto L5;
            return;
        L5:
            Canvas r103 = this.f30663b;
            if (r103 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r102.isAvailable() == false) goto L15;
            r103.translate(r100, r101);
            return;
        }

        public void drawPoint(float r100, float r101, Paint r102) {
            TextureView r103 = this.f30662a;
            if (r103 != null) goto L5;
            return;
        L5:
            Canvas r104 = this.f30663b;
            if (r104 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r103.isAvailable() == false) goto L15;
            r104.drawPoint(r100, r101, r102);
            return;
        }

        public void rotate(float r100, float r101, float r102) {
            TextureView r103 = this.f30662a;
            if (r103 != null) goto L5;
            return;
        L5:
            Canvas r104 = this.f30663b;
            if (r104 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r103.isAvailable() == false) goto L15;
            r104.rotate(r100, r101, r102);
            return;
        }

        public void drawBitmap(Bitmap r100, float r101, float r102, Paint r103) {
            TextureView r104 = this.f30662a;
            if (r104 != null) goto L5;
            return;
        L5:
            Canvas r105 = this.f30663b;
            if (r105 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r104.isAvailable() == false) goto L15;
            r105.drawBitmap(r100, r101, r102, r103);
            return;
        }

        public void scale(float r100, float r101, float r102, float r103) {
            TextureView r104 = this.f30662a;
            if (r104 != null) goto L5;
            return;
        L5:
            Canvas r105 = this.f30663b;
            if (r105 != null) goto L9;
            return;
        L9:
            if (ThreadMethodProxy.currentThread().isInterrupted() == false) goto L12;
            return;
        L12:
            if (r104.isAvailable() == false) goto L15;
            r105.scale(r100, r101, r102, r103);
            return;
        }
    }

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BackgroundDrawMapView f30664a;

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
        }

        public a(BackgroundDrawMapView r100) {
            this.f30664a = r100;
        }
    }

    public class b implements Comparator<IBackgroundDrawLayer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BackgroundDrawMapView f30665a;

        public b(BackgroundDrawMapView r100) {
            this.f30665a = r100;
        }

        public int a(IBackgroundDrawLayer r100, IBackgroundDrawLayer r101) {
            boolean r102 = r100 instanceof BaseBackgroundDrawLayer;
            if (r102 == true) goto L5;
        L8:
            if (r102 == false) goto L11;
            return 1;
        L11:
            return -1;
        L5:
            if ((r101 instanceof BaseBackgroundDrawLayer) == false) goto L8;
            return ((BaseBackgroundDrawLayer) r100).mOrder - ((BaseBackgroundDrawLayer) r101).mOrder;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(IBackgroundDrawLayer r100, IBackgroundDrawLayer r101) {
            return a(r100, r101);
        }
    }

    public class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f30666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BackgroundDrawMapView f30667b;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            com_baidu_mapapi_map_BackgroundDrawMapView$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_baidu_mapapi_map_BackgroundDrawMapView$c__run$___twin___() {
            super.run();
            Object r100 = BackgroundDrawMapView.access$200(this.f30667b);
            monitor-enter(r100);
            this.f30666a.set(true);     // Catch: Throwable -> L50
            CanvasProxy r101 = new CanvasProxy(this.f30667b);     // Catch: Throwable -> L50
            long r102 = 0;
            int r103 = 0;
        L6:
            if (BackgroundDrawMapView.access$300(this.f30667b).get() == false) goto L47;
            if (Thread.interrupted() == true) goto L47;
            if (r101.lockCanvas() == null) goto L12;
            MapController r110 = BackgroundDrawMapView.access$400(this.f30667b);     // Catch: Throwable -> L28 Exception -> L30
            if (r110 == null) goto L34;
            AppBaseMap r111 = r110.getBaseMap();     // Catch: Throwable -> L28 Exception -> L30
            if (r111 == null) goto L34;
            r111.Draw();     // Catch: Throwable -> L28 Exception -> L30
            a(r101, BackgroundDrawMapView.access$500(this.f30667b), r111);     // Catch: Throwable -> L28 Exception -> L30
            if (isInterrupted() == true) goto L34;
            r103 = 0;
        L40:
            r101.unlockCanvasAndPost(null);     // Catch: Throwable -> L50
            long r104 = (1000 / BackgroundDrawMapView.access$600(this.f30667b)) - (System.currentTimeMillis() - r102);
            if (r104 <= 0) goto L44;
            BackgroundDrawMapView.access$200(this.f30667b).wait(r104);     // Catch: InterruptedException -> L53 Throwable -> L50
        L44:
            r102 = System.currentTimeMillis();     // Catch: Throwable -> L50
            goto L6
        L34:
            r101.unlockCanvasAndPost(null);     // Catch: Throwable -> L50
            goto L47
        L28:
            th = move-exception;
            r101.unlockCanvasAndPost(null);     // Catch: Throwable -> L50
            throw th;     // Catch: Throwable -> L50
        L31:
            if (isInterrupted() == true) goto L34;
            if (r103 > 3) goto L34;
            BackgroundDrawMapView.access$200(this.f30667b).wait(100);     // Catch: Throwable -> L28 InterruptedException -> L38
        L39:
            r103 = r103 + 1;
            goto L40
        L38:
            interrupt();     // Catch: Throwable -> L28
            goto L39
        L12:
            if (r103 > 3) goto L47;
            r103 = r103 + 1;
            BackgroundDrawMapView.access$200(this.f30667b).wait(100);     // Catch: InterruptedException -> L53 Throwable -> L50
        L47:
            this.f30666a.set(false);     // Catch: Throwable -> L50
            monitor-exit(r100);     // Catch: Throwable -> L50
            return;
        L50:
            th = move-exception;
            throw th;
        }

        private c(BackgroundDrawMapView r100) {
            this.f30667b = r100;
            super("BackgroundDrawMapView$c");
            this.f30666a = new AtomicBoolean(false);
        }

        public static /* synthetic */ AtomicBoolean a(c r100) {
            return r100.f30666a;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapapi_map_BackgroundDrawMapView$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_baidu_mapapi_map_BackgroundDrawMapView$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public /* synthetic */ c(BackgroundDrawMapView r100, a r101) {
            this(r100);
        }

        private void a(CanvasProxy r100, List<IBackgroundDrawLayer> r101, AppBaseMap r102) {
            Iterator<IBackgroundDrawLayer> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            IBackgroundDrawLayer r104 = r103.next();
            if ((r104 instanceof com.baidu.mapapi.map.a) == false) goto L8;
            ((com.baidu.mapapi.map.a) r104).updateEntity(r102.getBaseRoadData());
        L8:
            r104.onDraw(r100);
            goto L4
        }
    }

    public boolean closeBackgroundMap() {
        MapSurfaceView r100 = this.mMapSurfaceView;
        if (r100 == null) goto L5;
        r100.setSupBackgroundDraw(false);
        r100.onForeground(true);
    L5:
        MapTextureView r101 = this.mMapTextureView;
        if (r101 == null) goto L8;
        r101.setSupBackgroundDraw(false);
        r101.onForeground(true);
    L8:
        setController(null);
        return true;
    }

    public IBackgroundDrawBaseRouteLayer getBaseRouteLayer() {
        Iterator<IBackgroundDrawLayer> r100 = this.mLayers.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        IBackgroundDrawLayer r101 = r100.next();
        if ((r101 instanceof com.baidu.mapapi.map.a) == false) goto L4;
        return (com.baidu.mapapi.map.a) r101;
    L9:
        return null;
    }

    public boolean openBackgroundMap() {
        MapSurfaceView r100 = this.mMapSurfaceView;
        if (r100 == null) goto L5;
        MapController r101 = r100.getController();
        r100.setSupBackgroundDraw(true);
        r100.onBackground(true);
    L6:
        MapTextureView r102 = this.mMapTextureView;
        if (r101 != null) goto L10;
        if (r102 == null) goto L10;
        r101 = r102.getController();
        r102.setSupBackgroundDraw(true);
        r102.onBackground(true);
    L10:
        if (r101 != null) goto L13;
        return false;
    L13:
        setController(r101);
        return true;
    L5:
        r101 = null;
        goto L6
    }

    public BackgroundDrawMapView(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ Object access$200(BackgroundDrawMapView r100) {
        return r100.mDrawThreadLock;
    }

    public static /* synthetic */ AtomicBoolean access$300(BackgroundDrawMapView r100) {
        return r100.mIsReady;
    }

    public static /* synthetic */ MapController access$400(BackgroundDrawMapView r100) {
        return r100.mController;
    }

    public static /* synthetic */ List access$500(BackgroundDrawMapView r100) {
        return r100.mLayers;
    }

    public static /* synthetic */ int access$600(BackgroundDrawMapView r100) {
        return r100.mFps;
    }

    private void setController(MapController r100) {
        c r101 = this.mDrawThread;
        if (r101 != null) goto L5;
    L10:
        a r102 = null;
        this.mDrawThread = null;
        this.mController = null;
        if (r100 != null) goto L13;
        return;
    L13:
        this.mController = r100;
        if (this.mIsReady.get() == true) goto L16;
        return;
    L16:
        Iterator<IBackgroundDrawLayer> r103 = this.mLayers.iterator();
    L18:
        if (r103.hasNext() == false) goto L23;
        IBackgroundDrawLayer r104 = r103.next();
        if ((r104 instanceof com.baidu.mapapi.map.b) == false) goto L18;
        ((com.baidu.mapapi.map.b) r104).updateMapController(r100);
        goto L18
    L23:
        c r105 = new c(this, r102);
        this.mDrawThread = r105;
        ThreadMethodProxy.start(r105);
        return;
    L5:
        if (c.a(r101).get() == false) goto L10;
        r101.interrupt();
    L8:
        if (c.a(r101).get() == false) goto L10;
        goto L10
    }

    public void addLayer(BaseBackgroundDrawLayer r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mLayers.contains(r100) == false) goto L7;
        return;
    L7:
        this.mLayers.add(r100);
        if (this.mIsReady.get() == true) goto L10;
    L13:
        List r101 = Arrays.asList(this.mLayers.toArray(new IBackgroundDrawLayer[0]));
        Collections.sort(r101, new b(this));
        this.mLayers.clear();
        this.mLayers.addAll(r101);
        return;
    L10:
        if ((r100 instanceof com.baidu.mapapi.map.b) == false) goto L12;
        ((com.baidu.mapapi.map.b) r100).updateMapController(this.mController);
    L12:
        r100.onCreate();
        r100.onSizeChanged(getWidth(), getHeight());
        goto L13
    }

    public void bindView(MapSurfaceView r100) {
        c r101 = this.mDrawThread;
        if (r101 != null) goto L5;
    L7:
        this.mDrawThread = null;
        this.mController = null;
        this.mMapTextureView = null;
        this.mMapSurfaceView = r100;
        return;
    L5:
        if (c.a(r101).get() == false) goto L7;
        r101.interrupt();
        goto L7
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        c r101 = this.mDrawThread;
        if (r101 != null) goto L5;
    L7:
        Iterator<IBackgroundDrawLayer> r102 = this.mLayers.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r102.next().onDestroy();
        goto L9
    L11:
        this.mIsReady.set(false);
        return true;
    L5:
        if (c.a(r101).get() == false) goto L7;
        r101.interrupt();
        goto L7
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Iterator<IBackgroundDrawLayer> r101 = this.mLayers.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onUpdated();
        goto L4
    }

    public void removeLayer(BaseBackgroundDrawLayer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mLayers.remove(r100);
        if (this.mIsReady.get() == false) goto L8;
        r100.onDestroy();
        return;
    }

    public void setFps(int r100) {
        this.mFps = Math.min(60, Math.max(10, r100));
    }

    public void bindView(MapTextureView r100) {
        c r101 = this.mDrawThread;
        if (r101 != null) goto L5;
    L7:
        this.mDrawThread = null;
        this.mController = null;
        this.mMapTextureView = r100;
        this.mMapSurfaceView = null;
        return;
    L5:
        if (c.a(r101).get() == false) goto L7;
        r101.interrupt();
        goto L7
    }

    public BackgroundDrawMapView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BackgroundDrawMapView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.mIsReady = new AtomicBoolean(false);
        this.mFps = 30;
        this.mDrawThreadLock = new Object();
        CopyOnWriteArrayList r103 = new CopyOnWriteArrayList();
        this.mLayers = r103;
        r103.add(new com.baidu.mapapi.map.a(getContext()));
        setOnClickListener(new a(this));
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Iterator<IBackgroundDrawLayer> r103 = this.mLayers.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        IBackgroundDrawLayer r104 = r103.next();
        if ((r104 instanceof com.baidu.mapapi.map.b) == false) goto L8;
        ((com.baidu.mapapi.map.b) r104).updateMapController(this.mController);
    L8:
        r104.onCreate();
        r104.onSizeChanged(r101, r102);
        goto L4
    L9:
        this.mIsReady.set(true);
        setController(this.mController);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Iterator<IBackgroundDrawLayer> r103 = this.mLayers.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onSizeChanged(r101, r102);
        goto L4
    }
}
