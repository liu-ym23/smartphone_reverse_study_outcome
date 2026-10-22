package com.bytedance.android.live.anchormodelink.linkroom;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.anchormodelink.util.JsbParamParseUtil;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.s;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ly.u;
import qh0.f;
import qh0.g;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InteractBeautyPreviewDialog f58749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public oy.d f58750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Boolean> f58751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f58752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f58753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.anchormodelink.gift.d f58754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f58755g;

    public final void a(my.c r110, final k r111) {
        Intrinsics.checkNotNullParameter(r110, "updateStatus");
        Intrinsics.checkNotNullParameter(r111, "updateCallback");
        int r100 = b.f58740a[r110.getType().ordinal()];
        if (r100 == 1) goto L80;
        int r101 = 2;
        if (r100 != 2) goto L7;
        JsonObject r112 = r110.f516353b;
        if (r112 == null) goto L75;
        JsonElement r113 = r112.get("permission_type");
        if (r113 == null) goto L75;
        String r114 = r113.getAsString();
        if (r114 == null) goto L75;
    L76:
        Context r102 = this.f58752d;
        boolean r115 = Intrinsics.areEqual(r114, "video");
        OperateType r103 = OperateType.APPLY;
        if (r115 == false) goto L79;
        r101 = 1;
    L79:
        ArrayList r116 = new ArrayList();
        r116.add(g.a(r103, r101));
        r116.add(new f.g(r102, r103, r101));
        r116.add(new f.c(r102, r103, r101));
        r116.add(new f.a(r102));
        r116.add(new f.C7326f(r102, r103, r101, true));
        r116.add(new f.e(r102, r103));
        s r117 = f.a(r116);
        boolean r104 = iy.b.f496463a;
        iy.b.d("[LinkBasicJsbHandler] checkPermission linkType=" + r101);
        r117.a(new c(r101, r111));
        return;
    L75:
        r114 = "audio";
        goto L76
    L7:
        if (r100 != 3) goto L9;
        boolean r105 = iy.b.f496463a;
        iy.b.d("[LinkBasicJsbHandler] sendPrivateInvite:" + r110.f516353b);
        JsonObject r118 = r110.f516353b;
        if (r118 == null) goto L68;
        final String r106 = r118.get("action").getAsString();
        final boolean r107 = r118.get("needPush").getAsBoolean();
        User r119 = (User) GsonHelper.getDefault().fromJson(r118.get("friend").getAsJsonObject(), User.class);     // Catch: Exception -> L66
        iy.b.d("[LinkBasicJsbHandler] sendPrivateInvite user:{" + r119.getIdString() + HttpClient.ENDFLAG + r119.getNickName() + '}');     // Catch: Exception -> L66
        IMiddlewareHostSocial r108 = (IMiddlewareHostSocial) jc1.k.f(IMiddlewareHostSocial.class);     // Catch: Exception -> L66
        if (r108 == null) goto L64;
        r108.inviteFriendByIM(this.f58752d, r119, new LinkBasicJsbHandler$sendPrivateInvite$$inlined$let$lambda$1(r107, r106, this, r111));     // Catch: Exception -> L66
    L64:
        r111.a(1, "success", null);     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        boolean r109 = iy.b.f496463a;
        iy.b.b("[LinkBasicJsbHandler] sendPrivateInvite parse user error:" + e.getMessage());
    L68:
        r111.a(0, "fail", null);
        return;
    L9:
        if (r100 != 4) goto L92;
        int r120 = JsbParamParseUtil.f58790a;
        JsonObject r121 = r110.f516353b;
        if (r121 != null) goto L86;
    L28:
        oy.d r122 = null;
    L29:
        this.f58750b = r122;
        boolean r123 = iy.b.f496463a;
        iy.b.d("[LinkBasicJsbHandler] layoutDidChange publicScreenInfo=" + r122);
        if (r122 == null) goto L57;
        float r124 = r122.f527115b;
        float r125 = 0;
        if (r124 <= r125) goto L36;
        int r126 = (int) r124;
        DataCenter r127 = this.f58753e;
        if (r127 == null) goto L39;
        r127.put("data_common_talk_room_match_screen", Integer.valueOf(r126));
    L39:
        float r128 = r122.f527114a;
        if (r128 <= r125) goto L49;
        float r129 = UtilityKotlinExtentionsKt.h(r128);
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r130 = InteractionWidgetsPosContext.a.a();
        if (r130 == null) goto L46;
        m<Integer> r131 = r130.getAudioTalkRadioPublicScreenTopMargin();
        if (r131 == null) goto L46;
        r131.setValue(Integer.valueOf((int) r129));
    L46:
        DataCenter r132 = this.f58753e;
        if (r132 == null) goto L57;
        r132.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME start"));
        goto L57
    L49:
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r133 = InteractionWidgetsPosContext.a.a();
        if (r133 == null) goto L54;
        m<Integer> r134 = r133.getAudioTalkRadioPublicScreenTopMargin();
        if (r134 == null) goto L54;
        r134.setValue(0);
    L54:
        DataCenter r135 = this.f58753e;
        if (r135 == null) goto L57;
        r135.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME reset"));
        goto L57
    L36:
        DataCenter r136 = this.f58753e;
        if (r136 == null) goto L39;
        r136.put("data_common_talk_room_match_screen", 12);
    L57:
        r111.a(1, "success", null);
        return;
    L86:
        JsonElement r137 = r121.get("offset_top");     // Catch: Exception -> L26
        float r138 = 0.0f;
        if (r137 == null) goto L17;
        float r139 = r137.getAsFloat();     // Catch: Exception -> L26
    L18:
        JsonElement r140 = r121.get("offset_right");     // Catch: Exception -> L26
        if (r140 == null) goto L22;
        r138 = r140.getAsFloat();     // Catch: Exception -> L26
    L22:
        if (r138 <= 0) goto L24;
        r138 = r138 + 12.0f;     // Catch: Exception -> L26
    L24:
        r122 = new oy.d(r139, r138);     // Catch: Exception -> L26
        goto L29
    L17:
        r139 = 0.0f;
    L26:
        e = move-exception;
        boolean r141 = iy.b.f496463a;
        StringBuilder r142 = new StringBuilder("getPublicScreenConfig parseJson error:");
        e.printStackTrace();
        r142.append(Unit.INSTANCE);
        iy.b.b(r142.toString());
        goto L28
    L92:
        return;
    L80:
        ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).setOnNeedMuteAudioFullPage(true);
        IMiddlewareHostSocial r143 = (IMiddlewareHostSocial) jc1.k.f(IMiddlewareHostSocial.class);
        if (r143 == null) goto L91;
        r143.showInviteFriendActivity(this.f58752d, new LinkBasicJsbHandler$inviteMore$1(this, r111));
        return;
    }

    public e(Context r100, DataCenter r101, com.bytedance.android.live.anchormodelink.gift.d r102, AnchorModeLinkDynamicWidget.c r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "basicProvider");
        this.f58752d = r100;
        this.f58753e = r101;
        this.f58754f = r102;
        this.f58755g = r103;
        this.f58751c = new LinkBasicJsbHandler$userListFilterAction$1(this);
    }
}
