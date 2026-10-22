package com.stepos.ability.bean;

import android.content.Context;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0002¨\u0006\f"}, d2 = {"toTaskConfig", "Lcom/stepos/ability/bean/TaskConfig;", "Lcom/stepos/ability/bean/OriginalTaskConfig;", "context", "Landroid/content/Context;", "bundle", "Landroid/os/Bundle;", "toTask", "Lcom/stepos/ability/bean/Task;", "toOriginalTaskConfig", "", "toJson", "bean_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTaskConfigKt {
    public static final String toJson(OriginalTaskConfig originalTaskConfig) {
        k.f(originalTaskConfig, "<this>");
        return OriginalTaskConfigJson.INSTANCE.toJson(originalTaskConfig);
    }

    public static final OriginalTaskConfig toOriginalTaskConfig(String str) {
        k.f(str, "<this>");
        return OriginalTaskConfigJson.INSTANCE.fromJson(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.ability.bean.Task toTask(com.stepos.ability.bean.OriginalTaskConfig r30) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r30
            kotlin.jvm.internal.k.f(r1, r0)
            java.lang.String r2 = r1.getTaskId()
            java.lang.String r12 = r1.getParentTaskId()
            java.lang.String r4 = r1.getName()
            java.lang.String r0 = r1.getStatus()
            int r3 = r0.hashCode()
            switch(r3) {
                case -1402931637: goto L4f;
                case -1367724422: goto L43;
                case -1281977283: goto L37;
                case -682587753: goto L2b;
                case 1550783935: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L57
        L1f:
            java.lang.String r3 = "running"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L28
            goto L57
        L28:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.g
            goto L5c
        L2b:
            java.lang.String r3 = "pending"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L34
            goto L57
        L34:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f
            goto L5c
        L37:
            java.lang.String r3 = "failed"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L40
            goto L57
        L40:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.i
            goto L5c
        L43:
            java.lang.String r3 = "cancel"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L4c
            goto L57
        L4c:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.f3076j
            goto L5c
        L4f:
            java.lang.String r3 = "completed"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L5a
        L57:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.g
            goto L5c
        L5a:
            com.stepos.ability.common.TaskStatus r0 = com.stepos.ability.common.TaskStatus.h
        L5c:
            int r10 = r0.f3078a
            java.lang.String r5 = r1.getCoverUrl()
            java.lang.String r6 = r1.getDescription()
            com.stepos.ability.bean.AppUI r19 = new com.stepos.ability.bean.AppUI
            java.lang.String r22 = r1.getResultType()
            java.lang.String r23 = r1.getResultSrc()
            java.lang.String r24 = r1.getResultContent()
            r28 = 14591(0x38ff, float:2.0446E-41)
            r29 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r13 = r19
            r19 = 0
            r20 = 0
            r21 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            com.stepos.ability.bean.Task r1 = new com.stepos.ability.bean.Task
            r24 = 506466(0x7ba62, float:7.0971E-40)
            r3 = 0
            r7 = 0
            r8 = 0
            r9 = -1
            r11 = 0
            r19 = r13
            r13 = 0
            r15 = 0
            r17 = 0
            r22 = 0
            r23 = 0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r19, r20, r21, r22, r23, r24, r25)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.bean.OriginalTaskConfigKt.toTask(com.stepos.ability.bean.OriginalTaskConfig):com.stepos.ability.bean.Task");
    }

    public static final TaskConfig toTaskConfig(OriginalTaskConfig originalTaskConfig, Context context, Bundle bundle) {
        k.f(originalTaskConfig, "<this>");
        k.f(context, "context");
        k.f(bundle, "bundle");
        String taskId = originalTaskConfig.getTaskId();
        String taskId2 = originalTaskConfig.getTaskId();
        String parentTaskId = originalTaskConfig.getParentTaskId();
        boolean zB = k.b(originalTaskConfig.getToolName(), "gui_agent");
        String toolName = originalTaskConfig.getToolName();
        String toolParams = originalTaskConfig.getToolParams();
        String name = originalTaskConfig.getName();
        String description = originalTaskConfig.getDescription();
        int i = 2;
        String str = null;
        Long l = null;
        GuiAgentConfig guiAgentConfig = null;
        int i6 = 0;
        return new TaskConfig(taskId, taskId2, parentTaskId, zB ? 1 : 0, i, str, l, toolName, new TaskUiInfo(name, originalTaskConfig.getCoverUrl(), description), guiAgentConfig, toolParams, bundle, context.getPackageName(), i6, 8768, null);
    }
}
