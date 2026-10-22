package g5;

import android.content.Context;
import androidx.work.WorkerParameters;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4338a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkerParameters f4339b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicInteger f4340c = new AtomicInteger(-256);

    /* renamed from: d, reason: collision with root package name */
    public boolean f4341d;

    public t(Context context, WorkerParameters workerParameters) {
        this.f4338a = context;
        this.f4339b = workerParameters;
    }

    public abstract t2.m a();
}
