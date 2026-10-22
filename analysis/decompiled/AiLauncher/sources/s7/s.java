package s7;

import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Ls7/s;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "Ls7/g;", "Ls7/g;", "frameTimes", "", Const.INTENT_KEY_PKGNAME, "J", "lastFrameNanos", "c", "frameCount", Const.INTENT_KEY_UMID, "droppedFrames", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g frameTimes = new g(120);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long lastFrameNanos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long frameCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long droppedFrames;

    public final void a() {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (this.lastFrameNanos != 0) {
            float f10 = (jElapsedRealtimeNanos - r2) / 1000000.0f;
            this.frameTimes.a(f10);
            if (f10 > 18.0f) {
                this.droppedFrames++;
            }
        }
        this.lastFrameNanos = jElapsedRealtimeNanos;
        this.frameCount++;
    }
}
