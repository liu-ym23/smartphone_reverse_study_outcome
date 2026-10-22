package com.bytedance.android.livesdk.livecommerce.iron.listheader;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECFlagShipReputationView;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECNewReputationLayout;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.ECShopETAView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/iron/listheader/IronListHeaderTagLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IronListHeaderTagLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ECNewReputationLayout f148768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECFlagShipReputationView f148769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ListHeaderTagWidget f148770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ListHeaderTagWidget f148771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECShopETAView f148772e;

    public IronListHeaderTagLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IronListHeaderTagLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public IronListHeaderTagLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        th.a.c(r100, R.layout.ec_list_header_tag_layout, this, true);
        this.f148768a = (ECNewReputationLayout) findViewById(R.id.reputation_tag);
        this.f148769b = (ECFlagShipReputationView) findViewById(R.id.reputation_flagship);
        this.f148770c = (ListHeaderTagWidget) findViewById(R.id.tags_ll);
        this.f148771d = (ListHeaderTagWidget) findViewById(R.id.front_tags_ll);
        this.f148772e = (ECShopETAView) findViewById(R.id.eta_info);
    }

    public /* synthetic */ IronListHeaderTagLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
