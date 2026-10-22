package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f107083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Activity f107084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f107085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f107086d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L14;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f107083a, r101.f107083a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f107084b, r101.f107084b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f107085c, r101.f107085c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f107086d, r101.f107086d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Bundle r100 = this.f107083a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Activity r104 = this.f107084b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Context r107 = this.f107085c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f107086d;
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
        return "OnStartRoomData(args=" + this.f107083a + ", activity=" + this.f107084b + ", context=" + this.f107085c + ", userActionStartTime=" + this.f107086d + ")";
    }

    public final Activity getActivity() {
        return this.f107084b;
    }

    public final Context getContext() {
        return this.f107085c;
    }

    public f(Bundle r100, FragmentActivity r101, Context r102, Long r103) {
        this.f107083a = r100;
        this.f107084b = r101;
        this.f107085c = r102;
        this.f107086d = r103;
    }
}
