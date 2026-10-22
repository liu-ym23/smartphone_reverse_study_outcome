package com.bytedance.android.livesdk.dislike.action;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.chatroom.utils.k1;
import com.bytedance.android.livesdk.dislike.ActionsManager;
import com.bytedance.android.livesdk.utils.i1;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class l extends OptionAction {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ActionsManager f122081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.user.f f122082f;

    @Override // com.bytedance.android.livesdk.dislike.action.OptionAction
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        g(false, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK);
    }

    public l(ActionsManager r100, com.bytedance.android.live.base.model.user.f r101) {
        Intrinsics.checkNotNullParameter(r100, "actionsManager");
        Intrinsics.checkNotNullParameter(r101, "contact");
        super(r100);
        this.f122081e = r100;
        this.f122082f = r101;
    }

    public final void g(boolean r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "sharePlatform");
        mt1.a r100 = new mt1.a(3, this.f122048b, this.f122081e.f121952e, null, false, 24);
        com.bytedance.android.live.base.model.user.f r101 = this.f122082f;
        r101.f58942c = r110;
        r100.f515595a = r101;
        xs2.b.a().post(r100);
        com.bytedance.android.live.base.model.user.f r102 = this.f122082f;
        com.bytedance.android.livesdk.log.filter.o r103 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r104 = "";
        if (r103.getMap().containsKey("enter_from_merge") == false) goto L5;
        String r105 = r103.getMap().get("enter_from_merge");
    L7:
        if (r103.getMap().containsKey("enter_method") == false) goto L9;
        String r106 = r103.getMap().get("enter_method");
    L11:
        if (r103.getMap().containsKey("action_type") == false) goto L13;
        String r107 = r103.getMap().get("action_type");
    L15:
        if (tb1.c.f545229a == false) goto L17;
        r105 = k1.c();
    L17:
        HashMap r108 = new HashMap();
        r108.put("enter_from_merge", r105);
        r108.put("enter_method", r106);
        r108.put("action_type", r107);
        r108.put(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r111);
        r108.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_detail");
        r108.put("is_vr_machine", VrUtils.o(this.f122081e.f121953f));
        if (r110 == false) goto L20;
        r108.put("is_outer_head", "1");
    L20:
        Map<String, String> r112 = ((ILiveShareService) jc1.k.n(ILiveShareService.class)).getToUserConversationId(r102);
        if (r112 != null) goto L23;
    L28:
        String r113 = r103.getMap().get("is_second_label");
        if (r113 != null) goto L31;
        r113 = "";
    L31:
        r108.put("is_second_label", r113);
        String r114 = r103.getMap().get("is_self_shared");
        if (r114 == null) goto L35;
        r104 = r114;
    L35:
        r108.put("is_self_shared", r104);
        if (TextUtils.isEmpty(r102.f58941b) == true) goto L38;
        r108.put("is_from_shopping_guide", "1");
        r108.put("shopping_guide_id", r102.f58941b);
    L38:
        r108.putAll(com.bytedance.android.livesdk.locallife.g.a(this.f122048b, (String) r108.get(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID)));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_share", r108, new Object[]{Room.class, am2.n.f(), am2.x.class});
        int r115 = i1.f158983a;
        Room r116 = this.f122048b;
        Map<String, String> r109 = ((ILiveShareService) jc1.k.n(ILiveShareService.class)).getToUserConversationId(this.f122082f);
        if (Intrinsics.areEqual(r111, com.bytedance.android.ec.core.event.a.VALUE_LONG_CLICK) == false) goto L41;
        String r117 = "press";
    L42:
        i1.c(r116, r109, r117);
        return;
    L41:
        r117 = "click";
        goto L42
    L23:
        if (r112.containsKey("conversation_id") == false) goto L26;
        r108.put("conversation_id", r112.get("conversation_id"));
        goto L28
    L26:
        if (r112.containsKey(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID) == false) goto L28;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID, r112.get(com.bytedance.android.ec.core.event.a.KEY_TO_USER_ID));
        goto L28
    L13:
        r107 = "";
        goto L15
    L9:
        r106 = "";
        goto L11
    L5:
        r105 = "";
        goto L7
    }
}
