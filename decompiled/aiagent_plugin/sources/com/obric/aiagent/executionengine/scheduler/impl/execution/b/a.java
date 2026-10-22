package com.obric.aiagent.executionengine.scheduler.impl.execution.b;

import android.net.Uri;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: UriSharingRecords.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f18400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18401c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18399a, r6.f18399a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f18400b, r6.f18400b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f18401c, r6.f18401c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f18399a.hashCode() * 31) + this.f18400b.hashCode()) * 31) + this.f18401c.hashCode();
    }

    public String toString() {
        return "SharingRecord(sharerPackage=" + this.f18399a + ", sharedUri=" + this.f18400b + ", receiverPackage=" + this.f18401c + ')';
    }

    public a(String r2, Uri r3, String r4) {
        o.e(r2, "sharerPackage");
        o.e(r3, "sharedUri");
        o.e(r4, "receiverPackage");
        this.f18399a = r2;
        this.f18400b = r3;
        this.f18401c = r4;
    }

    public final String a() {
        return this.f18399a + '%' + this.f18400b + '%' + this.f18401c;
    }
}
