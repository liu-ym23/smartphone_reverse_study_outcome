package com.android.server.wm;

import android.R;
import android.content.Context;
import android.hardware.devicestate.DeviceStateManager;
import android.util.ArrayMap;
import android.util.Pair;
import com.android.internal.hidden_from_bootclasspath.android.hardware.devicestate.feature.flags.FeatureFlagsImpl;
import com.android.internal.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
final class DeviceStateController {
    private final List<Integer> mConcurrentDisplayDeviceStates;
    private DeviceState mCurrentDeviceState;
    private int mCurrentState;
    final Map<Consumer<DeviceState>, Executor> mDeviceStateCallbacks;
    private final List<Integer> mFoldedDeviceStates;
    private final List<Integer> mHalfFoldedDeviceStates;
    private final boolean mMatchBuiltInDisplayOrientationToDefaultDisplay;
    private final List<Integer> mOpenDeviceStates;
    private final List<Integer> mRearDisplayDeviceStates;
    private final List<Integer> mReverseRotationAroundZAxisStates;
    private final WindowManagerGlobalLock mWmLock;

    public static final enum DeviceState extends Enum<DeviceState> {
        private static final /* synthetic */ DeviceState[] $VALUES = null;
        public static final DeviceState CONCURRENT = null;
        public static final DeviceState FOLDED = null;
        public static final DeviceState HALF_FOLDED = null;
        public static final DeviceState OPEN = null;
        public static final DeviceState REAR = null;
        public static final DeviceState UNKNOWN = null;

        private static /* synthetic */ DeviceState[] $values() {
            return new DeviceState[]{UNKNOWN, OPEN, FOLDED, HALF_FOLDED, REAR, CONCURRENT};
        }

        private DeviceState(String r1, int r2) {
            super(r1, r2);
        }

        public static DeviceState valueOf(String name) {
            return (DeviceState) Enum.valueOf(DeviceState.class, name);
        }

        public static DeviceState[] values() {
            return (DeviceState[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new DeviceState("UNKNOWN", 0);
            OPEN = new DeviceState("OPEN", 1);
            FOLDED = new DeviceState("FOLDED", 2);
            HALF_FOLDED = new DeviceState("HALF_FOLDED", 3);
            REAR = new DeviceState("REAR", 4);
            CONCURRENT = new DeviceState("CONCURRENT", 5);
            $VALUES = $values();
        }
    }

    public static /* synthetic */ void $r8$lambda$K13bSYJPwhwRNkEZRfzsnWOa04s(List r0, Consumer r1, Executor r2) {
        lambda$copyDeviceStateCallbacks$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$cKSxJPeDJchzkBl1iNyuTlqDNz0(Pair r0, DeviceState r1) {
        lambda$onDeviceStateReceivedByDisplayManager$0(r0, r1);
    }

    DeviceStateController(Context context, WindowManagerGlobalLock wmLock) {
        this.mDeviceStateCallbacks = new ArrayMap();
        this.mCurrentDeviceState = DeviceState.UNKNOWN;
        this.mWmLock = wmLock;
        new FeatureFlagsImpl();
        this.mOpenDeviceStates = new ArrayList();
        this.mHalfFoldedDeviceStates = new ArrayList();
        this.mFoldedDeviceStates = new ArrayList();
        this.mRearDisplayDeviceStates = new ArrayList();
        this.mConcurrentDisplayDeviceStates = new ArrayList();
        DeviceStateManager deviceStateManager = (DeviceStateManager) context.getSystemService(DeviceStateManager.class);
        List<android.hardware.devicestate.DeviceState> deviceStates = deviceStateManager.getSupportedDeviceStates();
        int i = 0;
    L4:
        if (i >= deviceStates.size()) goto L21;
        android.hardware.devicestate.DeviceState state = deviceStates.get(i);
        if (state.hasProperty(16) == false) goto L9;
        this.mRearDisplayDeviceStates.add(Integer.valueOf(state.getIdentifier()));
    L20:
        i = i + 1;
        goto L4
    L9:
        if (state.hasProperty(17) == false) goto L12;
        this.mConcurrentDisplayDeviceStates.add(Integer.valueOf(state.getIdentifier()));
        goto L20
    L12:
        if (state.hasProperty(11) == false) goto L15;
        this.mFoldedDeviceStates.add(Integer.valueOf(state.getIdentifier()));
        goto L20
    L15:
        if (state.hasProperty(12) == false) goto L20;
        if (state.hasProperty(2) == false) goto L19;
        this.mHalfFoldedDeviceStates.add(Integer.valueOf(state.getIdentifier()));
        goto L20
    L19:
        this.mOpenDeviceStates.add(Integer.valueOf(state.getIdentifier()));
        goto L20
    L21:
        this.mReverseRotationAroundZAxisStates = copyIntArrayToList(context.getResources().getIntArray(R.array.config_displayWhiteBalanceDisplayRangeMinimums));
        this.mMatchBuiltInDisplayOrientationToDefaultDisplay = context.getResources().getBoolean(R.bool.config_navBarCanMove);
    }

    void registerDeviceStateCallback(Consumer<DeviceState> callback, Executor executor) {
        WindowManagerGlobalLock r0 = this.mWmLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mDeviceStateCallbacks.put(callback, executor);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    void unregisterDeviceStateCallback(Consumer<DeviceState> callback) {
        WindowManagerGlobalLock r0 = this.mWmLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mDeviceStateCallbacks.remove(callback);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    boolean shouldReverseRotationDirectionAroundZAxis(DisplayContent displayContent) {
        if (displayContent.isDefaultDisplay == true) goto L7;
        return false;
    L7:
        return ArrayUtils.contains(this.mReverseRotationAroundZAxisStates, Integer.valueOf(this.mCurrentState));
    }

    boolean shouldMatchBuiltInDisplayOrientationToReverseDefaultDisplay() {
        return this.mMatchBuiltInDisplayOrientationToDefaultDisplay;
    }

    public void onDeviceStateReceivedByDisplayManager(int state) {
        this.mCurrentState = state;
        if (ArrayUtils.contains(this.mHalfFoldedDeviceStates, Integer.valueOf(state)) == false) goto L6;
        final DeviceState deviceState = DeviceState.HALF_FOLDED;
    L19:
        if (this.mCurrentDeviceState != null) goto L21;
    L22:
        this.mCurrentDeviceState = deviceState;
        List<Pair<Consumer<DeviceState>, Executor>> entries = copyDeviceStateCallbacks();
        int i = 0;
    L24:
        if (i >= entries.size()) goto L28;
        final Pair<Consumer<DeviceState>, Executor> entry = entries.get(i);
        ((Executor) entry.second).execute(new DeviceStateController$$ExternalSyntheticLambda1(entry, deviceState));
        i = i + 1;
        goto L24
    L28:
        return;
    L21:
        if (this.mCurrentDeviceState.equals(deviceState) == false) goto L22;
        return;
    L6:
        if (ArrayUtils.contains(this.mFoldedDeviceStates, Integer.valueOf(state)) == false) goto L9;
        deviceState = DeviceState.FOLDED;
        goto L19
    L9:
        if (ArrayUtils.contains(this.mRearDisplayDeviceStates, Integer.valueOf(state)) == false) goto L12;
        deviceState = DeviceState.REAR;
        goto L19
    L12:
        if (ArrayUtils.contains(this.mOpenDeviceStates, Integer.valueOf(state)) == false) goto L15;
        deviceState = DeviceState.OPEN;
        goto L19
    L15:
        if (ArrayUtils.contains(this.mConcurrentDisplayDeviceStates, Integer.valueOf(state)) == false) goto L17;
        deviceState = DeviceState.CONCURRENT;
        goto L19
    L17:
        deviceState = DeviceState.UNKNOWN;
        goto L19
    }

    private static /* synthetic */ void lambda$onDeviceStateReceivedByDisplayManager$0(Pair entry, DeviceState deviceState) {
        ((Consumer) entry.first).accept(deviceState);
    }

    List<Pair<Consumer<DeviceState>, Executor>> copyDeviceStateCallbacks() {
        final List<Pair<Consumer<DeviceState>, Executor>> entries = new ArrayList();
        WindowManagerGlobalLock r1 = this.mWmLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mDeviceStateCallbacks.forEach(new DeviceStateController$$ExternalSyntheticLambda0(entries));     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return entries;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private static /* synthetic */ void lambda$copyDeviceStateCallbacks$1(List entries, Consumer deviceStateConsumer, Executor executor) {
        entries.add(new Pair(deviceStateConsumer, executor));
    }

    private List<Integer> copyIntArrayToList(int[] values) {
        if (values == null) goto L4;
        List<Integer> valueList = new ArrayList();
        int i = 0;
    L7:
        if (i >= values.length) goto L10;
        valueList.add(Integer.valueOf(values[i]));
        i = i + 1;
        goto L7
    L10:
        return valueList;
    L4:
        return Collections.emptyList();
    }
}
