package com.mdisdk.action;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Ba\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0090@¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u001a\u0010\f\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b \u0010\u0017¨\u0006!"}, d2 = {"Lcom/mdisdk/action/SetTextAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "content", "", "x", "y", "windowTitle", "activityClassName", "packageName", WindowStateInfo.KEY_DISPLAY_ID, "tag", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getX", "()Ljava/lang/Integer;", "getY", "getWindowTitle", "getActivityClassName", "getPackageName", "getDisplayId", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SetTextAction extends Action<r> {
    private final String activityClassName;
    private final String content;
    private final Integer displayId;
    private final String packageName;
    private final String tag;
    private final String windowTitle;
    private final Integer x;
    private final Integer y;

    public /* synthetic */ SetTextAction(String str, Integer num, Integer num2, String str2, String str3, String str4, Integer num3, String str5, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num3, (i & 128) != 0 ? "" : str5);
    }

    public final String getActivityClassName() {
        return this.activityClassName;
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    public final Integer getX() {
        return this.x;
    }

    public final Integer getY() {
        return this.y;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    @Override // com.mdisdk.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object perform$mdisdk_release(com.mdisdk.core.TaskContext r19, H7.c<? super com.mdisdk.action.ActionResult<? extends C7.r>> r20) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.SetTextAction.perform$mdisdk_release(com.mdisdk.core.TaskContext, H7.c):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTextAction(String content, Integer num, Integer num2, String str, String str2, String str3, Integer num3, String tag) {
        super(tag, new Object[]{content, num, num2, str, str2, str3, num3});
        k.f(content, "content");
        k.f(tag, "tag");
        this.content = content;
        this.x = num;
        this.y = num2;
        this.windowTitle = str;
        this.activityClassName = str2;
        this.packageName = str3;
        this.displayId = num3;
        this.tag = tag;
    }
}
