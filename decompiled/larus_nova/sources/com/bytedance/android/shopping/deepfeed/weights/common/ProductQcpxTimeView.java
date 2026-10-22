package com.bytedance.android.shopping.deepfeed.weights.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kk.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/weights/common/ProductQcpxTimeView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductQcpxTimeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProductTextView f174210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProductTextView f174211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f174212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f174213d;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProductQcpxTimeView f174214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f174215b;

        public final void a() {
            ProductQcpxTimeView r100 = this.f174214a;
            long r101 = r100.f174212c;
            if (r101 <= 1) goto L5;
            r100.f174212c = r101 - 1;
            r100.a();
            this.f174214a.postDelayed(this, 1000);
            return;
        L5:
            r100.f174210a.setText("已过期");
            this.f174214a.f174210a.setTextColor(qc3.a.d(this.f174215b, R.color.shopping_color_FF6682));
            this.f174214a.f174211b.setTextColor(qc3.a.d(this.f174215b, R.color.shopping_color_FF6682));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ProductQcpxTimeView r100, Context r101) {
            this.f174214a = r100;
            this.f174215b = r101;
        }
    }

    public ProductQcpxTimeView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ProductQcpxTimeView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        d.c(new ProductQcpxTimeView$updateCountdownText$1(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f174213d);
    }

    public ProductQcpxTimeView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ProductTextView r103 = new ProductTextView(r100, null, 6, 0);
        r103.setGravity(16);
        com.bytedance.android.shopping.deepfeed.ui.view.a r104 = com.bytedance.android.shopping.deepfeed.ui.view.a.f173924e;
        r103.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 12));
        r103.setTextColor(qc3.a.d(r100, R.color.shopping_color_FF003C));
        r103.setIncludeFontPadding(false);
        Unit r105 = Unit.INSTANCE;
        this.f174210a = r103;
        ProductTextView r106 = new ProductTextView(r100, null, 6, 0);
        r106.setGravity(16);
        r106.setTextSize(0, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 12));
        r106.setTextColor(qc3.a.d(r100, R.color.shopping_color_FF003C));
        r106.setIncludeFontPadding(false);
        this.f174211b = r106;
        this.f174213d = new a(this, r100);
        setOrientation(0);
        addView(r106, new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 16)));
        addView(r103, new LinearLayout.LayoutParams(-2, com.bytedance.android.shopping.deepfeed.ui.view.a.C2600a.a(r100, 16)));
    }

    public /* synthetic */ ProductQcpxTimeView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
