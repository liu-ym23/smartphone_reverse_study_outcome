package aw3;

import com.bytedance.applet.audio.background.BackgroundAudioEventName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BackgroundAudioEventName f16461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q0 f16462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0 f16463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f16464d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r101 = (n0) r100;
        if (this.f16461a == r101.f16461a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f16462b, r101.f16462b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f16463c, r101.f16463c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f16464d, r101.f16464d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f16461a.hashCode() * 31) + this.f16462b.hashCode()) * 31;
        m0 r101 = this.f16463c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f16464d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BackgroundAudioEvent(name=" + this.f16461a + ", state=" + this.f16462b + ", error=" + this.f16463c + ", appletId=" + this.f16464d + ')';
    }

    public n0(BackgroundAudioEventName r100, q0 r101, m0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f16461a = r100;
        this.f16462b = r101;
        this.f16463c = r102;
        this.f16464d = r103;
    }
}
