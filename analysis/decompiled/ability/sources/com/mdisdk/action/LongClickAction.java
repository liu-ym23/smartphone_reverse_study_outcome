package com.mdisdk.action;

import C7.r;
import J7.c;
import U7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.action.ActionResult;
import com.mdisdk.capability.input.EventCallback;
import com.mdisdk.capability.input.EventInjectManager;
import com.mdisdk.capability.model.WindowStateInfo;
import com.mdisdk.core.TaskContext;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.C1718k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BM\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH\u0090@¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001d\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b'\u0010&R\u001a\u0010\f\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010$\u001a\u0004\b(\u0010&¨\u0006)"}, d2 = {"Lcom/mdisdk/action/LongClickAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "x", "y", "", "durationInMs", WindowStateInfo.KEY_DISPLAY_ID, "", "packageName", "windowTitle", "tag", AppAgent.CONSTRUCT, "(IIJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "targetDisplayId", "Lcom/mdisdk/action/ActionResult;", "performViaInjection", "(Lcom/mdisdk/core/TaskContext;ILH7/c;)Ljava/lang/Object;", "performViaSystem", "(ILH7/c;)Ljava/lang/Object;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "I", "getX", "()I", "getY", "J", "getDurationInMs", "()J", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "getWindowTitle", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LongClickAction extends Action<r> {
    private final Integer displayId;
    private final long durationInMs;
    private final String packageName;
    private final String tag;
    private final String windowTitle;
    private final int x;
    private final int y;

    @c(c = "com.mdisdk.action.LongClickAction", f = "LongClickAction.kt", l = {48}, m = "performViaInjection")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.action.LongClickAction$performViaInjection$1, reason: invalid class name */
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
            return LongClickAction.this.performViaInjection(null, 0, this);
        }
    }

    public /* synthetic */ LongClickAction(int i, int i6, long j5, Integer num, String str, String str2, String str3, int i10, e eVar) {
        this(i, i6, j5, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str, (i10 & 32) != 0 ? null : str2, (i10 & 64) != 0 ? "" : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performViaInjection(com.mdisdk.core.TaskContext r15, int r16, H7.c<? super com.mdisdk.action.ActionResult<C7.r>> r17) {
        /*
            r14 = this;
            r0 = r17
            boolean r1 = r0 instanceof com.mdisdk.action.LongClickAction.AnonymousClass1
            if (r1 == 0) goto L16
            r1 = r0
            com.mdisdk.action.LongClickAction$performViaInjection$1 r1 = (com.mdisdk.action.LongClickAction.AnonymousClass1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
        L14:
            r11 = r1
            goto L1c
        L16:
            com.mdisdk.action.LongClickAction$performViaInjection$1 r1 = new com.mdisdk.action.LongClickAction$performViaInjection$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r11.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r11.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.b.b(r0)
            goto L52
        L2b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L33:
            kotlin.b.b(r0)
            com.mdisdk.capability.UiCapabilityManager r2 = r15.getUiCapabilityManager()
            int r4 = r14.x
            int r5 = r14.y
            long r6 = r14.durationInMs
            java.lang.String r8 = r14.packageName
            r11.label = r3
            r9 = 0
            r12 = 32
            r13 = 0
            r3 = r16
            java.lang.Object r0 = com.mdisdk.capability.UiCapabilityManager.longClick$default(r2, r3, r4, r5, r6, r8, r9, r11, r12, r13)
            if (r0 != r1) goto L52
            return r1
        L52:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = ") via injection on "
            java.lang.String r2 = ", "
            if (r0 == 0) goto L8e
            com.mdisdk.action.ActionResult$Success r0 = new com.mdisdk.action.ActionResult$Success
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Long clicked at ("
            r3.<init>(r4)
            int r4 = r14.x
            r3.append(r4)
            r3.append(r2)
            int r2 = r14.y
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r14.packageName
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = r14.getTag()
            java.lang.Object[] r14 = r14.getArgs()
            C7.r r3 = C7.r.f317a
            r0.<init>(r3, r1, r2, r14)
            return r0
        L8e:
            com.mdisdk.action.ActionResult$Failure r4 = new com.mdisdk.action.ActionResult$Failure
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to long click at ("
            r0.<init>(r3)
            int r3 = r14.x
            r0.append(r3)
            r0.append(r2)
            int r2 = r14.y
            r0.append(r2)
            r0.append(r1)
            java.lang.String r1 = r14.packageName
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r8 = r14.getTag()
            java.lang.Object[] r9 = r14.getArgs()
            r10 = 6
            r11 = 0
            r6 = 0
            r7 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.LongClickAction.performViaInjection(com.mdisdk.core.TaskContext, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performViaSystem(final int i, H7.c<? super ActionResult<r>> cVar) {
        final C1718k c1718k = new C1718k(1, a.I(cVar));
        c1718k.y();
        EventInjectManager.longPress(getX(), getY(), getDurationInMs(), i, new EventCallback() { // from class: com.mdisdk.action.LongClickAction$performViaSystem$2$1
            @Override // com.mdisdk.capability.input.EventCallback
            public void onFailure(String reason) {
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Failure("Failed to long click at (" + this.getX() + ", " + this.getY() + ") on " + i + ", reason: " + reason, null, false, this.getTag(), this.getArgs(), 6, null));
                }
            }

            @Override // com.mdisdk.capability.input.EventCallback
            public void onSuccess() {
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Success(r.f317a, "Long clicked at (" + this.getX() + ", " + this.getY() + ") on " + i, this.getTag(), this.getArgs()));
                }
            }
        });
        Object objX = c1718k.x();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objX;
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
        return ((str2 == null || str2.length() == 0) && ((str = this.windowTitle) == null || str.length() == 0)) ? performViaSystem(iIntValue, cVar) : performViaInjection(taskContext, iIntValue, cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongClickAction(int i, int i6, long j5, Integer num, String str, String str2, String tag) {
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
