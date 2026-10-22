package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.controller.InterfaceC2538f;
import com.stepos.ailauncher.contract.model.search.SidebarSession;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/view/P7;", "", "Lcom/stepos/ailauncher/contract/model/search/SidebarSession;", "session", "LY8/t;", "f", "(Lcom/stepos/ailauncher/contract/model/search/SidebarSession;)V", "", "sessionId", "c", "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/chat/controller/f;", "target", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/chat/controller/f;)V", Const.INTENT_KEY_PKGNAME, "()V", "e", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "active", Const.INTENT_KEY_UMID, "(Z)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface P7 {
    void a(InterfaceC2538f target);

    void b();

    void c(String sessionId);

    default void d(boolean active) {
    }

    void e();

    void f(SidebarSession session);

    void g();
}
