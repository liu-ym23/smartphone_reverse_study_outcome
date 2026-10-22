package com.bytedance.ai.bridge.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/service/PermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "GRANTED", "DENIED", "REJECTED", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PermissionState extends Enum<PermissionState> {
    public static final PermissionState DENIED = null;
    public static final PermissionState GRANTED = null;
    public static final PermissionState REJECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionState[] f36105a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f36106b = null;

    public static EnumEntries<PermissionState> getEntries() {
        return f36106b;
    }

    static {
        PermissionState r100 = new PermissionState("GRANTED", 0);
        GRANTED = r100;
        PermissionState r101 = new PermissionState("DENIED", 1);
        DENIED = r101;
        PermissionState r102 = new PermissionState("REJECTED", 2);
        REJECTED = r102;
        PermissionState[] r103 = {r100, r101, r102};
        f36105a = r103;
        f36106b = EnumEntriesKt.enumEntries(r103);
    }

    public static PermissionState[] values() {
        return (PermissionState[]) f36105a.clone();
    }

    public static PermissionState valueOf(String r100) {
        return (PermissionState) a.a(PermissionState.class, r100);
    }

    public PermissionState(String r100, int r101) {
        super(r100, r101);
    }
}
