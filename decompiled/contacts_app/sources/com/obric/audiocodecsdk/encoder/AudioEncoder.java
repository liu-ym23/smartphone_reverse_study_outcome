package com.obric.audiocodecsdk.encoder;

import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioEncoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/AudioEncoder;", "", "()V", "totalBytes", "", "getTotalBytes", "()J", "setTotalBytes", "(J)V", "encode", "", "buffer", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "start", "stop", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AudioEncoder {
    private long totalBytes;

    public void encode(byte[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "buffer");
    }

    public void start() {
    }

    public void stop() {
    }

    public AudioEncoder() {
    }

    public final long getTotalBytes() {
        return this.totalBytes;
    }

    public final void setTotalBytes(long r1) {
        this.totalBytes = r1;
    }
}
