package com.bytedance.android.ec.core.vmsdk;

import com.bytedance.vmsdk.jsbridge.JSModuleManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f45764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f45765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f45766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f45767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<JSModuleManager, ai.b, String, Unit> f45768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f45769g;

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L24;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f45763a, r101.f45763a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f45764b, r101.f45764b) == true) goto L10;
        return false;
    L10:
        if (this.f45765c == r101.f45765c) goto L12;
        return false;
    L12:
        if (this.f45766d == r101.f45766d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f45767e, r101.f45767e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f45768f, r101.f45768f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(null, null) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(null, null) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f45769g, r101.f45769g) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f45763a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f45764b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f45765c;
        ?? r108 = 1;
        ?? r109 = r107;
        if (r107 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r106 + r109) * 31;
        boolean r111 = this.f45766d;
        if (r111 == true) goto L17;
        r108 = r111;
    L17:
        int r112 = (r110 + r108) * 31;
        String r113 = this.f45767e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Function3<JSModuleManager, ai.b, String, Unit> r116 = this.f45768f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (((((r115 + r117) * 31) + 0) * 31) + 0) * 31;
        String r119 = this.f45769g;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VmSdkConfig(scriptPath=" + this.f45763a + ", name=" + this.f45764b + ", enableEcJsb=" + this.f45765c + ", enableXBridge=" + this.f45766d + ", initPath=" + this.f45767e + ", initJsModuleManager=" + this.f45768f + ", initListener=null, serviceListener=null, bizName=" + this.f45769g + ")";
    }

    public b(String r100, String r101, boolean r102, int r103) {
        boolean r104 = true;
        if ((r103 & 4) == 0) goto L6;
        r102 = true;
    L6:
        if ((r103 & 8) != 0) goto L10;
        r104 = false;
    L10:
        if ((r103 & 16) == 0) goto L12;
        String r105 = VmSdkSetting.a().c();
    L14:
        if ((r103 & 256) == 0) goto L16;
        String r106 = "shopping";
    L17:
        Intrinsics.checkNotNullParameter(r100, "scriptPath");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r106, "bizName");
        this.f45763a = r100;
        this.f45764b = r101;
        this.f45765c = r102;
        this.f45766d = r104;
        this.f45767e = r105;
        this.f45768f = null;
        this.f45769g = r106;
        return;
    L16:
        r106 = null;
        goto L17
    L12:
        r105 = null;
        goto L14
    }
}
