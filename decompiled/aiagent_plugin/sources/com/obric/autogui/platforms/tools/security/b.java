package com.obric.autogui.platforms.tools.security;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.configs.AutoActionConfigs;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.m;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: ObricSecurityTools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "O-P-SecurityTools";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, Integer> f30527b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, IAutoActionSecurityApi.SuggestedGrantStrategy> f30528c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final C0824b f30529d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static a f30530e;

    /* JADX INFO: compiled from: ObricSecurityTools.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f30532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EnumC0823a f30533c;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.security.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObricSecurityTools.kt */
        public static final enum EnumC0823a extends Enum<EnumC0823a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0823a f30534a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0823a f30535b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0823a f30536c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0823a[] f30537d = null;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private static final /* synthetic */ d.d.a f30538e = null;

            private static final /* synthetic */ EnumC0823a[] a() {
                return new EnumC0823a[]{f30534a, f30535b, f30536c};
            }

            private EnumC0823a(String r1, int r2) {
                super(r1, r2);
            }

            static {
                f30534a = new EnumC0823a("WAITING_FOR_USER_OPERATE", 0);
                f30535b = new EnumC0823a("ACCEPTED", 1);
                f30536c = new EnumC0823a("CANCELLED", 2);
                EnumC0823a[] r0 = a();
                f30537d = r0;
                f30538e = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            }

            public static EnumC0823a valueOf(String r2) {
                return (EnumC0823a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0823a.class, r2), EnumC0823a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0823a[] values() {
                return (EnumC0823a[]) ZeusTransformUtils.preCheckCast(f30537d.clone(), EnumC0823a[].class, "com.obric.aiagent.plugin");
            }
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f30531a, r6.f30531a) == true) goto L12;
            return false;
        L12:
            if (this.f30532b == r6.f30532b) goto L15;
            return false;
        L15:
            if (this.f30533c == r6.f30533c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f30531a.hashCode() * 31) + Integer.hashCode(this.f30532b)) * 31) + this.f30533c.hashCode();
        }

        public String toString() {
            return "OngoingSensitiveSettingsEvent(packageName=" + this.f30531a + ", eventType=" + this.f30532b + ", status=" + this.f30533c + ')';
        }

        public a(String r2, int r3, EnumC0823a r4) {
            o.e(r2, "packageName");
            o.e(r4, "status");
            this.f30531a = r2;
            this.f30532b = r3;
            this.f30533c = r4;
        }

        public final String a() {
            return this.f30531a;
        }

        public final void a(EnumC0823a r2) {
            o.e(r2, "<set-?>");
            this.f30533c = r2;
        }

        public final EnumC0823a b() {
            return this.f30533c;
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.security.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricSecurityTools.kt */
    private static final class C0824b implements com.bytedance.securityguardkit.settingsevent.b {
        public C0824b() {
        }

        @Override // com.bytedance.securityguardkit.settingsevent.b
        public void a(int r4, String r5) {
            if (r5 == null) goto L14;
            a r3 = b.c();
            if (r3 == null) goto L6;
            String r6 = r3.a();
        L8:
            if (o.a(r5, r6) == false) goto L16;
            a r7 = b.c();
            if (r7 == null) goto L15;
            Loog.INSTANCE.i(b.TAG, " - [SensitiveEvent] - pkg=" + r5 + ", eventType=" + r4 + ", status=ACCEPTED");
            r7.a(a.EnumC0823a.f30535b);
            return;
        L15:
            return;
        L16:
            return;
        L6:
            r6 = null;
            goto L8
        }

        @Override // com.bytedance.securityguardkit.settingsevent.b
        public void b(int r4, String r5) {
            if (r5 == null) goto L14;
            a r3 = b.c();
            if (r3 == null) goto L6;
            String r6 = r3.a();
        L8:
            if (o.a(r5, r6) == false) goto L16;
            a r7 = b.c();
            if (r7 == null) goto L15;
            Loog.INSTANCE.i(b.TAG, " - [SensitiveEvent] - pkg=" + r5 + ", eventType=" + r4 + ", status=CANCELLED");
            r7.a(a.EnumC0823a.f30536c);
            return;
        L15:
            return;
        L16:
            return;
        L6:
            r6 = null;
            goto L8
        }
    }

    /* JADX INFO: compiled from: ObricSecurityTools.kt */
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30539a = null;

        static {
            int[] r0 = new int[a.EnumC0823a.values().length];
            r0[a.EnumC0823a.f30535b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[a.EnumC0823a.f30536c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f30539a = r0;
        }
    }

    private b() {
    }

    public static final /* synthetic */ a c() {
        return f30530e;
    }

    static {
        f30526a = new b();
        f30527b = ao.a(new m[]{s.a("android.permission-group.PHONE", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_PHONE, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_PHONE"))), s.a("android.permission-group.SMS", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_SMS, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_SMS"))), s.a("android.permission-group.SENSORS", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_SENSORS, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_SENSORS"))), s.a("android.permission-group.READ_MEDIA_VISUAL", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_READ_MEDIA_VISUAL, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_READ_MEDIA_VISUAL"))), s.a("android.permission-group.READ_MEDIA_AURAL", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_READ_MEDIA_AURAL, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_READ_MEDIA_AURAL"))), s.a("android.permission-group.CAMERA", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_CAMERA, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_CAMERA"))), s.a("android.permission-group.MICROPHONE", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_MICROPHONE, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_MICROPHONE"))), s.a("android.permission-group.ACTIVITY_RECOGNITION", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_ACTIVITY_RECOGNITION, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_ACTIVITY_RECOGNITION"))), s.a("android.permission-group.CONTACTS", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_CONTACTS, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_CONTACTS"))), s.a("android.permission-group.CALENDAR", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_CALENDAR, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_CALENDAR"))), s.a("android.permission-group.CALL_LOG", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_CALL_LOG, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_CALL_LOG"))), s.a("android.permission-group.NEARBY_DEVICES", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_NEARBY_DEVICES, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_NEARBY_DEVICES"))), s.a("android.permission-group.INSTALLED_APPS", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_INSTALLED_APPS, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_INSTALLED_APPS"))), s.a("android.permission-group.NOTIFICATIONS", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_NOTIFICATIONS, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_NOTIFICATIONS"))), s.a("android.permission.ACCESS_FINE_LOCATION", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_ACCESS_FINE_LOCATION, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_ACCESS_FINE_LOCATION"))), s.a("android.permission.ACCESS_COARSE_LOCATION", Integer.valueOf(ZeusTransformUtils.mapRes(R.string.platform_perm_readable_name_ACCESS_COARSE_LOCATION, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_perm_readable_name_ACCESS_COARSE_LOCATION")))});
        f30528c = ao.a(new m[]{s.a("android.permission-group.SENSORS", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.READ_MEDIA_VISUAL", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.READ_MEDIA_AURAL", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.CAMERA", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.MICROPHONE", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.CONTACTS", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.CALENDAR", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission-group.CALL_LOG", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission.ACCESS_FINE_LOCATION", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE), s.a("android.permission.ACCESS_COARSE_LOCATION", IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE)});
        f30529d = new C0824b();
    }

    private final d d() {
        return d.f30541a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public final IAutoActionSecurityApi.PermissionStrategy a(String r11) {
        o.e(r11, "forPackageName");
        Bundle r10 = com.obric.autogui.platforms.tools.security.c.f30540a.a(r11);
        if (r10 != null) goto L5;
    L52:
        Loog.INSTANCE.d(TAG, " - `" + r11 + "`: not actually requesting permission.");
        return null;
    L5:
        if (r10.isEmpty() == true) goto L52;
        String r6 = r10.getString("permission_name");
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == false) goto L17;
        Loog.INSTANCE.d(TAG, " - `" + r11 + "`: empty permission name.");
        return null;
    L17:
        String r0 = r10.getString("permission_level");
        if (r0 == null) goto L39;
        switch(r0.hashCode()) {
            case -1414557169: goto L35;
            case -1399434362: goto L31;
            case -1321217453: goto L27;
            case 3079692: goto L23;
            default: goto L39;
        };
    L23:
        if (r0.equals("deny") == false) goto L39;
        IAutoActionSecurityApi.SuggestedGrantStrategy r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.DENY;
    L45:
        IAutoActionSecurityApi.SuggestedGrantStrategy r8 = r1;
    L46:
        String r9 = r10.getString("use_reason");
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(f30527b.get(r6), Integer.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L49;
        int r5 = r2.intValue();
    L51:
        return new IAutoActionSecurityApi.PermissionStrategy(r11, r6, r5, r8, r9);
    L49:
        r5 = -1;
        goto L51
    L27:
        if (r0.equals("oneTime") == false) goto L39;
        r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.ONE_TIME;
        goto L45
    L31:
        if (r0.equals("duringUse") == false) goto L39;
        r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.DURING_USE;
        goto L45
    L35:
        if (r0.equals("always") == false) goto L39;
        r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.ALWAYS;
    L39:
        if (AutoActionConfigs.INSTANCE.getBooleanCfg("vlm.security.default_strategies", true) == false) goto L44;
        IAutoActionSecurityApi.SuggestedGrantStrategy r7 = (IAutoActionSecurityApi.SuggestedGrantStrategy) ZeusTransformUtils.preCheckCast(f30528c.get(r6), IAutoActionSecurityApi.SuggestedGrantStrategy.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L43;
        Loog.INSTANCE.d(TAG, " - `" + r11 + "`: permission level: `" + r0 + "` is mapped to `NONE`.");
        r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.NONE;
        goto L45
    L43:
        Loog.INSTANCE.d(TAG, " - `" + r11 + "`: permission level (base-mapping): `" + r0 + "` is mapped to `" + r7 + "`.");
        r8 = r7;
        goto L46
    L44:
        Loog.INSTANCE.d(TAG, " - `" + r11 + "`: permission level: `" + r0 + "` is mapped to `NONE` (don't use default suggestions.).");
        r1 = IAutoActionSecurityApi.SuggestedGrantStrategy.NONE;
        goto L45
    L10:
        if (r3.length() == 0) goto L13;
        r4 = false;
        goto L14
    }

    public final void a() {
        d().a((com.bytedance.securityguardkit.settingsevent.b) ZeusTransformUtils.preCheckCast(f30529d, com.bytedance.securityguardkit.settingsevent.b.class, "com.obric.aiagent.plugin"));
    }

    public final void b() {
        d().b();
    }

    public final IAutoActionSecurityApi.SensitiveOperation a(Context r13, ComponentName r14) {
        Context r15 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        o.e(r15, "context");
        o.e(r14, "topComponent");
        d r12 = d();
        String r0 = r14.getPackageName();
        o.c(r0, "getPackageName(...)");
        if (r12.c(r0) == true) goto L17;
        a r16 = f30530e;
        if (r16 == null) goto L16;
        int r4 = c.f30539a[r16.b().ordinal()];
        if (r4 != 1) goto L9;
        int r17 = ZeusTransformUtils.mapRes(R.string.platform_security_accessing_sensitive_settings_finished, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_accessing_sensitive_settings_finished");
    L14:
        f30530e = null;
        String r5 = r14.getPackageName();
        o.c(r5, "getPackageName(...)");
        String r7 = r15.getString(r17);
        o.c(r7, "getString(...)");
        String r8 = r15.getString(r17);
        o.c(r8, "getString(...)");
        return new IAutoActionSecurityApi.SensitiveOperation(r5, "sensitive_settings_done", r7, r8, false);
    L9:
        if (r4 == 2) goto L12;
        Loog.INSTANCE.e(TAG, " - [SensitiveEvent] - pkg=" + r14.getPackageName() + ", ongoingEvent=" + r16);
        return null;
    L12:
        r17 = ZeusTransformUtils.mapRes(R.string.platform_security_accessing_sensitive_settings_cancelled, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_accessing_sensitive_settings_cancelled");
        goto L14
    L16:
        return null;
    L17:
        String r3 = r14.getPackageName();
        o.c(r3, "getPackageName(...)");
        f30530e = new a(r3, -1, a.EnumC0823a.f30534a);
        String r9 = r14.getPackageName();
        o.c(r9, "getPackageName(...)");
        String r10 = r15.getString(ZeusTransformUtils.mapRes(R.string.platform_security_accessing_sensitive_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_accessing_sensitive_settings"));
        o.c(r10, "getString(...)");
        String r11 = r15.getString(ZeusTransformUtils.mapRes(R.string.platform_security_accessing_sensitive_settings, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_accessing_sensitive_settings"));
        o.c(r11, "getString(...)");
        return new IAutoActionSecurityApi.SensitiveOperation(r9, "accessing_sensitive_settings", r10, r11, true);
    }

    public final com.obric.autogui.common.e b(String r3) {
        o.e(r3, Params.PROMPT);
        if (d().a(r3) != 0) goto L7;
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.platform_security_prompt_risk, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_prompt_risk"), null, 2, null);
    }

    public final com.obric.autogui.common.e c(String r2) {
        o.e(r2, Params.PROMPT);
        d().a();
        if (d().b(r2) != 0) goto L7;
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        return com.obric.autogui.common.e.f29014b.b();
    }

    public final IAutoActionSecurityApi.PageOperationPolicy b(Context r3, ComponentName r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        o.e(r4, "topComponent");
        int r2 = d().a(r4);
        if (r2 != 2) goto L5;
        String r6 = r5.getString(ZeusTransformUtils.mapRes(R.string.platform_security_accessing_free_payment_page, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_accessing_free_payment_page"));
        o.c(r6, "getString(...)");
    L11:
        return new IAutoActionSecurityApi.PageOperationPolicy(r6);
    L5:
        if (r2 == 10) goto L8;
        return null;
    L8:
        r6 = r5.getString(ZeusTransformUtils.mapRes(R.string.platform_security_maybe_accessing_free_payment_page, WsChannelMultiProcessSharedProvider.STRING_TYPE, "platform_security_maybe_accessing_free_payment_page"));
        o.c(r6, "getString(...)");
        goto L11
    }
}
