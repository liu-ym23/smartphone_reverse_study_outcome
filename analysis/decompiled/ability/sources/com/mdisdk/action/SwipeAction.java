package com.mdisdk.action;

import C7.r;
import J7.c;
import U7.a;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
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

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Be\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0015\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0013H\u0090@¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010 R\u0017\u0010\u0006\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010 R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010 R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)R\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010-\u001a\u0004\b0\u0010/R\u001a\u0010\u0010\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b1\u0010/¨\u00062"}, d2 = {"Lcom/mdisdk/action/SwipeAction;", "Lcom/mdisdk/action/Action;", "LC7/r;", "", "startX", "startY", "endX", "endY", "", "durationInMs", "", "steps", WindowStateInfo.KEY_DISPLAY_ID, "", "packageName", "windowTitle", "tag", AppAgent.CONSTRUCT, "(FFFFJILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/mdisdk/core/TaskContext;", "context", "targetDisplayId", "Lcom/mdisdk/action/ActionResult;", "performViaInjection", "(Lcom/mdisdk/core/TaskContext;ILH7/c;)Ljava/lang/Object;", "performViaSystem", "(ILH7/c;)Ljava/lang/Object;", "perform$mdisdk_release", "(Lcom/mdisdk/core/TaskContext;LH7/c;)Ljava/lang/Object;", "perform", "F", "getStartX", "()F", "getStartY", "getEndX", "getEndY", "J", "getDurationInMs", "()J", "I", "getSteps", "()I", "Ljava/lang/Integer;", "getDisplayId", "()Ljava/lang/Integer;", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "getWindowTitle", "getTag", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SwipeAction extends Action<r> {
    private final Integer displayId;
    private final long durationInMs;
    private final float endX;
    private final float endY;
    private final String packageName;
    private final float startX;
    private final float startY;
    private final int steps;
    private final String tag;
    private final String windowTitle;

    @c(c = "com.mdisdk.action.SwipeAction", f = "SwipeAction.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "performViaInjection")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.mdisdk.action.SwipeAction$performViaInjection$1, reason: invalid class name */
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
            return SwipeAction.this.performViaInjection(null, 0, this);
        }
    }

    public /* synthetic */ SwipeAction(float f, float f7, float f9, float f10, long j5, int i, Integer num, String str, String str2, String str3, int i6, e eVar) {
        this(f, f7, f9, f10, j5, i, (i6 & 64) != 0 ? null : num, (i6 & 128) != 0 ? null : str, (i6 & 256) != 0 ? null : str2, (i6 & 512) != 0 ? "" : str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performViaInjection(com.mdisdk.core.TaskContext r18, int r19, H7.c<? super com.mdisdk.action.ActionResult<C7.r>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.mdisdk.action.SwipeAction.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            com.mdisdk.action.SwipeAction$performViaInjection$1 r2 = (com.mdisdk.action.SwipeAction.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r14 = r2
            goto L1e
        L18:
            com.mdisdk.action.SwipeAction$performViaInjection$1 r2 = new com.mdisdk.action.SwipeAction$performViaInjection$1
            r2.<init>(r1)
            goto L16
        L1e:
            java.lang.Object r1 = r14.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r14.label
            r4 = 1
            if (r3 == 0) goto L35
            if (r3 != r4) goto L2d
            kotlin.b.b(r1)
            goto L5d
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            kotlin.b.b(r1)
            com.mdisdk.capability.UiCapabilityManager r3 = r18.getUiCapabilityManager()
            float r1 = r0.startX
            int r5 = (int) r1
            float r1 = r0.startY
            int r6 = (int) r1
            float r1 = r0.endX
            int r7 = (int) r1
            float r1 = r0.endY
            int r8 = (int) r1
            long r9 = r0.durationInMs
            java.lang.String r11 = r0.packageName
            r14.label = r4
            r12 = 0
            r15 = 128(0x80, float:1.8E-43)
            r16 = 0
            r4 = r19
            java.lang.Object r1 = com.mdisdk.capability.UiCapabilityManager.swipe$default(r3, r4, r5, r6, r7, r8, r9, r11, r12, r14, r15, r16)
            if (r1 != r2) goto L5d
            return r2
        L5d:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto Lab
            com.mdisdk.action.ActionResult$Success r1 = new com.mdisdk.action.ActionResult$Success
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Swiped from ("
            r2.<init>(r3)
            float r3 = r0.startX
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            float r4 = r0.startY
            r2.append(r4)
            java.lang.String r4 = ") to ("
            r2.append(r4)
            float r4 = r0.endX
            r2.append(r4)
            r2.append(r3)
            float r3 = r0.endY
            r2.append(r3)
            java.lang.String r3 = ") via injection on "
            r2.append(r3)
            java.lang.String r3 = r0.packageName
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = r0.getTag()
            java.lang.Object[] r0 = r0.getArgs()
            C7.r r4 = C7.r.f317a
            r1.<init>(r4, r2, r3, r0)
            return r1
        Lab:
            com.mdisdk.action.ActionResult$Failure r5 = new com.mdisdk.action.ActionResult$Failure
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to swipe via injection on "
            r1.<init>(r2)
            java.lang.String r2 = r0.packageName
            r1.append(r2)
            java.lang.String r6 = r1.toString()
            java.lang.String r9 = r0.getTag()
            java.lang.Object[] r10 = r0.getArgs()
            r11 = 6
            r12 = 0
            r7 = 0
            r8 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mdisdk.action.SwipeAction.performViaInjection(com.mdisdk.core.TaskContext, int, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performViaSystem(final int i, H7.c<? super ActionResult<r>> cVar) {
        final C1718k c1718k = new C1718k(1, a.I(cVar));
        c1718k.y();
        EventInjectManager.swipe(getStartX(), getStartY(), getEndX(), getEndY(), getDurationInMs(), getSteps(), i, new EventCallback() { // from class: com.mdisdk.action.SwipeAction$performViaSystem$2$1
            @Override // com.mdisdk.capability.input.EventCallback
            public void onFailure(String reason) {
                Log.e("InputEvent", "Swipe failed: " + reason);
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Failure("Failed to swipe from (" + this.getStartX() + ", " + this.getStartY() + ") to (" + this.getEndX() + ", " + this.getEndY() + ") on " + i + ", reason: " + reason, null, false, this.getTag(), this.getArgs(), 6, null));
                }
            }

            @Override // com.mdisdk.capability.input.EventCallback
            public void onSuccess() {
                Log.d("InputEvent", "Swipe succeeded");
                if (c1718k.isActive()) {
                    c1718k.resumeWith(new ActionResult.Success(r.f317a, "Swiped from (" + this.getStartX() + ", " + this.getStartY() + ") to (" + this.getEndX() + ", " + this.getEndY() + ") on " + i, this.getTag(), this.getArgs()));
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

    public final float getEndX() {
        return this.endX;
    }

    public final float getEndY() {
        return this.endY;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final float getStartX() {
        return this.startX;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final int getSteps() {
        return this.steps;
    }

    @Override // com.mdisdk.action.Action
    public String getTag() {
        return this.tag;
    }

    public final String getWindowTitle() {
        return this.windowTitle;
    }

    @Override // com.mdisdk.action.Action
    public Object perform$mdisdk_release(TaskContext taskContext, H7.c<? super ActionResult<? extends r>> cVar) {
        String str;
        Integer num = this.displayId;
        int iIntValue = num != null ? num.intValue() : taskContext.getTaskDisplayId();
        String str2 = this.packageName;
        return ((str2 == null || str2.length() == 0) && ((str = this.windowTitle) == null || str.length() == 0)) ? performViaSystem(iIntValue, cVar) : performViaInjection(taskContext, iIntValue, cVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeAction(float f, float f7, float f9, float f10, long j5, int i, Integer num, String str, String str2, String tag) {
        super(tag, new Object[]{Float.valueOf(f), Float.valueOf(f7), Float.valueOf(f9), Float.valueOf(f10), Long.valueOf(j5), Integer.valueOf(i), num, str, str2});
        k.f(tag, "tag");
        this.startX = f;
        this.startY = f7;
        this.endX = f9;
        this.endY = f10;
        this.durationInMs = j5;
        this.steps = i;
        this.displayId = num;
        this.packageName = str;
        this.windowTitle = str2;
        this.tag = tag;
    }
}
