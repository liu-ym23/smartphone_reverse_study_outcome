package au8;

import android.os.Bundle;
import com.larus.apm.api.IApmTrace;
import com.larus.applog.api.IApplog;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f16318a = 0;

    static {
    }

    public static void a(String r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        nu8.a.e("BootProtectorReporter", "reportEvent key:" + r100 + " params:" + r101);
        IApplog.f287053a.b(r100, r101);
        IApmTrace.Companion r102 = IApmTrace.f286937a;
    L14:
        th = th;
        JSONObject r103 = null;
    L16:
        FLogger.f375446a.e("BootProtectorReporter", "parse bundle params failed, " + th);
    L17:
        if (r103 != null) goto L19;
        r103 = new JSONObject();
    L19:
        r102.f(r100, r103, null, null);
        return;
    L4:
        if (r101.isEmpty() == true) goto L13;
        r103 = new JSONObject();     // Catch: Throwable -> L14
        Iterator<String> r104 = r101.keySet().iterator();     // Catch: Throwable -> L11
    L8:
        if (r104.hasNext() == false) goto L17;
        String r105 = r104.next();     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L11
        String r106 = r105;     // Catch: Throwable -> L11
        r103.put(r106, r101.get(r106));     // Catch: Throwable -> L11
    L11:
        th = th;
        goto L16
    L13:
        r103 = null;
        goto L17
    }
}
