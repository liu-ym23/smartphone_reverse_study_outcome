package com.bytedance.android.ec.host.api.map.abstraction;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/host/api/map/abstraction/CameraMoveReason;", "", "GESTURE", "API", "ANIM", "UNKNOWN", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CameraMoveReason extends Enum<CameraMoveReason> {
    public static final CameraMoveReason ANIM = null;
    public static final CameraMoveReason API = null;
    public static final CameraMoveReason GESTURE = null;
    public static final CameraMoveReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CameraMoveReason[] f46182a = null;

    static {
        CameraMoveReason r100 = new CameraMoveReason("GESTURE", 0);
        GESTURE = r100;
        CameraMoveReason r101 = new CameraMoveReason("API", 1);
        API = r101;
        CameraMoveReason r102 = new CameraMoveReason("ANIM", 2);
        ANIM = r102;
        CameraMoveReason r103 = new CameraMoveReason("UNKNOWN", 3);
        UNKNOWN = r103;
        f46182a = new CameraMoveReason[]{r100, r101, r102, r103};
    }

    public static CameraMoveReason valueOf(String r100) {
        return (CameraMoveReason) a.a(CameraMoveReason.class, r100);
    }

    public static CameraMoveReason[] values() {
        return (CameraMoveReason[]) f46182a.clone();
    }

    public CameraMoveReason(String r100, int r101) {
        super(r100, r101);
    }
}
