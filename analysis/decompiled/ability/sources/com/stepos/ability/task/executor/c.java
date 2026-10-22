package com.stepos.ability.task.executor;

import com.stepos.ability.common.TaskStatus;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final TaskStatus f3311a;
    public final boolean b;
    public final Boolean c;
    public final boolean d;

    public c(TaskStatus taskStatus, boolean z10, Boolean bool, boolean z11) {
        this.f3311a = taskStatus;
        this.b = z10;
        this.c = bool;
        this.d = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f3311a == cVar.f3311a && this.b == cVar.b && k.b(this.c, cVar.c) && this.d == cVar.d;
    }

    public final int hashCode() {
        int iD = androidx.appfunctions.metadata.a.d(this.f3311a.hashCode() * 31, 31, this.b);
        Boolean bool = this.c;
        return Boolean.hashCode(this.d) + ((iD + (bool == null ? 0 : bool.hashCode())) * 31);
    }

    public final String toString() {
        return "ActionConfig(status=" + this.f3311a + ", completed=" + this.b + ", success=" + this.c + ", terminal=" + this.d + ")";
    }
}
