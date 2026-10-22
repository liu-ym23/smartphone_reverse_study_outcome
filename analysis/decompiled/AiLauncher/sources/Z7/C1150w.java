package Z7;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* renamed from: Z7.w, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1150w {
    public static ActivityManager.ProcessErrorStateInfo a(ActivityManager activityManager, long j10) throws InterruptedException {
        if (activityManager == null) {
            C1139k.h("get anr state, ActivityManager is null", new Object[0]);
            return null;
        }
        C1139k.h("get anr state, timeout:%d", Long.valueOf(j10));
        long j11 = j10 / 500;
        int i10 = 0;
        while (true) {
            ActivityManager.ProcessErrorStateInfo processErrorStateInfoC = c(activityManager.getProcessesInErrorState());
            if (processErrorStateInfoC == null) {
                C1139k.h("found proc state is null", new Object[0]);
            } else {
                int i11 = processErrorStateInfoC.condition;
                if (i11 == 2) {
                    C1139k.h("found proc state is anr! proc:%s", processErrorStateInfoC.processName);
                    return processErrorStateInfoC;
                }
                if (i11 == 1) {
                    C1139k.h("found proc state is crashed!", new Object[0]);
                    return null;
                }
            }
            int i12 = i10 + 1;
            if (i10 >= j11) {
                return b("Find process anr, but unable to get anr message.");
            }
            C1139k.h("try the %s times:", Integer.valueOf(i12));
            C1143o.C(500L);
            i10 = i12;
        }
    }

    public static ActivityManager.ProcessErrorStateInfo b(String str) {
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo = new ActivityManager.ProcessErrorStateInfo();
        processErrorStateInfo.pid = Process.myPid();
        processErrorStateInfo.processName = Y.a(Process.myPid());
        processErrorStateInfo.shortMsg = str;
        return processErrorStateInfo;
    }

    public static ActivityManager.ProcessErrorStateInfo c(List<ActivityManager.ProcessErrorStateInfo> list) {
        if (list == null || list.isEmpty()) {
            C1139k.h("error state info list is null", new Object[0]);
            return null;
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : list) {
            if (processErrorStateInfo.pid == iMyPid) {
                if (TextUtils.isEmpty(processErrorStateInfo.longMsg)) {
                    return null;
                }
                C1139k.h("found current proc in the error state", new Object[0]);
                return processErrorStateInfo;
            }
        }
        C1139k.h("current proc not in the error state", new Object[0]);
        return null;
    }
}
