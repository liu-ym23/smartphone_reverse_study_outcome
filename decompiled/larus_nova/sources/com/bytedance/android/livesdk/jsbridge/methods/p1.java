package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.LiveSetEffectAudioProcessResultModel;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.fb;

/* JADX INFO: loaded from: classes9.dex */
public final class p1 extends w20.k3<fb, LiveSetEffectAudioProcessResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f142172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f142173b;

    public p1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        fb r102 = (fb) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f142173b == true) goto L17;
        this.f142173b = true;
        rj0.l.f537955n2.getClass();
        rj0.l r103 = rj0.l.a.a();
        if (r103 == null) goto L9;
        com.bytedance.android.live.pushstream.d r104 = r103.getLiveStream();
        if (r104 == null) goto L9;
    L15:
        if (r104 == null) goto L17;
        r104.u();
    L9:
        IInteractService r105 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r105 == null) goto L14;
        qd0.a r106 = r105.getAudioTalkService();
        if (r106 == null) goto L14;
        r104 = r106.getLiveStream();
    L14:
        r104 = null;
    L17:
        CompositeDisposable r107 = this.f142172a;
        if (r107 == null) goto L20;
        r107.clear();
    L20:
        this.f142172a = new CompositeDisposable();
        Integer r108 = r102.b();
        if (r108 == null) goto L23;
        int r109 = r108.intValue();
    L24:
        if (r109 != 1) goto L26;
        boolean r110 = true;
    L27:
        String r111 = r102.c();
        if (r111 != null) goto L30;
        r111 = "";
    L30:
        Integer r112 = r102.a();
        if (r112 == null) goto L33;
        int r113 = r112.intValue();
    L34:
        if (r113 != 1) goto L36;
        boolean r114 = true;
    L37:
        if (r110 == true) goto L39;
    L44:
        CompositeDisposable r115 = this.f142172a;
        Intrinsics.checkNotNullParameter(r111, "stickerId");
        if (r110 == false) goto L47;
        RxUtilKt.c(Single.create(new o1(this, r111, true, r114)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new m1(this)), r115);
        return;
    L47:
        RxUtilKt.c(Single.create(new o1(this, String.valueOf(m90.b.f512567y.c(LiveEffectContextFactoryDelegate$Type.DEFAULT).longValue()), false, r114)).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new n1(this)), r115);
        return;
    L39:
        if (r111.length() != 0) goto L41;
        boolean r116 = true;
    L42:
        if (r116 == false) goto L44;
        j(4, "stickerId is empty");
        return;
    L41:
        r116 = false;
        goto L42
    L36:
        r114 = false;
        goto L37
    L33:
        r113 = 0;
        goto L34
    L26:
        r110 = false;
        goto L27
    L23:
        r109 = 0;
        goto L24
    }

    public final void j(int r100, String r101) {
        LiveSetEffectAudioProcessResultModel r102 = new LiveSetEffectAudioProcessResultModel();
        r102.a(LiveSetEffectAudioProcessResultModel.Code.Failed);
        r102.c(r101);
        LiveSetEffectAudioProcessResultModel.a r103 = new LiveSetEffectAudioProcessResultModel.a();
        r103.a(Integer.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
    }
}
