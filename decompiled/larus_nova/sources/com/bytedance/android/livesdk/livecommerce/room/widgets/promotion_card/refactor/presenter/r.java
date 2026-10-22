package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPopExtendInfo;
import com.bytedance.android.ec.model.response.ExtendInfoContent;
import com.bytedance.android.ec.model.response.ExtendInfoHeader;
import com.bytedance.android.ec.model.response.ExtendInfoRow;
import com.bytedance.android.ec.model.response.ExtendInfoTable;
import com.bytedance.android.ec.model.response.ExtendInfoTopContent;
import com.bytedance.android.ec.model.response.d0;
import com.bytedance.android.ecom.arch.slice.render.SlcFlexDirection;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class r extends p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public s f152476g;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f152477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c f152478b;

        public b(r r100, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r101) {
            this.f152477a = r100;
            this.f152478b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            pk2.d r101 = (pk2.d) r100;
            if (r101.f529590b != 0) goto L7;
            ((ViewGroup) this.f152477a.w().f()).removeAllViews();
            r r102 = this.f152477a;
            s r103 = r102.f152476g;
            if (r103 == null) goto L7;
            ((ViewGroup) r102.w().f()).removeCallbacks(r103);
        L7:
            ECPopExtendInfo r104 = r101.f529589a;
            if (r104 == null) goto L28;
            List<ExtendInfoContent> r105 = r104.getContent();
            if (r105 == null) goto L29;
            boolean r106 = true;
            if ((!r105.isEmpty()) == true) goto L15;
            r105 = null;
        L15:
            if (r105 != null) goto L17;
            return;
        L17:
            if (r101.f529590b != 2) goto L31;
            this.f152477a.w().g(0);
            r r107 = this.f152477a;
            ExtendInfoTopContent r108 = r101.f529589a.getTopContent();
            if (r108 == null) goto L25;
            List<com.bytedance.android.ec.model.live.b> r109 = r108.getContent();
            if (r109 == null) goto L25;
            if ((!r109.isEmpty()) != true) goto L25;
        L26:
            r.E(r107, 0, r105, r106);
            return;
        L25:
            r106 = false;
            goto L26
        L31:
            return;
        L29:
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f152479a;

        public c(TextView r100) {
            this.f152479a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f152479a.setGravity(8388629);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public r() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L6;
        r101.getCardExtendInfoState().b(r100.getLifecycleOwner(), new b(this, r100));
        return;
    }

    public final TextView G(String r100) {
        TextView r101 = new TextView(u().c());
        r101.setText(r100);
        r101.setTextSize(2, 10.0f);
        r101.setTextColor(-16777216);
        r101.setGravity(8388627);
        r101.setEllipsize(null);
        r101.setMaxLines(1);
        r101.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        return r101;
    }

    public final LinearLayout F(String r110, String r111, boolean r112) {
        LinearLayout r100 = new LinearLayout(u().c());
        r100.setOrientation(0);
        r100.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(21)));
        r100.setGravity(16);
        RelativeLayout r101 = new RelativeLayout(u().c());
        o0.c(r101, GravityCompat.START);
        r101.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        TextView r113 = G(r110);
        if (r112 == false) goto L5;
        r113.setTextColor(th.a.a(u().c(), R.color.shopping_color_73000000));
    L5:
        ViewGroup.LayoutParams r102 = r113.getLayoutParams();
        if (r102 == null) goto L17;
        ((RelativeLayout.LayoutParams) r102).addRule(20, -1);
        Unit r103 = Unit.INSTANCE;
        r101.addView(r113);
        r100.addView(r101);
        int r114 = UtilityKotlinExtentionsKt.d(8);
        TextView r104 = new TextView(u().c());
        r104.setLayoutParams(new LinearLayout.LayoutParams(r114, 0));
        r100.addView(r104);
        RelativeLayout r115 = new RelativeLayout(u().c());
        o0.c(r115, GravityCompat.END);
        r115.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        TextView r116 = G(r111);
        if (r112 == false) goto L10;
        r116.setTextColor(th.a.a(u().c(), R.color.shopping_color_73000000));
    L10:
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        if (r117 == null) goto L15;
        ((RelativeLayout.LayoutParams) r117).addRule(21, -1);
        r116.post(new c(r116));
        r115.addView(r116);
        r100.addView(r115);
        return r100;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }

    public static final void E(r r110, int r111, List r112, boolean r113) {
        ViewGroup r100 = (ViewGroup) r110.w().f();
        ExtendInfoContent r101 = (ExtendInfoContent) CollectionsKt.getOrNull(r112, r111);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getType() == 1) goto L7;
        ECExceptionMonitor.c("Unsupported type: " + r101.getType());
        return;
    L7:
        View r102 = (View) CollectionsKt.lastOrNull(com.bytedance.commerce.base.view.b.a(r100));
        ExtendInfoTable r103 = r101.getTable();
        LinearLayout r104 = new LinearLayout(r110.u().c());
        r104.setOrientation(1);
        r104.setBackgroundColor(-1);
        r104.setPadding(UtilityKotlinExtentionsKt.d(8), 0, UtilityKotlinExtentionsKt.d(8), 0);
        if (r103 == null) goto L12;
        ExtendInfoHeader r105 = r103.getHeader();
        if (r105 == null) goto L12;
        LinearLayout r106 = r110.F(r105.getName(), r105.getValue(), true);
        r106.setTag("header");
        r104.addView(r106);
    L12:
        LinearLayout r107 = new LinearLayout(r110.u().c());
        r107.setOrientation(1);
        r107.setTag(SlcFlexDirection.FLEX_ROW);
        if (r103 == null) goto L23;
        List<ExtendInfoRow> r108 = r103.getRows();
        if (r108 == null) goto L23;
        Iterator<T> r109 = r108.iterator();
        int r114 = 0;
    L18:
        if (r109.hasNext() == false) goto L23;
        Object r115 = r109.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        ExtendInfoRow r117 = (ExtendInfoRow) r115;
        r107.addView(r110.F(r117.getName(), r117.getValue(), false));
        r114 = r116;
    L23:
        r104.addView(r107);
        r100.addView(r104);
        if (r111 != 0) goto L26;
        r104.setTranslationY(r100.getHeight());
        r104.animate().translationY(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
    L29:
        r110.f152476g = new s(r100, r110, r112, r111, r113);
        ((ViewGroup) r110.w().f()).postDelayed(r110.f152476g, r101.getDuration());
        final d0 r118 = r101.getTrackInfo();
        if (r118 == null) goto L38;
        ExplainCardViewModel r119 = r110.f152468e;
        String r120 = r118.a();
        ExplainCardViewModel r121 = r110.f152468e;
        if (r121 == null) goto L36;
        QLiveData<ECUIPromotion> r122 = r121.getPromotionState();
        if (r122 == null) goto L36;
        ECUIPromotion r123 = r122.a();
    L37:
        UtilityKotlinExtentionsKt.g(r119, r120, r123, new ExtendContentPresenter$handleContentExpose$1$1(r118));
    L36:
        r123 = null;
    L38:
        ExplainCardViewModel r124 = r110.f152468e;
        if (r124 == null) goto L53;
        QLiveData<ECUIPromotion> r125 = r124.getPromotionState();
        if (r125 == null) goto L54;
        ECUIPromotion r126 = r125.a();
        if (r126 == null) goto L55;
        ql.b r127 = r126.getClientData();
        if (r127 == null) goto L56;
        r127.f533700i = r101;
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L26:
        r104.setTranslationX(r100.getWidth());
        r104.animate().translationX(0.0f).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
        if (r102 == null) goto L29;
        r102.animate().translationX(-r100.getWidth()).setInterpolator(new FastOutSlowInInterpolator()).setDuration(500).start();
        goto L29
    }
}
