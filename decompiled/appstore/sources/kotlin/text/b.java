package kotlin.text;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends a {
    public static final boolean d(char r10, char r11, boolean r12) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r12 == true) goto L8;
        return false;
    L8:
        char r13 = Character.toUpperCase(r10);
        char r14 = Character.toUpperCase(r11);
        if (r13 != r14) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r13) != Character.toLowerCase(r14)) goto L14;
        return true;
    L14:
        return false;
    }
}
