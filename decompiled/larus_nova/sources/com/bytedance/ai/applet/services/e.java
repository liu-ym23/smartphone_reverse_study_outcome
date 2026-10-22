package com.bytedance.ai.applet.services;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f35209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f35210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f35212d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f35209a, r101.f35209a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f35210b, r101.f35210b) == true) goto L15;
        return false;
    L15:
        if (this.f35211c == r101.f35211c) goto L18;
        return false;
    L18:
        if (this.f35212d == r101.f35212d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f35209a.hashCode() * 31) + this.f35210b.hashCode()) * 31) + this.f35211c) * 31) + this.f35212d;
    }

    public final String toString() {
        return "SnapshotUploadResult(messageId=" + this.f35209a + ", mimeType=" + this.f35210b + ", width=" + this.f35211c + ", height=" + this.f35212d + ')';
    }

    public e(String r100, String r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        Intrinsics.checkNotNullParameter(r101, DBDefinition.MIME_TYPE);
        this.f35209a = r100;
        this.f35210b = r101;
        this.f35211c = r102;
        this.f35212d = r103;
    }
}
