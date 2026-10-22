package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/h;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class h extends d {
    public static final h INSTANCE = new h();

    public final void b() {
        C4148a.k("initSprite", "eventMinuteCounting = ", false, 4, null);
        a(new SpriteEvent(SpriteEventType.COUNTING, SpriteEventAction.COUNTING_MINUTE, 0L, null, 12, null));
    }
}
