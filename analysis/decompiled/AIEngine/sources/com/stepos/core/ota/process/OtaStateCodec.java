package com.stepos.core.ota.process;

import com.stepos.core.ota.domain.OtaError;
import com.stepos.core.ota.domain.OtaState;
import com.stepos.core.ota.domain.PauseReason;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OtaStateCodec {
    public static final OtaStateCodec INSTANCE = new OtaStateCodec();

    private OtaStateCodec() {
    }

    public static /* synthetic */ OtaState decodeState$default(OtaStateCodec otaStateCodec, int i10, long j10, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j10 = 0;
        }
        if ((i11 & 4) != 0) {
            j11 = 0;
        }
        return otaStateCodec.decodeState(i10, j10, j11);
    }

    public final OtaState decodeState(int i10, long j10, long j11) {
        switch (i10) {
            case 1:
                return OtaState.Queued.INSTANCE;
            case 2:
                return OtaState.Checking.INSTANCE;
            case 3:
                return new OtaState.Downloading(j10, j11);
            case 4:
                return OtaState.Verifying.INSTANCE;
            case 5:
                return OtaState.Installing.INSTANCE;
            case 6:
                return OtaState.Activating.INSTANCE;
            case 7:
                return new OtaState.Installed(0);
            case 8:
                return new OtaState.Paused(PauseReason.USER, 0);
            case 9:
                return new OtaState.Failed(new OtaError.Unknown("", null));
            case 10:
                return OtaState.Removed.INSTANCE;
            default:
                return OtaState.Idle.INSTANCE;
        }
    }

    public final int stateOrdinal(OtaState state) {
        g.f(state, "state");
        if (state instanceof OtaState.Idle) {
            return 0;
        }
        if (state instanceof OtaState.Queued) {
            return 1;
        }
        if (state instanceof OtaState.Checking) {
            return 2;
        }
        if (state instanceof OtaState.Downloading) {
            return 3;
        }
        if (state instanceof OtaState.Verifying) {
            return 4;
        }
        if (state instanceof OtaState.Installing) {
            return 5;
        }
        if (state instanceof OtaState.Activating) {
            return 6;
        }
        if (state instanceof OtaState.Installed) {
            return 7;
        }
        if (state instanceof OtaState.Paused) {
            return 8;
        }
        if (state instanceof OtaState.Failed) {
            return 9;
        }
        if (state instanceof OtaState.Removed) {
            return 10;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int toDownloadState(int i10) {
        switch (i10) {
            case 1:
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 3;
            case 10:
                return 7;
            default:
                return 0;
        }
    }
}
