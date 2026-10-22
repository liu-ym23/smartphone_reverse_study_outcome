package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class cn extends kotlinx.coroutines.internal.v implements bu {
    @Override // kotlinx.coroutines.bu
    public boolean n_() {
        return true;
    }

    @Override // kotlinx.coroutines.bu
    public cn o_() {
        return this;
    }

    public cn() {
    }

    public final String a(String r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append("List{");
        r0.append(r6);
        r0.append("}[");
        kotlinx.coroutines.internal.v r5 = (kotlinx.coroutines.internal.v) ZeusTransformUtils.preCheckCast(this, kotlinx.coroutines.internal.v.class, "com.obric.aiagent.plugin");
        Object r7 = r5.f();
        d.h.b.o.a(r7, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        kotlinx.coroutines.internal.x r8 = (kotlinx.coroutines.internal.x) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.internal.x.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
    L4:
        if (d.h.b.o.a(r8, r5) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, ch.class) == false) goto L12;
        ch r3 = (ch) ZeusTransformUtils.preCheckCast(r8, ch.class, "com.obric.aiagent.plugin");
        if (r2 == false) goto L10;
        r2 = false;
    L11:
        r0.append(r3);
        goto L12
    L10:
        r0.append(", ");
    L12:
        r8 = r8.g();
        goto L4
    L13:
        r0.append("]");
        String r9 = r0.toString();
        d.h.b.o.c(r9, "toString(...)");
        return r9;
    }

    @Override // kotlinx.coroutines.internal.x
    public String toString() {
        if (aq.b() == false) goto L6;
        return a("Active");
    L6:
        return super.toString();
    }
}
