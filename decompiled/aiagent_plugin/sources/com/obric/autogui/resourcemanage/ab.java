package com.obric.autogui.resourcemanage;

import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResponseParser.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f30594a = null;

    /* JADX INFO: compiled from: ResponseParser.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DownloadBean f30595a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30596b;

        public final DownloadBean a() {
            return this.f30595a;
        }

        public final String b() {
            return this.f30596b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f30595a, r6.f30595a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f30596b, r6.f30596b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            DownloadBean r0 = this.f30595a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f30596b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Result(bean=" + this.f30595a + ", logId=" + this.f30596b + ')';
        }

        public a(DownloadBean r1, String r2) {
            this.f30595a = r1;
            this.f30596b = r2;
        }
    }

    static {
        f30594a = new ab();
    }

    private ab() {
    }

    public final a a(String r8) {
        d.h.b.o.e(r8, "responseData");
        JSONObject r1 = new JSONObject(r8);     // Catch: Exception -> L39
        int r9 = r1.optInt("error_no", -1);
        String r2 = r1.optString("error_msg", "");
        String r3 = r1.optString("log_id");
        d.h.b.o.a(r3);
        boolean r6 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L9:
        r6 = false;
    L10:
        if (r6 == true) goto L13;
        r3 = null;
    L13:
        if (r9 == 0) goto L19;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L17;
        Loog.INSTANCE.d("resource_downloader", "request failed. errorNo=" + r9 + ", errorMsg=" + r2 + ", logId=" + r3);
    L17:
        return null;
    L19:
        if (r1.has("data") == false) goto L35;
        if (r1.isNull("data") == true) goto L35;
        Object r10 = r1.opt("data");
        if (ZeusTransformUtils.instanceOf(r10, JSONObject.class) == false) goto L26;
        JSONObject r11 = (JSONObject) ZeusTransformUtils.preCheckCast(r10, JSONObject.class, "com.obric.aiagent.plugin");
    L27:
        if (r11 != null) goto L33;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L31;
        Loog.INSTANCE.d("resource_downloader", "response data has invalid type, logId=" + r3);
    L31:
        return null;
    L33:
        return new a(DownloadBean.Companion.a(r11), r3);
    L26:
        r11 = null;
    L35:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L38;
        Loog.INSTANCE.d("resource_downloader", "response contains no update data, logId=" + r3);
    L38:
        return new a(null, r3);
    L7:
        if (d.h.b.o.a(r3, "null") == true) goto L9;
    L39:
        e = move-exception;
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L43;
        Loog.INSTANCE.d("resource_downloader", "parse response error: " + e);
    L43:
        return null;
    }
}
