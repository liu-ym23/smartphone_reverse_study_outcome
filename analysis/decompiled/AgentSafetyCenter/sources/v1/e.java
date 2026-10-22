package v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends h.b0 {

    /* renamed from: c, reason: collision with root package name */
    public static e f14406c;

    @Override // h.b0
    public final int[] e(int i) {
        int length = i().length();
        if (length <= 0 || i >= length) {
            return null;
        }
        if (i < 0) {
            i = 0;
        }
        while (i < length && i().charAt(i) == '\n' && (i().charAt(i) == '\n' || (i != 0 && i().charAt(i - 1) != '\n'))) {
            i++;
        }
        if (i >= length) {
            return null;
        }
        int i3 = i + 1;
        while (i3 < length && !m(i3)) {
            i3++;
        }
        return h(i, i3);
    }

    @Override // h.b0
    public final int[] k(int i) {
        int length = i().length();
        if (length <= 0 || i <= 0) {
            return null;
        }
        if (i > length) {
            i = length;
        }
        while (i > 0 && i().charAt(i - 1) == '\n' && !m(i)) {
            i--;
        }
        if (i <= 0) {
            return null;
        }
        int i3 = i - 1;
        while (i3 > 0 && (i().charAt(i3) == '\n' || (i3 != 0 && i().charAt(i3 - 1) != '\n'))) {
            i3--;
        }
        return h(i3, i);
    }

    public final boolean m(int i) {
        if (i <= 0 || i().charAt(i - 1) == '\n') {
            return false;
        }
        return i == i().length() || i().charAt(i) == '\n';
    }
}
