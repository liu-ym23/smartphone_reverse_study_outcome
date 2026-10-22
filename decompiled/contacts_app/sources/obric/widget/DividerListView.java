package obric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* JADX INFO: loaded from: classes5.dex */
public class DividerListView extends ListView {
    private Rect mBounds;

    public DividerListView(Context context) {
        super(context);
        this.mBounds = new Rect();
    }

    public DividerListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mBounds = new Rect();
    }

    public DividerListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mBounds = new Rect();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mBounds.left = getPaddingLeft();
        this.mBounds.right = (getRight() - getLeft()) - getPaddingRight();
        Drawable r0 = getDivider();
        int r1 = getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        int r3 = r2 + 1;
        if (r2 == (r1 - 1)) goto L11;
        if (getAdapter().isEnabled(r2) == true) goto L9;
    L10:
        View r4 = getChildAt(r2);
        this.mBounds.top = r4.getBottom();
        this.mBounds.bottom = r4.getBottom() + getDividerHeight();
        r0.setBounds(this.mBounds);
        r0.draw(canvas);
        goto L11
    L9:
        if (getAdapter().isEnabled(r3) == false) goto L10;
    L11:
        r2 = r3;
        goto L3
    }
}
