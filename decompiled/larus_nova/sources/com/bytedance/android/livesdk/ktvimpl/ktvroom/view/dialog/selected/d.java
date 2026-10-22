package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MusicPanel f145088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f145089b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f145088a, r101.f145088a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f145089b, r101.f145089b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        MusicPanel r100 = this.f145088a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f145089b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvRoomSelectedMusicData(musicPanel=" + this.f145088a + ", extraMusicData=" + this.f145089b + ")";
    }

    public d(MusicPanel r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "musicPanel");
        Intrinsics.checkNotNullParameter(r101, "extraMusicData");
        this.f145088a = r100;
        this.f145089b = r101;
    }
}
