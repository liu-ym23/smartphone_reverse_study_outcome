package com.bytedance.android.ec.host.api.hybrid;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/host/api/hybrid/ForestPreloadType;", "", "LYNX", "WEB", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ForestPreloadType extends Enum<ForestPreloadType> {
    public static final ForestPreloadType LYNX = null;
    public static final ForestPreloadType WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForestPreloadType[] f46178a = null;

    static {
        ForestPreloadType r100 = new ForestPreloadType("LYNX", 0);
        LYNX = r100;
        ForestPreloadType r101 = new ForestPreloadType("WEB", 1);
        WEB = r101;
        f46178a = new ForestPreloadType[]{r100, r101};
    }

    public static ForestPreloadType valueOf(String r100) {
        return (ForestPreloadType) a.a(ForestPreloadType.class, r100);
    }

    public static ForestPreloadType[] values() {
        return (ForestPreloadType[]) f46178a.clone();
    }

    public ForestPreloadType(String r100, int r101) {
        super(r100, r101);
    }
}
