package com.bytedance.android.livesdk.interactivity.imagerecognition;

import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f136979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageRecognitionEntry f136980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f136981c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f136979a == r101.f136979a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f136980b, r101.f136980b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f136981c, r101.f136981c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f136979a * 31;
        ImageRecognitionEntry r101 = this.f136980b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f136981c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageRecognitionEvent(scene=" + this.f136979a + ", entry=" + this.f136980b + ", btmToken=" + this.f136981c + ")";
    }

    public a(int r100, ImageRecognitionEntry r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "entry");
        this.f136979a = r100;
        this.f136980b = r101;
        this.f136981c = r102;
    }
}
