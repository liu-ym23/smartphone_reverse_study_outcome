package com.bytedance.android.livesdk.interactivity.interactive.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/interactive/utils/MovingType;", "", "DEFAULT", "MOVE_TO_LEFT", "MOVE_TO_RIGHT", "STOP", "MOVE_TO_TOP", "MOVE_TO_BOTTOM", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum MovingType extends Enum<MovingType> {
    public static final MovingType DEFAULT = null;
    public static final MovingType MOVE_TO_BOTTOM = null;
    public static final MovingType MOVE_TO_LEFT = null;
    public static final MovingType MOVE_TO_RIGHT = null;
    public static final MovingType MOVE_TO_TOP = null;
    public static final MovingType STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MovingType[] f137448a = null;

    static {
        MovingType r100 = new MovingType("DEFAULT", 0);
        DEFAULT = r100;
        MovingType r101 = new MovingType("MOVE_TO_LEFT", 1);
        MOVE_TO_LEFT = r101;
        MovingType r102 = new MovingType("MOVE_TO_RIGHT", 2);
        MOVE_TO_RIGHT = r102;
        MovingType r103 = new MovingType("STOP", 3);
        STOP = r103;
        MovingType r104 = new MovingType("MOVE_TO_TOP", 4);
        MOVE_TO_TOP = r104;
        MovingType r105 = new MovingType("MOVE_TO_BOTTOM", 5);
        MOVE_TO_BOTTOM = r105;
        f137448a = new MovingType[]{r100, r101, r102, r103, r104, r105};
    }

    public static MovingType valueOf(String r100) {
        return (MovingType) a.a(MovingType.class, r100);
    }

    public static MovingType[] values() {
        return (MovingType[]) f137448a.clone();
    }

    public MovingType(String r100, int r101) {
        super(r100, r101);
    }
}
