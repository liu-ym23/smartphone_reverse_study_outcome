package L0;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile Handler f923a;

    static {
        new HashSet();
        f923a = new Handler(Looper.getMainLooper());
    }
}
