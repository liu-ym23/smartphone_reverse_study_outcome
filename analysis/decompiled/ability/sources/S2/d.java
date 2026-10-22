package S2;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.behavior.SwipeDismissBehavior;

/* loaded from: classes3.dex */
public final class d implements AccessibilityViewCommand {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeDismissBehavior f1172a;

    public d(SwipeDismissBehavior swipeDismissBehavior) {
        this.f1172a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        SwipeDismissBehavior swipeDismissBehavior = this.f1172a;
        if (!swipeDismissBehavior.c(view)) {
            return false;
        }
        boolean z10 = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.d;
        ViewCompat.offsetLeftAndRight(view, (!(i == 0 && z10) && (i != 1 || z10)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }
}
