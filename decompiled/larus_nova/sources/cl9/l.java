package cl9;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, List<Runnable>> f24145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, List<Runnable>> f24146b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ScheduledExecutorService f24147c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f24148d = null;

    static {
        f24145a = new HashMap();
        f24146b = new HashMap();
        f24147c = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new h());
        f24148d = PThreadExecutorsUtils.newSingleThreadScheduledExecutor(new i());
    }
}
