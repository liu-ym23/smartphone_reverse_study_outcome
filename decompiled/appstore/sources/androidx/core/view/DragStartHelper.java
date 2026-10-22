package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class DragStartHelper {

    public interface OnDragStartListener {
        boolean onDragStart(@NonNull View r10, @NonNull DragStartHelper r11);
    }
}
