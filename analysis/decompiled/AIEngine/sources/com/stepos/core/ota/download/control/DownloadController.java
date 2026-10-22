package com.stepos.core.ota.download.control;

import androidx.compose.runtime.i;
import com.stepos.core.ability.e;
import com.stepos.core.ota.domain.TriggerSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import mb.m;
import mb.q;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DownloadController {
    private final DownloadArbiter arbiter;
    private final CopyOnWriteArrayList<DownloadStrategy> strategies;

    public DownloadController() {
        this(null, null, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean register$lambda$1(DownloadStrategy downloadStrategy, DownloadStrategy downloadStrategy2) {
        return g.b(downloadStrategy2.getId(), downloadStrategy.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean unregister$lambda$2(String str, DownloadStrategy downloadStrategy) {
        return g.b(downloadStrategy.getId(), str);
    }

    public final DownloadVerdict decide(DeviceConditions conditions, TriggerSource source) {
        g.f(conditions, "conditions");
        g.f(source, "source");
        CopyOnWriteArrayList<DownloadStrategy> copyOnWriteArrayList = this.strategies;
        ArrayList arrayList = new ArrayList(m.Z(copyOnWriteArrayList, 10));
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(((DownloadStrategy) it.next()).evaluate(conditions, source));
        }
        return this.arbiter.combine(arrayList, source);
    }

    public final void register(DownloadStrategy strategy) {
        g.f(strategy, "strategy");
        q.i0(this.strategies, new i(strategy, 8));
        this.strategies.add(strategy);
    }

    public final List<String> strategyIds() {
        CopyOnWriteArrayList<DownloadStrategy> copyOnWriteArrayList = this.strategies;
        ArrayList arrayList = new ArrayList(m.Z(copyOnWriteArrayList, 10));
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(((DownloadStrategy) it.next()).getId());
        }
        return arrayList;
    }

    public final void unregister(String id2) {
        g.f(id2, "id");
        q.i0(this.strategies, new e(id2, 3));
    }

    public DownloadController(List<? extends DownloadStrategy> initial, DownloadArbiter arbiter) {
        g.f(initial, "initial");
        g.f(arbiter, "arbiter");
        this.arbiter = arbiter;
        CopyOnWriteArrayList<DownloadStrategy> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.addAll(initial);
        this.strategies = copyOnWriteArrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DownloadController(List list, DownloadArbiter downloadArbiter, int i10, kotlin.jvm.internal.e eVar) {
        this((i10 & 1) != 0 ? EmptyList.f10001a : list, (i10 & 2) != 0 ? new DefaultArbiter(null, 1, 0 == true ? 1 : 0) : downloadArbiter);
    }
}
