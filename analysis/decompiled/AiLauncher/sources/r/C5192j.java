package r;

import D.C0761b0;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Log;
import androidx.camera.camera2.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import com.autonavi.aps.amapapi.config.Const;
import java.nio.BufferUnderflowException;
import kotlin.Metadata;
import t.C5473b;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0001*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lt/v;", "", "allowRethrowOnError", Const.INTENT_KEY_APIKEY, "(Lt/v;Z)Z", "camera-camera2"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* renamed from: r.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5192j {
    public static final boolean a(InterfaceC5494v interfaceC5494v, boolean z10) {
        Boolean bool;
        kotlin.jvm.internal.p.i(interfaceC5494v, "<this>");
        try {
            androidx.camera.camera2.pipe.g metadata = interfaceC5494v.getMetadata();
            CameraCharacteristics.Key FLASH_INFO_AVAILABLE = CameraCharacteristics.FLASH_INFO_AVAILABLE;
            kotlin.jvm.internal.p.h(FLASH_INFO_AVAILABLE, "FLASH_INFO_AVAILABLE");
            bool = (Boolean) metadata.e0(FLASH_INFO_AVAILABLE);
        } catch (BufferUnderflowException e10) {
            if (q.f.f38470a.c(FlashAvailabilityBufferUnderflowQuirk.class) != null) {
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Device is known to throw an exception while checking flash availability. Flash is not available. [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "].");
                }
            } else {
                C5473b c5473b2 = C5473b.f41865a;
                if (C0761b0.g("CXCP")) {
                    Log.e(C5473b.TRUNCATED_TAG, "Exception thrown while checking for flash availability on device not known to throw exceptions during this check. Please file an issue at https://issuetracker.google.com/issues/new?component=618491&template=1257717 with this error message [Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", API Level: " + Build.VERSION.SDK_INT + "]. Flash is not available.", e10);
                }
            }
            if (z10) {
                throw e10;
            }
            bool = Boolean.FALSE;
        }
        if (bool == null) {
            C5473b c5473b3 = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "Characteristics did not contain key FLASH_INFO_AVAILABLE. Flash is not available.");
            }
        }
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static /* synthetic */ boolean b(InterfaceC5494v interfaceC5494v, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(interfaceC5494v, z10);
    }
}
