package kotlin.text;

import com.bytedance.apm.constant.CommonKey;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f21268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bg.c f21269b;

    public e(String r10, bg.c r11) {
        kotlin.jvm.internal.q.g(r10, CommonKey.KEY_VALUE);
        kotlin.jvm.internal.q.g(r11, "range");
        this.f21268a = r10;
        this.f21269b = r11;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L8;
        return false;
    L8:
        e r11 = (e) r10;
        if (kotlin.jvm.internal.q.b(this.f21268a, r11.f21268a) == true) goto L12;
        return false;
    L12:
        if (kotlin.jvm.internal.q.b(this.f21269b, r11.f21269b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21268a.hashCode() * 31) + this.f21269b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f21268a + ", range=" + this.f21269b + ')';
    }
}
