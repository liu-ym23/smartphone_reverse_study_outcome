package com.bytedance.android.livesdk.chatroom.utils;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/utils/SkinLoadResultType;", "", GXAnimation.STATE_START, "SUCCESS", "ERROR", GXAnimation.STATE_END, "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SkinLoadResultType extends Enum<SkinLoadResultType> {
    public static final SkinLoadResultType END = null;
    public static final SkinLoadResultType ERROR = null;
    public static final SkinLoadResultType START = null;
    public static final SkinLoadResultType SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkinLoadResultType[] f114371a = null;

    static {
        SkinLoadResultType r100 = new SkinLoadResultType(GXAnimation.STATE_START, 0);
        START = r100;
        SkinLoadResultType r101 = new SkinLoadResultType("SUCCESS", 1);
        SUCCESS = r101;
        SkinLoadResultType r102 = new SkinLoadResultType("ERROR", 2);
        ERROR = r102;
        SkinLoadResultType r103 = new SkinLoadResultType(GXAnimation.STATE_END, 3);
        END = r103;
        f114371a = new SkinLoadResultType[]{r100, r101, r102, r103};
    }

    public static SkinLoadResultType valueOf(String r100) {
        return (SkinLoadResultType) r27.a.a(SkinLoadResultType.class, r100);
    }

    public static SkinLoadResultType[] values() {
        return (SkinLoadResultType[]) f114371a.clone();
    }

    public SkinLoadResultType(String r100, int r101) {
        super(r100, r101);
    }
}
