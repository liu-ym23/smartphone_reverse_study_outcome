package com.bytedance.android.shopping.commentv3.audio;

import com.bytedance.android.ecom.arch.slice.action.IAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f172647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IAction f172648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f172649d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s f172650e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == false) goto L16;
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f172646a, r101.f172646a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f172647b, r101.f172647b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f172648c, r101.f172648c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f172649d, r101.f172649d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f172650e, r101.f172650e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f172646a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        e r104 = this.f172647b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        IAction r107 = this.f172648c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        k r110 = this.f172649d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        s r113 = this.f172650e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "PlaybackSession(sliceId=" + this.f172646a + ", audioInfo=" + this.f172647b + ", onStopAction=" + this.f172648c + ", player=" + this.f172649d + ", externalAudioLease=" + this.f172650e + ")";
    }

    public w(String r100, e r101, IAction r102, k r103, s r104) {
        Intrinsics.checkNotNullParameter(r100, "sliceId");
        Intrinsics.checkNotNullParameter(r101, "audioInfo");
        Intrinsics.checkNotNullParameter(r103, "player");
        this.f172646a = r100;
        this.f172647b = r101;
        this.f172648c = r102;
        this.f172649d = r103;
        this.f172650e = r104;
    }
}
