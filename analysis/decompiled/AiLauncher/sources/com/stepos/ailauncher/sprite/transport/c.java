package com.stepos.ailauncher.sprite.transport;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/sprite/transport/c;", "", "<init>", "()V", "", "code", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "sprite_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final c INSTANCE = new c();

    public final void a(int code) {
        if (UserEvent.INSTANCE.a(code) != null) {
            return;
        }
        throw new SecurityException("onUserEvent denied: unknown event=" + code);
    }
}
