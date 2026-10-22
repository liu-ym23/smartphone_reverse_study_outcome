package d.o;

/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes4.dex */
class c extends b {
    public static final boolean a(char r2, char r3, boolean r4) {
        if (r2 != r3) goto L6;
        return true;
    L6:
        if (r4 == true) goto L8;
        return false;
    L8:
        char r5 = Character.toUpperCase(r2);
        char r6 = Character.toUpperCase(r3);
        if (r5 != r6) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r5) != Character.toLowerCase(r6)) goto L14;
        return true;
    L14:
        return false;
    }
}
