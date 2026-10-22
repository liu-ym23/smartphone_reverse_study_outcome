package ms.bd.c;

import android.content.Context;
import android.webkit.WebSettings;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f39469a;

    public static synchronized String a(Context r3) {
        monitor-enter(c2.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        String r1 = f39469a;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(c2.class);
        return r1;
    L8:
        String r5 = WebSettings.getDefaultUserAgent(r4);     // Catch: Throwable -> L11
        f39469a = r5;     // Catch: Throwable -> L11
        monitor-exit(c2.class);
        return r5;
    L11:
        th = move-exception;
        throw th;
    }
}
