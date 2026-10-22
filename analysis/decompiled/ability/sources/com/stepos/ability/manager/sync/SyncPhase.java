package com.stepos.ability.manager.sync;

import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/manager/sync/SyncPhase;", "", "manager_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SyncPhase {

    /* renamed from: a, reason: collision with root package name */
    public static final SyncPhase f3161a;
    public static final SyncPhase b;
    public static final SyncPhase c;
    public static final /* synthetic */ SyncPhase[] d;

    static {
        SyncPhase syncPhase = new SyncPhase("LOCAL_PENDING", 0);
        f3161a = syncPhase;
        SyncPhase syncPhase2 = new SyncPhase("LOCAL_READY", 1);
        b = syncPhase2;
        SyncPhase syncPhase3 = new SyncPhase("CLOUD_READY", 2);
        c = syncPhase3;
        SyncPhase[] syncPhaseArr = {syncPhase, syncPhase2, syncPhase3};
        d = syncPhaseArr;
        kotlin.enums.a.a(syncPhaseArr);
    }

    public static SyncPhase valueOf(String str) {
        return (SyncPhase) Enum.valueOf(SyncPhase.class, str);
    }

    public static SyncPhase[] values() {
        return (SyncPhase[]) d.clone();
    }
}
