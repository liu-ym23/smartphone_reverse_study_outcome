package com.obric.autoaction.app.launcherpage.automation;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.main.IMainTab;
import com.obric.autoaction.app.launcherpage.main.c;
import com.obric.event.task.base.report.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AutomationTab.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutomationTab implements IMainTab {
    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public int order() {
        return 200;
    }

    public AutomationTab() {
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public boolean onBackPressed() {
        return IMainTab.b.f(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public void onTabReselected() {
        IMainTab.b.c(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public void onTabUnselected() {
        IMainTab.b.b(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public boolean shouldShow() {
        return IMainTab.b.d(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public boolean titleBarMaskEnabled() {
        return IMainTab.b.e(this);
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public Class<? extends Fragment> fragmentClass() {
        return AutomationFragment.class;
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public c tabConfig(Context r4) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        String r5 = r3.getString(ZeusTransformUtils.mapRes(R.string.main_tab_automation, WsChannelMultiProcessSharedProvider.STRING_TYPE, "main_tab_automation"));
        o.c(r5, "getString(...)");
        return new c(r5, ZeusTransformUtils.mapRes(R.drawable.autoaciton_condition_tab_icon, "drawable", "autoaciton_condition_tab_icon"));
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public String tag() {
        return IMainTab.Companion.b();
    }

    @Override // com.obric.autoaction.app.launcherpage.main.IMainTab
    public void onTabSelected() {
        IMainTab.b.a(this);
        l.f32861a.a(tag());
    }
}
