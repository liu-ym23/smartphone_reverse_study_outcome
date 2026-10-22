package com.bytedance.android.live.search.impl.search.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.search.impl.search.f;
import com.bytedance.android.live.search.impl.search.viewholder.LiveSearchSugHistoryMoreViewHolder;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.adapter.LiveSearchSugHistoryViewHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ra1.g;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/adapter/LiveSearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g> f100687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f100688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public qa1.c f100689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f100690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f100691e;

    public static final class a {
    }

    public static final class b implements qa1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSearchHistoryAdapter f100692a;

        @Override // qa1.b
        public final void a() {
            LiveSearchHistoryAdapter r100 = this.f100692a;
            r100.f100690d = true;
            r100.notifyDataSetChanged();
            int r101 = com.bytedance.android.live.search.impl.search.g.f100753a;
            HashMap r102 = new HashMap();
            r102.put("action_type", "show_all");
            u.l().e("search_history", r102, new Object[0]);
        }

        @Override // qa1.b
        public final void deleteAll() {
            LiveSearchHistoryAdapter r100 = this.f100692a;
            r100.f100690d = false;
            ((ArrayList) r100.f100687a).clear();
            this.f100692a.notifyDataSetChanged();
            f.f100749d.getClass();
            f.b(new ArrayList());
            int r101 = com.bytedance.android.live.search.impl.search.g.f100753a;
            HashMap r102 = new HashMap();
            r102.put("action_type", "clear_all");
            u.l().e("search_history", r102, new Object[0]);
        }

        public b(LiveSearchHistoryAdapter r100) {
            this.f100692a = r100;
        }
    }

    public static final class c implements LiveSearchSugHistoryViewHolder.OnDeleteItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveSearchHistoryAdapter f100693a;

        public c(LiveSearchHistoryAdapter r100) {
            this.f100693a = r100;
        }

        @Override // com.ss.android.ugc.aweme.discover.adapter.LiveSearchSugHistoryViewHolder.OnDeleteItemClickListener
        public final void a(int r100) {
            if (r100 >= 0) goto L4;
        L6:
            this.f100693a.notifyDataSetChanged();
            return;
        L4:
            if (r100 >= ((ArrayList) this.f100693a.f100687a).size()) goto L6;
            ListProtector.remove(this.f100693a.f100687a, r100);
            goto L6
        }
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        boolean r100 = false;
        if (this.f100690d == false) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L11;
        return 6;
    L11:
        if (this.f100690d == true) goto L13;
    L15:
        if (r100 == false) goto L18;
        return y2() + 1;
    L18:
        return y2();
    L13:
        if (((ArrayList) this.f100687a).size() <= 5) goto L15;
        r100 = true;
        goto L15
    L5:
        if (((ArrayList) this.f100687a).size() <= 5) goto L7;
        r101 = true;
        goto L8
    }

    public final int y2() {
        if (((ArrayList) this.f100687a).size() <= 10) goto L6;
        return 10;
    L6:
        return ((ArrayList) this.f100687a).size();
    }

    public LiveSearchHistoryAdapter(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f100687a = new ArrayList();
        this.f100688b = "";
        LiveSearchIntermediateViewModel r101 = (LiveSearchIntermediateViewModel) ViewModelProviders.of(r100).get(LiveSearchIntermediateViewModel.class);
        this.f100691e = new b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        boolean r101 = false;
        if (this.f100690d == false) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L12;
        if (r100 != 5) goto L12;
    L26:
        return 2;
    L12:
        if (this.f100690d == true) goto L14;
    L16:
        if (r101 == true) goto L18;
    L20:
        if (r100 < 0) goto L26;
        if (r100 >= ((ArrayList) this.f100687a).size()) goto L26;
        if (((g) ListProtector.get(this.f100687a, r100)).d() == false) goto L26;
        return 1;
    L18:
        if (r100 != y2()) goto L20;
        return 3;
    L14:
        if (((ArrayList) this.f100687a).size() <= 5) goto L16;
        r101 = true;
        goto L16
    L5:
        if (((ArrayList) this.f100687a).size() <= 5) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = getItemViewType(r101);
        boolean r103 = true;
        if (r102 != 1) goto L6;
        ((LiveSearchSugHistoryViewHolder) r100).T3((g) ListProtector.get(this.f100687a, r101), this.f100688b, r101, new c(this));
        return;
    L6:
        if ((r100 instanceof LiveSearchSugHistoryMoreViewHolder) == true) goto L8;
        r100 = null;
    L8:
        LiveSearchSugHistoryMoreViewHolder r104 = (LiveSearchSugHistoryMoreViewHolder) r100;
        if (r104 != null) goto L11;
        return;
    L11:
        if (r102 == 2) goto L14;
        r103 = false;
    L14:
        b r105 = this.f100691e;
        Intrinsics.checkNotNullParameter(r105, "listener");
        TextView r106 = (TextView) r104.itemView.findViewById(R.id.text);
        if (r103 == false) goto L17;
        int r107 = R.string.ttlive_search_history_all;
    L18:
        r106.setText(s1.B(r107));
        r104.itemView.setOnClickListener(new sa1.a(r103, r105));
        return;
    L17:
        r107 = R.string.ttlive_search_history_delete_all;
        goto L18
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 1) goto L6;
        LiveSearchSugHistoryViewHolder.Companion r102 = LiveSearchSugHistoryViewHolder.f450012b;
        qa1.c r103 = this.f100689c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveSearchSugHistoryViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_search_item_search_sug_history_list, r100, false), r103);
    L6:
        if (r101 != 3) goto L8;
    L11:
        int r104 = LiveSearchSugHistoryMoreViewHolder.f100814a;
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveSearchSugHistoryMoreViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_search_item_history_text, r100, false));
    L8:
        if (r101 == 2) goto L11;
        int r105 = LiveSearchSugHistoryMoreViewHolder.f100814a;
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new LiveSearchSugHistoryMoreViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_search_item_history_text, r100, false));
    }
}
