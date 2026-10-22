package Y;

import K.E0;
import K.InterfaceC0891n;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;

/* loaded from: classes.dex */
public class k implements InterfaceC0891n {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0891n f6978a;

    /* renamed from: b, reason: collision with root package name */
    public final E0 f6979b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6980c;

    public k(E0 e02, InterfaceC0891n interfaceC0891n) {
        this(interfaceC0891n, e02, -1L);
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$FlashState a() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.a() : CameraCaptureMetaData$FlashState.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public E0 e() {
        return this.f6979b;
    }

    @Override // K.InterfaceC0891n
    public long getTimestamp() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        if (interfaceC0891n != null) {
            return interfaceC0891n.getTimestamp();
        }
        long j10 = this.f6980c;
        if (j10 != -1) {
            return j10;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AwbMode h() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.h() : CameraCaptureMetaData$AwbMode.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AeMode k() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.k() : CameraCaptureMetaData$AeMode.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AfState o() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.o() : CameraCaptureMetaData$AfState.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AwbState q() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.q() : CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AfMode r() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.r() : CameraCaptureMetaData$AfMode.UNKNOWN;
    }

    @Override // K.InterfaceC0891n
    public CameraCaptureMetaData$AeState s() {
        InterfaceC0891n interfaceC0891n = this.f6978a;
        return interfaceC0891n != null ? interfaceC0891n.s() : CameraCaptureMetaData$AeState.UNKNOWN;
    }

    public k(E0 e02, long j10) {
        this(null, e02, j10);
    }

    public k(InterfaceC0891n interfaceC0891n, E0 e02, long j10) {
        this.f6978a = interfaceC0891n;
        this.f6979b = e02;
        this.f6980c = j10;
    }
}
