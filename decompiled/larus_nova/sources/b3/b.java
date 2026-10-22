package b3;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f17112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f17113b = null;

    public b() {
    }

    static {
        f17112a = new b();
        f17113b = new LinkedHashMap();
    }

    public final synchronized a a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);     // Catch: Throwable -> L6
        a r101 = (a) ((LinkedHashMap) f17113b).get(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
