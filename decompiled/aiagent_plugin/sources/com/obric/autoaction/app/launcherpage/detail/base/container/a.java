package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: DetailAddPinShortCutViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f23296c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23294a, r6.f23294a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23295b, r6.f23295b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23296c, r6.f23296c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f23294a.hashCode() * 31) + this.f23295b.hashCode()) * 31;
        Map<String, String> r2 = this.f23296c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailAddPinShortCutDataV2(id=" + this.f23294a + ", defaultShortCutName=" + this.f23295b + ", ext=" + this.f23296c + ')';
    }

    public a(String r3, String r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, DbHelper.COL_ID);
        d.h.b.o.e(r4, "defaultShortCutName");
        this.f23294a = r3;
        this.f23295b = r4;
        this.f23296c = r6;
    }

    public final String a() {
        return this.f23294a;
    }

    public final String b() {
        return this.f23295b;
    }

    public final Map<String, String> c() {
        return this.f23296c;
    }
}
