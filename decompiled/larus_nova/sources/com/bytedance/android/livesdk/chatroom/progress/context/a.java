package com.bytedance.android.livesdk.chatroom.progress.context;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f107688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f107689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence f107690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f107691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f107692e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.progress.context.a$a, reason: collision with other inner class name */
    public static final class C1637a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f107688a, r101.f107688a) == true) goto L8;
        return false;
    L8:
        if (this.f107689b == r101.f107689b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f107690c, r101.f107690c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f107691d, r101.f107691d) == true) goto L14;
        return false;
    L14:
        if (this.f107692e == r101.f107692e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r100 = this.f107688a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f107689b) * 31;
        CharSequence r104 = this.f107690c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        View r107 = this.f107691d;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f107692e;
        ?? r110 = r109;
        if (r109 == false) goto L17;
        r110 = 1;
    L17:
        return r108 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PlayerTipItem(key=" + this.f107688a + ", type=" + this.f107689b + ", content=" + this.f107690c + ", customView=" + this.f107691d + ", needAlpha=" + this.f107692e + ")";
    }

    public final int getType() {
        return this.f107689b;
    }

    public /* synthetic */ a(String r100, View r101) {
        this(r100, 1, null, r101, false);
    }

    public a(String r100, int r101, CharSequence r102, View r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f107688a = r100;
        this.f107689b = r101;
        this.f107690c = r102;
        this.f107691d = r103;
        this.f107692e = r104;
    }
}
