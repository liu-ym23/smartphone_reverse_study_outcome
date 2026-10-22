package com.bytedance.android.livesdk.widget.rollingTextView;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/widget/rollingTextView/Direction;", "", "", "value", "I", "getValue", "()I", "orientation", "getOrientation", "SCROLL_UP", "SCROLL_DOWN", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum Direction extends Enum<Direction> {
    public static final Direction SCROLL_DOWN = null;
    public static final Direction SCROLL_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Direction[] f162013a = null;
    private final int orientation;
    private final int value;

    static {
        Direction r100 = new Direction("SCROLL_UP", 0, -1);
        SCROLL_UP = r100;
        Direction r101 = new Direction("SCROLL_DOWN", 1, 1);
        SCROLL_DOWN = r101;
        f162013a = new Direction[]{r100, r101};
    }

    public static Direction valueOf(String r100) {
        return (Direction) a.a(Direction.class, r100);
    }

    public static Direction[] values() {
        return (Direction[]) f162013a.clone();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final int getValue() {
        return this.value;
    }

    public Direction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
        this.orientation = 1;
    }
}
