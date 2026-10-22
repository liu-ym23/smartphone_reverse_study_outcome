package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.MicOccupancyMonitor;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\n\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"", "offHook", "externalRecording", "externalVoip", "", Const.INTENT_KEY_PKGNAME, "(ZZZ)[I", "Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;", "hintKind", "preSelf", "c", "(Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;Lcom/stepos/ailauncher/common/utils/MicOccupancyMonitor$OccupancyKind;)Z", "voipAudioMode", "otherAppCapturing", "silencedOtherVoip", Const.INTENT_KEY_UMID, "(ZZZ)Z", "telecomInCall", "", "callState", "telephonyInCallAudio", Const.INTENT_KEY_APIKEY, "(ZIZ)Z", "utils_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final boolean a(boolean z10, int i10, boolean z11) {
        if (z10 || z11) {
            return i10 == 2 || z11;
        }
        return false;
    }

    public static final int[] b(boolean z10, boolean z11, boolean z12) {
        return z10 ? new int[]{4, 2, 7, 1} : z12 ? new int[]{7, 1} : z11 ? new int[]{1} : new int[]{1};
    }

    public static final boolean c(MicOccupancyMonitor.OccupancyKind hintKind, MicOccupancyMonitor.OccupancyKind preSelf) {
        kotlin.jvm.internal.p.i(hintKind, "hintKind");
        kotlin.jvm.internal.p.i(preSelf, "preSelf");
        MicOccupancyMonitor.OccupancyKind occupancyKind = MicOccupancyMonitor.OccupancyKind.EXTERNAL_RECORDING;
        return hintKind == occupancyKind || preSelf == occupancyKind;
    }

    public static final boolean d(boolean z10, boolean z11, boolean z12) {
        if (z10) {
            return z11 || z12;
        }
        return false;
    }
}
