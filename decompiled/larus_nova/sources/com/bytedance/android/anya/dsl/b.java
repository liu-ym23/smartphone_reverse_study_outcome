package com.bytedance.android.anya.dsl;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.anya.AnyaDSL;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIRecyclerViewAdapter;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.i0;
import com.bytedance.android.anya.p;
import com.bytedance.android.anya.t0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes43.dex */
@AnyaDSL
public final class b<SUPER_STATE extends MVIState<?>, ITEM_STATE extends MVIState<?>, ITEM_ACTION extends p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<i0<SUPER_STATE>, SUPER_STATE, t0<SUPER_STATE, ITEM_STATE>> f41586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<ViewGroup, Integer, BaseMVIListItem<ITEM_STATE, ?>> f41587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f41588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Function2<? super ViewGroup, ? super Integer, ? extends BaseMVIListItem<ITEM_STATE, ITEM_ACTION>>, MVIRecyclerViewAdapter<ITEM_STATE>> f41589d;

    public b(Function2 r100, Function2 r101, RecyclerView r102, Function1 r103) {
        this.f41586a = r100;
        this.f41587b = r101;
        this.f41588c = r102;
        this.f41589d = r103;
    }
}
