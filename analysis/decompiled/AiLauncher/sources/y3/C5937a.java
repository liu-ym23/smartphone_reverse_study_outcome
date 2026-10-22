package y3;

import android.os.SystemClock;
import com.google.android.gms.common.internal.C1666g;
import com.google.android.gms.common.internal.C1669j;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import x3.C5846a;

/* renamed from: y3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5937a {

    /* renamed from: c, reason: collision with root package name */
    public static final C1666g f43842c = new C1666g("StreamingFormatChecker", "");

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f43843a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public long f43844b = -1;

    public void a(C5846a c5846a) {
        if (c5846a.e() != -1) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f43843a.add(Long.valueOf(jElapsedRealtime));
        if (this.f43843a.size() > 5) {
            this.f43843a.removeFirst();
        }
        if (this.f43843a.size() != 5 || jElapsedRealtime - ((Long) C1669j.k((Long) this.f43843a.peekFirst())).longValue() >= 5000) {
            return;
        }
        long j10 = this.f43844b;
        if (j10 == -1 || jElapsedRealtime - j10 >= TimeUnit.SECONDS.toMillis(5L)) {
            this.f43844b = jElapsedRealtime;
            f43842c.f("StreamingFormatChecker", "ML Kit has detected that you seem to pass camera frames to the detector as a Bitmap object. This is inefficient. Please use YUV_420_888 format for camera2 API or NV21 format for (legacy) camera API and directly pass down the byte array to ML Kit.");
        }
    }
}
