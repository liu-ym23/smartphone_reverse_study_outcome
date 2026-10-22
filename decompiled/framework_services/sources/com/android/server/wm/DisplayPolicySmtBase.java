package com.android.server.wm;

import android.content.Context;
import android.os.Handler;
import com.android.server.IBoostFrameworkOptEx;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DisplayPolicySmtBase {
    protected static final boolean DEBUG = false;
    protected static final int DELAY_APPLY_THUMB_WINDOW_MOVE_DOWN = 65;
    protected static final int MSG_SHOW_GAME_BAR = 1000;
    static final int MSG_UPDATE_SYSTEM_UI_TIMEOUT = 1001;
    protected static final String TAG = "WindowManager";
    private int mBoostDragHandle;
    private int mBoostFlingerHandle;
    private IBoostFrameworkOptEx mBoostFrameworkDrag;
    private IBoostFrameworkOptEx mBoostFrameworkFlinger;
    protected Context mContext;
    protected DisplayContent mDisplayContent;
    protected DisplayPolicy mDisplayPolicy;
    protected Handler mHandler;
    private boolean mIsPerfBoostFlingAcquired;
    boolean mLeftSlideLunchBubble;
    int mNavigationBarFixedState;
    int mNavigationBarMode;
    int mNavigationBarTriggerMode;
    int mNavigationIconHints;
    boolean mNeedUpdateSystemUiVisibility;
    boolean mOnUpdateSystemUiVisibility;
    WindowState mRecentWin;
    boolean mSmForceShowNavigationBar;
    int mStatusBarDisabled;

    public DisplayPolicySmtBase(DisplayPolicy displayPolicy, DisplayContent displayContent, Context context, Handler handler) {
        this.mNavigationBarFixedState = -1;
        this.mNavigationBarMode = -1;
        this.mNavigationBarTriggerMode = 0;
        this.mStatusBarDisabled = 0;
        this.mNavigationIconHints = 0;
        this.mSmForceShowNavigationBar = false;
        this.mOnUpdateSystemUiVisibility = false;
        this.mNeedUpdateSystemUiVisibility = false;
        this.mRecentWin = null;
        this.mBoostFrameworkFlinger = null;
        this.mBoostFrameworkDrag = null;
        this.mBoostFlingerHandle = -1;
        this.mBoostDragHandle = -1;
        this.mDisplayPolicy = displayPolicy;
        this.mDisplayContent = displayContent;
        this.mContext = context;
        this.mHandler = handler;
        if (this.mDisplayContent.isDefaultDisplay == false) goto L6;
        displayContent.registerPointerEventListener(SysOptBridge.getFactory().getScenesPointerEventListener());
        return;
    }

    public void onVerticalFling(int durationMs) {
        if (this.mBoostFrameworkFlinger != null) goto L5;
        return;
    L5:
        if (this.mBoostFlingerHandle != (-1)) goto L8;
        this.mBoostFlingerHandle = this.mBoostFrameworkFlinger.configBoostParams(4, 1814000, 4, 1226000);
    L8:
        if (this.mBoostFlingerHandle == (-1)) goto L12;
        this.mBoostFrameworkFlinger.enableBoost(durationMs + 160);
        this.mIsPerfBoostFlingAcquired = true;
        return;
    }

    public void onHorizontalFling(int durationMs) {
    }

    public void onScroll(boolean started) {
        if (this.mBoostFrameworkDrag != null) goto L5;
        return;
    L5:
        if (this.mBoostDragHandle != (-1)) goto L7;
        this.mBoostDragHandle = this.mBoostFrameworkDrag.configBoostParams(4, 1085000, 4, 1050000);
    L7:
        if (started == true) goto L9;
        this.mBoostFrameworkDrag.disableBoost();
        return;
    L9:
        if (this.mBoostDragHandle == (-1)) goto L14;
        this.mBoostFrameworkDrag.enableBoost(-1);
        return;
    }

    public void onDown() {
        if (this.mBoostFrameworkFlinger != null) goto L5;
        return;
    L5:
        if (this.mIsPerfBoostFlingAcquired == false) goto L9;
        this.mBoostFrameworkFlinger.disableBoost();
        this.mIsPerfBoostFlingAcquired = false;
        return;
    }
}
