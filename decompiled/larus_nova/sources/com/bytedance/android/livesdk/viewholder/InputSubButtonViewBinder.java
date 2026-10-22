package com.bytedance.android.livesdk.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class InputSubButtonViewBinder extends me.drakeet.multitype.b<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a, SubButtonViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<View, Unit> f159268b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/viewholder/InputSubButtonViewBinder$SubButtonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class SubButtonViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f159269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f159270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f159271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ InputSubButtonViewBinder f159272d;

        public SubButtonViewHolder(InputSubButtonViewBinder r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f159272d = r100;
            super(r101);
            this.f159269a = (ImageView) r101.findViewById(R.id.button_pic);
            this.f159270b = (TextView) r101.findViewById(R.id.button_name);
            this.f159271c = (ImageView) r101.findViewById(R.id.red_dot);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InputSubButtonViewBinder(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onItemClick");
        this.f159268b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r101) {
        SubButtonViewHolder r102 = (SubButtonViewHolder) r100;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "vh");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "button");
        r102.itemView.setTag(r103.q());
        r102.f159269a.setBackgroundResource(r103.o());
        r102.f159270b.setText(r103.q().getDesc());
        if (r103.canShowRedDot() == false) goto L5;
        r103.u(true, true);
        UtilityKotlinExtentionsKt.w(r102.f159271c);
    L6:
        r102.itemView.setOnClickListener(new h(r102));
        return;
    L5:
        r103.u(false, true);
        UtilityKotlinExtentionsKt.t(r102.f159271c);
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SubButtonViewHolder(this, r100.inflate(R.layout.ttlive_comment_panel_more_function_item, r101, false));
    }
}
