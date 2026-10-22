package com.bytedance.ai.applet.permission;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f34949c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f34951b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f34950a, r101.f34950a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34951b, r101.f34951b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f34950a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f34951b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "AppletGetSettingResult(reason=" + this.f34950a + ", authSetting=" + this.f34951b + ')';
    }

    public g(String r100, Map<String, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "authSetting");
        this.f34950a = r100;
        this.f34951b = r101;
    }
}
