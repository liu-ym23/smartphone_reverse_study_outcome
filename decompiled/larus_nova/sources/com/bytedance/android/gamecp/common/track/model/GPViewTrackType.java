package com.bytedance.android.gamecp.common.track.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/gamecp/common/track/model/GPViewTrackType;", "", "ROOT_VIEW", "CHILD_VIEW", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum GPViewTrackType extends Enum<GPViewTrackType> {
    public static final GPViewTrackType CHILD_VIEW = null;
    public static final GPViewTrackType ROOT_VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GPViewTrackType[] f56809a = null;

    static {
        GPViewTrackType r100 = new GPViewTrackType("ROOT_VIEW", 0);
        ROOT_VIEW = r100;
        GPViewTrackType r101 = new GPViewTrackType("CHILD_VIEW", 1);
        CHILD_VIEW = r101;
        f56809a = new GPViewTrackType[]{r100, r101};
    }

    public static GPViewTrackType valueOf(String r100) {
        return (GPViewTrackType) a.a(GPViewTrackType.class, r100);
    }

    public static GPViewTrackType[] values() {
        return (GPViewTrackType[]) f56809a.clone();
    }

    public GPViewTrackType(String r100, int r101) {
        super(r100, r101);
    }
}
