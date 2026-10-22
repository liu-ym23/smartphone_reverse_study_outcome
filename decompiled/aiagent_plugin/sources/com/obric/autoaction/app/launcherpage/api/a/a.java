package com.obric.autoaction.app.launcherpage.api.a;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ConditionTaskDisplayInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22882a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22884c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22882a, r6.f22882a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22883b, r6.f22883b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22884c, r6.f22884c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f22882a.hashCode() * 31) + this.f22883b.hashCode()) * 31) + this.f22884c.hashCode();
    }

    public String toString() {
        return "ConditionTaskDisplayInfo(conditionString=" + this.f22882a + ", periodString=" + this.f22883b + ", query=" + this.f22884c + ')';
    }

    public a(String r2, String r3, String r4) {
        o.e(r2, "conditionString");
        o.e(r3, "periodString");
        o.e(r4, DownloadConstants.QUERY_KEY);
        this.f22882a = r2;
        this.f22883b = r3;
        this.f22884c = r4;
    }

    public final String a() {
        return this.f22882a;
    }

    public final String b() {
        return this.f22883b;
    }

    public final String c() {
        return this.f22884c;
    }
}
