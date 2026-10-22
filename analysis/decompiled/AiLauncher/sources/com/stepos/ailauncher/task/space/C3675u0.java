package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/task/space/u0;", "", "<init>", "()V", "", "pageResumed", "panelShown", "onChatPage", "", "sessionId", "", "aliases", Const.INTENT_KEY_APIKEY, "(ZZZLjava/lang/String;Ljava/util/Collection;)Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.u0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3675u0 {
    public static final C3675u0 INSTANCE = new C3675u0();

    public final boolean a(boolean pageResumed, boolean panelShown, boolean onChatPage, String sessionId, Collection<String> aliases) {
        kotlin.jvm.internal.p.i(aliases, "aliases");
        boolean z10 = false;
        boolean z11 = pageResumed && panelShown;
        if (z11 && onChatPage) {
            z10 = true;
        }
        com.stepos.ailauncher.common.utils.v vVar = com.stepos.ailauncher.common.utils.v.INSTANCE;
        vVar.q(z11, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        vVar.r(z10, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        if (z10) {
            vVar.s(sessionId, aliases, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
            return z10;
        }
        vVar.b(null, com.stepos.ailauncher.common.utils.v.OWNER_OVERLAY);
        return z10;
    }
}
