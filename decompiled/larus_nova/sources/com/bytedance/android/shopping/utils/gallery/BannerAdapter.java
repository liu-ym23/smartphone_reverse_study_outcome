package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter$BannerHolder;", "BannerHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends RecyclerView.Adapter<BannerHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Function1<Float, Unit>> f187090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f187091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f187092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f187093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f187094e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter$BannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BannerHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f187095a = 0;

        public BannerHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }

        public static void T3(Float r100, TextView r101, View r102) {
            if (r100 == null) goto L8;
            if (r101 == null) goto L5;
            r101.setAlpha(1 - ((float) Math.sqrt(r100.floatValue())));
        L5:
            if (r102 == null) goto L9;
            r102.setAlpha(r100.floatValue());
            return;
        L9:
            return;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f187093d.size();
    }

    public final void y2(float r100) {
        int r101 = this.f187094e;
        int r102 = ((int) Math.rint((r100 - (r101 / 2)) / (r101 + this.f187091b))) + 1;
        int r103 = r102 - 1;
        int r104 = r102 + 1;
        if (r103 > r104) goto L9;
    L4:
        int r105 = this.f187094e;
        float r106 = 1.0f - Math.min(1.0f, Math.abs((((r103 - 1) * (this.f187091b + r105)) + (r105 / 2)) - r100) / (this.f187094e + this.f187091b));
        Function1 r107 = (Function1) CollectionsKt.getOrNull(this.f187090a, r103);
        if (r107 == null) goto L7;
        Unit r108 = (Unit) r107.invoke(Float.valueOf(r106));
    L7:
        if (r103 == r104) goto L11;
        r103 = r103 + 1;
        goto L4
    L11:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final BannerHolder r101 = (BannerHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        List<Function1<Float, Unit>> r102 = this.f187090a;
        String r103 = (String) ListProtector.get(this.f187093d, r110);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r103, "title");
        final TextView r104 = (TextView) r101.itemView.findViewById(R.id.tv_banner_title);
        final View r105 = r101.itemView.findViewById(R.id.banner_title_extended_layout);
        final TextView r106 = (TextView) r101.itemView.findViewById(R.id.tv_banner_title_extended);
        if (r104 == null) goto L5;
        r104.setText(r103);
    L5:
        if (r106 != null) goto L7;
    L26:
        BannerHolder.T3(Float.valueOf(0.0f), r104, r105);
        ListProtector.set(r102, r110, new BannerAdapter$BannerHolder$bind$1(r101, r104, r106, r105));
        return;
    L7:
        if (r103.length() <= 0) goto L9;
        boolean r107 = true;
    L10:
        String r108 = "";
        if (r107 == false) goto L13;
        String r109 = com.bytedance.android.shopping.extensions.j.c(R.string.ec_commerce_banner_selected_hint) + ' ' + r103;
    L14:
        Intrinsics.checkNotNullParameter(r106, "$this$setNonLineBreakingText");
        ViewParent r111 = r106.getParent();
        if ((r111 instanceof ViewGroup) == true) goto L17;
        r111 = null;
    L17:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L22;
        if (r109 == null) goto L22;
        r106.setVisibility(4);
        r106.setText(r109);
        r112.post(new b(r106, r112, r109));
    L22:
        if (r109 == null) goto L25;
        r108 = r109;
    L25:
        r106.setText(r108);
        goto L26
    L13:
        r109 = "";
        goto L14
    L9:
        r107 = false;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = th.a.c(r100.getContext(), R.layout.ec_commerce_banner_item_layout, r100, false);
        r102.post(new a(this, r102));
        return new BannerHolder(r102);
    }

    public BannerAdapter(Context r100, List<String> r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "titles");
        this.f187092c = r100;
        this.f187093d = r101;
        this.f187094e = r102;
        int r103 = getItemCount();
        ArrayList r104 = new ArrayList(r103);
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L5;
        r104.add(null);
        r105 = r105 + 1;
        goto L3
    L5:
        this.f187090a = r104;
        this.f187091b = com.bytedance.android.shopping.extensions.b.b(32);
        k1.n(this.f187092c);
    }
}
