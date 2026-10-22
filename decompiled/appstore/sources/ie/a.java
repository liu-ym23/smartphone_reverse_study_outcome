package ie;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20581a = null;

    static {
        f20581a = new a();
    }

    public a() {
    }

    public static final boolean a(Integer r10) {
        if (r10 != null) goto L6;
    L8:
        if (r10 != null) goto L11;
    L13:
        if (r10 != null) goto L16;
    L18:
        if (r10 != null) goto L21;
    L23:
        if (r10 != null) goto L26;
    L28:
        if (r10 != null) goto L31;
    L33:
        return false;
    L31:
        if (r10.intValue() != 3000) goto L33;
        return true;
    L26:
        if (r10.intValue() != 4000) goto L28;
        return true;
    L21:
        if (r10.intValue() != 1002) goto L23;
        return true;
    L16:
        if (r10.intValue() != 1082) goto L18;
        return true;
    L11:
        if (r10.intValue() != 1011) goto L13;
        return true;
    L6:
        if (r10.intValue() != 1004) goto L8;
        return true;
    }

    public static final boolean b(int r10) {
        if (r10 != 1006) goto L5;
        return true;
    L5:
        return false;
    }
}
