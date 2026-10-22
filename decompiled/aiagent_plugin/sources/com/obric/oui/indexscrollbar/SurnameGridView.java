package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: SurnameGridView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SurnameGridView extends GridView {
    private int mPrePosition;
    private a mPressChangeListener;
    private int mTouchedPosition;

    /* JADX INFO: compiled from: SurnameGridView.kt */
    public interface a {
        void a(int r1);
    }

    public SurnameGridView(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
        this.mTouchedPosition = -1;
        this.mPrePosition = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        o.e(r5, "ev");
        int r0 = pointToPosition((int) r5.getX(), (int) r5.getY());
        int r1 = r5.getActionMasked();
        if (r1 != 0) goto L5;
        this.mTouchedPosition = r0;
    L15:
        if (this.mPrePosition == r0) goto L18;
        a r2 = this.mPressChangeListener;
        o.a(r2);
        r2.a(r0);
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

    public final void setOnPressChangeListener(a r3) {
        this.mPressChangeListener = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }
}
