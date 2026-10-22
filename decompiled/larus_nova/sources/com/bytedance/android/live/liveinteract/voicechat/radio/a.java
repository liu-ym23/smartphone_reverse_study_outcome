package com.bytedance.android.live.liveinteract.voicechat.radio;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.livelink.multilink.MultiLinkService;
import com.bytedance.android.livesdk.chatroom.model.interact.k2;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.dm;
import com.bytedance.android.livesdk.config.hj1;
import com.bytedance.android.livesdk.config.hr;
import com.bytedance.android.livesdk.config.jr0;
import com.bytedance.android.livesdk.config.ma1;
import com.bytedance.android.livesdk.config.uh1;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f80472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vb6.g f80473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m00.e f80474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public he0.b f80475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Integer> f80476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f80477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f80478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final k2 f80479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final j1 f80480i;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.voicechat.radio.a$a, reason: collision with other inner class name */
    public static final class C1244a {
    }

    public static final class b implements xb6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f80481a;

        public b(a r100) {
            this.f80481a = r100;
        }

        @Override // xb6.a
        public final void a(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
        }

        @Override // xb6.a
        public final String b(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }

        @Override // xb6.a
        public final void c(fi6.a r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            a r101 = this.f80481a;
            r101.getClass();
            if (hj1.f120382a.getValue().booleanValue() == false) goto L5;
            int r102 = le0.a.f508903a;
            InteractMode r103 = InteractMode.FM;
        L6:
            r101.f80475d = new he0.b(new c(r101), r101.f80476e, r101.f80480i);
            String r104 = r101.f80479h.a();
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r100.f477382f = r101.f80475d;
            r100.f(LinkConstant.STREAM_BACKGROUND);
            r100.h(r101.f80478g);
            Intrinsics.checkNotNullParameter(r104, "info");
            r100.f477406v = r104;
            r100.S = 5;
            r100.o(qi6.g.f533174h);
            String r105 = s1.B(R.string.ttlive_stream_project_key);
            Intrinsics.checkNotNullParameter(r105, "key");
            r100.f477407w = r105;
            r100.i(r103);
            r100.N = 300;
            r100.g(Character.ANCHOR);
            r100.f477378d = -1;
            r100.R = uh1.f121375a.getValue().booleanValue();
            r100.Q = (int) jr0.f120547a.getValue().longValue();
            he0.b r106 = r101.f80475d;
            Intrinsics.checkNotNull(r106);
            r106.f484810b = r100;
            com.bytedance.live.datacontext.m<IRoom> r107 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
            IBaseStreamUrl r108 = null;
            if (r107 == null) goto L12;
            IRoom r109 = r107.getValue();
        L13:
            m00.e r110 = r101.f80474c;
            if (r110 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("mAnchorVideoClient");
        L16:
            if (r110 == null) goto L36;
            r110.d();
            if (r109 == null) goto L20;
            r108 = r109.getStreamUrl();
        L20:
            Intrinsics.checkNotNull(r108);
            r100.f477380e = r108.getRtmpPushUrl();
            MixStreamType r111 = MixStreamType.SERVER_MIX;
            r100.j(r111);
            r100.n(StreamType.VIDEO);
            if (hr.f120398a.getValue().booleanValue() == false) goto L27;
            Boolean r112 = dm.f120048a.getValue();
            r100.W = false;
            if (r112.booleanValue() == false) goto L25;
            r111 = MixStreamType.RTC_CLIENT_MIX;
        L25:
            r100.j(r111);
        L27:
            if (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.c.a() == false) goto L29;
            r100.Z = true;
            x.O(true);
        L31:
            if (ma1.f120740a.getValue().booleanValue() == false) goto L33;
            r100.f477390j = 1;
        L33:
            he0.b r113 = r101.f80475d;
            Intrinsics.checkNotNull(r113);
            r113.f484810b = r100;
            return;
        L29:
            x.O(false);
            goto L31
        L36:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.widget.ILinkInRoomView");
        L12:
            r109 = null;
            goto L13
        L5:
            r103 = InteractMode.FM;
            goto L6
        }

        @Override // xb6.a
        public final String d(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }

        @Override // xb6.a
        public final String e(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }

        @Override // xb6.a
        public final String f(yb6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }
    }

    static {
    }

    public a(Context r100, k2 r101, j1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "initRtcInfo");
        Intrinsics.checkNotNullParameter(r102, "scopeProvider");
        this.f80478g = r100;
        this.f80479h = r101;
        this.f80480i = r102;
        this.f80476e = new HashMap();
        this.f80477f = new b(this);
        jb6.a r103 = (jb6.a) r102.getScopeServiceOrNullInMultiLinkRoom(jb6.a.class);
        com.bytedance.android.live.pushstream.d r104 = null;
        if (r103 == null) goto L5;
        MultiLinkService r105 = r103.wi(r100, gh0.a.d());
    L6:
        this.f80473b = r105;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r106 = com.bytedance.android.live.liveinteract.api.utils.m.i().getLiveStream();
        if (r106 == null) goto L9;
        r104 = r106.getValue();
    L9:
        this.f80472a = r104;
        return;
    L5:
        r105 = null;
        goto L6
    }
}
