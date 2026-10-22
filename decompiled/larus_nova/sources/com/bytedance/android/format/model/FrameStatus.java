package com.bytedance.android.format.model;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/format/model/FrameStatus;", "", "UNKNOWN", GXAnimation.STATE_START, "PROCESS", GXAnimation.STATE_END, "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FrameStatus extends Enum<FrameStatus> {
    public static final FrameStatus END = null;
    public static final FrameStatus PROCESS = null;
    public static final FrameStatus START = null;
    public static final FrameStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrameStatus[] f51340a = null;

    static {
        FrameStatus r100 = new FrameStatus("UNKNOWN", 0);
        UNKNOWN = r100;
        FrameStatus r101 = new FrameStatus(GXAnimation.STATE_START, 1);
        START = r101;
        FrameStatus r102 = new FrameStatus("PROCESS", 2);
        PROCESS = r102;
        FrameStatus r103 = new FrameStatus(GXAnimation.STATE_END, 3);
        END = r103;
        f51340a = new FrameStatus[]{r100, r101, r102, r103};
    }

    public static FrameStatus valueOf(String r100) {
        return (FrameStatus) r27.a.a(FrameStatus.class, r100);
    }

    public static FrameStatus[] values() {
        return (FrameStatus[]) f51340a.clone();
    }

    public FrameStatus(String r100, int r101) {
        super(r100, r101);
    }
}
