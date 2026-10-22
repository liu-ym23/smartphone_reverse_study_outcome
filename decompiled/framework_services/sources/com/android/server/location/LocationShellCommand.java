package com.android.server.location;

import android.content.Context;
import android.location.Location;
import android.location.provider.ProviderProperties;
import android.os.SystemClock;
import android.os.UserHandle;
import com.android.modules.utils.BasicShellCommandHandler;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class LocationShellCommand extends BasicShellCommandHandler {
    private static final float DEFAULT_TEST_LOCATION_ACCURACY = 100.0f;
    private final Context mContext;
    private final LocationManagerService mService;

    LocationShellCommand(Context context, LocationManagerService service) {
        this.mContext = context;
        service.getClass();
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(null);
    L6:
        switch(cmd.hashCode()) {
            case -1064420500: goto L27;
            case -547571550: goto L24;
            case -444268534: goto L21;
            case -361391806: goto L18;
            case -84945726: goto L15;
            case 1546249012: goto L12;
            case 1640843002: goto L9;
            default: goto L29;
        };
    L29:
        byte r0 = -1;
    L30:
        switch(r0) {
            case 0: goto L45;
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            default: goto L32;
        };
    L33:
        String command = getNextArgRequired();
        return parseProvidersCommand(command);
    L35:
        handleIsAutomotiveGnssSuspended();
        return 0;
    L37:
        handleSetAutomotiveGnssSuspended();
        return 0;
    L39:
        handleSetAdasGnssLocationEnabled();
        return 0;
    L41:
        handleIsAdasGnssLocationEnabled();
        return 0;
    L43:
        handleSetLocationEnabled();
        return 0;
    L45:
        handleIsLocationEnabled();
        return 0;
    L32:
        return handleDefaultCommands(cmd);
    L9:
        if (cmd.equals("is-adas-gnss-location-enabled") == false) goto L29;
        r0 = 2;
        goto L30
    L12:
        if (cmd.equals("set-location-enabled") == false) goto L29;
        r0 = 1;
        goto L30
    L15:
        if (cmd.equals("set-adas-gnss-location-enabled") == false) goto L29;
        r0 = 3;
        goto L30
    L18:
        if (cmd.equals("set-automotive-gnss-suspended") == false) goto L29;
        r0 = 4;
        goto L30
    L21:
        if (cmd.equals("is-automotive-gnss-suspended") == false) goto L29;
        r0 = 5;
        goto L30
    L24:
        if (cmd.equals("providers") == false) goto L29;
        r0 = 6;
        goto L30
    L27:
        if (cmd.equals("is-location-enabled") == false) goto L29;
        r0 = 0;
        goto L30
    }

    private int parseProvidersCommand(String cmd) {
        switch(cmd.hashCode()) {
            case -1669563581: goto L18;
            case -1650104991: goto L15;
            case -61579243: goto L12;
            case 11404448: goto L9;
            case 2036447497: goto L6;
            default: goto L20;
        };
    L20:
        byte r0 = -1;
    L21:
        switch(r0) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L24;
            default: goto L23;
        };
    L24:
        handleSendExtraCommand();
        return 0;
    L26:
        handleSetTestProviderLocation();
        return 0;
    L28:
        handleSetTestProviderEnabled();
        return 0;
    L30:
        handleRemoveTestProvider();
        return 0;
    L32:
        handleAddTestProvider();
        return 0;
    L23:
        return handleDefaultCommands(cmd);
    L6:
        if (cmd.equals("send-extra-command") == false) goto L20;
        r0 = 4;
        goto L21
    L9:
        if (cmd.equals("add-test-provider") == false) goto L20;
        r0 = 0;
        goto L21
    L12:
        if (cmd.equals("set-test-provider-enabled") == false) goto L20;
        r0 = 2;
        goto L21
    L15:
        if (cmd.equals("set-test-provider-location") == false) goto L20;
        r0 = 3;
        goto L21
    L18:
        if (cmd.equals("remove-test-provider") == false) goto L20;
        r0 = 1;
        goto L21
    }

    private void handleIsLocationEnabled() {
        int userId = -3;
    L3:
        String option = getNextOption();
        if (option == null) goto L5;
        if ("--user".equals(option) == false) goto L11;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L11:
        throw new IllegalArgumentException("Unknown option: " + option);
    L5:
        getOutPrintWriter().println(this.mService.isLocationEnabledForUser(userId));
    }

    private void handleSetLocationEnabled() {
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());
        int userId = -3;
    L3:
        String option = getNextOption();
        if (option == null) goto L5;
        if ("--user".equals(option) == false) goto L11;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L11:
        throw new IllegalArgumentException("Unknown option: " + option);
    L5:
        this.mService.setLocationEnabledForUser(enabled, userId);
    }

    private void handleIsAdasGnssLocationEnabled() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L15;
        int userId = -3;
    L5:
        String option = getNextOption();
        if (option == null) goto L7;
        if ("--user".equals(option) == false) goto L13;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L5
    L13:
        throw new IllegalArgumentException("Unknown option: " + option);
    L7:
        getOutPrintWriter().println(this.mService.isAdasGnssLocationEnabledForUser(userId));
        return;
    L15:
        throw new IllegalStateException("command only recognized on automotive devices");
    }

    private void handleSetAdasGnssLocationEnabled() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L15;
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());
        int userId = -3;
    L5:
        String option = getNextOption();
        if (option == null) goto L7;
        if ("--user".equals(option) == false) goto L13;
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L5
    L13:
        throw new IllegalArgumentException("Unknown option: " + option);
    L7:
        this.mService.setAdasGnssLocationEnabledForUser(enabled, userId);
        return;
    L15:
        throw new IllegalStateException("command only recognized on automotive devices");
    }

    private void handleSetAutomotiveGnssSuspended() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L7;
        boolean suspended = Boolean.parseBoolean(getNextArgRequired());
        this.mService.setAutomotiveGnssSuspended(suspended);
        return;
    L7:
        throw new IllegalStateException("command only recognized on automotive devices");
    }

    private void handleIsAutomotiveGnssSuspended() {
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L7;
        getOutPrintWriter().println(this.mService.isAutomotiveGnssSuspended());
        return;
    L7:
        throw new IllegalStateException("command only recognized on automotive devices");
    }

    private void handleAddTestProvider() {
        String provider = getNextArgRequired();
        boolean supportsSpeed = false;
        boolean supportsBearing = false;
        int powerRequirement = 1;
        int accuracy = 1;
        boolean supportsSpeed2 = false;
        boolean supportsBearing2 = false;
        boolean requiresCell = false;
        boolean hasMonetaryCost = false;
        List<String> extraAttributionTags = Collections.emptyList();
        boolean supportsAltitude = false;
    L3:
        String option = getNextOption();
        if (option == null) goto L5;
        switch(option.hashCode()) {
            case -2115952999: goto L38;
            case -1786843904: goto L35;
            case -1474799448: goto L32;
            case -1446936854: goto L29;
            case -1194644762: goto L26;
            case 1086076880: goto L23;
            case 1279633236: goto L20;
            case 1483009933: goto L17;
            case 1601002398: goto L14;
            case 2048042627: goto L11;
            default: goto L40;
        };
    L40:
        byte r2 = -1;
    L41:
        switch(r2) {
            case 0: goto L53;
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            case 9: goto L44;
            default: goto L43;
        };
    L43:
        throw new IllegalArgumentException("Received unexpected option: " + option);
    L45:
        int accuracy2 = Integer.parseInt(getNextArgRequired());
        accuracy = accuracy2;
        goto L3
    L46:
        int powerRequirement2 = Integer.parseInt(getNextArgRequired());
        powerRequirement = powerRequirement2;
        goto L3
    L47:
        supportsBearing = true;
        goto L3
    L48:
        supportsSpeed = true;
        goto L3
    L49:
        supportsAltitude = true;
        goto L3
    L50:
        hasMonetaryCost = true;
        goto L3
    L51:
        requiresCell = true;
        goto L3
    L52:
        supportsBearing2 = true;
        goto L3
    L53:
        supportsSpeed2 = true;
        goto L3
    L44:
        List<String> extraAttributionTags2 = Arrays.asList(getNextArgRequired().split(","));
        extraAttributionTags = extraAttributionTags2;
        goto L3
    L11:
        if (option.equals("--supportsSpeed") == false) goto L40;
        r2 = 5;
        goto L41
    L14:
        if (option.equals("--powerRequirement") == false) goto L40;
        r2 = 7;
        goto L41
    L17:
        if (option.equals("--requiresSatellite") == false) goto L40;
        r2 = 1;
        goto L41
    L20:
        if (option.equals("--hasMonetaryCost") == false) goto L40;
        r2 = 3;
        goto L41
    L23:
        if (option.equals("--requiresCell") == false) goto L40;
        r2 = 2;
        goto L41
    L26:
        if (option.equals("--supportsAltitude") == false) goto L40;
        r2 = 4;
        goto L41
    L29:
        if (option.equals("--supportsBearing") == false) goto L40;
        r2 = 6;
        goto L41
    L32:
        if (option.equals("--extraAttributionTags") == false) goto L40;
        r2 = 9;
        goto L41
    L35:
        if (option.equals("--requiresNetwork") == false) goto L40;
        r2 = 0;
        goto L41
    L38:
        if (option.equals("--accuracy") == false) goto L40;
        r2 = 8;
        goto L41
    L5:
        ProviderProperties properties = new ProviderProperties.Builder().setHasNetworkRequirement(supportsSpeed2).setHasSatelliteRequirement(supportsBearing2).setHasCellRequirement(requiresCell).setHasMonetaryCost(hasMonetaryCost).setHasAltitudeSupport(supportsAltitude).setHasSpeedSupport(supportsSpeed).setHasBearingSupport(supportsBearing).setPowerUsage(powerRequirement).setAccuracy(accuracy).build();
        this.mService.addTestProvider(provider, properties, extraAttributionTags, this.mContext.getOpPackageName(), this.mContext.getAttributionTag());
    }

    private void handleRemoveTestProvider() {
        String provider = getNextArgRequired();
        this.mService.removeTestProvider(provider, this.mContext.getOpPackageName(), this.mContext.getAttributionTag());
    }

    private void handleSetTestProviderEnabled() {
        String provider = getNextArgRequired();
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());
        this.mService.setTestProviderEnabled(provider, enabled, this.mContext.getOpPackageName(), this.mContext.getAttributionTag());
    }

    private void handleSetTestProviderLocation() {
        String provider = getNextArgRequired();
        boolean hasLatLng = false;
        Location location = new Location(provider);
        location.setAccuracy(DEFAULT_TEST_LOCATION_ACCURACY);
        location.setTime(System.currentTimeMillis());
        location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
    L3:
        String option = getNextOption();
        if (option == null) goto L5;
        switch(option.hashCode()) {
            case -2115952999: goto L20;
            case 1333430381: goto L17;
            case 1916798293: goto L14;
            default: goto L22;
        };
    L22:
        byte r4 = -1;
    L23:
        switch(r4) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            default: goto L25;
        };
    L25:
        throw new IllegalArgumentException("Unknown option: " + option);
    L27:
        location.setAccuracy(Float.parseFloat(getNextArgRequired()));
        goto L3
    L28:
        String[] locationInput = getNextArgRequired().split(",");
        if (locationInput.length != 2) goto L33;
        location.setLatitude(Double.parseDouble(locationInput[0]));
        location.setLongitude(Double.parseDouble(locationInput[1]));
        hasLatLng = true;
        goto L3
    L33:
        throw new IllegalArgumentException("Location argument must be in the form of \"<LATITUDE>,<LONGITUDE>\", not " + Arrays.toString(locationInput));
    L26:
        location.setTime(Long.parseLong(getNextArgRequired()));
        goto L3
    L14:
        if (option.equals("--location") == false) goto L22;
        r4 = 0;
        goto L23
    L17:
        if (option.equals("--time") == false) goto L22;
        r4 = 2;
        goto L23
    L20:
        if (option.equals("--accuracy") == false) goto L22;
        r4 = 1;
        goto L23
    L5:
        if (hasLatLng == false) goto L9;
        this.mService.setTestProviderLocation(provider, location, this.mContext.getOpPackageName(), this.mContext.getAttributionTag());
        return;
    L9:
        throw new IllegalArgumentException("Option \"--location\" is required");
    }

    private void handleSendExtraCommand() {
        String provider = getNextArgRequired();
        String command = getNextArgRequired();
        this.mService.sendExtraCommand(provider, command, null);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Location service commands:");
        pw.println("  help or -h");
        pw.println("    Print this help text.");
        pw.println("  is-location-enabled [--user <USER_ID>]");
        pw.println("    Gets the master location switch enabled state. If no user is specified,");
        pw.println("    the current user is assumed.");
        pw.println("  set-location-enabled true|false [--user <USER_ID>]");
        pw.println("    Sets the master location switch enabled state. If no user is specified,");
        pw.println("    the current user is assumed.");
        if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.type.automotive") == false) goto L5;
        pw.println("  is-adas-gnss-location-enabled [--user <USER_ID>]");
        pw.println("    Gets the ADAS GNSS location enabled state. If no user is specified,");
        pw.println("    the current user is assumed.");
        pw.println("  set-adas-gnss-location-enabled true|false [--user <USER_ID>]");
        pw.println("    Sets the ADAS GNSS location enabled state. If no user is specified,");
        pw.println("    the current user is assumed.");
        pw.println("  is-automotive-gnss-suspended");
        pw.println("    Gets the automotive GNSS suspended state.");
        pw.println("  set-automotive-gnss-suspended true|false");
        pw.println("    Sets the automotive GNSS suspended state.");
    L5:
        pw.println("  providers");
        pw.println("    The providers command is followed by a subcommand, as listed below:");
        pw.println();
        pw.println("    add-test-provider <PROVIDER> [--requiresNetwork] [--requiresSatellite]");
        pw.println("      [--requiresCell] [--hasMonetaryCost] [--supportsAltitude]");
        pw.println("      [--supportsSpeed] [--supportsBearing]");
        pw.println("      [--powerRequirement <POWER_REQUIREMENT>]");
        pw.println("      [--extraAttributionTags <TAG>,<TAG>,...]");
        pw.println("      Add the given test provider. Requires MOCK_LOCATION permissions which");
        pw.println("      can be enabled by running \"adb shell appops set <uid>");
        pw.println("      android:mock_location allow\". There are optional flags that can be");
        pw.println("      used to configure the provider properties and additional arguments. If");
        pw.println("      no flags are included, then default values will be used.");
        pw.println("    remove-test-provider <PROVIDER>");
        pw.println("      Remove the given test provider.");
        pw.println("    set-test-provider-enabled <PROVIDER> true|false");
        pw.println("      Sets the given test provider enabled state.");
        pw.println("    set-test-provider-location <PROVIDER> --location <LATITUDE>,<LONGITUDE>");
        pw.println("      [--accuracy <ACCURACY>] [--time <TIME>]");
        pw.println("      Set location for given test provider. Accuracy and time are optional.");
        pw.println("    send-extra-command <PROVIDER> <COMMAND>");
        pw.println("      Sends the given extra command to the given provider.");
        pw.println();
        pw.println("      Common commands that may be supported by the gps provider, depending on");
        pw.println("      hardware and software configurations:");
        pw.println("        delete_aiding_data - requests deletion of any predictive aiding data");
        pw.println("        force_time_injection - requests NTP time injection");
        pw.println("        force_psds_injection - requests predictive aiding data injection");
        pw.println("        request_power_stats - requests GNSS power stats update");
    }
}
