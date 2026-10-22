package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.module;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.ab.d;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ll.a;
import w83.i;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/module/PromotionCardExternalView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardExternalView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LivePromotionCardArgsV2 f150689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lazy<? extends i> f150690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f150691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f150692d;

    public PromotionCardExternalView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromotionCardExternalView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        LivePromotionCardArgsV2 r102 = this.f150689a;
        if (r102 == null) goto L7;
        ILivePromotionCardContainerHandler r103 = r102.f150038b;
        if (r103 == null) goto L7;
        r103.h(Decision.IS_IN_SPLIT_SCREEN);
    L7:
        d.a();
    }

    public PromotionCardExternalView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ PromotionCardExternalView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
