package com.stepos.taskrobot.llmapi.stepfun.mirror;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.DefaultLifecycleObserver;
import android.view.LifecycleOwner;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.android.material.textfield.g;
import com.mdisdk.Task;
import com.mdisdk.mirror.ScaleMode;
import com.stepos.taskrobot.llmapi.stepfun.ZyqlGuiAgentTask;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u00012\u0018\u0000 82\u00020\u00012\u00020\u0002:\u00018B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\rH\u0014¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u0018R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "guiTask", "LC7/r;", "bind", "(Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;)V", "unbind", "()V", "", "surfaceState", "()Ljava/lang/String;", "", "enable", "setForwardTouchEventEnable", "(Z)V", "onDetachedFromWindow", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onPause", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroid/view/SurfaceView;", "surfaceView", "Landroid/view/SurfaceView;", "Landroid/view/View;", "touchOverlay", "Landroid/view/View;", "boundTask", "Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlGuiAgentTask;", "Lcom/mdisdk/mirror/ScaleMode;", "scaleMode", "Lcom/mdisdk/mirror/ScaleMode;", "getScaleMode", "()Lcom/mdisdk/mirror/ScaleMode;", "setScaleMode", "(Lcom/mdisdk/mirror/ScaleMode;)V", "touchEnabled", "Z", "getTouchEnabled", "()Z", "setTouchEnabled", "com/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView$callback$1", "callback", "Lcom/stepos/taskrobot/llmapi/stepfun/mirror/UnifiedMirrorView$callback$1;", "Landroid/view/View$OnTouchListener;", "touchListener", "Landroid/view/View$OnTouchListener;", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifiedMirrorView extends FrameLayout implements DefaultLifecycleObserver {
    private static final String TAG = "UnifiedMirrorView";
    private volatile ZyqlGuiAgentTask boundTask;
    private final UnifiedMirrorView$callback$1 callback;
    private volatile ScaleMode scaleMode;
    private final SurfaceView surfaceView;
    private volatile boolean touchEnabled;

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener touchListener;
    private final View touchOverlay;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedMirrorView(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean touchListener$lambda$0(UnifiedMirrorView unifiedMirrorView, View view, MotionEvent motionEvent) {
        ZyqlGuiAgentTask zyqlGuiAgentTask;
        Task task;
        Object objA;
        if (!unifiedMirrorView.touchEnabled || (zyqlGuiAgentTask = unifiedMirrorView.boundTask) == null || (task = zyqlGuiAgentTask.getTask()) == null) {
            return false;
        }
        try {
            k.c(motionEvent);
            objA = Boolean.valueOf(task.forwardTouchEvent(motionEvent, unifiedMirrorView.getWidth(), unifiedMirrorView.getHeight(), unifiedMirrorView.scaleMode));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.e(TAG, "forwardTouchEvent failed: " + thA.getMessage(), true);
            objA = Boolean.FALSE;
        }
        return ((Boolean) objA).booleanValue();
    }

    public final void bind(ZyqlGuiAgentTask guiTask) {
        k.f(guiTask, "guiTask");
        this.boundTask = guiTask;
        try {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > 0 && displayMetrics.heightPixels > 0) {
                this.surfaceView.getHolder().setFixedSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Throwable th) {
            b.a(th);
        }
        Surface surface = this.surfaceView.getHolder().getSurface();
        if (surface != null && surface.isValid()) {
            guiTask.setOutputSurface(surface);
        }
        AbstractC1436a.d(TAG, "bind: taskId=" + guiTask.getTaskId(), true);
    }

    public final ScaleMode getScaleMode() {
        return this.scaleMode;
    }

    public final boolean getTouchEnabled() {
        return this.touchEnabled;
    }

    @Override // android.view.DefaultLifecycleObserver
    public /* bridge */ void onCreate(LifecycleOwner lifecycleOwner) {
        super.onCreate(lifecycleOwner);
    }

    @Override // android.view.DefaultLifecycleObserver
    public /* bridge */ void onDestroy(LifecycleOwner lifecycleOwner) {
        super.onDestroy(lifecycleOwner);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AbstractC1436a.a(TAG, "onDetachedFromWindow — auto unbind", true);
        unbind();
    }

    @Override // android.view.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        k.f(owner, "owner");
        AbstractC1436a.a(TAG, "onPause — unbind", true);
        unbind();
    }

    @Override // android.view.DefaultLifecycleObserver
    public /* bridge */ void onResume(LifecycleOwner lifecycleOwner) {
        super.onResume(lifecycleOwner);
    }

    @Override // android.view.DefaultLifecycleObserver
    public /* bridge */ void onStart(LifecycleOwner lifecycleOwner) {
        super.onStart(lifecycleOwner);
    }

    @Override // android.view.DefaultLifecycleObserver
    public /* bridge */ void onStop(LifecycleOwner lifecycleOwner) {
        super.onStop(lifecycleOwner);
    }

    public final void setForwardTouchEventEnable(boolean enable) {
        this.touchEnabled = enable;
    }

    public final void setScaleMode(ScaleMode scaleMode) {
        k.f(scaleMode, "<set-?>");
        this.scaleMode = scaleMode;
    }

    public final void setTouchEnabled(boolean z10) {
        this.touchEnabled = z10;
    }

    public final String surfaceState() {
        Surface surface = this.surfaceView.getHolder().getSurface();
        return "installed=" + (this.boundTask != null) + ", surfaceValid=" + (surface != null ? Boolean.valueOf(surface.isValid()) : null) + ", surface=" + surface;
    }

    public final void unbind() {
        ZyqlGuiAgentTask zyqlGuiAgentTask = this.boundTask;
        if (zyqlGuiAgentTask == null) {
            return;
        }
        try {
            zyqlGuiAgentTask.setOutputSurface(null);
        } catch (Throwable th) {
            b.a(th);
        }
        this.boundTask = null;
        AbstractC1436a.d(TAG, "unbind: taskId=" + zyqlGuiAgentTask.getTaskId(), true);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnifiedMirrorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.view.SurfaceHolder$Callback, com.stepos.taskrobot.llmapi.stepfun.mirror.UnifiedMirrorView$callback$1] */
    public UnifiedMirrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
        SurfaceView surfaceView = new SurfaceView(context);
        this.surfaceView = surfaceView;
        View view = new View(context);
        this.touchOverlay = view;
        this.scaleMode = ScaleMode.FIT;
        this.touchEnabled = true;
        ?? r42 = new SurfaceHolder.Callback() { // from class: com.stepos.taskrobot.llmapi.stepfun.mirror.UnifiedMirrorView$callback$1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                k.f(holder, "holder");
                ZyqlGuiAgentTask zyqlGuiAgentTask = this.this$0.boundTask;
                if (zyqlGuiAgentTask != null) {
                    zyqlGuiAgentTask.setOutputSurface(holder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder) {
                k.f(holder, "holder");
                AbstractC1436a.a("UnifiedMirrorView", "surfaceCreated", true);
                ZyqlGuiAgentTask zyqlGuiAgentTask = this.this$0.boundTask;
                if (zyqlGuiAgentTask != null) {
                    zyqlGuiAgentTask.setOutputSurface(holder.getSurface());
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder) {
                k.f(holder, "holder");
                AbstractC1436a.a("UnifiedMirrorView", "surfaceDestroyed", true);
                ZyqlGuiAgentTask zyqlGuiAgentTask = this.this$0.boundTask;
                if (zyqlGuiAgentTask != null) {
                    zyqlGuiAgentTask.setOutputSurface(null);
                }
            }
        };
        this.callback = r42;
        View.OnTouchListener gVar = new g(this, 2);
        this.touchListener = gVar;
        addView(surfaceView, new ViewGroup.LayoutParams(-1, -1));
        addView(view, new ViewGroup.LayoutParams(-1, -1));
        surfaceView.getHolder().addCallback(r42);
        view.setOnTouchListener(gVar);
    }

    public /* synthetic */ UnifiedMirrorView(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }
}
