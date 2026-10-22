package j6;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f6611a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f6612b = new HashMap();

    static {
        new ConcurrentHashMap();
        Runtime.getRuntime().availableProcessors();
        new Timer();
    }
}
