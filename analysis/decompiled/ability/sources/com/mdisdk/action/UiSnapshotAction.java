package com.mdisdk.action;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.capability.request.UiSnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0090@¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\r\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b$\u0010\u0018¨\u0006%"}, d2 = {"Lcom/mdisdk/action/UiSnapshotAction;", "Lcom/mdisdk/action/Action;", "Lcom/mdisdk/capability/request/UiSnapshot;", "", "packageName", "activityClass", "windowTitle", "", WindowStateInfo.KEY_DISPLAY_ID, "", "timeoutInMillis", "", "screenshot", "tag", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "getActivityClass", "getWindowTitle", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/Long;", "getTimeoutInMillis", "()Ljava/lang/Long;", "Ljava/lang/Boolean;", "getScreenshot", "()Ljava/lang/Boolean;", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UiSnapshotAction extends Action<UiSnapshot> {
    private final String activityClass;
    private final Integer displayId;
    private final String packageName;
    private final Boolean screenshot;
    private final String tag;
    private final Long timeoutInMillis;
    private final String windowTitle;

    public UiSnapshotAction() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final String getActivityClass() {
        return this.activityClass;
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Boolean getScreenshot() {
        return this.screenshot;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final Long getTimeoutInMillis() {
        return this.timeoutInMillis;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // com.mdisdk.action.Action
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object perform$mdisdk_release(com.mdisdk.core.TaskContext r17, H7.c<? super com.mdisdk.action.ActionResult<? extends com.mdisdk.capability.request.UiSnapshot>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.mdisdk.action.UiSnapshotAction$perform$1
            if (r2 == 0) goto L18
            r2 = r1
            com.mdisdk.action.UiSnapshotAction$perform$1 r2 = (com.mdisdk.action.UiSnapshotAction$perform$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r13 = r2
            goto L1e
        L18:
            com.mdisdk.action.UiSnapshotAction$perform$1 r2 = new com.mdisdk.action.UiSnapshotAction$perform$1
            r2.<init>(r0, r1)
            goto L16
        L1e:
            java.lang.Object r1 = r13.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r13.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            kotlin.b.b(r1)
            goto L7a
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            kotlin.b.b(r1)
            com.mdisdk.capability.UiCapabilityManager r3 = r17.getUiCapabilityManager()
            java.lang.Integer r1 = r0.displayId
            if (r1 == 0) goto L45
            int r1 = r1.intValue()
            goto L49
        L45:
            int r1 = r17.getTaskDisplayId()
        L49:
            java.lang.String r5 = r0.packageName
            java.lang.String r8 = r0.activityClass
            java.lang.String r6 = r0.windowTitle
            java.lang.Boolean r7 = r0.screenshot
            if (r7 == 0) goto L59
            boolean r7 = r7.booleanValue()
        L57:
            r10 = r7
            goto L5b
        L59:
            r7 = 0
            goto L57
        L5b:
            java.lang.Long r7 = r0.timeoutInMillis
            if (r7 == 0) goto L64
            long r11 = r7.longValue()
            goto L66
        L64:
            r11 = 3000(0xbb8, double:1.482E-320)
        L66:
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r1)
            r13.label = r4
            r4 = r7
            r7 = 0
            r9 = 0
            r14 = 40
            r15 = 0
            java.lang.Object r1 = com.mdisdk.capability.UiCapabilityManager.snapshot$default(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15)
            if (r1 != r2) goto L7a
            return r2
        L7a:
            r3 = r1
            com.mdisdk.capability.request.UiSnapshot r3 = (com.mdisdk.capability.request.UiSnapshot) r3
            if (r3 != 0) goto L93
            com.mdisdk.action.ActionResult$Failure r4 = new com.mdisdk.action.ActionResult$Failure
            java.lang.String r8 = r0.getTag()
            java.lang.Object[] r9 = r0.getArgs()
            r10 = 6
            r11 = 0
            java.lang.String r5 = "No such ui snapshot."
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return r4
        L93:
            com.mdisdk.action.ActionResult$Success r2 = new com.mdisdk.action.ActionResult$Success
            java.lang.String r5 = r0.getTag()
            java.lang.Object[] r6 = r0.getArgs()
            r7 = 2
            r8 = 0
            r4 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.UiSnapshotAction.perform$mdisdk_release(com.mdisdk.core.TaskContext, H7.c):java.lang.Object");
    }

    public /* synthetic */ UiSnapshotAction(String str, String str2, String str3, Integer num, Long l, Boolean bool, String str4, int i, e eVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : l, (i & 32) != 0 ? Boolean.FALSE : bool, (i & 64) != 0 ? "" : str4);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UiSnapshotAction(String str, String str2, String str3, Integer num, Long l, Boolean bool, String tag) {
        super(tag, new Object[]{str, str2, str3, num, l});
        k.f(tag, "tag");
        this.packageName = str;
        this.activityClass = str2;
        this.windowTitle = str3;
        this.displayId = num;
        this.timeoutInMillis = l;
        this.screenshot = bool;
        this.tag = tag;
    }
}
