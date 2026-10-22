package com.bytedance.android.live.effect.avadjust.lens;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLensAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k90.a> f66859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f66860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f66861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SparseArray<Boolean> f66862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f66863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f66864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f66865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66866h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public AbsSmallItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$AbsSmallItemViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveSmallItemViewHolder extends AbsSmallItemViewHolder {

        public static final class a {
        }

        static {
        }

        public LiveSmallItemViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public interface a {
        void a(k90.a r100);
    }

    public static final class b implements LiveSmallItemBeautyHelper.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLensAdapter f66867a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f66868a;

            public a(b r100) {
                this.f66868a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f66868a.f66867a.notifyDataSetChanged();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void onError() {
        }

        public b(LiveLensAdapter r100) {
            this.f66867a = r100;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r100) {
            Intrinsics.checkNotNullParameter(r100, "sticker");
            ((Handler) this.f66867a.f66863e.getValue()).post(new a(this));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f66859a).size();
    }

    public LiveLensAdapter(int r100, LiveEffectContextFactoryDelegate$Type r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f66865g = r100;
        this.f66866h = r101;
        this.f66859a = new ArrayList();
        this.f66860b = -1;
        this.f66862d = new SparseArray();
        this.f66863e = LazyKt.lazy(LiveLensAdapter$handler$2.INSTANCE);
        this.f66864f = new b(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        if ((r100 instanceof AbsSmallItemViewHolder) == false) goto L23;
        AbsSmallItemViewHolder r102 = (AbsSmallItemViewHolder) r100;
        k90.a r103 = (k90.a) ListProtector.get(this.f66859a, r101);
        if (this.f66860b != r101) goto L7;
        r102.itemView.findViewById(R.id.border).setVisibility(0);
        ((TextView) r102.itemView.findViewById(R.id.tv_name)).setTextColor(r102.itemView.getContext().getResources().getColor(R.color.ttlive_effect_broadcast_preview_beauty_item_text_color));
    L9:
        if (r103.f502138a <= 0) goto L14;
        r102.itemView.findViewById(R.id.item_change_tips).setVisibility(0);
        if (this.f66860b != r101) goto L13;
        r102.itemView.findViewById(R.id.item_change_tips).setBackgroundResource(R.drawable.ttlive_effect_ic_filter_red_point);
    L15:
        TextView r104 = (TextView) r102.itemView.findViewById(R.id.tv_name);
        r103.getClass();
        r104.setText(null);
        if (r103.getType() != 1) goto L19;
        r103.getClass();
        r103.getClass();
    L21:
        r102.itemView.setOnClickListener(new com.bytedance.android.live.effect.avadjust.lens.a(this, r102));
        return;
    L19:
        if (r103.getType() != 0) goto L21;
        ((HSImageView) r102.itemView.findViewById(R.id.iv_bg)).setActualImageResource(R.drawable.ttlive_effect_ic_anti_shake);
        ((ImageView) r102.itemView.findViewById(R.id.iv_loading)).setVisibility(8);
        goto L21
    L13:
        r102.itemView.findViewById(R.id.item_change_tips).setBackgroundResource(R.drawable.ttlive_effect_ic_filter_white_point);
        goto L15
    L14:
        r102.itemView.findViewById(R.id.item_change_tips).setVisibility(8);
        goto L15
    L7:
        this.f66862d.put(r101, Boolean.FALSE);
        r102.itemView.findViewById(R.id.border).setVisibility(4);
        ((TextView) r102.itemView.findViewById(R.id.tv_name)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return new LiveSmallItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(this.f66865g, r100, false));
    }
}
