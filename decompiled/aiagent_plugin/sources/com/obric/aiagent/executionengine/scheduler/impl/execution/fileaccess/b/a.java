package com.obric.aiagent.executionengine.scheduler.impl.execution.fileaccess.b;

import android.net.Uri;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: UriFileAccessConnection.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f18423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f18425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final IUriFileReceiver f18427e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f18423a, r6.f18423a) == true) goto L12;
        return false;
    L12:
        if (this.f18424b == r6.f18424b) goto L15;
        return false;
    L15:
        if (o.a(this.f18425c, r6.f18425c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f18426d, r6.f18426d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f18427e, r6.f18427e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((this.f18423a.hashCode() * 31) + Integer.hashCode(this.f18424b)) * 31) + this.f18425c.hashCode()) * 31) + this.f18426d.hashCode()) * 31) + this.f18427e.hashCode();
    }

    public String toString() {
        return "UriFileAccessConnection(uri=" + this.f18423a + ", receiverPid=" + this.f18424b + ", receiverPackage=" + this.f18425c + ", sharerPackage=" + this.f18426d + ", receiver=" + this.f18427e + ')';
    }

    public a(Uri r3, int r4, String r5, String r6, IUriFileReceiver r7) {
        IUriFileReceiver r8 = (IUriFileReceiver) ZeusTransformUtils.wrapperContextForParams(r7, IUriFileReceiver.class, "com.obric.aiagent.plugin");
        o.e(r3, "uri");
        o.e(r5, "receiverPackage");
        o.e(r6, "sharerPackage");
        o.e(r8, "receiver");
        this.f18423a = r3;
        this.f18424b = r4;
        this.f18425c = r5;
        this.f18426d = r6;
        this.f18427e = r8;
    }

    public final Uri a() {
        return this.f18423a;
    }

    public final int b() {
        return this.f18424b;
    }

    public final String c() {
        return this.f18425c;
    }

    public final String d() {
        return this.f18426d;
    }

    public final IUriFileReceiver e() {
        return this.f18427e;
    }

    public final Object a(d<? super Boolean> r3) {
        d<? super Boolean> r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.executionengine.scheduler.impl.a.f17967a.a(this, r4);
    }
}
