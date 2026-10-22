package androidx.core.view;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes3.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed != null) goto L6;
        this.mTempNestedScrollConsumed = new int[2];
    L6:
        return this.mTempNestedScrollConsumed;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public NestedScrollingChildHelper(View r100) {
        this.mView = r100;
    }

    private ViewParent getNestedScrollingParentForType(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return this.mNestedScrollingParentNonTouch;
    L10:
        return this.mNestedScrollingParentTouch;
    }

    public boolean hasNestedScrollingParent(int r100) {
        if (getNestedScrollingParentForType(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStopNestedScroll(View r100) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean r100) {
        if (this.mIsNestedScrollingEnabled == false) goto L5;
        ViewCompat.stopNestedScroll(this.mView);
    L5:
        this.mIsNestedScrollingEnabled = r100;
    }

    public boolean startNestedScroll(int r100) {
        return startNestedScroll(r100, 0);
    }

    public void stopNestedScroll(int r100) {
        ViewParent r101 = getNestedScrollingParentForType(r100);
        if (r101 == null) goto L6;
        ViewParentCompat.onStopNestedScroll(r101, this.mView, r100);
        setNestedScrollingParentForType(r100, null);
        return;
    }

    private void setNestedScrollingParentForType(int r100, ViewParent r101) {
        if (r100 != 0) goto L4;
        this.mNestedScrollingParentTouch = r101;
        return;
    L4:
        if (r100 != 1) goto L10;
        this.mNestedScrollingParentNonTouch = r101;
        return;
    }

    public boolean dispatchNestedPreFling(float r100, float r101) {
        if (isNestedScrollingEnabled() == false) goto L8;
        ViewParent r102 = getNestedScrollingParentForType(0);
        if (r102 == null) goto L8;
        return ViewParentCompat.onNestedPreFling(r102, this.mView, r100, r101);
    L8:
        return false;
    }

    public boolean startNestedScroll(int r100, int r101) {
        if (hasNestedScrollingParent(r101) == false) goto L6;
        return true;
    L6:
        if (isNestedScrollingEnabled() == false) goto L17;
        ViewParent r102 = this.mView.getParent();
        View r103 = this.mView;
    L8:
        if (r102 == null) goto L23;
        if (ViewParentCompat.onStartNestedScroll(r102, r103, this.mView, r100, r101) == true) goto L11;
        if ((r102 instanceof View) == false) goto L16;
        r103 = (View) r102;
    L16:
        r102 = r102.getParent();
        goto L8
    L11:
        setNestedScrollingParentForType(r101, r102);
        ViewParentCompat.onNestedScrollAccepted(r102, r103, this.mView, r100, r101);
        return true;
    L23:
        return false;
    L17:
        return false;
    }

    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        if (isNestedScrollingEnabled() == false) goto L8;
        ViewParent r103 = getNestedScrollingParentForType(0);
        if (r103 == null) goto L8;
        return ViewParentCompat.onNestedFling(r103, this.mView, r100, r101, r102);
    L8:
        return false;
    }

    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110) {
        return dispatchNestedPreScroll(r100, r101, r102, r110, 0);
    }

    public boolean dispatchNestedPreScroll(int r110, int r111, int[] r112, int[] r113, int r114) {
        if (isNestedScrollingEnabled() == false) goto L27;
        ViewParent r100 = getNestedScrollingParentForType(r114);
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r110 != 0) goto L13;
        if (r111 != 0) goto L13;
        if (r113 == null) goto L28;
        r113[0] = 0;
        r113[1] = 0;
        return false;
    L28:
        return false;
    L13:
        if (r113 == null) goto L15;
        this.mView.getLocationInWindow(r113);
        int r101 = r113[0];
        int r102 = r101;
        int r103 = r113[1];
    L16:
        if (r112 != null) goto L18;
        r112 = getTempNestedScrollConsumed();
    L18:
        r112[0] = 0;
        r112[1] = 0;
        ViewParentCompat.onNestedPreScroll(r100, this.mView, r110, r111, r112, r114);
        if (r113 == null) goto L22;
        this.mView.getLocationInWindow(r113);
        r113[0] = r113[0] - r102;
        r113[1] = r113[1] - r103;
    L22:
        if (r112[0] == 0) goto L24;
    L25:
        return true;
    L24:
        if (r112[1] != 0) goto L25;
        return false;
    L15:
        r102 = 0;
        r103 = 0;
        goto L16
    L27:
        return false;
    }

    public boolean dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113) {
        return dispatchNestedScrollInternal(r100, r110, r111, r112, r113, 0, null);
    }

    public boolean dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113, int r114) {
        return dispatchNestedScrollInternal(r100, r110, r111, r112, r113, r114, null);
    }

    private boolean dispatchNestedScrollInternal(int r110, int r111, int r112, int r113, int[] r210, int r211, int[] r212) {
        if (isNestedScrollingEnabled() == false) goto L25;
        ViewParent r100 = getNestedScrollingParentForType(r211);
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r110 != 0) goto L15;
        if (r111 != 0) goto L15;
        if (r112 != 0) goto L15;
        if (r113 != 0) goto L15;
        if (r210 == null) goto L25;
        r210[0] = 0;
        r210[1] = 0;
    L15:
        if (r210 == null) goto L17;
        this.mView.getLocationInWindow(r210);
        int r101 = r210[0];
        int r114 = r101;
        int r115 = r210[1];
    L18:
        if (r212 != null) goto L20;
        int[] r102 = getTempNestedScrollConsumed();
        r102[0] = 0;
        r102[1] = 0;
        int[] r116 = r102;
    L21:
        ViewParentCompat.onNestedScroll(r100, this.mView, r110, r111, r112, r113, r211, r116);
        if (r210 == null) goto L24;
        this.mView.getLocationInWindow(r210);
        r210[0] = r210[0] - r114;
        r210[1] = r210[1] - r115;
    L24:
        return true;
    L20:
        r116 = r212;
        goto L21
    L17:
        r114 = 0;
        r115 = 0;
    L25:
        return false;
    }

    public void dispatchNestedScroll(int r100, int r101, int r102, int r103, int[] r104, int r105, int[] r106) {
        dispatchNestedScrollInternal(r100, r101, r102, r103, r104, r105, r106);
    }
}
