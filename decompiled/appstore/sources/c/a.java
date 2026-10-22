package c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static ColorStateList a(Context r10, int r11) {
        return ContextCompat.c(r10, r11);
    }

    public static Drawable b(Context r10, int r11) {
        return ResourceManagerInternal.g().i(r10, r11);
    }
}
