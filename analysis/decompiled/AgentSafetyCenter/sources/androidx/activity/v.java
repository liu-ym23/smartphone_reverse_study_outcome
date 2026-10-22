package androidx.activity;

import java.util.ListIterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f702c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e0 f703f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(e0 e0Var, int i) {
        super(1);
        this.f702c = i;
        this.f703f = e0Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        Object objPrevious;
        Object objPrevious2;
        switch (this.f702c) {
            case 0:
                ((c) obj).getClass();
                e0 e0Var = this.f703f;
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
                e0Var.f666c = (u) objPrevious;
                break;
            default:
                ((c) obj).getClass();
                e0 e0Var2 = this.f703f;
                if (e0Var2.f666c == null) {
                    kb.j jVar2 = e0Var2.f665b;
                    ListIterator listIterator2 = jVar2.listIterator(jVar2.a());
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            objPrevious2 = listIterator2.previous();
                            if (((u) objPrevious2).f699a) {
                            }
                        } else {
                            objPrevious2 = null;
                        }
                    }
                }
                break;
        }
        return jb.v.f6774a;
    }
}
