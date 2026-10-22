package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.p;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.e;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class PrivacySheetAdapter extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f16376g = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f16377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f16378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f16379f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f16376g = new a(null);
    }

    public PrivacySheetAdapter(List r10) {
        q.g(r10, Card.KEY_ITEMS);
        this.f16377d = r10;
        this.f16378e = kotlin.b.b(new PrivacySheetAdapter$switchItemCount$2(this));
        this.f16379f = kotlin.b.b(new PrivacySheetAdapter$switchStartIndex$2(this));
    }

    public static final /* synthetic */ List u(PrivacySheetAdapter r10) {
        return r10.f16377d;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int e() {
        return this.f16377d.size();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public int g(int r10) {
        if ((((e) this.f16377d.get(r10)) instanceof e.a) == false) goto L7;
        return 1;
    L7:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public void k(RecyclerView.t r10, int r11) {
        q.g(r10, "holder");
        if ((r10 instanceof b) == false) goto L6;
        p.a(this.f16377d.get(r11));
        ((b) r10).O(null, r11, v(), w());
        return;
    L6:
        if ((r10 instanceof com.obric.oui.privacy.adapter.a) == false) goto L10;
        com.obric.oui.privacy.adapter.a r12 = (com.obric.oui.privacy.adapter.a) r10;
        r12.O((e.a) this.f16377d.get(r11));
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
    public RecyclerView.t m(ViewGroup r10, int r11) {
        q.g(r10, "parent");
        if (r11 != 0) goto L5;
        b.a r12 = b.f16383v;
        Context r13 = r10.getContext();
        q.f(r13, "parent.context");
        return r12.a(r13);
    L5:
        if (r11 != 1) goto L8;
        com.obric.oui.privacy.adapter.a.C0205a r14 = com.obric.oui.privacy.adapter.a.f16380w;
        Context r15 = r10.getContext();
        q.f(r15, "parent.context");
        return r14.a(r15);
    L8:
        throw new IllegalArgumentException(q.p("Unknown viewType: ", Integer.valueOf(r11)));
    }

    public final int v() {
        return ((Number) this.f16378e.getValue()).intValue();
    }

    public final int w() {
        return ((Number) this.f16379f.getValue()).intValue();
    }
}
