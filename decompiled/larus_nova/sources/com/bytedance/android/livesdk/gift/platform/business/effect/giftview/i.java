package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mz0.n;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements IPlayerActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IPlayerActionListener f129397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoGiftView f129398b;

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final /* synthetic */ void onFirstFrame() {
        IPlayerActionListener.CC.$default$onFirstFrame(this);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final /* synthetic */ void onReportPlayMetrics(Map r100) {
        IPlayerActionListener.CC.$default$onReportPlayMetrics(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onEnd() {
        this.f129398b.f129358q = false;
        IPlayerActionListener r100 = this.f129397a;
        if (r100 == null) goto L5;
        r100.onEnd();
    L5:
        a(false);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStart() {
        VideoGiftView r100 = this.f129398b;
        if (r100.f129358q == true) goto L7;
        List<Long> r101 = r100.f129359r;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(Long.valueOf(r100.f129360s)) == false) goto L7;
        long r103 = this.f129398b.f129360s;
        String r104 = com.bytedance.android.livesdk.gift.platform.core.utils.h.f132038a;
        n r105 = new n();
        Map<String, String> r106 = r105.f516447a;
        Intrinsics.checkNotNullParameter(r106, "map");
        String r107 = String.valueOf(r103);
        Intrinsics.checkNotNullParameter("asset_id", "key");
        Intrinsics.checkNotNullParameter(r107, "value");
        r106.put("asset_id", r107);
        mz0.m r108 = new mz0.m();
        r108.b(LogCommon.PAGE_SOURCE_LOG);
        r108.b(LogCommon.ROOM);
        List<Object> r109 = r105.f516448b;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(r108.f516446a);
        cy0.e.f465759a.getClass();
        cy0.j r111 = cy0.e.a.f465760a;
        com.bytedance.android.scope.m.f163449e.getClass();
        Object r112 = com.bytedance.android.scope.m.b(r111).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r112);
        ((mz0.i) ((f80.a) r112)).w3("livesdk_match_atmosphere_effect_show", r105.f516447a, r105.f516448b);
    L7:
        this.f129398b.f129358q = true;
        IPlayerActionListener r113 = this.f129397a;
        if (r113 == null) goto L10;
        r113.onStart();
    L10:
        a(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onStop() {
        IPlayerActionListener r100 = this.f129397a;
        if (r100 == null) goto L6;
        r100.onStop();
        return;
    }

    public final void a(boolean r100) {
        EffectMessage r101 = this.f129398b.f129354m;
        if (r101 == null) goto L14;
        com.bytedance.android.livesdk.gift.model.a r102 = r101.f126033q;
        if (r102 == null) goto L15;
        t3 r103 = r102.f126378c;
        if (r103 == null) goto L16;
        IBaseUser r104 = r103.f126422d;
        String r105 = r103.f126423e;
        com.bytedance.android.live.profit.player.d r106 = yt0.c.h();
        if (r106 == null) goto L17;
        if (r100 == false) goto L12;
        r106.f1().c(r104, r105);
        return;
    L12:
        r106.f1().b(r104, r105);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public i(VideoGiftView r100, BaseVideoGiftWidget.g r101) {
        this.f129398b = r100;
        this.f129397a = r101;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void onFileLoaded(int r100, int r101) {
        IPlayerActionListener r102 = this.f129397a;
        if (r102 == null) goto L6;
        r102.onFileLoaded(r100, r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener
    public final void updateTextEffectPosition(float r100, float r101, float r102, float r103) {
        IPlayerActionListener r104 = this.f129397a;
        if (r104 == null) goto L6;
        r104.updateTextEffectPosition(r100, r101, r102, r103);
        return;
    }
}
