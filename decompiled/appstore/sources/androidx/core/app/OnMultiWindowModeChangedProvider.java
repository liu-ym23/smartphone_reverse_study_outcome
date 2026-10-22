package androidx.core.app;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public interface OnMultiWindowModeChangedProvider {
    void addOnMultiWindowModeChangedListener(@NonNull Consumer<e> r10);

    void removeOnMultiWindowModeChangedListener(@NonNull Consumer<e> r10);
}
