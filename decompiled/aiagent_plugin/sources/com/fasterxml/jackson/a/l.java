package com.fasterxml.jackson.a;

/* JADX INFO: compiled from: JsonProcessingException.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected i f12148a;

    @Override // com.fasterxml.jackson.a.e
    public Object c() {
        return null;
    }

    public String e() {
        return null;
    }

    public l(String r1, i r2, Throwable r3) {
        super(r1, r3);
        this.f12148a = r2;
    }

    public l(String r1) {
        super(r1);
    }

    public l(String r2, i r3) {
        this(r2, r3, null);
    }

    @Override // com.fasterxml.jackson.a.e
    public i a() {
        return this.f12148a;
    }

    @Override // com.fasterxml.jackson.a.e
    public String b() {
        return super.getMessage();
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r0 = super.getMessage();
        if (r0 != null) goto L5;
        r0 = "N/A";
    L5:
        i r1 = a();
        String r4 = e();
        if (r1 != null) goto L8;
        if (r4 != null) goto L8;
        return r0;
    L8:
        StringBuilder r2 = new StringBuilder(100);
        r2.append(r0);
        if (r4 == null) goto L11;
        r2.append(r4);
    L11:
        if (r1 == null) goto L14;
        r2.append('\n');
        r2.append(" at ");
        r2.append(r1.toString());
    L14:
        return r2.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }
}
