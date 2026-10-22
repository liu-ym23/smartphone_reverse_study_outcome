package com.android.server.display;

import android.hardware.display.DeviceProductInfo;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.DisplayCutout;
import android.view.DisplayEventReceiver;
import android.view.DisplayShape;
import android.view.FrameRateCategoryRate;
import android.view.RoundedCorners;
import com.android.internal.display.BrightnessSynchronizer;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class DisplayDeviceInfo {
    public static final int DIFF_COLOR_MODE = 8;
    public static final int DIFF_COMMITTED_STATE = 4;
    public static final int DIFF_EVERYTHING = -1;
    public static final int DIFF_FRAME_RATE_OVERRIDE = 256;
    public static final int DIFF_HDR_SDR_RATIO = 16;
    public static final int DIFF_MODE_ID = 128;
    public static final int DIFF_OTHER = 1;
    public static final int DIFF_RENDER_TIMINGS = 64;
    public static final int DIFF_ROTATION = 32;
    public static final int DIFF_STATE = 2;
    public static final int FLAG_ALLOWED_TO_BE_DEFAULT_DISPLAY = 1;
    public static final int FLAG_ALLOWS_CONTENT_MODE_SWITCH = 1048576;
    public static final int FLAG_ALWAYS_UNLOCKED = 32768;
    public static final int FLAG_CAN_SHOW_WITH_INSECURE_KEYGUARD = 512;
    public static final int FLAG_DESTROY_CONTENT_ON_REMOVAL = 1024;
    public static final int FLAG_DEVICE_DISPLAY_FLAG_MIRROR_ANIMATION = 536870912;
    public static final int FLAG_DEVICE_DISPLAY_GROUP = 262144;
    public static final int FLAG_MASK_DISPLAY_CUTOUT = 2048;
    public static final int FLAG_NEVER_BLANK = 32;
    public static final int FLAG_OWN_CONTENT_ONLY = 128;
    public static final int FLAG_OWN_DISPLAY_GROUP = 16384;
    public static final int FLAG_OWN_FOCUS = 131072;
    public static final int FLAG_PRESENTATION = 64;
    public static final int FLAG_PRIVATE = 16;
    public static final int FLAG_ROTATES_WITH_CONTENT = 2;
    public static final int FLAG_ROUND = 256;
    public static final int FLAG_SECURE = 4;
    public static final int FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS = 4096;
    public static final int FLAG_STEAL_TOP_FOCUS_DISABLED = 524288;
    public static final int FLAG_SUPPORTS_PROTECTED_BUFFERS = 8;
    public static final int FLAG_TOUCH_FEEDBACK_DISABLED = 65536;
    public static final int FLAG_TRUSTED = 8192;
    public static final int TOUCH_EXTERNAL = 2;
    public static final int TOUCH_INTERNAL = 1;
    public static final int TOUCH_NONE = 0;
    public static final int TOUCH_VIRTUAL = 3;
    public DisplayAddress address;
    public boolean allmSupported;
    public long appVsyncOffsetNanos;
    public float brightnessDefault;
    public float brightnessDim;
    public float brightnessMaximum;
    public float brightnessMinimum;
    public int colorMode;
    public int committedState;
    public int defaultModeId;
    public int densityDpi;
    public DeviceProductInfo deviceProductInfo;
    public DisplayCutout displayCutout;
    public DisplayShape displayShape;
    public int flags;
    public FrameRateCategoryRate frameRateCategoryRate;
    public DisplayEventReceiver.FrameRateOverride[] frameRateOverrides;
    public boolean gameContentTypeSupported;
    public boolean hasArrSupport;
    public Display.HdrCapabilities hdrCapabilities;
    public float hdrSdrRatio;
    public int height;
    public int installOrientation;
    public boolean isForceSdr;
    public int modeId;
    public String name;
    public String ownerPackageName;
    public int ownerUid;
    public long presentationDeadlineNanos;
    public float renderFrameRate;
    public int rotation;
    public RoundedCorners roundedCorners;
    public int state;
    public int[] supportedColorModes;
    public Display.Mode[] supportedModes;
    public float[] supportedRefreshRates;
    public int touch;
    public int type;
    public String uniqueId;
    public int userPreferredModeId;
    public int width;
    public float xDpi;
    public float yDpi;

    DisplayDeviceInfo() {
        this.supportedRefreshRates = new float[0];
        this.userPreferredModeId = -1;
        this.supportedModes = Display.Mode.EMPTY_ARRAY;
        this.supportedColorModes = new int[]{0};
        this.rotation = 0;
        this.state = 2;
        this.committedState = 0;
        this.frameRateOverrides = new DisplayEventReceiver.FrameRateOverride[0];
        this.hdrSdrRatio = Float.NaN;
        this.installOrientation = 0;
    }

    public void setAssumedDensityForExternalDisplay(int width, int height) {
        this.densityDpi = (Math.min(width, height) * 320) / 1080;
        this.xDpi = this.densityDpi;
        this.yDpi = this.densityDpi;
    }

    public boolean equals(Object o) {
        if ((o instanceof DisplayDeviceInfo) == true) goto L5;
    L7:
        return false;
    L5:
        if (equals((DisplayDeviceInfo) o) == false) goto L7;
        return true;
    }

    public boolean equals(DisplayDeviceInfo other) {
        if (other != null) goto L4;
    L6:
        return false;
    L4:
        if (diff(other) != 0) goto L6;
        return true;
    }

    public int diff(DisplayDeviceInfo other) {
        int diff = 0;
        if (this.state == other.state) goto L6;
        diff = 0 | 2;
    L6:
        if (this.committedState == other.committedState) goto L9;
        diff = diff | 4;
    L9:
        if (this.colorMode == other.colorMode) goto L12;
        diff = diff | 8;
    L12:
        if (BrightnessSynchronizer.floatEquals(this.hdrSdrRatio, other.hdrSdrRatio) == true) goto L15;
        diff = diff | 16;
    L15:
        if (this.rotation == other.rotation) goto L18;
        diff = diff | 32;
    L18:
        if (this.renderFrameRate == other.renderFrameRate) goto L20;
    L23:
        diff = diff | 64;
    L25:
        if (this.modeId == other.modeId) goto L28;
        diff = diff | 128;
    L28:
        if (Arrays.equals(this.frameRateOverrides, other.frameRateOverrides) == true) goto L31;
        diff = diff | 256;
    L31:
        if (Objects.equals(this.name, other.name) == false) goto L97;
        if (Objects.equals(this.uniqueId, other.uniqueId) == false) goto L97;
        if (this.width != other.width) goto L97;
        if (this.height != other.height) goto L97;
        if (this.defaultModeId != other.defaultModeId) goto L97;
        if (this.userPreferredModeId != other.userPreferredModeId) goto L97;
        if (Arrays.equals(this.supportedModes, other.supportedModes) == false) goto L97;
        if (Arrays.equals(this.supportedColorModes, other.supportedColorModes) == false) goto L97;
        if (Objects.equals(this.hdrCapabilities, other.hdrCapabilities) == false) goto L97;
        if (this.isForceSdr != other.isForceSdr) goto L97;
        if (this.allmSupported != other.allmSupported) goto L97;
        if (this.gameContentTypeSupported != other.gameContentTypeSupported) goto L97;
        if (this.densityDpi != other.densityDpi) goto L97;
        if (this.xDpi != other.xDpi) goto L97;
        if (this.yDpi != other.yDpi) goto L97;
        if (this.flags != other.flags) goto L97;
        if (Objects.equals(this.displayCutout, other.displayCutout) == false) goto L97;
        if (this.touch != other.touch) goto L97;
        if (this.type != other.type) goto L97;
        if (Objects.equals(this.address, other.address) == false) goto L97;
        if (Objects.equals(this.deviceProductInfo, other.deviceProductInfo) == false) goto L97;
        if (this.ownerUid != other.ownerUid) goto L97;
        if (Objects.equals(this.ownerPackageName, other.ownerPackageName) == false) goto L97;
        if (BrightnessSynchronizer.floatEquals(this.brightnessMinimum, other.brightnessMinimum) == false) goto L97;
        if (BrightnessSynchronizer.floatEquals(this.brightnessMaximum, other.brightnessMaximum) == false) goto L97;
        if (BrightnessSynchronizer.floatEquals(this.brightnessDefault, other.brightnessDefault) == false) goto L97;
        if (BrightnessSynchronizer.floatEquals(this.brightnessDim, other.brightnessDim) == false) goto L97;
        if (Objects.equals(this.roundedCorners, other.roundedCorners) == false) goto L97;
        if (this.installOrientation != other.installOrientation) goto L97;
        if (Objects.equals(this.displayShape, other.displayShape) == false) goto L97;
        if (this.hasArrSupport != other.hasArrSupport) goto L97;
        if (Objects.equals(this.frameRateCategoryRate, other.frameRateCategoryRate) == false) goto L97;
        if (Arrays.equals(this.supportedRefreshRates, other.supportedRefreshRates) == false) goto L97;
        return diff;
    L97:
        return diff | 1;
    L20:
        if (this.presentationDeadlineNanos != other.presentationDeadlineNanos) goto L23;
        if (this.appVsyncOffsetNanos == other.appVsyncOffsetNanos) goto L25;
        goto L23
    }

    public int hashCode() {
        return 0;
    }

    public void copyFrom(DisplayDeviceInfo other) {
        this.name = other.name;
        this.uniqueId = other.uniqueId;
        this.width = other.width;
        this.height = other.height;
        this.modeId = other.modeId;
        this.renderFrameRate = other.renderFrameRate;
        this.hasArrSupport = other.hasArrSupport;
        this.frameRateCategoryRate = other.frameRateCategoryRate;
        this.supportedRefreshRates = other.supportedRefreshRates;
        this.defaultModeId = other.defaultModeId;
        this.userPreferredModeId = other.userPreferredModeId;
        this.supportedModes = other.supportedModes;
        this.colorMode = other.colorMode;
        this.supportedColorModes = other.supportedColorModes;
        this.hdrCapabilities = other.hdrCapabilities;
        this.isForceSdr = other.isForceSdr;
        this.allmSupported = other.allmSupported;
        this.gameContentTypeSupported = other.gameContentTypeSupported;
        this.densityDpi = other.densityDpi;
        this.xDpi = other.xDpi;
        this.yDpi = other.yDpi;
        this.appVsyncOffsetNanos = other.appVsyncOffsetNanos;
        this.presentationDeadlineNanos = other.presentationDeadlineNanos;
        this.flags = other.flags;
        this.displayCutout = other.displayCutout;
        this.touch = other.touch;
        this.rotation = other.rotation;
        this.type = other.type;
        this.address = other.address;
        this.deviceProductInfo = other.deviceProductInfo;
        this.state = other.state;
        this.committedState = other.committedState;
        this.ownerUid = other.ownerUid;
        this.ownerPackageName = other.ownerPackageName;
        this.frameRateOverrides = other.frameRateOverrides;
        this.brightnessMinimum = other.brightnessMinimum;
        this.brightnessMaximum = other.brightnessMaximum;
        this.brightnessDefault = other.brightnessDefault;
        this.brightnessDim = other.brightnessDim;
        this.hdrSdrRatio = other.hdrSdrRatio;
        this.roundedCorners = other.roundedCorners;
        this.installOrientation = other.installOrientation;
        this.displayShape = other.displayShape;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisplayDeviceInfo{\"");
        sb.append(this.name);
        sb.append("\": uniqueId=\"");
        sb.append(this.uniqueId);
        sb.append("\", ");
        sb.append(this.width);
        sb.append(" x ");
        sb.append(this.height);
        sb.append(", modeId ");
        sb.append(this.modeId);
        sb.append(", renderFrameRate ");
        sb.append(this.renderFrameRate);
        sb.append(", hasArrSupport ");
        sb.append(this.hasArrSupport);
        sb.append(", frameRateCategoryRate ");
        sb.append(this.frameRateCategoryRate);
        sb.append(", supportedRefreshRates ");
        sb.append(Arrays.toString(this.supportedRefreshRates));
        sb.append(", defaultModeId ");
        sb.append(this.defaultModeId);
        sb.append(", userPreferredModeId ");
        sb.append(this.userPreferredModeId);
        sb.append(", supportedModes ");
        sb.append(Arrays.toString(this.supportedModes));
        sb.append(", colorMode ");
        sb.append(this.colorMode);
        sb.append(", supportedColorModes ");
        sb.append(Arrays.toString(this.supportedColorModes));
        sb.append(", hdrCapabilities ");
        sb.append(this.hdrCapabilities);
        sb.append(", isForceSdr ");
        sb.append(this.isForceSdr);
        sb.append(", allmSupported ");
        sb.append(this.allmSupported);
        sb.append(", gameContentTypeSupported ");
        sb.append(this.gameContentTypeSupported);
        sb.append(", density ");
        sb.append(this.densityDpi);
        sb.append(", ");
        sb.append(this.xDpi);
        sb.append(" x ");
        sb.append(this.yDpi);
        sb.append(" dpi");
        sb.append(", appVsyncOff ");
        sb.append(this.appVsyncOffsetNanos);
        sb.append(", presDeadline ");
        sb.append(this.presentationDeadlineNanos);
        if (this.displayCutout == null) goto L5;
        sb.append(", cutout ");
        sb.append(this.displayCutout);
    L5:
        sb.append(", touch ");
        sb.append(touchToString(this.touch));
        sb.append(", rotation ");
        sb.append(this.rotation);
        sb.append(", type ");
        sb.append(Display.typeToString(this.type));
        if (this.address == null) goto L8;
        sb.append(", address ");
        sb.append(this.address);
    L8:
        sb.append(", deviceProductInfo ");
        sb.append(this.deviceProductInfo);
        sb.append(", state ");
        sb.append(Display.stateToString(this.state));
        sb.append(", committedState ");
        sb.append(Display.stateToString(this.committedState));
        if (this.ownerUid == 0) goto L11;
    L12:
        sb.append(", owner ");
        sb.append(this.ownerPackageName);
        sb.append(" (uid ");
        sb.append(this.ownerUid);
        sb.append(")");
    L13:
        sb.append(", frameRateOverride ");
        DisplayEventReceiver.FrameRateOverride[] r1 = this.frameRateOverrides;
        int r2 = r1.length;
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L16;
        DisplayEventReceiver.FrameRateOverride frameRateOverride = r1[r3];
        sb.append(frameRateOverride);
        sb.append(" ");
        r3 = r3 + 1;
        goto L14
    L16:
        sb.append(", brightnessMinimum ");
        sb.append(this.brightnessMinimum);
        sb.append(", brightnessMaximum ");
        sb.append(this.brightnessMaximum);
        sb.append(", brightnessDefault ");
        sb.append(this.brightnessDefault);
        sb.append(", brightnessDim ");
        sb.append(this.brightnessDim);
        sb.append(", hdrSdrRatio ");
        sb.append(this.hdrSdrRatio);
        if (this.roundedCorners == null) goto L19;
        sb.append(", roundedCorners ");
        sb.append(this.roundedCorners);
    L19:
        sb.append(flagsToString(this.flags));
        sb.append(", installOrientation ");
        sb.append(this.installOrientation);
        if (this.displayShape == null) goto L22;
        sb.append(", displayShape ");
        sb.append(this.displayShape);
    L22:
        sb.append("}");
        return sb.toString();
    L11:
        if (this.ownerPackageName == null) goto L13;
        goto L12
    }

    private static String touchToString(int touch) {
        switch(touch) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return "VIRTUAL";
    L7:
        return "EXTERNAL";
    L9:
        return "INTERNAL";
    L11:
        return "NONE";
    L4:
        return Integer.toString(touch);
    }

    private static String flagsToString(int flags) {
        StringBuilder msg = new StringBuilder();
        if ((flags & 1) == 0) goto L6;
        msg.append(", FLAG_ALLOWED_TO_BE_DEFAULT_DISPLAY");
    L6:
        if ((flags & 2) == 0) goto L9;
        msg.append(", FLAG_ROTATES_WITH_CONTENT");
    L9:
        if ((flags & 4) == 0) goto L12;
        msg.append(", FLAG_SECURE");
    L12:
        if ((flags & 8) == 0) goto L15;
        msg.append(", FLAG_SUPPORTS_PROTECTED_BUFFERS");
    L15:
        if ((flags & 16) == 0) goto L18;
        msg.append(", FLAG_PRIVATE");
    L18:
        if ((flags & 32) == 0) goto L21;
        msg.append(", FLAG_NEVER_BLANK");
    L21:
        if ((flags & 64) == 0) goto L24;
        msg.append(", FLAG_PRESENTATION");
    L24:
        if ((flags & 128) == 0) goto L27;
        msg.append(", FLAG_OWN_CONTENT_ONLY");
    L27:
        if ((flags & 256) == 0) goto L30;
        msg.append(", FLAG_ROUND");
    L30:
        if ((flags & 512) == 0) goto L33;
        msg.append(", FLAG_CAN_SHOW_WITH_INSECURE_KEYGUARD");
    L33:
        if ((flags & 1024) == 0) goto L36;
        msg.append(", FLAG_DESTROY_CONTENT_ON_REMOVAL");
    L36:
        if ((flags & 2048) == 0) goto L39;
        msg.append(", FLAG_MASK_DISPLAY_CUTOUT");
    L39:
        if ((flags & 4096) == 0) goto L42;
        msg.append(", FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS");
    L42:
        if ((flags & 8192) == 0) goto L45;
        msg.append(", FLAG_TRUSTED");
    L45:
        if ((flags & 16384) == 0) goto L48;
        msg.append(", FLAG_OWN_DISPLAY_GROUP");
    L48:
        if ((32768 & flags) == 0) goto L51;
        msg.append(", FLAG_ALWAYS_UNLOCKED");
    L51:
        if ((65536 & flags) == 0) goto L54;
        msg.append(", FLAG_TOUCH_FEEDBACK_DISABLED");
    L54:
        if ((131072 & flags) == 0) goto L57;
        msg.append(", FLAG_OWN_FOCUS");
    L57:
        if ((524288 & flags) == 0) goto L60;
        msg.append(", FLAG_STEAL_TOP_FOCUS_DISABLED");
    L60:
        return msg.toString();
    }
}
