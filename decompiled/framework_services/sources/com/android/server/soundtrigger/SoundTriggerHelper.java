package com.android.server.soundtrigger;

import android.content.Context;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.SoundTrigger;
import android.hardware.soundtrigger.SoundTriggerModule;
import android.os.FrozenObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.logging.MetricsLogger;
import com.android.server.utils.EventLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerHelper implements SoundTrigger.StatusListener {
    public static final int INVALID_MODULE_ID = -1;
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    public static final int STATUS_ERROR = Integer.MIN_VALUE;
    public static final int STATUS_OK = 0;
    static final String TAG = "SoundTriggerHelper";
    private final Context mContext;
    private DeviceStateHandler.SoundTriggerDeviceState mDeviceState;
    private final EventLogger mEventLogger;
    private boolean mIsAppOpPermitted;
    private boolean mIsDetached;
    private final HashMap<Integer, UUID> mKeyphraseUuidMap;
    private final Object mLock;
    private final HashMap<UUID, ModelData> mModelDataMap;
    private SoundTriggerModule mModule;
    private final int mModuleId;
    private final Supplier<List<SoundTrigger.ModuleProperties>> mModulePropertiesProvider;
    private final Function<SoundTrigger.StatusListener, SoundTriggerModule> mModuleProvider;
    private boolean mRecognitionRequested;

    /* JADX INFO: renamed from: com.android.server.soundtrigger.SoundTriggerHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState = null;

        static {
            $SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState = new int[DeviceStateHandler.SoundTriggerDeviceState.values().length];
            $SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState[DeviceStateHandler.SoundTriggerDeviceState.DISABLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState[DeviceStateHandler.SoundTriggerDeviceState.CRITICAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState[DeviceStateHandler.SoundTriggerDeviceState.ENABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class ModelData {
        static final int MODEL_LOADED = 1;
        static final int MODEL_NOTLOADED = 0;
        static final int MODEL_STARTED = 2;
        private IRecognitionStatusCallback mCallback;
        private int mModelHandle;
        private UUID mModelId;
        private int mModelState;
        private int mModelType;
        private SoundTrigger.RecognitionConfig mRecognitionConfig;
        private IBinder mRecognitionToken;
        private boolean mRequested;
        public boolean mRunInBatterySaverMode;
        private SoundTrigger.SoundModel mSoundModel;

        private ModelData(UUID modelId, int modelType) {
            this.mRequested = false;
            this.mModelType = -1;
            this.mCallback = null;
            this.mRecognitionConfig = null;
            this.mRunInBatterySaverMode = false;
            this.mSoundModel = null;
            this.mRecognitionToken = null;
            this.mModelId = modelId;
            this.mModelType = modelType;
        }

        static ModelData createKeyphraseModelData(UUID modelId) {
            return new ModelData(modelId, 0);
        }

        static ModelData createGenericModelData(UUID modelId) {
            return new ModelData(modelId, 1);
        }

        static ModelData createModelDataOfUnknownType(UUID modelId) {
            return new ModelData(modelId, -1);
        }

        synchronized void setCallback(IRecognitionStatusCallback callback) {
            monitor-enter(this);
            this.mCallback = callback;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized IRecognitionStatusCallback getCallback() {
            monitor-enter(this);
            IRecognitionStatusCallback r0 = this.mCallback;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean isModelLoaded() {
            monitor-enter(this);
            boolean r1 = true;
            if (this.mModelState == 1) goto L12;
            if (this.mModelState == 2) goto L12;
            r1 = false;
        L12:
            monitor-exit(this);
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized boolean isModelNotLoaded() {
            monitor-enter(this);
            if (this.mModelState != 0) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);
            return r0;
        L6:
            r0 = false;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void setStarted() {
            monitor-enter(this);
            this.mModelState = 2;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void setStopped() {
            monitor-enter(this);
            this.mRecognitionToken = null;     // Catch: Throwable -> L7
            this.mModelState = 1;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void setLoaded() {
            monitor-enter(this);
            this.mModelState = 1;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void setNotLoaded() {
            monitor-enter(this);
            this.mRecognitionToken = null;     // Catch: Throwable -> L7
            this.mModelState = 0;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized boolean isModelStarted() {
            monitor-enter(this);
            if (this.mModelState != 2) goto L7;
            boolean r0 = true;
        L8:
            monitor-exit(this);
            return r0;
        L7:
            r0 = false;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized void clearState() {
            monitor-enter(this);
            this.mModelState = 0;     // Catch: Throwable -> L7
            this.mRecognitionToken = null;     // Catch: Throwable -> L7
            this.mRecognitionConfig = null;     // Catch: Throwable -> L7
            this.mRequested = false;     // Catch: Throwable -> L7
            this.mCallback = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void clearCallback() {
            monitor-enter(this);
            this.mCallback = null;     // Catch: Throwable -> L7
            monitor-exit(this);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        synchronized void setHandle(int handle) {
            monitor-enter(this);
            this.mModelHandle = handle;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void setRecognitionConfig(SoundTrigger.RecognitionConfig config) {
            monitor-enter(this);
            this.mRecognitionConfig = config;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void setRunInBatterySaverMode(boolean runInBatterySaverMode) {
            monitor-enter(this);
            this.mRunInBatterySaverMode = runInBatterySaverMode;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean shouldRunInBatterySaverMode() {
            monitor-enter(this);
            boolean r0 = this.mRunInBatterySaverMode;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized int getHandle() {
            monitor-enter(this);
            int r0 = this.mModelHandle;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized UUID getModelId() {
            monitor-enter(this);
            UUID r0 = this.mModelId;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized SoundTrigger.RecognitionConfig getRecognitionConfig() {
            monitor-enter(this);
            SoundTrigger.RecognitionConfig r0 = this.mRecognitionConfig;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean isRequested() {
            monitor-enter(this);
            boolean r0 = this.mRequested;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void setRequested(boolean requested) {
            monitor-enter(this);
            this.mRequested = requested;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void setSoundModel(SoundTrigger.SoundModel soundModel) {
            monitor-enter(this);
            this.mSoundModel = soundModel;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized SoundTrigger.SoundModel getSoundModel() {
            monitor-enter(this);
            SoundTrigger.SoundModel r0 = this.mSoundModel;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized IBinder getToken() {
            monitor-enter(this);
            IBinder r0 = this.mRecognitionToken;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void setToken(IBinder token) {
            monitor-enter(this);
            this.mRecognitionToken = token;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized int getModelType() {
            monitor-enter(this);
            int r0 = this.mModelType;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized boolean isKeyphraseModel() {
            monitor-enter(this);
            if (this.mModelType != 0) goto L6;
            boolean r0 = true;
        L7:
            monitor-exit(this);
            return r0;
        L6:
            r0 = false;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized boolean isGenericModel() {
            monitor-enter(this);
            boolean r1 = true;
            if (this.mModelType == 1) goto L8;
            r1 = false;
        L8:
            monitor-exit(this);
            return r1;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized String stateToString() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            switch(this.mModelState) {
                case 0: goto L17;
                case 1: goto L14;
                case 2: goto L11;
                default: goto L6;
            };     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);
            return "Unknown state";
        L11:
            monitor-exit(this);
            return "STARTED";
        L14:
            monitor-exit(this);
            return "LOADED";
        L17:
            monitor-exit(this);
            return "NOT_LOADED";
        }

        synchronized String requestedToString() {
            monitor-enter(this);
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L6
            r0.append("Requested: ");     // Catch: Throwable -> L6
            if (this.mRequested == false) goto L8;
            String r1 = "Yes";
        L9:
            r0.append(r1);     // Catch: Throwable -> L6
            String r2 = r0.toString();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r2;
        L8:
            r1 = "No";
        L6:
            th = move-exception;
            throw th;
        }

        synchronized String callbackToString() {
            monitor-enter(this);
            StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L6
            r0.append("Callback: ");     // Catch: Throwable -> L6
            if (this.mCallback == null) goto L8;
            Object r1 = this.mCallback.asBinder();     // Catch: Throwable -> L6
        L9:
            r0.append(r1);     // Catch: Throwable -> L6
            String r2 = r0.toString();     // Catch: Throwable -> L6
            monitor-exit(this);
            return r2;
        L8:
            r1 = "null";
        L6:
            th = move-exception;
            throw th;
        }

        synchronized String uuidToString() {
            monitor-enter(this);
            String r0 = "UUID: " + this.mModelId;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized String toString() {
            monitor-enter(this);
            String r0 = "Handle: " + this.mModelHandle + "\nModelState: " + stateToString() + "\n" + requestedToString() + "\n" + callbackToString() + "\n" + uuidToString() + "\n" + modelTypeToString() + "RunInBatterySaverMode=" + this.mRunInBatterySaverMode;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized String modelTypeToString() {
            monitor-enter(this);
            String type = null;
        L8:
            th = move-exception;
            throw th;
        L5:
            switch(this.mModelType) {
                case -1: goto L11;
                case 0: goto L10;
                case 1: goto L7;
                default: goto L12;
            };     // Catch: Throwable -> L8
        L7:
            type = "Generic";
            goto L12
        L10:
            type = "Keyphrase";
            goto L12
        L11:
            type = "Unknown";
        L12:
            String r1 = "Model type: " + type + "\n";     // Catch: Throwable -> L8
            monitor-exit(this);
            return r1;
        }
    }

    SoundTriggerHelper(Context context, EventLogger eventLogger, Function<SoundTrigger.StatusListener, SoundTriggerModule> moduleProvider, int moduleId, Supplier<List<SoundTrigger.ModuleProperties>> modulePropertiesProvider) {
        this.mLock = new Object();
        this.mModelDataMap = new HashMap();
        this.mKeyphraseUuidMap = new HashMap();
        this.mRecognitionRequested = false;
        this.mIsDetached = false;
        this.mDeviceState = DeviceStateHandler.SoundTriggerDeviceState.DISABLE;
        this.mIsAppOpPermitted = true;
        this.mModuleId = moduleId;
        this.mContext = context;
        this.mModuleProvider = moduleProvider;
        this.mEventLogger = eventLogger;
        this.mModulePropertiesProvider = modulePropertiesProvider;
        if (moduleId != (-1)) goto L5;
        this.mModule = null;
        return;
    L5:
        this.mModule = this.mModuleProvider.apply(this);
    }

    public int startGenericRecognition(UUID modelId, SoundTrigger.GenericSoundModel soundModel, IRecognitionStatusCallback callback, SoundTrigger.RecognitionConfig recognitionConfig, boolean runInBatterySaverMode) {
        MetricsLogger.count(this.mContext, "sth_start_recognition", 1);
        if (modelId == null) goto L33;
        if (soundModel == null) goto L33;
        if (callback == null) goto L33;
        if (recognitionConfig == null) goto L33;
        Object r1 = this.mLock;
        monitor-enter(r1);
    L24:
        th = th;
    L30:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw th;
    L26:
        th = th;
        goto L30
    L11:
        if (this.mIsDetached == true) goto L29;
        ModelData modelData = getOrCreateGenericModelDataLocked(modelId);     // Catch: Throwable -> L26
        if (modelData != null) goto L21;
        Slog.w(TAG, "Irrecoverable error occurred, check UUID / sound model data.");     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return Integer.MIN_VALUE;
    L18:
        th = th;
        goto L30
    L21:
        int r12 = startRecognition(soundModel, modelData, callback, recognitionConfig, Integer.MIN_VALUE, runInBatterySaverMode);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return r12;
    L29:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L24
    L33:
        Slog.w(TAG, "Passed in bad data to startGenericRecognition().");
        return Integer.MIN_VALUE;
    }

    public int startKeyphraseRecognition(int keyphraseId, SoundTrigger.KeyphraseSoundModel soundModel, IRecognitionStatusCallback callback, SoundTrigger.RecognitionConfig recognitionConfig, boolean runInBatterySaverMode) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        MetricsLogger.count(this.mContext, "sth_start_recognition", 1);     // Catch: Throwable -> L38
        if (soundModel == null) goto L43;
        if (callback == null) goto L43;
        if (recognitionConfig == null) goto L43;
        if (this.mIsDetached == true) goto L41;
        ModelData model = getKeyphraseModelDataLocked(keyphraseId);     // Catch: Throwable -> L38
        if (model != null) goto L48;
    L20:
        if (model != null) goto L22;
    L28:
        if (model == null) goto L30;
        ModelData model2 = model;
    L33:
        int keyphraseId2 = startRecognition(soundModel, model2, callback, recognitionConfig, keyphraseId, runInBatterySaverMode);     // Catch: Throwable -> L36
        monitor-exit(r1);     // Catch: Throwable -> L36
        return keyphraseId2;
    L30:
        model2 = createKeyphraseModelDataLocked(soundModel.getUuid(), keyphraseId);     // Catch: Throwable -> L18
        goto L33
    L22:
        if (model.getModelId().equals(soundModel.getUuid()) == true) goto L28;
        int status = cleanUpExistingKeyphraseModelLocked(model);     // Catch: Throwable -> L18
        if (status == 0) goto L27;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return status;
    L27:
        removeKeyphraseModelLocked(keyphraseId);     // Catch: Throwable -> L18
        model = null;
        goto L28
    L48:
    L18:
        th = th;
    L45:
        monitor-exit(r1);     // Catch: Throwable -> L36
        throw th;
    L14:
        if (model.isKeyphraseModel() == true) goto L20;
        Slog.e(TAG, "Generic model with same UUID exists.");     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return Integer.MIN_VALUE;
    L41:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L36
    L43:
        monitor-exit(r1);     // Catch: Throwable -> L36
        return Integer.MIN_VALUE;
    L36:
        th = th;
    L38:
        th = th;
        goto L45
    }

    private int cleanUpExistingKeyphraseModelLocked(ModelData modelData) {
        int status = tryStopAndUnloadLocked(modelData, true, true);
        if (status == 0) goto L5;
        Slog.w(TAG, "Unable to stop or unload previous model: " + modelData.toString());
    L5:
        return status;
    }

    private int prepareForRecognition(ModelData modelData) {
        if (this.mModule != null) goto L7;
        Slog.w(TAG, "prepareForRecognition: cannot attach to sound trigger module");
        return Integer.MIN_VALUE;
    L7:
        if (modelData.isModelLoaded() == true) goto L13;
        stopAndUnloadDeadModelsLocked();
        int[] handle = {0};
        int status = this.mModule.loadSoundModel(modelData.getSoundModel(), handle);
        if (status == 0) goto L12;
        Slog.w(TAG, "prepareForRecognition: loadSoundModel failed with status: " + status);
        return status;
    L12:
        modelData.setHandle(handle[0]);
        modelData.setLoaded();
    L13:
        return 0;
    }

    private int startRecognition(SoundTrigger.SoundModel soundModel, ModelData modelData, IRecognitionStatusCallback callback, SoundTrigger.RecognitionConfig recognitionConfig, int keyphraseId, boolean runInBatterySaverMode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        IRecognitionStatusCallback oldCallback = modelData.getCallback();     // Catch: Throwable -> L11
        if (oldCallback == null) goto L17;
        if (oldCallback.asBinder() == callback.asBinder()) goto L17;
        Slog.w(TAG, "Canceling previous recognition for model id: " + modelData.getModelId());     // Catch: Throwable -> L11
        oldCallback.onPreempted();     // Catch: Throwable -> L11 RemoteException -> L13
    L15:
        modelData.clearCallback();     // Catch: Throwable -> L11
        goto L17
    L13:
        e = move-exception;
        Slog.w(TAG, "RemoteException in onDetectionStopped", e);     // Catch: Throwable -> L11
    L17:
        if (modelData.getSoundModel() == null) goto L33;
        boolean stopModel = false;
        boolean unloadModel = false;
        if (modelData.getSoundModel().equals(soundModel) == false) goto L24;
        if (modelData.isModelStarted() == false) goto L24;
        stopModel = true;
        unloadModel = false;
    L26:
        if (stopModel == true) goto L28;
        if (unloadModel == false) goto L33;
    L28:
        int status = tryStopAndUnloadLocked(modelData, stopModel, unloadModel);     // Catch: Throwable -> L11
        if (status == 0) goto L33;
        Slog.w(TAG, "Unable to stop or unload previous model: " + modelData.toString());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return status;
    L24:
        if (modelData.getSoundModel().equals(soundModel) == true) goto L26;
        stopModel = modelData.isModelStarted();     // Catch: Throwable -> L11
        unloadModel = modelData.isModelLoaded();     // Catch: Throwable -> L11
    L33:
        modelData.setCallback(callback);     // Catch: Throwable -> L11
        modelData.setRequested(true);     // Catch: Throwable -> L11
        modelData.setRecognitionConfig(recognitionConfig);     // Catch: Throwable -> L11
        modelData.setRunInBatterySaverMode(runInBatterySaverMode);     // Catch: Throwable -> L11
        modelData.setSoundModel(soundModel);     // Catch: Throwable -> L11
        if (isRecognitionAllowed(modelData) == false) goto L44;
        int startRecoResult = updateRecognitionLocked(modelData, false);     // Catch: Throwable -> L11
        if (startRecoResult != 0) goto L40;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return startRecoResult;
    L40:
        if (startRecoResult == SoundTrigger.STATUS_BUSY) goto L44;
        modelData.setRequested(false);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return startRecoResult;
    L44:
        if (callback != null) goto L55;
    L50:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return 0;
    L55:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId()));     // Catch: Throwable -> L11 RemoteException -> L47
        callback.onRecognitionPaused();     // Catch: Throwable -> L11 RemoteException -> L47
    L47:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId(), "RemoteException").printLog(2, TAG));     // Catch: Throwable -> L11
        forceStopAndUnloadModelLocked(modelData, e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public int stopGenericRecognition(UUID modelId, IRecognitionStatusCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_stop_recognition", 1);     // Catch: Throwable -> L18
        if (callback == null) goto L27;
        if (modelId == null) goto L27;
        if (this.mIsDetached == true) goto L26;
        ModelData modelData = this.mModelDataMap.get(modelId);     // Catch: Throwable -> L18
        if (modelData == null) goto L22;
        if (modelData.isGenericModel() == false) goto L22;
        int status = stopRecognition(modelData, callback);     // Catch: Throwable -> L18
        if (status == 0) goto L20;
        Slog.w(TAG, "stopGenericRecognition failed: " + status);     // Catch: Throwable -> L18
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return status;
    L22:
        Slog.w(TAG, "Attempting stopRecognition on invalid model with id:" + modelId);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return Integer.MIN_VALUE;
    L26:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L18
    L27:
        Slog.e(TAG, "Null callbackreceived for stopGenericRecognition() for modelid:" + modelId);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return Integer.MIN_VALUE;
    L18:
        th = move-exception;
        throw th;
    }

    public int stopKeyphraseRecognition(int keyphraseId, IRecognitionStatusCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_stop_recognition", 1);     // Catch: Throwable -> L9
        if (callback != null) goto L12;
        Slog.e(TAG, "Null callback received for stopKeyphraseRecognition() for keyphraseId:" + keyphraseId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return Integer.MIN_VALUE;
    L12:
        if (this.mIsDetached == true) goto L28;
        ModelData modelData = getKeyphraseModelDataLocked(keyphraseId);     // Catch: Throwable -> L9
        if (modelData == null) goto L24;
        if (modelData.isKeyphraseModel() == false) goto L24;
        int status = stopRecognition(modelData, callback);     // Catch: Throwable -> L9
        if (status == 0) goto L22;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return status;
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return status;
    L24:
        Slog.w(TAG, "No model exists for given keyphrase Id " + keyphraseId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return Integer.MIN_VALUE;
    L28:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private int stopRecognition(ModelData modelData, IRecognitionStatusCallback callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (callback != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return Integer.MIN_VALUE;
    L11:
        if (this.mModule != null) goto L15;
        Slog.w(TAG, "Attempting stopRecognition after detach");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return Integer.MIN_VALUE;
    L15:
        IRecognitionStatusCallback currentCallback = modelData.getCallback();     // Catch: Throwable -> L8
        if (currentCallback != null) goto L18;
    L34:
        Slog.w(TAG, "Attempting stopRecognition without a successful startRecognition");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return Integer.MIN_VALUE;
    L18:
        if (modelData.isRequested() == true) goto L23;
        if (modelData.isModelStarted() == false) goto L34;
    L23:
        if (currentCallback.asBinder() == callback.asBinder()) goto L27;
        Slog.w(TAG, "Attempting stopRecognition for another recognition");     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return Integer.MIN_VALUE;
    L27:
        modelData.setRequested(false);     // Catch: Throwable -> L8
        int status = updateRecognitionLocked(modelData, false);     // Catch: Throwable -> L8
        if (status == 0) goto L31;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return status;
    L31:
        modelData.setLoaded();     // Catch: Throwable -> L8
        modelData.clearCallback();     // Catch: Throwable -> L8
        modelData.setRecognitionConfig(null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return status;
    L8:
        th = move-exception;
        throw th;
    }

    private int tryStopAndUnloadLocked(ModelData modelData, boolean stopModel, boolean unloadModel) {
        int status = 0;
        if (modelData.isModelNotLoaded() == false) goto L6;
        return 0;
    L6:
        if (stopModel == true) goto L8;
    L13:
        if (unloadModel == true) goto L15;
    L24:
        return status;
    L15:
        if (modelData.isModelLoaded() == false) goto L24;
        Slog.d(TAG, "Unloading previously loaded stale model.");
        if (this.mModule != null) goto L20;
        return Integer.MIN_VALUE;
    L20:
        status = this.mModule.unloadSoundModel(modelData.getHandle());
        MetricsLogger.count(this.mContext, "sth_unloading_stale_model", 1);
        if (status == 0) goto L23;
        Slog.w(TAG, "unloadSoundModel call failed with " + status);
        goto L24
    L23:
        modelData.clearState();
        goto L24
    L8:
        if (modelData.isModelStarted() == false) goto L13;
        status = stopRecognitionLocked(modelData, false);
        if (status == 0) goto L13;
        Slog.w(TAG, "stopRecognition failed: " + status);
        return status;
    }

    public SoundTrigger.ModuleProperties getModuleProperties() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L16
        Iterator<SoundTrigger.ModuleProperties> r1 = this.mModulePropertiesProvider.get().iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        SoundTrigger.ModuleProperties moduleProperties = r1.next();
        if (moduleProperties.getId() != this.mModuleId) goto L9;
        return moduleProperties;
    L14:
        Slog.e(TAG, "Module properties not found for existing moduleId " + this.mModuleId);
        return null;
    L19:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L16
    }

    public int unloadKeyphraseSoundModel(int keyphraseId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_unload_keyphrase_sound_model", 1);     // Catch: Throwable -> L17
        ModelData modelData = getKeyphraseModelDataLocked(keyphraseId);     // Catch: Throwable -> L17
        if (this.mModule == null) goto L27;
        if (modelData == null) goto L27;
        if (modelData.isModelLoaded() == false) goto L27;
        if (modelData.isKeyphraseModel() == false) goto L27;
        if (this.mIsDetached == true) goto L26;
        modelData.setRequested(false);     // Catch: Throwable -> L17
        int status = updateRecognitionLocked(modelData, false);     // Catch: Throwable -> L17
        if (status == 0) goto L19;
        Slog.w(TAG, "Stop recognition failed for keyphrase ID:" + status);     // Catch: Throwable -> L17
    L19:
        int status2 = this.mModule.unloadSoundModel(modelData.getHandle());     // Catch: Throwable -> L17
        if (status2 == 0) goto L22;
        Slog.w(TAG, "unloadKeyphraseSoundModel call failed with " + status2);     // Catch: Throwable -> L17
    L22:
        removeKeyphraseModelLocked(keyphraseId);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return status2;
    L26:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L17
    L27:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return Integer.MIN_VALUE;
    L17:
        th = move-exception;
        throw th;
    }

    public int unloadGenericSoundModel(UUID modelId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_unload_generic_sound_model", 1);     // Catch: Throwable -> L21
        if (modelId == null) goto L43;
        if (this.mModule == null) goto L43;
        if (this.mIsDetached == true) goto L42;
        ModelData modelData = this.mModelDataMap.get(modelId);     // Catch: Throwable -> L21
        if (modelData == null) goto L38;
        if (modelData.isGenericModel() == false) goto L38;
        if (modelData.isModelLoaded() == true) goto L24;
        Slog.i(TAG, "Unload: Given generic model is not loaded:" + modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return 0;
    L24:
        if (modelData.isModelStarted() == false) goto L29;
        int status = stopRecognitionLocked(modelData, false);     // Catch: Throwable -> L21
        if (status == 0) goto L29;
        Slog.w(TAG, "stopGenericRecognition failed: " + status);     // Catch: Throwable -> L21
    L29:
        if (this.mModule != null) goto L32;
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L32:
        int status2 = this.mModule.unloadSoundModel(modelData.getHandle());     // Catch: Throwable -> L21
        if (status2 == 0) goto L35;
        Slog.w(TAG, "unloadGenericSoundModel() call failed with " + status2);     // Catch: Throwable -> L21
        Slog.w(TAG, "unloadGenericSoundModel() force-marking model as unloaded.");     // Catch: Throwable -> L21
    L35:
        this.mModelDataMap.remove(modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return status2;
    L38:
        Slog.w(TAG, "Unload error: Attempting unload invalid generic model with id:" + modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L42:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L21
    L43:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L21:
        th = move-exception;
        throw th;
    }

    public boolean isRecognitionRequested(UUID modelId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L17;
        ModelData modelData = this.mModelDataMap.get(modelId);     // Catch: Throwable -> L11
        if (modelData != null) goto L9;
    L13:
        boolean r2 = false;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    L9:
        if (modelData.isRequested() == false) goto L13;
        r2 = true;
        goto L14
    L17:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L11
    }

    public void onDeviceStateChanged(DeviceStateHandler.SoundTriggerDeviceState state) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L14;
        if (this.mDeviceState == state) goto L14;
        this.mDeviceState = state;     // Catch: Throwable -> L12
        updateAllRecognitionsLocked();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L12
    }

    public void onAppOpStateChanged(boolean isPermitted) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsAppOpPermitted != isPermitted) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsAppOpPermitted = isPermitted;     // Catch: Throwable -> L8
        updateAllRecognitionsLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public int getGenericModelState(UUID modelId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_get_generic_model_state", 1);     // Catch: Throwable -> L21
        if (modelId == null) goto L36;
        if (this.mModule == null) goto L36;
        if (this.mIsDetached == true) goto L35;
        ModelData modelData = this.mModelDataMap.get(modelId);     // Catch: Throwable -> L21
        if (modelData == null) goto L31;
        if (modelData.isGenericModel() == false) goto L31;
        if (modelData.isModelLoaded() == true) goto L24;
        Slog.i(TAG, "GetGenericModelState: Given generic model is not loaded:" + modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L24:
        if (modelData.isModelStarted() == true) goto L28;
        Slog.i(TAG, "GetGenericModelState: Given generic model is not started:" + modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L28:
        int r1 = this.mModule.getModelState(modelData.getHandle());     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return r1;
    L31:
        Slog.w(TAG, "GetGenericModelState error: Invalid generic model id:" + modelId);     // Catch: Throwable -> L21
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L35:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L21
    L36:
        monitor-exit(r0);     // Catch: Throwable -> L21
        return Integer.MIN_VALUE;
    L21:
        th = move-exception;
        throw th;
    }

    public int setParameter(UUID modelId, int modelParam, int value) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        int r1 = setParameterLocked(this.mModelDataMap.get(modelId), modelParam, value);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    public int setKeyphraseParameter(int keyphraseId, int modelParam, int value) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        int r1 = setParameterLocked(getKeyphraseModelDataLocked(keyphraseId), modelParam, value);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    private int setParameterLocked(ModelData modelData, int modelParam, int value) {
        MetricsLogger.count(this.mContext, "sth_set_parameter", 1);
        if (this.mModule == null) goto L5;
        if (modelData != null) goto L8;
    L12:
        Slog.i(TAG, "SetParameter: Given model is not loaded:" + modelData);
        return SoundTrigger.STATUS_BAD_VALUE;
    L8:
        if (modelData.isModelLoaded() == false) goto L12;
        return this.mModule.setParameter(modelData.getHandle(), modelParam, value);
    L5:
        return SoundTrigger.STATUS_NO_INIT;
    }

    public int getParameter(UUID modelId, int modelParam) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        int r1 = getParameterLocked(this.mModelDataMap.get(modelId), modelParam);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    public int getKeyphraseParameter(int keyphraseId, int modelParam) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        int r1 = getParameterLocked(getKeyphraseModelDataLocked(keyphraseId), modelParam);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    private int getParameterLocked(ModelData modelData, int modelParam) {
        MetricsLogger.count(this.mContext, "sth_get_parameter", 1);
        if (this.mModule == null) goto L14;
        if (modelData == null) goto L12;
        if (modelData.isModelLoaded() == false) goto L10;
        return this.mModule.getParameter(modelData.getHandle(), modelParam);
    L10:
        throw new UnsupportedOperationException("Given model is not loaded:" + modelData);
    L12:
        throw new IllegalArgumentException("Invalid model id");
    L14:
        throw new UnsupportedOperationException("SoundTriggerModule not initialized");
    }

    public SoundTrigger.ModelParamRange queryParameter(UUID modelId, int modelParam) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        SoundTrigger.ModelParamRange r1 = queryParameterLocked(this.mModelDataMap.get(modelId), modelParam);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    public SoundTrigger.ModelParamRange queryKeyphraseParameter(int keyphraseId, int modelParam) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == true) goto L12;
        SoundTrigger.ModelParamRange r1 = queryParameterLocked(getKeyphraseModelDataLocked(keyphraseId), modelParam);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L12:
        throw new IllegalStateException("SoundTriggerHelper has been detached");     // Catch: Throwable -> L9
    }

    private SoundTrigger.ModelParamRange queryParameterLocked(ModelData modelData, int modelParam) {
        MetricsLogger.count(this.mContext, "sth_query_parameter", 1);
        if (this.mModule != null) goto L6;
        return null;
    L6:
        if (modelData != null) goto L10;
        Slog.w(TAG, "queryParameter: Invalid model id");
        return null;
    L10:
        if (modelData.isModelLoaded() == true) goto L14;
        Slog.i(TAG, "queryParameter: Given model is not loaded:" + modelData);
        return null;
    L14:
        return this.mModule.queryParameter(modelData.getHandle(), modelParam);
    }

    public void onRecognition(SoundTrigger.RecognitionEvent event) {
        if (event != null) goto L6;
        Slog.w(TAG, "Null recognition event!");
        return;
    L6:
        if ((event instanceof SoundTrigger.KeyphraseRecognitionEvent) == false) goto L8;
    L11:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L14:
        switch(event.status) {
            case 0: goto L20;
            case 1: goto L16;
            case 2: goto L20;
            case 3: goto L20;
            default: goto L23;
        };     // Catch: Throwable -> L17
    L16:
        onRecognitionAbortLocked(event);     // Catch: Throwable -> L17
    L23:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L20:
        if (isKeyphraseRecognitionEvent(event) == false) goto L22;
        onKeyphraseRecognitionLocked((SoundTrigger.KeyphraseRecognitionEvent) event);     // Catch: Throwable -> L17
        goto L23
    L22:
        onGenericRecognitionLocked((SoundTrigger.GenericRecognitionEvent) event);     // Catch: Throwable -> L17
        goto L23
    L8:
        if ((event instanceof SoundTrigger.GenericRecognitionEvent) == true) goto L11;
        Slog.w(TAG, "Invalid recognition event type (not one of generic or keyphrase)!");
    }

    private boolean isKeyphraseRecognitionEvent(SoundTrigger.RecognitionEvent event) {
        return event instanceof SoundTrigger.KeyphraseRecognitionEvent;
    }

    private void onGenericRecognitionLocked(SoundTrigger.GenericRecognitionEvent event) {
        MetricsLogger.count(this.mContext, "sth_generic_recognition_event", 1);
        if (event.status != 0) goto L5;
    L7:
        ModelData model = getModelDataForLocked(event.soundModelHandle);
        if (model != null) goto L10;
    L38:
        Slog.w(TAG, "Generic recognition event: Model does not exist for handle: " + event.soundModelHandle);
        return;
    L10:
        if (model.isGenericModel() == false) goto L38;
        if (Objects.equals(event.getToken(), model.getToken()) == true) goto L15;
        return;
    L15:
        IRecognitionStatusCallback callback = model.getCallback();
        if (callback != null) goto L20;
        Slog.w(TAG, "Generic recognition event: Null callback for model handle: " + event.soundModelHandle);
        return;
    L20:
        if (event.recognitionStillActive == true) goto L40;
        model.setStopped();
    L40:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RECOGNITION, model.getModelId()));     // Catch: RemoteException -> L24 FrozenObjectException -> L26
        callback.onGenericSoundTriggerDetected(event);     // Catch: RemoteException -> L24 FrozenObjectException -> L26
    L24:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RECOGNITION, model.getModelId(), "RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(model, e);
        return;
    L30:
        SoundTrigger.RecognitionConfig config = model.getRecognitionConfig();
        if (config != null) goto L34;
        Slog.w(TAG, "Generic recognition event: Null RecognitionConfig for model handle: " + event.soundModelHandle);
        return;
    L34:
        model.setRequested(config.isMultipleTriggersAllowed());
        if (model.isRequested() == false) goto L42;
        updateRecognitionLocked(model, true);
        return;
    L42:
        return;
    L5:
        if (event.status == 3) goto L7;
    }

    public void onModelUnloaded(int modelHandle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MetricsLogger.count(this.mContext, "sth_sound_model_updated", 1);     // Catch: Throwable -> L7
        onModelUnloadedLocked(modelHandle);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onResourcesAvailable() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        onResourcesAvailableLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onServiceDied() {
        Slog.e(TAG, "onServiceDied!!");
        MetricsLogger.count(this.mContext, "sth_service_died", 1);
        Object r0 = this.mLock;
        monitor-enter(r0);
        onServiceDiedLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onModelUnloadedLocked(int modelHandle) {
        ModelData modelData = getModelDataForLocked(modelHandle);
        if (modelData == null) goto L6;
        modelData.setNotLoaded();
        return;
    }

    private void onResourcesAvailableLocked() {
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RESOURCES_AVAILABLE, null));
        updateAllRecognitionsLocked();
    }

    private void onRecognitionAbortLocked(SoundTrigger.RecognitionEvent event) {
        Slog.w(TAG, "Recognition aborted");
        MetricsLogger.count(this.mContext, "sth_recognition_aborted", 1);
        ModelData modelData = getModelDataForLocked(event.soundModelHandle);
        if (modelData != null) goto L5;
        return;
    L5:
        if (modelData.isModelStarted() == true) goto L7;
        return;
    L7:
        if (Objects.equals(event.getToken(), modelData.getToken()) == true) goto L9;
        return;
    L9:
        modelData.setStopped();
        IRecognitionStatusCallback callback = modelData.getCallback();     // Catch: RemoteException -> L14 FrozenObjectException -> L16
        if (callback == null) goto L25;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId()));     // Catch: RemoteException -> L14 FrozenObjectException -> L16
        callback.onRecognitionPaused();     // Catch: RemoteException -> L14 FrozenObjectException -> L16
        goto L24
    L26:
        return;
    L25:
        return;
    L14:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId(), "RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
        return;
    }

    private int getKeyphraseIdFromEvent(SoundTrigger.KeyphraseRecognitionEvent event) {
        if (event != null) goto L6;
        Slog.w(TAG, "Null RecognitionEvent received.");
        return Integer.MIN_VALUE;
    L6:
        SoundTrigger.KeyphraseRecognitionExtra[] keyphraseExtras = event.keyphraseExtras;
        if (keyphraseExtras != null) goto L9;
    L13:
        Slog.w(TAG, "Invalid keyphrase recognition event!");
        return Integer.MIN_VALUE;
    L9:
        if (keyphraseExtras.length == 0) goto L13;
        return keyphraseExtras[0].id;
    }

    private void onKeyphraseRecognitionLocked(SoundTrigger.KeyphraseRecognitionEvent event) {
        Slog.i(TAG, "Recognition success");
        MetricsLogger.count(this.mContext, "sth_keyphrase_recognition_event", 1);
        int keyphraseId = getKeyphraseIdFromEvent(event);
        ModelData modelData = getKeyphraseModelDataLocked(keyphraseId);
        if (modelData != null) goto L5;
    L32:
        Slog.e(TAG, "Keyphase model data does not exist for ID:" + keyphraseId);
        return;
    L5:
        if (modelData.isKeyphraseModel() == false) goto L32;
        if (Objects.equals(event.getToken(), modelData.getToken()) == true) goto L11;
        return;
    L11:
        if (modelData.getCallback() != null) goto L15;
        Slog.w(TAG, "Received onRecognition event without callback for keyphrase model.");
        return;
    L15:
        if (event.recognitionStillActive == true) goto L34;
        modelData.setStopped();
    L34:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RECOGNITION, modelData.getModelId()));     // Catch: RemoteException -> L19 FrozenObjectException -> L21
        modelData.getCallback().onKeyphraseDetected(event);     // Catch: RemoteException -> L19 FrozenObjectException -> L21
    L19:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RECOGNITION, modelData.getModelId(), "RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
        return;
    L25:
        SoundTrigger.RecognitionConfig config = modelData.getRecognitionConfig();
        if (config == null) goto L29;
        modelData.setRequested(config.isMultipleTriggersAllowed());
    L29:
        if (modelData.isRequested() == false) goto L36;
        updateRecognitionLocked(modelData, true);
        return;
    }

    private void updateAllRecognitionsLocked() {
        ArrayList<ModelData> modelDatas = new ArrayList(this.mModelDataMap.values());
        Iterator<ModelData> r1 = modelDatas.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ModelData modelData = r1.next();
        updateRecognitionLocked(modelData, true);
        goto L4
    }

    private int updateRecognitionLocked(ModelData model, boolean notifyClientOnError) {
        if (model.isRequested() == true) goto L5;
    L7:
        boolean shouldStartModel = false;
    L9:
        if (shouldStartModel != model.isModelStarted()) goto L11;
        return 0;
    L11:
        if (shouldStartModel == false) goto L19;
        int status = prepareForRecognition(model);
        if (status == 0) goto L17;
        Slog.w(TAG, "startRecognition failed to prepare model for recognition");
        return status;
    L17:
        return startRecognitionLocked(model, notifyClientOnError);
    L19:
        return stopRecognitionLocked(model, notifyClientOnError);
    L5:
        if (isRecognitionAllowed(model) == false) goto L7;
        shouldStartModel = true;
        goto L9
    }

    private void onServiceDiedLocked() {
        MetricsLogger.count(this.mContext, "sth_service_died", 1);     // Catch: Throwable -> L11
        Iterator<ModelData> r2 = this.mModelDataMap.values().iterator();     // Catch: Throwable -> L11
    L4:
        if (r2.hasNext() == false) goto L16;
        ModelData modelData = r2.next();     // Catch: Throwable -> L11
        IRecognitionStatusCallback callback = modelData.getCallback();     // Catch: Throwable -> L11
        if (callback == null) goto L4;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.MODULE_DIED, modelData.getModelId()).printLog(2, TAG));     // Catch: Throwable -> L11 RemoteException -> L13
        callback.onModuleDied();     // Catch: Throwable -> L11 RemoteException -> L13
    L14:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.MODULE_DIED, modelData.getModelId(), "RemoteException").printLog(2, TAG));     // Catch: Throwable -> L11
        goto L4
    L16:
        internalClearModelStateLocked();
        if (this.mModule == null) goto L23;
        this.mModule.detach();
        this.mModule = this.mModuleProvider.apply(this);     // Catch: Exception -> L21
        return;
    L22:
        this.mModule = null;
        return;
    L23:
        return;
    L11:
        th = move-exception;
        internalClearModelStateLocked();
        if (this.mModule == null) goto L31;
        this.mModule.detach();
        this.mModule = this.mModuleProvider.apply(this);     // Catch: Exception -> L29
    L30:
        this.mModule = null;
    L31:
        throw th;
    }

    private void internalClearModelStateLocked() {
        Iterator<ModelData> r0 = this.mModelDataMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ModelData modelData = r0.next();
        modelData.clearState();
        goto L4
    }

    public void detach() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsDetached == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mIsDetached = true;     // Catch: Throwable -> L8
        Iterator<ModelData> r1 = this.mModelDataMap.values().iterator();     // Catch: Throwable -> L8
    L12:
        if (r1.hasNext() == false) goto L14;
        ModelData model = r1.next();     // Catch: Throwable -> L8
        forceStopAndUnloadModelLocked(model, null);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.mModelDataMap.clear();     // Catch: Throwable -> L8
        if (this.mModule == null) goto L17;
        this.mModule.detach();     // Catch: Throwable -> L8
        this.mModule = null;     // Catch: Throwable -> L8
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void forceStopAndUnloadModelLocked(ModelData modelData, Exception exception) {
        forceStopAndUnloadModelLocked(modelData, exception, null);
    }

    private void forceStopAndUnloadModelLocked(ModelData modelData, Exception exception, Iterator modelDataIterator) {
        if (exception == null) goto L6;
        Slog.e(TAG, "forceStopAndUnloadModel", exception);
    L6:
        if (this.mModule != null) goto L9;
        return;
    L9:
        if (modelData.isModelStarted() == false) goto L15;
        Slog.d(TAG, "Stopping previously started dangling model " + modelData.getHandle());
        if (this.mModule.stopRecognition(modelData.getHandle()) != 0) goto L13;
        modelData.setStopped();
        modelData.setRequested(false);
        goto L15
    L13:
        Slog.e(TAG, "Failed to stop model " + modelData.getHandle());
    L15:
        if (modelData.isModelLoaded() == false) goto L36;
        Slog.d(TAG, "Unloading previously loaded dangling model " + modelData.getHandle());
        if (this.mModule.unloadSoundModel(modelData.getHandle()) != 0) goto L29;
        if (modelDataIterator == null) goto L20;
        modelDataIterator.remove();
    L21:
        Iterator<Map.Entry<Integer, UUID>> r0 = this.mKeyphraseUuidMap.entrySet().iterator();
    L23:
        if (r0.hasNext() == false) goto L28;
        if (r0.next().getValue().equals(modelData.getModelId()) == false) goto L23;
        r0.remove();
        goto L23
    L28:
        modelData.clearState();
        return;
    L20:
        this.mModelDataMap.remove(modelData.getModelId());
        goto L21
    L29:
        Slog.e(TAG, "Failed to unload model " + modelData.getHandle());
        return;
    }

    private void stopAndUnloadDeadModelsLocked() {
        Iterator<Map.Entry<UUID, ModelData>> r0 = this.mModelDataMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L16;
        ModelData modelData = r0.next().getValue();
        if (modelData.isModelLoaded() == false) goto L4;
        if (modelData.getCallback() == null) goto L14;
        if (modelData.getCallback().asBinder() == null) goto L4;
        if (modelData.getCallback().asBinder().pingBinder() == true) goto L4;
    L14:
        Slog.w(TAG, "Removing model " + modelData.getHandle() + " that has no clients");
        forceStopAndUnloadModelLocked(modelData, null, r0);
        goto L4
    }

    private ModelData getOrCreateGenericModelDataLocked(UUID modelId) {
        ModelData modelData = this.mModelDataMap.get(modelId);
        if (modelData != null) goto L6;
        ModelData modelData2 = ModelData.createGenericModelData(modelId);
        this.mModelDataMap.put(modelId, modelData2);
        return modelData2;
    L6:
        if (modelData.isGenericModel() == true) goto L10;
        Slog.e(TAG, "UUID already used for non-generic model.");
        return null;
    L10:
        return modelData;
    }

    private void removeKeyphraseModelLocked(int keyphraseId) {
        UUID uuid = this.mKeyphraseUuidMap.get(Integer.valueOf(keyphraseId));
        if (uuid != null) goto L5;
        return;
    L5:
        this.mModelDataMap.remove(uuid);
        this.mKeyphraseUuidMap.remove(Integer.valueOf(keyphraseId));
    }

    private ModelData getKeyphraseModelDataLocked(int keyphraseId) {
        UUID uuid = this.mKeyphraseUuidMap.get(Integer.valueOf(keyphraseId));
        if (uuid != null) goto L7;
        return null;
    L7:
        return this.mModelDataMap.get(uuid);
    }

    private ModelData createKeyphraseModelDataLocked(UUID modelId, int keyphraseId) {
        this.mKeyphraseUuidMap.remove(Integer.valueOf(keyphraseId));
        this.mModelDataMap.remove(modelId);
        this.mKeyphraseUuidMap.put(Integer.valueOf(keyphraseId), modelId);
        ModelData modelData = ModelData.createKeyphraseModelData(modelId);
        this.mModelDataMap.put(modelId, modelData);
        return modelData;
    }

    private ModelData getModelDataForLocked(int modelHandle) {
        Iterator<ModelData> r0 = this.mModelDataMap.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        ModelData model = r0.next();
        if (model.getHandle() != modelHandle) goto L4;
        return model;
    L9:
        return null;
    }

    private boolean isRecognitionAllowed(ModelData modelData) {
        if (this.mIsAppOpPermitted == true) goto L6;
        return false;
    L6:
        switch(AnonymousClass1.$SwitchMap$com$android$server$soundtrigger$DeviceStateHandler$SoundTriggerDeviceState[this.mDeviceState.ordinal()]) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L9;
            default: goto L8;
        };
    L9:
        return true;
    L14:
        return false;
    L8:
        throw new AssertionError("Enum changed between compile and runtime");
    L13:
        return modelData.shouldRunInBatterySaverMode();
    }

    private int startRecognitionLocked(ModelData modelData, boolean notifyClientOnError) {
        IRecognitionStatusCallback callback = modelData.getCallback();
        SoundTrigger.RecognitionConfig config = modelData.getRecognitionConfig();
        if (callback != null) goto L5;
    L41:
        Slog.w(TAG, "startRecognition: Bad data passed in.");
        MetricsLogger.count(this.mContext, "sth_start_recognition_error", 1);
        return Integer.MIN_VALUE;
    L5:
        if (modelData.isModelLoaded() == false) goto L41;
        if (config == null) goto L41;
        if (isRecognitionAllowed(modelData) == true) goto L13;
        Slog.w(TAG, "startRecognition requested but not allowed.");
        MetricsLogger.count(this.mContext, "sth_start_recognition_not_allowed", 1);
        return 0;
    L13:
        if (this.mModule != null) goto L15;
        return Integer.MIN_VALUE;
    L15:
        int status = 0;
        modelData.setToken(this.mModule.startRecognitionWithToken(modelData.getHandle(), config));     // Catch: Exception -> L18
    L21:
        if (status == 0) goto L31;
        Slog.w(TAG, "startRecognition failed with " + status);
        MetricsLogger.count(this.mContext, "sth_start_recognition_error", 1);
        if (notifyClientOnError == true) goto L47;
    L40:
        return status;
    L47:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RESUME_FAILED, modelData.getModelId(), String.valueOf(status)).printLog(2, TAG));     // Catch: RemoteException -> L26 FrozenObjectException -> L28
        modelData.setRequested(false);     // Catch: RemoteException -> L26 FrozenObjectException -> L28
        callback.onResumeFailed(status);     // Catch: RemoteException -> L26 FrozenObjectException -> L28
    L26:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RESUME_FAILED, modelData.getModelId(), String.valueOf(status) + " - RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
        goto L40
    L31:
        Slog.i(TAG, "startRecognition successful.");
        MetricsLogger.count(this.mContext, "sth_start_recognition_success", 1);
        modelData.setStarted();
        if (notifyClientOnError == false) goto L40;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RESUME, modelData.getModelId()));     // Catch: RemoteException -> L35 FrozenObjectException -> L37
        callback.onRecognitionResumed();     // Catch: RemoteException -> L35 FrozenObjectException -> L37
    L35:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.RESUME, modelData.getModelId(), "RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
    L18:
        e = move-exception;
        status = SoundTrigger.handleException(e);
        goto L21
    }

    private int stopRecognitionLocked(ModelData modelData, boolean notify) {
        if (this.mModule != null) goto L6;
        return Integer.MIN_VALUE;
    L6:
        IRecognitionStatusCallback callback = modelData.getCallback();
        int status = this.mModule.stopRecognition(modelData.getHandle());
        if (status == 0) goto L17;
        Slog.e(TAG, "stopRecognition call failed with " + status);
        MetricsLogger.count(this.mContext, "sth_stop_recognition_error", 1);
        if (notify == true) goto L27;
    L26:
        return status;
    L27:
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE_FAILED, modelData.getModelId(), String.valueOf(status)).printLog(2, TAG));     // Catch: RemoteException -> L12 FrozenObjectException -> L14
        modelData.setRequested(false);     // Catch: RemoteException -> L12 FrozenObjectException -> L14
        callback.onPauseFailed(status);     // Catch: RemoteException -> L12 FrozenObjectException -> L14
    L12:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE_FAILED, modelData.getModelId(), String.valueOf(status) + " - RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
        goto L26
    L17:
        modelData.setStopped();
        MetricsLogger.count(this.mContext, "sth_stop_recognition_success", 1);
        if (notify == false) goto L26;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId()));     // Catch: RemoteException -> L21 FrozenObjectException -> L23
        callback.onRecognitionPaused();     // Catch: RemoteException -> L21 FrozenObjectException -> L23
    L21:
        e = move-exception;
        this.mEventLogger.enqueue(new SoundTriggerEvent.SessionEvent(SoundTriggerEvent.SessionEvent.Type.PAUSE, modelData.getModelId(), "RemoteException").printLog(2, TAG));
        forceStopAndUnloadModelLocked(modelData, e);
        goto L26
    }

    private boolean computeRecognitionRequestedLocked() {
        if (this.mModule != null) goto L6;
        this.mRecognitionRequested = false;
        return this.mRecognitionRequested;
    L6:
        Iterator<ModelData> r0 = this.mModelDataMap.values().iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        ModelData modelData = r0.next();
        if (modelData.isRequested() == false) goto L8;
        this.mRecognitionRequested = true;
        return this.mRecognitionRequested;
    L14:
        this.mRecognitionRequested = false;
        return this.mRecognitionRequested;
    }
}
