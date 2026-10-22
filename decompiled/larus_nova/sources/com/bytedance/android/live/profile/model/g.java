package com.bytedance.android.live.profile.model;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;

/* JADX INFO: loaded from: classes47.dex */
public final class g extends ta1.a<f> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f86084c;

    public g() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        TokenCert r101 = j0.f153361c;
        if (H() == true) goto L7;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L7:
        r100.putAll(this.f545152b);
        I(r100, this.f86084c);
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        this.f86084c = (f) r100;
    }

    public final void I(Map<String, String> r100, f r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        TokenCert r102 = j0.f153361c;
        if (H() == true) goto L7;
        ALogger.w("ttlive_log", "thread exception, current thread: " + ThreadMethodProxy.currentThread().toString() + ", id: " + ThreadMethodProxy.currentThread().getId());
    L7:
        r100.putAll(this.f545152b);
        if (r101 == null) goto L11;
        r100.put("request_page", r101.f86079a);
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT, r101.f86080b);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r101.f86081c);
        r100.put("new_profile_card_v", String.valueOf(r101.f86082d));
        r100.put("user_id", r101.f86083e);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.o
    public final /* bridge */ /* synthetic */ void u(Map r100, Object r101) {
        I(r100, (f) r101);
    }
}
