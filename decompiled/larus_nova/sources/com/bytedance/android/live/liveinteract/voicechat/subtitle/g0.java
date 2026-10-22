package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedSubtitleMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.lynx.canvas.LynxGroupKryptonConfigs;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f80705a = 0;

    public static final class a extends b7.a {
        public a() {
        }
    }

    static {
    }

    public static boolean a(IRoom r100) {
        int r101 = c(r100);
        if (r101 != 1) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L15:
        return true;
    L11:
        if (c(r100) != 3) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == true) goto L15;
        return false;
    L13:
        r103 = false;
        goto L14
    L5:
        if (r101 == 2) goto L8;
        r102 = false;
        goto L9
    }

    public static boolean b(IRoom r100) {
        if (vm2.c.b().getGuestCanAdjustPublicScreen() == 0) goto L9;
        if (vm2.c.b().getGuestCanAdjustPublicScreen() != 2) goto L12;
        return true;
    L12:
        return false;
    L9:
        if (c(r100) == 0) goto L13;
        return true;
    L13:
        return false;
    }

    public static int c(IRoom r100) {
        if (r100 != null) goto L12;
        com.bytedance.live.datacontext.m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L18;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L19;
        String r103 = r102.getAnchorAbValue("audio_room_subtitle_opt");
        if (r103 != null) goto L11;
        return 0;
    L11:
        return CastIntegerProtector.parseInt(r103);
    L19:
        return 0;
    L18:
        return 0;
    L12:
        Map<String, String> r104 = r100.getAnchorABMap();
        if (r104 == null) goto L21;
        String r105 = r104.get("audio_room_subtitle_opt");
        if (r105 != null) goto L17;
        return 0;
    L17:
        return CastIntegerProtector.parseInt(r105);
    L21:
        return 0;
    }

    public static boolean d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        if (StringsKt.contains$default(r100, "audio_subtitle", false, 2, null) == true) goto L5;
        return false;
    L5:
        if (StringsKt.contains$default(r100, "subtitles", false, 2, null) == true) goto L7;
        return false;
    L7:
        if (StringsKt.contains$default(r100, "user_id", false, 2, null) == true) goto L9;
        return false;
    L9:
        if (StringsKt.contains$default(r100, "text", false, 2, null) == true) goto L11;
        return false;
    L11:
        if (StringsKt.contains$default(r100, "definite", false, 2, null) == true) goto L13;
        return false;
    L13:
        if (StringsKt.contains$default(r100, "sequence", false, 2, null) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public static void g(List r100) {
        Intrinsics.checkNotNullParameter(r100, "subtitleItemList");
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = ((nj0.g) r101.next()).f519410b;
        goto L4
    }

    public static List e(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "json");
        List r102 = GsonHelper.fromJsonArray(r100, nj0.h.class);
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        nj0.h r106 = (nj0.h) r105.next();
        String r107 = r106.d();
        String r108 = r106.c();
        LiveWrappedSubtitleMode r109 = LiveWrappedSubtitleMode.SUBTITLE_MODE_RECOGINTE;
        r103.add(new dg2.j(r107, r108, r106.b(), r106.a()));
        goto L4
    L6:
        Iterator r110 = r103.iterator();
    L8:
        if (r110.hasNext() == false) goto L23;
        nj0.g r111 = h((dg2.j) r110.next(), r101);
        int r112 = com.bytedance.android.live.liveinteract.voicechat.radio.e.f80544a;
        if (com.bytedance.android.live.liveinteract.voicechat.radio.e.d(gh0.a.d()) == false) goto L22;
        if (je0.d.f() != 0) goto L22;
        if (r111.f519409a != null) goto L22;
        com.bytedance.live.datacontext.m<IRoom> r113 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r113 == null) goto L20;
        IRoom r114 = r113.getValue();
        if (r114 == null) goto L20;
        IBaseUser r115 = r114.getOwner();
    L21:
        r111.f519409a = r115;
    L20:
        r115 = null;
    L22:
        r104.add(r111);
        goto L8
    L23:
        return r104;
    }

    public static HybridCard f(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r102 = new StringBuilder();
        String r103 = vm2.c.b().getSubtitlePatchUrl();
        if (r103.length() != 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        r103 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/audiochat_stage_douyin/pages/subtitle_patch/template.js?business_group=-1";
    L8:
        r102.append(r103);
        r102.append("&width=");
        r102.append(r101);
        r102.append("&height=");
        r102.append(LinkmicSubtitleUIWidget.f80656u);
        Uri r105 = x6.a.d(r102.toString());
        if (vm2.c.b().getSubtitleEnableEffect() == false) goto L11;
        r105 = UriProtector.parse(r105.toString()).buildUpon().appendQueryParameter(LynxGroupKryptonConfigs.CONFIG_ENABLE_CANVAS, "1").build();
    L11:
        HybridCard r106 = ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).getHybridCard(r100, r105, new a());
        if (r106 == null) goto L14;
        a7.a.a(r106, null, null, 3);
    L14:
        return r106;
    L5:
        r104 = false;
        goto L6
    }

    public static nj0.g h(dg2.j r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "subtitleMessage");
        nj0.g r102 = new nj0.g();
        Intrinsics.checkNotNullParameter(r100, "subtitleMessage");
        String r103 = r100.f468374a;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.f519410b = r103;
        String r105 = r100.f468375b;
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        r102.f519411c = r104;
        r102.f519412d = r100.f468376c;
        r102.f519413e = r100.f468377d;
        if (r101 == null) goto L21;
        Iterator r106 = r101.iterator();
    L13:
        if (r106.hasNext() == false) goto L17;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((ILinkPlayerInfoBridge) r107).getInteractId(), r100.f468374a) == false) goto L13;
    L18:
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r107;
        if (r108 == null) goto L21;
        r102.f519409a = r108.getUser();
        goto L21
    L17:
        r107 = null;
    L21:
        return r102;
    }
}
