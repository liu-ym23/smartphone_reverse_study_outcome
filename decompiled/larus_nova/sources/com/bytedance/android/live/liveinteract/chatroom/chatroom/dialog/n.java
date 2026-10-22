package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f72047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f72048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f72049c;

    public n() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f72047a, r101.f72047a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f72048b, r101.f72048b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f72049c, r101.f72049c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f72047a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f72048b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f72049c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedbackTexts(title=" + this.f72047a + ", subTitle=" + this.f72048b + ", question=" + this.f72049c + ")";
    }

    public n(String r100, String r101, String r102) {
        this.f72047a = r100;
        this.f72048b = r101;
        this.f72049c = r102;
    }
}
