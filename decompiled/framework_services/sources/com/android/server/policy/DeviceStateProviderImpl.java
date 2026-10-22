package com.android.server.policy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.devicestate.DeviceState;
import android.os.Environment;
import android.os.PowerManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.util.Preconditions;
import com.android.server.LocalServices;
import com.android.server.devicestate.DeviceStateProvider;
import com.android.server.input.InputManagerInternal;
import com.android.server.policy.devicestate.config.Conditions;
import com.android.server.policy.devicestate.config.DeviceStateConfig;
import com.android.server.policy.devicestate.config.LidSwitchCondition;
import com.android.server.policy.devicestate.config.NumericRange;
import com.android.server.policy.devicestate.config.Properties;
import com.android.server.policy.devicestate.config.SensorCondition;
import com.android.server.policy.devicestate.config.XmlParser;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceStateProviderImpl implements DeviceStateProvider, InputManagerInternal.LidSwitchCallback, SensorEventListener, PowerManager.OnThermalStatusChangedListener {
    private static final String CONFIG_FILE_NAME = "device_state_configuration.xml";
    private static final String DATA_CONFIG_FILE_PATH = "system/devicestate/";
    private static final boolean DEBUG = false;
    static final DeviceState DEFAULT_DEVICE_STATE = null;
    private static final BooleanSupplier FALSE_BOOLEAN_SUPPLIER = null;
    private static final String FLAG_APP_INACCESSIBLE = "FLAG_APP_INACCESSIBLE";
    private static final String FLAG_CANCEL_OVERRIDE_REQUESTS = "FLAG_CANCEL_OVERRIDE_REQUESTS";
    private static final String FLAG_CANCEL_WHEN_REQUESTER_NOT_ON_TOP = "FLAG_CANCEL_WHEN_REQUESTER_NOT_ON_TOP";
    private static final String FLAG_EMULATED_ONLY = "FLAG_EMULATED_ONLY";
    private static final String FLAG_UNSUPPORTED_WHEN_POWER_SAVE_MODE = "FLAG_UNSUPPORTED_WHEN_POWER_SAVE_MODE";
    private static final String FLAG_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL = "FLAG_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL";
    private static final String PROPERTY_APP_INACCESSIBLE = "com.android.server.policy.PROPERTY_APP_INACCESSIBLE";
    private static final String PROPERTY_EMULATED_ONLY = "com.android.server.policy.PROPERTY_EMULATED_ONLY";
    private static final String PROPERTY_EXTENDED_DEVICE_STATE_EXTERNAL_DISPLAY = "com.android.server.policy.PROPERTY_EXTENDED_DEVICE_STATE_EXTERNAL_DISPLAY";
    private static final String PROPERTY_FEATURE_DUAL_DISPLAY_INTERNAL_DEFAULT = "com.android.server.policy.PROPERTY_FEATURE_DUAL_DISPLAY_INTERNAL_DEFAULT";
    private static final String PROPERTY_FEATURE_REAR_DISPLAY = "com.android.server.policy.PROPERTY_FEATURE_REAR_DISPLAY";
    private static final String PROPERTY_FEATURE_REAR_DISPLAY_OUTER_DEFAULT = "com.android.server.policy.PROPERTY_FEATURE_REAR_DISPLAY_OUTER_DEFAULT";
    private static final String PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_INNER_PRIMARY = "com.android.server.policy.PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_INNER_PRIMARY";
    private static final String PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_OUTER_PRIMARY = "com.android.server.policy.PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_OUTER_PRIMARY";
    private static final String PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_CLOSED = "com.android.server.policy.PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_CLOSED";
    private static final String PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_HALF_OPEN = "com.android.server.policy.PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_HALF_OPEN";
    private static final String PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_OPEN = "com.android.server.policy.PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_OPEN";
    private static final String PROPERTY_POLICY_AVAILABLE_FOR_APP_REQUEST = "com.android.server.policy.PROPERTY_POLICY_AVAILABLE_FOR_APP_REQUEST";
    private static final String PROPERTY_POLICY_CANCEL_OVERRIDE_REQUESTS = "com.android.server.policy.PROPERTY_POLICY_CANCEL_OVERRIDE_REQUESTS";
    private static final String PROPERTY_POLICY_CANCEL_WHEN_REQUESTER_NOT_ON_TOP = "com.android.server.policy.PROPERTY_POLICY_CANCEL_WHEN_REQUESTER_NOT_ON_TOP";
    private static final String PROPERTY_POLICY_UNSUPPORTED_WHEN_POWER_SAVE_MODE = "com.android.server.policy.PROPERTY_POLICY_UNSUPPORTED_WHEN_POWER_SAVE_MODE";
    private static final String PROPERTY_POLICY_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL = "com.android.server.policy.PROPERTY_POLICY_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL";
    private static final String PROPERTY_POWER_CONFIGURATION_TRIGGER_SLEEP = "com.android.server.policy.PROPERTY_POWER_CONFIGURATION_TRIGGER_SLEEP";
    private static final String PROPERTY_POWER_CONFIGURATION_TRIGGER_WAKE = "com.android.server.policy.PROPERTY_POWER_CONFIGURATION_TRIGGER_WAKE";
    private static final String TAG = "DeviceStateProviderImpl";
    private static final BooleanSupplier TRUE_BOOLEAN_SUPPLIER = null;
    private static final String VENDOR_CONFIG_FILE_PATH = "etc/devicestate/";
    private final Context mContext;
    private Boolean mIsLidOpen;
    private int mLastReportedState;
    private final Map<Sensor, SensorEvent> mLatestSensorEvent;
    private DeviceStateProvider.Listener mListener;
    private final Object mLock;
    private final DeviceState[] mOrderedStates;
    private boolean mPowerSaveModeEnabled;
    private final SparseArray<BooleanSupplier> mStateConditions;
    private int mThermalStatus;

    private static final class AndBooleanSupplier implements BooleanSupplier {
        List<BooleanSupplier> mBooleanSuppliers;

        AndBooleanSupplier(List<BooleanSupplier> booleanSuppliers) {
            this.mBooleanSuppliers = booleanSuppliers;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            int i = 0;
        L4:
            if (i >= this.mBooleanSuppliers.size()) goto L10;
            if (this.mBooleanSuppliers.get(i).getAsBoolean() == false) goto L7;
            i = i + 1;
            goto L4
        L7:
            return false;
        L10:
            return true;
        }
    }

    private final class LidSwitchBooleanSupplier implements BooleanSupplier {
        private final boolean mExpectedOpen;
        final /* synthetic */ DeviceStateProviderImpl this$0;

        LidSwitchBooleanSupplier(DeviceStateProviderImpl r1, boolean expectedOpen) {
            this.this$0 = r1;
            this.mExpectedOpen = expectedOpen;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            Object r0 = DeviceStateProviderImpl.m7129$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (DeviceStateProviderImpl.m7127$$Nest$fgetmIsLidOpen(this.this$0) == null) goto L15;
            if (DeviceStateProviderImpl.m7127$$Nest$fgetmIsLidOpen(this.this$0).booleanValue() != this.mExpectedOpen) goto L9;
            boolean r1 = true;
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            r1 = false;
            goto L10
        L15:
            throw new IllegalStateException("Have not received lid switch value.");     // Catch: Throwable -> L12
        }
    }

    interface ReadableConfig {
        InputStream openRead() throws IOException;
    }

    private static final class ReadableFileConfig implements ReadableConfig {
        private final File mFile;

        /* synthetic */ ReadableFileConfig(File r1, DeviceStateProviderImplIA r2) {
            this(r1);
        }

        private ReadableFileConfig(File file) {
            this.mFile = file;
        }

        @Override // com.android.server.policy.DeviceStateProviderImpl.ReadableConfig
        public InputStream openRead() throws IOException {
            return new FileInputStream(this.mFile);
        }
    }

    private final class SensorBooleanSupplier implements BooleanSupplier {
        private final List<NumericRange> mExpectedValues;
        private final Sensor mSensor;
        final /* synthetic */ DeviceStateProviderImpl this$0;

        SensorBooleanSupplier(DeviceStateProviderImpl r1, Sensor sensor, List<NumericRange> expectedValues) {
            this.this$0 = r1;
            this.mSensor = sensor;
            this.mExpectedValues = expectedValues;
        }

        @Override // java.util.function.BooleanSupplier
        public boolean getAsBoolean() {
            Object r0 = DeviceStateProviderImpl.m7129$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            SensorEvent latestEvent = (SensorEvent) DeviceStateProviderImpl.m7128$$Nest$fgetmLatestSensorEvent(this.this$0).get(this.mSensor);     // Catch: Throwable -> L16
            if (latestEvent == null) goto L26;
            if (latestEvent.values.length < this.mExpectedValues.size()) goto L24;
            int i = 0;
        L10:
            if (i >= this.mExpectedValues.size()) goto L20;
            if (adheresToRange(latestEvent.values[i], this.mExpectedValues.get(i)) == false) goto L13;
            i = i + 1;     // Catch: Throwable -> L16
            goto L10
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return false;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return true;
        L24:
            throw new RuntimeException("Number of supplied numeric range(s) does not match the number of values in the latest sensor event for sensor: " + this.mSensor);     // Catch: Throwable -> L16
        L26:
            throw new IllegalStateException("Have not received sensor event.");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            throw th;
        }

        private boolean adheresToRange(float value, NumericRange range) {
            BigDecimal min = range.getMin_optional();
            if (min != null) goto L5;
        L7:
            BigDecimal minInclusive = range.getMinInclusive_optional();
            if (minInclusive != null) goto L10;
        L12:
            BigDecimal max = range.getMax_optional();
            if (max != null) goto L15;
        L17:
            BigDecimal maxInclusive = range.getMaxInclusive_optional();
            if (maxInclusive != null) goto L20;
            return true;
        L20:
            if (value <= maxInclusive.floatValue()) goto L24;
            return false;
        L24:
            return true;
        L15:
            if (value < max.floatValue()) goto L17;
            return false;
        L10:
            if (value >= minInclusive.floatValue()) goto L12;
            return false;
        L5:
            if (value > min.floatValue()) goto L7;
            return false;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$bgz4Cv-Vfw4TPvy7PVfVmwLTs14, reason: not valid java name */
    public static /* synthetic */ boolean m7126$r8$lambda$bgz4CvVfw4TPvy7PVfVmwLTs14() {
        return lambda$static$1();
    }

    public static /* synthetic */ boolean $r8$lambda$t8JSrrBv0J146lhB0w0iIONBa0A() {
        return lambda$static$0();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsLidOpen, reason: not valid java name */
    static /* bridge */ /* synthetic */ Boolean m7127$$Nest$fgetmIsLidOpen(DeviceStateProviderImpl r0) {
        return r0.mIsLidOpen;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLatestSensorEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m7128$$Nest$fgetmLatestSensorEvent(DeviceStateProviderImpl r0) {
        return r0.mLatestSensorEvent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7129$$Nest$fgetmLock(DeviceStateProviderImpl r0) {
        return r0.mLock;
    }

    static {
        TRUE_BOOLEAN_SUPPLIER = new DeviceStateProviderImpl$$ExternalSyntheticLambda0();
        FALSE_BOOLEAN_SUPPLIER = new DeviceStateProviderImpl$$ExternalSyntheticLambda1();
        DEFAULT_DEVICE_STATE = new DeviceState(new DeviceState.Configuration.Builder(0, "DEFAULT").build());
    }

    private static /* synthetic */ boolean lambda$static$0() {
        return true;
    }

    private static /* synthetic */ boolean lambda$static$1() {
        return false;
    }

    public static DeviceStateProviderImpl create(Context context) {
        File configFile = getConfigurationFile();
        DeviceStateProviderImplIA r1 = null;
        if (configFile != null) goto L7;
        return createFromConfig(context, null);
    L7:
        return createFromConfig(context, new ReadableFileConfig(configFile, r1));
    }

    static DeviceStateProviderImpl createFromConfig(Context context, ReadableConfig readableConfig) {
        List<DeviceState> deviceStateList = new ArrayList();
        List<Conditions> conditionsList = new ArrayList();
        if (readableConfig == null) goto L27;
        DeviceStateConfig config = parseConfig(readableConfig);
        if (config == null) goto L27;
        Iterator<com.android.server.policy.devicestate.config.DeviceState> r3 = config.getDeviceState().iterator();
    L8:
        if (r3.hasNext() == false) goto L27;
        com.android.server.policy.devicestate.config.DeviceState stateConfig = r3.next();
        int state = stateConfig.getIdentifier().intValue();
        if (stateConfig.getName() != null) goto L12;
        String name = "";
    L13:
        Set<Integer> systemProperties = new HashSet();
        Set<Integer> physicalProperties = new HashSet();
        Properties configProperties = stateConfig.getProperties();
        if (configProperties == null) goto L19;
        List<String> configPropertyStrings = configProperties.getProperty();
        int i = 0;
    L17:
        if (i >= configPropertyStrings.size()) goto L19;
        String configPropertyString = configPropertyStrings.get(i);
        addPropertyByString(configPropertyString, systemProperties, physicalProperties);
        i = i + 1;
    L19:
        com.android.server.policy.devicestate.config.Flags configFlags = stateConfig.getFlags();
        if (configFlags == null) goto L25;
        List<String> configFlagStrings = configFlags.getFlag();
        int i2 = 0;
    L23:
        if (i2 >= configFlagStrings.size()) goto L25;
        String configFlagString = configFlagStrings.get(i2);
        addFlagByString(configFlagString, systemProperties);
        i2 = i2 + 1;
    L25:
        DeviceState.Configuration deviceStateConfiguration = new DeviceState.Configuration.Builder(state, name).setSystemProperties(systemProperties).setPhysicalProperties(physicalProperties).build();
        deviceStateList.add(new DeviceState(deviceStateConfiguration));
        Conditions condition = stateConfig.getConditions();
        conditionsList.add(condition);
        goto L8
    L12:
        name = stateConfig.getName();
    L27:
        if (deviceStateList.isEmpty() == false) goto L30;
        deviceStateList.add(DEFAULT_DEVICE_STATE);
        conditionsList.add(null);
    L30:
        return new DeviceStateProviderImpl(context, deviceStateList, conditionsList);
    }

    private static void addPropertyByString(String propertyString, Set<Integer> systemProperties, Set<Integer> physicalProperties) {
        switch(propertyString.hashCode()) {
            case -2049159887: goto L57;
            case -1924910618: goto L54;
            case -1722863955: goto L51;
            case -1628585137: goto L48;
            case -1474991328: goto L45;
            case -1311371109: goto L42;
            case -1119149719: goto L39;
            case -296614396: goto L36;
            case -184629335: goto L33;
            case -47471589: goto L30;
            case 716062204: goto L27;
            case 989265137: goto L24;
            case 1003429125: goto L21;
            case 1091897292: goto L18;
            case 1178406448: goto L15;
            case 1533529885: goto L12;
            case 1755933010: goto L9;
            case 1962416929: goto L6;
            default: goto L59;
        };
    L59:
        byte r3 = -1;
    L60:
        switch(r3) {
            case 0: goto L79;
            case 1: goto L78;
            case 2: goto L77;
            case 3: goto L76;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            case 8: goto L71;
            case 9: goto L70;
            case 10: goto L69;
            case 11: goto L68;
            case 12: goto L67;
            case 13: goto L66;
            case 14: goto L65;
            case 15: goto L64;
            case 16: goto L63;
            case 17: goto L62;
            default: goto L61;
        };
    L61:
        Slog.w(TAG, "Parsed unknown flag with name: " + propertyString);
        return;
    L62:
        systemProperties.add(1001);
        return;
    L63:
        systemProperties.add(17);
        return;
    L64:
        systemProperties.add(16);
        return;
    L65:
        systemProperties.add(15);
        return;
    L66:
        systemProperties.add(14);
        return;
    L67:
        systemProperties.add(13);
        return;
    L68:
        systemProperties.add(12);
        return;
    L69:
        systemProperties.add(11);
        return;
    L70:
        systemProperties.add(10);
        return;
    L71:
        systemProperties.add(9);
        return;
    L72:
        systemProperties.add(8);
        return;
    L73:
        systemProperties.add(7);
        return;
    L74:
        systemProperties.add(6);
        return;
    L75:
        systemProperties.add(5);
        return;
    L76:
        systemProperties.add(4);
        return;
    L77:
        physicalProperties.add(3);
        return;
    L78:
        physicalProperties.add(2);
        return;
    L79:
        physicalProperties.add(1);
        return;
    L6:
        if (propertyString.equals(PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_OUTER_PRIMARY) == false) goto L59;
        r3 = 10;
        goto L60
    L9:
        if (propertyString.equals(PROPERTY_POLICY_CANCEL_OVERRIDE_REQUESTS) == false) goto L59;
        r3 = 3;
        goto L60
    L12:
        if (propertyString.equals(PROPERTY_FEATURE_REAR_DISPLAY) == false) goto L59;
        r3 = 15;
        goto L60
    L15:
        if (propertyString.equals(PROPERTY_POLICY_UNSUPPORTED_WHEN_POWER_SAVE_MODE) == false) goto L59;
        r3 = 6;
        goto L60
    L18:
        if (propertyString.equals(PROPERTY_EXTENDED_DEVICE_STATE_EXTERNAL_DISPLAY) == false) goto L59;
        r3 = 14;
        goto L60
    L21:
        if (propertyString.equals(PROPERTY_POLICY_AVAILABLE_FOR_APP_REQUEST) == false) goto L59;
        r3 = 7;
        goto L60
    L24:
        if (propertyString.equals(PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_HALF_OPEN) == false) goto L59;
        r3 = 1;
        goto L60
    L27:
        if (propertyString.equals(PROPERTY_FOLDABLE_DISPLAY_CONFIGURATION_INNER_PRIMARY) == false) goto L59;
        r3 = 11;
        goto L60
    L30:
        if (propertyString.equals(PROPERTY_POWER_CONFIGURATION_TRIGGER_WAKE) == false) goto L59;
        r3 = 13;
        goto L60
    L33:
        if (propertyString.equals(PROPERTY_FEATURE_DUAL_DISPLAY_INTERNAL_DEFAULT) == false) goto L59;
        r3 = 16;
        goto L60
    L36:
        if (propertyString.equals(PROPERTY_POLICY_CANCEL_WHEN_REQUESTER_NOT_ON_TOP) == false) goto L59;
        r3 = 4;
        goto L60
    L39:
        if (propertyString.equals(PROPERTY_POLICY_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL) == false) goto L59;
        r3 = 5;
        goto L60
    L42:
        if (propertyString.equals(PROPERTY_FEATURE_REAR_DISPLAY_OUTER_DEFAULT) == false) goto L59;
        r3 = 17;
        goto L60
    L45:
        if (propertyString.equals(PROPERTY_POWER_CONFIGURATION_TRIGGER_SLEEP) == false) goto L59;
        r3 = 12;
        goto L60
    L48:
        if (propertyString.equals(PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_OPEN) == false) goto L59;
        r3 = 2;
        goto L60
    L51:
        if (propertyString.equals(PROPERTY_EMULATED_ONLY) == false) goto L59;
        r3 = 9;
        goto L60
    L54:
        if (propertyString.equals(PROPERTY_APP_INACCESSIBLE) == false) goto L59;
        r3 = 8;
        goto L60
    L57:
        if (propertyString.equals(PROPERTY_FOLDABLE_HARDWARE_CONFIGURATION_FOLD_IN_CLOSED) == false) goto L59;
        r3 = 0;
        goto L60
    }

    private static void addFlagByString(String flagString, Set<Integer> systemProperties) {
        switch(flagString.hashCode()) {
            case -1145436729: goto L21;
            case -1134441332: goto L18;
            case -1054037563: goto L15;
            case -900521097: goto L12;
            case 574499747: goto L9;
            case 1671240668: goto L6;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            default: goto L25;
        };
    L25:
        Slog.w(TAG, "Parsed unknown flag with name: " + flagString);
        return;
    L26:
        systemProperties.add(6);
        return;
    L27:
        systemProperties.add(7);
        return;
    L28:
        systemProperties.add(5);
        return;
    L29:
        systemProperties.add(4);
        return;
    L30:
        systemProperties.add(10);
        return;
    L31:
        systemProperties.add(9);
        return;
    L6:
        if (flagString.equals(FLAG_UNSUPPORTED_WHEN_THERMAL_STATUS_CRITICAL) == false) goto L23;
        r0 = 5;
        goto L24
    L9:
        if (flagString.equals(FLAG_UNSUPPORTED_WHEN_POWER_SAVE_MODE) == false) goto L23;
        r0 = 4;
        goto L24
    L12:
        if (flagString.equals(FLAG_CANCEL_WHEN_REQUESTER_NOT_ON_TOP) == false) goto L23;
        r0 = 3;
        goto L24
    L15:
        if (flagString.equals(FLAG_CANCEL_OVERRIDE_REQUESTS) == false) goto L23;
        r0 = 2;
        goto L24
    L18:
        if (flagString.equals(FLAG_APP_INACCESSIBLE) == false) goto L23;
        r0 = 0;
        goto L24
    L21:
        if (flagString.equals(FLAG_EMULATED_ONLY) == false) goto L23;
        r0 = 1;
        goto L24
    }

    private DeviceStateProviderImpl(Context context, List<DeviceState> deviceStates, List<Conditions> stateConditions) {
        this.mLock = new Object();
        this.mStateConditions = new SparseArray();
        this.mListener = null;
        this.mLastReportedState = -1;
        this.mLatestSensorEvent = new ArrayMap();
        boolean r0 = false;
        this.mThermalStatus = 0;
        if (deviceStates.size() != stateConditions.size()) goto L5;
        r0 = true;
    L5:
        Preconditions.checkArgument(r0, "Number of device states must be equal to the number of device state conditions.");
        this.mContext = context;
        DeviceState[] orderedStates = (DeviceState[]) deviceStates.toArray(new DeviceState[deviceStates.size()]);
        Arrays.sort(orderedStates, Comparator.comparingInt(new DeviceStateProviderImpl$$ExternalSyntheticLambda2()));
        this.mOrderedStates = orderedStates;
        setStateConditions(deviceStates, stateConditions);
        final PowerManager powerManager = (PowerManager) context.getSystemService(PowerManager.class);
        if (powerManager != null) goto L8;
        return;
    L8:
        if (hasThermalSensitiveState(deviceStates) == false) goto L11;
        powerManager.addThermalStatusListener(this);
    L11:
        if (hasPowerSaveSensitiveState(deviceStates) == false) goto L15;
        IntentFilter filter = new IntentFilter("android.os.action.POWER_SAVE_MODE_CHANGED_INTERNAL");
        BroadcastReceiver receiver = new AnonymousClass1(this, powerManager);
        this.mContext.registerReceiver(receiver, filter);
        return;
    }

    private void setStateConditions(List<DeviceState> deviceStates, List<Conditions> stateConditions) {
        boolean shouldListenToLidSwitch = false;
        ArraySet<Sensor> sensorsToListenTo = new ArraySet();
        int i = 0;
    L4:
        if (i >= stateConditions.size()) goto L35;
        int state = deviceStates.get(i).getIdentifier();
        Conditions conditions = stateConditions.get(i);
        if (conditions == null) goto L8;
        boolean allRequiredComponentsFound = true;
        boolean lidSwitchRequired = false;
        ArraySet<Sensor> sensorsRequired = new ArraySet();
        List<BooleanSupplier> suppliers = new ArrayList();
        LidSwitchCondition lidSwitchCondition = conditions.getLidSwitch();
        if (lidSwitchCondition == null) goto L14;
        suppliers.add(new LidSwitchBooleanSupplier(this, lidSwitchCondition.getOpen()));
        lidSwitchRequired = true;
    L14:
        List<SensorCondition> sensorConditions = conditions.getSensor();
        int j = 0;
    L16:
        if (j >= sensorConditions.size()) goto L21;
        SensorCondition sensorCondition = sensorConditions.get(j);
        String expectedSensorType = sensorCondition.getType();
        boolean shouldListenToLidSwitch2 = shouldListenToLidSwitch;
        String expectedSensorName = sensorCondition.getName();
        int i2 = i;
        Sensor foundSensor = findSensor(expectedSensorType, expectedSensorName);
        if (foundSensor == null) goto L19;
        suppliers.add(new SensorBooleanSupplier(this, foundSensor, sensorCondition.getValue()));
        sensorsRequired.add(foundSensor);
        j = j + 1;
        shouldListenToLidSwitch = shouldListenToLidSwitch2;
        i = i2;
        goto L16
    L19:
        Slog.e(TAG, "Failed to find Sensor with type: " + expectedSensorType + " and name: " + expectedSensorName);
        allRequiredComponentsFound = false;
    L22:
        if (allRequiredComponentsFound == false) goto L31;
        boolean shouldListenToLidSwitch3 = shouldListenToLidSwitch2 | lidSwitchRequired;
        sensorsToListenTo.addAll(sensorsRequired);
        if (suppliers.size() <= 1) goto L27;
        this.mStateConditions.put(state, new AndBooleanSupplier(suppliers));
    L30:
        shouldListenToLidSwitch = shouldListenToLidSwitch3;
    L33:
        i = i2 + 1;
        goto L4
    L27:
        if (suppliers.size() <= 0) goto L29;
        this.mStateConditions.put(state, suppliers.get(0));
        goto L30
    L29:
        this.mStateConditions.put(state, TRUE_BOOLEAN_SUPPLIER);
        goto L30
    L31:
        this.mStateConditions.put(state, FALSE_BOOLEAN_SUPPLIER);
    L32:
        shouldListenToLidSwitch = shouldListenToLidSwitch2;
        goto L33
    L21:
        shouldListenToLidSwitch2 = shouldListenToLidSwitch;
        i2 = i;
        goto L22
    L8:
        if (deviceStates.get(i).hasProperty(10) == false) goto L10;
        this.mStateConditions.put(state, FALSE_BOOLEAN_SUPPLIER);
        shouldListenToLidSwitch2 = shouldListenToLidSwitch;
        i2 = i;
        goto L32
    L10:
        this.mStateConditions.put(state, TRUE_BOOLEAN_SUPPLIER);
        shouldListenToLidSwitch2 = shouldListenToLidSwitch;
        i2 = i;
        goto L32
    L35:
        if (shouldListenToLidSwitch == false) goto L37;
        InputManagerInternal inputManager = (InputManagerInternal) LocalServices.getService(InputManagerInternal.class);
        inputManager.registerLidSwitchCallback(this);
    L37:
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        int i3 = 0;
    L39:
        if (i3 >= sensorsToListenTo.size()) goto L42;
        Sensor sensor = sensorsToListenTo.valueAt(i3);
        sensorManager.registerListener(this, sensor, 0);
        i3 = i3 + 1;
        goto L39
    }

    private Sensor findSensor(String type, String name) {
        SensorManager sensorManager = (SensorManager) this.mContext.getSystemService(SensorManager.class);
        List<Sensor> sensors = sensorManager.getSensorList(-1);
        int sensorIndex = 0;
    L4:
        if (sensorIndex >= sensors.size()) goto L15;
        Sensor sensor = sensors.get(sensorIndex);
        String sensorType = sensor.getStringType();
        String sensorName = sensor.getName();
        if (sensorType == null) goto L14;
        if (sensorName == null) goto L14;
        if (sensorType.equals(type) == false) goto L14;
        if (sensorName.equals(name) == false) goto L14;
        return sensor;
    L14:
        sensorIndex = sensorIndex + 1;
        goto L4
    L15:
        return null;
    }

    @Override // com.android.server.devicestate.DeviceStateProvider
    public void setListener(DeviceStateProvider.Listener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener != null) goto L13;
        this.mListener = listener;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        notifySupportedStatesChanged(1);
        notifyDeviceStateChangedIfNeeded();
        return;
    L13:
        throw new RuntimeException("Provider already has a listener set.");     // Catch: Throwable -> L10
    }

    private void notifySupportedStatesChanged(int reason) {
        List<DeviceState> supportedStates = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        DeviceStateProvider.Listener listener = this.mListener;     // Catch: Throwable -> L8
        DeviceState[] r3 = this.mOrderedStates;     // Catch: Throwable -> L8
        int r4 = r3.length;     // Catch: Throwable -> L8
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L24;
        DeviceState deviceState = r3[r5];     // Catch: Throwable -> L8
        if (isThermalStatusCriticalOrAbove(this.mThermalStatus) == false) goto L18;
        if (deviceState.hasProperty(6) == false) goto L18;
    L23:
        r5 = r5 + 1;     // Catch: Throwable -> L8
    L18:
        if (this.mPowerSaveModeEnabled == true) goto L20;
    L22:
        supportedStates.add(deviceState);     // Catch: Throwable -> L8
        goto L23
    L20:
        if (deviceState.hasProperty(7) == false) goto L22;
    L24:
        monitor-exit(r1);     // Catch: Throwable -> L8
        listener.onSupportedDeviceStatesChanged((DeviceState[]) supportedStates.toArray(new DeviceState[supportedStates.size()]), reason);
    }

    void notifyDeviceStateChangedIfNeeded() {
        int stateToReport = -1;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mListener != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        int newState = -1;
        int i = 0;
    L12:
        if (i >= this.mOrderedStates.length) goto L20;
        int state = this.mOrderedStates[i].getIdentifier();     // Catch: Throwable -> L8
        boolean conditionSatisfied = this.mStateConditions.get(state).getAsBoolean();     // Catch: Throwable -> L8 IllegalStateException -> L17
        if (conditionSatisfied == false) goto L18;
        newState = state;
    L18:
        i = i + 1;
    L20:
        if (newState != (-1)) goto L22;
        Slog.e(TAG, "No declared device states match any of the required conditions.");     // Catch: Throwable -> L8
        dumpSensorValues();     // Catch: Throwable -> L8
    L22:
        if (newState != (-1)) goto L24;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L8
        if (stateToReport == (-1)) goto L39;
        this.mListener.onStateChanged(stateToReport);
        return;
    L39:
        return;
    L24:
        if (newState == this.mLastReportedState) goto L26;
        this.mLastReportedState = newState;     // Catch: Throwable -> L8
        stateToReport = newState;
        goto L26
    }

    @Override // com.android.server.input.InputManagerInternal.LidSwitchCallback
    public void notifyLidSwitchChanged(long whenNanos, boolean lidOpen) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIsLidOpen = Boolean.valueOf(lidOpen);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        notifyDeviceStateChangedIfNeeded();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLatestSensorEvent.put(event.sensor, event);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        notifyDeviceStateChangedIfNeeded();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter writer, String[] args) {
        writer.println(TAG);
        Object r0 = this.mLock;
        monitor-enter(r0);
        writer.println("  mLastReportedState = " + this.mLastReportedState);     // Catch: Throwable -> L8
        writer.println("  mPowerSaveModeEnabled = " + this.mPowerSaveModeEnabled);     // Catch: Throwable -> L8
        writer.println("  mThermalStatus = " + this.mThermalStatus);     // Catch: Throwable -> L8
        writer.println("  mIsLidOpen = " + this.mIsLidOpen);     // Catch: Throwable -> L8
        writer.println("  Sensor values:");     // Catch: Throwable -> L8
        Iterator<Sensor> r1 = this.mLatestSensorEvent.keySet().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        Sensor sensor = r1.next();     // Catch: Throwable -> L8
        SensorEvent sensorEvent = this.mLatestSensorEvent.get(sensor);     // Catch: Throwable -> L8
        writer.println("   - " + toSensorValueString(sensor, sensorEvent));     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static File getConfigurationFile() {
        File configFileFromDataDir = Environment.buildPath(Environment.getDataDirectory(), new String[]{DATA_CONFIG_FILE_PATH, CONFIG_FILE_NAME});
        if (configFileFromDataDir.exists() == false) goto L5;
        return configFileFromDataDir;
    L5:
        File configFileFromVendorDir = Environment.buildPath(Environment.getVendorDirectory(), new String[]{VENDOR_CONFIG_FILE_PATH, CONFIG_FILE_NAME});
        if (configFileFromVendorDir.exists() == false) goto L8;
        return configFileFromVendorDir;
    L8:
        return null;
    }

    private void dumpSensorValues() {
        Slog.i(TAG, "Sensor values:");
        Iterator<Sensor> r0 = this.mLatestSensorEvent.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Sensor sensor = r0.next();
        SensorEvent sensorEvent = this.mLatestSensorEvent.get(sensor);
        Slog.i(TAG, toSensorValueString(sensor, sensorEvent));
        goto L4
    }

    private String toSensorValueString(Sensor sensor, SensorEvent event) {
        String eventValues = "null";
        if (sensor != null) goto L5;
        String sensorString = "null";
    L6:
        if (event == null) goto L10;
        eventValues = Arrays.toString(event.values);
    L10:
        return sensorString + " : " + eventValues;
    L5:
        sensorString = sensor.getName();
        goto L6
    }

    private static DeviceStateConfig parseConfig(ReadableConfig readableConfig) {
        InputStream in = readableConfig.openRead();     // Catch: Throwable -> L9
        InputStream bin = new BufferedInputStream(in);     // Catch: Throwable -> L12
        DeviceStateConfig r2 = XmlParser.read(bin);     // Catch: Throwable -> L14
        bin.close();     // Catch: Throwable -> L12
        if (in == null) goto L11;
        in.close();     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L11:
        return r2;
    L14:
        th = move-exception;
        bin.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (in != null) goto L32;
    L26:
        throw th;     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L32:
        in.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L9 Throwable -> L9 Throwable -> L9
    L9:
        e = move-exception;
        Slog.e(TAG, "Encountered an error while reading device state config", e);
        return null;
    }

    void onPowerSaveModeChanged(boolean isPowerSaveModeEnabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mPowerSaveModeEnabled == isPowerSaveModeEnabled) goto L13;
        this.mPowerSaveModeEnabled = isPowerSaveModeEnabled;     // Catch: Throwable -> L11
        if (isPowerSaveModeEnabled == false) goto L9;
        int r1 = 4;
    L10:
        notifySupportedStatesChanged(r1);     // Catch: Throwable -> L11
        goto L13
    L9:
        r1 = 5;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public void onThermalStatusChanged(int thermalStatus) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int previousThermalStatus = this.mThermalStatus;     // Catch: Throwable -> L14
        this.mThermalStatus = thermalStatus;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        boolean isThermalStatusCriticalOrAbove = isThermalStatusCriticalOrAbove(thermalStatus);
        boolean isPreviousThermalStatusCriticalOrAbove = isThermalStatusCriticalOrAbove(previousThermalStatus);
        if (isThermalStatusCriticalOrAbove == isPreviousThermalStatusCriticalOrAbove) goto L19;
        Slog.i(TAG, "Updating supported device states due to thermal status change. isThermalStatusCriticalOrAbove: " + isThermalStatusCriticalOrAbove);
        if (isThermalStatusCriticalOrAbove == false) goto L11;
        int r3 = 3;
    L12:
        notifySupportedStatesChanged(r3);
        return;
    L11:
        r3 = 2;
        goto L12
    L19:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private static boolean isThermalStatusCriticalOrAbove(int thermalStatus) {
        switch(thermalStatus) {
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return false;
    L5:
        return true;
    }

    private static boolean hasThermalSensitiveState(List<DeviceState> deviceStates) {
        int i = 0;
    L4:
        if (i >= deviceStates.size()) goto L10;
        if (deviceStates.get(i).hasProperty(6) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private static boolean hasPowerSaveSensitiveState(List<DeviceState> deviceStates) {
        int i = 0;
    L4:
        if (i >= deviceStates.size()) goto L10;
        if (deviceStates.get(i).hasProperty(7) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
