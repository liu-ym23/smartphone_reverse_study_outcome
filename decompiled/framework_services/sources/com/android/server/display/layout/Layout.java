package com.android.server.display.layout;

import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import android.view.DisplayAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class Layout {
    public static final String DEFAULT_DISPLAY_GROUP_NAME = "";
    public static final int NO_LEAD_DISPLAY = -1;
    private static final String TAG = "Layout";
    private final List<Display> mDisplays;

    public static class Display {
        public static final int POSITION_FRONT = 0;
        public static final int POSITION_REAR = 1;
        public static final int POSITION_UNKNOWN = -1;
        private final DisplayAddress mAddress;
        private final String mDisplayGroupName;
        private final boolean mIsEnabled;
        private final DisplayAddress mLeadDisplayAddress;
        private int mLeadDisplayId;
        private final int mLogicalDisplayId;
        private final int mPosition;
        private final String mPowerThrottlingMapId;
        private final String mRefreshRateZoneId;
        private final String mThermalBrightnessThrottlingMapId;
        private final String mThermalRefreshRateThrottlingMapId;

        /* JADX INFO: renamed from: -$$Nest$msetLeadDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4065$$Nest$msetLeadDisplayId(Display r0, int r1) {
            r0.setLeadDisplayId(r1);
        }

        /* synthetic */ Display(DisplayAddress r1, int r2, boolean r3, String r4, String r5, int r6, DisplayAddress r7, String r8, String r9, String r10, LayoutIA r11) {
            this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
        }

        private Display(DisplayAddress address, int logicalDisplayId, boolean isEnabled, String displayGroupName, String brightnessThrottlingMapId, int position, DisplayAddress leadDisplayAddress, String refreshRateZoneId, String refreshRateThermalThrottlingMapId, String powerThrottlingMapId) {
            this.mAddress = address;
            this.mLogicalDisplayId = logicalDisplayId;
            this.mIsEnabled = isEnabled;
            this.mDisplayGroupName = displayGroupName;
            this.mPosition = position;
            this.mThermalBrightnessThrottlingMapId = brightnessThrottlingMapId;
            this.mLeadDisplayAddress = leadDisplayAddress;
            this.mRefreshRateZoneId = refreshRateZoneId;
            this.mThermalRefreshRateThrottlingMapId = refreshRateThermalThrottlingMapId;
            this.mPowerThrottlingMapId = powerThrottlingMapId;
            this.mLeadDisplayId = -1;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("{dispId: ");
            r0.append(this.mLogicalDisplayId);
            r0.append("(");
            if (this.mIsEnabled == false) goto L5;
            String r1 = "ON";
        L6:
            r0.append(r1);
            r0.append("), displayGroupName: ");
            r0.append(this.mDisplayGroupName);
            r0.append(", addr: ");
            r0.append(this.mAddress);
            if (this.mPosition != (-1)) goto L9;
            String r2 = "";
        L10:
            r0.append(r2);
            r0.append(", mThermalBrightnessThrottlingMapId: ");
            r0.append(this.mThermalBrightnessThrottlingMapId);
            r0.append(", mRefreshRateZoneId: ");
            r0.append(this.mRefreshRateZoneId);
            r0.append(", mLeadDisplayId: ");
            r0.append(this.mLeadDisplayId);
            r0.append(", mLeadDisplayAddress: ");
            r0.append(this.mLeadDisplayAddress);
            r0.append(", mThermalRefreshRateThrottlingMapId: ");
            r0.append(this.mThermalRefreshRateThrottlingMapId);
            r0.append(", mPowerThrottlingMapId: ");
            r0.append(this.mPowerThrottlingMapId);
            r0.append("}");
            return r0.toString();
        L9:
            r2 = ", position: " + this.mPosition;
            goto L10
        L5:
            r1 = "OFF";
            goto L6
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Display) == true) goto L5;
            return false;
        L5:
            Display otherDisplay = (Display) obj;
            if (otherDisplay.mIsEnabled == this.mIsEnabled) goto L8;
            return false;
        L8:
            if (otherDisplay.mPosition == this.mPosition) goto L10;
            return false;
        L10:
            if (otherDisplay.mLogicalDisplayId == this.mLogicalDisplayId) goto L12;
            return false;
        L12:
            if (this.mDisplayGroupName.equals(otherDisplay.mDisplayGroupName) == true) goto L14;
            return false;
        L14:
            if (this.mAddress.equals(otherDisplay.mAddress) == true) goto L16;
            return false;
        L16:
            if (Objects.equals(this.mThermalBrightnessThrottlingMapId, otherDisplay.mThermalBrightnessThrottlingMapId) == true) goto L18;
            return false;
        L18:
            if (Objects.equals(otherDisplay.mRefreshRateZoneId, this.mRefreshRateZoneId) == true) goto L20;
            return false;
        L20:
            if (this.mLeadDisplayId == otherDisplay.mLeadDisplayId) goto L22;
            return false;
        L22:
            if (Objects.equals(this.mLeadDisplayAddress, otherDisplay.mLeadDisplayAddress) == true) goto L24;
            return false;
        L24:
            if (Objects.equals(this.mThermalRefreshRateThrottlingMapId, otherDisplay.mThermalRefreshRateThrottlingMapId) == true) goto L26;
            return false;
        L26:
            if (Objects.equals(this.mPowerThrottlingMapId, otherDisplay.mPowerThrottlingMapId) == false) goto L40;
            return true;
        L40:
            return false;
        }

        public int hashCode() {
            int result = (1 * 31) + Boolean.hashCode(this.mIsEnabled);
            return (((((((((((((((((((result * 31) + this.mPosition) * 31) + this.mLogicalDisplayId) * 31) + this.mDisplayGroupName.hashCode()) * 31) + this.mAddress.hashCode()) * 31) + Objects.hashCode(this.mThermalBrightnessThrottlingMapId)) * 31) + Objects.hashCode(this.mRefreshRateZoneId)) * 31) + this.mLeadDisplayId) * 31) + Objects.hashCode(this.mLeadDisplayAddress)) * 31) + Objects.hashCode(this.mThermalRefreshRateThrottlingMapId)) * 31) + Objects.hashCode(this.mPowerThrottlingMapId);
        }

        public DisplayAddress getAddress() {
            return this.mAddress;
        }

        public int getLogicalDisplayId() {
            return this.mLogicalDisplayId;
        }

        public boolean isEnabled() {
            return this.mIsEnabled;
        }

        public String getDisplayGroupName() {
            return this.mDisplayGroupName;
        }

        public String getRefreshRateZoneId() {
            return this.mRefreshRateZoneId;
        }

        public String getThermalBrightnessThrottlingMapId() {
            return this.mThermalBrightnessThrottlingMapId;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public int getLeadDisplayId() {
            return this.mLeadDisplayId;
        }

        public DisplayAddress getLeadDisplayAddress() {
            return this.mLeadDisplayAddress;
        }

        public String getRefreshRateThermalThrottlingMapId() {
            return this.mThermalRefreshRateThrottlingMapId;
        }

        public String getPowerThrottlingMapId() {
            return this.mPowerThrottlingMapId;
        }

        private void setLeadDisplayId(int id) {
            this.mLeadDisplayId = id;
        }
    }

    public Layout() {
        this.mDisplays = new ArrayList(2);
    }

    public String toString() {
        return this.mDisplays.toString();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Layout) == true) goto L6;
        return false;
    L6:
        Layout otherLayout = (Layout) obj;
        return this.mDisplays.equals(otherLayout.mDisplays);
    }

    public int hashCode() {
        return this.mDisplays.hashCode();
    }

    public void createDefaultDisplayLocked(DisplayAddress address, DisplayIdProducer idProducer) {
        createDisplayLocked(address, true, true, "", idProducer, -1, null, null, null, null, null);
    }

    public void createDisplayLocked(DisplayAddress address, boolean isDefault, boolean isEnabled, String displayGroupName, DisplayIdProducer idProducer, int position, DisplayAddress leadDisplayAddress, String brightnessThrottlingMapId, String refreshRateZoneId, String refreshRateThermalThrottlingMapId, String powerThrottlingMapId) {
        if (contains(address) == false) goto L6;
        Slog.w(TAG, "Attempting to add second definition for display-device: " + address);
        return;
    L6:
        if (isDefault == true) goto L8;
    L11:
        if (displayGroupName != null) goto L13;
        String displayGroupName2 = "";
    L14:
        if (isDefault == true) goto L16;
    L20:
        if (isDefault == false) goto L26;
        if (leadDisplayAddress == null) goto L26;
        throw new IllegalArgumentException("Default display cannot have a lead display");
    L26:
        if (address.equals(leadDisplayAddress) == true) goto L30;
        int logicalDisplayId = idProducer.getId(isDefault);
        Display display = new Display(address, logicalDisplayId, isEnabled, displayGroupName2, brightnessThrottlingMapId, position, leadDisplayAddress, refreshRateZoneId, refreshRateThermalThrottlingMapId, powerThrottlingMapId, null);
        this.mDisplays.add(display);
        return;
    L30:
        throw new IllegalArgumentException("Lead display address cannot be the same as display  address");
    L16:
        if (displayGroupName2.equals("") == true) goto L20;
        throw new IllegalArgumentException("Default display should own DEFAULT_DISPLAY_GROUP");
    L13:
        displayGroupName2 = displayGroupName;
        goto L14
    L8:
        if (getById(0) == null) goto L11;
        Slog.w(TAG, "Ignoring attempt to add a second default display: " + address);
    }

    public void removeDisplayLocked(int id) {
        Display display = getById(id);
        if (display == null) goto L6;
        this.mDisplays.remove(display);
        return;
    }

    public void postProcessLocked() {
        int i = 0;
    L4:
        if (i >= this.mDisplays.size()) goto L26;
        Display display = this.mDisplays.get(i);
        if (display.getLogicalDisplayId() != 0) goto L8;
        Display.m4065$$Nest$msetLeadDisplayId(display, -1);
    L18:
        i = i + 1;
        goto L4
    L8:
        DisplayAddress leadDisplayAddress = display.getLeadDisplayAddress();
        if (leadDisplayAddress != null) goto L11;
        Display.m4065$$Nest$msetLeadDisplayId(display, -1);
        goto L18
    L11:
        Display leadDisplay = getByAddress(leadDisplayAddress);
        if (leadDisplay == null) goto L24;
        if (TextUtils.equals(display.getDisplayGroupName(), leadDisplay.getDisplayGroupName()) == false) goto L22;
        if (hasCyclicLeadDisplay(display) == true) goto L20;
        Display.m4065$$Nest$msetLeadDisplayId(display, leadDisplay.getLogicalDisplayId());
        goto L18
    L20:
        throw new IllegalArgumentException("Display(" + display + ") has a cyclic lead display");
    L22:
        throw new IllegalArgumentException("Lead display(" + leadDisplay + ") should be in the same display group of the display(" + display + ")");
    L24:
        throw new IllegalArgumentException("Cannot find a lead display whose address is " + leadDisplayAddress);
    }

    public boolean contains(DisplayAddress address) {
        if (getByAddress(address) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Display getById(int id) {
        int i = 0;
    L4:
        if (i >= this.mDisplays.size()) goto L9;
        Display display = this.mDisplays.get(i);
        if (id == display.getLogicalDisplayId()) goto L7;
        i = i + 1;
        goto L4
    L7:
        return display;
    L9:
        return null;
    }

    public Display getByAddress(DisplayAddress address) {
        int i = 0;
    L4:
        if (i >= this.mDisplays.size()) goto L12;
        Display display = this.mDisplays.get(i);
        if (address.equals(display.getAddress()) == true) goto L7;
        if (DisplayAddress.Physical.isPortMatch(address, display.getAddress()) == true) goto L10;
        i = i + 1;
        goto L4
    L10:
        return display;
    L7:
        return display;
    L12:
        return null;
    }

    public Display getAt(int index) {
        return this.mDisplays.get(index);
    }

    public int size() {
        return this.mDisplays.size();
    }

    private boolean hasCyclicLeadDisplay(Display display) {
        ArraySet<Display> visited = new ArraySet();
    L3:
        if (display == null) goto L13;
        if (visited.contains(display) == true) goto L6;
        visited.add(display);
        DisplayAddress leadDisplayAddress = display.getLeadDisplayAddress();
        if (leadDisplayAddress != null) goto L11;
        Display r2 = null;
    L12:
        display = r2;
        goto L3
    L11:
        r2 = getByAddress(leadDisplayAddress);
        goto L12
    L6:
        return true;
    L13:
        return false;
    }
}
