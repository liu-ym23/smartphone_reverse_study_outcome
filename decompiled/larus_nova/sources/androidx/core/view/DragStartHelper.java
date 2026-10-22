package androidx.core.view;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes17.dex */
public class DragStartHelper {
    private boolean mDragging;
    private int mLastTouchX;
    private int mLastTouchY;
    private final OnDragStartListener mListener;
    private final View.OnLongClickListener mLongClickListener;
    private final View.OnTouchListener mTouchListener;
    private final View mView;

    public interface OnDragStartListener {
        boolean onDragStart(View r100, DragStartHelper r101);
    }

    public void attach() {
        this.mView.setOnLongClickListener(this.mLongClickListener);
        this.mView.setOnTouchListener(this.mTouchListener);
    }

    public void detach() {
        this.mView.setOnLongClickListener(null);
        this.mView.setOnTouchListener(null);
    }

    public void getTouchPosition(Point r100) {
        r100.set(this.mLastTouchX, this.mLastTouchY);
    }

    public boolean onLongClick(View r100) {
        if (this.mDragging == false) goto L6;
        return true;
    L6:
        boolean r101 = this.mListener.onDragStart(r100, this);
        this.mDragging = r101;
        return r101;
    }

    public DragStartHelper(View r100, OnDragStartListener r101) {
        this.mLongClickListener = new d(this);
        this.mTouchListener = new e(this);
        this.mView = r100;
        this.mListener = r101;
    }

    public boolean onTouch(View r100, MotionEvent r101) {
        int r102 = (int) r101.getX();
        int r103 = (int) r101.getY();
        int r104 = r101.getAction();
        if (r104 != 0) goto L5;
        this.mLastTouchX = r102;
        this.mLastTouchY = r103;
    L28:
        return false;
    L5:
        if (r104 != 1) goto L7;
    L26:
        this.mDragging = false;
        goto L28
    L7:
        if (r104 == 2) goto L12;
        if (r104 == 3) goto L26;
    L12:
        if (MotionEventCompat.isFromSource(r101, 8194) == false) goto L28;
        if ((r101.getButtonState() & 1) == 0) goto L28;
        if (this.mDragging == true) goto L28;
        if (this.mLastTouchX == r102) goto L22;
    L24:
        this.mLastTouchX = r102;
        this.mLastTouchY = r103;
        boolean r105 = this.mListener.onDragStart(r100, this);
        this.mDragging = r105;
        return r105;
    L22:
        if (this.mLastTouchY != r103) goto L24;
        goto L24
    }
}
