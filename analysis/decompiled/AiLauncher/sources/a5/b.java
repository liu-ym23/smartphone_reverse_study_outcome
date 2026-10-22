package a5;

import com.autonavi.aps.amapapi.config.Const;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bRT\u0010\u000e\u001aB\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00060\u0006 \r* \u0012\f\u0012\n \r*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\f0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"La5/b;", "", "<init>", "()V", "", "sessionId", "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Z", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "listenedSessionIds", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final b INSTANCE = new b();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> listenedSessionIds = ConcurrentHashMap.newKeySet();

    public final boolean a(String sessionId) {
        p.i(sessionId, "sessionId");
        return listenedSessionIds.add(sessionId);
    }

    public final void b(String sessionId) {
        p.i(sessionId, "sessionId");
        listenedSessionIds.remove(sessionId);
    }
}
