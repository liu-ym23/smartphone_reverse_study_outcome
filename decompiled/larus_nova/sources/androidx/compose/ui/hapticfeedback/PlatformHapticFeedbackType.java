package androidx.compose.ui.hapticfeedback;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0013\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007R\u0013\u0010\u0017\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0018\u0010\u0007R\u0013\u0010\u0019\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007R\u0013\u0010\u001b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001c\u0010\u0007R\u0013\u0010\u001d\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007R\u0013\u0010\u001f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b \u0010\u0007¨\u0006!"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedbackType;", "", "<init>", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "KeyboardTap", "getKeyboardTap-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformHapticFeedbackType {
    public static final int $stable = 0;
    private static final int Confirm = 0;
    private static final int ContextClick = 0;
    private static final int GestureEnd = 0;
    private static final int GestureThresholdActivate = 0;
    public static final PlatformHapticFeedbackType INSTANCE = null;
    private static final int KeyboardTap = 0;
    private static final int LongPress = 0;
    private static final int Reject = 0;
    private static final int SegmentFrequentTick = 0;
    private static final int SegmentTick = 0;
    private static final int TextHandleMove = 0;
    private static final int ToggleOff = 0;
    private static final int ToggleOn = 0;
    private static final int VirtualKey = 0;

    private PlatformHapticFeedbackType() {
    }

    static {
        INSTANCE = new PlatformHapticFeedbackType();
        Confirm = HapticFeedbackType.m5607constructorimpl(16);
        ContextClick = HapticFeedbackType.m5607constructorimpl(6);
        GestureEnd = HapticFeedbackType.m5607constructorimpl(13);
        GestureThresholdActivate = HapticFeedbackType.m5607constructorimpl(23);
        KeyboardTap = HapticFeedbackType.m5607constructorimpl(3);
        LongPress = HapticFeedbackType.m5607constructorimpl(0);
        Reject = HapticFeedbackType.m5607constructorimpl(17);
        SegmentFrequentTick = HapticFeedbackType.m5607constructorimpl(27);
        SegmentTick = HapticFeedbackType.m5607constructorimpl(26);
        TextHandleMove = HapticFeedbackType.m5607constructorimpl(9);
        ToggleOff = HapticFeedbackType.m5607constructorimpl(22);
        ToggleOn = HapticFeedbackType.m5607constructorimpl(21);
        VirtualKey = HapticFeedbackType.m5607constructorimpl(1);
    }

    /* JADX INFO: renamed from: getConfirm-5zf0vsI, reason: not valid java name */
    public final int m5626getConfirm5zf0vsI() {
        return Confirm;
    }

    /* JADX INFO: renamed from: getContextClick-5zf0vsI, reason: not valid java name */
    public final int m5627getContextClick5zf0vsI() {
        return ContextClick;
    }

    /* JADX INFO: renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
    public final int m5628getGestureEnd5zf0vsI() {
        return GestureEnd;
    }

    /* JADX INFO: renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
    public final int m5629getGestureThresholdActivate5zf0vsI() {
        return GestureThresholdActivate;
    }

    /* JADX INFO: renamed from: getKeyboardTap-5zf0vsI, reason: not valid java name */
    public final int m5630getKeyboardTap5zf0vsI() {
        return KeyboardTap;
    }

    /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
    public final int m5631getLongPress5zf0vsI() {
        return LongPress;
    }

    /* JADX INFO: renamed from: getReject-5zf0vsI, reason: not valid java name */
    public final int m5632getReject5zf0vsI() {
        return Reject;
    }

    /* JADX INFO: renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
    public final int m5633getSegmentFrequentTick5zf0vsI() {
        return SegmentFrequentTick;
    }

    /* JADX INFO: renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
    public final int m5634getSegmentTick5zf0vsI() {
        return SegmentTick;
    }

    /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
    public final int m5635getTextHandleMove5zf0vsI() {
        return TextHandleMove;
    }

    /* JADX INFO: renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
    public final int m5636getToggleOff5zf0vsI() {
        return ToggleOff;
    }

    /* JADX INFO: renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
    public final int m5637getToggleOn5zf0vsI() {
        return ToggleOn;
    }

    /* JADX INFO: renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
    public final int m5638getVirtualKey5zf0vsI() {
        return VirtualKey;
    }
}
