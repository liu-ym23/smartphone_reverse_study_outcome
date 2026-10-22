package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

/* JADX INFO: loaded from: classes3.dex */
public interface TintAwareDrawable {
    void setTint(int r100);

    void setTintList(ColorStateList r100);

    void setTintMode(PorterDuff.Mode r100);
}
