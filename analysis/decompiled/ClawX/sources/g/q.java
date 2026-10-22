package g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final p f2803a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f2804b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f2805c = null;
    public boolean d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2806e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2807f;

    public q(p pVar) {
        this.f2803a = pVar;
    }

    public final void a() {
        p pVar = this.f2803a;
        Drawable buttonDrawable = pVar.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.d || this.f2806e) {
                Drawable drawableMutate = buttonDrawable.mutate();
                if (this.d) {
                    drawableMutate.setTintList(this.f2804b);
                }
                if (this.f2806e) {
                    drawableMutate.setTintMode(this.f2805c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(pVar.getDrawableState());
                }
                pVar.setButtonDrawable(drawableMutate);
            }
        }
    }
}
