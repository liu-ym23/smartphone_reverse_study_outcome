package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes4.dex */
public abstract class f {
    public static void a(Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(b(drawable));
        }
    }

    public static Rect b(Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
