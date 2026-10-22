package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f21771b;

    public x(Object r10, Function1 r11) {
        this.f21770a = r10;
        this.f21771b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof x) == true) goto L8;
        return false;
    L8:
        x r11 = (x) r10;
        if (kotlin.jvm.internal.q.b(this.f21770a, r11.f21770a) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f21771b, r11.f21771b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Object r10 = this.f21770a;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return (r11 * 31) + this.f21771b.hashCode();
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f21770a + ", onCancellation=" + this.f21771b + ')';
    }
}
