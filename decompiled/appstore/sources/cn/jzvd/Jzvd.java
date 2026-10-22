package cn.jzvd;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.toolbox.i;
import com.bytedanceos.common.ui.animation.AnimationConstants;
import com.danikula.videocache.CacheListener;
import com.danikula.videocache.HttpProxyCacheServer;
import com.google.common.primitives.Ints;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class Jzvd extends FrameLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener, CacheListener {
    public static boolean ACTION_BAR_EXIST = true;
    public static long CLICK_QUIT_FULLSCREEN_TIME = 0;
    public static final int CURRENT_STATE_AUTO_COMPLETE = 6;
    public static final int CURRENT_STATE_ERROR = 7;
    public static final int CURRENT_STATE_IDLE = -1;
    public static final int CURRENT_STATE_NORMAL = 0;
    public static final int CURRENT_STATE_PAUSE = 5;
    public static final int CURRENT_STATE_PLAYING = 3;
    public static final int CURRENT_STATE_PREPARING = 1;
    public static final int CURRENT_STATE_PREPARING_CHANGING_URL = 2;
    public static final int FULLSCREEN_ORIENTATION = 6;
    public static final int FULL_SCREEN_NORMAL_DELAY = 300;
    protected static JZUserAction JZ_USER_EVENT = null;
    public static int NORMAL_ORIENTATION = 1;
    public static int ON_PLAY_PAUSE_TMP_STATE = 0;
    public static final boolean SAVE_PROGRESS = true;
    public static final int SCREEN_WINDOW_FULLSCREEN = 2;
    public static final int SCREEN_WINDOW_LIST = 1;
    public static final int SCREEN_WINDOW_NORMAL = 0;
    public static final int SCREEN_WINDOW_TINY = 3;
    public static final String TAG = "JZVD";
    public static final int THRESHOLD = 80;
    public static final boolean TOOL_BAR_EXIST = true;
    public static int VIDEO_IMAGE_DISPLAY_TYPE = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    public static boolean WIFI_TIP_DIALOG_SHOWED = false;
    public static long lastAutoFullscreenTime = 0;
    private static boolean mIsUserClickedMuteIcon = true;
    private static int mSystemMusicVolume;
    public static final AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = null;
    protected Timer UPDATE_PROGRESS_TIMER;
    public ImageView backViewButton;
    public int currentScreen;
    public int currentState;
    public ImageView fullscreenButton;
    public int heightRatio;
    private boolean isAutoPlayWithWifiEnable;
    private boolean isFullScreenEnable;
    private boolean isPausedByUser;
    public JZDataSource jzDataSource;
    protected AudioManager mAudioManager;
    protected boolean mChangeBrightness;
    protected boolean mChangePosition;
    protected boolean mChangeVolume;
    protected float mDownX;
    protected float mDownY;
    protected float mGestureDownBrightness;
    protected long mGestureDownPosition;
    protected int mGestureDownVolume;
    private boolean mIsMuteEnabled;
    private Listener mListener;
    private boolean mLooping;
    private MusicVolumeContentObserver mMusicVolumeContentObserver;
    protected ProgressTimerTask mProgressTimerTask;
    private HttpProxyCacheServer mProxy;
    private boolean mRegistered;
    protected int mScreenHeight;
    protected int mScreenWidth;
    protected long mSeekTimePosition;
    protected boolean mTouchingProgressBar;
    public String mUrl;
    public ImageView muteButton;
    public int positionInList;
    public long seekToInAdvance;
    public int seekToManulPosition;
    public ImageView startButton;
    public ViewGroup textureViewContainer;
    boolean tmp_test_back;
    public int videoRotation;
    public int widthRatio;

    public static class JZAutoFullscreenListener implements SensorEventListener {
        public JZAutoFullscreenListener() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r10, int r11) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r10) {
            float[] r11 = r10.values;
            float r12 = r11[0];
            float r13 = r11[1];
            float r14 = r11[2];
            if (r12 < (-12.0f)) goto L7;
            if (r12 > 12.0f) goto L7;
            return;
        L7:
            if ((System.currentTimeMillis() - Jzvd.lastAutoFullscreenTime) > AnimationConstants.DURATION_2000L) goto L9;
            return;
        L9:
            if (JzvdMgr.getCurrentJzvd() == null) goto L11;
            JzvdMgr.getCurrentJzvd().autoFullscreen(r12);
        L11:
            Jzvd.lastAutoFullscreenTime = System.currentTimeMillis();
        }
    }

    public interface Listener {
        void onCompletion(MediaPlayer r10);

        boolean onError(MediaPlayer r10, int r11, int r12);

        void onExitFullScreen();

        void onFullScreen();

        void onFullScreenViewClick(View r10);

        boolean onInfo(MediaPlayer r10, int r11, int r12);

        void onMuteViewClick(View r10);

        void onPrepared(MediaPlayer r10);

        void onVideoStartButtonClick(View r10);

        void onVideoViewClick(View r10);
    }

    public static class ListenerAdapter implements Listener {
        public ListenerAdapter() {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onCompletion(MediaPlayer r10) {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public boolean onError(MediaPlayer r10, int r11, int r12) {
            return false;
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onExitFullScreen() {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onFullScreen() {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onFullScreenViewClick(View r10) {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public boolean onInfo(MediaPlayer r10, int r11, int r12) {
            return false;
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onMuteViewClick(View r10) {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onPrepared(MediaPlayer r10) {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onVideoStartButtonClick(View r10) {
        }

        @Override // cn.jzvd.Jzvd.Listener
        public void onVideoViewClick(View r10) {
        }
    }

    public class MusicVolumeContentObserver extends ContentObserver {
        private WeakReference<Context> mContextWeakRef;
        final /* synthetic */ Jzvd this$0;

        public MusicVolumeContentObserver(Jzvd r10, Context r11, Handler r12) {
            this.this$0 = r10;
            super(r12);
            this.mContextWeakRef = new WeakReference(r11);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return super.deliverSelfNotifications();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            super.onChange(r10);
            Context r11 = this.mContextWeakRef.get();
            if (r11 == null) goto L15;
            AudioManager r12 = (AudioManager) r11.getSystemService("audio");
            if (Jzvd.access$000() == false) goto L7;
            Jzvd.access$002(false);
        L13:
            Jzvd r13 = this.this$0;
            Jzvd.access$300(r13, Jzvd.access$100(r13));
            return;
        L7:
            int r14 = r12.getStreamVolume(3);
            if (r14 <= 0) goto L10;
            Jzvd.access$102(this.this$0, false);
        L12:
            Jzvd.access$202(r14);
            goto L13
        L10:
            if (r14 != 0) goto L12;
            Jzvd.access$102(this.this$0, true);
            goto L12
        }
    }

    public class ProgressTimerTask extends TimerTask {
        final /* synthetic */ Jzvd this$0;

        public ProgressTimerTask(Jzvd r10) {
            this.this$0 = r10;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Jzvd r10 = this.this$0;
            int r11 = r10.currentState;
            if (r11 != 3) goto L5;
        L6:
            r10.post(new AnonymousClass1(this));
            return;
        L5:
            if (r11 == 5) goto L6;
        }
    }

    static {
        onAudioFocusChangeListener = new AnonymousClass1();
        ON_PLAY_PAUSE_TMP_STATE = 0;
    }

    public Jzvd(Context r10) {
        super(r10);
        this.mIsMuteEnabled = true;
        this.mLooping = true;
        this.isFullScreenEnable = false;
        this.isAutoPlayWithWifiEnable = true;
        this.currentState = -1;
        this.currentScreen = -1;
        this.seekToInAdvance = 0;
        this.widthRatio = 16;
        this.heightRatio = 9;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.tmp_test_back = false;
        this.seekToManulPosition = -1;
        this.mRegistered = false;
        init(r10);
    }

    public static /* synthetic */ boolean access$000() {
        return mIsUserClickedMuteIcon;
    }

    public static /* synthetic */ boolean access$002(boolean r10) {
        mIsUserClickedMuteIcon = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$100(Jzvd r10) {
        return r10.mIsMuteEnabled;
    }

    public static /* synthetic */ boolean access$102(Jzvd r10, boolean r11) {
        r10.mIsMuteEnabled = r11;
        return r11;
    }

    public static /* synthetic */ int access$202(int r10) {
        mSystemMusicVolume = r10;
        return r10;
    }

    public static /* synthetic */ void access$300(Jzvd r10, boolean r11) {
        r10.updateMuteView(r11);
    }

    public static boolean backPress() {
        i.e("JZVD", "backPress");
        if ((System.currentTimeMillis() - CLICK_QUIT_FULLSCREEN_TIME) >= 300) goto L6;
        return false;
    L6:
        if (JzvdMgr.getSecondFloor() == null) goto L17;
        CLICK_QUIT_FULLSCREEN_TIME = System.currentTimeMillis();
        if (JzvdMgr.getFirstFloor().jzDataSource.containsTheUrl(JZMediaManager.getDataSource().getCurrentUrl()) == false) goto L14;
        Jzvd r10 = JzvdMgr.getSecondFloor();
        if (r10.currentScreen != 2) goto L12;
        int r11 = 8;
    L13:
        r10.onEvent(r11);
        JzvdMgr.getFirstFloor().playOnThisJzvd();
    L15:
        return true;
    L12:
        r11 = 10;
        goto L13
    L14:
        quitFullscreenOrTinyWindow();
        goto L15
    L17:
        if (JzvdMgr.getFirstFloor() != null) goto L19;
    L24:
        return false;
    L19:
        if (JzvdMgr.getFirstFloor().currentScreen != 2) goto L21;
    L22:
        CLICK_QUIT_FULLSCREEN_TIME = System.currentTimeMillis();
        quitFullscreenOrTinyWindow();
        return true;
    L21:
        if (JzvdMgr.getFirstFloor().currentScreen != 3) goto L24;
        goto L22
    }

    public static void clearSavedProgress(Context r10, String r11) {
        JZUtils.clearSavedProgress(r10, r11);
    }

    public static void goOnPlayOnPause() {
        if (JzvdMgr.getCurrentJzvd() == null) goto L12;
        Jzvd r10 = JzvdMgr.getCurrentJzvd();
        int r11 = r10.currentState;
        if (r11 == 6) goto L13;
        if (r11 != 0) goto L8;
        return;
    L8:
        if (r11 == 7) goto L15;
        ON_PLAY_PAUSE_TMP_STATE = r11;
        JZMediaManager.pause();
        r10.onStatePause();
        return;
    L15:
        return;
    L13:
        return;
    }

    public static void goOnPlayOnResume() {
        if (JzvdMgr.getCurrentJzvd() == null) goto L12;
        Jzvd r10 = JzvdMgr.getCurrentJzvd();
        i.a("JZVD", "goOnPlayOnResume [" + r10.hashCode() + "] " + r10.currentState);
        if (r10.currentState == 5) goto L7;
        return;
    L7:
        if (ON_PLAY_PAUSE_TMP_STATE != 5) goto L9;
        r10.onStatePause();
        JZMediaManager.pause();
    L10:
        ON_PLAY_PAUSE_TMP_STATE = 0;
        return;
    L9:
        r10.onStatePlaying();
        JZMediaManager.start();
        goto L10
    }

    @SuppressLint({"RestrictedApi"})
    public static void hideSupportActionBar(Context r10) {
        JZUtils.getWindow(r10).setFlags(1024, 1024);
    }

    public static void onChildViewAttachedToWindow(View r10, int r11) {
        if (JzvdMgr.getCurrentJzvd() != null) goto L5;
        return;
    L5:
        if (JzvdMgr.getCurrentJzvd().currentScreen != 3) goto L13;
        Jzvd r12 = (Jzvd) r10.findViewById(r11);
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.jzDataSource.containsTheUrl(JZMediaManager.getCurrentUrl()) == false) goto L15;
        backPress();
        return;
    L15:
        return;
    }

    public static void onChildViewDetachedFromWindow(View r10) {
        if (JzvdMgr.getCurrentJzvd() != null) goto L5;
        return;
    L5:
        if (JzvdMgr.getCurrentJzvd().currentScreen == 3) goto L14;
        Jzvd r11 = JzvdMgr.getCurrentJzvd();
        if (((ViewGroup) r10).indexOfChild(r11) != (-1)) goto L9;
        return;
    L9:
        if (r11.currentState != 5) goto L11;
        releaseAllVideos();
        return;
    L11:
        r11.startWindowTiny();
        return;
    }

    public static void onScrollAutoTiny(AbsListView r10, int r11, int r12, int r13) {
        int r14 = r12 + r11;
        int r15 = JZMediaManager.instance().positionInList;
        if (r15 >= 0) goto L5;
        return;
    L5:
        if (r15 < r11) goto L15;
        if (r15 > (r14 - 1)) goto L15;
        if (JzvdMgr.getCurrentJzvd() != null) goto L12;
        return;
    L12:
        if (JzvdMgr.getCurrentJzvd().currentScreen != 3) goto L27;
        i.b("JZVD", "onScroll: into screen");
        backPress();
        return;
    L27:
        return;
    L15:
        if (JzvdMgr.getCurrentJzvd() != null) goto L17;
        return;
    L17:
        if (JzvdMgr.getCurrentJzvd().currentScreen != 3) goto L19;
        return;
    L19:
        if (JzvdMgr.getCurrentJzvd().currentScreen != 2) goto L21;
        return;
    L21:
        if (JzvdMgr.getCurrentJzvd().currentState != 5) goto L23;
        releaseAllVideos();
        return;
    L23:
        i.b("JZVD", "onScroll: out screen");
        JzvdMgr.getCurrentJzvd().startWindowTiny();
    }

    public static void onScrollReleaseAllVideos(AbsListView r10, int r11, int r12, int r13) {
        int r14 = r12 + r11;
        int r15 = JZMediaManager.instance().positionInList;
        i.b("JZVD", "onScrollReleaseAllVideos: " + r15 + " " + r11 + " " + r15 + " " + r14);
        if (r15 < 0) goto L11;
        if (r15 < r11) goto L8;
        if (r15 > (r14 - 1)) goto L8;
        return;
    L8:
        if (JzvdMgr.getCurrentJzvd().currentScreen == 2) goto L13;
        releaseAllVideos();
        return;
    L13:
        return;
    }

    public static void quitFullscreenOrTinyWindow() {
        JzvdMgr.getFirstFloor().clearFloatScreen();
        JZMediaManager.instance().releaseMediaPlayer();
        JzvdMgr.completeAll();
    }

    private void registerVolumeReceiver() {
        if (this.mRegistered == true) goto L6;
        this.mMusicVolumeContentObserver = new MusicVolumeContentObserver(this, getContext(), new Handler());
        getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mMusicVolumeContentObserver);
        this.mRegistered = true;
        return;
    }

    public static void releaseAllVideos() {
        if ((System.currentTimeMillis() - CLICK_QUIT_FULLSCREEN_TIME) <= 300) goto L6;
        i.a("JZVD", "releaseAllVideos");
        JZMediaManager.instance().positionInList = -1;
        JZMediaManager.instance().releaseMediaPlayer();
        JzvdMgr.completeAll();
        return;
    }

    private void restoreMusicVolume() {
        this.mAudioManager.setStreamVolume(3, mSystemMusicVolume, 0);
    }

    public static void setJzUserAction(JZUserAction r10) {
        JZ_USER_EVENT = r10;
    }

    public static void setMediaInterface(JZMediaInterface r10) {
        JZMediaManager.instance().jzMediaInterface = r10;
    }

    public static void setTextureViewRotation(int r10) {
        JZTextureView r11 = JZMediaManager.textureView;
        if (r11 == null) goto L6;
        r11.setRotation(r10);
        return;
    }

    public static void setVideoImageDisplayType(int r10) {
        VIDEO_IMAGE_DISPLAY_TYPE = r10;
        JZTextureView r11 = JZMediaManager.textureView;
        if (r11 == null) goto L6;
        r11.requestLayout();
        return;
    }

    @SuppressLint({"RestrictedApi"})
    public static void showSupportActionBar(Context r10) {
        JZUtils.getWindow(r10).clearFlags(1024);
    }

    public static void startFullscreen(Context r10, Class r11, String r12, String r13) {
        startFullscreen(r10, r11, new JZDataSource(r12, r13));
    }

    private void toggleMuteStatus() {
        boolean r10 = !this.mIsMuteEnabled;
        this.mIsMuteEnabled = r10;
        updateMuteStatus(r10);
    }

    private void unRegisterVolumeReceiver() {
        if (this.mRegistered == false) goto L6;
        getContext().getContentResolver().unregisterContentObserver(this.mMusicVolumeContentObserver);
        this.mMusicVolumeContentObserver = null;
        this.mRegistered = false;
        return;
    }

    private void updateMuteStatus(boolean r10) {
        AudioManager r11 = this.mAudioManager;
        if (r10 == false) goto L5;
        int r12 = -100;
    L6:
        r11.adjustStreamVolume(3, r12, 0);
        updateMuteView(r10);
        return;
    L5:
        r12 = 100;
        goto L6
    }

    private void updateMuteView(boolean r10) {
        ImageView r11 = this.muteButton;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = R$drawable.jz_mute;
    L7:
        r11.setImageResource(r12);
        return;
    L6:
        r12 = R$drawable.jz_unmute;
        goto L7
    }

    public void addTextureView() {
        i.a("JZVD", "addTextureView [" + hashCode() + "] ");
        this.textureViewContainer.addView(JZMediaManager.textureView, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    public void autoFullscreen(float r10) {
        if (isCurrentPlay() == false) goto L17;
        int r11 = this.currentState;
        if (r11 != 3) goto L7;
    L8:
        int r12 = this.currentScreen;
        if (r12 == 2) goto L19;
        if (r12 != 3) goto L12;
        return;
    L12:
        if (r10 <= 0.0f) goto L14;
        JZUtils.setRequestedOrientation(getContext(), 0);
    L15:
        onEvent(7);
        startWindowFullscreen();
        return;
    L14:
        JZUtils.setRequestedOrientation(getContext(), 8);
        goto L15
    L19:
        return;
    L7:
        if (r11 == 5) goto L8;
        return;
    }

    public void autoQuitFullscreen() {
        if ((System.currentTimeMillis() - lastAutoFullscreenTime) > AnimationConstants.DURATION_2000L) goto L5;
        return;
    L5:
        if (isCurrentPlay() == true) goto L7;
        return;
    L7:
        if (this.currentState == 3) goto L9;
        return;
    L9:
        if (this.currentScreen != 2) goto L15;
        lastAutoFullscreenTime = System.currentTimeMillis();
        backPress();
        return;
    }

    public void cancelProgressTimer() {
        i.a("JZVD", "cancelProgressTimer:  [" + hashCode() + "] ");
        Timer r10 = this.UPDATE_PROGRESS_TIMER;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        ProgressTimerTask r11 = this.mProgressTimerTask;
        if (r11 == null) goto L9;
        r11.cancel();
        this.mProgressTimerTask = null;
        return;
    }

    public void changeUrl(int r10, long r11) {
        this.currentState = 2;
        this.seekToInAdvance = r11;
        JZDataSource r12 = this.jzDataSource;
        r12.currentUrlIndex = r10;
        JZMediaManager.setDataSource(r12);
        JZMediaManager.instance().prepare();
    }

    public void clearFloatScreen() {
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        showSupportActionBar(getContext());
        ViewGroup r10 = (ViewGroup) JZUtils.scanForActivity(getContext()).findViewById(R.id.content);
        Jzvd r11 = (Jzvd) r10.findViewById(R$id.jz_fullscreen_id);
        Jzvd r12 = (Jzvd) r10.findViewById(R$id.jz_tiny_id);
        if (r11 == null) goto L7;
        r10.removeView(r11);
        ViewGroup r13 = r11.textureViewContainer;
        if (r13 == null) goto L7;
        r13.removeView(JZMediaManager.textureView);
    L7:
        if (r12 == null) goto L11;
        r10.removeView(r12);
        ViewGroup r14 = r12.textureViewContainer;
        if (r14 == null) goto L11;
        r14.removeView(JZMediaManager.textureView);
    L11:
        JzvdMgr.setSecondFloor(null);
        Listener r15 = this.mListener;
        if (r15 == null) goto L15;
        r15.onExitFullScreen();
        return;
    }

    public void clearFullscreenLayout() {
        ViewGroup r10 = (ViewGroup) JZUtils.scanForActivity(getContext()).findViewById(R.id.content);
        View r11 = r10.findViewById(R$id.jz_fullscreen_id);
        View r12 = r10.findViewById(R$id.jz_tiny_id);
        if (r11 == null) goto L5;
        r10.removeView(r11);
    L5:
        if (r12 == null) goto L7;
        r10.removeView(r12);
    L7:
        showSupportActionBar(getContext());
    }

    public void dismissBrightnessDialog() {
    }

    public void dismissProgressDialog() {
    }

    public void dismissVolumeDialog() {
    }

    public Context getApplicationContext() {
        Context r10 = getContext();
        if (r10 == null) goto L7;
        Context r11 = r10.getApplicationContext();
        if (r11 == null) goto L7;
        return r11;
    L7:
        return r10;
    }

    public long getCurrentPositionWhenPlaying() {
        int r10 = this.currentState;
        if (r10 != 3) goto L5;
    L11:
        return JZMediaManager.getCurrentPosition();
    L8:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L5:
        if (r10 == 5) goto L11;
        return 0;
    }

    public Object getCurrentUrl() {
        JZDataSource r10 = this.jzDataSource;
        if (r10 != null) goto L5;
        return "";
    L5:
        if (r10.getCurrentUrl() != null) goto L7;
        return "";
    L7:
        return this.jzDataSource.getCurrentUrl();
    }

    public long getDuration() {
        return JZMediaManager.getDuration();
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public abstract int getLayoutId();

    public boolean getLooping() {
        if (this.mLooping == true) goto L7;
        return false;
    L7:
        return JZUtils.isWifiConnected(getContext());
    }

    public int getState() {
        return this.currentState;
    }

    public void init(Context r10) {
        View.inflate(r10, getLayoutId(), this);
        this.startButton = (ImageView) findViewById(R$id.start);
        this.fullscreenButton = (ImageView) findViewById(R$id.fullscreen);
        this.backViewButton = (ImageView) findViewById(R$id.back_view);
        this.muteButton = (ImageView) findViewById(R$id.mute_view);
        updateMuteView(this.mIsMuteEnabled);
        this.textureViewContainer = (ViewGroup) findViewById(R$id.surface_container);
        this.startButton.setOnClickListener(this);
        this.fullscreenButton.setOnClickListener(this);
        this.backViewButton.setOnClickListener(this);
        this.muteButton.setOnClickListener(this);
        this.textureViewContainer.setOnClickListener(this);
        this.textureViewContainer.setOnTouchListener(this);
        this.mScreenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mScreenHeight = getContext().getResources().getDisplayMetrics().heightPixels;
        this.mAudioManager = (AudioManager) getContext().getSystemService("audio");
    L7:
        e = move-exception;
        e.printStackTrace();
    L10:
        if (mSystemMusicVolume != 0) goto L15;
        mSystemMusicVolume = this.mAudioManager.getStreamVolume(3);
        return;
    L15:
        return;
    L4:
        if (isCurrentPlay() == false) goto L10;
        NORMAL_ORIENTATION = ((Activity) r10).getRequestedOrientation();     // Catch: Exception -> L7
        goto L10
    }

    public void initTextureView() {
        removeTextureView();
        JZMediaManager.setTextureView(new JZTextureView(getContext().getApplicationContext()));
        JZMediaManager.textureView.setSurfaceTextureListener(JZMediaManager.instance());
    }

    public boolean isAutoPlayWithWifiEnable() {
        return this.isAutoPlayWithWifiEnable;
    }

    public boolean isCached() {
        if (this.mProxy != null) goto L5;
    L11:
        return false;
    L5:
        if (this.jzDataSource == null) goto L11;
        if (TextUtils.isEmpty(this.mUrl) == true) goto L11;
        if (this.mProxy.isCached(String.valueOf(this.mUrl)) == false) goto L11;
        return true;
    }

    public boolean isCurrentJZVD() {
        if (JzvdMgr.getCurrentJzvd() != null) goto L5;
    L7:
        return false;
    L5:
        if (JzvdMgr.getCurrentJzvd() != this) goto L7;
        return true;
    }

    public boolean isCurrentPlay() {
        if (isCurrentJZVD() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.jzDataSource.containsTheUrl(JZMediaManager.getCurrentUrl()) == false) goto L7;
        return true;
    }

    public boolean isFullScreenEnable() {
        return this.isFullScreenEnable;
    }

    public boolean isMuteEnabled() {
        return this.mIsMuteEnabled;
    }

    public boolean isPausedByUser() {
        return this.isPausedByUser;
    }

    public boolean isSameUrl() {
        if (this.mProxy != null) goto L5;
    L11:
        return false;
    L5:
        if (this.jzDataSource == null) goto L11;
        if (TextUtils.isEmpty(this.mUrl) == true) goto L11;
        if (this.mProxy.getProxyUrl(this.mUrl).equals(this.jzDataSource.getCurrentUrl()) == false) goto L11;
        return true;
    }

    public void onAutoCompletion(MediaPlayer r10) {
        Runtime.getRuntime().gc();
        i.e("JZVD", "onAutoCompletion  [" + hashCode() + "] ");
        onEvent(6);
        dismissVolumeDialog();
        dismissProgressDialog();
        dismissBrightnessDialog();
        onStateAutoComplete();
        int r11 = this.currentScreen;
        if (r11 != 2) goto L5;
    L6:
        backPress();
    L7:
        JZMediaManager.instance().releaseMediaPlayer();
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), 0);
        Listener r12 = this.mListener;
        if (r12 == null) goto L11;
        r12.onCompletion(r10);
    L11:
        if (this.jzDataSource.looping == false) goto L14;
        startVideo();
        return;
    L14:
        return;
    L5:
        if (r11 != 3) goto L7;
        goto L6
    }

    @Override // com.danikula.videocache.CacheListener
    public void onCacheAvailable(File r10, String r11, int r12) {
        i.a("JZVD", "onCacheAvailable, p=" + r12);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r10) {
        int r11 = r10.getId();
        if (r11 != R$id.start) goto L38;
        i.e("JZVD", "onClick start [" + hashCode() + "] ");
        JZDataSource r12 = this.jzDataSource;
        if (r12 != null) goto L7;
    L35:
        Toast.makeText(getContext(), getResources().getString(R$string.no_url), 0).show();
        return;
    L7:
        if (r12.urlsMap.isEmpty() == true) goto L35;
        if (this.jzDataSource.getCurrentUrl() == null) goto L35;
        Listener r13 = this.mListener;
        if (r13 == null) goto L14;
        r13.onVideoStartButtonClick(r10);
    L14:
        int r14 = this.currentState;
        if (r14 != 0) goto L28;
        if (this.jzDataSource.getCurrentUrl().toString().startsWith("file") == false) goto L19;
    L26:
        startVideo();
        mIsUserClickedMuteIcon = true;
        onEvent(0);
        return;
    L19:
        if (this.jzDataSource.getCurrentUrl().toString().startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L26;
        if (JZUtils.isWifiConnected(getContext()) == true) goto L26;
        if (WIFI_TIP_DIALOG_SHOWED == true) goto L26;
        showWifiDialog();
        return;
    L28:
        if (r14 != 3) goto L31;
        onEvent(3);
        i.a("JZVD", "pauseVideo [" + hashCode() + "] ");
        JZMediaManager.pause();
        onStatePause();
        this.isPausedByUser = true;
        return;
    L31:
        if (r14 != 5) goto L33;
        onEvent(4);
        JZMediaManager.start();
        onStatePlaying();
        mIsUserClickedMuteIcon = true;
        this.isPausedByUser = false;
        return;
    L33:
        if (r14 != 6) goto L69;
        onEvent(2);
        startVideo();
        mIsUserClickedMuteIcon = true;
        return;
    L69:
        return;
    L38:
        if (r11 != R$id.fullscreen) goto L50;
        i.e("JZVD", "onClick fullscreen [" + hashCode() + "] ");
        Listener r15 = this.mListener;
        if (r15 == null) goto L43;
        r15.onFullScreenViewClick(this.fullscreenButton);
    L43:
        if (this.currentState != 6) goto L46;
        return;
    L46:
        if (this.currentScreen != 2) goto L48;
        backPress();
        return;
    L48:
        i.a("JZVD", "toFullscreenActivity [" + hashCode() + "] ");
        onEvent(7);
        startWindowFullscreen();
        return;
    L50:
        if (r11 != R$id.mute_view) goto L56;
        Listener r16 = this.mListener;
        if (r16 == null) goto L54;
        r16.onMuteViewClick(this.muteButton);
    L54:
        mIsUserClickedMuteIcon = true;
        toggleMuteStatus();
        return;
    L56:
        if (r11 != R$id.surface_container) goto L61;
        Listener r17 = this.mListener;
        if (r17 == null) goto L74;
        r17.onVideoViewClick(this.textureViewContainer);
        return;
    L74:
        return;
    L61:
        if (r11 == R$id.back_view) goto L63;
        return;
    L63:
        if (this.currentScreen != 2) goto L77;
        backPress();
        return;
    }

    public void onCompletion() {
        i.e("JZVD", "onCompletion  [" + hashCode() + "] ");
        int r10 = this.currentState;
        if (r10 != 3) goto L5;
    L6:
        JZUtils.saveProgress(getContext(), this.jzDataSource.getCurrentUrl(), getCurrentPositionWhenPlaying());
    L7:
        cancelProgressTimer();
        dismissBrightnessDialog();
        dismissProgressDialog();
        dismissVolumeDialog();
        onStateNormal();
        this.textureViewContainer.removeView(JZMediaManager.textureView);
        JZMediaManager.instance().currentVideoWidth = 0;
        JZMediaManager.instance().currentVideoHeight = 0;
        JZUtils.scanForActivity(getContext()).getWindow().clearFlags(128);
        clearFullscreenLayout();
        JZUtils.setRequestedOrientation(getContext(), NORMAL_ORIENTATION);
        monitor-enter(JZMediaManager.class);
        Surface r11 = JZMediaManager.surface;     // Catch: Throwable -> L12
        if (r11 == null) goto L14;
        r11.release();     // Catch: Throwable -> L12
    L14:
        SurfaceTexture r12 = JZMediaManager.savedSurfaceTexture;     // Catch: Throwable -> L12
        if (r12 == null) goto L17;
        r12.release();     // Catch: Throwable -> L12
    L17:
        JZMediaManager.textureView = null;     // Catch: Throwable -> L12
        JZMediaManager.savedSurfaceTexture = null;     // Catch: Throwable -> L12
        monitor-exit(JZMediaManager.class);     // Catch: Throwable -> L12
        this.mAudioManager.abandonAudioFocus(onAudioFocusChangeListener);
        restoreSystemVolume();
        return;
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10 != 5) goto L7;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterCacheListener();
    }

    public void onError(MediaPlayer r10, int r11, int r12) {
        i.b("JZVD", "onError " + r11 + " - " + r12 + " [" + hashCode() + "] ");
        if (r11 != 38) goto L5;
    L13:
        Listener r13 = this.mListener;
        if (r13 == null) goto L17;
        r13.onError(r10, r11, r12);
        return;
    L17:
        return;
    L5:
        if (r12 == (-38)) goto L13;
        if (r11 == (-38)) goto L13;
        if (r12 == 38) goto L13;
        if (r12 == (-19)) goto L13;
        onStateError();
        if (isCurrentPlay() == false) goto L13;
        JZMediaManager.instance().releaseMediaPlayer();
        goto L13
    }

    public void onEvent(int r10) {
        if (JZ_USER_EVENT != null) goto L5;
        return;
    L5:
        if (isCurrentPlay() == true) goto L7;
        return;
    L7:
        if (this.jzDataSource.urlsMap.isEmpty() == true) goto L12;
        JZ_USER_EVENT.onEvent(r10, this.jzDataSource.getCurrentUrl(), this.currentScreen, new Object[0]);
        return;
    }

    public void onInfo(MediaPlayer r10, int r11, int r12) {
        i.a("JZVD", "onInfo what - " + r11 + " extra - " + r12);
        Listener r13 = this.mListener;
        if (r13 == null) goto L6;
        r13.onInfo(r10, r11, r12);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        int r12 = this.currentScreen;
        if (r12 != 2) goto L5;
    L14:
        super.onMeasure(r10, r11);
        return;
    L5:
        if (r12 == 3) goto L14;
        if (this.widthRatio != 0) goto L10;
    L12:
        super.onMeasure(r10, r11);
        return;
    L10:
        if (this.heightRatio == 0) goto L12;
        int r13 = View.MeasureSpec.getSize(r10);
        int r14 = (int) ((r13 * this.heightRatio) / this.widthRatio);
        setMeasuredDimension(r13, r14);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(r13, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r14, Ints.MAX_POWER_OF_TWO));
    }

    public void onPrepared(MediaPlayer r10) {
        i.e("JZVD", "onPrepared  [" + hashCode() + "] ");
        setMuteEnable(isMuteEnabled());
        setFullScreenEnable(isFullScreenEnable());
        updateMuteStatus(this.mIsMuteEnabled);
        onStatePrepared();
        onStatePlaying();
        Listener r11 = this.mListener;
        if (r11 == null) goto L6;
        r11.onPrepared(r10);
        return;
    }

    public void onProgress(int r10, long r11, long r12) {
        if (this.mTouchingProgressBar == true) goto L10;
        int r13 = this.seekToManulPosition;
        if (r13 == (-1)) goto L11;
        if (r13 <= r10) goto L8;
        return;
    L8:
        this.seekToManulPosition = -1;
        return;
    L11:
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        getDuration();
        return;
    }

    public void onSeekComplete() {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r10) {
        i.e("JZVD", "bottomProgress onStartTrackingTouch [" + hashCode() + "] ");
        cancelProgressTimer();
        ViewParent r11 = getParent();
    L3:
        if (r11 == null) goto L5;
        r11.requestDisallowInterceptTouchEvent(true);
        r11 = r11.getParent();
        goto L3
    }

    public void onStateAutoComplete() {
        i.e("JZVD", "onStateAutoComplete  [" + hashCode() + "] ");
        this.currentState = 6;
        cancelProgressTimer();
    }

    public void onStateError() {
        i.e("JZVD", "onStateError  [" + hashCode() + "] ");
        this.currentState = 7;
        cancelProgressTimer();
    }

    public void onStateNormal() {
        i.e("JZVD", "onStateNormal  [" + hashCode() + "] ");
        this.currentState = 0;
        cancelProgressTimer();
    }

    public void onStatePause() {
        i.a("JZVD", "onStatePause  [" + hashCode() + "] ");
        this.currentState = 5;
        unRegisterVolumeReceiver();
        restoreMusicVolume();
        updateMuteView(this.mIsMuteEnabled);
        startProgressTimer();
    }

    public void onStatePlaying() {
        i.e("JZVD", "onStatePlaying  [" + hashCode() + "] ");
        this.currentState = 3;
        registerVolumeReceiver();
        updateMuteStatus(this.mIsMuteEnabled);
        startProgressTimer();
    }

    public void onStatePrepared() {
        long r10 = this.seekToInAdvance;
        if (r10 == 0) goto L5;
        JZMediaManager.seekTo(r10);
        this.seekToInAdvance = 0;
        return;
    L5:
        long r11 = JZUtils.getSavedProgress(getContext(), this.jzDataSource.getCurrentUrl());
        if (r11 == 0) goto L10;
        JZMediaManager.seekTo(r11);
        return;
    }

    public void onStatePreparing() {
        i.e("JZVD", "onStatePreparing  [" + hashCode() + "] ");
        this.currentState = 1;
        resetProgressAndTime();
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r10) {
        i.e("JZVD", "bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        onEvent(5);
        startProgressTimer();
        ViewParent r11 = getParent();
    L3:
        if (r11 == null) goto L5;
        r11.requestDisallowInterceptTouchEvent(false);
        r11 = r11.getParent();
        goto L3
    L5:
        int r12 = this.currentState;
        if (r12 == 3) goto L9;
        if (r12 == 5) goto L9;
        return;
    L9:
        long r13 = (((long) r10.getProgress()) * getDuration()) / 100;
        this.seekToManulPosition = r10.getProgress();
        JZMediaManager.seekTo(r13);
        i.e("JZVD", "seekTo " + r13 + " [" + hashCode() + "] ");
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        return super.onTouchEvent(r11);
    }

    public void onVideoSizeChanged() {
        i.e("JZVD", "onVideoSizeChanged  [" + hashCode() + "] ");
        JZTextureView r10 = JZMediaManager.textureView;
        if (r10 == null) goto L9;
        int r11 = this.videoRotation;
        if (r11 == 0) goto L7;
        r10.setRotation(r11);
    L7:
        JZMediaManager.textureView.setVideoSize(JZMediaManager.instance().currentVideoWidth, JZMediaManager.instance().currentVideoHeight);
        return;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if ((r10 instanceof Jzvd) == false) goto L20;
        if (r11 == 0) goto L6;
        return;
    L6:
        if (isAutoPlayWithWifiEnable() == true) goto L8;
        return;
    L8:
        if (JZUtils.isWifiConnected(getContext()) == false) goto L23;
        JZDataSource r12 = this.jzDataSource;
        if (r12 != null) goto L12;
        return;
    L12:
        if (r12.urlsMap.isEmpty() == false) goto L14;
        return;
    L14:
        if (this.jzDataSource.getCurrentUrl() != null) goto L17;
        return;
    L17:
        if (this.currentState != 0) goto L26;
        startVideo();
        return;
    L26:
        return;
    L23:
        return;
    }

    public void playOnThisJzvd() {
        i.e("JZVD", "playOnThisJzvd  [" + hashCode() + "] ");
        this.currentState = JzvdMgr.getSecondFloor().currentState;
        updateMuteStatus(JzvdMgr.getSecondFloor().isMuteEnabled());
        clearFloatScreen();
        setState(this.currentState);
        addTextureView();
    }

    public void release() {
        JZDataSource r10 = this.jzDataSource;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getCurrentUrl() != null) goto L8;
        return;
    L8:
        if (this.jzDataSource.getCurrentUrl().equals(JZMediaManager.getCurrentUrl()) == true) goto L10;
        return;
    L10:
        if ((System.currentTimeMillis() - CLICK_QUIT_FULLSCREEN_TIME) > 300) goto L12;
        return;
    L12:
        if (JzvdMgr.getSecondFloor() == null) goto L17;
        if (JzvdMgr.getSecondFloor().currentScreen != 2) goto L17;
        backPress();
        return;
    L17:
        if (JzvdMgr.getSecondFloor() == null) goto L19;
    L23:
        i.a("JZVD", "releaseMediaPlayer [" + hashCode() + "]");
        releaseAllVideos();
        return;
    L19:
        if (JzvdMgr.getFirstFloor() == null) goto L23;
        if (JzvdMgr.getFirstFloor().currentScreen != 2) goto L23;
        backPress();
    }

    public void removeTextureView() {
        JZMediaManager.setSavedSurfaceTexture(null);
        JZTextureView r10 = JZMediaManager.textureView;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getParent() == null) goto L9;
        ((ViewGroup) JZMediaManager.textureView.getParent()).removeView(JZMediaManager.textureView);
        return;
    }

    public void resetProgressAndTime() {
    }

    public void restoreSystemVolume() {
        unRegisterVolumeReceiver();
        restoreMusicVolume();
    }

    public void setAutoPlayWithWifiEnable(boolean r10) {
        this.isAutoPlayWithWifiEnable = r10;
    }

    public void setBackEnable(boolean r10) {
        ImageView r11 = this.backViewButton;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public void setBufferProgress(int r10) {
    }

    public void setFullScreenEnable(boolean r10) {
        this.isFullScreenEnable = r10;
        ImageView r11 = this.fullscreenButton;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public void setListener(Listener r10) {
        this.mListener = r10;
    }

    public void setLooping(boolean r10) {
        this.mLooping = r10;
    }

    public void setMuteEnable(boolean r10) {
        this.mIsMuteEnabled = r10;
        updateMuteStatus(r10);
    }

    public void setPausedByUser(boolean r10) {
        this.isPausedByUser = r10;
    }

    public void setState(int r10) {
        setState(r10, 0, 0);
    }

    public void setUp(String r10, String r11, int r12) {
        setUp(new JZDataSource(r10, r11), r12);
    }

    public void setUpWithCache(String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        if (r10.equals(this.mUrl) == false) goto L8;
        return;
    L8:
        if (this.mProxy != null) goto L10;
        this.mProxy = BaseApplication.k(getContext());
    L10:
        this.mUrl = r10;
        this.mProxy.registerCacheListener(this, r10);
        setUp(new JZDataSource(this.mProxy.getProxyUrl(r10), r11), r12);
    }

    public void setVideoRatio(int r10, int r11) {
        this.widthRatio = r10;
        this.heightRatio = r11;
        requestLayout();
    }

    public void showBrightnessDialog(int r10) {
    }

    public void showProgressDialog(float r10, String r11, long r12, String r13, long r14) {
    }

    public void showVolumeDialog(float r10, int r11) {
    }

    public void showWifiDialog() {
    }

    public void startProgressTimer() {
        i.e("JZVD", "startProgressTimer:  [" + hashCode() + "] ");
        cancelProgressTimer();
        this.UPDATE_PROGRESS_TIMER = new Timer();
        ProgressTimerTask r10 = new ProgressTimerTask(this);
        this.mProgressTimerTask = r10;
        this.UPDATE_PROGRESS_TIMER.schedule(r10, 0, 300);
    }

    public void startVideo() {
        JzvdMgr.completeAll();
        i.a("JZVD", "startVideo [" + hashCode() + "] ");
        updateMuteStatus(this.mIsMuteEnabled);
        initTextureView();
        addTextureView();
        this.mAudioManager.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
        JZUtils.scanForActivity(getContext()).getWindow().addFlags(128);
        JZMediaManager.setDataSource(this.jzDataSource);
        JZMediaManager.instance().positionInList = this.positionInList;
        onStatePreparing();
        JzvdMgr.setFirstFloor(this);
    }

    public void startWindowFullscreen() {
        i.e("JZVD", "startWindowFullscreen  [" + hashCode() + "] ");
        hideSupportActionBar(getContext());
        ViewGroup r10 = (ViewGroup) JZUtils.scanForActivity(getContext()).findViewById(R.id.content);
        int r11 = R$id.jz_fullscreen_id;
        View r12 = r10.findViewById(r11);
        if (r12 == null) goto L5;
        r10.removeView(r12);
    L5:
        this.textureViewContainer.removeView(JZMediaManager.textureView);
        Jzvd r13 = (Jzvd) getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});     // Catch: Exception -> L10
        r13.setBackgroundColor(-1);     // Catch: Exception -> L10
        r13.setId(r11);     // Catch: Exception -> L10
        r10.addView(r13, new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L10
        r13.setSystemUiVisibility(4102);     // Catch: Exception -> L10
        r13.setUp(this.jzDataSource, 2);     // Catch: Exception -> L10
        r13.setState(this.currentState);     // Catch: Exception -> L10
        r13.addTextureView();     // Catch: Exception -> L10
        r13.updateMuteStatus(this.mIsMuteEnabled);     // Catch: Exception -> L10
        r13.setBackEnable(true);     // Catch: Exception -> L10
        JzvdMgr.setSecondFloor(r13);     // Catch: Exception -> L10
        JZUtils.setRequestedOrientation(getContext(), 6);     // Catch: Exception -> L10
        r13.startProgressTimer();     // Catch: Exception -> L10
        CLICK_QUIT_FULLSCREEN_TIME = System.currentTimeMillis();     // Catch: Exception -> L10
        Listener r14 = this.mListener;     // Catch: Exception -> L10
        if (r14 == null) goto L15;
        r14.onFullScreen();     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void startWindowTiny() {
        i.e("JZVD", "startWindowTiny  [" + hashCode() + "] ");
        onEvent(9);
        int r10 = this.currentState;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r10 != 7) goto L7;
        return;
    L7:
        if (r10 == 6) goto L27;
        ViewGroup r11 = (ViewGroup) JZUtils.scanForActivity(getContext()).findViewById(R.id.content);
        int r12 = R$id.jz_tiny_id;
        View r13 = r11.findViewById(r12);
        if (r13 == null) goto L12;
        r11.removeView(r13);
    L12:
        this.textureViewContainer.removeView(JZMediaManager.textureView);
        Jzvd r14 = (Jzvd) getClass().getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()});     // Catch: Exception -> L15 InstantiationException -> L17
        r14.setId(r12);     // Catch: Exception -> L15 InstantiationException -> L17
        FrameLayout.LayoutParams r15 = new FrameLayout.LayoutParams(400, 400);     // Catch: Exception -> L15 InstantiationException -> L17
        r15.gravity = 85;     // Catch: Exception -> L15 InstantiationException -> L17
        r11.addView(r14, r15);     // Catch: Exception -> L15 InstantiationException -> L17
        r14.setUp(this.jzDataSource, 3);     // Catch: Exception -> L15 InstantiationException -> L17
        r14.setState(this.currentState);     // Catch: Exception -> L15 InstantiationException -> L17
        r14.addTextureView();     // Catch: Exception -> L15 InstantiationException -> L17
        JzvdMgr.setSecondFloor(r14);     // Catch: Exception -> L15 InstantiationException -> L17
        onStateNormal();     // Catch: Exception -> L15 InstantiationException -> L17
    L28:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public void unregisterCacheListener() {
        HttpProxyCacheServer r10 = this.mProxy;
        if (r10 == null) goto L6;
        r10.unregisterCacheListener(this);
        return;
    }

    public static void startFullscreen(Context r10, Class r11, JZDataSource r12) {
        hideSupportActionBar(r10);
        JZUtils.setRequestedOrientation(r10, 6);
        ViewGroup r13 = (ViewGroup) JZUtils.scanForActivity(r10).findViewById(R.id.content);
        int r14 = R$id.jz_fullscreen_id;
        View r15 = r13.findViewById(r14);
        if (r15 == null) goto L14;
        r13.removeView(r15);
    L14:
        Jzvd r16 = (Jzvd) r11.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10});     // Catch: Exception -> L7 InstantiationException -> L9
        r16.setId(r14);     // Catch: Exception -> L7 InstantiationException -> L9
        r13.addView(r16, new FrameLayout.LayoutParams(-1, -1));     // Catch: Exception -> L7 InstantiationException -> L9
        r16.setUp(r12, 2);     // Catch: Exception -> L7 InstantiationException -> L9
        CLICK_QUIT_FULLSCREEN_TIME = System.currentTimeMillis();     // Catch: Exception -> L7 InstantiationException -> L9
        r16.startButton.performClick();     // Catch: Exception -> L7 InstantiationException -> L9
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public void setState(int r10, int r11, int r12) {
        if (r10 != 0) goto L4;
        onStateNormal();
        return;
    L4:
        if (r10 != 1) goto L6;
        onStatePreparing();
        return;
    L6:
        if (r10 != 2) goto L8;
        changeUrl(r11, r12);
        return;
    L8:
        if (r10 != 3) goto L10;
        onStatePlaying();
        return;
    L10:
        if (r10 != 5) goto L12;
        onStatePause();
        return;
    L12:
        if (r10 != 6) goto L14;
        onStateAutoComplete();
        return;
    L14:
        if (r10 != 7) goto L30;
        onStateError();
        return;
    }

    public void setUp(JZDataSource r10, int r11) {
        if (this.jzDataSource == null) goto L10;
        if (r10.getCurrentUrl() == null) goto L10;
        if (this.jzDataSource.containsTheUrl(r10.getCurrentUrl()) == false) goto L10;
        return;
    L10:
        if (isCached() == false) goto L15;
        if (isSameUrl() == false) goto L15;
        return;
    L15:
        if (isCurrentJZVD() == false) goto L30;
        if (r10.containsTheUrl(JZMediaManager.getCurrentUrl()) == true) goto L48;
        if (isCached() == false) goto L30;
    L48:
        long r12 = JZMediaManager.getCurrentPosition();     // Catch: IllegalStateException -> L23
    L26:
        if (r12 == 0) goto L28;
        JZUtils.saveProgress(getContext(), JZMediaManager.getCurrentUrl(), r12);
    L28:
        JZMediaManager.instance().releaseMediaPlayer();
    L46:
        r10.looping = getLooping();
        this.jzDataSource = r10;
        this.currentScreen = r11;
        onStateNormal();
        return;
    L23:
        e = move-exception;
        e.printStackTrace();
        r12 = 0;
    L30:
        if (isCurrentJZVD() == false) goto L35;
        if (r10.containsTheUrl(JZMediaManager.getCurrentUrl()) == true) goto L35;
        startWindowTiny();
    L35:
        if (isCurrentJZVD() == true) goto L44;
        if (r10.containsTheUrl(JZMediaManager.getCurrentUrl()) == false) goto L44;
        if (JzvdMgr.getCurrentJzvd() == null) goto L46;
        if (JzvdMgr.getCurrentJzvd().currentScreen != 3) goto L46;
        this.tmp_test_back = true;
    L44:
        if (isCurrentJZVD() == true) goto L46;
        r10.containsTheUrl(JZMediaManager.getCurrentUrl());
        goto L46
    }

    public void updateMuteView() {
        updateMuteView(this.mIsMuteEnabled);
    }

    public void changeUrl(JZDataSource r10, long r11) {
        this.currentState = 2;
        this.seekToInAdvance = r11;
        this.jzDataSource = r10;
        if (JzvdMgr.getSecondFloor() != null) goto L5;
    L7:
        JZMediaManager.setDataSource(r10);
        JZMediaManager.instance().prepare();
        return;
    L5:
        if (JzvdMgr.getFirstFloor() == null) goto L7;
        JzvdMgr.getFirstFloor().jzDataSource = r10;
        goto L7
    }

    public void changeUrl(String r10, String r11, long r12) {
        changeUrl(new JZDataSource(r10, r11), r12);
    }

    public Jzvd(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.mIsMuteEnabled = true;
        this.mLooping = true;
        this.isFullScreenEnable = false;
        this.isAutoPlayWithWifiEnable = true;
        this.currentState = -1;
        this.currentScreen = -1;
        this.seekToInAdvance = 0;
        this.widthRatio = 16;
        this.heightRatio = 9;
        this.positionInList = -1;
        this.videoRotation = 0;
        this.tmp_test_back = false;
        this.seekToManulPosition = -1;
        this.mRegistered = false;
        init(r10);
    }
}
