package com.stepos.ailauncher.chat.lockscreen;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.manager.C2689c0;
import com.stepos.ailauncher.chat.view.ChatView;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/lockscreen/y;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/view/ChatView;", "chatView", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/view/ChatView;)V", Const.INTENT_KEY_PKGNAME, "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    public static final y INSTANCE = new y();
    private static final String TAG = "LockScreenChatHandoff";

    public final void a(ChatView chatView) {
        kotlin.jvm.internal.p.i(chatView, "chatView");
        chatView.u1();
    }

    public final void b() {
        C2689c0.INSTANCE.c();
        C4148a.d(TAG, "clear", false, 4, null);
    }
}
