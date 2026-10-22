package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(@NonNull MenuProvider r10);

    void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull Lifecycle.State r12);

    void invalidateMenu();

    void removeMenuProvider(@NonNull MenuProvider r10);
}
