package androidx.work;

import D0.j;
import D1.a;
import android.content.Context;
import androidx.annotation.NonNull;
import h.RunnableC0583a;
import s0.q;
import s0.s;

/* loaded from: classes.dex */
public abstract class Worker extends s {

    /* renamed from: a, reason: collision with root package name */
    public j f4311a;

    public Worker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract q a();

    @Override // s0.s
    public final a startWork() {
        this.f4311a = new j();
        getBackgroundExecutor().execute(new RunnableC0583a(8, this));
        return this.f4311a;
    }
}
