package com.bytedance.android.livesdk.chatroom.replay.adapter;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayListExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Episode f108112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f108113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReplayListExtra f108114c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f108112a, r101.f108112a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f108113b, r101.f108113b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f108114c, r101.f108114c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Episode r100 = this.f108112a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f108113b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ReplayListExtra r107 = this.f108114c;
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
        return "EpisodeWrapper(episode=" + this.f108112a + ", groupName=" + this.f108113b + ", extra=" + this.f108114c + ")";
    }

    public a(Episode r100, String r101, ReplayListExtra r102) {
        Intrinsics.checkNotNullParameter(r100, "episode");
        this.f108112a = r100;
        this.f108113b = r101;
        this.f108114c = r102;
    }
}
