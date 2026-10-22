package U5;

import android.os.Handler;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.sprite.event.c;
import com.stepos.ailauncher.foundation.sprite.event.e;
import com.stepos.ailauncher.foundation.sprite.event.f;
import com.stepos.ailauncher.foundation.sprite.event.g;
import com.stepos.ailauncher.foundation.sprite.event.h;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import h8.C4148a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u0003J\r\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0003J\r\u0010\u001d\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0003J\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0003J\r\u0010\u001f\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010\u0003J\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\u0003J\r\u0010!\u001a\u00020\u0006¢\u0006\u0004\b!\u0010\u0003J\r\u0010\"\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010\u0003J\r\u0010#\u001a\u00020\u0006¢\u0006\u0004\b#\u0010\u0003J\r\u0010$\u001a\u00020\u0006¢\u0006\u0004\b$\u0010\u0003J\r\u0010%\u001a\u00020\u0006¢\u0006\u0004\b%\u0010\u0003J\r\u0010&\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0003J\r\u0010'\u001a\u00020\u0006¢\u0006\u0004\b'\u0010\u0003J\u0015\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0011¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u000f¢\u0006\u0004\b,\u0010\u001aJ\r\u0010-\u001a\u00020\u0011¢\u0006\u0004\b-\u0010.J=\u00103\u001a\u00020\u00062.\u00102\u001a*\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f000/j\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f00`1¢\u0006\u0004\b3\u00104¨\u00065"}, d2 = {"LU5/b;", "", "<init>", "()V", "LW5/b;", "callback", "LY8/t;", "p", "(LW5/b;)V", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "task", "", "taskList", "v", "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;Ljava/util/List;)V", "", "level", "", "isAdd", "w", "(Ljava/lang/String;Z)V", "btnIds", "t", "(Ljava/lang/String;Ljava/lang/String;)V", "spaceAction", "r", "(Ljava/lang/String;)V", "x", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "c", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", Const.INTENT_KEY_UMID, "m", "k", "l", "isNight", "o", "(Z)V", "systemAction", "s", "n", "()Z", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "hasMap", "q", "(Ljava/util/HashMap;)V", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();

    public static final void u() {
        g.INSTANCE.c();
    }

    public final void b() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.c();
    }

    public final void c() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.d();
    }

    public final void d() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.e();
    }

    public final void e() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.f();
    }

    public final void f() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.g();
    }

    public final void g() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.h();
    }

    public final void h() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.i();
    }

    public final void i() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.j();
    }

    public final void j() {
        com.stepos.ailauncher.foundation.sprite.event.b.INSTANCE.k();
    }

    public final void k() {
        com.stepos.ailauncher.foundation.sprite.event.a.INSTANCE.b();
    }

    public final void l() {
        com.stepos.ailauncher.foundation.sprite.event.a.INSTANCE.c();
    }

    public final void m() {
        com.stepos.ailauncher.foundation.sprite.event.a.INSTANCE.e();
    }

    public final boolean n() {
        return X5.b.INSTANCE.i();
    }

    public final void o(boolean isNight) {
        if (isNight) {
            c.INSTANCE.b();
        } else {
            c.INSTANCE.c();
        }
    }

    public final void p(W5.b callback) {
        p.i(callback, "callback");
        W5.a.INSTANCE.d(callback);
    }

    public final void q(HashMap<String, String[]> hasMap) {
        p.i(hasMap, "hasMap");
        V5.b.INSTANCE.e(hasMap);
    }

    public final void r(String spaceAction) {
        p.i(spaceAction, "spaceAction");
        e.INSTANCE.b(spaceAction);
    }

    public final void s(String systemAction) {
        p.i(systemAction, "systemAction");
        f.INSTANCE.b(systemAction);
    }

    public final void t(String level, String btnIds) {
        p.i(level, "level");
        p.i(btnIds, "btnIds");
        if (p.d(level, "high") && p.d(btnIds, "reject")) {
            new Handler().postDelayed(new Runnable() { // from class: U5.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.u();
                }
            }, 1000L);
        }
    }

    public final void v(UiTask task, List<UiTask> taskList) {
        p.i(task, "task");
        p.i(taskList, "taskList");
        X5.b.INSTANCE.l(taskList);
        Iterator<T> it = taskList.iterator();
        while (it.hasNext()) {
            C4148a.h("taskUpdate", "it.status = " + ((UiTask) it.next()).getStatus(), false, 4, null);
        }
        g.INSTANCE.b(task);
    }

    public final void w(String level, boolean isAdd) {
        p.i(level, "level");
        if (p.d(level, "high")) {
            if (isAdd) {
                X5.b bVar = X5.b.INSTANCE;
                bVar.n(bVar.f() + 1);
            } else {
                X5.b.INSTANCE.n(r0.f() - 1);
            }
        } else if (isAdd) {
            X5.b bVar2 = X5.b.INSTANCE;
            bVar2.m(bVar2.e() + 1);
        } else {
            X5.b.INSTANCE.m(r0.e() - 1);
        }
        g.INSTANCE.d();
    }

    public final void x() {
        h.INSTANCE.b();
    }
}
