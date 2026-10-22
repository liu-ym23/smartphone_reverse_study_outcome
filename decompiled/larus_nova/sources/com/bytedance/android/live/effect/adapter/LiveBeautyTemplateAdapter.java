package com.bytedance.android.live.effect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.beauty.LiveBeautyTemplateDetailFragment;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyTemplateAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f66705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f66706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<o90.a> f66707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f66708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f66709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f66710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f66711g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/adapter/LiveBeautyTemplateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f66712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SimpleDraweeView f66713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f66714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f66715d;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f66712a = r100.findViewById(R.id.border);
            this.f66713b = (SimpleDraweeView) r100.findViewById(R.id.iv_bg);
            this.f66714c = (TextView) r100.findViewById(R.id.tv_name);
            this.f66715d = r100.findViewById(R.id.item_filter_dot);
        }
    }

    public static final class a {
    }

    public interface b {
        void onItemClick(int r100);
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f66707c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        o90.a r102 = (o90.a) ListProtector.get(this.f66707c, r110);
        String r103 = r102.f522430b;
        UrlModel r104 = r102.f522431c;
        boolean r105 = true;
        if (r110 != this.f66709e) goto L5;
        final boolean r106 = true;
    L6:
        View r107 = r101.f66712a;
        if (r106 == false) goto L9;
        int r108 = 0;
    L10:
        r107.setVisibility(r108);
        if (r106 == false) goto L13;
        r101.f66714c.setTextColor(this.f66708d.getResources().getColor(R.color.ttlive_effect_broadcast_beauty_new_style_selected));
    L15:
        if (r104.getUri() == null) goto L25;
        List<String> r109 = r104.getUrlList();
        if (r109 != null) goto L19;
    L22:
        if (r105 == true) goto L25;
        ImageModel r111 = new ImageModel();
        r111.setUri(r104.getUri());
        r111.setUrls(r104.getUrlList());
    L26:
        ImageLoader.bindImage(r101.f66713b, r111);
        r101.f66714c.setText(r103);
        r101.itemView.setOnClickListener(new i90.a(this, r110));
        r3.e(r101.itemView, new AnonymousClass2(r106, r101));
        return;
    L19:
        if (r109.isEmpty() == true) goto L22;
        r105 = false;
    L25:
        r111 = new ImageModel();
        r111.setUrls(CollectionsKt.listOf("https://lf9-effect-302.byteeffecttos.com/obj/ies.fe.effect/33c2f82e844b18d9255431322385bdb7"));
        goto L26
    L13:
        r101.f66714c.setTextColor(this.f66708d.getResources().getColor(R.color.ttlive_effect_broadcast_beauty_new_style_unselected));
        goto L15
    L9:
        r108 = 4;
        goto L10
    L5:
        r106 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(this.f66708d).inflate(this.f66705a, r100, false));
    }

    public LiveBeautyTemplateAdapter(Context r100, LiveBeautyTemplateDetailFragment.e r101, q90.b r102, LiveEffectContextFactoryDelegate$Type r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f66707c = new ArrayList();
        this.f66711g = true;
        this.f66708d = r100;
        this.f66706b = r103;
        this.f66709e = m90.b.f512545c.c(r103).intValue();
        this.f66710f = r101;
        int r104 = r102.f532069a;
        if (r104 != (-1)) goto L5;
        r104 = R.layout.ttlive_effect_item_live_filter_c;
    L5:
        this.f66705a = r104;
    }
}
