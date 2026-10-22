package M0;

import C0.r;
import C0.v;
import X0.j;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements v<T>, r {

    /* renamed from: a, reason: collision with root package name */
    protected final T f3994a;

    public b(T t5) {
        this.f3994a = (T) j.d(t5);
    }

    @Override // C0.r
    public void a() {
        T t5 = this.f3994a;
        if (t5 instanceof BitmapDrawable) {
            ((BitmapDrawable) t5).getBitmap().prepareToDraw();
        } else if (t5 instanceof O0.c) {
            ((O0.c) t5).e().prepareToDraw();
        }
    }

    @Override // C0.v
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f3994a.getConstantState();
        return constantState == null ? this.f3994a : (T) constantState.newDrawable();
    }
}
