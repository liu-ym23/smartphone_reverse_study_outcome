package x;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Map;
import kotlin.Metadata;
import w.C5708n;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\b*\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u0017R&\u0010!\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"Lx/h;", "Lw/x;", "Landroid/hardware/camera2/CaptureResult;", "captureResult", "Lw/n;", C3081a.CAMERA_FOCUS, "<init>", "(Landroid/hardware/camera2/CaptureResult;Ljava/lang/String;Lkotlin/jvm/internal/i;)V", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/hardware/camera2/CaptureResult$Key;", "key", "U", "(Landroid/hardware/camera2/CaptureResult$Key;)Ljava/lang/Object;", "default", SdCardDbCreator.FIELD_LASTLOC_ID, "(Landroid/hardware/camera2/CaptureResult$Key;Ljava/lang/Object;)Ljava/lang/Object;", "", "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/CaptureResult;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "", "c", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "extraMetadata", "Lw/y;", "m1", "()J", "frameNumber", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.h, reason: case insensitive filesystem and from toString */
/* loaded from: classes.dex */
public final class FrameMetadata implements w.x {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CaptureResult captureResult;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String camera;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<?, Object> extraMetadata;

    public /* synthetic */ FrameMetadata(CaptureResult captureResult, String str, kotlin.jvm.internal.i iVar) {
        this(captureResult, str);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        T t10;
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CaptureResult.class))) {
            T t11 = (T) this.captureResult;
            kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.camera.camera2.pipe.compat.AndroidFrameMetadata.unwrapAs");
            return t11;
        }
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(TotalCaptureResult.class)) || (t10 = (T) this.captureResult) == null) {
            return null;
        }
        return t10;
    }

    @Override // w.x
    public <T> T U(CaptureResult.Key<T> key) {
        kotlin.jvm.internal.p.i(key, "key");
        T t10 = (T) e().get(key);
        return t10 == null ? (T) this.captureResult.get(key) : t10;
    }

    @Override // w.x
    public <T> T a1(CaptureResult.Key<T> key, T t10) {
        kotlin.jvm.internal.p.i(key, "key");
        T t11 = (T) U(key);
        return t11 == null ? t10 : t11;
    }

    @Override // w.x
    /* renamed from: b, reason: from getter */
    public String getCamera() {
        return this.camera;
    }

    public Map<?, Object> e() {
        return this.extraMetadata;
    }

    @Override // w.x
    public long m1() {
        return w.y.b(this.captureResult.getFrameNumber());
    }

    public String toString() {
        return "FrameMetadata(camera: " + ((Object) C5708n.f(getCamera())) + ", frameNumber: " + this.captureResult.getFrameNumber() + ')';
    }

    public FrameMetadata(CaptureResult captureResult, String camera) {
        kotlin.jvm.internal.p.i(captureResult, "captureResult");
        kotlin.jvm.internal.p.i(camera, "camera");
        this.captureResult = captureResult;
        this.camera = camera;
        this.extraMetadata = kotlin.collections.a.i();
    }
}
