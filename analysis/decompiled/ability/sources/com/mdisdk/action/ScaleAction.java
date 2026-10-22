package com.mdisdk.action;

import C7.r;
import H7.c;
import U7.a;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.EventInjectManager;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.C1718k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BE\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0090@¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\r\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/mdisdk/action/ScaleAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "centerX", "centerY", "startDistance", "endDistance", "", "durationInMs", "", WindowStateInfo.KEY_DISPLAY_ID, "", "tag", AppAgent.CONSTRUCT, "(FFFFJLjava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "F", "getCenterX", "()F", "getCenterY", "getStartDistance", "getEndDistance", "J", "getDurationInMs", "()J", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScaleAction extends Action<r> {
    private final float centerX;
    private final float centerY;
    private final Integer displayId;
    private final long durationInMs;
    private final float endDistance;
    private final float startDistance;
    private final String tag;

    public /* synthetic */ ScaleAction(float f, float f7, float f9, float f10, long j5, Integer num, String str, int i, e eVar) {
        this(f, f7, f9, f10, j5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? "" : str);
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    public final float getEndDistance() {
        return this.endDistance;
    }

    public final float getStartDistance() {
        return this.startDistance;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, c<? super ActionResult<? extends r>> cVar) {
        final C1718k c1718k = new C1718k(1, a.I(cVar));
        c1718k.y();
        Integer displayId = getDisplayId();
        final int iIntValue = displayId != null ? displayId.intValue() : taskContext.getTaskDisplayId();
        EventInjectManager.pinch(getCenterX(), getCenterY(), getStartDistance(), getEndDistance(), 10, getDurationInMs(), iIntValue, new EventCallback() { // from class: com.mdisdk.action.ScaleAction$perform$2$1
            @Override // com.mdisdk.capability.input.EventCallback
            public void onFailure(String reason) {
                Log.e("InputEvent", "Pinch failed: " + reason);
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Failure("Failed to scale at (" + this.getCenterX() + ", " + this.getCenterY() + ")  on " + iIntValue + ", reason: " + reason, null, false, this.getTag(), this.getArgs(), 6, null));
                }
            }

            @Override // com.mdisdk.capability.input.EventCallback
            public void onSuccess() {
                Log.d("InputEvent", "Pinch succeeded");
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Success(r.f317a, "Scaled at (" + this.getCenterX() + ", " + this.getCenterY() + ")  on " + iIntValue, this.getTag(), this.getArgs()));
                }
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScaleAction(float f, float f7, float f9, float f10, long j5, Integer num, String tag) {
        super(tag, new Object[]{Float.valueOf(f), Float.valueOf(f7), Float.valueOf(f9), Float.valueOf(f10), Long.valueOf(j5), num});
        k.f(tag, "tag");
        this.centerX = f;
        this.centerY = f7;
        this.startDistance = f9;
        this.endDistance = f10;
        this.durationInMs = j5;
        this.displayId = num;
        this.tag = tag;
    }
}
