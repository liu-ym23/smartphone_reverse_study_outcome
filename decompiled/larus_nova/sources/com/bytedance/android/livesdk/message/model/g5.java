package com.bytedance.android.livesdk.message.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f153642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f153643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f153644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f153645d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g5) == false) goto L14;
        g5 r101 = (g5) r100;
        if (Intrinsics.areEqual(this.f153642a, r101.f153642a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f153643b, r101.f153643b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f153644c, r101.f153644c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f153645d, r101.f153645d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f153642a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f153643b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f153644c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f153645d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameRoomSuggestionFloatWindowMessageModel(id=" + this.f153642a + ", type=" + this.f153643b + ", title=" + this.f153644c + ", text=" + this.f153645d + ")";
    }

    public final String getType() {
        return this.f153643b;
    }

    public g5(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter("suggestion_message", "type");
        this.f153642a = r100;
        this.f153643b = "suggestion_message";
        this.f153644c = r101;
        this.f153645d = r102;
    }
}
