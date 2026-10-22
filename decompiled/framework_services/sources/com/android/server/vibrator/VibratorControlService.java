package com.android.server.vibrator;

import android.R;
import android.content.Context;
import android.frameworks.vibrator.IVibratorControlService;
import android.frameworks.vibrator.IVibratorController;
import android.frameworks.vibrator.ScaleParam;
import android.frameworks.vibrator.VibrationParam;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.VibrationAttributes;
import android.util.IndentingPrintWriter;
import android.util.IntArray;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.ArrayUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: loaded from: classes3.dex */
final class VibratorControlService extends IVibratorControlService.Stub {
    private static final DateTimeFormatter DEBUG_DATE_TIME_FORMATTER = null;
    private static final int NO_SCALE = -1;
    private static final String TAG = "VibratorControlService";
    private static final int UNRECOGNIZED_VIBRATION_TYPE = -1;
    private final Object mLock;
    private final int[] mRequestVibrationParamsForUsages;
    private final VibratorFrameworkStatsLogger mStatsLogger;
    private VibrationParamRequest mVibrationParamRequest;
    private final VibrationParamsRecords mVibrationParamsRecords;
    private final VibrationScaler mVibrationScaler;
    private final VibratorControllerHolder mVibratorControllerHolder;

    private static final class VibrationParamRequest {
        public final CompletableFuture<Void> future;
        public final IBinder token;
        public final int uid;
        public final long uptimeMs;
        public final int usage;

        VibrationParamRequest(int uid, int usage) {
            this.future = new CompletableFuture();
            this.token = new Binder();
            this.uid = uid;
            this.usage = usage;
            this.uptimeMs = SystemClock.uptimeMillis();
        }

        public void endRequest(boolean wasCancelled) {
            if (wasCancelled == false) goto L4;
            this.future.cancel(true);
            return;
        L4:
            this.future.complete(null);
        }
    }

    private static final class VibrationParamsRecords extends GroupedAggregatedLogRecords<VibrationScaleParamRecord> {

        static final enum Operation extends Enum<Operation> {
            private static final /* synthetic */ Operation[] $VALUES = null;
            public static final Operation CLEAR = null;
            public static final Operation PULL = null;
            public static final Operation PUSH = null;

            private static /* synthetic */ Operation[] $values() {
                return new Operation[]{PULL, PUSH, CLEAR};
            }

            private Operation(String r1, int r2) {
                super(r1, r2);
            }

            public static Operation valueOf(String name) {
                return (Operation) Enum.valueOf(Operation.class, name);
            }

            public static Operation[] values() {
                return (Operation[]) $VALUES.clone();
            }

            static {
                PULL = new Operation("PULL", 0);
                PUSH = new Operation("PUSH", 1);
                CLEAR = new Operation("CLEAR", 2);
                $VALUES = $values();
            }
        }

        VibrationParamsRecords(int sizeLimit, int aggregationTimeLimit) {
            super(sizeLimit, aggregationTimeLimit);
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords
        synchronized void dumpGroupHeader(IndentingPrintWriter pw, int paramType) {
            monitor-enter(this);
            if (paramType != 0) goto L7;
            pw.println("SCALE:");     // Catch: Throwable -> L5
        L8:
            monitor-exit(this);
            return;
        L7:
            pw.println("UNKNOWN:");     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords
        synchronized long findGroupKeyProtoFieldId(int usage) {
            monitor-enter(this);
            monitor-exit(this);
            return 2246267895836L;
        }
    }

    private static final class VibrationScaleParamRecord implements GroupedAggregatedLogRecords.SingleLogRecord {
        private final long mCreateTime;
        private final VibrationParamsRecords.Operation mOperation;
        private final float mScale;
        private final int mTypesMask;

        VibrationScaleParamRecord(VibrationParamsRecords.Operation operation, long createTime, int typesMask, float scale) {
            this.mOperation = operation;
            this.mCreateTime = createTime;
            this.mTypesMask = typesMask;
            this.mScale = scale;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public int getGroupKey() {
            return 0;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public long getCreateUptimeMs() {
            return this.mCreateTime;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public boolean mayAggregate(GroupedAggregatedLogRecords.SingleLogRecord record) {
            if ((record instanceof VibrationScaleParamRecord) == false) goto L10;
            VibrationScaleParamRecord param = (VibrationScaleParamRecord) record;
            if (this.mTypesMask == param.mTypesMask) goto L7;
            return false;
        L7:
            if (this.mOperation != param.mOperation) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public void dump(IndentingPrintWriter pw) {
            Locale r0 = Locale.ROOT;
            String r1 = VibratorControlService.m9316$$Nest$sfgetDEBUG_DATE_TIME_FORMATTER().withZone(ZoneId.systemDefault()).format(Instant.ofEpochMilli(this.mCreateTime));
            String r2 = this.mOperation.name().toLowerCase(Locale.ROOT);
            if (this.mScale != (-1.0f)) goto L5;
            String r3 = "";
        L6:
            String line = String.format(r0, "%s | %6s | scale: %5s | typesMask: %6s | usages: %s", new Object[]{r1, r2, r3, Long.toBinaryString(this.mTypesMask), createVibrationUsagesString()});
            pw.println(line);
            return;
        L5:
            r3 = String.format(Locale.ROOT, "%.2f", new Object[]{Float.valueOf(this.mScale)});
            goto L6
        }

        @Override // com.android.server.vibrator.GroupedAggregatedLogRecords.SingleLogRecord
        public void dump(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1112396529666L, this.mCreateTime);
            if (this.mOperation != VibrationParamsRecords.Operation.PULL) goto L5;
            boolean r2 = true;
        L6:
            proto.write(1133871366147L, r2);
            long scaleToken = proto.start(1146756268033L);
            proto.write(1120986464257L, this.mTypesMask);
            proto.write(1108101562370L, this.mScale);
            proto.end(scaleToken);
            proto.end(token);
            return;
        L5:
            r2 = false;
            goto L6
        }

        private String createVibrationUsagesString() {
            StringBuilder sb = new StringBuilder();
            int[] usages = VibratorControlService.m9317$$Nest$smmapFromAdaptiveVibrationTypeToVibrationUsages(this.mTypesMask);
            int i = 0;
        L4:
            if (i >= usages.length) goto L9;
            if (i <= 0) goto L7;
            sb.append(", ");
        L7:
            sb.append(VibrationAttributes.usageToString(usages[i]));
            i = i + 1;
            goto L4
        L9:
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG_DATE_TIME_FORMATTER, reason: not valid java name */
    static /* bridge */ /* synthetic */ DateTimeFormatter m9316$$Nest$sfgetDEBUG_DATE_TIME_FORMATTER() {
        return DEBUG_DATE_TIME_FORMATTER;
    }

    /* JADX INFO: renamed from: -$$Nest$smmapFromAdaptiveVibrationTypeToVibrationUsages, reason: not valid java name */
    static /* bridge */ /* synthetic */ int[] m9317$$Nest$smmapFromAdaptiveVibrationTypeToVibrationUsages(int r0) {
        return mapFromAdaptiveVibrationTypeToVibrationUsages(r0);
    }

    static {
        DEBUG_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss.SSS");
    }

    VibratorControlService(Context context, VibratorControllerHolder vibratorControllerHolder, VibrationScaler vibrationScaler, VibrationSettings vibrationSettings, VibratorFrameworkStatsLogger statsLogger, Object lock) {
        this.mVibrationParamRequest = null;
        this.mVibratorControllerHolder = vibratorControllerHolder;
        this.mVibrationScaler = vibrationScaler;
        this.mStatsLogger = statsLogger;
        this.mLock = lock;
        this.mRequestVibrationParamsForUsages = vibrationSettings.getRequestVibrationParamsForUsages();
        int dumpSizeLimit = context.getResources().getInteger(R.integer.config_satellite_emergency_mode_duration);
        int dumpAggregationTimeLimit = context.getResources().getInteger(R.integer.config_satellite_demo_mode_nb_iot_inactivity_timeout_millis);
        this.mVibrationParamsRecords = new VibrationParamsRecords(dumpSizeLimit, dumpAggregationTimeLimit);
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public void registerVibratorController(IVibratorController controller) {
        controller.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mVibratorControllerHolder.setVibratorController(controller);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public void unregisterVibratorController(IVibratorController controller) {
        controller.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibratorControllerHolder.getVibratorController() != null) goto L12;
        Slog.w(TAG, "Received request to unregister IVibratorController = " + controller + ", but no controller was previously registered. Request Ignored.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (Objects.equals(this.mVibratorControllerHolder.getVibratorController().asBinder(), controller.asBinder()) == true) goto L16;
        Slog.wtf(TAG, "Failed to unregister IVibratorController. The provided controller doesn't match the registered one. " + this);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        this.mVibrationScaler.clearAdaptiveHapticsScales();     // Catch: Throwable -> L9
        this.mVibratorControllerHolder.setVibratorController(null);     // Catch: Throwable -> L9
        endOngoingRequestVibrationParamsLocked(true);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public void setVibrationParams(VibrationParam[] params, IVibratorController token) {
        token.getClass();
        requireContainsNoNullElement(params);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibratorControllerHolder.getVibratorController() != null) goto L12;
        Slog.w(TAG, "Received request to set VibrationParams for IVibratorController = " + token + ", but no controller was previously registered. Request Ignored.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (Objects.equals(this.mVibratorControllerHolder.getVibratorController().asBinder(), token.asBinder()) == true) goto L16;
        Slog.wtf(TAG, "Failed to set new VibrationParams. The provided controller doesn't match the registered one. " + this);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        if (params != null) goto L20;
        Slog.d(TAG, "New vibration params received but are null. New vibration params ignored.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L20:
        updateAdaptiveHapticsScales(params);     // Catch: Throwable -> L9
        recordUpdateVibrationParams(params, false);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public void clearVibrationParams(int types, IVibratorController token) {
        token.getClass();
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibratorControllerHolder.getVibratorController() != null) goto L12;
        Slog.w(TAG, "Received request to clear VibrationParams for IVibratorController = " + token + ", but no controller was previously registered. Request Ignored.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (Objects.equals(this.mVibratorControllerHolder.getVibratorController().asBinder(), token.asBinder()) == true) goto L16;
        Slog.wtf(TAG, "Failed to clear VibrationParams. The provided controller doesn't match the registered one. " + this);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        updateAdaptiveHapticsScales(types, -1.0f);     // Catch: Throwable -> L9
        recordClearVibrationParams(types);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public void onRequestVibrationParamsComplete(IBinder requestToken, VibrationParam[] result) {
        requestToken.getClass();
        requireContainsNoNullElement(result);
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibrationParamRequest != null) goto L12;
        Slog.wtf(TAG, "New vibration params received but no token was cached in the service. New vibration params ignored.");     // Catch: Throwable -> L9
        this.mStatsLogger.logVibrationParamResponseIgnored();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (Objects.equals(requestToken, this.mVibrationParamRequest.token) == true) goto L16;
        Slog.w(TAG, "New vibration params received but the provided token does not match the cached one. New vibration params ignored.");     // Catch: Throwable -> L9
        this.mStatsLogger.logVibrationParamResponseIgnored();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        long latencyMs = SystemClock.uptimeMillis() - this.mVibrationParamRequest.uptimeMs;     // Catch: Throwable -> L9
        this.mStatsLogger.logVibrationParamRequestLatency(this.mVibrationParamRequest.uid, latencyMs);     // Catch: Throwable -> L9
        if (result != null) goto L21;
        Slog.d(TAG, "New vibration params received but are null. New vibration params ignored.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L21:
        updateAdaptiveHapticsScales(result);     // Catch: Throwable -> L9
        endOngoingRequestVibrationParamsLocked(false);     // Catch: Throwable -> L9
        recordUpdateVibrationParams(result, true);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public int getInterfaceVersion() {
        return 1;
    }

    @Override // android.frameworks.vibrator.IVibratorControlService
    public String getInterfaceHash() {
        return "eb095ed3034973273898ca9e37bbc72566392b8a";
    }

    public CompletableFuture<Void> triggerVibrationParamsRequest(int uid, int usage, int timeoutInMillis) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IVibratorController vibratorController = this.mVibratorControllerHolder.getVibratorController();     // Catch: Throwable -> L9
        if (vibratorController != null) goto L11;
        Slog.d(TAG, "Unable to request vibration params. There is no registered IVibrationController.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        int vibrationType = mapToAdaptiveVibrationType(usage);     // Catch: Throwable -> L9
        if (vibrationType != (-1)) goto L17;
        Slog.d(TAG, "Unable to request vibration params. The provided usage " + usage + " is unrecognized.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L17:
        if (this.mVibrationParamRequest == null) goto L34;
        if (this.mVibrationParamRequest.usage != usage) goto L34;
        CompletableFuture<Void> r2 = this.mVibrationParamRequest.future;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L34:
        endOngoingRequestVibrationParamsLocked(true);     // Catch: Throwable -> L9 RemoteException -> L27
        this.mVibrationParamRequest = new VibrationParamRequest(uid, usage);     // Catch: Throwable -> L9 RemoteException -> L27
        vibratorController.requestVibrationParams(vibrationType, timeoutInMillis, this.mVibrationParamRequest.token);     // Catch: Throwable -> L9 RemoteException -> L27
        CompletableFuture<Void> r3 = this.mVibrationParamRequest.future;     // Catch: Throwable -> L9 RemoteException -> L27
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L27:
        e = move-exception;
        Slog.e(TAG, "Failed to request vibration params.", e);     // Catch: Throwable -> L9
        endOngoingRequestVibrationParamsLocked(true);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    public boolean shouldRequestVibrationParams(int usage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IVibratorController vibratorController = this.mVibratorControllerHolder.getVibratorController();     // Catch: Throwable -> L9
        if (vibratorController != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return false;
    L11:
        boolean r2 = ArrayUtils.contains(this.mRequestVibrationParamsForUsages, usage);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    public IBinder getRequestVibrationParamsToken() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibrationParamRequest != null) goto L7;
        IBinder r1 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = this.mVibrationParamRequest.token;     // Catch: Throwable -> L10
        goto L8
    }

    void dump(IndentingPrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean hasPendingVibrationParamsRequest = false;
        if (this.mVibratorControllerHolder.getVibratorController() == null) goto L7;
        boolean isVibratorControllerRegistered = true;
    L9:
        if (this.mVibrationParamRequest == null) goto L11;
        hasPendingVibrationParamsRequest = true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        pw.println("VibratorControlService:");
        pw.increaseIndent();
        pw.println("isVibratorControllerRegistered = " + isVibratorControllerRegistered);
        pw.println("hasPendingVibrationParamsRequest = " + hasPendingVibrationParamsRequest);
        pw.println();
        pw.println("Vibration parameters update history:");
        pw.increaseIndent();
        this.mVibrationParamsRecords.dump(pw);
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L7:
        isVibratorControllerRegistered = false;
    L14:
        th = move-exception;
        throw th;
    }

    void dump(ProtoOutputStream proto) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mVibratorControllerHolder.getVibratorController() == null) goto L7;
        boolean isVibratorControllerRegistered = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L11
        proto.write(1120986464283L, isVibratorControllerRegistered);
        this.mVibrationParamsRecords.dump(proto);
        return;
    L7:
        isVibratorControllerRegistered = false;
        goto L8
    }

    private void endOngoingRequestVibrationParamsLocked(boolean wasCancelled) {
        if (this.mVibrationParamRequest == null) goto L5;
        this.mVibrationParamRequest.endRequest(wasCancelled);
    L5:
        this.mVibrationParamRequest = null;
    }

    private static int mapToAdaptiveVibrationType(int usage) {
        switch(usage) {
            case 0: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L13;
            case 33: goto L7;
            case 34: goto L9;
            case 49: goto L5;
            case 50: goto L9;
            case 65: goto L5;
            case 66: goto L9;
            default: goto L3;
        };
    L3:
        Slog.w(TAG, "Unrecognized vibration usage " + usage);
        return -1;
    L5:
        return 2;
    L7:
        return 4;
    L9:
        return 8;
    L11:
        return 1;
    L13:
        return 16;
    }

    private static int[] mapFromAdaptiveVibrationTypeToVibrationUsages(int types) {
        IntArray usages = new IntArray(15);
        if ((types & 1) == 0) goto L6;
        usages.add(17);
    L6:
        if ((types & 2) == 0) goto L9;
        usages.add(49);
        usages.add(65);
    L9:
        if ((types & 4) == 0) goto L12;
        usages.add(33);
    L12:
        if ((types & 16) == 0) goto L15;
        usages.add(19);
        usages.add(0);
    L15:
        if ((types & 8) == 0) goto L18;
        usages.add(18);
        usages.add(50);
    L18:
        return usages.toArray();
    }

    private void updateAdaptiveHapticsScales(VibrationParam[] params) {
        params.getClass();
        int r0 = params.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        VibrationParam param = params[r1];
        if (param.getTag() == 0) goto L7;
        Slog.e(TAG, "Unsupported vibration param: " + param);
    L8:
        r1 = r1 + 1;
        goto L3
    L7:
        ScaleParam scaleParam = param.getScale();
        updateAdaptiveHapticsScales(scaleParam.typesMask, scaleParam.scale);
        goto L8
    }

    private void updateAdaptiveHapticsScales(int types, float scale) {
        this.mStatsLogger.logVibrationParamScale(scale);
        int[] r0 = mapFromAdaptiveVibrationTypeToVibrationUsages(types);
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int usage = r0[r2];
        updateOrRemoveAdaptiveHapticsScale(usage, scale);
        r2 = r2 + 1;
        goto L3
    }

    private void updateOrRemoveAdaptiveHapticsScale(int usageHint, float scale) {
        if (scale != (-1.0f)) goto L6;
        this.mVibrationScaler.removeAdaptiveHapticsScale(usageHint);
        return;
    L6:
        this.mVibrationScaler.updateAdaptiveHapticsScale(usageHint, scale);
    }

    private void recordUpdateVibrationParams(VibrationParam[] params, boolean fromRequest) {
        params.getClass();
        if (fromRequest == false) goto L5;
        VibrationParamsRecords.Operation r0 = VibrationParamsRecords.Operation.PULL;
    L6:
        VibrationParamsRecords.Operation operation = r0;
        long createTime = SystemClock.uptimeMillis();
        int r1 = params.length;
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L13;
        VibrationParam param = params[r7];
        if (param.getTag() == 0) goto L11;
        Slog.w(TAG, "Unsupported vibration param ignored from dumpsys records: " + param);
    L12:
        r7 = r7 + 1;
        goto L7
    L11:
        ScaleParam scaleParam = param.getScale();
        this.mVibrationParamsRecords.add(new VibrationScaleParamRecord(operation, createTime, scaleParam.typesMask, scaleParam.scale));
        goto L12
    L13:
        return;
    L5:
        r0 = VibrationParamsRecords.Operation.PUSH;
        goto L6
    }

    private void recordClearVibrationParams(int typesMask) {
        long createTime = SystemClock.uptimeMillis();
        this.mVibrationParamsRecords.add(new VibrationScaleParamRecord(VibrationParamsRecords.Operation.CLEAR, createTime, typesMask, -1.0f));
    }

    private void requireContainsNoNullElement(VibrationParam[] params) {
        if (ArrayUtils.contains(params, null) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Invalid vibration params received: null values are not permitted.");
    }
}
