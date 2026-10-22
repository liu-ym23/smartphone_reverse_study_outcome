package androidx.work.impl.model;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f5635b;

    public c(String r10, Long r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        this.f5634a = r10;
        this.f5635b = r11;
    }

    public final String a() {
        return this.f5634a;
    }

    public final Long b() {
        return this.f5635b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (kotlin.jvm.internal.q.b(this.f5634a, r11.f5634a) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f5635b, r11.f5635b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r10 = this.f5634a.hashCode() * 31;
        Long r11 = this.f5635b;
        if (r11 != null) goto L5;
        int r12 = 0;
    L7:
        return r10 + r12;
    L5:
        r12 = r11.hashCode();
        goto L7
    }

    public String toString() {
        return "Preference(key=" + this.f5634a + ", value=" + this.f5635b + ')';
    }

    public c(String r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "key");
        if (r11 == false) goto L5;
        long r12 = 1;
    L6:
        this(r10, Long.valueOf(r12));
        return;
    L5:
        r12 = 0;
        goto L6
    }
}
