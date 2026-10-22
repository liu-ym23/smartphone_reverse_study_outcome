package androidx.appcompat.widget;

import android.annotation.SuppressLint;
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
import android.view.KeyEvent;
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
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
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
    private f mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    MenuBuilder.Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
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
    private f0 mWrapper;

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f945b;

        public LayoutParams(@NonNull Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f945b = 0;
        }

        public void a(ViewGroup.MarginLayoutParams r10) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r10.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r10.bottomMargin;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.f945b = 0;
            this.f211a = 8388627;
        }

        public LayoutParams(int r10, int r11, int r12) {
            super(r10, r11);
            this.f945b = 0;
            this.f211a = r12;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.f945b = 0;
            this.f945b = r10.f945b;
        }

        public LayoutParams(ActionBar.LayoutParams r10) {
            super(r10);
            this.f945b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f945b = 0;
            a(r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f945b = 0;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10) {
            this(r10, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.expandedMenuItemId);
            r10.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.expandedMenuItemId = r10.readInt();
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.isOverflowOpen = r12;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    public class a implements ActionMenuView.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f946a;

        public a(Toolbar r10) {
            this.f946a = r10;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem r10) {
            if (this.f946a.mMenuHostHelper.j(r10) == false) goto L6;
            return true;
        L6:
            OnMenuItemClickListener r11 = this.f946a.mOnMenuItemClickListener;
            if (r11 != null) goto L9;
            return false;
        L9:
            return r11.onMenuItemClick(r10);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f947a;

        public b(Toolbar r10) {
            this.f947a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f947a.showOverflowMenu();
        }
    }

    public class c implements MenuBuilder.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f948a;

        public c(Toolbar r10) {
            this.f948a = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder r10, MenuItem r11) {
            MenuBuilder.Callback r12 = this.f948a.mMenuBuilderCallback;
            if (r12 != null) goto L5;
        L7:
            return false;
        L5:
            if (r12.onMenuItemSelected(r10, r11) == false) goto L7;
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder r10) {
            if (this.f948a.mMenuView.l() == true) goto L5;
            this.f948a.mMenuHostHelper.k(r10);
        L5:
            MenuBuilder.Callback r11 = this.f948a.mMenuBuilderCallback;
            if (r11 == null) goto L9;
            r11.onMenuModeChange(r10);
            return;
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Toolbar f949a;

        public d(Toolbar r10) {
            this.f949a = r10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            this.f949a.collapseActionView();
        }
    }

    public static class e {
        @Nullable
        @DoNotInline
        public static OnBackInvokedDispatcher a(@NonNull View r10) {
            return r10.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        public static OnBackInvokedCallback b(@NonNull final Runnable r10) {
            Objects.requireNonNull(r10);
            return new e0(r10);
        }

        @DoNotInline
        public static void c(@NonNull Object r10, @NonNull Object r11) {
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) r11);
        }

        @DoNotInline
        public static void d(@NonNull Object r10, @NonNull Object r11) {
            ((OnBackInvokedDispatcher) r10).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    public class f implements MenuPresenter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MenuBuilder f950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.appcompat.view.menu.g f951b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Toolbar f952c;

        public f(Toolbar r10) {
            this.f952c = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r10, androidx.appcompat.view.menu.g r11) {
            KeyEvent.Callback r12 = this.f952c.mExpandedActionView;
            if ((r12 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r12).onActionViewCollapsed();
        L5:
            Toolbar r13 = this.f952c;
            r13.removeView(r13.mExpandedActionView);
            Toolbar r14 = this.f952c;
            r14.removeView(r14.mCollapseButtonView);
            Toolbar r15 = this.f952c;
            r15.mExpandedActionView = null;
            r15.addChildrenForExpandedActionView();
            this.f951b = null;
            this.f952c.requestLayout();
            r11.o(false);
            this.f952c.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r10, androidx.appcompat.view.menu.g r11) {
            this.f952c.ensureCollapseButtonView();
            ViewParent r12 = this.f952c.mCollapseButtonView.getParent();
            Toolbar r13 = this.f952c;
            if (r12 != r13) goto L5;
        L8:
            Toolbar r14 = this.f952c;
            r14.mExpandedActionView = r11.getActionView();
            this.f951b = r11;
            ViewParent r15 = this.f952c.mExpandedActionView.getParent();
            Toolbar r16 = this.f952c;
            if (r15 != r16) goto L11;
        L14:
            this.f952c.removeChildrenForExpandedActionView();
            this.f952c.requestLayout();
            r11.o(true);
            KeyEvent.Callback r17 = this.f952c.mExpandedActionView;
            if ((r17 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r17).onActionViewExpanded();
        L17:
            this.f952c.updateBackInvokedCallbackState();
            return true;
        L11:
            if ((r15 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r15).removeView(r16.mExpandedActionView);
        L13:
            LayoutParams r18 = this.f952c.generateDefaultLayoutParams();
            Toolbar r19 = this.f952c;
            r18.f211a = (r19.mButtonGravity & 112) | 8388611;
            r18.f945b = 2;
            r19.mExpandedActionView.setLayoutParams(r18);
            Toolbar r20 = this.f952c;
            r20.addView(r20.mExpandedActionView);
            goto L14
        L5:
            if ((r12 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r12).removeView(r13.mCollapseButtonView);
        L7:
            Toolbar r21 = this.f952c;
            r21.addView(r21.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup r10) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r10, MenuBuilder r11) {
            MenuBuilder r12 = this.f950a;
            if (r12 == null) goto L7;
            androidx.appcompat.view.menu.g r13 = this.f951b;
            if (r13 == null) goto L7;
            r12.collapseItemActionView(r13);
        L7:
            this.f950a = r11;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(androidx.appcompat.view.menu.m r10) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r10) {
            if (this.f951b == null) goto L16;
            MenuBuilder r11 = this.f950a;
            if (r11 == null) goto L12;
            int r12 = r11.size();
            int r13 = 0;
        L7:
            if (r13 >= r12) goto L12;
            if (this.f950a.getItem(r13) == this.f951b) goto L17;
            r13 = r13 + 1;
            goto L7
        L17:
            return;
        L12:
            collapseItemActionView(this.f950a, this.f951b);
            return;
        }
    }

    public Toolbar(@NonNull Context r10) {
        this(r10, null);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r10 = new ArrayList();
        Menu r11 = getMenu();
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        r10.add(r11.getItem(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    private MenuInflater getMenuInflater() {
        return new g.c(getContext());
    }

    public final void a(List r10, int r11) {
        int r12 = 0;
        if (ViewCompat.A(this) != 1) goto L5;
        boolean r13 = true;
    L6:
        int r14 = getChildCount();
        int r15 = androidx.core.view.c.b(r11, ViewCompat.A(this));
        r10.clear();
        if (r13 == false) goto L18;
        int r16 = r14 - 1;
    L9:
        if (r16 < 0) goto L27;
        View r17 = getChildAt(r16);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        if (r18.f945b != 0) goto L17;
        if (v(r17) == false) goto L17;
        if (h(r18.f211a) != r15) goto L17;
        r10.add(r17);
    L17:
        r16 = r16 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r12 >= r14) goto L38;
        View r19 = getChildAt(r12);
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        if (r20.f945b != 0) goto L26;
        if (v(r19) == false) goto L26;
        if (h(r20.f211a) != r15) goto L26;
        r10.add(r19);
    L26:
        r12 = r12 + 1;
        goto L18
    L38:
        return;
    L5:
        r13 = false;
        goto L6
    }

    public void addChildrenForExpandedActionView() {
        int r10 = this.mHiddenViews.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        addView(this.mHiddenViews.get(r10));
        r10 = r10 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.c(r10);
    }

    public final void b(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 != null) goto L6;
        LayoutParams r13 = generateDefaultLayoutParams();
    L9:
        r13.f945b = 1;
        if (r11 == true) goto L12;
    L14:
        addView(r10, r13);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r10.setLayoutParams(r13);
        this.mHiddenViews.add(r10);
        return;
    L6:
        if (checkLayoutParams(r12) == true) goto L8;
        r13 = generateLayoutParams(r12);
        goto L9
    L8:
        r13 = (LayoutParams) r12;
        goto L9
    }

    public final void c() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new v();
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L9;
        if (r10.m() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if (super.checkLayoutParams(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void collapseActionView() {
        f r10 = this.mExpandedMenuPresenter;
        if (r10 != null) goto L5;
        androidx.appcompat.view.menu.g r11 = null;
    L6:
        if (r11 == null) goto L9;
        r11.collapseActionView();
        return;
    L9:
        return;
    L5:
        r11 = r10.f951b;
        goto L6
    }

    public final void d() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView(getContext());
        return;
    }

    public void dismissPopupMenus() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L6;
        r10.d();
        return;
    }

    public final void e() {
        f();
        if (this.mMenuView.p() != null) goto L9;
        MenuBuilder r10 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new f(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r10.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        updateBackInvokedCallbackState();
        return;
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r10 = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r10;
        r10.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r11 = generateDefaultLayoutParams();
        r11.f211a = (this.mButtonGravity & 112) | 8388611;
        r11.f945b = 2;
        this.mCollapseButtonView.setLayoutParams(r11);
        this.mCollapseButtonView.setOnClickListener(new d(this));
        return;
    }

    public final void f() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r10 = new ActionMenuView(getContext());
        this.mMenuView = r10;
        r10.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.q(this.mActionMenuPresenterCallback, new c(this));
        LayoutParams r11 = generateDefaultLayoutParams();
        r11.f211a = (this.mButtonGravity & 112) | 8388613;
        this.mMenuView.setLayoutParams(r11);
        b(this.mMenuView, false);
        return;
    }

    public final void g() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R$attr.toolbarNavigationButtonStyle);
        LayoutParams r10 = generateDefaultLayoutParams();
        r10.f211a = (this.mButtonGravity & 112) | 8388611;
        this.mNavButtonView.setLayoutParams(r10);
        return;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    public int getContentInsetEnd() {
        v r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.a();
    }

    public int getContentInsetEndWithActions() {
        int r10 = this.mContentInsetEndWithActions;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        v r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.b();
    }

    public int getContentInsetRight() {
        v r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.c();
    }

    public int getContentInsetStart() {
        v r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.d();
    }

    public int getContentInsetStartWithNavigation() {
        int r10 = this.mContentInsetStartWithNavigation;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L10;
        MenuBuilder r11 = r10.p();
        if (r11 == null) goto L10;
        if (r11.hasVisibleItems() == false) goto L10;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L10:
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.A(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.A(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView r10 = this.mLogoView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r10 = this.mLogoView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    public Menu getMenu() {
        e();
        return this.mMenuView.getMenu();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton r10 = this.mNavButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton r10 = this.mNavButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        e();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new f0(this, true);
    L6:
        return this.mWrapper;
    }

    public final int h(int r10) {
        int r11 = ViewCompat.A(this);
        int r12 = androidx.core.view.c.b(r10, r11) & 7;
        if (r12 != 1) goto L5;
    L11:
        return r12;
    L5:
        if (r12 == 3) goto L11;
        if (r12 == 5) goto L11;
        if (r11 == 1) goto L10;
        return 3;
    L10:
        return 5;
    }

    public boolean hasExpandedActionView() {
        f r10 = this.mExpandedMenuPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.f951b == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.j() == false) goto L7;
        return true;
    }

    public final int i(View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        int r13 = r10.getMeasuredHeight();
        if (r11 <= 0) goto L5;
        int r14 = (r13 - r11) / 2;
    L6:
        int r15 = j(r12.f211a);
        if (r15 == 48) goto L21;
        if (r15 == 80) goto L19;
        int r16 = getPaddingTop();
        int r17 = getPaddingBottom();
        int r18 = getHeight();
        int r19 = (((r18 - r16) - r17) - r13) / 2;
        int r20 = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        if (r19 >= r20) goto L13;
        r19 = r20;
    L17:
        return r16 + r19;
    L13:
        int r21 = (((r18 - r17) - r13) - r19) - r16;
        int r22 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        if (r21 >= r22) goto L17;
        r19 = Math.max(0, r19 - (r22 - r21));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r13) - ((ViewGroup.MarginLayoutParams) r12).bottomMargin) - r14;
    L21:
        return getPaddingTop() - r14;
    L5:
        r14 = 0;
        goto L6
    }

    public void inflateMenu(@MenuRes int r10) {
        getMenuInflater().inflate(r10, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void invalidateMenu() {
        Iterator<MenuItem> r10 = this.mProvidedMenuItems.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        MenuItem r11 = r10.next();
        getMenu().removeItem(r11.getItemId());
        goto L4
    L6:
        s();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.k() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.l() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        TextView r10 = this.mTitleTextView;
        if (r10 != null) goto L5;
        return false;
    L5:
        Layout r11 = r10.getLayout();
        if (r11 != null) goto L8;
        return false;
    L8:
        int r12 = r11.getLineCount();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L15;
        if (r11.getEllipsisCount(r13) > 0) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    public final int j(int r10) {
        int r11 = r10 & 112;
        if (r11 != 16) goto L5;
    L10:
        return r11;
    L5:
        if (r11 == 48) goto L10;
        if (r11 == 80) goto L10;
        return this.mGravity & 112;
    }

    public final int k(View r10) {
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        return androidx.core.view.e.b(r11) + androidx.core.view.e.a(r11);
    }

    public final int l(View r10) {
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        return r11.topMargin + r11.bottomMargin;
    }

    public final int m(List r10, int[] r11) {
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r10.size();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L5;
        View r17 = (View) r10.get(r15);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        int r19 = ((ViewGroup.MarginLayoutParams) r18).leftMargin - r12;
        int r20 = ((ViewGroup.MarginLayoutParams) r18).rightMargin - r13;
        int r21 = Math.max(0, r19);
        int r22 = Math.max(0, r20);
        int r23 = Math.max(0, -r19);
        int r24 = Math.max(0, -r20);
        r16 = r16 + ((r21 + r17.getMeasuredWidth()) + r22);
        r15 = r15 + 1;
        r13 = r24;
        r12 = r23;
        goto L3
    L5:
        return r16;
    }

    public final boolean n(View r10) {
        if (r10.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r10) == true) goto L8;
        return false;
    }

    public final int o(View r10, int r11, int[] r12, int r13) {
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).leftMargin - r12[0];
        int r16 = r11 + Math.max(0, r15);
        r12[0] = Math.max(0, -r15);
        int r17 = i(r10, r13);
        int r18 = r10.getMeasuredWidth();
        r10.layout(r16, r17, r16 + r18, r10.getMeasuredHeight() + r17);
        return r16 + (r18 + ((ViewGroup.MarginLayoutParams) r14).rightMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r12 = super.onHoverEvent(r10);
        if (r11 != 9) goto L12;
        if (r12 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r11 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r11 != 3) goto L16;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.A(this) != 1) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getWidth();
        int r12 = getHeight();
        int r13 = getPaddingLeft();
        int r14 = getPaddingRight();
        int r15 = getPaddingTop();
        int r16 = getPaddingBottom();
        int r17 = r11 - r14;
        int[] r18 = this.mTempMargins;
        r18[1] = 0;
        r18[0] = 0;
        int r19 = ViewCompat.B(this);
        if (r19 < 0) goto L9;
        int r110 = Math.min(r19, r24 - r22);
    L11:
        if (v(this.mNavButtonView) == false) goto L16;
        if (r10 == false) goto L14;
        int r111 = p(this.mNavButtonView, r17, r18, r110);
        int r112 = r13;
    L18:
        if (v(this.mCollapseButtonView) == false) goto L23;
        if (r10 == false) goto L21;
        r111 = p(this.mCollapseButtonView, r111, r18, r110);
        goto L23
    L21:
        r112 = o(this.mCollapseButtonView, r112, r18, r110);
    L23:
        if (v(this.mMenuView) == false) goto L27;
        if (r10 == false) goto L26;
        r112 = o(this.mMenuView, r112, r18, r110);
        goto L27
    L26:
        r111 = p(this.mMenuView, r111, r18, r110);
    L27:
        int r113 = getCurrentContentInsetLeft();
        int r114 = getCurrentContentInsetRight();
        r18[0] = Math.max(0, r113 - r112);
        r18[1] = Math.max(0, r114 - (r17 - r111));
        int r25 = Math.max(r112, r113);
        int r115 = Math.min(r111, r17 - r114);
        if (v(this.mExpandedActionView) == false) goto L33;
        if (r10 == false) goto L31;
        r115 = p(this.mExpandedActionView, r115, r18, r110);
        goto L33
    L31:
        r25 = o(this.mExpandedActionView, r25, r18, r110);
    L33:
        if (v(this.mLogoView) == false) goto L37;
        if (r10 == false) goto L36;
        r115 = p(this.mLogoView, r115, r18, r110);
        goto L37
    L36:
        r25 = o(this.mLogoView, r25, r18, r110);
    L37:
        boolean r116 = v(this.mTitleTextView);
        boolean r117 = v(this.mSubtitleTextView);
        if (r116 == false) goto L40;
        LayoutParams r118 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r26 = (((ViewGroup.MarginLayoutParams) r118).topMargin + this.mTitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r118).bottomMargin;
    L41:
        if (r117 == false) goto L44;
        LayoutParams r27 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r26 = r26 + ((((ViewGroup.MarginLayoutParams) r27).topMargin + this.mSubtitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r27).bottomMargin);
    L44:
        if (r116 == true) goto L49;
        if (r117 == true) goto L49;
        int r119 = r13;
        r110 = r110;
    L48:
        int r28 = 0;
    L105:
        a(this.mTempViews, 3);
        int r29 = this.mTempViews.size();
        int r30 = r25;
        int r31 = r28;
    L106:
        if (r31 >= r29) goto L108;
        r30 = o(this.mTempViews.get(r31), r30, r18, r110);
        r31 = r31 + 1;
        goto L106
    L108:
        int r120 = r110;
        a(this.mTempViews, 5);
        int r32 = this.mTempViews.size();
        int r33 = r28;
    L109:
        if (r33 >= r32) goto L111;
        r115 = p(this.mTempViews.get(r33), r115, r18, r120);
        r33 = r33 + 1;
        goto L109
    L111:
        a(this.mTempViews, 1);
        int r34 = m(this.mTempViews, r18);
        int r35 = (r119 + (((r11 - r119) - r14) / 2)) - (r34 / 2);
        int r36 = r34 + r35;
        if (r35 < r30) goto L117;
        if (r36 <= r115) goto L116;
        r30 = r35 - (r36 - r115);
        goto L117
    L116:
        r30 = r35;
    L117:
        int r37 = this.mTempViews.size();
    L118:
        if (r28 >= r37) goto L120;
        r30 = o(this.mTempViews.get(r28), r30, r18, r120);
        r28 = r28 + 1;
        goto L118
    L120:
        this.mTempViews.clear();
        return;
    L49:
        if (r116 == false) goto L51;
        TextView r38 = this.mTitleTextView;
    L52:
        if (r117 == false) goto L54;
        TextView r39 = this.mSubtitleTextView;
    L55:
        LayoutParams r40 = (LayoutParams) r38.getLayoutParams();
        LayoutParams r41 = (LayoutParams) r39.getLayoutParams();
        if (r116 == true) goto L58;
    L59:
        if (r117 == true) goto L61;
    L63:
        boolean r121 = false;
    L64:
        int r122 = this.mGravity & 112;
        r119 = r13;
        if (r122 != 48) goto L67;
        int r42 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r40).topMargin) + this.mTitleMarginTop;
    L77:
        if (r10 == false) goto L92;
        if (r121 == false) goto L81;
        int r43 = this.mTitleMarginStart;
    L82:
        int r44 = r43 - r18[1];
        r115 = r115 - Math.max(0, r44);
        r18[1] = Math.max(0, -r44);
        if (r116 == false) goto L85;
        LayoutParams r45 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r46 = r115 - this.mTitleTextView.getMeasuredWidth();
        int r47 = this.mTitleTextView.getMeasuredHeight() + r42;
        this.mTitleTextView.layout(r46, r42, r115, r47);
        int r48 = r46 - this.mTitleMarginEnd;
        r42 = r47 + ((ViewGroup.MarginLayoutParams) r45).bottomMargin;
    L86:
        if (r117 == false) goto L88;
        int r49 = r42 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        this.mSubtitleTextView.layout(r115 - this.mSubtitleTextView.getMeasuredWidth(), r49, r115, this.mSubtitleTextView.getMeasuredHeight() + r49);
        int r50 = r115 - this.mTitleMarginEnd;
    L89:
        if (r121 == false) goto L91;
        r115 = Math.min(r48, r50);
    L91:
        r25 = r25;
        goto L48
    L88:
        r50 = r115;
        goto L89
    L85:
        r48 = r115;
        goto L86
    L81:
        r43 = 0;
        goto L82
    L92:
        if (r121 == false) goto L95;
        int r51 = this.mTitleMarginStart;
    L94:
        r28 = 0;
        int r52 = r51 - r18[0];
        r25 = r25 + Math.max(0, r52);
        r18[0] = Math.max(0, -r52);
        if (r116 == false) goto L99;
        LayoutParams r53 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r54 = this.mTitleTextView.getMeasuredWidth() + r25;
        int r55 = this.mTitleTextView.getMeasuredHeight() + r42;
        this.mTitleTextView.layout(r25, r42, r54, r55);
        int r56 = r54 + this.mTitleMarginEnd;
        r42 = r55 + ((ViewGroup.MarginLayoutParams) r53).bottomMargin;
    L100:
        if (r117 == false) goto L102;
        int r57 = r42 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r58 = this.mSubtitleTextView.getMeasuredWidth() + r25;
        this.mSubtitleTextView.layout(r25, r57, r58, this.mSubtitleTextView.getMeasuredHeight() + r57);
        int r59 = r58 + this.mTitleMarginEnd;
    L103:
        if (r121 == false) goto L105;
        r25 = Math.max(r56, r59);
        goto L105
    L102:
        r59 = r25;
        goto L103
    L99:
        r56 = r25;
        goto L100
    L95:
        r51 = 0;
        goto L94
    L67:
        if (r122 == 80) goto L75;
        int r60 = (((r12 - r15) - r16) - r26) / 2;
        int r123 = ((ViewGroup.MarginLayoutParams) r40).topMargin;
        int r124 = this.mTitleMarginTop;
        if (r60 >= (r123 + r124)) goto L71;
        r60 = r123 + r124;
    L74:
        r42 = r15 + r60;
        goto L77
    L71:
        int r61 = (((r12 - r16) - r26) - r60) - r15;
        int r62 = ((ViewGroup.MarginLayoutParams) r40).bottomMargin;
        int r63 = this.mTitleMarginBottom;
        if (r61 >= (r62 + r63)) goto L74;
        r60 = Math.max(0, r60 - ((((ViewGroup.MarginLayoutParams) r41).bottomMargin + r63) - r61));
        goto L74
    L75:
        r42 = (((r12 - r16) - ((ViewGroup.MarginLayoutParams) r41).bottomMargin) - this.mTitleMarginBottom) - r26;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r121 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r39 = this.mTitleTextView;
        goto L55
    L51:
        r38 = this.mSubtitleTextView;
        goto L52
    L40:
        r26 = 0;
        goto L41
    L14:
        r112 = o(this.mNavButtonView, r13, r18, r110);
    L15:
        r111 = r17;
        goto L18
    L16:
        r112 = r13;
        goto L15
    L9:
        r110 = 0;
        goto L11
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        int[] r10 = this.mTempMargins;
        boolean r11 = i0.b(this);
        int r12 = 0;
        int r13 = !r11 ? 1 : 0;
        if (v(this.mNavButtonView) == false) goto L5;
        r(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r14 = this.mNavButtonView.getMeasuredWidth() + k(this.mNavButtonView);
        int r15 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + l(this.mNavButtonView));
        int r16 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (v(this.mCollapseButtonView) == false) goto L9;
        r(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r14 = this.mCollapseButtonView.getMeasuredWidth() + k(this.mCollapseButtonView);
        r15 = Math.max(r15, this.mCollapseButtonView.getMeasuredHeight() + l(this.mCollapseButtonView));
        r16 = View.combineMeasuredStates(r16, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r19 = getCurrentContentInsetStart();
        int r110 = Math.max(r19, r14);
        r10[r11 ? 1 : 0] = Math.max(0, r19 - r14);
        if (v(this.mMenuView) == false) goto L12;
        r(this.mMenuView, r17, r110, r18, 0, this.mMaxButtonHeight);
        int r20 = this.mMenuView.getMeasuredWidth() + k(this.mMenuView);
        r15 = Math.max(r15, this.mMenuView.getMeasuredHeight() + l(this.mMenuView));
        r16 = View.combineMeasuredStates(r16, this.mMenuView.getMeasuredState());
    L13:
        int r21 = getCurrentContentInsetEnd();
        int r111 = r110 + Math.max(r21, r20);
        r10[r13] = Math.max(0, r21 - r20);
        if (v(this.mExpandedActionView) == false) goto L17;
        r111 = r111 + q(this.mExpandedActionView, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, this.mExpandedActionView.getMeasuredHeight() + l(this.mExpandedActionView));
        r16 = View.combineMeasuredStates(r16, this.mExpandedActionView.getMeasuredState());
    L17:
        if (v(this.mLogoView) == false) goto L19;
        r111 = r111 + q(this.mLogoView, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, this.mLogoView.getMeasuredHeight() + l(this.mLogoView));
        r16 = View.combineMeasuredStates(r16, this.mLogoView.getMeasuredState());
    L19:
        int r22 = getChildCount();
        int r112 = 0;
    L20:
        if (r112 >= r22) goto L28;
        View r113 = getChildAt(r112);
        if (((LayoutParams) r113.getLayoutParams()).f945b != 0) goto L27;
        if (v(r113) == false) goto L27;
        r111 = r111 + q(r113, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, r113.getMeasuredHeight() + l(r113));
        r16 = View.combineMeasuredStates(r16, r113.getMeasuredState());
    L27:
        r112 = r112 + 1;
        goto L20
    L28:
        int r23 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r114 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (v(this.mTitleTextView) == false) goto L31;
        q(this.mTitleTextView, r17, r111 + r114, r18, r23, r10);
        int r24 = this.mTitleTextView.getMeasuredWidth() + k(this.mTitleTextView);
        int r115 = this.mTitleTextView.getMeasuredHeight() + l(this.mTitleTextView);
        int r25 = View.combineMeasuredStates(r16, this.mTitleTextView.getMeasuredState());
        int r116 = r24;
    L33:
        if (v(this.mSubtitleTextView) == false) goto L36;
        r116 = Math.max(r116, q(this.mSubtitleTextView, r17, r111 + r114, r18, r115 + r23, r10));
        r115 = r115 + (this.mSubtitleTextView.getMeasuredHeight() + l(this.mSubtitleTextView));
        r25 = View.combineMeasuredStates(r25, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r26 = Math.max(r15, r115);
        int r117 = (r111 + r116) + (getPaddingLeft() + getPaddingRight());
        int r27 = r26 + (getPaddingTop() + getPaddingBottom());
        int r28 = View.resolveSizeAndState(Math.max(r117, getSuggestedMinimumWidth()), r17, (-16777216) & r25);
        int r29 = View.resolveSizeAndState(Math.max(r27, getSuggestedMinimumHeight()), r18, r25 << 16);
        if (u() == true) goto L40;
        r12 = r29;
    L40:
        setMeasuredDimension(r28, r12);
        return;
    L31:
        r115 = 0;
        r25 = r16;
        r116 = 0;
        goto L33
    L12:
        r20 = 0;
        goto L13
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        ActionMenuView r12 = this.mMenuView;
        if (r12 == null) goto L9;
        MenuBuilder r13 = r12.p();
    L10:
        int r14 = r11.expandedMenuItemId;
        if (r14 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r13 == null) goto L19;
        MenuItem r15 = r13.findItem(r14);
        if (r15 == null) goto L19;
        r15.expandActionView();
    L19:
        if (r11.isOverflowOpen == false) goto L22;
        t();
        return;
    L22:
        return;
    L9:
        r13 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        super.onRtlPropertiesChanged(r10);
        c();
        v r11 = this.mContentInsets;
        boolean r12 = true;
        if (r10 == 1) goto L6;
        r12 = false;
    L6:
        r11.f(r12);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        f r11 = this.mExpandedMenuPresenter;
        if (r11 == null) goto L7;
        androidx.appcompat.view.menu.g r12 = r11.f951b;
        if (r12 == null) goto L7;
        r10.expandedMenuItemId = r12.getItemId();
    L7:
        r10.isOverflowOpen = isOverflowMenuShowing();
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r12 = super.onTouchEvent(r10);
        if (r11 != 0) goto L11;
        if (r12 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r11 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r11 != 3) goto L15;
        goto L14
    }

    public final int p(View r10, int r11, int[] r12, int r13) {
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).rightMargin - r12[1];
        int r16 = r11 - Math.max(0, r15);
        r12[1] = Math.max(0, -r15);
        int r17 = i(r10, r13);
        int r18 = r10.getMeasuredWidth();
        r10.layout(r16 - r18, r17, r16, r10.getMeasuredHeight() + r17);
        return r16 - (r18 + ((ViewGroup.MarginLayoutParams) r14).leftMargin);
    }

    public final int q(View r10, int r11, int r12, int r13, int r14, int[] r15) {
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r17 = r16.leftMargin - r15[0];
        int r18 = r16.rightMargin - r15[1];
        int r19 = Math.max(0, r17) + Math.max(0, r18);
        r15[0] = Math.max(0, -r17);
        r15[1] = Math.max(0, -r18);
        r10.measure(ViewGroup.getChildMeasureSpec(r11, ((getPaddingLeft() + getPaddingRight()) + r19) + r12, r16.width), ViewGroup.getChildMeasureSpec(r13, (((getPaddingTop() + getPaddingBottom()) + r16.topMargin) + r16.bottomMargin) + r14, r16.height));
        return r10.getMeasuredWidth() + r19;
    }

    public final void r(View r10, int r11, int r12, int r13, int r14, int r15) {
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r17 = ViewGroup.getChildMeasureSpec(r11, (((getPaddingLeft() + getPaddingRight()) + r16.leftMargin) + r16.rightMargin) + r12, r16.width);
        int r18 = ViewGroup.getChildMeasureSpec(r13, (((getPaddingTop() + getPaddingBottom()) + r16.topMargin) + r16.bottomMargin) + r14, r16.height);
        int r19 = View.MeasureSpec.getMode(r18);
        if (r19 == 1073741824) goto L8;
        if (r15 < 0) goto L8;
        if (r19 == 0) goto L7;
        r15 = Math.min(View.MeasureSpec.getSize(r18), r15);
    L7:
        r18 = View.MeasureSpec.makeMeasureSpec(r15, Ints.MAX_POWER_OF_TWO);
    L8:
        r10.measure(r17, r18);
    }

    public void removeChildrenForExpandedActionView() {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L10;
        View r11 = getChildAt(r10);
        if (((LayoutParams) r11.getLayoutParams()).f945b == 2) goto L9;
        if (r11 == this.mMenuView) goto L9;
        removeViewAt(r10);
        this.mHiddenViews.add(r11);
    L9:
        r10 = r10 - 1;
        goto L3
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.l(r10);
    }

    public final void s() {
        Menu r10 = getMenu();
        ArrayList<MenuItem> r11 = getCurrentMenuItems();
        this.mMenuHostHelper.h(r10, getMenuInflater());
        ArrayList<MenuItem> r12 = getCurrentMenuItems();
        r12.removeAll(r11);
        this.mProvidedMenuItems = r12;
    }

    public void setBackInvokedCallbackEnabled(boolean r10) {
        if (this.mBackInvokedCallbackEnabled == r10) goto L6;
        this.mBackInvokedCallbackEnabled = r10;
        updateBackInvokedCallbackState();
        return;
    }

    public void setCollapseContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getContext().getText(r10);
    L5:
        setCollapseContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setCollapseIcon(@DrawableRes int r10) {
        setCollapseIcon(c.a.b(getContext(), r10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean r10) {
        this.mCollapsible = r10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r10) {
        if (r10 >= 0) goto L5;
        r10 = Integer.MIN_VALUE;
    L5:
        if (r10 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r10;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r10) {
        if (r10 >= 0) goto L5;
        r10 = Integer.MIN_VALUE;
    L5:
        if (r10 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r10;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetsAbsolute(int r10, int r11) {
        c();
        this.mContentInsets.e(r10, r11);
    }

    public void setContentInsetsRelative(int r10, int r11) {
        c();
        this.mContentInsets.g(r10, r11);
    }

    public void setLogo(@DrawableRes int r10) {
        setLogo(c.a.b(getContext(), r10));
    }

    public void setLogoDescription(@StringRes int r10) {
        setLogoDescription(getContext().getText(r10));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMenu(MenuBuilder r10, ActionMenuPresenter r11) {
        if (r10 == null) goto L4;
    L6:
        f();
        MenuBuilder r12 = this.mMenuView.p();
        if (r12 != r10) goto L9;
        return;
    L9:
        if (r12 == null) goto L12;
        r12.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r12.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new f(this);
    L14:
        r11.x(true);
        if (r10 == null) goto L17;
        r10.addMenuPresenter(r11, this.mPopupContext);
        r10.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r11);
        this.mOuterActionMenuPresenter = r11;
        updateBackInvokedCallbackState();
        return;
    L17:
        r11.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r11.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.mActionMenuPresenterCallback = r10;
        this.mMenuBuilderCallback = r11;
        ActionMenuView r12 = this.mMenuView;
        if (r12 == null) goto L6;
        r12.q(r10, r11);
        return;
    }

    public void setNavigationContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getContext().getText(r10);
    L5:
        setNavigationContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setNavigationIcon(@DrawableRes int r10) {
        setNavigationIcon(c.a.b(getContext(), r10));
    }

    public void setNavigationOnClickListener(View.OnClickListener r10) {
        g();
        this.mNavButtonView.setOnClickListener(r10);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r10) {
        this.mOnMenuItemClickListener = r10;
    }

    public void setOverflowIcon(@Nullable Drawable r10) {
        e();
        this.mMenuView.setOverflowIcon(r10);
    }

    public void setPopupTheme(@StyleRes int r10) {
        if (this.mPopupTheme == r10) goto L9;
        this.mPopupTheme = r10;
        if (r10 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r10);
        return;
    }

    public void setSubtitle(@StringRes int r10) {
        setSubtitle(getContext().getText(r10));
    }

    public void setSubtitleTextAppearance(Context r10, @StyleRes int r11) {
        this.mSubtitleTextAppearance = r11;
        TextView r12 = this.mSubtitleTextView;
        if (r12 == null) goto L6;
        r12.setTextAppearance(r10, r11);
        return;
    }

    public void setSubtitleTextColor(@ColorInt int r10) {
        setSubtitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setTitle(@StringRes int r10) {
        setTitle(getContext().getText(r10));
    }

    public void setTitleMargin(int r10, int r11, int r12, int r13) {
        this.mTitleMarginStart = r10;
        this.mTitleMarginTop = r11;
        this.mTitleMarginEnd = r12;
        this.mTitleMarginBottom = r13;
        requestLayout();
    }

    public void setTitleMarginBottom(int r10) {
        this.mTitleMarginBottom = r10;
        requestLayout();
    }

    public void setTitleMarginEnd(int r10) {
        this.mTitleMarginEnd = r10;
        requestLayout();
    }

    public void setTitleMarginStart(int r10) {
        this.mTitleMarginStart = r10;
        requestLayout();
    }

    public void setTitleMarginTop(int r10) {
        this.mTitleMarginTop = r10;
        requestLayout();
    }

    public void setTitleTextAppearance(Context r10, @StyleRes int r11) {
        this.mTitleTextAppearance = r11;
        TextView r12 = this.mTitleTextView;
        if (r12 == null) goto L6;
        r12.setTextAppearance(r10, r11);
        return;
    }

    public void setTitleTextColor(@ColorInt int r10) {
        setTitleTextColor(ColorStateList.valueOf(r10));
    }

    public boolean showOverflowMenu() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.r() == false) goto L7;
        return true;
    }

    public final void t() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    public final boolean u() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L15;
        View r12 = getChildAt(r11);
        if (v(r12) == false) goto L14;
        if (r12.getMeasuredWidth() <= 0) goto L14;
        if (r12.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r11 = r11 + 1;
        goto L6
    L15:
        return true;
    }

    public void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L25;
        OnBackInvokedDispatcher r10 = e.a(this);
        if (hasExpandedActionView() == false) goto L12;
        if (r10 == null) goto L12;
        if (ViewCompat.S(this) == false) goto L12;
        if (this.mBackInvokedCallbackEnabled == false) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == true) goto L15;
    L20:
        if (r11 == true) goto L27;
        OnBackInvokedDispatcher r12 = this.mBackInvokedDispatcher;
        if (r12 == null) goto L28;
        e.d(r12, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = null;
        return;
    L28:
        return;
    L27:
        return;
    L15:
        if (this.mBackInvokedDispatcher != null) goto L20;
        if (this.mBackInvokedCallback != null) goto L19;
        this.mBackInvokedCallback = e.b(new c0(this));
    L19:
        e.c(r10, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = r10;
        return;
    L12:
        r11 = false;
        goto L13
    }

    public final boolean v(View r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.getParent() != this) goto L8;
        if (r10.getVisibility() == 8) goto L8;
        return true;
    }

    public Toolbar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.toolbarStyle);
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11) {
        this.mMenuHostHelper.d(r10, r11);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    public void setCollapseContentDescription(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r11 = this.mCollapseButtonView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        return;
    }

    public void setCollapseIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r10);
        return;
    L4:
        ImageButton r11 = this.mCollapseButtonView;
        if (r11 == null) goto L9;
        r11.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public void setLogo(Drawable r10) {
        if (r10 == null) goto L6;
        d();
        if (n(this.mLogoView) == true) goto L11;
        b(this.mLogoView, true);
    L11:
        ImageView r11 = this.mLogoView;
        if (r11 == null) goto L15;
        r11.setImageDrawable(r10);
        return;
    L15:
        return;
    L6:
        ImageView r12 = this.mLogoView;
        if (r12 == null) goto L11;
        if (n(r12) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        d();
    L5:
        ImageView r11 = this.mLogoView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        return;
    }

    public void setNavigationContentDescription(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        g();
    L5:
        ImageButton r11 = this.mNavButtonView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        g0.a(this.mNavButtonView, r10);
        return;
    }

    public void setNavigationIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L6;
        g();
        if (n(this.mNavButtonView) == true) goto L11;
        b(this.mNavButtonView, true);
    L11:
        ImageButton r11 = this.mNavButtonView;
        if (r11 == null) goto L15;
        r11.setImageDrawable(r10);
        return;
    L15:
        return;
    L6:
        ImageButton r12 = this.mNavButtonView;
        if (r12 == null) goto L11;
        if (n(r12) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setSubtitle(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        TextView r11 = this.mSubtitleTextView;
        if (r11 != null) goto L18;
    L20:
        TextView r12 = this.mSubtitleTextView;
        if (r12 == null) goto L23;
        r12.setText(r10);
    L23:
        this.mSubtitleText = r10;
        return;
    L18:
        if (n(r11) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r13 = getContext();
        AppCompatTextView r14 = new AppCompatTextView(r13);
        this.mSubtitleTextView = r14;
        r14.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r15 = this.mSubtitleTextAppearance;
        if (r15 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r13, r15);
    L9:
        ColorStateList r16 = this.mSubtitleTextColor;
        if (r16 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r16);
    L13:
        if (n(this.mSubtitleTextView) == true) goto L20;
        b(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextColor(@NonNull ColorStateList r10) {
        this.mSubtitleTextColor = r10;
        TextView r11 = this.mSubtitleTextView;
        if (r11 == null) goto L6;
        r11.setTextColor(r10);
        return;
    }

    public void setTitle(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        TextView r11 = this.mTitleTextView;
        if (r11 != null) goto L18;
    L20:
        TextView r12 = this.mTitleTextView;
        if (r12 == null) goto L23;
        r12.setText(r10);
    L23:
        this.mTitleText = r10;
        return;
    L18:
        if (n(r11) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r13 = getContext();
        AppCompatTextView r14 = new AppCompatTextView(r13);
        this.mTitleTextView = r14;
        r14.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r15 = this.mTitleTextAppearance;
        if (r15 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r13, r15);
    L9:
        ColorStateList r16 = this.mTitleTextColor;
        if (r16 == null) goto L13;
        this.mTitleTextView.setTextColor(r16);
    L13:
        if (n(this.mTitleTextView) == true) goto L20;
        b(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleTextColor(@NonNull ColorStateList r10) {
        this.mTitleTextColor = r10;
        TextView r11 = this.mTitleTextView;
        if (r11 == null) goto L6;
        r11.setTextColor(r10);
        return;
    }

    public Toolbar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new d0(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new a(this);
        this.mShowOverflowMenuRunnable = new b(this);
        Context r13 = getContext();
        int[] r14 = R$styleable.Toolbar;
        b0 r15 = b0.v(r13, r11, r14, r12, 0);
        ViewCompat.n0(this, r10, r14, r11, r15.r(), r12, 0);
        this.mTitleTextAppearance = r15.n(R$styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = r15.n(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = r15.l(R$styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = r15.l(R$styleable.Toolbar_buttonGravity, 48);
        int r16 = r15.e(R$styleable.Toolbar_titleMargin, 0);
        int r17 = R$styleable.Toolbar_titleMargins;
        if (r15.s(r17) == false) goto L5;
        r16 = r15.e(r17, r16);
    L5:
        this.mTitleMarginBottom = r16;
        this.mTitleMarginTop = r16;
        this.mTitleMarginEnd = r16;
        this.mTitleMarginStart = r16;
        int r18 = r15.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (r18 < 0) goto L8;
        this.mTitleMarginStart = r18;
    L8:
        int r19 = r15.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (r19 < 0) goto L11;
        this.mTitleMarginEnd = r19;
    L11:
        int r110 = r15.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (r110 < 0) goto L14;
        this.mTitleMarginTop = r110;
    L14:
        int r111 = r15.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (r111 < 0) goto L17;
        this.mTitleMarginBottom = r111;
    L17:
        this.mMaxButtonHeight = r15.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int r112 = r15.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int r113 = r15.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int r20 = r15.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int r21 = r15.f(R$styleable.Toolbar_contentInsetRight, 0);
        c();
        this.mContentInsets.e(r20, r21);
        if (r112 != Integer.MIN_VALUE) goto L20;
        if (r113 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r15.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r15.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = r15.g(R$styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = r15.p(R$styleable.Toolbar_collapseContentDescription);
        CharSequence r114 = r15.p(R$styleable.Toolbar_title);
        if (TextUtils.isEmpty(r114) == true) goto L24;
        setTitle(r114);
    L24:
        CharSequence r115 = r15.p(R$styleable.Toolbar_subtitle);
        if (TextUtils.isEmpty(r115) == true) goto L27;
        setSubtitle(r115);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r15.n(R$styleable.Toolbar_popupTheme, 0));
        Drawable r116 = r15.g(R$styleable.Toolbar_navigationIcon);
        if (r116 == null) goto L30;
        setNavigationIcon(r116);
    L30:
        CharSequence r117 = r15.p(R$styleable.Toolbar_navigationContentDescription);
        if (TextUtils.isEmpty(r117) == true) goto L33;
        setNavigationContentDescription(r117);
    L33:
        Drawable r118 = r15.g(R$styleable.Toolbar_logo);
        if (r118 == null) goto L36;
        setLogo(r118);
    L36:
        CharSequence r119 = r15.p(R$styleable.Toolbar_logoDescription);
        if (TextUtils.isEmpty(r119) == true) goto L39;
        setLogoDescription(r119);
    L39:
        int r120 = R$styleable.Toolbar_titleTextColor;
        if (r15.s(r120) == false) goto L42;
        setTitleTextColor(r15.c(r120));
    L42:
        int r121 = R$styleable.Toolbar_subtitleTextColor;
        if (r15.s(r121) == false) goto L45;
        setSubtitleTextColor(r15.c(r121));
    L45:
        int r122 = R$styleable.Toolbar_menu;
        if (r15.s(r122) == false) goto L48;
        inflateMenu(r15.n(r122, 0));
    L48:
        r15.w();
        return;
    L20:
        this.mContentInsets.g(r112, r113);
        goto L21
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull Lifecycle.State r12) {
        this.mMenuHostHelper.e(r10, r11, r12);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r10);
    L7:
        if ((r10 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r10);
    L11:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L15:
        return new LayoutParams(r10);
    }
}
