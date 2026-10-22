package com.stepos.agentframework.chatui.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/FeedbackInputScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ownsGesture", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeedbackInputScrollView extends ScrollView {
    private boolean ownsGesture;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FeedbackInputScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.p.i(r5, r0)
            int r0 = r5.getActionMasked()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L34
            if (r0 == r2) goto L24
            r3 = 2
            if (r0 == r3) goto L16
            r2 = 3
            if (r0 == r2) goto L24
            goto L4f
        L16:
            boolean r0 = r4.ownsGesture
            if (r0 == 0) goto L4f
            android.view.ViewParent r0 = r4.getParent()
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L4f
        L24:
            boolean r0 = r4.ownsGesture
            if (r0 == 0) goto L31
            android.view.ViewParent r0 = r4.getParent()
            if (r0 == 0) goto L31
            r0.requestDisallowInterceptTouchEvent(r1)
        L31:
            r4.ownsGesture = r1
            goto L4f
        L34:
            boolean r0 = r4.canScrollVertically(r2)
            if (r0 != 0) goto L41
            r0 = -1
            boolean r0 = r4.canScrollVertically(r0)
            if (r0 == 0) goto L42
        L41:
            r1 = r2
        L42:
            r4.ownsGesture = r1
            if (r1 == 0) goto L4f
            android.view.ViewParent r0 = r4.getParent()
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
        L4f:
            boolean r4 = super.dispatchTouchEvent(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.dialog.FeedbackInputScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackInputScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ FeedbackInputScrollView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
