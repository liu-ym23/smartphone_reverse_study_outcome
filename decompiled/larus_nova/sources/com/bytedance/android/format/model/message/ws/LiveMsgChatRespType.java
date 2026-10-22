package com.bytedance.android.format.model.message.ws;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/format/model/message/ws/LiveMsgChatRespType;", "", "", "type", "I", "getType", "()I", "AIReplyDefault", "AIReplyTargeted", "UserActive", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveMsgChatRespType extends Enum<LiveMsgChatRespType> {
    public static final LiveMsgChatRespType AIReplyDefault = null;
    public static final LiveMsgChatRespType AIReplyTargeted = null;
    public static final LiveMsgChatRespType UserActive = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveMsgChatRespType[] f51363a = null;
    private final int type;

    static {
        LiveMsgChatRespType r100 = new LiveMsgChatRespType("AIReplyDefault", 0, 0);
        AIReplyDefault = r100;
        LiveMsgChatRespType r101 = new LiveMsgChatRespType("AIReplyTargeted", 1, 1);
        AIReplyTargeted = r101;
        LiveMsgChatRespType r102 = new LiveMsgChatRespType("UserActive", 2, 2);
        UserActive = r102;
        f51363a = new LiveMsgChatRespType[]{r100, r101, r102};
    }

    public static LiveMsgChatRespType valueOf(String r100) {
        return (LiveMsgChatRespType) a.a(LiveMsgChatRespType.class, r100);
    }

    public static LiveMsgChatRespType[] values() {
        return (LiveMsgChatRespType[]) f51363a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public LiveMsgChatRespType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
