package com.mdisdk.mirror;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/mdisdk/mirror/TouchForwardingOverlay;", "Landroid/view/View;", "Landroid/content/Context;", "context", "Lcom/mdisdk/mirror/TouchForwarder;", "forwarder", AppAgent.CONSTRUCT, "(Landroid/content/Context;Lcom/mdisdk/mirror/TouchForwarder;)V", "Lcom/mdisdk/Task;", "task", "LC7/r;", "setTask$mdisdk_release", "(Lcom/mdisdk/Task;)V", "setTask", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/mdisdk/mirror/TouchForwarder;", "Lcom/mdisdk/Task;", "enableTouch", "Z", "getEnableTouch$mdisdk_release", "()Z", "setEnableTouch$mdisdk_release", "(Z)V", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TouchForwardingOverlay extends View {
    private volatile boolean enableTouch;
    private final TouchForwarder forwarder;
    private volatile Task task;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchForwardingOverlay(Context context, TouchForwarder forwarder) {
        super(context);
        k.f(context, "context");
        k.f(forwarder, "forwarder");
        this.forwarder = forwarder;
        this.enableTouch = true;
    }

    /* renamed from: getEnableTouch$mdisdk_release, reason: from getter */
    public final boolean getEnableTouch() {
        return this.enableTouch;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        ViewParent parent;
        k.f(event, "event");
        if (!this.enableTouch) {
            return false;
        }
        if (event.getActionMasked() == 0 && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Task task = this.task;
        if (task != null && !task.getIsFinishing()) {
            this.forwarder.forward(event, task.getDisplayId());
        }
        return true;
    }

    public final void setEnableTouch$mdisdk_release(boolean z10) {
        this.enableTouch = z10;
    }

    public final void setTask$mdisdk_release(Task task) {
        Task task2 = this.task;
        if (task2 != task && task2 != null) {
            this.forwarder.cancel(task2.getDisplayId());
        }
        this.task = task;
    }
}
