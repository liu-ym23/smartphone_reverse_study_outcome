package za;

import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f7020a;

    public j(String treeId) {
        k.f(treeId, "treeId");
        this.f7020a = treeId;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j) && k.b(this.f7020a, ((j) obj).f7020a);
    }

    public final int hashCode() {
        return this.f7020a.hashCode() * 887503681;
    }

    public final String toString() {
        return B7.a.m("TaskTreeContext(treeId=", this.f7020a, ", totalNodes=null, nodeIndex=null, nodeLabel=null, slotMap=null, pathNodeMetadata=null, extra=null)");
    }
}
