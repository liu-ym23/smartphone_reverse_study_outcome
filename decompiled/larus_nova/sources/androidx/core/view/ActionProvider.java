package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ActionProvider {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean r100);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean r100);
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu r100) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener != null) goto L5;
        return;
    L5:
        if (overridesItemVisibility() == false) goto L9;
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
        return;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ActionProvider(Context r100) {
        this.mContext = r100;
    }

    public View onCreateActionView(MenuItem r100) {
        return onCreateActionView();
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener r100) {
        this.mSubUiVisibilityListener = r100;
    }

    public void setVisibilityListener(VisibilityListener r100) {
        if (this.mVisibilityListener == null) goto L6;
        if (r100 != null) goto L6;
    L6:
        this.mVisibilityListener = r100;
    }

    public void subUiVisibilityChanged(boolean r100) {
        SubUiVisibilityListener r101 = this.mSubUiVisibilityListener;
        if (r101 == null) goto L6;
        r101.onSubUiVisibilityChanged(r100);
        return;
    }
}
