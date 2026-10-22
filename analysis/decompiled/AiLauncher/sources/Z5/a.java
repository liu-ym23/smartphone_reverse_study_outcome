package Z5;

import L4.l;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.R$string;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LZ5/a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "event", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)Z", "", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)I", "LL4/l;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)LL4/l;", "taskCount", "", "c", "(I)Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "f", "", "taskRunningTextList", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final List<Integer> taskRunningTextList = C1173v.p(Integer.valueOf(R$string.sprite_doing_tasks_foundation), Integer.valueOf(R$string.sprite_doing_tasks_foundation_two));

    public final l a(SpriteEvent event) {
        p.i(event, "event");
        return p.d(event.getAction(), SpriteEventAction.TASK_WAIT) ? l.C0930c.INSTANCE : p.d(event.getAction(), SpriteEventAction.TASK_SUCCESS) ? l.S.INSTANCE : p.d(event.getAction(), SpriteEventAction.TASK_ERROR) ? l.C0937j.INSTANCE : p.d(event.getAction(), SpriteEventAction.TASK_INTERRUPTED) ? l.C0948v.INSTANCE : l.T.INSTANCE;
    }

    public final int b(SpriteEvent event) {
        p.i(event, "event");
        return p.d(event.getAction(), SpriteEventAction.TASK_WAIT) ? 5 : 3;
    }

    public final String c(int taskCount) {
        if (taskCount <= 1) {
            return V5.b.INSTANCE.c(SpriteEventAction.TASK_RUNNING);
        }
        String string = C3197a.INSTANCE.a().getString(((Number) F.U0(taskRunningTextList, Random.INSTANCE)).intValue(), Integer.valueOf(taskCount));
        p.h(string, "getString(...)");
        return string;
    }

    public final String d(int taskCount) {
        if (taskCount <= 1) {
            return V5.b.INSTANCE.c("task_waiting");
        }
        String string = C3197a.INSTANCE.a().getString(R$string.sprite_auth_tasks_foundation, Integer.valueOf(taskCount));
        p.h(string, "getString(...)");
        return string;
    }

    public final String e(int taskCount) {
        if (taskCount <= 1) {
            return V5.b.INSTANCE.c("task_waiting");
        }
        String string = C3197a.INSTANCE.a().getString(R$string.sprite_pending_tasks_foundation, Integer.valueOf(taskCount));
        p.h(string, "getString(...)");
        return string;
    }

    public final String f(int taskCount) {
        if (taskCount <= 1) {
            return V5.b.INSTANCE.c("task_waiting");
        }
        String string = C3197a.INSTANCE.a().getString(R$string.sprite_danger_tasks_foundation, Integer.valueOf(taskCount));
        p.h(string, "getString(...)");
        return string;
    }

    public final boolean g(SpriteEvent event) {
        p.i(event, "event");
        return p.d(event.getType(), SpriteEventType.TASK) || p.d(event.getType(), SpriteEventType.NIGHT) || p.d(event.getType(), SpriteEventType.COUNTING) || p.d(event.getType(), SpriteEventType.USER) || p.d(event.getType(), SpriteEventType.SYSTEM) || p.d(event.getType(), SpriteEventType.NETWORK) || p.d(event.getType(), SpriteEventType.AGENT_WORK) || p.d(event.getType(), SpriteEventType.AGENT_WAKE);
    }
}
