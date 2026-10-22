package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: IndexedValue.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ai<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f38348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f38349b;

    public final int c() {
        return this.f38348a;
    }

    public final T d() {
        return this.f38349b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ai.class) == true) goto L8;
        return false;
    L8:
        ai r6 = (ai) ZeusTransformUtils.preCheckCast(r5, ai.class, "com.obric.aiagent.plugin");
        if (this.f38348a == r6.f38348a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f38349b, r6.f38349b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.f38348a) * 31;
        T r1 = this.f38349b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "IndexedValue(index=" + this.f38348a + ", value=" + this.f38349b + ')';
    }

    public ai(int r1, T r2) {
        this.f38348a = r1;
        this.f38349b = r2;
    }

    public final int a() {
        return this.f38348a;
    }

    public final T b() {
        return this.f38349b;
    }
}
