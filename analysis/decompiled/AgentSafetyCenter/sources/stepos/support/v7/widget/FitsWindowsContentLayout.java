package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private e0 mOnStartActionModeListener;

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public void setOnStartActionModeListener(e0 e0Var) {
        this.mOnStartActionModeListener = e0Var;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        e0 e0Var = this.mOnStartActionModeListener;
        ActionMode actionModeOnWindowStartingActionMode = e0Var != null ? ((stepos.support.v7.app.m) e0Var).f12342c.f12390h.onWindowStartingActionMode(callback, 0) : null;
        return actionModeOnWindowStartingActionMode == null ? super.startActionModeForChild(view, callback) : actionModeOnWindowStartingActionMode;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void makeOptionalFitsSystemWindows() {
    }
}
