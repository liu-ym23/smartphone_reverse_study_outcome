package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/bytedance/android/livesdk/link/model/ISurvivalInfoRef$AnchorStatus", "", "Lcom/bytedance/android/livesdk/link/model/ISurvivalInfoRef$AnchorStatus;", "Default", "Out", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ISurvivalInfoRef$AnchorStatus extends Enum<ISurvivalInfoRef$AnchorStatus> {
    public static final ISurvivalInfoRef$AnchorStatus Default = null;
    public static final ISurvivalInfoRef$AnchorStatus Out = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ISurvivalInfoRef$AnchorStatus[] f147070a = null;

    static {
        ISurvivalInfoRef$AnchorStatus r100 = new ISurvivalInfoRef$AnchorStatus("Default", 0);
        Default = r100;
        ISurvivalInfoRef$AnchorStatus r101 = new ISurvivalInfoRef$AnchorStatus("Out", 1);
        Out = r101;
        f147070a = new ISurvivalInfoRef$AnchorStatus[]{r100, r101};
    }

    public static ISurvivalInfoRef$AnchorStatus valueOf(String r100) {
        return (ISurvivalInfoRef$AnchorStatus) r27.a.a(ISurvivalInfoRef$AnchorStatus.class, r100);
    }

    public static ISurvivalInfoRef$AnchorStatus[] values() {
        return (ISurvivalInfoRef$AnchorStatus[]) f147070a.clone();
    }

    public ISurvivalInfoRef$AnchorStatus(String r100, int r101) {
        super(r100, r101);
    }
}
