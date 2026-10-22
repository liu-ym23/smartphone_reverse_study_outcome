package abc;

import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final VoiceRecordState f2527b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f2526a, r101.f2526a) == true) goto L12;
        return false;
    L12:
        if (this.f2527b == r101.f2527b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f2526a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.f2527b.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "VoiceRecordStatus(taskId=" + this.f2526a + ", state=" + this.f2527b + ')';
    }

    public /* synthetic */ c(int r100) {
        this(null, VoiceRecordState.Idle);
    }

    public c(String r100, VoiceRecordState r101) {
        Intrinsics.checkNotNullParameter(r101, "state");
        this.f2526a = r100;
        this.f2527b = r101;
    }
}
