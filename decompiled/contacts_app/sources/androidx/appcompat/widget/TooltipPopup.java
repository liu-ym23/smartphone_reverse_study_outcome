package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos;
    private final int[] mTmpAppPos;
    private final Rect mTmpDisplayFrame;

    TooltipPopup(Context r5) {
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.mLayoutParams = r0;
        this.mTmpDisplayFrame = new Rect();
        this.mTmpAnchorPos = new int[2];
        this.mTmpAppPos = new int[2];
        this.mContext = r5;
        View r1 = LayoutInflater.from(r5).inflate(R.layout.abc_tooltip, null);
        this.mContentView = r1;
        this.mMessageView = (TextView) r1.findViewById(R.id.message);
        r0.setTitle(getClass().getSimpleName());
        r0.packageName = r5.getPackageName();
        r0.type = 1002;
        r0.width = -2;
        r0.height = -2;
        r0.format = -3;
        r0.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        r0.flags = 24;
    }

    void show(View r8, int r9, int r10, boolean r11, CharSequence r12) {
        if (isShowing() == false) goto L5;
        hide();
    L5:
        this.mMessageView.setText(r12);
        computePosition(r8, r9, r10, r11, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }

    void hide() {
        if (isShowing() == true) goto L5;
        return;
    L5:
        ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
    }

    boolean isShowing() {
        if (this.mContentView.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private void computePosition(View r9, int r10, int r11, boolean r12, WindowManager.LayoutParams r13) {
        r13.token = r9.getApplicationWindowToken();
        int r0 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (r9.getWidth() >= r0) goto L7;
        r10 = r9.getWidth() / 2;
    L7:
        if (r9.getHeight() < r0) goto L9;
        int r1 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
        int r2 = r11 + r1;
        int r14 = r11 - r1;
    L10:
        r13.gravity = 49;
        Resources r3 = this.mContext.getResources();
        if (r12 == false) goto L13;
        int r4 = R.dimen.tooltip_y_offset_touch;
    L14:
        int r5 = r3.getDimensionPixelOffset(r4);
        View r6 = getAppRootView(r9);
        if (r6 != null) goto L18;
        Log.e(TAG, "Cannot find app view");
        return;
    L18:
        r6.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        if (this.mTmpDisplayFrame.left < 0) goto L21;
    L27:
        r6.getLocationOnScreen(this.mTmpAppPos);
        r9.getLocationOnScreen(this.mTmpAnchorPos);
        int[] r15 = this.mTmpAnchorPos;
        int r7 = r15[0];
        int[] r8 = this.mTmpAppPos;
        int r16 = r7 - r8[0];
        r15[0] = r16;
        r15[1] = r15[1] - r8[1];
        r13.x = (r16 + r10) - (r6.getWidth() / 2);
        int r17 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(r17, r17);
        int r18 = this.mContentView.getMeasuredHeight();
        int r19 = this.mTmpAnchorPos[1];
        int r110 = ((r14 + r19) - r5) - r18;
        int r111 = (r19 + r2) + r5;
        if (r12 == false) goto L33;
        if (r110 < 0) goto L31;
        r13.y = r110;
        return;
    L31:
        r13.y = r111;
        return;
    L33:
        if ((r18 + r111) > this.mTmpDisplayFrame.height()) goto L35;
        r13.y = r111;
        return;
    L35:
        r13.y = r110;
        return;
    L21:
        if (this.mTmpDisplayFrame.top >= 0) goto L27;
        Resources r20 = this.mContext.getResources();
        int r21 = r20.getIdentifier("status_bar_height", "dimen", "android");
        if (r21 == 0) goto L25;
        int r22 = r20.getDimensionPixelSize(r21);
    L26:
        DisplayMetrics r23 = r20.getDisplayMetrics();
        this.mTmpDisplayFrame.set(0, r22, r23.widthPixels, r23.heightPixels);
        goto L27
    L25:
        r22 = 0;
        goto L26
    L13:
        r4 = R.dimen.tooltip_y_offset_non_touch;
        goto L14
    L9:
        r2 = r9.getHeight();
        r14 = 0;
        goto L10
    }

    private static View getAppRootView(View r3) {
        View r0 = r3.getRootView();
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof WindowManager.LayoutParams) == true) goto L5;
    L7:
        Context r4 = r3.getContext();
    L9:
        if ((r4 instanceof ContextWrapper) == false) goto L15;
        if ((r4 instanceof Activity) == true) goto L13;
        r4 = ((ContextWrapper) r4).getBaseContext();
        goto L9
    L13:
        return ((Activity) r4).getWindow().getDecorView();
    L15:
        return r0;
    L5:
        if (((WindowManager.LayoutParams) r1).type != 2) goto L7;
        return r0;
    }
}
