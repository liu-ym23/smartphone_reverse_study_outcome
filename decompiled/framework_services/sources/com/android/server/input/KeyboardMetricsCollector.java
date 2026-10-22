package com.android.server.input;

import android.hardware.input.KeyboardLayout;
import android.hardware.input.KeyboardLayoutSelectionResult;
import android.icu.util.ULocale;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.InputDevice;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.util.FrameworkStatsLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class KeyboardMetricsCollector {
    private static final boolean DEBUG = false;
    public static final String DEFAULT_LANGUAGE_TAG = "None";
    static final String DEFAULT_LAYOUT_NAME = "Default";
    private static final int INVALID_SYSTEMS_EVENT = 0;
    private static final String TAG = "KeyboardMetricCollector";

    public static class KeyboardConfigurationEvent {
        private final InputDevice mInputDevice;
        private final boolean mIsFirstConfiguration;
        private final List<LayoutConfiguration> mLayoutConfigurations;

        public static class Builder {
            private final List<InputMethodSubtype> mImeSubtypeList;
            private final InputDevice mInputDevice;
            private boolean mIsFirstConfiguration;
            private final List<Integer> mLayoutSelectionCriteriaList;
            private final List<String> mSelectedLayoutList;

            public Builder(InputDevice inputDevice) {
                this.mImeSubtypeList = new ArrayList();
                this.mSelectedLayoutList = new ArrayList();
                this.mLayoutSelectionCriteriaList = new ArrayList();
                inputDevice.getClass();
                this.mInputDevice = inputDevice;
            }

            public Builder setIsFirstTimeConfiguration(boolean isFirstTimeConfiguration) {
                this.mIsFirstConfiguration = isFirstTimeConfiguration;
                return this;
            }

            public Builder addLayoutSelection(InputMethodSubtype imeSubtype, String selectedLayout, int layoutSelectionCriteria) {
                imeSubtype.getClass();
                if (KeyboardMetricsCollector.m4594$$Nest$smisValidSelectionCriteria(layoutSelectionCriteria) == false) goto L7;
                this.mImeSubtypeList.add(imeSubtype);
                this.mSelectedLayoutList.add(selectedLayout);
                this.mLayoutSelectionCriteriaList.add(Integer.valueOf(layoutSelectionCriteria));
                return this;
            L7:
                throw new IllegalStateException("Invalid layout selection criteria");
            }

            public KeyboardConfigurationEvent build() {
                int size = this.mImeSubtypeList.size();
                if (size == 0) goto L26;
                List<LayoutConfiguration> configurationList = new ArrayList();
                int i = 0;
            L5:
                if (i >= size) goto L24;
                int layoutSelectionCriteria = this.mLayoutSelectionCriteriaList.get(i).intValue();
                InputMethodSubtype imeSubtype = this.mImeSubtypeList.get(i);
                String keyboardLanguageTag = this.mInputDevice.getKeyboardLanguageTag();
                if (TextUtils.isEmpty(keyboardLanguageTag) == false) goto L9;
                String keyboardLanguageTag2 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
            L10:
                int keyboardLayoutType = KeyboardLayout.LayoutType.getLayoutTypeEnumValue(this.mInputDevice.getKeyboardLayoutType());
                ULocale pkLocale = imeSubtype.getPhysicalKeyboardHintLanguageTag();
                if (pkLocale == null) goto L13;
                String imeLanguageTag = pkLocale.toLanguageTag();
            L15:
                if (TextUtils.isEmpty(imeLanguageTag) == false) goto L17;
                String imeLanguageTag2 = KeyboardMetricsCollector.DEFAULT_LANGUAGE_TAG;
            L18:
                int imeLayoutType = KeyboardLayout.LayoutType.getLayoutTypeEnumValue(imeSubtype.getPhysicalKeyboardHintLayoutType());
                if (this.mSelectedLayoutList.get(i) != null) goto L21;
                String r6 = KeyboardMetricsCollector.DEFAULT_LAYOUT_NAME;
            L22:
                String keyboardLayoutName = r6;
                configurationList.add(new LayoutConfiguration(keyboardLayoutType, keyboardLanguageTag2, keyboardLayoutName, layoutSelectionCriteria, imeLayoutType, imeLanguageTag2, null));
                i = i + 1;
                goto L5
            L21:
                r6 = this.mSelectedLayoutList.get(i);
                goto L22
            L17:
                imeLanguageTag2 = imeLanguageTag;
                goto L18
            L13:
                imeLanguageTag = imeSubtype.getCanonicalizedLanguageTag();
                goto L15
            L9:
                keyboardLanguageTag2 = keyboardLanguageTag;
                goto L10
            L24:
                return new KeyboardConfigurationEvent(this.mInputDevice, this.mIsFirstConfiguration, configurationList, null);
            L26:
                throw new IllegalStateException("Should have at least one configuration");
            }
        }

        /* synthetic */ KeyboardConfigurationEvent(InputDevice r1, boolean r2, List r3, KeyboardMetricsCollectorIA r4) {
            this(r1, r2, r3);
        }

        private KeyboardConfigurationEvent(InputDevice inputDevice, boolean isFirstConfiguration, List<LayoutConfiguration> layoutConfigurations) {
            this.mInputDevice = inputDevice;
            this.mIsFirstConfiguration = isFirstConfiguration;
            this.mLayoutConfigurations = layoutConfigurations;
        }

        public int getVendorId() {
            return this.mInputDevice.getVendorId();
        }

        public int getProductId() {
            return this.mInputDevice.getProductId();
        }

        public int getDeviceBus() {
            return this.mInputDevice.getDeviceBus();
        }

        public boolean isFirstConfiguration() {
            return this.mIsFirstConfiguration;
        }

        public List<LayoutConfiguration> getLayoutConfigurations() {
            return this.mLayoutConfigurations;
        }

        public String toString() {
            return "InputDevice = {VendorId = " + Integer.toHexString(getVendorId()) + ", ProductId = " + Integer.toHexString(getProductId()) + ", Device Bus = " + Integer.toHexString(getDeviceBus()) + "}, isFirstConfiguration = " + this.mIsFirstConfiguration + ", LayoutConfigurations = " + this.mLayoutConfigurations;
        }
    }

    static class LayoutConfiguration {
        public final String imeLanguageTag;
        public final int imeLayoutType;
        public final String keyboardLanguageTag;
        public final String keyboardLayoutName;
        public final int keyboardLayoutType;
        public final int layoutSelectionCriteria;

        /* synthetic */ LayoutConfiguration(int r1, String r2, String r3, int r4, int r5, String r6, KeyboardMetricsCollectorIA r7) {
            this(r1, r2, r3, r4, r5, r6);
        }

        private LayoutConfiguration(int keyboardLayoutType, String keyboardLanguageTag, String keyboardLayoutName, int layoutSelectionCriteria, int imeLayoutType, String imeLanguageTag) {
            this.keyboardLayoutType = keyboardLayoutType;
            this.keyboardLanguageTag = keyboardLanguageTag;
            this.keyboardLayoutName = keyboardLayoutName;
            this.layoutSelectionCriteria = layoutSelectionCriteria;
            this.imeLayoutType = imeLayoutType;
            this.imeLanguageTag = imeLanguageTag;
        }

        public String toString() {
            return "{keyboardLanguageTag = " + this.keyboardLanguageTag + " keyboardLayoutType = " + KeyboardLayout.LayoutType.getLayoutNameFromValue(this.keyboardLayoutType) + " keyboardLayoutName = " + this.keyboardLayoutName + " layoutSelectionCriteria = " + KeyboardLayoutSelectionResult.layoutSelectionCriteriaToString(this.layoutSelectionCriteria) + " imeLanguageTag = " + this.imeLanguageTag + " imeLayoutType = " + KeyboardLayout.LayoutType.getLayoutNameFromValue(this.imeLayoutType) + "}";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smisValidSelectionCriteria, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4594$$Nest$smisValidSelectionCriteria(int r0) {
        return isValidSelectionCriteria(r0);
    }

    public KeyboardMetricsCollector() {
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public static void logKeyboardSystemsEventReportedAtom(InputDevice inputDevice, int[] keycodes, int modifierState, int systemsEvent) {
        if (systemsEvent == 0) goto L13;
        if (inputDevice.isVirtual() == true) goto L13;
        if (inputDevice.isFullKeyboard() == false) goto L15;
        FrameworkStatsLog.write(FrameworkStatsLog.KEYBOARD_SYSTEMS_EVENT_REPORTED, inputDevice.getVendorId(), inputDevice.getProductId(), systemsEvent, keycodes, modifierState, inputDevice.getDeviceBus());
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Logging Keyboard system event: " + modifierState + " + " + Arrays.toString(keycodes) + " -> " + systemsEvent);
        return;
    L14:
        return;
    L15:
        return;
    }

    public static void logKeyboardConfiguredAtom(KeyboardConfigurationEvent event) {
        ProtoOutputStream proto = new ProtoOutputStream();
        Iterator<LayoutConfiguration> r1 = event.getLayoutConfigurations().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        LayoutConfiguration layoutConfiguration = r1.next();
        addKeyboardLayoutConfigurationToProto(proto, layoutConfiguration);
        goto L4
    L6:
        FrameworkStatsLog.write(FrameworkStatsLog.KEYBOARD_CONFIGURED, event.isFirstConfiguration(), event.getVendorId(), event.getProductId(), proto.getBytes(), event.getDeviceBus());
        if (DEBUG == false) goto L11;
        Slog.d(TAG, "Logging Keyboard configuration event: " + event);
        return;
    }

    private static void addKeyboardLayoutConfigurationToProto(ProtoOutputStream proto, LayoutConfiguration layoutConfiguration) {
        long keyboardLayoutConfigToken = proto.start(2246267895809L);
        proto.write(1138166333442L, layoutConfiguration.keyboardLanguageTag);
        proto.write(1120986464257L, layoutConfiguration.keyboardLayoutType);
        proto.write(1138166333443L, layoutConfiguration.keyboardLayoutName);
        proto.write(1120986464260L, layoutConfiguration.layoutSelectionCriteria);
        proto.write(1138166333446L, layoutConfiguration.imeLanguageTag);
        proto.write(1120986464261L, layoutConfiguration.imeLayoutType);
        proto.end(keyboardLayoutConfigToken);
    }

    private static boolean isValidSelectionCriteria(int layoutSelectionCriteria) {
        if (layoutSelectionCriteria != 1) goto L5;
        return true;
    L5:
        if (layoutSelectionCriteria != 2) goto L7;
        return true;
    L7:
        if (layoutSelectionCriteria != 3) goto L9;
        return true;
    L9:
        if (layoutSelectionCriteria == 4) goto L16;
        return false;
    L16:
        return true;
    }
}
