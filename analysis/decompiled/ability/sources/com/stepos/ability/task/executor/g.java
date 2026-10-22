package com.stepos.ability.task.executor;

import C7.r;
import android.os.Bundle;
import com.stepos.ability.api.ability.calltool.ICallTool;
import com.stepos.ability.api.ability.permission.ISlaPermissionManager;
import com.stepos.ability.api.task.listener.ITaskListener;
import com.stepos.ability.bean.Task;
import com.stepos.ability.commoninternal.ITag;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.ability.IAbilityManager;
import com.stepos.ability.report.IReportManager;
import java.lang.reflect.Type;
import kotlin.Pair;
import kotlin.jvm.internal.k;
import z4.C2169a;
import z4.C2172d;
import z4.C2175g;
import z4.m;
import z4.o;

/* loaded from: classes3.dex */
public final class g extends a implements ITag {
    public final ICallTool d;
    public final IAbilityManager e;
    public final IReportManager f;
    public final com.stepos.ability.task.executor.permissionauth.a g;
    public final C2175g h;
    public final m i;

    /* renamed from: j, reason: collision with root package name */
    public final C2172d f3314j;
    public final C2169a k;
    public final ISlaPermissionManager l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ITaskListener taskListener, ICallTool callTool, IAbilityManager abilityManager, IReportManager reportManager, com.stepos.ability.task.executor.permissionauth.a permissionAuthCoordinator, C2175g pendingPermissionAuth, m permissionAuthProcessor, C2172d authSessionStore, C2169a authCallbackInbox, ISlaPermissionManager slaPermissionMng) {
        super(taskListener);
        k.f(taskListener, "taskListener");
        k.f(callTool, "callTool");
        k.f(abilityManager, "abilityManager");
        k.f(reportManager, "reportManager");
        k.f(permissionAuthCoordinator, "permissionAuthCoordinator");
        k.f(pendingPermissionAuth, "pendingPermissionAuth");
        k.f(permissionAuthProcessor, "permissionAuthProcessor");
        k.f(authSessionStore, "authSessionStore");
        k.f(authCallbackInbox, "authCallbackInbox");
        k.f(slaPermissionMng, "slaPermissionMng");
        this.d = callTool;
        this.e = abilityManager;
        this.f = reportManager;
        this.g = permissionAuthCoordinator;
        this.h = pendingPermissionAuth;
        this.i = permissionAuthProcessor;
        this.f3314j = authSessionStore;
        this.k = authCallbackInbox;
        this.l = slaPermissionMng;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(com.stepos.ability.bean.InternalTask r19, com.stepos.ability.beaninternal.ability.FunctionCallResult r20, java.lang.String r21, z4.C2171c r22, z4.C2174f r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.g.b(com.stepos.ability.bean.InternalTask, com.stepos.ability.beaninternal.ability.FunctionCallResult, java.lang.String, z4.c, z4.f, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x044a, code lost:
    
        if (r7.equals(androidx.constraintlayout.core.motion.utils.TypedValues.Custom.S_INT) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0454, code lost:
    
        if (r7.equals(androidx.constraintlayout.core.motion.utils.TypedValues.Custom.S_FLOAT) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04c4, code lost:
    
        if (r7.equals("long") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x04c7, code lost:
    
        r8 = j9.t.g0(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04cb, code lost:
    
        if (r8 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04cd, code lost:
    
        r12 = new com.google.gson.JsonPrimitive(java.lang.Long.valueOf(r8.longValue()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x04f9, code lost:
    
        if (r7.equals("number") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0502, code lost:
    
        if (r7.equals("double") == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0505, code lost:
    
        r8 = j9.s.U(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0509, code lost:
    
        if (r8 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x050b, code lost:
    
        r12 = new com.google.gson.JsonPrimitive(java.lang.Double.valueOf(r8.doubleValue()));
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04a9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x06a2  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(java.lang.Long r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.Long r53, java.lang.String r54, com.stepos.ability.bean.Task r55, boolean r56, int r57, kotlin.coroutines.jvm.internal.ContinuationImpl r58) {
        /*
            Method dump skipped, instructions count: 2020
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.g.c(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, com.stepos.ability.bean.Task, boolean, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object cancel(Task task, H7.c cVar) {
        String string;
        String string2;
        if (task != null) {
            Type type = o.f6970a;
            Bundle bundle = task.getBundle();
            String str = null;
            String str2 = (String) kotlin.collections.a.Q(new Pair(Key.KEY_TOOL_CALL_ID, bundle != null ? bundle.getString(Key.KEY_TOOL_CALL_ID) : null)).get(Key.KEY_TOOL_CALL_ID);
            if (str2 == null || (string = j9.m.R0(str2).toString()) == null || string.length() <= 0) {
                string = null;
            }
            if (string != null) {
                str = string;
            } else {
                String taskId = task.getTaskId();
                if (taskId != null && (string2 = j9.m.R0(taskId).toString()) != null && string2.length() > 0) {
                    str = string2;
                }
            }
            if (str != null) {
                this.k.a(this.f3314j, this.h, str);
            }
        }
        return r.f317a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x020b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r0v67, types: [com.stepos.ability.api.task.listener.ITaskListener] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v27, types: [m9.z] */
    /* JADX WARN: Type inference failed for: r11v28 */
    /* JADX WARN: Type inference failed for: r11v36 */
    /* JADX WARN: Type inference failed for: r15v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v31 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r4v20, types: [boolean] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(com.stepos.ability.bean.InternalTask r40, int r41, int r42, H7.c r43) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.g.execute(com.stepos.ability.bean.InternalTask, int, int, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object pause(Task task, H7.c cVar) {
        return r.f317a;
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object resume(Task task, H7.c cVar) {
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0190  */
    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object submitPermissionAuthResult(boolean r20, java.lang.String r21, android.os.Bundle r22, H7.c r23) {
        /*
            Method dump skipped, instructions count: 654
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.task.executor.g.submitPermissionAuthResult(boolean, java.lang.String, android.os.Bundle, H7.c):java.lang.Object");
    }

    @Override // com.stepos.ability.api.task.executor.ITaskExecutor
    public final Object updateTask(String str, int i, Bundle bundle, H7.c cVar) {
        String tag = getTAG();
        k.f(tag, "tag");
        P3.c.f1086a.invoke(3, "Ability_".concat(tag), "updateTask: ToolTaskExecutor does not support update", null);
        return r.f317a;
    }
}
