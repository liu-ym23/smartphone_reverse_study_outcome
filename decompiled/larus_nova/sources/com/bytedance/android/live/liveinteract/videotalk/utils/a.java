package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.os.SystemClock;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.interactivesong.impl.InteractiveSongContext;
import com.bytedance.android.live.liveinteract.interactivesong.logger.InteractiveSongLoggerKt;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.WakeupSoundEffectSettings;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f79782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f79783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f79784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f79785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f79786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f79787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f79788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f79789h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f79790i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> f79791j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f79792k;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.videotalk.utils.a$a, reason: collision with other inner class name */
    public static final class C1240a {
    }

    static {
    }

    public final void c() {
        if (this.f79783b == false) goto L5;
        return;
    L5:
        ALogger.d("CPositionDurationHelper", "release: selfIsCPosition=" + this.f79789h + ", cPositionStart=" + this.f79784c);
        this.f79791j.T4(this.f79782a);
        this.f79783b = true;
        if (this.f79789h == true) goto L8;
    L10:
        this.f79784c = 0;
        this.f79789h = false;
        return;
    L8:
        if (this.f79784c <= 0) goto L10;
        d(SystemClock.elapsedRealtime() - this.f79784c, this.f79787f, this.f79788g);
        goto L10
    }

    public static boolean a(List r100) {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();
        if (((ILinkPlayerInfoBridge) r103).isEnlarged() == false) goto L4;
        r101.add(r103);
        goto L4
    L9:
        if (r101.size() < 2) goto L11;
    L14:
        return true;
    L11:
        if (TalkRoomLogUtils.f77434b.f77481a == 26) goto L14;
        return false;
    }

    public final void b(List<? extends ILinkPlayerInfoBridge> r110) {
        if (this.f79783b == false) goto L5;
        return;
    L5:
        String r100 = je0.d.b0();
        if (r100 != null) goto L8;
    L11:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L15;
        Boolean r102 = Boolean.FALSE;
        Pair r103 = new Pair(r102, r102);
    L30:
        boolean r104 = ((Boolean) r103.component1()).booleanValue();
        boolean r105 = ((Boolean) r103.component2()).booleanValue();
        if (this.f79790i == r104) goto L36;
        ALogger.d("CPositionDurationHelper", "online state change " + this.f79790i + " -> " + r104);
        if (r104 == false) goto L35;
        this.f79785d = 0;
        this.f79786e = false;
    L35:
        this.f79790i = r104;
    L36:
        if (r105 == false) goto L57;
        String r106 = je0.d.a();
        if (r106 != null) goto L40;
        r106 = "";
    L40:
        Iterator<T> r107 = r110.iterator();
    L42:
        if (r107.hasNext() == false) goto L50;
        Object r108 = r107.next();
        IBaseUser r111 = ((ILinkPlayerInfoBridge) r108).getUser();
        if (r111 == null) goto L46;
        String r112 = r111.getIdString();
    L48:
        if (Intrinsics.areEqual(r112, r106) == false) goto L42;
    L51:
        ILinkPlayerInfoBridge r109 = (ILinkPlayerInfoBridge) r108;
        if (r109 == null) goto L54;
        boolean r113 = r109.isEnlarged();
    L55:
        this.f79787f = r113;
        this.f79788g = a(r110);
        goto L57
    L54:
        r113 = false;
        goto L55
    L46:
        r112 = null;
        goto L48
    L50:
        r108 = null;
    L57:
        if (this.f79789h == r105) goto L141;
        if (r105 == false) goto L129;
        ALogger.d("CPositionDurationHelper", "我【成为】C位了");
        this.f79784c = SystemClock.elapsedRealtime();
        this.f79786e = true;
        boolean r114 = a(r110);
        com.bytedance.live.datacontext.m<IRoom> r115 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r115 == null) goto L66;
        IRoom r116 = r115.getValue();
        if (r116 == null) goto L66;
        if (r116.isLiveTypeAudio() != true) goto L66;
        String r117 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.f77434b.f77481a), r110, null, 32);
    L67:
        i0 r118 = TalkRoomLogUtils.f77433a;
        DataCenter r119 = this.f79792k;
        Intrinsics.checkNotNullParameter(r110, "list");
        LinkedHashMap r120 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r120);
        TalkRoomLogUtils.B0(r120, null, null, 6);
        r120.put(FastStartLiveConfig.PLAY_MODE, u0.b());
        TalkRoomLogUtils.V0(r120);
        r120.put("enlarge_user_type", TalkRoomLogUtils.y());
        r120.put("enlarge_user_id", je0.d.b0().toString());
        r120.put("seat_num", String.valueOf(je0.d.R()));
        r120.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        r120.putAll(TalkRoomLogUtils.e());
        InteractiveSongLoggerKt.b(r120);
        if (r117 == null) goto L71;
        r120.put("enlarge_show_type", r117);
    L73:
        String r121 = "1";
        if (r114 == false) goto L77;
        r120.put("is_double", "1");
    L77:
        if (TalkRoomLogUtils.D(r110, r119) == false) goto L79;
        r120.put("is_anchor_enlarge", "1");
    L79:
        com.bytedance.android.live.liveinteract.plantform.utils.h r122 = TalkRoomLogUtils.f77434b;
        r120.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(r122.f77481a)));
        if (r122.f77481a != 26) goto L82;
        r120.put("is_empty_enlarge_seat", TalkRoomLogUtils.s(r119));
    L82:
        InteractiveSongContext.a r123 = InteractiveSongContext.Companion;
        InteractiveSongContext r124 = r123.getContext();
        if (r124 == null) goto L102;
        com.bytedance.live.datacontext.j<of0.b> r125 = r124.getInteractiveSongWidget();
        if (r125 == null) goto L102;
        of0.b r126 = r125.getValue();
        if (r126 == null) goto L102;
        String r127 = r126.Bm();
        if (r127 == null) goto L102;
        if (r123.f() == false) goto L102;
        r120.put("play_layout", r127);
        HamletAvatarContext r128 = HamletAvatarContext.Companion.getContext();
        if (r128 == null) goto L100;
        com.bytedance.live.datacontext.n<Long> r129 = r128.getCurrentSelectAvatarID();
        if (r129 == null) goto L100;
        Long r130 = r129.getValue();
        if (r130 == null) goto L100;
        String r131 = String.valueOf(r130.longValue());
        if (r131 == null) goto L100;
    L101:
        r120.put("avatar_id", r131);
        e33.e r132 = TalkRoomLogUtils.f77435c;
        r132.b("play_layout", r127);
        r132.b(FastStartLiveConfig.PLAY_MODE, u0.b());
        r132.b("avatar_id", r131);
    L100:
        r131 = "0";
    L102:
        r120.put("user_type", TalkRoomLogUtils.y());
        HamletAvatarContext.a r133 = HamletAvatarContext.Companion;
        HamletAvatarContext r134 = r133.getContext();
        if (r134 == null) goto L111;
        com.bytedance.live.datacontext.j<gd0.g> r135 = r134.getHamletAvatarService();
        if (r135 == null) goto L111;
        gd0.g r136 = r135.getValue();
        if (r136 == null) goto L111;
        if (r136.I6() != true) goto L111;
    L112:
        r120.put("is_multiplayer", r121);
        Integer r137 = je0.d.h();
        if (r137 != null) goto L116;
    L118:
        String r138 = WakeupSoundEffectSettings.CLASSIC;
    L119:
        r120.put("play_layout", r138);
        HamletAvatarContext r139 = r133.getContext();
        if (r139 == null) goto L128;
        com.bytedance.live.datacontext.j<gd0.g> r140 = r139.getHamletAvatarService();
        if (r140 == null) goto L128;
        gd0.g r141 = r140.getValue();
        if (r141 == null) goto L128;
        Long r142 = r141.Ue();
        if (r142 == null) goto L128;
        r120.put("avatar_id", String.valueOf(r142.longValue()));
    L128:
        zi0.d.b(r120, false);
        j0.l().sendLog("livesdk_live_guest_enlarge_start", r120, new Object[]{IRoom.class, am2.x.class});
    L133:
        this.f79789h = r105;
        return;
    L116:
        if (r137.intValue() != 28) goto L118;
        r138 = "avatar";
    L111:
        r121 = "0";
        goto L112
    L71:
        if (je0.d.f() != 12) goto L73;
        TalkRoomLogUtils.x0(r120);
    L66:
        r117 = null;
        goto L67
    L129:
        ALogger.d("CPositionDurationHelper", "我【下】C位了");
        if (this.f79784c <= 0) goto L132;
        long r143 = SystemClock.elapsedRealtime() - this.f79784c;
        this.f79785d += r143;
        d(r143, this.f79787f, this.f79788g);
        this.f79784c = 0;
    L132:
        ALogger.d("CPositionDurationHelper", "lastLinkCPositionDuration=" + this.f79785d);
        goto L133
    L141:
        return;
    L15:
        Iterator<T> r144 = r110.iterator();
    L17:
        if (r144.hasNext() == false) goto L25;
        Object r145 = r144.next();
        IBaseUser r146 = ((ILinkPlayerInfoBridge) r145).getUser();
        if (r146 == null) goto L21;
        String r147 = r146.getIdString();
    L23:
        if (Intrinsics.areEqual(r147, r100) == false) goto L17;
    L26:
        ILinkPlayerInfoBridge r148 = (ILinkPlayerInfoBridge) r145;
        if (r148 == null) goto L29;
        r103 = new Pair(Boolean.TRUE, Boolean.valueOf(r148.isEnlarged()));
        goto L30
    L29:
        Boolean r149 = Boolean.FALSE;
        r103 = new Pair(r149, r149);
        goto L30
    L21:
        r147 = null;
        goto L23
    L25:
        r145 = null;
        goto L26
    L8:
        if (r100.length() == 0) goto L11;
        r101 = false;
        goto L13
    }

    public a(com.bytedance.android.live.liveinteract.plantform.core.y r100, boolean r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "userCenter");
        this.f79791j = r100;
        this.f79792k = r102;
        b r103 = new b(this);
        this.f79782a = r103;
        r100.Q4(r103);
        b(r100.f76316c);
    }

    public final void d(long r110, boolean r111, boolean r112) {
        ALogger.d("CPositionDurationHelper", "我的C位时长：" + r110);
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Integer r101 = null;
        if (r100 == null) goto L9;
        IRoom r102 = r100.getValue();
        if (r102 == null) goto L9;
        if (r102.isLiveTypeAudio() != true) goto L9;
        String r103 = u0.f(je0.d.h(), Integer.valueOf(je0.d.f()), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.f77434b.f77481a), null, null, 48);
    L10:
        i0 r104 = TalkRoomLogUtils.f77433a;
        DataCenter r105 = this.f79792k;
        LinkedHashMap r106 = new LinkedHashMap();
        r106.putAll(TalkRoomLogUtils.e());
        TalkRoomLogUtils.J0(r106);
        TalkRoomLogUtils.B0(r106, null, null, 6);
        r106.put(FastStartLiveConfig.PLAY_MODE, u0.b());
        TalkRoomLogUtils.V0(r106);
        r106.put("duration", String.valueOf((r110 + ((long) 500)) / ((long) 1000)));
        com.bytedance.android.live.liveinteract.plantform.utils.h r113 = TalkRoomLogUtils.f77434b;
        r106.put("current_enlarge_user_type", TalkRoomLogUtils.o(Integer.valueOf(r113.f77481a)));
        if (r113.f77481a != 26) goto L13;
        r106.put("is_empty_enlarge_seat", TalkRoomLogUtils.s(r105));
    L13:
        r106.put("enlarge_user_type", TalkRoomLogUtils.y());
        r106.put("enlarge_user_id", je0.d.b0().toString());
        r106.put("enlarge_open_from", String.valueOf(TalkRoomLogUtils.f()));
        InteractiveSongLoggerKt.b(r106);
        if (r103 == null) goto L17;
        r106.put("enlarge_show_type", r103);
    L19:
        String r114 = "1";
        if (r112 == false) goto L22;
        r106.put("is_double", "1");
    L22:
        if (r111 == false) goto L24;
        r106.put("is_anchor_enlarge", "1");
    L24:
        e33.e r115 = TalkRoomLogUtils.f77435c;
        if (r115.f470906a.isEmpty() == true) goto L39;
        Object r116 = r115.get("play_layout");
        if (r116 == null) goto L38;
        r106.put("play_layout", (String) r116);
        Object r117 = r115.get(FastStartLiveConfig.PLAY_MODE);
        if (r117 == null) goto L36;
        r106.put(FastStartLiveConfig.PLAY_MODE, (String) r117);
        Object r118 = r115.get("avatar_id");
        if (r118 == null) goto L34;
        r106.put("avatar_id", (String) r118);
        r115.f470906a.clear();
        goto L39
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L36:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L39:
        r106.put("user_type", TalkRoomLogUtils.y());
        HamletAvatarContext.a r119 = HamletAvatarContext.Companion;
        HamletAvatarContext r120 = r119.getContext();
        if (r120 != null) goto L42;
    L44:
        r114 = "0";
    L45:
        r106.put("is_multiplayer", r114);
        Integer r121 = je0.d.h();
        com.bytedance.android.livesdk.chatroom.u r122 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r122 == null) goto L55;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.chatroom.viewmodel.f> r123 = r122.s();
        if (r123 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r124 = r123.getValue();
        if (r124 == null) goto L55;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r125 = r124.g();
        if (r125 == null) goto L55;
        r101 = Integer.valueOf(r125.f114793b);
    L55:
        if (r121 != null) goto L58;
    L59:
        if (r101 != null) goto L62;
    L64:
        String r126 = WakeupSoundEffectSettings.CLASSIC;
    L66:
        r106.put("play_layout", r126);
        HamletAvatarContext r127 = r119.getContext();
        if (r127 == null) goto L75;
        com.bytedance.live.datacontext.j<gd0.g> r128 = r127.getHamletAvatarService();
        if (r128 == null) goto L75;
        gd0.g r129 = r128.getValue();
        if (r129 == null) goto L75;
        Long r130 = r129.Ue();
        if (r130 == null) goto L75;
        r106.put("avatar_id", String.valueOf(r130.longValue()));
    L75:
        String r131 = u0.j(r101);
        if (r131 == null) goto L78;
        r106.put("layout_type", r131);
    L78:
        zi0.d.b(r106, false);
        j0.l().sendLog("livesdk_live_guest_enlarge_over", r106, new Object[]{IRoom.class, am2.x.class});
        return;
    L62:
        if (r101.intValue() != 28) goto L64;
    L65:
        r126 = "avatar";
        goto L66
    L58:
        if (r121.intValue() == 28) goto L65;
    L42:
        if (r120.isMultiAvatarModeForReport() != true) goto L44;
    L17:
        if (je0.d.f() != 12) goto L19;
        TalkRoomLogUtils.x0(r106);
    L9:
        r103 = null;
        goto L10
    }
}
