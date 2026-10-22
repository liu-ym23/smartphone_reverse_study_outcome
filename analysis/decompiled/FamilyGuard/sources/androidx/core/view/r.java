package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/* loaded from: classes.dex */
public interface r {
    boolean a(MenuItem menuItem);

    default void b(Menu menu) {
    }

    void c(Menu menu, MenuInflater menuInflater);

    default void d(Menu menu) {
    }
}
