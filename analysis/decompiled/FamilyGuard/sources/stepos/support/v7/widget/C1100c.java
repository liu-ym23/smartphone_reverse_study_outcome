package stepos.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* renamed from: stepos.support.v7.widget.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1100c extends C1099b {
    public C1100c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f21917a;
        if (actionBarContainer.f21415h) {
            Drawable drawable = actionBarContainer.f21414g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f21412e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }
}
