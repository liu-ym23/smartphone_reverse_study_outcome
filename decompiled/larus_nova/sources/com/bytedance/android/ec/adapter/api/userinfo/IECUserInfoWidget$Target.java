package com.bytedance.android.ec.adapter.api.userinfo;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/adapter/api/userinfo/IECUserInfoWidget$Target", "", "Lcom/bytedance/android/ec/adapter/api/userinfo/IECUserInfoWidget$Target;", "ENTRANCE_CONTAINER", "ec-adapter-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum IECUserInfoWidget$Target extends Enum<IECUserInfoWidget$Target> {
    public static final IECUserInfoWidget$Target ENTRANCE_CONTAINER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IECUserInfoWidget$Target[] f42718a = null;

    static {
        IECUserInfoWidget$Target r100 = new IECUserInfoWidget$Target();
        ENTRANCE_CONTAINER = r100;
        f42718a = new IECUserInfoWidget$Target[]{r100};
    }

    public static IECUserInfoWidget$Target valueOf(String r100) {
        return (IECUserInfoWidget$Target) a.a(IECUserInfoWidget$Target.class, r100);
    }

    public static IECUserInfoWidget$Target[] values() {
        return (IECUserInfoWidget$Target[]) f42718a.clone();
    }

    public IECUserInfoWidget$Target() {
        super("ENTRANCE_CONTAINER", 0);
    }
}
