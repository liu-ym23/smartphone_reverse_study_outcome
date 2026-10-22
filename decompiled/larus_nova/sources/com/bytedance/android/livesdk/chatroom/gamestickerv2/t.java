package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerRecord;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GameStickerRecord> f106370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f106371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<String> f106372c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L12;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f106370a, r101.f106370a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f106371b, r101.f106371b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f106372c, r101.f106372c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<GameStickerRecord> r100 = this.f106370a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Set<Integer> r104 = this.f106371b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Set<String> r107 = this.f106372c;
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
        return "SeiData(recordId=" + this.f106370a + ", ver=" + this.f106371b + ", displayIds=" + this.f106372c + ")";
    }

    public t(List<GameStickerRecord> r100, Set<Integer> r101, Set<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, "ver");
        Intrinsics.checkNotNullParameter(r102, "displayIds");
        this.f106370a = r100;
        this.f106371b = r101;
        this.f106372c = r102;
    }
}
