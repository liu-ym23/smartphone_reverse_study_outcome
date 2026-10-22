package androidx.legacy.app;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface ActionBarDrawerToggle$Delegate {
    @Nullable
    Drawable getThemeUpIndicator();

    void setActionBarDescription(@StringRes int r10);

    void setActionBarUpIndicator(Drawable r10, @StringRes int r11);
}
