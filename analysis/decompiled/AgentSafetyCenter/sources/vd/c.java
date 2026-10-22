package vd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum c {
    V1_0(new Integer[]{1, 0}),
    V1_1(new Integer[]{1, 1});


    /* renamed from: c, reason: collision with root package name */
    public final Integer[] f14909c;

    c(Integer[] numArr) {
        this.f14909c = numArr;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        Integer[] numArr = this.f14909c;
        sb2.append(numArr[0]);
        sb2.append(".");
        sb2.append(numArr[1]);
        return "Version: ".concat(sb2.toString());
    }
}
