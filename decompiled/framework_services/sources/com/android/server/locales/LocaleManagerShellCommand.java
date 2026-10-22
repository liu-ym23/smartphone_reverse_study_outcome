package com.android.server.locales;

import android.app.ActivityManager;
import android.app.ILocaleManager;
import android.app.LocaleConfig;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.LocaleList;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.UserHandle;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class LocaleManagerShellCommand extends ShellCommand {
    private final ILocaleManager mBinderService;
    private final Context mContext;

    LocaleManagerShellCommand(ILocaleManager localeManager, Context context) {
        this.mBinderService = localeManager;
        this.mContext = context;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -843437997: goto L21;
            case -232514593: goto L18;
            case 819706294: goto L15;
            case 1730458818: goto L12;
            case 1797819257: goto L9;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return handleDefaultCommands(cmd);
    L28:
        return runGetAppLocaleConfigIgnoreOverride();
    L30:
        return runGetAppOverrideLocaleConfig();
    L32:
        return runSetAppOverrideLocaleConfig();
    L34:
        return runGetAppLocales();
    L36:
        return runSetAppLocales();
    L9:
        if (cmd.equals("get-app-localeconfig-ignore-override") == false) goto L23;
        r0 = 4;
        goto L24
    L12:
        if (cmd.equals("set-app-locales") == false) goto L23;
        r0 = 0;
        goto L24
    L15:
        if (cmd.equals("get-app-locales") == false) goto L23;
        r0 = 1;
        goto L24
    L18:
        if (cmd.equals("get-app-localeconfig") == false) goto L23;
        r0 = 3;
        goto L24
    L21:
        if (cmd.equals("set-app-localeconfig") == false) goto L23;
        r0 = 2;
        goto L24
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Locale manager (locale) shell commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  set-app-locales <PACKAGE_NAME> [--user <USER_ID>] [--locales <LOCALE_INFO>][--delegate <FROM_DELEGATE>]");
        pw.println("      Set the locales for the specified app.");
        pw.println("      --user <USER_ID>: apply for the given user, the current user is used when unspecified.");
        pw.println("      --locales <LOCALE_INFO>: The language tags of locale to be included as a single String separated by commas.");
        pw.println("                 eg. en,en-US,hi ");
        pw.println("                 Empty locale list is used when unspecified.");
        pw.println("      --delegate <FROM_DELEGATE>: The locales are set from a delegate, the value could be true or false. false is the default when unspecified.");
        pw.println("  get-app-locales <PACKAGE_NAME> [--user <USER_ID>]");
        pw.println("      Get the locales for the specified app.");
        pw.println("      --user <USER_ID>: get for the given user, the current user is used when unspecified.");
        pw.println("  set-app-localeconfig <PACKAGE_NAME> [--user <USER_ID>] [--locales <LOCALE_INFO>]");
        pw.println("      Set the override LocaleConfig for the specified app.");
        pw.println("      --user <USER_ID>: apply for the given user, the current user is used when unspecified.");
        pw.println("      --locales <LOCALE_INFO>: The language tags of locale to be included as a single String separated by commas.");
        pw.println("                 eg. en,en-US,hi ");
        pw.println("                 Empty locale list is used when typing a 'empty' word");
        pw.println("                 NULL is used when unspecified.");
        pw.println("  get-app-localeconfig <PACKAGE_NAME> [--user <USER_ID>]");
        pw.println("      Get the locales within the override LocaleConfig for the specified app.");
        pw.println("      --user <USER_ID>: get for the given user, the current user is used when unspecified.");
    }

    private int runSetAppLocales() {
        PrintWriter err = getErrPrintWriter();
        String packageName = getNextArg();
        if (packageName == null) goto L37;
        int userId = ActivityManager.getCurrentUser();
        LocaleList locales = LocaleList.getEmptyLocaleList();
        boolean fromDelegate = false;
    L5:
        String option = getNextOption();
        byte r7 = 0;
        if (option != null) goto L18;
        this.mBinderService.setApplicationLocales(packageName, userId, locales, fromDelegate);     // Catch: IllegalArgumentException -> L9 RemoteException -> L11
    L16:
        return 0;
    L11:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
    L13:
        getOutPrintWriter().println("Unknown package " + packageName + " for userId " + userId);
        goto L16
    L18:
        switch(option.hashCode()) {
            case 835076901: goto L27;
            case 1333469547: goto L24;
            case 1724392377: goto L21;
            default: goto L29;
        };
    L29:
        r7 = -1;
    L30:
        switch(r7) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            default: goto L32;
        };
    L32:
        throw new IllegalArgumentException("Unknown option: " + option);
    L34:
        locales = parseLocales();
        goto L5
    L35:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L5
    L33:
        fromDelegate = parseFromDelegate();
        goto L5
    L21:
        if (option.equals("--locales") == false) goto L49;
        r7 = 1;
        goto L30
    L49:
        r7 = -1;
        goto L30
    L24:
        if (option.equals("--user") == true) goto L30;
        r7 = -1;
        goto L30
    L27:
        if (option.equals("--delegate") == false) goto L51;
        r7 = 2;
        goto L30
    L51:
        r7 = -1;
        goto L30
    L37:
        err.println("Error: no package specified");
        return -1;
    }

    private int runGetAppLocales() {
        PrintWriter err = getErrPrintWriter();
        String packageName = getNextArg();
        if (packageName == null) goto L22;
        int userId = ActivityManager.getCurrentUser();
        String option = getNextOption();
        if (option != null) goto L8;
    L24:
        LocaleList locales = this.mBinderService.getApplicationLocales(packageName, userId);     // Catch: IllegalArgumentException -> L12 RemoteException -> L14
        getOutPrintWriter().println("Locales for " + packageName + " for user " + userId + " are [" + locales.toLanguageTags() + "]");     // Catch: IllegalArgumentException -> L12 RemoteException -> L14
        goto L16
    L26:
        return 0;
    L14:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
        return 0;
    L16:
        getOutPrintWriter().println("Unknown package " + packageName + " for userId " + userId);
        return 0;
    L8:
        if ("--user".equals(option) == false) goto L21;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L24
    L21:
        throw new IllegalArgumentException("Unknown option: " + option);
    L22:
        err.println("Error: no package specified");
        return -1;
    }

    private int runSetAppOverrideLocaleConfig() {
        String packageName = getNextArg();
        if (packageName == null) goto L32;
        int userId = ActivityManager.getCurrentUser();
        LocaleList locales = null;
    L5:
        String option = getNextOption();
        byte r5 = 0;
        if (option == null) goto L7;
        switch(option.hashCode()) {
            case 1333469547: goto L23;
            case 1724392377: goto L20;
            default: goto L25;
        };
    L25:
        r5 = -1;
    L26:
        switch(r5) {
            case 0: goto L30;
            case 1: goto L29;
            default: goto L28;
        };
    L28:
        throw new IllegalArgumentException("Unknown option: " + option);
    L30:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L5
    L29:
        locales = parseOverrideLocales();
        goto L5
    L20:
        if (option.equals("--locales") == false) goto L43;
        r5 = 1;
        goto L26
    L43:
        r5 = -1;
        goto L26
    L23:
        if (option.equals("--user") == true) goto L26;
        r5 = -1;
        goto L26
    L7:
        if (locales != null) goto L34;
        LocaleConfig localeConfig = null;
    L10:
        this.mBinderService.setOverrideLocaleConfig(packageName, userId, localeConfig);     // Catch: RemoteException -> L12
    L15:
        return 0;
    L12:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
        goto L15
    L34:
        localeConfig = new LocaleConfig(locales);     // Catch: RemoteException -> L12
        goto L10
    L32:
        PrintWriter err = getErrPrintWriter();
        err.println("Error: no package specified");
        return -1;
    }

    private int runGetAppOverrideLocaleConfig() {
        String packageName = getNextArg();
        if (packageName == null) goto L27;
        int userId = ActivityManager.getCurrentUser();
        String option = getNextOption();
        if (option != null) goto L8;
    L29:
        LocaleConfig localeConfig = this.mBinderService.getOverrideLocaleConfig(packageName, userId);     // Catch: RemoteException -> L14
        if (localeConfig != null) goto L16;
        getOutPrintWriter().println("LocaleConfig for " + packageName + " for user " + userId + " is null");     // Catch: RemoteException -> L14
        return 0;
    L16:
        LocaleList locales = localeConfig.getSupportedLocales();     // Catch: RemoteException -> L14
        if (locales != null) goto L20;
        getOutPrintWriter().println("Locales within the LocaleConfig for " + packageName + " for user " + userId + " are null");     // Catch: RemoteException -> L14
        return 0;
    L20:
        getOutPrintWriter().println("Locales within the LocaleConfig for " + packageName + " for user " + userId + " are [" + locales.toLanguageTags() + "]");     // Catch: RemoteException -> L14
        return 0;
    L14:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
        return 0;
    L8:
        if ("--user".equals(option) == false) goto L26;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L29
    L26:
        throw new IllegalArgumentException("Unknown option: " + option);
    L27:
        PrintWriter err = getErrPrintWriter();
        err.println("Error: no package specified");
        return -1;
    }

    private int runGetAppLocaleConfigIgnoreOverride() {
        String packageName = getNextArg();
        PrintWriter err = getErrPrintWriter();
        if (packageName == null) goto L25;
        int userId = ActivityManager.getCurrentUser();
        String option = getNextOption();
        if (option == null) goto L27;
        if ("--user".equals(option) == false) goto L24;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L27
    L24:
        throw new IllegalArgumentException("Unknown option: " + option);
    L27:
        LocaleConfig resLocaleConfig = LocaleConfig.fromContextIgnoringOverride(this.mContext.createPackageContextAsUser(packageName, 0, UserHandle.of(userId)));     // Catch: PackageManager.NameNotFoundException -> L20
        if (resLocaleConfig != null) goto L14;
        getOutPrintWriter().println("LocaleConfig for " + packageName + " for user " + userId + " is null");
    L19:
        return 0;
    L14:
        LocaleList locales = resLocaleConfig.getSupportedLocales();
        if (locales != null) goto L17;
        getOutPrintWriter().println("Locales within the LocaleConfig for " + packageName + " for user " + userId + " are null");
        goto L19
    L17:
        getOutPrintWriter().println("Locales within the LocaleConfig for " + packageName + " for user " + userId + " are [" + locales.toLanguageTags() + "]");
    L21:
        err.println("Unknown package name " + packageName + " for user " + userId);
        return -1;
    L25:
        err.println("Error: no package specified");
        return -1;
    }

    private LocaleList parseOverrideLocales() {
        String locales = getNextArg();
        if (locales != null) goto L7;
        return null;
    L7:
        if (locales.equals("empty") == false) goto L11;
        return LocaleList.getEmptyLocaleList();
    L11:
        if (locales.startsWith("-") == true) goto L15;
        return LocaleList.forLanguageTags(locales);
    L15:
        throw new IllegalArgumentException("Unknown locales: " + locales);
    }

    private LocaleList parseLocales() {
        String locales = getNextArg();
        if (locales != null) goto L7;
        return LocaleList.getEmptyLocaleList();
    L7:
        if (locales.startsWith("-") == true) goto L11;
        return LocaleList.forLanguageTags(locales);
    L11:
        throw new IllegalArgumentException("Unknown locales: " + locales);
    }

    private boolean parseFromDelegate() {
        String result = getNextArg();
        if (result != null) goto L7;
        return false;
    L7:
        if (result.startsWith("-") == true) goto L11;
        return Boolean.parseBoolean(result);
    L11:
        throw new IllegalArgumentException("Unknown source: " + result);
    }
}
