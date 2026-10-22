package com.android.server.job;

import android.app.ActivityManager;
import android.app.AppGlobals;
import android.content.pm.IPackageManager;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Binder;
import android.os.UserHandle;
import com.android.modules.utils.BasicShellCommandHandler;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.pm.verify.domain.DomainVerificationPersistence;
import com.android.server.power.teardown.swteardown.EventTeardownResult;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class JobSchedulerShellCommand extends BasicShellCommandHandler {
    static final int BYTE_OPTION_DOWNLOAD = 0;
    static final int BYTE_OPTION_UPLOAD = 1;
    public static final int CMD_ERR_CONSTRAINTS = -1002;
    public static final int CMD_ERR_NO_JOB = -1001;
    public static final int CMD_ERR_NO_PACKAGE = -1000;
    JobSchedulerService mInternal;
    IPackageManager mPM;

    JobSchedulerShellCommand(JobSchedulerService service) {
        this.mInternal = service;
        this.mPM = AppGlobals.getPackageManager();
    }

    public int onCommand(String cmd) {
        PrintWriter pw = getOutPrintWriter();
        if (cmd == null) goto L5;
        String r2 = cmd;
    L147:
    L12:
        e = move-exception;
        pw.println("Exception: " + e);
        return -1;
    L7:
        switch(r2.hashCode()) {
            case -1894245460: goto L87;
            case -1845752298: goto L84;
            case -1711668249: goto L81;
            case -1687551032: goto L78;
            case -1367724422: goto L75;
            case -1313911455: goto L72;
            case -1274672338: goto L69;
            case -1040109341: goto L66;
            case 113291: goto L63;
            case 3540994: goto L60;
            case 55361425: goto L57;
            case 200896764: goto L54;
            case 298223069: goto L51;
            case 703160488: goto L48;
            case 826231557: goto L45;
            case 859357184: goto L42;
            case 1025586161: goto L39;
            case 1173086269: goto L36;
            case 1617865539: goto L33;
            case 1749711139: goto L30;
            case 1790568356: goto L27;
            case 1791471818: goto L24;
            case 1854493850: goto L21;
            case 1929440801: goto L18;
            case 1986627080: goto L15;
            case 1993990204: goto L10;
            default: goto L89;
        };     // Catch: Exception -> L12
    L89:
        byte r3 = -1;
    L90:
        switch(r3) {
            case 0: goto L144;
            case 1: goto L142;
            case 2: goto L140;
            case 3: goto L138;
            case 4: goto L136;
            case 5: goto L134;
            case 6: goto L132;
            case 7: goto L130;
            case 8: goto L128;
            case 9: goto L126;
            case 10: goto L124;
            case 11: goto L122;
            case 12: goto L120;
            case 13: goto L118;
            case 14: goto L116;
            case 15: goto L114;
            case 16: goto L112;
            case 17: goto L110;
            case 18: goto L108;
            case 19: goto L106;
            case 20: goto L104;
            case 21: goto L102;
            case 22: goto L100;
            case 23: goto L98;
            case 24: goto L96;
            case 25: goto L94;
            default: goto L92;
        };     // Catch: Exception -> L12
    L92:
        return handleDefaultCommands(cmd);
    L94:
        return triggerDockState(pw);
    L96:
        return stop(pw);
    L98:
        return resetFlexPolicy(pw);
    L100:
        return resetScheduleQuota(pw);
    L102:
        return resetExecutionQuota(pw);
    L104:
        return cacheConfigChanges(pw);
    L106:
        return doHeartbeat(pw);
    L108:
        return getJobState(pw);
    L110:
        return getJobWakelockTag(pw);
    L112:
        return getTransferredNetworkBytes(pw, 1);
    L114:
        return getTransferredNetworkBytes(pw, 0);
    L116:
        return getStorageNotLow(pw);
    L118:
        return getStorageSeq(pw);
    L120:
        return getEstimatedNetworkBytes(pw, 1);
    L122:
        return getEstimatedNetworkBytes(pw, 0);
    L124:
        return getConfigValue(pw);
    L126:
        return getBatteryNotLow(pw);
    L128:
        return getBatteryCharging(pw);
    L130:
        return getBatterySeq(pw);
    L132:
        return getAconfigFlagState(pw);
    L134:
        return enableFlexPolicy(pw);
    L136:
        return disableFlexPolicy(pw);
    L138:
        return monitorBattery(pw);
    L140:
        return cancelJob(pw);
    L142:
        return timeout(pw);
    L144:
        return runJob(pw);
    L10:
        if (r2.equals("enable-flex-policy") == false) goto L89;
        r3 = 5;
        goto L90
    L15:
        if (r2.equals("reset-flex-policy") == false) goto L89;
        r3 = ParameterName.COLOR_TEMPERATURE;
        goto L90
    L18:
        if (r2.equals("disable-flex-policy") == false) goto L89;
        r3 = 4;
        goto L90
    L21:
        if (r2.equals("monitor-battery") == false) goto L89;
        r3 = 3;
        goto L90
    L24:
        if (r2.equals("get-job-state") == false) goto L89;
        r3 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L90
    L27:
        if (r2.equals("get-transferred-download-bytes") == false) goto L89;
        r3 = 15;
        goto L90
    L30:
        if (r2.equals("get-battery-not-low") == false) goto L89;
        r3 = 9;
        goto L90
    L33:
        if (r2.equals("get-job-wakelock-tag") == false) goto L89;
        r3 = ParameterName.DE_CONTOUR;
        goto L90
    L36:
        if (r2.equals("get-config-value") == false) goto L89;
        r3 = 10;
        goto L90
    L39:
        if (r2.equals("get-aconfig-flag-state") == false) goto L89;
        r3 = 6;
        goto L90
    L42:
        if (r2.equals("reset-schedule-quota") == false) goto L89;
        r3 = ParameterName.COLOR_TUNE;
        goto L90
    L45:
        if (r2.equals("reset-execution-quota") == false) goto L89;
        r3 = ParameterName.BLUE_STRETCH;
        goto L90
    L48:
        if (r2.equals("get-battery-seq") == false) goto L89;
        r3 = 7;
        goto L90
    L51:
        if (r2.equals("get-transferred-upload-bytes") == false) goto L89;
        r3 = 16;
        goto L90
    L54:
        if (r2.equals("heartbeat") == false) goto L89;
        r3 = ParameterName.FILM_MODE;
        goto L90
    L57:
        if (r2.equals("get-storage-not-low") == false) goto L89;
        r3 = 14;
        goto L90
    L60:
        if (r2.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L89;
        r3 = ParameterName.GLOBE_DIMMING;
        goto L90
    L63:
        if (r2.equals("run") == false) goto L89;
        r3 = 0;
        goto L90
    L66:
        if (r2.equals("cache-config-changes") == false) goto L89;
        r3 = ParameterName.BLACK_STRETCH;
        goto L90
    L69:
        if (r2.equals("get-estimated-download-bytes") == false) goto L89;
        r3 = 11;
        goto L90
    L72:
        if (r2.equals("timeout") == false) goto L89;
        r3 = 1;
        goto L90
    L75:
        if (r2.equals("cancel") == false) goto L89;
        r3 = 2;
        goto L90
    L78:
        if (r2.equals("get-battery-charging") == false) goto L89;
        r3 = 8;
        goto L90
    L81:
        if (r2.equals("get-estimated-upload-bytes") == false) goto L89;
        r3 = 12;
        goto L90
    L84:
        if (r2.equals("get-storage-seq") == false) goto L89;
        r3 = 13;
        goto L90
    L87:
        if (r2.equals("trigger-dock-state") == false) goto L89;
        r3 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L90
    L5:
        r2 = "";
        goto L147
    }

    private void checkPermission(String operation) throws Exception {
        checkPermission(operation, "android.permission.CHANGE_APP_IDLE_STATE");
    }

    private void checkPermission(String operation, String permission) throws Exception {
        int uid = Binder.getCallingUid();
        if (uid != 0) goto L5;
        return;
    L5:
        int perm = this.mPM.checkUidPermission(permission, uid);
        if (perm != 0) goto L9;
        return;
    L9:
        throw new SecurityException("Uid " + uid + " not permitted to " + operation);
    }

    private boolean printError(int errCode, String pkgName, int userId, String namespace, int jobId) {
        switch(errCode) {
            case -1002: goto L13;
            case -1001: goto L8;
            case -1000: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        PrintWriter pw = getErrPrintWriter();
        pw.print("Package not found: ");
        pw.print(pkgName);
        pw.print(" / user ");
        pw.println(userId);
        return true;
    L8:
        PrintWriter pw2 = getErrPrintWriter();
        pw2.print("Could not find job ");
        pw2.print(jobId);
        pw2.print(" in package ");
        pw2.print(pkgName);
        if (namespace == null) goto L11;
        pw2.print(" / namespace ");
        pw2.print(namespace);
    L11:
        pw2.print(" / user ");
        pw2.println(userId);
        return true;
    L13:
        PrintWriter pw3 = getErrPrintWriter();
        pw3.print("Job ");
        pw3.print(jobId);
        pw3.print(" in package ");
        pw3.print(pkgName);
        if (namespace == null) goto L16;
        pw3.print(" / namespace ");
        pw3.print(namespace);
    L16:
        pw3.print(" / user ");
        pw3.print(userId);
        pw3.println(" has functional constraints but --force not specified");
        return true;
    }

    private int runJob(PrintWriter pw) throws Exception {
        checkPermission("force scheduled jobs");
        int userId = 0;
        boolean force = false;
        boolean satisfied = false;
        String namespace = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L41;
        switch(opt.hashCode()) {
            case -1626076853: goto L30;
            case -969907566: goto L27;
            case 1497: goto L24;
            case 1505: goto L21;
            case 1510: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L32;
        };
    L32:
        byte r0 = -1;
    L33:
        switch(r0) {
            case 0: goto L39;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L36;
            default: goto L34;
        };
    L34:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L37:
        String namespace2 = getNextArgRequired();
        int userId2 = UserHandle.parseUserArg(namespace2);
        userId = userId2;
        goto L3
    L38:
        satisfied = true;
        goto L3
    L39:
        force = true;
        goto L3
    L36:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L77;
        r0 = 7;
        goto L33
    L77:
        r0 = -1;
        goto L33
    L12:
        if (opt.equals("--user") == false) goto L78;
        r0 = 5;
        goto L33
    L78:
        r0 = -1;
        goto L33
    L15:
        if (opt.equals("-u") == false) goto L79;
        r0 = 4;
        goto L33
    L79:
        r0 = -1;
        goto L33
    L18:
        if (opt.equals("-s") == false) goto L80;
        r0 = 2;
        goto L33
    L80:
        r0 = -1;
        goto L33
    L21:
        if (opt.equals("-n") == false) goto L81;
        r0 = 6;
        goto L33
    L81:
        r0 = -1;
        goto L33
    L24:
        if (opt.equals("-f") == false) goto L82;
        r0 = 0;
        goto L33
    L82:
        r0 = -1;
        goto L33
    L27:
        if (opt.equals("--satisfied") == false) goto L83;
        r0 = 3;
        goto L33
    L83:
        r0 = -1;
        goto L33
    L30:
        if (opt.equals("--force") == false) goto L84;
        r0 = 1;
        goto L33
    L84:
        r0 = -1;
        goto L33
    L41:
        if (force == false) goto L46;
        if (satisfied == false) goto L46;
        pw.println("Cannot specify both --force and --satisfied");
        return -1;
    L46:
        if (userId != (-2)) goto L48;
        int userId3 = ActivityManager.getCurrentUser();
        int userId4 = userId3;
    L49:
        String pkgName = getNextArgRequired();
        int jobId = Integer.parseInt(getNextArgRequired());
        long ident = Binder.clearCallingIdentity();
        int ret = this.mInternal.executeRunCommand(pkgName, userId4, namespace, jobId, satisfied, force);     // Catch: Throwable -> L57
        if (printError(ret, pkgName, userId4, namespace, jobId) == false) goto L54;
        Binder.restoreCallingIdentity(ident);
        return ret;
    L54:
        pw.print("Running job");     // Catch: Throwable -> L57
        if (force == false) goto L59;
        pw.print(" [FORCED]");     // Catch: Throwable -> L57
    L59:
        pw.println();     // Catch: Throwable -> L57
        Binder.restoreCallingIdentity(ident);
        return ret;
    L57:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L48:
        userId4 = userId;
        goto L49
    }

    private int timeout(PrintWriter pw) throws Exception {
        checkPermission("force timeout jobs");
        int userId = -1;
        String namespace = null;
    L3:
        String opt = getNextOption();
        byte r2 = 0;
        int r4 = -1;
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace2);
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L60;
        r2 = 3;
        goto L21
    L60:
        r2 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L61;
        r2 = 1;
        goto L21
    L61:
        r2 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == true) goto L21;
        r2 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L63;
        r2 = 2;
        goto L21
    L63:
        r2 = -1;
        goto L21
    L28:
        if (userId != (-2)) goto L30;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L31:
        String pkgName = getNextArg();
        String jobIdStr = getNextArg();
        if (jobIdStr == null) goto L34;
        r4 = Integer.parseInt(jobIdStr);
    L34:
        int jobId = r4;
        long ident = Binder.clearCallingIdentity();
        int userId4 = userId3;
        JobSchedulerService r1 = this.mInternal;     // Catch: Throwable -> L45
        if (jobIdStr == null) goto L38;
        boolean r6 = true;
    L49:
        int r15 = r1.executeStopCommand(pw, pkgName, userId4, namespace, r6, jobId, 3, 3);     // Catch: Throwable -> L43
        Binder.restoreCallingIdentity(ident);
        return r15;
    L43:
        th = move-exception;
        Throwable r16 = th;
    L47:
        Binder.restoreCallingIdentity(ident);
        throw r16;
    L38:
        r6 = false;
    L45:
        th = move-exception;
        r16 = th;
        goto L47
    L30:
        userId3 = userId;
        goto L31
    }

    private int cancelJob(PrintWriter pw) throws Exception {
        checkPermission("cancel jobs");
        int userId = 0;
        String namespace = null;
    L3:
        String opt = getNextOption();
        byte r2 = 0;
        if (opt == null) goto L27;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        int userId2 = UserHandle.parseUserArg(namespace2);
        userId = userId2;
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L59;
        r2 = 3;
        goto L21
    L59:
        r2 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L60;
        r2 = 1;
        goto L21
    L60:
        r2 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == true) goto L21;
        r2 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L62;
        r2 = 2;
        goto L21
    L62:
        r2 = -1;
        goto L21
    L27:
        if (userId >= 0) goto L30;
        pw.println("Error: must specify a concrete user ID");
        return -1;
    L30:
        int r0 = -1;
        String pkgName = getNextArg();
        String jobIdStr = getNextArg();
        if (jobIdStr == null) goto L33;
        r0 = Integer.parseInt(jobIdStr);
    L33:
        int jobId = r0;
        long ident = Binder.clearCallingIdentity();
        JobSchedulerService r3 = this.mInternal;     // Catch: Throwable -> L44
        if (jobIdStr == null) goto L37;
        boolean r7 = true;
    L50:
        int r13 = r3.executeCancelCommand(pw, pkgName, userId, namespace, r7, jobId);     // Catch: Throwable -> L42
        Binder.restoreCallingIdentity(ident);
        return r13;
    L42:
        th = move-exception;
        Throwable r14 = th;
    L46:
        Binder.restoreCallingIdentity(ident);
        throw r14;
    L37:
        r7 = false;
    L44:
        th = move-exception;
        r14 = th;
        goto L46
    }

    private int monitorBattery(PrintWriter pw) throws Exception {
        checkPermission("change battery monitoring");
        String opt = getNextArgRequired();
        if ("on".equals(opt) == false) goto L6;
        boolean enabled = true;
    L8:
        long ident = Binder.clearCallingIdentity();
        this.mInternal.setMonitorBattery(enabled);     // Catch: Throwable -> L12
        if (enabled == false) goto L14;
        pw.println("Battery monitoring enabled");     // Catch: Throwable -> L12
    L15:
        Binder.restoreCallingIdentity(ident);
        return 0;
    L14:
        pw.println("Battery monitoring disabled");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L6:
        if ("off".equals(opt) == false) goto L19;
        enabled = false;
        goto L8
    L19:
        getErrPrintWriter().println("Error: unknown option " + opt);
        return 1;
    }

    private int disableFlexPolicy(PrintWriter pw) throws Exception {
        checkPermission("disable flex policy");
        long ident = Binder.clearCallingIdentity();
        this.mInternal.setFlexPolicy(true, 0);     // Catch: Throwable -> L6
        pw.println("Set flex policy to 0");     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return 0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int enableFlexPolicy(PrintWriter pw) throws Exception {
        checkPermission("enable flex policy");
        int enabled = 0;
    L3:
        String opt = getNextOption();
        byte r3 = 0;
        if (opt == null) goto L42;
        switch(opt.hashCode()) {
            case 1506: goto L12;
            case 1389876757: goto L9;
            default: goto L14;
        };
    L14:
        byte r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L16;
        };
    L18:
        String constraint = getNextArgRequired();
        switch(constraint.hashCode()) {
            case -409840230: goto L31;
            case 3227604: goto L28;
            case 1436115569: goto L25;
            case 1923312055: goto L22;
            default: goto L33;
        };
    L33:
        r3 = -1;
    L34:
        switch(r3) {
            case 0: goto L40;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L37;
            default: goto L35;
        };
    L35:
        pw.println("Unsupported option: " + constraint);
        return -1;
    L38:
        enabled = enabled | 268435456;
        goto L3
    L39:
        enabled = enabled | 1;
        goto L3
    L40:
        enabled = enabled | 2;
        goto L3
    L37:
        enabled = enabled | 4;
        goto L3
    L22:
        if (constraint.equals("connectivity") == false) goto L63;
        r3 = 2;
        goto L34
    L63:
        r3 = -1;
        goto L34
    L25:
        if (constraint.equals(EventTeardownResult.EVENT_CHARGING) == false) goto L64;
        r3 = 1;
        goto L34
    L64:
        r3 = -1;
        goto L34
    L28:
        if (constraint.equals("idle") == false) goto L65;
        r3 = 3;
        goto L34
    L65:
        r3 = -1;
        goto L34
    L31:
        if (constraint.equals("battery-not-low") == true) goto L34;
        r3 = -1;
        goto L34
    L16:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L9:
        if (opt.equals("--option") == false) goto L67;
        r1 = 1;
        goto L15
    L67:
        r1 = -1;
        goto L15
    L12:
        if (opt.equals("-o") == false) goto L68;
        r1 = 0;
        goto L15
    L68:
        r1 = -1;
        goto L15
    L42:
        long ident = Binder.clearCallingIdentity();
        this.mInternal.setFlexPolicy(true, enabled);     // Catch: Throwable -> L46
        pw.println("Set flex policy to " + enabled);     // Catch: Throwable -> L46
        Binder.restoreCallingIdentity(ident);
        return 0;
    L46:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int getAconfigFlagState(PrintWriter pw) throws Exception {
        checkPermission("get aconfig flag state", "android.permission.DUMP");
        String flagName = getNextArgRequired();
        switch(flagName.hashCode()) {
            case -1325722786: goto L30;
            case -963776836: goto L27;
            case -946452577: goto L24;
            case -930760458: goto L21;
            case -891215409: goto L18;
            case -768714758: goto L15;
            case -616213836: goto L12;
            case -198167065: goto L9;
            case 281707623: goto L6;
            default: goto L32;
        };
    L32:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            default: goto L34;
        };
    L34:
        pw.println("Unknown flag: " + flagName);
    L44:
        return 0;
    L35:
        pw.println(true);
        goto L44
    L36:
        pw.println(true);
        goto L44
    L37:
        pw.println(true);
        goto L44
    L38:
        pw.println(false);
        goto L44
    L39:
        pw.println(false);
        goto L44
    L40:
        pw.println(false);
        goto L44
    L41:
        pw.println(true);
        goto L44
    L42:
        pw.println(true);
        goto L44
    L43:
        pw.println(false);
        goto L44
    L6:
        if (flagName.equals("android.app.job.add_type_info_to_wakelock_tag") == false) goto L32;
        r1 = 2;
        goto L33
    L9:
        if (flagName.equals(Flags.FLAG_BATCH_ACTIVE_BUCKET_JOBS) == false) goto L32;
        r1 = 3;
        goto L33
    L12:
        if (flagName.equals(Flags.FLAG_DO_NOT_FORCE_RUSH_EXECUTION_AT_BOOT) == false) goto L32;
        r1 = 5;
        goto L33
    L15:
        if (flagName.equals("android.app.job.get_pending_job_reasons_api") == false) goto L32;
        r1 = 7;
        goto L33
    L18:
        if (flagName.equals("android.app.job.get_pending_job_reasons_history_api") == false) goto L32;
        r1 = 8;
        goto L33
    L21:
        if (flagName.equals(Flags.FLAG_BATCH_CONNECTIVITY_JOBS_PER_NETWORK) == false) goto L32;
        r1 = 4;
        goto L33
    L24:
        if (flagName.equals("android.app.job.job_debug_info_apis") == false) goto L32;
        r1 = 1;
        goto L33
    L27:
        if (flagName.equals("android.app.job.enforce_minimum_time_windows") == false) goto L32;
        r1 = 0;
        goto L33
    L30:
        if (flagName.equals("android.app.job.ignore_important_while_foreground") == false) goto L32;
        r1 = 6;
        goto L33
    }

    private int getBatterySeq(PrintWriter pw) {
        int seq = this.mInternal.getBatterySeq();
        pw.println(seq);
        return 0;
    }

    private int getBatteryCharging(PrintWriter pw) {
        boolean val = this.mInternal.isBatteryCharging();
        pw.println(val);
        return 0;
    }

    private int getBatteryNotLow(PrintWriter pw) {
        boolean val = this.mInternal.isBatteryNotLow();
        pw.println(val);
        return 0;
    }

    private int getConfigValue(PrintWriter pw) throws Exception {
        checkPermission("get device config value", "android.permission.DUMP");
        String key = getNextArgRequired();
        long ident = Binder.clearCallingIdentity();
        pw.println(this.mInternal.getConfigValue(key));     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return 0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int getEstimatedNetworkBytes(PrintWriter pw, int byteOption) throws Exception {
        checkPermission("get estimated bytes");
        int userId = 0;
        String namespace = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace2);
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L60;
        r1 = 3;
        goto L21
    L60:
        r1 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L61;
        r1 = 1;
        goto L21
    L61:
        r1 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == false) goto L62;
        r1 = 0;
        goto L21
    L62:
        r1 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L63;
        r1 = 2;
        goto L21
    L63:
        r1 = -1;
        goto L21
    L28:
        if (userId != (-2)) goto L30;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L31:
        String pkgName = getNextArgRequired();
        String jobIdStr = getNextArgRequired();
        int jobId = Integer.parseInt(jobIdStr);
        long ident = Binder.clearCallingIdentity();
        int ret = this.mInternal.getEstimatedNetworkBytes(pw, pkgName, userId3, namespace, jobId, byteOption);     // Catch: Throwable -> L41
        printError(ret, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L39
        Binder.restoreCallingIdentity(ident);
        return ret;
    L39:
        th = move-exception;
        Throwable r13 = th;
    L45:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L41:
        th = move-exception;
        r13 = th;
    L43:
        th = move-exception;
        r13 = th;
        goto L45
    L30:
        userId3 = userId;
        goto L31
    }

    private int getStorageSeq(PrintWriter pw) {
        int seq = this.mInternal.getStorageSeq();
        pw.println(seq);
        return 0;
    }

    private int getStorageNotLow(PrintWriter pw) {
        boolean val = this.mInternal.getStorageNotLow();
        pw.println(val);
        return 0;
    }

    private int getTransferredNetworkBytes(PrintWriter pw, int byteOption) throws Exception {
        checkPermission("get transferred bytes");
        int userId = 0;
        String namespace = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace2);
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L60;
        r1 = 3;
        goto L21
    L60:
        r1 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L61;
        r1 = 1;
        goto L21
    L61:
        r1 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == false) goto L62;
        r1 = 0;
        goto L21
    L62:
        r1 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L63;
        r1 = 2;
        goto L21
    L63:
        r1 = -1;
        goto L21
    L28:
        if (userId != (-2)) goto L30;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L31:
        String pkgName = getNextArgRequired();
        String jobIdStr = getNextArgRequired();
        int jobId = Integer.parseInt(jobIdStr);
        long ident = Binder.clearCallingIdentity();
        int ret = this.mInternal.getTransferredNetworkBytes(pw, pkgName, userId3, namespace, jobId, byteOption);     // Catch: Throwable -> L41
        printError(ret, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L39
        Binder.restoreCallingIdentity(ident);
        return ret;
    L39:
        th = move-exception;
        Throwable r13 = th;
    L45:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L41:
        th = move-exception;
        r13 = th;
    L43:
        th = move-exception;
        r13 = th;
        goto L45
    L30:
        userId3 = userId;
        goto L31
    }

    private int getJobWakelockTag(PrintWriter pw) throws Exception {
        checkPermission("get job wakelock tag");
        int userId = 0;
        String namespace = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace2);
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L60;
        r1 = 3;
        goto L21
    L60:
        r1 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L61;
        r1 = 1;
        goto L21
    L61:
        r1 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == false) goto L62;
        r1 = 0;
        goto L21
    L62:
        r1 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L63;
        r1 = 2;
        goto L21
    L63:
        r1 = -1;
        goto L21
    L28:
        if (userId != (-2)) goto L30;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L31:
        String pkgName = getNextArgRequired();
        String jobIdStr = getNextArgRequired();
        int jobId = Integer.parseInt(jobIdStr);
        long ident = Binder.clearCallingIdentity();
        int ret = this.mInternal.getJobWakelockTag(pw, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L41
        printError(ret, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L39
        Binder.restoreCallingIdentity(ident);
        return ret;
    L39:
        th = move-exception;
        Throwable r13 = th;
    L45:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L41:
        th = move-exception;
        r13 = th;
    L43:
        th = move-exception;
        r13 = th;
        goto L45
    L30:
        userId3 = userId;
        goto L31
    }

    private int getJobState(PrintWriter pw) throws Exception {
        checkPermission("get job state");
        int userId = 0;
        String namespace = null;
    L3:
        String opt = getNextOption();
        if (opt == null) goto L28;
        switch(opt.hashCode()) {
            case 1505: goto L18;
            case 1512: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L20;
        };
    L20:
        byte r1 = -1;
    L21:
        switch(r1) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L25:
        String namespace2 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace2);
        goto L3
    L24:
        String namespace3 = getNextArgRequired();
        namespace = namespace3;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L60;
        r1 = 3;
        goto L21
    L60:
        r1 = -1;
        goto L21
    L12:
        if (opt.equals("--user") == false) goto L61;
        r1 = 1;
        goto L21
    L61:
        r1 = -1;
        goto L21
    L15:
        if (opt.equals("-u") == false) goto L62;
        r1 = 0;
        goto L21
    L62:
        r1 = -1;
        goto L21
    L18:
        if (opt.equals("-n") == false) goto L63;
        r1 = 2;
        goto L21
    L63:
        r1 = -1;
        goto L21
    L28:
        if (userId != (-2)) goto L30;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L31:
        String pkgName = getNextArgRequired();
        String jobIdStr = getNextArgRequired();
        int jobId = Integer.parseInt(jobIdStr);
        long ident = Binder.clearCallingIdentity();
        int ret = this.mInternal.getJobState(pw, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L41
        printError(ret, pkgName, userId3, namespace, jobId);     // Catch: Throwable -> L39
        Binder.restoreCallingIdentity(ident);
        return ret;
    L39:
        th = move-exception;
        Throwable r13 = th;
    L45:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L41:
        th = move-exception;
        r13 = th;
    L43:
        th = move-exception;
        r13 = th;
        goto L45
    L30:
        userId3 = userId;
        goto L31
    }

    private int doHeartbeat(PrintWriter pw) throws Exception {
        checkPermission("manipulate scheduler heartbeat");
        pw.println("Heartbeat command is no longer supported");
        return -1;
    }

    private int cacheConfigChanges(PrintWriter pw) throws Exception {
        checkPermission("change config caching", "android.permission.DUMP");
        String opt = getNextArgRequired();
        if ("on".equals(opt) == false) goto L6;
        boolean enabled = true;
    L8:
        long ident = Binder.clearCallingIdentity();
        this.mInternal.setCacheConfigChanges(enabled);     // Catch: Throwable -> L12
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L12
        r4.append("Config caching ");     // Catch: Throwable -> L12
        if (enabled == false) goto L14;
        String r5 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L15:
        r4.append(r5);     // Catch: Throwable -> L12
        pw.println(r4.toString());     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return 0;
    L14:
        r5 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L6:
        if ("off".equals(opt) == false) goto L20;
        enabled = false;
        goto L8
    L20:
        getErrPrintWriter().println("Error: unknown option " + opt);
        return 1;
    }

    private int resetFlexPolicy(PrintWriter pw) throws Exception {
        checkPermission("reset flex policy");
        long ident = Binder.clearCallingIdentity();
        this.mInternal.setFlexPolicy(false, 0);     // Catch: Throwable -> L6
        pw.println("Reset flex policy to its default state");     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return 0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int resetExecutionQuota(PrintWriter pw) throws Exception {
        checkPermission("reset execution quota");
        int userId = 0;
    L3:
        String opt = getNextOption();
        byte r3 = 0;
        if (opt == null) goto L20;
        switch(opt.hashCode()) {
            case 1512: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r3 = -1;
    L15:
        switch(r3) {
            case 0: goto L18;
            case 1: goto L18;
            default: goto L16;
        };
    L18:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L16:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L9:
        if (opt.equals("--user") == false) goto L33;
        r3 = 1;
        goto L15
    L33:
        r3 = -1;
        goto L15
    L12:
        if (opt.equals("-u") == true) goto L15;
        r3 = -1;
        goto L15
    L20:
        if (userId != (-2)) goto L22;
        userId = ActivityManager.getCurrentUser();
    L22:
        String pkgName = getNextArgRequired();
        long ident = Binder.clearCallingIdentity();
        this.mInternal.resetExecutionQuota(pkgName, userId);     // Catch: Throwable -> L26
        Binder.restoreCallingIdentity(ident);
        return 0;
    L26:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int resetScheduleQuota(PrintWriter pw) throws Exception {
        checkPermission("reset schedule quota");
        long ident = Binder.clearCallingIdentity();
        this.mInternal.resetScheduleQuota();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(ident);
        return 0;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private int stop(PrintWriter pw) throws Exception {
        checkPermission("stop jobs");
        int userId = -1;
        String namespace = null;
        int stopReason = 13;
        int internalStopReason = -1;
    L3:
        String opt = getNextOption();
        byte r2 = 0;
        int r4 = -1;
        if (opt == null) goto L42;
        switch(opt.hashCode()) {
            case -1405909809: goto L30;
            case 1500: goto L27;
            case 1505: goto L24;
            case 1510: goto L21;
            case 1512: goto L18;
            case 617801983: goto L15;
            case 1333469547: goto L12;
            case 1740612539: goto L9;
            default: goto L32;
        };
    L32:
        r2 = -1;
    L33:
        switch(r2) {
            case 0: goto L39;
            case 1: goto L39;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L36;
            default: goto L34;
        };
    L34:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L37:
        int stopReason2 = Integer.parseInt(getNextArgRequired());
        stopReason = stopReason2;
        goto L3
    L38:
        String namespace2 = getNextArgRequired();
        namespace = namespace2;
        goto L3
    L39:
        String namespace3 = getNextArgRequired();
        userId = UserHandle.parseUserArg(namespace3);
        goto L3
    L36:
        int internalStopReason2 = Integer.parseInt(getNextArgRequired());
        internalStopReason = internalStopReason2;
        goto L3
    L9:
        if (opt.equals("--namespace") == false) goto L78;
        r2 = 3;
        goto L33
    L78:
        r2 = -1;
        goto L33
    L12:
        if (opt.equals("--user") == false) goto L79;
        r2 = 1;
        goto L33
    L79:
        r2 = -1;
        goto L33
    L15:
        if (opt.equals("--internal-stop-reason") == false) goto L80;
        r2 = 7;
        goto L33
    L80:
        r2 = -1;
        goto L33
    L18:
        if (opt.equals("-u") == true) goto L33;
        r2 = -1;
        goto L33
    L21:
        if (opt.equals("-s") == false) goto L82;
        r2 = 4;
        goto L33
    L82:
        r2 = -1;
        goto L33
    L24:
        if (opt.equals("-n") == false) goto L83;
        r2 = 2;
        goto L33
    L83:
        r2 = -1;
        goto L33
    L27:
        if (opt.equals("-i") == false) goto L84;
        r2 = 6;
        goto L33
    L84:
        r2 = -1;
        goto L33
    L30:
        if (opt.equals("--stop-reason") == false) goto L85;
        r2 = 5;
        goto L33
    L85:
        r2 = -1;
        goto L33
    L42:
        if (userId != (-2)) goto L44;
        int userId2 = ActivityManager.getCurrentUser();
        int userId3 = userId2;
    L45:
        String pkgName = getNextArg();
        String jobIdStr = getNextArg();
        if (jobIdStr == null) goto L48;
        r4 = Integer.parseInt(jobIdStr);
    L48:
        int jobId = r4;
        long ident = Binder.clearCallingIdentity();
        int userId4 = userId3;
        JobSchedulerService r1 = this.mInternal;     // Catch: Throwable -> L59
        if (jobIdStr == null) goto L52;
        boolean r6 = true;
    L63:
        int r15 = r1.executeStopCommand(pw, pkgName, userId4, namespace, r6, jobId, stopReason, internalStopReason);     // Catch: Throwable -> L57
        Binder.restoreCallingIdentity(ident);
        return r15;
    L57:
        th = move-exception;
        Throwable r16 = th;
    L61:
        Binder.restoreCallingIdentity(ident);
        throw r16;
    L52:
        r6 = false;
    L59:
        th = move-exception;
        r16 = th;
        goto L61
    L44:
        userId3 = userId;
        goto L45
    }

    private int triggerDockState(PrintWriter pw) throws Exception {
        checkPermission("trigger wireless charging dock state");
        String opt = getNextArgRequired();
        if ("idle".equals(opt) == false) goto L6;
        boolean idleState = true;
    L8:
        long ident = Binder.clearCallingIdentity();
        this.mInternal.triggerDockState(idleState);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return 0;
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L6:
        if (DomainVerificationPersistence.TAG_ACTIVE.equals(opt) == false) goto L15;
        idleState = false;
        goto L8
    L15:
        getErrPrintWriter().println("Error: unknown option " + opt);
        return 1;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Job scheduler (jobscheduler) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  run [-f | --force] [-s | --satisfied] [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Trigger immediate execution of a specific scheduled job. For historical");
        pw.println("    reasons, some constraints, such as battery, are ignored when this");
        pw.println("    command is called. If you don't want any constraints to be ignored,");
        pw.println("    include the -s flag.");
        pw.println("    Options:");
        pw.println("      -f or --force: run the job even if technical constraints such as");
        pw.println("         connectivity are not currently met. This is incompatible with -f ");
        pw.println("         and so an error will be reported if both are given.");
        pw.println("      -n or --namespace: specify the namespace this job sits in; the default");
        pw.println("         is null (no namespace).");
        pw.println("      -s or --satisfied: run the job only if all constraints are met.");
        pw.println("         This is incompatible with -f and so an error will be reported");
        pw.println("         if both are given.");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("  stop [-u | --user USER_ID] [-n | --namespace NAMESPACE] [-s | --stop-reason STOP_REASON] [-i | --internal-stop-reason STOP_REASON] [PACKAGE] [JOB_ID]");
        pw.println("    Trigger immediate stop of currently executing jobs using the specified");
        pw.println("    stop reasons.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         all users");
        pw.println("      -n or --namespace: specify the namespace this job sits in; the default");
        pw.println("         is null (no namespace).");
        pw.println("      -s or --stop-reason: specify the stop reason given to the job.");
        pw.println("         Valid values are those that can be returned from");
        pw.println("         JobParameters.getStopReason().");
        pw.println("          The default value is STOP_REASON_USER.");
        pw.println("      -i or --internal-stop-reason: specify the internal stop reason.");
        pw.println("         JobScheduler will use for internal processing.");
        pw.println("         Valid values are those that can be returned from");
        pw.println("         JobParameters.getInternalStopReason().");
        pw.println("          The default value is INTERNAL_STOP_REASON_UNDEFINED.");
        pw.println("  timeout [-u | --user USER_ID] [-n | --namespace NAMESPACE] [PACKAGE] [JOB_ID]");
        pw.println("    Trigger immediate timeout of currently executing jobs, as if their");
        pw.println("    execution timeout had expired.");
        pw.println("    This is the equivalent of calling `stop -s 3 -i 3`.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         all users");
        pw.println("      -n or --namespace: specify the namespace this job sits in; the default");
        pw.println("         is null (no namespace).");
        pw.println("  cancel [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE [JOB_ID]");
        pw.println("    Cancel a scheduled job.  If a job ID is not supplied, all jobs scheduled");
        pw.println("    by that package will be canceled.  USE WITH CAUTION.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("      -n or --namespace: specify the namespace this job sits in; the default");
        pw.println("         is null (no namespace).");
        pw.println("  heartbeat [num]");
        pw.println("    No longer used.");
        pw.println("  cache-config-changes [on|off]");
        pw.println("    Control caching the set of most recently processed config flags.");
        pw.println("    Off by default.  Turning on makes get-config-value useful.");
        pw.println("  monitor-battery [on|off]");
        pw.println("    Control monitoring of all battery changes.  Off by default.  Turning");
        pw.println("    on makes get-battery-seq useful.");
        pw.println("  enable-flex-policy --option <option>");
        pw.println("    Enable flex policy with the specified options. Supported options are");
        pw.println("    battery-not-low, charging, connectivity, idle.");
        pw.println("    Multiple enable options can be specified (e.g.");
        pw.println("    enable-flex-policy --option battery-not-low --option charging");
        pw.println("  disable-flex-policy");
        pw.println("    Turn off flex policy so that it does not affect job execution.");
        pw.println("  reset-flex-policy");
        pw.println("    Resets the flex policy to its default state.");
        pw.println("  get-aconfig-flag-state FULL_FLAG_NAME");
        pw.println("    Return the state of the specified aconfig flag, if known. The flag name");
        pw.println("         must be fully qualified.");
        pw.println("  get-battery-seq");
        pw.println("    Return the last battery update sequence number that was received.");
        pw.println("  get-battery-charging");
        pw.println("    Return whether the battery is currently considered to be charging.");
        pw.println("  get-battery-not-low");
        pw.println("    Return whether the battery is currently considered to not be low.");
        pw.println("  get-config-value KEY");
        pw.println("    Return the most recently processed and cached config value for the KEY.");
        pw.println("    Only useful if caching is turned on with cache-config-changes.");
        pw.println("  get-estimated-download-bytes [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Return the most recent estimated download bytes for the job.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("  get-estimated-upload-bytes [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Return the most recent estimated upload bytes for the job.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("  get-storage-seq");
        pw.println("    Return the last storage update sequence number that was received.");
        pw.println("  get-storage-not-low");
        pw.println("    Return whether storage is currently considered to not be low.");
        pw.println("  get-transferred-download-bytes [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Return the most recent transferred download bytes for the job.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("  get-transferred-upload-bytes [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Return the most recent transferred upload bytes for the job.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("  get-job-state [-u | --user USER_ID] [-n | --namespace NAMESPACE] PACKAGE JOB_ID");
        pw.println("    Return the current state of a job, may be any combination of:");
        pw.println("      pending: currently on the pending list, waiting to be active");
        pw.println("      active: job is actively running");
        pw.println("      user-stopped: job can't run because its user is stopped");
        pw.println("      backing-up: job can't run because app is currently backing up its data");
        pw.println("      no-component: job can't run because its component is not available");
        pw.println("      ready: job is ready to run (all constraints satisfied or bypassed)");
        pw.println("      waiting: if nothing else above is printed, job not ready to run");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's job is to be run; the default is");
        pw.println("         the primary or system user");
        pw.println("      -n or --namespace: specify the namespace this job sits in; the default");
        pw.println("         is null (no namespace).");
        pw.println("  trigger-dock-state [idle|active]");
        pw.println("    Trigger wireless charging dock state.  Active by default.");
        pw.println();
    }
}
