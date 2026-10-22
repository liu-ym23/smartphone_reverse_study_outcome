package com.bytedance.android.livesdkapi.host;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/host/HostDataKey;", "", "(Ljava/lang/String;I)V", "NETWORK_QUALITY", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HostDataKey extends Enum<HostDataKey> {
    private static final /* synthetic */ HostDataKey[] $VALUES = null;
    public static final HostDataKey NETWORK_QUALITY = null;

    static {
        HostDataKey r100 = new HostDataKey("NETWORK_QUALITY", 0);
        NETWORK_QUALITY = r100;
        $VALUES = new HostDataKey[]{r100};
    }

    public static HostDataKey valueOf(String r100) {
        return (HostDataKey) a.a(HostDataKey.class, r100);
    }

    public static HostDataKey[] values() {
        return (HostDataKey[]) $VALUES.clone();
    }

    private HostDataKey(String r100, int r101) {
        super(r100, r101);
    }
}
