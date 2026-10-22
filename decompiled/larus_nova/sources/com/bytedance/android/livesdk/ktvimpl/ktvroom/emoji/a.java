package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import hg6.i;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import tc0.c;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f144694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f144695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f144696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f144697d;

    public a() {
    }

    public final q0 a() {
        Context r100 = this.f144694a;
        if (r100 == null) goto L41;
        DataCenter r101 = this.f144695b;
        if (r101 == null) goto L39;
        if (this.f144696c == null) goto L37;
        if (this.f144697d == null) goto L35;
        if (r101 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L13:
        Boolean r102 = this.f144696c;
        if (r102 == null) goto L16;
        boolean r103 = r102.booleanValue();
    L17:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        String r104 = this.f144697d;
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L20:
        Intrinsics.checkNotNullParameter(r104, "requestPage");
        if (i.a() == false) goto L29;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r105 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.f79836j;
        IInteractService r106 = (IInteractService) k.f(IInteractService.class);
        if (r106 == null) goto L27;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r107 = r106.getLinkUserInfoCenter();
        if (r107 == null) goto L27;
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r107.getGuestInfo(d.b0(), c.h().f545349f);
    L28:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r108, r104, r103);
        return r105;
    L27:
        r108 = null;
        goto L28
    L29:
        ALogger.d("KtvRoomDynamicEmojiDialog", "new instance voice chat dynamic from " + r104);
        KtvRoomDynamicEmojiDialog r109 = new KtvRoomDynamicEmojiDialog(r100, r101, r103);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r109.f79296u = r104;
        tb6.c r110 = r109.A;
        if (r110 == null) goto L33;
        r110.a();
        r110.d(r104);
    L33:
        return r109;
    L16:
        r103 = false;
        goto L17
    L35:
        throw new IllegalArgumentException("call setRequestPage() before call build()");
    L37:
        throw new IllegalArgumentException("call setShowExtraButton() before call build()");
    L39:
        throw new IllegalArgumentException("call setDataCenter() before call build()");
    L41:
        throw new IllegalArgumentException("call setContext() before call build()");
    }

    public final void b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f144694a = r100;
    }

    public final void c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f144695b = r100;
    }
}
