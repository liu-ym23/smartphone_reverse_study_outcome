package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.widget.ECAutoScaleLayout;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public class l0 extends BaseViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f149629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f149630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f149631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ECAutoScaleLayout f149632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f149633g;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l0 f149634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f149635b;

        public a(l0 r100, b r101) {
            this.f149634a = r100;
            this.f149635b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveFlashViewModel r101 = this.f149634a.f149510a;
            if (r101 == null) goto L8;
            MutableLiveData<b> r102 = r101.getItemClickObserver();
            if (r102 == null) goto L9;
            r102.setValue(this.f149635b);
            return;
        L9:
            return;
        }
    }

    public l0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149629c = r100.findViewById(R.id.iv_right_arrow);
        this.f149630d = (TextView) r100.findViewById(R.id.tv_label);
        this.f149631e = (TextView) r100.findViewById(R.id.tv_content);
        ECAutoScaleLayout r101 = (ECAutoScaleLayout) r100.findViewById(R.id.layout_content_info);
        this.f149632f = r101;
        this.f149633g = (TextView) r100.findViewById(R.id.tv_content_info);
        this.f149511b = r100.findViewById(R.id.view_error_line);
        r101.setScaleType(1);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.BaseViewHolder
    public void T3(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        String r102 = "";
        ViewGroup.LayoutParams r103 = null;
        int r104 = 0;
        if ((r100 instanceof k) == false) goto L13;
        this.itemView.setPadding(0, 0, 0, 0);
        View r105 = this.f149629c;
        k r106 = (k) r100;
        if (r106.f149622p == false) goto L7;
        int r107 = 8;
    L8:
        r105.setVisibility(r107);
        this.f149630d.setText(r106.f149573b);
        TextView r108 = this.f149631e;
        String r109 = r106.f149613g;
        if (r109 == null) goto L11;
        r102 = r109;
    L11:
        r108.setText(r102);
        this.f149631e.setHint(r106.f149621o);
        this.f149632f.setVisibility(8);
        U3(r106.a());
        this.itemView.setOnClickListener(new a(this, r100));
    L25:
        ViewGroup.LayoutParams r110 = this.f149631e.getLayoutParams();
        if ((r110 instanceof ConstraintLayout.LayoutParams) == false) goto L29;
        r103 = r110;
    L29:
        ConstraintLayout.LayoutParams r111 = (ConstraintLayout.LayoutParams) r103;
        if (r111 != null) goto L32;
        return;
    L32:
        if (this.f149632f.getVisibility() == 8) goto L35;
        r104 = -2;
    L35:
        ((ViewGroup.MarginLayoutParams) r111).width = r104;
        this.f149631e.setLayoutParams(r111);
        return;
    L7:
        r107 = 0;
        goto L8
    L13:
        if ((r100 instanceof h) == false) goto L25;
        LiveFlashViewModel r112 = this.f149510a;
        if (r112 != null) goto L17;
    L19:
        this.itemView.setPadding(0, 0, 0, 0);
    L20:
        this.f149629c.setVisibility(8);
        h r113 = (h) r100;
        this.f149630d.setText(r113.f149573b);
        this.f149631e.setText(r113.f149591c);
        this.f149631e.setHint("");
        if (TextUtils.isEmpty(r113.f149592d) == true) goto L23;
        this.f149633g.setText(r113.f149592d);
        this.f149632f.setVisibility(0);
    L24:
        U3(false);
        this.itemView.setOnClickListener(null);
        goto L25
    L23:
        this.f149632f.setVisibility(8);
        goto L24
    L17:
        if (r112.checkIsBarCodeItem(r101 - 1) != true) goto L19;
        this.itemView.setPadding(0, (int) UtilityKotlinExtentionsKt.c(30), 0, 0);
        goto L20
    }
}
