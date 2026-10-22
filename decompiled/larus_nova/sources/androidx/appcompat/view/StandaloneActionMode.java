package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public void onCloseMenu(MenuBuilder r100, boolean r101) {
    }

    public void onCloseSubMenu(SubMenuBuilder r100) {
    }

    @Override // androidx.appcompat.view.ActionMode
    public void finish() {
        if (this.mFinished == false) goto L5;
        return;
    L5:
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View getCustomView() {
        WeakReference<View> r100 = this.mCustomView;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r100) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder r100) {
        if (r100.hasVisibleItems() == true) goto L5;
        return true;
    L5:
        new MenuPopupHelper(this.mContextView.getContext(), r100).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View r100) {
        this.mContextView.setCustomView(r100);
        if (r100 == null) goto L5;
        WeakReference<View> r101 = new WeakReference(r100);
    L6:
        this.mCustomView = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int r100) {
        setSubtitle(this.mContext.getString(r100));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int r100) {
        setTitle(this.mContext.getString(r100));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean r100) {
        super.setTitleOptionalHint(r100);
        this.mContextView.setTitleOptional(r100);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence r100) {
        this.mContextView.setSubtitle(r100);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence r100) {
        this.mContextView.setTitle(r100);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r100, MenuItem r101) {
        return this.mCallback.onActionItemClicked(this, r101);
    }

    public StandaloneActionMode(Context r100, ActionBarContextView r101, ActionMode.Callback r102, boolean r103) {
        this.mContext = r100;
        this.mContextView = r101;
        this.mCallback = r102;
        MenuBuilder r104 = new MenuBuilder(r101.getContext()).setDefaultShowAsAction(1);
        this.mMenu = r104;
        r104.setCallback(this);
        this.mFocusable = r103;
    }
}
