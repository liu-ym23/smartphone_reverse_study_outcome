package a6;

import L4.AgentPlace;
import L4.l;
import W5.f;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.c;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteStateResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0010\u0010\u0003J\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014¨\u0006\u0017"}, d2 = {"La6/b;", "LX5/a;", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "event", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)V", Const.INTENT_KEY_UMID, "c", "", "isSwitch", "e", "(Z)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", Const.INTENT_KEY_PKGNAME, "", "spaceState", "Ljava/lang/String;", "skillState", "Companion", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a6.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1236b implements X5.a {
    public static final long BUBBLE_TEXT_PERIOD = 180000;
    private String spaceState = c.POSITION_MARKET;
    private String skillState = "browse";

    @Override // X5.a
    public void a(SpriteEvent event) {
        p.i(event, "event");
        if (C1235a.INSTANCE.a(event)) {
            if (p.d(event.getType(), SpriteEventType.COUNTING)) {
                b(event);
                return;
            }
            if (p.d(event.getAction(), SpriteEventAction.SPACE_MARKET_SWITCH)) {
                if (!p.d(this.spaceState, c.POSITION_MARKET)) {
                    if (p.d(this.skillState, "browse")) {
                        e(true);
                    } else if (p.d(this.skillState, "skill_install")) {
                        g(true);
                    }
                }
            } else if (p.d(event.getAction(), SpriteEventAction.SPACE_FIX_ROOM_SWITCH)) {
                if (!p.d(this.spaceState, "fix_room")) {
                    d();
                }
            } else if (p.d(event.getAction(), SpriteEventAction.SPACE_AGENT_TEAM_SWITCH)) {
                if (!p.d(this.spaceState, "team")) {
                    c();
                }
            } else if (p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_START)) {
                if (p.d(this.spaceState, c.POSITION_MARKET)) {
                    g(false);
                }
            } else if (p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_FAIL)) {
                if (p.d(this.spaceState, c.POSITION_MARKET)) {
                    e(false);
                }
            } else if (p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_SUCCESS) && p.d(this.spaceState, c.POSITION_MARKET)) {
                f();
            }
            if (p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_START)) {
                this.skillState = "skill_install";
            } else if (p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_FAIL) || p.d(event.getAction(), SpriteEventAction.MARKET_SKILL_INSTALL_SUCCESS)) {
                this.skillState = "browse";
            }
            if (p.d(event.getAction(), SpriteEventAction.SPACE_MARKET_SWITCH)) {
                this.spaceState = c.POSITION_MARKET;
            } else if (p.d(event.getAction(), SpriteEventAction.SPACE_FIX_ROOM_SWITCH)) {
                this.spaceState = "fix_room";
            } else if (p.d(event.getAction(), SpriteEventAction.SPACE_AGENT_TEAM_SWITCH)) {
                this.spaceState = "team";
            }
        }
    }

    public final void b(SpriteEvent event) {
        String str = p.d(this.spaceState, c.POSITION_MARKET) ? p.d(this.skillState, "skill_install") ? "skill_installing" : "skill_browse" : p.d(this.spaceState, "fix_room") ? "agent_fix_room" : "agent_team";
        V5.b bVar = V5.b.INSTANCE;
        if (bVar.d(str, 180000L)) {
            String strA = bVar.a(str);
            f.INSTANCE.a(strA);
            bVar.f(str, strA);
        }
    }

    public final void c() {
        f.INSTANCE.b(new SpriteStateResult(l.C0072l.INSTANCE, V5.b.INSTANCE.c("agent_team"), -1L, -1, null, null, false, 112, null), AgentPlace.a.INSTANCE);
    }

    public final void d() {
        f.INSTANCE.b(new SpriteStateResult(l.C0072l.INSTANCE, V5.b.INSTANCE.c("agent_fix_room"), 0L, -1, null, null, false, 112, null), AgentPlace.C0071f.INSTANCE);
    }

    public final void e(boolean isSwitch) {
        SpriteStateResult spriteStateResult = new SpriteStateResult(l.C0933f.INSTANCE, V5.b.INSTANCE.c("skill_browse"), -1L, -1, null, null, false, 112, null);
        if (isSwitch) {
            f.INSTANCE.b(spriteStateResult, AgentPlace.g.INSTANCE);
        } else {
            f.INSTANCE.b(spriteStateResult, null);
        }
    }

    public final void f() {
        l.C0946t c0946t = l.C0946t.INSTANCE;
        V5.b bVar = V5.b.INSTANCE;
        f.INSTANCE.b(new SpriteStateResult(c0946t, bVar.c("skill_install_success"), 3000L, 1, l.C0933f.INSTANCE, bVar.c("skill_browse"), false, 64, null), null);
    }

    public final void g(boolean isSwitch) {
        if (isSwitch) {
            f.INSTANCE.b(new SpriteStateResult(l.C0947u.INSTANCE, V5.b.INSTANCE.c("skill_installing"), -1L, -1, null, null, false, 112, null), AgentPlace.g.INSTANCE);
        } else {
            l.C0936i c0936i = l.C0936i.INSTANCE;
            V5.b bVar = V5.b.INSTANCE;
            f.INSTANCE.b(new SpriteStateResult(c0936i, bVar.c("skill_early_installing"), 10000L, -1, l.C0947u.INSTANCE, bVar.c("skill_installing"), false, 64, null), null);
        }
    }
}
