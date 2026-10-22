package com.mdisdk.mirror;

import android.content.Context;
import android.util.AttributeSet;
import android.view.DefaultLifecycleObserver;
import android.view.Display;
import android.view.LifecycleOwner;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.mdisdk.base.ALog;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\n*\u00018\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J/\u0010(\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u0007H\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\rH\u0014¢\u0006\u0004\b*\u0010\u0016J\u0017\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b-\u0010.R\u0014\u00100\u001a\u00020/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010\u0013¨\u0006A"}, d2 = {"Lcom/mdisdk/mirror/TaskMirrorView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewW", "viewH", "LC7/r;", "updateForwarder", "(II)V", "Lcom/mdisdk/Task;", "task", "onTaskAttached$mdisdk_release", "(Lcom/mdisdk/Task;)V", "onTaskAttached", "onTaskDetached$mdisdk_release", "()V", "onTaskDetached", "Landroid/view/Surface;", "getSurface$mdisdk_release", "()Landroid/view/Surface;", "getSurface", "Lcom/mdisdk/mirror/ScaleMode;", "mode", "setScaleMode", "(Lcom/mdisdk/mirror/ScaleMode;)V", "", "enable", "setForwardTouchEventEnable", "(Z)V", "w", "h", "oldw", "oldh", "onSizeChanged", "(IIII)V", "onDetachedFromWindow", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onPause", "(Landroidx/lifecycle/LifecycleOwner;)V", "Lcom/mdisdk/mirror/TouchForwarder;", "forwarder", "Lcom/mdisdk/mirror/TouchForwarder;", "Landroid/view/SurfaceView;", "surfaceView", "Landroid/view/SurfaceView;", "Lcom/mdisdk/mirror/TouchForwardingOverlay;", "overlay", "Lcom/mdisdk/mirror/TouchForwardingOverlay;", "com/mdisdk/mirror/TaskMirrorView$surfaceCallback$1", "surfaceCallback", "Lcom/mdisdk/mirror/TaskMirrorView$surfaceCallback$1;", "currentTask", "Lcom/mdisdk/Task;", "getCurrentTask$mdisdk_release", "()Lcom/mdisdk/Task;", "setCurrentTask$mdisdk_release", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskMirrorView extends FrameLayout implements DefaultLifecycleObserver {
    private static final String TAG = "TaskMirrorView";
    private volatile Task currentTask;
    private final TouchForwarder forwarder;
    private final TouchForwardingOverlay overlay;
    private final TaskMirrorView$surfaceCallback$1 surfaceCallback;
    private final SurfaceView surfaceView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskMirrorView(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateForwarder(int viewW, int viewH) {
        Task task = this.currentTask;
        if (task == null) {
            return;
        }
        Display.Mode mode = task.getDisplay().getMode();
        this.forwarder.updateViewSize(viewW, viewH, mode.getPhysicalWidth(), mode.getPhysicalHeight());
    }

    /* renamed from: getCurrentTask$mdisdk_release, reason: from getter */
    public final Task getCurrentTask() {
        return this.currentTask;
    }

    public final Surface getSurface$mdisdk_release() {
        Surface surface = this.surfaceView.getHolder().getSurface();
        if (surface == null || !surface.isValid()) {
            return null;
        }
        return surface;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ALog.d$default(TAG, "onDetachedFromWindow — auto-detaching task", null, 4, null);
        Task task = this.currentTask;
        if (task != null) {
            task.detachMirrorView();
        }
    }

    @Override // android.view.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        k.f(owner, "owner");
        ALog.d$default(TAG, "onPause — detaching task", null, 4, null);
        Task task = this.currentTask;
        if (task != null) {
            task.detachMirrorView();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int w8, int h, int oldw, int oldh) {
        super.onSizeChanged(w8, h, oldw, oldh);
        updateForwarder(w8, h);
    }

    public final void onTaskAttached$mdisdk_release(Task task) {
        k.f(task, "task");
        this.currentTask = task;
        this.overlay.setTask$mdisdk_release(task);
        updateForwarder(getWidth(), getHeight());
    }

    public final void onTaskDetached$mdisdk_release() {
        this.currentTask = null;
        this.overlay.setTask$mdisdk_release(null);
    }

    public final void setCurrentTask$mdisdk_release(Task task) {
        this.currentTask = task;
    }

    public final void setForwardTouchEventEnable(boolean enable) {
        this.overlay.setEnableTouch$mdisdk_release(enable);
    }

    public final void setScaleMode(ScaleMode mode) {
        k.f(mode, "mode");
        this.forwarder.setScaleMode(mode);
        if (getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        updateForwarder(getWidth(), getHeight());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TaskMirrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    public /* synthetic */ TaskMirrorView(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.SurfaceHolder$Callback, com.mdisdk.mirror.TaskMirrorView$surfaceCallback$1] */
    public TaskMirrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
        TouchForwarder touchForwarder = new TouchForwarder();
        this.forwarder = touchForwarder;
        SurfaceView surfaceView = new SurfaceView(context);
        this.surfaceView = surfaceView;
        TouchForwardingOverlay touchForwardingOverlay = new TouchForwardingOverlay(context, touchForwarder);
        this.overlay = touchForwardingOverlay;
        ?? r32 = new SurfaceHolder.Callback() { // from class: com.mdisdk.mirror.TaskMirrorView$surfaceCallback$1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int w8, int h) {
                k.f(holder, "holder");
                this.this$0.updateForwarder(w8, h);
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
                k.f(holder, "holder");
                ALog.d$default("TaskMirrorView", "surfaceCreated", null, 4, null);
                Task currentTask = this.this$0.getCurrentTask();
                if (currentTask != null) {
                    currentTask.setOutputSurface(holder.getSurface());
                }
                TaskMirrorView taskMirrorView = this.this$0;
                taskMirrorView.updateForwarder(taskMirrorView.getWidth(), this.this$0.getHeight());
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
                k.f(holder, "holder");
                ALog.d$default("TaskMirrorView", "surfaceDestroyed", null, 4, null);
                Task currentTask = this.this$0.getCurrentTask();
                if (currentTask != null) {
                    currentTask.setOutputSurface(null);
                }
            }
        };
        this.surfaceCallback = r32;
        addView(surfaceView, new FrameLayout.LayoutParams(-1, -1));
        addView(touchForwardingOverlay, new FrameLayout.LayoutParams(-1, -1));
        surfaceView.getHolder().addCallback(r32);
    }
}
