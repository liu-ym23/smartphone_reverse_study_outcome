package bytekn.foundation.encryption;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f21780a = null;

    static {
        int[] r100 = new int[Padding.values().length];
        Padding r101 = Padding.NoPadding;
        r100[r101.ordinal()] = 1;
        Padding r102 = Padding.PKCS7Padding;
        r100[r102.ordinal()] = 2;
        Padding r103 = Padding.ANSIX923Padding;
        r100[r103.ordinal()] = 3;
        Padding r104 = Padding.ISO10126Padding;
        r100[r104.ordinal()] = 4;
        Padding r105 = Padding.ZeroPadding;
        r100[r105.ordinal()] = 5;
        int[] r106 = new int[Padding.values().length];
        f21780a = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
    }
}
