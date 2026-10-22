package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public interface MenuItemHoverListener {
    void onItemHoverEnter(@NonNull MenuBuilder r10, @NonNull MenuItem r11);

    void onItemHoverExit(@NonNull MenuBuilder r10, @NonNull MenuItem r11);
}
