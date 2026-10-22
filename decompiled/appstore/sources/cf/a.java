package cf;

import android.app.Application;
import com.bytedance.common.push.ActivityLifecycleObserver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f6142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f6143b;

    public static void a(Application r10) {
        f6142a = r10;
        if (f6143b == false) goto L5;
        return;
    L5:
        f6143b = true;
        if (ef.a.c(r10) == true) goto L8;
        return;
    L8:
        f6142a.registerActivityLifecycleCallbacks(ActivityLifecycleObserver.e());
    }
}
