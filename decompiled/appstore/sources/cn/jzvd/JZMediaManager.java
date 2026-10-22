package cn.jzvd;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.TextureView;
import com.bytedanceos.common.toolbox.i;

/* JADX INFO: loaded from: classes.dex */
public class JZMediaManager implements TextureView.SurfaceTextureListener {
    public static final int HANDLER_PREPARE = 0;
    public static final int HANDLER_RELEASE = 2;
    public static final String TAG = "JZVD";
    public static JZMediaManager jzMediaManager;
    public static SurfaceTexture savedSurfaceTexture;
    public static Surface surface;
    public static JZTextureView textureView;
    public int currentVideoHeight;
    public int currentVideoWidth;
    public JZMediaInterface jzMediaInterface;
    public MediaHandler mMediaHandler;
    public HandlerThread mMediaHandlerThread;
    public Handler mainThreadHandler;
    public int positionInList;

    public class MediaHandler extends Handler {
        final /* synthetic */ JZMediaManager this$0;

        public MediaHandler(JZMediaManager r10, Looper r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            int r11 = r10.what;
            if (r11 != 0) goto L5;
            JZMediaManager r12 = this.this$0;
            r12.currentVideoWidth = 0;
            r12.currentVideoHeight = 0;
            r12.jzMediaInterface.prepare();
            monitor-enter(JZMediaManager.class);
        L15:
            th = move-exception;
            throw th;
        L11:
            if (JZMediaManager.savedSurfaceTexture == null) goto L18;
            Surface r13 = JZMediaManager.surface;     // Catch: Throwable -> L15
            if (r13 == null) goto L17;
            r13.release();     // Catch: Throwable -> L15
        L17:
            Surface r14 = new Surface(JZMediaManager.savedSurfaceTexture);     // Catch: Throwable -> L15
            JZMediaManager.surface = r14;     // Catch: Throwable -> L15
            this.this$0.jzMediaInterface.setSurface(r14);     // Catch: Throwable -> L15
        L18:
            monitor-exit(JZMediaManager.class);     // Catch: Throwable -> L15
            return;
        L5:
            if (r11 != 2) goto L25;
            this.this$0.jzMediaInterface.release();
            return;
        }
    }

    public JZMediaManager() {
        this.positionInList = -1;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
        HandlerThread r10 = new HandlerThread("JZVD");
        this.mMediaHandlerThread = r10;
        r10.start();
        this.mMediaHandler = new MediaHandler(this, this.mMediaHandlerThread.getLooper());
        this.mainThreadHandler = new Handler();
        if (this.jzMediaInterface != null) goto L6;
        this.jzMediaInterface = new JZMediaSystem();
        return;
    }

    public static long getCurrentPosition() {
        return instance().jzMediaInterface.getCurrentPosition();
    }

    public static Object getCurrentUrl() {
        if (instance().jzMediaInterface.jzDataSource != null) goto L6;
        return null;
    L6:
        return instance().jzMediaInterface.jzDataSource.getCurrentUrl();
    }

    public static JZDataSource getDataSource() {
        return instance().jzMediaInterface.jzDataSource;
    }

    public static long getDuration() {
        return instance().jzMediaInterface.getDuration();
    }

    public static JZMediaManager instance() {
        if (jzMediaManager != null) goto L6;
        jzMediaManager = new JZMediaManager();
    L6:
        return jzMediaManager;
    }

    public static boolean isPlaying() {
        return instance().jzMediaInterface.isPlaying();
    }

    public static void pause() {
        instance().jzMediaInterface.pause();
    }

    public static void seekTo(long r10) {
        instance().jzMediaInterface.seekTo(r10);
    }

    public static void setDataSource(JZDataSource r10) {
        instance().jzMediaInterface.jzDataSource = r10;
    }

    public static void setLooping(boolean r10) {
        instance().jzMediaInterface.setLooping(r10);
    }

    public static void setSavedSurfaceTexture(SurfaceTexture r10) {
        savedSurfaceTexture = r10;
    }

    public static void setSpeed(float r10) {
        instance().jzMediaInterface.setSpeed(r10);
    }

    public static void setTextureView(JZTextureView r10) {
        textureView = r10;
    }

    public static void start() {
        instance().jzMediaInterface.start();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r10, int r11, int r12) {
        if (JzvdMgr.getCurrentJzvd() != null) goto L5;
        return;
    L5:
        i.e("JZVD", "onSurfaceTextureAvailable [" + JzvdMgr.getCurrentJzvd().hashCode() + "] ");
        SurfaceTexture r13 = savedSurfaceTexture;
        if (r13 != null) goto L8;
        savedSurfaceTexture = r10;
        prepare();
        return;
    L8:
        textureView.setSurfaceTexture(r13);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r10) {
        if (savedSurfaceTexture != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r10, int r11, int r12) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r10) {
    }

    public void prepare() {
        releaseMediaPlayer();
        Message r10 = new Message();
        r10.what = 0;
        this.mMediaHandler.sendMessage(r10);
    }

    public void releaseMediaPlayer() {
        this.mMediaHandler.removeCallbacksAndMessages(null);
        Message r10 = new Message();
        r10.what = 2;
        this.mMediaHandler.sendMessage(r10);
    }
}
