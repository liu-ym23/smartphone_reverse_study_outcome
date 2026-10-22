package com.obric.aiagent.executionengine.scheduler.impl.appfunction;

import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f;
import d.g;
import d.h.b.aa;
import d.h.b.h;
import d.j;
import d.x;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppFunctionSettingsServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFunctionSettingsServiceImpl implements IAppFunctionSettingsService {
    private static final a Companion = null;

    @Deprecated
    public static final String SETTINGS_KEY = "obric_app_function_settings";
    private final f cachedSettings$delegate;

    /* JADX INFO: compiled from: AppFunctionSettingsServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a lambda$jDcCfKsjF10qgzgjwWhx5aVodds(AppFunctionSettingsServiceImpl r0) {
        return cachedSettings_delegate$lambda$0(r0);
    }

    public AppFunctionSettingsServiceImpl() {
        this.cachedSettings$delegate = g.a(j.f38505a, new $$Lambda$AppFunctionSettingsServiceImpl$jDcCfKsjF10qgzgjwWhx5aVodds(this));
    }

    private final com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a getCachedSettings() {
        return (com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a) ZeusTransformUtils.preCheckCast(this.cachedSettings$delegate.b(), com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a cachedSettings_delegate$lambda$0(AppFunctionSettingsServiceImpl r0) {
        return r0.loadSettings();
    }

    @Override // com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.IAppFunctionSettingsService
    public com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a getSettings() {
        return getCachedSettings();
    }

    private final com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a loadSettings() {
        com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a r12 = new com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a(false, false, null, 7, null);
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        if (r0 == null) goto L5;
        String r1 = r0.getObricFlowSettingsJson(SETTINGS_KEY);
    L6:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L36;
        return r12;
    L36:
        JSONObject r4 = new JSONObject(r1);     // Catch: Exception -> L35
        JSONArray r5 = r4.optJSONArray("blockApps");     // Catch: Exception -> L35
        boolean r8 = r4.optBoolean("enableKDoc", r12.b());     // Catch: Exception -> L35
        List r6 = p.a();     // Catch: Exception -> L35
        if (r5 == null) goto L32;
        int r7 = r5.length();     // Catch: Exception -> L35
        int r9 = 0;
    L18:
        if (r9 >= r7) goto L32;
        Object r10 = r5.opt(r9);     // Catch: Exception -> L35
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L22;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L35
    L23:
        if (r11 != null) goto L26;
    L31:
        r9 = r9 + 1;     // Catch: Exception -> L35
        goto L18
    L26:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == false) goto L31;
        r6.add(r11);     // Catch: Exception -> L35
        goto L31
    L28:
        r13 = false;
        goto L29
    L22:
        r11 = null;
    L32:
        x r14 = x.f38692a;     // Catch: Exception -> L35
        return new com.obric.aiagent.executionengine.capabilitymanager.api.appfunction.a(false, r8, p.s((Iterable) ZeusTransformUtils.preCheckCast(p.a(r6), Iterable.class, "com.obric.aiagent.plugin")), 1, null);
    L42:
        return r12;
    L9:
        if (r2.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }
}
