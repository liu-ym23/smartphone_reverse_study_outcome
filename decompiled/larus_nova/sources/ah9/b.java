package ah9;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpeakerVoice f3445b;

    public b() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f3444a, r101.f3444a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f3445b, r101.f3445b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f3444a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        SpeakerVoice r104 = this.f3445b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DeleteVoiceResponse(voiceId=" + this.f3444a + ", voice=" + this.f3445b + ')';
    }

    public b(String r100, SpeakerVoice r101) {
        this.f3444a = r100;
        this.f3445b = r101;
    }
}
