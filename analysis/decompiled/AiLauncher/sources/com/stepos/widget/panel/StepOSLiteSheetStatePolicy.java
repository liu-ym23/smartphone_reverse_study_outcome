package com.stepos.widget.panel;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/widget/panel/StepOSLiteSheetStatePolicy;", "", "<init>", "()V", "", "mode", "LY8/t;", "requireMode", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "", "allows", "(II)Z", "defaultState", "(I)I", "requested", "initialState", "(ILjava/lang/Integer;)I", "", "minPosition", "(I)F", "origin", "canDismiss", "dragLimit", "(IZI)F", "position", "velocity", "minFling", "releasedState", "(IFFFZI)I", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSLiteSheetStatePolicy {
    public static final StepOSLiteSheetStatePolicy INSTANCE = new StepOSLiteSheetStatePolicy();

    private StepOSLiteSheetStatePolicy() {
    }

    public static /* synthetic */ float dragLimit$default(StepOSLiteSheetStatePolicy stepOSLiteSheetStatePolicy, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        return stepOSLiteSheetStatePolicy.dragLimit(i10, z10, i11);
    }

    public static /* synthetic */ int releasedState$default(StepOSLiteSheetStatePolicy stepOSLiteSheetStatePolicy, int i10, float f10, float f11, float f12, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            i11 = 0;
        }
        return stepOSLiteSheetStatePolicy.releasedState(i10, f10, f11, f12, z10, i11);
    }

    public final boolean allows(int mode, int state) {
        if (state < 0 || state >= 2) {
            return false;
        }
        return mode == 0 || (mode == 1 && state == 1) || (mode == 2 && state == 0);
    }

    public final int defaultState(int mode) {
        return mode == 2 ? 0 : 1;
    }

    public final float dragLimit(int origin, boolean canDismiss, int mode) {
        if (mode == 0) {
            return (origin == 0 || !canDismiss) ? 1.0f : 2.0f;
        }
        if (canDismiss) {
            return 2.0f;
        }
        return defaultState(mode);
    }

    public final int initialState(int mode, Integer requested) {
        requireMode(mode);
        int iIntValue = requested != null ? requested.intValue() : defaultState(mode);
        if (allows(mode, iIntValue)) {
            return iIntValue;
        }
        throw new IllegalArgumentException("Initial state conflicts with sheetMode");
    }

    public final float minPosition(int mode) {
        return mode == 1 ? 1.0f : 0.0f;
    }

    public final int releasedState(int origin, float position, float velocity, float minFling, boolean canDismiss, int mode) {
        if (mode != 0) {
            int iDefaultState = defaultState(mode);
            float f10 = iDefaultState + ((2 - iDefaultState) * 0.2f);
            if (!canDismiss || velocity < (-minFling) || (velocity <= minFling && position <= f10)) {
                return iDefaultState;
            }
            return 2;
        }
        if (origin == 0) {
            return (velocity > minFling || (position > 0.2f && velocity >= (-minFling))) ? 1 : 0;
        }
        if (velocity < (-minFling)) {
            return 0;
        }
        if (position >= 0.8f || velocity > minFling) {
            return (!canDismiss || (velocity <= minFling && position <= 1.2f)) ? 1 : 2;
        }
        return 0;
    }

    public final void requireMode(int mode) {
        if (mode < 0 || mode >= 3) {
            throw new IllegalArgumentException("Mode must be MODE_BOTH, MODE_HALF_ONLY or MODE_EXPANDED_ONLY");
        }
    }
}
