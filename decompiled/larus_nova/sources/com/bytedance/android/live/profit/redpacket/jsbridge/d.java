package com.bytedance.android.live.profit.redpacket.jsbridge;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.jsbridge.base.RedEnvelopeUpdateResultModel;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftSource;
import com.bytedance.android.livesdk.gift.platform.core.model.SendGiftStrategy;
import com.bytedance.android.livesdk.gift.platform.core.model.b0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import w20.c5;
import w20.dd;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends c5<dd, RedEnvelopeUpdateResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f88641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f88642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function2<Long, Boolean, Unit> f88643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Long, Unit> f88644d;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        Disposable r100 = this.f88641a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f88641a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onDestroy() {
        super.onDestroy();
        Disposable r100 = this.f88641a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L11;
        Disposable r101 = this.f88641a;
        if (r101 == null) goto L12;
        r101.dispose();
        return;
    L12:
        return;
    }

    public final Context getContext() {
        return this.f88642b;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r610, CallContext r611) {
        dd r100 = (dd) r610;
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r611, "p1");
        String r101 = r100.getType();
        if (r101 != null) goto L6;
    L30:
        finishWithFailure();
        return;
    L6:
        switch(r101.hashCode()) {
            case -1335458389: goto L28;
            case 3267882: goto L21;
            case 12811976: goto L14;
            case 1682120465: goto L9;
            default: goto L30;
        };
    L9:
        if (r101.equals("openRecharge") == false) goto L30;
        com.bytedance.android.live.recharge.model.d r102 = new com.bytedance.android.live.recharge.model.d(true, "red_envelope", null, 0, false, 0, 0, null, null, null, null, "red_envelope", null, 30716);
        FragmentActivity r103 = ContextUtil.contextToFragmentActivity(this.f88642b);
        if (r103 == null) goto L30;
        ((IRechargeService) com.bytedance.android.live.revenue.core.util.f.a(IRechargeService.class)).showRechargeDialogFragment(r103, r102, null);
        goto L30
    L14:
        if (r101.equals("sendProps") == false) goto L30;
        a r104 = (a) GsonProtectorUtils.fromJson(GsonHelper.get(), r100.b(), a.class);
        if (TextUtils.isEmpty(r104.b()) == true) goto L18;
        String r105 = r104.b();
    L19:
        String r110 = r105;
        String r111 = null;
        String r112 = null;
        String r113 = null;
        int r114 = 0;
        String r115 = null;
        ArrayList r116 = null;
        boolean r117 = false;
        SendGiftStrategy r118 = null;
        int r210 = 0;
        this.f88641a = ((IGiftService) k.n(IGiftService.class)).sendProp(new b0(r104.c(), SendGiftSource.RedPacketGiftGuide, null, null, 0, 0, r110, r111, r112, r113, r114, r115, r116, r117, r118, r210, true, null, 0, null, false, null, false, 0, null, null, null, null, null, null, null, null, 0, 0, null, null, false, null, null, null, null, null, null, false, null, null, null, null, 0, null, null, -65604, 8388607), r104.a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
        return;
    L18:
        r105 = UserProfileEvent.POSITION_RED_PACKET;
        goto L19
    L21:
        if (r101.equals("join") == false) goto L30;
        f r106 = (f) GsonProtectorUtils.fromJson(GsonHelper.get(), r100.b(), f.class);
        if (r106 == null) goto L25;
        boolean r107 = r106.a();
    L26:
        this.f88643c.invoke(r100.a(), Boolean.valueOf(r107));
        finishWithSuccess();
        return;
    L25:
        r107 = false;
        goto L26
    L28:
        if (r101.equals("delete") == false) goto L30;
        this.f88644d.invoke(r100.a());
        finishWithSuccess();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(Context r100, DataCenter r101, Function2<? super Long, ? super Boolean, Unit> r102, Function1<? super Long, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, "markJoined");
        Intrinsics.checkNotNullParameter(r103, "markRushed");
        this.f88642b = r100;
        this.f88643c = r102;
        this.f88644d = r103;
    }
}
