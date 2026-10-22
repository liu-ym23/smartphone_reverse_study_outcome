package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b&\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/r1;", "Lcom/stepos/agentframework/chatui/S1;", "", "type", "<init>", "(I)V", "", Const.INTENT_KEY_PKGNAME, "()Z", "I", "getType", "()I", "setType", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.r1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2044r1 implements S1 {
    public static final int TYPE_ACTION_FOOTER = 4;
    public static final int TYPE_BUSINESS_START = 1000;
    public static final int TYPE_LOADING_BUBBLE = 5;
    public static final int TYPE_RECEIVED_TEXT = 0;
    public static final int TYPE_RECONNECT_PROMPT = 7;
    public static final int TYPE_SENT_FILE = 3;
    public static final int TYPE_SENT_IMAGE = 2;
    public static final int TYPE_SENT_TEXT = 1;
    public static final int TYPE_THINKING_BUBBLE = 6;
    public static final int TYPE_TOP_NOTICE = 8;
    private int type;

    public AbstractC2044r1(int i10) {
        this.type = i10;
    }

    @Override // com.stepos.agentframework.chatui.S1
    public boolean b() {
        return a() == 0 || a() == 1 || a() == 2 || a() == 3;
    }

    public /* synthetic */ AbstractC2044r1(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
