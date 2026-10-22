package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/container/o0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/container/o0$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/container/o0$a;)V", "", "source", "sessionId", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Z", "handler", "Lcom/stepos/ailauncher/container/o0$a;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class o0 {
    public static final o0 INSTANCE = new o0();
    private static volatile a handler;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/container/o0$a;", "", "", "source", "sessionId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {
        boolean a(String source, String sessionId);
    }

    public final void a(a h10) {
        handler = h10;
    }

    public final boolean b(String source, String sessionId) {
        a aVar = handler;
        if (aVar != null) {
            return aVar.a(source, sessionId);
        }
        return false;
    }
}
