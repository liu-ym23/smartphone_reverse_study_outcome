package com.obric.autoaction.presentation.island.donation;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.island.b;
import com.obric.autoaction.presentation.island.c;
import com.obric.autoaction.presentation.island.template.DataDonationCardTemplate;
import com.obric.autoaction.presentation.island.template.TextButton;
import com.obric.autoaction.presentation.island.template.TitleWithIcon;
import com.obric.autoaction.presentation.island.template.a;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.screen.capture.IDonationApi;
import com.obric.autogui.common.api.presentation.IDonationTaskStateApi;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.Text;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: DonationTaskStateHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DonationTaskStateImpl implements IDonationTaskStateApi {
    public static /* synthetic */ x lambda$lyvwZKNdQbrY4sMs5d3RNRZRwuU() {
        return createOrUpdate$lambda$1$lambda$0();
    }

    public DonationTaskStateImpl() {
    }

    @Override // com.obric.autogui.common.api.presentation.IDonationTaskStateApi
    public void create() {
        createOrUpdate(0);
    }

    @Override // com.obric.autogui.common.api.presentation.IDonationTaskStateApi
    public void updateStep(int r1) {
        createOrUpdate(r1);
    }

    @Override // com.obric.autogui.common.api.presentation.IDonationTaskStateApi
    public void end() {
        c.a().c(0);
    }

    private final void createOrUpdate(int r28) {
        b r0 = c.a();
        Icon r11 = new Icon(20, 22, "svg:right_hand_point_up", null, null, null, null, 120, null);
        String r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_widget_step_count, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_widget_step_count"), new Object[]{Integer.valueOf(r28)});
        o.c(r1, "getString(...)");
        IslandWidget r2 = CommonCollapseTemplate.create$default(new CommonCollapseTemplate(null, new Text(r1, 14, a.a(a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_ai_a_color3_6, "color", "oui_ai_a_color3_6"), false, 2, null)), r11, null, 9, null), null, 1, null);
        TitleWithIcon r3 = new TitleWithIcon(new Icon(20, 20, "svg:right_hand_point_up", null, null, null, null, 120, null), new Text(a.f25101a.a(ZeusTransformUtils.mapRes(R.string.obric_operate_record, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_operate_record")), 14, "#FFFFFFFF"));
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_current_step_count, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_current_step_count"), new Object[]{Integer.valueOf(r28)});
        o.c(r5, "getString(...)");
        IslandWidget r4 = new DataDonationCardTemplate(r3, new Text(r5, 16, "var:ai-gradient-a3"), new Text(a.f25101a.a(ZeusTransformUtils.mapRes(R.string.obric_donation_task_operate_record_tip, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_donation_task_operate_record_tip")), 12, a.a(a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_3, "color", "oui_on_accent_text_3"), false, 2, null)), new TextButton("finish_task", new Icon(22, 22, "svg:leading", null, null, null, null, 120, null), new Text(a.f25101a.a(ZeusTransformUtils.mapRes(R.string.obric_task_finish, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_task_finish")), 14, a.a(a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_functional_red_7, "color", "oui_functional_red_7"), false, 2, null)), a.a(a.f25101a, ZeusTransformUtils.mapRes(R.color.oui_functional_red_2, "color", "oui_functional_red_2"), false, 2, null), null, 16, null)).create(true);
        r4.addOnViewClickCallback("finish_task", $$Lambda$DonationTaskStateImpl$lyvwZKNdQbrY4sMs5d3RNRZRwuU.INSTANCE);
        x r6 = x.f38692a;
        r0.a(r2, r4, true);
    }

    private static final x createOrUpdate$lambda$1$lambda$0() {
        c.a().c(0);
        IDonationApi r0 = (IDonationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDonationApi.class), IDonationApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L6;
        r0.onFinishTaskClick();
    L6:
        return x.f38692a;
    }
}
