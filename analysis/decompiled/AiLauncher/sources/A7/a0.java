package A7;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00020\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"LA7/a0;", "Ly7/s;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Ly7/F;", "params", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ly7/F;)V", "release", "()V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "viewRef", "Landroid/graphics/drawable/GradientDrawable;", Const.INTENT_KEY_PKGNAME, "Landroid/graphics/drawable/GradientDrawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "c", "Landroid/graphics/drawable/Drawable;", "previousBackground", Const.INTENT_KEY_UMID, "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a0 implements y7.s {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final WeakReference<View> viewRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final GradientDrawable drawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Drawable previousBackground;

    public a0(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        this.viewRef = new WeakReference<>(view);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        this.drawable = gradientDrawable;
        this.previousBackground = view.getBackground();
        view.setBackground(gradientDrawable);
    }

    @Override // y7.s
    public void a(y7.F params) {
        View view;
        kotlin.jvm.internal.p.i(params, "params");
        C0746n c0746n = params instanceof C0746n ? (C0746n) params : null;
        if (c0746n == null || (view = this.viewRef.get()) == null) {
            return;
        }
        this.drawable.setCornerRadius(c0746n.getCornerRadius());
        this.drawable.setColor(-434431205);
        this.drawable.setStroke(1, 620756991);
        view.invalidate();
    }

    @Override // y7.s
    public void release() {
        View view = this.viewRef.get();
        if (view != null && view.getBackground() == this.drawable) {
            view.setBackground(this.previousBackground);
        }
    }
}
