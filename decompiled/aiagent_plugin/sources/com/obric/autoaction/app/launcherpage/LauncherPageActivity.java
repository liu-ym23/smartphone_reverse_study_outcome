package com.obric.autoaction.app.launcherpage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.main.MainFragment;
import com.obric.autoaction.app.launcherpage.ui.FluidColorfulBlobShader;
import com.obric.autoaction.app.launcherpage.ui.FluidColorfulBlobView;
import com.obric.autoaction.common.base.BaseActivity;
import com.obric.autogui.common.api.presentation.IAutoActionNotificationApi;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: LauncherPageActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LauncherPageActivity extends BaseActivity implements com.obric.autoaction.app.launcherpage.b.a {
    public static /* synthetic */ x lambda$g3OxD23KWebqjWYjosz_nTf0DGU(com.obric.autoaction.common.base.a r0) {
        return configExtension$lambda$0(r0);
    }

    @Override // com.obric.autoaction.common.base.BaseActivity
    public b<com.obric.autoaction.common.base.a, x> configExtension() {
        return $$Lambda$LauncherPageActivity$g3OxD23KWebqjWYjosz_nTf0DGU.INSTANCE;
    }

    public LauncherPageActivity() {
    }

    private static final x configExtension$lambda$0(com.obric.autoaction.common.base.a r5) {
        o.e(r5, "<this>");
        r5.a((com.obric.autoaction.common.base.b) ZeusTransformUtils.preCheckCast(new com.obric.autoaction.common.ext.b("main_page_detail", false, 2, null), com.obric.autoaction.common.base.b.class, "com.obric.aiagent.plugin"));
        return x.f38692a;
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r9) {
        super.onCreate(r9);
        BaseActivity.a.a(BaseActivity.Companion, (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 1, null);
        setContentView(ZeusTransformUtils.mapRes(R.layout.autoaction_main_activity, "layout", "autoaction_main_activity"));
        if (Build.VERSION.SDK_INT < 33) goto L11;
        FluidColorfulBlobView r10 = new FluidColorfulBlobView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
        r10.setSpeed(0.7f);
        r10.setTargetFrameRate(30);
        if (isNightMode() == false) goto L7;
        FluidColorfulBlobShader.a r0 = FluidColorfulBlobShader.Companion.b();
    L8:
        r10.setColorTheme(r0);
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout r1 = (FrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.container, DbHelper.COL_ID, "container")), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L11;
        r1.removeAllViews();
        r1.addView((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.aiagent.plugin"));
        goto L11
    L7:
        r0 = FluidColorfulBlobShader.Companion.a();
    L11:
        pushMainFragment();
        FragmentManager r11 = getSupportFragmentManager();
        Intent r8 = getIntent();
        if (r8 == null) goto L15;
        Bundle r12 = r8.getExtras();
        if (r12 == null) goto L15;
    L16:
        r11.a("activity_pass_though_params", r12);
        return;
    L15:
        r12 = new Bundle();
        goto L16
    }

    private final boolean isNightMode() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        clearAllHistoryNotifications();
    }

    @Override // com.obric.autoaction.common.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r2) {
        super.onNewIntent(r2);
        FragmentManager r1 = getSupportFragmentManager();
        if (r2 == null) goto L6;
        Bundle r3 = r2.getExtras();
        if (r3 == null) goto L6;
    L7:
        r1.a("activity_pass_though_params", r3);
        return;
    L6:
        r3 = new Bundle();
        goto L7
    }

    private final void pushMainFragment() {
        if (getSupportFragmentManager().b("MainFragment") != null) goto L6;
        Fragment r0 = (Fragment) ZeusTransformUtils.preCheckCast(new MainFragment(), Fragment.class, "com.obric.aiagent.plugin");
        getSupportFragmentManager().a().b(ZeusTransformUtils.mapRes(R.id.container, DbHelper.COL_ID, "container"), r0, "MainFragment").c();
        return;
    }

    private final void clearAllHistoryNotifications() {
        IAutoActionNotificationApi r2 = (IAutoActionNotificationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionNotificationApi.class), IAutoActionNotificationApi.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.tryCancelAllNotifiers();
        return;
    }

    @Override // com.obric.autoaction.app.launcherpage.b.a
    public OFloatingTitleBar getFloatingTransitionSourceTitleBar() {
        Fragment r3 = getSupportFragmentManager().b("MainFragment");
        if (ZeusTransformUtils.instanceOf(r3, MainFragment.class) == false) goto L5;
        MainFragment r4 = (MainFragment) ZeusTransformUtils.preCheckCast(r3, MainFragment.class, "com.obric.aiagent.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.getFloatingTitleBar();
    L5:
        r4 = null;
        goto L6
    }
}
