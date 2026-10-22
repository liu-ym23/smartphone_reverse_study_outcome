package androidx.activity;

import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f704c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e0 f705f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(e0 e0Var, int i) {
        super(0);
        this.f704c = i;
        this.f705f = e0Var;
    }

    @Override // xb.a
    public final Object invoke() {
        Object objPrevious;
        switch (this.f704c) {
            case 0:
                this.f705f.b();
                break;
            case 1:
                e0 e0Var = this.f705f;
                if (e0Var.f666c == null) {
                    kb.j jVar = e0Var.f665b;
                    ListIterator listIterator = jVar.listIterator(jVar.a());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            objPrevious = listIterator.previous();
                            if (((u) objPrevious).f699a) {
                            }
                        } else {
                            objPrevious = null;
                        }
                    }
                }
                e0Var.f666c = null;
                break;
            default:
                this.f705f.b();
                break;
        }
        return jb.v.f6774a;
    }
}
