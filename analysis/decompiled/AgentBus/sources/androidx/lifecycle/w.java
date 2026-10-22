package androidx.lifecycle;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public q f1031a;

    /* renamed from: b, reason: collision with root package name */
    public t f1032b;

    public final void a(v vVar, p pVar) {
        q qVarA = pVar.a();
        q qVar = this.f1031a;
        q7.k.e(qVar, "state1");
        if (qVarA.compareTo(qVar) < 0) {
            qVar = qVarA;
        }
        this.f1031a = qVar;
        this.f1032b.b(vVar, pVar);
        this.f1031a = qVarA;
    }
}
