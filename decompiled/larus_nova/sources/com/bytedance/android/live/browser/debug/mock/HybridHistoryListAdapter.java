package com.bytedance.android.live.browser.debug.mock;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import q20.b;
import q20.c;
import q20.d;
import q20.e;
import q20.f;
import q20.g;
import r20.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u000bR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter$ViewHolder;", "Landroidx/fragment/app/FragmentActivity;", "b", "Landroidx/fragment/app/FragmentActivity;", "getContext", "()Landroidx/fragment/app/FragmentActivity;", "setContext", "(Landroidx/fragment/app/FragmentActivity;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "ViewHolder", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HybridHistoryListAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f62608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f62609b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/HybridHistoryListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f62610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f62611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f62612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f62613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Button f62614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Button f62615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f62616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Button f62617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Button f62618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Button f62619j;

        @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
        public final String toString() {
            return super.toString() + " '" + this.f62611b.getText() + "'";
        }

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f62610a = (TextView) r100.findViewById(R.id.item_number);
            this.f62611b = (TextView) r100.findViewById(R.id.out_scheme);
            this.f62612c = (TextView) r100.findViewById(R.id.origin_sub_url_host);
            this.f62613d = (TextView) r100.findViewById(R.id.origin_sub_url_path);
            TextView r101 = (TextView) r100.findViewById(R.id.maped_sub_url);
            this.f62614e = (Button) r100.findViewById(R.id.full_scheme_btn);
            this.f62615f = (Button) r100.findViewById(R.id.copy_url);
            this.f62616g = (TextView) r100.findViewById(R.id.mapping_config);
            this.f62617h = (Button) r100.findViewById(R.id.open_local_debug_page);
            this.f62618i = (Button) r100.findViewById(R.id.open_debug_page);
            this.f62619j = (Button) r100.findViewById(R.id.send_to_user);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f62608a.size();
    }

    public final FragmentActivity getContext() {
        return this.f62609b;
    }

    public HybridHistoryListAdapter(List<a> r100, FragmentActivity r101) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.f62608a = r100;
        this.f62609b = r101;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ViewHolder r102 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        a r103 = (a) ListProtector.get(this.f62608a, r101);
        TextView r104 = r102.f62610a;
        StringBuilder r105 = new StringBuilder();
        if (r103.f535709a == false) goto L5;
        String r106 = "TOP";
    L6:
        r105.append(r106);
        r105.append(String.valueOf(this.f62608a.size() - r101));
        r104.setText(r105.toString());
        r102.f62611b.setText(r103.f535710b.toString());
        Uri r107 = UriProtector.parse(UriProtector.getQueryParameter(r103.f535710b, "url"));
        r102.f62612c.setText(r107.getHost());
        r102.f62613d.setText(r107.getPath());
        r102.f62614e.setOnClickListener(new b(r103));
        r102.f62616g.setOnClickListener(new c(this, r103));
        r102.f62617h.setOnClickListener(new d(this, r103));
        r102.f62618i.setOnClickListener(new e(this, r103));
        r102.f62619j.setOnClickListener(new f(r103));
        r102.f62615f.setOnClickListener(new g(this, r103));
        return;
    L5:
        r106 = "";
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.fragment_hybrid_history_item, r100, false));
    }
}
