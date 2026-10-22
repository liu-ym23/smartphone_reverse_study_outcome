package com.bytedance.lego.init.util;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.model.DelayTaskInfo;
import com.bytedance.lego.init.model.InitTaskProcess;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DelayTaskExtend.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DelayTaskExtendKt {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ProcessMatchMode.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[ProcessMatchMode.ENDWITH.ordinal()] = 1;
            r0[ProcessMatchMode.CONTAIN.ordinal()] = 2;
        }
    }

    public static final boolean getSupportCurProcess(DelayTaskInfo r6) {
        o.d(r6, "receiver$0");
        if (r6.runInProcess.contains("all") == false) goto L6;
        return true;
    L6:
        if (r6.runInProcess.contains(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (InitScheduler.INSTANCE.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r6.runInProcess.contains(InitTaskProcess.MAIN);
    L13:
        if (r6.runInProcess.contains(InitTaskProcess.NONMAIN) == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r0 = InitScheduler.INSTANCE.getProcessMatchMode$initscheduler_release();
        int r1 = WhenMappings.$EnumSwitchMapping$0[r0.ordinal()];
        if (r1 != 1) goto L18;
        List<String> r7 = r6.runInProcess;
        o.b(r7, "runInProcess");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L28:
        if (r8.hasNext() == false) goto L41;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.aiagent.plugin");
        String r3 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        o.b(r2, "it");
        if (d.o.o.c(r3, r2, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r1 != 2) goto L32;
        List<String> r9 = r6.runInProcess;
        o.b(r9, "runInProcess");
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L22:
        if (r10.hasNext() == false) goto L40;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), CharSequence.class, "com.obric.aiagent.plugin");
        o.b(r4, "it");
        if (d.o.o.c(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }
}
