package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/a;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "", "action", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "e", Const.INTENT_KEY_PKGNAME, "c", "TAG", "Ljava/lang/String;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a extends d {
    public static final a INSTANCE = new a();
    private static final String TAG = "AgentWakeEventCollector";

    public final void b() {
        d(SpriteEventAction.AGENT_WAKE_AI_KEY_CLICK);
    }

    public final void c() {
        d(SpriteEventAction.AGENT_WAKE_AI_KEY_LONG_CLICK);
    }

    public final void d(String action) {
        p.i(action, "action");
        C4148a.k(TAG, "agentWake action=" + action, false, 4, null);
        a(new SpriteEvent(SpriteEventType.AGENT_WAKE, action, System.currentTimeMillis(), null, 8, null));
    }

    public final void e() {
        d(SpriteEventAction.AGENT_WAKE_VOICE);
    }
}
