package com.bytedance.android.livesdk.gamecp.impl;

import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class n implements dw.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<vv.c, vlc.l> f125449a;

    public static final class a implements vlc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vv.c f125450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f125451b;

        public a(vv.c r100, String r101) {
            this.f125450a = r100;
            this.f125451b = r101;
        }

        @Override // vlc.l
        public final void onMessage(tlc.d r100) {
            this.f125450a.onMessage(this.f125451b, GsonProtectorUtils.toJson(new Gson(), r100));
        }
    }

    public n() {
        this.f125449a = new HashMap();
    }

    @Override // dw.i
    public final void b(long r100, vv.c r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        vlc.l r102 = this.f125449a.get(r101);
        if (r102 != null) goto L5;
        return;
    L5:
        vlc.d r103 = n3.c(r100);
        if (r103 == null) goto L8;
        r103.removeMessageListener(r102);
    L8:
        this.f125449a.remove(r101);
    }

    @Override // dw.i
    public final void a(long r100, String r101, vv.c r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "listener");
        a r103 = new a(r102, r101);
        this.f125449a.put(r102, r103);
        MessageType[] r104 = MessageType.values();
        int r105 = r104.length;
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        MessageType r107 = r104[r106];
        if (Intrinsics.areEqual(r107.getWsMethod(), r101) == true) goto L9;
        r106 = r106 + 1;
    L9:
        if (r107 == null) goto L16;
        vlc.d r108 = n3.c(r100);
        if (r108 == null) goto L17;
        r108.addMessageListener(r107.getIntType(), r103);
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r107 = null;
        goto L9
    }
}
