package com.obric.matrix.platform.sdk.ones.picolinks;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/matrix/platform/sdk/ones/picolinks/PicoLinksHook$Callback", "", "", "url", "", "onRedirect", "(Ljava/lang/String;)V", "", "data", "onResult", "(Ljava/util/Map;)V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PicoLinksHook$Callback {
    void onRedirect(@NotNull String r10);

    void onResult(@NotNull Map<String, String> r10);
}
