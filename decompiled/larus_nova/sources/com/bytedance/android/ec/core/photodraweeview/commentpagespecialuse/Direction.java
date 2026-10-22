package com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/photodraweeview/commentpagespecialuse/Direction;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UP", "DOWN", "RIGHT", "LEFT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Direction extends Enum<Direction> {
    public static final Direction DOWN = null;
    public static final Direction LEFT = null;
    public static final Direction RIGHT = null;
    public static final Direction UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f45303a = null;
    private final String value;

    static {
        Direction r100 = new Direction("UP", 0, "up");
        UP = r100;
        Direction r101 = new Direction("DOWN", 1, ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN);
        DOWN = r101;
        Direction r102 = new Direction("RIGHT", 2, "right");
        RIGHT = r102;
        Direction r103 = new Direction("LEFT", 3, "left");
        LEFT = r103;
        f45303a = new Direction[]{r100, r101, r102, r103};
    }

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public static Direction[] values() {
        return (Direction[]) f45303a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public Direction(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
