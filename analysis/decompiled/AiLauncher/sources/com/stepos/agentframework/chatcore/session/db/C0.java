package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w4.MessagePart;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH'¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/C0;", "", "", "Lw4/f;", "parts", "LY8/t;", "c", "(Ljava/util/List;)V", "", "messageId", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/util/List;", "messageIds", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;)Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface C0 {
    List<MessagePart> a(List<String> messageIds);

    void b(String messageId);

    void c(List<MessagePart> parts);

    List<MessagePart> d(String messageId);
}
