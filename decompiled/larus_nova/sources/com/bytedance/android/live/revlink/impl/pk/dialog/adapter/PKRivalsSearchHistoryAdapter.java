package com.bytedance.android.live.revlink.impl.pk.dialog.adapter;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.PKRivalsPanelSearchWidget;
import com.bytedance.android.live.revlink.impl.pk.dialog.presenter.j;
import com.bytedance.android.live.revlink.impl.pk.utils.u;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "DummyViewHolder", "SearchHistoryViewHolder", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PKRivalsSearchHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f95504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f95505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f95506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f95507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f95508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f95509f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x31.j f95510g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u f95511h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter$DummyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class DummyViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PKRivalsSearchHistoryAdapter f95512a;

        public static final class a implements View.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ DummyViewHolder f95513a;

            public a(DummyViewHolder r100) {
                this.f95513a = r100;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r100) {
                this.f95513a.f95512a.f95509f.e();
            }
        }

        public DummyViewHolder(PKRivalsSearchHistoryAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f95512a = r100;
            super(r101);
            r101.setOnClickListener(new a(this));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/dialog/adapter/PKRivalsSearchHistoryAdapter$SearchHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class SearchHistoryViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f95514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f95515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f95516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f95517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f95518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PKRivalsSearchHistoryAdapter f95519f;

        public SearchHistoryViewHolder(PKRivalsSearchHistoryAdapter r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f95519f = r100;
            super(r101);
            this.f95514a = r101.findViewById(R.id.history_icon);
            this.f95515b = (TextView) r101.findViewById(R.id.history_content);
            this.f95516c = r101.findViewById(R.id.remove_history);
            this.f95517d = (TextView) r101.findViewById(R.id.history_content);
            this.f95518e = "";
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f95505b).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return this.f95504a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        if ((r100 instanceof SearchHistoryViewHolder) == false) goto L20;
        SearchHistoryViewHolder r102 = (SearchHistoryViewHolder) r100;
        String r103 = (String) ListProtector.get(this.f95505b, r101);
        int r104 = this.f95504a;
        int r105 = this.f95506c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "content");
        r102.f95518e = r103;
        r102.f95515b.setText(r103);
        if (r104 != 0) goto L7;
        r102.f95514a.setVisibility(8);
        r102.f95516c.setOnClickListener(null);
        return;
    L7:
        if (r104 == 2) goto L9;
        r102.f95514a.setVisibility(0);
        r102.f95516c.setBackgroundResource(R.drawable.ttlive_ic_pk_rivals_search_history_remove);
        r102.f95516c.setOnClickListener(new c(r102));
        r102.f95515b.setOnClickListener(new d(r102));
        return;
    L9:
        r102.f95514a.setVisibility(8);
        ViewGroup.LayoutParams r106 = r102.f95517d.getLayoutParams();
        if (r106 == null) goto L17;
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        r107.leftMargin = s1.f(20.0f);
        SpannableString r108 = new SpannableString(r102.f95517d.getText());
        ForegroundColorSpan r109 = new ForegroundColorSpan(s1.h(R.color.ttlive_pk_search_hint));
        if (r108.length() >= r105) goto L15;
        r105 = r108.length();
    L15:
        r108.setSpan(r109, 0, r105, 18);
        r102.f95517d.setText(r108);
        r102.f95517d.setLayoutParams(r107);
        r102.f95516c.setBackgroundResource(R.drawable.ttlive_ic_history_go_search);
        r102.f95516c.setOnClickListener(new com.bytedance.android.live.revlink.impl.pk.dialog.adapter.a(r102));
        r102.f95515b.setOnClickListener(new b(r102));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L9;
        return new DummyViewHolder(this, LayoutInflater.from(this.f95508e).inflate(R.layout.ttlive_item_pk_rivals_search_history_dummy, r100, false));
    L9:
        return new SearchHistoryViewHolder(this, LayoutInflater.from(this.f95508e).inflate(R.layout.ttlive_item_pk_rivals_search_history, r100, false));
    }

    public PKRivalsSearchHistoryAdapter(Context r100, j r101, PKRivalsPanelSearchWidget r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mPresenter");
        Intrinsics.checkNotNullParameter(r102, "mListener");
        Intrinsics.checkNotNullParameter(r103, "searchSource");
        this.f95508e = r100;
        this.f95509f = r101;
        this.f95510g = r102;
        this.f95511h = r103;
        this.f95504a = 1;
        this.f95505b = new ArrayList();
        this.f95507d = "";
    }
}
