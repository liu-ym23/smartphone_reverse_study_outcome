package com.bytedance.android.annie.bridge.method;

import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f38572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DialogInterface.OnClickListener f38573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f38574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DialogInterface.OnClickListener f38575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DialogInterface.OnCancelListener f38576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f38577i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f38569a, r101.f38569a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f38570b, r101.f38570b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f38571c, r101.f38571c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f38572d, r101.f38572d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f38573e, r101.f38573e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f38574f, r101.f38574f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f38575g, r101.f38575g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f38576h, r101.f38576h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f38577i, r101.f38577i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f38569a.hashCode() * 31;
        String r101 = this.f38570b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f38571c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f38572d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        DialogInterface.OnClickListener r111 = this.f38573e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f38574f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        DialogInterface.OnClickListener r117 = this.f38575g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        DialogInterface.OnCancelListener r120 = this.f38576h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Boolean r123 = this.f38577i;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ModalBuilder(context=" + this.f38569a + ", title=" + this.f38570b + ", message=" + this.f38571c + ", positiveBtnText=" + this.f38572d + ", positiveClickListener=" + this.f38573e + ", negativeBtnText=" + this.f38574f + ", negativeClickListener=" + this.f38575g + ", cancelListener=" + this.f38576h + ", cancelOnTouchOutside=" + this.f38577i + ')';
    }

    public final Context getContext() {
        return this.f38569a;
    }

    public b1(Context r100, String r101, String r102, String r103, l2 r104, String r105, j2 r106, k2 r107, Boolean r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f38569a = r100;
        this.f38570b = r101;
        this.f38571c = r102;
        this.f38572d = r103;
        this.f38573e = r104;
        this.f38574f = r105;
        this.f38575g = r106;
        this.f38576h = r107;
        this.f38577i = r110;
    }
}
