package com.bytedance.android.live.ktv.common.search.view;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordItemViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchGuessWordAdapter extends RecyclerView.Adapter<CommonSearchGuessWordItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SpannableString> f70284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<s> f70285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f70286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Unit> f70287d;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f70284a).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSearchGuessWordAdapter(boolean r100, Function1<? super String, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "clickAction");
        this.f70286c = r100;
        this.f70287d = r101;
        this.f70284a = new ArrayList();
        this.f70285b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        CommonSearchGuessWordItemViewHolder r102 = (CommonSearchGuessWordItemViewHolder) r100;
        Intrinsics.checkNotNullParameter(r102, "holder");
        SpannableString r103 = (SpannableString) ListProtector.get(this.f70284a, r101);
        s r104 = (s) ListProtector.get(this.f70285b, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, "guessWord");
        r102.f70288a = r103;
        r102.f70289b = r104;
        r102.f70290c.setText(r103);
        int r105 = KtvOrderSongThemeManager.f70192a;
        KtvOrderSongThemeManager.d(r102.f70290c, KtvOrderSongThemeManager.f70197f);
        int r106 = r102.getAdapterPosition();
        pb0.a r107 = pb0.b.f528406a;
        Intrinsics.checkNotNullParameter(r104, "guessWord");
        pb0.a r108 = pb0.b.f528406a;
        if (r108 == null) goto L6;
        r108.s(r106, r104);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Function1<String, Unit> r102 = this.f70287d;
        LayoutInflater r103 = LayoutInflater.from(r100.getContext());
        if (this.f70286c == false) goto L5;
        int r104 = R.layout.ttlive_ktv_common_search_guess_adapt;
    L7:
        return new CommonSearchGuessWordItemViewHolder(r102, r103.inflate(r104, r100, false));
    L5:
        r104 = R.layout.ttlive_ktv_common_search_guess;
        goto L7
    }
}
