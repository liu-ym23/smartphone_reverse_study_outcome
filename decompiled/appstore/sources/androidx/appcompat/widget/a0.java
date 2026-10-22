package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a0 extends u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f969b;

    public a0(Context r10, Resources r11) {
        super(r11);
        this.f969b = new WeakReference(r10);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int r10) {
        Drawable r11 = a(r10);
        Context r12 = (Context) this.f969b.get();
        if (r11 == null) goto L6;
        if (r12 == null) goto L6;
        ResourceManagerInternal.g().w(r12, r10, r11);
    L6:
        return r11;
    }
}
