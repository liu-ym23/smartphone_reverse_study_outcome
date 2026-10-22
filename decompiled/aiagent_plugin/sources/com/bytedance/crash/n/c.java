package com.bytedance.crash.n;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.i;
import com.obric.autoaction.view.DraggableFloatingLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: AppExitInfoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7610a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Object f7611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<ApplicationExitInfo> f7612c;

    public static String a(int r0) {
        switch(r0) {
            case 1: goto L31;
            case 2: goto L29;
            case 3: goto L27;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            case 13: goto L7;
            case 14: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "FREEZER";
    L7:
        return "OTHER KILLS BY SYSTEM";
    L9:
        return "DEPENDENCY DIED";
    L11:
        return "USER STOPPED";
    L13:
        return "USER REQUESTED";
    L15:
        return "EXCESSIVE RESOURCE USAGE";
    L17:
        return "PERMISSION CHANGE";
    L19:
        return "INITIALIZATION FAILURE";
    L21:
        return "ANR";
    L23:
        return "APP CRASH(NATIVE)";
    L25:
        return "APP CRASH(EXCEPTION)";
    L27:
        return "LOW_MEMORY";
    L29:
        return "SIGNALED";
    L31:
        return "EXIT_SELF";
    }

    public static String b(int r0) {
        switch(r0) {
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L49;
            case 4: goto L47;
            case 5: goto L45;
            case 6: goto L43;
            case 7: goto L41;
            case 8: goto L39;
            case 9: goto L37;
            case 10: goto L35;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L29;
            case 14: goto L27;
            case 15: goto L25;
            case 16: goto L23;
            case 17: goto L21;
            case 18: goto L19;
            case 19: goto L17;
            case 20: goto L15;
            case 21: goto L13;
            case 22: goto L11;
            case 23: goto L9;
            case 24: goto L7;
            case 25: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "PACKAGE UPDATE";
    L7:
        return "KILL BACKGROUND";
    L9:
        return "STOP APP";
    L11:
        return "REMOVE TASK";
    L13:
        return "FORCE STOP";
    L15:
        return "FREEZER BINDER TRANSACTION";
    L17:
        return "FREEZER BINDER IOCTL";
    L19:
        return "CACHED IDLE FORCED APP STANDBY";
    L21:
        return "ISOLATED NOT NEEDED";
    L23:
        return "REMOVE LRU";
    L25:
        return "IMPERCEPTIBLE";
    L27:
        return "INVALID STATE";
    L29:
        return "INVALID START";
    L31:
        return "KILL PID";
    L33:
        return "KILL UID";
    L35:
        return "KILL ALL BG EXCEPT";
    L37:
        return "KILL ALL FG";
    L39:
        return "SYSTEM UPDATE_DONE";
    L41:
        return "EXCESSIVE CPU USAGE";
    L43:
        return "MEMORY PRESSURE";
    L45:
        return "LARGE CACHED";
    L47:
        return "TRIM EMPTY";
    L49:
        return "TOO MANY EMPTY PROCS";
    L51:
        return "TOO MANY CACHED PROCS";
    L53:
        return "WAIT FOR DEBUGGER";
    }

    static {
        f7611b = new Object();
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<ApplicationExitInfo> b() {
        List<ApplicationExitInfo> r0 = c();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public static List<ApplicationExitInfo> c() {
        if (a() == true) goto L5;
        return null;
    L5:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        return null;
    L8:
        ActivityManager r2 = (ActivityManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("activity"), ActivityManager.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L12;
        return null;
    L12:
        if (f7610a == true) goto L14;
        Object r1 = f7611b;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L18:
        if (f7610a == true) goto L20;
        List<ApplicationExitInfo> r3 = r2.getHistoricalProcessExitReasons(r0.getPackageName(), 0, 0);     // Catch: Throwable -> L24
        f7612c = r3;     // Catch: Throwable -> L24
        r3.sort(new AnonymousClass1());     // Catch: Throwable -> L24
    L20:
        f7610a = true;     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return f7612c;
    L14:
        return f7612c;
    }

    static String a(long r2) {
        long r3 = r2 / 1024;     // Catch: Throwable -> L63
        if (r3 >= 1) goto L6;
        return "<1MB";
    L6:
        if (r3 > 30) goto L9;
        return "[1~30MB]";
    L9:
        if (r3 > 60) goto L12;
        return "(30~100MB]";
    L12:
        if (r3 > 100) goto L15;
        return "(60~100MB]";
    L15:
        if (r3 > 200) goto L18;
        return "(100~150MB]";
    L18:
        if (r3 > 300) goto L21;
        return "(200~300MB]";
    L21:
        if (r3 > 400) goto L24;
        return "(300~400MB]";
    L24:
        if (r3 > 500) goto L27;
        return "(400~500MB]";
    L27:
        if (r3 <= 600) goto L74;
        if (r3 <= 600) goto L34;
        if (r3 > 700) goto L34;
        return "(600~700MB]";
    L34:
        if (r3 > 800) goto L37;
        return "(700~800MB]";
    L37:
        if (r3 > 900) goto L40;
        return "(800~900MB]";
    L40:
        if (r3 > 1000) goto L43;
        return "(900~1000MB]";
    L43:
        if (r3 > 1500) goto L46;
        return "(1GB~1.5GB]";
    L46:
        if (r3 > 2000) goto L49;
        return "(1.5GB~2GB]";
    L49:
        if (r3 > WsConstants.EXIT_DELAY_TIME) goto L52;
        return "(2GB~3GB]";
    L52:
        if (r3 > 4000) goto L55;
        return "(3GB~4GB]";
    L55:
        if (r3 > DraggableFloatingLayout.DEFAULT_RIGHT_REVEAL_AUTO_RETRACT_DELAY_MS) goto L58;
        return "(4GB~6GB]";
    L58:
        if (r3 > 8000) goto L85;
        return "(6GB~8GB]";
    L85:
        return ">8G";
    L74:
        return "(500~600MB]";
    L63:
        return "invalid";
    }
}
