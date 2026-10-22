package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SurnameGridView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mPrePosition", "", "mPressChangeListener", "Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "mTouchedPosition", "onTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "setOnPressChangeListener", "", "listener", "OnPressChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameGridView extends GridView {
    private int mPrePosition;
    private OnPressChangeListener mPressChangeListener;
    private int mTouchedPosition;

    /* JADX INFO: compiled from: SurnameGridView.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "", "onTouched", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPressChangeListener {
        void onTouched(int r1);
    }

    public SurnameGridView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mTouchedPosition = -1;
        this.mPrePosition = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        int r0 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L5;
        this.mTouchedPosition = r0;
    L15:
        if (this.mPrePosition == r0) goto L18;
        OnPressChangeListener r2 = this.mPressChangeListener;
        Intrinsics.checkNotNull(r2);
        r2.onTouched(r0);
        this.mPrePosition = r0;
    L18:
        return super.onTouchEvent(r5);
    L5:
        if (r1 != 1) goto L7;
    L9:
        r0 = -1;
        goto L15
    L7:
        if (r1 != 2) goto L9;
        int r3 = this.mTouchedPosition;
        if (r3 != r0) goto L9;
        r0 = r3;
        goto L15
    }

    public final void setOnPressChangeListener(OnPressChangeListener r1) {
        this.mPressChangeListener = r1;
    }
}
