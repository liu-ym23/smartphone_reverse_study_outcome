package b37;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f17199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f17201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f17202h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f17195a == r101.f17195a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f17196b, r101.f17196b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f17197c, r101.f17197c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f17198d, r101.f17198d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f17199e, r101.f17199e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f17200f, r101.f17200f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f17201g, r101.f17201g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f17202h, r101.f17202h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.f17195a * 31) + this.f17196b.hashCode()) * 31) + this.f17197c.hashCode()) * 31) + this.f17198d.hashCode()) * 31) + this.f17199e.hashCode()) * 31) + this.f17200f.hashCode()) * 31) + this.f17201g.hashCode()) * 31) + this.f17202h.hashCode();
    }

    public final String toString() {
        return "AppConfig(appId=" + this.f17195a + ", appName=" + this.f17196b + ", appVersionName=" + this.f17197c + ", versionCode=" + this.f17198d + ", updateVersionCode=" + this.f17199e + ", channel=" + this.f17200f + ", os=" + this.f17201g + ", deviceId=" + this.f17202h + ")";
    }

    public a(int r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "appVersionName");
        Intrinsics.checkNotNullParameter(r103, RuleConditionBean.VERSION_CODE_KEY);
        Intrinsics.checkNotNullParameter(r104, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r105, "channel");
        Intrinsics.checkNotNullParameter("android", "os");
        Intrinsics.checkNotNullParameter(r106, "deviceId");
        this.f17195a = r100;
        this.f17196b = r101;
        this.f17197c = r102;
        this.f17198d = r103;
        this.f17199e = r104;
        this.f17200f = r105;
        this.f17201g = "android";
        this.f17202h = r106;
    }
}
