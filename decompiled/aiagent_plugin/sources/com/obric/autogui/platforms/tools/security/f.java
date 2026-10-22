package com.obric.autogui.platforms.tools.security;

import android.content.ComponentName;
import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;

/* JADX INFO: compiled from: StandardSecurityApiImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f extends com.obric.autogui.platforms.tools.security.a {
    private static final String TAG = "OAuto-SecApi-Impl";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f30545c = null;

    /* JADX INFO: compiled from: StandardSecurityApiImpl.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30545c = new a(null);
    }

    private static final String a() {
        return "- [Perm] acquiring strategies.";
    }

    private static final String b() {
        return "- [Perm] strategies=";
    }

    /* JADX INFO: renamed from: lambda$BN-QL2qwxuZ52aVpaGRt2ug9-60, reason: not valid java name */
    public static /* synthetic */ String m876lambda$BNQL2qwxuZ52aVpaGRt2ug960(String r0, z.f r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ String lambda$OmGTem04ehwlQAjZNzgvP4KhPtk() {
        return b();
    }

    public static /* synthetic */ String lambda$XoUnNT71Lr181ZQO5AFLwPfun3o(String r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$erb5hNwmIGqylcX1K-eSAaeWq3o, reason: not valid java name */
    public static /* synthetic */ String m877lambda$erb5hNwmIGqylcX1KeSAaeWq3o() {
        return a();
    }

    public f() {
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [T, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi$PermissionStrategy] */
    /* JADX WARN: Type inference failed for: r14v14, types: [T, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi$PermissionStrategy] */
    /* JADX WARN: Type inference failed for: r14v16, types: [T, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi$PermissionStrategy] */
    /* JADX WARN: Type inference failed for: r3v9, types: [T, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi$PermissionStrategy] */
    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.PermissionStrategy acquirePermissionStrategy(DisplayedAppInfo r15) {
        DisplayedAppInfo r14 = (DisplayedAppInfo) ZeusTransformUtils.wrapperContextForParams(r15, DisplayedAppInfo.class, "com.obric.aiagent.plugin");
        o.e(r14, "topApp");
        ComponentName r16 = r14.getTopActivity();
        final String r1 = null;
        if (r16 != null) goto L5;
        return null;
    L5:
        final z.f r2 = new z.f();
        if (o.a(r16.getPackageName(), "com.android.launcher3") == false) goto L11;
        if (o.a(r16.getClassName(), "com.android.launcher3.dragndrop.AddItemActivity") == false) goto L11;
        Loog.INSTANCE.d(TAG, " - [Perm] in SystemUI AddItemActivity.");
        r2.f38504a = new IAutoActionSecurityApi.PermissionStrategy("", "", ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_SYSTEMUI_ADD_ITEM, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_SYSTEMUI_ADD_ITEM"), IAutoActionSecurityApi.SuggestedGrantStrategy.DENY, null, 16, null);
    L11:
        if (o.a(r16.getPackageName(), "com.android.permissioncontroller") == false) goto L24;
        if (o.a(r16.getClassName(), "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity") == false) goto L24;
        ComponentName r17 = r14.getRealActivity();
        if (r17 == null) goto L17;
        r1 = r17.getPackageName();
    L17:
        if (r1 != null) goto L20;
        Loog.INSTANCE.w(TAG, " - [Perm] NULL realActivity in permission controller.");
        r2.f38504a = new IAutoActionSecurityApi.PermissionStrategy("", "", -1, IAutoActionSecurityApi.SuggestedGrantStrategy.NOT_SURE, null, 16, null);
        return (IAutoActionSecurityApi.PermissionStrategy) ZeusTransformUtils.preCheckCast(r2.f38504a, IAutoActionSecurityApi.PermissionStrategy.class, "com.obric.aiagent.plugin");
    L20:
        Loog.INSTANCE.ip(TAG, new $$Lambda$f$XoUnNT71Lr181ZQO5AFLwPfun3o(r1), $$Lambda$f$erb5hNwmIGqylcX1KeSAaeWq3o.INSTANCE);
        r2.f38504a = b.f30526a.a(r1);
        Loog.INSTANCE.dp(TAG, new $$Lambda$f$BNQL2qwxuZ52aVpaGRt2ug960(r1, r2), $$Lambda$f$OmGTem04ehwlQAjZNzgvP4KhPtk.INSTANCE);
        if (r2.f38504a != 0) goto L24;
        Loog.INSTANCE.w(TAG, " - [Perm] NULL strategy can be found in permission controller.");
        r2.f38504a = new IAutoActionSecurityApi.PermissionStrategy("", "", -1, IAutoActionSecurityApi.SuggestedGrantStrategy.NOT_SURE, null, 16, null);
    L24:
        return (IAutoActionSecurityApi.PermissionStrategy) ZeusTransformUtils.preCheckCast(r2.f38504a, IAutoActionSecurityApi.PermissionStrategy.class, "com.obric.aiagent.plugin");
    }

    private static final String a(String r2) {
        return " - [Perm][" + r2 + "] in permission controller. acquiring strategies.";
    }

    private static final String a(String r2, z.f r3) {
        return " - [Perm][" + r2 + "] strategies=" + r3.f38504a;
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.SensitiveOperation acquireSensitiveOperation(Context r2, ComponentName r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "topComponent");
        return b.f30526a.a(r1, r3);
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public IAutoActionSecurityApi.PageOperationPolicy acquirePageOperationPolicy(Context r2, ComponentName r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        o.e(r3, "topComponent");
        return b.f30526a.b(r1, r3);
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public com.obric.autogui.common.e checkPrompt(String r1) {
        o.e(r1, Params.PROMPT);
        return b.f30526a.b(r1);
    }

    @Override // com.obric.autogui.platforms.tools.security.a, com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi
    public boolean checkSensitiveWord(String r1) {
        o.e(r1, "content");
        return b.f30526a.c(r1).g();
    }
}
