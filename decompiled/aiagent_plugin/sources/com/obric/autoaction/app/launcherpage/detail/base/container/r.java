package com.obric.autoaction.app.launcherpage.detail.base.container;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DetailQueryViewContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements com.obric.autoaction.app.launcherpage.detail.base.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23344b;

    /* JADX WARN: Multi-variable type inference failed */
    public r() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23343a, r6.f23343a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23344b, r6.f23344b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.f23343a.hashCode() * 31;
        String r1 = this.f23344b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DetailQueryDataV2(query=" + this.f23343a + ", enterFrom=" + this.f23344b + ')';
    }

    public r(String r2, String r3) {
        d.h.b.o.e(r2, DownloadConstants.QUERY_KEY);
        this.f23343a = r2;
        this.f23344b = r3;
    }

    public /* synthetic */ r(String r1, String r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = null;
    L8:
        this(r1, r2);
    }

    public final String a() {
        return this.f23343a;
    }

    public final String b() {
        return this.f23344b;
    }
}
