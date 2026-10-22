package o;

import K.E0;
import K.InterfaceC0891n;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.f0;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010)\u001a\u00020(2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J)\u00102\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010/*\u00020.2\f\u00101\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00104R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b)\u00107\u001a\u0004\b8\u00109¨\u0006:"}, d2 = {"Lo/q;", "LK/n;", "Lw/U;", "Lw/K;", "requestMetadata", "Lw/y;", "frameNumber", "Lw/w;", "result", "<init>", "(Lw/K;JLw/w;Lkotlin/jvm/internal/i;)V", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfMode;", "r", "()Landroidx/camera/core/impl/CameraCaptureMetaData$AfMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AfState;", "o", "()Landroidx/camera/core/impl/CameraCaptureMetaData$AfState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeMode;", "k", "()Landroidx/camera/core/impl/CameraCaptureMetaData$AeMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AeState;", "s", "()Landroidx/camera/core/impl/CameraCaptureMetaData$AeState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbMode;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/core/impl/CameraCaptureMetaData$AwbMode;", "Landroidx/camera/core/impl/CameraCaptureMetaData$AwbState;", "q", "()Landroidx/camera/core/impl/CameraCaptureMetaData$AwbState;", "Landroidx/camera/core/impl/CameraCaptureMetaData$FlashState;", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/core/impl/CameraCaptureMetaData$FlashState;", "", "getTimestamp", "()J", "LK/E0;", "e", "()LK/E0;", "Landroidx/camera/core/impl/utils/ExifData$b;", "exifBuilder", "LY8/t;", "c", "(Landroidx/camera/core/impl/utils/ExifData$b;)V", "Landroid/hardware/camera2/CaptureResult;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Landroid/hardware/camera2/CaptureResult;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", "Lw/K;", Const.INTENT_KEY_PKGNAME, "J", "Lw/w;", "getResult$camera_camera2", "()Lw/w;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4985q implements InterfaceC0891n, w.U {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final w.K requestMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long frameNumber;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final w.w result;

    public /* synthetic */ C4985q(w.K k10, long j10, w.w wVar, kotlin.jvm.internal.i iVar) {
        this(k10, j10, wVar);
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(w.w.class))) {
            return (T) this.result.R0(type);
        }
        T t10 = (T) this.result;
        kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.CaptureResultAdapter.unwrapAs");
        return t10;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$FlashState a() {
        return r.p(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public void c(ExifData.b exifBuilder) throws NumberFormatException {
        kotlin.jvm.internal.p.i(exifBuilder, "exifBuilder");
        super.c(exifBuilder);
        r.r(this.result.getMetadata(), exifBuilder);
    }

    @Override // K.InterfaceC0891n
    public E0 e() {
        return (E0) this.requestMetadata.c(f0.a(), E0.b());
    }

    @Override // K.InterfaceC0891n
    public long getTimestamp() {
        return r.q(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AwbMode h() {
        return r.n(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CaptureResult j() {
        Object objR0 = R0(kotlin.jvm.internal.t.b(TotalCaptureResult.class));
        if (objR0 != null) {
            return (CaptureResult) objR0;
        }
        throw new IllegalStateException(("Failed to unwrap " + this + " as TotalCaptureResult").toString());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AeMode k() {
        return r.j(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AfState o() {
        return r.m(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AwbState q() {
        return r.o(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AfMode r() {
        return r.l(this.result.getMetadata());
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AeState s() {
        return r.k(this.result.getMetadata());
    }

    public C4985q(w.K requestMetadata, long j10, w.w result) {
        kotlin.jvm.internal.p.i(requestMetadata, "requestMetadata");
        kotlin.jvm.internal.p.i(result, "result");
        this.requestMetadata = requestMetadata;
        this.frameNumber = j10;
        this.result = result;
    }
}
