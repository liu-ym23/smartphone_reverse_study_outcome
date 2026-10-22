package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.ies.sve_list.RecyclerViewItemWidget;
import com.bytedance.ies.sve_list.SVEAdapter;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00062\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0010\u0010\u0005\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lcom/bytedance/ies/sve_list/ViewType;", "p1", "Lcom/bytedance/ies/sve_list/SVEAdapter;", "Lcom/bytedance/android/gamecp/base/gamedetail/d0;", "p2", "Lcom/bytedance/ies/sve_list/RecyclerViewItemWidget;", AbsMethodDelegate.TAG_INVOKE, "(ILcom/bytedance/ies/sve_list/SVEAdapter;)Lcom/bytedance/ies/sve_list/RecyclerViewItemWidget;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ScaffoldComponent$createWidget$4 extends FunctionReferenceImpl implements Function2<Integer, SVEAdapter<d0, ?>, RecyclerViewItemWidget<? extends d0>> {
    public ScaffoldComponent$createWidget$4(com.bytedance.android.gamecp.business.gamedetail.component.f r100) {
        super(2, r100, com.bytedance.android.gamecp.business.gamedetail.component.f.class, "createWidget", "createWidget(ILcom/bytedance/ies/sve_list/SVEAdapter;)Lcom/bytedance/ies/sve_list/RecyclerViewItemWidget;", 0);
    }

    public final RecyclerViewItemWidget<? extends d0> invoke(int r100, SVEAdapter<d0, ?> r101) {
        Intrinsics.checkNotNullParameter(r101, "p2");
        return ((com.bytedance.android.gamecp.business.gamedetail.component.f) this.receiver).d(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ RecyclerViewItemWidget<? extends d0> invoke(Integer r100, SVEAdapter<d0, ?> r101) {
        return invoke(r100.intValue(), r101);
    }
}
