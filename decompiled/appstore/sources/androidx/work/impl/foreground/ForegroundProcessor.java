package androidx.work.impl.foreground;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.d;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ForegroundProcessor {
    boolean isEnqueuedInForeground(@NonNull String r10);

    void startForeground(@NonNull String r10, @NonNull d r11);

    void stopForeground(@NonNull String r10);
}
