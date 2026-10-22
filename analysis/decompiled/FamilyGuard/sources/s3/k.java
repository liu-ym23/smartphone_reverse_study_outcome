package s3;

import android.os.Trace;
import com.stepos.minor.Minor;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f20291a = new k();

    private k() {
    }

    public final void a(String str, long j5) {
        j4.k.g(str, Minor.COLUMN_NAME);
        Trace.setCounter("StepOS:" + str, j5);
    }
}
