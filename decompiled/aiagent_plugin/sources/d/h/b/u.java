package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u extends d implements d.m.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f38498a;

    @Override // d.h.b.d
    public /* synthetic */ d.m.b getReflected() {
        return b();
    }

    public u() {
        this.f38498a = false;
    }

    public u(Object r10, Class r11, String r12, String r13, int r14) {
        boolean r1 = false;
        if ((r14 & 1) != 1) goto L5;
        boolean r8 = true;
    L6:
        super(r10, r11, r12, r13, r8);
        if ((r14 & 2) != 2) goto L9;
        r1 = true;
    L9:
        this.f38498a = r1;
        return;
    L5:
        r8 = false;
        goto L6
    }

    public d.m.h b() {
        if (this.f38498a == true) goto L7;
        return (d.m.h) ZeusTransformUtils.preCheckCast(super.getReflected(), d.m.h.class, "com.obric.aiagent.plugin");
    L7:
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }

    @Override // d.h.b.d
    public d.m.b compute() {
        if (this.f38498a == false) goto L6;
        return this;
    L6:
        return super.compute();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, u.class) == false) goto L19;
        u r6 = (u) ZeusTransformUtils.preCheckCast(r5, u.class, "com.obric.aiagent.plugin");
        if (getOwner().equals(r6.getOwner()) == false) goto L17;
        if (getName().equals(r6.getName()) == false) goto L17;
        if (getSignature().equals(r6.getSignature()) == false) goto L17;
        if (o.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L17;
        return true;
    L17:
        return false;
    L19:
        if (ZeusTransformUtils.instanceOf(r5, d.m.h.class) == true) goto L21;
        return false;
    L21:
        return r5.equals(compute());
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        d.m.b r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
