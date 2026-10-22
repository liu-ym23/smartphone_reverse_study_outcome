package bh8;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.list.datasource.adapter.PagingAdapterKt$doOnScrollIdle$listener$1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d {
    public static void a(final RecyclerView r100, final Function0 r101) {
        final Function1 r102 = new c();
        Intrinsics.checkNotNullParameter(r102, "scrollIdle");
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r100 != null) goto L5;
    L8:
        r101.invoke();
        return;
    L5:
        if (((Boolean) r102.invoke(r100)).booleanValue() == true) goto L8;
        r100.addOnScrollListener(new PagingAdapterKt$doOnScrollIdle$listener$1(r102, r100, r101));
    }
}
