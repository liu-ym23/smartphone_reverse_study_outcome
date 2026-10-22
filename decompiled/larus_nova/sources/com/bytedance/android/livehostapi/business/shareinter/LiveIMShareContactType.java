package com.bytedance.android.livehostapi.business.shareinter;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/shareinter/LiveIMShareContactType;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "RECENT", "WECHAT", "MORE", "CONTACT", "UG_SHARE_WECHAT", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveIMShareContactType extends Enum<LiveIMShareContactType> {
    private static final /* synthetic */ LiveIMShareContactType[] $VALUES = null;
    public static final LiveIMShareContactType CONTACT = null;
    public static final LiveIMShareContactType MORE = null;
    public static final LiveIMShareContactType RECENT = null;
    public static final LiveIMShareContactType UG_SHARE_WECHAT = null;
    public static final LiveIMShareContactType WECHAT = null;
    private final String key;

    static {
        LiveIMShareContactType r100 = new LiveIMShareContactType("RECENT", 0, "im_recent_friend");
        RECENT = r100;
        LiveIMShareContactType r101 = new LiveIMShareContactType("WECHAT", 1, "add_wechat_friends");
        WECHAT = r101;
        LiveIMShareContactType r102 = new LiveIMShareContactType("MORE", 2, "more_contact");
        MORE = r102;
        LiveIMShareContactType r103 = new LiveIMShareContactType("CONTACT", 3, "im_friend");
        CONTACT = r103;
        LiveIMShareContactType r104 = new LiveIMShareContactType("UG_SHARE_WECHAT", 4, "ug_share_wechat");
        UG_SHARE_WECHAT = r104;
        $VALUES = new LiveIMShareContactType[]{r100, r101, r102, r103, r104};
    }

    public static LiveIMShareContactType valueOf(String r100) {
        return (LiveIMShareContactType) a.a(LiveIMShareContactType.class, r100);
    }

    public static LiveIMShareContactType[] values() {
        return (LiveIMShareContactType[]) $VALUES.clone();
    }

    public final String getKey() {
        return this.key;
    }

    private LiveIMShareContactType(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
