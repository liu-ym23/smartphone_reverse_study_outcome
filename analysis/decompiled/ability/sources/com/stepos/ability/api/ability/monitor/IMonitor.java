package com.stepos.ability.api.ability.monitor;

import com.stepos.ability.beaninternal.ability.AbilityCallerContext;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.ability.IComponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Ja\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/api/ability/monitor/IMonitor;", "Lcom/stepos/ability/commoninternal/ability/IComponent;", "", "abilityId", "", "pkgName", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "taskCode", "Lcom/stepos/ability/beaninternal/ability/AbilityCallerContext;", "callerContext", "callStart", "durationMs", "taskStatus", "errorMsg", "LC7/r;", "onTaskResult", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/beaninternal/ability/AbilityCallerContext;JJLjava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IMonitor extends IComponent {
    static /* synthetic */ void onTaskResult$default(IMonitor iMonitor, Long l, String str, String str2, String str3, AbilityCallerContext abilityCallerContext, long j5, long j6, String str4, String str5, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onTaskResult");
        }
        if ((i & 16) != 0) {
            abilityCallerContext = null;
        }
        if ((i & 256) != 0) {
            str5 = null;
        }
        iMonitor.onTaskResult(l, str, str2, str3, abilityCallerContext, j5, j6, str4, str5);
    }

    void onTaskResult(Long abilityId, String pkgName, String method, String taskCode, AbilityCallerContext callerContext, long callStart, long durationMs, String taskStatus, String errorMsg);
}
