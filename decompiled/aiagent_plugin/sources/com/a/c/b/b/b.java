package com.a.c.b.b;

/* JADX INFO: compiled from: FieldDayOfWeekDefinitionBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3110e;

    @Override // com.a.c.b.b.f
    public /* synthetic */ f c(int r1, int r2) {
        return a(r1, r2);
    }

    @Override // com.a.c.b.b.f
    public /* synthetic */ f d(int r1, int r2) {
        return b(r1, r2);
    }

    @Override // com.a.c.b.b.f, com.a.c.b.b.d
    public /* synthetic */ d e(int r1, int r2) {
        return a(r1, r2);
    }

    @Override // com.a.c.b.b.f, com.a.c.b.b.d
    public /* synthetic */ d f(int r1, int r2) {
        return b(r1, r2);
    }

    public b(com.a.c.a.d r1, com.a.c.b.b r2) {
        super(r1, r2);
        this.f3110e = 1;
        com.a.e.a.a(com.a.c.b.b.f.equals(r2), "CronFieldName must be DAY_OF_WEEK");
    }

    public b a(int r3) {
        this.f3116c.a(r3 - this.f3110e);
        this.f3110e = r3;
        return this;
    }

    @Override // com.a.c.b.b.d
    public com.a.c.a.d a() {
        boolean r0 = this.f3116c.g().a(0);
        this.f3114a.a(new a(this.f3115b, this.f3116c.g(), this.f3117d, new com.a.b.b(this.f3110e, r0)));
        return this.f3114a;
    }

    public b a(int r1, int r2) {
        super.c(r1, r2);
        return this;
    }

    public b b(int r1, int r2) {
        super.d(r1, r2);
        return this;
    }
}
