package com.bytedance.android.shopping.anchorv3.detail.viewholder;

import android.view.View;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "ITEM", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class AbsFullSpanVH<ITEM> extends JediSimpleViewHolder<ITEM> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ITEM f164813l;

    public /* synthetic */ AbsFullSpanVH() {
        throw null;
    }

    public AbsFullSpanVH(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        StaggeredGridDoubleColumnDecoration.a r102 = StaggeredGridDoubleColumnDecoration.f164806g;
        View r103 = this.itemView;
        r102.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r103, r101);
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public void b4(ITEM r100, int r101, List<Object> r102) {
        if ((!Intrinsics.areEqual(this.f164813l, r100)) == false) goto L6;
        this.f164813l = r100;
        a4(r100);
        return;
    }
}
