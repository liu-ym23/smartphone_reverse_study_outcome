package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* JADX INFO: loaded from: classes17.dex */
public interface ForegroundUpdater {
    ListenableFuture<Void> setForegroundAsync(Context r100, UUID r101, ForegroundInfo r102);
}
