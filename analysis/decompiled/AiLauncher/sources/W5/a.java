package W5;

import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"LW5/a;", "", "<init>", "()V", "LW5/b;", "observer", "LY8/t;", Const.INTENT_KEY_UMID, "(LW5/b;)V", "", "eventName", "", "isTaskExecuting", "isForeground", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;ZZ)V", "c", "(Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "EXTRA_IS_TASK_EXECUTING", "Ljava/lang/String;", "EXTRA_IS_READ", "", "observers", "Ljava/util/List;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String EXTRA_IS_READ = "is_read";
    public static final String EXTRA_IS_TASK_EXECUTING = "is_task_executing";
    public static final a INSTANCE = new a();
    private static final List<b> observers = new ArrayList();

    public final void a(String eventName) {
        p.i(eventName, "eventName");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((b) it.next()).b(eventName);
        }
    }

    public final void b(String eventName, boolean isTaskExecuting, boolean isForeground) {
        p.i(eventName, "eventName");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(eventName, isTaskExecuting, isForeground);
        }
    }

    public final void c(String eventName) {
        p.i(eventName, "eventName");
        Iterator it = F.m1(observers).iterator();
        while (it.hasNext()) {
            ((b) it.next()).c(eventName);
        }
    }

    public final void d(b observer) {
        p.i(observer, "observer");
        List<b> list = observers;
        if (list.contains(observer)) {
            return;
        }
        list.add(observer);
    }
}
