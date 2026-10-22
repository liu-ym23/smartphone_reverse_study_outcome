package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/chat/view/AgentDevicesScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "velocityY", "LY8/t;", "p", "(I)V", "disallow", "X", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView;", ExifInterface.LONGITUDE_WEST, "()Landroidx/recyclerview/widget/RecyclerView;", "", "lastY", "F", "downX", "downY", "dragAxisDecided", "Z", "grabbing", "touchSlop", "I", "axisSlop", "outerRv", "Landroidx/recyclerview/widget/RecyclerView;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentDevicesScrollView extends NestedScrollView {
    private final int axisSlop;
    private float downX;
    private float downY;
    private boolean dragAxisDecided;
    private boolean grabbing;
    private float lastY;
    private RecyclerView outerRv;
    private final int touchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentDevicesScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public final RecyclerView W() {
        RecyclerView recyclerView = this.outerRv;
        if (recyclerView != null) {
            return recyclerView;
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof RecyclerView) {
                RecyclerView recyclerView2 = (RecyclerView) parent;
                this.outerRv = recyclerView2;
                return recyclerView2;
            }
        }
        return null;
    }

    public final void X(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.p.i(r7, r0)
            int r0 = r7.getActionMasked()
            r1 = 0
            if (r0 == 0) goto L74
            r2 = 1
            if (r0 == r2) goto L70
            r3 = 2
            if (r0 == r3) goto L17
            r2 = 3
            if (r0 == r2) goto L70
            goto L8a
        L17:
            float r0 = r7.getX()
            float r3 = r6.downX
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            float r3 = r7.getY()
            float r4 = r6.downY
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            boolean r4 = r6.dragAxisDecided
            if (r4 != 0) goto L48
            int r4 = r6.axisSlop
            float r5 = (float) r4
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 > 0) goto L3d
            float r4 = (float) r4
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L48
        L3d:
            r6.dragAxisDecided = r2
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 <= 0) goto L45
            r0 = r2
            goto L46
        L45:
            r0 = r1
        L46:
            r6.grabbing = r0
        L48:
            boolean r0 = r6.grabbing
            if (r0 == 0) goto L66
            float r0 = r7.getY()
            float r1 = r6.lastY
            float r0 = r0 - r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L5e
            r0 = -1
            boolean r0 = r6.canScrollVertically(r0)
            goto L62
        L5e:
            boolean r0 = r6.canScrollVertically(r2)
        L62:
            r6.X(r0)
            goto L69
        L66:
            r6.X(r1)
        L69:
            float r0 = r7.getY()
            r6.lastY = r0
            goto L8a
        L70:
            r6.X(r1)
            goto L8a
        L74:
            float r0 = r7.getX()
            r6.downX = r0
            float r0 = r7.getY()
            r6.downY = r0
            float r0 = r7.getY()
            r6.lastY = r0
            r6.dragAxisDecided = r1
            r6.grabbing = r1
        L8a:
            boolean r6 = super.dispatchTouchEvent(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.AgentDevicesScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.core.widget.NestedScrollView
    public void p(int velocityY) {
        if (canScrollVertically(velocityY > 0 ? 1 : -1)) {
            super.p(velocityY);
            return;
        }
        RecyclerView recyclerViewW = W();
        if (recyclerViewW != null) {
            recyclerViewW.fling(0, velocityY);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentDevicesScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.touchSlop = scaledTouchSlop;
        this.axisSlop = C5685n.f(scaledTouchSlop / 2, 1);
    }

    public /* synthetic */ AgentDevicesScrollView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
