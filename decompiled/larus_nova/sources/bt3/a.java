package bt3;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Handler f20529a;

    static {
        new HashSet();
        f20529a = new Handler(Looper.getMainLooper());
    }
}
