package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.NoneSymmetryDecoration;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowEveryoneTalkCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowEveryoneTalkCard extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECDraweeView f189899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f189900b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f189901c;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189899a = (ECDraweeView) findViewById(R.id.window_info_everyone_talk_title);
        this.f189901c = findViewById(R.id.window_info_everyone_talk_ic);
        this.f189900b = (RecyclerView) findViewById(R.id.window_info_everyone_talk_impression);
    }

    public WindowEveryoneTalkCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public final void R5(List<uq3.p> r110, final Function1<? super String, Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "impressionWords");
        RecyclerView r100 = this.f189900b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L5:
        r100.setAdapter(new WindowAutoScrollViewAdapter());
        RecyclerView r101 = this.f189900b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L8:
        r101.setLayoutManager(new ECWindowInfoLinearManager());
        RecyclerView r102 = this.f189900b;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L11:
        r102.addItemDecoration(new NoneSymmetryDecoration(getContext(), 0.0f, com.bytedance.android.shopping.extensions.b.b(4), 0.0f, WindowEveryoneTalkCard$initRecycleView$1.INSTANCE));
        RecyclerView r103 = this.f189900b;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L14:
        RecyclerView.Adapter r104 = r103.getAdapter();
        if (r104 == null) goto L28;
        WindowAutoScrollViewAdapter r105 = (WindowAutoScrollViewAdapter) r104;
        Function1<String, Unit> r106 = new WindowEveryoneTalkCard$initRecycleView$2(r111);
        Intrinsics.checkNotNullParameter(r110, "list");
        r105.f188178b = r106;
        ((ArrayList) r105.f188177a).clear();
        r105.notifyDataSetChanged();
        ((ArrayList) r105.f188177a).addAll(r110);
        r105.notifyItemRangeInserted(0, r110.size());
        RecyclerView r107 = this.f189900b;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L19:
        r107.post(new u(this, r110));
        View r112 = this.f189901c;
        if (r112 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException(SoloKtvContext.SOLO_PAGE_ENTRANCE);
    L22:
        r112.setOnClickListener(new s(r111));
        ECDraweeView r113 = this.f189899a;
        if (r113 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L25:
        r113.setOnClickListener(new t(r111));
        return;
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter");
    }
}
