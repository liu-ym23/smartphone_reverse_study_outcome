package com.stepos.aiengine.algorithm.perception;

import M5.b;
import Z8.C1173v;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\\\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0007H&¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/algorithm/perception/IPerception;", "", LinkHeader.Rel.PreLoad, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "args", "Landroid/os/Bundle;", "summarize", "", b.CREDENTIAL_TOKEN, "imageFds", "", "Landroid/os/ParcelFileDescriptor;", "imagePaths", "", "imageBitmaps", "Landroid/graphics/Bitmap;", "userPrompt", "systemPromptOverride", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", e.f30860s, "", "getMaxTokenLimit", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IPerception {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int summarize(IPerception iPerception, AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, String str, Bundle args, IBundleCallback callback) {
            p.i(token, "token");
            p.i(imageFds, "imageFds");
            p.i(userPrompt, "userPrompt");
            p.i(args, "args");
            p.i(callback, "callback");
            return iPerception.summarize(token, imageFds, C1173v.m(), C1173v.m(), userPrompt, str, args, callback);
        }
    }

    boolean cancel(long identity);

    int getMaxTokenLimit();

    AlgorithmToken preload(Bundle args);

    int summarize(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, String systemPromptOverride, Bundle args, IBundleCallback callback);

    int summarize(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, String systemPromptOverride, Bundle args, IBundleCallback callback);
}
