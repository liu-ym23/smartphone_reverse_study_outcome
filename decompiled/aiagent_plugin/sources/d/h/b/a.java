package d.h.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: AdaptedFunctionReference.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements j, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Object f38477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f38478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f38479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f38480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f38481e;
    private final int f;
    private final int g;

    public a(int r1, Object r2, Class r3, String r4, String r5, int r6) {
        this.f38477a = r2;
        this.f38478b = r3;
        this.f38479c = r4;
        this.f38480d = r5;
        if ((r6 & 1) != 1) goto L5;
        boolean r7 = true;
    L6:
        this.f38481e = r7;
        this.f = r1;
        this.g = r6 >> 1;
        return;
    L5:
        r7 = false;
        goto L6
    }

    @Override // d.h.b.j
    public int getArity() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (this.f38481e != r6.f38481e) goto L24;
        if (this.f != r6.f) goto L24;
        if (this.g != r6.g) goto L24;
        if (o.a(this.f38477a, r6.f38477a) == false) goto L24;
        if (o.a(this.f38478b, r6.f38478b) == false) goto L24;
        if (this.f38479c.equals(r6.f38479c) == false) goto L24;
        if (this.f38480d.equals(r6.f38480d) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        Object r0 = this.f38477a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Class r4 = this.f38478b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (((((r3 + r1) * 31) + this.f38479c.hashCode()) * 31) + this.f38480d.hashCode()) * 31;
        if (this.f38481e == false) goto L12;
        int r6 = 1231;
    L14:
        return ((((r5 + r6) * 31) + this.f) * 31) + this.g;
    L12:
        r6 = 1237;
        goto L14
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return aa.a(this);
    }
}
