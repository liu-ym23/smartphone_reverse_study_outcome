package org.c.a.d;

/* JADX INFO: compiled from: NodeEvent.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class k extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40405a;

    public k(String r1, org.c.a.c.a r2, org.c.a.c.a r3) {
        super(r2, r3);
        this.f40405a = r1;
    }

    public String h() {
        return this.f40405a;
    }

    @Override // org.c.a.d.g
    public String d() {
        return "anchor=" + this.f40405a;
    }
}
