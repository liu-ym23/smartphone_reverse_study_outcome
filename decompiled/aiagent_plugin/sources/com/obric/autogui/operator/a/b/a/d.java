package com.obric.autogui.operator.a.b.a;

import android.content.Context;
import android.content.Intent;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.packages.appinfo.AppInfoEntry;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OpenAppUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String TAG = "Op-OpenApp/Util";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f29526a = null;

    /* JADX INFO: compiled from: OpenAppUtil.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.operator.a.b.a.b.a f29527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29528b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29527a, r6.f29527a) == true) goto L12;
            return false;
        L12:
            if (this.f29528b == r6.f29528b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29527a.hashCode() * 31) + Boolean.hashCode(this.f29528b);
        }

        public String toString() {
            return "LauncherIntentMatching(opener=" + this.f29527a + ", isExactMatch=" + this.f29528b + ')';
        }

        public a(com.obric.autogui.operator.a.b.a.b.a r3, boolean r4) {
            com.obric.autogui.operator.a.b.a.b.a r5 = (com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin");
            o.e(r5, "opener");
            this.f29527a = r5;
            this.f29528b = r4;
        }

        public final com.obric.autogui.operator.a.b.a.b.a a() {
            return this.f29527a;
        }

        public final boolean b() {
            return this.f29528b;
        }
    }

    static {
        f29526a = new d();
    }

    private d() {
    }

    public final a a(Context r8, String r9, String r10) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        o.e(r9, "packageName");
        Intent r11 = AOPackagesTools.INSTANCE.getLaunchIntent(r7, r9);
        CharSequence r1 = null;
        if (r11 != null) goto L5;
        Loog.INSTANCE.d(TAG, "launchIntent -- not available for package: " + r9 + ". finding other candidates.");
        return null;
    L5:
        if (r10 == null) goto L7;
        AppInfoEntry r12 = AOPackagesTools.INSTANCE.getAppInfo(r7, r9);
        if (r12 == null) goto L15;
        CharSequence r5 = r12.getAppLabel();
        if (r5 == null) goto L15;
        if (d.o.o.a(r5, (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.aiagent.plugin")) != true) goto L15;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L20;
        Loog.INSTANCE.d(TAG, " - [OpenApp|label-exact-match] app `" + r9 + "` with viable LaunchIntent for `" + r10 + '`');
        return new a((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.d(r11, r10), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), true);
    L20:
        Loog r13 = Loog.INSTANCE;
        StringBuilder r3 = new StringBuilder().append(" - [OpenApp|label-part-match] app ");
        if (r12 == null) goto L23;
        r1 = r12.getAppLabel();
    L23:
        r13.d(TAG, r3.append(r1).append(" !== `").append(r10).append('`').toString());
        return new a((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.d(r11, r10), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), false);
    L15:
        r6 = false;
        goto L17
    L7:
        return new a((com.obric.autogui.operator.a.b.a.b.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.operator.a.b.a.b.d(r11, null), com.obric.autogui.operator.a.b.a.b.a.class, "com.obric.aiagent.plugin"), true);
    }
}
