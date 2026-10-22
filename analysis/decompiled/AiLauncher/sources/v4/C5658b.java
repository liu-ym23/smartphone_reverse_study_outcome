package v4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatHintType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lv4/b;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "hint", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/ChatHintType;)I", "code", Const.INTENT_KEY_PKGNAME, "(I)Lcom/stepos/agentframework/chatcore/session/ChatHintType;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: v4.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5658b {
    public final int a(ChatHintType hint) {
        p.i(hint, "hint");
        return hint.getCode();
    }

    public final ChatHintType b(int code) {
        return ChatHintType.INSTANCE.a(code);
    }
}
