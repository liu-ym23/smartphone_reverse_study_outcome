package a6b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.SpaceViewHolder;
import com.ss.android.lark.chat.message.menu.v2.j0;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i implements e<zya.h, SpaceViewHolder> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // a6b.e
    public final /* synthetic */ void b(j0 r100) {
    }

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = new View(r100.getContext());
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(12.0f)));
        return new SpaceViewHolder(r101);
    }

    @Override // a6b.e
    public final void c(RecyclerView.ViewHolder r100, zya.e r101) {
        SpaceViewHolder r102 = (SpaceViewHolder) r100;
        zya.h r103 = (zya.h) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "itemData");
        View r104 = r102.itemView;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L7;
        r105.height = UIUtils.dp2px(r102.itemView.getContext(), r103.f574003b);
        r104.setLayoutParams(r105);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }
}
