package androidx.appcompat.widget;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

/* JADX INFO: loaded from: classes2.dex */
class TooltipCompatHandler implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View r100) {
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void scheduleShow() {
        this.mAnchor.postDelayed(this.mShowRunnable, ViewConfiguration.getLongPressTimeout());
    }

    public void hide() {
        if (sActiveHandler != this) goto L8;
        sActiveHandler = null;
        TooltipPopup r100 = this.mPopup;
        if (r100 == null) goto L8;
        r100.hide();
        this.mPopup = null;
        clearAnchorPos();
        this.mAnchor.removeOnAttachStateChangeListener(this);
    L8:
        if (sPendingHandler != this) goto L10;
        setPendingHandler(null);
    L10:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
    }

    private void clearAnchorPos() {
        this.mAnchorX = Integer.MAX_VALUE;
        this.mAnchorY = Integer.MAX_VALUE;
    }

    private static void setPendingHandler(TooltipCompatHandler r100) {
        TooltipCompatHandler r101 = sPendingHandler;
        if (r101 == null) goto L5;
        r101.cancelPendingShow();
    L5:
        sPendingHandler = r100;
        if (r100 == null) goto L9;
        r100.scheduleShow();
        return;
    }

    private boolean updateAnchorPos(MotionEvent r100) {
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        if (Math.abs(r101 - this.mAnchorX) <= this.mHoverSlop) goto L5;
    L8:
        this.mAnchorX = r101;
        this.mAnchorY = r102;
        return true;
    L5:
        if (Math.abs(r102 - this.mAnchorY) > this.mHoverSlop) goto L8;
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View r100) {
        this.mAnchorX = r100.getWidth() / 2;
        this.mAnchorY = r100.getHeight() / 2;
        show(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View r100) {
        hide();
    }

    public void show(boolean r100) {
        if (ViewCompat.isAttachedToWindow(this.mAnchor) == true) goto L5;
        return;
    L5:
        setPendingHandler(null);
        TooltipCompatHandler r101 = sActiveHandler;
        if (r101 == null) goto L8;
        r101.hide();
    L8:
        sActiveHandler = this;
        this.mFromTouch = r100;
        TooltipPopup r102 = new TooltipPopup(this.mAnchor.getContext());
        this.mPopup = r102;
        r102.show(this.mAnchor, this.mAnchorX, this.mAnchorY, this.mFromTouch, this.mTooltipText);
        this.mAnchor.addOnAttachStateChangeListener(this);
        if (this.mFromTouch == false) goto L12;
        long r103 = LONG_CLICK_HIDE_TIMEOUT_MS;
    L16:
        this.mAnchor.removeCallbacks(this.mHideRunnable);
        this.mAnchor.postDelayed(this.mHideRunnable, r103);
        return;
    L12:
        if ((ViewCompat.getWindowSystemUiVisibility(this.mAnchor) & 1) != 1) goto L14;
        long r104 = ViewConfiguration.getLongPressTimeout();
        long r105 = 3000;
    L15:
        r103 = r105 - r104;
        goto L16
    L14:
        r104 = ViewConfiguration.getLongPressTimeout();
        r105 = 15000;
        goto L15
    }

    private TooltipCompatHandler(View r100, CharSequence r101) {
        this.mShowRunnable = new AnonymousClass1(this);
        this.mHideRunnable = new AnonymousClass2(this);
        this.mAnchor = r100;
        this.mTooltipText = r101;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(r100.getContext()));
        clearAnchorPos();
        r100.setOnLongClickListener(this);
        r100.setOnHoverListener(this);
    }

    public static void setTooltipText(View r100, CharSequence r101) {
        TooltipCompatHandler r102 = sPendingHandler;
        if (r102 == null) goto L8;
        if (r102.mAnchor != r100) goto L8;
        setPendingHandler(null);
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L15;
        TooltipCompatHandler r103 = sActiveHandler;
        if (r103 != null) goto L12;
    L14:
        r100.setOnLongClickListener(null);
        r100.setLongClickable(false);
        r100.setOnHoverListener(null);
        return;
    L12:
        if (r103.mAnchor != r100) goto L14;
        r103.hide();
        goto L14
    L15:
        new TooltipCompatHandler(r100, r101);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View r100, MotionEvent r101) {
        if (this.mPopup != null) goto L5;
    L7:
        AccessibilityManager r102 = (AccessibilityManager) this.mAnchor.getContext().getSystemService("accessibility");
        if (r102.isEnabled() == true) goto L10;
    L12:
        int r103 = r101.getAction();
        if (r103 == 7) goto L19;
        if (r103 != 10) goto L25;
        clearAnchorPos();
        hide();
    L25:
        return false;
    L19:
        if (this.mAnchor.isEnabled() == false) goto L25;
        if (this.mPopup != null) goto L25;
        if (updateAnchorPos(r101) == false) goto L25;
        setPendingHandler(this);
        goto L25
    L10:
        if (r102.isTouchExplorationEnabled() == false) goto L12;
        return false;
    L5:
        if (this.mFromTouch == false) goto L7;
        return false;
    }
}
