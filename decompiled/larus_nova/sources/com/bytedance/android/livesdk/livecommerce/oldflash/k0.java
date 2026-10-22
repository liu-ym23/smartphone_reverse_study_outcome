package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class k0 extends BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RadioGroup f149623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f149624d;

    public static final class a implements RadioGroup.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f149625a;

        public a(j r100) {
            this.f149625a = r100;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public final void onCheckedChanged(RadioGroup r100, int r101) {
            if (r101 != R.id.rb_order) goto L5;
            this.f149625a.f149598d = 1;
            return;
        L5:
            this.f149625a.f149598d = 2;
        }
    }

    public k0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149623c = (RadioGroup) r100.findViewById(R.id.rg_stock_reduction);
        RadioButton r101 = (RadioButton) r100.findViewById(R.id.rb_order);
        RadioButton r102 = (RadioButton) r100.findViewById(R.id.rb_pay);
        this.f149624d = (TextView) r100.findViewById(R.id.tv_label);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public final void T3(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        if ((r100 instanceof j) == true) goto L5;
        r100 = null;
    L5:
        j r102 = (j) r100;
        if (r102 == null) goto L13;
        this.f149624d.setText(r102.f149573b);
        if (r102.f149598d != 1) goto L10;
        this.f149623c.check(R.id.rb_order);
    L11:
        this.f149623c.setOnCheckedChangeListener(new a(r102));
        return;
    L10:
        this.f149623c.check(R.id.rb_pay);
        goto L11
    }
}
