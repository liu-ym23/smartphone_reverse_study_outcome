package org.c.a.c;

/* JADX INFO: compiled from: MarkedYAMLException.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f40382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f40383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f40384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f40385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f40386e;

    public b(String r8, a r9, String r10, a r11, String r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public b(String r3, a r4, String r5, a r6, String r7, Throwable r8) {
        super(r3 + "; " + r5 + "; " + r6, r8);
        this.f40382a = r3;
        this.f40383b = r4;
        this.f40384c = r5;
        this.f40385d = r6;
        this.f40386e = r7;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.f40382a;
        if (r1 == null) goto L5;
        r0.append(r1);
        r0.append("\n");
    L5:
        a r2 = this.f40383b;
        if (r2 != null) goto L8;
    L18:
        String r3 = this.f40384c;
        if (r3 == null) goto L21;
        r0.append(r3);
        r0.append("\n");
    L21:
        a r4 = this.f40385d;
        if (r4 == null) goto L24;
        r0.append(r4.toString());
        r0.append("\n");
    L24:
        String r5 = this.f40386e;
        if (r5 == null) goto L28;
        r0.append(r5);
        r0.append("\n");
    L28:
        return r0.toString();
    L8:
        if (this.f40384c != null) goto L10;
    L17:
        r0.append(this.f40383b.toString());
        r0.append("\n");
        goto L18
    L10:
        if (this.f40385d == null) goto L17;
        if (r2.b().equals(this.f40385d.b()) == true) goto L17;
        if (this.f40383b.c() != this.f40385d.c()) goto L17;
        if (this.f40383b.d() == this.f40385d.d()) goto L18;
        goto L17
    }

    public String getContext() {
        return this.f40382a;
    }
}
