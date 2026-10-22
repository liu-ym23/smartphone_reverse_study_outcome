package com.bytedance.android.live.effect.event;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/event/ReleaseStatus;", "", "Start", "End", "liveeffect-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReleaseStatus extends Enum<ReleaseStatus> {
    public static final ReleaseStatus End = null;
    public static final ReleaseStatus Start = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReleaseStatus[] f67999a = null;

    static {
        ReleaseStatus r100 = new ReleaseStatus("Start", 0);
        Start = r100;
        ReleaseStatus r101 = new ReleaseStatus("End", 1);
        End = r101;
        f67999a = new ReleaseStatus[]{r100, r101};
    }

    public static ReleaseStatus valueOf(String r100) {
        return (ReleaseStatus) a.a(ReleaseStatus.class, r100);
    }

    public static ReleaseStatus[] values() {
        return (ReleaseStatus[]) f67999a.clone();
    }

    public ReleaseStatus(String r100, int r101) {
        super(r100, r101);
    }
}
