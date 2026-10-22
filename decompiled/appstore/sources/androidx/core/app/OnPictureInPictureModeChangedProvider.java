package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public interface OnPictureInPictureModeChangedProvider {
    void addOnPictureInPictureModeChangedListener(@NonNull Consumer<k> r10);

    void removeOnPictureInPictureModeChangedListener(@NonNull Consumer<k> r10);
}
