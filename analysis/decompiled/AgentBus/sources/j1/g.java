package j1;

/* loaded from: classes.dex */
public final class g extends c {

    /* renamed from: c, reason: collision with root package name */
    public static g f5165c;

    @Override // j1.c
    public final int[] c(int i2) {
        int length = e().length();
        if (length <= 0 || i2 >= length) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < length && e().charAt(i2) == '\n' && (e().charAt(i2) == '\n' || (i2 != 0 && e().charAt(i2 - 1) != '\n'))) {
            i2++;
        }
        if (i2 >= length) {
            return null;
        }
        int i10 = i2 + 1;
        while (i10 < length && !i(i10)) {
            i10++;
        }
        return d(i2, i10);
    }

    @Override // j1.c
    public final int[] h(int i2) {
        int length = e().length();
        if (length <= 0 || i2 <= 0) {
            return null;
        }
        if (i2 > length) {
            i2 = length;
        }
        while (i2 > 0 && e().charAt(i2 - 1) == '\n' && !i(i2)) {
            i2--;
        }
        if (i2 <= 0) {
            return null;
        }
        int i10 = i2 - 1;
        while (i10 > 0 && (e().charAt(i10) == '\n' || (i10 != 0 && e().charAt(i10 - 1) != '\n'))) {
            i10--;
        }
        return d(i10, i2);
    }

    public final boolean i(int i2) {
        if (i2 <= 0 || e().charAt(i2 - 1) == '\n') {
            return false;
        }
        return i2 == e().length() || e().charAt(i2) == '\n';
    }
}
