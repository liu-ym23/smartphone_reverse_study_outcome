package com.obric.aiagent.skill.virt.impl.a.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: VirtFileBridgeSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f21901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21902b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f21901a, r6.f21901a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f21902b, r6.f21902b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f21901a.hashCode() * 31) + this.f21902b.hashCode();
    }

    public String toString() {
        return "StagingDir(hostDir=" + this.f21901a + ", containerPath=" + this.f21902b + ')';
    }

    public b(File r2, String r3) {
        o.e(r2, "hostDir");
        o.e(r3, "containerPath");
        this.f21901a = r2;
        this.f21902b = r3;
    }

    public final File a() {
        return this.f21901a;
    }

    public final String b() {
        return this.f21902b;
    }
}
