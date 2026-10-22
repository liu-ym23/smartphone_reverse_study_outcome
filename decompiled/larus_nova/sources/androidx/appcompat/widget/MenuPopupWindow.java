package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r100) {
            if (this.mHoverListener == null) goto L27;
            ListAdapter r101 = getAdapter();
            if ((r101 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r102 = (HeaderViewListAdapter) r101;
            int r103 = r102.getHeadersCount();
            MenuAdapter r104 = (MenuAdapter) r102.getWrappedAdapter();
        L9:
            if (r100.getAction() == 10) goto L17;
            int r105 = pointToPosition((int) r100.getX(), (int) r100.getY());
            if (r105 == (-1)) goto L17;
            int r106 = r105 - r103;
            if (r106 < 0) goto L17;
            if (r106 >= r104.getCount()) goto L17;
            MenuItemImpl r107 = r104.getItem(r106);
        L18:
            MenuItem r108 = this.mHoveredMenuItem;
            if (r108 == r107) goto L27;
            MenuBuilder r109 = r104.getAdapterMenu();
            if (r108 == null) goto L23;
            this.mHoverListener.onItemHoverExit(r109, r108);
        L23:
            this.mHoveredMenuItem = r107;
            if (r107 == null) goto L27;
            this.mHoverListener.onItemHoverEnter(r109, r107);
        L17:
            r107 = null;
            goto L18
        L7:
            r104 = (MenuAdapter) r101;
            r103 = 0;
        L27:
            return super.onHoverEvent(r100);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r100) {
            return super.onTouchEvent(r100);
        }

        public void setHoverListener(MenuItemHoverListener r100) {
            this.mHoverListener = r100;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r100) {
            super.setSelector(r100);
        }

        public MenuDropDownListView(Context r100, boolean r101) {
            super(r100, r101);
            if (1 != r100.getResources().getConfiguration().getLayoutDirection()) goto L5;
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
            return;
        L5:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r100, boolean r101) {
            return super.lookForSelectablePosition(r100, r101);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r100, int r101) {
            return super.onForwardedEvent(r100, r101);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r100, KeyEvent r101) {
            ListMenuItemView r102 = (ListMenuItemView) getSelectedView();
            if (r102 != null) goto L5;
        L12:
            if (r102 == null) goto L22;
            if (r100 != this.mRetreatKey) goto L22;
            setSelection(-1);
            ListAdapter r103 = getAdapter();
            if ((r103 instanceof HeaderViewListAdapter) == false) goto L18;
            MenuAdapter r104 = (MenuAdapter) ((HeaderViewListAdapter) r103).getWrappedAdapter();
        L19:
            r104.getAdapterMenu().close(false);
            return true;
        L18:
            r104 = (MenuAdapter) r103;
        L22:
            return super.onKeyDown(r100, r101);
        L5:
            if (r100 != this.mAdvanceKey) goto L12;
            if (r102.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r102.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r102, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r100, int r101, int r102, int r103, int r104) {
            return super.measureHeightOfChildrenCompat(r100, r101, r102, r103, r104);
        }
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
        return;
    L9:
        return;
    }

    public void setEnterTransition(Object r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mPopup.setEnterTransition((Transition) r100);
        return;
    }

    public void setExitTransition(Object r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mPopup.setExitTransition((Transition) r100);
        return;
    }

    public void setHoverListener(MenuItemHoverListener r100) {
        this.mHoverListener = r100;
    }

    public void setTouchModal(boolean r100) {
        if (Build.VERSION.SDK_INT > 28) goto L8;
        Method r101 = sSetTouchModalMethod;
        if (r101 == null) goto L13;
        r101.invoke(this.mPopup, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    L8:
        this.mPopup.setTouchModal(r100);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    public DropDownListView createDropDownListView(Context r100, boolean r101) {
        MenuDropDownListView r102 = new MenuDropDownListView(r100, r101);
        r102.setHoverListener(this);
        return r102;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder r100, MenuItem r101) {
        MenuItemHoverListener r102 = this.mHoverListener;
        if (r102 == null) goto L6;
        r102.onItemHoverEnter(r100, r101);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder r100, MenuItem r101) {
        MenuItemHoverListener r102 = this.mHoverListener;
        if (r102 == null) goto L6;
        r102.onItemHoverExit(r100, r101);
        return;
    }

    public MenuPopupWindow(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
