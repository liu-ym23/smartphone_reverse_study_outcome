package com.obric.aiagent.product.impl;

import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: CloudConfigImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements ICloudConfig {
    private static final String TAG = "CloudConfigImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0397a f18794a = null;

    /* JADX INFO: renamed from: com.obric.aiagent.product.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CloudConfigImpl.kt */
    public static final class C0397a {
        public /* synthetic */ C0397a(h r1) {
            this();
        }

        private C0397a() {
        }
    }

    static {
        f18794a = new C0397a(null);
    }

    public a() {
    }

    @Override // com.obric.aiagent.platform.depend.ICloudConfig
    public JSONObject getSettingsConfig(String r7) {
        o.e(r7, "key");
        if (at.a(aa.b(IFlowSettingsIDL.class)) != null) goto L5;
        ILogDepend.Companion.i(TAG, "IFlowSettingsIDL is null");
    L5:
        IFlowSettingsIDL r0 = at.a(aa.b(IFlowSettingsIDL.class));
        Object r2 = null;
        if (r0 == null) goto L8;
        String r8 = r0.getObricCloudConfig(r7);
    L9:
        if (r8 != null) goto L11;
        return null;
    L11:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == true) goto L17;
        r8 = null;
    L17:
        if (r8 == null) goto L34;
        n.a r3 = n.f38560a;     // Catch: Throwable -> L20
        a r6 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        Object r9 = n.f(new JSONObject(r8));     // Catch: Throwable -> L20
    L22:
        Throwable r10 = n.c(r9);
        if (r10 == null) goto L26;
        ILogDepend.Companion.e(TAG, "getSettingsConfig error: " + r10, r10);
    L26:
        if (n.b(r9) == true) goto L30;
        r2 = r9;
    L30:
        return (JSONObject) ZeusTransformUtils.preCheckCast(r2, JSONObject.class, "com.obric.aiagent.plugin");
    L20:
        th = move-exception;
        n.a r11 = n.f38560a;
        r9 = n.f(d.o.a(th));
        goto L22
    L34:
        return null;
    L13:
        r1 = false;
        goto L14
    L8:
        r8 = null;
        goto L9
    }
}
