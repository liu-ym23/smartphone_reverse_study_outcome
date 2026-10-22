package bs8;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.model.PcDeviceUiState;
import com.larus.bmhome.taskskill.service.TaskModeService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class g {
    public static final PcDeviceUiState b(PcDevice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Boolean r101 = r100.r();
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L6;
        return PcDeviceUiState.OFFLINE;
    L6:
        if (TaskModeService.f314424a.f(r100) == false) goto L9;
        return PcDeviceUiState.NEED_UPGRADE;
    L9:
        if (Intrinsics.areEqual(r100.g(), r102) == true) goto L12;
        return PcDeviceUiState.CONTROL_DISABLED;
    L12:
        if (Intrinsics.areEqual(r100.c(), r102) == true) goto L15;
        return PcDeviceUiState.UNAUTHORIZED_AVAILABLE;
    L15:
        return PcDeviceUiState.AUTHORIZED_AVAILABLE;
    }

    public static final PcDevice a(PcDevice r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        PcDevice r103 = PcDevice.a(r100, Boolean.valueOf(r101), null, null, 8183);
        r103.f314343a = r102;
        return r103;
    }
}
