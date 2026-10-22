package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes2.dex */
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    public boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW)).removeView(this.mContentView);
    }

    public TooltipPopup(Context r100) {
        WindowManager.LayoutParams r101 = new WindowManager.LayoutParams();
        this.mLayoutParams = r101;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = r100;
        View r102 = LayoutInflater.from(r100).inflate(R.layout.abc_tooltip, null);
        this.mContentView = r102;
        this.mMessageView = (TextView) r102.findViewById(R.id.message);
        r101.setTitle(getClass().getSimpleName());
        r101.packageName = r100.getPackageName();
        r101.type = 1002;
        r101.width = -2;
        r101.height = -2;
        r101.format = -3;
        r101.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        r101.flags = 24;
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private static View getAppRootView(View r100) {
        View r101 = r100.getRootView();
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof WindowManager.LayoutParams) == true) goto L5;
    L7:
        Context r103 = r100.getContext();
    L9:
        if ((r103 instanceof ContextWrapper) == false) goto L15;
        if ((r103 instanceof Activity) == true) goto L13;
        r103 = ((ContextWrapper) r103).getBaseContext();
        goto L9
    L13:
        return INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) r103).getWindow());
    L15:
        return r101;
    L5:
        if (((WindowManager.LayoutParams) r102).type != 2) goto L7;
        return r101;
    }

    public static void INVOKEINTERFACE_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView(WindowManager r100, View r101, ViewGroup.LayoutParams r102) {
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r101, r102);
        r100.addView(r101, r102);
    }

    private void computePosition(View r100, int r110, int r111, boolean r112, WindowManager.LayoutParams r113) {
        r113.token = r100.getApplicationWindowToken();
        int r101 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (r100.getWidth() >= r101) goto L7;
        r110 = r100.getWidth() / 2;
    L7:
        if (r100.getHeight() < r101) goto L9;
        int r102 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
        int r103 = r111 + r102;
        int r114 = r111 - r102;
    L10:
        r113.gravity = 49;
        Resources r104 = this.mContext.getResources();
        if (r112 == false) goto L13;
        int r105 = R.dimen.tooltip_y_offset_touch;
    L14:
        int r106 = r104.getDimensionPixelOffset(r105);
        View r107 = getAppRootView(r100);
        if (r107 != null) goto L17;
        return;
    L17:
        r107.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect r108 = this.mTmpDisplayFrame;
        if (r108.left < 0) goto L20;
    L26:
        r107.getLocationOnScreen(this.mTmpAppPos);
        r100.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r109 = this.mTmpAnchorPos;
        int r115 = r109[0];
        int[] r116 = this.mTmpAppPos;
        int r117 = r115 - r116[0];
        r109[0] = r117;
        r109[1] = r109[1] - r116[1];
        r113.x = (r117 + r110) - (r107.getWidth() / 2);
        int r118 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r118, r118);
        int r119 = this.mContentView.getMeasuredHeight();
        int r120 = this.mTmpAnchorPos[1];
        int r121 = ((r114 + r120) - r106) - r119;
        int r122 = (r120 + r103) + r106;
        if (r112 == false) goto L32;
        if (r121 < 0) goto L30;
        r113.y = r121;
        return;
    L30:
        r113.y = r122;
        return;
    L32:
        if ((r119 + r122) > this.mTmpDisplayFrame.height()) goto L34;
        r113.y = r122;
        return;
    L34:
        r113.y = r121;
        return;
    L20:
        if (r108.top >= 0) goto L26;
        Resources r123 = this.mContext.getResources();
        int r124 = r123.getIdentifier("status_bar_height", "dimen", "android");
        if (r124 == 0) goto L24;
        int r125 = r123.getDimensionPixelSize(r124);
    L25:
        DisplayMetrics r126 = INVOKEVIRTUAL_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r123);
        this.mTmpDisplayFrame.set(0, r125, r126.widthPixels, r126.heightPixels);
        goto L26
    L24:
        r125 = 0;
        goto L25
    L13:
        r105 = R.dimen.tooltip_y_offset_non_touch;
        goto L14
    L9:
        r103 = r100.getHeight();
        r114 = 0;
        goto L10
    }

    public void show(View r100, int r101, int r110, boolean r111, CharSequence r112) {
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r112);
        computePosition(r100, r101, r110, r111, this.mLayoutParams);
        INVOKEINTERFACE_androidx_appcompat_widget_TooltipPopup_com_obric_assistant_interaction_impl_window_helpers_WindowManagerLancet_addView((WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW), this.mContentView, this.mLayoutParams);
    }
}
