package com.obric.autoaction.app.launcherpage.condition.config.condition;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.rom.IRomInfoKt;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.strategy.IAutoActionPlatformStrategyApi;
import com.obric.autogui.common.api.platform.strategy.SensitiveOperation;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LocationPermissionUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f23036a = null;

    static {
        f23036a = new h();
    }

    private h() {
    }

    public static final /* synthetic */ void a(h r2, Context r3) {
        r2.c((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"));
    }

    public final boolean a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        o.e(r6, "ctx");
        IAutoActionPlatformStrategyApi r0 = AOPlatformTools.INSTANCE.platformStrategy();
        if (r0 == null) goto L5;
        IAutoActionPlatformStrategyApi.SensitiveOpStrategy r1 = r0.checkSensitiveOp((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), SensitiveOperation.ACCESS_FINE_LOCATION);
    L7:
        if (r1 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == true) goto L15;
        b(r6);
        return false;
    L15:
        return true;
    L9:
        if (r1.isAllowed() != true) goto L11;
        r2 = true;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    private final void b(Context r21) {
        final Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.aiagent.plugin");
        com.obric.oui.dialog.v2.alert.a r8 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a(r0).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(r0.getString(ZeusTransformUtils.mapRes(R.string.location_permission_dialog_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "location_permission_dialog_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(r0.getString(ZeusTransformUtils.mapRes(R.string.location_permission_dialog_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "location_permission_dialog_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r2 = r0.getString(ZeusTransformUtils.mapRes(R.string.oauto_permission_enable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_enable"));
        o.c(r2, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r14 = com.obric.oui.dialog.v2.alert.a.a(r8, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new LocationPermissionUtils$showPermissionRequestDialog$1(r0), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null);
        String r1 = r0.getString(ZeusTransformUtils.mapRes(R.string.app_btn_close, WsChannelMultiProcessSharedProvider.STRING_TYPE, "app_btn_close"));
        o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a.b(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new LocationPermissionUtils$showPermissionRequestDialog$2(), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null).h();
    }

    private final void c(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        if (a() == true) goto L9;
    L6:
        ZeusTransformUtils.startActivity(r7, b(), "com.obric.aiagent.plugin");
        return;
    L9:
        Intent r0 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: Exception -> L8
        r0.setData(Uri.fromParts("package", AOSystemTools.INSTANCE.getHostAppPackage(), null));     // Catch: Exception -> L8
        r0.addFlags(268435456);     // Catch: Exception -> L8
        ZeusTransformUtils.startActivity(r7, r0, "com.obric.aiagent.plugin");     // Catch: Exception -> L8
    }

    private final boolean a() {
        return o.a(ObricProductSdk.INSTANCE.platformService().romInfo().getRomReleaseRegion(), IRomInfoKt.REGION_HK);
    }

    private final Intent b() {
        ComponentName r2 = new ComponentName("com.android.permissioncontroller", "com.android.permissioncontroller.permissionplus.ui.AppPermissionStateActivity");
        Intent r0 = new Intent();
        r0.setComponent(r2);
        r0.putExtra("packageName", "com.larus.nova");
        r0.putExtra("permissionGroup", "android.permission-group.LOCATION");
        return r0;
    }
}
