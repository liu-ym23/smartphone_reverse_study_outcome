package com.bytedance.android.live.ktv.common.search.view;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchGuessWordItemViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpannableString f70288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s f70289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f70290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f70291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f70292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<String, Unit> f70293f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonSearchGuessWordItemViewHolder f70294a;

        public a(CommonSearchGuessWordItemViewHolder r100) {
            this.f70294a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            CommonSearchGuessWordItemViewHolder r101 = this.f70294a;
            Function1<String, Unit> r102 = r101.f70293f;
            if (r102 == null) goto L5;
            Unit r103 = r102.invoke(String.valueOf(r101.f70288a));
        L5:
            CommonSearchGuessWordItemViewHolder r104 = this.f70294a;
            s r105 = r104.f70289b;
            if (r105 == null) goto L11;
            int r106 = r104.getAdapterPosition();
            pb0.a r107 = pb0.b.f528406a;
            Intrinsics.checkNotNullParameter(r105, "guessWord");
            pb0.a r108 = pb0.b.f528406a;
            if (r108 == null) goto L12;
            r108.m(r106, r105);
            return;
        L12:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSearchGuessWordItemViewHolder(Function1<? super String, Unit> r100, View r101) {
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f70293f = r100;
        this.f70290c = (TextView) r101.findViewById(R.id.guess_content);
        View r102 = r101.findViewById(R.id.search_icon);
        this.f70291d = r102;
        View r103 = r101.findViewById(R.id.right_icon);
        this.f70292e = r103;
        r101.setOnClickListener(new a(this));
        r102.setVisibility(0);
        r103.setVisibility(8);
        KtvOrderSongThemeManager.c(r102, KtvOrderSongThemeManager.f70200i);
    }
}
