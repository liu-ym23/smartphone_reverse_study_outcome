package androidx.startup;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: StartupLogger.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    private static final String TAG = "StartupLogger";

    public static void a(String r1) {
        a(TAG, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
