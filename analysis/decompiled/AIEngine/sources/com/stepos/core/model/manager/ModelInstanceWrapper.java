package com.stepos.core.model.manager;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelInstanceWrapper implements com.stepos.base.model.a {
    private final String backend;
    private final b7.a iModel;
    private final long loadedAtElapsed;
    private final String modelId;
    private final AtomicInteger refCount;
    private final long sizeBytes;
    private final int version;

    public /* synthetic */ ModelInstanceWrapper(b7.a aVar, String str, int i10, String str2, long j10, long j11, kotlin.jvm.internal.e eVar) {
        this(aVar, str, i10, str2, j10, j11);
    }

    /* renamed from: getBackend-Cf6VwhI, reason: not valid java name */
    public String m107getBackendCf6VwhI() {
        return this.backend;
    }

    public b7.k getConfig() {
        return getIModel().getConfig();
    }

    @Override // com.stepos.base.model.a
    public b7.a getIModel() {
        return this.iModel;
    }

    public long getLoadedAtElapsed() {
        return this.loadedAtElapsed;
    }

    public String getModelId() {
        return this.modelId;
    }

    public AtomicInteger getRefCount() {
        return this.refCount;
    }

    public long getSizeBytes() {
        return this.sizeBytes;
    }

    public int getVersion() {
        return this.version;
    }

    private ModelInstanceWrapper(b7.a iModel, String modelId, int i10, String backend, long j10, long j11) {
        kotlin.jvm.internal.g.f(iModel, "iModel");
        kotlin.jvm.internal.g.f(modelId, "modelId");
        kotlin.jvm.internal.g.f(backend, "backend");
        this.iModel = iModel;
        this.modelId = modelId;
        this.version = i10;
        this.backend = backend;
        this.sizeBytes = j10;
        this.loadedAtElapsed = j11;
        this.refCount = new AtomicInteger(0);
    }

    public /* synthetic */ ModelInstanceWrapper(b7.a aVar, String str, int i10, String str2, long j10, long j11, int i11, kotlin.jvm.internal.e eVar) {
        this(aVar, str, i10, str2, j10, (i11 & 32) != 0 ? SystemClock.elapsedRealtime() : j11, null);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
    }
}
