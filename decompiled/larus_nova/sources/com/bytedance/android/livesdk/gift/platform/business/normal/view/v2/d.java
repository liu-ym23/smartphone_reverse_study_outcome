package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.gift.platform.core.utils.GiftNitaViewInfo;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fy1.a f129969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f129970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AsyncLayoutInflater f129971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Typeface f129972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<GiftNitaViewInfo, ArrayList<View>> f129973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f129974f;

    public static final class a {
    }

    public static final class b implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f129975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GiftNitaViewInfo f129976b;

        public b(d r100, GiftNitaViewInfo r101) {
            this.f129975a = r100;
            this.f129976b = r101;
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final /* synthetic */ void onCancel(int r100) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            d r103 = this.f129975a;
            if (r103.f129970b == true) goto L6;
            jy0.b.c("GiftTrayPreInflateService", "service not alive", null, 4);
            return;
        L6:
            ArrayList<View> r104 = r103.f129973e.get(this.f129976b);
            if (r104 != null) goto L9;
            return;
        L9:
            if (r104.size() >= 2) goto L11;
            r104.add(r100);
            jy0.b.c("GiftTrayPreInflateService", "async inflate success " + this.f129976b, null, 4);
            return;
        L11:
            jy0.b.c("GiftTrayPreInflateService", "async inflate success but cache is already full: " + this.f129976b, null, 4);
        }
    }

    static {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        this.f129970b = true;
        this.f129971c = new AsyncLayoutInflater(this.f129974f);
        this.f129973e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3, new ArrayList());
        this.f129973e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V3_PK, new ArrayList());
        this.f129973e.put(GiftNitaViewInfo.TTLIVE_VIEW_GIFT_NORMAL_V2_LANDSCAPE_SPLIT, new ArrayList());
        jy0.b.c("GiftTrayPreInflateService", "jank opt config: " + this.f129969a, null, 4);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f129973e.clear();
        this.f129972d = null;
        this.f129970b = false;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f129974f = r100;
        this.f129969a = (fy1.a) com.bytedance.android.livesdk.gift.platform.business.e.f129018d.getValue(null, com.bytedance.android.livesdk.gift.platform.business.e.f129015a[2]);
        this.f129973e = new HashMap();
    }

    public final Typeface a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Typeface r101 = this.f129972d;
        if (r101 == null) goto L11;
        return r101;
    L11:
        this.f129972d = Typeface.createFromAsset(r100.getAssets(), "font/ttlive_base_gift_combo_opt_font.ttf");     // Catch: Exception -> L7
    L10:
        return this.f129972d;
    L7:
        e = move-exception;
        e.printStackTrace();
        jy0.b.c("GiftTrayPreInflateService", "load font asset exception: " + e.getMessage(), null, 4);
        goto L10
    }

    public final void d(GiftNitaViewInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "viewInfo");
        ArrayList<View> r101 = this.f129973e.get(r100);
        if (r101 != null) goto L7;
        jy0.b.c("GiftTrayPreInflateService", "unsupported type: " + r100, null, 4);
        return;
    L7:
        if (r101.size() < 2) goto L10;
        jy0.b.c("GiftTrayPreInflateService", "cache is already full: " + r100, null, 4);
        return;
    L10:
        AsyncLayoutInflater r102 = this.f129971c;
        if (r102 == null) goto L14;
        r102.inflate(r100.getResId(), new LinearLayout(this.f129974f), new b(this, r100));
        return;
    }

    public final void c(ViewGroup r100, GiftNitaViewInfo r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "viewInfo");
        ArrayList<View> r102 = this.f129973e.get(r101);
        if (r102 != null) goto L5;
    L8:
        jy0.b.c("initTrayView no cache, do normal inflate", null, null, 6);
        LayoutInflater.from(r100.getContext()).inflate(r101.getResId(), r100);
        return;
    L5:
        if ((!r102.isEmpty()) != true) goto L8;
        r100.addView((View) ListProtector.remove(r102, 0));
    }
}
