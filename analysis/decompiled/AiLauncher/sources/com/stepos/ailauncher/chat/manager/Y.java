package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.ailauncher.foundation.account.AccountInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/Y;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "com/stepos/ailauncher/chat/manager/Y$a", "callback", "Lcom/stepos/ailauncher/chat/manager/Y$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Y {
    public static final Y INSTANCE = new Y();
    private static final a callback = new a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/chat/manager/Y$a", "Lcom/stepos/ailauncher/foundation/account/i;", "Lcom/stepos/ailauncher/foundation/account/a;", "accountInfo", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/account/a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements com.stepos.ailauncher.foundation.account.i {
        @Override // com.stepos.ailauncher.foundation.account.i
        public void a(AccountInfo accountInfo) {
            ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
            if (chatCoreSdk.g()) {
                if (accountInfo == null) {
                    chatCoreSdk.i();
                } else {
                    chatCoreSdk.k(accountInfo.getAccountId());
                }
            }
            if (accountInfo != null && AuthManager.INSTANCE.Y()) {
                com.stepos.ailauncher.common.startup.g.INSTANCE.q();
            }
            U0.INSTANCE.t();
        }
    }

    public final void a() {
        com.stepos.ailauncher.foundation.account.f.INSTANCE.z(callback);
        b();
    }

    public final void b() {
        String strK = com.stepos.ailauncher.foundation.account.f.INSTANCE.k();
        if (strK.length() == 0) {
            return;
        }
        ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
        if (chatCoreSdk.g()) {
            chatCoreSdk.k(strK);
        }
    }
}
