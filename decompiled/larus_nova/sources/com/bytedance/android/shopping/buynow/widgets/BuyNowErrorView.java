package com.bytedance.android.shopping.buynow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.util.i;
import com.bytedance.android.shopping.buynow.starter.b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/widgets/BuyNowErrorView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/android/shopping/buynow/widgets/BuyNowErrorView$a;", "callback", "", "setCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowErrorView extends LinearLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f171240d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f171241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f171242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f171243c;

    public interface a {
        void a();

        void b();

        void onQuit();
    }

    public BuyNowErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BuyNowErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f171241a != null) goto L5;
        this.f171241a = new LinkedHashMap();
    L5:
        View r101 = this.f171241a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f171241a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "buyNowPageConfig");
        final com.bytedance.android.ecom.arch.slice.render.context.b r101 = r100.a();
        SimpleDraweeView r102 = (SimpleDraweeView) a(R.id.error_icon);
        ViewGroup.LayoutParams r103 = ((SimpleDraweeView) a(R.id.error_icon)).getLayoutParams();
        r103.height = SlcDimensExtensionsKt.a(80, r101);
        r103.width = Math.round(SlcDimensExtensionsKt.c(80, r101));
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        TextView r105 = (TextView) a(R.id.error_title);
        ViewGroup.LayoutParams r106 = ((TextView) a(R.id.error_title)).getLayoutParams();
        LinearLayout.LayoutParams r107 = null;
        if ((r106 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r106 = null;
    L5:
        LinearLayout.LayoutParams r108 = (LinearLayout.LayoutParams) r106;
        if (r108 == null) goto L8;
        r108.topMargin = SlcDimensExtensionsKt.a(8, r101);
    L9:
        r105.setLayoutParams(r108);
        i.e((TextView) a(R.id.error_title), 500);
        i.e((TextView) a(R.id.error_subtitle), 400);
        TextView r109 = (TextView) a(R.id.error_button);
        ViewGroup.LayoutParams r110 = ((TextView) a(R.id.error_button)).getLayoutParams();
        if ((r110 instanceof LinearLayout.LayoutParams) == true) goto L12;
        r110 = null;
    L12:
        LinearLayout.LayoutParams r111 = (LinearLayout.LayoutParams) r110;
        if (r111 == null) goto L15;
        r111.topMargin = SlcDimensExtensionsKt.a(40, r101);
        r111.width = SlcDimensExtensionsKt.a(165, r101);
        r111.height = SlcDimensExtensionsKt.a(44, r101);
        r107 = r111;
    L15:
        r109.setLayoutParams(r107);
        i.e((TextView) a(R.id.error_button), 500);
        ViewCompat.setBackground(a(R.id.error_button), com.bytedance.commerce.base.drawable.a.a(new BuyNowErrorView$adapterUIScale$4(this, r101)));
        return;
    L8:
        r108 = null;
        goto L9
    }

    public final void setCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f171242b = r100;
    }

    public BuyNowErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f171241a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.buynow_layout_net_error, this, true);
        setVisibility(8);
        setGravity(17);
        setOrientation(1);
    }

    public /* synthetic */ BuyNowErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
