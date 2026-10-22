package stepos.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import androidx.appcompat.widget.ContentFrameLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FitsWindowsContentLayout extends ContentFrameLayout {
    private a mOnStartActionModeListener;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
    }

    public FitsWindowsContentLayout(Context context) {
        super(context);
    }

    public void setOnStartActionModeListener(a aVar) {
        this.mOnStartActionModeListener = aVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        a aVar = this.mOnStartActionModeListener;
        ActionMode actionModeOnWindowStartingActionMode = aVar != null ? stepos.support.v7.app.k.this.f12128d.onWindowStartingActionMode(callback, 0) : null;
        return actionModeOnWindowStartingActionMode == null ? super.startActionModeForChild(view, callback) : actionModeOnWindowStartingActionMode;
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FitsWindowsContentLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void makeOptionalFitsSystemWindows() {
    }
}
