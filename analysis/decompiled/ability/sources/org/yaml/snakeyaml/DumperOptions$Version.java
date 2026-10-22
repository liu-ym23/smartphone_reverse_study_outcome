package org.yaml.snakeyaml;

/* loaded from: classes4.dex */
public enum DumperOptions$Version {
    V1_0(new Integer[]{1, 0}),
    V1_1(new Integer[]{1, 1});


    /* renamed from: a, reason: collision with root package name */
    public final Integer[] f5521a;

    DumperOptions$Version(Integer[] numArr) {
        this.f5521a = numArr;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("Version: ");
        StringBuilder sb2 = new StringBuilder();
        Integer[] numArr = this.f5521a;
        sb2.append(numArr[0]);
        sb2.append(".");
        sb2.append(numArr[1]);
        sb.append(sb2.toString());
        return sb.toString();
    }
}
