package com.stepos.aiengine.algorithm.compsmooth;

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
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J.\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016JR\u0010\u0006\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J6\u0010\u0006\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0010H&¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/algorithm/compsmooth/ICompSmooth;", "", LinkHeader.Rel.PreLoad, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "args", "Landroid/os/Bundle;", "analyzeComposition", "", b.CREDENTIAL_TOKEN, "imageFds", "", "Landroid/os/ParcelFileDescriptor;", "imagePaths", "imageBitmaps", "Landroid/graphics/Bitmap;", "userPrompt", "", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", e.f30860s, "", "getMaxTokenLimit", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICompSmooth {
    int analyzeComposition(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, Bundle args, IBundleCallback callback);

    int analyzeComposition(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, Bundle args, IBundleCallback callback);

    String analyzeComposition(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, Bundle args);

    String analyzeComposition(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, Bundle args);

    boolean cancel(long identity);

    int getMaxTokenLimit();

    AlgorithmToken preload(Bundle args);

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String analyzeComposition(ICompSmooth iCompSmooth, AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, Bundle args) throws ExecutionException, InterruptedException {
            p.i(token, "token");
            p.i(imageFds, "imageFds");
            p.i(imagePaths, "imagePaths");
            p.i(imageBitmaps, "imageBitmaps");
            p.i(userPrompt, "userPrompt");
            p.i(args, "args");
            CompSmoothCallback compSmoothCallback = new CompSmoothCallback() { // from class: com.stepos.aiengine.algorithm.compsmooth.ICompSmooth$analyzeComposition$callback$1
                @Override // com.stepos.aiengine.algorithm.compsmooth.CompSmoothCallback
                public void onNext(String token2) {
                    p.i(token2, "token");
                }
            };
            int iAnalyzeComposition = iCompSmooth.analyzeComposition(token, imageFds, imagePaths, imageBitmaps, userPrompt, args, compSmoothCallback);
            if (iAnalyzeComposition == 0) {
                String str = compSmoothCallback.outputFuture().get();
                p.h(str, "get(...)");
                return str;
            }
            throw new IllegalStateException(("analyzeComposition failed: " + iAnalyzeComposition).toString());
        }

        public static String analyzeComposition(ICompSmooth iCompSmooth, AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, Bundle args) {
            p.i(token, "token");
            p.i(imageFds, "imageFds");
            p.i(userPrompt, "userPrompt");
            p.i(args, "args");
            return iCompSmooth.analyzeComposition(token, imageFds, C1173v.m(), C1173v.m(), userPrompt, args);
        }

        public static int analyzeComposition(ICompSmooth iCompSmooth, AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String userPrompt, Bundle args, IBundleCallback callback) {
            p.i(token, "token");
            p.i(imageFds, "imageFds");
            p.i(userPrompt, "userPrompt");
            p.i(args, "args");
            p.i(callback, "callback");
            return iCompSmooth.analyzeComposition(token, imageFds, C1173v.m(), C1173v.m(), userPrompt, args, callback);
        }
    }
}
