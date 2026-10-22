package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: compiled from: InvalidationLiveDataContainer.java */
/* JADX INFO: loaded from: classes.dex */
class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set<LiveData> f2628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p f2629b;

    g(p r2) {
        this.f2628a = Collections.newSetFromMap(new IdentityHashMap());
        this.f2629b = r2;
    }
}
