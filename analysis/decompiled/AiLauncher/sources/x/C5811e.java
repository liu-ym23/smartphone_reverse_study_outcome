package x;

import android.hardware.camera2.CaptureFailure;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\t*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001f\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010%\u001a\u00020 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lx/e;", "Lw/J;", "Lw/K;", "requestMetadata", "Landroid/hardware/camera2/CaptureFailure;", "captureFailure", "<init>", "(Lw/K;Landroid/hardware/camera2/CaptureFailure;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lw/K;", "getRequestMetadata", "()Lw/K;", Const.INTENT_KEY_PKGNAME, "Landroid/hardware/camera2/CaptureFailure;", "Lw/y;", "c", "J", "getFrameNumber-Ugla2oM", "()J", "frameNumber", "", Const.INTENT_KEY_UMID, "I", "getReason", "()I", "reason", "", "e", "Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Z", "wasImageCaptured", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5811e implements w.J {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final w.K requestMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CaptureFailure captureFailure;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long frameNumber;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final int reason;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final boolean wasImageCaptured;

    public C5811e(w.K requestMetadata, CaptureFailure captureFailure) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(captureFailure, "captureFailure");
        this.requestMetadata = requestMetadata;
        this.captureFailure = captureFailure;
        this.frameNumber = w.y.b(captureFailure.getFrameNumber());
        this.reason = captureFailure.getReason();
        this.wasImageCaptured = captureFailure.wasImageCaptured();
    }

    @Override // w.J
    /* renamed from: A, reason: from getter */
    public boolean getWasImageCaptured() {
        return this.wasImageCaptured;
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CaptureFailure.class))) {
            return (T) this.captureFailure;
        }
        return null;
    }

    @Override // w.J
    public int getReason() {
        return this.reason;
    }
}
