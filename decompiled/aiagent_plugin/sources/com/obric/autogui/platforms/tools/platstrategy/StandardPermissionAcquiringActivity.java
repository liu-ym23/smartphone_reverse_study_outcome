package com.obric.autogui.platforms.tools.platstrategy;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.h;
import d.h.b.o;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: StandardPermissionAcquiringActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class StandardPermissionAcquiringActivity extends GeneratePluginActivity {
    private static final Set<String> APP_LIST_PERMISSIONS = null;
    public static final a Companion = null;
    private static final String EXTRA_PERMISSION = "extra_permission";
    private static final int REQUEST_CODE_PERMISSION = 1001;
    private static final String TAG = "StandardPermissionAcquiringActivity";
    private static final AtomicBoolean isStarted = null;
    private static com.obric.autogui.platforms.tools.platstrategy.a ongoingCallback;
    private com.obric.autogui.platforms.tools.platstrategy.a callback;
    private String permission;

    /* JADX INFO: compiled from: StandardPermissionAcquiringActivity.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final void a(Context r4, String r5, com.obric.autogui.platforms.tools.platstrategy.a r6) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            com.obric.autogui.platforms.tools.platstrategy.a r7 = (com.obric.autogui.platforms.tools.platstrategy.a) ZeusTransformUtils.wrapperContextForParams(r6, com.obric.autogui.platforms.tools.platstrategy.a.class, "com.obric.aiagent.plugin");
            o.e(r3, "context");
            o.e(r5, "permission");
            if (StandardPermissionAcquiringActivity.access$isStarted$cp().compareAndSet(false, true) == true) goto L6;
            Loog.INSTANCE.e(StandardPermissionAcquiringActivity.TAG, "PermissionAcquiring activity is started.");
            return;
        L6:
            StandardPermissionAcquiringActivity.access$setOngoingCallback$cp(r7);
            Intent r8 = new Intent(r3, StandardPermissionAcquiringActivity.class);
            r8.putExtra(StandardPermissionAcquiringActivity.EXTRA_PERMISSION, r5);
            if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L9;
            r8.addFlags(268435456);
        L9:
            ZeusTransformUtils.startActivity(r3, r8, "com.obric.aiagent.plugin");
        }
    }

    public static /* synthetic */ void lambda$8RymAcvPEhHePfRakvw6pwUl298(StandardPermissionAcquiringActivity r0, DialogInterface r1, int r2) {
        showAppListPermissionRationale$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$CBJOnBSA0O2wr90SgE7yVH_4znM(StandardPermissionAcquiringActivity r0, DialogInterface r1, int r2) {
        showAppListPermissionRationale$lambda$2(r0, r1, r2);
    }

    public String getPluginPkgName() {
        return "com.obric.aiagent.plugin";
    }

    public StandardPermissionAcquiringActivity() {
    }

    public static final /* synthetic */ AtomicBoolean access$isStarted$cp() {
        return isStarted;
    }

    public static final /* synthetic */ void access$setOngoingCallback$cp(com.obric.autogui.platforms.tools.platstrategy.a r2) {
        ongoingCallback = (com.obric.autogui.platforms.tools.platstrategy.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.autogui.platforms.tools.platstrategy.a.class, "com.obric.aiagent.plugin");
    }

    static {
        Companion = new a(null);
        APP_LIST_PERMISSIONS = ax.a(new String[]{"com.android.permission.GET_INSTALLED_APPS", "android.permission.QUERY_ALL_PACKAGES"});
        isStarted = new AtomicBoolean(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r7) {
        super/*android.app.Activity*/.onCreate(r7);
        String r8 = getIntent().getStringExtra(EXTRA_PERMISSION);
        if (r8 != null) goto L6;
        StandardPermissionAcquiringActivity r6 = (StandardPermissionAcquiringActivity) ZeusTransformUtils.preCheckCast(this, StandardPermissionAcquiringActivity.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.e(TAG, "No permission provided");
        isStarted.set(false);
        r6.finish();
        return;
    L6:
        this.permission = r8;
        this.callback = ongoingCallback;
        String r2 = null;
        if (r8 != null) goto L10;
        o.c("permission");
        r8 = null;
    L10:
        if (checkSelfPermission(r8) != 0) goto L13;
        notifyResult(true);
        return;
    L13:
        Set<String> r9 = APP_LIST_PERMISSIONS;
        String r5 = this.permission;
        if (r5 != null) goto L17;
        o.c("permission");
        r5 = null;
    L17:
        if (r9.contains(r5) == false) goto L19;
        showAppListPermissionRationale();
        return;
    L19:
        String[] r10 = new String[1];
        String r4 = this.permission;
        if (r4 != null) goto L22;
        o.c("permission");
    L23:
        r10[0] = r2;
        ZeusTransformUtils.requestPermissions(this, r10, 1001, "com.obric.aiagent.plugin");
        return;
    L22:
        r2 = r4;
        goto L23
    }

    private final void showAppListPermissionRationale() {
        new AlertDialog.Builder((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).setTitle(ZeusTransformUtils.mapRes(R.string.oauto_app_list_permission_desc_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_app_list_permission_desc_title")).setMessage(ZeusTransformUtils.mapRes(R.string.oauto_app_list_permission_desc_content, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_app_list_permission_desc_content")).setCancelable(false).setNegativeButton(ZeusTransformUtils.mapRes(R.string.oauto_permission_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_cancel"), new $$Lambda$StandardPermissionAcquiringActivity$8RymAcvPEhHePfRakvw6pwUl298(this)).setPositiveButton(ZeusTransformUtils.mapRes(R.string.oauto_permission_open, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_permission_open"), new $$Lambda$StandardPermissionAcquiringActivity$CBJOnBSA0O2wr90SgE7yVH_4znM(this)).show();
    }

    private static final void showAppListPermissionRationale$lambda$1(StandardPermissionAcquiringActivity r1, DialogInterface r2, int r3) {
        StandardPermissionAcquiringActivity r4 = (StandardPermissionAcquiringActivity) ZeusTransformUtils.wrapperContextForParams(r1, StandardPermissionAcquiringActivity.class, "com.obric.aiagent.plugin");
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r2, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        r4.notifyResult(false);
    }

    private static final void showAppListPermissionRationale$lambda$2(StandardPermissionAcquiringActivity r2, DialogInterface r3, int r4) {
        StandardPermissionAcquiringActivity r5 = (StandardPermissionAcquiringActivity) ZeusTransformUtils.wrapperContextForParams(r2, StandardPermissionAcquiringActivity.class, "com.obric.aiagent.plugin");
        ((DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin")).dismiss();
        String[] r6 = new String[1];
        String r7 = r5.permission;
        if (r7 != null) goto L5;
        o.c("permission");
        r7 = null;
    L5:
        r6[0] = r7;
        ZeusTransformUtils.requestPermissions(r5, r6, 1001, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        super/*android.app.Activity*/.onDestroy();
        isStarted.set(false);
        ongoingCallback = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRequestPermissionsResult(int r3, String[] r4, int[] r5) {
        o.e(r4, "permissions");
        o.e(r5, "grantResults");
        super/*android.app.Activity*/.onRequestPermissionsResult(r3, r4, r5);
        boolean r0 = false;
        if (r3 == 1001) goto L5;
    L20:
        notifyResult(false);
        return;
    L5:
        if (r4.length != 0) goto L7;
        boolean r6 = true;
    L9:
        if ((!r6) == false) goto L20;
        if (r5.length != 0) goto L13;
        boolean r7 = true;
    L15:
        if ((!r7) == true) goto L17;
    L19:
        notifyResult(r0);
        return;
    L17:
        if (r5[0] != 0) goto L19;
        r0 = true;
        goto L19
    L13:
        r7 = false;
        goto L15
    L7:
        r6 = false;
        goto L9
    }

    private final void notifyResult(boolean r6) {
        com.obric.autogui.platforms.tools.platstrategy.a r0 = this.callback;     // Catch: Throwable -> L9 Exception -> L11
        if (r0 == null) goto L8;
        String r1 = this.permission;     // Catch: Throwable -> L9 Exception -> L11
        if (r1 != null) goto L7;
        o.c("permission");     // Catch: Throwable -> L9 Exception -> L11
        r1 = null;
    L7:
        r0.a(r1, r6);     // Catch: Throwable -> L9 Exception -> L11
    L8:
        finish();
        return;
    L9:
        th = move-exception;
        finish();
        throw th;
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "Error calling callback: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
        goto L8
    }
}
