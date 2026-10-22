package com.stepos.ailauncher.chat.wake;

import android.content.Intent;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/f;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/wake/f$a;", "handler", "Lcom/stepos/ailauncher/chat/wake/f$a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/wake/f$a;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/wake/f$a;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3119f {
    public static final C3119f INSTANCE = new C3119f();
    private static volatile a handler;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/f$a;", "", "Landroid/content/Intent;", "intent", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Intent;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.wake.f$a */
    public interface a {
        boolean a(Intent intent);
    }

    public final a a() {
        return handler;
    }

    public final void b(a aVar) {
        handler = aVar;
    }
}
