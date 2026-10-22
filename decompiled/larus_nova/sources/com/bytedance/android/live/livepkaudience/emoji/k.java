package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.c2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f81960b;

    public k(d r100, String r101) {
        this.f81959a = r100;
        this.f81960b = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        this.f81959a.f81936c = false;
        String r102 = this.f81960b.toString();
        c2 r103 = (c2) r101.data;
        if (r103 == null) goto L7;
        List<com.bytedance.android.livesdk.link.model.bridge.k> r104 = r103.getLinkedUsers();
        if (r104 == null) goto L7;
        String r105 = dl0.q.a(r104);
    L8:
        com.bytedance.android.live.liveinteract.plantform.utils.x.D0(r102, LiveCommonConstants.REASON_SELF_PANEL, r105, null);
        d r106 = this.f81959a;
        DATA r107 = r101.data;
        if (r107 == 0) goto L15;
        r106.d0((UnSilenceResponse) r107);
        d.a r108 = (d.a) this.f81959a.f531633a;
        if (r108 == null) goto L16;
        r108.G(this.f81960b);
        return;
    L16:
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.model.interact.UnSilenceResponse");
    L7:
        r105 = null;
        goto L8
    }
}
