package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface MenuProvider {
    void onCreateMenu(@NonNull Menu r10, @NonNull MenuInflater r11);

    default void onMenuClosed(@NonNull Menu r10) {
    }

    boolean onMenuItemSelected(@NonNull MenuItem r10);

    default void onPrepareMenu(@NonNull Menu r10) {
    }
}
