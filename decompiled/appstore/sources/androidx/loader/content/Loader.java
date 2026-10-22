package androidx.loader.content;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Loader {

    public interface OnLoadCanceledListener<D> {
        void onLoadCanceled(@NonNull Loader r10);
    }

    public interface OnLoadCompleteListener<D> {
        void onLoadComplete(@NonNull Loader r10, @Nullable D r11);
    }
}
