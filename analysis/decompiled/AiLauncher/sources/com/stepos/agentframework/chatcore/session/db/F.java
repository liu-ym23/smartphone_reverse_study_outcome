package com.stepos.agentframework.chatcore.session.db;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import w4.ChatMessageVariant;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\tH'¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0007H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H'¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/db/F;", "", "Lw4/d;", "variant", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lw4/d;)V", "", "groupId", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/util/List;", "", "variantIndex", "k", "(Ljava/lang/String;I)Lw4/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)I", "l", "(Ljava/lang/String;)Ljava/lang/Integer;", "groupIds", "Lcom/stepos/agentframework/chatcore/session/db/I1;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/List;", "f", "(Ljava/lang/String;I)V", "sessionId", "e", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "()V", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface F {
    void a();

    void e(String sessionId);

    void f(String groupId, int variantIndex);

    void g(ChatMessageVariant variant);

    int h(String groupId);

    List<VariantGroupCount> i(List<String> groupIds);

    List<ChatMessageVariant> j(String groupId);

    ChatMessageVariant k(String groupId, int variantIndex);

    Integer l(String groupId);
}
