package com.bytedance.ai.applet.db;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f34586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f34587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f34588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f34589d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f34586a, r101.f34586a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f34587b, r101.f34587b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f34588c, r101.f34588c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f34589d, r101.f34589d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f34586a.hashCode() * 31) + this.f34587b.hashCode()) * 31) + this.f34588c.hashCode()) * 31) + this.f34589d.hashCode();
    }

    public final String toString() {
        return "WidgetContextEntity(cardId=" + this.f34586a + ", messageId=" + this.f34587b + ", conversationId=" + this.f34588c + ", botId=" + this.f34589d + ')';
    }

    public i(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "cardId");
        Intrinsics.checkNotNullParameter(r101, "messageId");
        Intrinsics.checkNotNullParameter(r102, "conversationId");
        Intrinsics.checkNotNullParameter(r103, "botId");
        this.f34586a = r100;
        this.f34587b = r101;
        this.f34588c = r102;
        this.f34589d = r103;
    }
}
