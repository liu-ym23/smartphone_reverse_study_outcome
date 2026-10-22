package com.stepos.core.model.task;

import b7.k;
import com.stepos.base.task.data.TaskPriority;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import j7.e;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskSession {
    private final AtomicLong _firstTokenAt;
    private final AtomicInteger _tokenCount;
    private volatile String backend;
    private long createTimeMs;
    private long enqueueTimeMs;
    private int errorCode;
    private String errorMessage;
    private long executeStartTimeMs;
    private long inferEndTimeMs;
    private long inferStartTimeMs;
    private long inferenceTimeMs;
    private volatile boolean modelCacheHit;
    private k modelConfig;
    private String modelType;
    private long postprocessTimeMs;
    private long preprocessTimeMs;
    private TaskPriority priority;
    private int priorityScore;
    private final e request;
    private long returnTimeMs;
    private String sceneId;
    private volatile long startedAt;
    private volatile TaskSessionState state;
    private volatile boolean success;
    private float systemLoad;
    private int thermalState;
    private String threadName;
    private String threadPool;
    private long timeoutMs;

    public TaskSession(e request) {
        g.f(request, "request");
        this.request = request;
        this.priority = TaskPriority.f6399e;
        this.priorityScore = 50;
        this.timeoutMs = AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS;
        this.state = TaskSessionState.PENDING;
        this.createTimeMs = request.h;
        this._tokenCount = new AtomicInteger(0);
        this._firstTokenAt = new AtomicLong(0L);
    }

    public final String getBackend() {
        return this.backend;
    }

    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final long getEnqueueTimeMs() {
        return this.enqueueTimeMs;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final long getExecuteStartTimeMs() {
        return this.executeStartTimeMs;
    }

    public final long getFirstTokenAt() {
        return this._firstTokenAt.get();
    }

    public final long getInferEndTimeMs() {
        return this.inferEndTimeMs;
    }

    public final long getInferStartTimeMs() {
        return this.inferStartTimeMs;
    }

    public final long getInferenceTimeMs() {
        return this.inferenceTimeMs;
    }

    public final boolean getModelCacheHit() {
        return this.modelCacheHit;
    }

    public final k getModelConfig() {
        return this.modelConfig;
    }

    public final String getModelType() {
        return this.modelType;
    }

    public final long getPostprocessTimeMs() {
        return this.postprocessTimeMs;
    }

    public final long getPreprocessTimeMs() {
        return this.preprocessTimeMs;
    }

    public final TaskPriority getPriority() {
        return this.priority;
    }

    public final int getPriorityScore() {
        return this.priorityScore;
    }

    public final e getRequest() {
        return this.request;
    }

    public final long getReturnTimeMs() {
        return this.returnTimeMs;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final long getStartedAt() {
        return this.startedAt;
    }

    public final TaskSessionState getState() {
        return this.state;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final float getSystemLoad() {
        return this.systemLoad;
    }

    public final int getThermalState() {
        return this.thermalState;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    public final String getThreadPool() {
        return this.threadPool;
    }

    public final long getTimeToFirstToken() {
        long j10 = this._firstTokenAt.get();
        if (j10 > 0) {
            return j10 - this.startedAt;
        }
        return 0L;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final int getTokenCount() {
        return this._tokenCount.get();
    }

    public final void markCancelled() {
        this.state = TaskSessionState.CANCELLED;
        this.returnTimeMs = System.currentTimeMillis();
    }

    public final void markCompleted() {
        this.state = TaskSessionState.COMPLETED;
        this.success = true;
        this.returnTimeMs = System.currentTimeMillis();
    }

    public final void markFailed(int i10, String str) {
        this.state = TaskSessionState.FAILED;
        this.success = false;
        this.errorCode = i10;
        this.errorMessage = str;
        this.returnTimeMs = System.currentTimeMillis();
    }

    public final void markStarted() {
        this.state = TaskSessionState.RUNNING;
        this.startedAt = System.currentTimeMillis();
        this.executeStartTimeMs = this.startedAt;
        this.threadName = Thread.currentThread().getName();
    }

    public final void markTimeout() {
        this.state = TaskSessionState.TIMEOUT;
        this.returnTimeMs = System.currentTimeMillis();
    }

    public final void recordToken() {
        this._firstTokenAt.compareAndSet(0L, System.currentTimeMillis());
        this._tokenCount.incrementAndGet();
    }

    public final void setBackend(String str) {
        this.backend = str;
    }

    public final void setCreateTimeMs(long j10) {
        this.createTimeMs = j10;
    }

    public final void setEnqueueTimeMs(long j10) {
        this.enqueueTimeMs = j10;
    }

    public final void setErrorCode(int i10) {
        this.errorCode = i10;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setExecuteStartTimeMs(long j10) {
        this.executeStartTimeMs = j10;
    }

    public final void setInferEndTimeMs(long j10) {
        this.inferEndTimeMs = j10;
    }

    public final void setInferStartTimeMs(long j10) {
        this.inferStartTimeMs = j10;
    }

    public final void setInferenceTimeMs(long j10) {
        this.inferenceTimeMs = j10;
    }

    public final void setModelCacheHit(boolean z) {
        this.modelCacheHit = z;
    }

    public final void setModelConfig(k kVar) {
        this.modelConfig = kVar;
    }

    public final void setModelType(String str) {
        this.modelType = str;
    }

    public final void setPostprocessTimeMs(long j10) {
        this.postprocessTimeMs = j10;
    }

    public final void setPreprocessTimeMs(long j10) {
        this.preprocessTimeMs = j10;
    }

    public final void setPriority(TaskPriority taskPriority) {
        g.f(taskPriority, "<set-?>");
        this.priority = taskPriority;
    }

    public final void setPriorityScore(int i10) {
        this.priorityScore = i10;
    }

    public final void setReturnTimeMs(long j10) {
        this.returnTimeMs = j10;
    }

    public final void setSceneId(String str) {
        this.sceneId = str;
    }

    public final void setStartedAt(long j10) {
        this.startedAt = j10;
    }

    public final void setState(TaskSessionState taskSessionState) {
        g.f(taskSessionState, "<set-?>");
        this.state = taskSessionState;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final void setSystemLoad(float f8) {
        this.systemLoad = f8;
    }

    public final void setThermalState(int i10) {
        this.thermalState = i10;
    }

    public final void setThreadName(String str) {
        this.threadName = str;
    }

    public final void setThreadPool(String str) {
        this.threadPool = str;
    }

    public final void setTimeoutMs(long j10) {
        this.timeoutMs = j10;
    }

    public final TaskInvokeRecord toRecord() {
        e eVar = this.request;
        String str = eVar.f9710a;
        String str2 = eVar.f9711b;
        String str3 = eVar.f9712c;
        String str4 = eVar.f9716g;
        int i10 = eVar.f9714e;
        Long lValueOf = Long.valueOf(this.startedAt);
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        return new TaskInvokeRecord(str, str2, str3, str4, i10, lValueOf != null ? lValueOf.longValue() : this.request.h, System.currentTimeMillis(), this.state == TaskSessionState.CANCELLED ? Long.valueOf(this.returnTimeMs) : null, this._firstTokenAt.get(), this._tokenCount.get(), this.preprocessTimeMs, this.inferenceTimeMs, this.postprocessTimeMs, this.backend, this.modelCacheHit, this.success, this.errorCode, this.errorMessage);
    }
}
