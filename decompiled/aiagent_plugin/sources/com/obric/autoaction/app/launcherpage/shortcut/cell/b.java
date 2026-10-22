package com.obric.autoaction.app.launcherpage.shortcut.cell;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autoaction.app.launcherpage.ui.h;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Map;

/* JADX INFO: compiled from: ShortCutCell.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f24423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f24425d;

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public Object c(h r2) {
        h r1 = (h) ZeusTransformUtils.wrapperContextForParams(r2, h.class, "com.obric.aiagent.plugin");
        o.e(r1, "newItem");
        return r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f24422a, r6.f24422a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f24423b, r6.f24423b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f24424c, r6.f24424c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f24425d, r6.f24425d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f24422a.hashCode() * 31) + this.f24423b.hashCode()) * 31;
        String r1 = this.f24424c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Map<String, String> r5 = this.f24425d;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "ShortCutItem(id=" + this.f24422a + ", query=" + this.f24423b + ", shortQuery=" + this.f24424c + ", ext=" + this.f24425d + ')';
    }

    public b(String r3, String r4, String r5, Map<String, String> r6) {
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r4, DownloadConstants.QUERY_KEY);
        this.f24422a = r3;
        this.f24423b = r4;
        this.f24424c = r5;
        this.f24425d = r7;
    }

    public final String a() {
        return this.f24422a;
    }

    public final String b() {
        return this.f24423b;
    }

    public final String c() {
        return this.f24424c;
    }

    public final Map<String, String> d() {
        return this.f24425d;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean a(h r4) {
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.aiagent.plugin");
        o.e(r5, "other");
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (o.a(this.f24422a, ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).f24422a) == false) goto L7;
        return true;
    }

    @Override // com.obric.autoaction.app.launcherpage.ui.h
    public boolean b(h r3) {
        h r4 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.aiagent.plugin");
        o.e(r4, "other");
        return o.a(this, r4);
    }
}
