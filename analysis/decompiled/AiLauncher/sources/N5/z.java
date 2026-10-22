package N5;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"LN5/z;", "", "<init>", "()V", "", "taskId", "LN5/d;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)LN5/d;", "view", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;LN5/d;)V", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "viewMap", "Ljava/util/concurrent/ConcurrentHashMap;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    public static final z INSTANCE = new z();
    private static final ConcurrentHashMap<String, d> viewMap = new ConcurrentHashMap<>();

    public final d a(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return viewMap.get(taskId);
    }

    public final void b(String taskId, d view) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(view, "view");
        viewMap.put(taskId, view);
    }

    public final d c(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        return viewMap.remove(taskId);
    }
}
