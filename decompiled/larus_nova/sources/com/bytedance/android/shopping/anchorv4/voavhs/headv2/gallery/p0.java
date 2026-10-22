package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p0 extends RecyclerView.Adapter<r0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<s> f169360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f169361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Integer, Integer, Unit> f169362c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f169360a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        r0 r112 = (r0) r110;
        Intrinsics.checkNotNullParameter(r112, "holder");
        s r100 = (s) ListProtector.get(this.f169360a, r111);
        int r101 = 0;
        if (r100.f169386a.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        r112.f169385a.f169378c.setVisibility(8);
    L11:
        if (r100.f169391f == true) goto L13;
    L15:
        r112.f169385a.f169378c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    L16:
        String r103 = r100.f169387b;
        if (r103 != null) goto L19;
    L21:
        r112.f169385a.setSelected(r100.f169391f);
        r112.f169385a.setOnClickListener(new o0(this, r100, r111));
        q0 r113 = r112.f169385a;
        ViewGroup.LayoutParams r104 = r113.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        r104 = null;
    L24:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 != null) goto L27;
        r105 = new ViewGroup.MarginLayoutParams(-2, -2);
    L27:
        if (r111 == 0) goto L29;
        r101 = com.bytedance.android.shopping.extensions.b.a(8);
    L29:
        r105.leftMargin = r101;
        Unit r106 = Unit.INSTANCE;
        r113.setLayoutParams(r105);
        m r107 = this.f169361b.f169329g;
        r107.getClass();
        m.d(r107, com.bytedance.android.ec.core.event.a.EVENT_PDP_MODULE_SHOW, null, "more_video_item_" + r111, "a1.b34986.c503191.d47097_i" + (r111 + 1), 6);
        return;
    L19:
        if ((!Intrinsics.areEqual(r112.f169385a.f169379d.getTag(), r103)) == false) goto L21;
        r112.f169385a.f169379d.setTag(r103);
        com.bytedance.android.ec.core.utils.y.d(r112.f169385a.f169379d, r103);
        goto L21
    L13:
        if (r100.f169389d == false) goto L15;
        r112.f169385a.f169378c.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ec_pdp_gallery_more_video_live, 0, 0, 0);
        r112.f169385a.f169378c.setCompoundDrawablePadding((int) com.bytedance.android.ec.core.utils.q.a(Double.valueOf(1.5d)));
        goto L16
    L9:
        r112.f169385a.f169378c.setVisibility(0);
        r112.f169385a.f169378c.setText(r100.f169386a);
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new r0(new q0(r100.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p0(List<s> r100, l r101, Function2<? super Integer, ? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "items");
        Intrinsics.checkNotNullParameter(r101, "galleryCtx");
        Intrinsics.checkNotNullParameter(r102, "trySelectPosition");
        this.f169361b = r101;
        this.f169362c = r102;
        this.f169360a = CollectionsKt.toMutableList(r100);
    }
}
