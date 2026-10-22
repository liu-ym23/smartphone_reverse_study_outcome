package com.stepos.core.ota.process;

import com.stepos.core.common.cloud.FileStorageUploader;
import com.stepos.core.ota.confirm.InteractiveSessionRegistry;
import dc.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaProcessClientKt {
    public static final long rebindBackoffMs(int i10, long j10, long j11) {
        long jA0 = j10 << h.a0(i10 - 1, 0, 16);
        return jA0 > j11 ? j11 : jA0;
    }

    public static /* synthetic */ long rebindBackoffMs$default(int i10, long j10, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j10 = FileStorageUploader.LOG_HEARTBEAT_MS;
        }
        if ((i11 & 4) != 0) {
            j11 = InteractiveSessionRegistry.DEFAULT_TTL_MS;
        }
        return rebindBackoffMs(i10, j10, j11);
    }
}
