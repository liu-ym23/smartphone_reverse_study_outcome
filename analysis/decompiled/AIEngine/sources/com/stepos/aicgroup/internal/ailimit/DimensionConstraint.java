package com.stepos.aicgroup.internal.ailimit;

import com.stepos.aicgroup.AiDispatchers;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DimensionConstraint {
    public static final Companion Companion = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final DimensionConstraint f5729c = new DimensionConstraint(EmptySet.f10003a, StopAction.PAUSE);

    /* renamed from: a, reason: collision with root package name */
    public final Set<AiDispatchers.DispatcherPriority> f5730a;

    /* renamed from: b, reason: collision with root package name */
    public final StopAction f5731b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final DimensionConstraint getNONE() {
            return DimensionConstraint.f5729c;
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DimensionConstraint(Set<? extends AiDispatchers.DispatcherPriority> priorities, StopAction action) {
        g.f(priorities, "priorities");
        g.f(action, "action");
        this.f5730a = priorities;
        this.f5731b = action;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DimensionConstraint copy$default(DimensionConstraint dimensionConstraint, Set set, StopAction stopAction, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            set = dimensionConstraint.f5730a;
        }
        if ((i10 & 2) != 0) {
            stopAction = dimensionConstraint.f5731b;
        }
        return dimensionConstraint.copy(set, stopAction);
    }

    public final Set<AiDispatchers.DispatcherPriority> component1() {
        return this.f5730a;
    }

    public final StopAction component2() {
        return this.f5731b;
    }

    public final DimensionConstraint copy(Set<? extends AiDispatchers.DispatcherPriority> priorities, StopAction action) {
        g.f(priorities, "priorities");
        g.f(action, "action");
        return new DimensionConstraint(priorities, action);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DimensionConstraint)) {
            return false;
        }
        DimensionConstraint dimensionConstraint = (DimensionConstraint) obj;
        return g.b(this.f5730a, dimensionConstraint.f5730a) && this.f5731b == dimensionConstraint.f5731b;
    }

    public final StopAction getAction() {
        return this.f5731b;
    }

    public final Set<AiDispatchers.DispatcherPriority> getPriorities() {
        return this.f5730a;
    }

    public int hashCode() {
        return this.f5731b.hashCode() + (this.f5730a.hashCode() * 31);
    }

    public String toString() {
        return "DimensionConstraint(priorities=" + this.f5730a + ", action=" + this.f5731b + ")";
    }
}
