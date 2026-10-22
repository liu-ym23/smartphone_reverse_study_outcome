package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/e;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "", "spaceEvent", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e extends d {
    public static final e INSTANCE = new e();

    public final void b(String spaceEvent) {
        p.i(spaceEvent, "spaceEvent");
        a(new SpriteEvent(SpriteEventType.SPACE, spaceEvent, System.currentTimeMillis(), null, 8, null));
    }
}
