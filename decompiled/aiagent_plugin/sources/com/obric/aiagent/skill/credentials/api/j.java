package com.obric.aiagent.skill.credentials.api;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CredentialModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f18967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18968c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f18969d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f18966a, r6.f18966a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f18967b, r6.f18967b) == true) goto L15;
        return false;
    L15:
        if (this.f18968c == r6.f18968c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f18969d, r6.f18969d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f18966a.hashCode() * 31) + this.f18967b.hashCode()) * 31) + Integer.hashCode(this.f18968c)) * 31) + this.f18969d.hashCode();
    }

    public String toString() {
        return "CredentialVerificationRequest(flowId=" + this.f18966a + ", url=" + this.f18967b + ", expiresInSec=" + this.f18968c + ", title=" + this.f18969d + ')';
    }

    public j(String r2, String r3, int r4, String r5) {
        d.h.b.o.e(r2, "flowId");
        d.h.b.o.e(r3, "url");
        d.h.b.o.e(r5, DBDefinition.TITLE);
        this.f18966a = r2;
        this.f18967b = r3;
        this.f18968c = r4;
        this.f18969d = r5;
    }

    public final String a() {
        return this.f18966a;
    }

    public final String b() {
        return this.f18967b;
    }

    public final int c() {
        return this.f18968c;
    }
}
