package d7;

import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class o extends f implements RandomAccess {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int[] f2972f;

    public o(int[] iArr) {
        this.f2972f = iArr;
    }

    @Override // d7.a
    public final int a() {
        return this.f2972f.length;
    }

    @Override // d7.a, java.util.Collection
    public final boolean contains(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.f2972f;
        q7.k.e(iArr, "<this>");
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (iIntValue == iArr[i2]) {
                break;
            }
            i2++;
        }
        return i2 >= 0;
    }

    @Override // java.util.List
    public final Object get(int i2) {
        return Integer.valueOf(this.f2972f[i2]);
    }

    @Override // d7.f, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.f2972f;
        q7.k.e(iArr, "<this>");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iIntValue == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    @Override // d7.a, java.util.Collection
    public final boolean isEmpty() {
        return this.f2972f.length == 0;
    }

    @Override // d7.f, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Number) obj).intValue();
        int[] iArr = this.f2972f;
        q7.k.e(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (iIntValue == iArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }
}
