package com.bytedance.android.livesdk.revenue.message;

import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livesdk.chatroom.bl.LiveMessage;
import com.bytedance.android.livesdk.link.model.bridge.h2;
import com.bytedance.android.livesdk.message.model.RtmMessage;
import com.bytedance.android.livesdkapi.message.BaseMessage;
import com.bytedance.android.livesdkapi.message.ExternalMessageInject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vlc.d f157185a;

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void release() {
        this.f157185a.release();
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void startMessage() {
        this.f157185a.startMessage();
    }

    public i(vlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f157185a = r100;
    }

    public static yh6.c b(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$flexInstance");
        boolean r101 = r100 instanceof vh7.e;
        vh7.c r102 = r100;
        if (r101 == false) goto L9;
        Object r103 = ((vh7.e) r100).getFlexInstance();
        if (r103 == null) goto L8;
        r102 = (vh7.c) r103;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModel<T>");
    L9:
        if (r102 == null) goto L48;
        RtmMessage r104 = (RtmMessage) r102;
        RtmMessage.Header r105 = r104.getMHeader();
        t r106 = null;
        if (r105 == null) goto L13;
        String r107 = r105.getMMethod();
    L15:
        if (r107 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == false) goto L23;
        return null;
    L23:
        byte[] r109 = r104.getPayload();
        if (r104.getMHeader() == null) goto L49;
        if (r109 == null) goto L50;
        Class<? extends t> r110 = LiveMessage.getMessageClass(r107);
        if (r110 != null) goto L30;
        r110 = ExternalMessageInject.getInstance().getMessageClass(r107);
    L30:
        if (r110 != null) goto L32;
        return null;
    L32:
        am3.c r111 = ((INetworkService) jc1.k.n(INetworkService.class)).getProtoDecoder(r110);
        long r112 = System.currentTimeMillis();
        am3.g r113 = new am3.g();
        r113.k(new am3.b(r109));
        t r114 = (t) r111.decode(r113);
        if (r114 == null) goto L42;
        if ((r114 instanceof BaseMessage) == false) goto L42;
        BaseMessage r115 = (BaseMessage) r114;
        r115.setMessageMethod(r107);
        RtmMessage.Header r116 = r104.getMHeader();
        if (r116 == null) goto L39;
        long r117 = r116.getMCreateTime();
    L40:
        r115.timestamp = r117;
        r115.setMessageFrom(1);
        r115.fromChannel = 1;
        r115.setReceiveTime(com.bytedance.android.livesdk.utils.ntp.e.a());
        r115.setDecodeStartTime(r112);
        r115.setDecodeEndTime(System.currentTimeMillis());
        goto L42
    L39:
        r117 = 0;
    L42:
        if ((r114 instanceof yh6.c) == false) goto L46;
        r106 = r114;
    L46:
        return (yh6.c) r106;
    L50:
        return null;
    L49:
        return null;
    L17:
        if (r107.length() == 0) goto L20;
        r108 = false;
        goto L21
    L13:
        r107 = null;
        goto L15
    L48:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.RtmMessage");
    }

    public final yh6.c a(h2 r100) {
        Intrinsics.checkNotNullParameter(r100, "rtmMessage");
        return b(r100);
    L5:
        return null;
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void h(vlc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        this.f157185a.h(r100);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void addMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f157185a.addMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void j(tlc.d r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f157185a.j(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void removeMessageListener(String r100, vlc.l r101) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f157185a.removeMessageListener(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.revenue.message.b
    public final void i(String r100, vlc.l r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "messageType");
        Intrinsics.checkNotNullParameter(r101, "listener");
        vlc.d r103 = this.f157185a;
        if ((r103 instanceof xlc.a) == true) goto L5;
        r103 = null;
    L5:
        xlc.a r104 = (xlc.a) r103;
        if (r104 == null) goto L9;
        r104.i(r100, r101, r102);
        return;
    }
}
