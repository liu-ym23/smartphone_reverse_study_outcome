package com.bytedance.android.livesdk.event;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f123325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f123326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f123327c;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f123325a == r101.f123325a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f123326b, r101.f123326b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f123327c, r101.f123327c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f123325a * 31;
        String r101 = this.f123326b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        JSONObject r105 = this.f123327c;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "BannerH5RoomStatusChangeEvent(position=" + this.f123325a + ", type=" + this.f123326b + ", data=" + this.f123327c + ")";
    }

    public final String getType() {
        return this.f123326b;
    }

    public c(JSONObject r100) {
        Intrinsics.checkNotNullParameter("cny_task_reward", "type");
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f123325a = 1;
        this.f123326b = "cny_task_reward";
        this.f123327c = r100;
    }
}
