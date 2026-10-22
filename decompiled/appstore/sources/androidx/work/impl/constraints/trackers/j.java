package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5548a = null;

    static {
        String r10 = androidx.work.i.i("NetworkStateTracker");
        q.f(r10, "tagWithPrefix(\"NetworkStateTracker\")");
        f5548a = r10;
    }

    public static final g a(Context r10, TaskExecutor r11) {
        q.g(r10, "context");
        q.g(r11, "taskExecutor");
        return new i(r10, r11);
    }

    public static final /* synthetic */ String b() {
        return f5548a;
    }

    public static final androidx.work.impl.constraints.a c(ConnectivityManager r10) {
        q.g(r10, "<this>");
        NetworkInfo r11 = r10.getActiveNetworkInfo();
        boolean r12 = false;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        boolean r14 = d(r10);
        boolean r15 = ConnectivityManagerCompat.a(r10);
        if (r11 == null) goto L14;
        if (r11.isRoaming() == true) goto L14;
        r12 = true;
    L14:
        return new androidx.work.impl.constraints.a(r13, r14, r15, r12);
    L5:
        if (r11.isConnected() == false) goto L7;
        r13 = true;
        goto L8
    }

    public static final boolean d(ConnectivityManager r10) {
        q.g(r10, "<this>");
        NetworkCapabilities r11 = androidx.work.impl.utils.i.a(r10, androidx.work.impl.utils.j.a(r10));     // Catch: SecurityException -> L7
        if (r11 == null) goto L12;
        return androidx.work.impl.utils.i.b(r11, 16);
    L12:
        return false;
    L7:
        e = move-exception;
        androidx.work.i.e().d(f5548a, "Unable to validate active network", e);
        return false;
    }
}
