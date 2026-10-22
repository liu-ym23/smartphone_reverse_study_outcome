package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/j0;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.manager.j0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2703j0 {
    public static final C2703j0 INSTANCE = new C2703j0();

    public static final boolean c(String sessionId) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        return vVar.j() && vVar.p(sessionId);
    }

    public final void b() {
        x4.v.INSTANCE.b(new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.manager.i0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C2703j0.c((String) obj));
            }
        });
    }
}
