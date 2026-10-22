package K;

import D.C0761b0;
import androidx.camera.core.impl.CameraCaptureMetaData$AeMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbMode;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/* loaded from: classes.dex */
public class Q {

    /* renamed from: a, reason: collision with root package name */
    public static final Set<CameraCaptureMetaData$AfState> f3923a = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AfState.PASSIVE_FOCUSED, CameraCaptureMetaData$AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_FOCUSED, CameraCaptureMetaData$AfState.LOCKED_NOT_FOCUSED));

    /* renamed from: b, reason: collision with root package name */
    public static final Set<CameraCaptureMetaData$AwbState> f3924b = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData$AwbState.CONVERGED, CameraCaptureMetaData$AwbState.UNKNOWN));

    /* renamed from: c, reason: collision with root package name */
    public static final Set<CameraCaptureMetaData$AeState> f3925c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set<CameraCaptureMetaData$AeState> f3926d;

    static {
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState = CameraCaptureMetaData$AeState.CONVERGED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState2 = CameraCaptureMetaData$AeState.FLASH_REQUIRED;
        CameraCaptureMetaData$AeState cameraCaptureMetaData$AeState3 = CameraCaptureMetaData$AeState.UNKNOWN;
        Set<CameraCaptureMetaData$AeState> setUnmodifiableSet = Collections.unmodifiableSet(EnumSet.of(cameraCaptureMetaData$AeState, cameraCaptureMetaData$AeState2, cameraCaptureMetaData$AeState3));
        f3925c = setUnmodifiableSet;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) setUnmodifiableSet);
        enumSetCopyOf.remove(cameraCaptureMetaData$AeState2);
        enumSetCopyOf.remove(cameraCaptureMetaData$AeState3);
        f3926d = Collections.unmodifiableSet(enumSetCopyOf);
    }

    public static boolean a(InterfaceC0891n interfaceC0891n, boolean z10) {
        boolean z11 = interfaceC0891n.r() == CameraCaptureMetaData$AfMode.OFF || f3923a.contains(interfaceC0891n.o());
        boolean z12 = interfaceC0891n.k() == CameraCaptureMetaData$AeMode.OFF;
        boolean z13 = !z10 ? !(z12 || f3925c.contains(interfaceC0891n.s())) : !(z12 || f3926d.contains(interfaceC0891n.s()));
        boolean z14 = interfaceC0891n.h() == CameraCaptureMetaData$AwbMode.OFF || f3924b.contains(interfaceC0891n.q());
        C0761b0.a("ConvergenceUtils", "checkCaptureResult, AE=" + interfaceC0891n.s() + " AF =" + interfaceC0891n.o() + " AWB=" + interfaceC0891n.q());
        return z11 && z13 && z14;
    }
}
