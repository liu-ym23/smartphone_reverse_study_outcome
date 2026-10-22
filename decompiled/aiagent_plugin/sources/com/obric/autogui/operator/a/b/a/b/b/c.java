package com.obric.autogui.operator.a.b.a.b.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayedAppInfo;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.obric.autogui.common.api.virtualdisplay.AutoActionVirtualDisplay;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: StartInPlacePreCheck.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    private static final String TAG = "PreChk/StartInPlace";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f29481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ComponentName f29482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29483c;

    /* JADX INFO: compiled from: StartInPlacePreCheck.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f29481a = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public c(ComponentName r1, String r2) {
        this.f29482b = r1;
        this.f29483c = r2;
    }

    public /* synthetic */ c(ComponentName r2, String r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    @Override // com.obric.autogui.operator.a.b.a.b.b.b
    public com.obric.autogui.operator.a.b.a.c a(Context r11) {
        o.e((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), "context");
        if (a() == true) goto L5;
        return null;
    L5:
        return new com.obric.autogui.operator.a.b.a.c(com.obric.autogui.operator.a.b.a.b.j, null, null, null, null, false, null, 126, null);
    }

    private final boolean a() {
        com.obric.autogui.session.a r1 = com.obric.autogui.session.c.f30777a.b();
        if (r1 != null) goto L5;
        return false;
    L5:
        Object r3 = r1.a(com.obric.autogui.agents.a.EnumC0655a.f26120b);
        String r5 = null;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.autogui.agents.vlm.b.C0677b.class) == false) goto L8;
        com.obric.autogui.agents.vlm.b.C0677b r4 = (com.obric.autogui.agents.vlm.b.C0677b) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.agents.vlm.b.C0677b.class, "com.obric.aiagent.plugin");
    L9:
        if (r4 != null) goto L11;
        return false;
    L11:
        com.obric.autogui.session.state.a r6 = r1.m().e();
        if (ZeusTransformUtils.instanceOf(r6, com.obric.autogui.session.state.a.h.class) == false) goto L14;
        com.obric.autogui.session.state.a.h r7 = (com.obric.autogui.session.state.a.h) ZeusTransformUtils.preCheckCast(r6, com.obric.autogui.session.state.a.h.class, "com.obric.aiagent.plugin");
    L16:
        if (r7 != null) goto L19;
        Loog.INSTANCE.d(TAG, "[OpenApp] [OpenAppInPlace] not in operating state. not bringing task to vd.");
        return false;
    L19:
        DisplayedAppInfo r8 = r7.a();
        if (r8 != null) goto L23;
        return false;
    L23:
        if (r4.f() == true) goto L62;
        Bundle r9 = r1.l().getTaskExtras();
        if (r9 != null) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == false) goto L62;
        ComponentName r11 = r8.getRealActivity();
        ComponentName r12 = this.f29482b;
        if (r11 != null) goto L34;
    L36:
        boolean r13 = false;
    L37:
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(this.f29483c, CharSequence.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L40;
    L43:
        boolean r15 = true;
    L44:
        if (r15 == true) goto L49;
        r13 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(this.f29483c, CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r8.getData(), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r13 == false) goto L49;
        Loog.INSTANCE.d(TAG, "[OpenApp] [OpenAppInPlace] candidate MiniApp (" + this.f29483c + ") being Brought.");
    L49:
        if (r13 == false) goto L61;
        Loog.INSTANCE.i(TAG, "[OpenApp] [OpenAppInPlace] candidate app `" + r12 + "` is the same as the task to bring `" + r11 + "`.");
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        IAutoActionPresentationApi r16 = (IAutoActionPresentationApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAutoActionPresentationApi.class), IAutoActionPresentationApi.class, "com.obric.aiagent.plugin");
        if (r16 == null) goto L55;
        Intent r17 = r16.getOpenPlayerIntent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "start_in_place");
        if (r17 == null) goto L55;
        r17.addFlags(65536);
    L56:
        ZeusTransformUtils.startActivity(r2, r17, "com.obric.aiagent.plugin");
        AutoActionVirtualDisplay.INSTANCE.bringMdAppToVd(r8.getTaskId());
        IAutoActionTrackingApi r18 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r19 = new JSONObject();
        r19.put("scenario", "OpenAppInPlace");
        r19.put("operation", "open_app");
        if (r11 == null) goto L59;
        r5 = r11.getPackageName();
    L59:
        r19.put("package_name", r5);
        com.obric.autogui.session.c.b.a(r19, r1);
        x r0 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r18, "start_in_place", r19, false, false, null, 28, null);
        return true;
    L55:
        r17 = null;
        goto L56
    L61:
        Loog.INSTANCE.d(TAG, "[OpenApp] [OpenAppInPlace] abandoned StartInPlace for desired Task=" + r8 + " (current=" + r12 + ").");
        IAutoActionTrackingApi r20 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
        JSONObject r21 = new JSONObject();
        r21.put("scenario", "OpenAppInBackground");
        r21.put("operation", "open_app");
        com.obric.autogui.session.c.b.a(r21, r1);
        x r22 = x.f38692a;
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r20, "start_in_place", r21, false, false, null, 28, null);
        goto L62
    L40:
        if (d.o.o.d(r14) == true) goto L43;
        r15 = false;
        goto L44
    L34:
        if (o.a(r12, r11) == false) goto L36;
        r13 = true;
        goto L37
    L27:
        if (r9.getBoolean("start_in_place") != true) goto L29;
        r10 = true;
    L62:
        return false;
    L14:
        r7 = null;
        goto L16
    L8:
        r4 = null;
        goto L9
    }
}
