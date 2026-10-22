package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.livesdk.gift.model.h0;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.LiveGiftGroupComboViewNew;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftGroupItem;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.GroupWaveAnimationView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q extends BaseMVIListItem<GiftGroupItem, GiftAction> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f127876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f127877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f127878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LiveGiftGroupComboViewNew f127879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f127880p;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f127881a;

        public a(q r100) {
            this.f127881a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            q r101 = this.f127881a;
            r101.o(new ClickGroupItem(r101.p()));
        }
    }

    public static final class b {
    }

    static {
    }

    public q(View r100) {
        Intrinsics.checkNotNullParameter(r100, "inflateView");
        super(r100, new GiftGroupItem());
        this.f127876l = this.f41534j.findViewById(R.id.gift_group_bg);
        this.f127877m = (TextView) this.f41534j.findViewById(R.id.gift_group_count);
        this.f127878n = (TextView) this.f41534j.findViewById(R.id.gift_group_title);
        this.f127879o = (LiveGiftGroupComboViewNew) this.f41534j.findViewById(R.id.gift_group_combo_view);
        new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel.e();
        this.f41534j.setOnClickListener(new a(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r100, MVIState r110) {
        GiftGroupItem r111 = (GiftGroupItem) r110;
        Intrinsics.checkNotNullParameter(r100, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r111, "state");
        r0<GiftGroupItem, h0> r101 = r111.getGroupInfo();
        Object r102 = r100.f41740c.a(r101);
        Object r103 = null;
        if (r102 == null) goto L18;
        r100.f41739b.f41563a.invoke(r101);
        h0 r104 = (h0) r102;
        this.f127876l.setVisibility(0);
        this.f127877m.setVisibility(0);
        this.f41534j.setAlpha(0.4f);
        this.f127877m.setText(this.f41534j.getContext().getString(R.string.ttlive_live_gift_combo_toast_num, new Object[]{Integer.valueOf(r104.getGroupCount())}));
        boolean r105 = com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.b.a(r104.getGroupText());
        this.f127880p = r105;
        if (r105 == false) goto L7;
        this.f127878n.setVisibility(0);
        this.f127878n.setText(r104.getGroupText());
    L8:
        ViewGroup.LayoutParams r106 = this.f127877m.getLayoutParams();
        if ((r106 instanceof ConstraintLayout.LayoutParams) == true) goto L11;
        r106 = null;
    L11:
        ConstraintLayout.LayoutParams r107 = (ConstraintLayout.LayoutParams) r106;
        if (r107 == null) goto L18;
        r107.topToTop = 0;
        if (this.f127880p == false) goto L16;
        int r108 = -1;
    L17:
        r107.bottomToBottom = r108;
        goto L18
    L16:
        r108 = 0;
        goto L17
    L7:
        this.f127878n.setVisibility(8);
    L18:
        r0<GiftGroupItem, Integer> r112 = r111.getComboCount();
        Object r109 = r100.f41740c.a(r112);
        if (r109 == null) goto L40;
        r100.f41739b.f41563a.invoke(r112);
        if (((Number) r109).intValue() != 0) goto L31;
        LiveGiftGroupComboViewNew r113 = this.f127879o;
        r113.a();
        LottieAnimationView r114 = r113.f126683e;
        if (r114 == null) goto L25;
        r114.cancelAnimation();
    L25:
        GroupWaveAnimationView r115 = r113.f126684f;
        if (r115 == null) goto L28;
        r115.removeAllViews();
    L28:
        r113.f126680b = 0;
        this.f127879o.setVisibility(8);
        this.f127876l.setVisibility(0);
        this.f127877m.setVisibility(0);
        this.f41534j.setAlpha(1.0f);
        if (this.f127880p == false) goto L41;
        this.f127878n.setVisibility(0);
        return;
    L41:
        return;
    L31:
        Object r116 = this.f41534j.getContext().getSystemService("vibrator");
        if ((r116 instanceof Vibrator) == false) goto L35;
        r103 = r116;
    L35:
        Vibrator r117 = (Vibrator) r103;
        if (r117 == null) goto L38;
        r117.vibrate(50);
    L38:
        this.f127876l.setVisibility(8);
        this.f127877m.setVisibility(8);
        this.f127879o.setVisibility(0);
        this.f127878n.setVisibility(8);
        this.f41534j.setAlpha(1.0f);
        this.f127879o.b(new r(this, p()));
        return;
    }
}
