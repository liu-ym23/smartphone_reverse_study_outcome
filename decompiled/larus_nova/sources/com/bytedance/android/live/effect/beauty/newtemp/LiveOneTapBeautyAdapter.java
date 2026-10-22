package com.bytedance.android.live.effect.beauty.newtemp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.r3;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOneTapBeautyAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f67357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveEffectContextFactoryDelegate$Type f67358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<o90.a> f67359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f67360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f67361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f67362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f67363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f67364h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/newtemp/LiveOneTapBeautyAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f67365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f67366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SimpleDraweeView f67367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f67368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f67369e;

        public ViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            super(r100);
            this.f67365a = -1;
            this.f67366b = r100.findViewById(R.id.border);
            this.f67367c = (SimpleDraweeView) r100.findViewById(R.id.iv_bg);
            this.f67368d = (TextView) r100.findViewById(R.id.tv_name);
            this.f67369e = r100.findViewById(R.id.item_filter_dot);
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
        return ((ArrayList) this.f67359c).size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r100) {
        ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        super.onViewAttachedToWindow(r101);
        int r102 = r101.f67365a;
        if (r102 == (-1)) goto L8;
        o90.a r103 = (o90.a) ListProtector.get(this.f67359c, r102);
        if (this.f67364h.contains(r103.f522432d) == true) goto L9;
        this.f67364h.add(r103.f522432d);
        ALogger.i("LiveOneTapBeautyAdapter", "show item = " + r103.f522430b + ' ' + r103.f522432d + ", position = " + r102);
        y2(true, r103, r102);
        return;
    L9:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r110) {
        final ViewHolder r101 = (ViewHolder) r100;
        Intrinsics.checkNotNullParameter(r101, "holder");
        boolean r102 = false;
        if (r110 != 0) goto L5;
        a1.m(r101.itemView, UtilityKotlinExtentionsKt.i(0));
    L7:
        if (r110 != (getItemCount() - 1)) goto L9;
        a1.n(r101.itemView, UtilityKotlinExtentionsKt.i(22));
    L10:
        r101.f67365a = r110;
        o90.a r103 = (o90.a) ListProtector.get(this.f67359c, r110);
        String r104 = r103.f522430b;
        UrlModel r105 = r103.f522431c;
        if (r110 != this.f67361e) goto L13;
        final boolean r106 = true;
    L14:
        View r107 = r101.f67366b;
        if (r106 == false) goto L17;
        int r108 = 0;
    L18:
        r107.setVisibility(r108);
        if (r106 == false) goto L21;
        r101.f67368d.setTextColor(this.f67360d.getResources().getColor(R.color.ttlive_effect_broadcast_beauty_new_style_selected));
    L23:
        if (r105.getUri() == null) goto L32;
        List<String> r109 = r105.getUrlList();
        if (r109 != null) goto L27;
    L28:
        r102 = true;
    L29:
        if (r102 == true) goto L32;
        ImageModel r111 = new ImageModel();
        r111.setUri(r105.getUri());
        r111.setUrls(r105.getUrlList());
    L33:
        ImageLoader.bindImage(r101.f67367c, r111);
        r101.f67368d.setText(r104);
        r101.itemView.setOnClickListener(new com.bytedance.android.live.effect.beauty.newtemp.b(this, r110));
        r3.e(r101.itemView, new AnonymousClass2(r106, r101));
        return;
    L27:
        if (r109.isEmpty() == false) goto L29;
    L32:
        r111 = new ImageModel();
        r111.setUrls(CollectionsKt.listOf("https://lf9-effect-302.byteeffecttos.com/obj/ies.fe.effect/33c2f82e844b18d9255431322385bdb7"));
        goto L33
    L21:
        r101.f67368d.setTextColor(this.f67360d.getResources().getColor(R.color.ttlive_effect_broadcast_beauty_new_style_unselected));
        goto L23
    L17:
        r108 = 4;
        goto L18
    L13:
        r106 = false;
        goto L14
    L9:
        a1.n(r101.itemView, UtilityKotlinExtentionsKt.i(0));
        goto L10
    L5:
        a1.m(r101.itemView, UtilityKotlinExtentionsKt.i(22));
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new ViewHolder(LayoutInflater.from(this.f67360d).inflate(this.f67357a, r100, false));
    }

    public static void y2(boolean r100, o90.a r101, int r102) {
        HashMap r103 = new HashMap();
        r103.put("position", String.valueOf(r102 + 1));
        r103.put("beauty_effect_name", r101.f522430b);
        r103.put("beauty_effect_id", r101.f522432d);
        IUserService r104 = (IUserService) k.f(IUserService.class);
        if (r104 == null) goto L8;
        com.bytedance.android.livesdk.user.f r105 = r104.user();
        if (r105 == null) goto L8;
        String r106 = r105.n();
        if (r106 == null) goto L8;
    L9:
        r103.put("anchor_id", r106);
        if (r100 == false) goto L12;
        String r107 = "livesdk_live_takepage_beauty_effect_show";
    L13:
        u.l().sendLog(r107, r103, new Object[0]);
        return;
    L12:
        r107 = "livesdk_live_takepage_beauty_effect_select";
    L8:
        r106 = "0";
        goto L9
    }

    public LiveOneTapBeautyAdapter(Context r100, LiveOneTapBeautyListFragment.d r101, q90.b r102, LiveEffectContextFactoryDelegate$Type r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter(r103, "type");
        this.f67359c = new ArrayList();
        this.f67363g = true;
        this.f67364h = new LinkedHashSet();
        this.f67360d = r100;
        this.f67358b = r103;
        this.f67361e = m90.b.f512545c.c(r103).intValue();
        this.f67362f = r101;
        int r104 = r102.f532069a;
        if (r104 != (-1)) goto L5;
        r104 = R.layout.ttlive_effect_item_live_filter_c;
    L5:
        this.f67357a = r104;
    }
}
