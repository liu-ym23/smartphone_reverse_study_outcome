package com.android.server.autofill;

import android.os.Bundle;
import android.os.RemoteCallback;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.service.autofill.AutofillFieldClassificationService;
import android.service.autofill.Flags;
import com.android.internal.os.IResultReceiver;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class AutofillManagerServiceShellCommand extends ShellCommand {
    private final AutofillManagerService mService;

    public static /* synthetic */ void $r8$lambda$3FaD0U_u9d_TRgwH8mkQaWuWE0M(AutofillManagerServiceShellCommand r0, int r1, IResultReceiver r2) {
        r0.lambda$requestDestroy$1(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$65ToakWZ60Xa_gHFsfBL9penBPo(AutofillManagerServiceShellCommand r0, int r1, IResultReceiver r2) {
        r0.lambda$requestList$2(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$zsFSy6nk4Ej0A1cLNgvWraX77js(PrintWriter r0, CountDownLatch r1, Bundle r2) {
        lambda$getFieldClassificationScore$0(r0, r1, r2);
    }

    public AutofillManagerServiceShellCommand(AutofillManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case 102230: goto L24;
            case 113762: goto L21;
            case 3322014: goto L18;
            case 97513095: goto L15;
            case 108404047: goto L12;
            case 1557372922: goto L9;
            default: goto L26;
        };
    L26:
        byte r1 = -1;
    L27:
        switch(r1) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            default: goto L29;
        };
    L29:
        return handleDefaultCommands(cmd);
    L31:
        return requestFlags(pw);
    L33:
        return requestSet(pw);
    L35:
        return requestGet(pw);
    L37:
        return requestReset();
    L39:
        return requestDestroy(pw);
    L41:
        return requestList(pw);
    L9:
        if (cmd.equals("destroy") == false) goto L26;
        r1 = 1;
        goto L27
    L12:
        if (cmd.equals("reset") == false) goto L26;
        r1 = 2;
        goto L27
    L15:
        if (cmd.equals("flags") == false) goto L26;
        r1 = 5;
        goto L27
    L18:
        if (cmd.equals("list") == false) goto L26;
        r1 = 0;
        goto L27
    L21:
        if (cmd.equals("set") == false) goto L26;
        r1 = 4;
        goto L27
    L24:
        if (cmd.equals("get") == false) goto L26;
        r1 = 3;
        goto L27
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("AutoFill Service (autofill) commands:");     // Catch: Throwable -> L6
        pw.println("  help");     // Catch: Throwable -> L6
        pw.println("    Prints this help text.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get log_level ");     // Catch: Throwable -> L6
        pw.println("    Gets the Autofill log level (off | debug | verbose).");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get max_partitions");     // Catch: Throwable -> L6
        pw.println("    Gets the maximum number of partitions per session.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get max_visible_datasets");     // Catch: Throwable -> L6
        pw.println("    Gets the maximum number of visible datasets in the UI.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get full_screen_mode");     // Catch: Throwable -> L6
        pw.println("    Gets the Fill UI full screen mode");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get fc_score [--algorithm ALGORITHM] value1 value2");     // Catch: Throwable -> L6
        pw.println("    Gets the field classification score for 2 fields.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get bind-instant-service-allowed");     // Catch: Throwable -> L6
        pw.println("    Gets whether binding to services provided by instant apps is allowed");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get saved-password-count");     // Catch: Throwable -> L6
        pw.println("    Gets the number of saved passwords in the current service.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set log_level [off | debug | verbose]");     // Catch: Throwable -> L6
        pw.println("    Sets the Autofill log level.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set max_partitions number");     // Catch: Throwable -> L6
        pw.println("    Sets the maximum number of partitions per session.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set max_visible_datasets number");     // Catch: Throwable -> L6
        pw.println("    Sets the maximum number of visible datasets in the UI.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set full_screen_mode [true | false | default]");     // Catch: Throwable -> L6
        pw.println("    Sets the Fill UI full screen mode");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set bind-instant-service-allowed [true | false]");     // Catch: Throwable -> L6
        pw.println("    Sets whether binding to services provided by instant apps is allowed");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-augmented-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the augmented autofill service implementation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call with just the USER_ID argument.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set default-augmented-service-enabled USER_ID [true|false]");     // Catch: Throwable -> L6
        pw.println("    Enable / disable the default augmented autofill service for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  set temporary-detection-service USER_ID [COMPONENT_NAME DURATION]");     // Catch: Throwable -> L6
        pw.println("    Temporarily (for DURATION ms) changes the autofill detection service implementation.");     // Catch: Throwable -> L6
        pw.println("    To reset, call with [COMPONENT_NAME 0].");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  get default-augmented-service-enabled USER_ID");     // Catch: Throwable -> L6
        pw.println("    Checks whether the default augmented autofill service is enabled for the user.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  list sessions [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Lists all pending sessions.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  destroy sessions [--user USER_ID]");     // Catch: Throwable -> L6
        pw.println("    Destroys all pending sessions.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  reset");     // Catch: Throwable -> L6
        pw.println("    Resets all pending sessions and cached service connections.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.println("  flags");     // Catch: Throwable -> L6
        pw.println("    Prints out all autofill related flags.");     // Catch: Throwable -> L6
        pw.println("");     // Catch: Throwable -> L6
        pw.close();
        return;
    L6:
        th = move-exception;
        if (pw != null) goto L13;
    L12:
        throw th;
    L13:
        pw.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.addSuppressed(th);
        goto L12
    }

    private int requestFlags(PrintWriter pw) {
        Method[] r2 = new Method[0];
        Method[] flagMethods = Flags.class.getDeclaredMethods();     // Catch: SecurityException -> L20
        int r3 = flagMethods.length;
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L19;
        Method method = flagMethods[r4];
        if (Modifier.isPublic(method.getModifiers()) == false) goto L16;
        pw.print(method.getName() + ": ");     // Catch: Throwable -> L11 Exception -> L13
        pw.print(method.invoke(null, new Object[0]));     // Catch: Throwable -> L11 Exception -> L13
    L10:
        pw.println("");
        goto L16
    L11:
        th = move-exception;
        pw.println("");
        throw th;
    L13:
        ex = move-exception;
        ex.printStackTrace(pw);     // Catch: Throwable -> L11
    L16:
        r4 = r4 + 1;
        goto L5
    L19:
        return 0;
    L20:
        ex = move-exception;
        ex.printStackTrace(pw);
        return -1;
    }

    private int requestGet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case -2124387184: goto L30;
            case -2006901047: goto L27;
            case -1298810906: goto L24;
            case -633247282: goto L21;
            case -255918237: goto L18;
            case 809633044: goto L15;
            case 852405952: goto L12;
            case 1393110435: goto L9;
            case 1772188804: goto L6;
            default: goto L32;
        };
    L32:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            default: goto L34;
        };
    L34:
        pw.println("Invalid set: " + what);
        return -1;
    L37:
        return getSavedPasswordCount(pw);
    L39:
        return isFieldDetectionServiceEnabled(pw);
    L41:
        return getDefaultAugmentedServiceEnabled(pw);
    L43:
        return getBindInstantService(pw);
    L45:
        return getFullScreenMode(pw);
    L47:
        return getFieldClassificationScore(pw);
    L49:
        return getMaxVisibileDatasets(pw);
    L51:
        return getMaxPartitions(pw);
    L53:
        return getLogLevel(pw);
    L6:
        if (what.equals("max_partitions") == false) goto L54;
        r1 = 1;
        goto L33
    L54:
        r1 = -1;
        goto L33
    L9:
        if (what.equals("max_visible_datasets") == false) goto L55;
        r1 = 2;
        goto L33
    L55:
        r1 = -1;
        goto L33
    L12:
        if (what.equals("default-augmented-service-enabled") == false) goto L56;
        r1 = 6;
        goto L33
    L56:
        r1 = -1;
        goto L33
    L15:
        if (what.equals("bind-instant-service-allowed") == false) goto L57;
        r1 = 5;
        goto L33
    L57:
        r1 = -1;
        goto L33
    L18:
        if (what.equals("saved-password-count") == false) goto L58;
        r1 = 8;
        goto L33
    L58:
        r1 = -1;
        goto L33
    L21:
        if (what.equals("field-detection-service-enabled") == false) goto L59;
        r1 = 7;
        goto L33
    L59:
        r1 = -1;
        goto L33
    L24:
        if (what.equals("full_screen_mode") == false) goto L60;
        r1 = 4;
        goto L33
    L60:
        r1 = -1;
        goto L33
    L27:
        if (what.equals("log_level") == false) goto L61;
        r1 = 0;
        goto L33
    L61:
        r1 = -1;
        goto L33
    L30:
        if (what.equals("fc_score") == false) goto L62;
        r1 = 3;
        goto L33
    L62:
        r1 = -1;
        goto L33
    }

    private int requestSet(PrintWriter pw) {
        String what = getNextArgRequired();
        switch(what.hashCode()) {
            case -2006901047: goto L27;
            case -1298810906: goto L24;
            case -571600804: goto L21;
            case 809633044: goto L18;
            case 852405952: goto L15;
            case 1393110435: goto L12;
            case 1772188804: goto L9;
            case 2027866865: goto L6;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        switch(r1) {
            case 0: goto L48;
            case 1: goto L46;
            case 2: goto L44;
            case 3: goto L42;
            case 4: goto L40;
            case 5: goto L38;
            case 6: goto L36;
            case 7: goto L34;
            default: goto L31;
        };
    L31:
        pw.println("Invalid set: " + what);
        return -1;
    L34:
        return setTemporaryDetectionService(pw);
    L36:
        return setDefaultAugmentedServiceEnabled(pw);
    L38:
        return setTemporaryAugmentedService(pw);
    L40:
        return setBindInstantService(pw);
    L42:
        return setFullScreenMode(pw);
    L44:
        return setMaxVisibileDatasets();
    L46:
        return setMaxPartitions();
    L48:
        return setLogLevel(pw);
    L6:
        if (what.equals("temporary-detection-service") == false) goto L49;
        r1 = 7;
        goto L30
    L49:
        r1 = -1;
        goto L30
    L9:
        if (what.equals("max_partitions") == false) goto L50;
        r1 = 1;
        goto L30
    L50:
        r1 = -1;
        goto L30
    L12:
        if (what.equals("max_visible_datasets") == false) goto L51;
        r1 = 2;
        goto L30
    L51:
        r1 = -1;
        goto L30
    L15:
        if (what.equals("default-augmented-service-enabled") == false) goto L52;
        r1 = 6;
        goto L30
    L52:
        r1 = -1;
        goto L30
    L18:
        if (what.equals("bind-instant-service-allowed") == false) goto L53;
        r1 = 4;
        goto L30
    L53:
        r1 = -1;
        goto L30
    L21:
        if (what.equals("temporary-augmented-service") == false) goto L54;
        r1 = 5;
        goto L30
    L54:
        r1 = -1;
        goto L30
    L24:
        if (what.equals("full_screen_mode") == false) goto L55;
        r1 = 3;
        goto L30
    L55:
        r1 = -1;
        goto L30
    L27:
        if (what.equals("log_level") == false) goto L56;
        r1 = 0;
        goto L30
    L56:
        r1 = -1;
        goto L30
    }

    private int getLogLevel(PrintWriter pw) {
        int logLevel = this.mService.getLogLevel();
        switch(logLevel) {
            case 0: goto L10;
            case 1: goto L4;
            case 2: goto L8;
            case 3: goto L4;
            case 4: goto L6;
            default: goto L4;
        };
    L4:
        pw.println("unknow (" + logLevel + ")");
        return 0;
    L6:
        pw.println("verbose");
        return 0;
    L8:
        pw.println("debug");
        return 0;
    L10:
        pw.println("off");
        return 0;
    }

    private int setLogLevel(PrintWriter pw) {
        String logLevel = getNextArgRequired();
        String r1 = logLevel.toLowerCase();
        switch(r1.hashCode()) {
            case 109935: goto L12;
            case 95458899: goto L9;
            case 351107458: goto L6;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Invalid level: " + logLevel);
        return -1;
    L18:
        this.mService.setLogLevel(0);
        return 0;
    L20:
        this.mService.setLogLevel(2);
        return 0;
    L22:
        this.mService.setLogLevel(4);
        return 0;
    L6:
        if (r1.equals("verbose") == false) goto L24;
        r2 = 0;
        goto L15
    L24:
        r2 = -1;
        goto L15
    L9:
        if (r1.equals("debug") == false) goto L25;
        r2 = 1;
        goto L15
    L25:
        r2 = -1;
        goto L15
    L12:
        if (r1.equals("off") == false) goto L26;
        r2 = 2;
        goto L15
    L26:
        r2 = -1;
        goto L15
    }

    private int getMaxPartitions(PrintWriter pw) {
        pw.println(this.mService.getMaxPartitions());
        return 0;
    }

    private int setMaxPartitions() {
        this.mService.setMaxPartitions(Integer.parseInt(getNextArgRequired()));
        return 0;
    }

    private int getMaxVisibileDatasets(PrintWriter pw) {
        pw.println(this.mService.getMaxVisibleDatasets());
        return 0;
    }

    private int setMaxVisibileDatasets() {
        this.mService.setMaxVisibleDatasets(Integer.parseInt(getNextArgRequired()));
        return 0;
    }

    private int getFieldClassificationScore(final PrintWriter pw) {
        String nextArg = getNextArgRequired();
        if ("--algorithm".equals(nextArg) == false) goto L5;
        String algorithm = getNextArgRequired();
        String value1 = getNextArgRequired();
    L6:
        String value2 = getNextArgRequired();
        final CountDownLatch latch = new CountDownLatch(1);
        this.mService.calculateScore(algorithm, value1, value2, new RemoteCallback(new AutofillManagerServiceShellCommand$$ExternalSyntheticLambda0(pw, latch)));
        return waitForLatch(pw, latch);
    L5:
        algorithm = null;
        value1 = nextArg;
        goto L6
    }

    private static /* synthetic */ void lambda$getFieldClassificationScore$0(PrintWriter pw, CountDownLatch latch, Bundle result) {
        AutofillFieldClassificationService.Scores scores = (AutofillFieldClassificationService.Scores) result.getParcelable("scores", AutofillFieldClassificationService.Scores.class);
        if (scores != null) goto L5;
        pw.println("no score");
    L6:
        latch.countDown();
        return;
    L5:
        pw.println(scores.scores[0][0]);
        goto L6
    }

    private int getFullScreenMode(PrintWriter pw) {
        Boolean mode = this.mService.getFullScreenMode();
        if (mode != null) goto L6;
        pw.println("default");
        return 0;
    L6:
        if (mode.booleanValue() == false) goto L8;
        pw.println("true");
        return 0;
    L8:
        pw.println("false");
        return 0;
    }

    private int setFullScreenMode(PrintWriter pw) {
        String mode = getNextArgRequired();
        String r1 = mode.toLowerCase();
        switch(r1.hashCode()) {
            case 3569038: goto L12;
            case 97196323: goto L9;
            case 1544803905: goto L6;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Invalid mode: " + mode);
        return -1;
    L18:
        this.mService.setFullScreenMode(null);
        return 0;
    L20:
        this.mService.setFullScreenMode(Boolean.FALSE);
        return 0;
    L22:
        this.mService.setFullScreenMode(Boolean.TRUE);
        return 0;
    L6:
        if (r1.equals("default") == false) goto L24;
        r2 = 2;
        goto L15
    L24:
        r2 = -1;
        goto L15
    L9:
        if (r1.equals("false") == false) goto L25;
        r2 = 1;
        goto L15
    L25:
        r2 = -1;
        goto L15
    L12:
        if (r1.equals("true") == false) goto L26;
        r2 = 0;
        goto L15
    L26:
        r2 = -1;
        goto L15
    }

    private int getBindInstantService(PrintWriter pw) {
        if (this.mService.getAllowInstantService() == false) goto L5;
        pw.println("true");
        return 0;
    L5:
        pw.println("false");
        return 0;
    }

    private int setBindInstantService(PrintWriter pw) {
        String mode = getNextArgRequired();
        String r1 = mode.toLowerCase();
        switch(r1.hashCode()) {
            case 3569038: goto L9;
            case 97196323: goto L6;
            default: goto L11;
        };
    L11:
        byte r2 = -1;
    L12:
        switch(r2) {
            case 0: goto L17;
            case 1: goto L15;
            default: goto L13;
        };
    L13:
        pw.println("Invalid mode: " + mode);
        return -1;
    L15:
        this.mService.setAllowInstantService(false);
        return 0;
    L17:
        this.mService.setAllowInstantService(true);
        return 0;
    L6:
        if (r1.equals("false") == false) goto L19;
        r2 = 1;
        goto L12
    L19:
        r2 = -1;
        goto L12
    L9:
        if (r1.equals("true") == false) goto L20;
        r2 = 0;
        goto L12
    L20:
        r2 = -1;
        goto L12
    }

    private int setTemporaryDetectionService(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryDetectionService(userId);
        return 0;
    L6:
        int duration = getNextIntArgRequired();
        if (duration > 0) goto L10;
        this.mService.resetTemporaryDetectionService(userId);
        return 0;
    L10:
        this.mService.setTemporaryDetectionService(userId, serviceName, duration);
        pw.println("Autofill Detection Service temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int isFieldDetectionServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = this.mService.isFieldDetectionServiceEnabledForUser(userId);
        pw.println(enabled);
        return 0;
    }

    private int setTemporaryAugmentedService(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        String serviceName = getNextArg();
        if (serviceName != null) goto L6;
        this.mService.resetTemporaryAugmentedAutofillService(userId);
        return 0;
    L6:
        int duration = getNextIntArgRequired();
        this.mService.setTemporaryAugmentedAutofillService(userId, serviceName, duration);
        pw.println("AugmentedAutofillService temporarily set to " + serviceName + " for " + duration + "ms");
        return 0;
    }

    private int getDefaultAugmentedServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = this.mService.isDefaultAugmentedServiceEnabled(userId);
        pw.println(enabled);
        return 0;
    }

    private int setDefaultAugmentedServiceEnabled(PrintWriter pw) {
        int userId = getNextIntArgRequired();
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());
        boolean changed = this.mService.setDefaultAugmentedServiceEnabled(userId, enabled);
        if (changed == true) goto L7;
        pw.println("already " + enabled);
        return 0;
    L7:
        return 0;
    }

    private int getSavedPasswordCount(final PrintWriter pw) {
        int userId = getNextIntArgRequired();
        final CountDownLatch latch = new CountDownLatch(1);
        IResultReceiver resultReceiver = new AnonymousClass1(this, pw, latch);
        if (this.mService.requestSavedPasswordCount(userId, resultReceiver) == false) goto L7;
        waitForLatch(pw, latch);
        return 0;
    L7:
        return 0;
    }

    private int requestDestroy(PrintWriter pw) {
        if (isNextArgSessions(pw) == true) goto L6;
        return -1;
    L6:
        final int userId = getUserIdFromArgsOrAllUsers();
        final CountDownLatch latch = new CountDownLatch(1);
        final IResultReceiver.Stub r2 = new AnonymousClass2(this, latch);
        return requestSessionCommon(pw, latch, new AutofillManagerServiceShellCommand$$ExternalSyntheticLambda2(this, userId, r2));
    }

    private /* synthetic */ void lambda$requestDestroy$1(int userId, IResultReceiver receiver) {
        this.mService.removeAllSessions(userId, receiver);
    }

    private int requestList(final PrintWriter pw) {
        if (isNextArgSessions(pw) == true) goto L6;
        return -1;
    L6:
        final int userId = getUserIdFromArgsOrAllUsers();
        final CountDownLatch latch = new CountDownLatch(1);
        final IResultReceiver.Stub r2 = new AnonymousClass3(this, pw, latch);
        return requestSessionCommon(pw, latch, new AutofillManagerServiceShellCommand$$ExternalSyntheticLambda1(this, userId, r2));
    }

    private /* synthetic */ void lambda$requestList$2(int userId, IResultReceiver receiver) {
        this.mService.listSessions(userId, receiver);
    }

    private boolean isNextArgSessions(PrintWriter pw) {
        String type = getNextArgRequired();
        if (type.equals("sessions") == true) goto L6;
        pw.println("Error: invalid list type");
        return false;
    L6:
        return true;
    }

    private int requestSessionCommon(PrintWriter pw, CountDownLatch latch, Runnable command) {
        command.run();
        return waitForLatch(pw, latch);
    }

    private int waitForLatch(PrintWriter pw, CountDownLatch latch) {
        boolean received = latch.await(5, TimeUnit.SECONDS);     // Catch: InterruptedException -> L7
        if (received == true) goto L9;
        pw.println("Timed out after 5 seconds");     // Catch: InterruptedException -> L7
        return -1;
    L9:
        return 0;
    L11:
        pw.println("System call interrupted");
        Thread.currentThread().interrupt();
        return -1;
    }

    private int requestReset() {
        this.mService.reset();
        return 0;
    }

    private int getUserIdFromArgsOrAllUsers() {
        if ("--user".equals(getNextArg()) == true) goto L5;
        return -1;
    L5:
        return UserHandle.parseUserArg(getNextArgRequired());
    }

    private int getNextIntArgRequired() {
        return Integer.parseInt(getNextArgRequired());
    }
}
