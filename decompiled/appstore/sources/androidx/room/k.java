package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f4576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f4577b;

    public k(RoomDatabase r10) {
        kotlin.jvm.internal.q.g(r10, "database");
        this.f4576a = r10;
        Set r11 = Collections.newSetFromMap(new IdentityHashMap());
        kotlin.jvm.internal.q.f(r11, "newSetFromMap(IdentityHashMap())");
        this.f4577b = r11;
    }

    public final LiveData a(String[] r10, boolean r11, Callable r12) {
        kotlin.jvm.internal.q.g(r10, "tableNames");
        kotlin.jvm.internal.q.g(r12, "computeFunction");
        return new t0(this.f4576a, this, r11, r12, r10);
    }

    public final void b(LiveData r10) {
        kotlin.jvm.internal.q.g(r10, "liveData");
        this.f4577b.add(r10);
    }

    public final void c(LiveData r10) {
        kotlin.jvm.internal.q.g(r10, "liveData");
        this.f4577b.remove(r10);
    }
}
