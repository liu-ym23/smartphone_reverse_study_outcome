package com.bytedance.android.shopping.sameproduct.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.shopping.sameproduct.model.ECCommissionDialogInfo;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import jj4.a;
import jj4.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ld3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/sameproduct/widget/SameProductTitleView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductTitleView extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f182455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f182456b;

    public SameProductTitleView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getId() != R.id.ec_commerce_ic_commission_explaination) goto L57;
    L8:
        ECCommissionDialog r101 = new ECCommissionDialog(getContext());
        int r102 = f.f508690a;
        int r103 = f.a.f508691a;
        int r104 = w0.f45736a;
        Object r105 = (ECCommissionDialogInfo) w0.b("{\"title\":\"分佣说明\",\"content\":\"查看同款商品能力旨在促进用户成交，推荐的商品以联盟商品为主，并且靠前排序，成交后会同样给视频作者分佣。\",\"button_text\":\"我知道了\"}", ECCommissionDialogInfo.class);
        if (r105 == null) goto L23;
        int r106 = p.f45243a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L15
        b r108 = b.f499326b;     // Catch: Throwable -> L15
        Object r109 = a.a("same_product_commission_dialog_content", ECCommissionDialogInfo.class, r105, false);     // Catch: Throwable -> L15
        if (r109 != null) goto L21;
        Intrinsics.throwNpe();     // Catch: Throwable -> L15
    L21:
        ECCommissionDialogInfo r110 = (ECCommissionDialogInfo) r109;
        if (r110 == null) goto L23;
    L33:
        if (r110 == null) goto L58;
        TextView r111 = r101.f182452a;
        if (r111 == null) goto L37;
        r111.setText(r110.getTitle());
    L37:
        TextView r112 = r101.f182453b;
        if (r112 == null) goto L40;
        r112.setText(r110.getContent());
    L40:
        TextView r113 = r101.f182454c;
        if (r113 == null) goto L44;
        r113.setText(r110.getButtonText());
    L44:
        if (DialogLancet.shouldBlockDialogShow(r101) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r101);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
    L47:
        DialogLancet.beforeDialogShow(r101);
        r101.show();
        DialogLancet.afterDialogShow(r101);
        return;
    L58:
        return;
    L15:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Object r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r115) == true) goto L20;
        r105 = r115;
    L20:
        r109 = r105;
    L23:
        int r116 = p.f45243a;
        Object r117 = null;
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L26
        b r119 = b.f499326b;     // Catch: Throwable -> L26
        Object r120 = a.a(" same_product_commission_dialog_content", ECCommissionDialogInfo.class, null, false);     // Catch: Throwable -> L26
    L32:
        r110 = (ECCommissionDialogInfo) r120;
    L26:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Object r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r122) == true) goto L31;
        r117 = r122;
    L31:
        r120 = r117;
        goto L32
    L57:
        return;
    L4:
        if (r100.getId() == R.id.ec_commerce_tv_commission) goto L8;
        goto L5
    }

    public SameProductTitleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.ec_commerce_same_product_title, this);
        TextView r102 = (TextView) findViewById(R.id.ec_commerce_tv_commission);
        this.f182455a = r102;
        View r103 = findViewById(R.id.ec_commerce_ic_commission_explaination);
        this.f182456b = r103;
        r102.setOnClickListener(this);
        r103.setOnClickListener(this);
    }
}
