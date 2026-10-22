package com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.session;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f107106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Configuration f107107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f107108c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f107106a, r101.f107106a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f107107b, r101.f107107b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f107108c, r101.f107108c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        View r100 = this.f107106a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Configuration r104 = this.f107107b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Bundle r107 = this.f107108c;
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
        return "OnContainerChangerData(rootView=" + this.f107106a + ", newConfig=" + this.f107107b + ", outState=" + this.f107108c + ")";
    }

    public c(View r100, Configuration r101, Bundle r102) {
        this.f107106a = r100;
        this.f107107b = r101;
        this.f107108c = r102;
    }
}
