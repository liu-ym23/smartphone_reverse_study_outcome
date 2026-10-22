package B6;

import La.H;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LB6/a;", "", "<init>", "()V", "", "sessionId", "toolName", "", "isFinished", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Z)V", "Ljava/util/concurrent/ConcurrentHashMap;", "LB6/a$a;", "listeners", "Ljava/util/concurrent/ConcurrentHashMap;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final ConcurrentHashMap<Object, InterfaceC0008a> listeners = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"LB6/a$a;", "", "", "sessionId", "toolName", "", "isFinished", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Z)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: B6.a$a, reason: collision with other inner class name */
    public interface InterfaceC0008a {
        void a(String sessionId, String toolName, boolean isFinished);
    }

    public final void a(String sessionId, String toolName, boolean isFinished) {
        if (sessionId == null || H.x0(sessionId)) {
            return;
        }
        Collection<InterfaceC0008a> collectionValues = listeners.values();
        p.h(collectionValues, "<get-values>(...)");
        List listM1 = F.m1(collectionValues);
        if (listM1.isEmpty()) {
            return;
        }
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            ((InterfaceC0008a) it.next()).a(sessionId, toolName, isFinished);
        }
    }
}
