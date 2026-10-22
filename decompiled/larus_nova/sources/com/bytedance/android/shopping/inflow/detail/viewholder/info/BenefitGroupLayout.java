package com.bytedance.android.shopping.inflow.detail.viewholder.info;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.c2;
import com.bytedance.android.ec.core.utils.l1;
import com.bytedance.android.shopping.extensions.b;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ld3.d;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/inflow/detail/viewholder/info/BenefitGroupLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ec/core/utils/l1$a;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BenefitGroupLayout extends FrameLayout implements l1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f176291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f176292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f176293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f176294d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onFinish() {
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onStart() {
    }

    public BenefitGroupLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f176294d = d.e(d.b());
        a(r100);
    }

    public final void a(Context r100) {
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r100).aU(R.layout.ec_commerce_benefit_layout, this, true);
        this.f176291a = (TextView) findViewById(R.id.tv_desc);
        this.f176292b = (ImageView) findViewById(R.id.iv_right_arrow);
        TextView r101 = this.f176291a;
        if (r101 == null) goto L5;
        se3.a.c(r101, 2, 12.0f);
    L5:
        ImageView r102 = this.f176292b;
        if (r102 == null) goto L9;
        se3.a.b(r102);
    L9:
        if (this.f176294d == false) goto L12;
        setPadding(b.b(4), b.b(4), b.b(4), b.b(4));
        return;
    }

    @Override // com.bytedance.android.ec.core.utils.l1.a
    public final void onTick(long r100) {
        int r101 = c2.f45564h;
        c2 r102 = c2.a.a(getContext(), r100, false);
        TextView r103 = this.f176291a;
        if (r103 == null) goto L10;
        String r104 = this.f176293c;
        if (r104 == null) goto L7;
        String r105 = String.format(r104, Arrays.copyOf(new Object[]{r102.f45567c, r102.f45568d, r102.f45569e}, 3));
    L8:
        r103.setText(r105);
        return;
    L7:
        r105 = null;
        goto L8
    }

    public BenefitGroupLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
        this.f176294d = d.e(d.b());
        a(r100);
    }

    public BenefitGroupLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101, r102);
        this.f176294d = d.e(d.b());
        a(r100);
    }
}
