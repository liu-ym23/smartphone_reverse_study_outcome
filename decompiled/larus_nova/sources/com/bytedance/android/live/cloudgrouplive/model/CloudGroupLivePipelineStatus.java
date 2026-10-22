package com.bytedance.android.live.cloudgrouplive.model;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/cloudgrouplive/model/CloudGroupLivePipelineStatus;", "", GXAnimation.STATE_END, "INVITING", GXAnimation.STATE_START, "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CloudGroupLivePipelineStatus extends Enum<CloudGroupLivePipelineStatus> {
    public static final CloudGroupLivePipelineStatus END = null;
    public static final CloudGroupLivePipelineStatus INVITING = null;
    public static final CloudGroupLivePipelineStatus START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CloudGroupLivePipelineStatus[] f64463a = null;

    static {
        CloudGroupLivePipelineStatus r100 = new CloudGroupLivePipelineStatus(GXAnimation.STATE_END, 0);
        END = r100;
        CloudGroupLivePipelineStatus r101 = new CloudGroupLivePipelineStatus("INVITING", 1);
        INVITING = r101;
        CloudGroupLivePipelineStatus r102 = new CloudGroupLivePipelineStatus(GXAnimation.STATE_START, 2);
        START = r102;
        f64463a = new CloudGroupLivePipelineStatus[]{r100, r101, r102};
    }

    public static CloudGroupLivePipelineStatus valueOf(String r100) {
        return (CloudGroupLivePipelineStatus) r27.a.a(CloudGroupLivePipelineStatus.class, r100);
    }

    public static CloudGroupLivePipelineStatus[] values() {
        return (CloudGroupLivePipelineStatus[]) f64463a.clone();
    }

    public CloudGroupLivePipelineStatus(String r100, int r101) {
        super(r100, r101);
    }
}
