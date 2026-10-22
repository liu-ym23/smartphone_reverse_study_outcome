package com.mdisdk.observer;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.observer.ObserverFilter;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001!B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00028\u0001\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JB\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u00002\b\b\u0002\u0010\b\u001a\u00028\u00012\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/mdisdk/observer/ObserverRegistration;", "L", "F", "Lcom/mdisdk/observer/ObserverFilter;", "", "id", "", "listener", "filter", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Object;Lcom/mdisdk/observer/ObserverFilter;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getListener", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getFilter", "()Lcom/mdisdk/observer/ObserverFilter;", "Lcom/mdisdk/observer/ObserverFilter;", "getTaskName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lcom/mdisdk/observer/ObserverFilter;Ljava/lang/String;)Lcom/mdisdk/observer/ObserverRegistration;", "equals", "", "other", "hashCode", "", "toString", "Companion", "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ObserverRegistration<L, F extends ObserverFilter> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static long idCounter;
    private final F filter;
    private final String id;
    private final L listener;
    private final String taskName;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/mdisdk/observer/ObserverRegistration$Companion;", "", AppAgent.CONSTRUCT, "()V", "idCounter", "", "generateId", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "mdisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final synchronized String generateId(String taskName) {
            StringBuilder sb;
            k.f(taskName, "taskName");
            sb = new StringBuilder();
            sb.append(taskName);
            sb.append("_observer_");
            ObserverRegistration.idCounter++;
            sb.append(ObserverRegistration.idCounter);
            return sb.toString();
        }

        private Companion() {
        }
    }

    public ObserverRegistration(String id, L l, F filter, String taskName) {
        k.f(id, "id");
        k.f(filter, "filter");
        k.f(taskName, "taskName");
        this.id = id;
        this.listener = l;
        this.filter = filter;
        this.taskName = taskName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObserverRegistration copy$default(ObserverRegistration observerRegistration, String str, Object obj, ObserverFilter observerFilter, String str2, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = observerRegistration.id;
        }
        if ((i & 2) != 0) {
            obj = observerRegistration.listener;
        }
        if ((i & 4) != 0) {
            observerFilter = observerRegistration.filter;
        }
        if ((i & 8) != 0) {
            str2 = observerRegistration.taskName;
        }
        return observerRegistration.copy(str, obj, observerFilter, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final L component2() {
        return this.listener;
    }

    public final F component3() {
        return this.filter;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    public final ObserverRegistration<L, F> copy(String id, L listener, F filter, String taskName) {
        k.f(id, "id");
        k.f(filter, "filter");
        k.f(taskName, "taskName");
        return new ObserverRegistration<>(id, listener, filter, taskName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ObserverRegistration)) {
            return false;
        }
        ObserverRegistration observerRegistration = (ObserverRegistration) other;
        return k.b(this.id, observerRegistration.id) && k.b(this.listener, observerRegistration.listener) && k.b(this.filter, observerRegistration.filter) && k.b(this.taskName, observerRegistration.taskName);
    }

    public final F getFilter() {
        return this.filter;
    }

    public final String getId() {
        return this.id;
    }

    public final L getListener() {
        return this.listener;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public int hashCode() {
        int iHashCode = this.id.hashCode() * 31;
        L l = this.listener;
        return this.taskName.hashCode() + ((this.filter.hashCode() + ((iHashCode + (l == null ? 0 : l.hashCode())) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ObserverRegistration(id=");
        sb.append(this.id);
        sb.append(", listener=");
        sb.append(this.listener);
        sb.append(", filter=");
        sb.append(this.filter);
        sb.append(", taskName=");
        return a.g(')', this.taskName, sb);
    }
}
