package com.android.server.accessibility;

import android.view.SurfaceControl;
import android.view.accessibility.IAccessibilityInteractionConnectionCallback;
import com.android.internal.util.function.QuintConsumer;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessibilityManagerService$$ExternalSyntheticLambda28 implements QuintConsumer {
    public /* synthetic */ AccessibilityManagerService$$ExternalSyntheticLambda28() {
    }

    public final void accept(Object r1, Object r2, Object r3, Object r4, Object r5) {
        ((AccessibilityManagerService) r1).attachAccessibilityOverlayToDisplayInternal(((Integer) r2).intValue(), ((Integer) r3).intValue(), (SurfaceControl) r4, (IAccessibilityInteractionConnectionCallback) r5);
    }
}
