package androidx.constraintlayout.a.a;

/* JADX INFO: compiled from: CustomVariable.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f603e;
    private String f;

    public a a() {
        return new a(this);
    }

    public a(a r2) {
        this.f602d = Integer.MIN_VALUE;
        this.f603e = Float.NaN;
        this.f = null;
        this.f599a = r2.f599a;
        this.f601c = r2.f601c;
        this.f602d = r2.f602d;
        this.f603e = r2.f603e;
        this.f = r2.f;
        this.f600b = r2.f600b;
    }

    public static String a(int r2) {
        String r3 = "00000000" + Integer.toHexString(r2);
        return "#" + r3.substring(r3.length() - 8);
    }

    public String toString() {
        String r0 = this.f599a + ':';
        switch(this.f601c) {
            case 900: goto L17;
            case 901: goto L15;
            case 902: goto L13;
            case 903: goto L11;
            case 904: goto L9;
            case 905: goto L7;
            default: goto L5;
        };
    L5:
        return r0 + "????";
    L7:
        return r0 + this.f603e;
    L9:
        return r0 + Boolean.valueOf(this.f600b);
    L11:
        return r0 + this.f;
    L13:
        return r0 + a(this.f602d);
    L15:
        return r0 + this.f603e;
    L17:
        return r0 + this.f602d;
    }

    public int getType() {
        return this.f601c;
    }

    public String b() {
        return this.f599a;
    }
}
