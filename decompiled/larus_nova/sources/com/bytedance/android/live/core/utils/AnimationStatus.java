package com.bytedance.android.live.core.utils;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/core/utils/AnimationStatus;", "", "", "status", "I", "getStatus", "()I", "IDLE", GXAnimation.STATE_START, "ANIMATION", "FAIL", GXAnimation.STATE_END, "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationStatus extends Enum<AnimationStatus> {
    public static final AnimationStatus ANIMATION = null;
    public static final AnimationStatus END = null;
    public static final AnimationStatus FAIL = null;
    public static final AnimationStatus IDLE = null;
    public static final AnimationStatus START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationStatus[] f66049a = null;
    private final int status;

    static {
        AnimationStatus r100 = new AnimationStatus("IDLE", 0, 0);
        IDLE = r100;
        AnimationStatus r101 = new AnimationStatus(GXAnimation.STATE_START, 1, 1);
        START = r101;
        AnimationStatus r102 = new AnimationStatus("ANIMATION", 2, 2);
        ANIMATION = r102;
        AnimationStatus r103 = new AnimationStatus("FAIL", 3, 3);
        FAIL = r103;
        AnimationStatus r104 = new AnimationStatus(GXAnimation.STATE_END, 4, 4);
        END = r104;
        f66049a = new AnimationStatus[]{r100, r101, r102, r103, r104};
    }

    public static AnimationStatus valueOf(String r100) {
        return (AnimationStatus) r27.a.a(AnimationStatus.class, r100);
    }

    public static AnimationStatus[] values() {
        return (AnimationStatus[]) f66049a.clone();
    }

    public final int getStatus() {
        return this.status;
    }

    public AnimationStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.status = r102;
    }
}
