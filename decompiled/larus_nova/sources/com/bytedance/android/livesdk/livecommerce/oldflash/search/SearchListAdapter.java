package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/SearchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f149683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Pair<String, String>, Unit> f149684b;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f149685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f149686b;

        public b(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f149685a = (TextView) r100.findViewById(R.id.tv_content_header);
            this.f149686b = (ImageView) r100.findViewById(R.id.iv_selected);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f149687a;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f149687a = (TextView) r100.findViewById(R.id.tv_header_title);
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f149688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SearchListAdapter f149689b;

        public d(i r100, SearchListAdapter r101) {
            this.f149688a = r100;
            this.f149689b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function1<Pair<String, String>, Unit> r101 = this.f149689b.f149684b;
            i r102 = this.f149688a;
            r101.invoke(TuplesKt.to(r102.f149702a, r102.f149700b));
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f149683a).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SearchListAdapter(Function1<? super Pair<String, String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "clickCallback");
        this.f149684b = r100;
        this.f149683a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        k r101 = (k) ListProtector.get(this.f149683a, r100);
        if ((r101 instanceof j) == false) goto L6;
        return 0;
    L6:
        if ((r101 instanceof i) == false) goto L10;
        return 1;
    L10:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.f149683a, r100)).getClass().getName()).toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        k r102 = (k) ListProtector.get(this.f149683a, r101);
        k r103 = null;
        if ((r100 instanceof c) == false) goto L11;
        if ((r102 instanceof j) == true) goto L7;
        r102 = null;
    L7:
        j r104 = (j) r102;
        if (r104 == null) goto L30;
        ((c) r100).f149687a.setText(r104.f149702a);
        return;
    L30:
        return;
    L11:
        if ((r100 instanceof b) == false) goto L29;
        if ((r102 instanceof i) == false) goto L16;
        r103 = r102;
    L16:
        i r105 = (i) r103;
        if (r105 == null) goto L32;
        b r106 = (b) r100;
        TextView r107 = r106.f149685a;
        r107.setText(r102.f149702a);
        Context r108 = r107.getContext();
        i r109 = (i) r102;
        if (r109.f149701c == false) goto L21;
        int r110 = R.color.ec_color_FE2C55;
    L22:
        r107.setTextColor(th.a.a(r108, r110));
        ImageView r111 = r106.f149686b;
        if (r109.f149701c == false) goto L25;
        int r112 = 0;
    L26:
        r111.setVisibility(r112);
        r100.itemView.setOnClickListener(new d(r105, this));
        return;
    L25:
        r112 = 8;
        goto L26
    L21:
        r110 = R.color.ec_color_black_161823;
        goto L22
    L32:
        return;
    L29:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.f149683a, r101)).getClass().getName()).toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 == 0) goto L10;
        if (r101 != 1) goto L8;
        return new b(y2(this, R.layout.ec_search_item_select, r100));
    L8:
        throw new IllegalStateException(("Invalid type " + r101).toString());
    L10:
        return new c(y2(this, R.layout.ec_search_item_header, r100));
    }

    public static View y2(SearchListAdapter r100, int r101, ViewGroup r102) {
        r100.getClass();
        Context r103 = r102.getContext();
        if (r103 == null) goto L5;
        Context r104 = th.a.e(r103, true);
    L7:
        return LayoutInflater.from(r104).inflate(r101, r102, false);
    L5:
        r104 = null;
        goto L7
    }
}
