package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MusicPanel f145473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.ktvimpl.base.sei.k f145474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<com.bytedance.component.lyric.model.b> f145475c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f145473a, r101.f145473a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f145474b, r101.f145474b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f145475c, r101.f145475c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        MusicPanel r100 = this.f145473a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r104 = this.f145474b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.component.lyric.model.b> r107 = this.f145475c;
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
        return "KtvCoreDataModel(musicPanel=" + this.f145473a + ", seiModel=" + this.f145474b + ", currentLyricsLines=" + this.f145475c + ")";
    }

    public d(MusicPanel r100, com.bytedance.android.livesdk.ktvimpl.base.sei.k r101, List<com.bytedance.component.lyric.model.b> r102) {
        this.f145473a = r100;
        this.f145474b = r101;
        this.f145475c = r102;
    }
}
