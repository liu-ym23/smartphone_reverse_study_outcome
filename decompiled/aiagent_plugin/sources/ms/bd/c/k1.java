package ms.bd.c;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f39538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f39539b;

    public static String a(Context r3) {
        Display r4 = ((WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin")).getDefaultDisplay();     // Catch: Throwable -> L15
        Point r0 = new Point();     // Catch: Throwable -> L15
        int r1 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r1 < 17) goto L8;
        r4.getRealSize(r0);     // Catch: Throwable -> L15
    L6:
        f39538a = r0.x;     // Catch: Throwable -> L15
        int r5 = r0.y;     // Catch: Throwable -> L15
    L12:
        f39539b = r5;     // Catch: Throwable -> L15
        goto L14
    L8:
        if (r1 < 13) goto L11;
        r4.getSize(r0);     // Catch: Throwable -> L15
        goto L6
    L11:
        f39538a = r4.getWidth();     // Catch: Throwable -> L15
        r5 = r4.getHeight();     // Catch: Throwable -> L15
    L14:
        return f39538a + "*" + f39539b;
    }
}
