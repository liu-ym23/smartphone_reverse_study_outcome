package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.lang.reflect.Field;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
class DropDownListView extends ListView {
    public static final int INVALID_POSITION = -1;
    public static final int NO_POSITION = -1;
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private Field mIsChildViewEnabled;
    private boolean mListSelectionHidden;
    private int mMotionPosition;
    ResolveHoverRunnable mResolveHoverRunnable;
    private ListViewAutoScrollHelper mScrollHelper;
    private int mSelectionBottomPadding;
    private int mSelectionLeftPadding;
    private int mSelectionRightPadding;
    private int mSelectionTopPadding;
    private GateKeeperDrawable mSelector;
    private final Rect mSelectorRect;

    public static class GateKeeperDrawable extends DrawableWrapper {
        private boolean mEnabled;

        public GateKeeperDrawable(Drawable r100) {
            super(r100);
            this.mEnabled = true;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas r100) {
            if (this.mEnabled == false) goto L6;
            super.draw(r100);
            return;
        }

        public void setEnabled(boolean r100) {
            this.mEnabled = r100;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setState(int[] r100) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setState(r100);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspot(float r100, float r101) {
            if (this.mEnabled == false) goto L6;
            super.setHotspot(r100, r101);
            return;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean setVisible(boolean r100, boolean r101) {
            if (this.mEnabled == true) goto L5;
            return false;
        L5:
            return super.setVisible(r100, r101);
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void setHotspotBounds(int r100, int r101, int r102, int r103) {
            if (this.mEnabled == false) goto L6;
            super.setHotspotBounds(r100, r101, r102, r103);
            return;
        }
    }

    public class ResolveHoverRunnable implements Runnable {
        final /* synthetic */ DropDownListView this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_DropDownListView$ResolveHoverRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_DropDownListView$ResolveHoverRunnable__run$___twin___() {
            DropDownListView r100 = this.this$0;
            r100.mResolveHoverRunnable = null;
            r100.drawableStateChanged();
        }

        public void cancel() {
            DropDownListView r100 = this.this$0;
            r100.mResolveHoverRunnable = null;
            r100.removeCallbacks(this);
        }

        public void post() {
            this.this$0.post(this);
        }

        public ResolveHoverRunnable(DropDownListView r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_DropDownListView$ResolveHoverRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ResolveHoverRunnable r100) {
            r100.androidx_appcompat_widget_DropDownListView$ResolveHoverRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View r100 = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (r100 == null) goto L5;
        r100.setPressed(false);
    L5:
        ViewPropertyAnimatorCompat r101 = this.mClickAnimation;
        if (r101 == null) goto L9;
        r101.cancel();
        this.mClickAnimation = null;
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) goto L5;
        return;
    L5:
        super.drawableStateChanged();
        setSelectorEnabled(true);
        updateSelectorStateCompat();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.hasWindowFocus() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isFocused() {
        if (this.mHijackFocus == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isFocused() == true) goto L8;
        return false;
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        if (this.mHijackFocus == false) goto L7;
        if (this.mListSelectionHidden == false) goto L7;
    L8:
        return true;
    L7:
        if (super.isInTouchMode() == true) goto L8;
        return false;
    }

    private void updateSelectorStateCompat() {
        Drawable r100 = getSelector();
        if (r100 != null) goto L5;
        return;
    L5:
        if (touchModeDrawsInPressedStateCompat() == true) goto L7;
        return;
    L7:
        if (isPressed() == false) goto L12;
        r100.setState(getDrawableState());
        return;
    }

    private boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState;
    }

    private void drawSelectorCompat(Canvas r100) {
        if (this.mSelectorRect.isEmpty() == true) goto L8;
        Drawable r101 = getSelector();
        if (r101 == null) goto L9;
        r101.setBounds(this.mSelectorRect);
        r101.draw(r100);
        return;
    L9:
        return;
    }

    private void setSelectorEnabled(boolean r100) {
        GateKeeperDrawable r101 = this.mSelector;
        if (r101 == null) goto L6;
        r101.setEnabled(r100);
        return;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        drawSelectorCompat(r100);
        super.dispatchDraw(r100);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        int r101 = r100.getActionMasked();
        if (r101 == 10) goto L9;
    L11:
        boolean r102 = super.onHoverEvent(r100);
        if (r101 != 9) goto L14;
    L17:
        int r103 = pointToPosition((int) r100.getX(), (int) r100.getY());
        if (r103 != (-1)) goto L20;
    L25:
        return r102;
    L20:
        if (r103 == getSelectedItemPosition()) goto L25;
        View r104 = getChildAt(r103 - getFirstVisiblePosition());
        if (r104.isEnabled() == false) goto L24;
        setSelectionFromTop(r103, r104.getTop() - getTop());
    L24:
        updateSelectorStateCompat();
        goto L25
    L14:
        if (r101 == 7) goto L17;
        setSelection(-1);
        goto L25
    L9:
        if (this.mResolveHoverRunnable != null) goto L11;
        ResolveHoverRunnable r105 = new ResolveHoverRunnable(this);
        this.mResolveHoverRunnable = r105;
        r105.post();
        goto L11
    L5:
        return super.onHoverEvent(r100);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 0) goto L6;
        this.mMotionPosition = pointToPosition((int) r100.getX(), (int) r100.getY());
    L6:
        ResolveHoverRunnable r101 = this.mResolveHoverRunnable;
        if (r101 == null) goto L10;
        r101.cancel();
    L10:
        return super.onTouchEvent(r100);
    }

    public void setListSelectionHidden(boolean r100) {
        this.mListSelectionHidden = r100;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable r100) {
        if (r100 == null) goto L4;
        GateKeeperDrawable r101 = new GateKeeperDrawable(r100);
    L5:
        this.mSelector = r101;
        super.setSelector(r101);
        Rect r102 = new Rect();
        if (r100 == null) goto L8;
        r100.getPadding(r102);
    L8:
        this.mSelectionLeftPadding = r102.left;
        this.mSelectionTopPadding = r102.top;
        this.mSelectionRightPadding = r102.right;
        this.mSelectionBottomPadding = r102.bottom;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public DropDownListView(Context r100, boolean r101) {
        super(r100, null, R.attr.dropDownListViewStyle);
        this.mSelectorRect = new Rect();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mHijackFocus = r101;
        setCacheColorHint(0);
        Field r102 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");     // Catch: NoSuchFieldException -> L5
        this.mIsChildViewEnabled = r102;     // Catch: NoSuchFieldException -> L5
        r102.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void clickPressedItem(View r100, int r101) {
        performItemClick(r100, r101, getItemIdAtPosition(r101));
    }

    private void positionSelectorCompat(int r100, View r101) {
        Rect r102 = this.mSelectorRect;
        r102.set(r101.getLeft(), r101.getTop(), r101.getRight(), r101.getBottom());
        r102.left -= this.mSelectionLeftPadding;
        r102.top -= this.mSelectionTopPadding;
        r102.right += this.mSelectionRightPadding;
        r102.bottom += this.mSelectionBottomPadding;
        boolean r103 = this.mIsChildViewEnabled.getBoolean(this);     // Catch: IllegalAccessException -> L13
        if (r101.isEnabled() == r103) goto L18;
        Field r104 = this.mIsChildViewEnabled;     // Catch: IllegalAccessException -> L13
        if (r103 == true) goto L8;
        boolean r105 = true;
    L9:
        r104.set(this, Boolean.valueOf(r105));     // Catch: IllegalAccessException -> L13
        if (r100 == (-1)) goto L19;
        refreshDrawableState();     // Catch: IllegalAccessException -> L13
        return;
    L19:
        return;
    L8:
        r105 = false;
        goto L9
    L18:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    private void positionSelectorLikeFocusCompat(int r100, View r101) {
        Drawable r102 = getSelector();
        boolean r103 = true;
        if (r102 != null) goto L5;
    L7:
        boolean r104 = false;
    L8:
        if (r104 == false) goto L10;
        r102.setVisible(false, false);
    L10:
        positionSelectorCompat(r100, r101);
        if (r104 == false) goto L18;
        Rect r105 = this.mSelectorRect;
        float r106 = r105.exactCenterX();
        float r107 = r105.exactCenterY();
        if (getVisibility() == 0) goto L16;
        r103 = false;
    L16:
        r102.setVisible(r103, false);
        DrawableCompat.setHotspot(r102, r106, r107);
        return;
    L18:
        return;
    L5:
        if (r100 == (-1)) goto L7;
        r104 = true;
        goto L8
    }

    public int lookForSelectablePosition(int r100, boolean r101) {
        ListAdapter r102 = getAdapter();
        if (r102 != null) goto L5;
    L29:
        return -1;
    L5:
        if (isInTouchMode() == true) goto L29;
        int r103 = r102.getCount();
        if (getAdapter().areAllItemsEnabled() == true) goto L25;
        if (r101 == false) goto L15;
        int r104 = Math.max(0, r100);
    L11:
        if (r104 >= r103) goto L20;
        if (r102.isEnabled(r104) == true) goto L20;
        r104 = r104 + 1;
    L20:
        if (r104 < 0) goto L24;
        if (r104 >= r103) goto L24;
        return r104;
    L24:
        return -1;
    L15:
        r104 = Math.min(r100, r103 - 1);
    L16:
        if (r104 < 0) goto L20;
        if (r102.isEnabled(r104) == true) goto L20;
        r104 = r104 - 1;
        goto L16
    L25:
        if (r100 < 0) goto L29;
        if (r100 >= r103) goto L29;
        return r100;
    }

    public boolean onForwardedEvent(MotionEvent r100, int r101) {
        int r102 = r100.getActionMasked();
        if (r102 != 1) goto L5;
        boolean r103 = false;
    L12:
        int r104 = r100.findPointerIndex(r101);
        if (r104 < 0) goto L9;
        int r105 = (int) r100.getX(r104);
        int r106 = (int) r100.getY(r104);
        int r107 = pointToPosition(r105, r106);
        if (r107 != (-1)) goto L18;
        boolean r108 = true;
    L21:
        if (r103 == false) goto L23;
        if (r108 == true) goto L23;
    L24:
        if (r103 == true) goto L26;
        ListViewAutoScrollHelper r109 = this.mScrollHelper;
        if (r109 == null) goto L32;
        r109.setEnabled(false);
    L32:
        return r103;
    L26:
        if (this.mScrollHelper != null) goto L28;
        this.mScrollHelper = new ListViewAutoScrollHelper(this);
    L28:
        this.mScrollHelper.setEnabled(true);
        this.mScrollHelper.onTouch(this, r100);
    L23:
        clearPressedItem();
        goto L24
    L18:
        View r110 = getChildAt(r107 - getFirstVisiblePosition());
        setPressedItem(r110, r107, r105, r106);
        if (r102 == 1) goto L20;
    L8:
        r108 = false;
        r103 = true;
        goto L21
    L20:
        clickPressedItem(r110, r107);
    L9:
        r108 = false;
        r103 = false;
        goto L21
    L5:
        if (r102 != 2) goto L7;
        r103 = true;
        goto L12
    L7:
        if (r102 == 3) goto L9;
        goto L8
    }

    private void positionSelectorLikeTouchCompat(int r100, View r101, float r102, float r103) {
        positionSelectorLikeFocusCompat(r100, r101);
        Drawable r104 = getSelector();
        if (r104 != null) goto L5;
        return;
    L5:
        if (r100 == (-1)) goto L9;
        DrawableCompat.setHotspot(r104, r102, r103);
        return;
    }

    private void setPressedItem(View r100, int r101, float r102, float r103) {
        this.mDrawsInPressedState = true;
        drawableHotspotChanged(r102, r103);
        if (isPressed() == true) goto L5;
        setPressed(true);
    L5:
        layoutChildren();
        int r104 = this.mMotionPosition;
        if (r104 == (-1)) goto L13;
        View r105 = getChildAt(r104 - getFirstVisiblePosition());
        if (r105 == null) goto L13;
        if (r105 == r100) goto L13;
        if (r105.isPressed() == false) goto L13;
        r105.setPressed(false);
    L13:
        this.mMotionPosition = r101;
        r100.drawableHotspotChanged(r102 - r100.getLeft(), r103 - r100.getTop());
        if (r100.isPressed() == true) goto L16;
        r100.setPressed(true);
    L16:
        positionSelectorLikeTouchCompat(r101, r100, r102, r103);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    public int measureHeightOfChildrenCompat(int r110, int r111, int r112, int r113, int r114) {
        int r115 = getListPaddingTop();
        int r116 = getListPaddingBottom();
        int r100 = getDividerHeight();
        Drawable r101 = getDivider();
        ListAdapter r102 = getAdapter();
        if (r102 == null) goto L5;
        int r117 = r115 + r116;
        if (r100 <= 0) goto L10;
        if (r101 == null) goto L10;
    L11:
        int r103 = r102.getCount();
        View r104 = null;
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L12:
        if (r105 >= r103) goto L38;
        int r108 = r102.getItemViewType(r105);
        if (r108 == r106) goto L16;
        r104 = null;
        r106 = r108;
    L16:
        r104 = r102.getView(r105, r104, this);
        ViewGroup.LayoutParams r109 = r104.getLayoutParams();
        if (r109 != null) goto L19;
        r109 = generateDefaultLayoutParams();
        r104.setLayoutParams(r109);
    L19:
        int r118 = r109.height;
        if (r118 <= 0) goto L22;
        int r119 = View.MeasureSpec.makeMeasureSpec(r118, 1073741824);
    L23:
        r104.measure(r110, r119);
        r104.forceLayout();
        if (r105 <= 0) goto L26;
        r117 = r117 + r100;
    L26:
        r117 = r117 + r104.getMeasuredHeight();
        if (r117 >= r113) goto L28;
        if (r114 < 0) goto L37;
        if (r105 < r114) goto L37;
        r107 = r117;
    L37:
        r105 = r105 + 1;
        goto L12
    L28:
        if (r114 < 0) goto L44;
        if (r105 <= r114) goto L45;
        if (r107 <= 0) goto L46;
        if (r117 != r113) goto L33;
        return r113;
    L33:
        return r107;
    L46:
        return r113;
    L45:
        return r113;
    L44:
        return r113;
    L22:
        r119 = View.MeasureSpec.makeMeasureSpec(0, 0);
        goto L23
    L38:
        return r117;
    L10:
        r100 = 0;
        goto L11
    L5:
        return r115 + r116;
    }
}
