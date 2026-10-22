package com.a.c.b.c.a;

import com.a.c.b.c.c;
import com.a.c.b.c.d;
import com.a.c.b.c.e;
import com.a.c.b.c.f;
import com.a.c.b.c.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: compiled from: ValidationFieldExpressionVisitor.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.a.c.b.a.a f3119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.a.b f3120b;

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(com.a.c.b.c.a r1) {
        return b(r1);
    }

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(com.a.c.b.c.b r1) {
        return b(r1);
    }

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(c r1) {
        return b(r1);
    }

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(d r1) {
        return b(r1);
    }

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(f r1) {
        return b(r1);
    }

    @Override // com.a.c.b.c.a.a
    public /* synthetic */ e a(g r1) {
        return b(r1);
    }

    public b(com.a.c.b.a.a r2) {
        this.f3119a = r2;
        this.f3120b = new com.a.b(r2);
    }

    private void a(e r4) {
        String r3 = this.f3120b.a(r4.a());
        if (r3.isEmpty() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("Invalid chars in expression! Expression: %s Invalid chars: %s", new Object[]{r4.a(), r3}));
    }

    public com.a.c.b.c.a b(com.a.c.b.c.a r1) {
        a(r1);
        return r1;
    }

    public com.a.c.b.c.b b(com.a.c.b.c.b r5) {
        a(r5);
        Iterator<e> r0 = r5.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin")).a(this);
        goto L4
    L6:
        return r5;
    }

    public c b(c r4) {
        a(r4);
        c(r4);
        if (this.f3119a.e() == true) goto L5;
    L13:
        return r4;
    L5:
        if (ZeusTransformUtils.instanceOf(r4.b(), com.a.c.b.d.b.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r4.c(), com.a.c.b.d.b.class) == false) goto L13;
        int r3 = ((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r4.b(), com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue();
        int r0 = ((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r4.c(), com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue();
        if (r3 <= r0) goto L13;
        throw new IllegalArgumentException(String.format("Invalid range! [%s,%s]", new Object[]{Integer.valueOf(r3), Integer.valueOf(r0)}));
    }

    public d b(d r2) {
        a(r2);
        if (r2.c() == null) goto L5;
        r2.c().a(this);
    L5:
        b(r2.b());
        return r2;
    }

    public f b(f r2) {
        a(r2);
        if (c(r2.b()) == true) goto L6;
        a(r2.b());
    L6:
        if (c(r2.c()) == true) goto L8;
        a(r2.c());
    L8:
        return r2;
    }

    public g b(g r1) {
        a(r1);
        return r1;
    }

    private void c(c r2) {
        a(r2.b());
        a(r2.c());
        if (d(r2.b()) == true) goto L8;
        if (d(r2.c()) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("No special characters allowed in range, except for 'L'");
    }

    public void a(com.a.c.b.d.a<?> r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.a.c.b.d.b.class) == false) goto L9;
        int r5 = ((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r4, com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue();
        if (this.f3119a.a(r5) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Value %s not in range [%s, %s]", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f3119a.a()), Integer.valueOf(this.f3119a.b())}));
    }

    public void b(com.a.c.b.d.a<?> r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.a.c.b.d.b.class) == false) goto L9;
        int r5 = ((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r4, com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue();
        if (this.f3119a.b(r5) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(String.format("Period %s not in range [%s, %s]", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f3119a.a()), Integer.valueOf(this.f3119a.b())}));
    }

    public boolean c(com.a.c.b.d.a<?> r2) {
        if (ZeusTransformUtils.instanceOf(r2, com.a.c.b.d.b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (((com.a.c.b.d.b) ZeusTransformUtils.preCheckCast(r2, com.a.c.b.d.b.class, "com.obric.aiagent.plugin")).b().intValue() != (-1)) goto L7;
        return true;
    }

    public boolean d(com.a.c.b.d.a<?> r1) {
        if (ZeusTransformUtils.instanceOf(r1, com.a.c.b.d.d.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.a.c.b.d.c.f3133b.equals(r1.a()) == true) goto L7;
        return true;
    }
}
