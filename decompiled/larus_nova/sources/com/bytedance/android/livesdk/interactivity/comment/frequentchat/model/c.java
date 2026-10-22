package com.bytedance.android.livesdk.interactivity.comment.frequentchat.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f134883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f134884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f134885c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f134883a, r101.f134883a) == true) goto L8;
        return false;
    L8:
        if (this.f134884b == r101.f134884b) goto L10;
        return false;
    L10:
        if (this.f134885c == r101.f134885c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f134883a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f134884b;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f134885c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "FrequentChatItemData(content=" + this.f134883a + ", id=" + this.f134884b + ", type=" + this.f134885c + ")";
    }

    public final int getType() {
        return this.f134885c;
    }

    public c(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.f134883a = r100;
        this.f134884b = r101;
        this.f134885c = r102;
    }
}
