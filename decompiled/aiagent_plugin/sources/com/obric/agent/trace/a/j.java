package com.obric.agent.trace.a;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: QueryListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15432b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15433c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f15431a, r6.f15431a) == true) goto L12;
        return false;
    L12:
        if (this.f15432b == r6.f15432b) goto L15;
        return false;
    L15:
        if (this.f15433c == r6.f15433c) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f15431a.hashCode() * 31) + Integer.hashCode(this.f15432b)) * 31) + Boolean.hashCode(this.f15433c);
    }

    public String toString() {
        return "QueryListItem(query=" + this.f15431a + ", index=" + this.f15432b + ", select=" + this.f15433c + ')';
    }

    public j(String r2, int r3, boolean r4) {
        o.e(r2, DownloadConstants.QUERY_KEY);
        this.f15431a = r2;
        this.f15432b = r3;
        this.f15433c = r4;
    }
}
