package com.bytedance.android.gamecp.business.props;

import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.android.gamecp.common.utils.LiveBroadcastBaseClient;
import com.bytedance.android.gamecp.common.utils.ToastUtil;
import com.bytedance.android.gamecp.host_api.callback.TTCJPayResult;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements sv.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f56378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wt.a f56379b;

    @Override // sv.b
    public final void a(TTCJPayResult r100) {
        Integer r101 = Integer.valueOf(r100.getCode());
        if (r101 != null) goto L6;
    L7:
        if (r101 != null) goto L10;
    L11:
        if (r101 != null) goto L14;
    L15:
        if (r101 != null) goto L18;
    L19:
        if (r101 != null) goto L22;
    L23:
        if (r101 != null) goto L26;
    L27:
        if (r101 != null) goto L30;
    L31:
        if (r101 != null) goto L34;
    L35:
        if (r101 == null) goto L41;
        if (r101.intValue() != 113) goto L41;
    L51:
        if (r101 != null) goto L54;
    L55:
        if (r101 != null) goto L58;
    L60:
        ToastUtil.a(R.string.ttlive_game_promote_prop_order_pay_fail);
        b r102 = this.f56378a.f56359g;
        if (r102 == null) goto L68;
        r102.R();
    L68:
        LiveTracingMonitor.EventModule r103 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r104 = this.f56378a.g();
        r104.put("error_code", r101.intValue());
        Unit r105 = Unit.INSTANCE;
        JSONObject r106 = new JSONObject();
        r106.put("order_id", this.f56379b.orderId);
        com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_HWDEC2SWDEC, r104, r106);
        return;
    L58:
        if (r101.intValue() != 101) goto L60;
    L63:
        j r107 = this.f56378a;
        wt.a r108 = this.f56379b;
        String r109 = r108.orderId;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "info");
        r107.h();
        Lazy r110 = LiveBroadcastBaseClient.f57176a;
        Observable<com.bytedance.android.gamecp.base.network.response.i<wt.j>> r111 = ((GamePromoteApi) LiveBroadcastBaseClient.a(GamePromoteApi.class)).queryOrderState(r109).doOnNext(n.f56385a).doOnError(new o(r107, r108, r109)).retryWhen(new com.bytedance.android.gamecp.common.utils.rxutils.d()).observeOn(AndroidSchedulers.mainThread());
        if (r111 == null) goto L68;
        Disposable r112 = r111.subscribe(new p(r107, r109, r108), new q(r107, r109, r108));
        if (r112 == null) goto L68;
        com.bytedance.android.gamecp.common.utils.rxutils.e.a(r112, r107.f56361i);
        goto L68
    L54:
        if (r101.intValue() == 0) goto L63;
    L41:
        if (r101 != null) goto L44;
    L46:
        if (r101 != null) goto L49;
        return;
    L49:
        if (r101.intValue() != 110) goto L71;
        yr.c.a(this.f56378a.f56353a, "CJ onPayCallback, code:" + r101);
        return;
    L71:
        return;
    L44:
        if (r101.intValue() != 111) goto L46;
        yr.c.a(this.f56378a.f56353a, "CJ onPayCallback, code:" + r101);
        return;
    L34:
        if (r101.intValue() == 104) goto L51;
    L30:
        if (r101.intValue() == 109) goto L51;
    L26:
        if (r101.intValue() == 103) goto L51;
    L22:
        if (r101.intValue() == 102) goto L51;
    L18:
        if (r101.intValue() == 101) goto L51;
    L14:
        if (r101.intValue() == 0) goto L51;
    L10:
        if (r101.intValue() == 105) goto L51;
    L6:
        if (r101.intValue() == 112) goto L51;
        goto L7
    }

    public k(j r100, wt.a r101) {
        this.f56378a = r100;
        this.f56379b = r101;
    }

    @Override // sv.b
    public final void onEvent(String r100, Map<String, String> r101) {
        if (r100 == null) goto L5;
        com.bytedance.android.gamecp.common.track.b.h(r100, false, r101, new String[0]);
        return;
    }
}
