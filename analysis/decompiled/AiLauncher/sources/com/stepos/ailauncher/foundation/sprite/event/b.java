package com.stepos.ailauncher.foundation.sprite.event;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u0003J\r\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u0003J\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003J\r\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0003J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/foundation/sprite/event/b;", "Lcom/stepos/ailauncher/foundation/sprite/event/d;", "<init>", "()V", "", "action", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "c", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "e", "TAG", "Ljava/lang/String;", "", "executingActive", "Z", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b extends d {
    public static final b INSTANCE = new b();
    private static final String TAG = "AgentWorkEventCollector";
    private static boolean executingActive;

    public final void b(String action) {
        p.i(action, "action");
        C4148a.k(TAG, "agentWork action=" + action, false, 4, null);
        a(new SpriteEvent(SpriteEventType.AGENT_WORK, action, System.currentTimeMillis(), null, 8, null));
    }

    public final void c() {
        if (!executingActive) {
            C4148a.k(TAG, "skip executing_done without executing", false, 4, null);
        } else {
            executingActive = false;
            b(SpriteEventAction.AGENT_EXECUTE_END);
        }
    }

    public final void d() {
        if (executingActive) {
            C4148a.k(TAG, "skip duplicate executing", false, 4, null);
        } else {
            executingActive = true;
            b(SpriteEventAction.AGENT_EXECUTE_START);
        }
    }

    public final void e() {
        b(SpriteEventAction.AGENT_LISTENING_END);
    }

    public final void f() {
        b("listening");
    }

    public final void g() {
        b(SpriteEventAction.AGENT_THINKING_END);
    }

    public final void h() {
        b(SpriteEventAction.AGENT_THINKING_START);
    }

    public final void i() {
        b("speaking_done");
    }

    public final void j() {
        b("speaking_done");
    }

    public final void k() {
        b(SpriteEventAction.AGENT_TTS_START);
    }
}
