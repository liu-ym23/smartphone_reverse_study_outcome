package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f79417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DataCenter f79418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f79419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f79420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79422f;

    public t() {
    }

    public final q0 a() {
        int r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getLinkMode();
        if (gd0.v.a(r100, 32) == false) goto L7;
        return b();
    L7:
        if (gd0.v.a(r100, 8) == false) goto L11;
        return c();
    L11:
        return c();
    }

    public final void d() {
        if (this.f79417a == null) goto L18;
        if (this.f79418b == null) goto L16;
        if (this.f79419c == null) goto L14;
        if (this.f79420d == null) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("call setRequestPage() before call build()");
    L14:
        throw new IllegalArgumentException("call setShowExtraButton() before call build()");
    L16:
        throw new IllegalArgumentException("call setDataCenter() before call build()");
    L18:
        throw new IllegalArgumentException("call setContext() before call build()");
    }

    public final q0 b() {
        d();
        Context r100 = this.f79417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        DataCenter r101 = this.f79418b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        Boolean r102 = this.f79419c;
        if (r102 == null) goto L11;
        boolean r103 = r102.booleanValue();
    L12:
        boolean r104 = this.f79422f;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        String r105 = this.f79420d;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L15:
        Intrinsics.checkNotNullParameter(r105, "requestPage");
        if (hg6.i.a() == false) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r106 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.f79836j;
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r107 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r108 = r107.getLinkUserInfoCenter();
        if (r108 == null) goto L22;
        ILinkPlayerInfoBridge r109 = (ILinkPlayerInfoBridge) r108.getGuestInfo(je0.d.b0(), tc0.c.h().f545349f);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r109, r105, r103);
        return r106;
    L22:
        r109 = null;
        goto L23
    L24:
        ALogger.d("DynamicEmojiDialog Refactor VideoTalk", "new instance video talk dynamic from " + r105);
        VideoTalkDynamicEmojiDialog r110 = new VideoTalkDynamicEmojiDialog(r100, r101, r103, r104);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r110.f79296u = r105;
        tb6.c r111 = r110.A;
        if (r111 == null) goto L28;
        r111.a();
        Intrinsics.checkNotNullParameter(r105, "requestPage");
        r111.f545269d = r105;
    L28:
        return r110;
    L11:
        r103 = false;
        goto L12
    }

    public final q0 c() {
        d();
        Context r100 = this.f79417a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L5:
        DataCenter r101 = this.f79418b;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("dataCenter");
    L8:
        Boolean r102 = this.f79419c;
        if (r102 == null) goto L11;
        boolean r103 = r102.booleanValue();
    L12:
        boolean r104 = this.f79421e;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        String r105 = this.f79420d;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("requestPage");
    L15:
        Intrinsics.checkNotNullParameter(r105, "requestPage");
        if (hg6.i.a() == false) goto L24;
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a r106 = com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.f79836j;
        IInteractService r107 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r107 == null) goto L22;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r108 = r107.getLinkUserInfoCenter();
        if (r108 == null) goto L22;
        ILinkPlayerInfoBridge r109 = (ILinkPlayerInfoBridge) r108.getGuestInfo(je0.d.b0(), tc0.c.h().f545349f);
    L23:
        com.bytedance.android.live.liveinteract.videotalk.utils.panel.a.u(r109, r105, r103);
        return r106;
    L22:
        r109 = null;
        goto L23
    L24:
        ALogger.d("VoiceChatDynamicEmojiDialog", "new instance voice chat dynamic from " + r105);
        VoiceChatDynamicEmojiDialog r110 = new VoiceChatDynamicEmojiDialog(r100, r101, r103, r104);
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r110.f79296u = r105;
        tb6.c r111 = r110.A;
        if (r111 == null) goto L28;
        r111.a();
        Intrinsics.checkNotNullParameter(r105, "requestPage");
        r111.f545269d = r105;
    L28:
        return r110;
    L11:
        r103 = false;
        goto L12
    }

    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f79417a = r100;
    }

    public final void f(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f79418b = r100;
    }

    public final void g(boolean r100) {
        this.f79419c = Boolean.valueOf(r100);
    }
}
