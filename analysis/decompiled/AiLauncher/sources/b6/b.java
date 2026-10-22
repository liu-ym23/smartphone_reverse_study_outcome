package b6;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.task.entity.UiTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ%\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lb6/b;", "", "<init>", "()V", "Lb6/a;", "observer", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lb6/a;)V", "c", "Lcom/stepos/ailauncher/foundation/task/entity/UiTask;", "taskCard", "", "activeTasks", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/foundation/task/entity/UiTask;Ljava/util/List;)V", "", "observers", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final List<InterfaceC1452a> observers = new ArrayList();

    public final void a(InterfaceC1452a observer) {
        p.i(observer, "observer");
        List<InterfaceC1452a> list = observers;
        if (list.contains(observer)) {
            return;
        }
        list.add(observer);
    }

    public final void b(UiTask taskCard, List<UiTask> activeTasks) {
        p.i(taskCard, "taskCard");
        p.i(activeTasks, "activeTasks");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((InterfaceC1452a) it.next()).a(taskCard, activeTasks);
        }
    }

    public final void c(InterfaceC1452a observer) {
        p.i(observer, "observer");
        observers.remove(observer);
    }
}
