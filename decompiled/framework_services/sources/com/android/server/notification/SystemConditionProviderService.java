package com.android.server.notification;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.UserHandle;
import android.service.notification.ConditionProviderService;
import android.service.notification.IConditionProvider;
import android.util.TimeUtils;
import com.android.server.pm.PackageManagerService;
import java.io.PrintWriter;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SystemConditionProviderService extends ConditionProviderService {
    public abstract void dump(PrintWriter r1, NotificationManagerService.DumpFilter r2);

    public abstract boolean isValidConditionId(Uri r1);

    public abstract void onBootComplete();

    public abstract void onUserSwitched(UserHandle r1);

    public SystemConditionProviderService() {
    }

    final ComponentName getComponent() {
        return new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, getClass().getName());
    }

    final IConditionProvider asInterface() {
        return onBind(null);
    }

    final void attachBase(Context context) {
        attachBaseContext(context);
    }

    protected static String ts(long time) {
        return new Date(time) + " (" + time + ")";
    }

    protected static String formatDuration(long millis) {
        StringBuilder sb = new StringBuilder();
        TimeUtils.formatDuration(millis, sb);
        return sb.toString();
    }

    protected static void dumpUpcomingTime(PrintWriter pw, String var, long time, long now) {
        pw.print("      ");
        pw.print(var);
        pw.print('=');
        if (time <= 0) goto L5;
        pw.printf("%s, in %s, now=%s", new Object[]{ts(time), formatDuration(time - now), ts(now)});
    L6:
        pw.println();
        return;
    L5:
        pw.print(time);
        goto L6
    }
}
