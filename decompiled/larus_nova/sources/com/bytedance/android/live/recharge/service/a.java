package com.bytedance.android.live.recharge.service;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revenue.common.u;
import com.bytedance.android.livesdk.event.v;
import com.bytedance.android.livesdkapi.eventbus.ReOpenRechargeEvent;
import com.bytedance.android.scope.o;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yz0.m;
import zg1.x2;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements o, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f90348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.k f90349b;

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.service.a$a, reason: collision with other inner class name */
    public static final class C1388a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f90350a;

        public C1388a(a r100) {
            this.f90350a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Object r101 = ((ReOpenRechargeEvent) r100).getExtra();
            if ((r101 instanceof x2) == false) goto L9;
            x2 r102 = (x2) r101;
            if (r102.f572005n == false) goto L7;
            this.f90350a.d(r102);
            return;
        L7:
            this.f90350a.c(r102);
            return;
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // yz0.m
    public final void onViewReady() {
    }

    @Override // yz0.m
    public final void onWidgetLoaded() {
    }

    @Override // yz0.m
    public final void x() {
    }

    private final Context getContext() {
        return this.f90349b.getContext();
    }

    @Override // yz0.m
    public final void i() {
        this.f90348a.add(xs2.b.a().b(ReOpenRechargeEvent.class).subscribe(new C1388a(this)));
        CompositeDisposable r100 = this.f90348a;
        Observable r101 = xs2.b.a().b(x2.class);
        b r102 = new b(this);
        c r103 = c.f90352a;
        r100.add(r101.subscribe(r102, r103));
        this.f90348a.add(xs2.b.a().b(v.class).subscribe(new b(this), r103));
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f90348a.clear();
    }

    public a(yz0.k r100) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        this.f90349b = r100;
        this.f90348a = new CompositeDisposable();
    }

    public final void c(x2 r310) {
        String r100 = r310.f572006o;
        if (r100 != null) goto L5;
    L12:
        r100 = "live_detail";
    L13:
        String r101 = r100;
        String r102 = r310.f571995d;
        if (TextUtils.equals(r310.f571994c, "gift_guide") == false) goto L16;
        String r110 = "guide";
    L18:
        if (TextUtils.equals(r310.f571994c, "gift_guide") == false) goto L20;
        String r111 = NotificationCompat.CATEGORY_CALL;
    L21:
        long r103 = r310.f571998g;
        if (r103 <= 0) goto L24;
        boolean r112 = true;
    L25:
        int r113 = r310.f571997f;
        long r104 = r310.f571999h;
        int r105 = r310.f572001j;
        long r106 = r310.f572000i;
        long r107 = r310.f572002k;
        if (TextUtils.isEmpty(r310.f572003l) == true) goto L28;
        String r210 = r310.f572003l;
    L29:
        Map<String, String> r114 = r310.f572008q;
        if (r114 == null) goto L33;
        Map r115 = MapsKt.toMutableMap(r114);
        if (r115 == null) goto L33;
    L34:
        com.bytedance.android.live.recharge.model.d r108 = new com.bytedance.android.live.recharge.model.d(true, r102, r101, r103, r112, r113, 0, r110, r111, new com.bytedance.android.live.recharge.model.b(null, r210, r107, r106, r104, r105, new com.bytedance.android.live.recharge.model.a(r115), 129), null, r310.f572007p, null, 29760);
        IRechargeService r109 = (IRechargeService) jc1.k.n(IRechargeService.class);
        Context r116 = getContext();
        if (r116 == null) goto L63;
        r109.showRechargeDialogFragment((FragmentActivity) r116, r108, null);
        int r117 = com.bytedance.android.live.recharge.utils.m.f90492a;
        String r118 = r310.f572009r;
        if (r118 != null) goto L39;
        String r119 = "";
    L40:
        String r120 = r310.f572006o;
        if (r120 != null) goto L43;
        String r121 = "";
    L44:
        String r122 = r310.f571993b;
        if (r122 != null) goto L47;
        String r123 = "";
    L48:
        String r124 = r310.f571995d;
        if (r124 != null) goto L51;
        String r125 = "";
    L52:
        long r126 = r310.f571998g;
        long r127 = r310.f571999h;
        long r128 = r310.f572000i;
        int r129 = r310.f571997f;
        String r130 = r310.f572007p;
        if (r130 != null) goto L55;
        String r131 = "";
    L56:
        String r132 = r310.f572010s;
        if (r132 != null) goto L59;
        String r133 = "";
    L60:
        com.bytedance.android.live.recharge.utils.m.n(r119, r121, r123, r125, r126, r127, r128, r129, r131, r133, null, 3072);
        return;
    L59:
        r133 = r132;
        goto L60
    L55:
        r131 = r130;
        goto L56
    L51:
        r125 = r124;
        goto L52
    L47:
        r123 = r122;
        goto L48
    L43:
        r121 = r120;
        goto L44
    L39:
        r119 = r118;
        goto L40
    L63:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L33:
        r115 = new LinkedHashMap();
        goto L34
    L28:
        r210 = "";
        goto L29
    L24:
        r112 = false;
        goto L25
    L20:
        r111 = "";
        goto L21
    L16:
        r110 = "";
        goto L18
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r134 = true;
    L8:
        if (r134 == true) goto L11;
        r100 = null;
    L11:
        if (r100 != null) goto L13;
    L7:
        r134 = false;
        goto L8
    }

    public final void d(x2 r100) {
        String r101 = (String) com.bytedance.android.live.recharge.util.g.f90432c.getValue(null, com.bytedance.android.live.recharge.util.g.f90430a[1]);
        if (TextUtils.isEmpty(r101) == true) goto L6;
        HashMap r102 = new HashMap();
        r102.put("previous_gift_id", String.valueOf(r100.f571999h));
        r102.put("previous_gift_money", String.valueOf(r100.f572000i));
        r102.put("previous_pay_money", String.valueOf(r100.f572002k));
        r102.put("money_diff", String.valueOf(r100.f571998g));
        r102.put("previous_gift_type", r100.f572003l.toString());
        r102.put(DyVerifyReqConstants.Value.DIAMOND, String.valueOf(r100.f572004m));
        r102.put("is_protrait", String.valueOf(this.f90349b.isPortraitInteraction()));
        String r103 = u.a(r101, r102);
        ((zz0.g) com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class)).S2(getContext(), r103);
        return;
    }

    public static final void a(a r100, x2 r101) {
        r100.getClass();
        if (r101 == null) goto L21;
        int r102 = r101.getType();
        if (r102 == 0) goto L17;
        if (r102 == 1) goto L17;
        if (r102 != 2) goto L24;
        wh6.a r103 = (wh6.a) vh6.c.b(wh6.a.class);
        Context r104 = r100.getContext();
        if (r104 == null) goto L15;
        r103.openWallet((Activity) r104);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L24:
        return;
    L17:
        if (r101.f572005n == false) goto L19;
        r100.d(r101);
        return;
    L19:
        r100.c(r101);
        return;
    }
}
