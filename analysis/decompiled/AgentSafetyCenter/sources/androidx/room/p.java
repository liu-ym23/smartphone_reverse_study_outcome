package androidx.room;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1596a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1597b;

    public /* synthetic */ p(int i) {
        this.f1596a = i;
    }

    public final void a(z4.c cVar) {
        int i = this.f1596a;
        cVar.getClass();
        switch (i) {
            case 0:
                ((a9.e) this.f1597b).invoke(cVar);
                return;
            default:
                cVar.d();
                try {
                    StringBuilder sb2 = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
                    ((g5.j) this.f1597b).getClass();
                    sb2.append(System.currentTimeMillis() - 86400000);
                    sb2.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
                    cVar.n(sb2.toString());
                    cVar.F();
                    return;
                } finally {
                    cVar.i();
                }
        }
    }
}
