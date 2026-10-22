package com.bytedance.android.window.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowRecommendAndBoughtCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "getDoEventAction", "()Lkotlin/jvm/functions/Function0;", "setDoEventAction", "(Lkotlin/jvm/functions/Function0;)V", "doEventAction", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowRecommendAndBoughtCard extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f189936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f189937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f189938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f189939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f189940e;

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f189937b = (TextView) findViewById(R.id.ec_shop_recommend_name);
        this.f189938c = findViewById(R.id.user_bought_container);
        this.f189939d = (TextView) findViewById(R.id.ec_shop_bought_count);
        this.f189936a = findViewById(R.id.ec_shop_user_bought_empty);
    }

    public final Function0<Unit> getDoEventAction() {
        return this.f189940e;
    }

    public final void setDoEventAction(Function0<Unit> r100) {
        this.f189940e = r100;
    }

    public WindowRecommendAndBoughtCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
