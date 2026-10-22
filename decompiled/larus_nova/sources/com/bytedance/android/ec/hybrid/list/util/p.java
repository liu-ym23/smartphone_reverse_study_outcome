package com.bytedance.android.ec.hybrid.list.util;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public interface p {
    boolean a(BaseViewHolder r100, int r101, int r102, int r103);

    void b(Function1<? super BaseViewHolder, Unit> r100);

    boolean c(BaseViewHolder r100, float r101);

    void d();

    Pair<Integer, Integer> e(RecyclerView.LayoutManager r100);

    BaseViewHolder f(int r100);

    List<BaseViewHolder> g();

    boolean h(BaseViewHolder r100);
}
