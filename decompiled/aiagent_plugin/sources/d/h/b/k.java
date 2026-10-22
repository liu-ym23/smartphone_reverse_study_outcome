package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes4.dex */
public class k extends d implements j, d.m.e {
    private final int arity;
    private final int flags;

    @Override // d.h.b.d
    public /* bridge */ /* synthetic */ d.m.b getReflected() {
        return getReflected();
    }

    public k(int r8) {
        this(r8, NO_RECEIVER, null, null, null, 0);
    }

    public k(int r8, Object r9) {
        this(r8, r9, null, null, null, 0);
    }

    public k(int r9, Object r10, Class r11, String r12, String r13, int r14) {
        if ((r14 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        super(r10, r11, r12, r13, r7);
        this.arity = r9;
        this.flags = r14 >> 1;
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // d.h.b.j
    public int getArity() {
        return this.arity;
    }

    @Override // d.h.b.d
    public d.m.e getReflected() {
        return (d.m.e) ZeusTransformUtils.preCheckCast(super.getReflected(), d.m.e.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.b.d
    public d.m.b computeReflected() {
        return aa.a(this);
    }

    @Override // d.m.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // d.m.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // d.m.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // d.m.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // d.h.b.d, d.m.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L23;
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (getName().equals(r6.getName()) == false) goto L21;
        if (getSignature().equals(r6.getSignature()) == false) goto L21;
        if (this.flags != r6.flags) goto L21;
        if (this.arity != r6.arity) goto L21;
        if (o.a(getBoundReceiver(), r6.getBoundReceiver()) == false) goto L21;
        if (o.a(getOwner(), r6.getOwner()) == false) goto L21;
        return true;
    L21:
        return false;
    L23:
        if (ZeusTransformUtils.instanceOf(r5, d.m.e.class) == true) goto L25;
        return false;
    L25:
        return r5.equals(compute());
    }

    public int hashCode() {
        if (getOwner() != null) goto L5;
        int r0 = 0;
    L7:
        return ((r0 + getName().hashCode()) * 31) + getSignature().hashCode();
    L5:
        r0 = getOwner().hashCode() * 31;
        goto L7
    }

    public String toString() {
        d.m.b r0 = compute();
        if (r0 == this) goto L7;
        return r0.toString();
    L7:
        if ("<init>".equals(getName()) == false) goto L10;
        return "constructor (Kotlin reflection is not available)";
    L10:
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
