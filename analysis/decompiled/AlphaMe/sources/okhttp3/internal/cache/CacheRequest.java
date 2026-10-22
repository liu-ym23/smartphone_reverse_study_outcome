package okhttp3.internal.cache;

import java.io.IOException;
import k3.z;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lokhttp3/internal/cache/CacheRequest;", "", "Lk3/z;", "body", "()Lk3/z;", "", "abort", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public interface CacheRequest {
    void abort();

    @NotNull
    z body() throws IOException;
}
