package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import os.teatracker.IBdInstall;

/* JADX INFO: compiled from: AppBlackBean.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(IBdInstall.PARAM_APP_NAME)
    private final String f27346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("app_name_en")
    private final String f27347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("app_name_alias")
    private final List<String> f27348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("package_name")
    private final String f27349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("block_source")
    private final int f27350e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f27346a, r6.f27346a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f27347b, r6.f27347b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f27348c, r6.f27348c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f27349d, r6.f27349d) == true) goto L21;
        return false;
    L21:
        if (this.f27350e == r6.f27350e) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f27346a.hashCode() * 31) + this.f27347b.hashCode()) * 31;
        List<String> r1 = this.f27348c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.f27349d.hashCode()) * 31) + Integer.hashCode(this.f27350e);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AppBlackBean(appName=" + this.f27346a + ", appNameEn=" + this.f27347b + ", appNameAlias=" + this.f27348c + ", packageName=" + this.f27349d + ", blockSource=" + this.f27350e + ')';
    }

    public final String a() {
        return this.f27346a;
    }

    public final String b() {
        return this.f27347b;
    }

    public final List<String> c() {
        return this.f27348c;
    }

    public final String d() {
        return this.f27349d;
    }
}
