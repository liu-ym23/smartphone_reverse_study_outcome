package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.content.Context;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/e;", "data", "", "setDataWithAutoScroll", "", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/os/Handler;", "b", "Lkotlin/Lazy;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "InnerAdapter", "InnerSmoothScroller", "PlaceHolderViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionAutoRecycleView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f149892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f149893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InnerSmoothScroller f149894c;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "InnerViewHolder", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InnerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f149895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<e> f149896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InteractionAutoRecycleView f149897c;

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerAdapter$InnerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        public final class InnerViewHolder extends RecyclerView.ViewHolder {
            public InnerViewHolder(View r100) {
                Intrinsics.checkNotNullParameter(r100, "itemView");
                super(r100);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            if (((ArrayList) this.f149897c.f149892a).size() < 4) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L9;
            return Integer.MAX_VALUE;
        L9:
            return this.f149896b.size() + 1;
        L5:
            r100 = false;
            goto L6
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            if (r100 != 0) goto L5;
            return 0;
        L5:
            return this.f149895a;
        }

        public InnerAdapter(InteractionAutoRecycleView r100, List<e> r101) {
            Intrinsics.checkNotNullParameter(r101, "itemList");
            this.f149897c = r100;
            this.f149896b = r101;
            this.f149895a = 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "holder");
            if ((r110 instanceof InnerViewHolder) == false) goto L24;
            boolean r100 = true;
            if ((!this.f149896b.isEmpty()) == false) goto L25;
            if (r111 <= 0) goto L26;
            InnerViewHolder r112 = (InnerViewHolder) r110;
            e r113 = (e) ListProtector.get(this.f149896b, (r111 - 1) % this.f149896b.size());
            r112.getClass();
            Intrinsics.checkNotNullParameter(r113, MapController.ITEM_LAYER_TAG);
            View r101 = r112.itemView.findViewById(R.id.ll_avatar_container);
            List<String> r102 = r113.f149902c;
            if (r102 != null) goto L10;
        L16:
            TextView r114 = (TextView) r112.itemView.findViewById(R.id.tv_item);
            r114.setText(r113.f149901b);
            if (r113.getType() != 2) goto L19;
        L21:
            r100 = false;
        L22:
            r114.setSingleLine(r100);
            return;
        L19:
            if (r113.getType() == 1) goto L21;
        L10:
            if ((!r102.isEmpty()) == false) goto L15;
            ECDraweeView r103 = (ECDraweeView) r112.itemView.findViewById(R.id.iv_avatar_1);
            ECDraweeView r104 = (ECDraweeView) r112.itemView.findViewById(R.id.iv_avatar_2);
            h0.e(r103, (String) ListProtector.get(r102, 0), null, null, null, 120);
            if (r102.size() <= 1) goto L14;
            r104.setVisibility(0);
            r103.setTranslationZ(1.0f);
            h0.e((GenericDraweeView) r112.itemView.findViewById(R.id.iv_avatar_2), (String) ListProtector.get(r102, 1), null, null, null, 120);
            goto L16
        L14:
            r104.setVisibility(8);
            goto L16
        L15:
            r101.setVisibility(8);
            goto L16
        L26:
            return;
        L25:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 != 0) goto L7;
            View r102 = new View(this.f149897c.getContext());
            r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            Unit r103 = Unit.INSTANCE;
            return new PlaceHolderViewHolder(r102);
        L7:
            return new InnerViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.ec_explain_playback_interaction_item, r100, false));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$InnerSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InnerSmoothScroller extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final int getVerticalSnapPreference() {
            return 1;
        }

        public InnerSmoothScroller(Context r100) {
            super(r100);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics r100) {
            if (r100 != null) goto L6;
            return super.calculateSpeedPerPixel(r100);
        L6:
            return 300.0f / r100.densityDpi;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/interaction/InteractionAutoRecycleView$PlaceHolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class PlaceHolderViewHolder extends RecyclerView.ViewHolder {
        public PlaceHolderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    private final Handler getMHandler() {
        return (Handler) this.f149893b.getValue();
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return super.getTopFadingEdgeStrength();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMHandler().removeCallbacksAndMessages(null);
    }

    public InteractionAutoRecycleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        ArrayList r101 = new ArrayList();
        this.f149892a = r101;
        this.f149893b = LazyKt.lazy(InteractionAutoRecycleView$mHandler$2.INSTANCE);
        setLayoutManager(new LinearLayoutManager(r100));
        this.f149894c = new InnerSmoothScroller(r100);
        setAdapter(new InnerAdapter(this, r101));
        setVerticalFadingEdgeEnabled(true);
        setFadingEdgeLength(UtilityKotlinExtentionsKt.d(26));
        addItemDecoration(new InteractionAutoRecycleView$itemDecoration$1());
    }

    public static final /* synthetic */ Handler r(InteractionAutoRecycleView r100) {
        return r100.getMHandler();
    }

    public final void setDataWithAutoScroll(List<e> r100) {
        if (r100 == null) goto L8;
        ((ArrayList) this.f149892a).clear();
        ArrayList r101 = (ArrayList) this.f149892a;
        r101.addAll(r100);
        RecyclerView.Adapter r102 = getAdapter();
        if (r102 == null) goto L6;
        r102.notifyDataSetChanged();
    L6:
        ViewExtensionsKt.d(this);
        getMHandler().removeCallbacksAndMessages(null);
        c r103 = new c(this);
        getMHandler().postDelayed(r103, 500);
        return;
    }
}
