package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f38831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.h.a.b<Throwable, d.x> f38832b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f38831a, r6.f38831a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38832b, r6.f38832b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Object r0 = this.f38831a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.f38832b.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f38831a + ", onCancellation=" + this.f38832b + ')';
    }

    public ac(Object r3, d.h.a.b<? super Throwable, d.x> r4) {
        d.h.a.b<Throwable, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        this.f38831a = r3;
        this.f38832b = r5;
    }
}
