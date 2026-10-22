package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
class Z extends Q {

    /* renamed from: b, reason: collision with root package name */
    private final WeakReference<Context> f8466b;

    public Z(Context context, Resources resources) {
        super(resources);
        this.f8466b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i5) {
        Drawable drawableA = a(i5);
        Context context = this.f8466b.get();
        if (drawableA != null && context != null) {
            P.g().w(context, i5, drawableA);
        }
        return drawableA;
    }
}
