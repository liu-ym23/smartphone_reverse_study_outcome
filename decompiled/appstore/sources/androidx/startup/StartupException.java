package androidx.startup;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class StartupException extends RuntimeException {
    public StartupException(@NonNull String r10) {
        super(r10);
    }

    public StartupException(@NonNull Throwable r10) {
        super(r10);
    }

    public StartupException(@NonNull String r10, @NonNull Throwable r11) {
        super(r10, r11);
    }
}
