package com.bytedance.android.livesdkapi.paramtransfer.utils;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/utils/LiveEntranceTag;", "", "(Ljava/lang/String;I)V", "TAG_JUMP_IN_ROOM", "TAG_DRAWER_IN_ROOM", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveEntranceTag extends Enum<LiveEntranceTag> {
    private static final /* synthetic */ LiveEntranceTag[] $VALUES = null;
    public static final LiveEntranceTag TAG_DRAWER_IN_ROOM = null;
    public static final LiveEntranceTag TAG_JUMP_IN_ROOM = null;

    static {
        LiveEntranceTag r100 = new LiveEntranceTag("TAG_JUMP_IN_ROOM", 0);
        TAG_JUMP_IN_ROOM = r100;
        LiveEntranceTag r101 = new LiveEntranceTag("TAG_DRAWER_IN_ROOM", 1);
        TAG_DRAWER_IN_ROOM = r101;
        $VALUES = new LiveEntranceTag[]{r100, r101};
    }

    public static LiveEntranceTag valueOf(String r100) {
        return (LiveEntranceTag) a.a(LiveEntranceTag.class, r100);
    }

    public static LiveEntranceTag[] values() {
        return (LiveEntranceTag[]) $VALUES.clone();
    }

    private LiveEntranceTag(String r100, int r101) {
        super(r100, r101);
    }
}
