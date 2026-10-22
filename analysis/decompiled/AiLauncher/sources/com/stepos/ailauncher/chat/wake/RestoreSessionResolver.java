package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\b\u0010\tJ+\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0000¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/RestoreSessionResolver;", "", "<init>", "()V", "", "remembered", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/agentframework/chatcore/SessionHandler;Le9/c;)Ljava/lang/Object;", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "sessions", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RestoreSessionResolver {
    public static final RestoreSessionResolver INSTANCE = new RestoreSessionResolver();
    private static final String TAG = "RestoreSessionResolver";

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.lang.String r9, com.stepos.agentframework.chatcore.SessionHandler r10, e9.InterfaceC4014c<? super java.lang.String> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.wake.RestoreSessionResolver.a(java.lang.String, com.stepos.agentframework.chatcore.SessionHandler, e9.c):java.lang.Object");
    }

    public final String b(String remembered, List<SidebarSession> sessions) {
        if (sessions == null) {
            return remembered;
        }
        if (sessions.isEmpty()) {
            return null;
        }
        if (remembered != null) {
            List<SidebarSession> list = sessions;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (kotlin.jvm.internal.p.d(((SidebarSession) it.next()).getSessionId(), remembered)) {
                        return remembered;
                    }
                }
            }
        }
        return ((SidebarSession) Z8.F.q0(sessions)).getSessionId();
    }
}
