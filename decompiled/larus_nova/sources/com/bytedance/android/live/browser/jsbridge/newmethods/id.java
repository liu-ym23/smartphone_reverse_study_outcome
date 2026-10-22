package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.browser.jsbridge.base.UpdateLivePanelEffectResultModel;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.et0;
import com.bytedance.android.livesdk.config.f30;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.mf;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "updateLivePanelEffect")
public final class id extends w20.b7<mf, UpdateLivePanelEffectResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f63457a = 0;

    public static final class a {
    }

    static {
    }

    public id() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        mf r100 = (mf) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = r100.c();
        if (r101 != null) goto L5;
        String r102 = "";
    L6:
        String r103 = r100.a();
        if (r103 == null) goto L11;
        Long r104 = StringsKt.toLongOrNull(r103);
        if (r104 == null) goto L11;
        long r105 = r104.longValue();
    L12:
        boolean r112 = Intrinsics.areEqual(r100.d(), Boolean.TRUE);
        Bundle r113 = new Bundle();
        String r106 = r100.b();
        boolean r114 = true;
        if (r106 == null) goto L25;
        LiveSeiUtil.f71508i.getClass();     // Catch: Exception -> L23
        JSONObject r107 = LiveSeiUtil.c(r106);     // Catch: Exception -> L23
        r107.optString(MonitorConstants.EXTRA_DOWNLOAD_PAGE);     // Catch: Exception -> L23
        if (f30.f120173a.getValue().booleanValue() == true) goto L17;
    L21:
        r113.putBoolean("force_replace_other", r107.optBoolean("force_replace_other"));     // Catch: Exception -> L23
        r113.putString("replace_dialog_content", r107.optString("effect_replace_tip"));     // Catch: Exception -> L23
        r113.putString("challenge_id", r107.optString("upload_score_id"));     // Catch: Exception -> L23
        Unit r108 = Unit.INSTANCE;     // Catch: Exception -> L23
        goto L25
    L17:
        if (r107.optInt("interact_tool_version_type") != 1) goto L19;
        boolean r109 = true;
    L20:
        r113.putBoolean("extra_key_enable_debug_mode", r109);     // Catch: Exception -> L23
        r113.putString("extra_key_debug_schema_url", r107.optString("interact_tool_debug_schema"));     // Catch: Exception -> L23
        goto L21
    L19:
        r109 = false;
    L25:
        if (et0.f120153a.getValue().booleanValue() == false) goto L27;
    L39:
        RoomContext.a r115 = RoomContext.Companion;
        RoomContext r116 = RoomContext.a.c(r115, null, 0, 3);
        if (r116 == null) goto L55;
        com.bytedance.live.datacontext.i<Boolean> r117 = r116.isAnchor();
        if (r117 == null) goto L55;
        if (r117.getValue().booleanValue() != true) goto L55;
        RoomContext r118 = RoomContext.a.c(r115, null, 0, 3);
        if (r118 == null) goto L50;
        com.bytedance.live.datacontext.i<LiveMode> r119 = r118.getLiveMode();
        if (r119 == null) goto L50;
        LiveMode r120 = r119.getValue();
    L52:
        if (r120 == LiveMode.VIDEO) goto L55;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_sticker_not_support_non_video_room_toast, 0);
        finishWithFailure();
        return;
    L50:
        r120 = null;
    L55:
        if (r102.length() == 0) goto L59;
        r114 = false;
    L59:
        if (r114 == true) goto L82;
        if (r105 == 0) goto L82;
        if (Intrinsics.areEqual(r102, "zongyiyouxi") == false) goto L66;
        xs2.b.a().post(new zg1.p(r102, String.valueOf(r105), r112, new ld(this)));
        return;
    L66:
        String r121 = com.bytedance.android.live.effect.api.d0.f66754d;
        if (Intrinsics.areEqual(r102, r121) == false) goto L72;
        if (RoomContext.a.c(r115, null, 0, 3) != null) goto L72;
        xs2.b.a().post(new zg1.l2());
        finishWithFailure();
        return;
    L72:
        if (ft0.f120230a.getValue().b() == true) goto L74;
    L80:
        List<String> r122 = LiveEffectContext.f66734h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).d().fetchEffect(String.valueOf(r105), new nd(this, r102, r112, r100, r105, r113));
        return;
    L74:
        if (Intrinsics.areEqual(r102, r121) == false) goto L80;
        RoomContext r123 = RoomContext.a.c(r115, null, 0, 3);
        if (r123 == null) goto L80;
        com.bytedance.live.datacontext.n<String> r124 = r123.getDownLoadingInteractEffectId();
        if (r124 == null) goto L80;
        r124.setValue(String.valueOf(r105));
    L82:
        if (Intrinsics.areEqual(r102, "zongyiyouxi") == false) goto L85;
        if (r112 == true) goto L85;
        xs2.b.a().post(new zg1.p(r102, "", false, new kd(this)));
    L85:
        finishWithFailure();
        return;
    L27:
        if (ft0.f120230a.getValue().b() == false) goto L39;
        if (Intrinsics.areEqual(r102, com.bytedance.android.live.effect.api.d0.f66753c) == false) goto L39;
        List<String> r125 = LiveEffectContext.f66734h;
        if ((!LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a().o(com.bytedance.android.live.effect.api.d0.f66754d).isEmpty()) == false) goto L39;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_anchor_interactive_extension_conflict_popup", MapsKt.mapOf(TuplesKt.to("action_type", "show")), new Object[]{IRoom.class});
        View r126 = LayoutInflater.from(r111.getContext()).inflate(R.layout.ttlive_view_dialog_text, null);
        TextView r127 = (TextView) r126.findViewById(R.id.title);
        TextView r128 = (TextView) r126.findViewById(R.id.sub_title);
        r127.setText("请先退出当前互动工具");
        r128.setText("最多可同时使用一种特效/互动工具");
        com.bytedance.android.livesdk.widget.z0 r129 = com.bytedance.android.livesdk.widget.z0.a();
        Context r130 = r111.getContext();
        r129.getClass();
        com.bytedance.android.livesdk.widget.x0.d r131 = new com.bytedance.android.livesdk.widget.x0.d();
        r131.f162243b = r130;
        r131.f162242a = 4;
        r131.f162253l = false;
        r131.f162247f = r126;
        jd r132 = jd.f63495a;
        com.bytedance.android.livesdk.widget.x0.c[] r133 = r131.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r134 = r133[0];
        if (r134 != null) goto L35;
        r134 = new com.bytedance.android.livesdk.widget.x0.c();
        r133[0] = r134;
    L35:
        r134.f162239a = "我知道了";
        r134.f162240b = r132;
        com.bytedance.android.livesdk.widget.x0.c[] r135 = r131.f162248g;
        com.bytedance.android.livesdk.widget.x0.c r136 = r135[0];
        if (r136 != null) goto L38;
        r136 = new com.bytedance.android.livesdk.widget.x0.c();
        r135[0] = r136;
    L38:
        r136.f162241c = true;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r131.f162243b, r131));
        finishWithFailure();
        return;
    L11:
        r105 = 0;
        goto L12
    L5:
        r102 = r101;
        goto L6
    }
}
