package com.stepos.taskrobot.llmapi.stepfun;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.material3.MenuKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.Task;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import stepai.aios.guiagent.ability.GuiAbilityProvider;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00015B9\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0014\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0007H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b \u0010!R\u001c\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\"R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010#R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u0004\u0018\u00010\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ZyqlSystemGuiAbilityProvider;", "Lstepai/aios/guiagent/ability/GuiAbilityProvider;", "Lkotlin/Function0;", "Lcom/mdisdk/Task;", "taskProvider", "", "getActionDisplayId", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(LS7/a;LS7/a;Ljava/lang/String;Landroid/content/Context;)V", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "Landroid/graphics/Bitmap;", "bitmap", "LC7/r;", "notifyProgress", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", BffConstant.Type.Url, "notifyProgressPair", "(Ljava/lang/String;Landroid/graphics/Bitmap;Ljava/lang/String;)V", SingleFileBundle.KEY_PATH, "retries", "tag", "uploadWithRetry", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;LH7/c;)Ljava/lang/Object;", "Lstepai/aios/guiagent/ability/CaptureOptions;", "options", "Lstepai/aios/guiagent/ability/CaptureResult;", "captureScreenResult", "(Lstepai/aios/guiagent/ability/CaptureOptions;LH7/c;)Ljava/lang/Object;", "bitmap2Base64", "(Landroid/graphics/Bitmap;LH7/c;)Ljava/lang/Object;", "LS7/a;", "Ljava/lang/String;", "Landroid/content/Context;", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "taskEntity", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getTaskEntity", "()Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "setTaskEntity", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)V", "LFa/a;", "converter", "LFa/a;", "getTask", "()Lcom/mdisdk/Task;", "task", "getLogPrefix", "()Ljava/lang/String;", "logPrefix", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ZyqlSystemGuiAbilityProvider implements GuiAbilityProvider {
    private static final String TAG = "ZyqlSystemGuiAbilityProvider";
    private final Context context;
    private final Fa.a converter;
    private final S7.a getActionDisplayId;
    private TaskEntity taskEntity;
    private final String taskId;
    private final S7.a taskProvider;

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider", f = "ZyqlSystemGuiAbilityProvider.kt", l = {74, 115, MenuKt.InTransitionDuration}, m = "captureScreenResult", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider$captureScreenResult$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiAbilityProvider.this.captureScreenResult(null, this);
        }
    }

    @J7.c(c = "com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider", f = "ZyqlSystemGuiAbilityProvider.kt", l = {231, 237}, m = "uploadWithRetry", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider$uploadWithRetry$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11811 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C11811(H7.c<? super C11811> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ZyqlSystemGuiAbilityProvider.this.uploadWithRetry(null, null, 0, null, this);
        }
    }

    public ZyqlSystemGuiAbilityProvider(S7.a taskProvider, S7.a getActionDisplayId, String str, Context context) {
        kotlin.jvm.internal.k.f(taskProvider, "taskProvider");
        kotlin.jvm.internal.k.f(getActionDisplayId, "getActionDisplayId");
        kotlin.jvm.internal.k.f(context, "context");
        this.taskProvider = taskProvider;
        this.getActionDisplayId = getActionDisplayId;
        this.taskId = str;
        this.context = context;
        this.converter = new Fa.a();
        AbstractC1436a.d(TAG, getLogPrefix() + " ZyqlSystemGuiAbilityProvider created: initialDisplayId=" + getActionDisplayId.invoke(), true);
    }

    private final String getLogPrefix() {
        String str = this.taskId;
        return str != null ? B7.a.m("[", str, "]") : "";
    }

    private final Task getTask() {
        return (Task) this.taskProvider.invoke();
    }

    private final void notifyProgress(String action, Bitmap bitmap) {
        String str = this.taskId;
        if (str != null) {
            SystemSdkBridge.notifyProgressChanged$default(SystemSdkBridge.INSTANCE, str, action, bitmap, null, null, 24, null);
        }
    }

    public static /* synthetic */ void notifyProgress$default(ZyqlSystemGuiAbilityProvider zyqlSystemGuiAbilityProvider, String str, Bitmap bitmap, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        zyqlSystemGuiAbilityProvider.notifyProgress(str, bitmap);
    }

    private final void notifyProgressPair(String action, Bitmap bitmap, String url) {
        String str = this.taskId;
        if (str != null) {
            SystemSdkBridge.INSTANCE.notifyProgressChangedPair(str, action, bitmap, "", url);
        }
    }

    public static /* synthetic */ void notifyProgressPair$default(ZyqlSystemGuiAbilityProvider zyqlSystemGuiAbilityProvider, String str, Bitmap bitmap, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            bitmap = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        zyqlSystemGuiAbilityProvider.notifyProgressPair(str, bitmap, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0127 -> B:39:0x012b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0131 -> B:41:0x0136). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadWithRetry(android.content.Context r20, java.lang.String r21, int r22, java.lang.String r23, H7.c<? super java.lang.String> r24) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider.uploadWithRetry(android.content.Context, java.lang.String, int, java.lang.String, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object uploadWithRetry$default(ZyqlSystemGuiAbilityProvider zyqlSystemGuiAbilityProvider, Context context, String str, int i, String str2, H7.c cVar, int i6, Object obj) {
        if ((i6 & 4) != 0) {
            i = 1;
        }
        return zyqlSystemGuiAbilityProvider.uploadWithRetry(context, str, i, str2, cVar);
    }

    @Override // stepai.aios.guiagent.ability.GuiAbilityProvider
    public Object bitmap2Base64(Bitmap bitmap, H7.c<? super String> cVar) {
        return Fa.a.b(this.converter, bitmap, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x052a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    @Override // stepai.aios.guiagent.ability.GuiAbilityProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object captureScreenResult(stepai.aios.guiagent.ability.CaptureOptions r52, H7.c<? super stepai.aios.guiagent.ability.CaptureResult> r53) {
        /*
            Method dump skipped, instructions count: 1360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.ZyqlSystemGuiAbilityProvider.captureScreenResult(stepai.aios.guiagent.ability.CaptureOptions, H7.c):java.lang.Object");
    }

    public final TaskEntity getTaskEntity() {
        return this.taskEntity;
    }

    public final void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    public /* synthetic */ ZyqlSystemGuiAbilityProvider(S7.a aVar, S7.a aVar2, String str, Context context, int i, kotlin.jvm.internal.e eVar) {
        this(aVar, aVar2, (i & 4) != 0 ? null : str, context);
    }
}
