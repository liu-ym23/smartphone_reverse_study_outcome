package D0;

/* loaded from: classes.dex */
public final class h implements a<int[]> {
    @Override // D0.a
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // D0.a
    public int b() {
        return 4;
    }

    @Override // D0.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(int[] iArr) {
        return iArr.length;
    }

    @Override // D0.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i5) {
        return new int[i5];
    }
}
