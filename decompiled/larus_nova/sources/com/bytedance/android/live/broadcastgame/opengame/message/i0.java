package com.bytedance.android.live.broadcastgame.opengame.message;

import com.bytedance.android.livesdk.message.model.sc;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 implements com.bytedance.android.live.broadcastgame.c0<a>, vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.broadcastgame.b0 f60234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vlc.d f60235b;

    public static final class a implements com.bytedance.android.live.broadcastgame.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final sc f60236a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f60236a, ((a) r100).f60236a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            sc r100 = this.f60236a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "OpenPlatformControlMessage(msg=" + this.f60236a + ")";
        }

        public a(sc r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f60236a = r100;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void release() {
        vlc.d r100 = this.f60235b;
        if (r100 == null) goto L6;
        r100.removeMessageListener(this);
        return;
    }

    public i0(vlc.d r100) {
        this.f60235b = r100;
    }

    @Override // com.bytedance.android.live.broadcastgame.c0
    public final void a(com.bytedance.android.live.broadcastgame.b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "queue");
        this.f60234a = r100;
        vlc.d r101 = this.f60235b;
        if (r101 == null) goto L6;
        r101.addMessageListener(MessageType.INTERACT_OPEN_PLATFORM_CONTROL_MESSAGE.getIntType(), this);
        return;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof sc) == false) goto L8;
        com.bytedance.android.live.broadcastgame.b0 r101 = this.f60234a;
        if (r101 == null) goto L9;
        r101.insert(new a((sc) r100));
        return;
    L9:
        return;
    }
}
