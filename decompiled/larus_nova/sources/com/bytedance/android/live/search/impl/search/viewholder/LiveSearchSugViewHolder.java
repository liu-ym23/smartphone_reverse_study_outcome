package com.bytedance.android.live.search.impl.search.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.c;
import ra1.g;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/search/impl/search/viewholder/LiveSearchSugViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchSugViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f100815g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f100816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f100817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f100818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f100819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f100820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f100821f;

    public static final class a {
    }

    static {
    }

    public LiveSearchSugViewHolder(View r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f100821f = r101;
        this.f100818c = "";
        this.f100820e = "";
        boolean r102 = this.itemView.getContext() instanceof FragmentActivity;
        this.f100816a = (TextView) r100.findViewById(R.id.tv_sug);
        this.f100819d = r100.findViewById(R.id.iv_search_icon);
    }
}
