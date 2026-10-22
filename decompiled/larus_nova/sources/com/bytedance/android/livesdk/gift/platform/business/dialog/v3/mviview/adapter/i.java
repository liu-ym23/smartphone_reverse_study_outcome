package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.animation.ObjectAnimator;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.anya.BaseMVIListItem;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.r0;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickBuffCard;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftAction;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.GiftBuffCardItem;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class i extends BaseMVIListItem<GiftBuffCardItem, GiftAction> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TextView f127846l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HSImageView f127847m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HSImageView f127848n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f127849o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final HSImageView f127850p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ImageView f127851q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f127852r;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f127853a;

        public a(i r100) {
            this.f127853a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            i r101 = this.f127853a;
            r101.o(new ClickBuffCard(r101.p()));
        }
    }

    @Override // com.bytedance.android.anya.BaseMVIView
    public final void i() {
        Disposable r100 = this.f127852r;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "inflateView");
        super(r100, new GiftBuffCardItem());
        this.f127846l = (TextView) this.f41534j.findViewById(R.id.buff_card_price);
        this.f127847m = (HSImageView) this.f41534j.findViewById(R.id.selected_view);
        this.f127848n = (HSImageView) this.f41534j.findViewById(R.id.gift_buff_bg);
        this.f127849o = (TextView) this.f41534j.findViewById(R.id.buff_time_text);
        this.f127850p = (HSImageView) this.f41534j.findViewById(R.id.buff_sweep_light_view);
        this.f127851q = (ImageView) this.f41534j.findViewById(R.id.buff_lock_icon);
        this.f41534j.setOnClickListener(new a(this));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.bytedance.android.anya.BaseMVIView
    public final void b(com.bytedance.android.anya.k r110, MVIState r111) {
        GiftBuffCardItem r112 = (GiftBuffCardItem) r111;
        Intrinsics.checkNotNullParameter(r110, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r112, "state");
        r0<GiftBuffCardItem, Boolean> r100 = r112.getSelected();
        Object r101 = r110.f41740c.a(r100);
        if (r101 == null) goto L8;
        r110.f41739b.f41563a.invoke(r100);
        if (((Boolean) r101).booleanValue() == false) goto L7;
        ViewUtilsKt.f(this.f127847m);
        this.f127850p.setVisibility(8);
        goto L8
    L7:
        ViewUtilsKt.e(this.f127847m);
    L8:
        r0<GiftBuffCardItem, l1> r102 = r112.getBuffInfo();
        Object r103 = r110.f41740c.a(r102);
        if (r103 == null) goto L36;
        r110.f41739b.f41563a.invoke(r102);
        l1 r104 = (l1) r103;
        ImageLoader.bindImage(this.f127848n, r104.getBgImg());
        com.bytedance.android.livesdk.gift.model.i r105 = r104.getLockInfo();
        if (r105 == null) goto L15;
        if (r105.getLocked() != true) goto L15;
    L17:
        this.f127850p.setVisibility(8);
    L18:
        String r106 = r104.getText();
        this.f127846l.setText(r106);
        if (TextUtils.isEmpty(r106) == true) goto L21;
        this.f127846l.setTextColor(ColorProtector.parseColor(r104.getTextColor()));
    L21:
        View r107 = this.f41534j;
        com.bytedance.android.livesdk.gift.model.i r108 = r104.getLockInfo();
        if (r108 != null) goto L24;
    L27:
        float r109 = 1.0f;
    L28:
        r107.setAlpha(r109);
        ImageView r113 = this.f127851q;
        com.bytedance.android.livesdk.gift.model.i r114 = r104.getLockInfo();
        if (r114 != null) goto L31;
    L34:
        int r115 = 8;
    L35:
        r113.setVisibility(r115);
        goto L36
    L31:
        if (r114.getLocked() != true) goto L34;
        r115 = 0;
        goto L35
    L24:
        if (r108.getLocked() != true) goto L27;
        r109 = 0.5f;
    L15:
        if (r104.getSweepLightImg() == null) goto L17;
        ImageLoader.bindImage(this.f127850p, r104.getSweepLightImg());
    L36:
        r0<GiftBuffCardItem, Pair<Long, Long>> r116 = r112.getExpireTime();
        Object r117 = r110.f41740c.a(r116);
        if (r117 == null) goto L50;
        r110.f41739b.f41563a.invoke(r116);
        Pair r118 = (Pair) r117;
        long r119 = ((Number) r118.getFirst()).longValue();
        long r120 = (r119 - System.currentTimeMillis()) - ((Number) r118.getSecond()).longValue();
        if (r119 != 0) goto L41;
        this.f127849o.setVisibility(8);
    L43:
        if (r120 >= 0) goto L45;
        String r121 = s1.B(R.string.ttlive_gift_buff_offline_hint);
    L49:
        this.f127849o.setText(r121);
        goto L50
    L45:
        long r122 = u0.f91003j.f91006a;
        if (r120 >= r122) goto L48;
        r121 = s1.C(R.string.ttlive_gift_buff_offline_hint_hour, new Object[]{Integer.valueOf((int) (r120 / u0.f91002i.f91006a))});
        goto L49
    L48:
        r121 = s1.C(R.string.ttlive_gift_buff_offline_hint_day, new Object[]{Integer.valueOf((int) (r120 / r122))});
        goto L49
    L41:
        this.f127849o.setVisibility(0);
    L50:
        r0<GiftBuffCardItem, Boolean> r123 = r112.getShowAnim();
        Object r124 = r110.f41740c.a(r123);
        if (r124 == null) goto L60;
        r110.f41739b.f41563a.invoke(r123);
        if (((Boolean) r124).booleanValue() == false) goto L61;
        Disposable r125 = this.f127852r;
        if (r125 == null) goto L58;
        r125.dispose();
    L58:
        ObjectAnimator r126 = ObjectAnimator.ofFloat(this.f127850p, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{s1.f(-74.0f), s1.f(171.0f)});
        Ref.IntRef r127 = new Ref.IntRef();
        r127.element = 0;
        r126.setDuration(700);
        r126.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f));
        this.f127850p.setVisibility(0);
        com.bytedance.android.live.core.utils.rxutils.j.a r128 = com.bytedance.android.live.core.utils.rxutils.j.f66356a;
        this.f127852r = com.bytedance.android.live.core.utils.rxutils.j.a(0, 500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this, r127, r126));
        r126.start();
        return;
    L61:
        return;
    }
}
