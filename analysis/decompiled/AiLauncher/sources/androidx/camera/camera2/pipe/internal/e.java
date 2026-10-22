package androidx.camera.camera2.pipe.internal;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u001b\b\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000f¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/pipe/internal/e;", "", "", "initialOffset", "errorDelta", "<init>", "(JJ)V", "cameraOutputNumber", "outputNumber", "", Const.INTENT_KEY_PKGNAME, "(JJ)Z", Const.INTENT_KEY_APIKEY, "J", "LOa/e;", "LOa/e;", "currentOffset", "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final e f11049d = new e(0, 0);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final long errorDelta;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Oa.e<Long> currentOffset;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/pipe/internal/e$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/internal/e;", "EXACT", "Landroidx/camera/camera2/pipe/internal/e;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/internal/e;", "", "NS_PER_SECOND", "J", "ERROR_DETECTION_FPS", "DEFAULT_ERROR_NS", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.pipe.internal.e$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final e a() {
            return e.f11049d;
        }

        public Companion() {
        }
    }

    public e(long j10, long j11) {
        this.errorDelta = j11;
        this.currentOffset = Oa.b.g(Long.valueOf(j10));
    }

    public final boolean b(long cameraOutputNumber, long outputNumber) {
        long jLongValue = this.currentOffset.c().longValue();
        long j10 = (cameraOutputNumber - outputNumber) + jLongValue;
        if (j10 == 0) {
            return true;
        }
        long j11 = this.errorDelta;
        if (j11 == 0 || j10 >= j11 || j10 <= (-j11)) {
            return false;
        }
        this.currentOffset.a(Long.valueOf(jLongValue), Long.valueOf(jLongValue - j10));
        return true;
    }
}
