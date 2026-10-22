package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.q;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.config.h40;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c f146541a;

    public static final class a {
    }

    public static final class b extends b7.a {
        public b() {
        }

        @Override // b7.a, b7.b
        public final void onLoadSuccess(View r100) {
            ALogger.i("ConcertHybridManager", "loadLynxView success");
        }

        @Override // b7.a, b7.b
        public final void onLoadFail(View r100, String r101, String r102) {
            ALogger.e("ConcertHybridManager", "loadLynxView onLoadFail");
        }
    }

    static {
    }

    public c() {
    }

    public final void b() {
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r100 = this.f146541a;
        if (r100 == null) goto L5;
        r100.J();
    L5:
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r101 = this.f146541a;
        if (r101 == null) goto L9;
        r101.release();
        return;
    }

    public final void a(fd2.b r110) {
        Intrinsics.checkNotNullParameter(r110, "params");
        String r100 = h40.f120341a.getValue();
        int r101 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.f77132a;
        String r102 = com.bytedance.android.live.liveinteract.plantform.dynamicframe.utils.c.b(r100, Long.valueOf(d5.c(r110.f476469b)), r110.f476471d, r110.f476473f);
        u6 r103 = new u6("sslocal://webcast_lynxview?hybrid_type=lynx&url=");
        r103.b("url", r102);
        u6 r104 = r103.d("url");
        String r105 = "1";
        if (r110.f476472e == false) goto L5;
        String r106 = "1";
    L6:
        r104.b("is_video_chorus", r106);
        r104.b("anchor_id", r110.f476470c);
        r104.b("room_id", r110.f476469b);
        if (r110.f476471d == true) goto L10;
        r105 = "0";
    L10:
        r104.b("is_feed", r105);
        String r107 = r110.f476473f;
        if (r107 != null) goto L13;
        r107 = "";
    L13:
        r104.b("enter_from", r107);
        int r108 = q.f77142a;
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r109 = q.b(r110.getContext(), r103.c(), new b(), 0, null, 56);
        this.f146541a = r109;
        ih0.c.a.a(r109, null, null, 7);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r111 = this.f146541a;
        if (r111 == null) goto L21;
        AnnieXLynxView r112 = r111.f76888h;
        if (r112 == null) goto L22;
        r112.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        ViewGroup r113 = r110.f476476i;
        if (r113 == null) goto L23;
        r113.addView(r112);
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L5:
        r106 = "0";
        goto L6
    }

    public final void c(String r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "enterFrom");
        LinkedHashMap r104 = new LinkedHashMap();
        if (r100 != null) goto L10;
        m<IRoom> r105 = o3.f().getRoom();
        if (r105 == null) goto L9;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L9;
        r100 = r106.getIdStr();
    L9:
        r100 = null;
    L10:
        if (r101 != null) goto L17;
        m<IRoom> r107 = o3.f().getRoom();
        if (r107 == null) goto L16;
        IRoom r108 = r107.getValue();
        if (r108 == null) goto L16;
        r101 = r108.getOwnerUserIdString();
    L16:
        r101 = null;
    L17:
        String r109 = gh0.a.c();
        String r110 = "";
        if (r100 != null) goto L20;
        String r111 = "";
    L21:
        r104.put("room_id", r111);
        if (r101 != null) goto L24;
        String r112 = "";
    L25:
        r104.put("anchor_id", r112);
        if (r109 == null) goto L29;
        r110 = r109;
    L29:
        r104.put("user_id", r110);
        if (r102 == false) goto L32;
        String r113 = "1";
    L33:
        r104.put("is_feed", r113);
        r104.put("enter_from", r103);
        ALogger.i("ConcertHybridManager", "更新GlobalProps, mHybridCard=" + this.f146541a + ", roomId=" + r100 + ", anchorId=" + r101 + ", userId=" + r109 + ", is_feed=" + r102 + ", enterFrom=" + r103);
        com.bytedance.android.live.liveinteract.plantform.dynamicframe.anniex.c r114 = this.f146541a;
        if (r114 == null) goto L37;
        r114.updateGlobalProps(r104);
        return;
    L37:
        return;
    L32:
        r113 = "0";
        goto L33
    L24:
        r112 = r101;
        goto L25
    L20:
        r111 = r100;
        goto L21
    }
}
