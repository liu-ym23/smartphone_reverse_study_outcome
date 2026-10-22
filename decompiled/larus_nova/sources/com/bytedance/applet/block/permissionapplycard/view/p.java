package com.bytedance.applet.block.permissionapplycard.view;

import com.larus.bmhome.chat.api.r0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f191489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<String, Boolean> f191490c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f191488a, r101.f191488a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f191489b, r101.f191489b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f191490c, r101.f191490c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f191488a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f191489b.hashCode()) * 31) + this.f191490c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "PermissionApplyCardViewInput(permissionData=" + this.f191488a + ", msgData=" + this.f191489b + ", isLastMessage=" + this.f191490c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(String r100, r0 r101, Function1<? super String, Boolean> r102) {
        Intrinsics.checkNotNullParameter(r101, "msgData");
        Intrinsics.checkNotNullParameter(r102, "isLastMessage");
        this.f191488a = r100;
        this.f191489b = r101;
        this.f191490c = r102;
    }
}
