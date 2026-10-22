package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.apm.util.u;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/ECCartErrorView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/View$OnClickListener;", "Lcom/bytedance/android/shopping/new_cart/widgets/ECCartErrorView$a;", "callback", "", "setCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartErrorView extends ConstraintLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f179443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f179444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f179445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CartLinkedScrollViewV2 f179446d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f179447e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f179448f;

    public interface a {
        void a();

        void b();

        void onBack();
    }

    public ECCartErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECCartErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        int r101 = r100.getId();
        if (r101 != R.id.iv_back) goto L8;
        a r102 = this.f179444b;
        if (r102 == null) goto L18;
        r102.onBack();
        return;
    L18:
        return;
    L8:
        if (r101 != R.id.tv_retry) goto L13;
        a r103 = this.f179444b;
        if (r103 == null) goto L20;
        r103.a();
        return;
    L20:
        return;
    L13:
        if (r101 != R.id.tv_advice) goto L22;
        a r104 = this.f179444b;
        if (r104 == null) goto L23;
        r104.b();
        return;
    L23:
        return;
    }

    public final void setCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f179444b = r100;
    }

    public ECCartErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Handler r103 = new Handler(Looper.getMainLooper());
        this.f179443a = r103;
        View r104 = LayoutInflater.from(r100).inflate(R.layout.new_ec_cart_layout_error, this, true);
        this.f179448f = r104;
        View r105 = LayoutInflater.from(r100).inflate(R.layout.ec_cart_error_view, this, false);
        this.f179447e = r105;
        ImageView r106 = null;
        if (r104 == null) goto L5;
        CartLinkedScrollViewV2 r107 = (CartLinkedScrollViewV2) r104.findViewById(R.id.linked_scroll_view);
    L6:
        this.f179446d = r107;
        if (r107 == null) goto L9;
        r107.setTopView(r105);
    L9:
        int r108 = com.bytedance.ies.xbridge.base.utils.c.f249457a;
        int r109 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        if (r104 == null) goto L12;
        View r110 = r104.findViewById(R.id.rl_bar);
    L13:
        this.f179445c = r110;
        if (r110 == null) goto L17;
        r110.setPadding(0, r109, 0, 0);
    L17:
        if (r105 == null) goto L21;
        TextView r111 = (TextView) r105.findViewById(R.id.tv_retry);
        if (r111 == null) goto L21;
        bg3.a r112 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r111, "button", r111.getText().toString(), false);
        Unit r113 = Unit.INSTANCE;
    L22:
        if (r111 == null) goto L24;
        r111.setOnClickListener(this);
    L24:
        if (r104 == null) goto L26;
        r106 = (ImageView) r104.findViewById(R.id.iv_back);
    L26:
        if (r106 == null) goto L28;
        bg3.a r114 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r106, "button", "返回", false);
    L28:
        Unit r115 = Unit.INSTANCE;
        if (r106 == null) goto L31;
        r106.setOnClickListener(this);
    L31:
        if (r104 == null) goto L35;
        TextView r116 = (TextView) r104.findViewById(R.id.err_title);
        if (r116 == null) goto L35;
        bg3.a r117 = com.bytedance.android.shopping.new_cart.utils.a.f179357a;
        com.bytedance.android.shopping.new_cart.utils.a.h(r116, "text", r116.getText().toString(), true);
    L35:
        setBackgroundColor(ColorProtector.parseColor("#F5F6F9"));
        c r118 = new c(this);
        if (u.a() == false) goto L38;
        r118.run();
        return;
    L38:
        r103.post(r118);
        return;
    L21:
        r111 = null;
        goto L22
    L12:
        r110 = null;
        goto L13
    L5:
        r107 = null;
        goto L6
    }

    public /* synthetic */ ECCartErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
