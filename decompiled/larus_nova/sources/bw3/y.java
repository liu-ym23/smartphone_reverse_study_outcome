package bw3;

import com.bytedance.applet.audio.inner.InnerAudioEventName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InnerAudioEventName f21138a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h0 f21139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f21140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21141d;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f21138a == r101.f21138a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f21139b, r101.f21139b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f21140c, r101.f21140c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f21141d, r101.f21141d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f21138a.hashCode() * 31) + this.f21139b.hashCode()) * 31;
        x r101 = this.f21140c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f21141d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InnerAudioEvent(name=" + this.f21138a + ", state=" + this.f21139b + ", error=" + this.f21140c + ", appletId=" + this.f21141d + ')';
    }

    public y(InnerAudioEventName r100, h0 r101, x r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f21138a = r100;
        this.f21139b = r101;
        this.f21140c = r102;
        this.f21141d = r103;
    }
}
