package com.bytedance.android.gamecp.business.instantplay;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/instantplay/SchemeLaunchStatus;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SCHEME_LAUNCH_UNKNOWN", "SCHEME_LAUNCH_SUCCESS", "SCHEME_LAUNCH_FAILED", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SchemeLaunchStatus extends Enum<SchemeLaunchStatus> {
    public static final a Companion = null;
    public static final SchemeLaunchStatus SCHEME_LAUNCH_FAILED = null;
    public static final SchemeLaunchStatus SCHEME_LAUNCH_SUCCESS = null;
    public static final SchemeLaunchStatus SCHEME_LAUNCH_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SchemeLaunchStatus[] f56117a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.gamecp.business.instantplay.SchemeLaunchStatus$a] */
    static {
        SchemeLaunchStatus r100 = new SchemeLaunchStatus("SCHEME_LAUNCH_UNKNOWN", 0, 0);
        SCHEME_LAUNCH_UNKNOWN = r100;
        SchemeLaunchStatus r101 = new SchemeLaunchStatus("SCHEME_LAUNCH_SUCCESS", 1, 1);
        SCHEME_LAUNCH_SUCCESS = r101;
        SchemeLaunchStatus r102 = new SchemeLaunchStatus("SCHEME_LAUNCH_FAILED", 2, 2);
        SCHEME_LAUNCH_FAILED = r102;
        f56117a = new SchemeLaunchStatus[]{r100, r101, r102};
        Companion = new a();
    }

    public static SchemeLaunchStatus valueOf(String r100) {
        return (SchemeLaunchStatus) r27.a.a(SchemeLaunchStatus.class, r100);
    }

    public static SchemeLaunchStatus[] values() {
        return (SchemeLaunchStatus[]) f56117a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public SchemeLaunchStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
