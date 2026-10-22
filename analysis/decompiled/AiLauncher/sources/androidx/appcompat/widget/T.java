package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class T extends K {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f9078b;

    public T(Context context, Resources resources) {
        super(resources);
        this.f9078b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable drawableA = a(i10);
        Context context = this.f9078b.get();
        if (drawableA != null && context != null) {
            J.g().w(context, i10, drawableA);
        }
        return drawableA;
    }
}
