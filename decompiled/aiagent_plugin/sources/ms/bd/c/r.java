package ms.bd.c;

import android.content.Context;
import android.util.DisplayMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f39593a;

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L7;
        new DisplayMetrics();     // Catch: Throwable -> L8
        f39593a = ZeusTransformUtils.getResources(r3, "com.obric.aiagent.plugin").getDisplayMetrics().densityDpi;     // Catch: Throwable -> L8
    L7:
        return "" + f39593a;
    }
}
