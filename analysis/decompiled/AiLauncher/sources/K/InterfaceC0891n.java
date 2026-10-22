package K;

import android.hardware.camera2.CaptureResult;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.CameraCaptureMetaData$FlashState;
import androidx.camera.core.impl.utils.ExifData;

/* renamed from: K.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0891n {

    /* renamed from: K.n$a */
    public static final class a implements InterfaceC0891n {
        public static InterfaceC0891n b() {
            return new a();
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$FlashState a() {
            return CameraCaptureMetaData$FlashState.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public E0 e() {
            return E0.b();
        }

        @Override // K.InterfaceC0891n
        public long getTimestamp() {
            return -1L;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AwbMode h() {
            return CameraCaptureMetaData$AwbMode.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public CaptureResult j() {
            return null;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AeMode k() {
            return CameraCaptureMetaData$AeMode.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AfState o() {
            return CameraCaptureMetaData$AfState.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AwbState q() {
            return CameraCaptureMetaData$AwbState.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AfMode r() {
            return CameraCaptureMetaData$AfMode.UNKNOWN;
        }

        @Override // K.InterfaceC0891n
        public CameraCaptureMetaData$AeState s() {
            return CameraCaptureMetaData$AeState.UNKNOWN;
        }
    }

    CameraCaptureMetaData$FlashState a();

    default void c(ExifData.b bVar) throws NumberFormatException {
        bVar.g(a());
    }

    E0 e();

    long getTimestamp();

    CameraCaptureMetaData$AwbMode h();

    default CaptureResult j() {
        return null;
    }

    CameraCaptureMetaData$AeMode k();

    CameraCaptureMetaData$AfState o();

    CameraCaptureMetaData$AwbState q();

    CameraCaptureMetaData$AfMode r();

    CameraCaptureMetaData$AeState s();
}
