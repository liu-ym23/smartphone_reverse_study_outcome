package com.android.server.policy.gamedock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class GameDockModeView extends RelativeLayout implements View.OnTouchListener, View.OnClickListener {
    private final String POWER_MODE_MESSAGE;
    private Context mContext;
    private DisplayManager mDisplayManager;
    private Handler mHandler;
    private boolean mIsConsume;
    private LayoutInflater mLayoutInflater;
    private boolean mMoving;
    private int mOldLevel;
    private OnSlideToUnlockListener mOnSlideToUnlock;
    private float mStartX;
    private float mStartY;
    private int mTouchSlop;
    private View mWindowContentView;
    private WindowManager mWindowManager;
    private BroadcastReceiver powerChangeReceiver;
    private final Runnable runActualGameDock;
    private View vActualGameDock;
    private TextView vBatteryValue;
    private ImageView vScreenShot;

    public interface OnSlideToUnlockListener {
        void onSlideToUnlock();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOldLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7296$$Nest$fgetmOldLevel(GameDockModeView r0) {
        return r0.mOldLevel;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetvActualGameDock, reason: not valid java name */
    static /* bridge */ /* synthetic */ View m7297$$Nest$fgetvActualGameDock(GameDockModeView r0) {
        return r0.vActualGameDock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetvBatteryValue, reason: not valid java name */
    static /* bridge */ /* synthetic */ TextView m7298$$Nest$fgetvBatteryValue(GameDockModeView r0) {
        return r0.vBatteryValue;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmOldLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7299$$Nest$fputmOldLevel(GameDockModeView r0, int r1) {
        r0.mOldLevel = r1;
    }

    public GameDockModeView(Context context) {
        this(context, null);
    }

    public GameDockModeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameDockModeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.POWER_MODE_MESSAGE = "android.security2.power.mode";
        this.mHandler = new Handler(Looper.getMainLooper());
        this.runActualGameDock = new AnonymousClass1(this);
        this.mOldLevel = -1;
        this.powerChangeReceiver = new AnonymousClass2(this);
        this.mContext = context;
        init();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerPowerReceive();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mHandler.removeCallbacksAndMessages(null);
        unregistePowerReceiver();
        super.onDetachedFromWindow();
    }

    private void init() {
        this.mWindowManager = (WindowManager) this.mContext.getSystemService("window");
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService("display");
        DisplayMetrics dm = new DisplayMetrics();
        this.mWindowManager.getDefaultDisplay().getRealMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        int gameScene = Settings.Global.getInt(this.mContext.getContentResolver(), "nubia_game_scene", 0);
        if (height <= width) goto L5;
        int r4 = width / 2;
    L6:
        this.mTouchSlop = r4;
        this.mLayoutInflater = LayoutInflater.from(this.mContext);
        if (isScreenOriatationPortrait() == false) goto L9;
        int layoutId = 84148225;
    L10:
        if (gameScene == 0) goto L12;
    L16:
        this.mWindowContentView = this.mLayoutInflater.inflate(layoutId, this);
        this.vActualGameDock = this.mWindowContentView.findViewById(84082688);
        this.vBatteryValue = (TextView) this.mWindowContentView.findViewById(84082689);
        this.vScreenShot = (ImageView) this.mWindowContentView.findViewById(84082691);
        LinearLayout r5 = (LinearLayout) this.mWindowContentView.findViewById(84082692);
        setOnTouchListener(this);
        setBackgroundColor(AudioFormat.MAIN_MASK);
        showActualGameDock();
        return;
    L12:
        if (isScreenOriatationPortrait() == false) goto L14;
        int r6 = 84148227;
    L15:
        layoutId = r6;
        goto L16
    L14:
        r6 = 84148226;
        goto L15
    L9:
        layoutId = 84148224;
        goto L10
    L5:
        r4 = height / 2;
        goto L6
    }

    private void showActualGameDock() {
        if (this.mHandler.hasCallbacks(this.runActualGameDock) == false) goto L5;
        return;
    L5:
        this.mHandler.postDelayed(this.runActualGameDock, 5000);
    }

    public void setScreenShow(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable == null) goto L5;
        this.vScreenShot.setImageDrawable(bitmapDrawable);
        return;
    }

    public void setOnSlideToUnlockListener(OnSlideToUnlockListener onSlideToUnlockListener) {
        this.mOnSlideToUnlock = onSlideToUnlockListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        if (this.mMoving == false) goto L10;
        if (event.getAction() != 2) goto L7;
        boolean r0 = true;
    L8:
        this.mMoving = r0;
        goto L10
    L7:
        r0 = false;
    L10:
        switch(event.getAction()) {
            case 0: goto L36;
            case 1: goto L29;
            case 2: goto L13;
            default: goto L44;
        };
    L13:
        if (this.mMoving == true) goto L16;
        this.mStartX = event.getX();
        this.mStartY = event.getY();
        this.mMoving = true;
    L16:
        if (this.mIsConsume == true) goto L44;
        if (Math.abs(event.getX() - this.mStartX) > this.mTouchSlop) goto L22;
        if (Math.abs(event.getY() - this.mStartY) <= this.mTouchSlop) goto L44;
    L22:
        if (this.mMoving == false) goto L44;
        if (this.mOnSlideToUnlock == null) goto L44;
        if (this.vActualGameDock == null) goto L44;
        this.vActualGameDock.setVisibility(8);
        this.mOnSlideToUnlock.onSlideToUnlock();
        this.mIsConsume = true;
        goto L44
    L29:
        if (this.mIsConsume == true) goto L44;
        if (this.vActualGameDock == null) goto L44;
        if (this.vActualGameDock.getVisibility() == 0) goto L44;
        showActualGameDock();
        goto L44
    L36:
        if (this.mIsConsume == false) goto L38;
    L42:
        this.mIsConsume = false;
        this.mStartX = event.getX();
        this.mStartY = event.getY();
        goto L44
    L38:
        if (this.vActualGameDock == null) goto L42;
        if (this.vActualGameDock.getVisibility() == 8) goto L42;
        this.vActualGameDock.setVisibility(8);
    L44:
        return this.mIsConsume;
    }

    private void registerPowerReceive() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_CHANGED");
        filter.addAction("android.security2.power.mode");
        this.mContext.registerReceiver(this.powerChangeReceiver, filter, 2);
    }

    private void unregistePowerReceiver() {
        this.mContext.unregisterReceiver(this.powerChangeReceiver);
    }

    public boolean isScreenOriatationPortrait() {
        if (getContext().getResources().getConfiguration().orientation == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
