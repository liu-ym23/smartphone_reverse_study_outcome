package com.android.server.display;

import android.os.Environment;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.view.DisplayAddress;
import com.android.server.display.config.layout.Display;
import com.android.server.display.config.layout.Layouts;
import com.android.server.display.config.layout.XmlParser;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.layout.DisplayIdProducer;
import com.android.server.display.layout.Layout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class DeviceStateToLayoutMap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String CONFIG_FILE_PATH = "etc/displayconfig/display_layout_configuration.xml";
    private static final String DATA_CONFIG_FILE_PATH = "system/displayconfig/display_layout_configuration.xml";
    private static final String FRONT_STRING = "front";
    private static final int POSITION_FRONT = 0;
    private static final int POSITION_REAR = 1;
    private static final int POSITION_UNKNOWN = -1;
    private static final String REAR_STRING = "rear";
    public static final int STATE_DEFAULT = -1;
    private static final String TAG = "DeviceStateToLayoutMap";
    private final DisplayIdProducer mIdProducer;
    private final boolean mIsPortInDisplayLayoutEnabled;
    private final SparseArray<Layout> mLayoutMap;

    static {
    }

    DeviceStateToLayoutMap(DisplayIdProducer idProducer, DisplayManagerFlags flags) {
        this(idProducer, flags, getConfigFile());
    }

    DeviceStateToLayoutMap(DisplayIdProducer idProducer, DisplayManagerFlags flags, File configFile) {
        this.mLayoutMap = new SparseArray();
        this.mIsPortInDisplayLayoutEnabled = flags.isPortInDisplayLayoutEnabled();
        this.mIdProducer = idProducer;
        loadLayoutsFromConfig(configFile);
        createLayout(-1);
    }

    private static File getConfigFile() {
        File configFileFromDataDir = Environment.buildPath(Environment.getDataDirectory(), new String[]{DATA_CONFIG_FILE_PATH});
        if (configFileFromDataDir.exists() == false) goto L6;
        return configFileFromDataDir;
    L6:
        return Environment.buildPath(Environment.getVendorDirectory(), new String[]{CONFIG_FILE_PATH});
    }

    public void dumpLocked(IndentingPrintWriter ipw) {
        ipw.println("DeviceStateToLayoutMap:");
        ipw.println("-----------------------");
        ipw.increaseIndent();
        ipw.println("mIsPortInDisplayLayoutEnabled=" + this.mIsPortInDisplayLayoutEnabled);
        ipw.println("Registered Layouts:");
        int i = 0;
    L4:
        if (i >= this.mLayoutMap.size()) goto L7;
        ipw.println("state(" + this.mLayoutMap.keyAt(i) + "): " + this.mLayoutMap.valueAt(i));
        i = i + 1;
        goto L4
    }

    Layout get(int state) {
        Layout layout = this.mLayoutMap.get(state);
        if (layout == null) goto L5;
        return layout;
    L5:
        return this.mLayoutMap.get(-1);
    }

    int size() {
        return this.mLayoutMap.size();
    }

    void loadLayoutsFromConfig(File configFile) {
        if (configFile.exists() == true) goto L5;
        return;
    L5:
        Slog.i(TAG, "Loading display layouts from " + configFile);
        InputStream in = new BufferedInputStream(new FileInputStream(configFile));     // Catch: Throwable -> L13
        Layouts layouts = XmlParser.read(in);     // Catch: Throwable -> L15
        if (layouts != null) goto L17;
        Slog.i(TAG, "Display layout config not found: " + configFile);     // Catch: Throwable -> L15
        in.close();     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        return;
    L17:
        Iterator<com.android.server.display.config.layout.Layout> r5 = layouts.getLayout().iterator();     // Catch: Throwable -> L15
    L19:
        if (r5.hasNext() == false) goto L31;
        com.android.server.display.config.layout.Layout l = r5.next();     // Catch: Throwable -> L15
        int state = l.getState().intValue();     // Catch: Throwable -> L15
        Layout layout = createLayout(state);     // Catch: Throwable -> L15
        Iterator<Display> r8 = l.getDisplay().iterator();     // Catch: Throwable -> L15
    L22:
        if (r8.hasNext() == false) goto L28;
        Display d = r8.next();     // Catch: Throwable -> L15
        DisplayAddress address = getDisplayAddressForLayoutDisplay(d);     // Catch: Throwable -> L15
        int position = getPosition(d.getPosition());     // Catch: Throwable -> L15
        BigInteger leadDisplayPhysicalId = d.getLeadDisplayAddress();     // Catch: Throwable -> L15
        if (leadDisplayPhysicalId != null) goto L26;
        DisplayAddress leadDisplayAddress = null;
    L27:
        layout.createDisplayLocked(address, d.isDefaultDisplay(), d.isEnabled(), d.getDisplayGroup(), this.mIdProducer, position, leadDisplayAddress, d.getBrightnessThrottlingMapId(), d.getRefreshRateZoneId(), d.getRefreshRateThermalThrottlingMapId(), d.getPowerThrottlingMapId());     // Catch: Throwable -> L15
        goto L22
    L26:
        leadDisplayAddress = DisplayAddress.fromPhysicalDisplayId(leadDisplayPhysicalId.longValue());     // Catch: Throwable -> L15
        goto L27
    L28:
        layout.postProcessLocked();     // Catch: Throwable -> L15
        goto L19
    L31:
        in.close();     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        return;
    L15:
        th = move-exception;
        in.close();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        throw th;     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
    L13:
        e = move-exception;
        Slog.e(TAG, "Encountered an error while reading/parsing display layout config file: " + configFile, e);
    }

    private DisplayAddress getDisplayAddressForLayoutDisplay(Display display) {
        BigInteger xmlAddress = display.getAddress_optional();
        if (xmlAddress == null) goto L7;
        return DisplayAddress.fromPhysicalDisplayId(xmlAddress.longValue());
    L7:
        if (this.mIsPortInDisplayLayoutEnabled == false) goto L13;
        if (display.getPort_optional() == null) goto L13;
        return DisplayAddress.fromPortAndModel((int) display.getPort_optional().longValue(), null);
    L13:
        throw new IllegalArgumentException("Must specify a display identifier in display layout configuration: " + display);
    }

    private int getPosition(String position) {
        if (FRONT_STRING.equals(position) == false) goto L6;
        return 0;
    L6:
        if (REAR_STRING.equals(position) == false) goto L10;
        return 1;
    L10:
        return -1;
    }

    private Layout createLayout(int state) {
        if (this.mLayoutMap.contains(state) == false) goto L6;
        Slog.e(TAG, "Attempted to create a second layout for state " + state);
        return null;
    L6:
        Layout layout = new Layout();
        this.mLayoutMap.append(state, layout);
        return layout;
    }
}
