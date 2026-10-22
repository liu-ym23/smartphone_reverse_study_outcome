package com.mdisdk.action;

import C7.r;
import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.input.EventInjectManager;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0090@¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b'\u0010&R\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b(\u0010&¨\u0006)"}, d2 = {"Lcom/mdisdk/action/ClickAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "x", "y", "", "durationInMs", WindowStateInfo.KEY_DISPLAY_ID, "", "packageName", "windowTitle", "tag", AppAgent.CONSTRUCT, "(IIJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "targetDisplayId", "Lcom/mdisdk/action/ActionResult;", "performViaInjection", "(Lcom/mdisdk/core/TaskContext;ILH7/c;)Ljava/lang/Object;", "performViaSystem", "(I)Lcom/mdisdk/action/ActionResult;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "I", "getX", "()I", "getY", "J", "getDurationInMs", "()J", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "getWindowTitle", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClickAction extends Action<r> {
    private final Integer displayId;
    private final long durationInMs;
    private final String packageName;
    private final String tag;
    private final String windowTitle;
    private final int x;
    private final int y;

    @c(c = "com.mdisdk.action.ClickAction", f = "ClickAction.kt", l = {45}, m = "performViaInjection")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.action.ClickAction$performViaInjection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClickAction.this.performViaInjection(null, 0, this);
        }
    }

    public /* synthetic */ ClickAction(int i, int i6, long j5, Integer num, String str, String str2, String str3, int i10, e eVar) {
        this(i, i6, j5, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? "" : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performViaInjection(com.mdisdk.core.TaskContext r12, int r13, H7.c<? super com.mdisdk.action.ActionResult<C7.r>> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.mdisdk.action.ClickAction.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r14
            com.mdisdk.action.ClickAction$performViaInjection$1 r0 = (com.mdisdk.action.ClickAction.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r8 = r0
            goto L1a
        L14:
            com.mdisdk.action.ClickAction$performViaInjection$1 r0 = new com.mdisdk.action.ClickAction$performViaInjection$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r8.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.b.b(r14)
            goto L4d
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.b.b(r14)
            com.mdisdk.capability.UiCapabilityManager r1 = r12.getUiCapabilityManager()
            int r3 = r11.x
            int r4 = r11.y
            java.lang.String r5 = r11.packageName
            r8.label = r2
            r6 = 0
            r9 = 16
            r10 = 0
            r2 = r13
            java.lang.Object r14 = com.mdisdk.capability.UiCapabilityManager.click$default(r1, r2, r3, r4, r5, r6, r8, r9, r10)
            if (r14 != r0) goto L4d
            return r0
        L4d:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r12 = r14.booleanValue()
            java.lang.String r13 = ") via injection on "
            java.lang.String r14 = ", "
            if (r12 == 0) goto L89
            com.mdisdk.action.ActionResult$Success r12 = new com.mdisdk.action.ActionResult$Success
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Clicked at ("
            r0.<init>(r1)
            int r1 = r11.x
            r0.append(r1)
            r0.append(r14)
            int r14 = r11.y
            r0.append(r14)
            r0.append(r13)
            java.lang.String r13 = r11.packageName
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            java.lang.String r14 = r11.getTag()
            java.lang.Object[] r11 = r11.getArgs()
            C7.r r0 = C7.r.f317a
            r12.<init>(r0, r13, r14, r11)
            return r12
        L89:
            com.mdisdk.action.ActionResult$Failure r1 = new com.mdisdk.action.ActionResult$Failure
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Failed to click at ("
            r12.<init>(r0)
            int r0 = r11.x
            r12.append(r0)
            r12.append(r14)
            int r14 = r11.y
            r12.append(r14)
            r12.append(r13)
            java.lang.String r13 = r11.packageName
            r12.append(r13)
            java.lang.String r2 = r12.toString()
            java.lang.String r5 = r11.getTag()
            java.lang.Object[] r6 = r11.getArgs()
            r7 = 6
            r8 = 0
            r3 = 0
            r4 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.ClickAction.performViaInjection(com.mdisdk.core.TaskContext, int, H7.c):java.lang.Object");
    }

    private final ActionResult<r> performViaSystem(int targetDisplayId) {
        if (!EventInjectManager.click(this.x, this.y, targetDisplayId)) {
            return new ActionResult.Failure("Failed to click at (" + this.x + ", " + this.y + ") on " + targetDisplayId, null, false, getTag(), getArgs(), 6, null);
        }
        return new ActionResult.Success(r.f317a, "Clicked at (" + this.x + ", " + this.y + ") on " + targetDisplayId, getTag(), getArgs());
    }

    public final Integer getDisplayId() {
        return this.displayId;
    }

    public final long getDurationInMs() {
        return this.durationInMs;
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

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, H7.c<? super ActionResult<? extends r>> cVar) {
        String str;
        Integer num = this.displayId;
        int iIntValue = num != null ? num.intValue() : taskContext.getDisplay().getDisplayId();
        String str2 = this.packageName;
        return ((str2 == null || str2.length() == 0) && ((str = this.windowTitle) == null || str.length() == 0)) ? performViaSystem(iIntValue) : performViaInjection(taskContext, iIntValue, cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickAction(int i, int i6, long j5, Integer num, String str, String str2, String tag) {
        super(tag, new Object[]{Integer.valueOf(i), Integer.valueOf(i6), Long.valueOf(j5), num, str, str2});
        k.f(tag, "tag");
        this.x = i;
        this.y = i6;
        this.durationInMs = j5;
        this.displayId = num;
        this.packageName = str;
        this.windowTitle = str2;
        this.tag = tag;
    }
}
