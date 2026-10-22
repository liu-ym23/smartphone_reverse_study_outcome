package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;
import stepos.support.v7.app.C1968q;

/* loaded from: classes4.dex */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private K mOnStartActionModeListener;

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public void makeOptionalFitsSystemWindows() {
    }

    public void setOnStartActionModeListener(K k) {
        this.mOnStartActionModeListener = k;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        K k = this.mOnStartActionModeListener;
        ActionMode actionModeOnWindowStartingActionMode = k != null ? ((C1968q) ((B1.c) k).f180a).d.onWindowStartingActionMode(callback, 0) : null;
        return actionModeOnWindowStartingActionMode == null ? super.startActionModeForChild(view, callback) : actionModeOnWindowStartingActionMode;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
