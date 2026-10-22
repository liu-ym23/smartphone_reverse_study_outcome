package com.stepos.agentframework.chatcore.send;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatcore/send/k;", "", "Lcom/stepos/agentframework/chatcore/send/e;", "ctx", "Lcom/stepos/agentframework/chatcore/send/b;", "result", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/send/e;Lcom/stepos/agentframework/chatcore/send/b;)V", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/send/e;)V", "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface k {
    void a(SendContext ctx);

    void b(SendContext ctx, LocalExecResult result);

    void c(SendContext ctx);
}
