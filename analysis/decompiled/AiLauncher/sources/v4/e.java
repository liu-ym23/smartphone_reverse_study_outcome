package v4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.EReplyStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lv4/e;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "status", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/session/EReplyStatus;)Ljava/lang/String;", "statusStr", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/EReplyStatus;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    public final String a(EReplyStatus status) {
        p.i(status, "status");
        return status.name();
    }

    public final EReplyStatus b(String statusStr) {
        p.i(statusStr, "statusStr");
        return EReplyStatus.valueOf(statusStr);
    }
}
