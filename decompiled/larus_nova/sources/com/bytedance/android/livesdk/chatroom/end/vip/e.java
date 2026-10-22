package com.bytedance.android.livesdk.chatroom.end.vip;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.end.vip.models.RestartLiveStatus;
import com.bytedance.android.livesdk.chatroom.end.vip.view.CountDownProgressView;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.larus.nova.R;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VipLiveEndService f106142a;

    public e(VipLiveEndService r100) {
        this.f106142a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Pair r101 = (Pair) r100;
        ug1.a r102 = (ug1.a) r101.component1();
        Boolean r103 = (Boolean) r101.component2();
        if (r103.booleanValue() == false) goto L22;
        if (r102.f549982a != RestartLiveStatus.WAITING) goto L22;
        View r104 = this.f106142a.f106127b;
        if (r104 == null) goto L9;
        UtilityKotlinExtentionsKt.t(r104);
    L9:
        CountDownProgressView r105 = this.f106142a.f106130e;
        if (r105 == null) goto L12;
        UtilityKotlinExtentionsKt.w(r105);
    L12:
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r106.setDuration(((Long) this.f106142a.f106132g.getValue()).longValue() * 1000);
        r106.addUpdateListener(new c(this));
        RxUtilKt.c(Disposables.fromAction(new d(r106)), this.f106142a.f106137l);
        r106.start();
        TextView r107 = this.f106142a.f106128c;
        if (r107 == null) goto L15;
        r107.setText(s1.B(R.string.ttlive_vip_end_anchor_preparing));
    L15:
        SpannableString r108 = new SpannableString(s1.C(R.string.ttlive_vip_end_predict_count_text, new Object[]{(Long) this.f106142a.f106132g.getValue()}));
        r108.setSpan(new ForegroundColorSpan(-1), 2, 4, 33);
        TextView r109 = this.f106142a.f106129d;
        if (r109 == null) goto L18;
        r109.setText(r108);
    L18:
        Function1<? super String, Unit> r110 = this.f106142a.f106126a;
        if (r110 == null) goto L70;
        Unit r111 = r110.invoke(s1.B(R.string.ttlive_vip_end_last_live_end_title));
        return;
    L70:
        return;
    L22:
        if (r103.booleanValue() == false) goto L30;
        if (r102.f549982a != RestartLiveStatus.STREAMING) goto L30;
        View r112 = this.f106142a.f106127b;
        if (r112 == null) goto L28;
        UtilityKotlinExtentionsKt.t(r112);
    L28:
        VipLiveEndService r113 = this.f106142a;
        long r114 = r102.f549983b;
        r113.getClass();
        Bundle r115 = new Bundle();
        ILiveOntologyInfoManager r116 = ((IMiddlewareLiveService) k.n(IMiddlewareLiveService.class)).getLiveOntologyRecord();
        String r117 = r116.getEnterFromMerge();
        String r118 = r116.getEnterMethod();
        r115.putString("enter_from_merge", r117);
        r115.putString("enter_method", r118);
        r115.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_VIP_BACK_PRE_ROOM_ENABLE, false);
        Unit r119 = Unit.INSTANCE;
        xs2.b.a().post(new JumpToOtherRoomEvent(r114, r115));
        return;
    L30:
        if (r103.booleanValue() == true) goto L46;
        if (r102.f549982a != RestartLiveStatus.WAITING) goto L46;
        View r120 = this.f106142a.f106127b;
        if (r120 == null) goto L36;
        UtilityKotlinExtentionsKt.w(r120);
    L36:
        Function1<? super String, Unit> r121 = this.f106142a.f106126a;
        if (r121 == null) goto L39;
        Unit r122 = r121.invoke(s1.B(R.string.ttlive_vip_end_waiting_title));
    L39:
        TextView r123 = this.f106142a.f106128c;
        if (r123 == null) goto L42;
        r123.setText(s1.B(R.string.ttlive_vip_end_non_vip_main_text));
    L42:
        TextView r124 = this.f106142a.f106129d;
        if (r124 == null) goto L73;
        r124.setText(s1.B(R.string.ttlive_vip_end_non_vip_sub_text));
        return;
    L73:
        return;
    L46:
        if (r103.booleanValue() == false) goto L48;
    L61:
        RestartLiveStatus r125 = r102.f549982a;
        if (r125 != RestartLiveStatus.ERROR) goto L64;
    L65:
        Function1<? super String, Unit> r126 = this.f106142a.f106126a;
        if (r126 == null) goto L68;
        Unit r127 = r126.invoke(s1.B(R.string.ttlive_live_end_label));
    L68:
        f2.b(R.string.ttlive_vip_end_error_toast, 0);
        this.f106142a.c();
        return;
    L64:
        if (r125 == RestartLiveStatus.TIMEOUT) goto L65;
        return;
    L48:
        if (r102.f549982a != RestartLiveStatus.STREAMING) goto L61;
        View r128 = this.f106142a.f106127b;
        if (r128 == null) goto L52;
        UtilityKotlinExtentionsKt.w(r128);
    L52:
        Function1<? super String, Unit> r129 = this.f106142a.f106126a;
        if (r129 == null) goto L55;
        Unit r130 = r129.invoke(s1.B(R.string.ttlive_vip_end_streaming_title));
    L55:
        TextView r131 = this.f106142a.f106128c;
        if (r131 == null) goto L58;
        r131.setText(s1.B(R.string.ttlive_vip_end_non_vip_streaming_text));
    L58:
        TextView r132 = this.f106142a.f106129d;
        if (r132 == null) goto L75;
        r132.setText(s1.B(R.string.ttlive_vip_end_non_vip_sub_text));
        return;
    }
}
