package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SupportActionModeWrapper extends android.view.ActionMode {
    final Context mContext;
    final ActionMode mWrappedObject;

    public static class CallbackWrapper implements ActionMode.Callback {
        final ArrayList<SupportActionModeWrapper> mActionModes;
        final Context mContext;
        final SimpleArrayMap<Menu, Menu> mMenus;
        final android.view.ActionMode.Callback mWrappedCallback;

        private Menu getMenuWrapper(Menu r100) {
            Menu r101 = this.mMenus.get(r100);
            if (r101 != null) goto L6;
            MenuWrapperICS r102 = new MenuWrapperICS(this.mContext, (SupportMenu) r100);
            this.mMenus.put(r100, r102);
            return r102;
        L6:
            return r101;
        }

        public android.view.ActionMode getActionModeWrapper(ActionMode r100) {
            int r101 = this.mActionModes.size();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L10;
            SupportActionModeWrapper r103 = (SupportActionModeWrapper) ListProtector.get(this.mActionModes, r102);
            if (r103 == null) goto L9;
            if (r103.mWrappedObject != r100) goto L9;
            return r103;
        L9:
            r102 = r102 + 1;
            goto L3
        L10:
            SupportActionModeWrapper r104 = new SupportActionModeWrapper(this.mContext, r100);
            this.mActionModes.add(r104);
            return r104;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r100) {
            this.mWrappedCallback.onDestroyActionMode(getActionModeWrapper(r100));
        }

        public CallbackWrapper(Context r100, android.view.ActionMode.Callback r101) {
            this.mContext = r100;
            this.mWrappedCallback = r101;
            this.mActionModes = new ArrayList();
            this.mMenus = new SimpleArrayMap();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            return this.mWrappedCallback.onActionItemClicked(getActionModeWrapper(r100), new MenuItemWrapperICS(this.mContext, (SupportMenuItem) r101));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r100, Menu r101) {
            return this.mWrappedCallback.onCreateActionMode(getActionModeWrapper(r100), getMenuWrapper(r101));
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            return this.mWrappedCallback.onPrepareActionMode(getActionModeWrapper(r100), getMenuWrapper(r101));
        }
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.mWrappedObject.finish();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.mWrappedObject.getCustomView();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuWrapperICS(this.mContext, (SupportMenu) this.mWrappedObject.getMenu());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.mWrappedObject.getMenuInflater();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mWrappedObject.getSubtitle();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.mWrappedObject.getTag();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.mWrappedObject.getTitleOptionalHint();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.mWrappedObject.invalidate();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.mWrappedObject.isTitleOptional();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View r100) {
        this.mWrappedObject.setCustomView(r100);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int r100) {
        this.mWrappedObject.setSubtitle(r100);
    }

    @Override // android.view.ActionMode
    public void setTag(Object r100) {
        this.mWrappedObject.setTag(r100);
    }

    @Override // android.view.ActionMode
    public void setTitle(int r100) {
        this.mWrappedObject.setTitle(r100);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean r100) {
        this.mWrappedObject.setTitleOptionalHint(r100);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence r100) {
        this.mWrappedObject.setSubtitle(r100);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence r100) {
        this.mWrappedObject.setTitle(r100);
    }

    public SupportActionModeWrapper(Context r100, ActionMode r101) {
        this.mContext = r100;
        this.mWrappedObject = r101;
    }
}
