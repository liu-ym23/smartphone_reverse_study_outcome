package com.bytedance.android.shopping.mall.homepage.card.headercard;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes13.dex */
public final class a extends ef3.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BtmData f177571j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f177572k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public HeaderCardData f177573l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f177574m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SkinConfig f177575n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CoroutineScope f177576o;

    public final SkinConfigStyle b() {
        if (this.f472419c == false) goto L7;
        SkinConfig r100 = this.f177575n;
        if (r100 != null) goto L12;
        return null;
    L12:
        return r100.getDark();
    L7:
        SkinConfig r101 = this.f177575n;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getLight();
    }

    @Override // ef3.a, ef3.b
    public final void onRelease() {
        super.onRelease();
        CoroutineScope r100 = this.f177576o;
        if (r100 == null) goto L6;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);
        return;
    }

    @Override // ef3.a, ef3.b
    public final void N2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        this.f177574m = r100;
        this.f177576o = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt.Job$default(null, 1, null)));
        super.N2(r100);
    }

    public a(Context r100, ECMallFeed r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mallFeed");
        Intrinsics.checkNotNullParameter(r102, "sceneID");
        super(r100, r101, r102);
        this.f177572k = "ec_na_mall_header";
    }
}
