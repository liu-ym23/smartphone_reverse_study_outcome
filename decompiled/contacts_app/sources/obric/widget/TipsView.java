package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class TipsView extends TextView {
    public TipsView(Context context) {
        this(context, null);
    }

    public TipsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TipsView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.TipsViewAppearance);
    }

    public TipsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void setTextAlignMode() {
        if (getLineCount() <= 1) goto L5;
        int r0 = 3;
    L6:
        setGravity(r0);
        return;
    L5:
        r0 = 17;
        goto L6
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setTextAlignMode();
    }
}
