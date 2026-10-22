package com.bytedance.android.shopping.card_list.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bytedance.android.ui.ec.widget.loading.ECPullRefreshView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/CardListRefreshHeadView;", "Landroid/widget/FrameLayout;", "", "getAnimState", "Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getSlogan", "()Lcom/bytedance/android/ui/ec/widget/loading/ECPullRefreshView;", "slogan", "", "b", "Z", "getLoading", "()Z", "setLoading", "(Z)V", "loading", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListRefreshHeadView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f171939c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f171941b;

    public static final class a {
    }

    public CardListRefreshHeadView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListRefreshHeadView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final ECPullRefreshView getSlogan() {
        return (ECPullRefreshView) this.f171940a.getValue();
    }

    public final int getAnimState() {
        return 0;
    }

    static {
        f171939c = com.bytedance.android.shopping.extensions.b.b(32);
    }

    public final void a() {
        if (this.f171941b == false) goto L5;
        return;
    L5:
        this.f171941b = true;
        getSlogan().setRefreshState(ECPullRefreshView.RefreshState.REFRESHING);
    }

    public final void b() {
        if (this.f171941b == true) goto L5;
        return;
    L5:
        this.f171941b = false;
        getSlogan().setRefreshState(ECPullRefreshView.RefreshState.PULL);
    }

    public final boolean getLoading() {
        return this.f171941b;
    }

    public final void setLoading(boolean r100) {
        this.f171941b = r100;
    }

    public CardListRefreshHeadView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f171940a = LazyKt.lazy(new CardListRefreshHeadView$slogan$2(this));
        th.a.c(r100, R.layout.ec_commerce_card_list_fixed_head_layout, this, true);
        b();
        this.f171941b = false;
        getSlogan().setRefreshState(ECPullRefreshView.RefreshState.PULL);
    }

    public /* synthetic */ CardListRefreshHeadView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
