package stepos.support.v7.widget;

import android.graphics.Outline;
import android.widget.FrameLayout;
import androidx.appcompat.widget.C0191b;

/* renamed from: stepos.support.v7.widget.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0882b extends C0191b {
    @Override // androidx.appcompat.widget.C0191b, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        FrameLayout frameLayout = this.f3054b;
        if (((ActionBarContainer) frameLayout).f14710g) {
            if (((ActionBarContainer) frameLayout).f14709f != null) {
                ((ActionBarContainer) frameLayout).f14709f.getOutline(outline);
            }
        } else if (((ActionBarContainer) frameLayout).f14707d != null) {
            ((ActionBarContainer) frameLayout).f14707d.getOutline(outline);
        }
    }
}
