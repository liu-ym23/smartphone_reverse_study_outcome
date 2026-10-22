package aq6;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService("connectivity");     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L9
        NetworkInfo r102 = ((ConnectivityManager) r101).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r102 == null) goto L12;
        if (r102.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }
}
