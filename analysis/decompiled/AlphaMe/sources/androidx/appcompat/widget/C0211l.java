package androidx.appcompat.widget;

import android.view.View;
import k.InterfaceC0644E;
import stepos.support.v7.widget.C0894n;
import stepos.support.v7.widget.C0895o;
import stepos.support.v7.widget.C0897q;

/* renamed from: androidx.appcompat.widget.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0211l extends AbstractViewOnTouchListenerC0235x0 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3121j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f3122k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ View f3123l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0211l(int i4, View view, View view2, Object obj) {
        super(view2);
        this.f3121j = i4;
        this.f3123l = view;
        this.f3122k = obj;
    }

    @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0
    public final InterfaceC0644E b() {
        int i4 = this.f3121j;
        View view = this.f3123l;
        switch (i4) {
            case 0:
                C0205i c0205i = ((C0213m) view).f3124a.f3144s;
                if (c0205i == null) {
                    return null;
                }
                return c0205i.a();
            case 1:
                return (T) this.f3122k;
            default:
                C0895o c0895o = ((C0894n) view).f15104d.f15110A;
                if (c0895o == null) {
                    return null;
                }
                return c0895o.f1350j;
        }
    }

    @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0
    public final boolean c() {
        int i4 = this.f3121j;
        View view = this.f3123l;
        switch (i4) {
            case 0:
                ((C0213m) view).f3124a.l();
                break;
            case 1:
                V v4 = (V) view;
                if (!v4.getInternalPopup().e()) {
                    v4.f3020f.n(v4.getTextDirection(), v4.getTextAlignment());
                    break;
                }
                break;
            default:
                ((C0894n) view).f15104d.o();
                break;
        }
        return true;
    }

    @Override // androidx.appcompat.widget.AbstractViewOnTouchListenerC0235x0
    public final boolean d() {
        int i4 = this.f3121j;
        View view = this.f3123l;
        switch (i4) {
            case 0:
                C0217o c0217o = ((C0213m) view).f3124a;
                if (c0217o.f3146u == null) {
                    c0217o.g();
                    break;
                }
                break;
            case 1:
            default:
                super.d();
                break;
            case 2:
                C0897q c0897q = ((C0894n) view).f15104d;
                if (c0897q.f15112C == null) {
                    c0897q.j();
                    break;
                }
                break;
        }
        return true;
    }
}
