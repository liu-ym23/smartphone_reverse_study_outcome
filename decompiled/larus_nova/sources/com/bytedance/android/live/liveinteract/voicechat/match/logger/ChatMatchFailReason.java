package com.bytedance.android.live.liveinteract.voicechat.match.logger;

import com.hihonor.honorid.core.data.UserInfo;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/match/logger/ChatMatchFailReason;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "OCCUPATION", "CANCEL", "NO_MATCH", "REQUEST_FAIL", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ChatMatchFailReason extends Enum<ChatMatchFailReason> {
    public static final ChatMatchFailReason CANCEL = null;
    public static final ChatMatchFailReason NO_MATCH = null;
    public static final ChatMatchFailReason OCCUPATION = null;
    public static final ChatMatchFailReason REQUEST_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChatMatchFailReason[] f80312a = null;
    private final String value;

    static {
        ChatMatchFailReason r100 = new ChatMatchFailReason("OCCUPATION", 0, UserInfo.OCCUPATION);
        OCCUPATION = r100;
        ChatMatchFailReason r101 = new ChatMatchFailReason("CANCEL", 1, "cancel");
        CANCEL = r101;
        ChatMatchFailReason r102 = new ChatMatchFailReason("NO_MATCH", 2, "no_match");
        NO_MATCH = r102;
        ChatMatchFailReason r103 = new ChatMatchFailReason("REQUEST_FAIL", 3, "request_fail");
        REQUEST_FAIL = r103;
        f80312a = new ChatMatchFailReason[]{r100, r101, r102, r103};
    }

    public static ChatMatchFailReason valueOf(String r100) {
        return (ChatMatchFailReason) a.a(ChatMatchFailReason.class, r100);
    }

    public static ChatMatchFailReason[] values() {
        return (ChatMatchFailReason[]) f80312a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ChatMatchFailReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
