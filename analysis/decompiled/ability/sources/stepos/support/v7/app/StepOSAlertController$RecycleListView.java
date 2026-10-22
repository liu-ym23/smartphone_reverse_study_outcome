package stepos.support.v7.app;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public class StepOSAlertController$RecycleListView extends ListView {
    private final int mPaddingBottomNoButtons;
    private final int mPaddingTopNoTitle;

    public StepOSAlertController$RecycleListView(Context context) {
        this(context, null);
    }

    public void setHasDecor(boolean z10, boolean z11) {
        if (z11 && z10) {
            return;
        }
        setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z11 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
    }

    public StepOSAlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaddingTopNoTitle = 0;
        this.mPaddingBottomNoButtons = 0;
    }
}
