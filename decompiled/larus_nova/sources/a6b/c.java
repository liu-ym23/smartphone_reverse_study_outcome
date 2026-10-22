package a6b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.utils.o0;
import com.larus.nova.R;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.CategoryTitleHolder;
import com.ss.android.lark.chat.message.menu.v2.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements e<zya.a, CategoryTitleHolder> {
    public c() {
    }

    @Override // a6b.e
    public final /* synthetic */ void b(j0 r100) {
    }

    @Override // a6b.e
    public final RecyclerView.ViewHolder a(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = o0.a(r100).inflate(R.layout.item_message_action_category_title, r100, false);
        Intrinsics.checkNotNull(r101);
        return new CategoryTitleHolder(r101);
    }

    @Override // a6b.e
    public final void c(RecyclerView.ViewHolder r100, zya.e r101) {
        CategoryTitleHolder r102 = (CategoryTitleHolder) r100;
        zya.a r103 = (zya.a) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "itemData");
        TextView r104 = r102.f415683a;
        r103.getClass();
        r104.setText(null);
    }
}
