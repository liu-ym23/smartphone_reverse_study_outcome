package com.bytedance.android.live.room.api.messagewindow.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Position", "", "Lcom/bytedance/android/live/room/api/messagewindow/model/CommonCardConstant$Position;", "", "value", "I", "getValue", "()I", "UNKNOWN", "BOTTOM_RIGHT", "TOP_RIGHT", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommonCardConstant$Position extends Enum<CommonCardConstant$Position> {
    public static final CommonCardConstant$Position BOTTOM_RIGHT = null;
    public static final CommonCardConstant$Position TOP_RIGHT = null;
    public static final CommonCardConstant$Position UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonCardConstant$Position[] f98993a = null;
    private final int value;

    static {
        CommonCardConstant$Position r100 = new CommonCardConstant$Position("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        CommonCardConstant$Position r101 = new CommonCardConstant$Position("BOTTOM_RIGHT", 1, 1);
        BOTTOM_RIGHT = r101;
        CommonCardConstant$Position r102 = new CommonCardConstant$Position("TOP_RIGHT", 2, 3);
        TOP_RIGHT = r102;
        f98993a = new CommonCardConstant$Position[]{r100, r101, r102};
    }

    public static CommonCardConstant$Position valueOf(String r100) {
        return (CommonCardConstant$Position) a.a(CommonCardConstant$Position.class, r100);
    }

    public static CommonCardConstant$Position[] values() {
        return (CommonCardConstant$Position[]) f98993a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CommonCardConstant$Position(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
