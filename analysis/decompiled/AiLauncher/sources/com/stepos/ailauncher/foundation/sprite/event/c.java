package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/c;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "c", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c extends d {
    public static final c INSTANCE = new c();

    public final void b() {
        a(new SpriteEvent(SpriteEventType.NIGHT, SpriteEventAction.ENTER_NIGHT_MODE, System.currentTimeMillis(), null, 8, null));
    }

    public final void c() {
        a(new SpriteEvent(SpriteEventType.NIGHT, SpriteEventAction.EXIT_NIGHT_MODE, System.currentTimeMillis(), null, 8, null));
    }
}
