package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    public TintResources(Context r1, Resources r2) {
        super(r2);
        this.mContextRef = new WeakReference(r1);
    }

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int r3) throws Resources.NotFoundException {
        Drawable r0 = getDrawableCanonical(r3);
        Context r2 = this.mContextRef.get();
        if (r0 == null) goto L6;
        if (r2 == null) goto L6;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(r2, r3, r0);
    L6:
        return r0;
    }
}
