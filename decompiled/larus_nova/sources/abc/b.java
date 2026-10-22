package abc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2525b;

    public b() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f2524a, r101.f2524a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2525b, r101.f2525b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f2524a.hashCode() * 31) + this.f2525b.hashCode();
    }

    public final String toString() {
        return "VoiceRecordDetail(taskId=" + this.f2524a + ", voiceFile=" + this.f2525b + ')';
    }

    public b(String r100, int r101) {
        String r102 = "";
        if ((r101 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r101 & 2) != 0) goto L9;
        r102 = null;
    L9:
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r102, "voiceFile");
        this.f2524a = r100;
        this.f2525b = r102;
    }
}
