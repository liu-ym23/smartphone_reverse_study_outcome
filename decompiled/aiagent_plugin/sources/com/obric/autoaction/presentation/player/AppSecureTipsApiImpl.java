package com.obric.autoaction.presentation.player;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.presentation.island.b;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.vdplayer.api.secure.ISecureTipsApi;
import com.obric.livecard.api.entity.CommonCollapseTemplate;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.Text;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: AppSecureTipsApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AppSecureTipsApiImpl implements ISecureTipsApi {
    public static final a Companion = null;
    private static final b playerSecIsland = null;

    /* JADX INFO: compiled from: AppSecureTipsApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public AppSecureTipsApiImpl() {
    }

    static {
        Companion = new a(null);
        playerSecIsland = new b(true, 0, null, "player_security", 6, null);
    }

    @Override // com.obric.autogui.vdplayer.api.secure.ISecureTipsApi
    public void showSecureTips() {
        b r7 = playerSecIsland;
        CommonCollapseTemplate r0 = com.obric.autoaction.presentation.island.template.a.a(com.obric.autoaction.presentation.island.template.a.f25101a, "svg:oic_shield", null, ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_privacy_protection, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_privacy_protection")), null, 10, null);
        Icon r1 = r0.getStartIcon();
        if (r1 == null) goto L5;
        r1.setWidth(24);
    L5:
        Icon r2 = r0.getStartIcon();
        if (r2 == null) goto L8;
        r2.setHeight(24);
    L8:
        Text r3 = r0.getEndText();
        if (r3 == null) goto L11;
        r3.setTextColor("#FFFFFFFF");
    L11:
        r7.a(CommonCollapseTemplate.create$default(r0, null, 1, null), null, true);
    }

    @Override // com.obric.autogui.vdplayer.api.secure.ISecureTipsApi
    public void hideSecureTips() {
        playerSecIsland.c(0);
    }
}
