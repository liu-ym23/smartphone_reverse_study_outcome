package androidx.asynclayoutinflater.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface AsyncLayoutInflater$OnInflateFinishedListener {
    void onInflateFinished(@NonNull View r10, @LayoutRes int r11, @Nullable ViewGroup r12);
}
