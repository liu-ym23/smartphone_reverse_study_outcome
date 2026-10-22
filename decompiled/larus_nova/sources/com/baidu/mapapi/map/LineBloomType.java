package com.baidu.mapapi.map;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: classes39.dex */
public final enum LineBloomType extends Enum<LineBloomType> {
    public static final LineBloomType BLUR = null;
    public static final LineBloomType GradientA = null;
    public static final LineBloomType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ LineBloomType[] f31008a = null;

    static {
        LineBloomType r100 = new LineBloomType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        LineBloomType r101 = new LineBloomType("GradientA", 1);
        GradientA = r101;
        LineBloomType r102 = new LineBloomType("BLUR", 2);
        BLUR = r102;
        f31008a = new LineBloomType[]{r100, r101, r102};
    }

    public static LineBloomType[] values() {
        return (LineBloomType[]) f31008a.clone();
    }

    public static LineBloomType valueOf(String r100) {
        return (LineBloomType) r27.a.a(LineBloomType.class, r100);
    }

    private LineBloomType(String r100, int r101) {
        super(r100, r101);
    }
}
