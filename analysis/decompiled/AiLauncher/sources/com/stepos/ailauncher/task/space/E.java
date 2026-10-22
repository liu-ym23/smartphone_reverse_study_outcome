package com.stepos.ailauncher.task.space;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/ailauncher/task/space/E;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "event", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/stepos/ailauncher/task/space/F;", "touchGate", "Lcom/stepos/ailauncher/task/space/F;", UxipConstants.f30680s, "getTouchPassthrough", "()Z", "setTouchPassthrough", "(Z)V", "touchPassthrough", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class E extends FrameLayout {
    private final F touchGate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public E(Context context) {
        super(context);
        kotlin.jvm.internal.p.i(context, "context");
        this.touchGate = new F();
        setClipChildren(false);
        setClipToPadding(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        return this.touchGate.c(event.getActionMasked() == 0) && super.dispatchTouchEvent(event);
    }

    public final boolean getTouchPassthrough() {
        return this.touchGate.getPassthrough();
    }

    public final void setTouchPassthrough(boolean z10) {
        this.touchGate.b(z10);
    }
}
