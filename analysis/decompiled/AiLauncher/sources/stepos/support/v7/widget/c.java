package stepos.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* loaded from: classes5.dex */
public class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f41531a;
        if (actionBarContainer.f41033h) {
            Drawable drawable = actionBarContainer.f41032g;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f41030e;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }
}
