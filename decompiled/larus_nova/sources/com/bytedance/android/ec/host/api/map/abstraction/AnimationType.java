package com.bytedance.android.ec.host.api.map.abstraction;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/host/api/map/abstraction/AnimationType;", "", "TRANSLATE", "ROTATE", "SCALE", "ALPHA", "SMOOTH_MOVE", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AnimationType extends Enum<AnimationType> {
    public static final AnimationType ALPHA = null;
    public static final AnimationType ROTATE = null;
    public static final AnimationType SCALE = null;
    public static final AnimationType SMOOTH_MOVE = null;
    public static final AnimationType TRANSLATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnimationType[] f46181a = null;

    static {
        AnimationType r100 = new AnimationType("TRANSLATE", 0);
        TRANSLATE = r100;
        AnimationType r101 = new AnimationType("ROTATE", 1);
        ROTATE = r101;
        AnimationType r102 = new AnimationType("SCALE", 2);
        SCALE = r102;
        AnimationType r103 = new AnimationType("ALPHA", 3);
        ALPHA = r103;
        AnimationType r104 = new AnimationType("SMOOTH_MOVE", 4);
        SMOOTH_MOVE = r104;
        f46181a = new AnimationType[]{r100, r101, r102, r103, r104};
    }

    public static AnimationType valueOf(String r100) {
        return (AnimationType) a.a(AnimationType.class, r100);
    }

    public static AnimationType[] values() {
        return (AnimationType[]) f46181a.clone();
    }

    public AnimationType(String r100, int r101) {
        super(r100, r101);
    }
}
