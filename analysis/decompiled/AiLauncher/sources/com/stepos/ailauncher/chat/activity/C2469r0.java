package com.stepos.ailauncher.chat.activity;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/r0;", "", "<init>", "()V", "", "conversationShowing", "", "liveSid", "extraSid", "departingSid", Const.INTENT_KEY_APIKEY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.activity.r0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2469r0 {
    public static final C2469r0 INSTANCE = new C2469r0();

    public final String a(boolean conversationShowing, String liveSid, String extraSid, String departingSid) {
        if (!conversationShowing) {
            return null;
        }
        if (extraSid == null || extraSid.length() <= 0) {
            extraSid = null;
        }
        if (liveSid == null || liveSid.length() <= 0) {
            liveSid = null;
        }
        if (departingSid == null || departingSid.length() <= 0) {
            departingSid = null;
        }
        if ((extraSid == null || kotlin.jvm.internal.p.d(extraSid, departingSid)) && ((liveSid != null && !kotlin.jvm.internal.p.d(liveSid, departingSid)) || extraSid == null)) {
            extraSid = liveSid;
        }
        if (extraSid == null || kotlin.jvm.internal.p.d(extraSid, departingSid)) {
            return null;
        }
        return extraSid;
    }
}
