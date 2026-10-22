package androidx.appcompat.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ActionMode {
    private Object mTag;
    private boolean mTitleOptionalHint;

    public interface Callback {
        boolean onActionItemClicked(ActionMode r100, MenuItem r101);

        boolean onCreateActionMode(ActionMode r100, Menu r101);

        void onDestroyActionMode(ActionMode r100);

        boolean onPrepareActionMode(ActionMode r100, Menu r101);
    }

    public ActionMode() {
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public abstract CharSequence getTitle();

    public abstract void invalidate();

    public boolean isTitleOptional() {
        return false;
    }

    public boolean isUiFocusable() {
        return true;
    }

    public abstract void setCustomView(View r100);

    public abstract void setSubtitle(int r100);

    public abstract void setSubtitle(CharSequence r100);

    public abstract void setTitle(int r100);

    public abstract void setTitle(CharSequence r100);

    public Object getTag() {
        return this.mTag;
    }

    public boolean getTitleOptionalHint() {
        return this.mTitleOptionalHint;
    }

    public void setTag(Object r100) {
        this.mTag = r100;
    }

    public void setTitleOptionalHint(boolean r100) {
        this.mTitleOptionalHint = r100;
    }
}
