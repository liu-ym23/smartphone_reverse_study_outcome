package com.bytedance.android.gamecp.business.download;

import android.content.DialogInterface;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.Unit;

/* JADX INFO: loaded from: classes44.dex */
public final class b1 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u0 f52540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f52541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.base.core.service.depend.e f52542c;

    public b1(u0 r100, Map r101, a1 r102) {
        this.f52540a = r100;
        this.f52541b = r101;
        this.f52542c = r102;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        u0 r101 = this.f52540a;
        Map r102 = null;
        if (r101.f52945e == false) goto L9;
        int r103 = com.bytedance.android.gamecp.common.track.b.f56775a;
        Map r104 = this.f52541b;
        if (r104 == null) goto L7;
        r104.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "download_now");
        Unit r105 = Unit.INSTANCE;
        r102 = r104;
    L7:
        com.bytedance.android.gamecp.common.track.b.h("download_block_pop_click", false, r102, new String[0]);
        return;
    L9:
        if (r101.f52944d == false) goto L14;
        int r106 = com.bytedance.android.gamecp.common.track.b.f56775a;
        Map r107 = this.f52541b;
        if (r107 == null) goto L13;
        r107.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "wait_wifi");
        Unit r108 = Unit.INSTANCE;
        r102 = r107;
    L13:
        com.bytedance.android.gamecp.common.track.b.h("download_block_pop_click", false, r102, new String[0]);
        return;
    L14:
        this.f52542c.onContinue();
        int r109 = com.bytedance.android.gamecp.common.track.b.f56775a;
        Map r110 = this.f52541b;
        if (r110 == null) goto L17;
        r110.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, "no_action");
        Unit r111 = Unit.INSTANCE;
        r102 = r110;
    L17:
        com.bytedance.android.gamecp.common.track.b.h("download_block_pop_click", false, r102, new String[0]);
    }
}
