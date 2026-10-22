package com.android.server.app;

import android.app.ActivityManager;
import android.app.IGameManagerService;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringJoiner;

/* JADX INFO: loaded from: classes.dex */
public class GameManagerShellCommand extends ShellCommand {
    private static final String BATTERY_MODE_NUM = "3";
    private static final String BATTERY_MODE_STR = "battery";
    private static final String CUSTOM_MODE_NUM = "4";
    private static final String CUSTOM_MODE_STR = "custom";
    private static final String PERFORMANCE_MODE_NUM = "2";
    private static final String PERFORMANCE_MODE_STR = "performance";
    private static final String STANDARD_MODE_NUM = "1";
    private static final String STANDARD_MODE_STR = "standard";
    private static final String UNSUPPORTED_MODE_NUM = null;
    private static final String UNSUPPORTED_MODE_STR = "unsupported";
    private PackageManager mPackageManager;

    static {
        UNSUPPORTED_MODE_NUM = String.valueOf(0);
    }

    public GameManagerShellCommand(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Error: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1207633086: goto L24;
            case -729460415: goto L21;
            case 113762: goto L18;
            case 3357091: goto L15;
            case 108404047: goto L10;
            default: goto L26;
        };     // Catch: Exception -> L12
    L26:
        byte r2 = -1;
    L27:
        switch(r2) {
            case 0: goto L39;
            case 1: goto L37;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            default: goto L29;
        };     // Catch: Exception -> L12
    L29:
        return handleDefaultCommands(cmd);
    L31:
        return runListGameModeConfigs(pw);
    L33:
        return runListGameModes(pw);
    L35:
        return runSetGameMode(pw);
    L37:
        return runResetGameModeConfig(pw);
    L39:
        return runSetGameModeConfig(pw);
    L10:
        if (cmd.equals("reset") == false) goto L26;
        r2 = 1;
        goto L27
    L15:
        if (cmd.equals("mode") == false) goto L26;
        r2 = 2;
        goto L27
    L18:
        if (cmd.equals("set") == false) goto L26;
        r2 = 0;
        goto L27
    L21:
        if (cmd.equals("list-modes") == false) goto L26;
        r2 = 3;
        goto L27
    L24:
        if (cmd.equals("list-configs") == false) goto L26;
        r2 = 4;
        goto L27
    L4:
        return handleDefaultCommands(cmd);
    }

    private boolean isPackageGame(String packageName, int userId, PrintWriter pw) {
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfoAsUser(packageName, 131072, userId);     // Catch: PackageManager.NameNotFoundException -> L10
        if (applicationInfo.category != 0) goto L6;
        boolean isGame = true;
    L7:
        if (isGame == true) goto L12;
        pw.println("Package " + packageName + " is not of game type, to use the game mode commands, it must specify game category in the manifest as android:appCategory=\"game\"");     // Catch: PackageManager.NameNotFoundException -> L10
    L12:
        return isGame;
    L6:
        isGame = false;
    L13:
        pw.println("Package " + packageName + " is not found for user " + userId);
        return false;
    }

    private int runListGameModes(PrintWriter pw) throws ServiceManager.ServiceNotFoundException, RemoteException {
        String packageName = getNextArgRequired();
        int userId = ActivityManager.getCurrentUser();
        if (isPackageGame(packageName, userId, pw) == true) goto L6;
        return -1;
    L6:
        GameManagerService gameManagerService = (GameManagerService) ServiceManager.getService("game");
        String currentMode = gameModeIntToString(gameManagerService.getGameMode(packageName, userId));
        StringJoiner sj = new StringJoiner(",");
        int[] r5 = gameManagerService.getAvailableGameModes(packageName, userId);
        int r6 = r5.length;
        int r8 = 0;
    L7:
        if (r8 >= r6) goto L9;
        int mode = r5[r8];
        sj.add(gameModeIntToString(mode));
        r8 = r8 + 1;
        goto L7
    L9:
        pw.println(packageName + " current mode: " + currentMode + ", available game modes: [" + sj + "]");
        return 0;
    }

    private int runListGameModeConfigs(PrintWriter pw) throws ServiceManager.ServiceNotFoundException, RemoteException {
        String packageName = getNextArgRequired();
        int userId = ActivityManager.getCurrentUser();
        if (isPackageGame(packageName, userId, pw) == true) goto L6;
        return -1;
    L6:
        GameManagerService gameManagerService = (GameManagerService) ServiceManager.getService("game");
        String listStr = gameManagerService.getInterventionList(packageName, userId);
        if (listStr != null) goto L9;
        pw.println("No interventions found for " + packageName);
        return 0;
    L9:
        pw.println(packageName + " interventions: " + listStr);
        return 0;
    }

    private int runSetGameMode(PrintWriter pw) throws ServiceManager.ServiceNotFoundException, RemoteException {
        String option = getNextOption();
        String userIdStr = null;
        if (option != null) goto L5;
    L7:
        String gameMode = getNextArgRequired();
        String packageName = getNextArgRequired();
        if (userIdStr == null) goto L10;
        int userId = Integer.parseInt(userIdStr);
    L11:
        int r8 = -1;
        if (isPackageGame(packageName, userId, pw) == true) goto L14;
        return -1;
    L14:
        IGameManagerService service = IGameManagerService.Stub.asInterface(ServiceManager.getServiceOrThrow("game"));
        boolean batteryModeSupported = false;
        boolean perfModeSupported = false;
        int[] modes = service.getAvailableGameModes(packageName, userId);
        int r12 = modes.length;
        int r14 = 0;
    L15:
        int r16 = r8;
        if (r14 >= r12) goto L23;
        int mode = modes[r14];
        if (mode != 2) goto L20;
        perfModeSupported = true;
    L22:
        r14 = r14 + 1;
        r8 = r16;
        goto L15
    L20:
        if (mode != 3) goto L22;
        batteryModeSupported = true;
        goto L22
    L23:
        String r13 = gameMode.toLowerCase();
        switch(r13.hashCode()) {
            case -1480388560: goto L48;
            case -1349088399: goto L45;
            case -331239923: goto L42;
            case 49: goto L39;
            case 50: goto L36;
            case 51: goto L33;
            case 52: goto L30;
            case 1312628413: goto L27;
            default: goto L50;
        };
    L50:
        int r15 = r16;
    L52:
        switch(r15) {
            case 0: goto L64;
            case 1: goto L64;
            case 2: goto L60;
            case 3: goto L60;
            case 4: goto L56;
            case 5: goto L56;
            case 6: goto L55;
            case 7: goto L55;
            default: goto L53;
        };
    L53:
        pw.println("Invalid game mode: " + gameMode);
        return r16;
    L55:
        service.setGameMode(packageName, 4, userId);
        pw.println("Set game mode to `CUSTOM` for user `" + userId + "` in game `" + packageName + "`");
    L65:
        return 0;
    L56:
        if (batteryModeSupported == false) goto L58;
        service.setGameMode(packageName, 3, userId);
        pw.println("Set game mode to `BATTERY` for user `" + userId + "` in game `" + packageName + "`");
        goto L65
    L58:
        pw.println("Game mode: " + gameMode + " not supported by " + packageName);
        return r16;
    L60:
        if (perfModeSupported == false) goto L62;
        service.setGameMode(packageName, 2, userId);
        pw.println("Set game mode to `PERFORMANCE` for user `" + userId + "` in game `" + packageName + "`");
        goto L65
    L62:
        pw.println("Game mode: " + gameMode + " not supported by " + packageName);
        return r16;
    L64:
        service.setGameMode(packageName, 1, userId);
        pw.println("Set game mode to `STANDARD` for user `" + userId + "` in game `" + packageName + "`");
        goto L65
    L27:
        if (r13.equals(STANDARD_MODE_STR) == false) goto L70;
        r15 = 1;
        goto L52
    L70:
        r15 = r16;
        goto L52
    L30:
        if (r13.equals(CUSTOM_MODE_NUM) == false) goto L71;
        r15 = 6;
        goto L52
    L71:
        r15 = r16;
        goto L52
    L33:
        if (r13.equals(BATTERY_MODE_NUM) == false) goto L72;
        r15 = 4;
        goto L52
    L72:
        r15 = r16;
        goto L52
    L36:
        if (r13.equals(PERFORMANCE_MODE_NUM) == false) goto L73;
        r15 = 2;
        goto L52
    L73:
        r15 = r16;
        goto L52
    L39:
        if (r13.equals(STANDARD_MODE_NUM) == false) goto L74;
        r15 = 0;
        goto L52
    L74:
        r15 = r16;
        goto L52
    L42:
        if (r13.equals(BATTERY_MODE_STR) == false) goto L75;
        r15 = 5;
        goto L52
    L75:
        r15 = r16;
        goto L52
    L45:
        if (r13.equals(CUSTOM_MODE_STR) == false) goto L76;
        r15 = 7;
        goto L52
    L76:
        r15 = r16;
        goto L52
    L48:
        if (r13.equals(PERFORMANCE_MODE_STR) == false) goto L77;
        r15 = 3;
        goto L52
    L77:
        r15 = r16;
        goto L52
    L10:
        userId = ActivityManager.getCurrentUser();
        goto L11
    L5:
        if (option.equals("--user") == false) goto L7;
        userIdStr = getNextArgRequired();
        goto L7
    }

    private int runSetGameModeConfig(PrintWriter pw) throws ServiceManager.ServiceNotFoundException, RemoteException {
        String fpsStr = null;
        String downscaleRatio = null;
        int gameMode = 4;
        String fpsStr2 = null;
    L3:
        String option = getNextOption();
        byte r9 = 0;
        if (option == null) goto L51;
        switch(option.hashCode()) {
            case 43000649: goto L18;
            case 1333227331: goto L15;
            case 1333469547: goto L12;
            case 1807206472: goto L9;
            default: goto L20;
        };
    L20:
        r9 = -1;
    L22:
        switch(r9) {
            case 0: goto L49;
            case 1: goto L45;
            case 2: goto L34;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        pw.println("Invalid option '" + option + "'");
        return -1;
    L34:
        if (downscaleRatio != null) goto L43;
        String downscaleRatio2 = getNextArgRequired();
        if ("disable".equals(downscaleRatio2) == true) goto L37;
        Float.parseFloat(downscaleRatio2);     // Catch: NumberFormatException -> L40
        downscaleRatio = downscaleRatio2;
    L41:
        pw.println("Invalid scaling ratio '" + downscaleRatio2 + "'");
        return -1;
    L37:
        downscaleRatio = "-1";
        goto L3
    L43:
        pw.println("Duplicate option '" + option + "'");
        return -1;
    L45:
        if (fpsStr2 != null) goto L47;
        fpsStr2 = getNextArgRequired();
        goto L3
    L47:
        pw.println("Duplicate option '" + option + "'");
        return -1;
    L49:
        int gameMode2 = Integer.parseInt(getNextArgRequired());
        gameMode = gameMode2;
        goto L3
    L25:
        if (fpsStr != null) goto L32;
        String fpsStr3 = getNextArgRequired();
        Integer.parseInt(fpsStr3);     // Catch: NumberFormatException -> L29
        fpsStr = fpsStr3;
    L30:
        pw.println("Invalid frame rate: '" + fpsStr3 + "'");
        return -1;
    L32:
        pw.println("Duplicate option '" + option + "'");
        return -1;
    L9:
        if (option.equals("--downscale") == false) goto L84;
        r9 = 2;
        goto L22
    L84:
        r9 = -1;
        goto L22
    L12:
        if (option.equals("--user") == false) goto L85;
        r9 = 1;
        goto L22
    L85:
        r9 = -1;
        goto L22
    L15:
        if (option.equals("--mode") == true) goto L22;
        r9 = -1;
        goto L22
    L18:
        if (option.equals("--fps") == false) goto L87;
        r9 = 3;
        goto L22
    L87:
        r9 = -1;
        goto L22
    L51:
        String packageName = getNextArgRequired();
        if (fpsStr2 == null) goto L54;
        int userId = Integer.parseInt(fpsStr2);
    L56:
        if (isPackageGame(packageName, userId, pw) == true) goto L58;
        return -1;
    L58:
        GameManagerService gameManagerService = (GameManagerService) ServiceManager.getService("game");
        if (gameManagerService != null) goto L62;
        pw.println("Failed to find GameManagerService on device");
        return -1;
    L62:
        gameManagerService.setGameModeConfigOverride(packageName, userId, gameMode, fpsStr, downscaleRatio);
        pw.println("Set custom mode intervention config for user `" + userId + "` in game `" + packageName + "` as: `downscaling-ratio: " + downscaleRatio + ";fps-override: " + fpsStr + "`");
        return 0;
    L54:
        userId = ActivityManager.getCurrentUser();
        goto L56
    }

    private int runResetGameModeConfig(PrintWriter pw) throws ServiceManager.ServiceNotFoundException, RemoteException {
        String gameMode = null;
        String userIdStr = null;
    L3:
        String option = getNextOption();
        byte r4 = 1;
        if (option == null) goto L28;
        switch(option.hashCode()) {
            case 1333227331: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L16:
        switch(r4) {
            case 0: goto L23;
            case 1: goto L19;
            default: goto L17;
        };
    L17:
        pw.println("Invalid option '" + option + "'");
        return -1;
    L23:
        if (userIdStr != null) goto L26;
        userIdStr = getNextArgRequired();
        goto L3
    L26:
        pw.println("Duplicate option '" + option + "'");
        return -1;
    L19:
        if (gameMode != null) goto L21;
        gameMode = getNextArgRequired();
        goto L3
    L21:
        pw.println("Duplicate option '" + option + "'");
        return -1;
    L9:
        if (option.equals("--user") == false) goto L70;
        r4 = 0;
        goto L16
    L70:
        r4 = -1;
        goto L16
    L12:
        if (option.equals("--mode") == true) goto L16;
        r4 = -1;
        goto L16
    L28:
        String packageName = getNextArgRequired();
        if (userIdStr == null) goto L31;
        int userId = Integer.parseInt(userIdStr);
    L33:
        if (isPackageGame(packageName, userId, pw) == true) goto L35;
        return -1;
    L35:
        GameManagerService gameManagerService = (GameManagerService) ServiceManager.getService("game");
        if (gameMode != null) goto L39;
        gameManagerService.resetGameModeConfigOverride(packageName, userId, -1);
        return 0;
    L39:
        String r9 = gameMode.toLowerCase(Locale.getDefault());
        switch(r9.hashCode()) {
            case -1480388560: goto L52;
            case -331239923: goto L49;
            case 50: goto L46;
            case 51: goto L43;
            default: goto L54;
        };
    L54:
        r4 = -1;
    L55:
        switch(r4) {
            case 0: goto L59;
            case 1: goto L59;
            case 2: goto L58;
            case 3: goto L58;
            default: goto L56;
        };
    L56:
        pw.println("Invalid game mode: " + gameMode);
        return -1;
    L58:
        gameManagerService.resetGameModeConfigOverride(packageName, userId, 3);
    L60:
        return 0;
    L59:
        gameManagerService.resetGameModeConfigOverride(packageName, userId, 2);
        goto L60
    L43:
        if (r9.equals(BATTERY_MODE_NUM) == false) goto L72;
        r4 = 2;
        goto L55
    L72:
        r4 = -1;
        goto L55
    L46:
        if (r9.equals(PERFORMANCE_MODE_NUM) == false) goto L73;
        r4 = 0;
        goto L55
    L73:
        r4 = -1;
        goto L55
    L49:
        if (r9.equals(BATTERY_MODE_STR) == false) goto L74;
        r4 = 3;
        goto L55
    L74:
        r4 = -1;
        goto L55
    L52:
        if (r9.equals(PERFORMANCE_MODE_STR) == true) goto L55;
        r4 = -1;
        goto L55
    L31:
        userId = ActivityManager.getCurrentUser();
        goto L33
    }

    private static String gameModeIntToString(int gameMode) {
        switch(gameMode) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return "";
    L5:
        return CUSTOM_MODE_STR;
    L7:
        return BATTERY_MODE_STR;
    L9:
        return PERFORMANCE_MODE_STR;
    L11:
        return STANDARD_MODE_STR;
    L13:
        return UNSUPPORTED_MODE_STR;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Game manager (game) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  downscale");
        pw.println("      Deprecated. Please use `custom` command.");
        pw.println("  list-configs <PACKAGE_NAME>");
        pw.println("      Lists the current intervention configs of an app.");
        pw.println("  list-modes <PACKAGE_NAME>");
        pw.println("      Lists the current selected and available game modes of an app.");
        pw.println("  mode [--user <USER_ID>] [1|2|3|4|standard|performance|battery|custom] <PACKAGE_NAME>");
        pw.println("      Set app to run in the specified game mode, if supported.");
        pw.println("      --user <USER_ID>: apply for the given user,");
        pw.println("                        the current user is used when unspecified.");
        pw.println("  set [intervention configs] <PACKAGE_NAME>");
        pw.println("      Set app to run at custom mode using provided intervention configs");
        pw.println("      Intervention configs consists of:");
        pw.println("      --downscale [0.3|0.35|0.4|0.45|0.5|0.55|0.6|0.65");
        pw.println("                  |0.7|0.75|0.8|0.85|0.9|disable]: Set app to run at the");
        pw.println("                                                   specified scaling ratio.");
        pw.println("      --fps: Integer value to set app to run at the specified fps,");
        pw.println("             if supported. 0 to disable.");
        pw.println("  reset [--mode [2|3|performance|battery] --user <USER_ID>] <PACKAGE_NAME>");
        pw.println("      Resets the game mode of the app to device configuration.");
        pw.println("      This should only be used to reset any override to non custom game mode");
        pw.println("      applied using the deprecated `set` command");
        pw.println("      --mode [2|3|performance|battery]: apply for the given mode,");
        pw.println("                                        resets all modes when unspecified.");
        pw.println("      --user <USER_ID>: apply for the given user,");
        pw.println("                        the current user is used when unspecified.");
    }
}
