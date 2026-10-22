package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.PromotionCardInfoLineContainer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardInfoComponent;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "arg", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setContainerAbility", "", "getInfoAreaContentDescription", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardInfoComponent extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PromotionCardInfoLineContainer> f150537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LivePromotionCardArgsV2 f150538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150539c;

    public PromotionCardInfoComponent(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PromotionCardInfoComponent(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final String getInfoAreaContentDescription() {
        StringBuilder r100 = new StringBuilder();
        Iterator<T> r101 = this.f150537a.iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        r100.append(((PromotionCardInfoLineContainer) r101.next()).getLineContentDescription());
        goto L4
    L7:
        return r100.toString();
    }

    public final void setArgument(LivePromotionCardArgsV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "arg");
        this.f150538b = r100;
    }

    public final void setContainerAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "ability");
        this.f150539c = r100;
    }

    public PromotionCardInfoComponent(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f150537a = new ArrayList();
    }

    public /* synthetic */ PromotionCardInfoComponent(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
