package bi0;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdk.sharedpref.d;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import xh0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f19076a;

    static {
        f19076a = "";
    }

    public static void b(Context r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        boolean r103 = true;
        if (r102 == null) goto L9;
        IRoom r104 = r102.getValue();
        if (r104 == null) goto L9;
        if (r104.isLiveTypeAudio() != true) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
        boolean r106 = d.a();
    L13:
        if (r106 == true) goto L16;
        f2.b(R.string.ttlive_adventure_should_open_guest_gift_switch, 0);
        return;
    L16:
        AdventureContext.Companion.getClass();
        if (AdventureContext.a.a() == false) goto L24;
        a(r100, vm2.d.n().closePanelSchema, vm2.d.n().closePanelUrl, r101);
        if (r101 == null) goto L22;
        String r107 = (String) r101.get("request_page");
        if (r107 == null) goto L22;
    L23:
        f19076a = r107;
        return;
    L22:
        r107 = "";
        goto L23
    L24:
        IInteractService r108 = (IInteractService) k.f(IInteractService.class);
        g r109 = null;
        if (r108 == null) goto L29;
        xh0.d r110 = r108.getPlayModeService();
        if (r110 == null) goto L29;
        r109 = r110.a(29, null);
    L29:
        if (r109 != null) goto L31;
    L39:
        e<Boolean> r111 = b6.f65221J;
        if (r111.getValue().booleanValue() == false) goto L42;
        a(r100, vm2.d.n().startPanelSchema, vm2.d.n().startPanelUrl, r101);
        return;
    L42:
        a(r100, vm2.d.n().guidePanelSchema, vm2.d.n().guidePanelUrl, r101);
        f.d(r111, Boolean.TRUE);
        return;
    L31:
        if (r109.f563849c == true) goto L39;
        if (r109.f563851e.length() > 0) goto L36;
        r103 = false;
    L36:
        if (r103 == false) goto L39;
        f2.c(r109.f563851e, 0);
        return;
    L12:
        r106 = d.b();
    L9:
        r105 = false;
        goto L10
    }

    public static void a(Context r100, String r101, String r102, Map r103) {
        ALogger.i("Adventure#ToolbarAdventureBehavior", "onClick#openStartPanel.schema:" + r101 + ",url:" + r102 + ",params:" + r103);
        boolean r104 = false;
        if (r101.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        return;
    L8:
        if (r102.length() != 0) goto L10;
        r104 = true;
    L10:
        if (r104 == true) goto L50;
        u6 r106 = new u6(r101);
        r106.b("url", r102);
        u6 r107 = r106.d("url");
        if (r103 == null) goto L18;
        Iterator r108 = r103.entrySet().iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        Map.Entry r109 = (Map.Entry) r108.next();
        r107.b((String) r109.getKey(), (String) r109.getValue());
    L18:
        m<IRoom> r110 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r111 = null;
        if (r110 == null) goto L21;
        IRoom r112 = r110.getValue();
    L22:
        LinkedHashMap r113 = new LinkedHashMap();
        if (r112 == null) goto L25;
        r111 = Long.valueOf(r112.getId());
    L25:
        r113.put("room_id", String.valueOf(r111));
        if (r112 == null) goto L29;
        String r114 = r112.getOwnerUserIdString();
        if (r114 == null) goto L29;
    L30:
        r113.put("anchor_id", r114);
        i<ILinkPlayerInfoBridge> r115 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r115 == null) goto L34;
        String r116 = String.valueOf(r115.b());
        if (r116 == null) goto L34;
    L35:
        r113.put("user_cnt", r116);
        r113.put("action_from", "start");
        r113.put("function_type", ((IInteractService) k.n(IInteractService.class)).getCurrentFunctionType());
        if (r112 != null) goto L38;
    L40:
        String r117 = "video_live";
    L41:
        r113.put("live_type", r117);
        Iterator r118 = r113.entrySet().iterator();
    L43:
        if (r118.hasNext() == false) goto L45;
        Map.Entry r119 = (Map.Entry) r118.next();
        r107.b((String) r119.getKey(), (String) r119.getValue());
        goto L43
    L45:
        ((IBaseLiveActionHandler) k.n(IBaseLiveActionHandler.class)).handle(r100, r106.c());
        return;
    L38:
        if (r112.isLiveTypeAudio() != true) goto L40;
        r117 = "voice_live";
    L34:
        r116 = "0";
    L29:
        r114 = "";
        goto L30
    L21:
        r112 = null;
        goto L22
    L50:
        return;
    L5:
        r105 = false;
        goto L6
    }
}
