package a6b;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.ContentMessageActionViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends a {
    @Override // a6b.a
    public final int d() {
        return R.layout.item_message_action_container_grid;
    }

    @Override // a6b.a
    public final String e() {
        return "GridContentAdapterBinder";
    }

    public d() {
    }

    @Override // a6b.a, a6b.e
    public final /* bridge */ /* synthetic */ void c(RecyclerView.ViewHolder r100, zya.e r101) {
        f((ContentMessageActionViewHolder) r100, (zya.b) r101);
    }

    @Override // a6b.a
    public final void f(ContentMessageActionViewHolder r100, zya.b r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, "itemData");
        super.f(r100, r101);
        zya.c r102 = r101.f573997l;
        if (r102 != null) goto L5;
        return;
    L5:
        r100.f415687d.setTextSize(r102.f574000a);
    }
}
