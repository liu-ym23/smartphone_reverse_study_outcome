package com.bytedance.bdturing.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.g;
import com.bytedance.bdturing.setting.h;
import com.bytedance.bdturing.twiceverify.c;
import com.bytedance.bdturing.utils.d;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: UrlBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String TAG = "UrlBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6500a = null;

    static {
        f6500a = new b();
    }

    private b() {
    }

    public final StringBuilder a(int r6, String r7, Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.aiagent.plugin");
        o.d(r7, "serviceType");
        String r10 = h.f6610a.a(r7);
        String r1 = h.f6610a.b(r7);
        if (o.a(r7, "twice_verify") == false) goto L6;
        c r11 = c.a();
        o.b(r11, "TwiceVerifyManager.getInstance()");
        r1 = r11.c().b();
        c r12 = c.a();
        o.b(r12, "TwiceVerifyManager.getInstance()");
        r10 = r12.c().c();
    L6:
        if (g.a() == false) goto L28;
        com.bytedance.bdturing.b r13 = com.bytedance.bdturing.b.a();
        o.b(r13, "BdTuring.getInstance()");
        BdTuringConfig r14 = r13.b();
        String r2 = null;
        if (r14 == null) goto L10;
        Pair<String, String> r15 = r14.getTestConfig(2);
    L11:
        if (r15 == null) goto L13;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r15.first, String.class, "com.obric.aiagent.plugin");
    L15:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L19;
        if (r15 != null) goto L18;
        o.a();
    L18:
        r10 = (String) ZeusTransformUtils.preCheckCast(r15.first, String.class, "com.obric.aiagent.plugin");
    L19:
        if (r15 == null) goto L22;
        r2 = (String) ZeusTransformUtils.preCheckCast(r15.first, String.class, "com.obric.aiagent.plugin");
    L22:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")) == true) goto L26;
        if (r15 != null) goto L25;
        o.a();
    L25:
        r1 = (String) ZeusTransformUtils.preCheckCast(r15.second, String.class, "com.obric.aiagent.plugin");
    L26:
        if (r9 == null) goto L28;
        Toast.makeText((Context) ZeusTransformUtils.preCheckCast(r9, Context.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("url = " + r10 + ", verifyHost = " + r1, CharSequence.class, "com.obric.aiagent.plugin"), 1).show();
        goto L28
    L13:
        r3 = null;
        goto L15
    L10:
        r15 = null;
    L28:
        StringBuilder r16 = d.b(new StringBuilder(o.a(r10, "?")), "verify_host", r1);
        a(r9, r16);
        return r16;
    }

    public final void a(Activity r6, StringBuilder r7) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.aiagent.plugin");
        o.d(r7, "queryBuilder");
        com.bytedance.bdturing.b r8 = com.bytedance.bdturing.b.a();
        o.b(r8, "BdTuring.getInstance()");
        BdTuringConfig r9 = r8.b();
        String r1 = null;
        if (r9 == null) goto L5;
        String r2 = r9.getAppId();
    L6:
        StringBuilder r3 = d.a(r7, WsConstants.KEY_APP_ID, r2);
        if (r9 == null) goto L9;
        String r4 = r9.getLanguage();
    L10:
        StringBuilder r10 = d.a(r3, "lang", r4);
        if (r9 == null) goto L13;
        String r11 = r9.getAppName();
    L14:
        StringBuilder r12 = d.a(r10, IBdInstall.PARAM_APP_NAME, r11);
        com.bytedance.bdturing.b r13 = com.bytedance.bdturing.b.a();
        o.b(r13, "BdTuring.getInstance()");
        BdTuringConfig r0 = r13.b();
        if (r0 == null) goto L17;
        String r14 = r0.getLocale();
    L18:
        StringBuilder r15 = d.a(r12, "locale", r14);
        if (r9 == null) goto L21;
        String r16 = r9.getChannel();
    L22:
        StringBuilder r17 = d.a(r15, "ch", r16);
        if (r9 == null) goto L25;
        String r18 = r9.getChannel();
    L26:
        StringBuilder r19 = d.a(r17, "channel", r18);
        if (r9 == null) goto L29;
        String r20 = r9.getAppKey();
    L30:
        StringBuilder r21 = d.a(r19, WsConstants.KEY_APP_KEY, r20);
        if (r9 == null) goto L33;
        String r22 = r9.getInstallId();
    L34:
        StringBuilder r23 = d.a(r21, WsConstants.KEY_INSTALL_ID, r22);
        if (r9 == null) goto L37;
        String r24 = r9.getAppVersion();
    L38:
        StringBuilder r25 = d.a(r23, "vc", r24);
        if (r9 == null) goto L41;
        String r26 = r9.getAppVersion();
    L42:
        StringBuilder r27 = d.a(r25, "app_verison", r26);
        if (r9 == null) goto L45;
        String r28 = r9.getDeviceId();
    L46:
        StringBuilder r29 = d.a(r27, "did", r28);
        if (r9 == null) goto L49;
        String r30 = r9.getSessionId();
    L50:
        StringBuilder r31 = d.a(r29, "session_id", r30);
        if (r9 == null) goto L55;
        BdTuringConfig.b r32 = r9.getRegionType();
        if (r32 == null) goto L55;
        String r33 = r32.a();
    L56:
        StringBuilder r34 = d.a(d.a(d.a(d.a(d.a(d.a(d.a(d.a(d.a(d.a(r31, "region", r33), "use_native_report", h.f6610a.a() ? 1 : 0), "use_jsb_request", h.f6610a.b() ? 1 : 0), "orientation", d.a(r5)), HardwareInfo.KEY_HW_DISPLAY_RESOLUTION, d.b(r5)), "sdk_version", "3.2.0.cn"), RomInfo.KEY_ROM_OS_VERSION, com.bytedance.bdturing.utils.a.f6629c), HardwareInfo.KEY_HW_VENDOR_BRAND, com.bytedance.bdturing.utils.a.f6627a), HardwareInfo.KEY_HW_VENDOR_MODEL, com.bytedance.bdturing.utils.a.f6628b), "os_name", "android");
        if (r9 == null) goto L59;
        String r35 = r9.getAppVersionCode();
    L60:
        StringBuilder r36 = d.a(r34, "version_code", r35);
        if (r9 == null) goto L63;
        r1 = r9.getAppVersion();
    L63:
        d.a(d.a(d.a(d.a(r36, "version_name", r1), "device_type", com.bytedance.bdturing.utils.a.f6628b), "device_platform", "android"), "os_type", 0);
        if (h.f6610a.d() == false) goto L67;
        d.a(r7, "mock", 1);
        return;
    L67:
        return;
    L59:
        r35 = null;
    L55:
        r33 = null;
        goto L56
    L49:
        r30 = null;
        goto L50
    L45:
        r28 = null;
        goto L46
    L41:
        r26 = null;
        goto L42
    L37:
        r24 = null;
        goto L38
    L33:
        r22 = null;
        goto L34
    L29:
        r20 = null;
        goto L30
    L25:
        r18 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L17:
        r14 = null;
        goto L18
    L13:
        r11 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }
}
