package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f107077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f107078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f107079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f107080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bundle f107081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f107082f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f107077a, r101.f107077a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f107078b, r101.f107078b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f107079c, r101.f107079c) == true) goto L12;
        return false;
    L12:
        if (this.f107080d == r101.f107080d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f107081e, r101.f107081e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f107082f, r101.f107082f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    public final int hashCode() {
        Activity r100 = this.f107077a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Context r104 = this.f107078b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f107079c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f107080d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        Bundle r113 = this.f107081e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        Bundle r116 = this.f107082f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
    L20:
        r114 = 0;
        goto L21
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
        return "OnCreateContainerOutData(activity=" + this.f107077a + ", context=" + this.f107078b + ", roomId=" + this.f107079c + ", isFirstRoom=" + this.f107080d + ", args=" + this.f107081e + ", savedInstanceState=" + this.f107082f + ")";
    }

    public final Activity getActivity() {
        return this.f107077a;
    }

    public final Context getContext() {
        return this.f107078b;
    }

    public e(FragmentActivity r100, Context r101, Long r102, boolean r103, Bundle r104, Bundle r105) {
        this.f107077a = r100;
        this.f107078b = r101;
        this.f107079c = r102;
        this.f107080d = r103;
        this.f107081e = r104;
        this.f107082f = r105;
    }
}
