package com.bytedance.ai.api;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f33985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f33986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f33987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f33989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f33990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f33991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f33992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f33993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f33994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f33995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f33996l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f33997m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f33998n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f33999o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f34000p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f34001q;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f33985a, r101.f33985a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f33986b, r101.f33986b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f33987c, r101.f33987c) == true) goto L18;
        return false;
    L18:
        if (this.f33988d == r101.f33988d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f33989e, r101.f33989e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f33990f, r101.f33990f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f33991g, r101.f33991g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f33992h, r101.f33992h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f33993i, r101.f33993i) == true) goto L36;
        return false;
    L36:
        if (this.f33994j == r101.f33994j) goto L39;
        return false;
    L39:
        if (this.f33995k == r101.f33995k) goto L42;
        return false;
    L42:
        if (this.f33996l == r101.f33996l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f33997m, r101.f33997m) == true) goto L48;
        return false;
    L48:
        if (this.f33998n == r101.f33998n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f33999o, r101.f33999o) == true) goto L54;
        return false;
    L54:
        if (this.f34000p == r101.f34000p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f34001q, r101.f34001q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f33985a.hashCode() * 31;
        String r101 = this.f33986b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((((((((((((r100 + r102) * 31) + this.f33987c.hashCode()) * 31) + this.f33988d) * 31) + this.f33989e.hashCode()) * 31) + this.f33990f.hashCode()) * 31) + this.f33991g.hashCode()) * 31) + this.f33992h.hashCode()) * 31) + this.f33993i.hashCode()) * 31;
        int r104 = 1231;
        if (this.f33994j == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.f33995k == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r106 + r107) * 31;
        if (this.f33996l == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (((r108 + r109) * 31) + this.f33997m.hashCode()) * 31;
        if (this.f33998n == false) goto L21;
        int r111 = 1231;
    L22:
        int r112 = (((r110 + r111) * 31) + this.f33999o.hashCode()) * 31;
        if (this.f34000p == true) goto L27;
        r104 = 1237;
    L27:
        return ((r112 + r104) * 31) + this.f34001q.hashCode();
    L21:
        r111 = 1237;
        goto L22
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AppletAppConfig(application=" + this.f33985a + ", deviceId=" + this.f33986b + ", appName=" + this.f33987c + ", appId=" + this.f33988d + ", appVersion=" + this.f33989e + ", appVersionCode=" + this.f33990f + ", appPackageName=" + this.f33991g + ", appChannel=" + this.f33992h + ", updateVersionCode=" + this.f33993i + ", isOversea=" + this.f33994j + ", isDebug=" + this.f33995k + ", isTestChannel=" + this.f33996l + ", bid=" + this.f33997m + ", boeEnable=" + this.f33998n + ", boeEnv=" + this.f33999o + ", ppeEnable=" + this.f34000p + ", ppeEnv=" + this.f34001q + ')';
    }

    public a(Context r110, String r111, String r112, int r113, String r114, String r115, String r116, String r210, String r211, boolean r212, boolean r213, boolean r214, String r215, boolean r216, String r217, boolean r218, String r219) {
        Intrinsics.checkNotNullParameter(r110, "application");
        Intrinsics.checkNotNullParameter(r112, "appName");
        Intrinsics.checkNotNullParameter(r114, "appVersion");
        Intrinsics.checkNotNullParameter(r115, DBDefinition.APP_VERSION_CODE);
        Intrinsics.checkNotNullParameter(r116, "appPackageName");
        Intrinsics.checkNotNullParameter(r210, "appChannel");
        Intrinsics.checkNotNullParameter(r211, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r215, "bid");
        Intrinsics.checkNotNullParameter(r217, "boeEnv");
        Intrinsics.checkNotNullParameter(r219, "ppeEnv");
        this.f33985a = r110;
        this.f33986b = r111;
        this.f33987c = r112;
        this.f33988d = r113;
        this.f33989e = r114;
        this.f33990f = r115;
        this.f33991g = r116;
        this.f33992h = r210;
        this.f33993i = r211;
        this.f33994j = r212;
        this.f33995k = r213;
        this.f33996l = r214;
        this.f33997m = r215;
        this.f33998n = r216;
        this.f33999o = r217;
        this.f34000p = r218;
        this.f34001q = r219;
    }
}
