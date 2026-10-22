package androidx.compose.ui.hapticfeedback;

import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlatformHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public PlatformHapticFeedback(View r100) {
        this.view = r100;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo5605performHapticFeedbackCdsT49E(int r100) {
        HapticFeedbackType.Companion r101 = HapticFeedbackType.Companion;
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5613getConfirm5zf0vsI()) == false) goto L6;
        this.view.performHapticFeedback(16);
        return;
    L6:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5614getContextClick5zf0vsI()) == false) goto L9;
        this.view.performHapticFeedback(6);
        return;
    L9:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5615getGestureEnd5zf0vsI()) == false) goto L12;
        this.view.performHapticFeedback(13);
        return;
    L12:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5616getGestureThresholdActivate5zf0vsI()) == false) goto L15;
        this.view.performHapticFeedback(23);
        return;
    L15:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5617getKeyboardTap5zf0vsI()) == false) goto L18;
        this.view.performHapticFeedback(3);
        return;
    L18:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5618getLongPress5zf0vsI()) == false) goto L21;
        this.view.performHapticFeedback(0);
        return;
    L21:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5619getReject5zf0vsI()) == false) goto L24;
        this.view.performHapticFeedback(17);
        return;
    L24:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5620getSegmentFrequentTick5zf0vsI()) == false) goto L27;
        this.view.performHapticFeedback(27);
        return;
    L27:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5621getSegmentTick5zf0vsI()) == false) goto L30;
        this.view.performHapticFeedback(26);
        return;
    L30:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5622getTextHandleMove5zf0vsI()) == false) goto L33;
        this.view.performHapticFeedback(9);
        return;
    L33:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5623getToggleOff5zf0vsI()) == false) goto L36;
        this.view.performHapticFeedback(22);
        return;
    L36:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5624getToggleOn5zf0vsI()) == false) goto L39;
        this.view.performHapticFeedback(21);
        return;
    L39:
        if (HapticFeedbackType.m5609equalsimpl0(r100, r101.m5625getVirtualKey5zf0vsI()) == false) goto L54;
        this.view.performHapticFeedback(1);
        return;
    }
}
