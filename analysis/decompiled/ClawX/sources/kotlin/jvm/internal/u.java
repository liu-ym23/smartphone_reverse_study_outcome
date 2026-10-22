package kotlin.jvm.internal;

import a6.h0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class u extends e implements v5.h {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3682a;

    public u(Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, true);
        this.f3682a = false;
    }

    @Override // kotlin.jvm.internal.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final v5.h getReflected() {
        if (this.f3682a) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        v5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (v5.h) bVarCompute;
        }
        throw new h0("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    @Override // kotlin.jvm.internal.e
    public final v5.b compute() {
        return this.f3682a ? this : super.compute();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            return getOwner().equals(uVar.getOwner()) && getName().equals(uVar.getName()) && getSignature().equals(uVar.getSignature()) && p.a(getBoundReceiver(), uVar.getBoundReceiver());
        }
        if (obj instanceof v5.h) {
            return obj.equals(compute());
        }
        return false;
    }

    public final int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    public final String toString() {
        v5.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
