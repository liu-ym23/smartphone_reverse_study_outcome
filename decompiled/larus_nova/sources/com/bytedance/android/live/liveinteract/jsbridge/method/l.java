package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLinkmicStatusResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import w20.a7;
import w20.lf;

/* JADX INFO: loaded from: classes46.dex */
public final class l extends a7<lf, UpdateLinkmicStatusResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IKtvService f74228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f74229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f74230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f74231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IJsBridgeManager f74232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s f74233f;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        lf r102 = (lf) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        JsonObject r106 = r102.b();
        Intrinsics.checkNotNullParameter(r104, "bizId");
        if (Intrinsics.areEqual(r104, "dynamic_center") == false) goto L17;
        my.c r107 = new my.c(DynamicCenterUpdateType.valueOf(r103), r104, r106);
        k r108 = new k(this);
        s r109 = this.f74233f;
        if (r109 == null) goto L14;
        r109.P0(r107, r108, this.f74230c);
        return;
    L14:
        iy.g r110 = com.bytedance.android.live.anchormodelink.linkroom.a.f58739a;
        iy.g r111 = com.bytedance.android.live.anchormodelink.linkroom.a.a(this.f74229b);
        if (r111 == null) goto L59;
        r111.P0(r107, r108, this.f74230c);
        return;
    L59:
        return;
    L17:
        ALogger.i("DynamicUpdate", "updateLinkmicStatus: " + r103 + ", " + r106 + ", " + r104 + ", isFeed=" + this.f74230c);
        Object r112 = null;
        DynamicUpdateType r113 = DynamicUpdateType.valueOf(r103.toUpperCase(Locale.ROOT));     // Catch: Exception -> L20
    L21:
        if (r113 != null) goto L23;
        finishWithFailure(new Throwable(r103.concat(" not defined in DynamicUpdateType")));
        return;
    L23:
        ih0.f r114 = new ih0.f(r101.f249269d, r113, r104, r106);
        t r115 = this.f74231d;
        if (r115 == null) goto L26;
        r115.B1(r114, new i(this), this.f74230c);
        return;
    L26:
        j r116 = new j(this);
        if (this.f74228a != null) goto L29;
        this.f74228a = (IKtvService) jc1.k.f(IKtvService.class);
    L29:
        IKtvService r117 = this.f74228a;
        if (r117 == null) goto L32;
        Object r118 = r117.getRealTimeChorusMicManager();
    L34:
        if ((r118 instanceof t) == false) goto L37;
        r112 = r118;
    L37:
        t r119 = (t) r112;
        if (r119 == null) goto L40;
        r119.B1(r114, r116, this.f74230c);
    L40:
        if (r106 != null) goto L56;
    L45:
        long r120 = 0;
    L46:
        ih0.b r121 = ((IInteractService) jc1.k.n(IInteractService.class)).dynamicService(this.f74229b, r120);
        if (r121 == null) goto L49;
        r121.B1(r114, r116, this.f74230c);
    L49:
        IInteractService r122 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r122 == null) goto L63;
        r122.updateLinkMicStatus(r114, r116, this.f74232e);
        return;
    L63:
        return;
    L56:
        JsonElement r123 = r106.get("room_id");     // Catch: Exception -> L53
        if (r123 == null) goto L45;
        r120 = r123.getAsLong();     // Catch: Exception -> L53
    L32:
        r118 = null;
    L20:
        r113 = null;
        goto L21
    }

    public l(DataCenter r100, boolean r101, t r102, IJsBridgeManager r103, s r104) {
        this.f74229b = r100;
        this.f74230c = r101;
        this.f74231d = r102;
        this.f74232e = r103;
        this.f74233f = r104;
    }

    public /* synthetic */ l(DataCenter r100, boolean r101, com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r102, IJsBridgeManager r110, s r111, int r112) {
        if ((r112 & 2) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r112 & 4) == 0) goto L9;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r104 = null;
    L11:
        if ((r112 & 8) == 0) goto L13;
        IJsBridgeManager r105 = null;
    L15:
        if ((r112 & 16) == 0) goto L17;
        s r106 = null;
    L18:
        this(r100, r103, r104, r105, r106);
        return;
    L17:
        r106 = r111;
        goto L18
    L13:
        r105 = r110;
        goto L15
    L9:
        r104 = r102;
        goto L11
    L5:
        r103 = r101;
        goto L7
    }
}
