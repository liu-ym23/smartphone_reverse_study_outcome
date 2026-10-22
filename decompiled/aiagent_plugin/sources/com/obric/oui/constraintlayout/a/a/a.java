package com.obric.oui.constraintlayout.a.a;

/* JADX INFO: compiled from: CustomVariable.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static final String TAG = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f34576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f34577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f34580e;
    private String f;

    public a a() {
        return new a(this);
    }

    public a(a r2) {
        this.f34579d = Integer.MIN_VALUE;
        this.f34580e = Float.NaN;
        this.f = null;
        this.f34576a = r2.f34576a;
        this.f34578c = r2.f34578c;
        this.f34579d = r2.f34579d;
        this.f34580e = r2.f34580e;
        this.f = r2.f;
        this.f34577b = r2.f34577b;
    }

    public static String a(int r2) {
        String r3 = "00000000" + Integer.toHexString(r2);
        return "#" + r3.substring(r3.length() - 8);
    }

    public String toString() {
        String r0 = this.f34576a + ':';
        switch(this.f34578c) {
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
        return r0 + this.f34580e;
    L9:
        return r0 + Boolean.valueOf(this.f34577b);
    L11:
        return r0 + this.f;
    L13:
        return r0 + a(this.f34579d);
    L15:
        return r0 + this.f34580e;
    L17:
        return r0 + this.f34579d;
    }

    public int getType() {
        return this.f34578c;
    }

    public String b() {
        return this.f34576a;
    }
}
