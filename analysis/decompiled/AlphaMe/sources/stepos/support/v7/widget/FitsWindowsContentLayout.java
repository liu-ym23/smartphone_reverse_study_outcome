package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;
import stepos.support.v7.app.AbstractC0873s;
import stepos.support.v7.app.C0872q;

/* loaded from: classes2.dex */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private F mOnStartActionModeListener;

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void makeOptionalFitsSystemWindows() {
    }

    public void setOnStartActionModeListener(F f4) {
        this.mOnStartActionModeListener = f4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        F f4 = this.mOnStartActionModeListener;
        ActionMode actionModeOnWindowStartingActionMode = f4 != null ? ((AbstractC0873s) ((C0872q) f4).f14583b).f14512d.onWindowStartingActionMode(callback, 0) : null;
        return actionModeOnWindowStartingActionMode == null ? super.startActionModeForChild(view, callback) : actionModeOnWindowStartingActionMode;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public FitsWindowsContentLayout(Context context) {
        super(context, null);
    }
}
