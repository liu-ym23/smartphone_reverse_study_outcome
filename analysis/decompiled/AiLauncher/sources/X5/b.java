package X5;

import L4.l;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEvent;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventAction;
import com.stepos.ailauncher.foundation.sprite.bean.SpriteEventType;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0006J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0006¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR(\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010&R\"\u0010(\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-¨\u00061"}, d2 = {"LX5/b;", "", "<init>", "()V", "LL4/l;", Const.INTENT_KEY_PKGNAME, "()LL4/l;", VoiceWakeupReceiver.EXTRA_STATE, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LL4/l;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "(LL4/l;)LL4/l;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "c", "Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;", "event", "LY8/t;", "k", "(Lcom/stepos/ailauncher/foundation/sprite/bean/SpriteEvent;)V", "isNight", "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "setNight", "(Z)V", "", "idleList", "Ljava/util/List;", "getIdleList", "()Ljava/util/List;", "runningList", "getRunningList", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "mRunningTaskList", Const.INTENT_KEY_UMID, "l", "(Ljava/util/List;)V", "", "taskWaitAuthCount", "I", "e", "()I", "m", "(I)V", "taskWaitDangerCount", "f", "n", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final List<l> idleList = C1173v.p(l.C0939m.INSTANCE, l.C0940n.INSTANCE, l.C0941o.INSTANCE, l.C0942p.INSTANCE, l.C0944r.INSTANCE);
    private static boolean isNight;
    private static List<UiTask> mRunningTaskList;
    private static final List<l> runningList;
    private static int taskWaitAuthCount;
    private static int taskWaitDangerCount;

    static {
        l.T t10 = l.T.INSTANCE;
        runningList = C1173v.p(t10, t10, t10, l.U.INSTANCE);
        mRunningTaskList = C1173v.m();
    }

    public final l a(l state) {
        p.i(state, "state");
        if (isNight) {
            return l.C0943q.INSTANCE;
        }
        List<l> list = idleList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!p.d((l) obj, state)) {
                arrayList.add(obj);
            }
        }
        return (l) F.U0(arrayList, Random.INSTANCE);
    }

    public final l b() {
        return isNight ? l.C0943q.INSTANCE : (l) F.U0(idleList, Random.INSTANCE);
    }

    public final l c() {
        return (l) F.U0(runningList, Random.INSTANCE);
    }

    public final List<UiTask> d() {
        return mRunningTaskList;
    }

    public final int e() {
        return taskWaitAuthCount;
    }

    public final int f() {
        return taskWaitDangerCount;
    }

    public final boolean g(l state) {
        p.i(state, "state");
        return p.d(state, l.C0943q.INSTANCE) || p.d(state, l.C0939m.INSTANCE) || p.d(state, l.C0940n.INSTANCE) || p.d(state, l.C0941o.INSTANCE) || p.d(state, l.C0942p.INSTANCE) || p.d(state, l.C0944r.INSTANCE);
    }

    public final boolean h(l state) {
        p.i(state, "state");
        return idleList.contains(state);
    }

    public final boolean i() {
        return isNight;
    }

    public final boolean j(l state) {
        p.i(state, "state");
        return runningList.contains(state);
    }

    public final void k(SpriteEvent event) {
        p.i(event, "event");
        if (p.d(event.getType(), SpriteEventType.NIGHT)) {
            if (p.d(event.getAction(), SpriteEventAction.ENTER_NIGHT_MODE)) {
                isNight = true;
            } else if (p.d(event.getAction(), SpriteEventAction.EXIT_NIGHT_MODE)) {
                isNight = false;
            }
        }
    }

    public final void l(List<UiTask> list) {
        p.i(list, "<set-?>");
        mRunningTaskList = list;
    }

    public final void m(int i10) {
        taskWaitAuthCount = i10;
    }

    public final void n(int i10) {
        taskWaitDangerCount = i10;
    }
}
