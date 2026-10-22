package ai4;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import androidx.camera.core.RetryPolicy;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f3751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Object f3752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<ApplicationExitInfo> f3753c;

    public static String d(int r100) {
        switch(r100) {
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
        f3752b = new Object();
        f3753c = null;
    }

    public static boolean a() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public static List<ApplicationExitInfo> b() {
        if (a() == true) goto L5;
    L4:
        List<ApplicationExitInfo> r100 = null;
    L22:
        if (r100 != null) goto L24;
        return null;
    L24:
        return r100;
    L5:
        Context r101 = com.bytedance.crash.i.getContext();
        if (r101 == null) goto L4;
        ActivityManager r102 = (ActivityManager) r101.getSystemService("activity");
        if (r102 == null) goto L4;
        if (f3751a == false) goto L14;
        r100 = f3753c;
        goto L22
    L14:
        Object r103 = f3752b;
        monitor-enter(r103);
    L25:
        th = move-exception;
        throw th;
    L17:
        if (f3751a == true) goto L19;
        List<ApplicationExitInfo> r104 = r102.getHistoricalProcessExitReasons(r101.getPackageName(), 0, 0);     // Catch: Throwable -> L25
        f3753c = r104;     // Catch: Throwable -> L25
        r104.sort(new c());     // Catch: Throwable -> L25
    L19:
        f3751a = true;     // Catch: Throwable -> L25
        monitor-exit(r103);     // Catch: Throwable -> L25
        r100 = f3753c;
        goto L22
    }

    public static String c(long r100) {
        long r101 = r100 / 1024;     // Catch: Throwable -> L63
        if (r101 >= 1) goto L6;
        return "<1MB";
    L6:
        if (r101 > 30) goto L9;
        return "[1~30MB]";
    L9:
        if (r101 > 60) goto L12;
        return "(30~100MB]";
    L12:
        if (r101 > 100) goto L15;
        return "(60~100MB]";
    L15:
        if (r101 > 200) goto L18;
        return "(100~150MB]";
    L18:
        if (r101 > 300) goto L21;
        return "(200~300MB]";
    L21:
        if (r101 > 400) goto L24;
        return "(300~400MB]";
    L24:
        if (r101 > 500) goto L27;
        return "(400~500MB]";
    L27:
        if (r101 <= 600) goto L74;
        if (r101 <= 600) goto L34;
        if (r101 > 700) goto L34;
        return "(600~700MB]";
    L34:
        if (r101 > 800) goto L37;
        return "(700~800MB]";
    L37:
        if (r101 > 900) goto L40;
        return "(800~900MB]";
    L40:
        if (r101 > 1000) goto L43;
        return "(900~1000MB]";
    L43:
        if (r101 > 1500) goto L46;
        return "(1GB~1.5GB]";
    L46:
        if (r101 > 2000) goto L49;
        return "(1.5GB~2GB]";
    L49:
        if (r101 > 3000) goto L52;
        return "(2GB~3GB]";
    L52:
        if (r101 > 4000) goto L55;
        return "(3GB~4GB]";
    L55:
        if (r101 > RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS) goto L58;
        return "(4GB~6GB]";
    L58:
        if (r101 > KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL) goto L85;
        return "(6GB~8GB]";
    L85:
        return ">8G";
    L74:
        return "(500~600MB]";
    L63:
        return "invalid";
    }
}
