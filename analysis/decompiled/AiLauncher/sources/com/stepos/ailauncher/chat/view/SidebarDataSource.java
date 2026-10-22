package com.stepos.ailauncher.chat.view;

import Ua.C1056g;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.contract.api.agent.IExternalAgentBindService;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SidebarDataSource;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "", "currentSessionId", "", "refreshAgents", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", "cachedAgents", "Lcom/stepos/ailauncher/chat/view/Y8;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatcore/SessionHandler;Ljava/lang/String;ZLjava/util/List;Le9/c;)Ljava/lang/Object;", "fallback", "c", "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "deviceId", "agentType", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, "LY8/t;", "e", "(Ljava/lang/String;Ljava/lang/String;Z)V", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SidebarDataSource {
    public static final SidebarDataSource INSTANCE = new SidebarDataSource();
    private static final String TAG = "SidebarDataSource";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/view/SidebarDataSource$a;", "", "<init>", "()V", "", "Lcom/stepos/ailauncher/contract/api/agent/IExternalAgentBindService$SidebarAgent;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "agents", "LY8/t;", "c", "(Ljava/util/List;)V", "", "deviceId", "agentType", "", com.stepos.ailauncher.sla.G.NETWORK_ONLINE, Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_APIKEY, "()Ljava/lang/String;", "uid", "Ljava/lang/String;", "Ljava/util/List;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public static final a INSTANCE = new a();
        private static List<IExternalAgentBindService.SidebarAgent> agents = C1173v.m();
        private static String uid;

        /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String a() {
            /*
                r2 = this;
                r2 = 0
                kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L18
                com.stepos.ailauncher.foundation.account.f r0 = com.stepos.ailauncher.foundation.account.f.INSTANCE     // Catch: java.lang.Throwable -> L18
                boolean r1 = r0.v()     // Catch: java.lang.Throwable -> L18
                if (r1 == 0) goto L16
                java.lang.String r0 = r0.k()     // Catch: java.lang.Throwable -> L18
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L18
                if (r1 <= 0) goto L16
                goto L1a
            L16:
                r0 = r2
                goto L1a
            L18:
                r0 = move-exception
                goto L1f
            L1a:
                java.lang.Object r0 = kotlin.Result.b(r0)     // Catch: java.lang.Throwable -> L18
                goto L29
            L1f:
                kotlin.Result$a r1 = kotlin.Result.INSTANCE
                java.lang.Object r0 = kotlin.C4849c.a(r0)
                java.lang.Object r0 = kotlin.Result.b(r0)
            L29:
                boolean r1 = kotlin.Result.g(r0)
                if (r1 == 0) goto L30
                goto L31
            L30:
                r2 = r0
            L31:
                java.lang.String r2 = (java.lang.String) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.view.SidebarDataSource.a.a():java.lang.String");
        }

        public final synchronized List<IExternalAgentBindService.SidebarAgent> b() {
            String strA = a();
            if (strA == null) {
                return C1173v.m();
            }
            return kotlin.jvm.internal.p.d(strA, uid) ? agents : C1173v.m();
        }

        public final synchronized void c(List<IExternalAgentBindService.SidebarAgent> agents2) {
            kotlin.jvm.internal.p.i(agents2, "agents");
            uid = a();
            agents = agents2;
        }

        public final synchronized void d(String deviceId, String agentType, boolean online) {
            try {
                kotlin.jvm.internal.p.i(deviceId, "deviceId");
                kotlin.jvm.internal.p.i(agentType, "agentType");
                List<IExternalAgentBindService.SidebarAgent> list = agents;
                ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                for (IExternalAgentBindService.SidebarAgent sidebarAgentCopy : list) {
                    if (!sidebarAgentCopy.getInstalled() && La.D.L(La.H.D1(sidebarAgentCopy.getDeviceId()).toString(), La.H.D1(deviceId).toString(), true) && La.D.L(La.H.D1(sidebarAgentCopy.getAgentType()).toString(), La.H.D1(agentType).toString(), true)) {
                        sidebarAgentCopy = sidebarAgentCopy.copy((8175 & 1) != 0 ? sidebarAgentCopy.agentId : null, (8175 & 2) != 0 ? sidebarAgentCopy.deviceId : null, (8175 & 4) != 0 ? sidebarAgentCopy.displayName : null, (8175 & 8) != 0 ? sidebarAgentCopy.agentType : null, (8175 & 16) != 0 ? sidebarAgentCopy.online : online, (8175 & 32) != 0 ? sidebarAgentCopy.pinned : false, (8175 & 64) != 0 ? sidebarAgentCopy.updateAt : 0L, (8175 & 128) != 0 ? sidebarAgentCopy.installed : false, (8175 & 256) != 0 ? sidebarAgentCopy.enabled : false, (8175 & 512) != 0 ? sidebarAgentCopy.assetId : null, (8175 & 1024) != 0 ? sidebarAgentCopy.reversionId : null, (8175 & 2048) != 0 ? sidebarAgentCopy.semver : null, (8175 & 4096) != 0 ? sidebarAgentCopy.icon : null);
                    }
                    arrayList.add(sidebarAgentCopy);
                }
                agents = arrayList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object d(SidebarDataSource sidebarDataSource, List list, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = C1173v.m();
        }
        return sidebarDataSource.c(list, interfaceC4014c);
    }

    public final List<IExternalAgentBindService.SidebarAgent> a() {
        return a.INSTANCE.b();
    }

    public final Object b(SessionHandler sessionHandler, String str, boolean z10, List<IExternalAgentBindService.SidebarAgent> list, InterfaceC4014c<? super SidebarSnapshot> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new SidebarDataSource$load$2(str, z10, list, sessionHandler, null), interfaceC4014c);
    }

    public final Object c(List<IExternalAgentBindService.SidebarAgent> list, InterfaceC4014c<? super List<IExternalAgentBindService.SidebarAgent>> interfaceC4014c) {
        return C1056g.j(Ua.Y.b(), new SidebarDataSource$loadAgents$2(list, null), interfaceC4014c);
    }

    public final void e(String deviceId, String agentType, boolean online) {
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentType, "agentType");
        a.INSTANCE.d(deviceId, agentType, online);
    }
}
