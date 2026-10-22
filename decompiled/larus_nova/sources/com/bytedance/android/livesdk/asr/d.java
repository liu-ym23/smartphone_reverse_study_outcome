package com.bytedance.android.livesdk.asr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LogLevel f103969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f103970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f103971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f103972d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f103969a, r101.f103969a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f103970b, r101.f103970b) == true) goto L10;
        return false;
    L10:
        if (this.f103971c == r101.f103971c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f103972d, r101.f103972d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        LogLevel r100 = this.f103969a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f103970b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f103971c;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        Throwable r109 = this.f103972d;
        if (r109 == null) goto L14;
        r101 = r109.hashCode();
    L14:
        return r108 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        String r100 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(this.f103971c));
        Throwable r101 = this.f103972d;
        if (r101 == null) goto L8;
        String r102 = ExceptionsKt.stackTraceToString(r101);
        if (r102 == null) goto L8;
        String r103 = "\n".concat(r102);
        if (r103 == null) goto L8;
    L10:
        return "[" + r100 + "] [" + this.f103969a.name() + "] " + this.f103970b + r103;
    L8:
        r103 = "";
        goto L10
    }

    public d(LogLevel r100, String r101, Throwable r102) {
        long r103 = System.currentTimeMillis();
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f103969a = r100;
        this.f103970b = r101;
        this.f103971c = r103;
        this.f103972d = r102;
    }
}
