package com.obric.oui.privacy.adapter;

import android.content.Context;
import android.view.ViewGroup;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.privacy.e;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends RecyclerView.t {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final a f16383v = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final OCardListItem f16384u;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final b a(Context r10) {
            q.g(r10, "context");
            OCardListItem r11 = new OCardListItem(r10, null, 0, 6, null);
            r11.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            r11.setDefaultCustomEndView(1);
            r11.B(true);
            r11.E(false);
            r11.D(false);
            return new b(r11);
        }

        public a() {
        }
    }

    static {
        f16383v = new a(null);
    }

    public b(OCardListItem r10) {
        q.g(r10, "cardListItem");
        super(r10);
        this.f16384u = r10;
    }

    public final void O(e.b r10, int r11, int r12, int r13) {
        q.g(r10, "item");
        throw null;
    }
}
