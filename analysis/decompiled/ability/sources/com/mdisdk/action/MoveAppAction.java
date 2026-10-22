package com.mdisdk.action;

import C7.r;
import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.framework.FrameworkBridgeFactory;
import com.mdisdk.capability.framework.IFrameworkBridge;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0090@¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/mdisdk/action/MoveAppAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "packageName", "", "toDisplayId", "", "toTop", "androidUserId", "tag", AppAgent.CONSTRUCT, "(Ljava/lang/String;ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "I", "getToDisplayId", "()I", "Ljava/lang/Boolean;", "getToTop", "()Ljava/lang/Boolean;", "Ljava/lang/Integer;", "getAndroidUserId", "()Ljava/lang/Integer;", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MoveAppAction extends Action<r> {
    private final Integer androidUserId;
    private final String packageName;
    private final String tag;
    private final int toDisplayId;
    private final Boolean toTop;

    public /* synthetic */ MoveAppAction(String str, int i, Boolean bool, Integer num, String str2, int i6, e eVar) {
        this(str, i, (i6 & 4) != 0 ? null : bool, (i6 & 8) != 0 ? null : num, (i6 & 16) != 0 ? "" : str2);
    }

    public final Integer getAndroidUserId() {
        return this.androidUserId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final int getToDisplayId() {
        return this.toDisplayId;
    }

    public final Boolean getToTop() {
        return this.toTop;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, c<? super ActionResult<? extends r>> cVar) {
        IFrameworkBridge iFrameworkBridge = FrameworkBridgeFactory.get();
        String str = this.packageName;
        int i = this.toDisplayId;
        Boolean bool = this.toTop;
        boolean zBooleanValue = bool != null ? bool.booleanValue() : true;
        Integer num = this.androidUserId;
        if (iFrameworkBridge.moveAppToDisplay(str, i, zBooleanValue, num != null ? num.intValue() : 0)) {
            return new ActionResult.Success(r.f317a, null, null, null, 14, null);
        }
        return new ActionResult.Failure("moveAppToDisplay failed!", null, false, getTag(), getArgs(), 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoveAppAction(String packageName, int i, Boolean bool, Integer num, String tag) {
        super(tag, new Object[]{packageName, Integer.valueOf(i), bool, num});
        k.f(packageName, "packageName");
        k.f(tag, "tag");
        this.packageName = packageName;
        this.toDisplayId = i;
        this.toTop = bool;
        this.androidUserId = num;
        this.tag = tag;
    }
}
