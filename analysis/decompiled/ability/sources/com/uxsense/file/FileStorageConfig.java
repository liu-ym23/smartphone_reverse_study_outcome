package com.uxsense.file;

import C7.r;
import C9.AbstractC0200b;
import C9.g;
import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1691I;
import m9.AbstractC1729v;
import u9.c;
import u9.d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JL\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0010J\u001a\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b'\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0015R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b+\u0010\u0017R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b-\u0010\u0019¨\u0006."}, d2 = {"Lcom/uxsense/file/FileStorageConfig;", "", "", "bufferSize", "", "enableCache", "maxRetryTimes", "", "retryDelayMs", "Lm9/v;", "dispatcher", "LC9/b;", "json", AppAgent.CONSTRUCT, "(IZIJLm9/v;LC9/b;)V", "component1", "()I", "component2", "()Z", "component3", "component4", "()J", "component5", "()Lm9/v;", "component6", "()LC9/b;", "copy", "(IZIJLm9/v;LC9/b;)Lcom/uxsense/file/FileStorageConfig;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getBufferSize", "Z", "getEnableCache", "getMaxRetryTimes", "J", "getRetryDelayMs", "Lm9/v;", "getDispatcher", "LC9/b;", "getJson", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class FileStorageConfig {
    private final int bufferSize;
    private final AbstractC1729v dispatcher;
    private final boolean enableCache;
    private final AbstractC0200b json;
    private final int maxRetryTimes;
    private final long retryDelayMs;

    public FileStorageConfig() {
        this(0, false, 0, 0L, null, null, 63, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$0(g Json) {
        k.f(Json, "$this$Json");
        Json.e = true;
        Json.c = true;
        Json.f325a = true;
        Json.b = false;
        return r.f317a;
    }

    public static /* synthetic */ FileStorageConfig copy$default(FileStorageConfig fileStorageConfig, int i, boolean z10, int i6, long j5, AbstractC1729v abstractC1729v, AbstractC0200b abstractC0200b, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = fileStorageConfig.bufferSize;
        }
        if ((i10 & 2) != 0) {
            z10 = fileStorageConfig.enableCache;
        }
        if ((i10 & 4) != 0) {
            i6 = fileStorageConfig.maxRetryTimes;
        }
        if ((i10 & 8) != 0) {
            j5 = fileStorageConfig.retryDelayMs;
        }
        if ((i10 & 16) != 0) {
            abstractC1729v = fileStorageConfig.dispatcher;
        }
        if ((i10 & 32) != 0) {
            abstractC0200b = fileStorageConfig.json;
        }
        long j6 = j5;
        int i11 = i6;
        return fileStorageConfig.copy(i, z10, i11, j6, abstractC1729v, abstractC0200b);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBufferSize() {
        return this.bufferSize;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEnableCache() {
        return this.enableCache;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxRetryTimes() {
        return this.maxRetryTimes;
    }

    /* renamed from: component4, reason: from getter */
    public final long getRetryDelayMs() {
        return this.retryDelayMs;
    }

    /* renamed from: component5, reason: from getter */
    public final AbstractC1729v getDispatcher() {
        return this.dispatcher;
    }

    /* renamed from: component6, reason: from getter */
    public final AbstractC0200b getJson() {
        return this.json;
    }

    public final FileStorageConfig copy(int bufferSize, boolean enableCache, int maxRetryTimes, long retryDelayMs, AbstractC1729v dispatcher, AbstractC0200b json) {
        k.f(dispatcher, "dispatcher");
        k.f(json, "json");
        return new FileStorageConfig(bufferSize, enableCache, maxRetryTimes, retryDelayMs, dispatcher, json);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileStorageConfig)) {
            return false;
        }
        FileStorageConfig fileStorageConfig = (FileStorageConfig) other;
        return this.bufferSize == fileStorageConfig.bufferSize && this.enableCache == fileStorageConfig.enableCache && this.maxRetryTimes == fileStorageConfig.maxRetryTimes && this.retryDelayMs == fileStorageConfig.retryDelayMs && k.b(this.dispatcher, fileStorageConfig.dispatcher) && k.b(this.json, fileStorageConfig.json);
    }

    public final int getBufferSize() {
        return this.bufferSize;
    }

    public final AbstractC1729v getDispatcher() {
        return this.dispatcher;
    }

    public final boolean getEnableCache() {
        return this.enableCache;
    }

    public final AbstractC0200b getJson() {
        return this.json;
    }

    public final int getMaxRetryTimes() {
        return this.maxRetryTimes;
    }

    public final long getRetryDelayMs() {
        return this.retryDelayMs;
    }

    public int hashCode() {
        return this.json.hashCode() + ((this.dispatcher.hashCode() + a.c(androidx.constraintlayout.core.dsl.a.a(this.maxRetryTimes, a.d(Integer.hashCode(this.bufferSize) * 31, 31, this.enableCache), 31), 31, this.retryDelayMs)) * 31);
    }

    public String toString() {
        return "FileStorageConfig(bufferSize=" + this.bufferSize + ", enableCache=" + this.enableCache + ", maxRetryTimes=" + this.maxRetryTimes + ", retryDelayMs=" + this.retryDelayMs + ", dispatcher=" + this.dispatcher + ", json=" + this.json + ')';
    }

    public FileStorageConfig(int i, boolean z10, int i6, long j5, AbstractC1729v dispatcher, AbstractC0200b json) {
        k.f(dispatcher, "dispatcher");
        k.f(json, "json");
        this.bufferSize = i;
        this.enableCache = z10;
        this.maxRetryTimes = i6;
        this.retryDelayMs = j5;
        this.dispatcher = dispatcher;
        this.json = json;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FileStorageConfig(int i, boolean z10, int i6, long j5, AbstractC1729v abstractC1729v, AbstractC0200b abstractC0200b, int i10, e eVar) {
        i = (i10 & 1) != 0 ? 8192 : i;
        z10 = (i10 & 2) != 0 ? false : z10;
        i6 = (i10 & 4) != 0 ? 3 : i6;
        j5 = (i10 & 8) != 0 ? 1000L : j5;
        if ((i10 & 16) != 0) {
            d dVar = AbstractC1691I.f5315a;
            abstractC1729v = c.f6743a;
        }
        this(i, z10, i6, j5, abstractC1729v, (i10 & 32) != 0 ? com.stepos.ability.task.executor.e.b(new androidx.compose.ui.text.d(28)) : abstractC0200b);
    }
}
