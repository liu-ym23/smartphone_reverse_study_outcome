package com.mdisdk.action;

import C7.r;
import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.input.EventInjectManager;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0090@¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/mdisdk/action/KeyEventAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "keyCode", WindowStateInfo.KEY_DISPLAY_ID, "", "tag", AppAgent.CONSTRUCT, "(ILjava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "I", "getKeyCode", "()I", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class KeyEventAction extends Action<r> {
    private final Integer displayId;
    private final int keyCode;
    private final String tag;

    public /* synthetic */ KeyEventAction(int i, Integer num, String str, int i6, e eVar) {
        this(i, (i6 & 2) != 0 ? null : num, (i6 & 4) != 0 ? "" : str);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final int getKeyCode() {
        return this.keyCode;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, c<? super ActionResult<? extends r>> cVar) {
        Integer num = this.displayId;
        int iIntValue = num != null ? num.intValue() : taskContext.getDisplay().getDisplayId();
        if (EventInjectManager.injectKey(this.keyCode, iIntValue)) {
            return new ActionResult.Success(r.f317a, "Injected key event " + this.keyCode + " on " + iIntValue, getTag(), getArgs());
        }
        return new ActionResult.Failure("Failed to inject key event " + this.keyCode + " on " + iIntValue, null, false, getTag(), getArgs(), 6, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyEventAction(int i, Integer num, String tag) {
        super(tag, new Integer[]{Integer.valueOf(i), num});
        k.f(tag, "tag");
        this.keyCode = i;
        this.displayId = num;
        this.tag = tag;
    }
}
