package com.obric.autoaction.app.launcherpage.knowledge.a;

import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: TitleBarViewExt.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ x lambda$NkeYOvCFdCdf8zhHsaY3SaJp8tM(View.OnClickListener r0, View.OnClickListener r1, OFloatingTitleBar r2) {
        return a(r0, r1, r2);
    }

    public static final void a(OFloatingTitleBar r2, View.OnClickListener r3, View.OnClickListener r4) {
        final View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
        final View.OnClickListener r6 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r4, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r2, "titleBar");
        o.e(r5, "cancelClickListener");
        o.e(r6, "saveClickListener");
        r2.batchSet(false, new $$Lambda$a$NkeYOvCFdCdf8zhHsaY3SaJp8tM(r5, r6));
    }

    private static final x a(View.OnClickListener r12, View.OnClickListener r13, OFloatingTitleBar r14) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r12, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r14, "$this$batchSet");
        OFloatingTitleBar.removeAllEndAction$default(r14, false, 1, null);
        OFloatingTitleBar.removeAllStartAction$default(r14, false, 1, null);
        r14.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        r14.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Primary_Icon, "style", "OStyleV2_OButtonFloating_S_Primary_Icon"));
        OFloatingTitleBar.addStartAction$default(r14, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, r5, 2, null);
        OFloatingTitleBar.addEndAction$default(r14, ZeusTransformUtils.mapRes(R.drawable.oic_check, "drawable", "oic_check"), 0, r9, 2, null);
        r14.setCenterTitle(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_edit_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_edit_title"));
        return x.f38692a;
    }

    public static final void b(OFloatingTitleBar r12, View.OnClickListener r13, View.OnClickListener r14) {
        View.OnClickListener r5 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r13, View.OnClickListener.class, "com.obric.aiagent.plugin");
        View.OnClickListener r9 = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r14, View.OnClickListener.class, "com.obric.aiagent.plugin");
        o.e(r12, "titleBar");
        o.e(r5, "onExitClickListener");
        o.e(r9, "onMoreClickListener");
        OFloatingTitleBar.removeAllEndAction$default(r12, false, 1, null);
        OFloatingTitleBar.removeAllStartAction$default(r12, false, 1, null);
        r12.setStartButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        r12.setEndButtonGroupStyle(ZeusTransformUtils.mapRes(R.style.OStyleV2_OButtonFloating_S_Standard_Icon, "style", "OStyleV2_OButtonFloating_S_Standard_Icon"));
        r12.setCenterTitle(ZeusTransformUtils.mapRes(R.string.instruction_knowledge_read_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "instruction_knowledge_read_title"));
        OFloatingTitleBar.addStartAction$default(r12, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, r5, 2, null);
        OFloatingTitleBar.addEndAction$default(r12, ZeusTransformUtils.mapRes(R.drawable.main_fragment_more_menu, "drawable", "main_fragment_more_menu"), 0, r9, 2, null);
    }
}
