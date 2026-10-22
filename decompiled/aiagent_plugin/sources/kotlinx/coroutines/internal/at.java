package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.cy;

/* JADX INFO: compiled from: ThreadContext.kt */
/* JADX INFO: loaded from: classes4.dex */
final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.c.g f39380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f39381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final cy<Object>[] f39382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f39383d;

    public at(d.c.g r3, int r4) {
        this.f39380a = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        this.f39381b = new Object[r4];
        this.f39382c = new cy[r4];
    }

    public final void a(cy<?> r3, Object r4) {
        cy<Object> r5 = (cy) ZeusTransformUtils.wrapperContextForParams(r3, cy.class, "com.obric.aiagent.plugin");
        Object[] r0 = this.f39381b;
        int r1 = this.f39383d;
        r0[r1] = r4;
        cy<Object>[] r6 = this.f39382c;
        this.f39383d = r1 + 1;
        d.h.b.o.a(r5, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        r6[r1] = r5;
    }

    public final void a(d.c.g r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        int r0 = this.f39382c.length - 1;
        if (r0 < 0) goto L8;
    L4:
        int r1 = r0 - 1;
        cy<Object> r2 = this.f39382c[r0];
        d.h.b.o.a(r2);
        r2.a(r6, this.f39381b[r0]);
        if (r1 < 0) goto L10;
        r0 = r1;
        goto L4
    L10:
        return;
    }
}
