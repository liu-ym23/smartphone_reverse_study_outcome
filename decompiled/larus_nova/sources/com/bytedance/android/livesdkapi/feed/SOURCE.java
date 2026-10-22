package com.bytedance.android.livesdkapi.feed;

import com.bytedance.awemeopen.apps.photo.pinch.PinchStableView;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/SOURCE;", "", "source", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getSource", "WATCH_DELAY", "LAST_SLIDE_UP", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SOURCE extends Enum<SOURCE> {
    private static final /* synthetic */ SOURCE[] $VALUES = null;
    public static final SOURCE LAST_SLIDE_UP = null;
    public static final SOURCE WATCH_DELAY = null;
    private final String desc;
    private final String source;

    static {
        SOURCE r100 = new SOURCE("WATCH_DELAY", 0, "watch_delay", "停留一段时间");
        WATCH_DELAY = r100;
        SOURCE r101 = new SOURCE("LAST_SLIDE_UP", 1, PinchStableView.Gesture.PULL_UP, "最后一个直播间上滑");
        LAST_SLIDE_UP = r101;
        $VALUES = new SOURCE[]{r100, r101};
    }

    public static SOURCE valueOf(String r100) {
        return (SOURCE) a.a(SOURCE.class, r100);
    }

    public static SOURCE[] values() {
        return (SOURCE[]) $VALUES.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getSource() {
        return this.source;
    }

    private SOURCE(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.source = r102;
        this.desc = r103;
    }
}
