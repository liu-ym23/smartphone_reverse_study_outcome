package com.bytedance.android.window.shop.holder.footer;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowFooterStatusView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f187969d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f187970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f187971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f187972c;

    private final LoadMoreStatusView getStatusView() {
        return (LoadMoreStatusView) this.f187971b.getValue();
    }

    private final Unit getSubViewInitializer() {
        return (Unit) this.f187972c.getValue();
    }

    public final CharSequence getNoMoreContent() {
        return this.f187970a;
    }

    public WindowFooterStatusView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setMinimumHeight(r100.getResources().getDimensionPixelSize(R.dimen.ec_shopwindow_footer_loading_height) + (r100.getResources().getDimensionPixelSize(R.dimen.ec_shopwindow_footer_loading_vertical_margin) * 2));
        this.f187970a = r100.getText(R.string.ec_shop_footer_no_more_content);
        this.f187971b = LazyKt.lazy(new WindowFooterStatusView$statusView$2(this));
        this.f187972c = LazyKt.lazy(new WindowFooterStatusView$subViewInitializer$2(this));
    }

    public static final void a(WindowFooterStatusView r100) {
        r100.getClass();
        int r101 = com.bytedance.android.shopping.extensions.b.b(12);
        r100.setPadding(0, r101, 0, r101);
        r100.addView(r100.getStatusView(), new FrameLayout.LayoutParams(-1, -2));
    }

    public final void b(np3.d r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        getSubViewInitializer();
        FooterStatus r101 = r100.f520038a;
        int r102 = c.f187977a[r101.ordinal()];
        if (r102 != 1) goto L5;
        getStatusView().a();
        return;
    L5:
        if (r102 != 2) goto L7;
        getStatusView().b();
        return;
    L7:
        if (r102 != 3) goto L15;
        getStatusView().d();
        return;
    }

    public final void setNoMoreContent(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f187970a = r100;
    }
}
