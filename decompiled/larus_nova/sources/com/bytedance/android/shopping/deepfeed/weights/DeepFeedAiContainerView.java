package com.bytedance.android.shopping.deepfeed.weights;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.shopping.deepfeed.ui.view.DeepFeedTypewriterTextView;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DeepFeedAiAdapter", "DeepFeedAiHeaderViewHolder", "DeepFeedAiViewHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedAiContainerView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f174014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f174015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DeepFeedAiAdapter f174016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DeepFeedTypewriterTextView f174017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f174018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f174019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LottieAnimationView f174020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f174021i;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f174022a;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return 0;
        }

        public DeepFeedAiAdapter() {
            this.f174022a = 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemViewType(int r100) {
            return this.f174022a;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "holder");
            if ((r101 - 1) >= 0) goto L5;
            return;
        L5:
            if ((r100 instanceof DeepFeedAiViewHolder) == true) goto L7;
            r100 = null;
        L7:
            DeepFeedAiViewHolder r102 = (DeepFeedAiViewHolder) r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            if (r101 == 1) goto L5;
            View r102 = th.a.c(r100.getContext(), R.layout.shopping_deep_feed_ai_item_view, r100, false);
            r102.setBackgroundResource(R.drawable.shopping_deep_feed_ai_item_bg);
            return new DeepFeedAiViewHolder(r102);
        L5:
            return new DeepFeedAiHeaderViewHolder(th.a.c(r100.getContext(), R.layout.shopping_deep_feed_ai_header_item_view, r100, false));
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiHeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiHeaderViewHolder extends RecyclerView.ViewHolder {
        public DeepFeedAiHeaderViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/DeepFeedAiContainerView$DeepFeedAiViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DeepFeedAiViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppCompatTextView f174023a;

        public DeepFeedAiViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
            this.f174023a = (AppCompatTextView) r100.findViewById(R.id.deep_feed_ai_item_text);
        }
    }

    public DeepFeedAiContainerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedAiContainerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        Iterator<T> r100 = this.f174021i.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        if (((String) r100.next()).length() <= 0) goto L4;
        goto L4
    L9:
        this.f174021i.clear();
    }

    public DeepFeedAiContainerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f174013a = "正在努力为你寻找 ";
        this.f174014b = " ...";
        this.f174016d = new DeepFeedAiAdapter();
        int r103 = com.bytedance.android.ec.base.settings.a.f42813a;
        Object r104 = Boolean.TRUE;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L166
        Object r106 = null;
        Object r107 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L57
        if (r107 != null) goto L9;
    L54:
        Object r108 = null;
    L55:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L57
    L59:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L166
        if (r110 == null) goto L63;
        EnsureManager.ensureNotReachHere(r110);     // Catch: Throwable -> L166
    L63:
        if (Result.m9455isFailureimpl(r109) == false) goto L66;
        r109 = null;
    L66:
        if ((r109 instanceof Boolean) == true) goto L68;
        r109 = null;
    L68:
        Object r111 = (Boolean) r109;     // Catch: Throwable -> L166
        if (r111 != null) goto L75;
        Object r112 = com.bytedance.android.ec.base.settings.d.f42816a.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L166
        if ((r112 instanceof Boolean) == true) goto L74;
        r112 = null;
    L74:
        r111 = (Boolean) r112;     // Catch: Throwable -> L166
    L75:
        if (r111 != null) goto L175;
        int r113 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L166
        Object r114 = com.bytedance.android.ec.base.settings.d.f42818c.get("mall_deep_feed_ai_event_fix");     // Catch: Throwable -> L130
        if (r114 != null) goto L82;
    L127:
        Object r115 = null;
    L128:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L130
    L132:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L156
        if (r117 == null) goto L136;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L156
    L136:
        if (Result.m9455isFailureimpl(r116) == false) goto L139;
        r116 = null;
    L139:
        if ((r116 instanceof Boolean) == true) goto L141;
        r116 = null;
    L141:
        r111 = (Boolean) r116;     // Catch: Throwable -> L156
        if (r111 != null) goto L164;
        IHybridHostService r118 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L156
        if (r118 == null) goto L147;
        Object r119 = r118.getHostABValue("mall_deep_feed_ai_event_fix", r104);     // Catch: Throwable -> L156
    L148:
        if (r119 != null) goto L150;
    L155:
        r111 = r104;
        goto L164
    L150:
        if ((r119 instanceof Boolean) == false) goto L153;
        r106 = r119;
    L153:
        Object r120 = (Boolean) r106;     // Catch: Throwable -> L156
        if (r120 == null) goto L155;
    L163:
        r111 = r120;
        goto L164
    L147:
        r119 = null;
    L164:
        com.bytedance.android.ec.base.settings.d.d("mall_deep_feed_ai_event_fix", r111);     // Catch: Throwable -> L166
        goto L175
    L82:
        if ((r114 instanceof Boolean) == true) goto L84;
        Object r121 = null;
    L85:
        r115 = (Boolean) r121;     // Catch: Throwable -> L130
        if (r115 != null) goto L128;
        if ((r114 instanceof Number) == false) goto L115;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L97;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L130
        if ((r122 instanceof Boolean) == true) goto L95;
        r122 = null;
    L95:
        r115 = (Boolean) r122;     // Catch: Throwable -> L130
        goto L128
    L97:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L103;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L130
        if ((r123 instanceof Boolean) == true) goto L101;
        r123 = null;
    L101:
        r115 = (Boolean) r123;     // Catch: Throwable -> L130
        goto L128
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L109;
        Integer r124 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L130
        if ((r124 instanceof Boolean) == true) goto L107;
        r124 = null;
    L107:
        r115 = (Boolean) r124;     // Catch: Throwable -> L130
        goto L128
    L109:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L115;
        Long r125 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L130
        if ((r125 instanceof Boolean) == true) goto L113;
        r125 = null;
    L113:
        r115 = (Boolean) r125;     // Catch: Throwable -> L130
    L115:
        if ((r114 instanceof JSONObject) == false) goto L117;
    L183:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L123
        Object r126 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Boolean.class);     // Catch: Throwable -> L123
        if ((r126 instanceof Boolean) == true) goto L121;
        r126 = null;
    L121:
        Object r127 = Result.m9449constructorimpl((Boolean) r126);     // Catch: Throwable -> L123
    L125:
        r115 = r127;
        if (Result.m9455isFailureimpl(r115) == false) goto L128;
    L123:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L130
        r127 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        goto L125
    L117:
        if ((r114 instanceof JSONArray) == false) goto L127;
    L84:
        r121 = r114;
    L156:
        th = move-exception;
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L166
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
        Throwable r130 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L166
        if (r130 == null) goto L161;
        EnsureManager.ensureNotReachHere(r130);     // Catch: Throwable -> L166
    L161:
        if (Result.m9455isFailureimpl(r120) == false) goto L163;
        r120 = r104;
    L130:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L156
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L156
    L175:
        boolean r132 = ((Boolean) r111).booleanValue();
        ViewGroup.inflate(r100, R.layout.shopping_deepfeed_product_under_ai, this);
        RecyclerView r133 = (RecyclerView) findViewById(R.id.deep_feed_ai_rec_list);
        this.f174015c = r133;
        this.f174017e = (DeepFeedTypewriterTextView) findViewById(R.id.deep_feed_ai_write_view);
        this.f174018f = (ImageView) findViewById(R.id.deep_feed_ai_icon_when_write);
        this.f174019g = (ViewGroup) findViewById(R.id.deep_feed_ai_write_layout);
        LottieAnimationView r134 = (LottieAnimationView) findViewById(R.id.deep_feed_ai_rec_lottie);
        this.f174020h = r134;
        int r135 = ed3.a.f472196a;
        Intrinsics.checkNotNullParameter(r134, "lottieView");
        r134.setAnimation("deep_feed_ai_under_lottie_bg.json");
        r133.setAdapter(this.f174016d);
        r133.setLayoutManager(new LinearLayoutManager(r100, 0, false));
        boolean r136 = ECServiceManager.f42805a;
        if (((IECHostService) ECServiceManager.c(IECHostService.class)).getRecommendStatus() == true) goto L178;
        r133.setPadding(com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
    L178:
        if (r132 == false) goto L181;
        r133.addOnChildAttachStateChangeListener(new DeepFeedAiContainerView$onShowReport$1(this));
    L181:
        this.f174021i = new LinkedHashSet();
        return;
    L9:
        if ((r107 instanceof Boolean) == true) goto L11;
        Object r137 = null;
    L12:
        r108 = (Boolean) r137;     // Catch: Throwable -> L57
        if (r108 != null) goto L55;
        if ((r107 instanceof Number) == false) goto L42;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r138 = Float.valueOf(((Number) r107).floatValue());     // Catch: Throwable -> L57
        if ((r138 instanceof Boolean) == true) goto L22;
        r138 = null;
    L22:
        r108 = (Boolean) r138;     // Catch: Throwable -> L57
        goto L55
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r139 = Double.valueOf(((Number) r107).doubleValue());     // Catch: Throwable -> L57
        if ((r139 instanceof Boolean) == true) goto L28;
        r139 = null;
    L28:
        r108 = (Boolean) r139;     // Catch: Throwable -> L57
        goto L55
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L36;
        Integer r140 = Integer.valueOf(((Number) r107).intValue());     // Catch: Throwable -> L57
        if ((r140 instanceof Boolean) == true) goto L34;
        r140 = null;
    L34:
        r108 = (Boolean) r140;     // Catch: Throwable -> L57
        goto L55
    L36:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L42;
        Long r141 = Long.valueOf(((Number) r107).longValue());     // Catch: Throwable -> L57
        if ((r141 instanceof Boolean) == true) goto L40;
        r141 = null;
    L40:
        r108 = (Boolean) r141;     // Catch: Throwable -> L57
    L42:
        if ((r107 instanceof JSONObject) == false) goto L44;
    L191:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L50
        Object r142 = SDKSettingsCacheManager.a().fromJson(r107.toString(), Boolean.class);     // Catch: Throwable -> L50
        if ((r142 instanceof Boolean) == true) goto L48;
        r142 = null;
    L48:
        Object r143 = Result.m9449constructorimpl((Boolean) r142);     // Catch: Throwable -> L50
    L52:
        r108 = r143;
        if (Result.m9455isFailureimpl(r108) == false) goto L55;
    L50:
        th = move-exception;
        Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L57
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L57
        goto L52
    L44:
        if ((r107 instanceof JSONArray) == false) goto L54;
    L11:
        r137 = r107;
    L57:
        th = move-exception;
        Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L166
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L166
    L166:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        Object r147 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r148 = Result.m9452exceptionOrNullimpl(r147);
        if (r148 == null) goto L171;
        EnsureManager.ensureNotReachHere(r148);
    L171:
        if (Result.m9455isFailureimpl(r147) == true) goto L174;
        r104 = r147;
    L174:
        r111 = r104;
        goto L175
    }

    public /* synthetic */ DeepFeedAiContainerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
