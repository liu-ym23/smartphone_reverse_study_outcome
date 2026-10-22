package cj0;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.paid.viewmodel.PaidLinkMicContext;
import com.bytedance.android.live.liveinteract.videotalk.utils.b0;
import com.bytedance.android.livesdk.config.wd1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ttm.player.MediaPlayer;
import hh1.t0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import tf0.o;

/* JADX INFO: loaded from: classes46.dex */
public final class h {
    public static final boolean a() {
        xh0.d r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getPlayModeService();
        xh0.g r101 = null;
        if (r100 == null) goto L6;
        r101 = r100.a(11, null);
    L6:
        if (r101 != null) goto L8;
    L16:
        return false;
    L8:
        if (r101.f563849c == true) goto L16;
        if (r101.f563851e.length() <= 0) goto L12;
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        f2.c(r101.f563851e, 0);
        return true;
    L12:
        r102 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(Context r110, String r111) {
        ReadOnlyProperty r100 = vm2.d.f556011x4;
        KProperty<?>[] r101 = vm2.d.f555776a;
        IRoom r102 = null;
        String r103 = ((wd1) r100.getValue(null, r101[281(0x119, float:3.94E-43)])).b();
        String r104 = ((wd1) r100.getValue(null, r101[281(0x119, float:3.94E-43)])).a();
        LinkedHashMap r105 = new LinkedHashMap();
        r105.put("scene", String.valueOf(((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene()));
        String r106 = "1";
        String r107 = "0";
        if (fj0.e.k() == false) goto L5;
        Object[] r108 = "1";
    L6:
        r105.put("isOpen", r108);
        m<IRoom> r109 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r109 == null) goto L9;
        IRoom r112 = r109.getValue();
    L11:
        if (fj0.e.g(r112) == false) goto L13;
        Object[] r113 = "1";
    L14:
        r105.put("optran_paid_linkmic", r113);
        r105.put("showLinkmicMode", "0");
        PaidLinkMicContext.a r114 = PaidLinkMicContext.Companion;
        boolean r115 = true;
        if (r114 == null) goto L21;
        c r116 = r114.a();
        if (r116 == null) goto L21;
        if (r116.isPaidLinkOn() != true) goto L21;
        r105.put("linkmicMode", "2");
    L21:
        m<IRoom> r117 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r117 == null) goto L27;
        IRoom r118 = r117.getValue();
        if (r118 == null) goto L27;
        String r119 = String.valueOf(r118.getId());
        if (r119 == null) goto L27;
    L28:
        r105.put("room_id", r119);
        if (je0.d.u() == false) goto L31;
        String r120 = "voice_live";
    L32:
        r105.put("live_type", r120);
        r105.put("function_type", TalkRoomLogUtils.g());
        String r121 = u0.j(je0.d.h());
        if (r121 == null) goto L35;
        r105.put("layout_type", r121);
    L35:
        r105.put("function_type2", TalkRoomLogUtils.f77440h);
        o r122 = b0.c();
        if (r122 == null) goto L42;
        t0 r123 = r122.C();
        if (r123 == null) goto L42;
        if (r123.isDynamic() != true) goto L42;
    L43:
        if (r115 == true) goto L46;
        r106 = "0";
    L46:
        r105.put("seat_fit_status", r106);
        r105.put("source", r111);
        Integer r124 = je0.d.h();
        if (r124 == null) goto L52;
        String r125 = String.valueOf(r124.intValue());
        if (r125 == null) goto L52;
        r107 = r125;
    L52:
        r105.put("ui_layout", r107);
        UrlBuilder r126 = new UrlBuilder(r103);
        Iterator r127 = r105.entrySet().iterator();
    L54:
        if (r127.hasNext() == false) goto L56;
        Map.Entry r128 = (Map.Entry) r127.next();
        r126.addParam((String) r128.getKey(), (String) r128.getValue());
        goto L54
    L56:
        String r129 = r126.build();
        Uri.Builder r130 = UriProtector.parse(r104).buildUpon();
        if (je0.d.u() == true) goto L59;
        boolean r131 = tb1.d.f545237a;
        int r132 = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER;
    L60:
        m<IRoom> r133 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r133 == null) goto L64;
        r102 = r133.getValue();
    L64:
        if (fj0.e.g(r102) == false) goto L66;
        r132 = r132 + 20;
    L66:
        ((IBaseLiveActionHandler) jc1.k.n(IBaseLiveActionHandler.class)).handle(r110, r130.appendQueryParameter("height", String.valueOf(r132)).appendQueryParameter("url", r129).build().toString());
        if (fj0.e.k() == true) goto L69;
        fj0.a r134 = fj0.b.f477460a;
        r134.getClass();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r134.f477451a = r111;
    L69:
        fj0.a r135 = fj0.b.f477460a;
        if (fj0.e.k() == false) goto L72;
        String r136 = "change";
    L73:
        r135.getClass();
        Intrinsics.checkNotNullParameter(r136, "<set-?>");
        MultiLinkEventModule r137 = com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.f71493a;
        boolean r138 = fj0.e.k();
        Intrinsics.checkNotNullParameter(r111, "source");
        JSONObject r139 = new JSONObject();
        r139.put("source", r111);
        r139.put("isOpen", r138 ? 1 : 0);
        nd0.c.p(nd0.c.f518746a, LinkMonitorData.OpenPaidLinkMicLynxPanel, r139, com.bytedance.android.live.liveinteract.api.fulllink.revenue.g.f71493a, 0, null, false, null, 120);
        return;
    L72:
        r136 = "open";
        goto L73
    L59:
        r132 = 290;
    L42:
        r115 = false;
        goto L43
    L31:
        r120 = "video_live";
    L27:
        r119 = "";
        goto L28
    L13:
        r113 = "0";
        goto L14
    L9:
        r112 = null;
        goto L11
    L5:
        r108 = "0";
        goto L6
    }
}
