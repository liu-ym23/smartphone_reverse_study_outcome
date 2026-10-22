package com.bytedance.android.livesdk.gift.biggift.viewModel;

import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CurrentState f125993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f125994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f125995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f125996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l1 f125997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n f125998f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f125993a, r101.f125993a) == true) goto L8;
        return false;
    L8:
        if (this.f125994b == r101.f125994b) goto L10;
        return false;
    L10:
        if (this.f125995c == r101.f125995c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f125996d, r101.f125996d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f125997e, r101.f125997e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f125998f, r101.f125998f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        CurrentState r100 = this.f125993a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + this.f125994b) * 31) + this.f125995c) * 31;
        e r104 = this.f125996d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        l1 r107 = this.f125997e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n r110 = this.f125998f;
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
        return "BigGiftSendInfo(state=" + this.f125993a + ", clickCount=" + this.f125994b + ", sendSuccessCount=" + this.f125995c + ", subscribeGiftInfo=" + this.f125996d + ", buffInfo=" + this.f125997e + ", diyInfo=" + this.f125998f + ")";
    }

    public a(CurrentState r100, int r101, int r102, e r103, l1 r104, n r105) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f125993a = r100;
        this.f125994b = r101;
        this.f125995c = r102;
        this.f125996d = r103;
        this.f125997e = r104;
        this.f125998f = r105;
    }

    public static a a(a r100, CurrentState r101, int r102, int r110, e r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f125993a;
    L5:
        CurrentState r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f125994b;
    L8:
        int r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f125995c;
    L11:
        int r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        r111 = r100.f125996d;
    L14:
        e r106 = r111;
        if ((r112 & 16) == 0) goto L17;
        l1 r107 = r100.f125997e;
    L19:
        if ((r112 & 32) == 0) goto L21;
        n r108 = r100.f125998f;
    L22:
        Intrinsics.checkNotNullParameter(r103, "state");
        return new a(r103, r104, r105, r106, r107, r108);
    L21:
        r108 = null;
        goto L22
    L17:
        r107 = null;
        goto L19
    }
}
