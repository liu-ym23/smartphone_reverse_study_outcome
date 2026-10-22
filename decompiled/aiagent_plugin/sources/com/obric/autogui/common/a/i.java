package com.obric.autogui.common.a;

import com.obric.aiagent.platform.depend.ICloudConfig;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.logging.OmniDataFeedbackLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.n;
import d.x;
import org.json.JSONObject;

/* JADX INFO: compiled from: OmniUploadImageAutoDrainConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final String TAG = "OmniUploadImageAutoDrainConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f28986a = null;

    /* JADX INFO: compiled from: OmniUploadImageAutoDrainConfig.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Boolean f28987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Boolean f28988b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28987a, r6.f28987a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f28988b, r6.f28988b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.f28987a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Boolean r4 = this.f28988b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "StreamingIdleUploadGateValues(autoDrainEnabled=" + this.f28987a + ", streamingIdleUploadEnabled=" + this.f28988b + ')';
        }

        public a(Boolean r1, Boolean r2) {
            this.f28987a = r1;
            this.f28988b = r2;
        }

        public final Boolean a() {
            return this.f28987a;
        }

        public final Boolean b() {
            return this.f28988b;
        }
    }

    static {
        f28986a = new i();
    }

    public static /* synthetic */ a lambda$jUMuah9OCdqNgVYAM6AnuDfzIn0() {
        return d();
    }

    public static /* synthetic */ Boolean lambda$jdkSSUI6GvNRB9e2U2bbY29LqYw() {
        return c();
    }

    private i() {
    }

    public final boolean a() {
        boolean r3 = a($$Lambda$i$jdkSSUI6GvNRB9e2U2bbY29LqYw.INSTANCE);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L5;
        Loog.INSTANCE.d(TAG, "cloud gate, key=obric_omni_upload_image_auto_drain_toggle_map, enabled=" + r3);
    L5:
        return r3;
    }

    private static final Boolean c() {
        JSONObject r0 = ICloudConfig.Companion.getSettingsConfig("obric_omni_upload_image_auto_drain_toggle_map");
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.has("enable") == true) goto L8;
        r0 = null;
    L8:
        if (r0 != null) goto L10;
        return null;
    L10:
        return Boolean.valueOf(r0.optBoolean("enable", false));
    }

    public final boolean b() {
        boolean r0 = AOSystemTools.INSTANCE.isDebugVersion();
        boolean r4 = a(r0, $$Lambda$i$jUMuah9OCdqNgVYAM6AnuDfzIn0.INSTANCE);
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L5;
        Loog.INSTANCE.d(TAG, "streaming idle gate, key=obric_omni_upload_image_auto_drain_toggle_map, debug=" + r0 + ", enabled=" + r4);
    L5:
        return r4;
    }

    private static final a d() {
        JSONObject r0 = ICloudConfig.Companion.getSettingsConfig("obric_omni_upload_image_auto_drain_toggle_map");
        boolean r1 = false;
        Object r2 = null;
        if (r0 != null) goto L5;
    L10:
        Boolean r3 = null;
    L11:
        i r4 = f28986a;
        if (r0 != null) goto L14;
    L16:
        if (r0 == null) goto L19;
        r2 = r0.opt("streaming_idle_upload_enable");
    L19:
        return new a(r3, Boolean.valueOf(r4.a(r1, r2)));
    L14:
        if (r0.has("streaming_idle_upload_enable") != true) goto L16;
        r1 = true;
        goto L16
    L5:
        if (r0.has("enable") == false) goto L7;
        JSONObject r5 = r0;
    L8:
        if (r5 == null) goto L10;
        r3 = Boolean.valueOf(r5.optBoolean("enable", false));
        goto L11
    L7:
        r5 = null;
        goto L8
    }

    public final boolean a(d.h.a.a<Boolean> r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "valueProvider");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        Object r4 = n.f(Boolean.valueOf(((i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin")).a((Boolean) ZeusTransformUtils.preCheckCast(r6.invoke(), Boolean.class, "com.obric.aiagent.plugin"))));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = n.c(r4);
        if (r7 == null) goto L18;
        n.a r1 = n.f38560a;     // Catch: Throwable -> L14
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L12;
        Loog.INSTANCE.w(TAG, "read cloud map failed, key=obric_omni_upload_image_auto_drain_toggle_map", r7);     // Catch: Throwable -> L14
    L12:
        Object r8 = n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        n.g(r8);
    L14:
        th = move-exception;
        n.a r2 = n.f38560a;
        r8 = n.f(d.o.a(th));
    L18:
        if (n.b(r4) == false) goto L21;
        r4 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r9 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L7
    }

    public final boolean a(Boolean r1) {
        return o.a(r1, true);
    }

    public final boolean a(boolean r4, d.h.a.a<a> r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r6, "valueProvider");
        n.a r0 = n.f38560a;     // Catch: Throwable -> L5
        i r3 = (i) ZeusTransformUtils.preCheckCast(this, i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6.invoke(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r8 = n.f(Boolean.valueOf(r3.a(r7.a(), r7.b(), r4)));     // Catch: Throwable -> L5
    L7:
        Throwable r9 = n.c(r8);
        if (r9 == null) goto L18;
        n.a r10 = n.f38560a;     // Catch: Throwable -> L14
        if (OmniDataFeedbackLog.INSTANCE.isVerboseLogEnabled() == false) goto L12;
        Loog.INSTANCE.w(TAG, "read streaming idle cloud map failed, key=obric_omni_upload_image_auto_drain_toggle_map", r9);     // Catch: Throwable -> L14
    L12:
        Object r11 = n.f(x.f38692a);     // Catch: Throwable -> L14
    L16:
        n.g(r11);
    L14:
        th = move-exception;
        n.a r12 = n.f38560a;
        r11 = n.f(d.o.a(th));
    L18:
        if (n.b(r8) == false) goto L21;
        r8 = false;
    L21:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        n.a r13 = n.f38560a;
        r8 = n.f(d.o.a(th));
        goto L7
    }

    public final boolean a(Boolean r2, Boolean r3, boolean r4) {
        if (o.a(r3, true) == false) goto L8;
        if (r4 == false) goto L6;
        return true;
    L6:
        if (o.a(r2, true) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean a(boolean r1, Object r2) {
        if (r1 == true) goto L5;
        return true;
    L5:
        return o.a(r2, true);
    }
}
