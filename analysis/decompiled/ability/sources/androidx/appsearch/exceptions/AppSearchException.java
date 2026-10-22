package androidx.appsearch.exceptions;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appsearch.app.AppSearchResult;

/* loaded from: classes.dex */
public class AppSearchException extends Exception {
    private final int mResultCode;

    public AppSearchException(int i) {
        this(i, null);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    @NonNull
    public <T> AppSearchResult<T> toAppSearchResult() {
        return AppSearchResult.newFailedResult(this.mResultCode, getMessage());
    }

    public AppSearchException(int i, @Nullable String str) {
        this(i, str, null);
    }

    public AppSearchException(int i, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        this.mResultCode = i;
    }
}
