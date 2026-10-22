package obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/* JADX INFO: loaded from: classes5.dex */
public class SurnameGridView extends GridView {
    private int mPrePosition;
    private OnPressChangeListener mPressChangeListener;
    private int mTouchedPosition;

    public interface OnPressChangeListener {
        void onTouched(int position);
    }

    public SurnameGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mTouchedPosition = -1;
        this.mPrePosition = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        int r0 = pointToPosition((int) ev.getX(), (int) ev.getY());
        int r1 = ev.getActionMasked();
        if (r1 != 0) goto L5;
        this.mTouchedPosition = r0;
    L15:
        if (this.mPrePosition == r0) goto L18;
        this.mPressChangeListener.onTouched(r0);
        this.mPrePosition = r0;
    L18:
        return super.onTouchEvent(ev);
    L5:
        if (r1 != 1) goto L7;
    L9:
        r0 = -1;
        goto L15
    L7:
        if (r1 != 2) goto L9;
        int r2 = this.mTouchedPosition;
        if (r2 != r0) goto L9;
        r0 = r2;
        goto L15
    }

    public void setOnPressChangeListener(OnPressChangeListener listener) {
        this.mPressChangeListener = listener;
    }
}
