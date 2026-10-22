package sf;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static int a(Comparable r10, Comparable r11) {
        if (r10 != r11) goto L5;
        return 0;
    L5:
        if (r10 != null) goto L8;
        return -1;
    L8:
        if (r11 != null) goto L12;
        return 1;
    L12:
        return r10.compareTo(r11);
    }
}
