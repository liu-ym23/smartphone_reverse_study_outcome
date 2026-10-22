package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private static final String TAG = "Toolbar";
    private androidx.appcompat.view.menu.d.a mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private v mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private b mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    MenuBuilder.a mMenuBuilderCallback;
    final androidx.core.view.h mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.d mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    c mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private z mWrapper;

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
            this.mViewType = 0;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.mViewType = 0;
            this.gravity = r3;
        }

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            this.mViewType = r2.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r2) {
            super(r2);
            this.mViewType = 0;
            copyMarginsFromCompat(r2);
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mViewType = 0;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r2) {
            this.leftMargin = r2.leftMargin;
            this.topMargin = r2.topMargin;
            this.rightMargin = r2.rightMargin;
            this.bottomMargin = r2.bottomMargin;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public SavedState(Parcel r2) {
            this(r2, null);
        }

        public SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            this.expandedMenuItemId = r1.readInt();
            if (r1.readInt() == 0) goto L5;
            boolean r3 = true;
        L6:
            this.isOverflowOpen = r3;
            return;
        L5:
            r3 = false;
            goto L6
        }

        public SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeInt(this.expandedMenuItemId);
            r1.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    static class a {
        static void a(Object r2, Object r3) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.aiagent.plugin"));
        }

        static void b(Object r2, Object r3) {
            ((OnBackInvokedDispatcher) ZeusTransformUtils.preCheckCast(r2, OnBackInvokedDispatcher.class, "com.obric.aiagent.plugin")).unregisterOnBackInvokedCallback((OnBackInvokedCallback) ZeusTransformUtils.preCheckCast(r3, OnBackInvokedCallback.class, "com.obric.aiagent.plugin"));
        }

        static OnBackInvokedDispatcher a(View r0) {
            return r0.findOnBackInvokedDispatcher();
        }

        static OnBackInvokedCallback a(Runnable r2) {
            final Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
            Objects.requireNonNull(r3);
            return new $$Lambda$4ezOK7vdu_oWZDLTTMzgHr1uNF4(r3);
        }
    }

    private class b implements androidx.appcompat.view.menu.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        MenuBuilder f398a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        MenuItemImpl f399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Toolbar f400c;

        @Override // androidx.appcompat.view.menu.d
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.d
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.d
        public void onCloseMenu(MenuBuilder r1, boolean r2) {
        }

        @Override // androidx.appcompat.view.menu.d
        public void onRestoreInstanceState(Parcelable r2) {
            Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.appcompat.view.menu.d
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.d
        public boolean onSubMenuSelected(SubMenuBuilder r1) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.d
        public void setCallback(androidx.appcompat.view.menu.d.a r2) {
            androidx.appcompat.view.menu.d.a r1 = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r2, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
        }

        b(Toolbar r1) {
            this.f400c = r1;
        }

        @Override // androidx.appcompat.view.menu.d
        public void initForMenu(Context r3, MenuBuilder r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            MenuBuilder r6 = this.f398a;
            if (r6 == null) goto L7;
            MenuItemImpl r0 = this.f399b;
            if (r0 == null) goto L7;
            r6.collapseItemActionView(r0);
        L7:
            this.f398a = r4;
        }

        @Override // androidx.appcompat.view.menu.d
        public void updateMenuView(boolean r5) {
            if (this.f399b == null) goto L17;
            MenuBuilder r6 = this.f398a;
            boolean r0 = false;
            if (r6 == null) goto L12;
            int r7 = r6.size();
            int r1 = 0;
        L7:
            if (r1 >= r7) goto L12;
            if (this.f398a.getItem(r1) == this.f399b) goto L10;
            r1 = r1 + 1;
            goto L7
        L10:
            r0 = true;
        L12:
            if (r0 == true) goto L18;
            collapseItemActionView(this.f398a, this.f399b);
            return;
        L18:
            return;
        }

        @Override // androidx.appcompat.view.menu.d
        public boolean expandItemActionView(MenuBuilder r4, MenuItemImpl r5) {
            this.f400c.ensureCollapseButtonView();
            ViewParent r6 = this.f400c.mCollapseButtonView.getParent();
            if (r6 != this.f400c) goto L5;
        L8:
            Toolbar r7 = this.f400c;
            r7.mExpandedActionView = r5.getActionView();
            this.f399b = r5;
            ViewParent r8 = this.f400c.mExpandedActionView.getParent();
            if (r8 != this.f400c) goto L11;
        L14:
            this.f400c.removeChildrenForExpandedActionView();
            this.f400c.requestLayout();
            r5.setActionViewExpanded(true);
            if (ZeusTransformUtils.instanceOf(this.f400c.mExpandedActionView, androidx.appcompat.view.c.class) == false) goto L17;
            ((androidx.appcompat.view.c) ZeusTransformUtils.preCheckCast(this.f400c.mExpandedActionView, androidx.appcompat.view.c.class, "com.obric.aiagent.plugin")).onActionViewExpanded();
        L17:
            this.f400c.updateBackInvokedCallbackState();
            return true;
        L11:
            if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L13;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.f400c.mExpandedActionView);
        L13:
            LayoutParams r9 = this.f400c.generateDefaultLayoutParams();
            r9.gravity = 8388611 | (this.f400c.mButtonGravity & 112);
            r9.mViewType = 2;
            this.f400c.mExpandedActionView.setLayoutParams(r9);
            Toolbar r10 = this.f400c;
            r10.addView(r10.mExpandedActionView);
            goto L14
        L5:
            if (ZeusTransformUtils.instanceOf(r6, ViewGroup.class) == false) goto L7;
            ((ViewGroup) ZeusTransformUtils.preCheckCast(r6, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(this.f400c.mCollapseButtonView);
        L7:
            Toolbar r11 = this.f400c;
            r11.addView(r11.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.d
        public boolean collapseItemActionView(MenuBuilder r3, MenuItemImpl r4) {
            if (ZeusTransformUtils.instanceOf(this.f400c.mExpandedActionView, androidx.appcompat.view.c.class) == false) goto L5;
            ((androidx.appcompat.view.c) ZeusTransformUtils.preCheckCast(this.f400c.mExpandedActionView, androidx.appcompat.view.c.class, "com.obric.aiagent.plugin")).onActionViewCollapsed();
        L5:
            Toolbar r5 = this.f400c;
            r5.removeView(r5.mExpandedActionView);
            Toolbar r6 = this.f400c;
            r6.removeView(r6.mCollapseButtonView);
            this.f400c.mExpandedActionView = null;
            this.f400c.addChildrenForExpandedActionView();
            this.f399b = null;
            this.f400c.requestLayout();
            r4.setActionViewExpanded(false);
            this.f400c.updateBackInvokedCallbackState();
            return true;
        }
    }

    public interface c {
        boolean a(MenuItem r1);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return generateLayoutParams(r1);
    }

    public Toolbar(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public Toolbar(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.toolbarStyle, "attr", "toolbarStyle"));
    }

    public Toolbar(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r3, r5, r12);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new androidx.core.view.h(new $$Lambda$a27oJTPm3gJru_UEnxCYPZCZOBg(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        y r13 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, R.styleable.Toolbar, r12, 0);
        ViewCompat.a(this, r3, R.styleable.Toolbar, r5, r13.a(), r12, 0);
        this.mTitleTextAppearance = r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleTextAppearance, "styleable", "Toolbar_titleTextAppearance"), 0);
        this.mSubtitleTextAppearance = r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_subtitleTextAppearance, "styleable", "Toolbar_subtitleTextAppearance"), 0);
        this.mGravity = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_android_gravity, "styleable", "Toolbar_android_gravity"), this.mGravity);
        this.mButtonGravity = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_buttonGravity, "styleable", "Toolbar_buttonGravity"), 48);
        int r14 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMargin, "styleable", "Toolbar_titleMargin"), 0);
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMargins, "styleable", "Toolbar_titleMargins")) == false) goto L5;
        r14 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMargins, "styleable", "Toolbar_titleMargins"), r14);
    L5:
        this.mTitleMarginBottom = r14;
        this.mTitleMarginTop = r14;
        this.mTitleMarginEnd = r14;
        this.mTitleMarginStart = r14;
        int r15 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMarginStart, "styleable", "Toolbar_titleMarginStart"), -1);
        if (r15 < 0) goto L8;
        this.mTitleMarginStart = r15;
    L8:
        int r16 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMarginEnd, "styleable", "Toolbar_titleMarginEnd"), -1);
        if (r16 < 0) goto L11;
        this.mTitleMarginEnd = r16;
    L11:
        int r17 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMarginTop, "styleable", "Toolbar_titleMarginTop"), -1);
        if (r17 < 0) goto L14;
        this.mTitleMarginTop = r17;
    L14:
        int r18 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleMarginBottom, "styleable", "Toolbar_titleMarginBottom"), -1);
        if (r18 < 0) goto L17;
        this.mTitleMarginBottom = r18;
    L17:
        this.mMaxButtonHeight = r13.e(ZeusTransformUtils.mapRes(R.styleable.Toolbar_maxButtonHeight, "styleable", "Toolbar_maxButtonHeight"), -1);
        int r19 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetStart, "styleable", "Toolbar_contentInsetStart"), Integer.MIN_VALUE);
        int r4 = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetEnd, "styleable", "Toolbar_contentInsetEnd"), Integer.MIN_VALUE);
        int r6 = r13.e(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetLeft, "styleable", "Toolbar_contentInsetLeft"), 0);
        int r7 = r13.e(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetRight, "styleable", "Toolbar_contentInsetRight"), 0);
        ensureContentInsets();
        this.mContentInsets.b(r6, r7);
        if (r19 != Integer.MIN_VALUE) goto L20;
        if (r4 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetStartWithNavigation, "styleable", "Toolbar_contentInsetStartWithNavigation"), Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r13.d(ZeusTransformUtils.mapRes(R.styleable.Toolbar_contentInsetEndWithActions, "styleable", "Toolbar_contentInsetEndWithActions"), Integer.MIN_VALUE);
        this.mCollapseIcon = r13.a(ZeusTransformUtils.mapRes(R.styleable.Toolbar_collapseIcon, "styleable", "Toolbar_collapseIcon"));
        this.mCollapseDescription = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_collapseContentDescription, "styleable", "Toolbar_collapseContentDescription"));
        CharSequence r110 = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_title, "styleable", "Toolbar_title"));
        if (TextUtils.isEmpty(r110) == true) goto L24;
        setTitle(r110);
    L24:
        CharSequence r111 = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_subtitle, "styleable", "Toolbar_subtitle"));
        if (TextUtils.isEmpty(r111) == true) goto L27;
        setSubtitle(r111);
    L27:
        this.mPopupContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        setPopupTheme(r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_popupTheme, "styleable", "Toolbar_popupTheme"), 0));
        Drawable r112 = r13.a(ZeusTransformUtils.mapRes(R.styleable.Toolbar_navigationIcon, "styleable", "Toolbar_navigationIcon"));
        if (r112 == null) goto L30;
        setNavigationIcon(r112);
    L30:
        CharSequence r113 = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_navigationContentDescription, "styleable", "Toolbar_navigationContentDescription"));
        if (TextUtils.isEmpty(r113) == true) goto L33;
        setNavigationContentDescription(r113);
    L33:
        Drawable r114 = r13.a(ZeusTransformUtils.mapRes(R.styleable.Toolbar_logo, "styleable", "Toolbar_logo"));
        if (r114 == null) goto L36;
        setLogo(r114);
    L36:
        CharSequence r115 = r13.c(ZeusTransformUtils.mapRes(R.styleable.Toolbar_logoDescription, "styleable", "Toolbar_logoDescription"));
        if (TextUtils.isEmpty(r115) == true) goto L40;
        setLogoDescription(r115);
    L40:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleTextColor, "styleable", "Toolbar_titleTextColor")) == false) goto L43;
        setTitleTextColor(r13.e(ZeusTransformUtils.mapRes(R.styleable.Toolbar_titleTextColor, "styleable", "Toolbar_titleTextColor")));
    L43:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_subtitleTextColor, "styleable", "Toolbar_subtitleTextColor")) == false) goto L46;
        setSubtitleTextColor(r13.e(ZeusTransformUtils.mapRes(R.styleable.Toolbar_subtitleTextColor, "styleable", "Toolbar_subtitleTextColor")));
    L46:
        if (r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_menu, "styleable", "Toolbar_menu")) == false) goto L48;
        inflateMenu(r13.g(ZeusTransformUtils.mapRes(R.styleable.Toolbar_menu, "styleable", "Toolbar_menu"), 0));
    L48:
        r13.b();
        return;
    L20:
        this.mContentInsets.a(r19, r4);
        goto L21
    }

    public void setBackInvokedCallbackEnabled(boolean r2) {
        if (this.mBackInvokedCallbackEnabled == r2) goto L6;
        this.mBackInvokedCallbackEnabled = r2;
        updateBackInvokedCallbackState();
        return;
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    public void setPopupTheme(int r5) {
        if (this.mPopupTheme == r5) goto L9;
        this.mPopupTheme = r5;
        if (r5 != 0) goto L7;
        this.mPopupContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        return;
    L7:
        this.mPopupContext = ZeusTransformUtils.wrapperContext(new ContextThemeWrapper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5), "com.obric.aiagent.plugin");
        return;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public void setTitleMargin(int r1, int r2, int r3, int r4) {
        this.mTitleMarginStart = r1;
        this.mTitleMarginTop = r2;
        this.mTitleMarginEnd = r3;
        this.mTitleMarginBottom = r4;
        requestLayout();
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public void setTitleMarginStart(int r1) {
        this.mTitleMarginStart = r1;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public void setTitleMarginTop(int r1) {
        this.mTitleMarginTop = r1;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public void setTitleMarginEnd(int r1) {
        this.mTitleMarginEnd = r1;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public void setTitleMarginBottom(int r1) {
        this.mTitleMarginBottom = r1;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r3) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        super.onRtlPropertiesChanged(r3);
    L5:
        ensureContentInsets();
        v r2 = this.mContentInsets;
        boolean r0 = true;
        if (r3 == 1) goto L9;
        r0 = false;
    L9:
        r2.a(r0);
    }

    public void setLogo(int r4) {
        setLogo(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r1 = this.mMenuView;
        if (r1 == null) goto L9;
        if (r1.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean showOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.showOverflowMenu() == false) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public void setMenu(MenuBuilder r4, ActionMenuPresenter r5) {
        if (r4 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r0 = this.mMenuView.peekMenu();
        if (r0 != r4) goto L9;
        return;
    L9:
        if (r0 == null) goto L12;
        r0.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r0.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new b(this);
    L14:
        r5.b(true);
        if (r4 == null) goto L17;
        r4.addMenuPresenter(r5, this.mPopupContext);
        r4.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r5);
        this.mOuterActionMenuPresenter = r5;
        updateBackInvokedCallbackState();
        return;
    L17:
        r5.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r5.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    public void dismissPopupMenus() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L6;
        r0.dismissPopupMenus();
        return;
    }

    public boolean isTitleTruncated() {
        TextView r4 = this.mTitleTextView;
        if (r4 != null) goto L5;
        return false;
    L5:
        Layout r5 = r4.getLayout();
        if (r5 != null) goto L8;
        return false;
    L8:
        int r1 = r5.getLineCount();
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L15;
        if (r5.getEllipsisCount(r2) > 0) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    public void setLogo(Drawable r3) {
        if (r3 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r2 = this.mLogoView;
        if (r2 == null) goto L15;
        r2.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageView r0 = this.mLogoView;
        if (r0 == null) goto L11;
        if (isChildOrHidden(r0) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public Drawable getLogo() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public void setLogoDescription(int r4) {
        setLogoDescription(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getText(r4));
    }

    public void setLogoDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r2 = this.mLogoView;
        if (r2 == null) goto L9;
        r2.setContentDescription(r4);
        return;
    }

    public CharSequence getLogoDescription() {
        ImageView r0 = this.mLogoView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    public boolean hasExpandedActionView() {
        b r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.f399b == null) goto L7;
        return true;
    }

    public void collapseActionView() {
        b r0 = this.mExpandedMenuPresenter;
        if (r0 != null) goto L5;
        MenuItemImpl r1 = null;
    L6:
        if (r1 == null) goto L9;
        r1.collapseActionView();
        return;
    L9:
        return;
    L5:
        r1 = r0.f399b;
        goto L6
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public void setTitle(int r4) {
        setTitle(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getText(r4));
    }

    public void setTitle(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        TextView r0 = this.mTitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mTitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r5);
    L23:
        this.mTitleText = r5;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mTitleTextView = r3;
        r3.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r6 = this.mTitleTextAppearance;
        if (r6 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r2, r6);
    L9:
        ColorStateList r7 = this.mTitleTextColor;
        if (r7 == null) goto L13;
        this.mTitleTextView.setTextColor(r7);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public void setSubtitle(int r4) {
        setSubtitle(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getText(r4));
    }

    public void setSubtitle(CharSequence r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r5) == false) goto L5;
        TextView r0 = this.mSubtitleTextView;
        if (r0 != null) goto L18;
    L20:
        TextView r1 = this.mSubtitleTextView;
        if (r1 == null) goto L23;
        r1.setText(r5);
    L23:
        this.mSubtitleText = r5;
        return;
    L18:
        if (isChildOrHidden(r0) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        AppCompatTextView r3 = new AppCompatTextView(r2);
        this.mSubtitleTextView = r3;
        r3.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r6 = this.mSubtitleTextAppearance;
        if (r6 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r2, r6);
    L9:
        ColorStateList r7 = this.mSubtitleTextColor;
        if (r7 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r7);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setTitleTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.mTitleTextAppearance = r4;
        TextView r2 = this.mTitleTextView;
        if (r2 == null) goto L6;
        r2.setTextAppearance(r5, r4);
        return;
    }

    public void setSubtitleTextAppearance(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.mSubtitleTextAppearance = r4;
        TextView r2 = this.mSubtitleTextView;
        if (r2 == null) goto L6;
        r2.setTextAppearance(r5, r4);
        return;
    }

    public void setTitleTextColor(int r1) {
        setTitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setTitleTextColor(ColorStateList r1) {
        this.mTitleTextColor = r1;
        TextView r0 = this.mTitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public void setSubtitleTextColor(int r1) {
        setSubtitleTextColor(ColorStateList.valueOf(r1));
    }

    public void setSubtitleTextColor(ColorStateList r1) {
        this.mSubtitleTextColor = r1;
        TextView r0 = this.mSubtitleTextView;
        if (r0 == null) goto L6;
        r0.setTextColor(r1);
        return;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public void setNavigationContentDescription(int r4) {
        if (r4 == 0) goto L4;
        CharSequence r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getText(r4);
    L5:
        setNavigationContentDescription(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setNavigationContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L9;
        r0.setContentDescription(r4);
        aa.a(this.mNavButtonView, r4);
        return;
    }

    public void setNavigationIcon(int r4) {
        setNavigationIcon(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public void setNavigationIcon(Drawable r3) {
        if (r3 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r2 = this.mNavButtonView;
        if (r2 == null) goto L15;
        r2.setImageDrawable(r3);
        return;
    L15:
        return;
    L6:
        ImageButton r0 = this.mNavButtonView;
        if (r0 == null) goto L11;
        if (isChildOrHidden(r0) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public Drawable getNavigationIcon() {
        ImageButton r0 = this.mNavButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public void setNavigationOnClickListener(View.OnClickListener r3) {
        View.OnClickListener r4 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r4);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getContentDescription();
    }

    public void setCollapseContentDescription(int r4) {
        if (r4 == 0) goto L4;
        CharSequence r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getText(r4);
    L5:
        setCollapseContentDescription(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    public void setCollapseContentDescription(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (TextUtils.isEmpty(r4) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r2 = this.mCollapseButtonView;
        if (r2 == null) goto L9;
        r2.setContentDescription(r4);
        return;
    }

    public Drawable getCollapseIcon() {
        ImageButton r0 = this.mCollapseButtonView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDrawable();
    }

    public void setCollapseIcon(int r4) {
        setCollapseIcon(androidx.appcompat.a.a.a.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4));
    }

    public void setCollapseIcon(Drawable r1) {
        if (r1 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r1);
        return;
    L4:
        ImageButton r2 = this.mCollapseButtonView;
        if (r2 == null) goto L9;
        r2.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public void setOverflowIcon(Drawable r1) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r1);
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() != null) goto L9;
        MenuBuilder r0 = (MenuBuilder) ZeusTransformUtils.preCheckCast(this.mMenuView.getMenu(), MenuBuilder.class, "com.obric.aiagent.plugin");
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new b(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r0.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        updateBackInvokedCallbackState();
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r0 = new ActionMenuView((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        this.mMenuView = r0;
        r0.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new AnonymousClass3(this));
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = 8388613 | (this.mButtonGravity & 112);
        this.mMenuView.setLayoutParams(r1);
        addSystemView(this.mMenuView, false);
        return;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public void inflateMenu(int r2) {
        getMenuInflater().inflate(r2, getMenu());
    }

    public void setOnMenuItemClickListener(c r3) {
        this.mOnMenuItemClickListener = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    public void setContentInsetsRelative(int r1, int r2) {
        ensureContentInsets();
        this.mContentInsets.a(r1, r2);
    }

    public int getContentInsetStart() {
        v r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public int getContentInsetEnd() {
        v r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    public void setContentInsetsAbsolute(int r1, int r2) {
        ensureContentInsets();
        this.mContentInsets.b(r1, r2);
    }

    public int getContentInsetLeft() {
        v r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.a();
    }

    public int getContentInsetRight() {
        v r0 = this.mContentInsets;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.b();
    }

    public int getContentInsetStartWithNavigation() {
        int r0 = this.mContentInsetStartWithNavigation;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int r2) {
        if (r2 >= 0) goto L5;
        r2 = Integer.MIN_VALUE;
    L5:
        if (r2 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public int getContentInsetEndWithActions() {
        int r0 = this.mContentInsetEndWithActions;
        if (r0 == Integer.MIN_VALUE) goto L6;
        return r0;
    L6:
        return getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int r2) {
        if (r2 >= 0) goto L5;
        r2 = Integer.MIN_VALUE;
    L5:
        if (r2 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r2;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        MenuBuilder r1 = r0.peekMenu();
        if (r1 == null) goto L9;
        if (r1.hasVisibleItems() == false) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r2 = false;
        goto L10
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.i(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.i(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.toolbarNavigationButtonStyle, "attr", "toolbarNavigationButtonStyle"));
        LayoutParams r0 = generateDefaultLayoutParams();
        r0.gravity = 8388611 | (this.mButtonGravity & 112);
        this.mNavButtonView.setLayoutParams(r0);
        return;
    }

    View getNavButtonView() {
        return this.mNavButtonView;
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r0 = new AppCompatImageButton((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), null, ZeusTransformUtils.mapRes(R.attr.toolbarNavigationButtonStyle, "attr", "toolbarNavigationButtonStyle"));
        this.mCollapseButtonView = r0;
        r0.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r1 = generateDefaultLayoutParams();
        r1.gravity = 8388611 | (this.mButtonGravity & 112);
        r1.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r1);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass4(this));
        return;
    }

    private void addSystemView(View r4, boolean r5) {
        ViewGroup.LayoutParams r0 = r4.getLayoutParams();
        if (r0 != null) goto L6;
        LayoutParams r1 = generateDefaultLayoutParams();
    L9:
        r1.mViewType = 1;
        if (r5 == true) goto L12;
    L14:
        addView(r4, r1);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r4.setLayoutParams(r1);
        this.mHiddenViews.add(r4);
        return;
    L6:
        if (checkLayoutParams(r0) == true) goto L8;
        r1 = generateLayoutParams(r0);
        goto L9
    L8:
        r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r0, LayoutParams.class, "com.obric.aiagent.plugin");
        goto L9
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        b r1 = this.mExpandedMenuPresenter;
        if (r1 != null) goto L5;
    L7:
        r0.isOverflowOpen = isOverflowMenuShowing();
        return r0;
    L5:
        if (r1.f399b == null) goto L7;
        r0.expandedMenuItemId = this.mExpandedMenuPresenter.f399b.getItemId();
        goto L7
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        super.onRestoreInstanceState(r5.getSuperState());
        ActionMenuView r0 = this.mMenuView;
        if (r0 == null) goto L9;
        MenuBuilder r1 = r0.peekMenu();
    L11:
        if (r5.expandedMenuItemId == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r1 == null) goto L19;
        MenuItem r2 = r1.findItem(r5.expandedMenuItemId);
        if (r2 == null) goto L19;
        r2.expandActionView();
    L19:
        if (r5.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r1 = null;
        goto L11
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r0 = r5.getActionMasked();
        if (r0 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r6 = super.onTouchEvent(r5);
        if (r0 != 0) goto L11;
        if (r6 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r0 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r0 != 3) goto L15;
        goto L14
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r6) {
        int r0 = r6.getActionMasked();
        if (r0 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r7 = super.onHoverEvent(r6);
        if (r0 != 9) goto L12;
        if (r7 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r0 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r0 != 3) goto L16;
        goto L15
    }

    private void measureChildConstrained(View r4, int r5, int r6, int r7, int r8, int r9) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r10 = getChildMeasureSpec(r5, (((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r6, r0.width);
        int r3 = getChildMeasureSpec(r7, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r8, r0.height);
        int r11 = View.MeasureSpec.getMode(r3);
        if (r11 == 1073741824) goto L8;
        if (r9 < 0) goto L8;
        if (r11 == 0) goto L7;
        r9 = Math.min(View.MeasureSpec.getSize(r3), r9);
    L7:
        r3 = View.MeasureSpec.makeMeasureSpec(r9, 1073741824);
    L8:
        r4.measure(r10, r3);
    }

    private int measureChildCollapseMargins(View r8, int r9, int r10, int r11, int r12, int[] r13) {
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r8.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = r0.leftMargin - r13[0];
        int r3 = r0.rightMargin - r13[1];
        int r5 = Math.max(0, r1) + Math.max(0, r3);
        r13[0] = Math.max(0, -r1);
        r13[1] = Math.max(0, -r3);
        r8.measure(getChildMeasureSpec(r9, ((getPaddingLeft() + getPaddingRight()) + r5) + r10, r0.width), getChildMeasureSpec(r11, (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r12, r0.height));
        return r8.getMeasuredWidth() + r5;
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r0 = getChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L15;
        View r3 = getChildAt(r2);
        if (shouldLayout(r3) == false) goto L14;
        if (r3.getMeasuredWidth() <= 0) goto L14;
        if (r3.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r2 = r2 + 1;
        goto L6
    L15:
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        int[] r8 = this.mTempMargins;
        int r9 = 0;
        if (ac.a(this) == false) goto L5;
        char r10 = 1;
        char r11 = 0;
    L7:
        if (shouldLayout(this.mNavButtonView) == false) goto L9;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r0 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r12 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r13 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L11:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L13;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r0 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r12 = Math.max(r12, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r13 = View.combineMeasuredStates(r13, this.mCollapseButtonView.getMeasuredState());
    L13:
        int r1 = getCurrentContentInsetStart();
        int r14 = 0 + Math.max(r1, r0);
        r8[r10] = Math.max(0, r1 - r0);
        if (shouldLayout(this.mMenuView) == false) goto L16;
        measureChildConstrained(this.mMenuView, r17, r14, r18, 0, this.mMaxButtonHeight);
        int r2 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r12 = Math.max(r12, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r13 = View.combineMeasuredStates(r13, this.mMenuView.getMeasuredState());
    L17:
        int r3 = getCurrentContentInsetEnd();
        int r15 = r14 + Math.max(r3, r2);
        r8[r11] = Math.max(0, r3 - r2);
        if (shouldLayout(this.mExpandedActionView) == false) goto L21;
        r15 = r15 + measureChildCollapseMargins(this.mExpandedActionView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r13 = View.combineMeasuredStates(r13, this.mExpandedActionView.getMeasuredState());
    L21:
        if (shouldLayout(this.mLogoView) == false) goto L23;
        r15 = r15 + measureChildCollapseMargins(this.mLogoView, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r13 = View.combineMeasuredStates(r13, this.mLogoView.getMeasuredState());
    L23:
        int r16 = getChildCount();
        int r19 = 0;
    L24:
        if (r19 >= r16) goto L32;
        View r110 = getChildAt(r19);
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r110.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mViewType != 0) goto L31;
        if (shouldLayout(r110) == false) goto L31;
        r15 = r15 + measureChildCollapseMargins(r110, r17, r15, r18, 0, r8);
        r12 = Math.max(r12, r110.getMeasuredHeight() + getVerticalMargins(r110));
        r13 = View.combineMeasuredStates(r13, r110.getMeasuredState());
    L31:
        r19 = r19 + 1;
        goto L24
    L32:
        int r111 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r112 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L35;
        measureChildCollapseMargins(this.mTitleTextView, r17, r15 + r112, r18, r111, r8);
        int r4 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r113 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r6 = View.combineMeasuredStates(r13, this.mTitleTextView.getMeasuredState());
        int r114 = r4;
    L37:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L40;
        r114 = Math.max(r114, measureChildCollapseMargins(this.mSubtitleTextView, r17, r15 + r112, r18, r113 + r111, r8));
        r113 = r113 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r6 = View.combineMeasuredStates(r6, this.mSubtitleTextView.getMeasuredState());
    L40:
        int r5 = Math.max(r12, r113);
        int r115 = (r15 + r114) + (getPaddingLeft() + getPaddingRight());
        int r7 = r5 + (getPaddingTop() + getPaddingBottom());
        int r20 = View.resolveSizeAndState(Math.max(r115, getSuggestedMinimumWidth()), r17, (-16777216) & r6);
        int r21 = View.resolveSizeAndState(Math.max(r7, getSuggestedMinimumHeight()), r18, r6 << 16);
        if (shouldCollapse() == true) goto L44;
        r9 = r21;
    L44:
        setMeasuredDimension(r20, r9);
        return;
    L35:
        r113 = 0;
        r6 = r13;
        r114 = 0;
        goto L37
    L16:
        r2 = 0;
        goto L17
    L9:
        r0 = 0;
        r12 = 0;
        r13 = 0;
        goto L11
    L5:
        r11 = 1;
        r10 = 0;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.i(this) != 1) goto L5;
        boolean r1 = true;
    L6:
        int r4 = getWidth();
        int r5 = getHeight();
        int r6 = getPaddingLeft();
        int r7 = getPaddingRight();
        int r8 = getPaddingTop();
        int r9 = getPaddingBottom();
        int r10 = r4 - r7;
        int[] r11 = this.mTempMargins;
        r11[1] = 0;
        r11[0] = 0;
        int r12 = ViewCompat.o(this);
        if (r12 < 0) goto L9;
        int r13 = Math.min(r12, r24 - r22);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L15;
        if (r1 == false) goto L14;
        int r14 = layoutChildRight(this.mNavButtonView, r10, r11, r13);
        int r15 = r6;
    L18:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L23;
        if (r1 == false) goto L21;
        r14 = layoutChildRight(this.mCollapseButtonView, r14, r11, r13);
        goto L23
    L21:
        r15 = layoutChildLeft(this.mCollapseButtonView, r15, r11, r13);
    L23:
        if (shouldLayout(this.mMenuView) == false) goto L27;
        if (r1 == false) goto L26;
        r15 = layoutChildLeft(this.mMenuView, r15, r11, r13);
        goto L27
    L26:
        r14 = layoutChildRight(this.mMenuView, r14, r11, r13);
    L27:
        int r16 = getCurrentContentInsetLeft();
        int r17 = getCurrentContentInsetRight();
        r11[0] = Math.max(0, r16 - r15);
        r11[1] = Math.max(0, r17 - (r10 - r14));
        int r2 = Math.max(r15, r16);
        int r18 = Math.min(r14, r10 - r17);
        if (shouldLayout(this.mExpandedActionView) == false) goto L33;
        if (r1 == false) goto L31;
        r18 = layoutChildRight(this.mExpandedActionView, r18, r11, r13);
        goto L33
    L31:
        r2 = layoutChildLeft(this.mExpandedActionView, r2, r11, r13);
    L33:
        if (shouldLayout(this.mLogoView) == false) goto L37;
        if (r1 == false) goto L36;
        r18 = layoutChildRight(this.mLogoView, r18, r11, r13);
        goto L37
    L36:
        r2 = layoutChildLeft(this.mLogoView, r2, r11, r13);
    L37:
        boolean r19 = shouldLayout(this.mTitleTextView);
        boolean r110 = shouldLayout(this.mSubtitleTextView);
        if (r19 == false) goto L40;
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mTitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r25 = ((r3.topMargin + this.mTitleTextView.getMeasuredHeight()) + r3.bottomMargin) + 0;
    L41:
        if (r110 == false) goto L44;
        LayoutParams r26 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSubtitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        r25 = r25 + ((r26.topMargin + this.mSubtitleTextView.getMeasuredHeight()) + r26.bottomMargin);
    L44:
        if (r19 == true) goto L49;
        if (r110 == true) goto L49;
        r13 = r13;
    L48:
        int r27 = 0;
    L103:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r28 = this.mTempViews.size();
        int r29 = r27;
    L104:
        if (r29 >= r28) goto L106;
        r2 = layoutChildLeft((View) ZeusTransformUtils.preCheckCast(this.mTempViews.get(r29), View.class, "com.obric.aiagent.plugin"), r2, r11, r13);
        r29 = r29 + 1;
        goto L104
    L106:
        int r111 = r13;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r30 = this.mTempViews.size();
        int r31 = r27;
    L107:
        if (r31 >= r30) goto L109;
        r18 = layoutChildRight((View) ZeusTransformUtils.preCheckCast(this.mTempViews.get(r31), View.class, "com.obric.aiagent.plugin"), r18, r11, r111);
        r31 = r31 + 1;
        goto L107
    L109:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r32 = getViewListMeasuredWidth(this.mTempViews, r11);
        int r33 = (r6 + (((r4 - r6) - r7) / 2)) - (r32 / 2);
        int r34 = r32 + r33;
        if (r33 < r2) goto L115;
        if (r34 <= r18) goto L114;
        r2 = r33 - (r34 - r18);
        goto L115
    L114:
        r2 = r33;
    L115:
        int r35 = this.mTempViews.size();
    L116:
        if (r27 >= r35) goto L118;
        r2 = layoutChildLeft((View) ZeusTransformUtils.preCheckCast(this.mTempViews.get(r27), View.class, "com.obric.aiagent.plugin"), r2, r11, r111);
        r27 = r27 + 1;
        goto L116
    L118:
        this.mTempViews.clear();
        return;
    L49:
        if (r19 == false) goto L51;
        TextView r36 = this.mTitleTextView;
    L52:
        if (r110 == false) goto L54;
        TextView r37 = this.mSubtitleTextView;
    L55:
        LayoutParams r38 = (LayoutParams) ZeusTransformUtils.preCheckCast(r36.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        LayoutParams r39 = (LayoutParams) ZeusTransformUtils.preCheckCast(r37.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r19 == true) goto L58;
    L59:
        if (r110 == true) goto L61;
    L63:
        boolean r40 = false;
    L64:
        int r112 = this.mGravity & 112;
        int r210 = r2;
        if (r112 != 48) goto L67;
        int r41 = (getPaddingTop() + r38.topMargin) + this.mTitleMarginTop;
    L77:
        if (r1 == false) goto L91;
        if (r40 == false) goto L80;
        int r42 = this.mTitleMarginStart;
    L81:
        int r43 = r42 - r11[1];
        r18 = r18 - Math.max(0, r43);
        r11[1] = Math.max(0, -r43);
        if (r19 == false) goto L84;
        LayoutParams r44 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mTitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r45 = r18 - this.mTitleTextView.getMeasuredWidth();
        int r46 = this.mTitleTextView.getMeasuredHeight() + r41;
        this.mTitleTextView.layout(r45, r41, r18, r46);
        int r47 = r45 - this.mTitleMarginEnd;
        r41 = r46 + r44.bottomMargin;
    L85:
        if (r110 == false) goto L87;
        LayoutParams r48 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSubtitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r49 = r41 + r48.topMargin;
        this.mSubtitleTextView.layout(r18 - this.mSubtitleTextView.getMeasuredWidth(), r49, r18, this.mSubtitleTextView.getMeasuredHeight() + r49);
        int r50 = r18 - this.mTitleMarginEnd;
        int r51 = r48.bottomMargin;
    L88:
        if (r40 == false) goto L90;
        r18 = Math.min(r47, r50);
    L90:
        r2 = r210;
        goto L48
    L87:
        r50 = r18;
        goto L88
    L84:
        r47 = r18;
        goto L85
    L80:
        r42 = 0;
        goto L81
    L91:
        if (r40 == false) goto L93;
        int r52 = this.mTitleMarginStart;
        r27 = 0;
    L94:
        int r53 = r52 - r11[r27];
        r2 = r210 + Math.max(r27, r53);
        r11[r27] = Math.max(r27, -r53);
        if (r19 == false) goto L97;
        LayoutParams r54 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mTitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r55 = this.mTitleTextView.getMeasuredWidth() + r2;
        int r56 = this.mTitleTextView.getMeasuredHeight() + r41;
        this.mTitleTextView.layout(r2, r41, r55, r56);
        int r57 = r55 + this.mTitleMarginEnd;
        r41 = r56 + r54.bottomMargin;
    L98:
        if (r110 == 0) goto L100;
        LayoutParams r58 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mSubtitleTextView.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r59 = r41 + r58.topMargin;
        int r60 = this.mSubtitleTextView.getMeasuredWidth() + r2;
        this.mSubtitleTextView.layout(r2, r59, r60, this.mSubtitleTextView.getMeasuredHeight() + r59);
        int r61 = r60 + this.mTitleMarginEnd;
        int r62 = r58.bottomMargin;
    L101:
        if (r40 == false) goto L103;
        r2 = Math.max(r57, r61);
        goto L103
    L100:
        r61 = r2;
        goto L101
    L97:
        r57 = r2;
        goto L98
    L93:
        r27 = 0;
        r52 = 0;
        goto L94
    L67:
        if (r112 == 80) goto L75;
        int r63 = (((r5 - r8) - r9) - r25) / 2;
        if (r63 >= (r38.topMargin + this.mTitleMarginTop)) goto L71;
        r63 = r38.topMargin + this.mTitleMarginTop;
    L74:
        r41 = r8 + r63;
        goto L77
    L71:
        int r64 = (((r5 - r9) - r25) - r63) - r8;
        if (r64 >= (r38.bottomMargin + this.mTitleMarginBottom)) goto L74;
        r63 = Math.max(0, r63 - ((r39.bottomMargin + this.mTitleMarginBottom) - r64));
        goto L74
    L75:
        r41 = (((r5 - r9) - r39.bottomMargin) - this.mTitleMarginBottom) - r25;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r40 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r37 = this.mTitleTextView;
        goto L55
    L51:
        r36 = this.mSubtitleTextView;
        goto L52
    L40:
        r25 = 0;
        goto L41
    L14:
        r15 = layoutChildLeft(this.mNavButtonView, r6, r11, r13);
    L16:
        r14 = r10;
        goto L18
    L15:
        r15 = r6;
        goto L16
    L9:
        r13 = 0;
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private int getViewListMeasuredWidth(List<View> r9, int[] r10) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        int r1 = r10[0];
        int r11 = r10[1];
        int r2 = r8.size();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        View r5 = (View) ZeusTransformUtils.preCheckCast(r8.get(r3), View.class, "com.obric.aiagent.plugin");
        LayoutParams r6 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r7 = r6.leftMargin - r1;
        int r12 = r6.rightMargin - r11;
        int r13 = Math.max(0, r7);
        int r14 = Math.max(0, r12);
        int r15 = Math.max(0, -r7);
        int r16 = Math.max(0, -r12);
        r4 = r4 + ((r13 + r5.getMeasuredWidth()) + r14);
        r3 = r3 + 1;
        r11 = r16;
        r1 = r15;
        goto L3
    L5:
        return r4;
    }

    private int layoutChildLeft(View r5, int r6, int[] r7, int r8) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = r0.leftMargin - r7[0];
        int r9 = r6 + Math.max(0, r1);
        r7[0] = Math.max(0, -r1);
        int r4 = getChildTop(r5, r8);
        int r10 = r5.getMeasuredWidth();
        r5.layout(r9, r4, r9 + r10, r5.getMeasuredHeight() + r4);
        return r9 + (r10 + r0.rightMargin);
    }

    private int layoutChildRight(View r6, int r7, int[] r8, int r9) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r1 = r0.rightMargin - r8[1];
        int r10 = r7 - Math.max(0, r1);
        r8[1] = Math.max(0, -r1);
        int r5 = getChildTop(r6, r9);
        int r11 = r6.getMeasuredWidth();
        r6.layout(r10 - r11, r5, r10, r6.getMeasuredHeight() + r5);
        return r10 - (r11 + r0.leftMargin);
    }

    private int getChildTop(View r6, int r7) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        int r8 = r6.getMeasuredHeight();
        if (r7 <= 0) goto L5;
        int r9 = (r8 - r7) / 2;
    L6:
        int r2 = getChildVerticalGravity(r0.gravity);
        if (r2 == 48) goto L21;
        if (r2 == 80) goto L19;
        int r10 = getPaddingTop();
        int r3 = getPaddingBottom();
        int r5 = getHeight();
        int r4 = (((r5 - r10) - r3) - r8) / 2;
        if (r4 >= r0.topMargin) goto L13;
        r4 = r0.topMargin;
    L17:
        return r10 + r4;
    L13:
        int r11 = (((r5 - r3) - r8) - r4) - r10;
        if (r11 >= r0.bottomMargin) goto L17;
        r4 = Math.max(0, r4 - (r0.bottomMargin - r11));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r8) - r0.bottomMargin) - r9;
    L21:
        return getPaddingTop() - r9;
    L5:
        r9 = 0;
        goto L6
    }

    private int getChildVerticalGravity(int r2) {
        int r3 = r2 & 112;
        if (r3 != 16) goto L5;
    L10:
        return r3;
    L5:
        if (r3 == 48) goto L10;
        if (r3 == 80) goto L10;
        return this.mGravity & 112;
    }

    private void addCustomViewsWithGravity(List<View> r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        int r2 = 0;
        if (ViewCompat.i(this) != 1) goto L5;
        boolean r0 = true;
    L6:
        int r4 = getChildCount();
        int r10 = androidx.core.view.d.a(r8, ViewCompat.i(this));
        r9.clear();
        if (r0 == false) goto L18;
        int r5 = r4 - 1;
    L9:
        if (r5 < 0) goto L27;
        View r1 = getChildAt(r5);
        LayoutParams r3 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r3.mViewType != 0) goto L17;
        if (shouldLayout(r1) == false) goto L17;
        if (getChildHorizontalGravity(r3.gravity) != r10) goto L17;
        r9.add(r1);
    L17:
        r5 = r5 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r2 >= r4) goto L38;
        View r6 = getChildAt(r2);
        LayoutParams r11 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r11.mViewType != 0) goto L26;
        if (shouldLayout(r6) == false) goto L26;
        if (getChildHorizontalGravity(r11.gravity) != r10) goto L26;
        r9.add(r6);
    L26:
        r2 = r2 + 1;
        goto L18
    L38:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private int getChildHorizontalGravity(int r4) {
        int r3 = ViewCompat.i(this);
        int r5 = androidx.core.view.d.a(r4, r3) & 7;
        if (r5 != 1) goto L5;
    L11:
        return r5;
    L5:
        if (r5 == 3) goto L11;
        if (r5 == 5) goto L11;
        if (r3 == 1) goto L10;
        return 3;
    L10:
        return 5;
    }

    private boolean shouldLayout(View r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.getParent() != this) goto L8;
        if (r2.getVisibility() == 8) goto L8;
        return true;
    }

    private int getHorizontalMargins(View r2) {
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        return androidx.core.view.g.a(r1) + androidx.core.view.g.b(r1);
    }

    private int getVerticalMargins(View r2) {
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
        return r1.topMargin + r1.bottomMargin;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L7;
        return new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.aiagent.plugin"));
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ActionBar.LayoutParams.class) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) ZeusTransformUtils.preCheckCast(r3, ActionBar.LayoutParams.class, "com.obric.aiagent.plugin"));
    L11:
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
    L15:
        return new LayoutParams(r3);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        if (super.checkLayoutParams(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r1, LayoutParams.class) == false) goto L7;
        return true;
    }

    public p getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new z(this, true);
    L6:
        return this.mWrapper;
    }

    void removeChildrenForExpandedActionView() {
        int r0 = getChildCount() - 1;
    L3:
        if (r0 < 0) goto L10;
        View r1 = getChildAt(r0);
        if (((LayoutParams) ZeusTransformUtils.preCheckCast(r1.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mViewType == 2) goto L9;
        if (r1 == this.mMenuView) goto L9;
        removeViewAt(r0);
        this.mHiddenViews.add(r1);
    L9:
        r0 = r0 - 1;
        goto L3
    }

    void addChildrenForExpandedActionView() {
        int r0 = this.mHiddenViews.size() - 1;
    L3:
        if (r0 < 0) goto L5;
        addView((View) ZeusTransformUtils.preCheckCast(this.mHiddenViews.get(r0), View.class, "com.obric.aiagent.plugin"));
        r0 = r0 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    private boolean isChildOrHidden(View r2) {
        if (r2.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r2) == true) goto L8;
        return false;
    }

    public void setCollapsible(boolean r1) {
        this.mCollapsible = r1;
        requestLayout();
    }

    public void setMenuCallbacks(androidx.appcompat.view.menu.d.a r3, MenuBuilder.a r4) {
        androidx.appcompat.view.menu.d.a r5 = (androidx.appcompat.view.menu.d.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.appcompat.view.menu.d.a.class, "com.obric.aiagent.plugin");
        MenuBuilder.a r6 = (MenuBuilder.a) ZeusTransformUtils.wrapperContextForParams(r4, MenuBuilder.a.class, "com.obric.aiagent.plugin");
        this.mActionMenuPresenterCallback = r5;
        this.mMenuBuilderCallback = r6;
        ActionMenuView r2 = this.mMenuView;
        if (r2 == null) goto L6;
        r2.setMenuCallbacks(r5, r6);
        return;
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new v();
        return;
    }

    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r0 = new ArrayList();
        Menu r3 = getMenu();
        int r1 = 0;
    L4:
        if (r1 >= r3.size()) goto L6;
        r0.add(r3.getItem(r1));
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    private void onCreateMenu() {
        Menu r0 = getMenu();
        ArrayList<MenuItem> r1 = getCurrentMenuItems();
        this.mMenuHostHelper.a(r0, getMenuInflater());
        ArrayList<MenuItem> r2 = getCurrentMenuItems();
        r2.removeAll(r1);
        this.mProvidedMenuItems = r2;
    }

    public void addMenuProvider(androidx.core.view.j r3) {
        androidx.core.view.j r4 = (androidx.core.view.j) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.view.j.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r4);
    }

    public void addMenuProvider(androidx.core.view.j r3, androidx.lifecycle.p r4) {
        androidx.core.view.j r5 = (androidx.core.view.j) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.view.j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r6 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r4, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r5, r6);
    }

    public void addMenuProvider(androidx.core.view.j r3, androidx.lifecycle.p r4, androidx.lifecycle.i.b r5) {
        androidx.core.view.j r6 = (androidx.core.view.j) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.view.j.class, "com.obric.aiagent.plugin");
        androidx.lifecycle.p r7 = (androidx.lifecycle.p) ZeusTransformUtils.wrapperContextForParams(r4, androidx.lifecycle.p.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.a(r6, r7, r5);
    }

    public void removeMenuProvider(androidx.core.view.j r3) {
        androidx.core.view.j r4 = (androidx.core.view.j) ZeusTransformUtils.wrapperContextForParams(r3, androidx.core.view.j.class, "com.obric.aiagent.plugin");
        this.mMenuHostHelper.b(r4);
    }

    public void invalidateMenu() {
        Iterator<MenuItem> r0 = this.mProvidedMenuItems.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MenuItem r1 = (MenuItem) ZeusTransformUtils.preCheckCast(r0.next(), MenuItem.class, "com.obric.aiagent.plugin");
        getMenu().removeItem(r1.getItemId());
        goto L4
    L6:
        onCreateMenu();
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L25;
        OnBackInvokedDispatcher r0 = a.a(this);
        if (hasExpandedActionView() == false) goto L12;
        if (r0 == null) goto L12;
        if (ViewCompat.I(this) == false) goto L12;
        if (this.mBackInvokedCallbackEnabled == false) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
    L20:
        if (r1 == true) goto L27;
        OnBackInvokedDispatcher r2 = this.mBackInvokedDispatcher;
        if (r2 == null) goto L28;
        a.b(r2, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = null;
        return;
    L28:
        return;
    L27:
        return;
    L15:
        if (this.mBackInvokedDispatcher != null) goto L20;
        if (this.mBackInvokedCallback != null) goto L19;
        this.mBackInvokedCallback = a.a(new $$Lambda$i6m8qvO2rOpeMZdwQ_hs78Wn5r4(this));
    L19:
        a.a(r0, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = r0;
        return;
    L12:
        r1 = false;
        goto L13
    }
}
