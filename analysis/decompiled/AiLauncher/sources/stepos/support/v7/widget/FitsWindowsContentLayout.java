package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;

/* loaded from: classes5.dex */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private a mOnStartActionModeListener;

    public interface a {
        ActionMode a(ActionMode.Callback callback, int i10);
    }

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public void makeOptionalFitsSystemWindows() {
    }

    public void setOnStartActionModeListener(a aVar) {
        this.mOnStartActionModeListener = aVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        a aVar = this.mOnStartActionModeListener;
        ActionMode actionModeA = aVar != null ? aVar.a(callback, 0) : null;
        return actionModeA == null ? super.startActionModeForChild(view, callback) : actionModeA;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
