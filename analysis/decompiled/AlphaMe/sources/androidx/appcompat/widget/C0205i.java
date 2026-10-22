package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import com.stepos.alphame.R;
import d.C0527a;
import k.AbstractC0669w;
import k.C0661o;
import k.C0671y;
import k.SubMenuC0646G;

/* renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0205i extends C0671y {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f3102m = 0;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ C0217o f3103n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0205i(C0217o c0217o, Context context, C0661o c0661o, C0213m c0213m) {
        super(R.attr.actionOverflowMenuStyle, 0, context, c0213m, c0661o, true);
        this.f3103n = c0217o;
        this.f13313g = 8388613;
        C0527a c0527a = c0217o.f3148w;
        this.f13315i = c0527a;
        AbstractC0669w abstractC0669w = this.f13316j;
        if (abstractC0669w != null) {
            abstractC0669w.j(c0527a);
        }
    }

    @Override // k.C0671y
    public final void c() {
        int i4 = this.f3102m;
        C0217o c0217o = this.f3103n;
        switch (i4) {
            case 0:
                c0217o.f3145t = null;
                super.c();
                break;
            default:
                C0661o c0661o = c0217o.f3128c;
                if (c0661o != null) {
                    c0661o.c(true);
                }
                c0217o.f3144s = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0205i(C0217o c0217o, Context context, SubMenuC0646G subMenuC0646G, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, subMenuC0646G, false);
        this.f3103n = c0217o;
        if (!subMenuC0646G.f13161A.f()) {
            View view2 = c0217o.f3134i;
            this.f13312f = view2 == null ? (View) c0217o.f3133h : view2;
        }
        C0527a c0527a = c0217o.f3148w;
        this.f13315i = c0527a;
        AbstractC0669w abstractC0669w = this.f13316j;
        if (abstractC0669w != null) {
            abstractC0669w.j(c0527a);
        }
    }
}
