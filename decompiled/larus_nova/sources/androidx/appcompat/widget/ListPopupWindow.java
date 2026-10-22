package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static final boolean DEBUG = false;
    static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sGetMaxAvailableHeightMethod;
    private static Method sSetClipToWindowEnabledMethod;
    private static Method sSetEpicenterBoundsMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private Rect mEpicenterBounds;
    private boolean mForceIgnoreOutsideTouch;
    final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private AdapterView.OnItemClickListener mItemClickListener;
    private AdapterView.OnItemSelectedListener mItemSelectedListener;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private boolean mOverlapAnchor;
    private boolean mOverlapAnchorSet;
    PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private final Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public class ListSelectorHider implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ListPopupWindow$ListSelectorHider_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ListPopupWindow$ListSelectorHider__run$___twin___() {
            this.this$0.clearListSelection();
        }

        public ListSelectorHider(ListPopupWindow r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ListPopupWindow$ListSelectorHider_com_larus_apm_impl_protector_RunnableLancet_run(ListSelectorHider r100) {
            r100.androidx_appcompat_widget_ListPopupWindow$ListSelectorHider__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class PopupDataSetObserver extends DataSetObserver {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (this.this$0.isShowing() == false) goto L6;
            this.this$0.show();
            return;
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            this.this$0.dismiss();
        }

        public PopupDataSetObserver(ListPopupWindow r100) {
            this.this$0 = r100;
        }
    }

    public class PopupScrollListener implements AbsListView.OnScrollListener {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView r100, int r101, int r102, int r103) {
        }

        public PopupScrollListener(ListPopupWindow r100) {
            this.this$0 = r100;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView r100, int r101) {
            if (r101 == 1) goto L5;
            return;
        L5:
            if (this.this$0.isInputMethodNotNeeded() == false) goto L7;
            return;
        L7:
            if (this.this$0.mPopup.getContentView() == null) goto L12;
            ListPopupWindow r102 = this.this$0;
            r102.mHandler.removeCallbacks(r102.mResizePopupRunnable);
            this.this$0.mResizePopupRunnable.run();
            return;
        }
    }

    public class PopupTouchInterceptor implements View.OnTouchListener {
        final /* synthetic */ ListPopupWindow this$0;

        public PopupTouchInterceptor(ListPopupWindow r100) {
            this.this$0 = r100;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r100, MotionEvent r101) {
            int r102 = r101.getAction();
            int r103 = (int) r101.getX();
            int r104 = (int) r101.getY();
            if (r102 != 0) goto L16;
            PopupWindow r105 = this.this$0.mPopup;
            if (r105 == null) goto L16;
            if (r105.isShowing() == false) goto L16;
            if (r103 < 0) goto L16;
            if (r103 >= this.this$0.mPopup.getWidth()) goto L16;
            if (r104 < 0) goto L16;
            if (r104 >= this.this$0.mPopup.getHeight()) goto L16;
            ListPopupWindow r106 = this.this$0;
            r106.mHandler.postDelayed(r106.mResizePopupRunnable, 250);
            return false;
        L16:
            if (r102 != 1) goto L21;
            ListPopupWindow r107 = this.this$0;
            r107.mHandler.removeCallbacks(r107.mResizePopupRunnable);
            return false;
        L21:
            return false;
        }
    }

    public class ResizePopupRunnable implements Runnable {
        final /* synthetic */ ListPopupWindow this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable__run$___twin___() {
            DropDownListView r100 = this.this$0.mDropDownList;
            if (r100 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r100) == true) goto L7;
            return;
        L7:
            if (this.this$0.mDropDownList.getCount() <= this.this$0.mDropDownList.getChildCount()) goto L14;
            int r101 = this.this$0.mDropDownList.getChildCount();
            ListPopupWindow r102 = this.this$0;
            if (r101 > r102.mListItemExpandMaximum) goto L15;
            r102.mPopup.setInputMethodMode(2);
            this.this$0.show();
            return;
        L15:
            return;
        }

        public ResizePopupRunnable(ListPopupWindow r100) {
            this.this$0 = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable_com_larus_apm_impl_protector_RunnableLancet_run(ResizePopupRunnable r100) {
            r100.androidx_appcompat_widget_ListPopupWindow$ResizePopupRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private static boolean isConfirmKey(int r100) {
        if (r100 != 66) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 23) goto L8;
        return false;
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L13
    L14:
        sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});     // Catch: NoSuchMethodException -> L7
    L9:
        if (Build.VERSION.SDK_INT > 23) goto L20;
        sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});     // Catch: NoSuchMethodException -> L12
        return;
    L21:
        return;
    }

    private int buildDropDown() {
        boolean r100 = true;
        if (this.mDropDownList != null) goto L25;
        Context r101 = this.mContext;
        this.mShowDropDownRunnable = new AnonymousClass2(this);
        DropDownListView r102 = createDropDownListView(r101, !this.mModal);
        this.mDropDownList = r102;
        Drawable r103 = this.mDropDownListHighlight;
        if (r103 == null) goto L7;
        r102.setSelector(r103);
    L7:
        this.mDropDownList.setAdapter(this.mAdapter);
        this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
        this.mDropDownList.setFocusable(true);
        this.mDropDownList.setFocusableInTouchMode(true);
        this.mDropDownList.setOnItemSelectedListener(new AnonymousClass3(this));
        this.mDropDownList.setOnScrollListener(this.mScrollListener);
        AdapterView.OnItemSelectedListener r104 = this.mItemSelectedListener;
        if (r104 == null) goto L10;
        this.mDropDownList.setOnItemSelectedListener(r104);
    L10:
        DropDownListView r105 = this.mDropDownList;
        View r106 = this.mPromptView;
        if (r106 == null) goto L23;
        LinearLayout r107 = new LinearLayout(r101);
        r107.setOrientation(1);
        LinearLayout.LayoutParams r108 = new LinearLayout.LayoutParams(-1, 0, 1.0f);
        int r109 = this.mPromptPosition;
        if (r109 == 0) goto L17;
        if (r109 != 1) goto L18;
        r107.addView(r105, r108);
        r107.addView(r106);
    L18:
        int r110 = this.mDropDownWidth;
        if (r110 < 0) goto L21;
        int r111 = Integer.MIN_VALUE;
    L22:
        r106.measure(View.MeasureSpec.makeMeasureSpec(r110, r111), 0);
        LinearLayout.LayoutParams r112 = (LinearLayout.LayoutParams) r106.getLayoutParams();
        int r113 = (r106.getMeasuredHeight() + r112.topMargin) + r112.bottomMargin;
        View r114 = r107;
    L24:
        this.mPopup.setContentView(r114);
    L29:
        Drawable r115 = this.mPopup.getBackground();
        if (r115 == null) goto L34;
        r115.getPadding(this.mTempRect);
        Rect r116 = this.mTempRect;
        int r117 = r116.top;
        int r118 = r116.bottom + r117;
        if (this.mDropDownVerticalOffsetSet == true) goto L36;
        this.mDropDownVerticalOffset = -r117;
    L36:
        if (this.mPopup.getInputMethodMode() == 2) goto L39;
        r100 = false;
    L39:
        int r119 = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, r100);
        if (this.mDropDownAlwaysVisible == true) goto L57;
        if (this.mDropDownHeight == (-1)) goto L57;
        int r120 = this.mDropDownWidth;
        if (r120 != (-2)) goto L47;
        int r121 = INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels;
        Rect r122 = this.mTempRect;
        int r123 = View.MeasureSpec.makeMeasureSpec(r121 - (r122.left + r122.right), Integer.MIN_VALUE);
    L51:
        int r124 = this.mDropDownList.measureHeightOfChildrenCompat(r123, 0, -1, r119 - r113, -1);
        if (r124 <= 0) goto L55;
        r113 = r113 + (r118 + (this.mDropDownList.getPaddingTop() + this.mDropDownList.getPaddingBottom()));
    L55:
        return r124 + r113;
    L47:
        if (r120 == (-1)) goto L49;
        r123 = View.MeasureSpec.makeMeasureSpec(r120, 1073741824);
        goto L51
    L49:
        int r125 = INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).widthPixels;
        Rect r126 = this.mTempRect;
        r123 = View.MeasureSpec.makeMeasureSpec(r125 - (r126.left + r126.right), 1073741824);
    L57:
        return r119 + r118;
    L34:
        this.mTempRect.setEmpty();
        r118 = 0;
        goto L36
    L21:
        r110 = 0;
        r111 = 0;
        goto L22
    L17:
        r107.addView(r106);
        r107.addView(r105, r108);
        goto L18
    L23:
        r113 = 0;
        r114 = r105;
        goto L24
    L25:
        ViewGroup r127 = (ViewGroup) this.mPopup.getContentView();
        View r128 = this.mPromptView;
        if (r128 == null) goto L28;
        LinearLayout.LayoutParams r129 = (LinearLayout.LayoutParams) r128.getLayoutParams();
        r113 = (r128.getMeasuredHeight() + r129.topMargin) + r129.bottomMargin;
        goto L29
    L28:
        r113 = 0;
        goto L29
    }

    private void removePromptView() {
        View r100 = this.mPromptView;
        if (r100 == null) goto L8;
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L9;
        ((ViewGroup) r101).removeView(this.mPromptView);
        return;
    L9:
        return;
    }

    public void clearListSelection() {
        DropDownListView r100 = this.mDropDownList;
        if (r100 == null) goto L6;
        r100.setListSelectionHidden(true);
        r100.requestLayout();
        return;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(this.mPopup);
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public Rect getEpicenterBounds() {
        if (this.mEpicenterBounds != null) goto L7;
        return null;
    L7:
        return new Rect(this.mEpicenterBounds);
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        if (this.mDropDownVerticalOffsetSet == true) goto L7;
        return 0;
    L7:
        return this.mDropDownVerticalOffset;
    }

    public boolean isInputMethodNotNeeded() {
        if (this.mPopup.getInputMethodMode() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public Object getSelectedItem() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        if (isShowing() == true) goto L7;
        return Long.MIN_VALUE;
    L7:
        return this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        if (isShowing() == true) goto L7;
        return -1;
    L7:
        return this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        if (isShowing() == true) goto L7;
        return null;
    L7:
        return this.mDropDownList.getSelectedView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int r100 = buildDropDown();
        boolean r101 = isInputMethodNotNeeded();
        PopupWindowCompat.setWindowLayoutType(this.mPopup, this.mDropDownWindowLayoutType);
        boolean r102 = true;
        if (this.mPopup.isShowing() == true) goto L5;
        int r103 = this.mDropDownWidth;
        if (r103 != (-1)) goto L48;
        r103 = -1;
    L50:
        int r104 = this.mDropDownHeight;
        if (r104 != (-1)) goto L53;
        r100 = -1;
    L56:
        this.mPopup.setWidth(r103);
        this.mPopup.setHeight(r100);
        setPopupClipToScreenEnabled(true);
        PopupWindow r105 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L59;
    L61:
        boolean r106 = false;
    L62:
        r105.setOutsideTouchable(r106);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        if (this.mOverlapAnchorSet == false) goto L66;
        PopupWindowCompat.setOverlapAnchor(this.mPopup, this.mOverlapAnchor);
    L66:
        if (Build.VERSION.SDK_INT > 28) goto L72;
        Method r107 = sSetEpicenterBoundsMethod;
        if (r107 != null) goto L82;
    L73:
        PopupWindowCompat.showAsDropDown(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(-1);
        if (this.mModal == true) goto L76;
    L77:
        clearListSelection();
    L79:
        if (this.mModal == true) goto L85;
        this.mHandler.post(this.mHideSelector);
        return;
    L85:
        return;
    L76:
        if (this.mDropDownList.isInTouchMode() == false) goto L79;
    L82:
        r107.invoke(this.mPopup, new Object[]{this.mEpicenterBounds});     // Catch: Exception -> L71
        goto L73
    L72:
        this.mPopup.setEpicenterBounds(this.mEpicenterBounds);
        goto L73
    L59:
        if (this.mDropDownAlwaysVisible == true) goto L61;
        r106 = true;
        goto L62
    L53:
        if (r104 == (-2)) goto L56;
        r100 = r104;
        goto L56
    L48:
        if (r103 != (-2)) goto L50;
        r103 = getAnchorView().getWidth();
        goto L50
    L5:
        if (ViewCompat.isAttachedToWindow(getAnchorView()) == true) goto L7;
        return;
    L7:
        int r108 = this.mDropDownWidth;
        if (r108 != (-1)) goto L10;
        r108 = -1;
    L12:
        int r109 = this.mDropDownHeight;
        if (r109 != (-1)) goto L28;
        if (r101 == true) goto L17;
        r100 = -1;
    L17:
        if (r101 == false) goto L23;
        PopupWindow r110 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L21;
        int r111 = -1;
    L22:
        r110.setWidth(r111);
        this.mPopup.setHeight(0);
    L31:
        PopupWindow r112 = this.mPopup;
        if (this.mForceIgnoreOutsideTouch == false) goto L34;
    L36:
        r102 = false;
    L37:
        r112.setOutsideTouchable(r102);
        PopupWindow r113 = this.mPopup;
        View r114 = getAnchorView();
        int r115 = this.mDropDownHorizontalOffset;
        int r116 = this.mDropDownVerticalOffset;
        if (r108 >= 0) goto L40;
        int r117 = -1;
    L41:
        if (r100 >= 0) goto L43;
        int r118 = -1;
    L44:
        INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r113, r114, r115, r116, r117, r118);
        return;
    L43:
        r118 = r100;
        goto L44
    L40:
        r117 = r108;
        goto L41
    L34:
        if (this.mDropDownAlwaysVisible == true) goto L36;
    L21:
        r111 = 0;
        goto L22
    L23:
        PopupWindow r119 = this.mPopup;
        if (this.mDropDownWidth != (-1)) goto L26;
        int r120 = -1;
    L27:
        r119.setWidth(r120);
        this.mPopup.setHeight(-1);
        goto L31
    L26:
        r120 = 0;
        goto L27
    L28:
        if (r109 == (-2)) goto L31;
        r100 = r109;
        goto L31
    L10:
        if (r108 != (-2)) goto L12;
        r108 = getAnchorView().getWidth();
        goto L12
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public ListPopupWindow(Context r100) {
        this(r100, null, R.attr.listPopupWindowStyle);
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r100) {
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private void setPopupClipToScreenEnabled(boolean r100) {
        if (Build.VERSION.SDK_INT > 28) goto L8;
        Method r101 = sSetClipToWindowEnabledMethod;
        if (r101 == null) goto L13;
        r101.invoke(this.mPopup, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    L8:
        this.mPopup.setIsClippedToScreen(r100);
    }

    public View.OnTouchListener createDragToOpenListener(final View r100) {
        return new AnonymousClass1(this, r100);
    }

    public boolean performItemClick(int r100) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mItemClickListener == null) goto L11;
        DropDownListView r101 = this.mDropDownList;
        View r102 = r101.getChildAt(r100 - r101.getFirstVisiblePosition());
        ListAdapter r103 = r101.getAdapter();
        this.mItemClickListener.onItemClick(r101, r102, r100, r103.getItemId(r100));
        return true;
    L11:
        return true;
    }

    public void setAdapter(ListAdapter r100) {
        DataSetObserver r101 = this.mObserver;
        if (r101 != null) goto L5;
        this.mObserver = new PopupDataSetObserver(this);
    L8:
        this.mAdapter = r100;
        if (r100 == null) goto L11;
        r100.registerDataSetObserver(this.mObserver);
    L11:
        DropDownListView r102 = this.mDropDownList;
        if (r102 == null) goto L15;
        r102.setAdapter(this.mAdapter);
        return;
    L15:
        return;
    L5:
        ListAdapter r103 = this.mAdapter;
        if (r103 == null) goto L8;
        r103.unregisterDataSetObserver(r101);
        goto L8
    }

    public void setAnchorView(View r100) {
        this.mDropDownAnchorView = r100;
    }

    public void setAnimationStyle(int r100) {
        this.mPopup.setAnimationStyle(r100);
    }

    public void setBackgroundDrawable(Drawable r100) {
        this.mPopup.setBackgroundDrawable(r100);
    }

    public void setContentWidth(int r100) {
        Drawable r101 = this.mPopup.getBackground();
        if (r101 == null) goto L5;
        r101.getPadding(this.mTempRect);
        Rect r102 = this.mTempRect;
        this.mDropDownWidth = (r102.left + r102.right) + r100;
        return;
    L5:
        setWidth(r100);
    }

    public void setDropDownAlwaysVisible(boolean r100) {
        this.mDropDownAlwaysVisible = r100;
    }

    public void setDropDownGravity(int r100) {
        this.mDropDownGravity = r100;
    }

    public void setEpicenterBounds(Rect r100) {
        if (r100 == null) goto L4;
        Rect r101 = new Rect(r100);
    L5:
        this.mEpicenterBounds = r101;
        return;
    L4:
        r101 = null;
        goto L5
    }

    public void setForceIgnoreOutsideTouch(boolean r100) {
        this.mForceIgnoreOutsideTouch = r100;
    }

    public void setHeight(int r100) {
        if (r100 < 0) goto L4;
    L10:
        this.mDropDownHeight = r100;
        return;
    L4:
        if ((-2) == r100) goto L10;
        if ((-1) == r100) goto L10;
        throw new IllegalArgumentException("Invalid height. Must be a positive value, MATCH_PARENT, or WRAP_CONTENT.");
    }

    public void setHorizontalOffset(int r100) {
        this.mDropDownHorizontalOffset = r100;
    }

    public void setInputMethodMode(int r100) {
        this.mPopup.setInputMethodMode(r100);
    }

    public void setListItemExpandMax(int r100) {
        this.mListItemExpandMaximum = r100;
    }

    public void setListSelector(Drawable r100) {
        this.mDropDownListHighlight = r100;
    }

    public void setModal(boolean r100) {
        this.mModal = r100;
        this.mPopup.setFocusable(r100);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener r100) {
        this.mPopup.setOnDismissListener(r100);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r100) {
        this.mItemClickListener = r100;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener r100) {
        this.mItemSelectedListener = r100;
    }

    public void setOverlapAnchor(boolean r100) {
        this.mOverlapAnchorSet = true;
        this.mOverlapAnchor = r100;
    }

    public void setPromptPosition(int r100) {
        this.mPromptPosition = r100;
    }

    public void setPromptView(View r100) {
        boolean r101 = isShowing();
        if (r101 == false) goto L5;
        removePromptView();
    L5:
        this.mPromptView = r100;
        if (r101 == false) goto L9;
        show();
        return;
    }

    public void setSelection(int r100) {
        DropDownListView r101 = this.mDropDownList;
        if (isShowing() == false) goto L9;
        if (r101 == null) goto L10;
        r101.setListSelectionHidden(false);
        r101.setSelection(r100);
        if (r101.getChoiceMode() == 0) goto L11;
        r101.setItemChecked(r100, true);
        return;
    L11:
        return;
    L10:
        return;
    }

    public void setSoftInputMode(int r100) {
        this.mPopup.setSoftInputMode(r100);
    }

    public void setVerticalOffset(int r100) {
        this.mDropDownVerticalOffset = r100;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int r100) {
        this.mDropDownWidth = r100;
    }

    public void setWindowLayoutType(int r100) {
        this.mDropDownWindowLayoutType = r100;
    }

    public ListPopupWindow(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.listPopupWindowStyle);
    }

    public DropDownListView createDropDownListView(Context r100, boolean r101) {
        return new DropDownListView(r100, r101);
    }

    public boolean onKeyDown(int r110, KeyEvent r111) {
        if (isShowing() == true) goto L5;
    L49:
        return false;
    L5:
        if (r110 == 62) goto L49;
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L9;
    L10:
        int r100 = this.mDropDownList.getSelectedItemPosition();
        boolean r101 = !this.mPopup.isAboveAnchor();
        ListAdapter r102 = this.mAdapter;
        if (r102 == null) goto L19;
        boolean r103 = r102.areAllItemsEnabled();
        if (r103 == false) goto L15;
        int r104 = 0;
    L16:
        if (r103 == false) goto L18;
        int r105 = r102.getCount() - 1;
    L21:
        if (r101 == false) goto L25;
        if (r110 != 19) goto L25;
        if (r100 > r104) goto L25;
    L28:
        clearListSelection();
        this.mPopup.setInputMethodMode(1);
        show();
        return true;
    L25:
        if (r101 == true) goto L30;
        if (r110 != 20) goto L30;
        if (r100 >= r105) goto L28;
    L30:
        this.mDropDownList.setListSelectionHidden(false);
        if (this.mDropDownList.onKeyDown(r110, r111) == false) goto L41;
        this.mPopup.setInputMethodMode(2);
        this.mDropDownList.requestFocusFromTouch();
        show();
        if (r110 == 19) goto L40;
        if (r110 == 20) goto L40;
        if (r110 == 23) goto L40;
        if (r110 != 66) goto L49;
    L40:
        return true;
    L41:
        if (r101 == false) goto L45;
        if (r110 != 20) goto L45;
        if (r100 != r105) goto L49;
        return true;
    L45:
        if (r101 == true) goto L49;
        if (r110 != 19) goto L49;
        if (r100 != r104) goto L49;
        return true;
    L18:
        r105 = this.mDropDownList.lookForSelectablePosition(r102.getCount() - 1, false);
        goto L21
    L15:
        r104 = this.mDropDownList.lookForSelectablePosition(0, true);
        goto L16
    L19:
        r104 = Integer.MAX_VALUE;
        r105 = Integer.MIN_VALUE;
        goto L21
    L9:
        if (isConfirmKey(r110) == true) goto L49;
        goto L10
    }

    public boolean onKeyPreIme(int r100, KeyEvent r101) {
        if (r100 == 4) goto L5;
        return false;
    L5:
        if (isShowing() == false) goto L27;
        View r102 = this.mDropDownAnchorView;
        if (r101.getAction() != 0) goto L15;
        if (r101.getRepeatCount() != 0) goto L15;
        KeyEvent.DispatcherState r103 = r102.getKeyDispatcherState();
        if (r103 == null) goto L13;
        r103.startTracking(r101, this);
    L13:
        return true;
    L15:
        if (r101.getAction() != 1) goto L28;
        KeyEvent.DispatcherState r104 = r102.getKeyDispatcherState();
        if (r104 == null) goto L20;
        r104.handleUpEvent(r101);
    L20:
        if (r101.isTracking() == true) goto L22;
        return false;
    L22:
        if (r101.isCanceled() == true) goto L30;
        dismiss();
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    }

    public boolean onKeyUp(int r100, KeyEvent r101) {
        if (isShowing() == true) goto L5;
        return false;
    L5:
        if (this.mDropDownList.getSelectedItemPosition() < 0) goto L14;
        boolean r102 = this.mDropDownList.onKeyUp(r100, r101);
        if (r102 == true) goto L9;
    L11:
        return r102;
    L9:
        if (isConfirmKey(r100) == false) goto L11;
        dismiss();
        goto L11
    L14:
        return false;
    }

    public ListPopupWindow(Context r100, AttributeSet r101, int r102) {
        this(r100, r101, r102, 0);
    }

    private int getMaxAvailableHeight(View r100, int r101, boolean r102) {
        if (Build.VERSION.SDK_INT > 23) goto L11;
        Method r103 = sGetMaxAvailableHeightMethod;
        if (r103 == null) goto L9;
        return ((Integer) r103.invoke(this.mPopup, new Object[]{r100, Integer.valueOf(r101), Boolean.valueOf(r102)})).intValue();
    L9:
        return this.mPopup.getMaxAvailableHeight(r100, r101);
    L11:
        return this.mPopup.getMaxAvailableHeight(r100, r101, r102);
    }

    public ListPopupWindow(Context r100, AttributeSet r101, int r102, int r103) {
        this.mDropDownHeight = -2;
        this.mDropDownWidth = -2;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = 0;
        this.mDropDownAlwaysVisible = false;
        this.mForceIgnoreOutsideTouch = false;
        this.mListItemExpandMaximum = Integer.MAX_VALUE;
        this.mPromptPosition = 0;
        this.mResizePopupRunnable = new ResizePopupRunnable(this);
        this.mTouchInterceptor = new PopupTouchInterceptor(this);
        this.mScrollListener = new PopupScrollListener(this);
        this.mHideSelector = new ListSelectorHider(this);
        this.mTempRect = new Rect();
        this.mContext = r100;
        this.mHandler = new Handler(r100.getMainLooper());
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{android.R.attr.dropDownHorizontalOffset, android.R.attr.dropDownVerticalOffset}, r102, r103);
        this.mDropDownHorizontalOffset = r104.getDimensionPixelOffset(0, 0);
        int r105 = r104.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = r105;
        if (r105 == 0) goto L5;
        this.mDropDownVerticalOffsetSet = true;
    L5:
        r104.recycle();
        AppCompatPopupWindow r106 = new AppCompatPopupWindow(r100, r101, r102, r103);
        this.mPopup = r106;
        r106.setInputMethodMode(1);
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_widget_ListPopupWindow_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r100, View r101, int r102, int r103, int r104, int r105) {
        if ((r100 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r100) == false) goto L9;
        r100.update(r101, r102, r103, r104, r105);
        return;
    L9:
        if (PopupWindowLancet.rewriteDirectUpdateIfNeeded(r100, r101, r102, r103, r104, r105) == false) goto L11;
        return;
    L11:
        r100.update(r101, r102, r103, r104, r105);
    }
}
