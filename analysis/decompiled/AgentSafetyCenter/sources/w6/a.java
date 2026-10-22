package w6;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public d5.b f15267a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ c f15268b;

    public final void a(Drawable drawable) {
        c cVar = this.f15268b;
        ColorStateList colorStateList = cVar.f15279s;
        if (colorStateList != null) {
            drawable.setTint(colorStateList.getColorForState(cVar.f15283w, colorStateList.getDefaultColor()));
        }
    }
}
