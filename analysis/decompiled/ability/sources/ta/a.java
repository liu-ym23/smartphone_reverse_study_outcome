package ta;

import N9.j;
import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$click$2$1;
import stepai.aios.guiexecutor.core.AccessibleGuiActionExecutor$swipe$result$1$1;

/* loaded from: classes4.dex */
public final class a extends AccessibilityService.GestureResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6682a;
    public final /* synthetic */ d b;

    public /* synthetic */ a(d dVar, int i) {
        this.f6682a = i;
        this.b = dVar;
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCancelled(GestureDescription gestureDescription) {
        switch (this.f6682a) {
            case 0:
                super.onCancelled(gestureDescription);
                j.F("Gesture dispatch cancelled", "AccessibilityActionExecutor");
                ((AccessibleGuiActionExecutor$click$2$1) this.b).onActionResult(false);
                break;
            default:
                j.F("Swipe gesture cancelled", "AccessibilityActionExecutor");
                ((AccessibleGuiActionExecutor$swipe$result$1$1) this.b).onActionResult(false);
                break;
        }
    }

    @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
    public final void onCompleted(GestureDescription gestureDescription) {
        switch (this.f6682a) {
            case 0:
                super.onCompleted(gestureDescription);
                j.F("Gesture dispatch completed", "AccessibilityActionExecutor");
                ((AccessibleGuiActionExecutor$click$2$1) this.b).onActionResult(true);
                break;
            default:
                j.F("Swipe gesture completed", "AccessibilityActionExecutor");
                ((AccessibleGuiActionExecutor$swipe$result$1$1) this.b).onActionResult(true);
                break;
        }
    }
}
