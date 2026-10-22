package ah9;

import com.larus.im.bean.bot.SpeakerVoice;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpeakerVoice> f3459b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f3458a == r101.f3458a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3459b, r101.f3459b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f3458a * 31) + this.f3459b.hashCode();
    }

    public final String toString() {
        return "VoiceListResponse(status=" + this.f3458a + ", list=" + this.f3459b + ')';
    }

    public g(int r100, List<SpeakerVoice> r101) {
        Intrinsics.checkNotNullParameter(r101, "list");
        this.f3458a = r100;
        this.f3459b = r101;
    }
}
