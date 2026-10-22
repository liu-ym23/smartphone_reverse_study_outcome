package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
class TintResources extends ResourcesWrapper {
    private final WeakReference<Context> mContextRef;

    @Override // androidx.appcompat.widget.ResourcesWrapper, android.content.res.Resources
    public Drawable getDrawable(int r100) throws Resources.NotFoundException {
        Drawable r101 = super.getDrawable(r100);
        Context r102 = this.mContextRef.get();
        if (r101 == null) goto L6;
        if (r102 == null) goto L6;
        ResourceManagerInternal.get().tintDrawableUsingColorFilter(r102, r100, r101);
    L6:
        return r101;
    }

    public TintResources(Context r100, Resources r101) {
        super(r101);
        this.mContextRef = new WeakReference(r100);
    }
}
