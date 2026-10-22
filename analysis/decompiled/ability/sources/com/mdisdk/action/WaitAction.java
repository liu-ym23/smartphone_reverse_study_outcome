package com.mdisdk.action;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0090@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/mdisdk/action/WaitAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "durationInMs", "", WindowStateInfo.KEY_DISPLAY_ID, "", "tag", AppAgent.CONSTRUCT, "(JLjava/lang/Integer;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "J", "getDurationInMs", "()J", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WaitAction extends Action<r> {
    private final Integer displayId;
    private final long durationInMs;
    private final String tag;

    public /* synthetic */ WaitAction(long j5, Integer num, String str, int i, e eVar) {
        this(j5, (i & 2) != 0 ? null : num, (i & 4) != 0 ? "" : str);
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.mdisdk.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object perform$mdisdk_release(com.mdisdk.core.TaskContext r9, H7.c<? super com.mdisdk.action.ActionResult<? extends C7.r>> r10) {
        /*
            r8 = this;
            boolean r9 = r10 instanceof com.mdisdk.action.WaitAction$perform$1
            if (r9 == 0) goto L13
            r9 = r10
            com.mdisdk.action.WaitAction$perform$1 r9 = (com.mdisdk.action.WaitAction$perform$1) r9
            int r0 = r9.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r9.label = r0
            goto L18
        L13:
            com.mdisdk.action.WaitAction$perform$1 r9 = new com.mdisdk.action.WaitAction$perform$1
            r9.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r9.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            kotlin.b.b(r10)
            goto L3d
        L27:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2f:
            kotlin.b.b(r10)
            long r3 = r8.durationInMs
            r9.label = r2
            java.lang.Object r9 = kotlinx.coroutines.a.f(r3, r9)
            if (r9 != r0) goto L3d
            return r0
        L3d:
            com.mdisdk.action.ActionResult$Success r1 = new com.mdisdk.action.ActionResult$Success
            java.lang.String r4 = r8.getTag()
            java.lang.Object[] r5 = r8.getArgs()
            r6 = 2
            r7 = 0
            C7.r r2 = C7.r.f317a
            r3 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.WaitAction.perform$mdisdk_release(com.mdisdk.core.TaskContext, H7.c):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaitAction(long j5, Integer num, String tag) {
        super(tag, new Object[]{Long.valueOf(j5), num});
        k.f(tag, "tag");
        this.durationInMs = j5;
        this.displayId = num;
        this.tag = tag;
    }
}
