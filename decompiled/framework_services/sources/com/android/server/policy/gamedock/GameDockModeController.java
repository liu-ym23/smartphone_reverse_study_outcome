package com.android.server.policy.gamedock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.window.ScreenCapture;
import com.android.server.autofill.HintsHelper;
import com.android.server.display.DisplayControl;

/* JADX INFO: loaded from: classes2.dex */
public class GameDockModeController {
    private static final String ALARM_BEGIN = "com.android.deskclock.ALARM_ALERT";
    private static final String GAME_APP_FOREGROUND = "nubia_game_scene";
    private static final String NUBIA_ACTION_GAME_MODE_START = "cn.nubia.intent.action.lock_screen_hang_up_option";
    private static final String NUBIA_ACTION_GAME_MODE_STOP = "cn.nubia.systemui.NOTIFICATION_CLICKED";
    public static final String STR_GAME_DOCK_MODE = "nubia_game_dock_mode";
    private static final String TAG = "GameDockModeController";
    private final boolean DEBUG;
    private boolean isDockUnlockViewShowing;
    private boolean isGameDockMode;
    private AudioManager mAudioManager;
    private Context mContext;
    private Bitmap mCurrentScreenBitmap;
    private Display mDisplay;
    private DisplayManager mDisplayManager;
    private GameDockModeView mDockModeUnlockView;
    private ContentObserver mForegroundAppObserver;
    private boolean mFromFloatAssist;
    private BroadcastReceiver mGameMockModeReceiver;
    private Handler mHandler;
    private final HandlerThread mHandlerThread;
    private boolean mIsGameModeAndRunning;
    private boolean mNeedRestore;
    private GameDockModePhoneStateListener mPhoneStateListener;
    private WindowManager mWindowManager;

    private final class GameDockModePhoneStateListener extends PhoneStateListener {
        final /* synthetic */ GameDockModeController this$0;

        GameDockModePhoneStateListener(GameDockModeController r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.telephony.PhoneStateListener
        public void onCallStateChanged(int state, String incomingNumber) {
            switch(state) {
                case 0: goto L12;
                case 1: goto L6;
                case 2: goto L4;
                default: goto L12;
            };
        L4:
            GameDockModeController.m7295$$Nest$mstopGameDockMode(this.this$0);
            return;
        L12:
            return;
        L6:
            if (GameDockModeController.m7289$$Nest$fgetmFromFloatAssist(this.this$0) == false) goto L10;
            GameDockModeController.m7295$$Nest$mstopGameDockMode(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetisDockUnlockViewShowing, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7285$$Nest$fgetisDockUnlockViewShowing(GameDockModeController r0) {
        return r0.isDockUnlockViewShowing;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetisGameDockMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7286$$Nest$fgetisGameDockMode(GameDockModeController r0) {
        return r0.isGameDockMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7287$$Nest$fgetmContext(GameDockModeController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDockModeUnlockView, reason: not valid java name */
    static /* bridge */ /* synthetic */ GameDockModeView m7288$$Nest$fgetmDockModeUnlockView(GameDockModeController r0) {
        return r0.mDockModeUnlockView;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFromFloatAssist, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7289$$Nest$fgetmFromFloatAssist(GameDockModeController r0) {
        return r0.mFromFloatAssist;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManager m7290$$Nest$fgetmWindowManager(GameDockModeController r0) {
        return r0.mWindowManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputisDockUnlockViewShowing, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7291$$Nest$fputisDockUnlockViewShowing(GameDockModeController r0, boolean r1) {
        r0.isDockUnlockViewShowing = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$misDisplayDockView, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7292$$Nest$misDisplayDockView(GameDockModeController r0, Intent r1) {
        return r0.isDisplayDockView(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowDockModeUnlockView, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7293$$Nest$mshowDockModeUnlockView(GameDockModeController r0) {
        r0.showDockModeUnlockView();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartGameDockMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7294$$Nest$mstartGameDockMode(GameDockModeController r0) {
        r0.startGameDockMode();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopGameDockMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7295$$Nest$mstopGameDockMode(GameDockModeController r0) {
        r0.stopGameDockMode();
    }

    public GameDockModeController(Context context) {
        this.DEBUG = false;
        this.isDockUnlockViewShowing = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsGameModeAndRunning = false;
        this.isGameDockMode = false;
        this.mNeedRestore = false;
        this.mGameMockModeReceiver = new AnonymousClass1(this);
        this.mContext = context;
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        this.mDisplayManager = (DisplayManager) context.getSystemService(DisplayManager.class);
        this.mDisplay = this.mContext.getDisplay();
        this.mAudioManager = (AudioManager) context.getSystemService(AudioManager.class);
        this.mHandlerThread = new HandlerThread(TAG);
        this.mHandlerThread.start();
        registerPhoneState();
        registerGameMockModeReceive();
        registerForegroundAppObserver();
        Settings.Global.putInt(this.mContext.getContentResolver(), STR_GAME_DOCK_MODE, 0);
        this.mIsGameModeAndRunning = true;
    }

    public long interceptKeyBeforeQueueing(KeyEvent event, int policyFlags, boolean isScreenOn) {
        int keyCode = event.getKeyCode();
        if (event.getAction() != 0) goto L5;
        boolean down = true;
    L6:
        int repeatCount = event.getRepeatCount();
        if (keyCode == 26) goto L9;
        return 0;
    L9:
        if (this.mIsGameModeAndRunning == true) goto L13;
        if (this.mFromFloatAssist == true) goto L13;
        return 0;
    L13:
        if (this.isGameDockMode == false) goto L19;
        interceptPowerKey(down, repeatCount);
        return -2;
    L19:
        return 0;
    L5:
        down = false;
        goto L6
    }

    private void interceptPowerKey(boolean down, int repeatCount) {
        if (down == false) goto L8;
        if (repeatCount == 0) goto L5;
        return;
    L5:
        if (this.isGameDockMode == false) goto L10;
        stopGameDockMode();
        return;
    L10:
        return;
    }

    private void registerGameMockModeReceive() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(NUBIA_ACTION_GAME_MODE_START);
        filter.addAction(NUBIA_ACTION_GAME_MODE_STOP);
        filter.addAction(ALARM_BEGIN);
        this.mContext.registerReceiver(this.mGameMockModeReceiver, filter, 2);
    }

    private void registerForegroundAppObserver() {
        final Handler r1 = this.mHandler;
        this.mForegroundAppObserver = new AnonymousClass2(this, r1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(GAME_APP_FOREGROUND), false, this.mForegroundAppObserver, -1);
    }

    private void startGameDockMode() {
        if (this.isGameDockMode == false) goto L5;
        return;
    L5:
        this.isGameDockMode = true;
        Settings.Global.putInt(this.mContext.getContentResolver(), STR_GAME_DOCK_MODE, 1);
        showDockView();
        if (isBrightnessAutoMode() == false) goto L9;
        setBrightnessMode(0);
        this.mNeedRestore = true;
        return;
    }

    private void stopGameDockMode() {
        if (this.isGameDockMode == true) goto L5;
        return;
    L5:
        this.isGameDockMode = false;
        Settings.Global.putInt(this.mContext.getContentResolver(), STR_GAME_DOCK_MODE, 0);
        removeDockView();
        if (this.mNeedRestore == false) goto L9;
        setBrightnessMode(1);
        this.mNeedRestore = false;
        return;
    }

    private void showDockView() {
        this.mHandler.postDelayed(new AnonymousClass3(this), 250);
    }

    private void showDockModeUnlockView() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        this.mDockModeUnlockView = new GameDockModeView(this.mContext);
        this.mDockModeUnlockView.setFocusable(true);
        this.mDockModeUnlockView.setFocusableInTouchMode(true);
        this.mDockModeUnlockView.setSystemUiVisibility(6);
        this.mDockModeUnlockView.setScreenShow(getCurrentScreenBitmap(displayMetrics.widthPixels, displayMetrics.heightPixels));
        this.mDockModeUnlockView.setOnSlideToUnlockListener(new AnonymousClass4(this));
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        params.type = 2003;
        params.flags = 1984;
        params.setTitle("GameDockView");
        params.format = 1;
        params.gravity = 51;
        params.x = 0;
        params.y = 0;
        params.width = displayMetrics.widthPixels;
        params.height = displayMetrics.heightPixels;
        int orientation = this.mContext.getResources().getConfiguration().orientation;
        if (orientation != 1) goto L6;
        params.screenOrientation = 1;
    L8:
        this.mWindowManager.addView(this.mDockModeUnlockView, params);
        return;
    L6:
        if (orientation != 2) goto L8;
        params.screenOrientation = 0;
        goto L8
    }

    private void removeDockView() {
        this.mHandler.post(new AnonymousClass5(this));
    }

    private boolean isBrightnessAutoMode() {
        if (getBrightnessMode(0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int getBrightnessMode(int defaultValue) {
        int brightnessMode = Settings.System.getInt(this.mContext.getContentResolver(), "screen_brightness_mode");     // Catch: Exception -> L5
        return brightnessMode;
    L5:
        e = move-exception;
        e.printStackTrace();
        return defaultValue;
    }

    private void setBrightnessMode(int mode) {
        Settings.System.putInt(this.mContext.getContentResolver(), "screen_brightness_mode", mode);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private void registerPhoneState() {
        this.mPhoneStateListener = new GameDockModePhoneStateListener(this, this.mHandlerThread.getLooper());
        TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService(HintsHelper.AUTOFILL_HINT_PHONE);
        telephonyManager.listen(this.mPhoneStateListener, 32);
    }

    private BitmapDrawable getCurrentScreenBitmap(int width, int height) {
        DisplayAddress.Physical r2 = this.mDisplay.getAddress();
        if ((r2 instanceof DisplayAddress.Physical) == true) goto L6;
        Slog.e(TAG, "Skipping Screenshot - Default display does not have a physical address: " + this.mDisplay);
        return null;
    L6:
        DisplayAddress.Physical physicalAddress = r2;
        IBinder displayToken = DisplayControl.getPhysicalDisplayToken(physicalAddress.getPhysicalDisplayId());
        ScreenCapture.DisplayCaptureArgs captureArgs = new ScreenCapture.DisplayCaptureArgs.Builder(displayToken).setSourceCrop(new Rect(0, 0, width, height)).setSize(width, height).build();
        ScreenCapture.ScreenshotHardwareBuffer screenshotBuffer = ScreenCapture.captureDisplay(captureArgs);
        if (screenshotBuffer != null) goto L9;
        Bitmap screenshotBitmap = null;
    L10:
        if (screenshotBitmap != null) goto L13;
        return null;
    L13:
        if (this.mCurrentScreenBitmap != null) goto L15;
    L17:
        boolean isScreenOriatationPortrait = true;
        this.mCurrentScreenBitmap = screenshotBitmap.copy(Bitmap.Config.ARGB_4444, true);
        if (this.mContext.getResources().getConfiguration().orientation == 1) goto L21;
        isScreenOriatationPortrait = false;
    L21:
        if (isScreenOriatationPortrait == false) goto L23;
        int roundingRadius = 20;
    L24:
        this.mCurrentScreenBitmap = getRoundBitmap(this.mCurrentScreenBitmap, roundingRadius);
        this.mCurrentScreenBitmap.setHasAlpha(false);
        this.mCurrentScreenBitmap.prepareToDraw();
        if (screenshotBitmap.isRecycled() == true) goto L27;
        screenshotBitmap.recycle();
    L27:
        BitmapDrawable currentScreenShotDrawable = new BitmapDrawable(this.mCurrentScreenBitmap);
        return currentScreenShotDrawable;
    L23:
        roundingRadius = 14;
        goto L24
    L15:
        if (this.mCurrentScreenBitmap.isRecycled() == true) goto L17;
        this.mCurrentScreenBitmap.recycle();
        goto L17
    L9:
        screenshotBitmap = screenshotBuffer.asBitmap();
        goto L10
    }

    private Bitmap getRoundBitmap(Bitmap bitmap, int roundPx) {
        Bitmap roundBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
        Paint paint = new Paint();
        Canvas canvas = new Canvas(roundBitmap);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-1);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);     // Catch: IllegalArgumentException -> L5
    L7:
        return roundBitmap;
    L5:
        ex = move-exception;
        ex.printStackTrace();
        goto L7
    }

    private int dp2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) ((dipValue * scale) + 0.5f);
    }

    private boolean isDisplayDockView(Intent intent) {
        this.mFromFloatAssist = intent.getBooleanExtra("isEntertainmentToolbox", false);
        if (this.mFromFloatAssist == true) goto L5;
        return true;
    L5:
        if (this.mAudioManager != null) goto L7;
        return true;
    L7:
        if (this.mAudioManager.isMusicActive() == true) goto L12;
        this.mFromFloatAssist = false;
        return false;
    L12:
        return true;
    }
}
