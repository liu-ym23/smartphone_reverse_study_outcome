package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/view/D5;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "disallowIntercept", "LY8/t;", "requestDisallowInterceptTouchEvent", "(Z)V", "Landroid/view/MotionEvent;", "event", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "touchSlop", "I", "", "initialX", "F", "initialY", "sealingHorizontally", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class D5 extends FrameLayout {
    private float initialX;
    private float initialY;
    private boolean sealingHorizontally;
    private final int touchSlop;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.initialX = event.getX();
            this.initialY = event.getY();
            this.sealingHorizontally = false;
        } else if (actionMasked == 2) {
            float fAbs = Math.abs(event.getX() - this.initialX);
            float fAbs2 = Math.abs(event.getY() - this.initialY);
            float f10 = fAbs * 0.5f;
            int i10 = this.touchSlop;
            if (f10 > i10 || fAbs2 > i10) {
                boolean z10 = f10 >= fAbs2;
                this.sealingHorizontally = z10;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(z10);
                }
            }
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept || !this.sealingHorizontally) {
            super.requestDisallowInterceptTouchEvent(disallowIntercept);
        }
    }

    public /* synthetic */ D5(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
